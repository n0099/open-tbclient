package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.List;
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, drivingRoutePlanOption) == null) {
            this.f9408a.a("qt", "cars");
            this.f9408a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
            this.f9408a.a("ie", "utf-8");
            this.f9408a.a("lrn", "20");
            this.f9408a.a("version", "6");
            this.f9408a.a("extinfo", EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS);
            this.f9408a.a("mrs", "1");
            this.f9408a.a("rp_format", "json");
            this.f9408a.a("rp_filter", "mobile");
            this.f9408a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
            this.f9408a.a(IAdRequestParam.SN, a(drivingRoutePlanOption.mFrom));
            this.f9408a.a("en", a(drivingRoutePlanOption.mTo));
            String str = drivingRoutePlanOption.mCityName;
            if (str != null) {
                this.f9408a.a("c", str);
            }
            PlanNode planNode2 = drivingRoutePlanOption.mFrom;
            if (planNode2 != null) {
                this.f9408a.a(Config.STAT_SDK_CHANNEL, planNode2.getCity());
            }
            PlanNode planNode3 = drivingRoutePlanOption.mTo;
            if (planNode3 != null) {
                this.f9408a.a("ec", planNode3.getCity());
            }
            List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
            String str2 = new String();
            String str3 = new String();
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) != null) {
                        str2 = str2 + a(planNode);
                        str3 = str3 + planNode.getCity();
                        if (i2 != list.size() - 1) {
                            str3 = str3 + "|";
                            str2 = str2 + "|";
                        }
                    }
                }
                this.f9408a.a("wp", str2);
                this.f9408a.a("wpc", str3);
            }
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.i() : (String) invokeL.objValue;
    }
}
