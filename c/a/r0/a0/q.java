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
    public TbPageContext f15665a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15666b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f15667c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.i f15668d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f15669e;

    /* renamed from: f  reason: collision with root package name */
    public j f15670f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15671g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f15672h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.s.f f15673i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.f f15674j;
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
        public final /* synthetic */ q f15675a;

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
            this.f15675a = qVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15675a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15676a;

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
            this.f15676a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15676a.f15671g == null) {
                return;
            }
            this.f15676a.q();
            int i3 = 2;
            if (this.f15676a.f15671g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.f15676a.f15671g.u;
                i2 = 1;
            }
            if (this.f15676a.f15671g == null || !this.f15676a.f15671g.s) {
                if (this.f15676a.f15671g.getThreadData() != null) {
                    this.f15676a.p.f(this.f15676a.f15671g.getThreadData().s1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f15676a.f15671g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f15676a.f15671g.getThreadData().s1())) ? 1 : 1;
                this.f15676a.p.b();
                if (this.f15676a.f15671g.getThreadData() != null) {
                    this.f15676a.p.d(i2, i3, this.f15676a.f15671g.getThreadData().s1());
                    return;
                }
                return;
            }
            this.f15676a.f15665a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f15676a.f15671g.getThreadData() != null) {
                this.f15676a.p.d(i2, 3, this.f15676a.f15671g.getThreadData().s1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f15677e;

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
            this.f15677e = qVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15677e.f15666b, R.string.neterror);
                    return;
                }
                if (this.f15677e.f15671g.u != 1) {
                    if (this.f15677e.f15671g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f15677e.o) {
                    this.f15677e.n.Q(this.f15677e.f15671g.t);
                }
                this.f15677e.n.S(this.f15677e.f15671g.f50120e, this.f15677e.f15671g.l, this.f15677e.f15671g.f50121f, this.f15677e.f15671g.f50124i, 0, 0, true, this.f15677e.f15671g.t.L(), false);
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
        public final /* synthetic */ q f15678a;

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
            this.f15678a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(this.f15678a.f15666b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15678a.f15671g.s) {
                    this.f15678a.f15671g.s = false;
                    c.a.e.e.p.l.L(this.f15678a.f15666b, R.string.thread_has_open);
                    if (this.f15678a.f15673i != null) {
                        this.f15678a.f15673i.m(this.f15678a.f15666b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f15678a.f15670f != null) {
                        this.f15678a.f15670f.a(false);
                        return;
                    }
                    return;
                }
                this.f15678a.f15671g.s = true;
                if (this.f15678a.f15673i != null) {
                    this.f15678a.f15673i.m(this.f15678a.f15666b.getString(R.string.set_thread_public_open));
                }
                if (this.f15678a.f15670f != null) {
                    this.f15678a.f15670f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f15678a.f15671g.f50121f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15679a;

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
            this.f15679a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15679a.f15666b, R.string.neterror);
                    return;
                }
                if (this.f15679a.f15671g.s) {
                    if (this.f15679a.f15671g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f15679a.f15671g.u != 1) {
                    if (this.f15679a.f15671g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f15679a.m == null) {
                    this.f15679a.m = new SetPrivacyModel(this.f15679a.f15665a, this.f15679a.f15671g);
                }
                if (!this.f15679a.m.C()) {
                    this.f15679a.m.D(this.f15679a.r);
                    this.f15679a.m.LoadData();
                }
                this.f15679a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15680a;

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
            this.f15680a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15680a.f15666b, R.string.neterror);
                    return;
                }
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.f15680a.f15671g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.s1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15680a.f15665a, new String[]{d2});
                i0.a(5);
                this.f15680a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15681a;

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
            this.f15681a = qVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15681a.f15666b, R.string.neterror);
                    return;
                }
                if (this.f15681a.f15671g != null && this.f15681a.n != null) {
                    this.f15681a.p();
                    this.f15681a.f15669e.show();
                }
                this.f15681a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15682a;

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
            this.f15682a = qVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f57244c == 0) {
                    c.a.e.e.p.l.L(this.f15682a.f15666b, R.string.delete_success);
                    if (this.f15682a.f15671g != null) {
                        if (c.a.e.e.p.k.isEmpty(this.f15682a.f15671g.K)) {
                            if (c.a.e.e.p.k.isEmpty(this.f15682a.f15671g.f50121f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f15682a.f15671g.f50121f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f15682a.f15671g.K));
                    }
                } else if (!c.a.e.e.p.k.isEmpty(bVar.f57243b)) {
                    c.a.e.e.p.l.M(this.f15682a.f15666b, bVar.f57243b);
                } else {
                    c.a.e.e.p.l.L(this.f15682a.f15666b, R.string.delete_fail);
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
        this.f15665a = tbPageContext;
        this.f15666b = tbPageContext.getPageActivity();
        this.f15672h = new ArrayList();
        this.f15668d = new c.a.q0.s.s.i(this.f15666b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f15665a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.r0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15671g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f15673i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f15666b.getString(R.string.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.K2()) {
                    if (this.f15672h.contains(this.f15673i)) {
                        this.f15672h.remove(this.f15673i);
                        this.f15668d.k(this.f15672h);
                    }
                } else {
                    this.f15673i.m(this.f15666b.getString(R.string.set_thread_privacy));
                }
            }
            this.f15673i.p(z);
            if (this.f15674j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f15674j.m(this.f15666b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15671g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15671g.getThreadData().s1())) {
                        this.f15674j.m(this.f15666b.getString(R.string.have_called_fans));
                    } else {
                        this.f15674j.m(this.f15666b.getString(R.string.call_fans));
                    }
                    this.f15674j.o(R.color.cp_cont_b_alpha33);
                }
                this.f15674j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15667c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f15666b.getString(R.string.heating_thread), this.f15668d);
                this.l = fVar;
                fVar.l(this.t);
                this.f15672h.add(this.l);
            }
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.f15668d);
            this.f15673i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f15672h.add(this.f15673i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(this.f15666b.getString(R.string.call_fans), this.f15668d);
                this.f15674j = fVar3;
                fVar3.l(this.q);
                this.f15672h.add(this.f15674j);
            }
            c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(this.f15666b.getString(R.string.delete), this.f15668d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f15672h.add(this.k);
            this.f15668d.m(new a(this));
            this.f15668d.k(this.f15672h);
            this.f15667c = new PopupDialog(this.f15665a, this.f15668d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15669e == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f15665a.getPageActivity());
            this.f15669e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15671g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.U1()) {
                    this.f15669e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f15669e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f15669e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f15669e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f15669e.setCancelable(true);
            this.f15669e.create(this.f15665a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f15667c) != null && popupDialog.isShowing()) {
            this.f15667c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.s.s.i iVar = this.f15668d;
            if (iVar != null) {
                iVar.j();
            }
            c.a.q0.s.s.a aVar = this.f15669e;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.f15665a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15670f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f15667c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
