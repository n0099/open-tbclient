package com.baidu.live.data;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bs {
    public long aRA;
    public int aRB;
    public int aRC;
    public int aRD;
    public br aRE;
    public String aRF;
    public long aRw;
    public int aRx;
    public int aRy;
    public long aRz;
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
            this.aRw = jSONObject.optInt(CashierData.CUSTOMER_ID);
            this.service = jSONObject.optString("service");
            this.orderId = jSONObject.optString(CashierData.ORDERID);
            this.aRx = jSONObject.optInt(CashierData.ORDER_CREATE_TIME);
            this.aRy = jSONObject.optInt(CashierData.DEVICE_TYPE);
            this.aRz = jSONObject.optLong(CashierData.PAY_AMOUNT);
            this.aRA = jSONObject.optLong(CashierData.ORIGINALAMOUNT_AMOUNT);
            this.notifyUrl = jSONObject.optString(CashierData.NOTIFY_URL);
            this.passuid = jSONObject.optString(CashierData.PASS_UID);
            this.title = jSONObject.optString("title");
            this.tn = jSONObject.optString(CashierData.TN);
            this.url = jSONObject.optString("url");
            this.mobile = jSONObject.optString("mobile");
            this.itemInfo = jSONObject.optString(CashierData.ITEM_INFO);
            this.imei = jSONObject.optString("imei");
            this.aRB = jSONObject.optInt(CashierData.SDK);
            this.aRC = jSONObject.optInt(CashierData.SDK_STYLE);
            this.extData = jSONObject.optString(CashierData.EXT_DATA);
            this.aRD = jSONObject.optInt(CashierData.SIGN_TYPE);
            this.tag = jSONObject.optString("tag");
            this.sign = jSONObject.optString("sign");
            JSONObject optJSONObject = jSONObject.optJSONObject("popup");
            if (optJSONObject != null) {
                this.aRE = new br();
                this.aRE.parserJson(optJSONObject);
            }
            this.pay_url = jSONObject.optString("pay_url");
            this.call_type = jSONObject.optString("call_type");
            this.pay_channel = jSONObject.optString("pay_channel");
            this.aRF = jSONObject.optString("real_channel");
        }
    }
}
