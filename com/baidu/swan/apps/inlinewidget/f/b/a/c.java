package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes9.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a dhd = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String dhe;

    public c(String str) {
        this.dhe = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void azW() {
        if (this.dhd.pj("video_will_play")) {
            this.dhd.pi("video_play_cancel");
        }
        azP();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fO(boolean z) {
        if (this.dhd.isFinished()) {
            this.dhd.azQ();
            com.baidu.swan.apps.inlinewidget.f.b.b.azT();
            return;
        }
        this.dhd.bO("fmpArrived", z ? "1" : "0");
    }

    private void azP() {
        this.dhd.azP();
        if (this.dhd.pk("fmpArrived")) {
            this.dhd.azQ();
            com.baidu.swan.apps.inlinewidget.f.b.b.azT();
        }
    }
}
