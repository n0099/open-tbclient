package com.baidu.nadcore.video.player;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class IVideoPlayer$PlayerType {
    public static final /* synthetic */ IVideoPlayer$PlayerType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_AD;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_DEFAULT;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_MINI;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_OFFLINE;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_ONLINE;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_SURFACE;
    public static final IVideoPlayer$PlayerType PLAYER_TYPE_SWAN_APP_SURFACE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1674257596, "Lcom/baidu/nadcore/video/player/IVideoPlayer$PlayerType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1674257596, "Lcom/baidu/nadcore/video/player/IVideoPlayer$PlayerType;");
                return;
            }
        }
        PLAYER_TYPE_ONLINE = new IVideoPlayer$PlayerType("PLAYER_TYPE_ONLINE", 0);
        PLAYER_TYPE_OFFLINE = new IVideoPlayer$PlayerType("PLAYER_TYPE_OFFLINE", 1);
        PLAYER_TYPE_DEFAULT = new IVideoPlayer$PlayerType("PLAYER_TYPE_DEFAULT", 2);
        PLAYER_TYPE_AD = new IVideoPlayer$PlayerType("PLAYER_TYPE_AD", 3);
        PLAYER_TYPE_MINI = new IVideoPlayer$PlayerType("PLAYER_TYPE_MINI", 4);
        PLAYER_TYPE_SURFACE = new IVideoPlayer$PlayerType("PLAYER_TYPE_SURFACE", 5);
        IVideoPlayer$PlayerType iVideoPlayer$PlayerType = new IVideoPlayer$PlayerType("PLAYER_TYPE_SWAN_APP_SURFACE", 6);
        PLAYER_TYPE_SWAN_APP_SURFACE = iVideoPlayer$PlayerType;
        $VALUES = new IVideoPlayer$PlayerType[]{PLAYER_TYPE_ONLINE, PLAYER_TYPE_OFFLINE, PLAYER_TYPE_DEFAULT, PLAYER_TYPE_AD, PLAYER_TYPE_MINI, PLAYER_TYPE_SURFACE, iVideoPlayer$PlayerType};
    }

    public IVideoPlayer$PlayerType(String str, int i2) {
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

    public static IVideoPlayer$PlayerType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IVideoPlayer$PlayerType) Enum.valueOf(IVideoPlayer$PlayerType.class, str) : (IVideoPlayer$PlayerType) invokeL.objValue;
    }

    public static IVideoPlayer$PlayerType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IVideoPlayer$PlayerType[]) $VALUES.clone() : (IVideoPlayer$PlayerType[]) invokeV.objValue;
    }
}
