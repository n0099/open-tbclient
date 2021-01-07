package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes9.dex */
public class a {
    private String agreeText;
    private boolean dXs;
    private String dXt;
    private String dXu;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aTr() {
        return this.loginMode;
    }

    public void mf(int i) {
        this.loginMode = i;
    }

    public boolean aTs() {
        return this.dXs;
    }

    public void hP(boolean z) {
        this.dXs = z;
    }

    public String aTt() {
        return this.encryptPhoneNum;
    }

    public void vy(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aTu() {
        return this.hasHistory;
    }

    public void hQ(boolean z) {
        this.hasHistory = z;
    }

    public void vz(String str) {
        this.dXt = str;
    }

    public String aTv() {
        String str = this.dXt;
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
                this.dXu = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dXu = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dXu = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dXu;
    }

    public String aTw() {
        String str = this.dXt;
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
