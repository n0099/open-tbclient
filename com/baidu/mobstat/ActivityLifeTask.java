package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8317a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8318b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8319c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8320d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8321e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8318b = new AutoTrack.MyActivityLifeCallback(1);
            f8320d = new af.a();
            f8319c = new av.a();
            f8321e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8317a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8318b);
            ActivityLifeObserver.instance().addObserver(f8320d);
            ActivityLifeObserver.instance().addObserver(f8319c);
            ActivityLifeObserver.instance().addObserver(f8321e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8317a = true;
        }
    }
}
