package com.baidu.platform.core.f;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes3.dex */
public class n extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n(TransitRoutePlanOption transitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transitRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(transitRoutePlanOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.h();
        }
        return (String) invokeL.objValue;
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, transitRoutePlanOption) == null) {
            this.a.a("qt", "bus");
            com.baidu.platform.util.a aVar = this.a;
            aVar.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
            this.a.a("ie", IMAudioTransRequest.CHARSET);
            this.a.a("lrn", PayUVEventType.PAY_WALLET_BANNER_SHOW);
            this.a.a("version", "3");
            this.a.a("rp_format", "json");
            this.a.a("rp_filter", "mobile");
            this.a.a("ic_info", "2");
            this.a.a("exptype", "depall");
            this.a.a(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, a(transitRoutePlanOption.mFrom));
            this.a.a("en", a(transitRoutePlanOption.mTo));
            String str = transitRoutePlanOption.mCityName;
            if (str != null) {
                this.a.a("c", str);
            }
            if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
                this.a.a("f", "[0,2,4,7,5,8,9,10,11]");
            }
        }
    }
}
