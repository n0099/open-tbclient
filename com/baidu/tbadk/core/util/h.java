package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    final /* synthetic */ e Dg;
    StringBuffer Di;

    private h(e eVar) {
        this.Dg = eVar;
        this.Di = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
    }

    public void bo(int i) {
        if (this.Di.length() != 0) {
            this.Di.append(",");
        }
        this.Di.append(i);
    }

    public void clear() {
        this.Di.setLength(0);
    }

    public String toString() {
        return this.Di.toString();
    }
}
