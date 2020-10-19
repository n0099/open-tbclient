package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes8.dex */
public class a {
    private String agreeText;
    private boolean duU;
    private String duV;
    private String duW;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aKd() {
        return this.loginMode;
    }

    public void lj(int i) {
        this.loginMode = i;
    }

    public boolean aKe() {
        return this.duU;
    }

    public void gJ(boolean z) {
        this.duU = z;
    }

    public String aKf() {
        return this.encryptPhoneNum;
    }

    public void uq(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aKg() {
        return this.hasHistory;
    }

    public void gK(boolean z) {
        this.hasHistory = z;
    }

    public void ur(String str) {
        this.duV = str;
    }

    public String aKh() {
        String str = this.duV;
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
                this.duW = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.duW = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.duW = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.duW;
    }

    public String aKi() {
        String str = this.duV;
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
