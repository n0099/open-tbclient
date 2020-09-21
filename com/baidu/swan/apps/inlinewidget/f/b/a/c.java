package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes3.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cwC = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cwD;

    public c(String str) {
        this.cwD = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void aoY() {
        if (this.cwC.nu("video_will_play")) {
            this.cwC.nt("video_play_cancel");
        }
        aoR();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void ev(boolean z) {
        if (this.cwC.isFinished()) {
            this.cwC.aoS();
            com.baidu.swan.apps.inlinewidget.f.b.b.aoV();
            return;
        }
        this.cwC.bx("fmpArrived", z ? "1" : "0");
    }

    private void aoR() {
        this.cwC.aoR();
        if (this.cwC.nv("fmpArrived")) {
            this.cwC.aoS();
            com.baidu.swan.apps.inlinewidget.f.b.b.aoV();
        }
    }
}
