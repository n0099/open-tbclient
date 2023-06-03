package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes3.dex */
public class YalogWrap {
    public static volatile YalogWrap g;
    public Object a;
    public Method b;
    public Method c;
    public Method d;
    public Method e;
    public Method f;

    public YalogWrap() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        try {
            this.a = Class.forName("com.baidu.yalog.LoggerManager").getDeclaredMethod("getLogger", String.class).invoke(null, "dumedia");
            Class<?> cls = Class.forName("com.baidu.yalog.Logger");
            this.b = cls.getDeclaredMethod("v", String.class, String.class, String.class);
            this.c = cls.getDeclaredMethod("d", String.class, String.class, String.class);
            this.d = cls.getDeclaredMethod("i", String.class, String.class, String.class);
            this.e = cls.getDeclaredMethod("w", String.class, String.class, String.class);
            this.f = cls.getDeclaredMethod("e", String.class, String.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static YalogWrap getInstance() {
        if (g == null) {
            synchronized (YalogWrap.class) {
                if (g == null) {
                    g = new YalogWrap();
                }
            }
        }
        return g;
    }

    public void writeYalog(int i, String str, String str2) {
        try {
            if (this.a != null) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i == 6 || i == 9) {
                                    this.f.invoke(this.a, "5529", str, str2);
                                }
                            } else {
                                this.e.invoke(this.a, "5529", str, str2);
                            }
                        } else {
                            this.d.invoke(this.a, "5529", str, str2);
                        }
                    } else {
                        this.c.invoke(this.a, "5529", str, str2);
                    }
                } else {
                    this.b.invoke(this.a, "5529", str, str2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
