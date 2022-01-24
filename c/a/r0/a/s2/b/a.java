package c.a.r0.a.s2.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.k;
import c.a.r0.a.u1.i;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f8912j;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f8913b;

    /* renamed from: c  reason: collision with root package name */
    public int f8914c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.h0.g.f f8915d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.n f8916e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f8917f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.o> f8918g;

    /* renamed from: h  reason: collision with root package name */
    public String f8919h;

    /* renamed from: i  reason: collision with root package name */
    public String f8920i;

    /* renamed from: c.a.r0.a.s2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0562a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8922f;

        public View$OnClickListenerC0562a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8922f = aVar;
            this.f8921e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8922f.g(this.f8921e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f8923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f8924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8925g;

        public b(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8925g = aVar;
            this.f8923e = swanAppBottomTabIconView;
            this.f8924f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8923e.setIconView(this.f8924f);
                if (this.f8925g.f8919h == null) {
                    this.f8923e.setTextColor(this.f8925g.f8916e.a);
                } else {
                    this.f8923e.setTextColor(SwanAppConfigData.t(this.f8925g.f8919h));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f8926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f8927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8928g;

        public c(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8928g = aVar;
            this.f8926e = swanAppBottomTabIconView;
            this.f8927f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8926e.setIconView(this.f8927f);
                if (this.f8928g.f8920i == null) {
                    this.f8926e.setTextColor(this.f8928g.f8916e.f39408b);
                } else {
                    this.f8926e.setTextColor(SwanAppConfigData.t(this.f8928g.f8920i));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8929e;

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
            this.f8929e = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f8929e.f8913b.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f8930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8931f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8930e = swanAppBottomTabIconView;
            this.f8931f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8930e.setTextView(this.f8931f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f8932e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8932e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8932e.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1720217954, "Lc/a/r0/a/s2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1720217954, "Lc/a/r0/a/s2/b/a;");
                return;
            }
        }
        f8912j = k.a;
    }

    public a(c.a.r0.a.h0.g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8914c = 0;
        this.f8915d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.r0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.r0.a.x1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f39414b;
            if (c.a.r0.w.d.v(str)) {
                swanAppBottomTabIconView.setmIsSelect(false);
                q0.e0(new b(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f8919h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.r0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.r0.a.x1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f39415c;
            if (c.a.r0.w.d.v(str)) {
                swanAppBottomTabIconView.setmIsSelect(true);
                q0.e0(new c(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f8920i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i2 = 0; i2 < this.f8918g.size(); i2++) {
                if (this.f8918g.get(i2).a.equals(str)) {
                    u(i2);
                    this.f8914c = i2;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f8915d.Y1()) {
            SwanAppConfigData s = c.a.r0.a.g1.f.U().s();
            if (s == null) {
                if (f8912j) {
                    String str2 = "configData is null." + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            SwanAppConfigData.n nVar = s.f39372f;
            this.f8916e = nVar;
            List<SwanAppConfigData.o> list = nVar.f39411e;
            this.f8918g = list;
            int size = list.size();
            this.f8917f = new ArrayList<>(size);
            this.a = view.findViewById(c.a.r0.a.f.bottom_bar_shadow);
            y(this.f8916e.f39409c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(c.a.r0.a.f.ai_apps_bottom_tab);
            this.f8913b = linearLayout;
            linearLayout.setVisibility(0);
            this.f8913b.setBackgroundColor(this.f8916e.f39410d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.o oVar = this.f8918g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(oVar.a, !TextUtils.isEmpty(str) ? str : c.a.r0.a.g1.f.U().g()) && !z) {
                    C(swanAppBottomTabIconView, oVar);
                    this.f8914c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, oVar);
                }
                swanAppBottomTabIconView.setTextView(oVar.f39416d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0562a(this, i2));
                this.f8917f.add(swanAppBottomTabIconView);
                this.f8913b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            u(i2);
            v(i2);
            if (this.f8914c == i2) {
                return;
            }
            this.f8914c = i2;
            this.f8915d.pause();
            c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(this.f8918g.get(i2).a, c.a.r0.a.g1.f.U().z());
            e2.f7818i = "5";
            e2.f7819j = uuid;
            c.a.r0.a.n2.i.g(e2);
            this.f8915d.f3(e2, uuid);
            c.a.r0.a.h0.g.f.O3("switchTab");
            this.f8915d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.a == null || this.f8913b == null) {
                return false;
            }
            y(SwanAppConfigData.t(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f8917f.iterator();
            while (it.hasNext()) {
                SwanAppBottomTabIconView next = it.next();
                if (next.ismIsSelect()) {
                    next.setTextColor(SwanAppConfigData.t(str2));
                } else {
                    next.setTextColor(SwanAppConfigData.t(str));
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (q(i2)) {
                this.f8917f.get(i2).setBadgeVisibleState(false);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            View view = this.a;
            if (view == null || this.f8913b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f8913b.setVisibility(8);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @AnyThread
    public boolean k(int i2) {
        InterceptResult invokeI;
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (q(i2) && (swanAppBottomTabIconView = this.f8917f.get(i2)) != null) {
                q0.e0(new f(this, swanAppBottomTabIconView));
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f8913b, AnimationProperty.TRANSLATE_Y, 0.0f, c.a.r0.a.c1.a.c().getResources().getDimensionPixelSize(c.a.r0.a.d.aiapps_bottom_tab_height));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f8913b : (LinearLayout) invokeV.objValue;
    }

    public final c.a.r0.a.f1.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L != null) {
                return L.X();
            }
            return null;
        }
        return (c.a.r0.a.f1.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.o> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f8918g) != null && list.size() != 0) {
                for (int i2 = 0; i2 < this.f8918g.size(); i2++) {
                    SwanAppConfigData.o oVar = this.f8918g.get(i2);
                    if (oVar != null && TextUtils.equals(oVar.a, str)) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinearLayout linearLayout = this.f8913b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f8917f;
            return arrayList != null && i2 < arrayList.size() && i2 >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.a;
            if (view == null || this.f8913b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f8913b.setVisibility(0);
            t(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (q(i2)) {
                this.f8917f.get(i2).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f8913b, AnimationProperty.TRANSLATE_Y, c.a.r0.a.c1.a.c().getResources().getDimensionPixelSize(c.a.r0.a.d.aiapps_bottom_tab_height), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            A(this.f8917f.get(this.f8914c), this.f8918g.get(this.f8914c));
            C(this.f8917f.get(i2), this.f8918g.get(i2));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.o oVar = this.f8918g.get(i2);
            String q3 = this.f8915d.q3(c.a.r0.a.m1.b.e(oVar.a, c.a.r0.a.g1.f.U().z()).f7814e);
            hashMap.put("index", String.valueOf(i2));
            hashMap.put("pagePath", oVar.a);
            hashMap.put("text", oVar.f39416d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, q3);
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, str)) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f8917f.get(i2);
                swanAppBottomTabIconView.setBadgeVisibleState(true);
                swanAppBottomTabIconView.setBadgeText(str);
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f8917f.get(i2);
                q0.e0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f8918g.get(i2).f39414b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f8918g.get(i2).f39415c = str3;
                }
                if (swanAppBottomTabIconView.ismIsSelect()) {
                    return C(swanAppBottomTabIconView, this.f8918g.get(i2));
                }
                return A(swanAppBottomTabIconView, this.f8918g.get(i2));
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(c.a.r0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f8913b.setBackgroundColor(SwanAppConfigData.t(str));
        }
    }
}
