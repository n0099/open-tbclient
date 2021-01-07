package b.a.a.a.a;

import android.os.Bundle;
/* loaded from: classes4.dex */
final class b implements Runnable {
    private /* synthetic */ al Ag;

    /* renamed from: a  reason: collision with root package name */
    private String f1060a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1061b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(al alVar, String str, boolean z) {
        this.Ag = alVar;
        this.f1060a = "";
        this.f1061b = false;
        this.f1060a = str;
        this.f1061b = z;
    }

    private static boolean a(byte[] bArr) {
        try {
            if (o.a(bArr)) {
                return true;
            }
            byte[] a2 = n.a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
            if (o.a(a2)) {
                return true;
            }
            new StringBuilder("[src,enc]=[").append(bArr.length).append(",").append(a2.length).append("]");
            boolean[] zArr = new boolean[1];
            zArr[0] = true;
            Bundle d = o.d("https://analytics.map.qq.com/tr?mllc", a2);
            int i = d.getInt("status", -1);
            new String(d.getByteArray("data_bytes"), d.getString("data_charset"));
            if (i != 0) {
                zArr[0] = false;
            }
            return zArr[0];
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (o.a(this.f1060a)) {
            return;
        }
        a(this.f1060a.getBytes());
    }
}
