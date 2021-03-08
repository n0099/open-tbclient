package com.baidu.mobads.i;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.XAdVideoResponse;
import com.baidu.mobads.r;
import com.baidu.mobads.utils.d;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f2405a;
    private com.baidu.mobads.i.a b;
    private View c;
    private String d;
    private DexClassLoader e;

    public b(Context context) {
        super(context);
        this.d = "TvtfWYI1/aJhqbnwJ3f1NpdlWii72QtgZNj6vCzWTzeryGCytmYPBnjkQ3CBaxEa";
        a(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void a(Context context) {
        this.f2405a = context;
        Class[] clsArr = {Context.class};
        Object[] objArr = {this.f2405a};
        this.e = com.baidu.mobads.g.b.d();
        if (this.e == null) {
            this.e = r.a(this.f2405a);
        }
        this.c = (View) r.a(d.a(this.d), this.e, clsArr, objArr);
        if (this.c != null) {
            addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void a(XAdVideoResponse xAdVideoResponse) {
        if (xAdVideoResponse != null && this.c != null) {
            r.a(d.a(this.d), this.c, this.e, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
        }
    }

    public void a(com.baidu.mobads.i.a aVar) {
        this.b = aVar;
        try {
            Class<?> a2 = r.a("com.component.patchad.IPatchAdListener", this.e);
            Object newProxyInstance = Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, new a());
            if (this.c != null) {
                r.a(d.a(this.d), this.c, this.e, "setPatchAdListener", new Class[]{a2}, newProxyInstance);
            }
        } catch (Throwable th) {
        }
    }

    public void a(boolean z) {
        if (this.c != null) {
            r.a(d.a(this.d), this.c, this.e, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public long a() {
        if (this.c != null) {
            return ((Long) r.a(d.a(this.d), this.c, this.e, "getCurrentPosition", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    public long b() {
        if (this.c != null) {
            return ((Long) r.a(d.a(this.d), this.c, this.e, "getDuration", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    /* loaded from: classes4.dex */
    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (!TextUtils.isEmpty(name)) {
                if (name.equals("playCompletion")) {
                    if (b.this.b != null) {
                        b.this.b.a();
                    }
                } else if (name.equals("playFailure")) {
                    if (b.this.b != null) {
                        b.this.b.b();
                    }
                } else if (name.equals("onAdShow") && b.this.b != null) {
                    b.this.b.c();
                }
            }
            return null;
        }
    }
}
