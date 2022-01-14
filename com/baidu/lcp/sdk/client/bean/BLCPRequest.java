package com.baidu.lcp.sdk.client.bean;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BLCPRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f34621b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f34622c;

    /* renamed from: d  reason: collision with root package name */
    public long f34623d;

    /* renamed from: e  reason: collision with root package name */
    public SendTimeoutSecond f34624e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class SendTimeoutSecond {
        public static final /* synthetic */ SendTimeoutSecond[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SendTimeoutSecond TIMEOUT_120s;
        public static final SendTimeoutSecond TIMEOUT_20s;
        public static final SendTimeoutSecond TIMEOUT_30s;
        public static final SendTimeoutSecond TIMEOUT_50s;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-348799826, "Lcom/baidu/lcp/sdk/client/bean/BLCPRequest$SendTimeoutSecond;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-348799826, "Lcom/baidu/lcp/sdk/client/bean/BLCPRequest$SendTimeoutSecond;");
                    return;
                }
            }
            TIMEOUT_20s = new SendTimeoutSecond("TIMEOUT_20s", 0);
            TIMEOUT_30s = new SendTimeoutSecond("TIMEOUT_30s", 1);
            TIMEOUT_50s = new SendTimeoutSecond("TIMEOUT_50s", 2);
            SendTimeoutSecond sendTimeoutSecond = new SendTimeoutSecond("TIMEOUT_120s", 3);
            TIMEOUT_120s = sendTimeoutSecond;
            $VALUES = new SendTimeoutSecond[]{TIMEOUT_20s, TIMEOUT_30s, TIMEOUT_50s, sendTimeoutSecond};
        }

        public SendTimeoutSecond(String str, int i2) {
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

        public static SendTimeoutSecond valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SendTimeoutSecond) Enum.valueOf(SendTimeoutSecond.class, str) : (SendTimeoutSecond) invokeL.objValue;
        }

        public static SendTimeoutSecond[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SendTimeoutSecond[]) $VALUES.clone() : (SendTimeoutSecond[]) invokeV.objValue;
        }
    }

    public BLCPRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.f34621b = -1L;
        this.f34622c = new byte[0];
        this.f34623d = -1L;
        this.f34624e = SendTimeoutSecond.TIMEOUT_120s;
    }
}
