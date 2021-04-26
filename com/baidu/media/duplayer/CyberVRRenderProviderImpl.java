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
    public final a f8262a;

    /* renamed from: b  reason: collision with root package name */
    public Method f8263b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f8264c;

    /* renamed from: d  reason: collision with root package name */
    public Method f8265d;

    /* renamed from: e  reason: collision with root package name */
    public Method f8266e;

    /* renamed from: f  reason: collision with root package name */
    public Method f8267f;

    /* renamed from: g  reason: collision with root package name */
    public Method f8268g;

    /* renamed from: h  reason: collision with root package name */
    public Method f8269h;

    /* renamed from: i  reason: collision with root package name */
    public Method f8270i;
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
        public CyberVRRenderProvider.IOnSurfaceReadyCallback f8271e;

        /* renamed from: f  reason: collision with root package name */
        public CyberVRRenderProvider.INotSupportCallback f8272f;

        public a(CyberVRRenderProviderImpl cyberVRRenderProviderImpl) {
        }

        public void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.f8272f = iNotSupportCallback;
        }

        public void b(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.f8271e = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            CyberVRRenderProvider.INotSupportCallback iNotSupportCallback;
            CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback;
            if (method.getName().startsWith("onS") && (iOnSurfaceReadyCallback = this.f8271e) != null) {
                iOnSurfaceReadyCallback.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || (iNotSupportCallback = this.f8272f) == null) {
                return null;
            } else {
                iNotSupportCallback.onNotSupport(((Integer) objArr[0]).intValue());
                return null;
            }
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
        this.f8264c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.f8265d = d.a.w.a.a.a.a(cls, "init", SurfaceView.class);
        this.f8266e = d.a.w.a.a.a.a(cls, "init", TextureView.class);
        Class cls4 = Float.TYPE;
        this.f8267f = d.a.w.a.a.a.a(cls, "onTextureResize", cls4, cls4);
        this.f8268g = d.a.w.a.a.a.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.f8269h = d.a.w.a.a.a.a(cls, "switchDisplayMode", Integer.TYPE);
        this.f8270i = d.a.w.a.a.a.a(cls, "switchProjectionMode", Integer.TYPE);
        this.j = d.a.w.a.a.a.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.f8263b = d.a.w.a.a.a.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.k = d.a.w.a.a.a.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = d.a.w.a.a.a.a(cls, "onOrientationChanged", new Class[0]);
        this.m = d.a.w.a.a.a.a(cls, "displayMode", Integer.TYPE);
        this.n = d.a.w.a.a.a.a(cls, "interactiveMode", Integer.TYPE);
        this.o = d.a.w.a.a.a.a(cls, "projectionMode", Integer.TYPE);
        this.p = d.a.w.a.a.a.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = d.a.w.a.a.a.a(cls, "asVideo", cls2);
        this.r = d.a.w.a.a.a.a(cls, "ifNotSupport", cls3);
        Class cls5 = Float.TYPE;
        this.s = d.a.w.a.a.a.a(cls, "setFov", cls5, cls5, cls5);
        this.f8262a = new a(this);
        this.t = Proxy.newProxyInstance(CyberVRRenderProviderImpl.class.getClassLoader(), new Class[]{cls2, cls3}, this.f8262a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.f8264c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.f8264c + ", mAsVideoMethod = " + this.q);
            return this;
        }
        this.f8262a.b(iOnSurfaceReadyCallback);
        try {
            this.q.invoke(this.f8264c, this.t);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl displayMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj != null && (method = this.m) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.f8264c + ", mDisplayModeMethod = " + this.m);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl ifNotSupport(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
        if (this.f8264c == null || this.r == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.f8264c + ", mIfNotSupportMethod = " + this.r);
            return this;
        }
        this.f8262a.a(iNotSupportCallback);
        try {
            this.r.invoke(this.f8264c, this.t);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8265d) == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f8264c + ", mInitMethod1 = " + this.f8265d);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8266e) == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f8264c + ", mInitMethod1 = " + this.f8266e);
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
    public CyberVRRenderProviderImpl interactiveMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj != null && (method = this.n) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.f8264c + ", mInteractiveModeMethod = " + this.n);
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onDestroy() {
        Method method;
        Object obj = this.f8264c;
        if (obj == null || (method = this.k) == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.f8264c + ", mOnDestroyMethod = " + this.k);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.l) == null) {
            CyberLog.e(TAG, "can not call onOrientationChanged method. mBdVRRender = " + this.f8264c + ", mOnOrientationChanged = " + this.l);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8263b) == null) {
            CyberLog.e(TAG, "can not call onPause method. mBdVRRender = " + this.f8264c + ", mOnPause = " + this.f8263b);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.j) == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.f8264c + ", mOnResume = " + this.j);
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
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8267f) == null) {
            CyberLog.e(TAG, "can not call onTextureResize method. mBdVRRender = " + this.f8264c + ", mOnTextureResizeMethod = " + this.f8267f);
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
        Object obj = this.f8264c;
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
        CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.f8264c + ", mPinchEnabledMethod = " + this.p);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl projectionMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj != null && (method = this.o) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.f8264c + ", mProjectionModeMethod = " + this.o);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl setFov(float f2, float f3, float f4) {
        Method method;
        Object obj = this.f8264c;
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
        CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.f8264c + ", mSetFovMethod = " + this.s);
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchDisplayMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8269h) == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.f8264c + ", mSwitchDisplayModeMethod = " + this.f8269h);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchInteractiveMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8268g) == null) {
            CyberLog.e(TAG, "can not call switchInteractiveMode method. mBdVRRender = " + this.f8264c + ", mSwitchInteractiveModeMethod = " + this.f8268g);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchProjectionMode(int i2) {
        Method method;
        Object obj = this.f8264c;
        if (obj == null || (method = this.f8270i) == null) {
            CyberLog.e(TAG, "can not call switchProjectionMode method. mBdVRRender = " + this.f8264c + ", mSwitchProjectionMode = " + this.f8270i);
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
