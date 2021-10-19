package c.a.r0.h1.l;

import android.view.View;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.x0;
import c.a.r0.h1.l.c.b;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.h1.l.c.b f18729a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.h1.l.e.a f18730b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f18731c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f18732d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f18733e;

    /* renamed from: f  reason: collision with root package name */
    public f.g f18734f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f18735g;

    /* renamed from: h  reason: collision with root package name */
    public b.f f18736h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f18737i;

    /* renamed from: c.a.r0.h1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0903a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18738a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0903a(a aVar, int i2) {
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
            this.f18738a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18738a.h(customResponsedMessage);
                if (this.f18738a.f18730b != null) {
                    this.f18738a.f18730b.E();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18739a;

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
            this.f18739a = aVar;
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
            if (this.f18739a.f18730b != null) {
                this.f18739a.f18730b.G();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) != null) || x0Var == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18740e;

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
            this.f18740e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f18740e.f18730b.L(false);
                    this.f18740e.f18729a.j();
                    TiebaStatic.log(new StatisticItem("c13582"));
                    return;
                }
                this.f18740e.f18730b.X(null);
                this.f18740e.f18731c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18741e;

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
            this.f18741e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18741e.f18730b.Q();
                this.f18741e.f18729a.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18742a;

        /* renamed from: c.a.r0.h1.l.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0904a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f18743e;

            public View$OnClickListenerC0904a(e eVar) {
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
                this.f18743e = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f18743e.f18742a.l();
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
            this.f18742a = aVar;
        }

        @Override // c.a.r0.h1.l.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f18742a.f18730b.t();
                this.f18742a.f18730b.u();
                if (z || z2) {
                    this.f18742a.f18730b.X(null);
                } else {
                    this.f18742a.f18730b.X(this.f18742a.i(i2));
                }
                if (i2 != 0) {
                    this.f18742a.f18730b.J(this.f18742a.f18729a.h());
                    this.f18742a.f18730b.P(this.f18742a.f18737i);
                } else if (ListUtils.isEmpty(this.f18742a.f18730b.q())) {
                    this.f18742a.f18730b.T();
                } else if (z) {
                    this.f18742a.f18730b.U();
                }
            }
        }

        @Override // c.a.r0.h1.l.c.b.f
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f18742a.f18730b.X(null);
                this.f18742a.f18730b.t();
                this.f18742a.f18730b.u();
                if (ListUtils.isEmpty(this.f18742a.f18730b.q())) {
                    this.f18742a.f18730b.S(new View$OnClickListenerC0904a(this));
                    return;
                }
                if (z) {
                    this.f18742a.f18730b.P(this.f18742a.f18737i);
                }
                if (StringUtils.isNull(str)) {
                    this.f18742a.f18731c.showToast(R.string.video_tab_load_more_fail);
                } else {
                    this.f18742a.f18731c.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18744e;

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
            this.f18744e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18744e.f18730b == null || this.f18744e.f18729a == null) {
                return;
            }
            this.f18744e.f18730b.Q();
            this.f18744e.f18729a.l();
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
        this.f18732d = new C0903a(this, 2016488);
        this.f18733e = new b(this);
        this.f18734f = new c(this);
        this.f18735g = new d(this);
        this.f18736h = new e(this);
        this.f18737i = new f(this);
        this.f18731c = tbPageContext;
        this.f18730b = new c.a.r0.h1.l.e.a(tbPageContext, bdUniqueId, this.f18733e);
        this.f18729a = new c.a.r0.h1.l.c.b(this.f18731c, this.f18736h);
    }

    public void g() {
        c.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f18730b) == null) {
            return;
        }
        aVar.m();
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.r0.h1.l.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f18729a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f18729a.r(optString);
        this.f18729a.q(optString);
        c.a.r0.h1.l.e.a aVar = this.f18730b;
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
                string = this.f18731c.getResources().getString(R.string.video_tab_no_more);
            } else {
                string = this.f18731c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.h1.l.e.a aVar = this.f18730b;
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
            this.f18729a.p();
            this.f18730b.v();
            this.f18730b.K(this.f18734f);
            this.f18730b.M(this.f18735g);
            MessageManager.getInstance().registerListener(this.f18732d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.h1.l.e.a aVar = this.f18730b;
            if (aVar != null) {
                aVar.n();
                this.f18730b.R();
            }
            c.a.r0.h1.l.c.b bVar = this.f18729a;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.h1.l.e.a aVar = this.f18730b;
            if (aVar != null) {
                aVar.K(null);
                this.f18730b.M(null);
                this.f18730b.A();
            }
            c.a.r0.h1.l.c.b bVar = this.f18729a;
            if (bVar != null) {
                bVar.o();
            }
            MessageManager.getInstance().unRegisterListener(this.f18732d);
        }
    }

    public void n() {
        c.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f18730b) == null) {
            return;
        }
        aVar.B();
        this.f18730b.C();
        this.f18730b.O(true);
    }

    public void o() {
        c.a.r0.h1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f18730b) == null) {
            return;
        }
        aVar.L(false);
        this.f18730b.W();
        this.f18730b.y();
        this.f18730b.V();
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.f18730b.D();
            } else {
                this.f18730b.C();
            }
        }
    }
}
