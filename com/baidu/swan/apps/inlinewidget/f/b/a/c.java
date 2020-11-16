package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes7.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cVn = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cVo;

    public c(String str) {
        this.cVo = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void avx() {
        if (this.cVn.oJ("video_will_play")) {
            this.cVn.oI("video_play_cancel");
        }
        avq();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fq(boolean z) {
        if (this.cVn.isFinished()) {
            this.cVn.avr();
            com.baidu.swan.apps.inlinewidget.f.b.b.avu();
            return;
        }
        this.cVn.bI("fmpArrived", z ? "1" : "0");
    }

    private void avq() {
        this.cVn.avq();
        if (this.cVn.oK("fmpArrived")) {
            this.cVn.avr();
            com.baidu.swan.apps.inlinewidget.f.b.b.avu();
        }
    }
}
