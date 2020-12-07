package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes25.dex */
public class a {
    private String agreeText;
    private String dOA;
    private String dOB;
    private boolean dOz;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aQV() {
        return this.loginMode;
    }

    public void lY(int i) {
        this.loginMode = i;
    }

    public boolean aQW() {
        return this.dOz;
    }

    public void hx(boolean z) {
        this.dOz = z;
    }

    public String aQX() {
        return this.encryptPhoneNum;
    }

    public void vz(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aQY() {
        return this.hasHistory;
    }

    public void hy(boolean z) {
        this.hasHistory = z;
    }

    public void vA(String str) {
        this.dOA = str;
    }

    public String aQZ() {
        String str = this.dOA;
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
                this.dOB = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dOB = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dOB = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dOB;
    }

    public String aRa() {
        String str = this.dOA;
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
