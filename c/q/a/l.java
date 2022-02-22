package c.q.a;

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
    public a5 f30593b;

    /* renamed from: c  reason: collision with root package name */
    public Info f30594c;

    /* renamed from: d  reason: collision with root package name */
    public View f30595d;

    /* renamed from: e  reason: collision with root package name */
    public List f30596e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f30597f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f30598g;

    /* renamed from: h  reason: collision with root package name */
    public long f30599h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f30600i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30601j;
    public long k;
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
        this.f30596e = Collections.synchronizedList(new ArrayList());
        this.f30599h = 0L;
        this.f30600i = new w5(this);
        this.f30601j = false;
        this.k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f61008c);
        this.f30593b = a5Var;
        a5Var.f30509g = this.f30600i;
        this.f30598g = new h4(context);
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
                if (this.f30593b != null) {
                    this.f30593b.b();
                    this.f30593b = null;
                }
                if (this.f30597f != null) {
                    this.f30597f = null;
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
        this.f30599h = 0L;
        if (this.f30595d != null) {
            h();
        }
        this.f30595d = view;
        try {
            h hVar = new h(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f30596e.contains(view2)) {
                        this.f30596e.add(view2);
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
                    htmlWebView.a(g() ? this.f30594c.getLoad() : "", this.f30594c);
                    if (this.f30594c.isNat()) {
                        htmlWebView.f30578c.setOnTouchListener(new a(this));
                    }
                    htmlWebView.f30577b = new d(this);
                }
            } catch (Exception unused2) {
            }
        }
        y2 a = c3.a(this.a);
        a.o(new g3(this.f30594c));
        a.m();
        if (this.f30594c != null) {
            m2.m(this.a, this.f30594c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f30594c, new e6(this, view));
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f30594c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f30596e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f30596e.clear();
                if (this.f30595d != null) {
                    this.f30595d = null;
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
