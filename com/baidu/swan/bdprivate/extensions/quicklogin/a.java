package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes3.dex */
public class a {
    private String agreeText;
    private boolean diO;
    private String diP;
    private String diQ;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aHu() {
        return this.loginMode;
    }

    public void kM(int i) {
        this.loginMode = i;
    }

    public boolean aHv() {
        return this.diO;
    }

    public void gn(boolean z) {
        this.diO = z;
    }

    public String aHw() {
        return this.encryptPhoneNum;
    }

    public void tE(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aHx() {
        return this.hasHistory;
    }

    public void go(boolean z) {
        this.hasHistory = z;
    }

    public void tF(String str) {
        this.diP = str;
    }

    public String aHy() {
        String str = this.diP;
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
                this.diQ = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.diQ = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.diQ = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.diQ;
    }

    public String aHz() {
        String str = this.diP;
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
