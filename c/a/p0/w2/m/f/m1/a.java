package c.a.p0.w2.m.f.m1;

import android.text.TextUtils;
import c.a.d.o.e.n;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.a1;
import c.a.p0.w2.q.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f20241b;

    /* renamed from: c  reason: collision with root package name */
    public a1 f20242c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f20243d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20244e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f20245f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.o0.m.a f20246g;

    /* renamed from: c.a.p0.w2.m.f.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1514a implements c.a.o0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1514a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.m.a
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.f20242c == null || this.a.f20242c.L0() == null) {
                return;
            }
            this.a.f20242c.L0().N();
        }

        @Override // c.a.o0.m.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.f20243d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    f S0 = this.a.f20243d.S0();
                    String first_class = S0.l() != null ? S0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.f20242c == null || this.a.f20242c.L0() == null) {
                            return;
                        }
                        this.a.f20242c.L0().v(S0.t());
                        this.a.f20242c.L0().N();
                        if (S0.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", S0.m());
                            statisticItem.param("fname", S0.n());
                            statisticItem.param("tid", S0.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    List<n> b2 = b.b(list, first_class, this.a.f20243d.R0());
                    this.a.a.addAll(b2);
                    S0.L0(this.a.a);
                    this.a.f20245f.addAll(b2);
                    Integer num = dataRes.rec_type;
                    S0.I0(num == null ? 0 : num.intValue());
                }
                if (this.a.f20242c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.f20242c.r3();
                }
                if (this.a.f20242c.L0() == null || !this.a.f20242c.L0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.f20242c.L0().k();
            }
        }
    }

    public a(c cVar, BdUniqueId bdUniqueId, a1 a1Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId, a1Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f20245f = new ArrayList();
        this.f20246g = new C1514a(this);
        this.f20242c = a1Var;
        this.f20243d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(cVar.getPageContext(), bdUniqueId);
        this.f20241b = relateRecThreadListModel;
        relateRecThreadListModel.F(this.f20246g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f20243d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.k1()) || this.f20243d.S0() == null) {
                return false;
            }
            if (this.f20244e) {
                return true;
            }
            if (this.f20243d.S0().a0()) {
                return false;
            }
            String forumId = this.f20243d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.f20243d.S0().l() != null) {
                forumId = this.f20243d.S0().l().getId();
            }
            long g2 = c.a.d.f.m.b.g(forumId, 0L);
            long g3 = c.a.d.f.m.b.g(this.f20243d.k1(), 0L);
            int f1 = this.f20243d.f1();
            String e1 = this.f20243d.e1();
            if (!this.f20244e) {
                this.f20244e = true;
            }
            return this.f20241b.E(g2, g3, 1, f1, e1);
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.f20241b.onDestroy();
        }
    }

    public void f(a1 a1Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, a1Var, pbModel) == null) {
            this.f20242c = a1Var;
            this.f20243d = pbModel;
        }
    }
}
