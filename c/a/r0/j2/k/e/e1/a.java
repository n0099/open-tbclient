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
    public final List<n> f20046a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f20047b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f20048c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f20049d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.q0.n.a f20050e;

    /* renamed from: c.a.r0.j2.k.e.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0959a implements c.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20051a;

        public C0959a(a aVar) {
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
            this.f20051a = aVar;
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f20051a.f20048c == null || this.f20051a.f20048c.L0() == null) {
                return;
            }
            this.f20051a.f20048c.L0().K();
        }

        @Override // c.a.q0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f20051a.f20049d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    e O0 = this.f20051a.f20049d.O0();
                    String first_class = O0.m() != null ? O0.m().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f20051a.f20048c == null || this.f20051a.f20048c.L0() == null) {
                            return;
                        }
                        this.f20051a.f20048c.L0().K();
                        return;
                    }
                    this.f20051a.f20046a.addAll(b.b(list, first_class, this.f20051a.f20049d.N0()));
                    O0.I0(this.f20051a.f20046a);
                    Integer num = dataRes.rec_type;
                    O0.F0(num == null ? 0 : num.intValue());
                }
                if (this.f20051a.f20048c != null && !ListUtils.isEmpty(this.f20051a.f20046a)) {
                    this.f20051a.f20048c.o3();
                }
                if (this.f20051a.f20048c.L0() == null || !this.f20051a.f20048c.L0().m() || ListUtils.isEmpty(this.f20051a.f20046a)) {
                    return;
                }
                this.f20051a.f20048c.L0().j();
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
        this.f20046a = new ArrayList();
        this.f20050e = new C0959a(this);
        this.f20048c = s0Var;
        this.f20049d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f20047b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f20050e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f20049d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.e1()) || this.f20049d.O0() == null || this.f20049d.O0().Z()) {
                return false;
            }
            int b0 = this.f20049d.b0();
            int N0 = this.f20049d.N0();
            if (b0 == 1 || N0 == 2 || N0 == 3) {
                String forumId = this.f20049d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f20049d.O0().m() != null) {
                    forumId = this.f20049d.O0().m().getId();
                }
                return this.f20047b.C(c.a.e.e.m.b.g(forumId, 0L), c.a.e.e.m.b.g(this.f20049d.e1(), 0L), b0, N0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20046a.clear();
            this.f20047b.onDestroy();
        }
    }

    public void f(s0 s0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s0Var, pbModel) == null) {
            this.f20048c = s0Var;
            this.f20049d = pbModel;
        }
    }
}
