package com.baidu.live.im.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends BaseData {
    public long aTI;
    public String aTL;
    public boolean aZK;
    public JSONObject aZL;
    public String aZX;
    public String baa;
    public String bkM;
    public String blR;
    public long blS;
    public String blT;
    public boolean blU;
    public boolean blV;
    public boolean blW;
    public String contentType;
    public String giftId;
    public String giftName;
    public boolean isDynamic;

    public c() {
    }

    public c(JSONObject jSONObject) {
        parserJson(jSONObject);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aZL = jSONObject;
            this.contentType = jSONObject.optString("content_type");
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aTI = jSONObject.optLong("gift_count");
            this.giftName = jSONObject.optString("gift_name");
            this.aTL = jSONObject.optString("gift_url");
            this.baa = jSONObject.optString("attach");
            this.aZK = jSONObject.optInt("is_pk_gift") == 1;
            this.blS = jSONObject.optLong("charm_total");
            this.blR = jSONObject.optString("attach_new");
            this.blT = jSONObject.optString("gift_mul");
            this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
            this.blV = jSONObject.optInt("show_own") == 1;
            this.blU = jSONObject.optInt("from_gongyanfang_page") == 1;
            this.blW = jSONObject.optInt("from_gongyanfang_2") == 1;
            this.aZX = jSONObject.optString("gift_source_text");
            this.bkM = jSONObject.optString("gift_source");
        }
    }
}
