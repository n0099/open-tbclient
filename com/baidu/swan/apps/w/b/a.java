package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes11.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ie() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ir() {
        return com.baidu.swan.apps.w.a.UH().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Is() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String It() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bjF));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean HV() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Ia() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Ib() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bt(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ic() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Id() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String In() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Io() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ip() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean Iq() {
        return false;
    }
}
