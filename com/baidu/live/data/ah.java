package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ah {
    public long TY;
    public int TZ;
    public int Ua;
    public long Ub;
    public long Uc;
    public int Ud;
    public int Ue;
    public int Uf;
    public ag Ug;
    public String Uh;
    public String call_type;
    public String extData;
    public String imei;
    public String itemInfo;
    public String mobile;
    public String notifyUrl;
    public String orderId;
    public String passuid;
    public String pay_channel;
    public String pay_url;
    public String service;
    public String sign;
    public String tag;
    public String title;
    public String tn;
    public String url;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.TY = jSONObject.optInt("customerId");
            this.service = jSONObject.optString("service");
            this.orderId = jSONObject.optString("orderId");
            this.TZ = jSONObject.optInt("orderCreateTime");
            this.Ua = jSONObject.optInt("deviceType");
            this.Ub = jSONObject.optLong("payAmount");
            this.Uc = jSONObject.optLong("originalAmount");
            this.notifyUrl = jSONObject.optString("notifyUrl");
            this.passuid = jSONObject.optString("passuid");
            this.title = jSONObject.optString("title");
            this.tn = jSONObject.optString("tn");
            this.url = jSONObject.optString("url");
            this.mobile = jSONObject.optString("mobile");
            this.itemInfo = jSONObject.optString("itemInfo");
            this.imei = jSONObject.optString("imei");
            this.Ud = jSONObject.optInt("sdk");
            this.Ue = jSONObject.optInt("sdkStyle");
            this.extData = jSONObject.optString("extData");
            this.Uf = jSONObject.optInt("signType");
            this.tag = jSONObject.optString("tag");
            this.sign = jSONObject.optString("sign");
            JSONObject optJSONObject = jSONObject.optJSONObject("popup");
            if (optJSONObject != null) {
                this.Ug = new ag();
                this.Ug.parserJson(optJSONObject);
            }
            this.pay_url = jSONObject.optString("pay_url");
            this.call_type = jSONObject.optString("call_type");
            this.pay_channel = jSONObject.optString("pay_channel");
            this.Uh = jSONObject.optString("real_channel");
        }
    }
}
