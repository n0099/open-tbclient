package com.baidu.swan.apps.core.prefetch.resource.task;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.wj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ResType {
    public static final /* synthetic */ ResType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ResType IMAGE;
    public static final ResType NONE;
    public static final ResType TEST;
    public static final ResType VIDEO;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(285497951, "Lcom/baidu/swan/apps/core/prefetch/resource/task/ResType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(285497951, "Lcom/baidu/swan/apps/core/prefetch/resource/task/ResType;");
                return;
            }
        }
        NONE = new ResType(HlsPlaylistParser.METHOD_NONE, 0);
        TEST = new ResType("TEST", 1);
        VIDEO = new ResType(HlsPlaylistParser.TYPE_VIDEO, 2);
        ResType resType = new ResType("IMAGE", 3);
        IMAGE = resType;
        $VALUES = new ResType[]{NONE, TEST, VIDEO, resType};
    }

    public ResType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ResType typeOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return NONE;
            }
            ResType resType = NONE;
            ResType[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ResType resType2 = values[i];
                if (str.equalsIgnoreCase(resType2.name())) {
                    resType = resType2;
                    break;
                }
                i++;
            }
            if (wj1.a) {
                Log.d("ResType", "res type - " + resType.name());
            }
            return resType;
        }
        return (ResType) invokeL.objValue;
    }

    public static ResType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (ResType) Enum.valueOf(ResType.class, str);
        }
        return (ResType) invokeL.objValue;
    }

    public static ResType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (ResType[]) $VALUES.clone();
        }
        return (ResType[]) invokeV.objValue;
    }
}
