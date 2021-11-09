package b.q.a;

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
/* loaded from: classes6.dex */
public class u2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33518a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f33519b;

    /* renamed from: c  reason: collision with root package name */
    public Info f33520c;

    /* renamed from: d  reason: collision with root package name */
    public View f33521d;

    /* renamed from: e  reason: collision with root package name */
    public List f33522e;

    /* renamed from: f  reason: collision with root package name */
    public i3 f33523f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f33524g;

    /* renamed from: h  reason: collision with root package name */
    public long f33525h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f33526i;
    public boolean j;
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

    public u2(Context context, String str) {
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
        this.f33522e = Collections.synchronizedList(new ArrayList());
        this.f33525h = 0L;
        this.f33526i = new e2(this);
        this.j = false;
        this.k = 0L;
        this.f33518a = context;
        a5 a5Var = new a5(context, str, L.f70456f);
        this.f33519b = a5Var;
        a5Var.f33244g = this.f33526i;
        this.f33524g = new h4(context);
    }

    public static /* synthetic */ void c(u2 u2Var, View view) {
        if (u2Var.t <= 0 || u2Var.u <= 0) {
            u2Var.u = view.getHeight();
            u2Var.t = view.getWidth();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                f();
                if (this.f33519b != null) {
                    this.f33519b.b();
                    this.f33519b = null;
                }
                if (this.f33523f != null) {
                    this.f33523f = null;
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
        this.f33525h = 0L;
        if (this.f33521d != null) {
            f();
        }
        this.f33521d = view;
        try {
            r2 r2Var = new r2(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f33522e.contains(view2)) {
                        this.f33522e.add(view2);
                    }
                    if (!(view2 instanceof CircleProgressbar)) {
                        view2.setOnClickListener(r2Var);
                        view2.setOnTouchListener(r2Var);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    j3 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(e() ? this.f33520c.getLoad() : "", this.f33520c);
                    if (this.f33520c.isNat()) {
                        htmlWebView.f33355c.setOnTouchListener(new n2(this));
                    }
                    htmlWebView.f33354b = new o2(this);
                }
            } catch (Exception unused2) {
            }
        }
        y2 a2 = c3.a(this.f33518a);
        a2.o(new g3(this.f33520c));
        a2.m();
        if (this.f33520c != null) {
            m2.m(this.f33518a, this.f33520c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f33520c, new k2(this, view));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.f33520c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                for (View view : this.f33522e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f33522e.clear();
                if (this.f33521d != null) {
                    this.f33521d = null;
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
