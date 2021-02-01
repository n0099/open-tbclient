package com.baidu.platform.comapi.walknavi.g.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f4331a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4332b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* loaded from: classes4.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f4335a = new a();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.f4335a;
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
            C0288a b2 = b(i);
            int i4 = b2.f4333a;
            i2 = b2.f4334b;
            i3 = i4;
        }
        if (f4331a != i3) {
            cVar.a(i3, i2);
        }
        f4331a = i3;
    }

    private C0288a b(int i) {
        C0288a c0288a = new C0288a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            if (i3 >= f4332b.length) {
                break;
            } else if (i2 < f4332b[i3] || i2 % f4332b[i3] != 0) {
                i3++;
            } else {
                c0288a.f4333a = c(f4332b[i3]);
                c0288a.f4334b = i2 / f4332b[i3];
                break;
            }
        }
        return c0288a;
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
        if (i == 15) {
            return 2130837778;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0288a {

        /* renamed from: a  reason: collision with root package name */
        public int f4333a;

        /* renamed from: b  reason: collision with root package name */
        public int f4334b;

        C0288a() {
        }
    }
}
