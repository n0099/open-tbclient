package com.baidu.mobstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.tbadk.TbadkApplication;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    private static Handler i;
    private Timer e;
    private WeakReference<Context> h;
    private static HandlerThread a = new HandlerThread("LogSenderThread");
    private static k j = new k();
    private boolean b = false;
    private SendStrategyEnum c = SendStrategyEnum.APP_START;
    private int d = 1;
    private int f = 0;
    private boolean g = false;

    private k() {
        a.start();
        i = new Handler(a.getLooper());
    }

    public static k a() {
        return j;
    }

    private void e(Context context) {
        if (context == null) {
            com.baidu.mobstat.a.e.a("sdkstat", "initContext context=" + ((Object) null));
        }
        if (this.h != null || context == null) {
            return;
        }
        this.h = new WeakReference<>(context);
    }

    public void a(int i2) {
        if (i2 < 0 || i2 > 30) {
            return;
        }
        this.f = i2;
    }

    public void a(Context context) {
        e(context);
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            String a2 = y.a(context, "BaiduMobAd_EXCEPTION_LOG");
            if (!a2.equals("")) {
                if (a2.equals("true")) {
                    i.a().a(context);
                    BasicStoreTools.getInstance().setExceptionTurn(context, true);
                } else if (a2.equals("false")) {
                    BasicStoreTools.getInstance().setExceptionTurn(context, false);
                }
            }
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a(e);
        }
        try {
            String a3 = y.a(context, "BaiduMobAd_SEND_STRATEGY");
            if (!a3.equals("")) {
                if (a3.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    BasicStoreTools.getInstance().setSendStrategy(context, sendStrategyEnum.ordinal());
                } else if (a3.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    BasicStoreTools.getInstance().setSendStrategy(context, sendStrategyEnum.ordinal());
                    BasicStoreTools.getInstance().setSendStrategyTime(context, 24);
                } else if (a3.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    BasicStoreTools.getInstance().setSendStrategy(context, sendStrategyEnum.ordinal());
                }
            }
        } catch (Exception e2) {
            com.baidu.mobstat.a.e.a(e2);
            sendStrategyEnum = sendStrategyEnum;
        }
        try {
            String a4 = y.a(context, "BaiduMobAd_TIME_INTERVAL");
            if (!a4.equals("")) {
                int parseInt = Integer.parseInt(a4);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    BasicStoreTools.getInstance().setSendStrategyTime(context, parseInt);
                }
            }
        } catch (Exception e3) {
            com.baidu.mobstat.a.e.a(e3);
        }
        try {
            String a5 = y.a(context, "BaiduMobAd_ONLY_WIFI");
            if (a5.equals("")) {
                return;
            }
            if (a5.equals("true")) {
                BasicStoreTools.getInstance().setOnlyWifi(context, true);
            } else if (a5.equals("false")) {
                BasicStoreTools.getInstance().setOnlyWifi(context, false);
            }
        } catch (Exception e4) {
            com.baidu.mobstat.a.e.a(e4);
        }
    }

    public void a(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.c = sendStrategyEnum;
            BasicStoreTools.getInstance().setSendStrategy(context, this.c.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                BasicStoreTools.getInstance().setSendStrategyTime(context, 24);
            }
        } else if (i2 <= 0 || i2 > 24) {
            com.baidu.mobstat.a.e.c("setSendLogStrategy", "time_interval is invalid, new strategy does not work");
        } else {
            this.d = i2;
            this.c = SendStrategyEnum.SET_TIME_INTERVAL;
            BasicStoreTools.getInstance().setSendStrategy(context, this.c.ordinal());
            BasicStoreTools.getInstance().setSendStrategyTime(context, this.d);
        }
        this.b = z;
        BasicStoreTools.getInstance().setOnlyWifi(context, this.b);
        com.baidu.mobstat.a.e.a("sdkstat", "sstype is:" + this.c.name() + " And time_interval is:" + this.d + " And m_only_wifi:" + this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, boolean z) {
        if (z) {
            try {
                if (!((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
                    com.baidu.mobstat.a.e.a("statsdk", "sendLogData() does not send because of only_wifi setting");
                    return;
                }
            } catch (Exception e) {
                com.baidu.mobstat.a.e.a("statsdk", "sendLogData exception when get wifimanager");
                return;
            }
        }
        DataCore.getInstance().sendLogData(context);
    }

    public void a(boolean z, Context context) {
        e(context);
        this.g = z;
        com.baidu.mobstat.a.e.a("sdkstat", "APP_ANALYSIS_EXCEPTION is:" + this.g);
        BasicStoreTools.getInstance().setExceptionTurn(context, this.g);
    }

    public void b(Context context) {
        e(context);
        if (context == null && this.h.get() != null) {
            context = this.h.get();
        }
        i.post(new l(this, context));
    }

    public void c(Context context) {
        BasicStoreTools.getInstance().setLastSendTime(context, new Date().getTime());
    }

    public void d(Context context) {
        this.e = new Timer();
        this.e.schedule(new n(this, context), this.d * TbadkApplication.APP_ENTER_FORE_SEND_PV_INTERNAL, this.d * TbadkApplication.APP_ENTER_FORE_SEND_PV_INTERNAL);
    }
}
