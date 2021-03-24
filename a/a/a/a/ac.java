package a.a.a.a;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f999a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1000b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1001c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1002d;

    /* renamed from: e  reason: collision with root package name */
    public int f1003e;

    public ac() {
        this(4194304);
    }

    public ac(int i) {
        this.f999a = null;
        this.f1000b = 0;
        this.f1001c = 0;
        this.f1002d = 0;
        this.f1003e = 0;
        this.f1003e = i;
        this.f999a = new byte[i];
    }

    public void a() {
        synchronized (this) {
            this.f1000b = 0;
            this.f1001c = 0;
            this.f1002d = 0;
        }
    }

    public boolean a(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && i <= this.f1000b) {
                    if (this.f1001c + i <= this.f1003e) {
                        System.arraycopy(this.f999a, this.f1001c, bArr, 0, i);
                        this.f1001c += i;
                        this.f1000b -= i;
                        return true;
                    }
                    System.arraycopy(this.f999a, this.f1001c, bArr, 0, this.f1003e - this.f1001c);
                    System.arraycopy(this.f999a, 0, bArr, this.f1003e - this.f1001c, (this.f1001c + i) - this.f1003e);
                    this.f1001c = (i - this.f1003e) + this.f1001c;
                    this.f1000b -= i;
                    return true;
                }
            }
            return false;
        }
    }

    public boolean b(byte[] bArr, int i) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length >= i && this.f1000b + i <= this.f1003e) {
                    if (this.f1002d + i <= this.f1003e) {
                        System.arraycopy(bArr, 0, this.f999a, this.f1002d, i);
                        this.f1002d += i;
                        this.f1000b += i;
                        return true;
                    }
                    System.arraycopy(bArr, 0, this.f999a, this.f1002d, this.f1003e - this.f1002d);
                    System.arraycopy(bArr, this.f1003e - this.f1002d, this.f999a, 0, (this.f1002d + i) - this.f1003e);
                    this.f1002d = (i - this.f1003e) + this.f1002d;
                    this.f1000b += i;
                    return true;
                }
            }
            return false;
        }
    }
}
