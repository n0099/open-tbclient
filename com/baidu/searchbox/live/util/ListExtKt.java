package com.baidu.searchbox.live.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0002\u001a\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\"\u0017\u0010\u000f\u001a\u00020\u0000*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u000e\"\u0017\u0010\u0010\u001a\u00020\u0000*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000e\"\u0017\u0010\u0012\u001a\u00020\u0011*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0017\u0010\u0014\u001a\u00020\u0011*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"", "getDisplayHeight", "()I", "getDisplayWidth", "getPlayQualityScore", "Landroid/content/Context;", "context", "", "getStaticDeviceScore", "(Landroid/content/Context;)F", "Landroid/content/Intent;", "Lcom/baidu/searchbox/live/frame/IntentData;", "parseLiveData", "(Landroid/content/Intent;)Lcom/baidu/searchbox/live/frame/IntentData;", "(Landroid/content/Context;)I", "displayHeight", "displayWidth", "", "isDynamicDisplay", "(Landroid/content/Context;)Z", "isHwMagicWindows", "lib-live-mini-shell_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListExtKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int getDisplayHeight() {
        InterceptResult invokeV;
        Resources resources;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context appContext = MiniShellRuntime.INSTANCE.getAppContext();
            if (appContext != null && (resources = appContext.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static final int getDisplayWidth() {
        InterceptResult invokeV;
        Resources resources;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context appContext = MiniShellRuntime.INSTANCE.getAppContext();
            if (appContext != null && (resources = appContext.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static final int getPlayQualityScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return CyberPlayerManager.getDevicePlayQualityScore(MimeTypes.VIDEO_H265, 0, RecordConstants.VIDEO_CONSTANT_WIDTH_OLD, 960, null);
        }
        return invokeV.intValue;
    }

    public static final int getDisplayHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            return resources.getDisplayMetrics().heightPixels;
        }
        return invokeL.intValue;
    }

    public static final int getDisplayWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            return resources.getDisplayMetrics().widthPixels;
        }
        return invokeL.intValue;
    }

    public static final float getStaticDeviceScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
            if (appInfoService != null) {
                return appInfoService.getStaticDeviceScore(context);
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public static final boolean isDynamicDisplay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (!isHwMagicWindows(context) && !isHwMagicWindows(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean isHwMagicWindows(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            String configuration = resources.getConfiguration().toString();
            Intrinsics.checkExpressionValueIsNotNull(configuration, "resources.configuration.toString()");
            return StringsKt__StringsKt.contains$default((CharSequence) configuration, (CharSequence) "hw-magic-windows", false, 2, (Object) null);
        }
        return invokeL.booleanValue;
    }

    public static final IntentData parseLiveData(Intent intent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, intent)) == null) {
            String stringExtra = intent.getStringExtra("params");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = intent.getStringExtra("scheme");
            if (stringExtra2 == null) {
                str = "";
            } else {
                str = stringExtra2;
            }
            IntentData.SchemeModel parseSchemeData = IntentData.Companion.parseSchemeData(stringExtra);
            IntentData intentData = new IntentData(parseSchemeData.getRoomId(), parseSchemeData.getSource(), str, parseSchemeData, null, null, 48, null);
            intentData.setTransitionStatus(intent.getBooleanExtra("translucent", false) ? 1 : 0);
            return intentData;
        }
        return (IntentData) invokeL.objValue;
    }
}
