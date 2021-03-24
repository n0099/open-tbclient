package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8637a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8638b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8639c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8640d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8641e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8638b = new AutoTrack.MyActivityLifeCallback(1);
            f8640d = new af.a();
            f8639c = new av.a();
            f8641e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8637a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8638b);
            ActivityLifeObserver.instance().addObserver(f8640d);
            ActivityLifeObserver.instance().addObserver(f8639c);
            ActivityLifeObserver.instance().addObserver(f8641e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8637a = true;
        }
    }
}
