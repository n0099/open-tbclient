package com.baidu.platform.comapi.walknavi.g.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f4550a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4551b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* loaded from: classes3.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f4554a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.f4554a;
    }

    private a() {
    }

    public void a(int i, c cVar) {
        int i2;
        int i3 = 2;
        if (i > 0 && i < 10) {
            i2 = (int) (i / 2.5d);
            if (i2 == 1) {
                i3 = 0;
            } else if (i2 == 2) {
                i3 = 1;
            } else if (i2 != 3) {
                i3 = -1;
            }
        } else if (i >= 10 && i < 20) {
            i2 = 1;
            i3 = 3;
        } else if (i >= 20 && i < 30) {
            i2 = 1;
            i3 = 4;
        } else if (i >= 30 && i < 50) {
            i2 = 1;
            i3 = 5;
        } else if (i >= 50 && i < 60) {
            i2 = 1;
            i3 = 6;
        } else if (i >= 60 && i < 70) {
            i2 = 1;
            i3 = 7;
        } else if (i >= 70 && i < 80) {
            i2 = 1;
            i3 = 8;
        } else if (i >= 80 && i < 90) {
            i2 = 1;
            i3 = 9;
        } else if (i >= 90 && i < 100) {
            i2 = 1;
            i3 = 10;
        } else if (i < 100) {
            i2 = 0;
            i3 = -1;
        } else {
            C0301a b2 = b(i);
            int i4 = b2.f4552a;
            i2 = b2.f4553b;
            i3 = i4;
        }
        if (f4550a != i3) {
            cVar.a(i3, i2);
        }
        f4550a = i3;
    }

    private C0301a b(int i) {
        C0301a c0301a = new C0301a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            if (i3 >= f4551b.length) {
                break;
            } else if (i2 < f4551b[i3] || i2 % f4551b[i3] != 0) {
                i3++;
            } else {
                c0301a.f4552a = c(f4551b[i3]);
                c0301a.f4553b = i2 / f4551b[i3];
                break;
            }
        }
        return c0301a;
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
        if (i != 90) {
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
            if (i == 10) {
                return 3;
            }
            return 0;
        }
        return 10;
    }

    public int a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return 2130837850;
        }
        if (i == 3) {
            return 2130837851;
        }
        if (i == 4) {
            return 2130837853;
        }
        if (i == 5) {
            return 2130837843;
        }
        if (i == 6) {
            return 2130837848;
        }
        if (i == 7) {
            return 2130837847;
        }
        if (i == 8) {
            return 2130837842;
        }
        if (i == 9) {
            return 2130837845;
        }
        if (i == 10) {
            return 2130837844;
        }
        if (i == 11) {
            return 2130837852;
        }
        if (i == 12) {
            return 2130837841;
        }
        if (i == 13) {
            return 2130837840;
        }
        if (i == 14) {
            return 2130837849;
        }
        if (i == 15) {
            return 2130837846;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0301a {

        /* renamed from: a  reason: collision with root package name */
        public int f4552a;

        /* renamed from: b  reason: collision with root package name */
        public int f4553b;

        C0301a() {
        }
    }
}
