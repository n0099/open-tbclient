package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes25.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a dcj = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String dck;

    public c(String str) {
        this.dck = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void ayF() {
        if (this.dcj.pq("video_will_play")) {
            this.dcj.pp("video_play_cancel");
        }
        ayy();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fF(boolean z) {
        if (this.dcj.isFinished()) {
            this.dcj.ayz();
            com.baidu.swan.apps.inlinewidget.f.b.b.ayC();
            return;
        }
        this.dcj.bP("fmpArrived", z ? "1" : "0");
    }

    private void ayy() {
        this.dcj.ayy();
        if (this.dcj.pr("fmpArrived")) {
            this.dcj.ayz();
            com.baidu.swan.apps.inlinewidget.f.b.b.ayC();
        }
    }
}
