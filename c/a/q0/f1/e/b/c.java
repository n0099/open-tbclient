package c.a.q0.f1.e.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.x0;
import c.a.q0.f1.e.b.a;
import c.a.q0.f1.e.b.b;
import c.a.q0.f1.e.d.b;
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
    public TbPageContext f17474a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.f1.e.f.b f17475b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.f1.e.d.b f17476c;

    /* renamed from: d  reason: collision with root package name */
    public int f17477d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.e.b.a f17478e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.f1.e.b.b f17479f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f17480g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17481h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f17482i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f17483j;
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
        public final /* synthetic */ c f17484a;

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
            this.f17484a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17484a.p(customResponsedMessage);
                if (this.f17484a.f17475b != null) {
                    this.f17484a.f17475b.L();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17485a;

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
            this.f17485a = cVar;
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
            if (this.f17485a.f17475b != null) {
                this.f17485a.f17475b.N();
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
            TiebaStatic.log(new StatisticItem("c13499").param("fid", x0Var.c()).param("tid", x0Var.f()).param("obj_type", this.f17485a.f17477d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: c.a.q0.f1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0846c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17486e;

        public View$OnClickListenerC0846c(c cVar) {
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
            this.f17486e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17486e.f17475b.E()) {
                return;
            }
            this.f17486e.f17475b.Q(true);
            if (this.f17486e.f17479f.i()) {
                this.f17486e.f17479f.e();
                this.f17486e.f17475b.c0();
                SkinManager.setBackgroundResource(this.f17486e.f17475b.x(), R.color.CAM_X0207);
                return;
            }
            this.f17486e.f17479f.n(this.f17486e.f17475b.x());
            this.f17486e.f17475b.d0();
            SkinManager.setBackgroundResource(this.f17486e.f17475b.x(), R.color.CAM_X0201);
            if (this.f17486e.f17476c == null || ListUtils.isEmpty(this.f17486e.f17476c.m())) {
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
        public final /* synthetic */ c f17487e;

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
            this.f17487e = cVar;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f17487e.f17476c.q(this.f17487e.f17477d);
                    this.f17487e.u();
                    this.f17487e.f17475b.X(false);
                    return;
                }
                this.f17487e.f17475b.n0(null);
                this.f17487e.f17474a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17488e;

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
            this.f17488e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17488e.f17475b.f0();
                this.f17488e.f17476c.r(this.f17488e.f17477d);
                this.f17488e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17489a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f17490e;

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
                this.f17490e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f17490e.f17489a.t();
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
            this.f17489a = cVar;
        }

        @Override // c.a.q0.f1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f17489a.f17475b.A();
                this.f17489a.f17475b.B();
                if (z || z2) {
                    this.f17489a.f17475b.n0(null);
                } else {
                    this.f17489a.f17475b.n0(this.f17489a.q(i2));
                }
                if (this.f17489a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.f17489a.f17476c.m()) && !StringUtils.isNull(c.a.p0.s.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.f17489a.f17475b.R(this.f17489a.f17479f.i());
                    this.f17489a.f17475b.e0();
                    this.f17489a.f17479f.l(this.f17489a.f17476c.m());
                }
                if (i2 != 0) {
                    this.f17489a.f17475b.S(this.f17489a.f17476c.l());
                    this.f17489a.f17475b.b0(this.f17489a.n);
                } else if (ListUtils.isEmpty(this.f17489a.f17475b.w())) {
                    this.f17489a.f17475b.i0();
                } else if (z) {
                    this.f17489a.f17475b.j0();
                }
            }
        }

        @Override // c.a.q0.f1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f17489a.f17475b.n0(null);
                this.f17489a.f17475b.A();
                this.f17489a.f17475b.B();
                if (ListUtils.isEmpty(this.f17489a.f17475b.w())) {
                    this.f17489a.f17475b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.f17489a.f17475b.b0(this.f17489a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.f17489a.f17474a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.f17489a.f17474a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17491e;

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
            this.f17491e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17491e.f17475b == null || this.f17491e.f17476c == null) {
                return;
            }
            this.f17491e.f17475b.f0();
            this.f17491e.f17476c.r(this.f17491e.f17477d);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17492a;

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
            this.f17492a = cVar;
        }

        @Override // c.a.q0.f1.e.b.b.f
        public void a(c.a.q0.f1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f17492a.f17477d = aVar.f17494a;
            this.f17492a.m(aVar.f17494a);
            if (this.f17492a.f17475b != null) {
                this.f17492a.f17475b.U(aVar.f17494a);
                this.f17492a.f17475b.R(false);
                this.f17492a.f17475b.T(aVar.f17495b);
            }
        }

        @Override // c.a.q0.f1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17492a.f17475b == null) {
                return;
            }
            this.f17492a.f17475b.R(false);
            this.f17492a.f17475b.H(false);
        }

        @Override // c.a.q0.f1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f17492a.f17475b.H(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17493a;

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
            this.f17493a = cVar;
        }

        @Override // c.a.q0.f1.e.b.a.b
        public void a(c.a.q0.f1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f17493a.f17477d = aVar.f17494a;
            this.f17493a.m(aVar.f17494a);
            if (this.f17493a.f17475b != null) {
                this.f17493a.f17475b.U(aVar.f17494a);
                this.f17493a.f17475b.R(false);
                this.f17493a.f17475b.T(aVar.f17495b);
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
        this.f17481h = new a(this, 2016488);
        this.f17482i = new b(this);
        this.f17483j = new View$OnClickListenerC0846c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.f17474a = tbPageContext;
        this.f17480g = bdUniqueId;
        this.f17475b = new c.a.q0.f1.e.f.b(tbPageContext, bdUniqueId, this.f17482i);
        this.f17476c = new c.a.q0.f1.e.d.b(this.f17474a, this.m);
        c.a.q0.f1.e.b.b bVar = new c.a.q0.f1.e.b.b(tbPageContext, this.f17480g);
        this.f17479f = bVar;
        bVar.m(this.o);
        c.a.q0.f1.e.b.a aVar = new c.a.q0.f1.e.b.a(tbPageContext, this.f17480g);
        this.f17478e = aVar;
        aVar.i(this.p);
        this.f17475b.W(this.f17483j);
        int k = c.a.p0.s.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f17477d = k;
        this.f17475b.U(k);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.q0.f1.e.b.b bVar = this.f17479f;
            if (bVar != null) {
                bVar.p(i2);
            }
            c.a.q0.f1.e.d.b bVar2 = this.f17476c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.f1.e.f.b bVar = this.f17475b;
            if (bVar != null) {
                bVar.r();
            }
            c.a.q0.f1.e.b.b bVar2 = this.f17479f;
            if (bVar2 != null) {
                bVar2.j();
            }
            c.a.q0.f1.e.b.a aVar = this.f17478e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f17479f.i()) {
                SkinManager.setBackgroundResource(this.f17475b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f17475b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        c.a.q0.f1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.q0.f1.e.d.b bVar = this.f17476c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f17476c.o() || this.f17477d == 0) && (aVar = this.f17478e) != null) {
                aVar.h(this.f17476c.m());
                this.f17478e.c((ViewGroup) this.f17475b.y());
                c.a.p0.s.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
                c.a.p0.s.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.q0.f1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f17476c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f17476c.w(optString);
        this.f17476c.v(optString);
        c.a.q0.f1.e.f.b bVar2 = this.f17475b;
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
                string = this.f17474a.getResources().getString(R.string.game_video_no_more);
            } else {
                string = this.f17474a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.q0.f1.e.f.b bVar = this.f17475b;
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
            this.f17476c.u();
            this.f17475b.C();
            this.f17475b.V(this.k);
            this.f17475b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f17481h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.f1.e.f.b bVar = this.f17475b;
            if (bVar != null) {
                bVar.s();
                this.f17475b.g0();
            }
            c.a.q0.f1.e.d.b bVar2 = this.f17476c;
            if (bVar2 != null) {
                bVar2.q(this.f17477d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f17477d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.f1.e.f.b bVar = this.f17475b;
            if (bVar != null) {
                bVar.V(null);
                this.f17475b.Y(null);
                this.f17475b.I();
            }
            c.a.q0.f1.e.b.b bVar2 = this.f17479f;
            if (bVar2 != null) {
                bVar2.k();
            }
            c.a.q0.f1.e.b.a aVar = this.f17478e;
            if (aVar != null) {
                aVar.g();
            }
            c.a.q0.f1.e.d.b bVar3 = this.f17476c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f17481h);
        }
    }

    public void w() {
        c.a.q0.f1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f17475b) == null) {
            return;
        }
        bVar.J();
        this.f17475b.K();
        this.f17475b.Z(true);
    }

    public void x() {
        c.a.q0.f1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f17475b) == null) {
            return;
        }
        bVar.G();
        this.f17475b.l0();
        this.f17475b.X(false);
        this.f17475b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f17477d));
                if (this.f17479f.i()) {
                    return;
                }
                this.f17475b.a0();
                return;
            }
            c.a.q0.f1.e.b.b bVar = this.f17479f;
            if (bVar != null) {
                bVar.f();
            }
            this.f17475b.K();
        }
    }
}
