package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.x;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
/* loaded from: classes15.dex */
public class y {
    private static Application l(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }

    @NonNull
    @MainThread
    public static x b(@NonNull FragmentActivity fragmentActivity) {
        return a(fragmentActivity, null);
    }

    @NonNull
    @MainThread
    public static x a(@NonNull FragmentActivity fragmentActivity, @Nullable x.b bVar) {
        Application l = l(fragmentActivity);
        if (bVar == null) {
            bVar = x.a.c(l);
        }
        return new x(ab.c(fragmentActivity), bVar);
    }
}
