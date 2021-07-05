package com.baidu.searchbox.floating.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.TypeCastException;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0006\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroid/content/Context;", "", "dp", "dpToPxByScale", "(Landroid/content/Context;I)I", "getNavBarHeight", "(Landroid/content/Context;)I", "getScreenHeight", "getScreenWidth", "getStatusBarHeight", "Landroid/view/WindowManager;", "getWindowManager", "(Landroid/content/Context;)Landroid/view/WindowManager;", "Landroid/content/BroadcastReceiver;", SocialConstants.PARAM_RECEIVER, "Landroid/content/IntentFilter;", CloudControlRequest.REQUEST_KEY_FILTER, "", "registerLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V", "Landroid/content/Intent;", "intent", "", "sendLocalBroadcast", "(Landroid/content/Context;Landroid/content/Intent;)Z", "unregisterLocalReceiver", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V", "lib-player-floating_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int dpToPxByScale(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i2)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            float f3 = 3.0f;
            if (f2 <= 2.5f || f2 > 3.0f) {
                f3 = displayMetrics.density;
            }
            return (int) ((f3 * i2) + 0.5f);
        }
        return invokeLI.intValue;
    }

    public static final int getNavBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? VideoSystemHelper.getNavigationBarHeight() : invokeL.intValue;
    }

    public static final int getScreenHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? VideoSystemHelper.getDisplayHeight() : invokeL.intValue;
    }

    public static final int getScreenWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? VideoSystemHelper.getDisplayWidth() : invokeL.intValue;
    }

    public static final int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? VideoSystemHelper.getStatusBarHeight() : invokeL.intValue;
    }

    public static final WindowManager getWindowManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                return (WindowManager) systemService;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        return (WindowManager) invokeL.objValue;
    }

    public static final void registerLocalReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, broadcastReceiver, intentFilter) == null) {
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static final boolean sendLocalBroadcast(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, intent)) == null) ? LocalBroadcastManager.getInstance(context).sendBroadcast(intent) : invokeLL.booleanValue;
    }

    public static final void unregisterLocalReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, broadcastReceiver) == null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
        }
    }
}
