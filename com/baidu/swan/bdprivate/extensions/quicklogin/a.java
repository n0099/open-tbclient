package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes3.dex */
public class a {
    private String agreeText;
    private boolean dgL;
    private String dgM;
    private String dgN;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aGK() {
        return this.loginMode;
    }

    public void kB(int i) {
        this.loginMode = i;
    }

    public boolean aGL() {
        return this.dgL;
    }

    public void gp(boolean z) {
        this.dgL = z;
    }

    public String aGM() {
        return this.encryptPhoneNum;
    }

    public void tl(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aGN() {
        return this.hasHistory;
    }

    public void gq(boolean z) {
        this.hasHistory = z;
    }

    public void tm(String str) {
        this.dgM = str;
    }

    public String aGO() {
        String str = this.dgM;
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
                this.dgN = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dgN = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dgN = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dgN;
    }

    public String aGP() {
        String str = this.dgM;
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
