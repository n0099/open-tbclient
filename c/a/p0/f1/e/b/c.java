package c.a.p0.f1.e.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.o0.s.f0.f;
import c.a.o0.s.q.x0;
import c.a.p0.f1.e.b.a;
import c.a.p0.f1.e.b.b;
import c.a.p0.f1.e.d.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17129a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f1.e.f.b f17130b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.e.d.b f17131c;

    /* renamed from: d  reason: collision with root package name */
    public int f17132d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.e.b.a f17133e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f1.e.b.b f17134f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17135g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17136h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f17137i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f17138j;
    public f.g k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17139a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17139a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17139a.p(customResponsedMessage);
                if (this.f17139a.f17130b != null) {
                    this.f17139a.f17130b.L();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17140a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17140a = cVar;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || arrayList == null || x0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = x0Var.n;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49) {
                i2 = 3;
            }
            if (this.f17140a.f17130b != null) {
                this.f17140a.f17130b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", x0Var.c()).param("obj_param1", x0Var.k).param("obj_source", x0Var.l).param("obj_id", x0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) || x0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", x0Var.c()).param("tid", x0Var.f()).param("obj_type", this.f17140a.f17132d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: c.a.p0.f1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0834c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17141e;

        public View$OnClickListenerC0834c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17141e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17141e.f17130b.E()) {
                return;
            }
            this.f17141e.f17130b.Q(true);
            if (this.f17141e.f17134f.i()) {
                this.f17141e.f17134f.e();
                this.f17141e.f17130b.c0();
                SkinManager.setBackgroundResource(this.f17141e.f17130b.x(), R.color.CAM_X0207);
                return;
            }
            this.f17141e.f17134f.n(this.f17141e.f17130b.x());
            this.f17141e.f17130b.d0();
            SkinManager.setBackgroundResource(this.f17141e.f17130b.x(), R.color.CAM_X0201);
            if (this.f17141e.f17131c == null || ListUtils.isEmpty(this.f17141e.f17131c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17142e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17142e = cVar;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f17142e.f17131c.q(this.f17142e.f17132d);
                    this.f17142e.u();
                    this.f17142e.f17130b.X(false);
                    return;
                }
                this.f17142e.f17130b.n0(null);
                this.f17142e.f17129a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17143e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17143e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17143e.f17130b.f0();
                this.f17143e.f17131c.r(this.f17143e.f17132d);
                this.f17143e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17144a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f17145e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17145e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f17145e.f17144a.t();
                }
            }
        }

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17144a = cVar;
        }

        @Override // c.a.p0.f1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f17144a.f17130b.A();
                this.f17144a.f17130b.B();
                if (z || z2) {
                    this.f17144a.f17130b.n0(null);
                } else {
                    this.f17144a.f17130b.n0(this.f17144a.q(i2));
                }
                if (this.f17144a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.f17144a.f17131c.m()) && !StringUtils.isNull(c.a.o0.s.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.f17144a.f17130b.R(this.f17144a.f17134f.i());
                    this.f17144a.f17130b.e0();
                    this.f17144a.f17134f.l(this.f17144a.f17131c.m());
                }
                if (i2 != 0) {
                    this.f17144a.f17130b.S(this.f17144a.f17131c.l());
                    this.f17144a.f17130b.b0(this.f17144a.n);
                } else if (ListUtils.isEmpty(this.f17144a.f17130b.w())) {
                    this.f17144a.f17130b.i0();
                } else if (z) {
                    this.f17144a.f17130b.j0();
                }
            }
        }

        @Override // c.a.p0.f1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f17144a.f17130b.n0(null);
                this.f17144a.f17130b.A();
                this.f17144a.f17130b.B();
                if (ListUtils.isEmpty(this.f17144a.f17130b.w())) {
                    this.f17144a.f17130b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.f17144a.f17130b.b0(this.f17144a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.f17144a.f17129a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.f17144a.f17129a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17146e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17146e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17146e.f17130b == null || this.f17146e.f17131c == null) {
                return;
            }
            this.f17146e.f17130b.f0();
            this.f17146e.f17131c.r(this.f17146e.f17132d);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17147a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17147a = cVar;
        }

        @Override // c.a.p0.f1.e.b.b.f
        public void a(c.a.p0.f1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f17147a.f17132d = aVar.f17149a;
            this.f17147a.m(aVar.f17149a);
            if (this.f17147a.f17130b != null) {
                this.f17147a.f17130b.U(aVar.f17149a);
                this.f17147a.f17130b.R(false);
                this.f17147a.f17130b.T(aVar.f17150b);
            }
        }

        @Override // c.a.p0.f1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17147a.f17130b == null) {
                return;
            }
            this.f17147a.f17130b.R(false);
            this.f17147a.f17130b.H(false);
        }

        @Override // c.a.p0.f1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f17147a.f17130b.H(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17148a;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17148a = cVar;
        }

        @Override // c.a.p0.f1.e.b.a.b
        public void a(c.a.p0.f1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f17148a.f17132d = aVar.f17149a;
            this.f17148a.m(aVar.f17149a);
            if (this.f17148a.f17130b != null) {
                this.f17148a.f17130b.U(aVar.f17149a);
                this.f17148a.f17130b.R(false);
                this.f17148a.f17130b.T(aVar.f17150b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17136h = new a(this, 2016488);
        this.f17137i = new b(this);
        this.f17138j = new View$OnClickListenerC0834c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.f17129a = tbPageContext;
        this.f17135g = bdUniqueId;
        this.f17130b = new c.a.p0.f1.e.f.b(tbPageContext, bdUniqueId, this.f17137i);
        this.f17131c = new c.a.p0.f1.e.d.b(this.f17129a, this.m);
        c.a.p0.f1.e.b.b bVar = new c.a.p0.f1.e.b.b(tbPageContext, this.f17135g);
        this.f17134f = bVar;
        bVar.m(this.o);
        c.a.p0.f1.e.b.a aVar = new c.a.p0.f1.e.b.a(tbPageContext, this.f17135g);
        this.f17133e = aVar;
        aVar.i(this.p);
        this.f17130b.W(this.f17138j);
        int k = c.a.o0.s.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f17132d = k;
        this.f17130b.U(k);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.p0.f1.e.b.b bVar = this.f17134f;
            if (bVar != null) {
                bVar.p(i2);
            }
            c.a.p0.f1.e.d.b bVar2 = this.f17131c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.f1.e.f.b bVar = this.f17130b;
            if (bVar != null) {
                bVar.r();
            }
            c.a.p0.f1.e.b.b bVar2 = this.f17134f;
            if (bVar2 != null) {
                bVar2.j();
            }
            c.a.p0.f1.e.b.a aVar = this.f17133e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f17134f.i()) {
                SkinManager.setBackgroundResource(this.f17130b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f17130b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        c.a.p0.f1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.f1.e.d.b bVar = this.f17131c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f17131c.o() || this.f17132d == 0) && (aVar = this.f17133e) != null) {
                aVar.h(this.f17131c.m());
                this.f17133e.c((ViewGroup) this.f17130b.y());
                c.a.o0.s.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
                c.a.o0.s.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.f1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f17131c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f17131c.w(optString);
        this.f17131c.v(optString);
        c.a.p0.f1.e.f.b bVar2 = this.f17130b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.f17129a.getResources().getString(R.string.game_video_no_more);
            } else {
                string = this.f17129a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.f1.e.f.b bVar = this.f17130b;
            if (bVar != null) {
                return bVar.y();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17131c.u();
            this.f17130b.C();
            this.f17130b.V(this.k);
            this.f17130b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f17136h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.f1.e.f.b bVar = this.f17130b;
            if (bVar != null) {
                bVar.s();
                this.f17130b.g0();
            }
            c.a.p0.f1.e.d.b bVar2 = this.f17131c;
            if (bVar2 != null) {
                bVar2.q(this.f17132d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f17132d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.f1.e.f.b bVar = this.f17130b;
            if (bVar != null) {
                bVar.V(null);
                this.f17130b.Y(null);
                this.f17130b.I();
            }
            c.a.p0.f1.e.b.b bVar2 = this.f17134f;
            if (bVar2 != null) {
                bVar2.k();
            }
            c.a.p0.f1.e.b.a aVar = this.f17133e;
            if (aVar != null) {
                aVar.g();
            }
            c.a.p0.f1.e.d.b bVar3 = this.f17131c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f17136h);
        }
    }

    public void w() {
        c.a.p0.f1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f17130b) == null) {
            return;
        }
        bVar.J();
        this.f17130b.K();
        this.f17130b.Z(true);
    }

    public void x() {
        c.a.p0.f1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f17130b) == null) {
            return;
        }
        bVar.G();
        this.f17130b.l0();
        this.f17130b.X(false);
        this.f17130b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f17132d));
                if (this.f17134f.i()) {
                    return;
                }
                this.f17130b.a0();
                return;
            }
            c.a.p0.f1.e.b.b bVar = this.f17134f;
            if (bVar != null) {
                bVar.f();
            }
            this.f17130b.K();
        }
    }
}
