package b.a.e.j;

import android.text.TextUtils;
import b.a.e.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
@Singleton
@Service
/* loaded from: classes.dex */
public class b implements IPmsContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public boolean checkChannelAllow(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public List<RequestParams.Channel> getLongConnectParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Collections.emptyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? getRegisterParams(str, "aps") : (RequestParams) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public StatisticCallback getStatisticCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new d() : (StatisticCallback) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "aps";
            }
            requestParams.setRunNode(str2);
            if ("0".equals(str)) {
                requestParams.addChannel(b.a.e.h.c.e().d());
                requestParams.addChannel(new g());
                requestParams.addChannel(new b.a.e.k.d());
            }
            return requestParams;
        }
        return (RequestParams) invokeLL.objValue;
    }
}
