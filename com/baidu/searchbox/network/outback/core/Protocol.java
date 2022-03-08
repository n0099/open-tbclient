package com.baidu.searchbox.network.outback.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class Protocol {
    public static final /* synthetic */ Protocol[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Protocol H2_PRIOR_KNOWLEDGE;
    public static final Protocol HTTP_1_0;
    public static final Protocol HTTP_1_1;
    public static final Protocol HTTP_2;
    public static final Protocol QUIC;
    public static final Protocol SPDY_3;
    public static final Protocol UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public final String protocol;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2047382360, "Lcom/baidu/searchbox/network/outback/core/Protocol;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2047382360, "Lcom/baidu/searchbox/network/outback/core/Protocol;");
                return;
            }
        }
        HTTP_1_0 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_1 = new Protocol("HTTP_1_1", 1, "http/1.1");
        SPDY_3 = new Protocol("SPDY_3", 2, "spdy/3.1");
        HTTP_2 = new Protocol("HTTP_2", 3, "h2");
        H2_PRIOR_KNOWLEDGE = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        QUIC = new Protocol("QUIC", 5, "quic");
        Protocol protocol = new Protocol(RomUtils.UNKNOWN, 6, "unknown");
        UNKNOWN = protocol;
        $VALUES = new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC, protocol};
    }

    public Protocol(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.protocol = str2;
    }

    public static Protocol get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return UNKNOWN;
            }
            if (str.equals(HTTP_1_0.protocol)) {
                return HTTP_1_0;
            }
            if (str.equals(HTTP_1_1.protocol)) {
                return HTTP_1_1;
            }
            if (str.equals(H2_PRIOR_KNOWLEDGE.protocol)) {
                return H2_PRIOR_KNOWLEDGE;
            }
            if (str.equals(HTTP_2.protocol)) {
                return HTTP_2;
            }
            if (str.equals(SPDY_3.protocol)) {
                return SPDY_3;
            }
            if (str.equals(QUIC.protocol)) {
                return QUIC;
            }
            return UNKNOWN;
        }
        return (Protocol) invokeL.objValue;
    }

    public static Protocol valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Protocol) Enum.valueOf(Protocol.class, str) : (Protocol) invokeL.objValue;
    }

    public static Protocol[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Protocol[]) $VALUES.clone() : (Protocol[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.protocol : (String) invokeV.objValue;
    }
}
