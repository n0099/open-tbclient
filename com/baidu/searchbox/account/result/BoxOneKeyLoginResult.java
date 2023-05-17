package com.baidu.searchbox.account.result;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BoxOneKeyLoginResult extends LoginResult {
    @SuppressLint({"BDOfflineUrl"})
    public static final String BAIDU_PRIVACY = "https://wappass.baidu.com/passport/agreement?personal=1";
    @SuppressLint({"BDOfflineUrl"})
    public static final String BAIDU_PRIVACY_POLICY = "https://s.bdstatic.com/common/agreement/privacy.html";
    @SuppressLint({"BDOfflineUrl"})
    public static final String MOBILE_AGREE_URL = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String OPERATOR_TYPE_DX = "CT";
    public static final String OPERATOR_TYPE_LT = "CU";
    public static final String OPERATOR_TYPE_YD = "CM";
    @SuppressLint({"BDOfflineUrl"})
    public static final String PASS_ACCOUNT_AGREE = "https://wappass.baidu.com/passport/agreement";
    @SuppressLint({"BDOfflineUrl"})
    public static final String TELECOM_AGREE_URL = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
    @SuppressLint({"BDOfflineUrl"})
    public static final String UNICOM_AGREE_URL = "https://ms.zzx9.cn/html/oauth/protocol2.html";
    public boolean hasHistory;
    public int loginMode;
    public String encryptPhoneNum = "";
    public String operatorType = "";
    public String agreeUrl = "";
    public String agreeText = "";

    public String getEncryptPhoneNum() {
        return this.encryptPhoneNum;
    }

    public boolean getHasHistory() {
        return this.hasHistory;
    }

    public int getLoginMode() {
        return this.loginMode;
    }

    public String getOperatorType() {
        return this.operatorType;
    }

    public boolean isOnekeyEnable() {
        return isEnable();
    }

    public String getAgreeText() {
        char c;
        String str = this.operatorType;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals("CU")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("CT")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals("CM")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    this.agreeText = "";
                } else {
                    this.agreeText = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f00a0);
                }
            } else {
                this.agreeText = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f009e);
            }
        } else {
            this.agreeText = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f009c);
        }
        return this.agreeText;
    }

    public String getOperatorServiceText() {
        if (TextUtils.isEmpty(this.operatorType)) {
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f00a2);
        }
        String string = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f00a2);
        String str = this.operatorType;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals("CU")) {
                    c = 1;
                }
            } else if (str.equals("CT")) {
                c = 0;
            }
        } else if (str.equals("CM")) {
            c = 2;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f00a1);
                }
                return string;
            }
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f009f);
        }
        return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f009d);
    }

    public String getAgreeUrl() {
        char c;
        String str = this.operatorType;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals("CU")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("CT")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals("CM")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    this.agreeUrl = "https://wap.cmpassport.com/resources/html/contract.html";
                }
            } else {
                this.agreeUrl = "https://ms.zzx9.cn/html/oauth/protocol2.html";
            }
        } else {
            this.agreeUrl = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        }
        return this.agreeUrl;
    }

    public String getUbcAgreementValue() {
        char c;
        String str = this.operatorType;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals("CU")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("CT")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals("CM")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return "";
                }
                return "quicklogin_yd_agreement";
            }
            return "quicklogin_lt_agreement";
        }
        return "quicklogin_dx_agreement";
    }

    public String getUbcValue() {
        char c;
        String str = this.operatorType;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals("CU")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("CT")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals("CM")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return "";
                }
                return "quicklogin_yd";
            }
            return "quicklogin_lt";
        }
        return "quicklogin_dx";
    }

    public void setEncryptPhoneNum(String str) {
        this.encryptPhoneNum = str;
    }

    public void setHasHistory(boolean z) {
        this.hasHistory = z;
    }

    public void setLoginMode(int i) {
        this.loginMode = i;
    }

    public void setOperatorType(String str) {
        this.operatorType = str;
    }
}
