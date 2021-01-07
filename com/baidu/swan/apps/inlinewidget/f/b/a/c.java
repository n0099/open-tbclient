package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes9.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a dhd = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String dhe;

    public c(String str) {
        this.dhe = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void azX() {
        if (this.dhd.pj("video_will_play")) {
            this.dhd.pi("video_play_cancel");
        }
        azQ();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fO(boolean z) {
        if (this.dhd.isFinished()) {
            this.dhd.azR();
            com.baidu.swan.apps.inlinewidget.f.b.b.azU();
            return;
        }
        this.dhd.bO("fmpArrived", z ? "1" : "0");
    }

    private void azQ() {
        this.dhd.azQ();
        if (this.dhd.pk("fmpArrived")) {
            this.dhd.azR();
            com.baidu.swan.apps.inlinewidget.f.b.b.azU();
        }
    }
}
