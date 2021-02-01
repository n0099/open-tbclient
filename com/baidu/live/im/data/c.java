package com.baidu.live.im.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BaseData {
    public long aVC;
    public long aWN;
    public String aWQ;
    public boolean bcR;
    public JSONObject bcS;
    public String bde;
    public String bdh;
    public String bof;
    public String bpm;
    public long bpn;
    public String bpo;
    public boolean bpp;
    public boolean bpq;
    public boolean bpr;
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
            this.bcS = jSONObject;
            this.contentType = jSONObject.optString("content_type");
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aWN = jSONObject.optLong("gift_count");
            this.giftName = jSONObject.optString("gift_name");
            this.aWQ = jSONObject.optString("gift_url");
            this.bdh = jSONObject.optString("attach");
            this.bcR = jSONObject.optInt("is_pk_gift") == 1;
            this.aVC = jSONObject.optLong("charm_value");
            this.bpn = jSONObject.optLong("charm_total");
            this.bpm = jSONObject.optString("attach_new");
            this.bpo = jSONObject.optString("gift_mul");
            this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
            this.bpq = jSONObject.optInt("show_own") == 1;
            this.bpp = jSONObject.optInt("from_gongyanfang_page") == 1;
            this.bpr = jSONObject.optInt("from_gongyanfang_2") == 1;
            this.bde = jSONObject.optString("gift_source_text");
            this.bof = jSONObject.optString("gift_source");
        }
    }
}
