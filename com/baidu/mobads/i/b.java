package com.baidu.mobads.i;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.XAdVideoResponse;
import com.baidu.mobads.component.FeedPortraitVideoView;
import com.baidu.mobads.r;
import com.baidu.mobads.utils.d;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes2.dex */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f8328a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mobads.i.a f8329b;

    /* renamed from: c  reason: collision with root package name */
    public View f8330c;

    /* renamed from: d  reason: collision with root package name */
    public String f8331d;

    /* renamed from: e  reason: collision with root package name */
    public DexClassLoader f8332e;

    /* loaded from: classes2.dex */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(FeedPortraitVideoView.PLAY_END)) {
                if (b.this.f8329b != null) {
                    b.this.f8329b.a();
                }
            } else if (name.equals("playFailure")) {
                if (b.this.f8329b != null) {
                    b.this.f8329b.b();
                }
            } else if (name.equals("onAdShow") && b.this.f8329b != null) {
                b.this.f8329b.c();
            }
            return null;
        }
    }

    public b(Context context) {
        super(context);
        this.f8331d = "TvtfWYI1/aJhqbnwJ3f1NpdlWii72QtgZNj6vCzWTzeryGCytmYPBnjkQ3CBaxEa";
        a(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    public long b() {
        if (this.f8330c != null) {
            return ((Long) r.a(d.a(this.f8331d), this.f8330c, this.f8332e, "getDuration", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    private void a(Context context) {
        this.f8328a = context;
        Class[] clsArr = {Context.class};
        Object[] objArr = {context};
        DexClassLoader d2 = com.baidu.mobads.g.b.d();
        this.f8332e = d2;
        if (d2 == null) {
            this.f8332e = r.a(this.f8328a);
        }
        View view = (View) r.a(d.a(this.f8331d), this.f8332e, clsArr, objArr);
        this.f8330c = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void a(XAdVideoResponse xAdVideoResponse) {
        if (xAdVideoResponse == null || this.f8330c == null) {
            return;
        }
        r.a(d.a(this.f8331d), this.f8330c, this.f8332e, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
    }

    public void a(com.baidu.mobads.i.a aVar) {
        this.f8329b = aVar;
        try {
            Class<?> a2 = r.a("com.component.patchad.IPatchAdListener", this.f8332e);
            Object newProxyInstance = Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, new a());
            if (this.f8330c != null) {
                r.a(d.a(this.f8331d), this.f8330c, this.f8332e, "setPatchAdListener", new Class[]{a2}, newProxyInstance);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        if (this.f8330c != null) {
            r.a(d.a(this.f8331d), this.f8330c, this.f8332e, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public long a() {
        if (this.f8330c != null) {
            return ((Long) r.a(d.a(this.f8331d), this.f8330c, this.f8332e, LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }
}
