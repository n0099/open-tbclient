package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    final /* synthetic */ e HA;
    StringBuffer HC;

    private h(e eVar) {
        this.HA = eVar;
        this.HC = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
    }

    public void bQ(int i) {
        if (this.HC.length() != 0) {
            this.HC.append(",");
        }
        this.HC.append(i);
    }

    public void clear() {
        this.HC.setLength(0);
    }

    public String toString() {
        return this.HC.toString();
    }
}
