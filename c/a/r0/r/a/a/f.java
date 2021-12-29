package c.a.r0.r.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.r.a.a.p;
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
/* loaded from: classes6.dex */
public final class f extends o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final n f11913e;

    /* renamed from: f  reason: collision with root package name */
    public d f11914f;

    /* renamed from: g  reason: collision with root package name */
    public d f11915g;

    /* renamed from: h  reason: collision with root package name */
    public int f11916h;

    /* renamed from: i  reason: collision with root package name */
    public int f11917i;

    /* renamed from: j  reason: collision with root package name */
    public int f11918j;

    /* renamed from: k  reason: collision with root package name */
    public int f11919k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public boolean r;
    public int s;
    public int t;
    public CharSequence u;
    public int v;
    public CharSequence w;
    public ArrayList<String> x;
    public ArrayList<String> y;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragment;
        }

        @Override // c.a.r0.r.a.a.p.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.W() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f11921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11922g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f11923h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f11924i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Fragment f11925j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Fragment f11926k;
        public final /* synthetic */ f l;

        public b(f fVar, View view, Object obj, ArrayList arrayList, e eVar, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, obj, arrayList, eVar, Boolean.valueOf(z), fragment, fragment2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            this.f11920e = view;
            this.f11921f = obj;
            this.f11922g = arrayList;
            this.f11923h = eVar;
            this.f11924i = z;
            this.f11925j = fragment;
            this.f11926k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11920e.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.f11921f;
                if (obj != null) {
                    p.s(obj, this.f11922g);
                    this.f11922g.clear();
                    c.a.r0.r.a.c.a I = this.l.I(this.f11923h, this.f11924i, this.f11925j);
                    p.v(this.f11921f, this.f11923h.f11942d, I, this.f11922g);
                    this.l.P(I, this.f11923h);
                    this.l.t(this.f11923h, this.f11925j, this.f11926k, this.f11924i, I);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f11928f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11929g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f11930h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f11931i;

        public c(f fVar, View view, e eVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, eVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11931i = fVar;
            this.f11927e = view;
            this.f11928f = eVar;
            this.f11929g = i2;
            this.f11930h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11927e.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f11931i.B(this.f11928f, this.f11929g, this.f11930h);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public d f11932b;

        /* renamed from: c  reason: collision with root package name */
        public int f11933c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f11934d;

        /* renamed from: e  reason: collision with root package name */
        public int f11935e;

        /* renamed from: f  reason: collision with root package name */
        public int f11936f;

        /* renamed from: g  reason: collision with root package name */
        public int f11937g;

        /* renamed from: h  reason: collision with root package name */
        public int f11938h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f11939i;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.r.a.c.a<String, String> a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f11940b;

        /* renamed from: c  reason: collision with root package name */
        public p.e f11941c;

        /* renamed from: d  reason: collision with root package name */
        public View f11942d;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c.a.r0.r.a.c.a<>();
            this.f11940b = new ArrayList<>();
            this.f11941c = new p.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-316402695, "Lc/a/r0/r/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-316402695, "Lc/a/r0/r/a/a/f;");
                return;
            }
        }
        z = Build.VERSION.SDK_INT >= 21;
    }

    public f(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = true;
        this.s = -1;
        this.f11913e = nVar;
    }

    public static Object D(Fragment fragment, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z2)) == null) {
            if (fragment == null) {
                return null;
            }
            return p.j(z2 ? fragment.E() : fragment.v());
        }
        return invokeLZ.objValue;
    }

    public static Object E(Fragment fragment, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fragment, z2)) == null) {
            if (fragment == null) {
                return null;
            }
            return p.j(z2 ? fragment.F() : fragment.y());
        }
        return invokeLZ.objValue;
    }

    public static Object G(Fragment fragment, Fragment fragment2, boolean z2) {
        InterceptResult invokeLLZ;
        Object G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z2)) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z2) {
                G = fragment2.H();
            } else {
                G = fragment.G();
            }
            return p.w(G);
        }
        return invokeLLZ.objValue;
    }

    public static c.a.r0.r.a.c.a<String, View> L(ArrayList<String> arrayList, ArrayList<String> arrayList2, c.a.r0.r.a.c.a<String, View> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, arrayList, arrayList2, aVar)) == null) {
            if (aVar.isEmpty()) {
                return aVar;
            }
            c.a.r0.r.a.c.a<String, View> aVar2 = new c.a.r0.r.a.c.a<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = aVar.get(arrayList.get(i2));
                if (view != null) {
                    aVar2.put(arrayList2.get(i2), view);
                }
            }
            return aVar2;
        }
        return (c.a.r0.r.a.c.a) invokeLLL.objValue;
    }

    public static void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0 || fragment.m0() || !fragment.g0() || fragment.W() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void S(c.a.r0.r.a.c.a<String, String> aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, aVar, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            if (str.equals(aVar.k(i2))) {
                aVar.j(i2, str2);
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
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            S(eVar.a, arrayList.get(i2), arrayList2.get(i2));
        }
    }

    public static Object u(Object obj, Fragment fragment, ArrayList<View> arrayList, c.a.r0.r.a.c.a<String, View> aVar, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, aVar, view)) == null) ? obj != null ? p.g(obj, fragment.W(), arrayList, aVar, view) : obj : invokeLLLLL.objValue;
    }

    public void A(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, printWriter, z2) == null) {
            if (z2) {
                printWriter.print(str);
                printWriter.print("mName=");
                printWriter.print(this.q);
                printWriter.print(" mIndex=");
                printWriter.print(this.s);
                printWriter.print(" mCommitted=");
                printWriter.println(this.r);
                if (this.m != 0) {
                    printWriter.print(str);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(this.m));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(this.n));
                }
                if (this.f11917i != 0 || this.f11918j != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f11917i));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f11918j));
                }
                if (this.f11919k != 0 || this.l != 0) {
                    printWriter.print(str);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f11919k));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(this.l));
                }
                if (this.t != 0 || this.u != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(this.t));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(this.u);
                }
                if (this.v != 0 || this.w != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(this.v));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(this.w);
                }
            }
            if (this.f11914f != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.f11914f;
                int i2 = 0;
                while (dVar != null) {
                    switch (dVar.f11933c) {
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
                            str2 = "cmd=" + dVar.f11933c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.f11934d);
                    if (z2) {
                        if (dVar.f11935e != 0 || dVar.f11936f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11935e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11936f));
                        }
                        if (dVar.f11937g != 0 || dVar.f11938h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11937g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11938h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.f11939i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i3 = 0; i3 < dVar.f11939i.size(); i3++) {
                            printWriter.print(str3);
                            if (dVar.f11939i.size() == 1) {
                                printWriter.print("Removed: ");
                            } else {
                                if (i3 == 0) {
                                    printWriter.println("Removed:");
                                }
                                printWriter.print(str3);
                                printWriter.print("  #");
                                printWriter.print(i3);
                                printWriter.print(": ");
                            }
                            printWriter.println(dVar.f11939i.get(i3));
                        }
                    }
                    dVar = dVar.a;
                    i2++;
                }
            }
        }
    }

    public final void B(e eVar, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, i2, obj) == null) || this.f11913e.f11954e == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f11913e.f11954e.size(); i3++) {
            Fragment fragment = this.f11913e.f11954e.get(i3);
            View view = fragment.M;
            if (view != null && fragment.L != null && fragment.B == i2) {
                if (fragment.D) {
                    if (!eVar.f11940b.contains(view)) {
                        p.l(obj, fragment.M, true);
                        eVar.f11940b.add(fragment.M);
                    }
                } else {
                    p.l(obj, view, false);
                    eVar.f11940b.remove(fragment.M);
                }
            }
        }
    }

    public final void C(View view, e eVar, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, view, eVar, i2, obj) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, eVar, i2, obj));
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public final c.a.r0.r.a.c.a<String, View> H(e eVar, Fragment fragment, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, eVar, fragment, z2)) == null) {
            c.a.r0.r.a.c.a<String, View> aVar = new c.a.r0.r.a.c.a<>();
            View W = fragment.W();
            if (W == null || this.x == null) {
                return aVar;
            }
            p.m(aVar, W);
            if (z2) {
                return L(this.x, this.y, aVar);
            }
            aVar.m(this.y);
            return aVar;
        }
        return (c.a.r0.r.a.c.a) invokeLLZ.objValue;
    }

    public final c.a.r0.r.a.c.a<String, View> I(e eVar, boolean z2, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z2), fragment})) == null) {
            c.a.r0.r.a.c.a<String, View> H = H(eVar, fragment, z2);
            if (z2) {
                SharedElementCallback sharedElementCallback = fragment.c0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.y, H);
                }
                N(eVar, H, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.b0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.y, H);
                }
                T(eVar, H, true);
            }
            return H;
        }
        return (c.a.r0.r.a.c.a) invokeCommon.objValue;
    }

    public e J(boolean z2, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z2), eVar, sparseArray, sparseArray2})) == null) {
            e eVar2 = null;
            if (n.x) {
                String str = "popFromBackStack: " + this;
                c.a.r0.r.a.c.d dVar = new c.a.r0.r.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                v(printWriter);
                v(dVar);
            }
            if (z) {
                if (eVar == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        eVar = p(sparseArray, sparseArray2, true);
                    }
                } else if (!z2) {
                    U(eVar, this.y, this.x);
                }
            }
            q(-1);
            int i2 = eVar != null ? 0 : this.n;
            int i3 = eVar != null ? 0 : this.m;
            for (d dVar2 = this.f11915g; dVar2 != null; dVar2 = dVar2.f11932b) {
                int i4 = eVar != null ? 0 : dVar2.f11937g;
                int i5 = eVar != null ? 0 : dVar2.f11938h;
                switch (dVar2.f11933c) {
                    case 1:
                        Fragment fragment = dVar2.f11934d;
                        fragment.K = i5;
                        this.f11913e.Z(fragment, n.d0(i3), i2);
                        break;
                    case 2:
                        Fragment fragment2 = dVar2.f11934d;
                        if (fragment2 != null) {
                            fragment2.K = i5;
                            this.f11913e.Z(fragment2, n.d0(i3), i2);
                        }
                        if (dVar2.f11939i != null) {
                            for (int i6 = 0; i6 < dVar2.f11939i.size(); i6++) {
                                Fragment fragment3 = dVar2.f11939i.get(i6);
                                fragment3.K = i4;
                                this.f11913e.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar2.f11934d;
                        fragment4.K = i4;
                        this.f11913e.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar2.f11934d;
                        fragment5.K = i4;
                        this.f11913e.k0(fragment5, n.d0(i3), i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar2.f11934d;
                        fragment6.K = i5;
                        this.f11913e.K(fragment6, n.d0(i3), i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar2.f11934d;
                        fragment7.K = i4;
                        this.f11913e.k(fragment7, n.d0(i3), i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar2.f11934d;
                        fragment8.K = i4;
                        this.f11913e.m(fragment8, n.d0(i3), i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar2.f11933c);
                }
            }
            if (z2) {
                n nVar = this.f11913e;
                nVar.R(nVar.l, n.d0(i3), i2, true);
            } else {
                eVar2 = eVar;
            }
            int i7 = this.s;
            if (i7 >= 0) {
                this.f11913e.H(i7);
                this.s = -1;
            }
            return eVar2;
        }
        return (e) invokeCommon.objValue;
    }

    public final void K(e eVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z2, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eVar, view, obj, fragment, fragment2, Boolean.valueOf(z2), arrayList}) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj, arrayList, eVar, z2, fragment, fragment2));
        }
    }

    public final c.a.r0.r.a.c.a<String, View> M(e eVar, Fragment fragment, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, fragment, z2)) == null) {
            c.a.r0.r.a.c.a<String, View> aVar = new c.a.r0.r.a.c.a<>();
            if (this.x != null) {
                p.m(aVar, fragment.W());
                if (z2) {
                    aVar.m(this.y);
                } else {
                    aVar = L(this.x, this.y, aVar);
                }
            }
            if (z2) {
                SharedElementCallback sharedElementCallback = fragment.b0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.y, aVar);
                }
                N(eVar, aVar, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.c0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.y, aVar);
                }
                T(eVar, aVar, false);
            }
            return aVar;
        }
        return (c.a.r0.r.a.c.a) invokeLLZ.objValue;
    }

    public final void N(e eVar, c.a.r0.r.a.c.a<String, View> aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, aVar, z2) == null) {
            ArrayList<String> arrayList = this.y;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = this.x.get(i2);
                View view = aVar.get(this.y.get(i2));
                if (view != null) {
                    String o = p.o(view);
                    if (z2) {
                        S(eVar.a, str, o);
                    } else {
                        S(eVar.a, o, str);
                    }
                }
            }
        }
    }

    public o O(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i2, i3, i4, i5)) == null) {
            this.f11917i = i2;
            this.f11918j = i3;
            this.f11919k = i4;
            this.l = i5;
            return this;
        }
        return (o) invokeIIII.objValue;
    }

    public final void P(c.a.r0.r.a.c.a<String, View> aVar, e eVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, aVar, eVar) == null) || this.y == null || aVar.isEmpty() || (view = aVar.get(this.y.get(0))) == null) {
            return;
        }
        eVar.f11941c.a = view;
    }

    public final void R(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void T(e eVar, c.a.r0.r.a.c.a<String, View> aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, eVar, aVar, z2) == null) {
            int size = aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                String h2 = aVar.h(i2);
                String o = p.o(aVar.k(i2));
                if (z2) {
                    S(eVar.a, h2, o);
                } else {
                    S(eVar.a, o, h2);
                }
            }
        }
    }

    @Override // c.a.r0.r.a.a.o
    public o a(int i2, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, fragment)) == null) {
            y(i2, fragment, null, 1);
            return this;
        }
        return (o) invokeIL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o b(int i2, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i2, fragment, str)) == null) {
            y(i2, fragment, str, 1);
            return this;
        }
        return (o) invokeILL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, fragment, str)) == null) {
            y(0, fragment, str, 1);
            return this;
        }
        return (o) invokeLL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (this.p) {
                this.o = true;
                this.q = str;
                return this;
            }
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? w(false) : invokeV.intValue;
    }

    @Override // c.a.r0.r.a.a.o
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? w(true) : invokeV.intValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11933c = 4;
            dVar.f11934d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o h(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11933c = 3;
            dVar.f11934d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) {
            O(i2, i3, 0, 0);
            return this;
        }
        return (o) invokeII.objValue;
    }

    @Override // c.a.r0.r.a.a.o
    public o j(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11933c = 5;
            dVar.f11934d = fragment;
            o(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    public void o(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            if (this.f11914f == null) {
                this.f11915g = dVar;
                this.f11914f = dVar;
            } else {
                d dVar2 = this.f11915g;
                dVar.f11932b = dVar2;
                dVar2.a = dVar;
                this.f11915g = dVar;
            }
            dVar.f11935e = this.f11917i;
            dVar.f11936f = this.f11918j;
            dVar.f11937g = this.f11919k;
            dVar.f11938h = this.l;
            this.f11916h++;
        }
    }

    public final e p(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048601, this, sparseArray, sparseArray2, z2)) == null) {
            e eVar = new e(this);
            eVar.f11942d = new View(this.f11913e.m.getContext());
            boolean z3 = false;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (x(sparseArray.keyAt(i2), eVar, z2, sparseArray, sparseArray2)) {
                    z3 = true;
                }
            }
            for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                int keyAt = sparseArray2.keyAt(i3);
                if (sparseArray.get(keyAt) == null && x(keyAt, eVar, z2, sparseArray, sparseArray2)) {
                    z3 = true;
                }
            }
            if (z3) {
                return eVar;
            }
            return null;
        }
        return (e) invokeLLZ.objValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i2) == null) && this.o) {
            if (n.x) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            for (d dVar = this.f11914f; dVar != null; dVar = dVar.a) {
                Fragment fragment = dVar.f11934d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (n.x) {
                        String str2 = "Bump nesting of " + dVar.f11934d + " to " + dVar.f11934d.v;
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f11939i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f11939i.get(size);
                        fragment2.v += i2;
                        if (n.x) {
                            String str3 = "Bump nesting of " + fragment2 + " to " + fragment2.v;
                        }
                    }
                }
            }
        }
    }

    public void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, sparseArray, sparseArray2) == null) && this.f11913e.n.b()) {
            for (d dVar = this.f11914f; dVar != null; dVar = dVar.a) {
                switch (dVar.f11933c) {
                    case 1:
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f11939i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                R(sparseArray2, dVar.f11939i.get(size));
                            }
                        }
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 3:
                        R(sparseArray2, dVar.f11934d);
                        break;
                    case 4:
                        R(sparseArray2, dVar.f11934d);
                        break;
                    case 5:
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 6:
                        R(sparseArray2, dVar.f11934d);
                        break;
                    case 7:
                        Q(sparseArray, dVar.f11934d);
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
                String str = "Run: " + this;
            }
            if (this.o && this.s < 0) {
                throw new IllegalStateException("addToBackStack() called after commit()");
            }
            q(1);
            if (z) {
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                s(sparseArray, sparseArray2);
                eVar = p(sparseArray, sparseArray2, false);
            } else {
                eVar = null;
            }
            int i2 = eVar != null ? 0 : this.n;
            int i3 = eVar != null ? 0 : this.m;
            for (d dVar = this.f11914f; dVar != null; dVar = dVar.a) {
                int i4 = eVar != null ? 0 : dVar.f11935e;
                int i5 = eVar != null ? 0 : dVar.f11936f;
                switch (dVar.f11933c) {
                    case 1:
                        Fragment fragment = dVar.f11934d;
                        fragment.K = i4;
                        this.f11913e.h(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.f11934d;
                        int i6 = fragment2.B;
                        if (this.f11913e.f11954e != null) {
                            for (int i7 = 0; i7 < this.f11913e.f11954e.size(); i7++) {
                                Fragment fragment3 = this.f11913e.f11954e.get(i7);
                                if (n.x) {
                                    String str2 = "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3;
                                }
                                if (fragment3.B == i6) {
                                    if (fragment3 == fragment2) {
                                        dVar.f11934d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.f11939i == null) {
                                            dVar.f11939i = new ArrayList<>();
                                        }
                                        dVar.f11939i.add(fragment3);
                                        fragment3.K = i5;
                                        if (this.o) {
                                            fragment3.v++;
                                            if (n.x) {
                                                String str3 = "Bump nesting of " + fragment3 + " to " + fragment3.v;
                                            }
                                        }
                                        this.f11913e.Z(fragment3, i3, i2);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.K = i4;
                            this.f11913e.h(fragment2, false);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar.f11934d;
                        fragment4.K = i5;
                        this.f11913e.Z(fragment4, i3, i2);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.f11934d;
                        fragment5.K = i5;
                        this.f11913e.K(fragment5, i3, i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.f11934d;
                        fragment6.K = i4;
                        this.f11913e.k0(fragment6, i3, i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.f11934d;
                        fragment7.K = i5;
                        this.f11913e.m(fragment7, i3, i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.f11934d;
                        fragment8.K = i4;
                        this.f11913e.k(fragment8, i3, i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.f11933c);
                }
            }
            n nVar = this.f11913e;
            nVar.R(nVar.l, i3, i2, true);
            if (this.o) {
                this.f11913e.g(this);
            }
        }
    }

    public final void s(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, sparseArray, sparseArray2) == null) && this.f11913e.n.b()) {
            for (d dVar = this.f11914f; dVar != null; dVar = dVar.a) {
                switch (dVar.f11933c) {
                    case 1:
                        R(sparseArray2, dVar.f11934d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f11934d;
                        if (this.f11913e.f11954e != null) {
                            for (int i2 = 0; i2 < this.f11913e.f11954e.size(); i2++) {
                                Fragment fragment2 = this.f11913e.f11954e.get(i2);
                                if (fragment == null || fragment2.B == fragment.B) {
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
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 4:
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 5:
                        R(sparseArray2, dVar.f11934d);
                        break;
                    case 6:
                        Q(sparseArray, dVar.f11934d);
                        break;
                    case 7:
                        R(sparseArray2, dVar.f11934d);
                        break;
                }
            }
        }
    }

    public final void t(e eVar, Fragment fragment, Fragment fragment2, boolean z2, c.a.r0.r.a.c.a<String, View> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{eVar, fragment, fragment2, Boolean.valueOf(z2), aVar}) == null) {
            SharedElementCallback sharedElementCallback = z2 ? fragment2.b0 : fragment.b0;
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
            if (this.s >= 0) {
                sb.append(" #");
                sb.append(this.s);
            }
            if (this.q != null) {
                sb.append(" ");
                sb.append(this.q);
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

    public int w(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z2)) == null) {
            if (!this.r) {
                if (n.x) {
                    String str = "Commit: " + this;
                    c.a.r0.r.a.c.d dVar = new c.a.r0.r.a.c.d("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(dVar);
                    z(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    v(printWriter);
                    v(dVar);
                }
                this.r = true;
                if (this.o) {
                    this.s = this.f11913e.i(this);
                } else {
                    this.s = -1;
                }
                this.f11913e.D(this, z2);
                return this.s;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean x(int i2, e eVar, boolean z2, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        c.a.r0.r.a.c.a<String, View> aVar;
        boolean z3;
        Object obj3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f11913e.n.a(i2);
            if (viewGroup == null) {
                return false;
            }
            Fragment fragment = sparseArray2.get(i2);
            Fragment fragment2 = sparseArray.get(i2);
            Object D = D(fragment, z2);
            Object G = G(fragment, fragment2, z2);
            Object E = E(fragment2, z2);
            ArrayList<View> arrayList = new ArrayList<>();
            Object obj4 = null;
            if (G != null) {
                c.a.r0.r.a.c.a<String, View> M = M(eVar, fragment2, z2);
                if (M.isEmpty()) {
                    aVar = null;
                    obj = E;
                    obj2 = D;
                } else {
                    SharedElementCallback sharedElementCallback = z2 ? fragment2.b0 : fragment.b0;
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onSharedElementStart(new ArrayList(M.keySet()), new ArrayList(M.values()), null);
                    }
                    obj = E;
                    obj2 = D;
                    K(eVar, viewGroup, G, fragment, fragment2, z2, arrayList);
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
            Object u = u(obj, fragment2, arrayList2, aVar, eVar.f11942d);
            ArrayList<String> arrayList3 = this.y;
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
            c.a.r0.r.a.c.a aVar3 = new c.a.r0.r.a.c.a();
            if (fragment == null) {
                z3 = true;
            } else if (z2) {
                z3 = fragment.r();
            } else {
                z3 = fragment.q();
            }
            Object r = p.r(obj2, u, obj4, z3);
            if (r != null) {
                obj3 = r;
                p.d(obj2, obj4, viewGroup, aVar2, eVar.f11942d, eVar.f11941c, eVar.a, arrayList4, aVar, aVar3, arrayList);
                C(viewGroup, eVar, i2, obj3);
                p.l(obj3, eVar.f11942d, true);
                B(eVar, i2, obj3);
                p.e(viewGroup, obj3);
                p.i(viewGroup, eVar.f11942d, obj2, arrayList4, u, arrayList2, obj4, arrayList, obj3, eVar.f11940b, aVar3);
            } else {
                obj3 = r;
            }
            return obj3 != null;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i2, Fragment fragment, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), fragment, str, Integer.valueOf(i3)}) == null) {
            fragment.w = this.f11913e;
            if (str != null) {
                String str2 = fragment.C;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.C + " now " + str);
                }
                fragment.C = str;
            }
            if (i2 != 0) {
                int i4 = fragment.A;
                if (i4 != 0 && i4 != i2) {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.A + " now " + i2);
                }
                fragment.A = i2;
                fragment.B = i2;
            }
            d dVar = new d();
            dVar.f11933c = i3;
            dVar.f11934d = fragment;
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
