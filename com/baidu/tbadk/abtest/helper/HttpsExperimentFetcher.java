package com.baidu.tbadk.abtest.helper;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.HttpsTestSwitch;
import com.baidu.tbadk.switchs.Ipv6TestSwitch;
import com.baidu.tieba.a95;
import com.baidu.tieba.ef;
import com.baidu.tieba.nf;
import com.baidu.tieba.tj1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class HttpsExperimentFetcher extends tj1<ef> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class HttpsExperimentImpl implements ef {
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

        public List<nf> getHttpsWhileList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a95 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
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
                a95 httpsWhileData = TbadkCoreApplication.getInst().getHttpsWhileData();
                if (httpsWhileData == null) {
                    return false;
                }
                return httpsWhileData.b();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ef
        public boolean isIpv6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return Ipv6TestSwitch.isOn();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ef
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
    @Override // com.baidu.tieba.tj1
    public ef createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new HttpsExperimentImpl(null);
        }
        return (ef) invokeV.objValue;
    }
}
