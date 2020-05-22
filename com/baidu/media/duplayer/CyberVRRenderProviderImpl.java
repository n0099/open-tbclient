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
    private Method bpA;
    private final a bpr;
    private Method bps;
    private Method bpt;
    private Method bpu;
    private Method bpv;
    private Method bpw;
    private Method bpx;
    private Method bpy;
    private Method bpz;
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
        private CyberVRRenderProvider.IOnSurfaceReadyCallback bpB;
        private CyberVRRenderProvider.INotSupportCallback bpC;

        public a() {
        }

        void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.bpC = iNotSupportCallback;
        }

        void a(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.bpB = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().startsWith("onS") && this.bpB != null) {
                this.bpB.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || this.bpC == null) {
                return null;
            } else {
                this.bpC.onNotSupport(((Integer) objArr[0]).intValue());
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
        this.bps = com.baidu.media.duplayer.a.c.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = com.baidu.media.duplayer.a.c.a(cls, "switchProjectionMode", Integer.TYPE);
        this.bpt = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.b = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.bpu = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = com.baidu.media.duplayer.a.c.a(cls, "onOrientationChanged", new Class[0]);
        this.bpv = com.baidu.media.duplayer.a.c.a(cls, "displayMode", Integer.TYPE);
        this.bpw = com.baidu.media.duplayer.a.c.a(cls, "interactiveMode", Integer.TYPE);
        this.bpx = com.baidu.media.duplayer.a.c.a(cls, "projectionMode", Integer.TYPE);
        this.bpy = com.baidu.media.duplayer.a.c.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = com.baidu.media.duplayer.a.c.a(cls, "asVideo", cls2);
        this.bpz = com.baidu.media.duplayer.a.c.a(cls, "ifNotSupport", cls3);
        this.bpA = com.baidu.media.duplayer.a.c.a(cls, "setFov", Float.TYPE, Float.TYPE, Float.TYPE);
        this.bpr = new a();
        this.t = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls2, cls3}, this.bpr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.c + ", mAsVideoMethod = " + this.q);
        } else {
            this.bpr.a(iOnSurfaceReadyCallback);
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
        if (this.c == null || this.bpv == null) {
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.c + ", mDisplayModeMethod = " + this.bpv);
        } else {
            try {
                this.bpv.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bpz == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.c + ", mIfNotSupportMethod = " + this.bpz);
        } else {
            this.bpr.a(iNotSupportCallback);
            try {
                this.bpz.invoke(this.c, this.t);
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
        if (this.c == null || this.bpw == null) {
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.c + ", mInteractiveModeMethod = " + this.bpw);
        } else {
            try {
                this.bpw.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bpu == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.c + ", mOnDestroyMethod = " + this.bpu);
            return;
        }
        try {
            this.bpu.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bpt == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.c + ", mOnResume = " + this.bpt);
            return;
        }
        try {
            this.bpt.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bpy == null) {
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.c + ", mPinchEnabledMethod = " + this.bpy);
        } else {
            try {
                this.bpy.invoke(this.c, Boolean.valueOf(z));
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
        if (this.c == null || this.bpx == null) {
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.c + ", mProjectionModeMethod = " + this.bpx);
        } else {
            try {
                this.bpx.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bpA == null) {
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.c + ", mSetFovMethod = " + this.bpA);
        } else {
            try {
                this.bpA.invoke(this.c, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
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
        if (this.c == null || this.bps == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.c + ", mSwitchDisplayModeMethod = " + this.bps);
            return;
        }
        try {
            this.bps.invoke(this.c, Integer.valueOf(i));
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
