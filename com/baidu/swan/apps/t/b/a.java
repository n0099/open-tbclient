package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes10.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afB() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeU() {
        return com.baidu.swan.apps.t.a.auM().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int afD() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afE() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afF() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aeD() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void afy() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void afz() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bs(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afA() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeS() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeT() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean afC() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String aeV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afH() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String afI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kg(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
