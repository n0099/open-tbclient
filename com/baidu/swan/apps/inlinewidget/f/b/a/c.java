package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes8.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cux = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cuy;

    public c(String str) {
        this.cuy = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void aoo() {
        if (this.cux.na("video_will_play")) {
            this.cux.mZ("video_play_cancel");
        }
        aoh();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void ew(boolean z) {
        if (this.cux.isFinished()) {
            this.cux.aoi();
            com.baidu.swan.apps.inlinewidget.f.b.b.aol();
            return;
        }
        this.cux.bx("fmpArrived", z ? "1" : "0");
    }

    private void aoh() {
        this.cux.aoh();
        if (this.cux.nb("fmpArrived")) {
            this.cux.aoi();
            com.baidu.swan.apps.inlinewidget.f.b.b.aol();
        }
    }
}
