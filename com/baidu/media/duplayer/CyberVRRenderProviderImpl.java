package com.baidu.media.duplayer;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
/* loaded from: classes16.dex */
public class CyberVRRenderProviderImpl extends CyberVRRenderProvider {
    public static final String TAG = "BDVRRenderDelegate";
    private Method b;
    private Method bKA;
    private Method bKB;
    private Method bKC;
    private Method bKD;
    private final a bKu;
    private Method bKv;
    private Method bKw;
    private Method bKx;
    private Method bKy;
    private Method bKz;
    private final Object c;
    private Method d;
    private Method e;
    private Method f;
    private Method g;
    private Method i;
    private Method l;
    private Method q;
    private final Object t;

    /* loaded from: classes16.dex */
    public class a implements InvocationHandler {
        private CyberVRRenderProvider.IOnSurfaceReadyCallback bKE;
        private CyberVRRenderProvider.INotSupportCallback bKF;

        public a() {
        }

        void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.bKF = iNotSupportCallback;
        }

        void a(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.bKE = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().startsWith("onS") && this.bKE != null) {
                this.bKE.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || this.bKF == null) {
                return null;
            } else {
                this.bKF.onNotSupport(((Integer) objArr[0]).intValue());
                return null;
            }
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
        this.c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.d = com.baidu.media.duplayer.a.a.a(cls, OneKeyLoginSdkCall.l, SurfaceView.class);
        this.e = com.baidu.media.duplayer.a.a.a(cls, OneKeyLoginSdkCall.l, TextureView.class);
        this.f = com.baidu.media.duplayer.a.a.a(cls, "onTextureResize", Float.TYPE, Float.TYPE);
        this.g = com.baidu.media.duplayer.a.a.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.bKv = com.baidu.media.duplayer.a.a.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = com.baidu.media.duplayer.a.a.a(cls, "switchProjectionMode", Integer.TYPE);
        this.bKw = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.b = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.bKx = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = com.baidu.media.duplayer.a.a.a(cls, "onOrientationChanged", new Class[0]);
        this.bKy = com.baidu.media.duplayer.a.a.a(cls, "displayMode", Integer.TYPE);
        this.bKz = com.baidu.media.duplayer.a.a.a(cls, "interactiveMode", Integer.TYPE);
        this.bKA = com.baidu.media.duplayer.a.a.a(cls, "projectionMode", Integer.TYPE);
        this.bKB = com.baidu.media.duplayer.a.a.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = com.baidu.media.duplayer.a.a.a(cls, "asVideo", cls2);
        this.bKC = com.baidu.media.duplayer.a.a.a(cls, "ifNotSupport", cls3);
        this.bKD = com.baidu.media.duplayer.a.a.a(cls, "setFov", Float.TYPE, Float.TYPE, Float.TYPE);
        this.bKu = new a();
        this.t = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls2, cls3}, this.bKu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.c + ", mAsVideoMethod = " + this.q);
        } else {
            this.bKu.a(iOnSurfaceReadyCallback);
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
        if (this.c == null || this.bKy == null) {
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.c + ", mDisplayModeMethod = " + this.bKy);
        } else {
            try {
                this.bKy.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bKC == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.c + ", mIfNotSupportMethod = " + this.bKC);
        } else {
            this.bKu.a(iNotSupportCallback);
            try {
                this.bKC.invoke(this.c, this.t);
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
        if (this.c == null || this.bKz == null) {
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.c + ", mInteractiveModeMethod = " + this.bKz);
        } else {
            try {
                this.bKz.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bKx == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.c + ", mOnDestroyMethod = " + this.bKx);
            return;
        }
        try {
            this.bKx.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bKw == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.c + ", mOnResume = " + this.bKw);
            return;
        }
        try {
            this.bKw.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bKB == null) {
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.c + ", mPinchEnabledMethod = " + this.bKB);
        } else {
            try {
                this.bKB.invoke(this.c, Boolean.valueOf(z));
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
        if (this.c == null || this.bKA == null) {
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.c + ", mProjectionModeMethod = " + this.bKA);
        } else {
            try {
                this.bKA.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bKD == null) {
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.c + ", mSetFovMethod = " + this.bKD);
        } else {
            try {
                this.bKD.invoke(this.c, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
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
        if (this.c == null || this.bKv == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.c + ", mSwitchDisplayModeMethod = " + this.bKv);
            return;
        }
        try {
            this.bKv.invoke(this.c, Integer.valueOf(i));
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
