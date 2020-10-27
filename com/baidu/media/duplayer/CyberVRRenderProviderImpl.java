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
    private final a bSQ;
    private Method bSR;
    private Method bSS;
    private Method bST;
    private Method bSU;
    private Method bSV;
    private Method bSW;
    private Method bSX;
    private Method bSY;
    private Method bSZ;
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
        private CyberVRRenderProvider.IOnSurfaceReadyCallback bTa;
        private CyberVRRenderProvider.INotSupportCallback bTb;

        public a() {
        }

        void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.bTb = iNotSupportCallback;
        }

        void a(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.bTa = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().startsWith("onS") && this.bTa != null) {
                this.bTa.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || this.bTb == null) {
                return null;
            } else {
                this.bTb.onNotSupport(((Integer) objArr[0]).intValue());
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
        this.bSR = com.baidu.media.duplayer.a.a.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = com.baidu.media.duplayer.a.a.a(cls, "switchProjectionMode", Integer.TYPE);
        this.bSS = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.b = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.bST = com.baidu.media.duplayer.a.a.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = com.baidu.media.duplayer.a.a.a(cls, "onOrientationChanged", new Class[0]);
        this.bSU = com.baidu.media.duplayer.a.a.a(cls, "displayMode", Integer.TYPE);
        this.bSV = com.baidu.media.duplayer.a.a.a(cls, "interactiveMode", Integer.TYPE);
        this.bSW = com.baidu.media.duplayer.a.a.a(cls, "projectionMode", Integer.TYPE);
        this.bSX = com.baidu.media.duplayer.a.a.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = com.baidu.media.duplayer.a.a.a(cls, "asVideo", cls2);
        this.bSY = com.baidu.media.duplayer.a.a.a(cls, "ifNotSupport", cls3);
        this.bSZ = com.baidu.media.duplayer.a.a.a(cls, "setFov", Float.TYPE, Float.TYPE, Float.TYPE);
        this.bSQ = new a();
        this.t = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls2, cls3}, this.bSQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.c + ", mAsVideoMethod = " + this.q);
        } else {
            this.bSQ.a(iOnSurfaceReadyCallback);
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
        if (this.c == null || this.bSU == null) {
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.c + ", mDisplayModeMethod = " + this.bSU);
        } else {
            try {
                this.bSU.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bSY == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.c + ", mIfNotSupportMethod = " + this.bSY);
        } else {
            this.bSQ.a(iNotSupportCallback);
            try {
                this.bSY.invoke(this.c, this.t);
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
        if (this.c == null || this.bSV == null) {
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.c + ", mInteractiveModeMethod = " + this.bSV);
        } else {
            try {
                this.bSV.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bST == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.c + ", mOnDestroyMethod = " + this.bST);
            return;
        }
        try {
            this.bST.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bSS == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.c + ", mOnResume = " + this.bSS);
            return;
        }
        try {
            this.bSS.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bSX == null) {
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.c + ", mPinchEnabledMethod = " + this.bSX);
        } else {
            try {
                this.bSX.invoke(this.c, Boolean.valueOf(z));
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
        if (this.c == null || this.bSW == null) {
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.c + ", mProjectionModeMethod = " + this.bSW);
        } else {
            try {
                this.bSW.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bSZ == null) {
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.c + ", mSetFovMethod = " + this.bSZ);
        } else {
            try {
                this.bSZ.invoke(this.c, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
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
        if (this.c == null || this.bSR == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.c + ", mSwitchDisplayModeMethod = " + this.bSR);
            return;
        }
        try {
            this.bSR.invoke(this.c, Integer.valueOf(i));
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
