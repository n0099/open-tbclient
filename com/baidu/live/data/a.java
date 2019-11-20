package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public long Oj;
    public long Ok;
    public int Ol;
    public boolean Om;
    public boolean On;
    public int Oo;
    public List<AlaLiveMarkData> Op;
    public String appId;
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
            this.Oj = jSONObject.optLong("fan_num");
            this.Ok = jSONObject.optLong("concern_num");
            this.Ol = jSONObject.optInt("have_concern");
            this.Om = jSONObject.optBoolean("isOfficial");
            this.On = jSONObject.optBoolean("isLiveAdmin");
            this.appId = jSONObject.optString(Constants.APP_ID);
            this.tagName = jSONObject.optString("tag_name");
            this.Oo = jSONObject.optInt("tag_type");
            this.appId = jSONObject.optString(Constants.APP_ID);
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.Op = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                    alaLiveMarkData.parserJson(optJSONObject);
                    this.Op.add(alaLiveMarkData);
                }
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
            jSONObject.put("fan_num", this.Oj);
            jSONObject.put("concern_num", this.Ok);
            jSONObject.put("have_concern", this.Ol);
            jSONObject.put("isOfficial", this.Om);
            jSONObject.put("isLiveAdmin", this.On);
            jSONObject.put(Constants.APP_ID, this.appId);
            jSONObject.put("tag_name", this.tagName);
            jSONObject.put("tag_type", this.Oo);
            JSONArray jSONArray = new JSONArray();
            if (this.Op != null) {
                for (AlaLiveMarkData alaLiveMarkData : this.Op) {
                    jSONArray.put(alaLiveMarkData.toJsonObject());
                }
            }
            jSONObject.put("live_mark_info_new", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.name_show) ? this.userName : this.name_show;
    }
}
