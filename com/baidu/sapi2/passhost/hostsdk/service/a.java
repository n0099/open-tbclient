package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.base.utils.AlarmerUtil;
import com.baidu.sapi2.base.utils.DateTimeUtil;
import com.baidu.sapi2.base.utils.NetworkUtil;
import com.baidu.sapi2.passhost.hostsdk.service.c;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends IEventCenterService {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    private static final String h = "EventCenterService";
    private Object i;
    private TimingReceiver j;
    private Context k;
    private volatile boolean l;
    private boolean m;
    private Apn.IOnChange n;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sapi2.passhost.hostsdk.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0087a {
        public static a a = new a();

        private C0087a() {
        }
    }

    public static a a() {
        return C0087a.a;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(Context context) {
        if (this.k == null) {
            this.k = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TimingReceiver.b);
            this.j = new TimingReceiver();
            if (this.m) {
                AlarmerUtil.addAlarm(context, TimingReceiver.b, 7, 1);
            } else {
                AlarmerUtil.addAlarm(context, TimingReceiver.a, 10, 1);
                intentFilter.addAction(TimingReceiver.a);
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                b.a().a(this.n);
            }
            context.registerReceiver(this.j, intentFilter);
        }
    }

    private a() {
        this.i = new Object();
        this.n = new Apn.IOnChange() { // from class: com.baidu.sapi2.passhost.hostsdk.service.a.1
            @Override // com.baidu.sapi2.base.network.Apn.IOnChange
            public void onNetworkChange(byte b2, int i, int i2, String str) {
                Log.d(a.h, "networkType", Byte.valueOf(b2), "entValue", Integer.valueOf(i), "apnNameValue", Integer.valueOf(i2), "apnNameDri", str);
                a.this.notify(null, 1, Byte.valueOf(b2), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (NetworkUtil.isNetworkAvaliable(a.this.k)) {
                    a.this.notify(null, 2, Byte.valueOf(b2), Integer.valueOf(i), Integer.valueOf(i2), str);
                }
                switch (b2) {
                    case 1:
                        a.this.notify(null, 4, new Object[0]);
                        break;
                    case 2:
                        a.this.notify(null, 5, new Object[0]);
                        break;
                    case 3:
                        a.this.notify(null, 3, new Object[0]);
                        break;
                }
                a.this.a(1);
            }
        };
    }

    public void a(final int i) {
        Log.d(h, "handleRevivePoint()", "reviveType", Integer.valueOf(i));
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.passhost.hostsdk.service.a.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.i) {
                    if (i == 0) {
                        a.this.l = true;
                        a.this.notify(null, 10001, new Object[0]);
                    }
                    if (2 == i) {
                        a.this.notify(null, 10002, new Object[0]);
                    }
                    if (3 == i) {
                        a.this.notify(null, 30, new Object[0]);
                    }
                    if (4 == i) {
                        a.this.notify(null, 31, new Object[0]);
                    }
                    if (5 == i) {
                        a.this.notify(null, 32, new Object[0]);
                    }
                    if (a.this.l) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ISpManagerService.ISPer sPer = d.a().getSPer(c.b.a, 0);
                        long j = sPer.getLong(c.a.a);
                        long j2 = sPer.getLong(c.a.b);
                        long j3 = sPer.getLong(c.a.c);
                        long j4 = sPer.getLong(c.a.d);
                        long j5 = sPer.getLong(c.a.e);
                        long j6 = sPer.getLong(c.a.f);
                        int hourDiff = DateTimeUtil.getHourDiff(currentTimeMillis, j);
                        Log.d(a.h, "count1Hour", Integer.valueOf(hourDiff));
                        if (hourDiff >= 1) {
                            sPer.putLong(c.a.a, currentTimeMillis, true);
                            a.this.notify(null, 11, new Object[0]);
                        }
                        int hourDiff2 = DateTimeUtil.getHourDiff(currentTimeMillis, j2);
                        Log.d(a.h, "count1", Integer.valueOf(hourDiff2));
                        if (hourDiff2 >= 24) {
                            sPer.putLong(c.a.b, currentTimeMillis, true);
                            a.this.notify(null, 12, new Object[0]);
                        }
                        int hourDiff3 = DateTimeUtil.getHourDiff(currentTimeMillis, j3);
                        Log.d(a.h, "count3", Integer.valueOf(hourDiff3));
                        if (hourDiff3 >= 72) {
                            sPer.putLong(c.a.c, currentTimeMillis, true);
                            a.this.notify(null, 13, new Object[0]);
                        }
                        int hourDiff4 = DateTimeUtil.getHourDiff(currentTimeMillis, j4);
                        Log.d(a.h, "count7", Integer.valueOf(hourDiff4));
                        if (hourDiff4 >= 168) {
                            sPer.putLong(c.a.d, currentTimeMillis, true);
                            a.this.notify(null, 14, new Object[0]);
                        }
                        int hourDiff5 = DateTimeUtil.getHourDiff(currentTimeMillis, j5);
                        Log.d(a.h, "count1m", Integer.valueOf(hourDiff5));
                        if (hourDiff5 >= 744) {
                            sPer.putLong(c.a.e, currentTimeMillis, true);
                            a.this.notify(null, 15, new Object[0]);
                        }
                        int hourDiff6 = DateTimeUtil.getHourDiff(currentTimeMillis, j6);
                        Log.d(a.h, "count3m", Integer.valueOf(hourDiff6));
                        if (hourDiff6 >= 2232) {
                            sPer.putLong(c.a.f, currentTimeMillis, true);
                            a.this.notify(null, 16, new Object[0]);
                        }
                    }
                }
            }
        }, "handleRevivePoint"));
    }

    public static boolean b(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.BaiduMap(.*)");
        for (String str : arrayList) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }
}
