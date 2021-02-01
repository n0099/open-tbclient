package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes9.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a deC = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String deD;

    public c(String str) {
        this.deD = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void awB() {
        if (this.deC.oq("video_will_play")) {
            this.deC.op("video_play_cancel");
        }
        awu();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fM(boolean z) {
        if (this.deC.isFinished()) {
            this.deC.awv();
            com.baidu.swan.apps.inlinewidget.f.b.b.awy();
            return;
        }
        this.deC.bH("fmpArrived", z ? "1" : "0");
    }

    private void awu() {
        this.deC.awu();
        if (this.deC.or("fmpArrived")) {
            this.deC.awv();
            com.baidu.swan.apps.inlinewidget.f.b.b.awy();
        }
    }
}
