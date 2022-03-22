package c.a.p0.q1.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.o0.r.l0.f;
import c.a.o0.r.r.v0;
import c.a.p0.q1.f.b.a;
import c.a.p0.q1.f.b.b;
import c.a.p0.q1.f.d.b;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q1.f.f.b f17276b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.q1.f.d.b f17277c;

    /* renamed from: d  reason: collision with root package name */
    public int f17278d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.q1.f.b.a f17279e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.q1.f.b.b f17280f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17281g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17282h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public f.g k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f17276b != null) {
                    this.a.f17276b.L();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, v0Var) == null) || arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = v0Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49) {
                i = 3;
            }
            if (this.a.f17276b != null) {
                this.a.f17276b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.k).param("obj_source", v0Var.l).param("obj_id", v0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(v0 v0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v0Var) == null) || v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.f()).param("obj_type", this.a.f17278d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: c.a.p0.q1.f.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1297c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public View$OnClickListenerC1297c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f17276b.E()) {
                return;
            }
            this.a.f17276b.Q(true);
            if (this.a.f17280f.i()) {
                this.a.f17280f.e();
                this.a.f17276b.c0();
                SkinManager.setBackgroundResource(this.a.f17276b.x(), R.color.CAM_X0207);
                return;
            }
            this.a.f17280f.n(this.a.f17276b.x());
            this.a.f17276b.d0();
            SkinManager.setBackgroundResource(this.a.f17276b.x(), R.color.CAM_X0201);
            if (this.a.f17277c == null || ListUtils.isEmpty(this.a.f17277c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes2.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.a.f17277c.q(this.a.f17278d);
                    this.a.u();
                    this.a.f17276b.X(false);
                    return;
                }
                this.a.f17276b.n0(null);
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f089e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f17276b.f0();
                this.a.f17277c.r(this.a.f17278d);
                this.a.u();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.a.t();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.q1.f.d.b.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f17276b.A();
                this.a.f17276b.B();
                if (z || z2) {
                    this.a.f17276b.n0(null);
                } else {
                    this.a.f17276b.n0(this.a.q(i));
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.f17277c.m()) && !StringUtils.isNull(c.a.o0.r.j0.b.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.f17276b.R(this.a.f17280f.i());
                    this.a.f17276b.e0();
                    this.a.f17280f.l(this.a.f17277c.m());
                }
                if (i != 0) {
                    this.a.f17276b.S(this.a.f17277c.l());
                    this.a.f17276b.b0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.f17276b.w())) {
                    this.a.f17276b.i0();
                } else if (z) {
                    this.a.f17276b.j0();
                }
            }
        }

        @Override // c.a.p0.q1.f.d.b.e
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.f17276b.n0(null);
                this.a.f17276b.A();
                this.a.f17276b.B();
                if (ListUtils.isEmpty(this.a.f17276b.w())) {
                    this.a.f17276b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.a.f17276b.b0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0784);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f17276b == null || this.a.f17277c == null) {
                return;
            }
            this.a.f17276b.f0();
            this.a.f17277c.r(this.a.f17278d);
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.q1.f.b.b.f
        public void a(c.a.p0.q1.f.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f17278d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f17276b != null) {
                this.a.f17276b.U(aVar.a);
                this.a.f17276b.R(false);
                this.a.f17276b.T(aVar.f17283b);
            }
        }

        @Override // c.a.p0.q1.f.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f17276b == null) {
                return;
            }
            this.a.f17276b.R(false);
            this.a.f17276b.H(false);
        }

        @Override // c.a.p0.q1.f.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f17276b.H(true);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.q1.f.b.a.b
        public void a(c.a.p0.q1.f.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.f17278d = aVar.a;
            this.a.m(aVar.a);
            if (this.a.f17276b != null) {
                this.a.f17276b.U(aVar.a);
                this.a.f17276b.R(false);
                this.a.f17276b.T(aVar.f17283b);
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
        this.f17282h = new a(this, 2016488);
        this.i = new b(this);
        this.j = new View$OnClickListenerC1297c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.f17281g = bdUniqueId;
        this.f17276b = new c.a.p0.q1.f.f.b(tbPageContext, bdUniqueId, this.i);
        this.f17277c = new c.a.p0.q1.f.d.b(this.a, this.m);
        c.a.p0.q1.f.b.b bVar = new c.a.p0.q1.f.b.b(tbPageContext, this.f17281g);
        this.f17280f = bVar;
        bVar.m(this.o);
        c.a.p0.q1.f.b.a aVar = new c.a.p0.q1.f.b.a(tbPageContext, this.f17281g);
        this.f17279e = aVar;
        aVar.i(this.p);
        this.f17276b.W(this.j);
        int l = c.a.o0.r.j0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f17278d = l;
        this.f17276b.U(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.p0.q1.f.b.b bVar = this.f17280f;
            if (bVar != null) {
                bVar.p(i2);
            }
            c.a.p0.q1.f.d.b bVar2 = this.f17277c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.q1.f.f.b bVar = this.f17276b;
            if (bVar != null) {
                bVar.r();
            }
            c.a.p0.q1.f.b.b bVar2 = this.f17280f;
            if (bVar2 != null) {
                bVar2.j();
            }
            c.a.p0.q1.f.b.a aVar = this.f17279e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f17280f.i()) {
                SkinManager.setBackgroundResource(this.f17276b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f17276b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        c.a.p0.q1.f.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.q1.f.d.b bVar = this.f17277c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f17277c.o() || this.f17278d == 0) && (aVar = this.f17279e) != null) {
                aVar.h(this.f17277c.m());
                this.f17279e.c((ViewGroup) this.f17276b.y());
                c.a.o0.r.j0.b.k().D("key_game_video_tab_has_choosed_sub_class_id");
                c.a.o0.r.j0.b.k().D("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.q1.f.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f17277c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f17277c.w(optString);
        this.f17277c.v(optString);
        c.a.p0.q1.f.f.b bVar2 = this.f17276b;
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
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0782);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0783, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.q1.f.f.b bVar = this.f17276b;
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
            this.f17277c.u();
            this.f17276b.C();
            this.f17276b.V(this.k);
            this.f17276b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f17282h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.q1.f.f.b bVar = this.f17276b;
            if (bVar != null) {
                bVar.s();
                this.f17276b.g0();
            }
            c.a.p0.q1.f.d.b bVar2 = this.f17277c;
            if (bVar2 != null) {
                bVar2.q(this.f17278d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f17278d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.q1.f.f.b bVar = this.f17276b;
            if (bVar != null) {
                bVar.V(null);
                this.f17276b.Y(null);
                this.f17276b.I();
            }
            c.a.p0.q1.f.b.b bVar2 = this.f17280f;
            if (bVar2 != null) {
                bVar2.k();
            }
            c.a.p0.q1.f.b.a aVar = this.f17279e;
            if (aVar != null) {
                aVar.g();
            }
            c.a.p0.q1.f.d.b bVar3 = this.f17277c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f17282h);
        }
    }

    public void w() {
        c.a.p0.q1.f.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f17276b) == null) {
            return;
        }
        bVar.J();
        this.f17276b.K();
        this.f17276b.Z(true);
    }

    public void x() {
        c.a.p0.q1.f.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f17276b) == null) {
            return;
        }
        bVar.G();
        this.f17276b.l0();
        this.f17276b.X(false);
        this.f17276b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f17278d));
                if (this.f17280f.i()) {
                    return;
                }
                this.f17276b.a0();
                return;
            }
            c.a.p0.q1.f.b.b bVar = this.f17280f;
            if (bVar != null) {
                bVar.f();
            }
            this.f17276b.K();
        }
    }
}
