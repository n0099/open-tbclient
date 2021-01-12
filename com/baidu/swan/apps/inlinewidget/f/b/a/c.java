package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes8.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a dco = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String dcp;

    public c(String str) {
        this.dcp = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void awd() {
        if (this.dco.nW("video_will_play")) {
            this.dco.nV("video_play_cancel");
        }
        avW();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fK(boolean z) {
        if (this.dco.isFinished()) {
            this.dco.avX();
            com.baidu.swan.apps.inlinewidget.f.b.b.awa();
            return;
        }
        this.dco.bN("fmpArrived", z ? "1" : "0");
    }

    private void avW() {
        this.dco.avW();
        if (this.dco.nX("fmpArrived")) {
            this.dco.avX();
            com.baidu.swan.apps.inlinewidget.f.b.b.awa();
        }
    }
}
