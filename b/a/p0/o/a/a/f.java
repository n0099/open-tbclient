package b.a.p0.o.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.o.a.a.p;
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
/* loaded from: classes4.dex */
public final class f extends o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final n f11257e;

    /* renamed from: f  reason: collision with root package name */
    public d f11258f;

    /* renamed from: g  reason: collision with root package name */
    public d f11259g;

    /* renamed from: h  reason: collision with root package name */
    public int f11260h;

    /* renamed from: i  reason: collision with root package name */
    public int f11261i;
    public int j;
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

    /* loaded from: classes4.dex */
    public class a implements p.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f11262a;

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
            this.f11262a = fragment;
        }

        @Override // b.a.p0.o.a.a.p.f
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11262a.c0() : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f11264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11265g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f11266h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f11267i;
        public final /* synthetic */ Fragment j;
        public final /* synthetic */ Fragment k;
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
            this.f11263e = view;
            this.f11264f = obj;
            this.f11265g = arrayList;
            this.f11266h = eVar;
            this.f11267i = z;
            this.j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11263e.getViewTreeObserver().removeOnPreDrawListener(this);
                Object obj = this.f11264f;
                if (obj != null) {
                    p.s(obj, this.f11265g);
                    this.f11265g.clear();
                    b.a.p0.o.a.c.a H = this.l.H(this.f11266h, this.f11267i, this.j);
                    p.v(this.f11264f, this.f11266h.f11285d, H, this.f11265g);
                    this.l.O(H, this.f11266h);
                    this.l.s(this.f11266h, this.j, this.k, this.f11267i, H);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f11269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11270g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f11271h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f11272i;

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
            this.f11272i = fVar;
            this.f11268e = view;
            this.f11269f = eVar;
            this.f11270g = i2;
            this.f11271h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11268e.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f11272i.A(this.f11269f, this.f11270g, this.f11271h);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f11273a;

        /* renamed from: b  reason: collision with root package name */
        public d f11274b;

        /* renamed from: c  reason: collision with root package name */
        public int f11275c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f11276d;

        /* renamed from: e  reason: collision with root package name */
        public int f11277e;

        /* renamed from: f  reason: collision with root package name */
        public int f11278f;

        /* renamed from: g  reason: collision with root package name */
        public int f11279g;

        /* renamed from: h  reason: collision with root package name */
        public int f11280h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f11281i;

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

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.o.a.c.a<String, String> f11282a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f11283b;

        /* renamed from: c  reason: collision with root package name */
        public p.e f11284c;

        /* renamed from: d  reason: collision with root package name */
        public View f11285d;

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
            this.f11282a = new b.a.p0.o.a.c.a<>();
            this.f11283b = new ArrayList<>();
            this.f11284c = new p.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(836484505, "Lb/a/p0/o/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(836484505, "Lb/a/p0/o/a/a/f;");
                return;
            }
        }
        y = Build.VERSION.SDK_INT >= 21;
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
        this.r = -1;
        this.f11257e = nVar;
    }

    public static Object C(Fragment fragment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            return p.j(z ? fragment.u() : fragment.p());
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
            return p.j(z ? fragment.x() : fragment.q());
        }
        return invokeLZ.objValue;
    }

    public static Object F(Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeLLZ;
        Object y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, fragment2, z)) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z) {
                y2 = fragment2.B();
            } else {
                y2 = fragment.y();
            }
            return p.w(y2);
        }
        return invokeLLZ.objValue;
    }

    public static b.a.p0.o.a.c.a<String, View> K(ArrayList<String> arrayList, ArrayList<String> arrayList2, b.a.p0.o.a.c.a<String, View> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, arrayList, arrayList2, aVar)) == null) {
            if (aVar.isEmpty()) {
                return aVar;
            }
            b.a.p0.o.a.c.a<String, View> aVar2 = new b.a.p0.o.a.c.a<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = aVar.get(arrayList.get(i2));
                if (view != null) {
                    aVar2.put(arrayList2.get(i2), view);
                }
            }
            return aVar2;
        }
        return (b.a.p0.o.a.c.a) invokeLLL.objValue;
    }

    public static void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0 || fragment.m0() || !fragment.k0() || fragment.c0() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void R(b.a.p0.o.a.c.a<String, String> aVar, String str, String str2) {
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

    public static void T(e eVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, eVar, arrayList, arrayList2) == null) || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            R(eVar.f11282a, arrayList.get(i2), arrayList2.get(i2));
        }
    }

    public static Object t(Object obj, Fragment fragment, ArrayList<View> arrayList, b.a.p0.o.a.c.a<String, View> aVar, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, obj, fragment, arrayList, aVar, view)) == null) ? obj != null ? p.g(obj, fragment.c0(), arrayList, aVar, view) : obj : invokeLLLLL.objValue;
    }

    public final void A(e eVar, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, eVar, i2, obj) == null) || this.f11257e.f11300e == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f11257e.f11300e.size(); i3++) {
            Fragment fragment = this.f11257e.f11300e.get(i3);
            View view = fragment.M;
            if (view != null && fragment.L != null && fragment.B == i2) {
                if (fragment.D) {
                    if (!eVar.f11283b.contains(view)) {
                        p.l(obj, fragment.M, true);
                        eVar.f11283b.add(fragment.M);
                    }
                } else {
                    p.l(obj, view, false);
                    eVar.f11283b.remove(fragment.M);
                }
            }
        }
    }

    public final void B(View view, e eVar, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar, i2, obj) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, eVar, i2, obj));
        }
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public final b.a.p0.o.a.c.a<String, View> G(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, eVar, fragment, z)) == null) {
            b.a.p0.o.a.c.a<String, View> aVar = new b.a.p0.o.a.c.a<>();
            View c0 = fragment.c0();
            if (c0 == null || this.w == null) {
                return aVar;
            }
            p.m(aVar, c0);
            if (z) {
                return K(this.w, this.x, aVar);
            }
            aVar.m(this.x);
            return aVar;
        }
        return (b.a.p0.o.a.c.a) invokeLLZ.objValue;
    }

    public final b.a.p0.o.a.c.a<String, View> H(e eVar, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{eVar, Boolean.valueOf(z), fragment})) == null) {
            b.a.p0.o.a.c.a<String, View> G = G(eVar, fragment, z);
            if (z) {
                SharedElementCallback sharedElementCallback = fragment.c0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(this.x, G);
                }
                M(eVar, G, true);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.b0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, G);
                }
                S(eVar, G, true);
            }
            return G;
        }
        return (b.a.p0.o.a.c.a) invokeCommon.objValue;
    }

    public e I(boolean z, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), eVar, sparseArray, sparseArray2})) == null) {
            e eVar2 = null;
            if (n.x) {
                String str = "popFromBackStack: " + this;
                b.a.p0.o.a.c.d dVar = new b.a.p0.o.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                u(printWriter);
                u(dVar);
            }
            if (y) {
                if (eVar == null) {
                    if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                        eVar = o(sparseArray, sparseArray2, true);
                    }
                } else if (!z) {
                    T(eVar, this.x, this.w);
                }
            }
            p(-1);
            int i2 = eVar != null ? 0 : this.n;
            int i3 = eVar != null ? 0 : this.m;
            for (d dVar2 = this.f11259g; dVar2 != null; dVar2 = dVar2.f11274b) {
                int i4 = eVar != null ? 0 : dVar2.f11279g;
                int i5 = eVar != null ? 0 : dVar2.f11280h;
                switch (dVar2.f11275c) {
                    case 1:
                        Fragment fragment = dVar2.f11276d;
                        fragment.K = i5;
                        this.f11257e.Z(fragment, n.d0(i3), i2);
                        break;
                    case 2:
                        Fragment fragment2 = dVar2.f11276d;
                        if (fragment2 != null) {
                            fragment2.K = i5;
                            this.f11257e.Z(fragment2, n.d0(i3), i2);
                        }
                        if (dVar2.f11281i != null) {
                            for (int i6 = 0; i6 < dVar2.f11281i.size(); i6++) {
                                Fragment fragment3 = dVar2.f11281i.get(i6);
                                fragment3.K = i4;
                                this.f11257e.h(fragment3, false);
                            }
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar2.f11276d;
                        fragment4.K = i4;
                        this.f11257e.h(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = dVar2.f11276d;
                        fragment5.K = i4;
                        this.f11257e.k0(fragment5, n.d0(i3), i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar2.f11276d;
                        fragment6.K = i5;
                        this.f11257e.K(fragment6, n.d0(i3), i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar2.f11276d;
                        fragment7.K = i4;
                        this.f11257e.k(fragment7, n.d0(i3), i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar2.f11276d;
                        fragment8.K = i4;
                        this.f11257e.m(fragment8, n.d0(i3), i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar2.f11275c);
                }
            }
            if (z) {
                n nVar = this.f11257e;
                nVar.R(nVar.l, n.d0(i3), i2, true);
            } else {
                eVar2 = eVar;
            }
            int i7 = this.r;
            if (i7 >= 0) {
                this.f11257e.H(i7);
                this.r = -1;
            }
            return eVar2;
        }
        return (e) invokeCommon.objValue;
    }

    public final void J(e eVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eVar, view, obj, fragment, fragment2, Boolean.valueOf(z), arrayList}) == null) {
            view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj, arrayList, eVar, z, fragment, fragment2));
        }
    }

    public final b.a.p0.o.a.c.a<String, View> L(e eVar, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, eVar, fragment, z)) == null) {
            b.a.p0.o.a.c.a<String, View> aVar = new b.a.p0.o.a.c.a<>();
            if (this.w != null) {
                p.m(aVar, fragment.c0());
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
                M(eVar, aVar, false);
            } else {
                SharedElementCallback sharedElementCallback2 = fragment.c0;
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(this.x, aVar);
                }
                S(eVar, aVar, false);
            }
            return aVar;
        }
        return (b.a.p0.o.a.c.a) invokeLLZ.objValue;
    }

    public final void M(e eVar, b.a.p0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, aVar, z) == null) {
            ArrayList<String> arrayList = this.x;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = this.w.get(i2);
                View view = aVar.get(this.x.get(i2));
                if (view != null) {
                    String o = p.o(view);
                    if (z) {
                        R(eVar.f11282a, str, o);
                    } else {
                        R(eVar.f11282a, o, str);
                    }
                }
            }
        }
    }

    public o N(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i2, i3, i4, i5)) == null) {
            this.f11261i = i2;
            this.j = i3;
            this.k = i4;
            this.l = i5;
            return this;
        }
        return (o) invokeIIII.objValue;
    }

    public final void O(b.a.p0.o.a.c.a<String, View> aVar, e eVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, aVar, eVar) == null) || this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        eVar.f11284c.f11329a = view;
    }

    public final void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, sparseArray, fragment) == null) || fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void S(e eVar, b.a.p0.o.a.c.a<String, View> aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, eVar, aVar, z) == null) {
            int size = aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                String h2 = aVar.h(i2);
                String o = p.o(aVar.k(i2));
                if (z) {
                    R(eVar.f11282a, h2, o);
                } else {
                    R(eVar.f11282a, o, h2);
                }
            }
        }
    }

    @Override // b.a.p0.o.a.a.o
    public o a(int i2, Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, fragment)) == null) {
            x(i2, fragment, null, 1);
            return this;
        }
        return (o) invokeIL.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o b(int i2, Fragment fragment, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i2, fragment, str)) == null) {
            x(i2, fragment, str, 1);
            return this;
        }
        return (o) invokeILL.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o c(Fragment fragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, fragment, str)) == null) {
            x(0, fragment, str, 1);
            return this;
        }
        return (o) invokeLL.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? v(false) : invokeV.intValue;
    }

    @Override // b.a.p0.o.a.a.o
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? v(true) : invokeV.intValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o f(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11275c = 4;
            dVar.f11276d = fragment;
            n(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o g(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11275c = 3;
            dVar.f11276d = fragment;
            n(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            N(i2, i3, 0, 0);
            return this;
        }
        return (o) invokeII.objValue;
    }

    @Override // b.a.p0.o.a.a.o
    public o i(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            d dVar = new d();
            dVar.f11275c = 5;
            dVar.f11276d = fragment;
            n(dVar);
            return this;
        }
        return (o) invokeL.objValue;
    }

    public void n(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            if (this.f11258f == null) {
                this.f11259g = dVar;
                this.f11258f = dVar;
            } else {
                d dVar2 = this.f11259g;
                dVar.f11274b = dVar2;
                dVar2.f11273a = dVar;
                this.f11259g = dVar;
            }
            dVar.f11277e = this.f11261i;
            dVar.f11278f = this.j;
            dVar.f11279g = this.k;
            dVar.f11280h = this.l;
            this.f11260h++;
        }
    }

    public final e o(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, sparseArray, sparseArray2, z)) == null) {
            e eVar = new e(this);
            eVar.f11285d = new View(this.f11257e.m.getContext());
            boolean z2 = false;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (w(sparseArray.keyAt(i2), eVar, z, sparseArray, sparseArray2)) {
                    z2 = true;
                }
            }
            for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                int keyAt = sparseArray2.keyAt(i3);
                if (sparseArray.get(keyAt) == null && w(keyAt, eVar, z, sparseArray, sparseArray2)) {
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

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && this.o) {
            if (n.x) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            for (d dVar = this.f11258f; dVar != null; dVar = dVar.f11273a) {
                Fragment fragment = dVar.f11276d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (n.x) {
                        String str2 = "Bump nesting of " + dVar.f11276d + " to " + dVar.f11276d.v;
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f11281i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f11281i.get(size);
                        fragment2.v += i2;
                        if (n.x) {
                            String str3 = "Bump nesting of " + fragment2 + " to " + fragment2.v;
                        }
                    }
                }
            }
        }
    }

    public void q(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, sparseArray, sparseArray2) == null) && this.f11257e.n.b()) {
            for (d dVar = this.f11258f; dVar != null; dVar = dVar.f11273a) {
                switch (dVar.f11275c) {
                    case 1:
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f11281i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                Q(sparseArray2, dVar.f11281i.get(size));
                            }
                        }
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 3:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                    case 4:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                    case 5:
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 6:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                    case 7:
                        P(sparseArray, dVar.f11276d);
                        break;
                }
            }
        }
    }

    public final void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, sparseArray, sparseArray2) == null) && this.f11257e.n.b()) {
            for (d dVar = this.f11258f; dVar != null; dVar = dVar.f11273a) {
                switch (dVar.f11275c) {
                    case 1:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f11276d;
                        if (this.f11257e.f11300e != null) {
                            for (int i2 = 0; i2 < this.f11257e.f11300e.size(); i2++) {
                                Fragment fragment2 = this.f11257e.f11300e.get(i2);
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
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 4:
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 5:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                    case 6:
                        P(sparseArray, dVar.f11276d);
                        break;
                    case 7:
                        Q(sparseArray2, dVar.f11276d);
                        break;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (n.x) {
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
                eVar = o(sparseArray, sparseArray2, false);
            } else {
                eVar = null;
            }
            int i2 = eVar != null ? 0 : this.n;
            int i3 = eVar != null ? 0 : this.m;
            for (d dVar = this.f11258f; dVar != null; dVar = dVar.f11273a) {
                int i4 = eVar != null ? 0 : dVar.f11277e;
                int i5 = eVar != null ? 0 : dVar.f11278f;
                switch (dVar.f11275c) {
                    case 1:
                        Fragment fragment = dVar.f11276d;
                        fragment.K = i4;
                        this.f11257e.h(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.f11276d;
                        int i6 = fragment2.B;
                        if (this.f11257e.f11300e != null) {
                            for (int i7 = 0; i7 < this.f11257e.f11300e.size(); i7++) {
                                Fragment fragment3 = this.f11257e.f11300e.get(i7);
                                if (n.x) {
                                    String str2 = "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3;
                                }
                                if (fragment3.B == i6) {
                                    if (fragment3 == fragment2) {
                                        dVar.f11276d = null;
                                        fragment2 = null;
                                    } else {
                                        if (dVar.f11281i == null) {
                                            dVar.f11281i = new ArrayList<>();
                                        }
                                        dVar.f11281i.add(fragment3);
                                        fragment3.K = i5;
                                        if (this.o) {
                                            fragment3.v++;
                                            if (n.x) {
                                                String str3 = "Bump nesting of " + fragment3 + " to " + fragment3.v;
                                            }
                                        }
                                        this.f11257e.Z(fragment3, i3, i2);
                                    }
                                }
                            }
                        }
                        if (fragment2 != null) {
                            fragment2.K = i4;
                            this.f11257e.h(fragment2, false);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        Fragment fragment4 = dVar.f11276d;
                        fragment4.K = i5;
                        this.f11257e.Z(fragment4, i3, i2);
                        break;
                    case 4:
                        Fragment fragment5 = dVar.f11276d;
                        fragment5.K = i5;
                        this.f11257e.K(fragment5, i3, i2);
                        break;
                    case 5:
                        Fragment fragment6 = dVar.f11276d;
                        fragment6.K = i4;
                        this.f11257e.k0(fragment6, i3, i2);
                        break;
                    case 6:
                        Fragment fragment7 = dVar.f11276d;
                        fragment7.K = i5;
                        this.f11257e.m(fragment7, i3, i2);
                        break;
                    case 7:
                        Fragment fragment8 = dVar.f11276d;
                        fragment8.K = i4;
                        this.f11257e.k(fragment8, i3, i2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.f11275c);
                }
            }
            n nVar = this.f11257e;
            nVar.R(nVar.l, i3, i2, true);
            if (this.o) {
                this.f11257e.g(this);
            }
        }
    }

    public final void s(e eVar, Fragment fragment, Fragment fragment2, boolean z, b.a.p0.o.a.c.a<String, View> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{eVar, fragment, fragment2, Boolean.valueOf(z), aVar}) == null) {
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
                if (n.x) {
                    String str = "Commit: " + this;
                    b.a.p0.o.a.c.d dVar = new b.a.p0.o.a.c.d("FragmentManager");
                    PrintWriter printWriter = new PrintWriter(dVar);
                    y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                    u(printWriter);
                    u(dVar);
                }
                this.q = true;
                if (this.o) {
                    this.r = this.f11257e.i(this);
                } else {
                    this.r = -1;
                }
                this.f11257e.D(this, z);
                return this.r;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    public final boolean w(int i2, e eVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        InterceptResult invokeCommon;
        Object obj;
        Object obj2;
        b.a.p0.o.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z), sparseArray, sparseArray2})) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f11257e.n.a(i2);
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
                b.a.p0.o.a.c.a<String, View> L = L(eVar, fragment2, z);
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
                    J(eVar, viewGroup, F, fragment, fragment2, z, arrayList);
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
            Object t = t(obj, fragment2, arrayList2, aVar, eVar.f11285d);
            ArrayList<String> arrayList3 = this.x;
            if (arrayList3 != null && aVar != null && (view = aVar.get(arrayList3.get(0))) != null) {
                if (t != null) {
                    p.t(t, view);
                }
                if (obj4 != null) {
                    p.t(obj4, view);
                }
            }
            a aVar2 = new a(this, fragment);
            ArrayList arrayList4 = new ArrayList();
            b.a.p0.o.a.c.a aVar3 = new b.a.p0.o.a.c.a();
            if (fragment == null) {
                z2 = true;
            } else if (z) {
                z2 = fragment.l();
            } else {
                z2 = fragment.i();
            }
            Object r = p.r(obj2, t, obj4, z2);
            if (r != null) {
                obj3 = r;
                p.d(obj2, obj4, viewGroup, aVar2, eVar.f11285d, eVar.f11284c, eVar.f11282a, arrayList4, aVar, aVar3, arrayList);
                B(viewGroup, eVar, i2, obj3);
                p.l(obj3, eVar.f11285d, true);
                A(eVar, i2, obj3);
                p.e(viewGroup, obj3);
                p.i(viewGroup, eVar.f11285d, obj2, arrayList4, t, arrayList2, obj4, arrayList, obj3, eVar.f11283b, aVar3);
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
            fragment.w = this.f11257e;
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
            dVar.f11275c = i3;
            dVar.f11276d = fragment;
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
                if (this.f11261i != 0 || this.j != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.f11261i));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.j));
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
            if (this.f11258f != null) {
                printWriter.print(str);
                printWriter.println("Operations:");
                String str3 = str + "    ";
                d dVar = this.f11258f;
                int i2 = 0;
                while (dVar != null) {
                    switch (dVar.f11275c) {
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
                            str2 = "cmd=" + dVar.f11275c;
                            break;
                    }
                    printWriter.print(str);
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str2);
                    printWriter.print(" ");
                    printWriter.println(dVar.f11276d);
                    if (z) {
                        if (dVar.f11277e != 0 || dVar.f11278f != 0) {
                            printWriter.print(str);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11277e));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11278f));
                        }
                        if (dVar.f11279g != 0 || dVar.f11280h != 0) {
                            printWriter.print(str);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(dVar.f11279g));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(dVar.f11280h));
                        }
                    }
                    ArrayList<Fragment> arrayList = dVar.f11281i;
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i3 = 0; i3 < dVar.f11281i.size(); i3++) {
                            printWriter.print(str3);
                            if (dVar.f11281i.size() == 1) {
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
                            printWriter.println(dVar.f11281i.get(i3));
                        }
                    }
                    dVar = dVar.f11273a;
                    i2++;
                }
            }
        }
    }
}
