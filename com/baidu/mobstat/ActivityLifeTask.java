package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
/* loaded from: classes2.dex */
public class ActivityLifeTask {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8212a = false;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8213b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8214c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8215d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8216e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f8213b = new AutoTrack.MyActivityLifeCallback(1);
            f8215d = new af.a();
            f8214c = new av.a();
            f8216e = new AutoTrack.MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (f8212a) {
                return;
            }
            a(context);
            ActivityLifeObserver.instance().clearObservers();
            ActivityLifeObserver.instance().addObserver(f8213b);
            ActivityLifeObserver.instance().addObserver(f8215d);
            ActivityLifeObserver.instance().addObserver(f8214c);
            ActivityLifeObserver.instance().addObserver(f8216e);
            ActivityLifeObserver.instance().registerActivityLifeCallback(context);
            f8212a = true;
        }
    }
}
