package com.baidu.searchbox.floating.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.tencent.open.SocialConstants;
import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes15.dex */
public final class UtilsKt {
    public static final WindowManager getWindowManager(Context context) {
        p.o(context, "$receiver");
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        return (WindowManager) systemService;
    }

    public static final int getScreenHeight(Context context) {
        p.o(context, "$receiver");
        return VideoSystemHelper.getDisplayHeight();
    }

    public static final int getScreenWidth(Context context) {
        p.o(context, "$receiver");
        return VideoSystemHelper.getDisplayWidth();
    }

    public static final int getNavBarHeight(Context context) {
        p.o(context, "$receiver");
        return VideoSystemHelper.getNavigationBarHeight();
    }

    public static final int getStatusBarHeight(Context context) {
        p.o(context, "$receiver");
        return VideoSystemHelper.getStatusBarHeight();
    }

    public static final boolean sendLocalBroadcast(Context context, Intent intent) {
        p.o(context, "$receiver");
        p.o(intent, "intent");
        return LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public static final void registerLocalReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        p.o(context, "$receiver");
        p.o(broadcastReceiver, SocialConstants.PARAM_RECEIVER);
        p.o(intentFilter, FilterImageAction.ACTION_NAME);
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
    }

    public static final void unregisterLocalReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        p.o(context, "$receiver");
        p.o(broadcastReceiver, SocialConstants.PARAM_RECEIVER);
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
    }

    public static final int dpToPxByScale(Context context, int i) {
        float f = 3.0f;
        p.o(context, "$receiver");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.density <= 2.5f || displayMetrics.density > 3.0f) {
            f = displayMetrics.density;
        }
        return (int) ((f * i) + 0.5f);
    }
}
