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
/* loaded from: classes9.dex */
public class u2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f31471b;

    /* renamed from: c  reason: collision with root package name */
    public Info f31472c;

    /* renamed from: d  reason: collision with root package name */
    public View f31473d;

    /* renamed from: e  reason: collision with root package name */
    public List f31474e;

    /* renamed from: f  reason: collision with root package name */
    public i3 f31475f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f31476g;

    /* renamed from: h  reason: collision with root package name */
    public long f31477h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f31478i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31479j;

    /* renamed from: k  reason: collision with root package name */
    public long f31480k;
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
        this.f31474e = Collections.synchronizedList(new ArrayList());
        this.f31477h = 0L;
        this.f31478i = new e2(this);
        this.f31479j = false;
        this.f31480k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f63178f);
        this.f31471b = a5Var;
        a5Var.f31251g = this.f31478i;
        this.f31476g = new h4(context);
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
                if (this.f31471b != null) {
                    this.f31471b.b();
                    this.f31471b = null;
                }
                if (this.f31475f != null) {
                    this.f31475f = null;
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
        this.f31477h = 0L;
        if (this.f31473d != null) {
            f();
        }
        this.f31473d = view;
        try {
            r2 r2Var = new r2(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f31474e.contains(view2)) {
                        this.f31474e.add(view2);
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
                    htmlWebView.a(e() ? this.f31472c.getLoad() : "", this.f31472c);
                    if (this.f31472c.isNat()) {
                        htmlWebView.f31323c.setOnTouchListener(new n2(this));
                    }
                    htmlWebView.f31322b = new o2(this);
                }
            } catch (Exception unused2) {
            }
        }
        y2 a = c3.a(this.a);
        a.o(new g3(this.f31472c));
        a.m();
        if (this.f31472c != null) {
            m2.m(this.a, this.f31472c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f31472c, new k2(this, view));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.f31472c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                for (View view : this.f31474e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f31474e.clear();
                if (this.f31473d != null) {
                    this.f31473d = null;
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
