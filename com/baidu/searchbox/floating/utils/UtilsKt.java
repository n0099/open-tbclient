package com.baidu.searchbox.floating.utils;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.p0.u;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u001aB\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0018\u001a\u00020\u0006*\u00020\u0015\u001a\u0012\u0010\u0019\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001c\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001d\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001e\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010\u001f\u001a\u00020\u0001*\u00020 \u001a\n\u0010!\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010\"\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010#\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010$\u001a\u00020%*\u00020\u000e\u001a\u001a\u0010&\u001a\u00020\n*\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*\u001a\u0012\u0010+\u001a\u00020,*\u00020\u000e2\u0006\u0010-\u001a\u00020.\u001a\u0012\u0010/\u001a\u00020\n*\u00020\u000e2\u0006\u0010-\u001a\u00020.\u001a\u0012\u00100\u001a\u00020\n*\u00020\u000e2\u0006\u0010'\u001a\u00020(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"NOTIFICATION_CHANNEL_ID", "", "doubleTapAnimator", "Landroid/animation/ValueAnimator;", "startSize", "Lkotlin/Pair;", "", "endSize", "updateListener", "Lkotlin/Function2;", "", "getDefaultNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "icon", "channelId", "channelName", "title", "content", "buttonBottomMargin", "Landroid/view/View;", "buttonExtraPadding", "buttonHorizontalMargin", "buttonVerticalMargin", "dpToPxByScale", u.v, "floatingButtonHeight", "floatingButtonWidth", "floatingImageViewSize", "getNavBarHeight", "getScale", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "getScreenHeight", "getScreenWidth", "getStatusBarHeight", "getWindowManager", "Landroid/view/WindowManager;", "registerLocalReceiver", SocialConstants.PARAM_RECEIVER, "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "sendLocalBroadcast", "", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "unregisterLocalReceiver", "floating-view_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final String NOTIFICATION_CHANNEL_ID = "floating_bd_video";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            iArr[ScaleMode.S.ordinal()] = 1;
            iArr[ScaleMode.M.ordinal()] = 2;
            iArr[ScaleMode.L.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int buttonBottomMargin(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 26.0f);
    }

    public static final int buttonExtraPadding(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 6.0f);
    }

    public static final int buttonHorizontalMargin(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 5.0f);
    }

    public static final int buttonVerticalMargin(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 5.0f);
    }

    public static final int floatingButtonHeight(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 21.0f);
    }

    public static final int floatingButtonWidth(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 29.0f);
    }

    public static final int floatingImageViewSize(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return BdPlayerUtils.dp2px(view2, 20.0f);
    }

    public static final int getNavBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return VideoSystemHelper.getNavigationBarHeight();
    }

    public static final String getScale(ScaleMode scaleMode) {
        Intrinsics.checkNotNullParameter(scaleMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[scaleMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return "0";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public static final int getScreenHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return VideoSystemHelper.getDisplayHeight();
    }

    public static final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return VideoSystemHelper.getDisplayWidth();
    }

    public static final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return VideoSystemHelper.getStatusBarHeight();
    }

    public static final WindowManager getWindowManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public static final ValueAnimator doubleTapAnimator(Pair<Integer, Integer> startSize, Pair<Integer, Integer> endSize, final Function2<? super Integer, ? super Integer, Unit> updateListener) {
        Intrinsics.checkNotNullParameter(startSize, "startSize");
        Intrinsics.checkNotNullParameter(endSize, "endSize");
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        final ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("width", startSize.getFirst().intValue(), endSize.getFirst().intValue()), PropertyValuesHolder.ofInt("height", startSize.getSecond().intValue(), endSize.getSecond().intValue()));
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.qo1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    UtilsKt.m92doubleTapAnimator$lambda1$lambda0(ofPropertyValuesHolder, updateListener, valueAnimator);
                }
            }
        });
        ofPropertyValuesHolder.setDuration(400L);
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(p…     duration = 400\n    }");
        return ofPropertyValuesHolder;
    }

    /* renamed from: doubleTapAnimator$lambda-1$lambda-0  reason: not valid java name */
    public static final void m92doubleTapAnimator$lambda1$lambda0(ValueAnimator valueAnimator, Function2 updateListener, ValueAnimator valueAnimator2) {
        Intrinsics.checkNotNullParameter(updateListener, "$updateListener");
        Object animatedValue = valueAnimator.getAnimatedValue("width");
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            Object animatedValue2 = valueAnimator.getAnimatedValue("height");
            if (animatedValue2 != null) {
                updateListener.invoke(Integer.valueOf(intValue), Integer.valueOf(((Integer) animatedValue2).intValue()));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public static final int dpToPxByScale(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        float f2 = 3.0f;
        if (f <= 2.5f || f > 3.0f) {
            f2 = displayMetrics.density;
        }
        return (int) ((f2 * i) + 0.5f);
    }

    public static final boolean sendLocalBroadcast(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public static final void sendLocalBroadcastSync(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        LocalBroadcastManager.getInstance(context).sendBroadcastSync(intent);
    }

    public static final void unregisterLocalReceiver(Context context, BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }

    public static final Notification getDefaultNotification(Context context, int i, String channelId, String channelName, String title, String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        NotificationManager notificationManager = null;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, 1);
        Object systemService = context.getSystemService("notification");
        if (systemService instanceof NotificationManager) {
            notificationManager = (NotificationManager) systemService;
        }
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return new NotificationCompat.Builder(context, channelId).setContentTitle(title).setContentText(content).setAutoCancel(false).setSmallIcon(i).setPriority(1).build();
    }

    public static /* synthetic */ Notification getDefaultNotification$default(Context context, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = R.drawable.obfuscated_res_0x7f08026a;
        }
        if ((i2 & 4) != 0) {
            str = "floating_bd_video";
        }
        String str5 = str;
        if ((i2 & 8) != 0) {
            str2 = context.getString(R.string.obfuscated_res_0x7f0f108c);
            Intrinsics.checkNotNullExpressionValue(str2, "context.getString(R.stri…ing_notification_channel)");
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = context.getString(R.string.obfuscated_res_0x7f0f108e);
            Intrinsics.checkNotNullExpressionValue(str3, "context.getString(R.stri…ating_notification_title)");
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = context.getString(R.string.obfuscated_res_0x7f0f108d);
            Intrinsics.checkNotNullExpressionValue(str4, "context.getString(R.stri…ing_notification_content)");
        }
        return getDefaultNotification(context, i, str5, str6, str7, str4);
    }

    public static final void registerLocalReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(filter, "filter");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, filter);
    }
}
