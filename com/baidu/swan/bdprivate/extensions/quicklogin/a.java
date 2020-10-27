package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes8.dex */
public class a {
    private String agreeText;
    private boolean dDr;
    private String dDs;
    private String dDt;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aLX() {
        return this.loginMode;
    }

    public void lu(int i) {
        this.loginMode = i;
    }

    public boolean aLY() {
        return this.dDr;
    }

    public void gW(boolean z) {
        this.dDr = z;
    }

    public String aLZ() {
        return this.encryptPhoneNum;
    }

    public void uJ(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aMa() {
        return this.hasHistory;
    }

    public void gX(boolean z) {
        this.hasHistory = z;
    }

    public void uK(String str) {
        this.dDs = str;
    }

    public String aMb() {
        String str = this.dDs;
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
                this.dDt = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dDt = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dDt = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dDt;
    }

    public String aMc() {
        String str = this.dDs;
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
