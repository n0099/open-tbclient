package b.a.r0.k2.u.f.f1;

import android.text.TextUtils;
import b.a.e.m.e.n;
import b.a.r0.k2.r.f;
import b.a.r0.k2.u.f.t0;
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
    public final List<n> f20801a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f20802b;

    /* renamed from: c  reason: collision with root package name */
    public t0 f20803c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f20804d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a.q0.n.a f20805e;

    /* renamed from: b.a.r0.k2.u.f.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1037a implements b.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20806a;

        public C1037a(a aVar) {
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
            this.f20806a = aVar;
        }

        @Override // b.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f20806a.f20803c == null || this.f20806a.f20803c.K0() == null) {
                return;
            }
            this.f20806a.f20803c.K0().M();
        }

        @Override // b.a.q0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f20806a.f20804d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    f P0 = this.f20806a.f20804d.P0();
                    String first_class = P0.l() != null ? P0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f20806a.f20803c == null || this.f20806a.f20803c.K0() == null) {
                            return;
                        }
                        this.f20806a.f20803c.K0().u(P0.t());
                        this.f20806a.f20803c.K0().M();
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
                    this.f20806a.f20801a.addAll(b.b(list, first_class, this.f20806a.f20804d.O0()));
                    P0.L0(this.f20806a.f20801a);
                    Integer num = dataRes.rec_type;
                    P0.I0(num == null ? 0 : num.intValue());
                }
                if (this.f20806a.f20803c != null && !ListUtils.isEmpty(this.f20806a.f20801a)) {
                    this.f20806a.f20803c.m3();
                }
                if (this.f20806a.f20803c.K0() == null || !this.f20806a.f20803c.K0().n() || ListUtils.isEmpty(this.f20806a.f20801a)) {
                    return;
                }
                this.f20806a.f20803c.K0().k();
            }
        }
    }

    public a(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId, t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, t0Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20801a = new ArrayList();
        this.f20805e = new C1037a(this);
        this.f20803c = t0Var;
        this.f20804d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f20802b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f20805e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f20804d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.f1()) || this.f20804d.P0() == null || this.f20804d.P0().a0()) {
                return false;
            }
            int c0 = this.f20804d.c0();
            int O0 = this.f20804d.O0();
            if (c0 == 1 || O0 == 2 || O0 == 3) {
                String forumId = this.f20804d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f20804d.P0().l() != null) {
                    forumId = this.f20804d.P0().l().getId();
                }
                return this.f20802b.C(b.a.e.f.m.b.g(forumId, 0L), b.a.e.f.m.b.g(this.f20804d.f1(), 0L), c0, O0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20801a.clear();
            this.f20802b.onDestroy();
        }
    }

    public void f(t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t0Var, pbModel) == null) {
            this.f20803c = t0Var;
            this.f20804d = pbModel;
        }
    }
}
