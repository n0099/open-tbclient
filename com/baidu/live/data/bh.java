package com.baidu.live.data;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bh {
    public long aJX;
    public int aJY;
    public int aJZ;
    public long aKa;
    public long aKb;
    public int aKc;
    public int aKd;
    public bg aKe;
    public String aKf;
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
    public int signType;
    public String tag;
    public String title;
    public String tn;
    public String url;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJX = jSONObject.optInt(CashierData.CUSTOMER_ID);
            this.service = jSONObject.optString("service");
            this.orderId = jSONObject.optString(CashierData.ORDERID);
            this.aJY = jSONObject.optInt(CashierData.ORDER_CREATE_TIME);
            this.aJZ = jSONObject.optInt(CashierData.DEVICE_TYPE);
            this.aKa = jSONObject.optLong(CashierData.PAY_AMOUNT);
            this.aKb = jSONObject.optLong(CashierData.ORIGINALAMOUNT_AMOUNT);
            this.notifyUrl = jSONObject.optString(CashierData.NOTIFY_URL);
            this.passuid = jSONObject.optString(CashierData.PASS_UID);
            this.title = jSONObject.optString("title");
            this.tn = jSONObject.optString(CashierData.TN);
            this.url = jSONObject.optString("url");
            this.mobile = jSONObject.optString("mobile");
            this.itemInfo = jSONObject.optString(CashierData.ITEM_INFO);
            this.imei = jSONObject.optString("imei");
            this.aKc = jSONObject.optInt(CashierData.SDK);
            this.aKd = jSONObject.optInt(CashierData.SDK_STYLE);
            this.extData = jSONObject.optString(CashierData.EXT_DATA);
            this.signType = jSONObject.optInt(CashierData.SIGN_TYPE);
            this.tag = jSONObject.optString("tag");
            this.sign = jSONObject.optString("sign");
            JSONObject optJSONObject = jSONObject.optJSONObject(MapController.POPUP_LAYER_TAG);
            if (optJSONObject != null) {
                this.aKe = new bg();
                this.aKe.parserJson(optJSONObject);
            }
            this.pay_url = jSONObject.optString("pay_url");
            this.call_type = jSONObject.optString("call_type");
            this.pay_channel = jSONObject.optString("pay_channel");
            this.aKf = jSONObject.optString("real_channel");
        }
    }
}
