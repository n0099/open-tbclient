package c.a.o0.o.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentStateManager;
import c.a.o0.o.a.a.e;
import c.a.o0.o.a.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.support.v4.app.BackStackState;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentManagerState;
import com.baidu.swan.support.v4.app.FragmentState;
import com.baidu.swan.support.v4.app.SuperNotCalledException;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class m extends l implements c.a.o0.o.a.d.e {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator A;
    public static boolean x;
    public static final boolean y;
    public static final Interpolator z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Runnable> f12081a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable[] f12082b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12083c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f12084d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f12085e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f12086f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.o0.o.a.a.e> f12087g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Fragment> f12088h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c.a.o0.o.a.a.e> f12089i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<Integer> f12090j;
    public ArrayList<l.a> k;
    public int l;
    public k m;
    public i n;
    public Fragment o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public Bundle u;
    public SparseArray<Parcelable> v;
    public Runnable w;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f12091e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12091e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12091e.E();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f12093f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f12094g;

        public b(m mVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12094g = mVar;
            this.f12092e = i2;
            this.f12093f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m mVar = this.f12094g;
                mVar.X(mVar.m.j(), null, this.f12092e, this.f12093f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f12095c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f12096d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m mVar, View view, Animation animation, Fragment fragment) {
            super(view, animation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, view, animation, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Animation) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12096d = mVar;
            this.f12095c = fragment;
        }

        @Override // c.a.o0.o.a.a.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                super.onAnimationEnd(animation);
                Fragment fragment = this.f12095c;
                if (fragment.f47114f != null) {
                    fragment.f47114f = null;
                    this.f12096d.U(fragment, fragment.f47115g, 0, 0, false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12097a;

        /* renamed from: b  reason: collision with root package name */
        public View f12098b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f12099e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12099e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.o.a.d.f.d(this.f12099e.f12098b, 2, null);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f12100e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12100e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.o.a.d.f.d(this.f12100e.f12098b, 0, null);
                }
            }
        }

        public d(View view, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12097a = false;
            if (view == null || animation == null) {
                return;
            }
            this.f12098b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.f12097a) {
                this.f12098b.post(new b(this));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                boolean j0 = m.j0(this.f12098b, animation);
                this.f12097a = j0;
                if (j0) {
                    this.f12098b.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f12101a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1945340015, "Lc/a/o0/o/a/a/m$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1945340015, "Lc/a/o0/o/a/a/m$e;");
                    return;
                }
            }
            f12101a = new int[]{16842755, 16842960, 16842961};
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-153979406, "Lc/a/o0/o/a/a/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-153979406, "Lc/a/o0/o/a/a/m;");
                return;
            }
        }
        y = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.u = null;
        this.v = null;
        this.w = new a(this);
    }

    public static Animation N(Context context, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setInterpolator(A);
            alphaAnimation.setDuration(220L);
            return alphaAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public static Animation P(Context context, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            AnimationSet animationSet = new AnimationSet(false);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(z);
            scaleAnimation.setDuration(220L);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
            alphaAnimation.setInterpolator(A);
            alphaAnimation.setDuration(220L);
            animationSet.addAnimation(alphaAnimation);
            return animationSet;
        }
        return (Animation) invokeCommon.objValue;
    }

    public static boolean Q(Animation animation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, animation)) == null) {
            if (animation instanceof AlphaAnimation) {
                return true;
            }
            if (animation instanceof AnimationSet) {
                List<Animation> animations = ((AnimationSet) animation).getAnimations();
                for (int i2 = 0; i2 < animations.size(); i2++) {
                    if (animations.get(i2) instanceof AlphaAnimation) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 4097) {
                if (i2 != 4099) {
                    return i2 != 8194 ? 0 : 4097;
                }
                return 4099;
            }
            return 8194;
        }
        return invokeI.intValue;
    }

    public static boolean j0(View view, Animation animation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, view, animation)) == null) ? c.a.o0.o.a.d.f.b(view) == 0 && c.a.o0.o.a.d.f.c(view) && Q(animation) : invokeLL.booleanValue;
    }

    public static int n0(int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (i2 == 4097) {
                return z2 ? 1 : 2;
            } else if (i2 == 4099) {
                return z2 ? 5 : 6;
            } else if (i2 != 8194) {
                return -1;
            } else {
                return z2 ? 3 : 4;
            }
        }
        return invokeCommon.intValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q = false;
            S(5, false);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q = false;
            S(4, false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = true;
            S(3, false);
        }
    }

    public void D(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, runnable, z2) == null) {
            if (!z2) {
                l();
            }
            synchronized (this) {
                if (!this.r && this.m != null) {
                    if (this.f12081a == null) {
                        this.f12081a = new ArrayList<>();
                    }
                    this.f12081a.add(runnable);
                    if (this.f12081a.size() == 1) {
                        this.m.j().removeCallbacks(this.w);
                        this.m.j().post(this.w);
                    }
                } else {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r6.f12083c = true;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r3 >= r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        r6.f12082b[r3].run();
        r6.f12082b[r3] = null;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f12083c) {
                if (Looper.myLooper() == this.m.j().getLooper()) {
                    boolean z2 = false;
                    while (true) {
                        synchronized (this) {
                            if (this.f12081a == null || this.f12081a.size() == 0) {
                                break;
                            }
                            int size = this.f12081a.size();
                            if (this.f12082b == null || this.f12082b.length < size) {
                                this.f12082b = new Runnable[size];
                            }
                            this.f12081a.toArray(this.f12082b);
                            this.f12081a.clear();
                            this.m.j().removeCallbacks(this.w);
                        }
                        this.f12083c = false;
                        z2 = true;
                    }
                    if (this.t) {
                        boolean z3 = false;
                        for (int i2 = 0; i2 < this.f12084d.size(); i2++) {
                            Fragment fragment = this.f12084d.get(i2);
                            if (fragment != null && (qVar = fragment.Q) != null) {
                                z3 |= qVar.j();
                            }
                        }
                        if (!z3) {
                            this.t = false;
                            l0();
                        }
                    }
                    return z2;
                }
                throw new IllegalStateException("Must be called from main thread of process");
            }
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        return invokeV.booleanValue;
    }

    public Fragment F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            ArrayList<Fragment> arrayList = this.f12085e;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.f12085e.get(size);
                    if (fragment != null && fragment.A == i2) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.f12084d;
            if (arrayList2 != null) {
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Fragment fragment2 = this.f12084d.get(size2);
                    if (fragment2 != null && fragment2.A == i2) {
                        return fragment2;
                    }
                }
                return null;
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public Fragment G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ArrayList<Fragment> arrayList = this.f12085e;
            if (arrayList != null && str != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.f12085e.get(size);
                    if (fragment != null && str.equals(fragment.C)) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.f12084d;
            if (arrayList2 == null || str == null) {
                return null;
            }
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f12084d.get(size2);
                if (fragment2 != null && str.equals(fragment2.C)) {
                    return fragment2;
                }
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                this.f12089i.set(i2, null);
                if (this.f12090j == null) {
                    this.f12090j = new ArrayList<>();
                }
                if (x) {
                    String str = "Freeing back stack index " + i2;
                }
                this.f12090j.add(Integer.valueOf(i2));
            }
        }
    }

    public Fragment I(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, str)) == null) {
            int i2 = bundle.getInt(str, -1);
            if (i2 == -1) {
                return null;
            }
            if (i2 < this.f12084d.size()) {
                Fragment fragment = this.f12084d.get(i2);
                if (fragment != null) {
                    return fragment;
                }
                m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
                throw null;
            }
            m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
            throw null;
        }
        return (Fragment) invokeLL.objValue;
    }

    public c.a.o0.o.a.d.e J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (c.a.o0.o.a.d.e) invokeV.objValue;
    }

    public void K(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, fragment, i2, i3) == null) {
            if (x) {
                String str = "hide: " + fragment;
            }
            if (fragment.D) {
                return;
            }
            fragment.D = true;
            if (fragment.M != null) {
                Animation L = L(fragment, i2, false, i3);
                if (L != null) {
                    i0(fragment.M, L);
                    fragment.M.startAnimation(L);
                }
                fragment.M.setVisibility(8);
            }
            if (fragment.p && fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.D0(true);
        }
    }

    public Animation L(Fragment fragment, int i2, boolean z2, int i3) {
        InterceptResult invokeCommon;
        int n0;
        Animation loadAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{fragment, Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            Animation x0 = fragment.x0(i2, z2, fragment.K);
            if (x0 != null) {
                return x0;
            }
            if (fragment.K == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.m.h(), fragment.K)) == null) {
                if (i2 != 0 && (n0 = n0(i2, z2)) >= 0) {
                    switch (n0) {
                        case 1:
                            return P(this.m.h(), 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return P(this.m.h(), 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return P(this.m.h(), 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return P(this.m.h(), 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return N(this.m.h(), 0.0f, 1.0f);
                        case 6:
                            return N(this.m.h(), 1.0f, 0.0f);
                        default:
                            if (i3 == 0 && this.m.r()) {
                                i3 = this.m.q();
                            }
                            if (i3 == 0) {
                            }
                            return null;
                    }
                }
                return null;
            }
            return loadAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public void M(Fragment fragment) {
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) || fragment.f47118j >= 0) {
            return;
        }
        ArrayList<Integer> arrayList2 = this.f12086f;
        if (arrayList2 != null && arrayList2.size() > 0) {
            fragment.i1(this.f12086f.remove(arrayList.size() - 1).intValue(), this.o);
            this.f12084d.set(fragment.f47118j, fragment);
        } else {
            if (this.f12084d == null) {
                this.f12084d = new ArrayList<>();
            }
            fragment.i1(this.f12084d.size(), this.o);
            this.f12084d.add(fragment);
        }
        if (x) {
            String str = "Allocated fragment index " + fragment;
        }
    }

    public void O(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) || fragment.f47118j < 0) {
            return;
        }
        if (x) {
            String str = "Freeing fragment index " + fragment;
        }
        this.f12084d.set(fragment.f47118j, null);
        if (this.f12086f == null) {
            this.f12086f = new ArrayList<>();
        }
        this.f12086f.add(Integer.valueOf(fragment.f47118j));
        this.m.m(fragment.k);
        fragment.j0();
    }

    public void R(int i2, int i3, int i4, boolean z2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            if (this.m == null && i2 != 0) {
                throw new IllegalStateException("No host");
            }
            if (z2 || this.l != i2) {
                this.l = i2;
                if (this.f12084d != null) {
                    boolean z3 = false;
                    for (int i5 = 0; i5 < this.f12084d.size(); i5++) {
                        Fragment fragment = this.f12084d.get(i5);
                        if (fragment != null) {
                            U(fragment, i2, i3, i4, false);
                            q qVar = fragment.Q;
                            if (qVar != null) {
                                z3 |= qVar.j();
                            }
                        }
                    }
                    if (!z3) {
                        l0();
                    }
                    if (this.p && (kVar = this.m) != null && this.l == 5) {
                        kVar.u();
                        this.p = false;
                    }
                }
            }
        }
    }

    public void S(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            R(i2, 0, 0, z2);
        }
    }

    public void T(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fragment) == null) {
            U(fragment, this.l, 0, 0, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x0209 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0145 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Throwable, android.os.Bundle, android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.os.Bundle, android.util.SparseArray<android.os.Parcelable>] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(Fragment fragment, int i2, int i3, int i4, boolean z2) {
        int i5;
        View view;
        boolean z3;
        m i6;
        ?? r5;
        ViewGroup viewGroup;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{fragment, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            int i8 = 1;
            if (!fragment.p || fragment.E) {
                i5 = i2;
                if (i5 > 1) {
                    i5 = 1;
                }
            } else {
                i5 = i2;
            }
            if (fragment.q && i5 > (i7 = fragment.f47113e)) {
                i5 = i7;
            }
            int i9 = (!fragment.O || fragment.f47113e >= 4 || i5 <= 3) ? i5 : 3;
            int i10 = fragment.f47113e;
            if (i10 < i9) {
                if (fragment.s && !fragment.t) {
                    return;
                }
                if (fragment.f47114f != null) {
                    fragment.f47114f = null;
                    U(fragment, fragment.f47115g, 0, 0, true);
                }
                int i11 = fragment.f47113e;
                if (i11 == 0) {
                    if (x) {
                        String str = "moveto CREATED: " + fragment;
                    }
                    Bundle bundle = fragment.f47116h;
                    if (bundle != null) {
                        bundle.setClassLoader(this.m.h().getClassLoader());
                        fragment.f47117i = fragment.f47116h.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                        Fragment I = I(fragment.f47116h, FragmentStateManager.TARGET_STATE_TAG);
                        fragment.m = I;
                        if (I != null) {
                            z3 = false;
                            fragment.o = fragment.f47116h.getInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, 0);
                        } else {
                            z3 = false;
                        }
                        boolean z4 = fragment.f47116h.getBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, true);
                        fragment.P = z4;
                        if (!z4) {
                            fragment.O = true;
                            if (i9 > 3) {
                                i9 = 3;
                            }
                        }
                    } else {
                        z3 = false;
                    }
                    k kVar = this.m;
                    fragment.x = kVar;
                    Fragment fragment2 = this.o;
                    fragment.z = fragment2;
                    if (fragment2 != null) {
                        i6 = fragment2.y;
                    } else {
                        i6 = kVar.i();
                    }
                    fragment.w = i6;
                    fragment.J = z3;
                    fragment.v0(this.m.h());
                    if (fragment.J) {
                        if (fragment.z == null) {
                            this.m.n(fragment);
                        }
                        if (!fragment.G) {
                            fragment.Q0(fragment.f47116h);
                        }
                        fragment.G = z3;
                        if (fragment.s) {
                            r5 = 0;
                            r5 = 0;
                            View S0 = fragment.S0(fragment.v(fragment.f47116h), null, fragment.f47116h);
                            fragment.M = S0;
                            if (S0 != null) {
                                fragment.N = S0;
                                if (Build.VERSION.SDK_INT >= 11) {
                                    c.a.o0.o.a.d.f.e(S0, z3);
                                } else {
                                    fragment.M = r.a(S0);
                                }
                                if (fragment.D) {
                                    fragment.M.setVisibility(8);
                                }
                                fragment.L0(fragment.M, fragment.f47116h);
                            } else {
                                fragment.N = null;
                            }
                            if (i9 > 1) {
                                if (x) {
                                    String str2 = "moveto ACTIVITY_CREATED: " + fragment;
                                }
                                if (!fragment.s) {
                                    int i12 = fragment.B;
                                    if (i12 != 0) {
                                        viewGroup = (ViewGroup) this.n.a(i12);
                                        if (viewGroup == null && !fragment.u) {
                                            m0(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.B) + " (" + fragment.z().getResourceName(fragment.B) + ") for fragment " + fragment));
                                            throw r5;
                                        }
                                    } else {
                                        viewGroup = r5;
                                    }
                                    fragment.L = viewGroup;
                                    View S02 = fragment.S0(fragment.v(fragment.f47116h), viewGroup, fragment.f47116h);
                                    fragment.M = S02;
                                    if (S02 != null) {
                                        fragment.N = S02;
                                        if (Build.VERSION.SDK_INT >= 11) {
                                            c.a.o0.o.a.d.f.e(S02, z3);
                                        } else {
                                            fragment.M = r.a(S02);
                                        }
                                        if (viewGroup != null) {
                                            Animation L = L(fragment, i3, true, i4);
                                            if (L != null) {
                                                i0(fragment.M, L);
                                                fragment.M.startAnimation(L);
                                            }
                                            viewGroup.addView(fragment.M);
                                        }
                                        if (fragment.D) {
                                            fragment.M.setVisibility(8);
                                        }
                                        fragment.L0(fragment.M, fragment.f47116h);
                                    } else {
                                        fragment.N = r5;
                                    }
                                }
                                fragment.N0(fragment.f47116h);
                                if (fragment.M != null) {
                                    fragment.g1(fragment.f47116h);
                                }
                                fragment.f47116h = r5;
                            }
                            if (i9 > 3) {
                            }
                            if (i9 > 4) {
                            }
                        }
                    } else {
                        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                    }
                } else if (i11 == 1) {
                    z3 = false;
                } else if (i11 == 2 || i11 == 3) {
                    r5 = 0;
                    if (i9 > 3) {
                        if (x) {
                            String str3 = "moveto STARTED: " + fragment;
                        }
                        fragment.d1();
                    }
                    if (i9 > 4) {
                        if (x) {
                            String str4 = "moveto RESUMED: " + fragment;
                        }
                        fragment.r = true;
                        fragment.b1();
                        fragment.f47116h = r5;
                        fragment.f47117i = r5;
                    }
                } else if (i11 == 4) {
                    r5 = 0;
                    if (i9 > 4) {
                    }
                }
                r5 = 0;
                if (i9 > 1) {
                }
                if (i9 > 3) {
                }
                if (i9 > 4) {
                }
            } else if (i10 > i9) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 == 5) {
                                    if (i9 < 5) {
                                        if (x) {
                                            String str5 = "movefrom RESUMED: " + fragment;
                                        }
                                        fragment.Y0();
                                        fragment.r = false;
                                    }
                                }
                            }
                            if (i9 < 4) {
                                if (x) {
                                    String str6 = "movefrom STARTED: " + fragment;
                                }
                                fragment.e1();
                            }
                        }
                        if (i9 < 3) {
                            if (x) {
                                String str7 = "movefrom STOPPED: " + fragment;
                            }
                            fragment.a1();
                        }
                    }
                    if (i9 < 2) {
                        if (x) {
                            String str8 = "movefrom ACTIVITY_CREATED: " + fragment;
                        }
                        if (fragment.M != null && this.m.t(fragment) && fragment.f47117i == null) {
                            g0(fragment);
                        }
                        fragment.U0();
                        if (fragment.M != null && fragment.L != null) {
                            Animation L2 = (this.l <= 0 || this.r) ? null : L(fragment, i3, false, i4);
                            if (L2 != null) {
                                View view2 = fragment.M;
                                fragment.f47114f = view2;
                                fragment.f47115g = i9;
                                L2.setAnimationListener(new c(this, view2, L2, fragment));
                                fragment.M.startAnimation(L2);
                            }
                            fragment.L.removeView(fragment.M);
                        }
                        fragment.L = null;
                        fragment.M = null;
                        fragment.N = null;
                    }
                }
                if (i9 < 1) {
                    if (this.r && (view = fragment.f47114f) != null) {
                        fragment.f47114f = null;
                        view.clearAnimation();
                    }
                    if (fragment.f47114f != null) {
                        fragment.f47115g = i9;
                        fragment.f47113e = i8;
                    }
                    if (x) {
                        String str9 = "movefrom CREATED: " + fragment;
                    }
                    if (!fragment.G) {
                        fragment.T0();
                    }
                    fragment.J = false;
                    fragment.C0();
                    if (!fragment.J) {
                        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                    } else if (!z2) {
                        if (!fragment.G) {
                            O(fragment);
                        } else {
                            fragment.x = null;
                            fragment.z = null;
                            fragment.w = null;
                            fragment.y = null;
                        }
                    }
                }
            }
            i8 = i9;
            fragment.f47113e = i8;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q = false;
        }
    }

    public void W(Fragment fragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fragment) == null) && fragment.O) {
            if (this.f12083c) {
                this.t = true;
                return;
            }
            fragment.O = false;
            U(fragment, this.l, 0, 0, false);
        }
    }

    public boolean X(Handler handler, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048596, this, handler, str, i2, i3)) == null) {
            ArrayList<c.a.o0.o.a.a.e> arrayList = this.f12087g;
            if (arrayList == null) {
                return false;
            }
            e.C0624e c0624e = null;
            if (str == null && i2 < 0 && (i3 & 1) == 0) {
                int size2 = arrayList.size() - 1;
                if (size2 < 0) {
                    return false;
                }
                c.a.o0.o.a.a.e remove = this.f12087g.remove(size2);
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                remove.q(sparseArray, sparseArray2);
                remove.I(true, null, sparseArray, sparseArray2);
                a0();
            } else {
                if (str != null || i2 >= 0) {
                    size = this.f12087g.size() - 1;
                    while (size >= 0) {
                        c.a.o0.o.a.a.e eVar = this.f12087g.get(size);
                        if ((str != null && str.equals(eVar.E())) || (i2 >= 0 && i2 == eVar.r)) {
                            break;
                        }
                        size--;
                    }
                    if (size < 0) {
                        return false;
                    }
                    if ((i3 & 1) != 0) {
                        while (true) {
                            size--;
                            if (size < 0) {
                                break;
                            }
                            c.a.o0.o.a.a.e eVar2 = this.f12087g.get(size);
                            if (str == null || !str.equals(eVar2.E())) {
                                if (i2 < 0 || i2 != eVar2.r) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    size = -1;
                }
                if (size == this.f12087g.size() - 1) {
                    return false;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int size3 = this.f12087g.size() - 1; size3 > size; size3--) {
                    arrayList2.add(this.f12087g.remove(size3));
                }
                int size4 = arrayList2.size() - 1;
                SparseArray<Fragment> sparseArray3 = new SparseArray<>();
                SparseArray<Fragment> sparseArray4 = new SparseArray<>();
                for (int i4 = 0; i4 <= size4; i4++) {
                    ((c.a.o0.o.a.a.e) arrayList2.get(i4)).q(sparseArray3, sparseArray4);
                }
                int i5 = 0;
                while (i5 <= size4) {
                    if (x) {
                        String str2 = "Popping back stack state: " + arrayList2.get(i5);
                    }
                    c0624e = ((c.a.o0.o.a.a.e) arrayList2.get(i5)).I(i5 == size4, c0624e, sparseArray3, sparseArray4);
                    i5++;
                }
                a0();
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public void Y(Bundle bundle, String str, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, str, fragment) == null) {
            int i2 = fragment.f47118j;
            if (i2 >= 0) {
                bundle.putInt(str, i2);
                return;
            }
            m0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
            throw null;
        }
    }

    public void Z(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, fragment, i2, i3) == null) {
            if (x) {
                String str = "remove: " + fragment + " nesting=" + fragment.v;
            }
            int i4 = !fragment.q0();
            if (fragment.E && i4 == 0) {
                return;
            }
            ArrayList<Fragment> arrayList = this.f12085e;
            if (arrayList != null) {
                arrayList.remove(fragment);
            }
            if (fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.p = false;
            fragment.q = true;
            U(fragment, i4 ^ 1, i2, i3, false);
        }
    }

    @Override // c.a.o0.o.a.a.l
    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new c.a.o0.o.a.a.e(this) : (n) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.k.get(i2).onBackStackChanged();
        }
    }

    @Override // c.a.o0.o.a.a.l
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, str, fileDescriptor, printWriter, strArr) == null) {
            String str2 = str + "    ";
            ArrayList<Fragment> arrayList = this.f12084d;
            if (arrayList != null && (size6 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i2 = 0; i2 < size6; i2++) {
                    Fragment fragment = this.f12084d.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.g(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.f12085e;
            if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i3 = 0; i3 < size5; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.f12085e.get(i3).toString());
                }
            }
            ArrayList<Fragment> arrayList3 = this.f12088h;
            if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i4 = 0; i4 < size4; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f12088h.get(i4).toString());
                }
            }
            ArrayList<c.a.o0.o.a.a.e> arrayList4 = this.f12087g;
            if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i5 = 0; i5 < size3; i5++) {
                    c.a.o0.o.a.a.e eVar = this.f12087g.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(eVar.toString());
                    eVar.y(str2, fileDescriptor, printWriter, strArr);
                }
            }
            synchronized (this) {
                if (this.f12089i != null && (size2 = this.f12089i.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i6 = 0; i6 < size2; i6++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
                        printWriter.print(": ");
                        printWriter.println((c.a.o0.o.a.a.e) this.f12089i.get(i6));
                    }
                }
                if (this.f12090j != null && this.f12090j.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.f12090j.toArray()));
                }
            }
            ArrayList<Runnable> arrayList5 = this.f12081a;
            if (arrayList5 != null && (size = arrayList5.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i7 = 0; i7 < size; i7++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i7);
                    printWriter.print(": ");
                    printWriter.println((Runnable) this.f12081a.get(i7));
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.n);
            if (this.o != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.o);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.l);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.q);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.r);
            if (this.p) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.p);
            }
            if (this.s != null) {
                printWriter.print(str);
                printWriter.print("  mNoTransactionsBecause=");
                printWriter.println(this.s);
            }
            ArrayList<Integer> arrayList6 = this.f12086f;
            if (arrayList6 == null || arrayList6.size() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f12086f.toArray()));
        }
    }

    public void b0(Parcelable parcelable, List<Fragment> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, parcelable, list) == null) || parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Fragment fragment = list.get(i2);
                if (x) {
                    String str = "restoreAllState: re-attaching retained " + fragment;
                }
                FragmentState fragmentState = fragmentManagerState.mActive[fragment.f47118j];
                fragmentState.mInstance = fragment;
                fragment.f47117i = null;
                fragment.v = 0;
                fragment.t = false;
                fragment.p = false;
                fragment.m = null;
                Bundle bundle = fragmentState.mSavedFragmentState;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.f47117i = fragmentState.mSavedFragmentState.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                    fragment.f47116h = fragmentState.mSavedFragmentState;
                }
            }
        }
        this.f12084d = new ArrayList<>(fragmentManagerState.mActive.length);
        ArrayList<Integer> arrayList = this.f12086f;
        if (arrayList != null) {
            arrayList.clear();
        }
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr = fragmentManagerState.mActive;
            if (i3 >= fragmentStateArr.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr[i3];
            if (fragmentState2 != null) {
                Fragment instantiate = fragmentState2.instantiate(this.m, this.o);
                if (x) {
                    String str2 = "restoreAllState: active #" + i3 + ": " + instantiate;
                }
                this.f12084d.add(instantiate);
                fragmentState2.mInstance = null;
            } else {
                this.f12084d.add(null);
                if (this.f12086f == null) {
                    this.f12086f = new ArrayList<>();
                }
                if (x) {
                    String str3 = "restoreAllState: avail #" + i3;
                }
                this.f12086f.add(Integer.valueOf(i3));
            }
            i3++;
        }
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                Fragment fragment2 = list.get(i4);
                int i5 = fragment2.n;
                if (i5 >= 0) {
                    if (i5 < this.f12084d.size()) {
                        fragment2.m = this.f12084d.get(fragment2.n);
                    } else {
                        String str4 = "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.n;
                        fragment2.m = null;
                    }
                }
            }
        }
        if (fragmentManagerState.mAdded != null) {
            this.f12085e = new ArrayList<>(fragmentManagerState.mAdded.length);
            int i6 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.mAdded;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f12084d.get(iArr[i6]);
                if (fragment3 != null) {
                    fragment3.p = true;
                    if (x) {
                        String str5 = "restoreAllState: added #" + i6 + ": " + fragment3;
                    }
                    if (!this.f12085e.contains(fragment3)) {
                        this.f12085e.add(fragment3);
                        i6++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    m0(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i6]));
                    throw null;
                }
            }
        } else {
            this.f12085e = null;
        }
        if (fragmentManagerState.mBackStack != null) {
            this.f12087g = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i7 >= backStackStateArr.length) {
                    return;
                }
                c.a.o0.o.a.a.e instantiate2 = backStackStateArr[i7].instantiate(this);
                if (x) {
                    String str6 = "restoreAllState: back stack #" + i7 + " (index " + instantiate2.r + "): " + instantiate2;
                    instantiate2.z(GlideException.IndentedAppendable.INDENT, new PrintWriter(new c.a.o0.o.a.c.d("FragmentManager")), false);
                }
                this.f12087g.add(instantiate2);
                int i8 = instantiate2.r;
                if (i8 >= 0) {
                    h0(i8, instantiate2);
                }
                i7++;
            }
        } else {
            this.f12087g = null;
        }
    }

    @Override // c.a.o0.o.a.a.l
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? E() : invokeV.booleanValue;
    }

    public ArrayList<Fragment> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.f12084d != null) {
                for (int i2 = 0; i2 < this.f12084d.size(); i2++) {
                    Fragment fragment = this.f12084d.get(i2);
                    if (fragment != null && fragment.F) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(fragment);
                        fragment.G = true;
                        Fragment fragment2 = fragment.m;
                        fragment.n = fragment2 != null ? fragment2.f47118j : -1;
                        if (x) {
                            String str = "retainNonConfig: keeping retained " + fragment;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.o0.o.a.a.l
    public List<Fragment> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f12084d : (List) invokeV.objValue;
    }

    @Override // c.a.o0.o.a.a.l
    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            if (i2 >= 0) {
                D(new b(this, i2, i3), false);
                return;
            }
            throw new IllegalArgumentException("Bad id: " + i2);
        }
    }

    public Parcelable e0() {
        InterceptResult invokeV;
        int[] iArr;
        int size;
        int size2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            E();
            if (y) {
                this.q = true;
            }
            ArrayList<Fragment> arrayList = this.f12084d;
            BackStackState[] backStackStateArr = null;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            int size3 = this.f12084d.size();
            FragmentState[] fragmentStateArr = new FragmentState[size3];
            boolean z2 = false;
            for (int i2 = 0; i2 < size3; i2++) {
                Fragment fragment = this.f12084d.get(i2);
                if (fragment != null) {
                    if (fragment.f47118j >= 0) {
                        FragmentState fragmentState = new FragmentState(fragment);
                        fragmentStateArr[i2] = fragmentState;
                        if (fragment.f47113e > 0 && fragmentState.mSavedFragmentState == null) {
                            Bundle f0 = f0(fragment);
                            fragmentState.mSavedFragmentState = f0;
                            Fragment fragment2 = fragment.m;
                            if (fragment2 != null) {
                                if (fragment2.f47118j >= 0) {
                                    if (f0 == null) {
                                        fragmentState.mSavedFragmentState = new Bundle();
                                    }
                                    Y(fragmentState.mSavedFragmentState, FragmentStateManager.TARGET_STATE_TAG, fragment.m);
                                    int i3 = fragment.o;
                                    if (i3 != 0) {
                                        fragmentState.mSavedFragmentState.putInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, i3);
                                    }
                                } else {
                                    m0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.m));
                                    throw null;
                                }
                            }
                        } else {
                            fragmentState.mSavedFragmentState = fragment.f47116h;
                        }
                        if (x) {
                            String str = "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState;
                        }
                        z2 = true;
                    } else {
                        m0(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f47118j));
                        throw null;
                    }
                }
            }
            if (!z2) {
                boolean z3 = x;
                return null;
            }
            ArrayList<Fragment> arrayList2 = this.f12085e;
            if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i4 = 0; i4 < size2; i4++) {
                    iArr[i4] = this.f12085e.get(i4).f47118j;
                    if (iArr[i4] >= 0) {
                        if (x) {
                            String str2 = "saveAllState: adding fragment #" + i4 + ": " + this.f12085e.get(i4);
                        }
                    } else {
                        m0(new IllegalStateException("Failure saving state: active " + this.f12085e.get(i4) + " has cleared index: " + iArr[i4]));
                        throw null;
                    }
                }
            }
            ArrayList<c.a.o0.o.a.a.e> arrayList3 = this.f12087g;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i5 = 0; i5 < size; i5++) {
                    backStackStateArr[i5] = new BackStackState(this.f12087g.get(i5));
                    if (x) {
                        String str3 = "saveAllState: adding back stack #" + i5 + ": " + this.f12087g.get(i5);
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = fragmentStateArr;
            fragmentManagerState.mAdded = iArr;
            fragmentManagerState.mBackStack = backStackStateArr;
            return fragmentManagerState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // c.a.o0.o.a.a.l
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            l();
            c();
            return X(this.m.j(), null, -1, 0);
        }
        return invokeV.booleanValue;
    }

    public Bundle f0(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fragment)) == null) {
            if (this.u == null) {
                this.u = new Bundle();
            }
            fragment.c1(this.u);
            Bundle bundle = null;
            if (!this.u.isEmpty()) {
                Bundle bundle2 = this.u;
                this.u = null;
                bundle = bundle2;
            }
            if (fragment.M != null) {
                g0(fragment);
            }
            if (fragment.f47117i != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG, fragment.f47117i);
            }
            if (!fragment.P) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, fragment.P);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void g(c.a.o0.o.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            if (this.f12087g == null) {
                this.f12087g = new ArrayList<>();
            }
            this.f12087g.add(eVar);
            a0();
        }
    }

    public void g0(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, fragment) == null) || fragment.N == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.v;
        if (sparseArray == null) {
            this.v = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.N.saveHierarchyState(this.v);
        if (this.v.size() > 0) {
            fragment.f47117i = this.v;
            this.v = null;
        }
    }

    public void h(Fragment fragment, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, fragment, z2) == null) {
            if (this.f12085e == null) {
                this.f12085e = new ArrayList<>();
            }
            if (x) {
                String str = "add: " + fragment;
            }
            M(fragment);
            if (fragment.E) {
                return;
            }
            if (!this.f12085e.contains(fragment)) {
                this.f12085e.add(fragment);
                fragment.p = true;
                fragment.q = false;
                if (fragment.H && fragment.I) {
                    this.p = true;
                }
                if (z2) {
                    T(fragment);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public void h0(int i2, c.a.o0.o.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i2, eVar) == null) {
            synchronized (this) {
                if (this.f12089i == null) {
                    this.f12089i = new ArrayList<>();
                }
                int size = this.f12089i.size();
                if (i2 < size) {
                    if (x) {
                        String str = "Setting back stack index " + i2 + " to " + eVar;
                    }
                    this.f12089i.set(i2, eVar);
                } else {
                    while (size < i2) {
                        this.f12089i.add(null);
                        if (this.f12090j == null) {
                            this.f12090j = new ArrayList<>();
                        }
                        if (x) {
                            String str2 = "Adding available back stack index " + size;
                        }
                        this.f12090j.add(Integer.valueOf(size));
                        size++;
                    }
                    if (x) {
                        String str3 = "Adding back stack index " + i2 + " with " + eVar;
                    }
                    this.f12089i.add(eVar);
                }
            }
        }
    }

    public int i(c.a.o0.o.a.a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, eVar)) == null) {
            synchronized (this) {
                if (this.f12090j != null && this.f12090j.size() > 0) {
                    int intValue = this.f12090j.remove(this.f12090j.size() - 1).intValue();
                    if (x) {
                        String str = "Adding back stack index " + intValue + " with " + eVar;
                    }
                    this.f12089i.set(intValue, eVar);
                    return intValue;
                }
                if (this.f12089i == null) {
                    this.f12089i = new ArrayList<>();
                }
                int size = this.f12089i.size();
                if (x) {
                    String str2 = "Setting back stack index " + size + " to " + eVar;
                }
                this.f12089i.add(eVar);
                return size;
            }
        }
        return invokeL.intValue;
    }

    public final void i0(View view, Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, view, animation) == null) || view == null || animation == null || !j0(view, animation)) {
            return;
        }
        animation.setAnimationListener(new d(view, animation));
    }

    public void j(k kVar, i iVar, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, kVar, iVar, fragment) == null) {
            if (this.m == null) {
                this.m = kVar;
                this.n = iVar;
                this.o = fragment;
                return;
            }
            throw new IllegalStateException("Already attached");
        }
    }

    public void k(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, fragment, i2, i3) == null) {
            if (x) {
                String str = "attach: " + fragment;
            }
            if (fragment.E) {
                fragment.E = false;
                if (fragment.p) {
                    return;
                }
                if (this.f12085e == null) {
                    this.f12085e = new ArrayList<>();
                }
                if (!this.f12085e.contains(fragment)) {
                    if (x) {
                        String str2 = "add from attach: " + fragment;
                    }
                    this.f12085e.add(fragment);
                    fragment.p = true;
                    if (fragment.H && fragment.I) {
                        this.p = true;
                    }
                    U(fragment, this.l, i2, i3, false);
                    return;
                }
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
        }
    }

    public void k0(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048618, this, fragment, i2, i3) == null) {
            if (x) {
                String str = "show: " + fragment;
            }
            if (fragment.D) {
                fragment.D = false;
                if (fragment.M != null) {
                    Animation L = L(fragment, i2, true, i3);
                    if (L != null) {
                        i0(fragment.M, L);
                        fragment.M.startAnimation(L);
                    }
                    fragment.M.setVisibility(0);
                }
                if (fragment.p && fragment.H && fragment.I) {
                    this.p = true;
                }
                fragment.D0(false);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (!this.q) {
                if (this.s == null) {
                    return;
                }
                throw new IllegalStateException("Can not perform this action inside of " + this.s);
            }
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.f12084d == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f12084d.size(); i2++) {
            Fragment fragment = this.f12084d.get(i2);
            if (fragment != null) {
                W(fragment);
            }
        }
    }

    public void m(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, fragment, i2, i3) == null) {
            if (x) {
                String str = "detach: " + fragment;
            }
            if (fragment.E) {
                return;
            }
            fragment.E = true;
            if (fragment.p) {
                if (this.f12085e != null) {
                    if (x) {
                        String str2 = "remove from detach: " + fragment;
                    }
                    this.f12085e.remove(fragment);
                }
                if (fragment.H && fragment.I) {
                    this.p = true;
                }
                fragment.p = false;
                U(fragment, 1, i2, i3, false);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0026 -> B:16:0x0026). Please submit an issue!!! */
    public final void m0(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, runtimeException) == null) {
            runtimeException.getMessage();
            PrintWriter printWriter = new PrintWriter(new c.a.o0.o.a.c.d("FragmentManager"));
            k kVar = this.m;
            try {
                if (kVar != null) {
                    kVar.o(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                } else {
                    b(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                }
            } catch (Exception unused) {
            }
            try {
                printWriter.close();
            } catch (Exception unused2) {
                boolean z2 = x;
            }
            throw runtimeException;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.q = false;
            S(2, false);
        }
    }

    public void o(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, configuration) == null) || this.f12085e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
            Fragment fragment = this.f12085e.get(i2);
            if (fragment != null) {
                fragment.O0(configuration);
            }
        }
    }

    @Override // c.a.o0.o.a.d.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, view, str, context, attributeSet)) == null) {
            if ("fragment".equals(str)) {
                String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f12101a);
                if (attributeValue == null) {
                    attributeValue = obtainStyledAttributes.getString(0);
                }
                String str2 = attributeValue;
                int resourceId = obtainStyledAttributes.getResourceId(1, -1);
                String string = obtainStyledAttributes.getString(2);
                obtainStyledAttributes.recycle();
                if (Fragment.r0(this.m.h(), str2)) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                    }
                    Fragment F = resourceId != -1 ? F(resourceId) : null;
                    if (F == null && string != null) {
                        F = G(string);
                    }
                    if (F == null && id != -1) {
                        F = F(id);
                    }
                    if (x) {
                        String str3 = "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + F;
                    }
                    if (F == null) {
                        F = Fragment.k0(context, str2);
                        F.s = true;
                        F.A = resourceId != 0 ? resourceId : id;
                        F.B = id;
                        F.C = string;
                        F.t = true;
                        F.w = this;
                        k kVar = this.m;
                        F.x = kVar;
                        F.F0(kVar.h(), attributeSet, F.f47116h);
                        h(F, true);
                    } else if (!F.t) {
                        F.t = true;
                        if (!F.G) {
                            F.F0(this.m.h(), attributeSet, F.f47116h);
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                    }
                    Fragment fragment = F;
                    if (this.l < 1 && fragment.s) {
                        U(fragment, 1, 0, 0, false);
                    } else {
                        T(fragment);
                    }
                    View view2 = fragment.M;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (fragment.M.getTag() == null) {
                            fragment.M.setTag(string);
                        }
                        return fragment.M;
                    }
                    throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
                }
                return null;
            }
            return null;
        }
        return (View) invokeLLLL.objValue;
    }

    public boolean p(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, menuItem)) == null) {
            if (this.f12085e != null) {
                for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
                    Fragment fragment = this.f12085e.get(i2);
                    if (fragment != null && fragment.P0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.q = false;
            S(1, false);
        }
    }

    public boolean r(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, menu, menuInflater)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.f12085e != null) {
                z2 = false;
                for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
                    Fragment fragment = this.f12085e.get(i2);
                    if (fragment != null && fragment.R0(menu, menuInflater)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(fragment);
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (this.f12088h != null) {
                for (int i3 = 0; i3 < this.f12088h.size(); i3++) {
                    Fragment fragment2 = this.f12088h.get(i3);
                    if (arrayList == null || !arrayList.contains(fragment2)) {
                        fragment2.A0();
                    }
                }
            }
            this.f12088h = arrayList;
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.r = true;
            E();
            S(0, false);
            this.m = null;
            this.n = null;
            this.o = null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            S(1, false);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("FragmentManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            Fragment fragment = this.o;
            if (fragment != null) {
                c.a.o0.o.a.c.c.a(fragment, sb);
            } else {
                c.a.o0.o.a.c.c.a(this.m, sb);
            }
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.f12085e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
            Fragment fragment = this.f12085e.get(i2);
            if (fragment != null) {
                fragment.V0();
            }
        }
    }

    public boolean v(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, menuItem)) == null) {
            if (this.f12085e != null) {
                for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
                    Fragment fragment = this.f12085e.get(i2);
                    if (fragment != null && fragment.W0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, menu) == null) || this.f12085e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
            Fragment fragment = this.f12085e.get(i2);
            if (fragment != null) {
                fragment.X0(menu);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            S(4, false);
        }
    }

    public boolean y(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, menu)) == null) {
            if (this.f12085e != null) {
                boolean z2 = false;
                for (int i2 = 0; i2 < this.f12085e.size(); i2++) {
                    Fragment fragment = this.f12085e.get(i2);
                    if (fragment != null && fragment.Z0(menu)) {
                        z2 = true;
                    }
                }
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            S(2, false);
        }
    }
}
