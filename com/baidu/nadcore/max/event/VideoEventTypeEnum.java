package com.baidu.nadcore.max.event;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/nadcore/max/event/VideoEventTypeEnum;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "FIRST_FRAME_INTERVAL", "PLAY_SEEK_TO_END", "PLAY_INFO_PROCESS", "LEFT_SLIDE_ON_VIDEO", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class VideoEventTypeEnum {
    public static final /* synthetic */ VideoEventTypeEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final VideoEventTypeEnum FIRST_FRAME_INTERVAL;
    public static final VideoEventTypeEnum LEFT_SLIDE_ON_VIDEO;
    public static final VideoEventTypeEnum PLAY_INFO_PROCESS;
    public static final VideoEventTypeEnum PLAY_SEEK_TO_END;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2028225588, "Lcom/baidu/nadcore/max/event/VideoEventTypeEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2028225588, "Lcom/baidu/nadcore/max/event/VideoEventTypeEnum;");
                return;
            }
        }
        VideoEventTypeEnum videoEventTypeEnum = new VideoEventTypeEnum("FIRST_FRAME_INTERVAL", 0);
        FIRST_FRAME_INTERVAL = videoEventTypeEnum;
        VideoEventTypeEnum videoEventTypeEnum2 = new VideoEventTypeEnum("PLAY_SEEK_TO_END", 1);
        PLAY_SEEK_TO_END = videoEventTypeEnum2;
        VideoEventTypeEnum videoEventTypeEnum3 = new VideoEventTypeEnum("PLAY_INFO_PROCESS", 2);
        PLAY_INFO_PROCESS = videoEventTypeEnum3;
        VideoEventTypeEnum videoEventTypeEnum4 = new VideoEventTypeEnum("LEFT_SLIDE_ON_VIDEO", 3);
        LEFT_SLIDE_ON_VIDEO = videoEventTypeEnum4;
        $VALUES = new VideoEventTypeEnum[]{videoEventTypeEnum, videoEventTypeEnum2, videoEventTypeEnum3, videoEventTypeEnum4};
    }

    public static VideoEventTypeEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoEventTypeEnum) Enum.valueOf(VideoEventTypeEnum.class, str) : (VideoEventTypeEnum) invokeL.objValue;
    }

    public static VideoEventTypeEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoEventTypeEnum[]) $VALUES.clone() : (VideoEventTypeEnum[]) invokeV.objValue;
    }

    public VideoEventTypeEnum(String str, int i) {
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
}
