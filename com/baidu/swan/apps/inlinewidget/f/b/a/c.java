package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes10.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cII = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cIJ;

    public c(String str) {
        this.cIJ = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void arK() {
        if (this.cII.oh("video_will_play")) {
            this.cII.og("video_play_cancel");
        }
        arD();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void eR(boolean z) {
        if (this.cII.isFinished()) {
            this.cII.arE();
            com.baidu.swan.apps.inlinewidget.f.b.b.arH();
            return;
        }
        this.cII.bC("fmpArrived", z ? "1" : "0");
    }

    private void arD() {
        this.cII.arD();
        if (this.cII.oi("fmpArrived")) {
            this.cII.arE();
            com.baidu.swan.apps.inlinewidget.f.b.b.arH();
        }
    }
}
