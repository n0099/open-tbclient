package com.baidu.platform.comapi.wnplatform.o;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f10287a = {"m", "km", "米", "公里"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f10288b = {"m", "h", "分钟", "小时"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f10289c = {"m", "h", "d", "分钟", "小时", "天"};

    /* loaded from: classes2.dex */
    public enum a {
        EN(0),
        ZH(1);
        

        /* renamed from: c  reason: collision with root package name */
        public int f10293c;

        a(int i2) {
            this.f10293c = i2;
        }

        public int a() {
            return this.f10293c;
        }
    }

    public static int a(boolean z) {
        return 0;
    }

    public static void a(int i2, a aVar, StringBuffer stringBuffer) {
        int a2 = aVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i2 < 1000) {
            if (stringBuffer != null) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i2), f10287a[a2 + 0]));
                return;
            }
            return;
        }
        String str = i2 % 1000 == 0 ? "%.0f%s" : "%.1f%s";
        if (stringBuffer != null) {
            int i3 = i2 / 1000;
            if (i3 >= 100) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i3), f10287a[a2 + 1]));
            } else {
                stringBuffer.append(String.format(str, Double.valueOf(i2 / 1000.0d), f10287a[a2 + 1]));
            }
        }
    }

    public static boolean a() {
        return false;
    }

    public static int b() {
        return 2;
    }

    public static void a(int i2, int i3, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i2 < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i4 = (i2 / 3600) % 24;
            int i5 = (i2 / 60) % 60;
            if (i2 < 3600) {
                stringBuffer.append(i5);
                stringBuffer.append(f10289c[i3 + 1]);
            } else if (i2 < 86400) {
                stringBuffer.append(i4);
                stringBuffer.append(f10289c[i3 + 2]);
                if (i5 > 0) {
                    stringBuffer.append(i5);
                    stringBuffer.append("分");
                }
            } else {
                stringBuffer.append(i2 / 86400);
                stringBuffer.append(f10289c[i3 + 3]);
                if (i4 > 0) {
                    stringBuffer.append(i4);
                    stringBuffer.append(f10289c[i3 + 2]);
                }
            }
        }
    }

    public static String a(int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        a(i2, i3, stringBuffer);
        return stringBuffer.toString();
    }
}
