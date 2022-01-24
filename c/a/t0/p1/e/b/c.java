package c.a.t0.p1.e.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.s0.s.k0.f;
import c.a.s0.s.q.x0;
import c.a.t0.p1.e.b.a;
import c.a.t0.p1.e.b.b;
import c.a.t0.p1.e.d.b;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.p1.e.f.b f20619b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.p1.e.d.b f20620c;

    /* renamed from: d  reason: collision with root package name */
    public int f20621d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.p1.e.b.a f20622e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.p1.e.b.b f20623f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f20624g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f20625h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f20626i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f20627j;
    public f.g k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes8.dex */
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
                if (this.a.f20619b != null) {
                    this.a.f20619b.L();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (this.a.f20619b != null) {
                this.a.f20619b.N();
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
            TiebaStatic.log(new StatisticItem("c13499").param("fid", x0Var.c()).param("tid", x0Var.f()).param("obj_type", this.a.f20621d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: c.a.t0.p1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1288c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20628e;

        public View$OnClickListenerC1288c(c cVar) {
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
            this.f20628e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20628e.f20619b.E()) {
                return;
            }
            this.f20628e.f20619b.Q(true);
            if (this.f20628e.f20623f.i()) {
                this.f20628e.f20623f.e();
                this.f20628e.f20619b.c0();
                SkinManager.setBackgroundResource(this.f20628e.f20619b.x(), R.color.CAM_X0207);
                return;
            }
            this.f20628e.f20623f.n(this.f20628e.f20619b.x());
            this.f20628e.f20619b.d0();
            SkinManager.setBackgroundResource(this.f20628e.f20619b.x(), R.color.CAM_X0201);
            if (this.f20628e.f20620c == null || ListUtils.isEmpty(this.f20628e.f20620c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20629e;

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
            this.f20629e = cVar;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.f20629e.f20620c.q(this.f20629e.f20621d);
                    this.f20629e.u();
                    this.f20629e.f20619b.X(false);
                    return;
                }
                this.f20629e.f20619b.n0(null);
                this.f20629e.a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20630e;

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
            this.f20630e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20630e.f20619b.f0();
                this.f20630e.f20620c.r(this.f20630e.f20621d);
                this.f20630e.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f20631e;

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
                this.f20631e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f20631e.a.t();
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

        @Override // c.a.t0.p1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f20619b.A();
                this.a.f20619b.B();
                if (z || z2) {
                    this.a.f20619b.n0(null);
                } else {
                    this.a.f20619b.n0(this.a.q(i2));
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.f20620c.m()) && !StringUtils.isNull(c.a.s0.s.i0.b.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.f20619b.R(this.a.f20623f.i());
                    this.a.f20619b.e0();
                    this.a.f20623f.l(this.a.f20620c.m());
                }
                if (i2 != 0) {
                    this.a.f20619b.S(this.a.f20620c.l());
                    this.a.f20619b.b0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.f20619b.w())) {
                    this.a.f20619b.i0();
                } else if (z) {
                    this.a.f20619b.j0();
                }
            }
        }

        @Override // c.a.t0.p1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.f20619b.n0(null);
                this.a.f20619b.A();
                this.a.f20619b.B();
                if (ListUtils.isEmpty(this.a.f20619b.w())) {
                    this.a.f20619b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.a.f20619b.b0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20632e;

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
            this.f20632e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20632e.f20619b == null || this.f20632e.f20620c == null) {
                return;
            }
            this.f20632e.f20619b.f0();
            this.f20632e.f20620c.r(this.f20632e.f20621d);
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // c.a.t0.p1.e.b.b.f
        public void a(c.a.t0.p1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f20621d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f20619b != null) {
                this.a.f20619b.U(aVar.a);
                this.a.f20619b.R(false);
                this.a.f20619b.T(aVar.f20633b);
            }
        }

        @Override // c.a.t0.p1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f20619b == null) {
                return;
            }
            this.a.f20619b.R(false);
            this.a.f20619b.H(false);
        }

        @Override // c.a.t0.p1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f20619b.H(true);
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // c.a.t0.p1.e.b.a.b
        public void a(c.a.t0.p1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f20621d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f20619b != null) {
                this.a.f20619b.U(aVar.a);
                this.a.f20619b.R(false);
                this.a.f20619b.T(aVar.f20633b);
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
        this.f20625h = new a(this, 2016488);
        this.f20626i = new b(this);
        this.f20627j = new View$OnClickListenerC1288c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.f20624g = bdUniqueId;
        this.f20619b = new c.a.t0.p1.e.f.b(tbPageContext, bdUniqueId, this.f20626i);
        this.f20620c = new c.a.t0.p1.e.d.b(this.a, this.m);
        c.a.t0.p1.e.b.b bVar = new c.a.t0.p1.e.b.b(tbPageContext, this.f20624g);
        this.f20623f = bVar;
        bVar.m(this.o);
        c.a.t0.p1.e.b.a aVar = new c.a.t0.p1.e.b.a(tbPageContext, this.f20624g);
        this.f20622e = aVar;
        aVar.i(this.p);
        this.f20619b.W(this.f20627j);
        int l = c.a.s0.s.i0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f20621d = l;
        this.f20619b.U(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.t0.p1.e.b.b bVar = this.f20623f;
            if (bVar != null) {
                bVar.p(i2);
            }
            c.a.t0.p1.e.d.b bVar2 = this.f20620c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.p1.e.f.b bVar = this.f20619b;
            if (bVar != null) {
                bVar.r();
            }
            c.a.t0.p1.e.b.b bVar2 = this.f20623f;
            if (bVar2 != null) {
                bVar2.j();
            }
            c.a.t0.p1.e.b.a aVar = this.f20622e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f20623f.i()) {
                SkinManager.setBackgroundResource(this.f20619b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f20619b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        c.a.t0.p1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.t0.p1.e.d.b bVar = this.f20620c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f20620c.o() || this.f20621d == 0) && (aVar = this.f20622e) != null) {
                aVar.h(this.f20620c.m());
                this.f20622e.c((ViewGroup) this.f20619b.y());
                c.a.s0.s.i0.b.k().D("key_game_video_tab_has_choosed_sub_class_id");
                c.a.s0.s.i0.b.k().D("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.t0.p1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f20620c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f20620c.w(optString);
        this.f20620c.v(optString);
        c.a.t0.p1.e.f.b bVar2 = this.f20619b;
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
            c.a.t0.p1.e.f.b bVar = this.f20619b;
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
            this.f20620c.u();
            this.f20619b.C();
            this.f20619b.V(this.k);
            this.f20619b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f20625h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.p1.e.f.b bVar = this.f20619b;
            if (bVar != null) {
                bVar.s();
                this.f20619b.g0();
            }
            c.a.t0.p1.e.d.b bVar2 = this.f20620c;
            if (bVar2 != null) {
                bVar2.q(this.f20621d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f20621d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.p1.e.f.b bVar = this.f20619b;
            if (bVar != null) {
                bVar.V(null);
                this.f20619b.Y(null);
                this.f20619b.I();
            }
            c.a.t0.p1.e.b.b bVar2 = this.f20623f;
            if (bVar2 != null) {
                bVar2.k();
            }
            c.a.t0.p1.e.b.a aVar = this.f20622e;
            if (aVar != null) {
                aVar.g();
            }
            c.a.t0.p1.e.d.b bVar3 = this.f20620c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f20625h);
        }
    }

    public void w() {
        c.a.t0.p1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f20619b) == null) {
            return;
        }
        bVar.J();
        this.f20619b.K();
        this.f20619b.Z(true);
    }

    public void x() {
        c.a.t0.p1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f20619b) == null) {
            return;
        }
        bVar.G();
        this.f20619b.l0();
        this.f20619b.X(false);
        this.f20619b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f20621d));
                if (this.f20623f.i()) {
                    return;
                }
                this.f20619b.a0();
                return;
            }
            c.a.t0.p1.e.b.b bVar = this.f20623f;
            if (bVar != null) {
                bVar.f();
            }
            this.f20619b.K();
        }
    }
}
