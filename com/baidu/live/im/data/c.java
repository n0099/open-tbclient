package com.baidu.live.im.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BaseData {
    public long aYv;
    public String aYy;
    public boolean beA;
    public JSONObject beB;
    public String beN;
    public String beQ;
    public String bpz;
    public String bqE;
    public long bqF;
    public String bqG;
    public boolean bqH;
    public boolean bqI;
    public boolean bqJ;
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
            this.beB = jSONObject;
            this.contentType = jSONObject.optString("content_type");
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aYv = jSONObject.optLong("gift_count");
            this.giftName = jSONObject.optString("gift_name");
            this.aYy = jSONObject.optString("gift_url");
            this.beQ = jSONObject.optString("attach");
            this.beA = jSONObject.optInt("is_pk_gift") == 1;
            this.bqF = jSONObject.optLong("charm_total");
            this.bqE = jSONObject.optString("attach_new");
            this.bqG = jSONObject.optString("gift_mul");
            this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
            this.bqI = jSONObject.optInt("show_own") == 1;
            this.bqH = jSONObject.optInt("from_gongyanfang_page") == 1;
            this.bqJ = jSONObject.optInt("from_gongyanfang_2") == 1;
            this.beN = jSONObject.optString("gift_source_text");
            this.bpz = jSONObject.optString("gift_source");
        }
    }
}
