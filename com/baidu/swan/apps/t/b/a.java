package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes3.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaV() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aao() {
        return com.baidu.swan.apps.t.a.aqg().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int aaX() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaY() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaZ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ZX() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aaS() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void aaT() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bm(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaU() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aaa() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aal() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aam() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aan() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean aaW() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String aap() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aba() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String abb() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String abc() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String jb(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
