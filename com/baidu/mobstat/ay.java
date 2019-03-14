package com.baidu.mobstat;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.mobstat.MtjConfig;
/* loaded from: classes6.dex */
public class ay {
    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        ba.a().a(feedTrackStrategy);
    }

    public static void a(Activity activity, boolean z) {
        if (z && !az.a().b() && !ba.a().b()) {
            ba.a().a(activity);
        }
    }

    public static void b(Activity activity, boolean z) {
        if (z && !az.a().b() && !ba.a().b()) {
            ba.a().b(activity);
        }
    }

    public static void c(Activity activity, boolean z) {
        if (z && !az.a().b() && !ba.a().b()) {
            ba.a().c(activity);
        }
    }

    public static void a(View view, Activity activity) {
        if (!az.a().b() && !ba.a().b()) {
            ba.a().a(view, activity);
        }
    }

    public static void a(KeyEvent keyEvent) {
        if (!az.a().b() && !ba.a().b()) {
            ba.a().a(keyEvent);
        }
    }

    public static void a(String str) {
        if (!ba.a().b()) {
            ba.a().a(str);
        }
    }
}
