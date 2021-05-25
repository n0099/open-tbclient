package com.baidu.smallgame.sdk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes2.dex */
public class MarioSDK {
    public static final String TAG = "MarioSDK";
    public AREngineDelegate mAREngineDelegate;
    public b mMarioInitListener;
    public V8Engine mV8Engine;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceHolder f10049a;

        /* renamed from: b  reason: collision with root package name */
        public GLSurfaceView.Renderer f10050b;

        /* renamed from: c  reason: collision with root package name */
        public ArBridge.FirstFrameListener f10051c;

        /* renamed from: d  reason: collision with root package name */
        public int f10052d;

        /* renamed from: e  reason: collision with root package name */
        public List<DebugConsole> f10053e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public Context f10054f;

        public void f(DebugConsole debugConsole) {
            if (debugConsole == null) {
                return;
            }
            this.f10053e.add(debugConsole);
        }

        public List<DebugConsole> g() {
            return this.f10053e;
        }

        public void h(Context context) {
            this.f10054f = context;
        }

        public void i(ArBridge.FirstFrameListener firstFrameListener) {
            this.f10051c = firstFrameListener;
        }

        public void j(GLSurfaceView.Renderer renderer) {
            this.f10050b = renderer;
        }

        public void k(SurfaceHolder surfaceHolder) {
            this.f10049a = surfaceHolder;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public MarioSDK(V8Engine v8Engine, AREngineDelegate aREngineDelegate) {
        this.mV8Engine = v8Engine;
        this.mAREngineDelegate = aREngineDelegate;
    }

    public static AREngineDelegate createAREngine(a aVar) {
        if (aVar == null) {
            return null;
        }
        d.a.g0.a.a aVar2 = new d.a.g0.a.a();
        if (aVar.f10049a != null) {
            aVar2.q(aVar.f10049a);
        }
        if (aVar.f10051c != null) {
            aVar2.setFirstFrameListener(aVar.f10051c);
        }
        aVar2.setRenderMode(aVar.f10052d);
        if (aVar.f10054f != null) {
            aVar2.p(aVar.f10054f);
        }
        if (aVar.f10050b != null) {
            aVar2.setRenderer(aVar.f10050b);
        }
        if (aVar.g() != null) {
            for (DebugConsole debugConsole : aVar.g()) {
                aVar2.addDebugConsole(debugConsole);
            }
        }
        return aVar2;
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
        }
        return v8Engine;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar) {
        return initialize(context, v8EngineConfiguration, aVar, null);
    }

    public AREngineDelegate getAREngineDelegate() {
        return this.mAREngineDelegate;
    }

    public V8Engine getV8Engine() {
        return this.mV8Engine;
    }

    public void reset() {
        resetAREngine();
        resetV8Engine();
    }

    public void resetAREngine() {
        this.mAREngineDelegate = null;
    }

    public void resetV8Engine() {
        this.mV8Engine = null;
    }

    public void setMarioInitListener(b bVar) {
        this.mMarioInitListener = bVar;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar, b bVar) {
        V8Engine v8Engine;
        AREngineDelegate aREngineDelegate = null;
        try {
            v8Engine = createV8Engine(context, v8EngineConfiguration);
        } catch (Exception e2) {
            Log.e(TAG, "v8Engine init error", e2);
            v8Engine = null;
        }
        try {
            aREngineDelegate = createAREngine(aVar);
        } catch (Exception e3) {
            Log.e(TAG, "AREngine init error", e3);
        }
        MarioSDK marioSDK = new MarioSDK(v8Engine, aREngineDelegate);
        if (bVar != null) {
            bVar.a();
        }
        return marioSDK;
    }
}
