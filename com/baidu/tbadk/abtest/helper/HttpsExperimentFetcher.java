package com.baidu.tbadk.abtest.helper;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.HttpsTestSwitch;
import com.baidu.tbadk.switchs.Ipv6TestSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ky4;
import com.repackage.mf;
import com.repackage.uc1;
import com.repackage.vf;
import java.util.List;
/* loaded from: classes3.dex */
public class HttpsExperimentFetcher extends uc1<mf> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class HttpsExperimentImpl implements mf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HttpsExperimentImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public List<vf> getHttpsWhileList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ky4 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
                if (httpsWhileData == null) {
                    return null;
                }
                return httpsWhileData.a();
            }
            return (List) invokeV.objValue;
        }

        public boolean isFullHttps() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ky4 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
                if (httpsWhileData == null) {
                    return false;
                }
                return httpsWhileData.b();
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.mf
        public boolean isIpv6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Ipv6TestSwitch.isOn() : invokeV.booleanValue;
        }

        @Override // com.repackage.mf
        public boolean isSwitchOn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? HttpsTestSwitch.isOn() : invokeV.booleanValue;
        }

        public /* synthetic */ HttpsExperimentImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public HttpsExperimentFetcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.uc1
    public mf createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new HttpsExperimentImpl(null) : (mf) invokeV.objValue;
    }
}
