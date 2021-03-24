package com.baidu.media.duplayer;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
/* loaded from: classes2.dex */
public class CyberVRRenderProviderImpl extends CyberVRRenderProvider {
    public static final String TAG = "BDVRRenderDelegate";

    /* renamed from: a  reason: collision with root package name */
    public final a f7937a;

    /* renamed from: b  reason: collision with root package name */
    public Method f7938b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7939c;

    /* renamed from: d  reason: collision with root package name */
    public Method f7940d;

    /* renamed from: e  reason: collision with root package name */
    public Method f7941e;

    /* renamed from: f  reason: collision with root package name */
    public Method f7942f;

    /* renamed from: g  reason: collision with root package name */
    public Method f7943g;

    /* renamed from: h  reason: collision with root package name */
    public Method f7944h;
    public Method i;
    public Method j;
    public Method k;
    public Method l;
    public Method m;
    public Method n;
    public Method o;
    public Method p;
    public Method q;
    public Method r;
    public Method s;
    public final Object t;

    /* loaded from: classes2.dex */
    public class a implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public CyberVRRenderProvider.IOnSurfaceReadyCallback f7945e;

        /* renamed from: f  reason: collision with root package name */
        public CyberVRRenderProvider.INotSupportCallback f7946f;

        public a(CyberVRRenderProviderImpl cyberVRRenderProviderImpl) {
        }

        public void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.f7946f = iNotSupportCallback;
        }

        public void b(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.f7945e = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            CyberVRRenderProvider.INotSupportCallback iNotSupportCallback;
            CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback;
            if (method.getName().startsWith("onS") && (iOnSurfaceReadyCallback = this.f7945e) != null) {
                iOnSurfaceReadyCallback.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || (iNotSupportCallback = this.f7946f) == null) {
                return null;
            } else {
                iNotSupportCallback.onNotSupport(((Integer) objArr[0]).intValue());
                return null;
            }
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
        this.f7939c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.f7940d = d.b.w.a.a.a.a(cls, "init", SurfaceView.class);
        this.f7941e = d.b.w.a.a.a.a(cls, "init", TextureView.class);
        Class cls4 = Float.TYPE;
        this.f7942f = d.b.w.a.a.a.a(cls, "onTextureResize", cls4, cls4);
        this.f7943g = d.b.w.a.a.a.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.f7944h = d.b.w.a.a.a.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = d.b.w.a.a.a.a(cls, "switchProjectionMode", Integer.TYPE);
        this.j = d.b.w.a.a.a.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.f7938b = d.b.w.a.a.a.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.k = d.b.w.a.a.a.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = d.b.w.a.a.a.a(cls, "onOrientationChanged", new Class[0]);
        this.m = d.b.w.a.a.a.a(cls, "displayMode", Integer.TYPE);
        this.n = d.b.w.a.a.a.a(cls, "interactiveMode", Integer.TYPE);
        this.o = d.b.w.a.a.a.a(cls, "projectionMode", Integer.TYPE);
        this.p = d.b.w.a.a.a.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = d.b.w.a.a.a.a(cls, "asVideo", cls2);
        this.r = d.b.w.a.a.a.a(cls, "ifNotSupport", cls3);
        Class cls5 = Float.TYPE;
        this.s = d.b.w.a.a.a.a(cls, "setFov", cls5, cls5, cls5);
        this.f7937a = new a(this);
        this.t = Proxy.newProxyInstance(CyberVRRenderProviderImpl.class.getClassLoader(), new Class[]{cls2, cls3}, this.f7937a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.f7939c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.f7939c + ", mAsVideoMethod = " + this.q);
            return this;
        }
        this.f7937a.b(iOnSurfaceReadyCallback);
        try {
            this.q.invoke(this.f7939c, this.t);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl displayMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj != null && (method = this.m) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.f7939c + ", mDisplayModeMethod = " + this.m);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl ifNotSupport(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
        if (this.f7939c == null || this.r == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.f7939c + ", mIfNotSupportMethod = " + this.r);
            return this;
        }
        this.f7937a.a(iNotSupportCallback);
        try {
            this.r.invoke(this.f7939c, this.t);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(SurfaceView surfaceView) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7940d) == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f7939c + ", mInitMethod1 = " + this.f7940d);
            return;
        }
        try {
            method.invoke(obj, surfaceView);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(TextureView textureView) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7941e) == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f7939c + ", mInitMethod1 = " + this.f7941e);
            return;
        }
        try {
            method.invoke(obj, textureView);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl interactiveMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj != null && (method = this.n) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.f7939c + ", mInteractiveModeMethod = " + this.n);
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onDestroy() {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.k) == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.f7939c + ", mOnDestroyMethod = " + this.k);
            return;
        }
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onOrientationChanged() {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.l) == null) {
            CyberLog.e(TAG, "can not call onOrientationChanged method. mBdVRRender = " + this.f7939c + ", mOnOrientationChanged = " + this.l);
            return;
        }
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onPause() {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7938b) == null) {
            CyberLog.e(TAG, "can not call onPause method. mBdVRRender = " + this.f7939c + ", mOnPause = " + this.f7938b);
            return;
        }
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onResume() {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.j) == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.f7939c + ", mOnResume = " + this.j);
            return;
        }
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onTextureResize(float f2, float f3) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7942f) == null) {
            CyberLog.e(TAG, "can not call onTextureResize method. mBdVRRender = " + this.f7939c + ", mOnTextureResizeMethod = " + this.f7942f);
            return;
        }
        try {
            method.invoke(obj, Float.valueOf(f2), Float.valueOf(f3));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl pinchEnabled(boolean z) {
        Method method;
        Object obj = this.f7939c;
        if (obj != null && (method = this.p) != null) {
            try {
                method.invoke(obj, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.f7939c + ", mPinchEnabledMethod = " + this.p);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl projectionMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj != null && (method = this.o) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.f7939c + ", mProjectionModeMethod = " + this.o);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl setFov(float f2, float f3, float f4) {
        Method method;
        Object obj = this.f7939c;
        if (obj != null && (method = this.s) != null) {
            try {
                method.invoke(obj, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.f7939c + ", mSetFovMethod = " + this.s);
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchDisplayMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7944h) == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.f7939c + ", mSwitchDisplayModeMethod = " + this.f7944h);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchInteractiveMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.f7943g) == null) {
            CyberLog.e(TAG, "can not call switchInteractiveMode method. mBdVRRender = " + this.f7939c + ", mSwitchInteractiveModeMethod = " + this.f7943g);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchProjectionMode(int i) {
        Method method;
        Object obj = this.f7939c;
        if (obj == null || (method = this.i) == null) {
            CyberLog.e(TAG, "can not call switchProjectionMode method. mBdVRRender = " + this.f7939c + ", mSwitchProjectionMode = " + this.i);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
