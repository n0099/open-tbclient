package com.baidu.smallgame.sdk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
@NotProguard
/* loaded from: classes2.dex */
public class MarioSDK {
    private static final String TAG = "MarioSDK";
    private AREngineDelegate mAREngineDelegate;
    private b mMarioInitListener;
    private V8Engine mV8Engine;

    /* loaded from: classes2.dex */
    public interface b {
        void AA();
    }

    public void setMarioInitListener(b bVar) {
        this.mMarioInitListener = bVar;
    }

    private MarioSDK(V8Engine v8Engine, AREngineDelegate aREngineDelegate) {
        this.mV8Engine = v8Engine;
        this.mAREngineDelegate = aREngineDelegate;
    }

    public V8Engine getV8Engine() {
        return this.mV8Engine;
    }

    public AREngineDelegate getAREngineDelegate() {
        return this.mAREngineDelegate;
    }

    public void resetV8Engine() {
        this.mV8Engine = null;
    }

    public void resetAREngine() {
        this.mAREngineDelegate = null;
    }

    public void reset() {
        resetAREngine();
        resetV8Engine();
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar) {
        return initialize(context, v8EngineConfiguration, aVar, null);
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar, b bVar) {
        V8Engine v8Engine;
        AREngineDelegate aREngineDelegate = null;
        try {
            v8Engine = createV8Engine(context, v8EngineConfiguration);
        } catch (Exception e) {
            Log.e(TAG, "v8Engine init error", e);
            v8Engine = null;
        }
        try {
            aREngineDelegate = createAREngine(aVar);
        } catch (Exception e2) {
            Log.e(TAG, "AREngine init error", e2);
        }
        MarioSDK marioSDK = new MarioSDK(v8Engine, aREngineDelegate);
        if (bVar != null) {
            bVar.AA();
        }
        return marioSDK;
    }

    public static V8Engine createV8Engine(Context context, V8EngineConfiguration v8EngineConfiguration) {
        if (v8EngineConfiguration == null) {
            return null;
        }
        V8Engine v8Engine = new V8Engine(context, v8EngineConfiguration.getBasePath(), v8EngineConfiguration.getJsPath(), v8EngineConfiguration.getV8ThreadDelegatePolicy(), v8EngineConfiguration.getMainGlobalObject(), v8EngineConfiguration.getOpenGlobalObject());
        if (v8EngineConfiguration.getUserAgent() != null) {
            v8Engine.setUserAgent(v8EngineConfiguration.getUserAgent());
        }
        if (v8EngineConfiguration.getDecodeBdFile() != null) {
            v8Engine.setBdFileRealPath(v8EngineConfiguration.getDecodeBdFile());
        }
        if (v8EngineConfiguration.getJavaScriptExceptionDelegate() != null) {
            v8Engine.setJavaScriptExceptionDelegate(v8EngineConfiguration.getJavaScriptExceptionDelegate());
        }
        if (v8EngineConfiguration.getFileSystemDelegatePolicy() != null) {
            v8Engine.setFileSystemDelegatePolicy(v8EngineConfiguration.getFileSystemDelegatePolicy());
        }
        if (v8EngineConfiguration.getV8EngineConsoles() != null) {
            for (V8Engine.V8EngineConsole v8EngineConsole : v8EngineConfiguration.getV8EngineConsoles()) {
                v8Engine.addV8EngineConsole(v8EngineConsole);
            }
        }
        if (v8EngineConfiguration.getV8StatusListeners() != null) {
            for (V8Engine.V8StatusListener v8StatusListener : v8EngineConfiguration.getV8StatusListeners()) {
                v8Engine.addStatusHandler(v8StatusListener);
            }
            return v8Engine;
        }
        return v8Engine;
    }

    public static AREngineDelegate createAREngine(a aVar) {
        if (aVar == null) {
            return null;
        }
        com.baidu.smallgame.sdk.a aVar2 = new com.baidu.smallgame.sdk.a();
        if (aVar.mSurfaceHolder != null) {
            aVar2.setSurfaceHolder(aVar.mSurfaceHolder);
        }
        if (aVar.mFirstFrameListener != null) {
            aVar2.setFirstFrameListener(aVar.mFirstFrameListener);
        }
        aVar2.setRenderMode(aVar.aDr);
        if (aVar.aCY == null) {
            return aVar2;
        }
        aVar2.setRenderer(aVar.aCY);
        return aVar2;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private GLSurfaceView.Renderer aCY;
        private int aDr;
        private ArBridge.FirstFrameListener mFirstFrameListener;
        private SurfaceHolder mSurfaceHolder;

        public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = surfaceHolder;
        }

        public void setRenderer(GLSurfaceView.Renderer renderer) {
            this.aCY = renderer;
        }

        public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
            this.mFirstFrameListener = firstFrameListener;
        }
    }
}
