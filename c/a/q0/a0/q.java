package c.a.q0.a0;

import android.content.Context;
import c.a.p0.s.q.c2;
import c.a.p0.s.s.a;
import c.a.p0.s.s.i;
import c.a.p0.t.c.i0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
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
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15338a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15339b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f15340c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.s.s.i f15341d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.s.s.a f15342e;

    /* renamed from: f  reason: collision with root package name */
    public j f15343f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15344g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.p0.s.s.f> f15345h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.s.f f15346i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.s.f f15347j;
    public c.a.p0.s.s.f k;
    public c.a.p0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.q0.z.a p;
    public i.d q;
    public SetPrivacyModel.a r;
    public i.d s;
    public i.d t;
    public i.d u;
    public c.a.e.a.e v;

    /* loaded from: classes3.dex */
    public class a implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15348a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15348a = qVar;
        }

        @Override // c.a.p0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15348a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15349a;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15349a = qVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15349a.f15344g == null) {
                return;
            }
            this.f15349a.q();
            int i3 = 2;
            if (this.f15349a.f15344g.s == 1) {
                i2 = 2;
            } else {
                int i4 = this.f15349a.f15344g.s;
                i2 = 1;
            }
            if (this.f15349a.f15344g == null || !this.f15349a.f15344g.q) {
                if (this.f15349a.f15344g.getThreadData() != null) {
                    this.f15349a.p.f(this.f15349a.f15344g.getThreadData().q1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f15349a.f15344g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f15349a.f15344g.getThreadData().q1())) ? 1 : 1;
                this.f15349a.p.b();
                if (this.f15349a.f15344g.getThreadData() != null) {
                    this.f15349a.p.d(i2, i3, this.f15349a.f15344g.getThreadData().q1());
                    return;
                }
                return;
            }
            this.f15349a.f15338a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f15349a.f15344g.getThreadData() != null) {
                this.f15349a.p.d(i2, 3, this.f15349a.f15344g.getThreadData().q1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f15350e;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15350e = qVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15350e.f15339b, R.string.neterror);
                    return;
                }
                if (this.f15350e.f15344g.s != 1) {
                    if (this.f15350e.f15344g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f15350e.o) {
                    this.f15350e.n.P(this.f15350e.f15344g.r);
                }
                this.f15350e.n.R(this.f15350e.f15344g.f49874e, this.f15350e.f15344g.f49879j, this.f15350e.f15344g.f49875f, this.f15350e.f15344g.f49876g, 0, 0, true, this.f15350e.f15344g.r.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15351a;

        public e(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15351a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(this.f15351a.f15339b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15351a.f15344g.q) {
                    this.f15351a.f15344g.q = false;
                    c.a.e.e.p.l.L(this.f15351a.f15339b, R.string.thread_has_open);
                    if (this.f15351a.f15346i != null) {
                        this.f15351a.f15346i.m(this.f15351a.f15339b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f15351a.f15343f != null) {
                        this.f15351a.f15343f.a(false);
                        return;
                    }
                    return;
                }
                this.f15351a.f15344g.q = true;
                if (this.f15351a.f15346i != null) {
                    this.f15351a.f15346i.m(this.f15351a.f15339b.getString(R.string.set_thread_public_open));
                }
                if (this.f15351a.f15343f != null) {
                    this.f15351a.f15343f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f15351a.f15344g.f49875f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15352a;

        public f(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15352a = qVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15352a.f15339b, R.string.neterror);
                    return;
                }
                if (this.f15352a.f15344g.q) {
                    if (this.f15352a.f15344g.s == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f15352a.f15344g.s != 1) {
                    if (this.f15352a.f15344g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f15352a.m == null) {
                    this.f15352a.m = new SetPrivacyModel(this.f15352a.f15338a, this.f15352a.f15344g);
                }
                if (!this.f15352a.m.C()) {
                    this.f15352a.m.D(this.f15352a.r);
                    this.f15352a.m.LoadData();
                }
                this.f15352a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15353a;

        public g(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15353a = qVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15353a.f15339b, R.string.neterror);
                    return;
                }
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                c2 threadData = this.f15353a.f15344g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (b2 = tiebaPlusConfigData.b(threadData.q1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15353a.f15338a, new String[]{b2});
                this.f15353a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15354a;

        public h(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15354a = qVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15354a.f15339b, R.string.neterror);
                    return;
                }
                if (this.f15354a.f15344g != null && this.f15354a.n != null) {
                    this.f15354a.p();
                    this.f15354a.f15342e.show();
                }
                this.f15354a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15355a;

        public i(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15355a = qVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f56967c == 0) {
                    c.a.e.e.p.l.L(this.f15355a.f15339b, R.string.delete_success);
                    if (this.f15355a.f15344g != null) {
                        if (c.a.e.e.p.k.isEmpty(this.f15355a.f15344g.I)) {
                            if (c.a.e.e.p.k.isEmpty(this.f15355a.f15344g.f49875f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f15355a.f15344g.f49875f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f15355a.f15344g.I));
                    }
                } else if (!c.a.e.e.p.k.isEmpty(bVar.f56966b)) {
                    c.a.e.e.p.l.M(this.f15355a.f15339b, bVar.f56966b);
                } else {
                    c.a.e.e.p.l.L(this.f15355a.f15339b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z);
    }

    public q(TbPageContext tbPageContext) {
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
        this.f15338a = tbPageContext;
        this.f15339b = tbPageContext.getPageActivity();
        this.f15345h = new ArrayList();
        this.f15341d = new c.a.p0.s.s.i(this.f15339b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f15338a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.q0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.p0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15344g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f15346i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.q) {
                fVar.m(this.f15339b.getString(R.string.set_thread_public_open));
            } else {
                fVar.m(this.f15339b.getString(R.string.set_thread_privacy));
            }
            this.f15346i.o(z);
            if (this.f15347j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f15347j.m(this.f15339b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15344g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15344g.getThreadData().q1())) {
                        this.f15347j.m(this.f15339b.getString(R.string.have_called_fans));
                    } else {
                        this.f15347j.m(this.f15339b.getString(R.string.call_fans));
                    }
                    this.f15347j.n(R.color.cp_cont_b_alpha33);
                }
                this.f15347j.o(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15340c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().c()) {
                c.a.p0.s.s.f fVar = new c.a.p0.s.s.f(this.f15339b.getString(R.string.heating_thread), this.f15341d);
                this.l = fVar;
                fVar.l(this.t);
                this.f15345h.add(this.l);
            }
            c.a.p0.s.s.f fVar2 = new c.a.p0.s.s.f(this.f15341d);
            this.f15346i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f15345h.add(this.f15346i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.p0.s.s.f fVar3 = new c.a.p0.s.s.f(this.f15339b.getString(R.string.call_fans), this.f15341d);
                this.f15347j = fVar3;
                fVar3.l(this.q);
                this.f15345h.add(this.f15347j);
            }
            c.a.p0.s.s.f fVar4 = new c.a.p0.s.s.f(this.f15339b.getString(R.string.delete), this.f15341d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f15345h.add(this.k);
            this.f15341d.m(new a(this));
            this.f15341d.k(this.f15345h);
            this.f15340c = new PopupDialog(this.f15338a, this.f15341d);
        }
    }

    public final void p() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15342e == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f15338a.getPageActivity());
            this.f15342e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15344g;
                if (cardPersonDynamicThreadData != null && (c2Var = cardPersonDynamicThreadData.r) != null && c2Var.R1()) {
                    this.f15342e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f15342e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f15342e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f15342e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f15342e.setCancelable(true);
            this.f15342e.create(this.f15338a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f15340c) != null && popupDialog.isShowing()) {
            this.f15340c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.s.s.i iVar = this.f15341d;
            if (iVar != null) {
                iVar.j();
            }
            c.a.p0.s.s.a aVar = this.f15342e;
            if (aVar != null) {
                c.a.p0.u0.a.a(this.f15338a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15343f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f15340c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
