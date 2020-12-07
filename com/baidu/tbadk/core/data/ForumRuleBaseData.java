package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ForumRuleBaseData implements Serializable {
    private List<ForumRuleItemData> list;
    private List<ForumRuleItemPbData> pbDataList;
    private String preface;
    private String title;

    /* loaded from: classes.dex */
    public static class ForumRuleItemPbContentData implements Serializable {
        public String href;
        public String tag;
        public String target;
        public String value;
    }

    /* loaded from: classes.dex */
    public static class ForumRuleItemPbData implements Serializable {
        public List<ForumRuleItemPbContentData> mContent;
        public String status;
        public String title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPreface() {
        return this.preface;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public List<ForumRuleItemData> getList() {
        return this.list;
    }

    public void setList(List<ForumRuleItemData> list) {
        this.list = list;
    }

    public List<ForumRuleItemPbData> getPbDataList() {
        return this.pbDataList;
    }

    public void setPbDataList(List<ForumRuleItemPbData> list) {
        this.pbDataList = list;
    }

    /* loaded from: classes.dex */
    public static class ForumRuleItemData implements Serializable {
        private String content;
        private String status;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public JSONObject makeJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void parserData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.preface = jSONObject.optString("preface");
            JSONArray optJSONArray = jSONObject.optJSONArray("rules");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        ForumRuleItemPbData forumRuleItemPbData = new ForumRuleItemPbData();
                        forumRuleItemPbData.title = optJSONObject.optString("title");
                        forumRuleItemPbData.status = optJSONObject.optString("status");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("content");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleItemPbContentData();
                                    forumRuleItemPbContentData.tag = optJSONObject2.optString("tag");
                                    forumRuleItemPbContentData.href = optJSONObject2.optString("href");
                                    forumRuleItemPbContentData.target = optJSONObject2.optString("target");
                                    if ("a".equals(forumRuleItemPbContentData.tag)) {
                                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("value");
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            forumRuleItemPbContentData.value = optJSONArray3.optJSONObject(0).optString("value");
                                        }
                                    } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                        forumRuleItemPbContentData.value = optJSONObject2.optString("value");
                                    }
                                    arrayList2.add(forumRuleItemPbContentData);
                                }
                            }
                        }
                        forumRuleItemPbData.mContent = arrayList2;
                        arrayList.add(forumRuleItemPbData);
                    }
                }
            }
            this.pbDataList = arrayList;
        }
    }
}
