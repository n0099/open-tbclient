package c.a.r0.a0;

import android.content.Context;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.q0.t.c.i0;
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
    public TbPageContext f15655a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15656b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f15657c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.i f15658d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f15659e;

    /* renamed from: f  reason: collision with root package name */
    public j f15660f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15661g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f15662h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.s.f f15663i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.f f15664j;
    public c.a.q0.s.s.f k;
    public c.a.q0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.r0.z.a p;
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
        public final /* synthetic */ q f15665a;

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
            this.f15665a = qVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15665a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15666a;

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
            this.f15666a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15666a.f15661g == null) {
                return;
            }
            this.f15666a.q();
            int i3 = 2;
            if (this.f15666a.f15661g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.f15666a.f15661g.u;
                i2 = 1;
            }
            if (this.f15666a.f15661g == null || !this.f15666a.f15661g.s) {
                if (this.f15666a.f15661g.getThreadData() != null) {
                    this.f15666a.p.f(this.f15666a.f15661g.getThreadData().s1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f15666a.f15661g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f15666a.f15661g.getThreadData().s1())) ? 1 : 1;
                this.f15666a.p.b();
                if (this.f15666a.f15661g.getThreadData() != null) {
                    this.f15666a.p.d(i2, i3, this.f15666a.f15661g.getThreadData().s1());
                    return;
                }
                return;
            }
            this.f15666a.f15655a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f15666a.f15661g.getThreadData() != null) {
                this.f15666a.p.d(i2, 3, this.f15666a.f15661g.getThreadData().s1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f15667e;

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
            this.f15667e = qVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15667e.f15656b, R.string.neterror);
                    return;
                }
                if (this.f15667e.f15661g.u != 1) {
                    if (this.f15667e.f15661g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f15667e.o) {
                    this.f15667e.n.Q(this.f15667e.f15661g.t);
                }
                this.f15667e.n.S(this.f15667e.f15661g.f50009e, this.f15667e.f15661g.l, this.f15667e.f15661g.f50010f, this.f15667e.f15661g.f50013i, 0, 0, true, this.f15667e.f15661g.t.L(), false);
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
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
        public final /* synthetic */ q f15668a;

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
            this.f15668a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(this.f15668a.f15656b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15668a.f15661g.s) {
                    this.f15668a.f15661g.s = false;
                    c.a.e.e.p.l.L(this.f15668a.f15656b, R.string.thread_has_open);
                    if (this.f15668a.f15663i != null) {
                        this.f15668a.f15663i.m(this.f15668a.f15656b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f15668a.f15660f != null) {
                        this.f15668a.f15660f.a(false);
                        return;
                    }
                    return;
                }
                this.f15668a.f15661g.s = true;
                if (this.f15668a.f15663i != null) {
                    this.f15668a.f15663i.m(this.f15668a.f15656b.getString(R.string.set_thread_public_open));
                }
                if (this.f15668a.f15660f != null) {
                    this.f15668a.f15660f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f15668a.f15661g.f50010f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15669a;

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
            this.f15669a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15669a.f15656b, R.string.neterror);
                    return;
                }
                if (this.f15669a.f15661g.s) {
                    if (this.f15669a.f15661g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f15669a.f15661g.u != 1) {
                    if (this.f15669a.f15661g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f15669a.m == null) {
                    this.f15669a.m = new SetPrivacyModel(this.f15669a.f15655a, this.f15669a.f15661g);
                }
                if (!this.f15669a.m.C()) {
                    this.f15669a.m.D(this.f15669a.r);
                    this.f15669a.m.LoadData();
                }
                this.f15669a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15670a;

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
            this.f15670a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            String c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15670a.f15656b, R.string.neterror);
                    return;
                }
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.f15670a.f15661g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (c2 = tiebaPlusConfigData.c(threadData.s1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15670a.f15655a, new String[]{c2});
                this.f15670a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15671a;

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
            this.f15671a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15671a.f15656b, R.string.neterror);
                    return;
                }
                if (this.f15671a.f15661g != null && this.f15671a.n != null) {
                    this.f15671a.p();
                    this.f15671a.f15659e.show();
                }
                this.f15671a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15672a;

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
            this.f15672a = qVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f57127c == 0) {
                    c.a.e.e.p.l.L(this.f15672a.f15656b, R.string.delete_success);
                    if (this.f15672a.f15661g != null) {
                        if (c.a.e.e.p.k.isEmpty(this.f15672a.f15661g.K)) {
                            if (c.a.e.e.p.k.isEmpty(this.f15672a.f15661g.f50010f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f15672a.f15661g.f50010f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f15672a.f15661g.K));
                    }
                } else if (!c.a.e.e.p.k.isEmpty(bVar.f57126b)) {
                    c.a.e.e.p.l.M(this.f15672a.f15656b, bVar.f57126b);
                } else {
                    c.a.e.e.p.l.L(this.f15672a.f15656b, R.string.delete_fail);
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
        this.f15655a = tbPageContext;
        this.f15656b = tbPageContext.getPageActivity();
        this.f15662h = new ArrayList();
        this.f15658d = new c.a.q0.s.s.i(this.f15656b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f15655a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.r0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15661g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f15663i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f15656b.getString(R.string.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.K2()) {
                    if (this.f15662h.contains(this.f15663i)) {
                        this.f15662h.remove(this.f15663i);
                        this.f15658d.k(this.f15662h);
                    }
                } else {
                    this.f15663i.m(this.f15656b.getString(R.string.set_thread_privacy));
                }
            }
            this.f15663i.p(z);
            if (this.f15664j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f15664j.m(this.f15656b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15661g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15661g.getThreadData().s1())) {
                        this.f15664j.m(this.f15656b.getString(R.string.have_called_fans));
                    } else {
                        this.f15664j.m(this.f15656b.getString(R.string.call_fans));
                    }
                    this.f15664j.o(R.color.cp_cont_b_alpha33);
                }
                this.f15664j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15657c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().e()) {
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f15656b.getString(R.string.heating_thread), this.f15658d);
                this.l = fVar;
                fVar.l(this.t);
                this.f15662h.add(this.l);
            }
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.f15658d);
            this.f15663i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f15662h.add(this.f15663i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(this.f15656b.getString(R.string.call_fans), this.f15658d);
                this.f15664j = fVar3;
                fVar3.l(this.q);
                this.f15662h.add(this.f15664j);
            }
            c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(this.f15656b.getString(R.string.delete), this.f15658d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f15662h.add(this.k);
            this.f15658d.m(new a(this));
            this.f15658d.k(this.f15662h);
            this.f15657c = new PopupDialog(this.f15655a, this.f15658d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15659e == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f15655a.getPageActivity());
            this.f15659e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15661g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.U1()) {
                    this.f15659e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f15659e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f15659e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f15659e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f15659e.setCancelable(true);
            this.f15659e.create(this.f15655a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f15657c) != null && popupDialog.isShowing()) {
            this.f15657c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.s.s.i iVar = this.f15658d;
            if (iVar != null) {
                iVar.j();
            }
            c.a.q0.s.s.a aVar = this.f15659e;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.f15655a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15660f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f15657c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
