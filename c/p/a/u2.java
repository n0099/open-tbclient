package c.p.a;

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
/* loaded from: classes7.dex */
public class u2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f30958b;

    /* renamed from: c  reason: collision with root package name */
    public Info f30959c;

    /* renamed from: d  reason: collision with root package name */
    public View f30960d;

    /* renamed from: e  reason: collision with root package name */
    public List f30961e;

    /* renamed from: f  reason: collision with root package name */
    public i3 f30962f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f30963g;

    /* renamed from: h  reason: collision with root package name */
    public long f30964h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f30965i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30966j;

    /* renamed from: k  reason: collision with root package name */
    public long f30967k;
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
        this.f30961e = Collections.synchronizedList(new ArrayList());
        this.f30964h = 0L;
        this.f30965i = new e2(this);
        this.f30966j = false;
        this.f30967k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f62602f);
        this.f30958b = a5Var;
        a5Var.f30738g = this.f30965i;
        this.f30963g = new h4(context);
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
                if (this.f30958b != null) {
                    this.f30958b.b();
                    this.f30958b = null;
                }
                if (this.f30962f != null) {
                    this.f30962f = null;
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
        this.f30964h = 0L;
        if (this.f30960d != null) {
            f();
        }
        this.f30960d = view;
        try {
            r2 r2Var = new r2(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f30961e.contains(view2)) {
                        this.f30961e.add(view2);
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
                    htmlWebView.a(e() ? this.f30959c.getLoad() : "", this.f30959c);
                    if (this.f30959c.isNat()) {
                        htmlWebView.f30810c.setOnTouchListener(new n2(this));
                    }
                    htmlWebView.f30809b = new o2(this);
                }
            } catch (Exception unused2) {
            }
        }
        y2 a = c3.a(this.a);
        a.o(new g3(this.f30959c));
        a.m();
        if (this.f30959c != null) {
            m2.m(this.a, this.f30959c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new s0().a(view, this.f30959c, new k2(this, view));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.f30959c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                for (View view : this.f30961e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f30961e.clear();
                if (this.f30960d != null) {
                    this.f30960d = null;
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
