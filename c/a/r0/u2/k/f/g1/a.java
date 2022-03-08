package c.a.r0.u2.k.f.g1;

import android.text.TextUtils;
import c.a.d.o.e.n;
import c.a.r0.u2.h.f;
import c.a.r0.u2.k.f.u0;
import c.a.r0.u2.o.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f23572b;

    /* renamed from: c  reason: collision with root package name */
    public u0 f23573c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f23574d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.q0.m.a f23575e;

    /* renamed from: c.a.r0.u2.k.f.g1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1459a implements c.a.q0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1459a(a aVar) {
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

        @Override // c.a.q0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.a.f23573c == null || this.a.f23573c.L0() == null) {
                return;
            }
            this.a.f23573c.L0().N();
        }

        @Override // c.a.q0.m.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.f23574d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    f R0 = this.a.f23574d.R0();
                    String first_class = R0.l() != null ? R0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.f23573c == null || this.a.f23573c.L0() == null) {
                            return;
                        }
                        this.a.f23573c.L0().v(R0.t());
                        this.a.f23573c.L0().N();
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
                    this.a.a.addAll(b.b(list, first_class, this.a.f23574d.Q0()));
                    R0.L0(this.a.a);
                    Integer num = dataRes.rec_type;
                    R0.I0(num == null ? 0 : num.intValue());
                }
                if (this.a.f23573c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.f23573c.p3();
                }
                if (this.a.f23573c.L0() == null || !this.a.f23573c.L0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.f23573c.L0().k();
            }
        }
    }

    public a(c cVar, BdUniqueId bdUniqueId, u0 u0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId, u0Var, pbModel};
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
        this.f23575e = new C1459a(this);
        this.f23573c = u0Var;
        this.f23574d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(cVar.getPageContext(), bdUniqueId);
        this.f23572b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f23575e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f23574d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.h1()) || this.f23574d.R0() == null || this.f23574d.R0().a0()) {
                return false;
            }
            int d0 = this.f23574d.d0();
            int Q0 = this.f23574d.Q0();
            if (d0 == 1 || Q0 == 2 || Q0 == 3) {
                String forumId = this.f23574d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f23574d.R0().l() != null) {
                    forumId = this.f23574d.R0().l().getId();
                }
                return this.f23572b.C(c.a.d.f.m.b.g(forumId, 0L), c.a.d.f.m.b.g(this.f23574d.h1(), 0L), d0, Q0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.f23572b.onDestroy();
        }
    }

    public void f(u0 u0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, u0Var, pbModel) == null) {
            this.f23573c = u0Var;
            this.f23574d = pbModel;
        }
    }
}
