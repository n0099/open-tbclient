package com.baidu.nadcore.webview.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/baidu/nadcore/webview/data/NadPageType;", "Ljava/lang/Enum;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PAGE_NAD_FEED", "PAGE_NAD_SPLASH", "PAGE_NAD_POP_WEB", "PAGE_FENGCHAO", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadPageType {
    public static final /* synthetic */ NadPageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NadPageType PAGE_FENGCHAO;
    public static final NadPageType PAGE_NAD_FEED;
    public static final NadPageType PAGE_NAD_POP_WEB;
    public static final NadPageType PAGE_NAD_SPLASH;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    public static NadPageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NadPageType) Enum.valueOf(NadPageType.class, str) : (NadPageType) invokeL.objValue;
    }

    public static NadPageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NadPageType[]) $VALUES.clone() : (NadPageType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-958647229, "Lcom/baidu/nadcore/webview/data/NadPageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-958647229, "Lcom/baidu/nadcore/webview/data/NadPageType;");
                return;
            }
        }
        NadPageType nadPageType = new NadPageType("PAGE_NAD_FEED", 0, "ad");
        PAGE_NAD_FEED = nadPageType;
        NadPageType nadPageType2 = new NadPageType("PAGE_NAD_SPLASH", 1, "xuzhang");
        PAGE_NAD_SPLASH = nadPageType2;
        NadPageType nadPageType3 = new NadPageType("PAGE_NAD_POP_WEB", 2, "pop_web");
        PAGE_NAD_POP_WEB = nadPageType3;
        NadPageType nadPageType4 = new NadPageType("PAGE_FENGCHAO", 3, "fc");
        PAGE_FENGCHAO = nadPageType4;
        $VALUES = new NadPageType[]{nadPageType, nadPageType2, nadPageType3, nadPageType4};
    }

    public NadPageType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public final String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }
}
