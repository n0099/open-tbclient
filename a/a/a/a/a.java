package a.a.a.a;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1030a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1031b;
    public volatile int c;
    public volatile int d;
    public int e;

    public a() {
        this(4194304);
    }

    public a(int i) {
        this.f1030a = null;
        this.f1031b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.e = i;
        this.f1030a = new byte[i];
    }

    public void a() {
        synchronized (this) {
            this.f1031b = 0;
            this.c = 0;
            this.d = 0;
        }
    }

    public boolean a(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && i <= this.f1031b) {
                    if (this.c + i <= this.e) {
                        System.arraycopy(this.f1030a, this.c, bArr, 0, i);
                        this.c += i;
                        this.f1031b -= i;
                        return true;
                    }
                    System.arraycopy(this.f1030a, this.c, bArr, 0, this.e - this.c);
                    System.arraycopy(this.f1030a, 0, bArr, this.e - this.c, (this.c + i) - this.e);
                    this.c += i - this.e;
                    this.f1031b -= i;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean d(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && this.f1031b + i <= this.e) {
                    if (this.d + i <= this.e) {
                        System.arraycopy(bArr, 0, this.f1030a, this.d, i);
                        this.d += i;
                        this.f1031b += i;
                        return true;
                    }
                    System.arraycopy(bArr, 0, this.f1030a, this.d, this.e - this.d);
                    System.arraycopy(bArr, this.e - this.d, this.f1030a, 0, (this.d + i) - this.e);
                    this.d += i - this.e;
                    this.f1031b += i;
                    return true;
                }
            }
        }
        return false;
    }
}
