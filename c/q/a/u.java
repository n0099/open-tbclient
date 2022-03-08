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
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CircleProgressbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public v4 f29132b;

    /* renamed from: c  reason: collision with root package name */
    public Info f29133c;

    /* renamed from: d  reason: collision with root package name */
    public View f29134d;

    /* renamed from: e  reason: collision with root package name */
    public List f29135e;

    /* renamed from: f  reason: collision with root package name */
    public s f29136f;

    /* renamed from: g  reason: collision with root package name */
    public c4 f29137g;

    /* renamed from: h  reason: collision with root package name */
    public long f29138h;

    /* renamed from: i  reason: collision with root package name */
    public z4 f29139i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29140j;
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

    public u(Context context, String str) {
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
        this.f29135e = Collections.synchronizedList(new ArrayList());
        this.f29138h = 0L;
        this.f29139i = new a6(this);
        this.f29140j = false;
        this.k = 0L;
        this.a = context;
        v4 v4Var = new v4(context, str, L.f59360e);
        this.f29132b = v4Var;
        v4Var.f29158g = this.f29139i;
        this.f29137g = new c4(context);
    }

    public static /* synthetic */ void d(u uVar, View view) {
        if (uVar.t <= 0 || uVar.u <= 0) {
            uVar.u = view.getHeight();
            uVar.t = view.getWidth();
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
                g();
                if (this.f29132b != null) {
                    this.f29132b.b();
                    this.f29132b = null;
                }
                if (this.f29136f != null) {
                    this.f29136f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c(View view, PBMediaView pBMediaView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, pBMediaView) == null) {
            List<View> arrayList = new ArrayList();
            if (view != null) {
                arrayList = a(view);
            }
            if (view == null || arrayList == null || arrayList.size() == 0 || !f()) {
                return;
            }
            this.f29138h = 0L;
            if (this.f29134d != null) {
                g();
            }
            this.f29134d = view;
            try {
                q qVar = new q(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f29135e.contains(view2)) {
                            this.f29135e.add(view2);
                        }
                        if (!(view2 instanceof CircleProgressbar)) {
                            view2.setOnClickListener(qVar);
                            view2.setOnTouchListener(qVar);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (pBMediaView != null) {
                try {
                    if (pBMediaView.getHtmlWebView() != null) {
                        e3 htmlWebView = pBMediaView.getHtmlWebView();
                        htmlWebView.a(f() ? this.f29133c.getLoad() : "", this.f29133c);
                        if (this.f29133c.isNat()) {
                            htmlWebView.f28945c.setOnTouchListener(new i(this));
                        }
                        htmlWebView.f28944b = new m(this);
                    }
                } catch (Exception unused2) {
                }
            }
            t2 a = x2.a(this.a);
            a.o(new b3(this.f29133c));
            a.m();
            s sVar = this.f29136f;
            if (sVar != null) {
                sVar.onDisplayed();
            }
            if (this.f29133c != null) {
                h2.m(this.a, this.f29133c.getId() + ":" + System.currentTimeMillis(), false);
            }
            new s0().a(view, this.f29133c, new e(this, view));
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f29133c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f29135e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f29135e.clear();
                if (this.f29134d != null) {
                    this.f29134d = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
