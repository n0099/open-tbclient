package c.a.s0.g0;

import android.content.Context;
import c.a.r0.s.r.d2;
import c.a.r0.s.t.a;
import c.a.r0.s.t.i;
import c.a.r0.t.c.k0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17822b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f17823c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s.t.i f17824d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.s.t.a f17825e;

    /* renamed from: f  reason: collision with root package name */
    public j f17826f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f17827g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.r0.s.t.f> f17828h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.s.t.f f17829i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.s.t.f f17830j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.s.t.f f17831k;
    public c.a.r0.s.t.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.s0.f0.a p;
    public i.d q;
    public SetPrivacyModel.a r;
    public i.d s;
    public i.d t;
    public i.d u;
    public c.a.d.a.e v;

    /* loaded from: classes7.dex */
    public class a implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.s.t.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f17827g == null) {
                return;
            }
            this.a.q();
            int i3 = 2;
            if (this.a.f17827g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.a.f17827g.u;
                i2 = 1;
            }
            if (this.a.f17827g == null || !this.a.f17827g.s) {
                if (this.a.f17827g.getThreadData() != null) {
                    this.a.p.f(this.a.f17827g.getThreadData().v1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.a.f17827g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.f17827g.getThreadData().v1())) ? 1 : 1;
                this.a.p.b();
                if (this.a.f17827g.getThreadData() != null) {
                    this.a.p.d(i2, i3, this.a.f17827g.getThreadData().v1());
                    return;
                }
                return;
            }
            this.a.a.showToast(c.a.s0.y2.g.privacy_thread_can_not_use_call_fans);
            if (this.a.f17827g.getThreadData() != null) {
                this.a.p.d(i2, 3, this.a.f17827g.getThreadData().v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f17832e;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17832e = sVar;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.k.A()) {
                    c.a.d.f.p.m.L(this.f17832e.f17822b, c.a.s0.y2.g.neterror);
                    return;
                }
                if (this.f17832e.f17827g.u != 1) {
                    if (this.f17832e.f17827g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f17832e.o) {
                    this.f17832e.n.Q(this.f17832e.f17827g.t);
                }
                this.f17832e.n.S(this.f17832e.f17827g.f43777e, this.f17832e.f17827g.l, this.f17832e.f17827g.f43778f, this.f17832e.f17827g.f43781i, 0, 0, true, this.f17832e.f17827g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public e(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.d.f.p.m.M(this.a.f17822b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f17827g.s) {
                    this.a.f17827g.s = false;
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.thread_has_open);
                    if (this.a.f17829i != null) {
                        this.a.f17829i.m(this.a.f17822b.getString(c.a.s0.y2.g.set_thread_privacy));
                    }
                    if (this.a.f17826f != null) {
                        this.a.f17826f.a(false);
                        return;
                    }
                    return;
                }
                this.a.f17827g.s = true;
                if (this.a.f17829i != null) {
                    this.a.f17829i.m(this.a.f17822b.getString(c.a.s0.y2.g.set_thread_public_open));
                }
                if (this.a.f17826f != null) {
                    this.a.f17826f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.f17827g.f43778f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public f(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.k.A()) {
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.neterror);
                    return;
                }
                if (this.a.f17827g.s) {
                    if (this.a.f17827g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.f17827g.u != 1) {
                    if (this.a.f17827g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.f17827g);
                }
                if (!this.a.m.C()) {
                    this.a.m.D(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public g(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.k.A()) {
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.neterror);
                    return;
                }
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.a.f17827g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.v1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{d2});
                k0.a(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public h(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.k.A()) {
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.neterror);
                    return;
                }
                if (this.a.f17827g != null && this.a.n != null) {
                    this.a.p();
                    this.a.f17825e.show();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public i(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f49827c == 0) {
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.delete_success);
                    if (this.a.f17827g != null) {
                        if (c.a.d.f.p.l.isEmpty(this.a.f17827g.K)) {
                            if (c.a.d.f.p.l.isEmpty(this.a.f17827g.f43778f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.f17827g.f43778f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.f17827g.K));
                    }
                } else if (!c.a.d.f.p.l.isEmpty(bVar.f49826b)) {
                    c.a.d.f.p.m.M(this.a.f17822b, bVar.f49826b);
                } else {
                    c.a.d.f.p.m.L(this.a.f17822b, c.a.s0.y2.g.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z);
    }

    public s(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.q = new b(this);
        this.r = new e(this);
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.v = new i(this);
        if (tbPageContext == null) {
            return;
        }
        this.a = tbPageContext;
        this.f17822b = tbPageContext.getPageActivity();
        this.f17828h = new ArrayList();
        this.f17824d = new c.a.r0.s.t.i(this.f17822b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.s0.f0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.r0.s.t.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f17827g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f17829i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f17822b.getString(c.a.s0.y2.g.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.O2()) {
                    if (this.f17828h.contains(this.f17829i)) {
                        this.f17828h.remove(this.f17829i);
                        this.f17824d.j(this.f17828h);
                    }
                } else {
                    this.f17829i.m(this.f17822b.getString(c.a.s0.y2.g.set_thread_privacy));
                }
            }
            this.f17829i.p(z);
            if (this.f17830j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f17830j.m(this.f17822b.getString(c.a.s0.y2.g.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f17827g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f17827g.getThreadData().v1())) {
                        this.f17830j.m(this.f17822b.getString(c.a.s0.y2.g.have_called_fans));
                    } else {
                        this.f17830j.m(this.f17822b.getString(c.a.s0.y2.g.call_fans));
                    }
                    this.f17830j.o(c.a.s0.y2.a.cp_cont_b_alpha33);
                }
                this.f17830j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f17823c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                c.a.r0.s.t.f fVar = new c.a.r0.s.t.f(this.f17822b.getString(c.a.s0.y2.g.heating_thread), this.f17824d);
                this.l = fVar;
                fVar.l(this.t);
                this.f17828h.add(this.l);
            }
            c.a.r0.s.t.f fVar2 = new c.a.r0.s.t.f(this.f17824d);
            this.f17829i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f17828h.add(this.f17829i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.r0.s.t.f fVar3 = new c.a.r0.s.t.f(this.f17822b.getString(c.a.s0.y2.g.call_fans), this.f17824d);
                this.f17830j = fVar3;
                fVar3.l(this.q);
                this.f17828h.add(this.f17830j);
            }
            c.a.r0.s.t.f fVar4 = new c.a.r0.s.t.f(this.f17822b.getString(c.a.s0.y2.g.delete), this.f17824d);
            this.f17831k = fVar4;
            fVar4.l(this.u);
            this.f17828h.add(this.f17831k);
            this.f17824d.l(new a(this));
            this.f17824d.j(this.f17828h);
            this.f17823c = new PopupDialog(this.a, this.f17824d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f17825e == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getPageActivity());
            this.f17825e = aVar;
            if (this.o) {
                aVar.setMessageId(c.a.s0.y2.g.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f17827g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.X1()) {
                    this.f17825e.setMessageId(c.a.s0.y2.g.del_work_thread_confirm);
                } else {
                    this.f17825e.setMessageId(c.a.s0.y2.g.del_thread_confirm);
                }
            }
            this.f17825e.setPositiveButton(c.a.s0.y2.g.dialog_ok, new c(this));
            this.f17825e.setNegativeButton(c.a.s0.y2.g.dialog_cancel, new d(this));
            this.f17825e.setCancelable(true);
            this.f17825e.create(this.a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f17823c) != null && popupDialog.isShowing()) {
            this.f17823c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.s.t.i iVar = this.f17824d;
            if (iVar != null) {
                iVar.i();
            }
            c.a.r0.s.t.a aVar = this.f17825e;
            if (aVar != null) {
                c.a.r0.w0.a.a(this.a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f17826f = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f17823c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
