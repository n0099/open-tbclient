package c.a.r0.g0;

import android.content.Context;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.q0.t.c.k0;
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
/* loaded from: classes5.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17340b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f17341c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.i f17342d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f17343e;

    /* renamed from: f  reason: collision with root package name */
    public j f17344f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f17345g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f17346h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.s.f f17347i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.f f17348j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.s.s.f f17349k;
    public c.a.q0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.r0.f0.a p;
    public i.d q;
    public SetPrivacyModel.a r;
    public i.d s;
    public i.d t;
    public i.d u;
    public c.a.d.a.e v;

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f17345g == null) {
                return;
            }
            this.a.q();
            int i3 = 2;
            if (this.a.f17345g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.a.f17345g.u;
                i2 = 1;
            }
            if (this.a.f17345g == null || !this.a.f17345g.s) {
                if (this.a.f17345g.getThreadData() != null) {
                    this.a.p.f(this.a.f17345g.getThreadData().v1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.a.f17345g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.f17345g.getThreadData().v1())) ? 1 : 1;
                this.a.p.b();
                if (this.a.f17345g.getThreadData() != null) {
                    this.a.p.d(i2, i3, this.a.f17345g.getThreadData().v1());
                    return;
                }
                return;
            }
            this.a.a.showToast(c.a.r0.w2.g.privacy_thread_can_not_use_call_fans);
            if (this.a.f17345g.getThreadData() != null) {
                this.a.p.d(i2, 3, this.a.f17345g.getThreadData().v1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f17350e;

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
            this.f17350e = sVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.f17350e.f17340b, c.a.r0.w2.g.neterror);
                    return;
                }
                if (this.f17350e.f17345g.u != 1) {
                    if (this.f17350e.f17345g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f17350e.o) {
                    this.f17350e.n.Q(this.f17350e.f17345g.t);
                }
                this.f17350e.n.S(this.f17350e.f17345g.f43286e, this.f17350e.f17345g.l, this.f17350e.f17345g.f43287f, this.f17350e.f17345g.f43290i, 0, 0, true, this.f17350e.f17345g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                c.a.d.f.p.l.M(this.a.f17340b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f17345g.s) {
                    this.a.f17345g.s = false;
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.thread_has_open);
                    if (this.a.f17347i != null) {
                        this.a.f17347i.m(this.a.f17340b.getString(c.a.r0.w2.g.set_thread_privacy));
                    }
                    if (this.a.f17344f != null) {
                        this.a.f17344f.a(false);
                        return;
                    }
                    return;
                }
                this.a.f17345g.s = true;
                if (this.a.f17347i != null) {
                    this.a.f17347i.m(this.a.f17340b.getString(c.a.r0.w2.g.set_thread_public_open));
                }
                if (this.a.f17344f != null) {
                    this.a.f17344f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.f17345g.f43287f));
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.neterror);
                    return;
                }
                if (this.a.f17345g.s) {
                    if (this.a.f17345g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.f17345g.u != 1) {
                    if (this.a.f17345g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.f17345g);
                }
                if (!this.a.m.C()) {
                    this.a.m.D(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.neterror);
                    return;
                }
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.a.f17345g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.v1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{d2});
                k0.a(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.neterror);
                    return;
                }
                if (this.a.f17345g != null && this.a.n != null) {
                    this.a.p();
                    this.a.f17343e.show();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (bVar.f49313c == 0) {
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.delete_success);
                    if (this.a.f17345g != null) {
                        if (c.a.d.f.p.k.isEmpty(this.a.f17345g.K)) {
                            if (c.a.d.f.p.k.isEmpty(this.a.f17345g.f43287f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.f17345g.f43287f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.f17345g.K));
                    }
                } else if (!c.a.d.f.p.k.isEmpty(bVar.f49312b)) {
                    c.a.d.f.p.l.M(this.a.f17340b, bVar.f49312b);
                } else {
                    c.a.d.f.p.l.L(this.a.f17340b, c.a.r0.w2.g.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f17340b = tbPageContext.getPageActivity();
        this.f17346h = new ArrayList();
        this.f17342d = new c.a.q0.s.s.i(this.f17340b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.r0.f0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f17345g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f17347i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f17340b.getString(c.a.r0.w2.g.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.O2()) {
                    if (this.f17346h.contains(this.f17347i)) {
                        this.f17346h.remove(this.f17347i);
                        this.f17342d.j(this.f17346h);
                    }
                } else {
                    this.f17347i.m(this.f17340b.getString(c.a.r0.w2.g.set_thread_privacy));
                }
            }
            this.f17347i.p(z);
            if (this.f17348j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f17348j.m(this.f17340b.getString(c.a.r0.w2.g.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f17345g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f17345g.getThreadData().v1())) {
                        this.f17348j.m(this.f17340b.getString(c.a.r0.w2.g.have_called_fans));
                    } else {
                        this.f17348j.m(this.f17340b.getString(c.a.r0.w2.g.call_fans));
                    }
                    this.f17348j.o(c.a.r0.w2.a.cp_cont_b_alpha33);
                }
                this.f17348j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f17341c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f17340b.getString(c.a.r0.w2.g.heating_thread), this.f17342d);
                this.l = fVar;
                fVar.l(this.t);
                this.f17346h.add(this.l);
            }
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.f17342d);
            this.f17347i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f17346h.add(this.f17347i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(this.f17340b.getString(c.a.r0.w2.g.call_fans), this.f17342d);
                this.f17348j = fVar3;
                fVar3.l(this.q);
                this.f17346h.add(this.f17348j);
            }
            c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(this.f17340b.getString(c.a.r0.w2.g.delete), this.f17342d);
            this.f17349k = fVar4;
            fVar4.l(this.u);
            this.f17346h.add(this.f17349k);
            this.f17342d.l(new a(this));
            this.f17342d.j(this.f17346h);
            this.f17341c = new PopupDialog(this.a, this.f17342d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f17343e == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageActivity());
            this.f17343e = aVar;
            if (this.o) {
                aVar.setMessageId(c.a.r0.w2.g.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f17345g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.X1()) {
                    this.f17343e.setMessageId(c.a.r0.w2.g.del_work_thread_confirm);
                } else {
                    this.f17343e.setMessageId(c.a.r0.w2.g.del_thread_confirm);
                }
            }
            this.f17343e.setPositiveButton(c.a.r0.w2.g.dialog_ok, new c(this));
            this.f17343e.setNegativeButton(c.a.r0.w2.g.dialog_cancel, new d(this));
            this.f17343e.setCancelable(true);
            this.f17343e.create(this.a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f17341c) != null && popupDialog.isShowing()) {
            this.f17341c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.s.s.i iVar = this.f17342d;
            if (iVar != null) {
                iVar.i();
            }
            c.a.q0.s.s.a aVar = this.f17343e;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f17344f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f17341c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
