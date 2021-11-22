package b.a.r0.h1.e.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.x0;
import b.a.r0.h1.e.b.a;
import b.a.r0.h1.e.b.b;
import b.a.r0.h1.e.d.b;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18587a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.h1.e.f.b f18588b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.h1.e.d.b f18589c;

    /* renamed from: d  reason: collision with root package name */
    public int f18590d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.e.b.a f18591e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.e.b.b f18592f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f18593g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18594h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f18595i;
    public final View.OnClickListener j;
    public f.g k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18596a;

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
            this.f18596a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18596a.p(customResponsedMessage);
                if (this.f18596a.f18588b != null) {
                    this.f18596a.f18588b.L();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18597a;

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
            this.f18597a = cVar;
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
            if (this.f18597a.f18588b != null) {
                this.f18597a.f18588b.N();
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
            TiebaStatic.log(new StatisticItem("c13499").param("fid", x0Var.c()).param("tid", x0Var.f()).param("obj_type", this.f18597a.f18590d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: b.a.r0.h1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0947c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18598e;

        public View$OnClickListenerC0947c(c cVar) {
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
            this.f18598e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18598e.f18588b.E()) {
                return;
            }
            this.f18598e.f18588b.Q(true);
            if (this.f18598e.f18592f.i()) {
                this.f18598e.f18592f.e();
                this.f18598e.f18588b.c0();
                SkinManager.setBackgroundResource(this.f18598e.f18588b.x(), R.color.CAM_X0207);
                return;
            }
            this.f18598e.f18592f.n(this.f18598e.f18588b.x());
            this.f18598e.f18588b.d0();
            SkinManager.setBackgroundResource(this.f18598e.f18588b.x(), R.color.CAM_X0201);
            if (this.f18598e.f18589c == null || ListUtils.isEmpty(this.f18598e.f18589c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18599e;

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
            this.f18599e = cVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f18599e.f18589c.q(this.f18599e.f18590d);
                    this.f18599e.u();
                    this.f18599e.f18588b.X(false);
                    return;
                }
                this.f18599e.f18588b.n0(null);
                this.f18599e.f18587a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18600e;

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
            this.f18600e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18600e.f18588b.f0();
                this.f18600e.f18589c.r(this.f18600e.f18590d);
                this.f18600e.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18601a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f18602e;

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
                this.f18602e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f18602e.f18601a.t();
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
            this.f18601a = cVar;
        }

        @Override // b.a.r0.h1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f18601a.f18588b.A();
                this.f18601a.f18588b.B();
                if (z || z2) {
                    this.f18601a.f18588b.n0(null);
                } else {
                    this.f18601a.f18588b.n0(this.f18601a.q(i2));
                }
                if (this.f18601a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.f18601a.f18589c.m()) && !StringUtils.isNull(b.a.q0.s.e0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.f18601a.f18588b.R(this.f18601a.f18592f.i());
                    this.f18601a.f18588b.e0();
                    this.f18601a.f18592f.l(this.f18601a.f18589c.m());
                }
                if (i2 != 0) {
                    this.f18601a.f18588b.S(this.f18601a.f18589c.l());
                    this.f18601a.f18588b.b0(this.f18601a.n);
                } else if (ListUtils.isEmpty(this.f18601a.f18588b.w())) {
                    this.f18601a.f18588b.i0();
                } else if (z) {
                    this.f18601a.f18588b.j0();
                }
            }
        }

        @Override // b.a.r0.h1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f18601a.f18588b.n0(null);
                this.f18601a.f18588b.A();
                this.f18601a.f18588b.B();
                if (ListUtils.isEmpty(this.f18601a.f18588b.w())) {
                    this.f18601a.f18588b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.f18601a.f18588b.b0(this.f18601a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.f18601a.f18587a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.f18601a.f18587a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18603e;

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
            this.f18603e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18603e.f18588b == null || this.f18603e.f18589c == null) {
                return;
            }
            this.f18603e.f18588b.f0();
            this.f18603e.f18589c.r(this.f18603e.f18590d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18604a;

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
            this.f18604a = cVar;
        }

        @Override // b.a.r0.h1.e.b.b.f
        public void a(b.a.r0.h1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f18604a.f18590d = aVar.f18606a;
            this.f18604a.m(aVar.f18606a);
            if (this.f18604a.f18588b != null) {
                this.f18604a.f18588b.U(aVar.f18606a);
                this.f18604a.f18588b.R(false);
                this.f18604a.f18588b.T(aVar.f18607b);
            }
        }

        @Override // b.a.r0.h1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18604a.f18588b == null) {
                return;
            }
            this.f18604a.f18588b.R(false);
            this.f18604a.f18588b.H(false);
        }

        @Override // b.a.r0.h1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f18604a.f18588b.H(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18605a;

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
            this.f18605a = cVar;
        }

        @Override // b.a.r0.h1.e.b.a.b
        public void a(b.a.r0.h1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f18605a.f18590d = aVar.f18606a;
            this.f18605a.m(aVar.f18606a);
            if (this.f18605a.f18588b != null) {
                this.f18605a.f18588b.U(aVar.f18606a);
                this.f18605a.f18588b.R(false);
                this.f18605a.f18588b.T(aVar.f18607b);
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
        this.f18594h = new a(this, 2016488);
        this.f18595i = new b(this);
        this.j = new View$OnClickListenerC0947c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.f18587a = tbPageContext;
        this.f18593g = bdUniqueId;
        this.f18588b = new b.a.r0.h1.e.f.b(tbPageContext, bdUniqueId, this.f18595i);
        this.f18589c = new b.a.r0.h1.e.d.b(this.f18587a, this.m);
        b.a.r0.h1.e.b.b bVar = new b.a.r0.h1.e.b.b(tbPageContext, this.f18593g);
        this.f18592f = bVar;
        bVar.m(this.o);
        b.a.r0.h1.e.b.a aVar = new b.a.r0.h1.e.b.a(tbPageContext, this.f18593g);
        this.f18591e = aVar;
        aVar.i(this.p);
        this.f18588b.W(this.j);
        int k = b.a.q0.s.e0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f18590d = k;
        this.f18588b.U(k);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            b.a.r0.h1.e.b.b bVar = this.f18592f;
            if (bVar != null) {
                bVar.p(i2);
            }
            b.a.r0.h1.e.d.b bVar2 = this.f18589c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.h1.e.f.b bVar = this.f18588b;
            if (bVar != null) {
                bVar.r();
            }
            b.a.r0.h1.e.b.b bVar2 = this.f18592f;
            if (bVar2 != null) {
                bVar2.j();
            }
            b.a.r0.h1.e.b.a aVar = this.f18591e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f18592f.i()) {
                SkinManager.setBackgroundResource(this.f18588b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f18588b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        b.a.r0.h1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.r0.h1.e.d.b bVar = this.f18589c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f18589c.o() || this.f18590d == 0) && (aVar = this.f18591e) != null) {
                aVar.h(this.f18589c.m());
                this.f18591e.c((ViewGroup) this.f18588b.y());
                b.a.q0.s.e0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
                b.a.q0.s.e0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        b.a.r0.h1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f18589c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f18589c.w(optString);
        this.f18589c.v(optString);
        b.a.r0.h1.e.f.b bVar2 = this.f18588b;
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
                string = this.f18587a.getResources().getString(R.string.game_video_no_more);
            } else {
                string = this.f18587a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.r0.h1.e.f.b bVar = this.f18588b;
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
            this.f18589c.u();
            this.f18588b.C();
            this.f18588b.V(this.k);
            this.f18588b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f18594h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.r0.h1.e.f.b bVar = this.f18588b;
            if (bVar != null) {
                bVar.s();
                this.f18588b.g0();
            }
            b.a.r0.h1.e.d.b bVar2 = this.f18589c;
            if (bVar2 != null) {
                bVar2.q(this.f18590d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f18590d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.r0.h1.e.f.b bVar = this.f18588b;
            if (bVar != null) {
                bVar.V(null);
                this.f18588b.Y(null);
                this.f18588b.I();
            }
            b.a.r0.h1.e.b.b bVar2 = this.f18592f;
            if (bVar2 != null) {
                bVar2.k();
            }
            b.a.r0.h1.e.b.a aVar = this.f18591e;
            if (aVar != null) {
                aVar.g();
            }
            b.a.r0.h1.e.d.b bVar3 = this.f18589c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f18594h);
        }
    }

    public void w() {
        b.a.r0.h1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f18588b) == null) {
            return;
        }
        bVar.J();
        this.f18588b.K();
        this.f18588b.Z(true);
    }

    public void x() {
        b.a.r0.h1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f18588b) == null) {
            return;
        }
        bVar.G();
        this.f18588b.l0();
        this.f18588b.X(false);
        this.f18588b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f18590d));
                if (this.f18592f.i()) {
                    return;
                }
                this.f18588b.a0();
                return;
            }
            b.a.r0.h1.e.b.b bVar = this.f18592f;
            if (bVar != null) {
                bVar.f();
            }
            this.f18588b.K();
        }
    }
}
