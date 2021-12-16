package c.p.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.L;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f31196b;

    /* renamed from: c  reason: collision with root package name */
    public Info f31197c;

    /* renamed from: d  reason: collision with root package name */
    public View f31198d;

    /* renamed from: e  reason: collision with root package name */
    public List f31199e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f31200f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f31201g;

    /* renamed from: h  reason: collision with root package name */
    public long f31202h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f31203i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31204j;

    /* renamed from: k  reason: collision with root package name */
    public long f31205k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public long v;
    public int w;
    public int x;
    public long y;

    public l(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31199e = Collections.synchronizedList(new ArrayList());
        this.f31202h = 0L;
        this.f31203i = new w5(this);
        this.f31204j = false;
        this.f31205k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f63180c);
        this.f31196b = a5Var;
        a5Var.f31108g = this.f31203i;
        this.f31201g = new h4(context);
    }

    public static /* synthetic */ void e(l lVar, View view) {
        if (lVar.t <= 0 || lVar.u <= 0) {
            lVar.u = view.getHeight();
            lVar.t = view.getWidth();
        }
    }

    public final List a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                try {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt != null) {
                            arrayList.add(childAt);
                            if (!(childAt instanceof PBMediaView)) {
                                arrayList.addAll(a(childAt));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h();
                if (this.f31196b != null) {
                    this.f31196b.b();
                    this.f31196b = null;
                }
                if (this.f31200f != null) {
                    this.f31200f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c(View view, PBMediaView pBMediaView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, pBMediaView) == null) {
            List arrayList = new ArrayList();
            if (view != null) {
                arrayList = a(view);
            }
            d(view, pBMediaView, arrayList);
        }
    }

    public void d(View view, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, view, pBMediaView, list) == null) || view == null || list == null || list.size() == 0 || !g()) {
            return;
        }
        this.f31202h = 0L;
        if (this.f31198d != null) {
            h();
        }
        this.f31198d = view;
        try {
            h hVar = new h(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f31199e.contains(view2)) {
                        this.f31199e.add(view2);
                    }
                    view2.setOnClickListener(hVar);
                    view2.setOnTouchListener(hVar);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    j3 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(g() ? this.f31197c.getLoad() : "", this.f31197c);
                    if (this.f31197c.isNat()) {
                        htmlWebView.f31180c.setOnTouchListener(new a(this));
                    }
                    htmlWebView.f31179b = new d(this);
                }
            } catch (Exception unused2) {
            }
        }
        y2 a = c3.a(this.a);
        a.o(new g3(this.f31197c));
        a.m();
        if (this.f31197c != null) {
            m2.m(this.a, this.f31197c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f31197c, new e6(this, view));
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f31197c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f31199e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f31199e.clear();
                if (this.f31198d != null) {
                    this.f31198d = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.n));
            hashMap.put("dy", Integer.valueOf(this.o));
            hashMap.put("dts", Long.valueOf(this.v));
            hashMap.put("ux", Integer.valueOf(this.w));
            hashMap.put("uy", Integer.valueOf(this.x));
            hashMap.put("uts", Long.valueOf(this.y));
            r0.j(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
