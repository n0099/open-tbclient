package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes8.dex */
public class a {
    private String agreeText;
    private boolean dJj;
    private String dJk;
    private String dJl;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aOx() {
        return this.loginMode;
    }

    public void lE(int i) {
        this.loginMode = i;
    }

    public boolean aOy() {
        return this.dJj;
    }

    public void hf(boolean z) {
        this.dJj = z;
    }

    public String aOz() {
        return this.encryptPhoneNum;
    }

    public void uX(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aOA() {
        return this.hasHistory;
    }

    public void hg(boolean z) {
        this.hasHistory = z;
    }

    public void uY(String str) {
        this.dJk = str;
    }

    public String aOB() {
        String str = this.dJk;
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
                this.dJl = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dJl = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dJl = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dJl;
    }

    public String aOC() {
        String str = this.dJk;
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
