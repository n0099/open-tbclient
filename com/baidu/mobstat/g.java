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
    private static HandlerThread a = new HandlerThread("LogSenderThread");
    private static g i = new g();
    private boolean b = false;
    private SendStrategyEnum c = SendStrategyEnum.APP_START;
    private int d = 1;
    private int f = 0;
    private boolean g = false;

    private g() {
        a.start();
        h = new Handler(a.getLooper());
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00d3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:? */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|2|3|(2:5|(1:7)(2:8|(1:10)))|11|12|(11:14|15|(2:17|18)(2:45|(2:47|48)(2:49|(1:51)))|19|20|(2:22|(1:26))|28|29|(2:31|(1:33)(2:34|(1:36)))|37|38)|54|19|20|(0)|28|29|(0)|37|38|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f6, code lost:
        com.baidu.mobstat.a.b.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0109, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010a, code lost:
        com.baidu.mobstat.a.b.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: Exception -> 0x00f5, TryCatch #3 {Exception -> 0x00f5, blocks: (B:14:0x0056, B:16:0x0064, B:20:0x0078), top: B:59:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b A[Catch: Exception -> 0x0109, TryCatch #2 {Exception -> 0x0109, blocks: (B:21:0x007d, B:23:0x008b, B:25:0x0093, B:47:0x00fa, B:49:0x0102), top: B:58:0x007d }] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.baidu.mobstat.SendStrategyEnum] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ad -> B:55:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d4 -> B:59:0x0056). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context) {
        SendStrategyEnum sendStrategyEnum;
        Exception e;
        String a2;
        String a3;
        SendStrategyEnum sendStrategyEnum2 = SendStrategyEnum.APP_START;
        SharedPreferences.Editor edit = a(context).edit();
        try {
            String a4 = q.a(context, "BaiduMobAd_EXCEPTION_LOG");
            if (!a4.equals("")) {
                if (a4.equals("true")) {
                    e.a().a(context);
                    edit.putBoolean("exceptionanalysisflag", true);
                } else if (a4.equals("false")) {
                    edit.putBoolean("exceptionanalysisflag", false);
                }
            }
        } catch (Exception e2) {
            com.baidu.mobstat.a.b.a(e2);
        }
        try {
            sendStrategyEnum = q.a(context, "BaiduMobAd_SEND_STRATEGY");
        } catch (Exception e3) {
            sendStrategyEnum = sendStrategyEnum2;
            e = e3;
            com.baidu.mobstat.a.b.a(e);
            sendStrategyEnum = sendStrategyEnum;
            a3 = q.a(context, "BaiduMobAd_TIME_INTERVAL");
            if (!a3.equals("")) {
            }
            a2 = q.a(context, "BaiduMobAd_ONLY_WIFI");
            if (!a2.equals("")) {
            }
            edit.commit();
        }
        if (!sendStrategyEnum.equals("")) {
            try {
                if (sendStrategyEnum.equals(SendStrategyEnum.APP_START.name())) {
                    SendStrategyEnum sendStrategyEnum3 = SendStrategyEnum.APP_START;
                    edit.putInt("sendLogtype", SendStrategyEnum.APP_START.ordinal());
                    sendStrategyEnum = sendStrategyEnum3;
                } else if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    SendStrategyEnum sendStrategyEnum4 = SendStrategyEnum.ONCE_A_DAY;
                    edit.putInt("sendLogtype", SendStrategyEnum.ONCE_A_DAY.ordinal());
                    edit.putInt("timeinterval", 24);
                    sendStrategyEnum = sendStrategyEnum4;
                } else if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum2 = SendStrategyEnum.SET_TIME_INTERVAL;
                    edit.putInt("sendLogtype", SendStrategyEnum.SET_TIME_INTERVAL.ordinal());
                }
            } catch (Exception e4) {
                e = e4;
                com.baidu.mobstat.a.b.a(e);
                sendStrategyEnum = sendStrategyEnum;
                a3 = q.a(context, "BaiduMobAd_TIME_INTERVAL");
                if (!a3.equals("")) {
                }
                a2 = q.a(context, "BaiduMobAd_ONLY_WIFI");
                if (!a2.equals("")) {
                }
                edit.commit();
            }
            a3 = q.a(context, "BaiduMobAd_TIME_INTERVAL");
            if (!a3.equals("")) {
                int parseInt = Integer.parseInt(a3);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    edit.putInt("timeinterval", parseInt);
                }
            }
            a2 = q.a(context, "BaiduMobAd_ONLY_WIFI");
            if (!a2.equals("")) {
                if (a2.equals("true")) {
                    edit.putBoolean("onlywifi", true);
                } else if (a2.equals("false")) {
                    edit.putBoolean("onlywifi", false);
                }
            }
            edit.commit();
        }
        sendStrategyEnum = sendStrategyEnum2;
        a3 = q.a(context, "BaiduMobAd_TIME_INTERVAL");
        if (!a3.equals("")) {
        }
        a2 = q.a(context, "BaiduMobAd_ONLY_WIFI");
        if (!a2.equals("")) {
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
