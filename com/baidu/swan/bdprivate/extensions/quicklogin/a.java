package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes8.dex */
public class a {
    private String agreeText;
    private boolean dSG;
    private String dSH;
    private String dSI;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aPx() {
        return this.loginMode;
    }

    public void kz(int i) {
        this.loginMode = i;
    }

    public boolean aPy() {
        return this.dSG;
    }

    public void hL(boolean z) {
        this.dSG = z;
    }

    public String aPz() {
        return this.encryptPhoneNum;
    }

    public void un(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aPA() {
        return this.hasHistory;
    }

    public void hM(boolean z) {
        this.hasHistory = z;
    }

    public void uo(String str) {
        this.dSH = str;
    }

    public String aPB() {
        String str = this.dSH;
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
                this.dSI = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dSI = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dSI = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dSI;
    }

    public String aPC() {
        String str = this.dSH;
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
