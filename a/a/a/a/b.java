package a.a.a.a;
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f954a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public int e;

    public b() {
        this(4194304);
    }

    public b(int i) {
        this.f954a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.e = i;
        this.f954a = new byte[i];
    }

    public void a() {
        synchronized (this) {
            this.b = 0;
            this.c = 0;
            this.d = 0;
        }
    }

    public boolean a(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && i <= this.b) {
                    if (this.c + i <= this.e) {
                        System.arraycopy(this.f954a, this.c, bArr, 0, i);
                        this.c += i;
                        this.b -= i;
                        return true;
                    }
                    System.arraycopy(this.f954a, this.c, bArr, 0, this.e - this.c);
                    System.arraycopy(this.f954a, 0, bArr, this.e - this.c, (this.c + i) - this.e);
                    this.c += i - this.e;
                    this.b -= i;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean d(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && this.b + i <= this.e) {
                    if (this.d + i <= this.e) {
                        System.arraycopy(bArr, 0, this.f954a, this.d, i);
                        this.d += i;
                        this.b += i;
                        return true;
                    }
                    System.arraycopy(bArr, 0, this.f954a, this.d, this.e - this.d);
                    System.arraycopy(bArr, this.e - this.d, this.f954a, 0, (this.d + i) - this.e);
                    this.d += i - this.e;
                    this.b += i;
                    return true;
                }
            }
        }
        return false;
    }
}
