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
    public a5 f31456b;

    /* renamed from: c  reason: collision with root package name */
    public Info f31457c;

    /* renamed from: d  reason: collision with root package name */
    public View f31458d;

    /* renamed from: e  reason: collision with root package name */
    public List f31459e;

    /* renamed from: f  reason: collision with root package name */
    public s f31460f;

    /* renamed from: g  reason: collision with root package name */
    public h4 f31461g;

    /* renamed from: h  reason: collision with root package name */
    public long f31462h;

    /* renamed from: i  reason: collision with root package name */
    public e5 f31463i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31464j;

    /* renamed from: k  reason: collision with root package name */
    public long f31465k;
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
        this.f31459e = Collections.synchronizedList(new ArrayList());
        this.f31462h = 0L;
        this.f31463i = new f6(this);
        this.f31464j = false;
        this.f31465k = 0L;
        this.a = context;
        a5 a5Var = new a5(context, str, L.f63177e);
        this.f31456b = a5Var;
        a5Var.f31251g = this.f31463i;
        this.f31461g = new h4(context);
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
                if (this.f31456b != null) {
                    this.f31456b.b();
                    this.f31456b = null;
                }
                if (this.f31460f != null) {
                    this.f31460f = null;
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
            this.f31462h = 0L;
            if (this.f31458d != null) {
                g();
            }
            this.f31458d = view;
            try {
                q qVar = new q(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f31459e.contains(view2)) {
                            this.f31459e.add(view2);
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
                        htmlWebView.a(f() ? this.f31457c.getLoad() : "", this.f31457c);
                        if (this.f31457c.isNat()) {
                            htmlWebView.f31323c.setOnTouchListener(new i(this));
                        }
                        htmlWebView.f31322b = new m(this);
                    }
                } catch (Exception unused2) {
                }
            }
            y2 a = c3.a(this.a);
            a.o(new g3(this.f31457c));
            a.m();
            s sVar = this.f31460f;
            if (sVar != null) {
                sVar.onDisplayed();
            }
            if (this.f31457c != null) {
                m2.m(this.a, this.f31457c.getId() + ":" + System.currentTimeMillis(), false);
            }
            new s0().a(view, this.f31457c, new e(this, view));
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f31457c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f31459e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f31459e.clear();
                if (this.f31458d != null) {
                    this.f31458d = null;
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
