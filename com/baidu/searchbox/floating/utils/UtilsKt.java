package com.baidu.searchbox.floating.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.x;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0006\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroid/content/Context;", "", x.w, "dpToPxByScale", "(Landroid/content/Context;I)I", "getNavBarHeight", "(Landroid/content/Context;)I", "getScreenHeight", "getScreenWidth", "getStatusBarHeight", "Landroid/view/WindowManager;", "getWindowManager", "(Landroid/content/Context;)Landroid/view/WindowManager;", "Landroid/content/BroadcastReceiver;", SocialConstants.PARAM_RECEIVER, "Landroid/content/IntentFilter;", CloudControlRequest.REQUEST_KEY_FILTER, "", "registerLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V", "Landroid/content/Intent;", "intent", "", "sendLocalBroadcast", "(Landroid/content/Context;Landroid/content/Intent;)Z", "unregisterLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V", "floating-view_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class UtilsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int dpToPxByScale(Context dpToPxByScale, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, dpToPxByScale, i2)) == null) {
            Intrinsics.checkNotNullParameter(dpToPxByScale, "$this$dpToPxByScale");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager(dpToPxByScale).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            float f3 = 3.0f;
            if (f2 <= 2.5f || f2 > 3.0f) {
                f3 = displayMetrics.density;
            }
            return (int) ((f3 * i2) + 0.5f);
        }
        return invokeLI.intValue;
    }

    public static final int getNavBarHeight(Context getNavBarHeight) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, getNavBarHeight)) == null) {
            Intrinsics.checkNotNullParameter(getNavBarHeight, "$this$getNavBarHeight");
            return VideoSystemHelper.getNavigationBarHeight();
        }
        return invokeL.intValue;
    }

    public static final int getScreenHeight(Context getScreenHeight) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, getScreenHeight)) == null) {
            Intrinsics.checkNotNullParameter(getScreenHeight, "$this$getScreenHeight");
            return VideoSystemHelper.getDisplayHeight();
        }
        return invokeL.intValue;
    }

    public static final int getScreenWidth(Context getScreenWidth) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, getScreenWidth)) == null) {
            Intrinsics.checkNotNullParameter(getScreenWidth, "$this$getScreenWidth");
            return VideoSystemHelper.getDisplayWidth();
        }
        return invokeL.intValue;
    }

    public static final int getStatusBarHeight(Context getStatusBarHeight) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, getStatusBarHeight)) == null) {
            Intrinsics.checkNotNullParameter(getStatusBarHeight, "$this$getStatusBarHeight");
            return VideoSystemHelper.getStatusBarHeight();
        }
        return invokeL.intValue;
    }

    public static final WindowManager getWindowManager(Context getWindowManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, getWindowManager)) == null) {
            Intrinsics.checkNotNullParameter(getWindowManager, "$this$getWindowManager");
            Object systemService = getWindowManager.getSystemService("window");
            if (systemService != null) {
                return (WindowManager) systemService;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        return (WindowManager) invokeL.objValue;
    }

    public static final void registerLocalReceiver(Context registerLocalReceiver, BroadcastReceiver receiver, IntentFilter filter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, registerLocalReceiver, receiver, filter) == null) {
            Intrinsics.checkNotNullParameter(registerLocalReceiver, "$this$registerLocalReceiver");
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            Intrinsics.checkNotNullParameter(filter, "filter");
            LocalBroadcastManager.getInstance(registerLocalReceiver).registerReceiver(receiver, filter);
        }
    }

    public static final boolean sendLocalBroadcast(Context sendLocalBroadcast, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, sendLocalBroadcast, intent)) == null) {
            Intrinsics.checkNotNullParameter(sendLocalBroadcast, "$this$sendLocalBroadcast");
            Intrinsics.checkNotNullParameter(intent, "intent");
            return LocalBroadcastManager.getInstance(sendLocalBroadcast).sendBroadcast(intent);
        }
        return invokeLL.booleanValue;
    }

    public static final void unregisterLocalReceiver(Context unregisterLocalReceiver, BroadcastReceiver receiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, unregisterLocalReceiver, receiver) == null) {
            Intrinsics.checkNotNullParameter(unregisterLocalReceiver, "$this$unregisterLocalReceiver");
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            LocalBroadcastManager.getInstance(unregisterLocalReceiver).unregisterReceiver(receiver);
        }
    }
}
