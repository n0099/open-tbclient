package com.baidu.minivideo.plugin.capture.bean;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class MusicStyle {
    public static final /* synthetic */ MusicStyle[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MusicStyle COMMON;
    public static final MusicStyle DESCRIBE;
    public static final MusicStyle END;
    public static final MusicStyle LINE;
    public static final MusicStyle MENU;
    public static final MusicStyle MORE;
    public static final MusicStyle PACK;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(178217820, "Lcom/baidu/minivideo/plugin/capture/bean/MusicStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(178217820, "Lcom/baidu/minivideo/plugin/capture/bean/MusicStyle;");
                return;
            }
        }
        MENU = new MusicStyle("MENU", 0, 0);
        COMMON = new MusicStyle("COMMON", 1, 1);
        MORE = new MusicStyle("MORE", 2, 2);
        END = new MusicStyle("END", 3, 3);
        PACK = new MusicStyle("PACK", 4, 4);
        LINE = new MusicStyle("LINE", 5, 5);
        MusicStyle musicStyle = new MusicStyle("DESCRIBE", 6, 6);
        DESCRIBE = musicStyle;
        $VALUES = new MusicStyle[]{MENU, COMMON, MORE, END, PACK, LINE, musicStyle};
    }

    public MusicStyle(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
    }

    public static MusicStyle valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MusicStyle) Enum.valueOf(MusicStyle.class, str) : (MusicStyle) invokeL.objValue;
    }

    public static MusicStyle[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MusicStyle[]) $VALUES.clone() : (MusicStyle[]) invokeV.objValue;
    }

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
