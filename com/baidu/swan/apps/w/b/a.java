package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes11.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ic() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ip() {
        return com.baidu.swan.apps.w.a.UF().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Iq() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ir() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bjD));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean HT() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HW() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HX() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void HY() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void HZ() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bt(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ia() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ib() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Il() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Im() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String In() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean Io() {
        return false;
    }
}
