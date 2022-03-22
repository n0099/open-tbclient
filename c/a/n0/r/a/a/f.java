package c.a.n0.r.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.r.a.a.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class f extends o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final n a;

    /* renamed from: b  reason: collision with root package name */
    public d f9281b;

    /* renamed from: c  reason: collision with root package name */
    public d f9282c;

    /* renamed from: d  reason: collision with root package name */
    public int f9283d;

    /* renamed from: e  reason: collision with root package name */
    public int f9284e;

    /* renamed from: f  reason: collision with root package name */
    public int f9285f;

    /* renamed from: g  reason: collision with root package name */
    public int f9286g;

    /* renamed from: h  reason: collision with root package name */
    public int f9287h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public String m;
    public boolean n;
    public int o;
    public int p;
    public CharSequence q;
    public int r;
    public CharSequence s;
    public ArrayList<String> t;
    public ArrayList<String> u;

    /* loaded from: classes2.dex */
    public class a implements p.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Fragment a;

        public a(f fVar, Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragment;
        }

        @Override // c.a.n0.r.a.a.p.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.Q() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f9288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9289c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f9290d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f9291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Fragment f9292f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Fragment f9293g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f9294h;

        public b(f fVar, View view, Object obj, ArrayList arrayList, e eVar, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, obj, arrayList, eVar, Boolean.valueOf(z), fragment, fragment2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9294h = fVar;
            this.a = view;
            this.f9288b = obj;
            this.f9289c = arrayList;
            this.f9290d = eVar;
            this.f9291e = z;
            this.f9292f = fragment;
            this.f9293g = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.f9288b;
                if (obj != null) {
                    p.s(obj, this.f9289c);
                    this.f9289c.clear();
                    c.a.n0.r.a.c.a I = this.f9294h.I(this.f9290d, this.f9291e, this.f9292f);
                    p.v(this.f9288b, this.f9290d.f9308d, I, this.f9289c);
                    this.f9294h.P(I, this.f9290d);
                    this.f9294h.t(this.f9290d, this.f9292f, this.f9293g, this.f9291e, I);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f9295b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f9296c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f9297d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9298e;

        public c(f fVar, View view, e eVar, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, eVar, Integer.valueOf(i), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9298e = fVar;
            this.a = view;
            this.f9295b = eVar;
            this.f9296c = i;
            this.f9297d = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f9298e.B(this.f9295b, this.f9296c, this.f9297d);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public d f9299b;

        /* renamed from: c  reason: collision with root package name */
        public int f9300c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f9301d;

        /* renamed from: e  reason: collision with root package name */
        public int f9302e;

        /* renamed from: f  reason: collision with root package name */
        public int f9303f;

        /* renamed from: g  reason: collision with root package name */
        public int f9304g;

        /* renamed from: h  reason: collision with root package name */
        public int f9305h;
        public ArrayList<Fragment> i;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.n0.r.a.c.a<String, String> a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f9306b;

        /* renamed from: c  reason: collision with root package name */
        public p.e f9307c;

        /* renamed from: d  reason: collision with root package name */
        public View f9308d;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c.a.n0.r.a.c.a<>();
            this.f9306b = new ArrayList<>();
            this.f9307c = new p.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1718531851, "Lc/a/n0/r/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1718531851, "Lc/a/n0/r/a/a/f;");
                return;
            }
        }
        v = Build.VERSION.SDK_INT >= 21;
    }

    public f(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.o = -1;
        this.a = nVar;
    }

    public static Object D(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return p.j(z ? fragment.w() : fragment.r());
        }
        return invokeLZ.objValue;
    }

    public static Object E(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return p.j(z ? fragment.A() : fragment.s());
        }
        return invokeLZ.objValue;
    }

    public static Object G(Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeLLZ;
        Object D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z)) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z) {
                D = fragment2.F();
            } else {
                D = fragment.D();
            }
            return p.w(D);
        }
        return invokeLLZ.objValue;
    }

    public static c.a.n0.r.a.c.a<String, View> L(ArrayList<String> arrayList, ArrayList<String> arrayList2, c.a.n0.r.a.c.a<String, View> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, arrayList, arrayList2, aVar)) == null) {
            if (aVar.isEmpty()) {
                return aVar;
            }
            c.a.n0.r.a.c.a<String, View> aVar2 = new c.a.n0.r.a.c.a<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = aVar.get(arrayList.get(i));
                if (view != null) {
                    aVar2.put(arrayList2.get(i), view);
                }
            }
            return aVar2;
        }
        return (c.a.n0.r.a.c.a) invokeLLL.objValue;
    }

    public static void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, sparseArray, fragment) == null) || fragment == null || (i = fragment.x) == 0 || fragment.j0() || !fragment.e0() || fragment.Q() == null || sparseArray.get(i) != null) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public static void S(c.a.n0.r.a.c.a<String, String> aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, aVar, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        for (int i = 0; i < aVar.size(); i++) {
            if (str.equals(aVar.k(i))) {
                aVar.j(i, str2);
                return;
            }
        }
        aVar.put(str, str2);
    }

    public static void U(e eVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, eVar, arrayList, arrayList2) == null) || arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            S(eVar.a, arrayList.get(i), arrayList2.get(i));
        }
    }

    public static Object u(Object obj, Fragment fragment, ArrayList<View> arrayList, c.a.n0.r.a.c.a<String, View> aVar, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, aVar, view)) == null) ? obj != null ? p.g(obj, fragment.Q(), arrayList, aVar, view) : obj : invokeLLLLL.objValue;
    }

    public void A(String str, PrintWriter printWriter, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, printWriter, z) == null) {
            if (z) {
                printWriter.print(str);
                printWriter.print("mName=");
                printWriter.print(this.m);
                printWriter.print(" mIndex=");
                printWriter.print(this.o);
                printWriter.print(" mCommitted=");
                printWriter.println(this.n);
                if (this.i != 0) {
                    printWriter.print(str);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(this.i));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(this.j));
                }
                if (this.f9284e != 0 || this.f9285f != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f9284e));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f9285f));
                }
                if (this.f9286g != 0 || this.f9287h != 0) {
                    printWriter.print(str);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f9286g));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f9287h));
                }
                if (this.p != 0 || this.q != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(this.p));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(this.q);
                }
                if (this.r != 0 || this.s != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(this.r));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(this.s);
                }
            }
            if (this.f9281b != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.f9281b;
                int i = 0;
                while (dVar != null) {
                    switch (dVar.f9300c) {
                        case 0:
                            str2 = "NULL";
                            break;
                        case 1:
                            str2 = "ADD";
                            break;
                        case 2:
                            str2 = "REPLACE";
                            break;
                        case 3:
                            str2 = "REMOVE";
                            break;
                        case 4:
                            str2 = "HIDE";
                            break;
                        case 5:
                            str2 = "SHOW";
                            break;
                        case 6:
                            str2 = "DETACH";
                            break;
                        case 7:
                            str2 = "ATTACH";
                            break;
                        default:
                            str2 = "cmd=" + dVar.f9300c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.f9301d);
                    if (z) {
                        if (dVar.f9302e != 0 || dVar.f9303f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f9302e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f9303f));
                        }
                        if (dVar.f9304g != 0 || dVar.f9305h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f9304g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f9305h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i2 = 0; i2 < dVar.i.size(); i2++) {
                            printWriter.print(str3);
                            if (dVar.i.size() == 1) {
                                printWriter.print("Removed: ");
                            } else {
                                if (i2 == 0) {
                                    printWriter.println("Removed:");
                                }
                                printWriter.print(str3);
                                printWriter.print("  #");
                                printWriter.print(i2);
                                printWriter.print(": ");
                            }
                            printWriter.println(dVar.i.get(i2));
                        }
                    }
                    dVar = dVar.a;
                    i++;
                }
            }
        }
    }

    public final void B(e eVar, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, i, obj) == null) || this.a.f9319e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.a.f9319e.size(); i2++) {
            Fragment fragment = this.a.f9319e.get(i2);
            View view = fragment.I;
            if (view != null && fragment.H != null && fragment.x == i) {
                if (fragment.z) {
                    if (!eVar.f9306b.contains(view)) {
                        p.l(obj, fragment.I, true);
                        eVar.f9306b.add(fragment.I);
                    }
                } else {
                    p.l(obj, view, false);
                    eVar.f9306b.remove(fragment.I);
                }
            }
        }
    }

    public final void C(View view, e eVar, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, view, eVar, i, obj) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, eVar, i, obj));
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public final c.a.n0.r.a.c.a<String, View> H(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, eVar, fragment, z)) == null) {
            c.a.n0.r.a.c.a<String, View> aVar = new c.a.n0.r.a.c.a<>();
            View Q = fragment.Q();
            if (Q == null || this.t == null) {
                return aVar;
            }
            p.m(aVar, Q);
            if (z) {
                return L(this.t, this.u, aVar);
            }
            aVar.m(this.u);
            return aVar;
        }
        return (c.a.n0.r.a.c.a) invokeLLZ.objValue;
    }

    public final c.a.n0.r.a.c.a<String, View> I(e eVar, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z), fragment})) == null) {
            c.a.n0.r.a.c.a<String, View> H = H(eVar, fragment, z);
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.Y;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.u, H);
                }
                N(eVar, H, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.X;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.u, H);
                }
                T(eVar, H, true);
            }
            return H;
        }
        return (c.a.n0.r.a.c.a) invokeCommon.objValue;
    }

    public e J(boolean z, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), eVar, sparseArray, sparseArray2})) == null) {
            e eVar2 = null;
            if (n.x) {
                Log.v("FragmentManager", "popFromBackStack: " + this);
                c.a.n0.r.a.c.d dVar = new c.a.n0.r.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                v(printWriter);
                v(dVar);
            }
            if (v) {
                if (eVar == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        eVar = p(sparseArray, sparseArray2, true);
                    }
                } else if (!z) {
                    U(eVar, this.u, this.t);
                }
            }
            q(-1);
            int i = eVar != null ? 0 : this.j;
            int i2 = eVar != null ? 0 : this.i;
            for (d dVar2 = this.f9282c; dVar2 != null; dVar2 = dVar2.f9299b) {
                int i3 = eVar != null ? 0 : dVar2.f9304g;
                int i4 = eVar != null ? 0 : dVar2.f9305h;
                switch (dVar2.f9300c) {
                    case 1:
                        Fragment fragment = dVar2.f9301d;
                        fragment.G = i4;
                        this.a.Z(fragment, n.d0(i2), i);
                        break;
                    case 2:
                        Fragment fragment2 = dVar2.f9301d;
                        if (fragment2 != null) {
                            fragment2.G = i4;
                            this.a.Z(fragment2, n.d0(i2), i);
                        }
                        if (dVar2.i != null) {
                            for (int i5 = 0; i5 < dVar2.i.size(); i5++) {
                                Fragment fragment3 = dVar2.i.get(i5);
                                fragment3.G = i3;
                                this.a.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar2.f9301d;
                        fragment4.G = i3;
                        this.a.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar2.f9301d;
                        fragment5.G = i3;
                        this.a.k0(fragment5, n.d0(i2), i);
                        break;
                    case 5:
                        Fragment fragment6 = dVar2.f9301d;
                        fragment6.G = i4;
                        this.a.K(fragment6, n.d0(i2), i);
                        break;
                    case 6:
                        Fragment fragment7 = dVar2.f9301d;
                        fragment7.G = i3;
                        this.a.k(fragment7, n.d0(i2), i);
                        break;
                    case 7:
                        Fragment fragment8 = dVar2.f9301d;
                        fragment8.G = i3;
                        this.a.m(fragment8, n.d0(i2), i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar2.f9300c);
                }
            }
            if (z) {
                n nVar = this.a;
                nVar.R(nVar.l, n.d0(i2), i, true);
            } else {
                eVar2 = eVar;
            }
            int i6 = this.o;
            if (i6 >= 0) {
                this.a.H(i6);
                this.o = -1;
            }
            return eVar2;
        }
        return (e) invokeCommon.objValue;
    }

    public final void K(e eVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eVar, view, obj, fragment, fragment2, Boolean.valueOf(z), arrayList}) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj, arrayList, eVar, z, fragment, fragment2));
        }
    }

    public final c.a.n0.r.a.c.a<String, View> M(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, fragment, z)) == null) {
            c.a.n0.r.a.c.a<String, View> aVar = new c.a.n0.r.a.c.a<>();
            if (this.t != null) {
                p.m(aVar, fragment.Q());
                if (z) {
                    aVar.m(this.u);
                } else {
                    aVar = L(this.t, this.u, aVar);
                }
            }
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.X;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.u, aVar);
                }
                N(eVar, aVar, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.Y;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.u, aVar);
                }
                T(eVar, aVar, false);
            }
            return aVar;
        }
        return (c.a.n0.r.a.c.a) invokeLLZ.objValue;
    }

    public final void N(e eVar, c.a.n0.r.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, aVar, z) == null) {
            ArrayList<String> arrayList = this.u;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = this.t.get(i);
                View view = aVar.get(this.u.get(i));
                if (view != null) {
                    String o = p.o(view);
                    if (z) {
                        S(eVar.a, str, o);
                    } else {
                        S(eVar.a, o, str);
                    }
                }
            }
        }
    }

    public o O(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i, i2, i3, i4)) == null) {
            this.f9284e = i;
            this.f9285f = i2;
            this.f9286g = i3;
            this.f9287h = i4;
            return this;
        }
        return (o) invokeIIII.objValue;
    }

    public final void P(c.a.n0.r.a.c.a<String, View> aVar, e eVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, aVar, eVar) == null) || this.u == null || aVar.isEmpty() || (view = aVar.get(this.u.get(0))) == null) {
            return;
        }
        eVar.f9307c.a = view;
    }

    public final void R(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, sparseArray, fragment) == null) || fragment == null || (i = fragment.x) == 0) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public final void T(e eVar, c.a.n0.r.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, eVar, aVar, z) == null) {
            int size = aVar.size();
            for (int i = 0; i < size; i++) {
                String h2 = aVar.h(i);
                String o = p.o(aVar.k(i));
                if (z) {
                    S(eVar.a, h2, o);
                } else {
                    S(eVar.a, o, h2);
                }
            }
        }
    }

    @Override // c.a.n0.r.a.a.o
    public o a(int i, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, fragment)) == null) {
            y(i, fragment, null, 1);
            return this;
        }
        return (o) invokeIL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o b(int i, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i, fragment, str)) == null) {
            y(i, fragment, str, 1);
            return this;
        }
        return (o) invokeILL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, fragment, str)) == null) {
            y(0, fragment, str, 1);
            return this;
        }
        return (o) invokeLL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (this.l) {
                this.k = true;
                this.m = str;
                return this;
            }
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? w(false) : invokeV.intValue;
    }

    @Override // c.a.n0.r.a.a.o
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? w(true) : invokeV.intValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fragment)) == null) {
            d dVar = new d();
            dVar.f9300c = 4;
            dVar.f9301d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o h(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.f9300c = 3;
            dVar.f9301d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            O(i, i2, 0, 0);
            return this;
        }
        return (o) invokeII.objValue;
    }

    @Override // c.a.n0.r.a.a.o
    public o j(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, fragment)) == null) {
            d dVar = new d();
            dVar.f9300c = 5;
            dVar.f9301d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    public void o(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            if (this.f9281b == null) {
                this.f9282c = dVar;
                this.f9281b = dVar;
            } else {
                d dVar2 = this.f9282c;
                dVar.f9299b = dVar2;
                dVar2.a = dVar;
                this.f9282c = dVar;
            }
            dVar.f9302e = this.f9284e;
            dVar.f9303f = this.f9285f;
            dVar.f9304g = this.f9286g;
            dVar.f9305h = this.f9287h;
            this.f9283d++;
        }
    }

    public final e p(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048601, this, sparseArray, sparseArray2, z)) == null) {
            e eVar = new e(this);
            eVar.f9308d = new View(this.a.m.getContext());
            boolean z2 = false;
            for (int i = 0; i < sparseArray.size(); i++) {
                if (x(sparseArray.keyAt(i), eVar, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                int keyAt = sparseArray2.keyAt(i2);
                if (sparseArray.get(keyAt) == null && x(keyAt, eVar, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            if (z2) {
                return eVar;
            }
            return null;
        }
        return (e) invokeLLZ.objValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.k) {
            if (n.x) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (d dVar = this.f9281b; dVar != null; dVar = dVar.a) {
                Fragment fragment = dVar.f9301d;
                if (fragment != null) {
                    fragment.r += i;
                    if (n.x) {
                        Log.v("FragmentManager", "Bump nesting of " + dVar.f9301d + " to " + dVar.f9301d.r);
                    }
                }
                ArrayList<Fragment> arrayList = dVar.i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.i.get(size);
                        fragment2.r += i;
                        if (n.x) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.r);
                        }
                    }
                }
            }
        }
    }

    public void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, sparseArray, sparseArray2) == null) && this.a.n.b()) {
            for (d dVar = this.f9281b; dVar != null; dVar = dVar.a) {
                switch (dVar.f9300c) {
                    case 1:
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                R(sparseArray2, dVar.i.get(size));
                            }
                        }
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 3:
                        R(sparseArray2, dVar.f9301d);
                        break;
                    case 4:
                        R(sparseArray2, dVar.f9301d);
                        break;
                    case 5:
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 6:
                        R(sparseArray2, dVar.f9301d);
                        break;
                    case 7:
                        Q(sparseArray, dVar.f9301d);
                        break;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (n.x) {
                Log.v("FragmentManager", "Run: " + this);
            }
            if (this.k && this.o < 0) {
                throw new IllegalStateException("addToBackStack() called after commit()");
            }
            q(1);
            if (v) {
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                s(sparseArray, sparseArray2);
                eVar = p(sparseArray, sparseArray2, false);
            } else {
                eVar = null;
            }
            int i = eVar != null ? 0 : this.j;
            int i2 = eVar != null ? 0 : this.i;
            for (d dVar = this.f9281b; dVar != null; dVar = dVar.a) {
                int i3 = eVar != null ? 0 : dVar.f9302e;
                int i4 = eVar != null ? 0 : dVar.f9303f;
                switch (dVar.f9300c) {
                    case 1:
                        Fragment fragment = dVar.f9301d;
                        fragment.G = i3;
                        this.a.h(fragment, false);
                        continue;
                    case 2:
                        Fragment fragment2 = dVar.f9301d;
                        int i5 = fragment2.x;
                        if (this.a.f9319e != null) {
                            for (int i6 = 0; i6 < this.a.f9319e.size(); i6++) {
                                Fragment fragment3 = this.a.f9319e.get(i6);
                                if (n.x) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                                }
                                if (fragment3.x == i5) {
                                    if (fragment3 == fragment2) {
                                        dVar.f9301d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.i == null) {
                                            dVar.i = new ArrayList<>();
                                        }
                                        dVar.i.add(fragment3);
                                        fragment3.G = i4;
                                        if (this.k) {
                                            fragment3.r++;
                                            if (n.x) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.r);
                                            }
                                        }
                                        this.a.Z(fragment3, i2, i);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.G = i3;
                            this.a.h(fragment2, false);
                            continue;
                        }
                        break;
                    case 3:
                        Fragment fragment4 = dVar.f9301d;
                        fragment4.G = i4;
                        this.a.Z(fragment4, i2, i);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.f9301d;
                        fragment5.G = i4;
                        this.a.K(fragment5, i2, i);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.f9301d;
                        fragment6.G = i3;
                        this.a.k0(fragment6, i2, i);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.f9301d;
                        fragment7.G = i4;
                        this.a.m(fragment7, i2, i);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.f9301d;
                        fragment8.G = i3;
                        this.a.k(fragment8, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.f9300c);
                }
            }
            n nVar = this.a;
            nVar.R(nVar.l, i2, i, true);
            if (this.k) {
                this.a.g(this);
            }
        }
    }

    public final void s(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, sparseArray, sparseArray2) == null) && this.a.n.b()) {
            for (d dVar = this.f9281b; dVar != null; dVar = dVar.a) {
                switch (dVar.f9300c) {
                    case 1:
                        R(sparseArray2, dVar.f9301d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f9301d;
                        if (this.a.f9319e != null) {
                            for (int i = 0; i < this.a.f9319e.size(); i++) {
                                Fragment fragment2 = this.a.f9319e.get(i);
                                if (fragment == null || fragment2.x == fragment.x) {
                                    if (fragment2 == fragment) {
                                        fragment = null;
                                    } else {
                                        Q(sparseArray, fragment2);
                                    }
                                }
                            }
                        }
                        R(sparseArray2, fragment);
                        break;
                    case 3:
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 4:
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 5:
                        R(sparseArray2, dVar.f9301d);
                        break;
                    case 6:
                        Q(sparseArray, dVar.f9301d);
                        break;
                    case 7:
                        R(sparseArray2, dVar.f9301d);
                        break;
                }
            }
        }
    }

    public final void t(e eVar, Fragment fragment, Fragment fragment2, boolean z, c.a.n0.r.a.c.a<String, View> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{eVar, fragment, fragment2, Boolean.valueOf(z), aVar}) == null) {
            SharedElementCallback sharedElementCallback = z ? fragment2.X : fragment.X;
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("BackStackEntry{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this.o >= 0) {
                sb.append(" #");
                sb.append(this.o);
            }
            if (this.m != null) {
                sb.append(" ");
                sb.append(this.m);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void v(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (!this.n) {
                if (n.x) {
                    Log.v("FragmentManager", "Commit: " + this);
                    c.a.n0.r.a.c.d dVar = new c.a.n0.r.a.c.d("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(dVar);
                    z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    v(printWriter);
                    v(dVar);
                }
                this.n = true;
                if (this.k) {
                    this.o = this.a.i(this);
                } else {
                    this.o = -1;
                }
                this.a.D(this, z);
                return this.o;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean x(int i, e eVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        c.a.n0.r.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i), eVar, Boolean.valueOf(z), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.a.n.a(i);
            if (viewGroup == null) {
                return false;
            }
            Fragment fragment = sparseArray2.get(i);
            Fragment fragment2 = sparseArray.get(i);
            Object D = D(fragment, z);
            Object G = G(fragment, fragment2, z);
            Object E = E(fragment2, z);
            ArrayList<View> arrayList = new ArrayList<>();
            Object obj4 = null;
            if (G != null) {
                c.a.n0.r.a.c.a<String, View> M = M(eVar, fragment2, z);
                if (M.isEmpty()) {
                    aVar = null;
                    obj = E;
                    obj2 = D;
                } else {
                    SharedElementCallback sharedElementCallback = z ? fragment2.X : fragment.X;
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onSharedElementStart(new ArrayList(M.keySet()), new ArrayList(M.values()), null);
                    }
                    obj = E;
                    obj2 = D;
                    K(eVar, viewGroup, G, fragment, fragment2, z, arrayList);
                    obj4 = G;
                    aVar = M;
                }
            } else {
                obj = E;
                obj2 = D;
                aVar = null;
                obj4 = G;
            }
            if (obj2 == null && obj4 == null && obj == null) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Object u = u(obj, fragment2, arrayList2, aVar, eVar.f9308d);
            ArrayList<String> arrayList3 = this.u;
            if (arrayList3 != null && aVar != null && (view = aVar.get(arrayList3.get(0))) != null) {
                if (u != null) {
                    p.t(u, view);
                }
                if (obj4 != null) {
                    p.t(obj4, view);
                }
            }
            a aVar2 = new a(this, fragment);
            ArrayList arrayList4 = new ArrayList();
            c.a.n0.r.a.c.a aVar3 = new c.a.n0.r.a.c.a();
            if (fragment == null) {
                z2 = true;
            } else if (z) {
                z2 = fragment.n();
            } else {
                z2 = fragment.k();
            }
            Object r = p.r(obj2, u, obj4, z2);
            if (r != null) {
                obj3 = r;
                p.d(obj2, obj4, viewGroup, aVar2, eVar.f9308d, eVar.f9307c, eVar.a, arrayList4, aVar, aVar3, arrayList);
                C(viewGroup, eVar, i, obj3);
                p.l(obj3, eVar.f9308d, true);
                B(eVar, i, obj3);
                p.e(viewGroup, obj3);
                p.i(viewGroup, eVar.f9308d, obj2, arrayList4, u, arrayList2, obj4, arrayList, obj3, eVar.f9306b, aVar3);
            } else {
                obj3 = r;
            }
            return obj3 != null;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i, Fragment fragment, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), fragment, str, Integer.valueOf(i2)}) == null) {
            fragment.s = this.a;
            if (str != null) {
                String str2 = fragment.y;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
                }
                fragment.y = str;
            }
            if (i != 0) {
                int i3 = fragment.w;
                if (i3 != 0 && i3 != i) {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i);
                }
                fragment.w = i;
                fragment.x = i;
            }
            d dVar = new d();
            dVar.f9300c = i2;
            dVar.f9301d = fragment;
            o(dVar);
        }
    }

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048612, this, str, fileDescriptor, printWriter, strArr) == null) {
            A(str, printWriter, true);
        }
    }
}
