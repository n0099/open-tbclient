package com.baidu.searchbox.v8engine.net.io;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static e a;

    /* renamed from: b  reason: collision with root package name */
    public static long f28697b;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (f.class) {
                if (a != null) {
                    e eVar = a;
                    a = eVar.f28695f;
                    eVar.f28695f = null;
                    f28697b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    return eVar;
                }
                return new e();
            }
        }
        return (e) invokeV.objValue;
    }

    public static void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eVar) == null) {
            if (eVar.f28695f == null && eVar.f28696g == null) {
                if (eVar.f28693d) {
                    return;
                }
                synchronized (f.class) {
                    if (f28697b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                        return;
                    }
                    f28697b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    eVar.f28695f = a;
                    eVar.f28692c = 0;
                    eVar.f28691b = 0;
                    a = eVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
