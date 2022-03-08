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
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public v4 f29008b;

    /* renamed from: c  reason: collision with root package name */
    public Info f29009c;

    /* renamed from: d  reason: collision with root package name */
    public View f29010d;

    /* renamed from: e  reason: collision with root package name */
    public List f29011e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f29012f;

    /* renamed from: g  reason: collision with root package name */
    public c4 f29013g;

    /* renamed from: h  reason: collision with root package name */
    public long f29014h;

    /* renamed from: i  reason: collision with root package name */
    public z4 f29015i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29016j;
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
        this.f29011e = Collections.synchronizedList(new ArrayList());
        this.f29014h = 0L;
        this.f29015i = new r5(this);
        this.f29016j = false;
        this.k = 0L;
        this.a = context;
        v4 v4Var = new v4(context, str, L.f59358c);
        this.f29008b = v4Var;
        v4Var.f29158g = this.f29015i;
        this.f29013g = new c4(context);
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
                if (this.f29008b != null) {
                    this.f29008b.b();
                    this.f29008b = null;
                }
                if (this.f29012f != null) {
                    this.f29012f = null;
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
        this.f29014h = 0L;
        if (this.f29010d != null) {
            h();
        }
        this.f29010d = view;
        try {
            h hVar = new h(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f29011e.contains(view2)) {
                        this.f29011e.add(view2);
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
                    e3 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(g() ? this.f29009c.getLoad() : "", this.f29009c);
                    if (this.f29009c.isNat()) {
                        htmlWebView.f28945c.setOnTouchListener(new a(this));
                    }
                    htmlWebView.f28944b = new d(this);
                }
            } catch (Exception unused2) {
            }
        }
        t2 a = x2.a(this.a);
        a.o(new b3(this.f29009c));
        a.m();
        if (this.f29009c != null) {
            h2.m(this.a, this.f29009c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f29009c, new z5(this, view));
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f29009c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f29011e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f29011e.clear();
                if (this.f29010d != null) {
                    this.f29010d = null;
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
