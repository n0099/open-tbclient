package com.baidu.swan.apps.w.b;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes11.dex */
public abstract class a implements o {
    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ih() {
        return "https://ossapi.baidu.com/pms";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Iu() {
        return com.baidu.swan.apps.w.a.UK().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Iv() {
        return "https://ossapi.baidu.com/ma/landingpage?t=service_agreement_m";
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Iw() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", com.baidu.swan.apps.h.c.bjS));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean HY() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ib() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ic() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Id() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void Ie() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String bs(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String If() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ig() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Iq() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ir() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Is() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public boolean It() {
        return false;
    }
}
