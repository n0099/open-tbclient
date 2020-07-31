package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.q;
/* loaded from: classes7.dex */
public abstract class a implements q {
    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Uk() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TF() {
        return com.baidu.swan.apps.t.a.ahU().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public int Um() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Un() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Uo() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean To() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void Uh() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void Ui() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String bh(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Uj() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tr() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TC() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TD() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TE() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean Ul() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String TG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Up() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Uq() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Ur() {
        return null;
    }
}
