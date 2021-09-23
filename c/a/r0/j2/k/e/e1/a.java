package c.a.r0.j2.k.e.e1;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.r0.j2.h.e;
import c.a.r0.j2.k.e.s0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f20061a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f20062b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f20063c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f20064d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.q0.n.a f20065e;

    /* renamed from: c.a.r0.j2.k.e.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0957a implements c.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20066a;

        public C0957a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20066a = aVar;
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f20066a.f20063c == null || this.f20066a.f20063c.L0() == null) {
                return;
            }
            this.f20066a.f20063c.L0().K();
        }

        @Override // c.a.q0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f20066a.f20064d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    e P0 = this.f20066a.f20064d.P0();
                    String first_class = P0.m() != null ? P0.m().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f20066a.f20063c == null || this.f20066a.f20063c.L0() == null) {
                            return;
                        }
                        this.f20066a.f20063c.L0().K();
                        return;
                    }
                    this.f20066a.f20061a.addAll(b.b(list, first_class, this.f20066a.f20064d.O0()));
                    P0.I0(this.f20066a.f20061a);
                    Integer num = dataRes.rec_type;
                    P0.F0(num == null ? 0 : num.intValue());
                }
                if (this.f20066a.f20063c != null && !ListUtils.isEmpty(this.f20066a.f20061a)) {
                    this.f20066a.f20063c.o3();
                }
                if (this.f20066a.f20063c.L0() == null || !this.f20066a.f20063c.L0().m() || ListUtils.isEmpty(this.f20066a.f20061a)) {
                    return;
                }
                this.f20066a.f20063c.L0().j();
            }
        }
    }

    public a(c.a.r0.j2.o.b bVar, BdUniqueId bdUniqueId, s0 s0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, s0Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20061a = new ArrayList();
        this.f20065e = new C0957a(this);
        this.f20063c = s0Var;
        this.f20064d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f20062b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f20065e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f20064d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.f1()) || this.f20064d.P0() == null || this.f20064d.P0().Z()) {
                return false;
            }
            int c0 = this.f20064d.c0();
            int O0 = this.f20064d.O0();
            if (c0 == 1 || O0 == 2 || O0 == 3) {
                String forumId = this.f20064d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f20064d.P0().m() != null) {
                    forumId = this.f20064d.P0().m().getId();
                }
                return this.f20062b.C(c.a.e.e.m.b.g(forumId, 0L), c.a.e.e.m.b.g(this.f20064d.f1(), 0L), c0, O0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20061a.clear();
            this.f20062b.onDestroy();
        }
    }

    public void f(s0 s0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s0Var, pbModel) == null) {
            this.f20063c = s0Var;
            this.f20064d = pbModel;
        }
    }
}
