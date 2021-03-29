package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8638a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8639b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8640c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8641d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8642e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8639b = new AutoTrack.MyActivityLifeCallback(1);
            f8641d = new af.a();
            f8640c = new av.a();
            f8642e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8638a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8639b);
            ActivityLifeObserver.instance().addObserver(f8641d);
            ActivityLifeObserver.instance().addObserver(f8640c);
            ActivityLifeObserver.instance().addObserver(f8642e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8638a = true;
        }
    }
}
