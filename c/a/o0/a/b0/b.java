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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f12228a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12229b;

    /* renamed from: c  reason: collision with root package name */
    public String f12230c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<c.a.o0.a.c> f12231d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f12232e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f12233f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f12234g;

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
        this.f12229b = false;
        this.f12230c = "";
        this.f12231d = new ArrayList<>();
        this.f12232e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12232e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<c.a.o0.a.c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12231d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.f12228a = dataRes;
            this.f12231d.clear();
            this.f12232e.clear();
            if (dataRes == null) {
                return;
            }
            this.f12229b = dataRes.is_new_user.intValue() == 1;
            this.f12230c = dataRes.active_url;
            this.f12232e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.f12228a.mission_list) {
                if (missionInfo != null) {
                    c.a.o0.a.c cVar = new c.a.o0.a.c(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        c.a.o0.s.c0.a.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        q.c().f(cVar);
                    } else if (cVar.K()) {
                        this.f12231d.add(cVar);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f12233f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.f12234g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}
