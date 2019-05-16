package com.baidu.poly.bean;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PayChannel implements Serializable {
    public static final String ACTION_TYPE_H5 = "h5";
    public static final String ACTION_TYPE_SDK = "sdk";
    public static final String ALIPAY = "BAIDU-ALIPAY-WISE";
    public static final String BAIFUBAO = "BAIDU-BAIFUBAO-WISE";
    public static final String BANKCARD = "BAIDU-BANK-CARD-PAY";
    public static final String WECHAT = "BAIDU-SUPER-WECHAT-WISE";
    private String actionType;
    private String displayName;
    private boolean enable;
    private String errorText;
    private int freePay;
    private String icon;
    private boolean isFold;
    private boolean isSelected;
    private String payChannel;
    private String payText;

    public PayChannel(JSONObject jSONObject) {
        this.displayName = jSONObject.optString("display_name");
        this.payChannel = jSONObject.optString("pay_channel");
        this.payText = jSONObject.optString("pay_text");
        this.errorText = jSONObject.optString("error_text");
        this.icon = jSONObject.optString("icon");
        this.isFold = jSONObject.optInt("is_fold", 0) == 1;
        this.isSelected = jSONObject.optInt("is_selected", 0) == 1;
        this.freePay = jSONObject.optInt("free_pay");
        this.enable = jSONObject.optInt("enable", 1) == 1;
        this.actionType = jSONObject.optString("action_type", ACTION_TYPE_SDK);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPayChannel() {
        return this.payChannel;
    }

    public String getPayText() {
        return this.payText;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean isFold() {
        return this.isFold;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getFreePay() {
        return this.freePay;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public String getActionType() {
        return this.actionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"displayName\":\"").append(this.displayName).append('\"');
        sb.append(",\"payChannel\":\"").append(this.payChannel).append('\"');
        sb.append(",\"payText\":\"").append(this.payText).append('\"');
        sb.append(",\"errorText\":\"").append(this.errorText).append('\"');
        sb.append(",\"icon\":\"").append(this.icon).append('\"');
        sb.append(",\"isFold\":").append(this.isFold);
        sb.append(",\"isSelected\":").append(this.isSelected);
        sb.append(",\"freePay\":").append(this.freePay);
        sb.append(",\"enable\":").append(this.enable);
        sb.append(",\"actionType\":\"").append(this.actionType).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
