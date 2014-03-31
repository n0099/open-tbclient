package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
final class e implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
