package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8217a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8218b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8219c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8220d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8221e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8218b = new AutoTrack.MyActivityLifeCallback(1);
            f8220d = new af.a();
            f8219c = new av.a();
            f8221e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8217a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8218b);
            ActivityLifeObserver.instance().addObserver(f8220d);
            ActivityLifeObserver.instance().addObserver(f8219c);
            ActivityLifeObserver.instance().addObserver(f8221e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8217a = true;
        }
    }
}
