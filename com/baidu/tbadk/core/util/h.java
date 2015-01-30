package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    final /* synthetic */ e HD;
    StringBuffer HF;

    private h(e eVar) {
        this.HD = eVar;
        this.HF = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
    }

    public void bQ(int i) {
        if (this.HF.length() != 0) {
            this.HF.append(",");
        }
        this.HF.append(i);
    }

    public void clear() {
        this.HF.setLength(0);
    }

    public String toString() {
        return this.HF.toString();
    }
}
