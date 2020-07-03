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
/* loaded from: classes.dex */
public class CyberVRRenderProviderImpl extends CyberVRRenderProvider {
    public static final String TAG = "BDVRRenderDelegate";
    private Method b;
    private Method buA;
    private Method buB;
    private final a bus;
    private Method but;
    private Method buu;
    private Method buv;
    private Method buw;
    private Method bux;
    private Method buy;
    private Method buz;
    private final Object c;
    private Method d;
    private Method e;
    private Method f;
    private Method g;
    private Method i;
    private Method l;
    private Method q;
    private final Object t;

    /* loaded from: classes.dex */
    public class a implements InvocationHandler {
        private CyberVRRenderProvider.IOnSurfaceReadyCallback buC;
        private CyberVRRenderProvider.INotSupportCallback buD;

        public a() {
        }

        void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.buD = iNotSupportCallback;
        }

        void a(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.buC = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().startsWith("onS") && this.buC != null) {
                this.buC.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || this.buD == null) {
                return null;
            } else {
                this.buD.onNotSupport(((Integer) objArr[0]).intValue());
                return null;
            }
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
        this.c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.d = com.baidu.media.duplayer.a.c.a(cls, com.baidu.sapi2.outsdk.c.l, SurfaceView.class);
        this.e = com.baidu.media.duplayer.a.c.a(cls, com.baidu.sapi2.outsdk.c.l, TextureView.class);
        this.f = com.baidu.media.duplayer.a.c.a(cls, "onTextureResize", Float.TYPE, Float.TYPE);
        this.g = com.baidu.media.duplayer.a.c.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.but = com.baidu.media.duplayer.a.c.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = com.baidu.media.duplayer.a.c.a(cls, "switchProjectionMode", Integer.TYPE);
        this.buu = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.b = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.buv = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = com.baidu.media.duplayer.a.c.a(cls, "onOrientationChanged", new Class[0]);
        this.buw = com.baidu.media.duplayer.a.c.a(cls, "displayMode", Integer.TYPE);
        this.bux = com.baidu.media.duplayer.a.c.a(cls, "interactiveMode", Integer.TYPE);
        this.buy = com.baidu.media.duplayer.a.c.a(cls, "projectionMode", Integer.TYPE);
        this.buz = com.baidu.media.duplayer.a.c.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = com.baidu.media.duplayer.a.c.a(cls, "asVideo", cls2);
        this.buA = com.baidu.media.duplayer.a.c.a(cls, "ifNotSupport", cls3);
        this.buB = com.baidu.media.duplayer.a.c.a(cls, "setFov", Float.TYPE, Float.TYPE, Float.TYPE);
        this.bus = new a();
        this.t = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls2, cls3}, this.bus);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.c + ", mAsVideoMethod = " + this.q);
        } else {
            this.bus.a(iOnSurfaceReadyCallback);
            try {
                this.q.invoke(this.c, this.t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl displayMode(int i) {
        if (this.c == null || this.buw == null) {
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.c + ", mDisplayModeMethod = " + this.buw);
        } else {
            try {
                this.buw.invoke(this.c, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl ifNotSupport(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
        if (this.c == null || this.buA == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.c + ", mIfNotSupportMethod = " + this.buA);
        } else {
            this.bus.a(iNotSupportCallback);
            try {
                this.buA.invoke(this.c, this.t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(SurfaceView surfaceView) {
        if (this.c == null || this.d == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.c + ", mInitMethod1 = " + this.d);
            return;
        }
        try {
            this.d.invoke(this.c, surfaceView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(TextureView textureView) {
        if (this.c == null || this.e == null) {
            CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.c + ", mInitMethod1 = " + this.e);
            return;
        }
        try {
            this.e.invoke(this.c, textureView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl interactiveMode(int i) {
        if (this.c == null || this.bux == null) {
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.c + ", mInteractiveModeMethod = " + this.bux);
        } else {
            try {
                this.bux.invoke(this.c, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onDestroy() {
        if (this.c == null || this.buv == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.c + ", mOnDestroyMethod = " + this.buv);
            return;
        }
        try {
            this.buv.invoke(this.c, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onOrientationChanged() {
        if (this.c == null || this.l == null) {
            CyberLog.e(TAG, "can not call onOrientationChanged method. mBdVRRender = " + this.c + ", mOnOrientationChanged = " + this.l);
            return;
        }
        try {
            this.l.invoke(this.c, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onPause() {
        if (this.c == null || this.b == null) {
            CyberLog.e(TAG, "can not call onPause method. mBdVRRender = " + this.c + ", mOnPause = " + this.b);
            return;
        }
        try {
            this.b.invoke(this.c, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onResume() {
        if (this.c == null || this.buu == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.c + ", mOnResume = " + this.buu);
            return;
        }
        try {
            this.buu.invoke(this.c, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onTextureResize(float f, float f2) {
        if (this.c == null || this.f == null) {
            CyberLog.e(TAG, "can not call onTextureResize method. mBdVRRender = " + this.c + ", mOnTextureResizeMethod = " + this.f);
            return;
        }
        try {
            this.f.invoke(this.c, Float.valueOf(f), Float.valueOf(f2));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl pinchEnabled(boolean z) {
        if (this.c == null || this.buz == null) {
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.c + ", mPinchEnabledMethod = " + this.buz);
        } else {
            try {
                this.buz.invoke(this.c, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl projectionMode(int i) {
        if (this.c == null || this.buy == null) {
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.c + ", mProjectionModeMethod = " + this.buy);
        } else {
            try {
                this.buy.invoke(this.c, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl setFov(float f, float f2, float f3) {
        if (this.c == null || this.buB == null) {
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.c + ", mSetFovMethod = " + this.buB);
        } else {
            try {
                this.buB.invoke(this.c, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchDisplayMode(int i) {
        if (this.c == null || this.but == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.c + ", mSwitchDisplayModeMethod = " + this.but);
            return;
        }
        try {
            this.but.invoke(this.c, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchInteractiveMode(int i) {
        if (this.c == null || this.g == null) {
            CyberLog.e(TAG, "can not call switchInteractiveMode method. mBdVRRender = " + this.c + ", mSwitchInteractiveModeMethod = " + this.g);
            return;
        }
        try {
            this.g.invoke(this.c, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchProjectionMode(int i) {
        if (this.c == null || this.i == null) {
            CyberLog.e(TAG, "can not call switchProjectionMode method. mBdVRRender = " + this.c + ", mSwitchProjectionMode = " + this.i);
            return;
        }
        try {
            this.i.invoke(this.c, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }
}
