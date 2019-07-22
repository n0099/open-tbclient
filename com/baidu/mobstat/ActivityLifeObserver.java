package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class ActivityLifeObserver {
    private static final ActivityLifeObserver b = new ActivityLifeObserver();
    private boolean a;
    private Set<IActivityLifeCallback> c = new LinkedHashSet();

    /* loaded from: classes6.dex */
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
        return b;
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.c) {
            this.c.add(iActivityLifeCallback);
        }
    }

    public void clearObservers() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.c) {
            this.c.remove(iActivityLifeCallback);
        }
    }

    public void registerActivityLifeCallback(Context context) {
        if (!this.a && Build.VERSION.SDK_INT >= 14) {
            doRegister(context);
            this.a = true;
        }
    }

    @TargetApi(14)
    public void doRegister(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.mobstat.ActivityLifeObserver.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityResumed(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityPaused(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityCreated(activity, bundle);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityStarted(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityStopped(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivitySaveInstanceState(activity, bundle);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.c) {
                        for (IActivityLifeCallback iActivityLifeCallback : ActivityLifeObserver.this.c) {
                            iActivityLifeCallback.onActivityDestroyed(activity);
                        }
                    }
                }
            });
        } catch (Exception e) {
            bc.c().a("registerActivityLifecycleCallbacks encounter exception");
        }
    }
}
