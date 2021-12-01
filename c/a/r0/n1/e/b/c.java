package c.a.r0.n1.e.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.q0.s.g0.f;
import c.a.q0.s.q.x0;
import c.a.r0.n1.e.b.a;
import c.a.r0.n1.e.b.b;
import c.a.r0.n1.e.d.b;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.n1.e.f.b f20292b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.n1.e.d.b f20293c;

    /* renamed from: d  reason: collision with root package name */
    public int f20294d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n1.e.b.a f20295e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n1.e.b.b f20296f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f20297g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f20298h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f20299i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f20300j;

    /* renamed from: k  reason: collision with root package name */
    public f.g f20301k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p(customResponsedMessage);
                if (this.a.f20292b != null) {
                    this.a.f20292b.L();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
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
            if (this.a.f20292b != null) {
                this.a.f20292b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", x0Var.c()).param("obj_param1", x0Var.f13093k).param("obj_source", x0Var.l).param("obj_id", x0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) || x0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", x0Var.c()).param("tid", x0Var.f()).param("obj_type", this.a.f20294d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: c.a.r0.n1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1206c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20302e;

        public View$OnClickListenerC1206c(c cVar) {
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
            this.f20302e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20302e.f20292b.E()) {
                return;
            }
            this.f20302e.f20292b.Q(true);
            if (this.f20302e.f20296f.i()) {
                this.f20302e.f20296f.e();
                this.f20302e.f20292b.c0();
                SkinManager.setBackgroundResource(this.f20302e.f20292b.x(), R.color.CAM_X0207);
                return;
            }
            this.f20302e.f20296f.n(this.f20302e.f20292b.x());
            this.f20302e.f20292b.d0();
            SkinManager.setBackgroundResource(this.f20302e.f20292b.x(), R.color.CAM_X0201);
            if (this.f20302e.f20293c == null || ListUtils.isEmpty(this.f20302e.f20293c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20303e;

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
            this.f20303e = cVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f20303e.f20293c.q(this.f20303e.f20294d);
                    this.f20303e.u();
                    this.f20303e.f20292b.X(false);
                    return;
                }
                this.f20303e.f20292b.n0(null);
                this.f20303e.a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20304e;

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
            this.f20304e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20304e.f20292b.f0();
                this.f20304e.f20293c.r(this.f20304e.f20294d);
                this.f20304e.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f20305e;

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
                this.f20305e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f20305e.a.t();
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
            this.a = cVar;
        }

        @Override // c.a.r0.n1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f20292b.A();
                this.a.f20292b.B();
                if (z || z2) {
                    this.a.f20292b.n0(null);
                } else {
                    this.a.f20292b.n0(this.a.q(i2));
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.f20293c.m()) && !StringUtils.isNull(c.a.q0.s.e0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.f20292b.R(this.a.f20296f.i());
                    this.a.f20292b.e0();
                    this.a.f20296f.l(this.a.f20293c.m());
                }
                if (i2 != 0) {
                    this.a.f20292b.S(this.a.f20293c.l());
                    this.a.f20292b.b0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.f20292b.w())) {
                    this.a.f20292b.i0();
                } else if (z) {
                    this.a.f20292b.j0();
                }
            }
        }

        @Override // c.a.r0.n1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.f20292b.n0(null);
                this.a.f20292b.A();
                this.a.f20292b.B();
                if (ListUtils.isEmpty(this.a.f20292b.w())) {
                    this.a.f20292b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.a.f20292b.b0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20306e;

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
            this.f20306e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20306e.f20292b == null || this.f20306e.f20293c == null) {
                return;
            }
            this.f20306e.f20292b.f0();
            this.f20306e.f20293c.r(this.f20306e.f20294d);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.r0.n1.e.b.b.f
        public void a(c.a.r0.n1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f20294d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f20292b != null) {
                this.a.f20292b.U(aVar.a);
                this.a.f20292b.R(false);
                this.a.f20292b.T(aVar.f20307b);
            }
        }

        @Override // c.a.r0.n1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f20292b == null) {
                return;
            }
            this.a.f20292b.R(false);
            this.a.f20292b.H(false);
        }

        @Override // c.a.r0.n1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f20292b.H(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.r0.n1.e.b.a.b
        public void a(c.a.r0.n1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f20294d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f20292b != null) {
                this.a.f20292b.U(aVar.a);
                this.a.f20292b.R(false);
                this.a.f20292b.T(aVar.f20307b);
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
        this.f20298h = new a(this, 2016488);
        this.f20299i = new b(this);
        this.f20300j = new View$OnClickListenerC1206c(this);
        this.f20301k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.f20297g = bdUniqueId;
        this.f20292b = new c.a.r0.n1.e.f.b(tbPageContext, bdUniqueId, this.f20299i);
        this.f20293c = new c.a.r0.n1.e.d.b(this.a, this.m);
        c.a.r0.n1.e.b.b bVar = new c.a.r0.n1.e.b.b(tbPageContext, this.f20297g);
        this.f20296f = bVar;
        bVar.m(this.o);
        c.a.r0.n1.e.b.a aVar = new c.a.r0.n1.e.b.a(tbPageContext, this.f20297g);
        this.f20295e = aVar;
        aVar.i(this.p);
        this.f20292b.W(this.f20300j);
        int k2 = c.a.q0.s.e0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f20294d = k2;
        this.f20292b.U(k2);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.r0.n1.e.b.b bVar = this.f20296f;
            if (bVar != null) {
                bVar.p(i2);
            }
            c.a.r0.n1.e.d.b bVar2 = this.f20293c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.n1.e.f.b bVar = this.f20292b;
            if (bVar != null) {
                bVar.r();
            }
            c.a.r0.n1.e.b.b bVar2 = this.f20296f;
            if (bVar2 != null) {
                bVar2.j();
            }
            c.a.r0.n1.e.b.a aVar = this.f20295e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f20296f.i()) {
                SkinManager.setBackgroundResource(this.f20292b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f20292b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        c.a.r0.n1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.n1.e.d.b bVar = this.f20293c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f20293c.o() || this.f20294d == 0) && (aVar = this.f20295e) != null) {
                aVar.h(this.f20293c.m());
                this.f20295e.c((ViewGroup) this.f20292b.y());
                c.a.q0.s.e0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
                c.a.q0.s.e0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.r0.n1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f20293c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f20293c.w(optString);
        this.f20293c.v(optString);
        c.a.r0.n1.e.f.b bVar2 = this.f20292b;
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
                string = this.a.getResources().getString(R.string.game_video_no_more);
            } else {
                string = this.a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.n1.e.f.b bVar = this.f20292b;
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
            this.f20293c.u();
            this.f20292b.C();
            this.f20292b.V(this.f20301k);
            this.f20292b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f20298h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.n1.e.f.b bVar = this.f20292b;
            if (bVar != null) {
                bVar.s();
                this.f20292b.g0();
            }
            c.a.r0.n1.e.d.b bVar2 = this.f20293c;
            if (bVar2 != null) {
                bVar2.q(this.f20294d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f20294d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.n1.e.f.b bVar = this.f20292b;
            if (bVar != null) {
                bVar.V(null);
                this.f20292b.Y(null);
                this.f20292b.I();
            }
            c.a.r0.n1.e.b.b bVar2 = this.f20296f;
            if (bVar2 != null) {
                bVar2.k();
            }
            c.a.r0.n1.e.b.a aVar = this.f20295e;
            if (aVar != null) {
                aVar.g();
            }
            c.a.r0.n1.e.d.b bVar3 = this.f20293c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f20298h);
        }
    }

    public void w() {
        c.a.r0.n1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f20292b) == null) {
            return;
        }
        bVar.J();
        this.f20292b.K();
        this.f20292b.Z(true);
    }

    public void x() {
        c.a.r0.n1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f20292b) == null) {
            return;
        }
        bVar.G();
        this.f20292b.l0();
        this.f20292b.X(false);
        this.f20292b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f20294d));
                if (this.f20296f.i()) {
                    return;
                }
                this.f20292b.a0();
                return;
            }
            c.a.r0.n1.e.b.b bVar = this.f20296f;
            if (bVar != null) {
                bVar.f();
            }
            this.f20292b.K();
        }
    }
}
