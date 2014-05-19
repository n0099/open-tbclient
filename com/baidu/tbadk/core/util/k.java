package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
class k {
    StringBuffer a;
    final /* synthetic */ h b;

    private k(h hVar) {
        this.b = hVar;
        this.a = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(h hVar, k kVar) {
        this(hVar);
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
