package com.baidu.tbadk.abtest.helper;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.HttpsTestSwitch;
import com.baidu.tbadk.switchs.Ipv6TestSwitch;
import com.baidu.tieba.ag;
import com.baidu.tieba.fd5;
import com.baidu.tieba.rf;
import com.baidu.tieba.sl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class HttpsExperimentFetcher extends sl1<rf> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class HttpsExperimentImpl implements rf {
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

        public List<ag> getHttpsWhileList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                fd5 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
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
                fd5 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
                if (httpsWhileData == null) {
                    return false;
                }
                return httpsWhileData.b();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.rf
        public boolean isIpv6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return Ipv6TestSwitch.isOn();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.rf
        public boolean isSwitchOn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return HttpsTestSwitch.isOn();
            }
            return invokeV.booleanValue;
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
    @Override // com.baidu.tieba.sl1
    public rf createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new HttpsExperimentImpl(null);
        }
        return (rf) invokeV.objValue;
    }
}
