package c.a.r0.q2.u.f.f1;

import android.text.TextUtils;
import c.a.d.m.e.n;
import c.a.r0.q2.r.f;
import c.a.r0.q2.u.f.t0;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f21993b;

    /* renamed from: c  reason: collision with root package name */
    public t0 f21994c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f21995d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.q0.n.a f21996e;

    /* renamed from: c.a.r0.q2.u.f.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1284a implements c.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1284a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.a.f21994c == null || this.a.f21994c.K0() == null) {
                return;
            }
            this.a.f21994c.K0().M();
        }

        @Override // c.a.q0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.f21995d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    f R0 = this.a.f21995d.R0();
                    String first_class = R0.l() != null ? R0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.f21994c == null || this.a.f21994c.K0() == null) {
                            return;
                        }
                        this.a.f21994c.K0().u(R0.t());
                        this.a.f21994c.K0().M();
                        if (R0.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", R0.m());
                            statisticItem.param("fname", R0.n());
                            statisticItem.param("tid", R0.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    this.a.a.addAll(b.b(list, first_class, this.a.f21995d.Q0()));
                    R0.L0(this.a.a);
                    Integer num = dataRes.rec_type;
                    R0.I0(num == null ? 0 : num.intValue());
                }
                if (this.a.f21994c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.f21994c.m3();
                }
                if (this.a.f21994c.K0() == null || !this.a.f21994c.K0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.f21994c.K0().k();
            }
        }
    }

    public a(c.a.r0.q2.y.b bVar, BdUniqueId bdUniqueId, t0 t0Var, PbModel pbModel) {
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
        this.a = new ArrayList();
        this.f21996e = new C1284a(this);
        this.f21994c = t0Var;
        this.f21995d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f21993b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f21996e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f21995d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.h1()) || this.f21995d.R0() == null || this.f21995d.R0().a0()) {
                return false;
            }
            int d0 = this.f21995d.d0();
            int Q0 = this.f21995d.Q0();
            if (d0 == 1 || Q0 == 2 || Q0 == 3) {
                String forumId = this.f21995d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f21995d.R0().l() != null) {
                    forumId = this.f21995d.R0().l().getId();
                }
                return this.f21993b.C(c.a.d.f.m.b.g(forumId, 0L), c.a.d.f.m.b.g(this.f21995d.h1(), 0L), d0, Q0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.f21993b.onDestroy();
        }
    }

    public void f(t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t0Var, pbModel) == null) {
            this.f21994c = t0Var;
            this.f21995d = pbModel;
        }
    }
}
