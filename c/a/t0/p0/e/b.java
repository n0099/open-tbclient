package c.a.t0.p0.e;

import c.a.s0.l0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ItemManage.DataRes;
import tbclient.ManageInfo;
/* loaded from: classes8.dex */
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.t0.p0.b.b> f21965e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.t0.p0.b.b> f21966f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f21967g;

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
        this.f21965e = new ArrayList();
        this.f21966f = new ArrayList();
        this.f21967g = 0;
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f21965e.addAll(bVar.f21965e);
            this.f21966f = bVar.f21966f;
            this.f21967g = bVar.f21967g;
        }
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            for (ManageInfo manageInfo : dataRes.manage_list) {
                this.f21965e.add(c.a.t0.p0.b.b.e(manageInfo));
            }
            for (ManageInfo manageInfo2 : dataRes.manage_recomm_list) {
                this.f21966f.add(c.a.t0.p0.b.b.e(manageInfo2));
            }
            this.f21967g = dataRes.has_more;
        }
    }

    @Override // c.a.s0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // c.a.s0.l0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
        }
    }
}
