package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    final /* synthetic */ e Hu;
    StringBuffer Hw;

    private h(e eVar) {
        this.Hu = eVar;
        this.Hw = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
    }

    public void bL(int i) {
        if (this.Hw.length() != 0) {
            this.Hw.append(",");
        }
        this.Hw.append(i);
    }

    public void clear() {
        this.Hw.setLength(0);
    }

    public String toString() {
        return this.Hw.toString();
    }
}
