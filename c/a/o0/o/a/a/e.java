package c.a.o0.o.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.o.a.a.o;
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
    public final m f12041e;

    /* renamed from: f  reason: collision with root package name */
    public d f12042f;

    /* renamed from: g  reason: collision with root package name */
    public d f12043g;

    /* renamed from: h  reason: collision with root package name */
    public int f12044h;

    /* renamed from: i  reason: collision with root package name */
    public int f12045i;

    /* renamed from: j  reason: collision with root package name */
    public int f12046j;
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
        public final /* synthetic */ Fragment f12047a;

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
            this.f12047a = fragment;
        }

        @Override // c.a.o0.o.a.a.o.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12047a.f0() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f12048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f12049f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12050g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0624e f12051h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f12052i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Fragment f12053j;
        public final /* synthetic */ Fragment k;
        public final /* synthetic */ e l;

        public b(e eVar, View view, Object obj, ArrayList arrayList, C0624e c0624e, boolean z, Fragment fragment, Fragment fragment2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, obj, arrayList, c0624e, Boolean.valueOf(z), fragment, fragment2};
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
            this.f12048e = view;
            this.f12049f = obj;
            this.f12050g = arrayList;
            this.f12051h = c0624e;
            this.f12052i = z;
            this.f12053j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f12048e.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.f12049f;
                if (obj != null) {
                    o.s(obj, this.f12050g);
                    this.f12050g.clear();
                    c.a.o0.o.a.c.a H = this.l.H(this.f12051h, this.f12052i, this.f12053j);
                    o.v(this.f12049f, this.f12051h.f12071d, H, this.f12050g);
                    this.l.O(H, this.f12051h);
                    this.l.s(this.f12051h, this.f12053j, this.k, this.f12052i, H);
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
        public final /* synthetic */ View f12054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C0624e f12055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f12056g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f12057h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f12058i;

        public c(e eVar, View view, C0624e c0624e, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, c0624e, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12058i = eVar;
            this.f12054e = view;
            this.f12055f = c0624e;
            this.f12056g = i2;
            this.f12057h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f12054e.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f12058i.A(this.f12055f, this.f12056g, this.f12057h);
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
        public d f12059a;

        /* renamed from: b  reason: collision with root package name */
        public d f12060b;

        /* renamed from: c  reason: collision with root package name */
        public int f12061c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f12062d;

        /* renamed from: e  reason: collision with root package name */
        public int f12063e;

        /* renamed from: f  reason: collision with root package name */
        public int f12064f;

        /* renamed from: g  reason: collision with root package name */
        public int f12065g;

        /* renamed from: h  reason: collision with root package name */
        public int f12066h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f12067i;

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

    /* renamed from: c.a.o0.o.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0624e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.o0.o.a.c.a<String, String> f12068a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f12069b;

        /* renamed from: c  reason: collision with root package name */
        public o.e f12070c;

        /* renamed from: d  reason: collision with root package name */
        public View f12071d;

        public C0624e(e eVar) {
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
            this.f12068a = new c.a.o0.o.a.c.a<>();
            this.f12069b = new ArrayList<>();
            this.f12070c = new o.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-153979654, "Lc/a/o0/o/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-153979654, "Lc/a/o0/o/a/a/e;");
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
        this.f12041e = mVar;
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

    public static c.a.o0.o.a.c.a<String, View> K(ArrayList<String> arrayList, ArrayList<String> arrayList2, c.a.o0.o.a.c.a<String, View> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, arrayList, arrayList2, aVar)) == null) {
            if (aVar.isEmpty()) {
                return aVar;
            }
            c.a.o0.o.a.c.a<String, View> aVar2 = new c.a.o0.o.a.c.a<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = aVar.get(arrayList.get(i2));
                if (view != null) {
                    aVar2.put(arrayList2.get(i2), view);
                }
            }
            return aVar2;
        }
        return (c.a.o0.o.a.c.a) invokeLLL.objValue;
    }

    public static void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0 || fragment.p0() || !fragment.n0() || fragment.f0() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void R(c.a.o0.o.a.c.a<String, String> aVar, String str, String str2) {
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

    public static void T(C0624e c0624e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, c0624e, arrayList, arrayList2) == null) || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            R(c0624e.f12068a, arrayList.get(i2), arrayList2.get(i2));
        }
    }

    public static Object t(Object obj, Fragment fragment, ArrayList<View> arrayList, c.a.o0.o.a.c.a<String, View> aVar, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, aVar, view)) == null) ? obj != null ? o.g(obj, fragment.f0(), arrayList, aVar, view) : obj : invokeLLLLL.objValue;
    }

    public final void A(C0624e c0624e, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, c0624e, i2, obj) == null) || this.f12041e.f12085e == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f12041e.f12085e.size(); i3++) {
            Fragment fragment = this.f12041e.f12085e.get(i3);
            View view = fragment.M;
            if (view != null && fragment.L != null && fragment.B == i2) {
                if (fragment.D) {
                    if (!c0624e.f12069b.contains(view)) {
                        o.l(obj, fragment.M, true);
                        c0624e.f12069b.add(fragment.M);
                    }
                } else {
                    o.l(obj, view, false);
                    c0624e.f12069b.remove(fragment.M);
                }
            }
        }
    }

    public final void B(View view, C0624e c0624e, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c0624e, i2, obj) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, c0624e, i2, obj));
        }
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public final c.a.o0.o.a.c.a<String, View> G(C0624e c0624e, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, c0624e, fragment, z)) == null) {
            c.a.o0.o.a.c.a<String, View> aVar = new c.a.o0.o.a.c.a<>();
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
        return (c.a.o0.o.a.c.a) invokeLLZ.objValue;
    }

    public final c.a.o0.o.a.c.a<String, View> H(C0624e c0624e, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{c0624e, Boolean.valueOf(z), fragment})) == null) {
            c.a.o0.o.a.c.a<String, View> G = G(c0624e, fragment, z);
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.c0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.x, G);
                }
                M(c0624e, G, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.b0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, G);
                }
                S(c0624e, G, true);
            }
            return G;
        }
        return (c.a.o0.o.a.c.a) invokeCommon.objValue;
    }

    public C0624e I(boolean z, C0624e c0624e, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), c0624e, sparseArray, sparseArray2})) == null) {
            C0624e c0624e2 = null;
            if (m.x) {
                String str = "popFromBackStack: " + this;
                c.a.o0.o.a.c.d dVar = new c.a.o0.o.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                u(printWriter);
                u(dVar);
            }
            if (y) {
                if (c0624e == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        c0624e = o(sparseArray, sparseArray2, true);
                    }
                } else if (!z) {
                    T(c0624e, this.x, this.w);
                }
            }
            p(-1);
            int i2 = c0624e != null ? 0 : this.n;
            int i3 = c0624e != null ? 0 : this.m;
            for (d dVar2 = this.f12043g; dVar2 != null; dVar2 = dVar2.f12060b) {
                int i4 = c0624e != null ? 0 : dVar2.f12065g;
                int i5 = c0624e != null ? 0 : dVar2.f12066h;
                switch (dVar2.f12061c) {
                    case 1:
                        Fragment fragment = dVar2.f12062d;
                        fragment.K = i5;
                        this.f12041e.Z(fragment, m.d0(i3), i2);
                        break;
                    case 2:
                        Fragment fragment2 = dVar2.f12062d;
                        if (fragment2 != null) {
                            fragment2.K = i5;
                            this.f12041e.Z(fragment2, m.d0(i3), i2);
                        }
                        if (dVar2.f12067i != null) {
                            for (int i6 = 0; i6 < dVar2.f12067i.size(); i6++) {
                                Fragment fragment3 = dVar2.f12067i.get(i6);
                                fragment3.K = i4;
                                this.f12041e.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar2.f12062d;
                        fragment4.K = i4;
                        this.f12041e.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar2.f12062d;
                        fragment5.K = i4;
                        this.f12041e.k0(fragment5, m.d0(i3), i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar2.f12062d;
                        fragment6.K = i5;
                        this.f12041e.K(fragment6, m.d0(i3), i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar2.f12062d;
                        fragment7.K = i4;
                        this.f12041e.k(fragment7, m.d0(i3), i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar2.f12062d;
                        fragment8.K = i4;
                        this.f12041e.m(fragment8, m.d0(i3), i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar2.f12061c);
                }
            }
            if (z) {
                m mVar = this.f12041e;
                mVar.R(mVar.l, m.d0(i3), i2, true);
            } else {
                c0624e2 = c0624e;
            }
            int i7 = this.r;
            if (i7 >= 0) {
                this.f12041e.H(i7);
                this.r = -1;
            }
            return c0624e2;
        }
        return (C0624e) invokeCommon.objValue;
    }

    public final void J(C0624e c0624e, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{c0624e, view, obj, fragment, fragment2, Boolean.valueOf(z), arrayList}) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj, arrayList, c0624e, z, fragment, fragment2));
        }
    }

    public final c.a.o0.o.a.c.a<String, View> L(C0624e c0624e, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, c0624e, fragment, z)) == null) {
            c.a.o0.o.a.c.a<String, View> aVar = new c.a.o0.o.a.c.a<>();
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
                M(c0624e, aVar, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.c0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, aVar);
                }
                S(c0624e, aVar, false);
            }
            return aVar;
        }
        return (c.a.o0.o.a.c.a) invokeLLZ.objValue;
    }

    public final void M(C0624e c0624e, c.a.o0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, c0624e, aVar, z) == null) {
            ArrayList<String> arrayList = this.x;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = this.w.get(i2);
                View view = aVar.get(this.x.get(i2));
                if (view != null) {
                    String o = o.o(view);
                    if (z) {
                        R(c0624e.f12068a, str, o);
                    } else {
                        R(c0624e.f12068a, o, str);
                    }
                }
            }
        }
    }

    public n N(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i2, i3, i4, i5)) == null) {
            this.f12045i = i2;
            this.f12046j = i3;
            this.k = i4;
            this.l = i5;
            return this;
        }
        return (n) invokeIIII.objValue;
    }

    public final void O(c.a.o0.o.a.c.a<String, View> aVar, C0624e c0624e) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, aVar, c0624e) == null) || this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        c0624e.f12070c.f12117a = view;
    }

    public final void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void S(C0624e c0624e, c.a.o0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, c0624e, aVar, z) == null) {
            int size = aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                String h2 = aVar.h(i2);
                String o = o.o(aVar.k(i2));
                if (z) {
                    R(c0624e.f12068a, h2, o);
                } else {
                    R(c0624e.f12068a, o, h2);
                }
            }
        }
    }

    @Override // c.a.o0.o.a.a.n
    public n a(int i2, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, fragment)) == null) {
            x(i2, fragment, null, 1);
            return this;
        }
        return (n) invokeIL.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n b(int i2, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i2, fragment, str)) == null) {
            x(i2, fragment, str, 1);
            return this;
        }
        return (n) invokeILL.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, fragment, str)) == null) {
            x(0, fragment, str, 1);
            return this;
        }
        return (n) invokeLL.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? v(false) : invokeV.intValue;
    }

    @Override // c.a.o0.o.a.a.n
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? v(true) : invokeV.intValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n f(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            d dVar = new d();
            dVar.f12061c = 4;
            dVar.f12062d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fragment)) == null) {
            d dVar = new d();
            dVar.f12061c = 3;
            dVar.f12062d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            N(i2, i3, 0, 0);
            return this;
        }
        return (n) invokeII.objValue;
    }

    @Override // c.a.o0.o.a.a.n
    public n i(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.f12061c = 5;
            dVar.f12062d = fragment;
            n(dVar);
            return this;
        }
        return (n) invokeL.objValue;
    }

    public void n(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            if (this.f12042f == null) {
                this.f12043g = dVar;
                this.f12042f = dVar;
            } else {
                d dVar2 = this.f12043g;
                dVar.f12060b = dVar2;
                dVar2.f12059a = dVar;
                this.f12043g = dVar;
            }
            dVar.f12063e = this.f12045i;
            dVar.f12064f = this.f12046j;
            dVar.f12065g = this.k;
            dVar.f12066h = this.l;
            this.f12044h++;
        }
    }

    public final C0624e o(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, sparseArray, sparseArray2, z)) == null) {
            C0624e c0624e = new C0624e(this);
            c0624e.f12071d = new View(this.f12041e.m.h());
            boolean z2 = false;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (w(sparseArray.keyAt(i2), c0624e, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                int keyAt = sparseArray2.keyAt(i3);
                if (sparseArray.get(keyAt) == null && w(keyAt, c0624e, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            if (z2) {
                return c0624e;
            }
            return null;
        }
        return (C0624e) invokeLLZ.objValue;
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && this.o) {
            if (m.x) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            for (d dVar = this.f12042f; dVar != null; dVar = dVar.f12059a) {
                Fragment fragment = dVar.f12062d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (m.x) {
                        String str2 = "Bump nesting of " + dVar.f12062d + " to " + dVar.f12062d.v;
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f12067i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f12067i.get(size);
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
        if ((interceptable == null || interceptable.invokeLL(1048601, this, sparseArray, sparseArray2) == null) && this.f12041e.n.b()) {
            for (d dVar = this.f12042f; dVar != null; dVar = dVar.f12059a) {
                switch (dVar.f12061c) {
                    case 1:
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f12067i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                Q(sparseArray2, dVar.f12067i.get(size));
                            }
                        }
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 3:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                    case 4:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                    case 5:
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 6:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                    case 7:
                        P(sparseArray, dVar.f12062d);
                        break;
                }
            }
        }
    }

    public final void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, sparseArray, sparseArray2) == null) && this.f12041e.n.b()) {
            for (d dVar = this.f12042f; dVar != null; dVar = dVar.f12059a) {
                switch (dVar.f12061c) {
                    case 1:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f12062d;
                        if (this.f12041e.f12085e != null) {
                            for (int i2 = 0; i2 < this.f12041e.f12085e.size(); i2++) {
                                Fragment fragment2 = this.f12041e.f12085e.get(i2);
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
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 4:
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 5:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                    case 6:
                        P(sparseArray, dVar.f12062d);
                        break;
                    case 7:
                        Q(sparseArray2, dVar.f12062d);
                        break;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C0624e c0624e;
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
                c0624e = o(sparseArray, sparseArray2, false);
            } else {
                c0624e = null;
            }
            int i2 = c0624e != null ? 0 : this.n;
            int i3 = c0624e != null ? 0 : this.m;
            for (d dVar = this.f12042f; dVar != null; dVar = dVar.f12059a) {
                int i4 = c0624e != null ? 0 : dVar.f12063e;
                int i5 = c0624e != null ? 0 : dVar.f12064f;
                switch (dVar.f12061c) {
                    case 1:
                        Fragment fragment = dVar.f12062d;
                        fragment.K = i4;
                        this.f12041e.h(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.f12062d;
                        int i6 = fragment2.B;
                        if (this.f12041e.f12085e != null) {
                            for (int i7 = 0; i7 < this.f12041e.f12085e.size(); i7++) {
                                Fragment fragment3 = this.f12041e.f12085e.get(i7);
                                if (m.x) {
                                    String str2 = "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3;
                                }
                                if (fragment3.B == i6) {
                                    if (fragment3 == fragment2) {
                                        dVar.f12062d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.f12067i == null) {
                                            dVar.f12067i = new ArrayList<>();
                                        }
                                        dVar.f12067i.add(fragment3);
                                        fragment3.K = i5;
                                        if (this.o) {
                                            fragment3.v++;
                                            if (m.x) {
                                                String str3 = "Bump nesting of " + fragment3 + " to " + fragment3.v;
                                            }
                                        }
                                        this.f12041e.Z(fragment3, i3, i2);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.K = i4;
                            this.f12041e.h(fragment2, false);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar.f12062d;
                        fragment4.K = i5;
                        this.f12041e.Z(fragment4, i3, i2);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.f12062d;
                        fragment5.K = i5;
                        this.f12041e.K(fragment5, i3, i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.f12062d;
                        fragment6.K = i4;
                        this.f12041e.k0(fragment6, i3, i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.f12062d;
                        fragment7.K = i5;
                        this.f12041e.m(fragment7, i3, i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.f12062d;
                        fragment8.K = i4;
                        this.f12041e.k(fragment8, i3, i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.f12061c);
                }
            }
            m mVar = this.f12041e;
            mVar.R(mVar.l, i3, i2, true);
            if (this.o) {
                this.f12041e.g(this);
            }
        }
    }

    public final void s(C0624e c0624e, Fragment fragment, Fragment fragment2, boolean z, c.a.o0.o.a.c.a<String, View> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{c0624e, fragment, fragment2, Boolean.valueOf(z), aVar}) == null) {
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
                    c.a.o0.o.a.c.d dVar = new c.a.o0.o.a.c.d("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(dVar);
                    y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    u(printWriter);
                    u(dVar);
                }
                this.q = true;
                if (this.o) {
                    this.r = this.f12041e.i(this);
                } else {
                    this.r = -1;
                }
                this.f12041e.D(this, z);
                return this.r;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean w(int i2, C0624e c0624e, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        c.a.o0.o.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), c0624e, Boolean.valueOf(z), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f12041e.n.a(i2);
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
                c.a.o0.o.a.c.a<String, View> L = L(c0624e, fragment2, z);
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
                    J(c0624e, viewGroup, F, fragment, fragment2, z, arrayList);
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
            Object t = t(obj, fragment2, arrayList2, aVar, c0624e.f12071d);
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
            c.a.o0.o.a.c.a aVar3 = new c.a.o0.o.a.c.a();
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
                o.d(obj2, obj4, viewGroup, aVar2, c0624e.f12071d, c0624e.f12070c, c0624e.f12068a, arrayList4, aVar, aVar3, arrayList);
                B(viewGroup, c0624e, i2, obj3);
                o.l(obj3, c0624e.f12071d, true);
                A(c0624e, i2, obj3);
                o.e(viewGroup, obj3);
                o.i(viewGroup, c0624e.f12071d, obj2, arrayList4, t, arrayList2, obj4, arrayList, obj3, c0624e.f12069b, aVar3);
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
            fragment.w = this.f12041e;
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
            dVar.f12061c = i3;
            dVar.f12062d = fragment;
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
                if (this.f12045i != 0 || this.f12046j != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f12045i));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.f12046j));
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
            if (this.f12042f != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.f12042f;
                int i2 = 0;
                while (dVar != null) {
                    switch (dVar.f12061c) {
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
                            str2 = "cmd=" + dVar.f12061c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.f12062d);
                    if (z) {
                        if (dVar.f12063e != 0 || dVar.f12064f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f12063e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f12064f));
                        }
                        if (dVar.f12065g != 0 || dVar.f12066h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f12065g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f12066h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.f12067i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i3 = 0; i3 < dVar.f12067i.size(); i3++) {
                            printWriter.print(str3);
                            if (dVar.f12067i.size() == 1) {
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
                            printWriter.println(dVar.f12067i.get(i3));
                        }
                    }
                    dVar = dVar.f12059a;
                    i2++;
                }
            }
        }
    }
}
