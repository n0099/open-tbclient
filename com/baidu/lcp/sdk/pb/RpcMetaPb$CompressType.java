package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.Internal;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class RpcMetaPb$CompressType implements Internal.EnumLite {
    public static final /* synthetic */ RpcMetaPb$CompressType[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final RpcMetaPb$CompressType COMPRESS_GZIP;
    public static final int COMPRESS_GZIP_VALUE = 1;
    public static final RpcMetaPb$CompressType COMPRESS_NONE;
    public static final int COMPRESS_NONE_VALUE = 0;
    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalValueMap;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(517709971, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$CompressType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(517709971, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$CompressType;");
                return;
            }
        }
        COMPRESS_NONE = new RpcMetaPb$CompressType("COMPRESS_NONE", 0, 0, 0);
        RpcMetaPb$CompressType rpcMetaPb$CompressType = new RpcMetaPb$CompressType("COMPRESS_GZIP", 1, 1, 1);
        COMPRESS_GZIP = rpcMetaPb$CompressType;
        $VALUES = new RpcMetaPb$CompressType[]{COMPRESS_NONE, rpcMetaPb$CompressType};
        internalValueMap = new Internal.EnumLiteMap<RpcMetaPb$CompressType>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb$CompressType.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public RpcMetaPb$CompressType findValueByNumber(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) ? RpcMetaPb$CompressType.valueOf(i) : (RpcMetaPb$CompressType) invokeI.objValue;
            }
        };
    }

    public RpcMetaPb$CompressType(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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

    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalGetValueMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? internalValueMap : (Internal.EnumLiteMap) invokeV.objValue;
    }

    public static RpcMetaPb$CompressType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (RpcMetaPb$CompressType) Enum.valueOf(RpcMetaPb$CompressType.class, str) : (RpcMetaPb$CompressType) invokeL.objValue;
    }

    public static RpcMetaPb$CompressType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (RpcMetaPb$CompressType[]) $VALUES.clone() : (RpcMetaPb$CompressType[]) invokeV.objValue;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }

    public static RpcMetaPb$CompressType valueOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return COMPRESS_GZIP;
            }
            return COMPRESS_NONE;
        }
        return (RpcMetaPb$CompressType) invokeI.objValue;
    }
}
