package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes10.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cRe = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cRf;

    public c(String str) {
        this.cRf = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void atF() {
        if (this.cRe.oB("video_will_play")) {
            this.cRe.oA("video_play_cancel");
        }
        aty();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fe(boolean z) {
        if (this.cRe.isFinished()) {
            this.cRe.atz();
            com.baidu.swan.apps.inlinewidget.f.b.b.atC();
            return;
        }
        this.cRe.bJ("fmpArrived", z ? "1" : "0");
    }

    private void aty() {
        this.cRe.aty();
        if (this.cRe.oC("fmpArrived")) {
            this.cRe.atz();
            com.baidu.swan.apps.inlinewidget.f.b.b.atC();
        }
    }
}
