package b.a.q0.a.b0;

import b.a.q0.a.q;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f11679a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11680b;

    /* renamed from: c  reason: collision with root package name */
    public String f11681c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<b.a.q0.a.c> f11682d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f11683e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f11684f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f11685g;

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
        this.f11680b = false;
        this.f11681c = "";
        this.f11682d = new ArrayList<>();
        this.f11683e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11683e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<b.a.q0.a.c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11682d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.f11679a = dataRes;
            this.f11682d.clear();
            this.f11683e.clear();
            if (dataRes == null) {
                return;
            }
            this.f11680b = dataRes.is_new_user.intValue() == 1;
            this.f11681c = dataRes.active_url;
            this.f11683e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.f11679a.mission_list) {
                if (missionInfo != null) {
                    b.a.q0.a.c cVar = new b.a.q0.a.c(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        b.a.q0.s.d0.a.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        q.c().f(cVar);
                    } else if (cVar.K()) {
                        this.f11682d.add(cVar);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f11684f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.f11685g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}
