package com.baidu.android.lbspay.channelpay;

import android.text.TextUtils;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PayDataBean implements Serializable {
    public static final long serialVersionUID = 1;
    public String appid;
    public String appurl;
    public String auth_appurl;
    public String channel_code;
    public String new_baifubao_auth_pay;
    public String noncestr;
    public String packagealias;
    public String params;
    public String partnerid;
    public int paytype;
    public String payurl;
    public String prepayid;
    public String sign;
    public String timestamp;
    public String tn;
    public String transid;
    public String url;

    public boolean isAliAuthPay() {
        return "ALIPAY-WISE-AUTH-SIGN".equals(this.channel_code) && !TextUtils.isEmpty(this.auth_appurl);
    }

    public boolean isBaifubaoAuthPay() {
        return "BAIFUBAO-WISE-AUTH-SIGN".equals(this.channel_code) && TextUtils.equals("1", this.new_baifubao_auth_pay);
    }
}
