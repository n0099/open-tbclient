package c.a.p0.h0;

import android.content.Context;
import c.a.o0.r.t.a;
import c.a.o0.r.t.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
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
    public Context f15381b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.t.j f15382c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.t.l f15383d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.t.a f15384e;

    /* renamed from: f  reason: collision with root package name */
    public j f15385f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15386g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.o0.r.t.h> f15387h;
    public c.a.o0.r.t.h i;
    public c.a.o0.r.t.h j;
    public c.a.o0.r.t.h k;
    public c.a.o0.r.t.h l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.p0.g0.a p;
    public l.d q;
    public SetPrivacyModel.a r;
    public l.d s;
    public l.d t;
    public l.d u;
    public c.a.d.a.e v;

    /* loaded from: classes2.dex */
    public class a implements l.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f15386g == null) {
                return;
            }
            this.a.q();
            int i2 = 2;
            if (this.a.f15386g.q == 1) {
                i = 2;
            } else {
                int i3 = this.a.f15386g.q;
                i = 1;
            }
            if (this.a.f15386g == null || !this.a.f15386g.o) {
                if (this.a.f15386g.getThreadData() != null) {
                    this.a.p.f(this.a.f15386g.getThreadData().getTid());
                }
                i2 = (TbSingleton.getInstance().mCallFansTid == null || this.a.f15386g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.f15386g.getThreadData().getTid())) ? 1 : 1;
                this.a.p.b();
                if (this.a.f15386g.getThreadData() != null) {
                    this.a.p.d(i, i2, this.a.f15386g.getThreadData().getTid());
                    return;
                }
                return;
            }
            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0ec9);
            if (this.a.f15386g.getThreadData() != null) {
                this.a.p.d(i, 3, this.a.f15386g.getThreadData().getTid());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                if (this.a.f15386g.q != 1) {
                    if (this.a.f15386g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.a.o) {
                    this.a.n.S(this.a.f15386g.p);
                }
                this.a.n.U(this.a.f15386g.a, this.a.f15386g.f31676h, this.a.f15386g.f31670b, this.a.f15386g.f31673e, 0, 0, true, this.a.f15386g.p.getBaijiahaoData(), false);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                c.a.d.f.p.n.N(this.a.f15381b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f15386g.o) {
                    this.a.f15386g.o = false;
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f139a);
                    if (this.a.i != null) {
                        this.a.i.n(this.a.f15381b.getString(R.string.obfuscated_res_0x7f0f10ef));
                    }
                    if (this.a.f15385f != null) {
                        this.a.f15385f.a(false);
                        return;
                    }
                    return;
                }
                this.a.f15386g.o = true;
                if (this.a.i != null) {
                    this.a.i.n(this.a.f15381b.getString(R.string.obfuscated_res_0x7f0f10f0));
                }
                if (this.a.f15385f != null) {
                    this.a.f15385f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.f15386g.f31670b));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements l.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                if (this.a.f15386g.o) {
                    if (this.a.f15386g.q == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.f15386g.q != 1) {
                    if (this.a.f15386g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.f15386g);
                }
                if (!this.a.m.E()) {
                    this.a.m.F(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements l.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                ThreadData threadData = this.a.f15386g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(threadData.getTid())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{jumpUrlWithTid});
                TiebaPlusConfigData.addClickStatsForFireLink(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements l.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                if (this.a.f15386g != null && this.a.n != null) {
                    this.a.p();
                    this.a.f15384e.show();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (bVar.f36157c == 0) {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f049c);
                    if (this.a.f15386g != null) {
                        if (c.a.d.f.p.m.isEmpty(this.a.f15386g.G)) {
                            if (c.a.d.f.p.m.isEmpty(this.a.f15386g.f31670b)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.f15386g.f31670b));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.f15386g.G));
                    }
                } else if (!c.a.d.f.p.m.isEmpty(bVar.f36156b)) {
                    c.a.d.f.p.n.N(this.a.f15381b, bVar.f36156b);
                } else {
                    c.a.d.f.p.n.M(this.a.f15381b, R.string.obfuscated_res_0x7f0f0493);
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
        this.f15381b = tbPageContext.getPageActivity();
        this.f15387h = new ArrayList();
        this.f15383d = new c.a.o0.r.t.l(this.f15381b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.p0.g0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.o0.r.t.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15386g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (hVar = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                hVar.n(this.f15381b.getString(R.string.obfuscated_res_0x7f0f10f0));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.f15387h.contains(this.i)) {
                        this.f15387h.remove(this.i);
                        this.f15383d.j(this.f15387h);
                    }
                } else {
                    this.i.n(this.f15381b.getString(R.string.obfuscated_res_0x7f0f10ef));
                }
            }
            this.i.r(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.f15381b.getString(R.string.obfuscated_res_0x7f0f035f));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15386g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15386g.getThreadData().getTid())) {
                        this.j.n(this.f15381b.getString(R.string.obfuscated_res_0x7f0f0811));
                    } else {
                        this.j.n(this.f15381b.getString(R.string.obfuscated_res_0x7f0f035f));
                    }
                    this.j.q(R.color.cp_cont_b_alpha33);
                }
                this.j.r(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15382c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
                c.a.o0.r.t.h hVar = new c.a.o0.r.t.h(this.f15381b.getString(R.string.obfuscated_res_0x7f0f081b), this.f15383d);
                this.l = hVar;
                hVar.m(this.t);
                this.f15387h.add(this.l);
            }
            c.a.o0.r.t.h hVar2 = new c.a.o0.r.t.h(this.f15383d);
            this.i = hVar2;
            hVar2.m(this.s);
            if (!this.o) {
                this.f15387h.add(this.i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.o0.r.t.h hVar3 = new c.a.o0.r.t.h(this.f15381b.getString(R.string.obfuscated_res_0x7f0f035f), this.f15383d);
                this.j = hVar3;
                hVar3.m(this.q);
                this.f15387h.add(this.j);
            }
            c.a.o0.r.t.h hVar4 = new c.a.o0.r.t.h(this.f15381b.getString(R.string.obfuscated_res_0x7f0f048e), this.f15383d);
            this.k = hVar4;
            hVar4.m(this.u);
            this.f15387h.add(this.k);
            this.f15383d.m(new a(this));
            this.f15383d.j(this.f15387h);
            this.f15382c = new c.a.o0.r.t.j(this.a, this.f15383d);
        }
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15384e == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            this.f15384e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0485);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15386g;
                if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                    this.f15384e.setMessageId(R.string.obfuscated_res_0x7f0f048d);
                } else {
                    this.f15384e.setMessageId(R.string.obfuscated_res_0x7f0f048c);
                }
            }
            this.f15384e.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, new c(this));
            this.f15384e.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new d(this));
            this.f15384e.setCancelable(true);
            this.f15384e.create(this.a);
        }
    }

    public void q() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jVar = this.f15382c) != null && jVar.isShowing()) {
            this.f15382c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.o0.r.t.l lVar = this.f15383d;
            if (lVar != null) {
                lVar.i();
            }
            c.a.o0.r.t.a aVar = this.f15384e;
            if (aVar != null) {
                c.a.o0.w0.a.a(this.a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15385f = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jVar = this.f15382c) == null) {
            return;
        }
        jVar.m();
    }
}
