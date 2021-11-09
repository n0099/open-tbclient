package b.q.a;

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
/* loaded from: classes6.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33502a;

    /* renamed from: b  reason: collision with root package name */
    public a5 f33503b;

    /* renamed from: c  reason: collision with root package name */
    public Info f33504c;

    /* renamed from: d  reason: collision with root package name */
    public View f33505d;

    /* renamed from: e  reason: collision with root package name */
    public List f33506e;

    /* renamed from: f  reason: collision with root package name */
    public s f33507f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f33508g;

    /* renamed from: h  reason: collision with root package name */
    public long f33509h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f33510i;
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
        this.f33506e = Collections.synchronizedList(new ArrayList());
        this.f33509h = 0L;
        this.f33510i = new f6(this);
        this.j = false;
        this.k = 0L;
        this.f33502a = context;
        a5 a5Var = new a5(context, str, L.f70455e);
        this.f33503b = a5Var;
        a5Var.f33244g = this.f33510i;
        this.f33508g = new h4(context);
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
                if (this.f33503b != null) {
                    this.f33503b.b();
                    this.f33503b = null;
                }
                if (this.f33507f != null) {
                    this.f33507f = null;
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
            this.f33509h = 0L;
            if (this.f33505d != null) {
                g();
            }
            this.f33505d = view;
            try {
                q qVar = new q(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f33506e.contains(view2)) {
                            this.f33506e.add(view2);
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
                        htmlWebView.a(f() ? this.f33504c.getLoad() : "", this.f33504c);
                        if (this.f33504c.isNat()) {
                            htmlWebView.f33355c.setOnTouchListener(new i(this));
                        }
                        htmlWebView.f33354b = new m(this);
                    }
                } catch (Exception unused2) {
                }
            }
            y2 a2 = c3.a(this.f33502a);
            a2.o(new g3(this.f33504c));
            a2.m();
            s sVar = this.f33507f;
            if (sVar != null) {
                sVar.onDisplayed();
            }
            if (this.f33504c != null) {
                m2.m(this.f33502a, this.f33504c.getId() + ":" + System.currentTimeMillis(), false);
            }
            new s0().a(view, this.f33504c, new e(this, view));
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f33504c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f33506e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f33506e.clear();
                if (this.f33505d != null) {
                    this.f33505d = null;
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
