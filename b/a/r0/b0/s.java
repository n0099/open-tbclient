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
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f16335a;

    /* renamed from: b  reason: collision with root package name */
    public Context f16336b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f16337c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.s.i f16338d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.s.a f16339e;

    /* renamed from: f  reason: collision with root package name */
    public j f16340f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f16341g;

    /* renamed from: h  reason: collision with root package name */
    public List<b.a.q0.s.s.f> f16342h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.s.f f16343i;
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
        public final /* synthetic */ s f16344a;

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
            this.f16344a = sVar;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16344a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f16345a;

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
            this.f16345a = sVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16345a.f16341g == null) {
                return;
            }
            this.f16345a.q();
            int i3 = 2;
            if (this.f16345a.f16341g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.f16345a.f16341g.u;
                i2 = 1;
            }
            if (this.f16345a.f16341g == null || !this.f16345a.f16341g.s) {
                if (this.f16345a.f16341g.getThreadData() != null) {
                    this.f16345a.p.f(this.f16345a.f16341g.getThreadData().t1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f16345a.f16341g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f16345a.f16341g.getThreadData().t1())) ? 1 : 1;
                this.f16345a.p.b();
                if (this.f16345a.f16341g.getThreadData() != null) {
                    this.f16345a.p.d(i2, i3, this.f16345a.f16341g.getThreadData().t1());
                    return;
                }
                return;
            }
            this.f16345a.f16335a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f16345a.f16341g.getThreadData() != null) {
                this.f16345a.p.d(i2, 3, this.f16345a.f16341g.getThreadData().t1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f16346e;

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
            this.f16346e = sVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f16346e.f16336b, R.string.neterror);
                    return;
                }
                if (this.f16346e.f16341g.u != 1) {
                    if (this.f16346e.f16341g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f16346e.o) {
                    this.f16346e.n.Q(this.f16346e.f16341g.t);
                }
                this.f16346e.n.S(this.f16346e.f16341g.f48319e, this.f16346e.f16341g.l, this.f16346e.f16341g.f48320f, this.f16346e.f16341g.f48323i, 0, 0, true, this.f16346e.f16341g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public final /* synthetic */ s f16347a;

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
            this.f16347a = sVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.e.f.p.l.M(this.f16347a.f16336b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f16347a.f16341g.s) {
                    this.f16347a.f16341g.s = false;
                    b.a.e.f.p.l.L(this.f16347a.f16336b, R.string.thread_has_open);
                    if (this.f16347a.f16343i != null) {
                        this.f16347a.f16343i.m(this.f16347a.f16336b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f16347a.f16340f != null) {
                        this.f16347a.f16340f.a(false);
                        return;
                    }
                    return;
                }
                this.f16347a.f16341g.s = true;
                if (this.f16347a.f16343i != null) {
                    this.f16347a.f16343i.m(this.f16347a.f16336b.getString(R.string.set_thread_public_open));
                }
                if (this.f16347a.f16340f != null) {
                    this.f16347a.f16340f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f16347a.f16341g.f48320f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f16348a;

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
            this.f16348a = sVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f16348a.f16336b, R.string.neterror);
                    return;
                }
                if (this.f16348a.f16341g.s) {
                    if (this.f16348a.f16341g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f16348a.f16341g.u != 1) {
                    if (this.f16348a.f16341g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f16348a.m == null) {
                    this.f16348a.m = new SetPrivacyModel(this.f16348a.f16335a, this.f16348a.f16341g);
                }
                if (!this.f16348a.m.C()) {
                    this.f16348a.m.D(this.f16348a.r);
                    this.f16348a.m.loadData();
                }
                this.f16348a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f16349a;

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
            this.f16349a = sVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f16349a.f16336b, R.string.neterror);
                    return;
                }
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.f16349a.f16341g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.t1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f16349a.f16335a, new String[]{d2});
                k0.a(5);
                this.f16349a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f16350a;

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
            this.f16350a = sVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f16350a.f16336b, R.string.neterror);
                    return;
                }
                if (this.f16350a.f16341g != null && this.f16350a.n != null) {
                    this.f16350a.p();
                    this.f16350a.f16339e.show();
                }
                this.f16350a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f16351a;

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
            this.f16351a = sVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f55169c == 0) {
                    b.a.e.f.p.l.L(this.f16351a.f16336b, R.string.delete_success);
                    if (this.f16351a.f16341g != null) {
                        if (b.a.e.f.p.k.isEmpty(this.f16351a.f16341g.K)) {
                            if (b.a.e.f.p.k.isEmpty(this.f16351a.f16341g.f48320f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f16351a.f16341g.f48320f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f16351a.f16341g.K));
                    }
                } else if (!b.a.e.f.p.k.isEmpty(bVar.f55168b)) {
                    b.a.e.f.p.l.M(this.f16351a.f16336b, bVar.f55168b);
                } else {
                    b.a.e.f.p.l.L(this.f16351a.f16336b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f16335a = tbPageContext;
        this.f16336b = tbPageContext.getPageActivity();
        this.f16342h = new ArrayList();
        this.f16338d = new b.a.q0.s.s.i(this.f16336b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f16335a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new b.a.r0.a0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        b.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f16341g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f16343i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f16336b.getString(R.string.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.M2()) {
                    if (this.f16342h.contains(this.f16343i)) {
                        this.f16342h.remove(this.f16343i);
                        this.f16338d.j(this.f16342h);
                    }
                } else {
                    this.f16343i.m(this.f16336b.getString(R.string.set_thread_privacy));
                }
            }
            this.f16343i.p(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.m(this.f16336b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f16341g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f16341g.getThreadData().t1())) {
                        this.j.m(this.f16336b.getString(R.string.have_called_fans));
                    } else {
                        this.j.m(this.f16336b.getString(R.string.call_fans));
                    }
                    this.j.o(R.color.cp_cont_b_alpha33);
                }
                this.j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f16337c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(this.f16336b.getString(R.string.heating_thread), this.f16338d);
                this.l = fVar;
                fVar.l(this.t);
                this.f16342h.add(this.l);
            }
            b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(this.f16338d);
            this.f16343i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f16342h.add(this.f16343i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(this.f16336b.getString(R.string.call_fans), this.f16338d);
                this.j = fVar3;
                fVar3.l(this.q);
                this.f16342h.add(this.j);
            }
            b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(this.f16336b.getString(R.string.delete), this.f16338d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f16342h.add(this.k);
            this.f16338d.l(new a(this));
            this.f16338d.j(this.f16342h);
            this.f16337c = new PopupDialog(this.f16335a, this.f16338d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f16339e == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f16335a.getPageActivity());
            this.f16339e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f16341g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.W1()) {
                    this.f16339e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f16339e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f16339e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f16339e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f16339e.setCancelable(true);
            this.f16339e.create(this.f16335a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f16337c) != null && popupDialog.isShowing()) {
            this.f16337c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.s.s.i iVar = this.f16338d;
            if (iVar != null) {
                iVar.i();
            }
            b.a.q0.s.s.a aVar = this.f16339e;
            if (aVar != null) {
                b.a.q0.v0.a.a(this.f16335a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f16340f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f16337c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
