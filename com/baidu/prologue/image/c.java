package com.baidu.prologue.image;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
/* loaded from: classes9.dex */
public class c {
    public static RequestManager aQ(Context context) {
        if (context == null) {
            context = com.baidu.prologue.a.b.a.bKm.get().UK();
        } else if (Util.isOnMainThread() && !(context instanceof Application) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || y(activity)) {
                context = com.baidu.prologue.a.b.a.bKm.get().UK();
            }
        }
        return Glide.with(context);
    }

    private static boolean y(Activity activity) {
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }
}
