package c.q.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.L;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CircleProgressbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class p2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public v4 f29069b;

    /* renamed from: c  reason: collision with root package name */
    public Info f29070c;

    /* renamed from: d  reason: collision with root package name */
    public View f29071d;

    /* renamed from: e  reason: collision with root package name */
    public List f29072e;

    /* renamed from: f  reason: collision with root package name */
    public d3 f29073f;

    /* renamed from: g  reason: collision with root package name */
    public c4 f29074g;

    /* renamed from: h  reason: collision with root package name */
    public long f29075h;

    /* renamed from: i  reason: collision with root package name */
    public z4 f29076i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29077j;
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

    public p2(Context context, String str) {
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
        this.f29072e = Collections.synchronizedList(new ArrayList());
        this.f29075h = 0L;
        this.f29076i = new z1(this);
        this.f29077j = false;
        this.k = 0L;
        this.a = context;
        v4 v4Var = new v4(context, str, L.f59361f);
        this.f29069b = v4Var;
        v4Var.f29158g = this.f29076i;
        this.f29074g = new c4(context);
    }

    public static /* synthetic */ void c(p2 p2Var, View view) {
        if (p2Var.t <= 0 || p2Var.u <= 0) {
            p2Var.u = view.getHeight();
            p2Var.t = view.getWidth();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                f();
                if (this.f29069b != null) {
                    this.f29069b.b();
                    this.f29069b = null;
                }
                if (this.f29073f != null) {
                    this.f29073f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b(View view, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pBMediaView, list) == null) || view == null || list == null || list.size() == 0 || !e()) {
            return;
        }
        this.f29075h = 0L;
        if (this.f29071d != null) {
            f();
        }
        this.f29071d = view;
        try {
            m2 m2Var = new m2(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f29072e.contains(view2)) {
                        this.f29072e.add(view2);
                    }
                    if (!(view2 instanceof CircleProgressbar)) {
                        view2.setOnClickListener(m2Var);
                        view2.setOnTouchListener(m2Var);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    e3 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(e() ? this.f29070c.getLoad() : "", this.f29070c);
                    if (this.f29070c.isNat()) {
                        htmlWebView.f28945c.setOnTouchListener(new i2(this));
                    }
                    htmlWebView.f28944b = new j2(this);
                }
            } catch (Exception unused2) {
            }
        }
        t2 a = x2.a(this.a);
        a.o(new b3(this.f29070c));
        a.m();
        if (this.f29070c != null) {
            h2.m(this.a, this.f29070c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f29070c, new f2(this, view));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.f29070c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                for (View view : this.f29072e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f29072e.clear();
                if (this.f29071d != null) {
                    this.f29071d = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
