package com.baidu.live.im.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BaseData {
    public long aWP;
    public String aWS;
    public boolean bcS;
    public JSONObject bcT;
    public String bdf;
    public String bnR;
    public String boV;
    public String boW;
    public long boX;
    public String boY;
    public boolean boZ;
    public boolean bpa;
    public boolean bpb;
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
            this.bcT = jSONObject;
            this.contentType = jSONObject.optString("content_type");
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aWP = jSONObject.optLong("gift_count");
            this.giftName = jSONObject.optString("gift_name");
            this.aWS = jSONObject.optString("gift_url");
            this.boV = jSONObject.optString("attach");
            this.bcS = jSONObject.optInt("is_pk_gift") == 1;
            this.boX = jSONObject.optLong("charm_total");
            this.boW = jSONObject.optString("attach_new");
            this.boY = jSONObject.optString("gift_mul");
            this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
            this.bpa = jSONObject.optInt("show_own") == 1;
            this.boZ = jSONObject.optInt("from_gongyanfang_page") == 1;
            this.bpb = jSONObject.optInt("from_gongyanfang_2") == 1;
            this.bdf = jSONObject.optString("gift_source_text");
            this.bnR = jSONObject.optString("gift_source");
        }
    }
}
