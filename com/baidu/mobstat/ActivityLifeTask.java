package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8505a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8506b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8507c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8508d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8509e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8506b = new AutoTrack.MyActivityLifeCallback(1);
            f8508d = new af.a();
            f8507c = new av.a();
            f8509e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8505a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8506b);
            ActivityLifeObserver.instance().addObserver(f8508d);
            ActivityLifeObserver.instance().addObserver(f8507c);
            ActivityLifeObserver.instance().addObserver(f8509e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8505a = true;
        }
    }
}
