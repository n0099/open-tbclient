package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes7.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2462a = false;
    private static ActivityLifeObserver.IActivityLifeCallback b;
    private static ActivityLifeObserver.IActivityLifeCallback c;
    private static ActivityLifeObserver.IActivityLifeCallback d;
    private static ActivityLifeObserver.IActivityLifeCallback e;

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (!f2462a) {
                a(context);
                ActivityLifeObserver.instance().clearObservers();
                ActivityLifeObserver.instance().addObserver(b);
                ActivityLifeObserver.instance().addObserver(d);
                ActivityLifeObserver.instance().addObserver(c);
                ActivityLifeObserver.instance().addObserver(e);
                ActivityLifeObserver.instance().registerActivityLifeCallback(context);
                f2462a = true;
            }
        }
    }

    private static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            b = new AutoTrack.MyActivityLifeCallback(1);
            d = new af.a();
            c = new av.a();
            e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }
}
