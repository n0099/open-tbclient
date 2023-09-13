package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes3.dex */
public class YalogWrap {
    public static final String YALOGGER_CLASS_NAME = "com.baidu.yalog.Logger";
    public static final String YALOGGER_MANAGER_CLASS_NAME = "com.baidu.yalog.LoggerManager";
    public static final String YALOG_SPACE = "dumedia";
    public static final String YALOG_UBCID = "5529";
    public static volatile YalogWrap sInstance;
    public Method mYalogD;
    public Method mYalogE;
    public Method mYalogI;
    public Method mYalogV;
    public Method mYalogW;
    public Object mYalogger;

    public YalogWrap() {
        this.mYalogger = null;
        this.mYalogV = null;
        this.mYalogD = null;
        this.mYalogI = null;
        this.mYalogW = null;
        this.mYalogE = null;
        try {
            this.mYalogger = Class.forName(YALOGGER_MANAGER_CLASS_NAME).getDeclaredMethod("getLogger", String.class).invoke(null, YALOG_SPACE);
            Class<?> cls = Class.forName(YALOGGER_CLASS_NAME);
            this.mYalogV = cls.getDeclaredMethod("v", String.class, String.class, String.class);
            this.mYalogD = cls.getDeclaredMethod("d", String.class, String.class, String.class);
            this.mYalogI = cls.getDeclaredMethod("i", String.class, String.class, String.class);
            this.mYalogW = cls.getDeclaredMethod("w", String.class, String.class, String.class);
            this.mYalogE = cls.getDeclaredMethod("e", String.class, String.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static YalogWrap getInstance() {
        if (sInstance == null) {
            synchronized (YalogWrap.class) {
                if (sInstance == null) {
                    sInstance = new YalogWrap();
                }
            }
        }
        return sInstance;
    }

    public void writeYalog(int i, String str, String str2) {
        try {
            if (this.mYalogger != null) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i == 6 || i == 9) {
                                    this.mYalogE.invoke(this.mYalogger, YALOG_UBCID, str, str2);
                                }
                            } else {
                                this.mYalogW.invoke(this.mYalogger, YALOG_UBCID, str, str2);
                            }
                        } else {
                            this.mYalogI.invoke(this.mYalogger, YALOG_UBCID, str, str2);
                        }
                    } else {
                        this.mYalogD.invoke(this.mYalogger, YALOG_UBCID, str, str2);
                    }
                } else {
                    this.mYalogV.invoke(this.mYalogger, YALOG_UBCID, str, str2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
