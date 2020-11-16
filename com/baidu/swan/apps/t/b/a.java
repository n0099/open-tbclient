package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.r;
/* loaded from: classes7.dex */
public abstract class a implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aht() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agM() {
        return com.baidu.swan.apps.t.a.awE().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public int ahv() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahw() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahx() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean agv() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahq() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void ahr() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String bs(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahs() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agy() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agJ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agK() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agL() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public boolean ahu() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String agN() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahy() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahz() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahA() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String kp(String str) {
        return com.baidu.swan.apps.i.c.processCommonParams(str);
    }
}
