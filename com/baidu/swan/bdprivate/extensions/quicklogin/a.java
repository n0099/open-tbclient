package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes8.dex */
public class a {
    private String agreeText;
    private boolean dWn;
    private String dWo;
    private String dWp;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aPT() {
        return this.loginMode;
    }

    public void kD(int i) {
        this.loginMode = i;
    }

    public boolean aPU() {
        return this.dWn;
    }

    public void hN(boolean z) {
        this.dWn = z;
    }

    public String aPV() {
        return this.encryptPhoneNum;
    }

    public void uN(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aPW() {
        return this.hasHistory;
    }

    public void hO(boolean z) {
        this.hasHistory = z;
    }

    public void uO(String str) {
        this.dWo = str;
    }

    public String aPX() {
        String str = this.dWo;
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
                this.dWp = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dWp = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dWp = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dWp;
    }

    public String aPY() {
        String str = this.dWo;
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
