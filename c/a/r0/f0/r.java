package c.a.r0.f0;

import android.content.Context;
import c.a.q0.r.r.e2;
import c.a.q0.r.t.a;
import c.a.q0.r.t.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17344b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f17345c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.r.t.j f17346d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.r.t.a f17347e;

    /* renamed from: f  reason: collision with root package name */
    public j f17348f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f17349g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.r.t.g> f17350h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.r.t.g f17351i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.r.t.g f17352j;
    public c.a.q0.r.t.g k;
    public c.a.q0.r.t.g l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.r0.e0.a p;
    public j.d q;
    public SetPrivacyModel.a r;
    public j.d s;
    public j.d t;
    public j.d u;
    public c.a.d.a.e v;

    /* loaded from: classes2.dex */
    public class a implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.q0.r.t.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.q0.r.t.j.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f17349g == null) {
                return;
            }
            this.a.q();
            int i3 = 2;
            if (this.a.f17349g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.a.f17349g.u;
                i2 = 1;
            }
            if (this.a.f17349g == null || !this.a.f17349g.s) {
                if (this.a.f17349g.getThreadData() != null) {
                    this.a.p.f(this.a.f17349g.getThreadData().w1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.a.f17349g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.f17349g.getThreadData().w1())) ? 1 : 1;
                this.a.p.b();
                if (this.a.f17349g.getThreadData() != null) {
                    this.a.p.d(i2, i3, this.a.f17349g.getThreadData().w1());
                    return;
                }
                return;
            }
            this.a.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.a.f17349g.getThreadData() != null) {
                this.a.p.d(i2, 3, this.a.f17349g.getThreadData().w1());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f17353e;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17353e = rVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f17353e.f17344b, R.string.neterror);
                    return;
                }
                if (this.f17353e.f17349g.u != 1) {
                    if (this.f17353e.f17349g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f17353e.o) {
                    this.f17353e.n.Q(this.f17353e.f17349g.t);
                }
                this.f17353e.n.S(this.f17353e.f17349g.f41018e, this.f17353e.f17349g.l, this.f17353e.f17349g.f41019f, this.f17353e.f17349g.f41022i, 0, 0, true, this.f17353e.f17349g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public e(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.d.f.p.n.N(this.a.f17344b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f17349g.s) {
                    this.a.f17349g.s = false;
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.thread_has_open);
                    if (this.a.f17351i != null) {
                        this.a.f17351i.m(this.a.f17344b.getString(R.string.set_thread_privacy));
                    }
                    if (this.a.f17348f != null) {
                        this.a.f17348f.a(false);
                        return;
                    }
                    return;
                }
                this.a.f17349g.s = true;
                if (this.a.f17351i != null) {
                    this.a.f17351i.m(this.a.f17344b.getString(R.string.set_thread_public_open));
                }
                if (this.a.f17348f != null) {
                    this.a.f17348f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.f17349g.f41019f));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public f(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.q0.r.t.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.neterror);
                    return;
                }
                if (this.a.f17349g.s) {
                    if (this.a.f17349g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.f17349g.u != 1) {
                    if (this.a.f17349g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.f17349g);
                }
                if (!this.a.m.C()) {
                    this.a.m.D(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public g(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.q0.r.t.j.d
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.neterror);
                    return;
                }
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                e2 threadData = this.a.f17349g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(threadData.w1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{jumpUrlWithTid});
                TiebaPlusConfigData.addClickStatsForFireLink(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public h(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.q0.r.t.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.neterror);
                    return;
                }
                if (this.a.f17349g != null && this.a.n != null) {
                    this.a.p();
                    this.a.f17347e.show();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public i(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f46779c == 0) {
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.delete_success);
                    if (this.a.f17349g != null) {
                        if (c.a.d.f.p.m.isEmpty(this.a.f17349g.K)) {
                            if (c.a.d.f.p.m.isEmpty(this.a.f17349g.f41019f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.f17349g.f41019f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.f17349g.K));
                    }
                } else if (!c.a.d.f.p.m.isEmpty(bVar.f46778b)) {
                    c.a.d.f.p.n.N(this.a.f17344b, bVar.f46778b);
                } else {
                    c.a.d.f.p.n.M(this.a.f17344b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(boolean z);
    }

    public r(TbPageContext tbPageContext) {
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
        this.f17344b = tbPageContext.getPageActivity();
        this.f17350h = new ArrayList();
        this.f17346d = new c.a.q0.r.t.j(this.f17344b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.r0.e0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.q0.r.t.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f17349g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (gVar = this.f17351i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                gVar.m(this.f17344b.getString(R.string.set_thread_public_open));
            } else {
                e2 e2Var = cardPersonDynamicThreadData.t;
                if (e2Var != null && e2Var.P2()) {
                    if (this.f17350h.contains(this.f17351i)) {
                        this.f17350h.remove(this.f17351i);
                        this.f17346d.j(this.f17350h);
                    }
                } else {
                    this.f17351i.m(this.f17344b.getString(R.string.set_thread_privacy));
                }
            }
            this.f17351i.q(z);
            if (this.f17352j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f17352j.m(this.f17344b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f17349g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f17349g.getThreadData().w1())) {
                        this.f17352j.m(this.f17344b.getString(R.string.have_called_fans));
                    } else {
                        this.f17352j.m(this.f17344b.getString(R.string.call_fans));
                    }
                    this.f17352j.p(R.color.cp_cont_b_alpha33);
                }
                this.f17352j.q(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f17345c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
                c.a.q0.r.t.g gVar = new c.a.q0.r.t.g(this.f17344b.getString(R.string.heating_thread), this.f17346d);
                this.l = gVar;
                gVar.l(this.t);
                this.f17350h.add(this.l);
            }
            c.a.q0.r.t.g gVar2 = new c.a.q0.r.t.g(this.f17346d);
            this.f17351i = gVar2;
            gVar2.l(this.s);
            if (!this.o) {
                this.f17350h.add(this.f17351i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.q0.r.t.g gVar3 = new c.a.q0.r.t.g(this.f17344b.getString(R.string.call_fans), this.f17346d);
                this.f17352j = gVar3;
                gVar3.l(this.q);
                this.f17350h.add(this.f17352j);
            }
            c.a.q0.r.t.g gVar4 = new c.a.q0.r.t.g(this.f17344b.getString(R.string.delete), this.f17346d);
            this.k = gVar4;
            gVar4.l(this.u);
            this.f17350h.add(this.k);
            this.f17346d.m(new a(this));
            this.f17346d.j(this.f17350h);
            this.f17345c = new PopupDialog(this.a, this.f17346d);
        }
    }

    public final void p() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f17347e == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.a.getPageActivity());
            this.f17347e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f17349g;
                if (cardPersonDynamicThreadData != null && (e2Var = cardPersonDynamicThreadData.t) != null && e2Var.Y1()) {
                    this.f17347e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f17347e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f17347e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f17347e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f17347e.setCancelable(true);
            this.f17347e.create(this.a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f17345c) != null && popupDialog.isShowing()) {
            this.f17345c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.r.t.j jVar = this.f17346d;
            if (jVar != null) {
                jVar.i();
            }
            c.a.q0.r.t.a aVar = this.f17347e;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f17348f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f17345c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
