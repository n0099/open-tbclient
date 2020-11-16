package com.baidu.searchbox.floating.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.tencent.open.SocialConstants;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes9.dex */
public final class UtilsKt {
    public static final WindowManager getWindowManager(Context context) {
        q.n(context, "$receiver");
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        return (WindowManager) systemService;
    }

    public static final int getScreenHeight(Context context) {
        q.n(context, "$receiver");
        return VideoSystemHelper.getDisplayHeight();
    }

    public static final int getScreenWidth(Context context) {
        q.n(context, "$receiver");
        return VideoSystemHelper.getDisplayWidth();
    }

    public static final int getNavBarHeight(Context context) {
        q.n(context, "$receiver");
        return VideoSystemHelper.getNavigationBarHeight();
    }

    public static final int getStatusBarHeight(Context context) {
        q.n(context, "$receiver");
        return VideoSystemHelper.getStatusBarHeight();
    }

    public static final boolean sendLocalBroadcast(Context context, Intent intent) {
        q.n(context, "$receiver");
        q.n(intent, "intent");
        return LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public static final void registerLocalReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        q.n(context, "$receiver");
        q.n(broadcastReceiver, SocialConstants.PARAM_RECEIVER);
        q.n(intentFilter, FilterImageAction.ACTION_NAME);
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
    }

    public static final void unregisterLocalReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        q.n(context, "$receiver");
        q.n(broadcastReceiver, SocialConstants.PARAM_RECEIVER);
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
    }

    public static final int dpToPxByScale(Context context, int i) {
        float f = 3.0f;
        q.n(context, "$receiver");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.density <= 2.5f || displayMetrics.density > 3.0f) {
            f = displayMetrics.density;
        }
        return (int) ((f * i) + 0.5f);
    }
}
