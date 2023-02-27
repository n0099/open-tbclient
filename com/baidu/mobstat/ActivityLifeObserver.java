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
    public static final ActivityLifeObserver c = new ActivityLifeObserver();
    public boolean a;
    public Application.ActivityLifecycleCallbacks b;
    public Set<IActivityLifeCallback> d = new LinkedHashSet();

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
        return c;
    }

    public void clearObservers() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.d) {
            this.d.add(iActivityLifeCallback);
        }
    }

    @TargetApi(14)
    public void doRegister(Context context) {
        this.b = new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.mobstat.ActivityLifeObserver.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityDestroyed(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityPaused(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityResumed(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityStarted(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityStopped(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivityCreated(activity, bundle);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                synchronized (ActivityLifeObserver.this.d) {
                    for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.d) {
                        iActivityLifeCallback.onActivitySaveInstanceState(activity, bundle);
                    }
                }
            }
        };
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.b);
        } catch (Exception unused) {
            bb.c().a("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    public void registerActivityLifeCallback(Context context) {
        if (this.a || Build.VERSION.SDK_INT < 14) {
            return;
        }
        doRegister(context);
        this.a = true;
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.d) {
            this.d.remove(iActivityLifeCallback);
        }
    }

    @TargetApi(14)
    public void unRegister(Context context) {
        try {
            ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
