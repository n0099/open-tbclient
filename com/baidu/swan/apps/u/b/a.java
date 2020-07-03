package com.baidu.swan.apps.u.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.q;
/* loaded from: classes11.dex */
public abstract class a implements q {
    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TN() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tk() {
        return com.baidu.swan.apps.u.a.agH().getHostName();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public int TP() {
        return 2;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TQ() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TR() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/navigate", "https://mbd.baidu.com"));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean ST() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TJ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void TK() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public void TL() {
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String bf(Context context) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TM() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SW() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Th() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Ti() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tj() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public boolean TO() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String Tl() {
        return null;
    }
}
