package com.baidu.fsg.face.liveness.utils;

import android.hardware.Camera;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ListIterator;
/* loaded from: classes10.dex */
public final class CameraUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 307200;

    /* renamed from: b  reason: collision with root package name */
    public static final int f34319b = 2073600;
    public transient /* synthetic */ FieldHolder $fh;

    public CameraUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Camera.Size getSimilarRatioSize(Camera.Parameters parameters, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, parameters, i2, i3)) == null) {
            if (i2 >= i3) {
                i3 = i2;
                i2 = i3;
            }
            float f2 = i2 / i3;
            float f3 = 1.0f;
            Camera.Size size = null;
            ListIterator<Camera.Size> listIterator = parameters.getSupportedPreviewSizes().listIterator();
            LogUtil.d("hello", "getSimilarRatioSize(" + i3 + "，" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            while (listIterator.hasNext()) {
                Camera.Size next = listIterator.next();
                int i4 = next.width;
                int i5 = next.height;
                if (i4 * i5 < 307200) {
                    listIterator.remove();
                } else if (i4 * i5 > 2073600) {
                    listIterator.remove();
                } else if (i4 % 2 != 0 || i5 % 2 != 0) {
                    listIterator.remove();
                } else if (i4 == i3 && i5 == i2) {
                    return next;
                } else {
                    float abs = Math.abs(f2 - (next.height / next.width));
                    if (f3 > abs) {
                        size = next;
                        f3 = abs;
                    }
                }
            }
            return size;
        }
        return (Camera.Size) invokeLII.objValue;
    }
}
