package c.a.q0.a.b0;

import c.a.q0.a.q;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f12506a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12507b;

    /* renamed from: c  reason: collision with root package name */
    public String f12508c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<c.a.q0.a.c> f12509d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f12510e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f12511f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f12512g;

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
                return;
            }
        }
        this.f12507b = false;
        this.f12508c = "";
        this.f12509d = new ArrayList<>();
        this.f12510e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12510e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<c.a.q0.a.c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12509d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.f12506a = dataRes;
            this.f12509d.clear();
            this.f12510e.clear();
            if (dataRes == null) {
                return;
            }
            this.f12507b = dataRes.is_new_user.intValue() == 1;
            this.f12508c = dataRes.active_url;
            this.f12510e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.f12506a.mission_list) {
                if (missionInfo != null) {
                    c.a.q0.a.c cVar = new c.a.q0.a.c(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        c.a.q0.s.c0.a.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        q.c().f(cVar);
                    } else if (cVar.K()) {
                        this.f12509d.add(cVar);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f12511f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.f12512g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}
