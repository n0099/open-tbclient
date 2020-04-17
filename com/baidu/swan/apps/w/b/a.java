package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes11.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PT() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qg() {
        return com.baidu.swan.apps.w.a.acz().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qh() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qi() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bIa));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean PK() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PN() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PO() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void PP() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void PQ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bg(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PS() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qc() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qd() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qe() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean Qf() {
        return false;
    }
}
