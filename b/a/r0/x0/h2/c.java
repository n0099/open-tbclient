package b.a.r0.x0.h2;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.e.f.p.l;
import b.a.r0.k0.a;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27352g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27353h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f27354a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f27355b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k0.b f27356c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f27357d;

    /* renamed from: e  reason: collision with root package name */
    public e f27358e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27359f;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27360e;

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
            this.f27360e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f27360e.f27356c.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27361a;

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
            this.f27361a = cVar;
        }

        @Override // b.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f27361a.i();
            }
        }

        @Override // b.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f27361a.f27358e == null || !this.f27361a.f27358e.c() || Math.abs(i3) <= c.f27353h) {
                return;
            }
            if (this.f27361a.f27355b != null) {
                this.f27361a.f27355b.setBackgroundResource(R.color.transparent);
            }
            this.f27361a.f27354a.finish();
        }

        @Override // b.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.k0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* renamed from: b.a.r0.x0.h2.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1343c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27362e;

        public View$OnClickListenerC1343c(c cVar) {
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
            this.f27362e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27362e.f27354a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BlankView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27363a;

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
            this.f27363a = cVar;
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f27363a.f27355b != null) {
                    this.f27363a.f27355b.setVisibility(8);
                }
                this.f27363a.f27359f = false;
                if (this.f27363a.f27358e != null) {
                    this.f27363a.f27358e.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();

        boolean c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-449740528, "Lb/a/r0/x0/h2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-449740528, "Lb/a/r0/x0/h2/c;");
                return;
            }
        }
        f27352g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        f27353h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
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
        this.f27359f = false;
        this.f27354a = baseActivity;
        this.f27356c = new b.a.r0.k0.b(baseActivity.getPageContext().getPageActivity());
        this.f27357d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a(this));
        this.f27356c.d(new b(this));
    }

    public void g() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27359f || (viewGroup = (ViewGroup) this.f27354a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f27354a.getPageContext().getPageActivity());
        this.f27355b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f27355b, 0, new LinearLayout.LayoutParams(-1, f27352g));
        this.f27355b.setVisibility(0);
        this.f27355b.setOnClickListener(new View$OnClickListenerC1343c(this));
        this.f27355b.setScrollCallBack(new d(this));
        this.f27354a.setExcludeHeight(f27352g);
        this.f27359f = true;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27359f : invokeV.booleanValue;
    }

    public void i() {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f27359f && this.f27357d != null && (blankView = this.f27355b) != null && blankView.getVisibility() == 0) {
            this.f27357d.setStatusBarVisibility(0);
            this.f27354a.setExcludeHeight(0);
            e eVar = this.f27358e;
            if (eVar != null) {
                eVar.a();
            }
            this.f27355b.startScrollDissmiss();
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f27358e = eVar;
        }
    }

    public void k(int i2) {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (blankView = this.f27355b) == null) {
            return;
        }
        SkinManager.setBackgroundResource(blankView, i2);
    }
}
