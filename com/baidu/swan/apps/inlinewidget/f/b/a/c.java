package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes8.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cuB = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cuC;

    public c(String str) {
        this.cuC = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void aoo() {
        if (this.cuB.nb("video_will_play")) {
            this.cuB.na("video_play_cancel");
        }
        aoh();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void ex(boolean z) {
        if (this.cuB.isFinished()) {
            this.cuB.aoi();
            com.baidu.swan.apps.inlinewidget.f.b.b.aol();
            return;
        }
        this.cuB.bx("fmpArrived", z ? "1" : "0");
    }

    private void aoh() {
        this.cuB.aoh();
        if (this.cuB.nc("fmpArrived")) {
            this.cuB.aoi();
            com.baidu.swan.apps.inlinewidget.f.b.b.aol();
        }
    }
}
