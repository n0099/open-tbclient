package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes9.dex */
public class a {
    private String agreeText;
    private boolean dUM;
    private String dUN;
    private String dUO;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aPQ() {
        return this.loginMode;
    }

    public void kC(int i) {
        this.loginMode = i;
    }

    public boolean aPR() {
        return this.dUM;
    }

    public void hN(boolean z) {
        this.dUM = z;
    }

    public String aPS() {
        return this.encryptPhoneNum;
    }

    public void uG(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aPT() {
        return this.hasHistory;
    }

    public void hO(boolean z) {
        this.hasHistory = z;
    }

    public void uH(String str) {
        this.dUN = str;
    }

    public String aPU() {
        String str = this.dUN;
        char c = 65535;
        switch (str.hashCode()) {
            case 2154:
                if (str.equals("CM")) {
                    c = 2;
                    break;
                }
                break;
            case 2161:
                if (str.equals("CT")) {
                    c = 0;
                    break;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.dUO = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dUO = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dUO = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dUO;
    }

    public String aPV() {
        String str = this.dUN;
        char c = 65535;
        switch (str.hashCode()) {
            case 2154:
                if (str.equals("CM")) {
                    c = 2;
                    break;
                }
                break;
            case 2161:
                if (str.equals("CT")) {
                    c = 0;
                    break;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.agreeText = AppRuntime.getAppContext().getString(b.g.account_onekey_login_dx_agree_text);
                break;
            case 1:
                this.agreeText = AppRuntime.getAppContext().getString(b.g.account_onekey_login_lt_agree_text);
                break;
            case 2:
                this.agreeText = AppRuntime.getAppContext().getString(b.g.account_onekey_login_yd_agree_text);
                break;
            default:
                this.agreeText = "";
                break;
        }
        return this.agreeText;
    }
}
