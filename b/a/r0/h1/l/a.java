package b.a.r0.h1.l;

import android.view.View;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.x0;
import b.a.r0.h1.l.c.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
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
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.h1.l.c.b f19124a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.h1.l.e.a f19125b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f19126c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f19127d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f19128e;

    /* renamed from: f  reason: collision with root package name */
    public f.g f19129f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f19130g;

    /* renamed from: h  reason: collision with root package name */
    public b.f f19131h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19132i;

    /* renamed from: b.a.r0.h1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0966a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19133a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0966a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f19133a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19133a.h(customResponsedMessage);
                if (this.f19133a.f19125b != null) {
                    this.f19133a.f19125b.E();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19134a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19134a = aVar;
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
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = x0Var.n;
            if (i3 != 0 && i3 == 40) {
            }
            if (this.f19134a.f19125b != null) {
                this.f19134a.f19125b.G();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) != null) || x0Var == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19135e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19135e = aVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f19135e.f19125b.L(false);
                    this.f19135e.f19124a.j();
                    TiebaStatic.log(new StatisticItem("c13582"));
                    return;
                }
                this.f19135e.f19125b.X(null);
                this.f19135e.f19126c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19136e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19136e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19136e.f19125b.Q();
                this.f19136e.f19124a.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19137a;

        /* renamed from: b.a.r0.h1.l.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0967a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f19138e;

            public View$OnClickListenerC0967a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19138e = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f19138e.f19137a.l();
                }
            }
        }

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19137a = aVar;
        }

        @Override // b.a.r0.h1.l.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f19137a.f19125b.t();
                this.f19137a.f19125b.u();
                if (z || z2) {
                    this.f19137a.f19125b.X(null);
                } else {
                    this.f19137a.f19125b.X(this.f19137a.i(i2));
                }
                if (i2 != 0) {
                    this.f19137a.f19125b.J(this.f19137a.f19124a.h());
                    this.f19137a.f19125b.P(this.f19137a.f19132i);
                } else if (ListUtils.isEmpty(this.f19137a.f19125b.q())) {
                    this.f19137a.f19125b.T();
                } else if (z) {
                    this.f19137a.f19125b.U();
                }
            }
        }

        @Override // b.a.r0.h1.l.c.b.f
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f19137a.f19125b.X(null);
                this.f19137a.f19125b.t();
                this.f19137a.f19125b.u();
                if (ListUtils.isEmpty(this.f19137a.f19125b.q())) {
                    this.f19137a.f19125b.S(new View$OnClickListenerC0967a(this));
                    return;
                }
                if (z) {
                    this.f19137a.f19125b.P(this.f19137a.f19132i);
                }
                if (StringUtils.isNull(str)) {
                    this.f19137a.f19126c.showToast(R.string.video_tab_load_more_fail);
                } else {
                    this.f19137a.f19126c.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19139e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19139e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19139e.f19125b == null || this.f19139e.f19124a == null) {
                return;
            }
            this.f19139e.f19125b.Q();
            this.f19139e.f19124a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f19127d = new C0966a(this, 2016488);
        this.f19128e = new b(this);
        this.f19129f = new c(this);
        this.f19130g = new d(this);
        this.f19131h = new e(this);
        this.f19132i = new f(this);
        this.f19126c = tbPageContext;
        this.f19125b = new b.a.r0.h1.l.e.a(tbPageContext, bdUniqueId, this.f19128e);
        this.f19124a = new b.a.r0.h1.l.c.b(this.f19126c, this.f19131h);
    }

    public void g() {
        b.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f19125b) == null) {
            return;
        }
        aVar.m();
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        b.a.r0.h1.l.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f19124a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f19124a.r(optString);
        this.f19124a.q(optString);
        b.a.r0.h1.l.e.a aVar = this.f19125b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.f19126c.getResources().getString(R.string.video_tab_no_more);
            } else {
                string = this.f19126c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.h1.l.e.a aVar = this.f19125b;
            if (aVar != null) {
                return aVar.r();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19124a.p();
            this.f19125b.v();
            this.f19125b.K(this.f19129f);
            this.f19125b.M(this.f19130g);
            MessageManager.getInstance().registerListener(this.f19127d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.h1.l.e.a aVar = this.f19125b;
            if (aVar != null) {
                aVar.n();
                this.f19125b.R();
            }
            b.a.r0.h1.l.c.b bVar = this.f19124a;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.r0.h1.l.e.a aVar = this.f19125b;
            if (aVar != null) {
                aVar.K(null);
                this.f19125b.M(null);
                this.f19125b.A();
            }
            b.a.r0.h1.l.c.b bVar = this.f19124a;
            if (bVar != null) {
                bVar.o();
            }
            MessageManager.getInstance().unRegisterListener(this.f19127d);
        }
    }

    public void n() {
        b.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f19125b) == null) {
            return;
        }
        aVar.B();
        this.f19125b.C();
        this.f19125b.O(true);
    }

    public void o() {
        b.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f19125b) == null) {
            return;
        }
        aVar.L(false);
        this.f19125b.W();
        this.f19125b.y();
        this.f19125b.V();
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.f19125b.D();
            } else {
                this.f19125b.C();
            }
        }
    }
}
