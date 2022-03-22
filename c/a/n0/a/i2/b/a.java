package c.a.n0.a.i2.b;

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
import c.a.n0.a.k1.i;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.tieba.R;
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
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f4849b;

    /* renamed from: c  reason: collision with root package name */
    public int f4850c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.x.g.f f4851d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.n f4852e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f4853f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.o> f4854g;

    /* renamed from: h  reason: collision with root package name */
    public String f4855h;
    public String i;

    /* renamed from: c.a.n0.a.i2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0318a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4856b;

        public View$OnClickListenerC0318a(a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4856b = aVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4856b.g(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f4857b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4858c;

        public b(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4858c = aVar;
            this.a = swanAppBottomTabIconView;
            this.f4857b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setIconView(this.f4857b);
                if (this.f4858c.f4855h == null) {
                    this.a.setTextColor(this.f4858c.f4852e.a);
                } else {
                    this.a.setTextColor(SwanAppConfigData.t(this.f4858c.f4855h));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f4859b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4860c;

        public c(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4860c = aVar;
            this.a = swanAppBottomTabIconView;
            this.f4859b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setIconView(this.f4859b);
                if (this.f4860c.i == null) {
                    this.a.setTextColor(this.f4860c.f4852e.f29274b);
                } else {
                    this.a.setTextColor(SwanAppConfigData.t(this.f4860c.i));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
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
                this.a.f4849b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4861b;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppBottomTabIconView;
            this.f4861b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTextView(this.f4861b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1773316248, "Lc/a/n0/a/i2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1773316248, "Lc/a/n0/a/i2/b/a;");
                return;
            }
        }
        j = c.a.n0.a.a.a;
    }

    public a(c.a.n0.a.x.g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4850c = 0;
        this.f4851d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.n0.a.v0.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.n0.a.n1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f29280b;
            if (c.a.n0.w.d.v(str)) {
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
            this.f4855h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, oVar)) == null) {
            c.a.n0.a.v0.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = c.a.n0.a.n1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = d.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.f29281c;
            if (c.a.n0.w.d.v(str)) {
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
            this.i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i = 0; i < this.f4854g.size(); i++) {
                if (this.f4854g.get(i).a.equals(str)) {
                    u(i);
                    this.f4850c = i;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f4851d.c2()) {
            SwanAppConfigData s = c.a.n0.a.w0.f.U().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.n nVar = s.f29240f;
            this.f4852e = nVar;
            List<SwanAppConfigData.o> list = nVar.f29277e;
            this.f4854g = list;
            int size = list.size();
            this.f4853f = new ArrayList<>(size);
            this.a = view.findViewById(R.id.obfuscated_res_0x7f0903b8);
            y(this.f4852e.f29275c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090170);
            this.f4849b = linearLayout;
            linearLayout.setVisibility(0);
            this.f4849b.setBackgroundColor(this.f4852e.f29276d);
            boolean z = false;
            for (int i = 0; i < size; i++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.o oVar = this.f4854g.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(oVar.a, !TextUtils.isEmpty(str) ? str : c.a.n0.a.w0.f.U().g()) && !z) {
                    C(swanAppBottomTabIconView, oVar);
                    this.f4850c = i;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, oVar);
                }
                swanAppBottomTabIconView.setTextView(oVar.f29282d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0318a(this, i));
                this.f4853f.add(swanAppBottomTabIconView);
                this.f4849b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            u(i);
            v(i);
            if (this.f4850c == i) {
                return;
            }
            this.f4850c = i;
            this.f4851d.pause();
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(this.f4854g.get(i).a, c.a.n0.a.w0.f.U().z());
            d2.f3950e = "5";
            d2.f3951f = uuid;
            c.a.n0.a.d2.i.g(d2);
            this.f4851d.j3(d2, uuid);
            c.a.n0.a.x.g.f.S3("switchTab");
            this.f4851d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.a == null || this.f4849b == null) {
                return false;
            }
            y(SwanAppConfigData.t(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f4853f.iterator();
            while (it.hasNext()) {
                SwanAppBottomTabIconView next = it.next();
                if (next.a()) {
                    next.setTextColor(SwanAppConfigData.t(str2));
                } else {
                    next.setTextColor(SwanAppConfigData.t(str));
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (q(i)) {
                this.f4853f.get(i).setBadgeVisibleState(false);
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
            if (view == null || this.f4849b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f4849b.setVisibility(8);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @AnyThread
    public boolean k(int i) {
        InterceptResult invokeI;
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (q(i) && (swanAppBottomTabIconView = this.f4853f.get(i)) != null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4849b, AnimationProperty.TRANSLATE_Y, 0.0f, c.a.n0.a.s0.a.c().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f4849b : (LinearLayout) invokeV.objValue;
    }

    public final c.a.n0.a.v0.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            if (L != null) {
                return L.X();
            }
            return null;
        }
        return (c.a.n0.a.v0.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.o> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f4854g) != null && list.size() != 0) {
                for (int i = 0; i < this.f4854g.size(); i++) {
                    SwanAppConfigData.o oVar = this.f4854g.get(i);
                    if (oVar != null && TextUtils.equals(oVar.a, str)) {
                        return i;
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
            LinearLayout linearLayout = this.f4849b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f4853f;
            return arrayList != null && i < arrayList.size() && i >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.a;
            if (view == null || this.f4849b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f4849b.setVisibility(0);
            t(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (q(i)) {
                this.f4853f.get(i).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4849b, AnimationProperty.TRANSLATE_Y, c.a.n0.a.s0.a.c().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            A(this.f4853f.get(this.f4850c), this.f4854g.get(this.f4850c));
            C(this.f4853f.get(i), this.f4854g.get(i));
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.o oVar = this.f4854g.get(i);
            String u3 = this.f4851d.u3(c.a.n0.a.c1.b.d(oVar.a, c.a.n0.a.w0.f.U().z()).a);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("pagePath", oVar.a);
            hashMap.put("text", oVar.f29282d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, u3);
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, str)) == null) {
            if (q(i)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f4853f.get(i);
                swanAppBottomTabIconView.setBadgeVisibleState(true);
                swanAppBottomTabIconView.setBadgeText(str);
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean x(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            if (q(i)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f4853f.get(i);
                q0.e0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f4854g.get(i).f29280b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f4854g.get(i).f29281c = str3;
                }
                if (swanAppBottomTabIconView.a()) {
                    return C(swanAppBottomTabIconView, this.f4854g.get(i));
                }
                return A(swanAppBottomTabIconView, this.f4854g.get(i));
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        } else if (-16777216 == i) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603dc));
        } else {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f4849b.setBackgroundColor(SwanAppConfigData.t(str));
        }
    }
}
