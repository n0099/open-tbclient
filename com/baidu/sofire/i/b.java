package com.baidu.sofire.i;

import android.hardware.Camera;
import com.baidu.sofire.utility.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, camera) == null) || camera == null) {
            return;
        }
        try {
            camera.release();
        } catch (Throwable unused) {
            c.a();
        }
    }
}
