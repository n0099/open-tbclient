package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes7.dex */
public class a {
    private String agreeText;
    private boolean dHB;
    private String dHC;
    private String dHD;
    private String encryptPhoneNum;
    private boolean hasHistory;
    private int loginMode;

    public int aNP() {
        return this.loginMode;
    }

    public void lA(int i) {
        this.loginMode = i;
    }

    public boolean aNQ() {
        return this.dHB;
    }

    public void hi(boolean z) {
        this.dHB = z;
    }

    public String aNR() {
        return this.encryptPhoneNum;
    }

    public void uS(String str) {
        this.encryptPhoneNum = str;
    }

    public boolean aNS() {
        return this.hasHistory;
    }

    public void hj(boolean z) {
        this.hasHistory = z;
    }

    public void uT(String str) {
        this.dHC = str;
    }

    public String aNT() {
        String str = this.dHC;
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
                this.dHD = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
                break;
            case 1:
                this.dHD = "https://ms.zzx9.cn/html/oauth/protocol2.html";
                break;
            case 2:
                this.dHD = "https://wap.cmpassport.com/resources/html/contract.html";
                break;
        }
        return this.dHD;
    }

    public String aNU() {
        String str = this.dHC;
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
