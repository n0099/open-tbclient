package b.a.r0.k2.u.f.e1;

import android.text.TextUtils;
import b.a.e.l.e.n;
import b.a.r0.k2.r.f;
import b.a.r0.k2.u.f.s0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f19235a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f19236b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f19237c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f19238d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a.q0.n.a f19239e;

    /* renamed from: b.a.r0.k2.u.f.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0965a implements b.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19240a;

        public C0965a(a aVar) {
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
            this.f19240a = aVar;
        }

        @Override // b.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f19240a.f19237c == null || this.f19240a.f19237c.K0() == null) {
                return;
            }
            this.f19240a.f19237c.K0().M();
        }

        @Override // b.a.q0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f19240a.f19238d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    f P0 = this.f19240a.f19238d.P0();
                    String first_class = P0.l() != null ? P0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f19240a.f19237c == null || this.f19240a.f19237c.K0() == null) {
                            return;
                        }
                        this.f19240a.f19237c.K0().u(P0.t());
                        this.f19240a.f19237c.K0().M();
                        if (P0.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", P0.m());
                            statisticItem.param("fname", P0.n());
                            statisticItem.param("tid", P0.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    this.f19240a.f19235a.addAll(b.b(list, first_class, this.f19240a.f19238d.O0()));
                    P0.L0(this.f19240a.f19235a);
                    Integer num = dataRes.rec_type;
                    P0.I0(num == null ? 0 : num.intValue());
                }
                if (this.f19240a.f19237c != null && !ListUtils.isEmpty(this.f19240a.f19235a)) {
                    this.f19240a.f19237c.m3();
                }
                if (this.f19240a.f19237c.K0() == null || !this.f19240a.f19237c.K0().n() || ListUtils.isEmpty(this.f19240a.f19235a)) {
                    return;
                }
                this.f19240a.f19237c.K0().k();
            }
        }
    }

    public a(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId, s0 s0Var, PbModel pbModel) {
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
        this.f19235a = new ArrayList();
        this.f19239e = new C0965a(this);
        this.f19237c = s0Var;
        this.f19238d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f19236b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f19239e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f19238d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.f1()) || this.f19238d.P0() == null || this.f19238d.P0().a0()) {
                return false;
            }
            int c0 = this.f19238d.c0();
            int O0 = this.f19238d.O0();
            if (c0 == 1 || O0 == 2 || O0 == 3) {
                String forumId = this.f19238d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f19238d.P0().l() != null) {
                    forumId = this.f19238d.P0().l().getId();
                }
                return this.f19236b.C(b.a.e.e.m.b.g(forumId, 0L), b.a.e.e.m.b.g(this.f19238d.f1(), 0L), c0, O0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19235a.clear();
            this.f19236b.onDestroy();
        }
    }

    public void f(s0 s0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s0Var, pbModel) == null) {
            this.f19237c = s0Var;
            this.f19238d = pbModel;
        }
    }
}
