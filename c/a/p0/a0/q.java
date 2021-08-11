package c.a.p0.a0;

import android.content.Context;
import c.a.o0.s.q.c2;
import c.a.o0.s.s.a;
import c.a.o0.s.s.i;
import c.a.o0.t.c.i0;
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
    public TbPageContext f15052a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15053b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f15054c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.s.s.i f15055d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.s.s.a f15056e;

    /* renamed from: f  reason: collision with root package name */
    public j f15057f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15058g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.o0.s.s.f> f15059h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.s.s.f f15060i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.s.s.f f15061j;
    public c.a.o0.s.s.f k;
    public c.a.o0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.p0.z.a p;
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
        public final /* synthetic */ q f15062a;

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
            this.f15062a = qVar;
        }

        @Override // c.a.o0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15062a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15063a;

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
            this.f15063a = qVar;
        }

        @Override // c.a.o0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15063a.f15058g == null) {
                return;
            }
            this.f15063a.q();
            int i3 = 2;
            if (this.f15063a.f15058g.s == 1) {
                i2 = 2;
            } else {
                int i4 = this.f15063a.f15058g.s;
                i2 = 1;
            }
            if (this.f15063a.f15058g == null || !this.f15063a.f15058g.q) {
                if (this.f15063a.f15058g.getThreadData() != null) {
                    this.f15063a.p.f(this.f15063a.f15058g.getThreadData().q1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f15063a.f15058g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f15063a.f15058g.getThreadData().q1())) ? 1 : 1;
                this.f15063a.p.b();
                if (this.f15063a.f15058g.getThreadData() != null) {
                    this.f15063a.p.d(i2, i3, this.f15063a.f15058g.getThreadData().q1());
                    return;
                }
                return;
            }
            this.f15063a.f15052a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f15063a.f15058g.getThreadData() != null) {
                this.f15063a.p.d(i2, 3, this.f15063a.f15058g.getThreadData().q1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f15064e;

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
            this.f15064e = qVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15064e.f15053b, R.string.neterror);
                    return;
                }
                if (this.f15064e.f15058g.s != 1) {
                    if (this.f15064e.f15058g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f15064e.o) {
                    this.f15064e.n.P(this.f15064e.f15058g.r);
                }
                this.f15064e.n.R(this.f15064e.f15058g.f49766e, this.f15064e.f15058g.f49771j, this.f15064e.f15058g.f49767f, this.f15064e.f15058g.f49768g, 0, 0, true, this.f15064e.f15058g.r.L(), false);
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

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
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
        public final /* synthetic */ q f15065a;

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
            this.f15065a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(this.f15065a.f15053b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15065a.f15058g.q) {
                    this.f15065a.f15058g.q = false;
                    c.a.e.e.p.l.L(this.f15065a.f15053b, R.string.thread_has_open);
                    if (this.f15065a.f15060i != null) {
                        this.f15065a.f15060i.m(this.f15065a.f15053b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f15065a.f15057f != null) {
                        this.f15065a.f15057f.a(false);
                        return;
                    }
                    return;
                }
                this.f15065a.f15058g.q = true;
                if (this.f15065a.f15060i != null) {
                    this.f15065a.f15060i.m(this.f15065a.f15053b.getString(R.string.set_thread_public_open));
                }
                if (this.f15065a.f15057f != null) {
                    this.f15065a.f15057f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f15065a.f15058g.f49767f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15066a;

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
            this.f15066a = qVar;
        }

        @Override // c.a.o0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15066a.f15053b, R.string.neterror);
                    return;
                }
                if (this.f15066a.f15058g.q) {
                    if (this.f15066a.f15058g.s == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f15066a.f15058g.s != 1) {
                    if (this.f15066a.f15058g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f15066a.m == null) {
                    this.f15066a.m = new SetPrivacyModel(this.f15066a.f15052a, this.f15066a.f15058g);
                }
                if (!this.f15066a.m.C()) {
                    this.f15066a.m.D(this.f15066a.r);
                    this.f15066a.m.LoadData();
                }
                this.f15066a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15067a;

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
            this.f15067a = qVar;
        }

        @Override // c.a.o0.s.s.i.d
        public void onClick() {
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15067a.f15053b, R.string.neterror);
                    return;
                }
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                c2 threadData = this.f15067a.f15058g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (b2 = tiebaPlusConfigData.b(threadData.q1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15067a.f15052a, new String[]{b2});
                this.f15067a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15068a;

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
            this.f15068a = qVar;
        }

        @Override // c.a.o0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15068a.f15053b, R.string.neterror);
                    return;
                }
                if (this.f15068a.f15058g != null && this.f15068a.n != null) {
                    this.f15068a.p();
                    this.f15068a.f15056e.show();
                }
                this.f15068a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f15069a;

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
            this.f15069a = qVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f56802c == 0) {
                    c.a.e.e.p.l.L(this.f15069a.f15053b, R.string.delete_success);
                    if (this.f15069a.f15058g != null) {
                        if (c.a.e.e.p.k.isEmpty(this.f15069a.f15058g.I)) {
                            if (c.a.e.e.p.k.isEmpty(this.f15069a.f15058g.f49767f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f15069a.f15058g.f49767f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f15069a.f15058g.I));
                    }
                } else if (!c.a.e.e.p.k.isEmpty(bVar.f56801b)) {
                    c.a.e.e.p.l.M(this.f15069a.f15053b, bVar.f56801b);
                } else {
                    c.a.e.e.p.l.L(this.f15069a.f15053b, R.string.delete_fail);
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
        this.f15052a = tbPageContext;
        this.f15053b = tbPageContext.getPageActivity();
        this.f15059h = new ArrayList();
        this.f15055d = new c.a.o0.s.s.i(this.f15053b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f15052a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.p0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.o0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15058g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f15060i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.q) {
                fVar.m(this.f15053b.getString(R.string.set_thread_public_open));
            } else {
                fVar.m(this.f15053b.getString(R.string.set_thread_privacy));
            }
            this.f15060i.o(z);
            if (this.f15061j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f15061j.m(this.f15053b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15058g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15058g.getThreadData().q1())) {
                        this.f15061j.m(this.f15053b.getString(R.string.have_called_fans));
                    } else {
                        this.f15061j.m(this.f15053b.getString(R.string.call_fans));
                    }
                    this.f15061j.n(R.color.cp_cont_b_alpha33);
                }
                this.f15061j.o(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15054c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().c()) {
                c.a.o0.s.s.f fVar = new c.a.o0.s.s.f(this.f15053b.getString(R.string.heating_thread), this.f15055d);
                this.l = fVar;
                fVar.l(this.t);
                this.f15059h.add(this.l);
            }
            c.a.o0.s.s.f fVar2 = new c.a.o0.s.s.f(this.f15055d);
            this.f15060i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f15059h.add(this.f15060i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.o0.s.s.f fVar3 = new c.a.o0.s.s.f(this.f15053b.getString(R.string.call_fans), this.f15055d);
                this.f15061j = fVar3;
                fVar3.l(this.q);
                this.f15059h.add(this.f15061j);
            }
            c.a.o0.s.s.f fVar4 = new c.a.o0.s.s.f(this.f15053b.getString(R.string.delete), this.f15055d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f15059h.add(this.k);
            this.f15055d.m(new a(this));
            this.f15055d.k(this.f15059h);
            this.f15054c = new PopupDialog(this.f15052a, this.f15055d);
        }
    }

    public final void p() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15056e == null) {
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f15052a.getPageActivity());
            this.f15056e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15058g;
                if (cardPersonDynamicThreadData != null && (c2Var = cardPersonDynamicThreadData.r) != null && c2Var.R1()) {
                    this.f15056e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f15056e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f15056e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f15056e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f15056e.setCancelable(true);
            this.f15056e.create(this.f15052a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f15054c) != null && popupDialog.isShowing()) {
            this.f15054c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.o0.s.s.i iVar = this.f15055d;
            if (iVar != null) {
                iVar.j();
            }
            c.a.o0.s.s.a aVar = this.f15056e;
            if (aVar != null) {
                c.a.o0.u0.a.a(this.f15052a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15057f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f15054c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
