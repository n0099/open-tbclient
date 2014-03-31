package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
final class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a.a(4, this.a.a.d.getString(com.baidu.tbadk.l.voice_error_file_md5));
        this.a.a.E = 1;
    }
}
