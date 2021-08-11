package c.a.n0.o.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.o.a.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes3.dex */
public final class e extends n implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final m f11795e;

    /* renamed from: f  reason: collision with root package name */
    public d f11796f;

    /* renamed from: g  reason: collision with root package name */
    public d f11797g;

    /* renamed from: h  reason: collision with root package name */
    public int f11798h;

    /* renamed from: i  reason: collision with root package name */
    public int f11799i;

    /* renamed from: j  reason: collision with root package name */
    public int f11800j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public CharSequence t;
    public int u;
    public CharSequence v;
    public ArrayList<String> w;
    public ArrayList<String> x;

    /* loaded from: classes3.dex */
    public class a implements o.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f11801a;

        public a(e eVar, Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11801a = fragment;
        }

        @Override // c.a.n0.o.a.a.o.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11801a.f0() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11802e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f11803f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11804g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0616e f11805h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f11806i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Fragment f11807j;
        public final /* synthetic */ Fragment k;
        public final /* synthetic */ e l;

        public b(e eVar, View view, Object obj, ArrayList arrayList, C0616e c0616e, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, obj, arrayList, c0616e, Boolean.valueOf(z), fragment, fragment2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f11802e = view;
            this.f11803f = obj;
            this.f11804g = arrayList;
            this.f11805h = c0616e;
            this.f11806i = z;
            this.f11807j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11802e.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.f11803f;
                if (obj != null) {
                    o.s(obj, this.f11804g);
                    this.f11804g.clear();
                    c.a.n0.o.a.c.a H = this.l.H(this.f11805h, this.f11806i, this.f11807j);
                    o.v(this.f11803f, this.f11805h.f11825d, H, this.f11804g);
                    this.l.O(H, this.f11805h);
                    this.l.s(this.f11805h, this.f11807j, this.k, this.f11806i, H);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C0616e f11809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11810g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f11811h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f11812i;

        public c(e eVar, View view, C0616e c0616e, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, c0616e, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11812i = eVar;
            this.f11808e = view;
            this.f11809f = c0616e;
            this.f11810g = i2;
            this.f11811h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11808e.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f11812i.A(this.f11809f, this.f11810g, this.f11811h);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f11813a;

        /* renamed from: b  reason: collision with root package name */
        public d f11814b;

        /* renamed from: c  reason: collision with root package name */
        public int f11815c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f11816d;

        /* renamed from: e  reason: collision with root package name */
        public int f11817e;

        /* renamed from: f  reason: collision with root package name */
        public int f11818f;

        /* renamed from: g  reason: collision with root package name */
        public int f11819g;

        /* renamed from: h  reason: collision with root package name */
        public int f11820h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f11821i;

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

    /* renamed from: c.a.n0.o.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0616e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.n0.o.a.c.a<String, String> f11822a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f11823b;

        /* renamed from: c  reason: collision with root package name */
        public o.e f11824c;

        /* renamed from: d  reason: collision with root package name */
        public View f11825d;

        public C0616e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11822a = new c.a.n0.o.a.c.a<>();
            this.f11823b = new ArrayList<>();
            this.f11824c = new o.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1642971705, "Lc/a/n0/o/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1642971705, "Lc/a/n0/o/a/a/e;");
                return;
            }
        }
        y = Build.VERSION.SDK_INT >= 21;
    }

    public e(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = -1;
        this.f11795e = mVar;
    }

    public static Object C(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return o.j(z ? fragment.y() : fragment.r());
        }
        return invokeLZ.objValue;
    }

    public static Object D(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return o.j(z ? fragment.O() : fragment.t());
        }
        return invokeLZ.objValue;
    }

    public static Object F(Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeLLZ;
        Object Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z)) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z) {
                Q = fragment2.S();
            } else {
                Q = fragment.Q();
            }
            return o.w(Q);
        }
        return invokeLLZ.objValue;
    }

    public static c.a.n0.o.a.c.a<String, View> K(ArrayList<String> arrayList, ArrayList<String> arrayList2, c.a.n0.o.a.c.a<String, View> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, arrayList, arrayList2, aVar)) == null) {
            if (aVar.isEmpty()) {
                return aVar;
            }
            c.a.n0.o.a.c.a<String, View> aVar2 = new c.a.n0.o.a.c.a<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = aVar.get(arrayList.get(i2));
                if (view != null) {
                    aVar2.put(arrayList2.get(i2), view);
                }
            }
            return aVar2;
        }
        return (c.a.n0.o.a.c.a) invokeLLL.objValue;
    }

    public static void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0 || fragment.p0() || !fragment.n0() || fragment.f0() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void R(c.a.n0.o.a.c.a<String, String> aVar, String str, String str2) {
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

    public static void T(C0616e c0616e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, c0616e, arrayList, arrayList2) == null) || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            R(c0616e.f11822a, arrayList.get(i2), arrayList2.get(i2));
        }
    }

    public static Object t(Object obj, Fragment fragment, ArrayList<View> arrayList, c.a.n0.o.a.c.a<String, View> aVar, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, aVar, view)) == null) ? obj != null ? o.g(obj, fragment.f0(), arrayList, aVar, view) : obj : invokeLLLLL.objValue;
    }

    public final void A(C0616e c0616e, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, c0616e, i2, obj) == null) || this.f11795e.f11839e == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f11795e.f11839e.size(); i3++) {
            Fragment fragment = this.f11795e.f11839e.get(i3);
            View view = fragment.M;
            if (view != null && fragment.L != null && fragment.B == i2) {
                if (fragment.D) {
                    if (!c0616e.f11823b.contains(view)) {
                        o.l(obj, fragment.M, true);
                        c0616e.f11823b.add(fragment.M);
                    }
                } else {
                    o.l(obj, view, false);
                    c0616e.f11823b.remove(fragment.M);
                }
            }
        }
    }

    public final void B(View view, C0616e c0616e, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c0616e, i2, obj) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, c0616e, i2, obj));
        }
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public final c.a.n0.o.a.c.a<String, View> G(C0616e c0616e, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, c0616e, fragment, z)) == null) {
            c.a.n0.o.a.c.a<String, View> aVar = new c.a.n0.o.a.c.a<>();
            View f0 = fragment.f0();
            if (f0 == null || this.w == null) {
                return aVar;
            }
            o.m(aVar, f0);
            if (z) {
                return K(this.w, this.x, aVar);
            }
            aVar.m(this.x);
            return aVar;
        }
        return (c.a.n0.o.a.c.a) invokeLLZ.objValue;
    }

    public final c.a.n0.o.a.c.a<String, View> H(C0616e c0616e, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{c0616e, Boolean.valueOf(z), fragment})) == null) {
            c.a.n0.o.a.c.a<String, View> G = G(c0616e, fragment, z);
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.c0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.x, G);
                }
                M(c0616e, G, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.b0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, G);
                }
                S(c0616e, G, true);
            }
            return G;
        }
        return (c.a.n0.o.a.c.a) invokeCommon.objValue;
    }

    public C0616e I(boolean z, C0616e c0616e, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), c0616e, sparseArray, sparseArray2})) == null) {
            C0616e c0616e2 = null;
            if (m.x) {
                String str = "popFromBackStack: " + this;
                c.a.n0.o.a.c.d dVar = new c.a.n0.o.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                u(printWriter);
                u(dVar);
            }
            if (y) {
                if (c0616e == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        c0616e = o(sparseArray, sparseArray2, true);
                    }
                } else if (!z) {
                    T(c0616e, this.x, this.w);
                }
            }
            p(-1);
            int i2 = c0616e != null ? 0 : this.n;
            int i3 = c0616e != null ? 0 : this.m;
            for (d dVar2 = this.f11797g; dVar2 != null; dVar2 = dVar2.f11814b) {
                int i4 = c0616e != null ? 0 : dVar2.f11819g;
                int i5 = c0616e != null ? 0 : dVar2.f11820h;
                switch (dVar2.f11815c) {
                    case 1:
                        Fragment fragment = dVar2.f11816d;
                        fragment.K = i5;
                        this.f11795e.Z(fragment, m.d0(i3), i2);
                        break;
                    case 2:
                        Fragment fragment2 = dVar2.f11816d;
                        if (fragment2 != null) {
                            fragment2.K = i5;
                            this.f11795e.Z(fragment2, m.d0(i3), i2);
                        }
                        if (dVar2.f11821i != null) {
                            for (int i6 = 0; i6 < dVar2.f11821i.size(); i6++) {
                                Fragment fragment3 = dVar2.f11821i.get(i6);
                                fragment3.K = i4;
                                this.f11795e.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar2.f11816d;
                        fragment4.K = i4;
                        this.f11795e.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar2.f11816d;
                        fragment5.K = i4;
                        this.f11795e.k0(fragment5, m.d0(i3), i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar2.f11816d;
                        fragment6.K = i5;
                        this.f11795e.K(fragment6, m.d0(i3), i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar2.f11816d;
                        fragment7.K = i4;
                        this.f11795e.k(fragment7, m.d0(i3), i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar2.f11816d;
                        fragment8.K = i4;
                        this.f11795e.m(fragment8, m.d0(i3), i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar2.f11815c);
                }
            }
            if (z) {
                m mVar = this.f11795e;
                mVar.R(mVar.l, m.d0(i3), i2, true);
            } else {
                c0616e2 = c0616e;
            }
            int i7 = this.r;
            if (i7 >= 0) {
                this.f11795e.H(i7);
                this.r = -1;
            }
            return c0616e2;
        }
        return (C0616e) invokeCommon.objValue;
    }

    public final void J(C0616e c0616e, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{c0616e, view, obj, fragment, fragment2, Boolean.valueOf(z), arrayList}) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj, arrayList, c0616e, z, fragment, fragment2));
        }
    }

    public final c.a.n0.o.a.c.a<String, View> L(C0616e c0616e, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, c0616e, fragment, z)) == null) {
            c.a.n0.o.a.c.a<String, View> aVar = new c.a.n0.o.a.c.a<>();
            if (this.w != null) {
                o.m(aVar, fragment.f0());
                if (z) {
                    aVar.m(this.x);
                } else {
                    aVar = K(this.w, this.x, aVar);
                }
            }
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.b0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.x, aVar);
                }
                M(c0616e, aVar, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.c0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, aVar);
                }
                S(c0616e, aVar, false);
            }
            return aVar;
        }
        return (c.a.n0.o.a.c.a) invokeLLZ.objValue;
    }

    public final void M(C0616e c0616e, c.a.n0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, c0616e, aVar, z) == null) {
            ArrayList<String> arrayList = this.x;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = this.w.get(i2);
                View view = aVar.get(this.x.get(i2));
                if (view != null) {
                    String o = o.o(view);
                    if (z) {
                        R(c0616e.f11822a, str, o);
                    } else {
                        R(c0616e.f11822a, o, str);
                    }
                }
            }
        }
    }

    public n N(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i2, i3, i4, i5)) == null) {
            this.f11799i = i2;
            this.f11800j = i3;
            this.k = i4;
            this.l = i5;
            return this;
        }
        return (n) invokeIIII.objValue;
    }

    public final void O(c.a.n0.o.a.c.a<String, View> aVar, C0616e c0616e) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, aVar, c0616e) == null) || this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        c0616e.f11824c.f11871a = view;
    }

    public final void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void S(C0616e c0616e, c.a.n0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, c0616e, aVar, z) == null) {
            int size = aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                String h2 = aVar.h(i2);
                String o = o.o(aVar.k(i2));
                if (z) {
                    R(c0616e.f11822a, h2, o);
                } else {
                    R(c0616e.f11822a, o, h2);
                }
            }
        }
    }

    @Override // c.a.n0.o.a.a.n
    public n a(int i2, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, fragment)) == null) {
            x(i2, fragment, null, 1);
            return this;
        }
        return (n) invokeIL.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n b(int i2, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i2, fragment, str)) == null) {
            x(i2, fragment, str, 1);
            return this;
        }
        return (n) invokeILL.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, fragment, str)) == null) {
            x(0, fragment, str, 1);
            return this;
        }
        return (n) invokeLL.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? v(false) : invokeV.intValue;
    }

    @Override // c.a.n0.o.a.a.n
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? v(true) : invokeV.intValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n f(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11815c = 4;
            dVar.f11816d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11815c = 3;
            dVar.f11816d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            N(i2, i3, 0, 0);
            return this;
        }
        return (n) invokeII.objValue;
    }

    @Override // c.a.n0.o.a.a.n
    public n i(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11815c = 5;
            dVar.f11816d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    public void n(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            if (this.f11796f == null) {
                this.f11797g = dVar;
                this.f11796f = dVar;
            } else {
                d dVar2 = this.f11797g;
                dVar.f11814b = dVar2;
                dVar2.f11813a = dVar;
                this.f11797g = dVar;
            }
            dVar.f11817e = this.f11799i;
            dVar.f11818f = this.f11800j;
            dVar.f11819g = this.k;
            dVar.f11820h = this.l;
            this.f11798h++;
        }
    }

    public final C0616e o(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, sparseArray, sparseArray2, z)) == null) {
            C0616e c0616e = new C0616e(this);
            c0616e.f11825d = new View(this.f11795e.m.h());
            boolean z2 = false;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (w(sparseArray.keyAt(i2), c0616e, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                int keyAt = sparseArray2.keyAt(i3);
                if (sparseArray.get(keyAt) == null && w(keyAt, c0616e, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            if (z2) {
                return c0616e;
            }
            return null;
        }
        return (C0616e) invokeLLZ.objValue;
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && this.o) {
            if (m.x) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            for (d dVar = this.f11796f; dVar != null; dVar = dVar.f11813a) {
                Fragment fragment = dVar.f11816d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (m.x) {
                        String str2 = "Bump nesting of " + dVar.f11816d + " to " + dVar.f11816d.v;
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f11821i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f11821i.get(size);
                        fragment2.v += i2;
                        if (m.x) {
                            String str3 = "Bump nesting of " + fragment2 + " to " + fragment2.v;
                        }
                    }
                }
            }
        }
    }

    public void q(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, sparseArray, sparseArray2) == null) && this.f11795e.n.b()) {
            for (d dVar = this.f11796f; dVar != null; dVar = dVar.f11813a) {
                switch (dVar.f11815c) {
                    case 1:
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f11821i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                Q(sparseArray2, dVar.f11821i.get(size));
                            }
                        }
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 3:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                    case 4:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                    case 5:
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 6:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                    case 7:
                        P(sparseArray, dVar.f11816d);
                        break;
                }
            }
        }
    }

    public final void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, sparseArray, sparseArray2) == null) && this.f11795e.n.b()) {
            for (d dVar = this.f11796f; dVar != null; dVar = dVar.f11813a) {
                switch (dVar.f11815c) {
                    case 1:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f11816d;
                        if (this.f11795e.f11839e != null) {
                            for (int i2 = 0; i2 < this.f11795e.f11839e.size(); i2++) {
                                Fragment fragment2 = this.f11795e.f11839e.get(i2);
                                if (fragment == null || fragment2.B == fragment.B) {
                                    if (fragment2 == fragment) {
                                        fragment = null;
                                    } else {
                                        P(sparseArray, fragment2);
                                    }
                                }
                            }
                        }
                        Q(sparseArray2, fragment);
                        break;
                    case 3:
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 4:
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 5:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                    case 6:
                        P(sparseArray, dVar.f11816d);
                        break;
                    case 7:
                        Q(sparseArray2, dVar.f11816d);
                        break;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C0616e c0616e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (m.x) {
                String str = "Run: " + this;
            }
            if (this.o && this.r < 0) {
                throw new IllegalStateException("addToBackStack() called after commit()");
            }
            p(1);
            if (y) {
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                r(sparseArray, sparseArray2);
                c0616e = o(sparseArray, sparseArray2, false);
            } else {
                c0616e = null;
            }
            int i2 = c0616e != null ? 0 : this.n;
            int i3 = c0616e != null ? 0 : this.m;
            for (d dVar = this.f11796f; dVar != null; dVar = dVar.f11813a) {
                int i4 = c0616e != null ? 0 : dVar.f11817e;
                int i5 = c0616e != null ? 0 : dVar.f11818f;
                switch (dVar.f11815c) {
                    case 1:
                        Fragment fragment = dVar.f11816d;
                        fragment.K = i4;
                        this.f11795e.h(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.f11816d;
                        int i6 = fragment2.B;
                        if (this.f11795e.f11839e != null) {
                            for (int i7 = 0; i7 < this.f11795e.f11839e.size(); i7++) {
                                Fragment fragment3 = this.f11795e.f11839e.get(i7);
                                if (m.x) {
                                    String str2 = "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3;
                                }
                                if (fragment3.B == i6) {
                                    if (fragment3 == fragment2) {
                                        dVar.f11816d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.f11821i == null) {
                                            dVar.f11821i = new ArrayList<>();
                                        }
                                        dVar.f11821i.add(fragment3);
                                        fragment3.K = i5;
                                        if (this.o) {
                                            fragment3.v++;
                                            if (m.x) {
                                                String str3 = "Bump nesting of " + fragment3 + " to " + fragment3.v;
                                            }
                                        }
                                        this.f11795e.Z(fragment3, i3, i2);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.K = i4;
                            this.f11795e.h(fragment2, false);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar.f11816d;
                        fragment4.K = i5;
                        this.f11795e.Z(fragment4, i3, i2);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.f11816d;
                        fragment5.K = i5;
                        this.f11795e.K(fragment5, i3, i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.f11816d;
                        fragment6.K = i4;
                        this.f11795e.k0(fragment6, i3, i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.f11816d;
                        fragment7.K = i5;
                        this.f11795e.m(fragment7, i3, i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.f11816d;
                        fragment8.K = i4;
                        this.f11795e.k(fragment8, i3, i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.f11815c);
                }
            }
            m mVar = this.f11795e;
            mVar.R(mVar.l, i3, i2, true);
            if (this.o) {
                this.f11795e.g(this);
            }
        }
    }

    public final void s(C0616e c0616e, Fragment fragment, Fragment fragment2, boolean z, c.a.n0.o.a.c.a<String, View> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{c0616e, fragment, fragment2, Boolean.valueOf(z), aVar}) == null) {
            SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("BackStackEntry{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this.r >= 0) {
                sb.append(" #");
                sb.append(this.r);
            }
            if (this.p != null) {
                sb.append(" ");
                sb.append(this.p);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void u(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
            if (!this.q) {
                if (m.x) {
                    String str = "Commit: " + this;
                    c.a.n0.o.a.c.d dVar = new c.a.n0.o.a.c.d("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(dVar);
                    y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    u(printWriter);
                    u(dVar);
                }
                this.q = true;
                if (this.o) {
                    this.r = this.f11795e.i(this);
                } else {
                    this.r = -1;
                }
                this.f11795e.D(this, z);
                return this.r;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean w(int i2, C0616e c0616e, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        c.a.n0.o.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), c0616e, Boolean.valueOf(z), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f11795e.n.a(i2);
            if (viewGroup == null) {
                return false;
            }
            Fragment fragment = sparseArray2.get(i2);
            Fragment fragment2 = sparseArray.get(i2);
            Object C = C(fragment, z);
            Object F = F(fragment, fragment2, z);
            Object D = D(fragment2, z);
            ArrayList<View> arrayList = new ArrayList<>();
            Object obj4 = null;
            if (F != null) {
                c.a.n0.o.a.c.a<String, View> L = L(c0616e, fragment2, z);
                if (L.isEmpty()) {
                    aVar = null;
                    obj = D;
                    obj2 = C;
                } else {
                    SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onSharedElementStart(new ArrayList(L.keySet()), new ArrayList(L.values()), null);
                    }
                    obj = D;
                    obj2 = C;
                    J(c0616e, viewGroup, F, fragment, fragment2, z, arrayList);
                    obj4 = F;
                    aVar = L;
                }
            } else {
                obj = D;
                obj2 = C;
                aVar = null;
                obj4 = F;
            }
            if (obj2 == null && obj4 == null && obj == null) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Object t = t(obj, fragment2, arrayList2, aVar, c0616e.f11825d);
            ArrayList<String> arrayList3 = this.x;
            if (arrayList3 != null && aVar != null && (view = aVar.get(arrayList3.get(0))) != null) {
                if (t != null) {
                    o.t(t, view);
                }
                if (obj4 != null) {
                    o.t(obj4, view);
                }
            }
            a aVar2 = new a(this, fragment);
            ArrayList arrayList4 = new ArrayList();
            c.a.n0.o.a.c.a aVar3 = new c.a.n0.o.a.c.a();
            if (fragment == null) {
                z2 = true;
            } else if (z) {
                z2 = fragment.m();
            } else {
                z2 = fragment.j();
            }
            Object r = o.r(obj2, t, obj4, z2);
            if (r != null) {
                obj3 = r;
                o.d(obj2, obj4, viewGroup, aVar2, c0616e.f11825d, c0616e.f11824c, c0616e.f11822a, arrayList4, aVar, aVar3, arrayList);
                B(viewGroup, c0616e, i2, obj3);
                o.l(obj3, c0616e.f11825d, true);
                A(c0616e, i2, obj3);
                o.e(viewGroup, obj3);
                o.i(viewGroup, c0616e.f11825d, obj2, arrayList4, t, arrayList2, obj4, arrayList, obj3, c0616e.f11823b, aVar3);
            } else {
                obj3 = r;
            }
            return obj3 != null;
        }
        return invokeCommon.booleanValue;
    }

    public final void x(int i2, Fragment fragment, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), fragment, str, Integer.valueOf(i3)}) == null) {
            fragment.w = this.f11795e;
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
            dVar.f11815c = i3;
            dVar.f11816d = fragment;
            n(dVar);
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, str, fileDescriptor, printWriter, strArr) == null) {
            z(str, printWriter, true);
        }
    }

    public void z(String str, PrintWriter printWriter, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048611, this, str, printWriter, z) == null) {
            if (z) {
                printWriter.print(str);
                printWriter.print("mName=");
                printWriter.print(this.p);
                printWriter.print(" mIndex=");
                printWriter.print(this.r);
                printWriter.print(" mCommitted=");
                printWriter.println(this.q);
                if (this.m != 0) {
                    printWriter.print(str);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(this.m));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(this.n));
                }
                if (this.f11799i != 0 || this.f11800j != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f11799i));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f11800j));
                }
                if (this.k != 0 || this.l != 0) {
                    printWriter.print(str);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.k));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(this.l));
                }
                if (this.s != 0 || this.t != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(this.s));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(this.t);
                }
                if (this.u != 0 || this.v != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(this.u));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(this.v);
                }
            }
            if (this.f11796f != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.f11796f;
                int i2 = 0;
                while (dVar != null) {
                    switch (dVar.f11815c) {
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
                            str2 = "cmd=" + dVar.f11815c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.f11816d);
                    if (z) {
                        if (dVar.f11817e != 0 || dVar.f11818f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11817e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11818f));
                        }
                        if (dVar.f11819g != 0 || dVar.f11820h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11819g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11820h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.f11821i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i3 = 0; i3 < dVar.f11821i.size(); i3++) {
                            printWriter.print(str3);
                            if (dVar.f11821i.size() == 1) {
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
                            printWriter.println(dVar.f11821i.get(i3));
                        }
                    }
                    dVar = dVar.f11813a;
                    i2++;
                }
            }
        }
    }
}
