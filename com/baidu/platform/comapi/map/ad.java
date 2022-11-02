package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.map.OverlayItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class ad {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-626012035, "Lcom/baidu/platform/comapi/map/ad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-626012035, "Lcom/baidu/platform/comapi/map/ad;");
                return;
            }
        }
        int[] iArr = new int[OverlayItem.AnimationSubType.values().length];
        b = iArr;
        try {
            iArr[OverlayItem.AnimationSubType.RADAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[OverlayItem.AnimationSubType.NONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[OverlayItem.AnimEffect.values().length];
        a = iArr2;
        try {
            iArr2[OverlayItem.AnimEffect.GROWTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[OverlayItem.AnimEffect.WAVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[OverlayItem.AnimEffect.SHRINK.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[OverlayItem.AnimEffect.FADE_OUT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[OverlayItem.AnimEffect.FADE_IN.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[OverlayItem.AnimEffect.GROWTH_FADE_IN.ordinal()] = 6;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[OverlayItem.AnimEffect.SHRINK_FADE_OUT.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[OverlayItem.AnimEffect.GROWTH_REBOUND.ordinal()] = 8;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[OverlayItem.AnimEffect.ALPHA.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[OverlayItem.AnimEffect.ANCHOR_GROUTH.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            a[OverlayItem.AnimEffect.ROTATE.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            a[OverlayItem.AnimEffect.NONE.ordinal()] = 12;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
