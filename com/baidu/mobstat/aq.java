package com.baidu.mobstat;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.mobstat.MtjConfig;
/* loaded from: classes2.dex */
public class aq {
    public static void a(Activity activity, boolean z) {
        if (!z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(activity);
    }

    public static void b(Activity activity, boolean z) {
        if (!z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().b(activity);
    }

    public static void c(Activity activity, boolean z) {
        if (!z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().c(activity);
    }

    public static void a(KeyEvent keyEvent) {
        if (ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(keyEvent);
    }

    public static void a(View view2, Activity activity) {
        if (ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(view2, activity);
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        as.a().a(feedTrackStrategy);
    }

    public static void a(String str) {
        if (as.a().b()) {
            return;
        }
        as.a().a(str);
    }
}
