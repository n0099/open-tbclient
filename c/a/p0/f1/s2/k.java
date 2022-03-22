package c.a.p0.f1.s2;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.s0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f14617b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f14618c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f14619d;

    /* renamed from: e  reason: collision with root package name */
    public s0 f14620e;

    /* renamed from: f  reason: collision with root package name */
    public String f14621f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f14622g;

    /* renamed from: h  reason: collision with root package name */
    public int f14623h;
    public c.a.o0.r.l0.q.c i;
    public c.a.o0.r.l0.q.b j;
    public c.a.o0.r.l0.q.a k;
    public Runnable l;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.r.l0.q.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.l0.q.c
        public void a(int i, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.o0.r.l0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // c.a.o0.r.l0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.o0.r.l0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.o0.r.l0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // c.a.o0.r.l0.q.a
        public void a(int i, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.r.l0.q.a
        public void b(int i, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.r.l0.q.a
        public void c(int i, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.r.l0.q.a
        public void d(int i, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) || this.a.f14620e == null) {
                return;
            }
            this.a.f14620e.D();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f14617b.o();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14621f = "999999";
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
        this.a = frsFragment;
        View H2 = frsFragment.H2();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) H2.findViewById(R.id.obfuscated_res_0x7f090ae3);
        this.f14617b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.i);
        this.f14617b.j(this.j);
        this.f14617b.i(this.k);
        this.f14617b.n();
        this.f14618c = (AppBarLayout) H2.findViewById(R.id.obfuscated_res_0x7f090ac4);
        this.f14619d = (BdTypeRecyclerView) H2.findViewById(R.id.obfuscated_res_0x7f090b7e);
    }

    public void d(c.a.o0.r.r.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !c.a.d.f.p.m.isEmpty(dVar.f10830b) && !c.a.d.f.p.m.isEmpty(dVar.a) && dVar.f10831c >= 0) {
                if (this.f14617b.v()) {
                    this.f14617b.o();
                }
                this.f14617b.X(dVar, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.f14617b.setAdvancedAdStyle(true);
                this.f14617b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f0923cf));
                return;
            }
            this.f14617b.setAdvancedAdStyle(false);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.f14617b.getData() != null && this.f14617b.b0()) {
                c.a.o0.r.r.d data = this.f14617b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f14621f;
                }
                String str = currentAccount + data.i;
                List<String> list = (List) new Gson().fromJson(c.a.o0.r.j0.b.k().q("key_uid_adid", ""), new e(this).getType());
                this.f14622g = list;
                if (list == null) {
                    this.f14622g = new ArrayList();
                }
                Iterator<String> it = this.f14622g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(c.a.o0.r.j0.b.k().m(next, 0L))) {
                        c.a.o0.r.j0.b.k().D(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(c.a.o0.r.j0.b.k().m(str, 0L))) {
                    this.f14622g.add(str);
                    c.a.o0.r.j0.b.k().x(str, System.currentTimeMillis());
                    z = true;
                }
                c.a.o0.r.j0.b.k().y("key_uid_adid", this.f14622g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (advancedAdSlideLoadingLayout = this.f14617b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.Z();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.l, 5000L);
            s0 s0Var = this.f14620e;
            if (s0Var != null) {
                s0Var.j0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public s0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14620e : (s0) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14617b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14617b.v() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14617b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.a.H2().findViewById(R.id.obfuscated_res_0x7f090d28);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090d27);
            if (findViewById == null) {
                return;
            }
            this.f14617b.setBgView(findViewById);
            if (this.f14617b.getAdvancedAdView() == null) {
                this.f14617b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, c.a.d.f.p.n.k(this.a.getContext()));
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f14617b.m(this.a.H2().findViewById(R.id.obfuscated_res_0x7f090b27), 0);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f14617b.o();
            c.a.d.f.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (findViewById = this.a.H2().findViewById(R.id.obfuscated_res_0x7f090d28)) == null || findViewById.getLayoutParams() == null || this.f14617b == null) {
            return;
        }
        this.f14617b.m(findViewById, findViewById.getLayoutParams().height);
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f14623h = i;
        }
    }

    public void q(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, s0Var) == null) {
            this.f14620e = s0Var;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f14617b.setEnableSlideLoading(z);
        }
    }

    public void s(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && i == this.f14623h) {
            if (z) {
                v();
                return;
            }
            this.f14619d.getAdapter().notifyDataSetChanged();
            w();
        }
    }

    public void t(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (advancedAdSlideLoadingLayout = this.f14617b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && e()) {
            this.f14617b.e0();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f14617b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.u()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f14619d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f14618c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f14617b.H();
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.f14617b.v()) {
            this.f14617b.o();
            c.a.d.f.m.e.a().removeCallbacks(this.l);
        }
    }
}
