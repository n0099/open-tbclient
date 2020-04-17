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
    private final a bhO;
    private Method bhP;
    private Method bhQ;
    private Method bhR;
    private Method bhS;
    private Method bhT;
    private Method bhU;
    private Method bhV;
    private Method bhW;
    private Method bhX;
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
        private CyberVRRenderProvider.IOnSurfaceReadyCallback bhY;
        private CyberVRRenderProvider.INotSupportCallback bhZ;

        public a() {
        }

        void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            this.bhZ = iNotSupportCallback;
        }

        void a(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            this.bhY = iOnSurfaceReadyCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().startsWith("onS") && this.bhY != null) {
                this.bhY.onSurfaceReady((Surface) objArr[0]);
                return null;
            } else if (!method.getName().startsWith("onN") || this.bhZ == null) {
                return null;
            } else {
                this.bhZ.onNotSupport(((Integer) objArr[0]).intValue());
                return null;
            }
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
        this.c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.d = com.baidu.media.duplayer.a.c.a(cls, "init", SurfaceView.class);
        this.e = com.baidu.media.duplayer.a.c.a(cls, "init", TextureView.class);
        this.f = com.baidu.media.duplayer.a.c.a(cls, "onTextureResize", Float.TYPE, Float.TYPE);
        this.g = com.baidu.media.duplayer.a.c.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.bhP = com.baidu.media.duplayer.a.c.a(cls, "switchDisplayMode", Integer.TYPE);
        this.i = com.baidu.media.duplayer.a.c.a(cls, "switchProjectionMode", Integer.TYPE);
        this.bhQ = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_RESUME, new Class[0]);
        this.b = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.bhR = com.baidu.media.duplayer.a.c.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = com.baidu.media.duplayer.a.c.a(cls, "onOrientationChanged", new Class[0]);
        this.bhS = com.baidu.media.duplayer.a.c.a(cls, "displayMode", Integer.TYPE);
        this.bhT = com.baidu.media.duplayer.a.c.a(cls, "interactiveMode", Integer.TYPE);
        this.bhU = com.baidu.media.duplayer.a.c.a(cls, "projectionMode", Integer.TYPE);
        this.bhV = com.baidu.media.duplayer.a.c.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = com.baidu.media.duplayer.a.c.a(cls, "asVideo", cls2);
        this.bhW = com.baidu.media.duplayer.a.c.a(cls, "ifNotSupport", cls3);
        this.bhX = com.baidu.media.duplayer.a.c.a(cls, "setFov", Float.TYPE, Float.TYPE, Float.TYPE);
        this.bhO = new a();
        this.t = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls2, cls3}, this.bhO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        if (this.c == null || this.q == null) {
            CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.c + ", mAsVideoMethod = " + this.q);
        } else {
            this.bhO.a(iOnSurfaceReadyCallback);
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
        if (this.c == null || this.bhS == null) {
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.c + ", mDisplayModeMethod = " + this.bhS);
        } else {
            try {
                this.bhS.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bhW == null) {
            CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.c + ", mIfNotSupportMethod = " + this.bhW);
        } else {
            this.bhO.a(iNotSupportCallback);
            try {
                this.bhW.invoke(this.c, this.t);
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
        if (this.c == null || this.bhT == null) {
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.c + ", mInteractiveModeMethod = " + this.bhT);
        } else {
            try {
                this.bhT.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bhR == null) {
            CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.c + ", mOnDestroyMethod = " + this.bhR);
            return;
        }
        try {
            this.bhR.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bhQ == null) {
            CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.c + ", mOnResume = " + this.bhQ);
            return;
        }
        try {
            this.bhQ.invoke(this.c, new Object[0]);
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
        if (this.c == null || this.bhV == null) {
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.c + ", mPinchEnabledMethod = " + this.bhV);
        } else {
            try {
                this.bhV.invoke(this.c, Boolean.valueOf(z));
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
        if (this.c == null || this.bhU == null) {
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.c + ", mProjectionModeMethod = " + this.bhU);
        } else {
            try {
                this.bhU.invoke(this.c, Integer.valueOf(i));
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
        if (this.c == null || this.bhX == null) {
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.c + ", mSetFovMethod = " + this.bhX);
        } else {
            try {
                this.bhX.invoke(this.c, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
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
        if (this.c == null || this.bhP == null) {
            CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.c + ", mSwitchDisplayModeMethod = " + this.bhP);
            return;
        }
        try {
            this.bhP.invoke(this.c, Integer.valueOf(i));
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
