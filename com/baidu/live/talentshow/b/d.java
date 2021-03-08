package com.baidu.live.talentshow.b;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends BaseData {
    public String appid;
    public String bGL;
    public String bGM;
    public String cuid;
    public int itemPosition = -1;
    public String nickName;
    public String portrait;
    public int status;
    public String uid;
    public String uk;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.uk = jSONObject.optString("uk");
            this.uid = jSONObject.optString("user_id");
            this.nickName = jSONObject.optString("nickname");
            this.portrait = jSONObject.optString("portrait");
            this.status = jSONObject.optInt("status");
            this.appid = jSONObject.optString("appid");
            this.cuid = jSONObject.optString("cuid");
            this.bGL = jSONObject.optString("im_uk");
            this.bGM = jSONObject.optString(HttpRequest.SUBAPP_VERSION);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: SK */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
