package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ActivityLifeObserver {

    /* renamed from: b  reason: collision with root package name */
    public static final ActivityLifeObserver f8633b = new ActivityLifeObserver();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8634a;

    /* renamed from: c  reason: collision with root package name */
    public Set<IActivityLifeCallback> f8635c = new LinkedHashSet();

    /* loaded from: classes2.dex */
    public interface IActivityLifeCallback {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public static ActivityLifeObserver instance() {
        return f8633b;
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.f8635c) {
            this.f8635c.add(iActivityLifeCallback);
        }
    }

    public void clearObservers() {
        synchronized (this.f8635c) {
            this.f8635c.clear();
        }
    }

    @TargetApi(14)
    public void doRegister(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.mobstat.ActivityLifeObserver.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityCreated(activity, bundle);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityDestroyed(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityPaused(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityResumed(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivitySaveInstanceState(activity, bundle);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityStarted(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f8635c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.f8635c) {
                            iActivityLifeCallback.onActivityStopped(activity);
                        }
                    }
                }
            });
        } catch (Exception unused) {
            bc.c().a("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    public void registerActivityLifeCallback(Context context) {
        if (!this.f8634a && Build.VERSION.SDK_INT >= 14) {
            doRegister(context);
            this.f8634a = true;
        }
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.f8635c) {
            this.f8635c.remove(iActivityLifeCallback);
        }
    }
}
