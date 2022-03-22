package c.a.o0.a.b0;

import c.a.o0.a.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9601b;

    /* renamed from: c  reason: collision with root package name */
    public String f9602c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<c.a.o0.a.c> f9603d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f9604e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f9605f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f9606g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9601b = false;
        this.f9602c = "";
        this.f9603d = new ArrayList<>();
        this.f9604e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9604e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<c.a.o0.a.c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9603d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.a = dataRes;
            this.f9603d.clear();
            this.f9604e.clear();
            if (dataRes == null) {
                return;
            }
            this.f9601b = dataRes.is_new_user.intValue() == 1;
            this.f9602c = dataRes.active_url;
            this.f9604e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.a.mission_list) {
                if (missionInfo != null) {
                    c.a.o0.a.c cVar = new c.a.o0.a.c(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        c.a.o0.r.i0.a.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        q.c().f(cVar);
                    } else if (cVar.K()) {
                        this.f9603d.add(cVar);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f9605f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.f9606g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}
