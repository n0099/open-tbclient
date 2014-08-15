package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class h {
    StringBuffer a;
    final /* synthetic */ e b;

    private h(e eVar) {
        this.b = eVar;
        this.a = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, h hVar) {
        this(eVar);
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
