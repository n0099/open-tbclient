package c.a.q0.v0.v1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.e.e.p.l;
import c.a.q0.i0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27244g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27245h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f27246a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f27247b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.i0.b f27248c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f27249d;

    /* renamed from: e  reason: collision with root package name */
    public e f27250e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27251f;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27252e;

        public a(c cVar) {
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
            this.f27252e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f27252e.f27248c.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27253a;

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
            this.f27253a = cVar;
        }

        @Override // c.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f27253a.i();
            }
        }

        @Override // c.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f27253a.f27250e == null || !this.f27253a.f27250e.c() || Math.abs(i3) <= c.f27245h) {
                return;
            }
            if (this.f27253a.f27247b != null) {
                this.f27253a.f27247b.setBackgroundResource(R.color.transparent);
            }
            this.f27253a.f27246a.finish();
        }

        @Override // c.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.v0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1276c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27254e;

        public View$OnClickListenerC1276c(c cVar) {
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
            this.f27254e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27254e.f27246a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27255a;

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
            this.f27255a = cVar;
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f27255a.f27247b != null) {
                    this.f27255a.f27247b.setVisibility(8);
                }
                this.f27255a.f27251f = false;
                if (this.f27255a.f27250e != null) {
                    this.f27255a.f27250e.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();

        boolean c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-617958527, "Lc/a/q0/v0/v1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-617958527, "Lc/a/q0/v0/v1/c;");
                return;
            }
        }
        f27244g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        f27245h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, view, navigationBar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27251f = false;
        this.f27246a = baseActivity;
        this.f27248c = new c.a.q0.i0.b(baseActivity.getPageContext().getPageActivity());
        this.f27249d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a(this));
        this.f27248c.d(new b(this));
    }

    public void g() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27251f || (viewGroup = (ViewGroup) this.f27246a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f27246a.getPageContext().getPageActivity());
        this.f27247b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f27247b, 0, new LinearLayout.LayoutParams(-1, f27244g));
        this.f27247b.setVisibility(0);
        this.f27247b.setOnClickListener(new View$OnClickListenerC1276c(this));
        this.f27247b.setScrollCallBack(new d(this));
        this.f27246a.setExcludeHeight(f27244g);
        this.f27251f = true;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27251f : invokeV.booleanValue;
    }

    public void i() {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f27251f && this.f27249d != null && (blankView = this.f27247b) != null && blankView.getVisibility() == 0) {
            this.f27249d.setStatusBarVisibility(0);
            this.f27246a.setExcludeHeight(0);
            e eVar = this.f27250e;
            if (eVar != null) {
                eVar.a();
            }
            this.f27247b.startScrollDissmiss();
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f27250e = eVar;
        }
    }

    public void k(int i2) {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (blankView = this.f27247b) == null) {
            return;
        }
        SkinManager.setBackgroundResource(blankView, i2);
    }
}
