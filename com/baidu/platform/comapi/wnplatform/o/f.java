package com.baidu.platform.comapi.wnplatform.o;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3081a = {"m", "km", "米", "公里"};
    public static final String[] b = {"m", "h", "分钟", "小时"};
    public static final String[] c = {"m", "h", "d", "分钟", "小时", "天"};

    /* loaded from: classes4.dex */
    public enum a {
        EN(0),
        ZH(1);
        
        private int c;

        a(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    public static void a(int i, a aVar, StringBuffer stringBuffer) {
        String str;
        int a2 = aVar.a();
        int i2 = a2 != 0 ? a2 + 1 : a2;
        if (i >= 1000) {
            if (i % 1000 == 0) {
                str = "%.0f%s";
            } else {
                str = "%.1f%s";
            }
            if (stringBuffer != null) {
                int i3 = i / 1000;
                if (i3 >= 100) {
                    stringBuffer.append(String.format("%d%s", Integer.valueOf(i3), f3081a[i2 + 1]));
                } else {
                    stringBuffer.append(String.format(str, Double.valueOf(i / 1000.0d), f3081a[i2 + 1]));
                }
            }
        } else if (stringBuffer != null) {
            stringBuffer.append(String.format("%d%s", Integer.valueOf(i), f3081a[0 + i2]));
        }
    }

    public static void a(int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i3 = (i / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 24;
            int i4 = (i / 60) % 60;
            if (i < 3600) {
                stringBuffer.append(i4).append(c[i2 + 1]);
            } else if (i < 86400) {
                stringBuffer.append(i3).append(c[i2 + 2]);
                if (i4 > 0) {
                    stringBuffer.append(i4).append("分");
                }
            } else {
                stringBuffer.append(i / 86400).append(c[i2 + 3]);
                if (i3 > 0) {
                    stringBuffer.append(i3).append(c[i2 + 2]);
                }
            }
        }
    }

    public static String a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        a(i, i2, stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean a() {
        return false;
    }

    public static int b() {
        return 2;
    }

    public static int a(boolean z) {
        return 0;
    }
}
