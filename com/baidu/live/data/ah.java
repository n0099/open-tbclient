package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ah {
    public String UB;
    public long Ur;
    public int Us;
    public int Ut;
    public long Uu;
    public long Uv;
    public int Uw;
    public int Ux;
    public int Uy;
    public ag Uz;
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
            this.Ur = jSONObject.optInt("customerId");
            this.service = jSONObject.optString("service");
            this.orderId = jSONObject.optString("orderId");
            this.Us = jSONObject.optInt("orderCreateTime");
            this.Ut = jSONObject.optInt("deviceType");
            this.Uu = jSONObject.optLong("payAmount");
            this.Uv = jSONObject.optLong("originalAmount");
            this.notifyUrl = jSONObject.optString("notifyUrl");
            this.passuid = jSONObject.optString("passuid");
            this.title = jSONObject.optString("title");
            this.tn = jSONObject.optString("tn");
            this.url = jSONObject.optString("url");
            this.mobile = jSONObject.optString("mobile");
            this.itemInfo = jSONObject.optString("itemInfo");
            this.imei = jSONObject.optString("imei");
            this.Uw = jSONObject.optInt("sdk");
            this.Ux = jSONObject.optInt("sdkStyle");
            this.extData = jSONObject.optString("extData");
            this.Uy = jSONObject.optInt("signType");
            this.tag = jSONObject.optString("tag");
            this.sign = jSONObject.optString("sign");
            JSONObject optJSONObject = jSONObject.optJSONObject("popup");
            if (optJSONObject != null) {
                this.Uz = new ag();
                this.Uz.parserJson(optJSONObject);
            }
            this.pay_url = jSONObject.optString("pay_url");
            this.call_type = jSONObject.optString("call_type");
            this.pay_channel = jSONObject.optString("pay_channel");
            this.UB = jSONObject.optString("real_channel");
        }
    }
}
