package com.baidu.swan.videoplayer.media.video.view;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class MediaGestureMode {
    public static final /* synthetic */ MediaGestureMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MediaGestureMode BRIGHTNESS;
    public static final MediaGestureMode FAST_FORWARD;
    public static final MediaGestureMode INTI;
    public static final MediaGestureMode VOLUME;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-731120437, "Lcom/baidu/swan/videoplayer/media/video/view/MediaGestureMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-731120437, "Lcom/baidu/swan/videoplayer/media/video/view/MediaGestureMode;");
                return;
            }
        }
        INTI = new MediaGestureMode("INTI", 0);
        VOLUME = new MediaGestureMode("VOLUME", 1);
        BRIGHTNESS = new MediaGestureMode("BRIGHTNESS", 2);
        MediaGestureMode mediaGestureMode = new MediaGestureMode("FAST_FORWARD", 3);
        FAST_FORWARD = mediaGestureMode;
        $VALUES = new MediaGestureMode[]{INTI, VOLUME, BRIGHTNESS, mediaGestureMode};
    }

    public MediaGestureMode(String str, int i) {
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

    public static MediaGestureMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (MediaGestureMode) Enum.valueOf(MediaGestureMode.class, str);
        }
        return (MediaGestureMode) invokeL.objValue;
    }

    public static MediaGestureMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (MediaGestureMode[]) $VALUES.clone();
        }
        return (MediaGestureMode[]) invokeV.objValue;
    }
}
