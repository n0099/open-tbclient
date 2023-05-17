package com.baidu.platform.core.f;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes3.dex */
public class p extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {walkingRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(walkingRoutePlanOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.k();
        }
        return (String) invokeL.objValue;
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, walkingRoutePlanOption) == null) {
            this.a.a("qt", "walk2");
            this.a.a(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, a(walkingRoutePlanOption.mFrom));
            this.a.a("en", a(walkingRoutePlanOption.mTo));
            PlanNode planNode = walkingRoutePlanOption.mFrom;
            if (planNode != null) {
                this.a.a(Config.STAT_SDK_CHANNEL, planNode.getCity());
            }
            PlanNode planNode2 = walkingRoutePlanOption.mTo;
            if (planNode2 != null) {
                this.a.a("ec", planNode2.getCity());
            }
            this.a.a("ie", IMAudioTransRequest.CHARSET);
            this.a.a("lrn", PayUVEventType.PAY_WALLET_BANNER_SHOW);
            this.a.a("version", "3");
            this.a.a("rp_format", "json");
            this.a.a("rp_filter", "mobile");
        }
    }
}
