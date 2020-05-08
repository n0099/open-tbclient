package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes11.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PS() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qf() {
        return com.baidu.swan.apps.w.a.acy().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qg() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qh() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bIf));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean PJ() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PM() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PN() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void PO() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void PP() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String aU(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PR() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qb() {
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
    public boolean Qe() {
        return false;
    }
}
