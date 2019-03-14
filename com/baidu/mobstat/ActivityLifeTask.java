package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.am;
import com.baidu.mobstat.bc;
/* loaded from: classes6.dex */
public class ActivityLifeTask {
    private static boolean a = false;
    private static ActivityLifeObserver.IActivityLifeCallback b;
    private static ActivityLifeObserver.IActivityLifeCallback c;
    private static ActivityLifeObserver.IActivityLifeCallback d;
    private static ActivityLifeObserver.IActivityLifeCallback e;

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (!a) {
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

    private static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            b = new AutoTrack.MyActivityLifeCallback(1);
            d = new am.a();
            c = new bc.a();
            e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }
}
