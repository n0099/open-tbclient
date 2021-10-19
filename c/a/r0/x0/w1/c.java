package c.a.r0.x0.w1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.e.e.p.l;
import c.a.r0.k0.a;
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
    public static final int f28110g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f28111h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f28112a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f28113b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.k0.b f28114c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f28115d;

    /* renamed from: e  reason: collision with root package name */
    public e f28116e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28117f;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28118e;

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
            this.f28118e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f28118e.f28114c.c(motionEvent);
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
        public final /* synthetic */ c f28119a;

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
            this.f28119a = cVar;
        }

        @Override // c.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f28119a.i();
            }
        }

        @Override // c.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f28119a.f28116e == null || !this.f28119a.f28116e.c() || Math.abs(i3) <= c.f28111h) {
                return;
            }
            if (this.f28119a.f28113b != null) {
                this.f28119a.f28113b.setBackgroundResource(R.color.transparent);
            }
            this.f28119a.f28112a.finish();
        }

        @Override // c.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.r0.k0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* renamed from: c.a.r0.x0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1322c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28120e;

        public View$OnClickListenerC1322c(c cVar) {
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
            this.f28120e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28120e.f28112a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BlankView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28121a;

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
            this.f28121a = cVar;
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28121a.f28113b != null) {
                    this.f28121a.f28113b.setVisibility(8);
                }
                this.f28121a.f28117f = false;
                if (this.f28121a.f28116e != null) {
                    this.f28121a.f28116e.b();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071634305, "Lc/a/r0/x0/w1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071634305, "Lc/a/r0/x0/w1/c;");
                return;
            }
        }
        f28110g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        f28111h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
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
        this.f28117f = false;
        this.f28112a = baseActivity;
        this.f28114c = new c.a.r0.k0.b(baseActivity.getPageContext().getPageActivity());
        this.f28115d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a(this));
        this.f28114c.d(new b(this));
    }

    public void g() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28117f || (viewGroup = (ViewGroup) this.f28112a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f28112a.getPageContext().getPageActivity());
        this.f28113b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f28113b, 0, new LinearLayout.LayoutParams(-1, f28110g));
        this.f28113b.setVisibility(0);
        this.f28113b.setOnClickListener(new View$OnClickListenerC1322c(this));
        this.f28113b.setScrollCallBack(new d(this));
        this.f28112a.setExcludeHeight(f28110g);
        this.f28117f = true;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28117f : invokeV.booleanValue;
    }

    public void i() {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f28117f && this.f28115d != null && (blankView = this.f28113b) != null && blankView.getVisibility() == 0) {
            this.f28115d.setStatusBarVisibility(0);
            this.f28112a.setExcludeHeight(0);
            e eVar = this.f28116e;
            if (eVar != null) {
                eVar.a();
            }
            this.f28113b.startScrollDissmiss();
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f28116e = eVar;
        }
    }

    public void k(int i2) {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (blankView = this.f28113b) == null) {
            return;
        }
        SkinManager.setBackgroundResource(blankView, i2);
    }
}
