package com.baidu.platform.comapi.wnplatform.o;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f9919a = {"m", "km", "米", "公里"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f9920b = {"m", "h", "分钟", "小时"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f9921c = {"m", "h", "d", "分钟", "小时", "天"};

    /* loaded from: classes2.dex */
    public enum a {
        EN(0),
        ZH(1);
        

        /* renamed from: c  reason: collision with root package name */
        public int f9925c;

        a(int i) {
            this.f9925c = i;
        }

        public int a() {
            return this.f9925c;
        }
    }

    public static int a(boolean z) {
        return 0;
    }

    public static void a(int i, a aVar, StringBuffer stringBuffer) {
        int a2 = aVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i < 1000) {
            if (stringBuffer != null) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i), f9919a[a2 + 0]));
                return;
            }
            return;
        }
        String str = i % 1000 == 0 ? "%.0f%s" : "%.1f%s";
        if (stringBuffer != null) {
            int i2 = i / 1000;
            if (i2 >= 100) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i2), f9919a[a2 + 1]));
            } else {
                stringBuffer.append(String.format(str, Double.valueOf(i / 1000.0d), f9919a[a2 + 1]));
            }
        }
    }

    public static boolean a() {
        return false;
    }

    public static int b() {
        return 2;
    }

    public static void a(int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i3 = (i / 3600) % 24;
            int i4 = (i / 60) % 60;
            if (i < 3600) {
                stringBuffer.append(i4);
                stringBuffer.append(f9921c[i2 + 1]);
            } else if (i < 86400) {
                stringBuffer.append(i3);
                stringBuffer.append(f9921c[i2 + 2]);
                if (i4 > 0) {
                    stringBuffer.append(i4);
                    stringBuffer.append("分");
                }
            } else {
                stringBuffer.append(i / 86400);
                stringBuffer.append(f9921c[i2 + 3]);
                if (i3 > 0) {
                    stringBuffer.append(i3);
                    stringBuffer.append(f9921c[i2 + 2]);
                }
            }
        }
    }

    public static String a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        a(i, i2, stringBuffer);
        return stringBuffer.toString();
    }
}
