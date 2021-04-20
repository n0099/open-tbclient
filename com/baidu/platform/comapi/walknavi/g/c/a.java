package com.baidu.platform.comapi.walknavi.g.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f9682a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f9683b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0126a {

        /* renamed from: a  reason: collision with root package name */
        public int f9684a;

        /* renamed from: b  reason: collision with root package name */
        public int f9685b;

        public C0126a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9687a = new a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.f9687a;
    }

    private C0126a b(int i) {
        C0126a c0126a = new C0126a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            int[] iArr = f9683b;
            if (i3 >= iArr.length) {
                break;
            } else if (i2 >= iArr[i3] && i2 % iArr[i3] == 0) {
                c0126a.f9684a = c(iArr[i3]);
                c0126a.f9685b = i2 / f9683b[i3];
                break;
            } else {
                i3++;
            }
        }
        return c0126a;
    }

    private int c(int i) {
        if (i == 500) {
            return 15;
        }
        if (i == 400) {
            return 14;
        }
        if (i == 300) {
            return 13;
        }
        if (i == 200) {
            return 12;
        }
        if (i == 100) {
            return 11;
        }
        if (i == 90) {
            return 10;
        }
        if (i == 80) {
            return 9;
        }
        if (i == 70) {
            return 8;
        }
        if (i == 60) {
            return 7;
        }
        if (i == 50) {
            return 6;
        }
        if (i == 30) {
            return 5;
        }
        if (i == 20) {
            return 4;
        }
        return i == 10 ? 3 : 0;
    }

    public int a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return 2130837782;
        }
        if (i == 3) {
            return 2130837783;
        }
        if (i == 4) {
            return 2130837785;
        }
        if (i == 5) {
            return 2130837775;
        }
        if (i == 6) {
            return 2130837780;
        }
        if (i == 7) {
            return 2130837779;
        }
        if (i == 8) {
            return 2130837774;
        }
        if (i == 9) {
            return 2130837777;
        }
        if (i == 10) {
            return 2130837776;
        }
        if (i == 11) {
            return 2130837784;
        }
        if (i == 12) {
            return 2130837773;
        }
        if (i == 13) {
            return 2130837772;
        }
        if (i == 14) {
            return 2130837781;
        }
        return i == 15 ? 2130837778 : -1;
    }

    public a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r11 == 3) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, c cVar) {
        int i2 = 2;
        int i3 = 0;
        if (i <= 0 || i >= 10) {
            if (i >= 10 && i < 20) {
                i2 = 3;
            } else if (i >= 20 && i < 30) {
                i2 = 4;
            } else if (i >= 30 && i < 50) {
                i2 = 5;
            } else if (i >= 50 && i < 60) {
                i2 = 6;
            } else if (i >= 60 && i < 70) {
                i2 = 7;
            } else if (i >= 70 && i < 80) {
                i2 = 8;
            } else if (i >= 80 && i < 90) {
                i2 = 9;
            } else if (i < 90 || i >= 100) {
                if (i >= 100) {
                    C0126a b2 = b(i);
                    i2 = b2.f9684a;
                    i3 = b2.f9685b;
                }
                i2 = -1;
            } else {
                i2 = 10;
            }
            i3 = 1;
        } else {
            int i4 = (int) (i / 2.5d);
            if (i4 == 1) {
                i3 = i4;
                i2 = 0;
            } else if (i4 == 2) {
                i3 = i4;
                i2 = 1;
            } else {
                i3 = i4;
            }
        }
        if (f9682a != i2) {
            cVar.a(i2, i3);
        }
        f9682a = i2;
    }
}
