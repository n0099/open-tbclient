package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.i1;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drivingRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(drivingRoutePlanOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.i();
        }
        return (String) invokeL.objValue;
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, drivingRoutePlanOption) == null) {
            this.a.a("qt", "cars");
            this.a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
            this.a.a("ie", "utf-8");
            this.a.a("lrn", PayUVEventType.PAY_WALLET_BANNER_SHOW);
            this.a.a("version", "6");
            this.a.a("extinfo", PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK);
            this.a.a("mrs", "1");
            this.a.a("rp_format", "json");
            this.a.a("rp_filter", "mobile");
            this.a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
            this.a.a(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, a(drivingRoutePlanOption.mFrom));
            this.a.a("en", a(drivingRoutePlanOption.mTo));
            String str = drivingRoutePlanOption.mCityName;
            if (str != null) {
                this.a.a("c", str);
            }
            PlanNode planNode2 = drivingRoutePlanOption.mFrom;
            if (planNode2 != null) {
                this.a.a("sc", planNode2.getCity());
            }
            PlanNode planNode3 = drivingRoutePlanOption.mTo;
            if (planNode3 != null) {
                this.a.a("ec", planNode3.getCity());
            }
            List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
            String str2 = new String();
            String str3 = new String();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        str2 = str2 + a(planNode);
                        str3 = str3 + planNode.getCity();
                        if (i != list.size() - 1) {
                            str3 = str3 + "|";
                            str2 = str2 + "|";
                        }
                    }
                }
                this.a.a(i1.q, str2);
                this.a.a("wpc", str3);
            }
        }
    }
}
