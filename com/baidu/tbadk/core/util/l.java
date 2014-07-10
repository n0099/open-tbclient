package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class l {
    StringBuffer a;
    final /* synthetic */ i b;

    private l(i iVar) {
        this.b = iVar;
        this.a = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(i iVar, l lVar) {
        this(iVar);
    }

    public void a(int i) {
        if (this.a.length() != 0) {
            this.a.append(",");
        }
        this.a.append(i);
    }

    public void a() {
        this.a.setLength(0);
    }

    public String toString() {
        return this.a.toString();
    }
}
