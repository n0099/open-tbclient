package cn.jiguang.a.a.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import cn.jiguang.d.d.aa;
import cn.jiguang.d.d.o;
@TargetApi(14)
/* loaded from: classes3.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    private static boolean a = false;
    private static int b = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (cn.jiguang.a.a.jH != null) {
            cn.jiguang.a.a.jH.F(activity, "onCreate");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (cn.jiguang.a.a.jH != null) {
            cn.jiguang.a.a.jH.W(activity);
        }
        if (cn.jiguang.a.a.b) {
            return;
        }
        b.ba().b(activity);
        Context applicationContext = activity != null ? activity.getApplicationContext() : cn.jiguang.d.a.d;
        aa.a(applicationContext);
        aa.b(applicationContext);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (cn.jiguang.a.a.jH != null) {
            cn.jiguang.a.a.jH.V(activity);
        }
        if (cn.jiguang.a.a.b) {
            return;
        }
        b.ba().a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (b == 0 && activity != null) {
            o.a((Context) activity, false);
            cn.jiguang.api.e.d(activity.getApplicationContext(), 1);
        }
        b++;
        if (cn.jiguang.a.a.jH != null) {
            cn.jiguang.a.a.jH.F(activity, "onStart");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        b--;
    }
}
