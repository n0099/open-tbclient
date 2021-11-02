package com.android.support.appcompat.storage;

import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class MediaFileProcessor$UriSource {
    public static final /* synthetic */ MediaFileProcessor$UriSource[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MediaFileProcessor$UriSource AUDIO;
    public static final MediaFileProcessor$UriSource DOWNLOAD;
    public static final MediaFileProcessor$UriSource IMAGE;
    public static final MediaFileProcessor$UriSource VIDEO;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(611017836, "Lcom/android/support/appcompat/storage/MediaFileProcessor$UriSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(611017836, "Lcom/android/support/appcompat/storage/MediaFileProcessor$UriSource;");
                return;
            }
        }
        IMAGE = new MediaFileProcessor$UriSource("IMAGE", 0);
        AUDIO = new MediaFileProcessor$UriSource("AUDIO", 1);
        VIDEO = new MediaFileProcessor$UriSource(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 2);
        MediaFileProcessor$UriSource mediaFileProcessor$UriSource = new MediaFileProcessor$UriSource("DOWNLOAD", 3);
        DOWNLOAD = mediaFileProcessor$UriSource;
        $VALUES = new MediaFileProcessor$UriSource[]{IMAGE, AUDIO, VIDEO, mediaFileProcessor$UriSource};
    }

    public MediaFileProcessor$UriSource(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MediaFileProcessor$UriSource valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MediaFileProcessor$UriSource) Enum.valueOf(MediaFileProcessor$UriSource.class, str) : (MediaFileProcessor$UriSource) invokeL.objValue;
    }

    public static MediaFileProcessor$UriSource[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MediaFileProcessor$UriSource[]) $VALUES.clone() : (MediaFileProcessor$UriSource[]) invokeV.objValue;
    }
}
