package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes9.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fr() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FE() {
        return com.baidu.swan.apps.w.a.RV().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FF() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FG() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.beA));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean Fi() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fl() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fm() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Fn() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Fo() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bp(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fp() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fq() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FA() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FB() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FC() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean FD() {
        return false;
    }
}
