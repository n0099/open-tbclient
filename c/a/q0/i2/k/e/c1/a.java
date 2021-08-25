package c.a.q0.i2.k.e.c1;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.q0.i2.h.e;
import c.a.q0.i2.k.e.q0;
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
    public final List<n> f19337a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f19338b;

    /* renamed from: c  reason: collision with root package name */
    public q0 f19339c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f19340d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.p0.n.a f19341e;

    /* renamed from: c.a.q0.i2.k.e.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0921a implements c.a.p0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19342a;

        public C0921a(a aVar) {
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
            this.f19342a = aVar;
        }

        @Override // c.a.p0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f19342a.f19339c == null || this.f19342a.f19339c.L0() == null) {
                return;
            }
            this.f19342a.f19339c.L0().K();
        }

        @Override // c.a.p0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f19342a.f19340d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    e O0 = this.f19342a.f19340d.O0();
                    String first_class = O0.m() != null ? O0.m().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f19342a.f19339c == null || this.f19342a.f19339c.L0() == null) {
                            return;
                        }
                        this.f19342a.f19339c.L0().K();
                        return;
                    }
                    this.f19342a.f19337a.addAll(b.b(list, first_class, this.f19342a.f19340d.N0()));
                    O0.I0(this.f19342a.f19337a);
                    Integer num = dataRes.rec_type;
                    O0.F0(num == null ? 0 : num.intValue());
                }
                if (this.f19342a.f19339c != null && !ListUtils.isEmpty(this.f19342a.f19337a)) {
                    this.f19342a.f19339c.p3();
                }
                if (this.f19342a.f19339c.L0() == null || !this.f19342a.f19339c.L0().m() || ListUtils.isEmpty(this.f19342a.f19337a)) {
                    return;
                }
                this.f19342a.f19339c.L0().j();
            }
        }
    }

    public a(c.a.q0.i2.o.b bVar, BdUniqueId bdUniqueId, q0 q0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, q0Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19337a = new ArrayList();
        this.f19341e = new C0921a(this);
        this.f19339c = q0Var;
        this.f19340d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f19338b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f19341e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f19340d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.e1()) || this.f19340d.O0() == null || this.f19340d.O0().Z()) {
                return false;
            }
            int b0 = this.f19340d.b0();
            int N0 = this.f19340d.N0();
            if (b0 == 1 || N0 == 2 || N0 == 3) {
                String forumId = this.f19340d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f19340d.O0().m() != null) {
                    forumId = this.f19340d.O0().m().getId();
                }
                return this.f19338b.C(c.a.e.e.m.b.f(forumId, 0L), c.a.e.e.m.b.f(this.f19340d.e1(), 0L), b0, N0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19337a.clear();
            this.f19338b.onDestroy();
        }
    }

    public void f(q0 q0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, q0Var, pbModel) == null) {
            this.f19339c = q0Var;
            this.f19340d = pbModel;
        }
    }
}
