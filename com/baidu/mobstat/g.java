package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Date;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    private static Handler h;
    private Timer e;

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f817a = new HandlerThread("LogSenderThread");
    private static g i = new g();
    private boolean b = false;
    private SendStrategyEnum c = SendStrategyEnum.APP_START;
    private int d = 1;
    private int f = 0;
    private boolean g = false;

    private g() {
        f817a.start();
        h = new Handler(f817a.getLooper());
    }

    public static g a() {
        return i;
    }

    public SharedPreferences a(Context context) {
        return context.getSharedPreferences("__Baidu_Stat_SDK_SendRem", 0);
    }

    public void a(int i2) {
        if (i2 < 0 || i2 > 30) {
            return;
        }
        this.f = i2;
    }

    public void a(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        SharedPreferences.Editor edit = a(context).edit();
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.c = sendStrategyEnum;
            edit.putInt("sendLogtype", this.c.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                edit.putInt("timeinterval", 24);
            }
        } else if (i2 <= 0 || i2 > 24) {
            com.baidu.mobstat.a.b.b("setSendLogStrategy", "time_interval is invalid, new strategy does not work");
        } else {
            this.d = i2;
            this.c = SendStrategyEnum.SET_TIME_INTERVAL;
            edit.putInt("sendLogtype", this.c.ordinal());
            edit.putInt("timeinterval", this.d);
        }
        this.b = z;
        edit.putBoolean("onlywifi", this.b);
        com.baidu.mobstat.a.b.a("Mobads SDK", "sstype is:" + this.c.name() + " And time_interval is:" + this.d + " And m_only_wifi:" + this.b);
        edit.commit();
    }

    public void a(boolean z, Context context) {
        this.g = z;
        SharedPreferences.Editor edit = a(context).edit();
        edit.putBoolean("exceptionanalysisflag", this.g);
        com.baidu.mobstat.a.b.a("Mobads SDK", "APP_ANALYSIS_EXCEPTION is:" + this.g);
        edit.commit();
    }

    public void b(Context context) {
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        SharedPreferences.Editor edit = a(context).edit();
        try {
            String a2 = q.a(context, "BaiduMobAd_EXCEPTION_LOG");
            if (!a2.equals("")) {
                if (a2.equals("true")) {
                    e.a().a(context);
                    edit.putBoolean("exceptionanalysisflag", true);
                } else if (a2.equals("false")) {
                    edit.putBoolean("exceptionanalysisflag", false);
                }
            }
        } catch (Exception e) {
            com.baidu.mobstat.a.b.a(e);
        }
        try {
            String a3 = q.a(context, "BaiduMobAd_SEND_STRATEGY");
            if (!a3.equals("")) {
                if (a3.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    edit.putInt("sendLogtype", SendStrategyEnum.APP_START.ordinal());
                } else if (a3.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    edit.putInt("sendLogtype", SendStrategyEnum.ONCE_A_DAY.ordinal());
                    edit.putInt("timeinterval", 24);
                } else if (a3.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    edit.putInt("sendLogtype", SendStrategyEnum.SET_TIME_INTERVAL.ordinal());
                }
            }
        } catch (Exception e2) {
            com.baidu.mobstat.a.b.a(e2);
            sendStrategyEnum = sendStrategyEnum;
        }
        try {
            String a4 = q.a(context, "BaiduMobAd_TIME_INTERVAL");
            if (!a4.equals("")) {
                int parseInt = Integer.parseInt(a4);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    edit.putInt("timeinterval", parseInt);
                }
            }
        } catch (Exception e3) {
            com.baidu.mobstat.a.b.a(e3);
        }
        try {
            String a5 = q.a(context, "BaiduMobAd_ONLY_WIFI");
            if (!a5.equals("")) {
                if (a5.equals("true")) {
                    edit.putBoolean("onlywifi", true);
                } else if (a5.equals("false")) {
                    edit.putBoolean("onlywifi", false);
                }
            }
        } catch (Exception e4) {
            com.baidu.mobstat.a.b.a(e4);
        }
        edit.commit();
    }

    public void c(Context context) {
        h.post(new h(this, context));
    }

    public void d(Context context) {
        a(context).edit().putLong("lastsendtime", new Date().getTime()).commit();
    }

    public void e(Context context) {
        this.e = new Timer();
        this.e.schedule(new j(this, context), this.d * 3600000, this.d * 3600000);
    }
}
