package b.a.r0.b0;

import android.content.Context;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.q0.t.c.k0;
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
/* loaded from: classes4.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f14843a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14844b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f14845c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.s.i f14846d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.s.a f14847e;

    /* renamed from: f  reason: collision with root package name */
    public j f14848f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f14849g;

    /* renamed from: h  reason: collision with root package name */
    public List<b.a.q0.s.s.f> f14850h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.s.f f14851i;
    public b.a.q0.s.s.f j;
    public b.a.q0.s.s.f k;
    public b.a.q0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public b.a.r0.a0.a p;
    public i.d q;
    public SetPrivacyModel.a r;
    public i.d s;
    public i.d t;
    public i.d u;
    public b.a.e.a.e v;

    /* loaded from: classes4.dex */
    public class a implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14852a;

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
            this.f14852a = rVar;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14852a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14853a;

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
            this.f14853a = rVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14853a.f14849g == null) {
                return;
            }
            this.f14853a.q();
            int i3 = 2;
            if (this.f14853a.f14849g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.f14853a.f14849g.u;
                i2 = 1;
            }
            if (this.f14853a.f14849g == null || !this.f14853a.f14849g.s) {
                if (this.f14853a.f14849g.getThreadData() != null) {
                    this.f14853a.p.f(this.f14853a.f14849g.getThreadData().s1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f14853a.f14849g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f14853a.f14849g.getThreadData().s1())) ? 1 : 1;
                this.f14853a.p.b();
                if (this.f14853a.f14849g.getThreadData() != null) {
                    this.f14853a.p.d(i2, i3, this.f14853a.f14849g.getThreadData().s1());
                    return;
                }
                return;
            }
            this.f14853a.f14843a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f14853a.f14849g.getThreadData() != null) {
                this.f14853a.p.d(i2, 3, this.f14853a.f14849g.getThreadData().s1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f14854e;

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
            this.f14854e = rVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f14854e.f14844b, R.string.neterror);
                    return;
                }
                if (this.f14854e.f14849g.u != 1) {
                    if (this.f14854e.f14849g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f14854e.o) {
                    this.f14854e.n.Q(this.f14854e.f14849g.t);
                }
                this.f14854e.n.S(this.f14854e.f14849g.f47456e, this.f14854e.f14849g.l, this.f14854e.f14849g.f47457f, this.f14854e.f14849g.f47460i, 0, 0, true, this.f14854e.f14849g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14855a;

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
            this.f14855a = rVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.e.e.p.l.M(this.f14855a.f14844b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f14855a.f14849g.s) {
                    this.f14855a.f14849g.s = false;
                    b.a.e.e.p.l.L(this.f14855a.f14844b, R.string.thread_has_open);
                    if (this.f14855a.f14851i != null) {
                        this.f14855a.f14851i.m(this.f14855a.f14844b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f14855a.f14848f != null) {
                        this.f14855a.f14848f.a(false);
                        return;
                    }
                    return;
                }
                this.f14855a.f14849g.s = true;
                if (this.f14855a.f14851i != null) {
                    this.f14855a.f14851i.m(this.f14855a.f14844b.getString(R.string.set_thread_public_open));
                }
                if (this.f14855a.f14848f != null) {
                    this.f14855a.f14848f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f14855a.f14849g.f47457f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14856a;

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
            this.f14856a = rVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f14856a.f14844b, R.string.neterror);
                    return;
                }
                if (this.f14856a.f14849g.s) {
                    if (this.f14856a.f14849g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f14856a.f14849g.u != 1) {
                    if (this.f14856a.f14849g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f14856a.m == null) {
                    this.f14856a.m = new SetPrivacyModel(this.f14856a.f14843a, this.f14856a.f14849g);
                }
                if (!this.f14856a.m.C()) {
                    this.f14856a.m.D(this.f14856a.r);
                    this.f14856a.m.loadData();
                }
                this.f14856a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14857a;

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
            this.f14857a = rVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f14857a.f14844b, R.string.neterror);
                    return;
                }
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.f14857a.f14849g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.s1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f14857a.f14843a, new String[]{d2});
                k0.a(5);
                this.f14857a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14858a;

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
            this.f14858a = rVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f14858a.f14844b, R.string.neterror);
                    return;
                }
                if (this.f14858a.f14849g != null && this.f14858a.n != null) {
                    this.f14858a.p();
                    this.f14858a.f14847e.show();
                }
                this.f14858a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f14859a;

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
            this.f14859a = rVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f54250c == 0) {
                    b.a.e.e.p.l.L(this.f14859a.f14844b, R.string.delete_success);
                    if (this.f14859a.f14849g != null) {
                        if (b.a.e.e.p.k.isEmpty(this.f14859a.f14849g.K)) {
                            if (b.a.e.e.p.k.isEmpty(this.f14859a.f14849g.f47457f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f14859a.f14849g.f47457f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f14859a.f14849g.K));
                    }
                } else if (!b.a.e.e.p.k.isEmpty(bVar.f54249b)) {
                    b.a.e.e.p.l.M(this.f14859a.f14844b, bVar.f54249b);
                } else {
                    b.a.e.e.p.l.L(this.f14859a.f14844b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f14843a = tbPageContext;
        this.f14844b = tbPageContext.getPageActivity();
        this.f14850h = new ArrayList();
        this.f14846d = new b.a.q0.s.s.i(this.f14844b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f14843a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new b.a.r0.a0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        b.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f14849g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f14851i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f14844b.getString(R.string.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.K2()) {
                    if (this.f14850h.contains(this.f14851i)) {
                        this.f14850h.remove(this.f14851i);
                        this.f14846d.j(this.f14850h);
                    }
                } else {
                    this.f14851i.m(this.f14844b.getString(R.string.set_thread_privacy));
                }
            }
            this.f14851i.p(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.m(this.f14844b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f14849g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f14849g.getThreadData().s1())) {
                        this.j.m(this.f14844b.getString(R.string.have_called_fans));
                    } else {
                        this.j.m(this.f14844b.getString(R.string.call_fans));
                    }
                    this.j.o(R.color.cp_cont_b_alpha33);
                }
                this.j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f14845c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(this.f14844b.getString(R.string.heating_thread), this.f14846d);
                this.l = fVar;
                fVar.l(this.t);
                this.f14850h.add(this.l);
            }
            b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(this.f14846d);
            this.f14851i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f14850h.add(this.f14851i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(this.f14844b.getString(R.string.call_fans), this.f14846d);
                this.j = fVar3;
                fVar3.l(this.q);
                this.f14850h.add(this.j);
            }
            b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(this.f14844b.getString(R.string.delete), this.f14846d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f14850h.add(this.k);
            this.f14846d.l(new a(this));
            this.f14846d.j(this.f14850h);
            this.f14845c = new PopupDialog(this.f14843a, this.f14846d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f14847e == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f14843a.getPageActivity());
            this.f14847e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f14849g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.U1()) {
                    this.f14847e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f14847e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f14847e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f14847e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f14847e.setCancelable(true);
            this.f14847e.create(this.f14843a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f14845c) != null && popupDialog.isShowing()) {
            this.f14845c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.s.s.i iVar = this.f14846d;
            if (iVar != null) {
                iVar.i();
            }
            b.a.q0.s.s.a aVar = this.f14847e;
            if (aVar != null) {
                b.a.q0.w0.a.a(this.f14843a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f14848f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f14845c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
