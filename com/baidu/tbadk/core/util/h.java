package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    final /* synthetic */ e Dh;
    StringBuffer Dj;

    private h(e eVar) {
        this.Dh = eVar;
        this.Dj = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
    }

    public void bo(int i) {
        if (this.Dj.length() != 0) {
            this.Dj.append(",");
        }
        this.Dj.append(i);
    }

    public void clear() {
        this.Dj.setLength(0);
    }

    public String toString() {
        return this.Dj.toString();
    }
}
