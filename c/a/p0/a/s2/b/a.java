package c.a.p0.a.s2.b;

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
import c.a.p0.a.a1.d;
import c.a.p0.a.k;
import c.a.p0.a.u1.i;
import c.a.p0.a.z2.q0;
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
    public static final boolean f7922j;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f7923b;

    /* renamed from: c  reason: collision with root package name */
    public int f7924c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.h0.g.f f7925d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.n f7926e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f7927f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.o> f7928g;

    /* renamed from: h  reason: collision with root package name */
    public String f7929h;

    /* renamed from: i  reason: collision with root package name */
    public String f7930i;

    /* renamed from: c.a.p0.a.s2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0460a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7932f;

        public View$OnClickListenerC0460a(a aVar, int i2) {
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
            this.f7932f = aVar;
            this.f7931e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7932f.g(this.f7931e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7934f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7935g;

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
            this.f7935g = aVar;
            this.f7933e = swanAppBottomTabIconView;
            this.f7934f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7933e.setIconView(this.f7934f);
                if (this.f7935g.f7929h == null) {
                    this.f7933e.setTextColor(this.f7935g.f7926e.a);
                } else {
                    this.f7933e.setTextColor(SwanAppConfigData.t(this.f7935g.f7929h));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7937f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7938g;

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
            this.f7938g = aVar;
            this.f7936e = swanAppBottomTabIconView;
            this.f7937f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7936e.setIconView(this.f7937f);
                if (this.f7938g.f7930i == null) {
                    this.f7936e.setTextColor(this.f7938g.f7926e.f40099b);
                } else {
                    this.f7936e.setTextColor(SwanAppConfigData.t(this.f7938g.f7930i));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7939e;

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
            this.f7939e = aVar;
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
                this.f7939e.f7923b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f7940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7941f;

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
            this.f7940e = swanAppBottomTabIconView;
            this.f7941f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7940e.setTextView(this.f7941f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7942e;

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
            this.f7942e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7942e.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1978383392, "Lc/a/p0/a/s2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1978383392, "Lc/a/p0/a/s2/b/a;");
                return;
            }
        }
        f7922j = k.a;
    }

    public a(c.a.p0.a.h0.g.f fVar) {
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
        this.f7924c = 0;
        this.f7925d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.p0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.p0.a.x1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f40105b;
            if (c.a.p0.w.d.v(str)) {
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
            this.f7929h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.p0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.p0.a.x1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f40106c;
            if (c.a.p0.w.d.v(str)) {
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
            this.f7930i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i2 = 0; i2 < this.f7928g.size(); i2++) {
                if (this.f7928g.get(i2).a.equals(str)) {
                    u(i2);
                    this.f7924c = i2;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f7925d.f2()) {
            SwanAppConfigData r = c.a.p0.a.g1.f.U().r();
            if (r == null) {
                if (f7922j) {
                    String str2 = "configData is null." + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            SwanAppConfigData.n nVar = r.f40062f;
            this.f7926e = nVar;
            List<SwanAppConfigData.o> list = nVar.f40102e;
            this.f7928g = list;
            int size = list.size();
            this.f7927f = new ArrayList<>(size);
            this.a = view.findViewById(c.a.p0.a.f.bottom_bar_shadow);
            y(this.f7926e.f40100c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(c.a.p0.a.f.ai_apps_bottom_tab);
            this.f7923b = linearLayout;
            linearLayout.setVisibility(0);
            this.f7923b.setBackgroundColor(this.f7926e.f40101d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.o oVar = this.f7928g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(oVar.a, !TextUtils.isEmpty(str) ? str : c.a.p0.a.g1.f.U().f()) && !z) {
                    C(swanAppBottomTabIconView, oVar);
                    this.f7924c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, oVar);
                }
                swanAppBottomTabIconView.setTextView(oVar.f40107d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0460a(this, i2));
                this.f7927f.add(swanAppBottomTabIconView);
                this.f7923b.addView(swanAppBottomTabIconView, layoutParams);
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
            if (this.f7924c == i2) {
                return;
            }
            this.f7924c = i2;
            this.f7925d.pause();
            c.a.p0.a.m1.b e2 = c.a.p0.a.m1.b.e(this.f7928g.get(i2).a, c.a.p0.a.g1.f.U().z());
            e2.f6803i = "5";
            e2.f6804j = uuid;
            c.a.p0.a.n2.i.g(e2);
            this.f7925d.m3(e2, uuid);
            c.a.p0.a.h0.g.f.V3("switchTab");
            this.f7925d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.a == null || this.f7923b == null) {
                return false;
            }
            y(SwanAppConfigData.t(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f7927f.iterator();
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
                this.f7927f.get(i2).setBadgeVisibleState(false);
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
            if (view == null || this.f7923b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f7923b.setVisibility(8);
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
            if (q(i2) && (swanAppBottomTabIconView = this.f7927f.get(i2)) != null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f7923b, AnimationProperty.TRANSLATE_Y, 0.0f, c.a.p0.a.c1.a.c().getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_bottom_tab_height));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7923b : (LinearLayout) invokeV.objValue;
    }

    public final c.a.p0.a.f1.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
            if (L != null) {
                return L.X();
            }
            return null;
        }
        return (c.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.o> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f7928g) != null && list.size() != 0) {
                for (int i2 = 0; i2 < this.f7928g.size(); i2++) {
                    SwanAppConfigData.o oVar = this.f7928g.get(i2);
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
            LinearLayout linearLayout = this.f7923b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f7927f;
            return arrayList != null && i2 < arrayList.size() && i2 >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.a;
            if (view == null || this.f7923b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f7923b.setVisibility(0);
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
                this.f7927f.get(i2).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f7923b, AnimationProperty.TRANSLATE_Y, c.a.p0.a.c1.a.c().getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_bottom_tab_height), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            A(this.f7927f.get(this.f7924c), this.f7928g.get(this.f7924c));
            C(this.f7927f.get(i2), this.f7928g.get(i2));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.o oVar = this.f7928g.get(i2);
            String x3 = this.f7925d.x3(c.a.p0.a.m1.b.e(oVar.a, c.a.p0.a.g1.f.U().z()).f6799e);
            hashMap.put("index", String.valueOf(i2));
            hashMap.put("pagePath", oVar.a);
            hashMap.put("text", oVar.f40107d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, x3);
            c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, str)) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f7927f.get(i2);
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
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f7927f.get(i2);
                q0.e0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f7928g.get(i2).f40105b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f7928g.get(i2).f40106c = str3;
                }
                if (swanAppBottomTabIconView.ismIsSelect()) {
                    return C(swanAppBottomTabIconView, this.f7928g.get(i2));
                }
                return A(swanAppBottomTabIconView, this.f7928g.get(i2));
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
            this.a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(c.a.p0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f7923b.setBackgroundColor(SwanAppConfigData.t(str));
        }
    }
}
