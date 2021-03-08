package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes8.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a dgd = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String dge;

    public c(String str) {
        this.dge = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void awE() {
        if (this.dgd.ox("video_will_play")) {
            this.dgd.ow("video_play_cancel");
        }
        awx();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fM(boolean z) {
        if (this.dgd.isFinished()) {
            this.dgd.awy();
            com.baidu.swan.apps.inlinewidget.f.b.b.awB();
            return;
        }
        this.dgd.bH("fmpArrived", z ? "1" : "0");
    }

    private void awx() {
        this.dgd.awx();
        if (this.dgd.oy("fmpArrived")) {
            this.dgd.awy();
            com.baidu.swan.apps.inlinewidget.f.b.b.awB();
        }
    }
}
