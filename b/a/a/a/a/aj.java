package b.a.a.a.a;

import java.io.File;
/* loaded from: classes3.dex */
final class aj implements Runnable {
    private /* synthetic */ ai Bq;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ File f1055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, File file) {
        this.Bq = aiVar;
        this.f1055a = file;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            byte[] a2 = ai.a(this.f1055a);
            if (a2 == null || a2.length <= 0 || o.d("https://analytics.map.qq.com/?sf2", a2).getInt("status", -1) != 0) {
                return;
            }
            this.f1055a.delete();
            new StringBuilder("upload ").append(this.f1055a.getName()).append(" succeed.");
        } catch (Throwable th) {
            new StringBuilder("upload file:").append(this.f1055a.getName()).append(" error!");
        }
    }
}
