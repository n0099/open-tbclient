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
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f30702b;

    /* renamed from: c  reason: collision with root package name */
    public Info f30703c;

    /* renamed from: d  reason: collision with root package name */
    public View f30704d;

    /* renamed from: e  reason: collision with root package name */
    public List f30705e;

    /* renamed from: f  reason: collision with root package name */
    public s f30706f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f30707g;

    /* renamed from: h  reason: collision with root package name */
    public long f30708h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f30709i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30710j;
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
        this.f30705e = Collections.synchronizedList(new ArrayList());
        this.f30708h = 0L;
        this.f30709i = new f6(this);
        this.f30710j = false;
        this.k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f61010e);
        this.f30702b = a5Var;
        a5Var.f30509g = this.f30709i;
        this.f30707g = new h4(context);
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
                if (this.f30702b != null) {
                    this.f30702b.b();
                    this.f30702b = null;
                }
                if (this.f30706f != null) {
                    this.f30706f = null;
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
            this.f30708h = 0L;
            if (this.f30704d != null) {
                g();
            }
            this.f30704d = view;
            try {
                q qVar = new q(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f30705e.contains(view2)) {
                            this.f30705e.add(view2);
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
                        j3 htmlWebView = pBMediaView.getHtmlWebView();
                        htmlWebView.a(f() ? this.f30703c.getLoad() : "", this.f30703c);
                        if (this.f30703c.isNat()) {
                            htmlWebView.f30578c.setOnTouchListener(new i(this));
                        }
                        htmlWebView.f30577b = new m(this);
                    }
                } catch (Exception unused2) {
                }
            }
            y2 a = c3.a(this.a);
            a.o(new g3(this.f30703c));
            a.m();
            s sVar = this.f30706f;
            if (sVar != null) {
                sVar.onDisplayed();
            }
            if (this.f30703c != null) {
                m2.m(this.a, this.f30703c.getId() + ":" + System.currentTimeMillis(), false);
            }
            new s0().a(view, this.f30703c, new e(this, view));
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f30703c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f30705e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f30705e.clear();
                if (this.f30704d != null) {
                    this.f30704d = null;
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
