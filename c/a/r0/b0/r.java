package c.a.r0.b0;

import android.content.Context;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.q0.t.c.j0;
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
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15821a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15822b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f15823c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.i f15824d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f15825e;

    /* renamed from: f  reason: collision with root package name */
    public j f15826f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f15827g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f15828h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.s.f f15829i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.f f15830j;
    public c.a.q0.s.s.f k;
    public c.a.q0.s.s.f l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public c.a.r0.a0.a p;
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
        public final /* synthetic */ r f15831a;

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
            this.f15831a = rVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15831a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f15832a;

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
            this.f15832a = rVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15832a.f15827g == null) {
                return;
            }
            this.f15832a.q();
            int i3 = 2;
            if (this.f15832a.f15827g.u == 1) {
                i2 = 2;
            } else {
                int i4 = this.f15832a.f15827g.u;
                i2 = 1;
            }
            if (this.f15832a.f15827g == null || !this.f15832a.f15827g.s) {
                if (this.f15832a.f15827g.getThreadData() != null) {
                    this.f15832a.p.f(this.f15832a.f15827g.getThreadData().s1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f15832a.f15827g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f15832a.f15827g.getThreadData().s1())) ? 1 : 1;
                this.f15832a.p.b();
                if (this.f15832a.f15827g.getThreadData() != null) {
                    this.f15832a.p.d(i2, i3, this.f15832a.f15827g.getThreadData().s1());
                    return;
                }
                return;
            }
            this.f15832a.f15821a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f15832a.f15827g.getThreadData() != null) {
                this.f15832a.p.d(i2, 3, this.f15832a.f15827g.getThreadData().s1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f15833e;

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
            this.f15833e = rVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15833e.f15822b, R.string.neterror);
                    return;
                }
                if (this.f15833e.f15827g.u != 1) {
                    if (this.f15833e.f15827g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f15833e.o) {
                    this.f15833e.n.Q(this.f15833e.f15827g.t);
                }
                this.f15833e.n.S(this.f15833e.f15827g.f50047e, this.f15833e.f15827g.l, this.f15833e.f15827g.f50048f, this.f15833e.f15827g.f50051i, 0, 0, true, this.f15833e.f15827g.t.L(), false);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public final /* synthetic */ r f15834a;

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
            this.f15834a = rVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(this.f15834a.f15822b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15834a.f15827g.s) {
                    this.f15834a.f15827g.s = false;
                    c.a.e.e.p.l.L(this.f15834a.f15822b, R.string.thread_has_open);
                    if (this.f15834a.f15829i != null) {
                        this.f15834a.f15829i.m(this.f15834a.f15822b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f15834a.f15826f != null) {
                        this.f15834a.f15826f.a(false);
                        return;
                    }
                    return;
                }
                this.f15834a.f15827g.s = true;
                if (this.f15834a.f15829i != null) {
                    this.f15834a.f15829i.m(this.f15834a.f15822b.getString(R.string.set_thread_public_open));
                }
                if (this.f15834a.f15826f != null) {
                    this.f15834a.f15826f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f15834a.f15827g.f50048f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f15835a;

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
            this.f15835a = rVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15835a.f15822b, R.string.neterror);
                    return;
                }
                if (this.f15835a.f15827g.s) {
                    if (this.f15835a.f15827g.u == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f15835a.f15827g.u != 1) {
                    if (this.f15835a.f15827g.u == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f15835a.m == null) {
                    this.f15835a.m = new SetPrivacyModel(this.f15835a.f15821a, this.f15835a.f15827g);
                }
                if (!this.f15835a.m.C()) {
                    this.f15835a.m.D(this.f15835a.r);
                    this.f15835a.m.loadData();
                }
                this.f15835a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f15836a;

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
            this.f15836a = rVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15836a.f15822b, R.string.neterror);
                    return;
                }
                j0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                d2 threadData = this.f15836a.f15827g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (d2 = tiebaPlusConfigData.d(threadData.s1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15836a.f15821a, new String[]{d2});
                j0.a(5);
                this.f15836a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f15837a;

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
            this.f15837a = rVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f15837a.f15822b, R.string.neterror);
                    return;
                }
                if (this.f15837a.f15827g != null && this.f15837a.n != null) {
                    this.f15837a.p();
                    this.f15837a.f15825e.show();
                }
                this.f15837a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f15838a;

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
            this.f15838a = rVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f57178c == 0) {
                    c.a.e.e.p.l.L(this.f15838a.f15822b, R.string.delete_success);
                    if (this.f15838a.f15827g != null) {
                        if (c.a.e.e.p.k.isEmpty(this.f15838a.f15827g.K)) {
                            if (c.a.e.e.p.k.isEmpty(this.f15838a.f15827g.f50048f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f15838a.f15827g.f50048f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f15838a.f15827g.K));
                    }
                } else if (!c.a.e.e.p.k.isEmpty(bVar.f57177b)) {
                    c.a.e.e.p.l.M(this.f15838a.f15822b, bVar.f57177b);
                } else {
                    c.a.e.e.p.l.L(this.f15838a.f15822b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f15821a = tbPageContext;
        this.f15822b = tbPageContext.getPageActivity();
        this.f15828h = new ArrayList();
        this.f15824d = new c.a.q0.s.s.i(this.f15822b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f15821a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new c.a.r0.a0.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        c.a.q0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f15827g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (fVar = this.f15829i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.s) {
                fVar.m(this.f15822b.getString(R.string.set_thread_public_open));
            } else {
                d2 d2Var = cardPersonDynamicThreadData.t;
                if (d2Var != null && d2Var.K2()) {
                    if (this.f15828h.contains(this.f15829i)) {
                        this.f15828h.remove(this.f15829i);
                        this.f15824d.k(this.f15828h);
                    }
                } else {
                    this.f15829i.m(this.f15822b.getString(R.string.set_thread_privacy));
                }
            }
            this.f15829i.p(z);
            if (this.f15830j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.f15830j.m(this.f15822b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f15827g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f15827g.getThreadData().s1())) {
                        this.f15830j.m(this.f15822b.getString(R.string.have_called_fans));
                    } else {
                        this.f15830j.m(this.f15822b.getString(R.string.call_fans));
                    }
                    this.f15830j.o(R.color.cp_cont_b_alpha33);
                }
                this.f15830j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f15823c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().f()) {
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f15822b.getString(R.string.heating_thread), this.f15824d);
                this.l = fVar;
                fVar.l(this.t);
                this.f15828h.add(this.l);
            }
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.f15824d);
            this.f15829i = fVar2;
            fVar2.l(this.s);
            if (!this.o) {
                this.f15828h.add(this.f15829i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(this.f15822b.getString(R.string.call_fans), this.f15824d);
                this.f15830j = fVar3;
                fVar3.l(this.q);
                this.f15828h.add(this.f15830j);
            }
            c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(this.f15822b.getString(R.string.delete), this.f15824d);
            this.k = fVar4;
            fVar4.l(this.u);
            this.f15828h.add(this.k);
            this.f15824d.m(new a(this));
            this.f15824d.k(this.f15828h);
            this.f15823c = new PopupDialog(this.f15821a, this.f15824d);
        }
    }

    public final void p() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15825e == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f15821a.getPageActivity());
            this.f15825e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f15827g;
                if (cardPersonDynamicThreadData != null && (d2Var = cardPersonDynamicThreadData.t) != null && d2Var.U1()) {
                    this.f15825e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f15825e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f15825e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f15825e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f15825e.setCancelable(true);
            this.f15825e.create(this.f15821a);
        }
    }

    public void q() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (popupDialog = this.f15823c) != null && popupDialog.isShowing()) {
            this.f15823c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.s.s.i iVar = this.f15824d;
            if (iVar != null) {
                iVar.j();
            }
            c.a.q0.s.s.a aVar = this.f15825e;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.f15821a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f15826f = jVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupDialog = this.f15823c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
