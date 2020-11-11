package com.baidu.swan.apps.inlinewidget.f.b.a;
/* loaded from: classes10.dex */
public class c extends b {
    private final com.baidu.swan.apps.inlinewidget.f.b.a cWX = new com.baidu.swan.apps.inlinewidget.f.b.a();
    private final String cWY;

    public c(String str) {
        this.cWY = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void awf() {
        if (this.cWX.oP("video_will_play")) {
            this.cWX.oO("video_play_cancel");
        }
        avY();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.b.a.b, com.baidu.swan.apps.inlinewidget.f.b.a.a
    public void fn(boolean z) {
        if (this.cWX.isFinished()) {
            this.cWX.avZ();
            com.baidu.swan.apps.inlinewidget.f.b.b.awc();
            return;
        }
        this.cWX.bJ("fmpArrived", z ? "1" : "0");
    }

    private void avY() {
        this.cWX.avY();
        if (this.cWX.oQ("fmpArrived")) {
            this.cWX.avZ();
            com.baidu.swan.apps.inlinewidget.f.b.b.awc();
        }
    }
}
