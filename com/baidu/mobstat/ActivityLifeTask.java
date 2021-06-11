package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8279a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8280b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8281c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8282d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8283e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8280b = new AutoTrack.MyActivityLifeCallback(1);
            f8282d = new af.a();
            f8281c = new av.a();
            f8283e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8279a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8280b);
            ActivityLifeObserver.instance().addObserver(f8282d);
            ActivityLifeObserver.instance().addObserver(f8281c);
            ActivityLifeObserver.instance().addObserver(f8283e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8279a = true;
        }
    }
}
