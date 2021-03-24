package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ForumRuleBaseData implements Serializable {
    public List<ForumRuleItemData> list;
    public List<ForumRuleItemPbData> pbDataList;
    public String preface;
    public String title;

    /* loaded from: classes3.dex */
    public static class ForumRuleItemData implements Serializable {
        public String content;
        public String status;
        public String title;

        public String getContent() {
            return this.content;
        }

        public String getStatus() {
            return this.status;
        }

        public String getTitle() {
            return this.title;
        }

        public JSONObject makeJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ForumRuleItemPbContentData implements Serializable {
        public String href;
        public String tag;
        public String target;
        public String value;
    }

    /* loaded from: classes3.dex */
    public static class ForumRuleItemPbData implements Serializable {
        public List<ForumRuleItemPbContentData> mContent;
        public String status;
        public String title;
    }

    public List<ForumRuleItemData> getList() {
        return this.list;
    }

    public List<ForumRuleItemPbData> getPbDataList() {
        return this.pbDataList;
    }

    public String getPreface() {
        return this.preface;
    }

    public String getTitle() {
        return this.title;
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

    public void setList(List<ForumRuleItemData> list) {
        this.list = list;
    }

    public void setPbDataList(List<ForumRuleItemPbData> list) {
        this.pbDataList = list;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
