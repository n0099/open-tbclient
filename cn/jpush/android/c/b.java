package cn.jpush.android.c;
/* loaded from: classes3.dex */
final class b {
    public byte a;
    public String b;
    public long c;
    public byte[] d;
    public int e = 0;
    final /* synthetic */ a f;

    public b(a aVar, byte b, String str, long j, byte[] bArr) {
        this.f = aVar;
        this.a = b;
        this.b = str;
        this.c = j;
        this.d = bArr;
    }

    public final String toString() {
        return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.a) + ", regid='" + this.b + "', rid=" + this.c + ", retryCount=" + this.e + '}';
    }
}
