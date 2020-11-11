package a.a.a.a;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f951a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public int e;

    public a() {
        this(4194304);
    }

    public a(int i) {
        this.f951a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.e = i;
        this.f951a = new byte[i];
    }

    public void a() {
        synchronized (this) {
            this.b = 0;
            this.c = 0;
            this.d = 0;
        }
    }

    public boolean d(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && i <= this.b) {
                    if (this.c + i <= this.e) {
                        System.arraycopy(this.f951a, this.c, bArr, 0, i);
                        this.c += i;
                        this.b -= i;
                        return true;
                    }
                    System.arraycopy(this.f951a, this.c, bArr, 0, this.e - this.c);
                    System.arraycopy(this.f951a, 0, bArr, this.e - this.c, (this.c + i) - this.e);
                    this.c += i - this.e;
                    this.b -= i;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && this.b + i <= this.e) {
                    if (this.d + i <= this.e) {
                        System.arraycopy(bArr, 0, this.f951a, this.d, i);
                        this.d += i;
                        this.b += i;
                        return true;
                    }
                    System.arraycopy(bArr, 0, this.f951a, this.d, this.e - this.d);
                    System.arraycopy(bArr, this.e - this.d, this.f951a, 0, (this.d + i) - this.e);
                    this.d += i - this.e;
                    this.b += i;
                    return true;
                }
            }
        }
        return false;
    }
}
