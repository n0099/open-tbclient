package b.a.p0.a.o2.b;

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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.j2.h;
import b.a.p0.a.k;
import b.a.p0.a.r1.i;
import b.a.p0.a.v2.q0;
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

    /* renamed from: a  reason: collision with root package name */
    public View f7126a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f7127b;

    /* renamed from: c  reason: collision with root package name */
    public int f7128c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.h0.g.f f7129d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f7130e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f7131f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f7132g;

    /* renamed from: h  reason: collision with root package name */
    public String f7133h;

    /* renamed from: i  reason: collision with root package name */
    public String f7134i;

    /* renamed from: b.a.p0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0331a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7136f;

        public View$OnClickListenerC0331a(a aVar, int i2) {
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
            this.f7136f = aVar;
            this.f7135e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7136f.g(this.f7135e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7139g;

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
            this.f7139g = aVar;
            this.f7137e = swanAppBottomTabIconView;
            this.f7138f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7137e.setIconView(this.f7138f);
                if (this.f7139g.f7133h == null) {
                    this.f7137e.setTextColor(this.f7139g.f7130e.f44272a);
                } else {
                    this.f7137e.setTextColor(SwanAppConfigData.s(this.f7139g.f7133h));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7141f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7142g;

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
            this.f7142g = aVar;
            this.f7140e = swanAppBottomTabIconView;
            this.f7141f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7140e.setIconView(this.f7141f);
                if (this.f7142g.f7134i == null) {
                    this.f7140e.setTextColor(this.f7142g.f7130e.f44273b);
                } else {
                    this.f7140e.setTextColor(SwanAppConfigData.s(this.f7142g.f7134i));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7143e;

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
            this.f7143e = aVar;
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
                this.f7143e.f7127b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f7144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7145f;

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
            this.f7144e = swanAppBottomTabIconView;
            this.f7145f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7144e.setTextView(this.f7145f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f7146e;

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
            this.f7146e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7146e.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-722896643, "Lb/a/p0/a/o2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-722896643, "Lb/a/p0/a/o2/b/a;");
                return;
            }
        }
        j = k.f6397a;
    }

    public a(b.a.p0.a.h0.g.f fVar) {
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
        this.f7128c = 0;
        this.f7129d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, mVar)) == null) {
            b.a.p0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = b.a.p0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0109e.i(n.G(), n.s1()).getPath();
            }
            String str = l + File.separator + mVar.f44280b;
            if (b.a.p0.t.d.u(str)) {
                swanAppBottomTabIconView.setmIsSelect(false);
                q0.b0(new b(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f7133h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, mVar)) == null) {
            b.a.p0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = b.a.p0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0109e.i(n.G(), n.s1()).getPath();
            }
            String str = l + File.separator + mVar.f44281c;
            if (b.a.p0.t.d.u(str)) {
                swanAppBottomTabIconView.setmIsSelect(true);
                q0.b0(new c(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f7134i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i2 = 0; i2 < this.f7132g.size(); i2++) {
                if (this.f7132g.get(i2).f44279a.equals(str)) {
                    u(i2);
                    this.f7128c = i2;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f7129d.T1()) {
            SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
            if (r == null) {
                if (j) {
                    String str2 = "configData is null." + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = r.f44233f;
            this.f7130e = lVar;
            List<SwanAppConfigData.m> list = lVar.f44276e;
            this.f7132g = list;
            int size = list.size();
            this.f7131f = new ArrayList<>(size);
            this.f7126a = view.findViewById(b.a.p0.a.f.bottom_bar_shadow);
            y(this.f7130e.f44274c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(b.a.p0.a.f.ai_apps_bottom_tab);
            this.f7127b = linearLayout;
            linearLayout.setVisibility(0);
            this.f7127b.setBackgroundColor(this.f7130e.f44275d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f7132g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f44279a, !TextUtils.isEmpty(str) ? str : b.a.p0.a.g1.f.T().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f7128c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f44282d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0331a(this, i2));
                this.f7131f.add(swanAppBottomTabIconView);
                this.f7127b.addView(swanAppBottomTabIconView, layoutParams);
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
            if (this.f7128c == i2) {
                return;
            }
            this.f7128c = i2;
            this.f7129d.pause();
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(this.f7132g.get(i2).f44279a, b.a.p0.a.g1.f.T().z());
            h.f(e2.f6555e, "5");
            this.f7129d.S2(e2, uuid);
            b.a.p0.a.h0.g.f.z3("switchTab");
            this.f7129d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.f7126a == null || this.f7127b == null) {
                return false;
            }
            y(SwanAppConfigData.s(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f7131f.iterator();
            while (it.hasNext()) {
                SwanAppBottomTabIconView next = it.next();
                if (next.ismIsSelect()) {
                    next.setTextColor(SwanAppConfigData.s(str2));
                } else {
                    next.setTextColor(SwanAppConfigData.s(str));
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
                this.f7131f.get(i2).setBadgeVisibleState(false);
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
            View view = this.f7126a;
            if (view == null || this.f7127b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f7127b.setVisibility(8);
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
            if (q(i2) && (swanAppBottomTabIconView = this.f7131f.get(i2)) != null) {
                q0.b0(new f(this, swanAppBottomTabIconView));
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f7127b, Key.TRANSLATION_Y, 0.0f, b.a.p0.a.c1.a.b().getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_height));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7127b : (LinearLayout) invokeV.objValue;
    }

    public final b.a.p0.a.f1.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 != null) {
                return i2.M();
            }
            return null;
        }
        return (b.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.m> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f7132g) != null && list.size() != 0) {
                for (int i2 = 0; i2 < this.f7132g.size(); i2++) {
                    SwanAppConfigData.m mVar = this.f7132g.get(i2);
                    if (mVar != null && TextUtils.equals(mVar.f44279a, str)) {
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
            LinearLayout linearLayout = this.f7127b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f7131f;
            return arrayList != null && i2 < arrayList.size() && i2 >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.f7126a;
            if (view == null || this.f7127b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f7127b.setVisibility(0);
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
                this.f7131f.get(i2).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f7127b, Key.TRANSLATION_Y, b.a.p0.a.c1.a.b().getResources().getDimensionPixelSize(b.a.p0.a.d.aiapps_bottom_tab_height), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            A(this.f7131f.get(this.f7128c), this.f7132g.get(this.f7128c));
            C(this.f7131f.get(i2), this.f7132g.get(i2));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.m mVar = this.f7132g.get(i2);
            String d3 = this.f7129d.d3(b.a.p0.a.l1.b.e(mVar.f44279a, b.a.p0.a.g1.f.T().z()).f6555e);
            hashMap.put("index", String.valueOf(i2));
            hashMap.put("pagePath", mVar.f44279a);
            hashMap.put("text", mVar.f44282d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, d3);
            b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.b("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, str)) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f7131f.get(i2);
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
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f7131f.get(i2);
                q0.b0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f7132g.get(i2).f44280b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f7132g.get(i2).f44281c = str3;
                }
                if (swanAppBottomTabIconView.ismIsSelect()) {
                    return C(swanAppBottomTabIconView, this.f7132g.get(i2));
                }
                return A(swanAppBottomTabIconView, this.f7132g.get(i2));
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
            this.f7126a.setVisibility(0);
            this.f7126a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f7126a.setVisibility(0);
            this.f7126a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(b.a.p0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f7126a.setVisibility(0);
            this.f7126a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f7127b.setBackgroundColor(SwanAppConfigData.s(str));
        }
    }
}
