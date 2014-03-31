package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
final class v implements Runnable {
    final /* synthetic */ t a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str, int i) {
        this.a = tVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.E = 1;
        this.a.a.a.a(this.b, this.c);
    }
}
