package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes15.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3569a = false;

    /* renamed from: b  reason: collision with root package name */
    private static ActivityLifeObserver.IActivityLifeCallback f3570b;
    private static ActivityLifeObserver.IActivityLifeCallback c;
    private static ActivityLifeObserver.IActivityLifeCallback d;
    private static ActivityLifeObserver.IActivityLifeCallback e;

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (!f3569a) {
                a(context);
                ActivityLifeObserver.instance().clearObservers();
                ActivityLifeObserver.instance().addObserver(f3570b);
                ActivityLifeObserver.instance().addObserver(d);
                ActivityLifeObserver.instance().addObserver(c);
                ActivityLifeObserver.instance().addObserver(e);
                ActivityLifeObserver.instance().registerActivityLifeCallback(context);
                f3569a = true;
            }
        }
    }

    private static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f3570b = new AutoTrack.MyActivityLifeCallback(1);
            d = new af.a();
            c = new av.a();
            e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }
}
