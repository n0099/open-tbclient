package com.baidu.poly.bean;

import com.baidu.fsg.face.base.b.c;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PayChannel implements Serializable {
    public static final String ALIPAY = "BAIDU-ALIPAY-WISE";
    public static final String BAIFUBAO = "BAIDU-BAIFUBAO-WISE";
    public static final String BANKCARD = "BAIDU-BANK-CARD-PAY";
    public static final String WECHAT = "BAIDU-SUPER-WECHAT-WISE";
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
        this.icon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
        this.isFold = jSONObject.optInt("is_fold", 0) == 1;
        this.isSelected = jSONObject.optInt("is_selected", 0) == 1;
        this.freePay = jSONObject.optInt("free_pay");
        this.enable = jSONObject.optInt(c.l, 1) == 1;
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
}
