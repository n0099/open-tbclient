package com.baidu.searchbox.common.security;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "Lkotlin/Any;", "", "getAppName", "()Ljava/lang/String;", "getEnUid", "", "getForceMappingCacheInterval", "()J", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "getOAID", "()Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "getUA", "", "useMapping", "()Z", "OAIDResult", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IDeviceInfoAppHost {
    String getAppName();

    String getEnUid();

    long getForceMappingCacheInterval();

    OAIDResult getOAID();

    String getUA();

    boolean useMapping();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String getAppName(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iDeviceInfoAppHost)) == null) ? "" : (String) invokeL.objValue;
        }

        public static String getEnUid(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iDeviceInfoAppHost)) == null) ? "" : (String) invokeL.objValue;
        }

        public static long getForceMappingCacheInterval(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iDeviceInfoAppHost)) == null) {
                return 500654080L;
            }
            return invokeL.longValue;
        }

        public static String getUA(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iDeviceInfoAppHost)) == null) ? "" : (String) invokeL.objValue;
        }

        public static boolean useMapping(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iDeviceInfoAppHost)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public static OAIDResult getOAID(IDeviceInfoAppHost iDeviceInfoAppHost) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iDeviceInfoAppHost)) == null) {
                return new OAIDResult(false, null, null);
            }
            return (OAIDResult) invokeL.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000B#\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "", "encodedOAID", "Ljava/lang/String;", "getEncodedOAID", "()Ljava/lang/String;", "", "hasInit", "Z", "getHasInit", "()Z", "oaid", "getOaid", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class OAIDResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String encodedOAID;
        public final boolean hasInit;
        public final String oaid;

        public OAIDResult(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hasInit = z;
            this.oaid = str;
            this.encodedOAID = str2;
        }

        public final String getEncodedOAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.encodedOAID;
            }
            return (String) invokeV.objValue;
        }

        public final boolean getHasInit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.hasInit;
            }
            return invokeV.booleanValue;
        }

        public final String getOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.oaid;
            }
            return (String) invokeV.objValue;
        }
    }
}
