package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.ad;
import com.baidu.mobstat.au;
/* loaded from: classes2.dex */
public class ActivityLifeTask {
    public static boolean a;
    public static ActivityLifeObserver.IActivityLifeCallback b;
    public static ActivityLifeObserver.IActivityLifeCallback c;
    public static ActivityLifeObserver.IActivityLifeCallback d;
    public static ActivityLifeObserver.IActivityLifeCallback e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            b = new AutoTrack.MyActivityLifeCallback(1);
            d = new ad.a();
            c = new au.a();
            e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(b);
            ActivityLifeObserver.instance().addObserver(d);
            ActivityLifeObserver.instance().addObserver(c);
            ActivityLifeObserver.instance().addObserver(e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            a = true;
        }
    }
}
