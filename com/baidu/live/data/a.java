package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public long aHt;
    public long aHu;
    public int aHv;
    public boolean aHw;
    public boolean aHx;
    public int aHy;
    public List<AlaLiveMarkData> aHz;
    public String appId;
    public JSONObject extInfoJson;
    public JSONObject extraUserInfo;
    public int level_id;
    public String name_show;
    public String portrait;
    public int sex;
    public String tagName;
    public String userId;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            this.userId = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID);
            this.name_show = jSONObject.optString("name_show");
            if (TextUtils.isEmpty(this.name_show)) {
                this.name_show = jSONObject.optString("nickName");
            }
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.level_id = jSONObject.optInt("level");
            this.sex = jSONObject.optInt("sex");
            this.aHt = jSONObject.optLong("fan_num");
            this.aHu = jSONObject.optLong("concern_num");
            this.aHv = jSONObject.optInt("have_concern");
            this.aHw = jSONObject.optBoolean("isOfficial");
            this.aHx = jSONObject.optBoolean("isLiveAdmin");
            this.appId = jSONObject.optString("app_id");
            this.tagName = jSONObject.optString("tag_name");
            this.aHy = jSONObject.optInt("tag_type");
            this.appId = jSONObject.optString("app_id");
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aHz = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                    alaLiveMarkData.userLevel = this.level_id;
                    alaLiveMarkData.parserJson(optJSONObject);
                    this.aHz.add(alaLiveMarkData);
                }
            }
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                this.extraUserInfo = jSONObject.optJSONObject(TbConfig.getSubappType() + "_info");
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, this.userName);
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.userId);
            jSONObject.put("name_show", this.name_show);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("level", this.level_id);
            jSONObject.put("sex", this.sex);
            jSONObject.put("fan_num", this.aHt);
            jSONObject.put("concern_num", this.aHu);
            jSONObject.put("have_concern", this.aHv);
            jSONObject.put("isOfficial", this.aHw);
            jSONObject.put("isLiveAdmin", this.aHx);
            jSONObject.put("app_id", this.appId);
            jSONObject.put("tag_name", this.tagName);
            jSONObject.put("tag_type", this.aHy);
            if (this.extInfoJson != null) {
                jSONObject.put("ext_info", this.extInfoJson);
            }
            JSONArray jSONArray = new JSONArray();
            if (this.aHz != null) {
                for (AlaLiveMarkData alaLiveMarkData : this.aHz) {
                    jSONArray.put(alaLiveMarkData.toJsonObject());
                }
            }
            jSONObject.put("live_mark_info_new", jSONArray);
            if (this.extraUserInfo != null) {
                jSONObject.put(TbConfig.getSubappType() + "_info", this.extraUserInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.name_show) ? this.userName : this.name_show;
    }
}
