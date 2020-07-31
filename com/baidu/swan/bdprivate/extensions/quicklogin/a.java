package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class a {
    private String agreeText;
    private String cXA;
    private boolean cXy;
    private String cXz;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int ayB() {
        return this.loginMode;
    }

    public void it(int i) {
        this.loginMode = i;
    }

    public boolean ayC() {
        return this.cXy;
    }

    public void fV(boolean z) {
        this.cXy = z;
    }

    public String ayD() {
        return this.encryptPhoneNum;
    }

    public void rc(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean ayE() {
        return this.hasHistory;
    }

    public void fW(boolean z) {
        this.hasHistory = z;
    }

    public void rd(String str) {
        this.cXz = str;
    }

    public String ayF() {
        String str = this.cXz;
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
                this.cXA = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.cXA = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.cXA = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.cXA;
    }

    public String ayG() {
        String str = this.cXz;
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
