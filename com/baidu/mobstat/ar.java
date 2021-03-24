package com.baidu.mobstat;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.mobstat.MtjConfig;
/* loaded from: classes2.dex */
public class ar {
    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        at.a().a(feedTrackStrategy);
    }

    public static void b(Activity activity, boolean z) {
        if (!z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().b(activity);
    }

    public static void c(Activity activity, boolean z) {
        if (!z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().c(activity);
    }

    public static void a(Activity activity, boolean z) {
        if (!z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(activity);
    }

    public static void a(View view, Activity activity) {
        if (as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(view, activity);
    }

    public static void a(KeyEvent keyEvent) {
        if (as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(keyEvent);
    }

    public static void a(String str) {
        if (at.a().b()) {
            return;
        }
        at.a().a(str);
    }
}
