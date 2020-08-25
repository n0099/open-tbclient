package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes8.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aam() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZF() {
        return com.baidu.swan.apps.t.a.apw().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int aao() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aap() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaq() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean Zo() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aaj() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aak() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bn(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aal() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zr() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZC() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZD() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZE() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aan() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ZG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aar() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aas() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aat() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String iH(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
