package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u0000*\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0000*\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u0000*\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\f*\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0017*\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001b\u001a\u00020\u0017*\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", TypeAdapters.AnonymousClass27.SECOND, "", "hours", "", "getTextWithSecond", "(IZ)Ljava/lang/String;", "content", "fallback", "parseIntSafe", "(Ljava/lang/String;I)I", "Landroid/view/View;", "", "dpValue", "dp2px", "(Landroid/view/View;F)I", "Landroid/content/Context;", "getMaxVolume", "(Landroid/content/Context;)I", "getVolume", "getVolumePercent", "(Landroid/content/Context;)F", "size", "", "setVolume", "(Landroid/content/Context;I)V", "percent", "setVolumePercent", "(Landroid/content/Context;F)V", "MSG_CONTROL_AUTO_HIDE", "I", "framework_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "BdPlayerUtils")
/* loaded from: classes4.dex */
public final class BdPlayerUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_CONTROL_AUTO_HIDE = 100;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int dp2px(View view, float f2) {
        InterceptResult invokeLF;
        Context context;
        Resources resources;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, view, f2)) == null) {
            return (int) ((f2 * ((view == null || (context = view.getContext()) == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density)) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static final int getMaxVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService("audio") : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static final String getTextWithSecond(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i < 0) {
                return "";
            }
            int i2 = i / 3600;
            int i3 = (i % 3600) / 60;
            int i4 = i % 60;
            if (i2 == 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
            return format2;
        }
        return (String) invokeCommon.objValue;
    }

    public static final int getVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService("audio") : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static final float getVolumePercent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService("audio") : null;
            if ((systemService instanceof AudioManager ? systemService : null) != null) {
                return MathKt__MathJVMKt.roundToInt((getVolume(context) / getMaxVolume(context)) * 10) / 10.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @JvmOverloads
    public static final int parseIntSafe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? parseIntSafe$default(str, 0, 2, null) : invokeL.intValue;
    }

    @JvmOverloads
    public static final int parseIntSafe(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            if (str == null || str.length() == 0) {
                return i;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                BdVideoLog.e("parseInt catch exception:", e2);
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static /* synthetic */ int parseIntSafe$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return parseIntSafe(str, i);
    }

    public static final void setVolume(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, context, i) == null) {
            Object systemService = context != null ? context.getSystemService("audio") : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i, 8);
            }
        }
    }

    public static final void setVolumePercent(Context context, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65545, null, context, f2) == null) {
            setVolume(context, MathKt__MathJVMKt.roundToInt(getMaxVolume(context) * f2));
        }
    }
}
