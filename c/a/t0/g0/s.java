package c.a.t0.g0;

import android.content.Context;
import c.a.s0.s.q.e2;
import c.a.s0.s.s.a;
import c.a.s0.s.s.j;
import c.a.s0.t.c.k0;
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
    public Context f17686b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f17687c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.s.s.j f17688d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.s.a f17689e;

    /* renamed from: f  reason: collision with root package name */
    public j f17690f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f17691g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.s0.s.s.g> f17692h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.s.g f17693i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.s.g f17694j;
    public c.a.s0.s.s.g k;
    public c.a.s0.s.s.g l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.t0.f0.a p;
    public j.d q;
    public SetPrivacyModel.a r;
    public j.d s;
    public j.d t;
    public j.d u;
    public c.a.d.a.e v;

    /* loaded from: classes7.dex */
    public class a implements j.c {
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

        @Override // c.a.s0.s.s.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements j.d {
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

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f17691g == null) {
                return;
            }
            this.a.q();
            int i3 = 2;
            if (this.a.f17691g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.a.f17691g.u;
                i2 = 1;
            }
            if (this.a.f17691g == null || !this.a.f17691g.s) {
                if (this.a.f17691g.getThreadData() != null) {
                    this.a.p.f(this.a.f17691g.getThreadData().w1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.a.f17691g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.f17691g.getThreadData().w1())) ? 1 : 1;
                this.a.p.b();
                if (this.a.f17691g.getThreadData() != null) {
                    this.a.p.d(i2, i3, this.a.f17691g.getThreadData().w1());
                    return;
                }
                return;
            }
            this.a.a.showToast(c.a.t0.z2.g.privacy_thread_can_not_use_call_fans);
            if (this.a.f17691g.getThreadData() != null) {
                this.a.p.d(i2, 3, this.a.f17691g.getThreadData().w1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f17695e;

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
            this.f17695e = sVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f17695e.f17686b, c.a.t0.z2.g.neterror);
                    return;
                }
                if (this.f17695e.f17691g.u != 1) {
                    if (this.f17695e.f17691g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f17695e.o) {
                    this.f17695e.n.Q(this.f17695e.f17691g.t);
                }
                this.f17695e.n.S(this.f17695e.f17691g.f42382e, this.f17695e.f17691g.l, this.f17695e.f17691g.f42383f, this.f17695e.f17691g.f42386i, 0, 0, true, this.f17695e.f17691g.t.L(), false);
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

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
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
                c.a.d.f.p.n.N(this.a.f17686b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f17691g.s) {
                    this.a.f17691g.s = false;
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.thread_has_open);
                    if (this.a.f17693i != null) {
                        this.a.f17693i.m(this.a.f17686b.getString(c.a.t0.z2.g.set_thread_privacy));
                    }
                    if (this.a.f17690f != null) {
                        this.a.f17690f.a(false);
                        return;
                    }
                    return;
                }
                this.a.f17691g.s = true;
                if (this.a.f17693i != null) {
                    this.a.f17693i.m(this.a.f17686b.getString(c.a.t0.z2.g.set_thread_public_open));
                }
                if (this.a.f17690f != null) {
                    this.a.f17690f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.f17691g.f42383f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements j.d {
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

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.neterror);
                    return;
                }
                if (this.a.f17691g.s) {
                    if (this.a.f17691g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.f17691g.u != 1) {
                    if (this.a.f17691g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.f17691g);
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
    public class g implements j.d {
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

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.neterror);
                    return;
                }
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                e2 threadData = this.a.f17691g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.w1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{d2});
                k0.a(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements j.d {
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

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.neterror);
                    return;
                }
                if (this.a.f17691g != null && this.a.n != null) {
                    this.a.p();
                    this.a.f17689e.show();
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
                if (bVar.f48198c == 0) {
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.delete_success);
                    if (this.a.f17691g != null) {
                        if (c.a.d.f.p.m.isEmpty(this.a.f17691g.K)) {
                            if (c.a.d.f.p.m.isEmpty(this.a.f17691g.f42383f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.f17691g.f42383f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.f17691g.K));
                    }
                } else if (!c.a.d.f.p.m.isEmpty(bVar.f48197b)) {
                    c.a.d.f.p.n.N(this.a.f17686b, bVar.f48197b);
                } else {
                    c.a.d.f.p.n.M(this.a.f17686b, c.a.t0.z2.g.delete_fail);
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
        this.f17686b = tbPageContext.getPageActivity();
        this.f17692h = new ArrayList();
        this.f17688d = new c.a.s0.s.s.j(this.f17686b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.t0.f0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.s0.s.s.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f17691g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (gVar = this.f17693i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                gVar.m(this.f17686b.getString(c.a.t0.z2.g.set_thread_public_open));
            } else {
                e2 e2Var = cardPersonDynamicThreadData.t;
                if (e2Var != null && e2Var.P2()) {
                    if (this.f17692h.contains(this.f17693i)) {
                        this.f17692h.remove(this.f17693i);
                        this.f17688d.j(this.f17692h);
                    }
                } else {
                    this.f17693i.m(this.f17686b.getString(c.a.t0.z2.g.set_thread_privacy));
                }
            }
            this.f17693i.p(z);
            if (this.f17694j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f17694j.m(this.f17686b.getString(c.a.t0.z2.g.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f17691g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f17691g.getThreadData().w1())) {
                        this.f17694j.m(this.f17686b.getString(c.a.t0.z2.g.have_called_fans));
                    } else {
                        this.f17694j.m(this.f17686b.getString(c.a.t0.z2.g.call_fans));
                    }
                    this.f17694j.o(c.a.t0.z2.a.cp_cont_b_alpha33);
                }
                this.f17694j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f17687c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(this.f17686b.getString(c.a.t0.z2.g.heating_thread), this.f17688d);
                this.l = gVar;
                gVar.l(this.t);
                this.f17692h.add(this.l);
            }
            c.a.s0.s.s.g gVar2 = new c.a.s0.s.s.g(this.f17688d);
            this.f17693i = gVar2;
            gVar2.l(this.s);
            if (!this.o) {
                this.f17692h.add(this.f17693i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.s0.s.s.g gVar3 = new c.a.s0.s.s.g(this.f17686b.getString(c.a.t0.z2.g.call_fans), this.f17688d);
                this.f17694j = gVar3;
                gVar3.l(this.q);
                this.f17692h.add(this.f17694j);
            }
            c.a.s0.s.s.g gVar4 = new c.a.s0.s.s.g(this.f17686b.getString(c.a.t0.z2.g.delete), this.f17688d);
            this.k = gVar4;
            gVar4.l(this.u);
            this.f17692h.add(this.k);
            this.f17688d.m(new a(this));
            this.f17688d.j(this.f17692h);
            this.f17687c = new PopupDialog(this.a, this.f17688d);
        }
    }

    public final void p() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f17689e == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageActivity());
            this.f17689e = aVar;
            if (this.o) {
                aVar.setMessageId(c.a.t0.z2.g.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f17691g;
                if (cardPersonDynamicThreadData != null && (e2Var = cardPersonDynamicThreadData.t) != null && e2Var.Y1()) {
                    this.f17689e.setMessageId(c.a.t0.z2.g.del_work_thread_confirm);
                } else {
                    this.f17689e.setMessageId(c.a.t0.z2.g.del_thread_confirm);
                }
            }
            this.f17689e.setPositiveButton(c.a.t0.z2.g.dialog_ok, new c(this));
            this.f17689e.setNegativeButton(c.a.t0.z2.g.dialog_cancel, new d(this));
            this.f17689e.setCancelable(true);
            this.f17689e.create(this.a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f17687c) != null && popupDialog.isShowing()) {
            this.f17687c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.s0.s.s.j jVar = this.f17688d;
            if (jVar != null) {
                jVar.i();
            }
            c.a.s0.s.s.a aVar = this.f17689e;
            if (aVar != null) {
                c.a.s0.x0.a.a(this.a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f17690f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f17687c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
