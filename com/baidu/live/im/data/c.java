package com.baidu.live.im.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends BaseData {
    public long aXc;
    public long aYn;
    public String aYq;
    public String beG;
    public String beJ;
    public boolean bes;
    public JSONObject beu;
    public String bpF;
    public String bqM;
    public long bqN;
    public String bqO;
    public boolean bqP;
    public boolean bqQ;
    public boolean bqR;
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
            this.beu = jSONObject;
            this.contentType = jSONObject.optString("content_type");
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aYn = jSONObject.optLong("gift_count");
            this.giftName = jSONObject.optString("gift_name");
            this.aYq = jSONObject.optString("gift_url");
            this.beJ = jSONObject.optString("attach");
            this.bes = jSONObject.optInt("is_pk_gift") == 1;
            this.aXc = jSONObject.optLong("charm_value");
            this.bqN = jSONObject.optLong("charm_total");
            this.bqM = jSONObject.optString("attach_new");
            this.bqO = jSONObject.optString("gift_mul");
            this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
            this.bqQ = jSONObject.optInt("show_own") == 1;
            this.bqP = jSONObject.optInt("from_gongyanfang_page") == 1;
            this.bqR = jSONObject.optInt("from_gongyanfang_2") == 1;
            this.beG = jSONObject.optString("gift_source_text");
            this.bpF = jSONObject.optString("gift_source");
        }
    }
}
