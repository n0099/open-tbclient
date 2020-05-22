package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String appId;
    public long aur;
    public long aus;
    public int aut;
    public boolean auu;
    public boolean auv;
    public int auw;
    public List<AlaLiveMarkData> aux;
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
            this.level_id = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
            this.sex = jSONObject.optInt("sex");
            this.aur = jSONObject.optLong("fan_num");
            this.aus = jSONObject.optLong("concern_num");
            this.aut = jSONObject.optInt("have_concern");
            this.auu = jSONObject.optBoolean("isOfficial");
            this.auv = jSONObject.optBoolean("isLiveAdmin");
            this.appId = jSONObject.optString("app_id");
            this.tagName = jSONObject.optString("tag_name");
            this.auw = jSONObject.optInt("tag_type");
            this.appId = jSONObject.optString("app_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aux = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                    alaLiveMarkData.parserJson(optJSONObject);
                    this.aux.add(alaLiveMarkData);
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
            jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, this.level_id);
            jSONObject.put("sex", this.sex);
            jSONObject.put("fan_num", this.aur);
            jSONObject.put("concern_num", this.aus);
            jSONObject.put("have_concern", this.aut);
            jSONObject.put("isOfficial", this.auu);
            jSONObject.put("isLiveAdmin", this.auv);
            jSONObject.put("app_id", this.appId);
            jSONObject.put("tag_name", this.tagName);
            jSONObject.put("tag_type", this.auw);
            JSONArray jSONArray = new JSONArray();
            if (this.aux != null) {
                for (AlaLiveMarkData alaLiveMarkData : this.aux) {
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
