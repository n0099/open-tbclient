package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes10.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FN() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ga() {
        return com.baidu.swan.apps.w.a.Sr().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Gb() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Gc() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bfp));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean FE() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FH() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void FJ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void FK() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bp(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FL() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FM() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FW() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FX() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String FY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean FZ() {
        return false;
    }
}
