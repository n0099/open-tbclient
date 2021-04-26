package com.baidu.platform.comapi.walknavi.g.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f10042a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f10043b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0126a {

        /* renamed from: a  reason: collision with root package name */
        public int f10044a;

        /* renamed from: b  reason: collision with root package name */
        public int f10045b;

        public C0126a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f10047a = new a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i2, int i3);
    }

    public static a a() {
        return b.f10047a;
    }

    private C0126a b(int i2) {
        C0126a c0126a = new C0126a();
        int i3 = (i2 / 10) * 10;
        int i4 = 0;
        while (true) {
            int[] iArr = f10043b;
            if (i4 >= iArr.length) {
                break;
            } else if (i3 >= iArr[i4] && i3 % iArr[i4] == 0) {
                c0126a.f10044a = c(iArr[i4]);
                c0126a.f10045b = i3 / f10043b[i4];
                break;
            } else {
                i4++;
            }
        }
        return c0126a;
    }

    private int c(int i2) {
        if (i2 == 500) {
            return 15;
        }
        if (i2 == 400) {
            return 14;
        }
        if (i2 == 300) {
            return 13;
        }
        if (i2 == 200) {
            return 12;
        }
        if (i2 == 100) {
            return 11;
        }
        if (i2 == 90) {
            return 10;
        }
        if (i2 == 80) {
            return 9;
        }
        if (i2 == 70) {
            return 8;
        }
        if (i2 == 60) {
            return 7;
        }
        if (i2 == 50) {
            return 6;
        }
        if (i2 == 30) {
            return 5;
        }
        if (i2 == 20) {
            return 4;
        }
        return i2 == 10 ? 3 : 0;
    }

    public int a(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            return 2130837782;
        }
        if (i2 == 3) {
            return 2130837783;
        }
        if (i2 == 4) {
            return 2130837785;
        }
        if (i2 == 5) {
            return 2130837775;
        }
        if (i2 == 6) {
            return 2130837780;
        }
        if (i2 == 7) {
            return 2130837779;
        }
        if (i2 == 8) {
            return 2130837774;
        }
        if (i2 == 9) {
            return 2130837777;
        }
        if (i2 == 10) {
            return 2130837776;
        }
        if (i2 == 11) {
            return 2130837784;
        }
        if (i2 == 12) {
            return 2130837773;
        }
        if (i2 == 13) {
            return 2130837772;
        }
        if (i2 == 14) {
            return 2130837781;
        }
        return i2 == 15 ? 2130837778 : -1;
    }

    public a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r11 == 3) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, c cVar) {
        int i3 = 2;
        int i4 = 0;
        if (i2 <= 0 || i2 >= 10) {
            if (i2 >= 10 && i2 < 20) {
                i3 = 3;
            } else if (i2 >= 20 && i2 < 30) {
                i3 = 4;
            } else if (i2 >= 30 && i2 < 50) {
                i3 = 5;
            } else if (i2 >= 50 && i2 < 60) {
                i3 = 6;
            } else if (i2 >= 60 && i2 < 70) {
                i3 = 7;
            } else if (i2 >= 70 && i2 < 80) {
                i3 = 8;
            } else if (i2 >= 80 && i2 < 90) {
                i3 = 9;
            } else if (i2 < 90 || i2 >= 100) {
                if (i2 >= 100) {
                    C0126a b2 = b(i2);
                    i3 = b2.f10044a;
                    i4 = b2.f10045b;
                }
                i3 = -1;
            } else {
                i3 = 10;
            }
            i4 = 1;
        } else {
            int i5 = (int) (i2 / 2.5d);
            if (i5 == 1) {
                i4 = i5;
                i3 = 0;
            } else if (i5 == 2) {
                i4 = i5;
                i3 = 1;
            } else {
                i4 = i5;
            }
        }
        if (f10042a != i3) {
            cVar.a(i3, i4);
        }
        f10042a = i3;
    }
}
