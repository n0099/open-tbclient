package com.baidu.searchbox.v8engine;

import android.content.Context;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes3.dex */
public class V8EngineConfiguration {
    private String mBasePath;
    private Context mContext;
    private String mDecodeBdFile;
    private V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    private V8Engine.JavaScriptExceptionDelegate mJavaScriptExceptionDelegate;
    private String mJsPath;
    private Object mMainGlobalObject;
    private Object mOpenGlobalObject;
    private String mUserAgent;
    private List<V8Engine.V8EngineConsole> mV8EngineConsoles = new ArrayList();
    private List<V8Engine.V8StatusListener> mV8StatusListeners = new ArrayList();
    private V8ThreadDelegatePolicy mV8ThreadDelegatePolicy;

    /* loaded from: classes3.dex */
    public static class CodeCacheSetting {
        public String id;
        public int maxCount;
        public ArrayList<String> pathList;
        public int sizeLimit;
    }

    /* loaded from: classes3.dex */
    public interface JSCacheCallback {
        void onCacheResult(CacheInfo cacheInfo);
    }

    public String getBasePath() {
        return this.mBasePath;
    }

    public void setBasePath(String str) {
        this.mBasePath = str;
    }

    public String getJsPath() {
        return this.mJsPath;
    }

    public void setJsPath(String str) {
        this.mJsPath = str;
    }

    public V8ThreadDelegatePolicy getV8ThreadDelegatePolicy() {
        return this.mV8ThreadDelegatePolicy;
    }

    public void setV8ThreadDelegatePolicy(V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.mV8ThreadDelegatePolicy = v8ThreadDelegatePolicy;
    }

    public void addV8EngineConsole(V8Engine.V8EngineConsole v8EngineConsole) {
        if (v8EngineConsole != null) {
            this.mV8EngineConsoles.add(v8EngineConsole);
        }
    }

    public void addV8StatusListener(V8Engine.V8StatusListener v8StatusListener) {
        if (v8StatusListener != null) {
            this.mV8StatusListeners.add(v8StatusListener);
        }
    }

    public List<V8Engine.V8StatusListener> getV8StatusListeners() {
        return this.mV8StatusListeners;
    }

    public Object getMainGlobalObject() {
        return this.mMainGlobalObject;
    }

    public void setMainGlobalObject(Object obj) {
        this.mMainGlobalObject = obj;
    }

    public Object getOpenGlobalObject() {
        return this.mOpenGlobalObject;
    }

    public void setOpenGlobalObject(Object obj) {
        this.mOpenGlobalObject = obj;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public String getDecodeBdFile() {
        return this.mDecodeBdFile;
    }

    public void setDecodeBdFile(String str) {
        this.mDecodeBdFile = str;
    }

    public List<V8Engine.V8EngineConsole> getV8EngineConsoles() {
        return this.mV8EngineConsoles;
    }

    public void setV8EngineConsoles(List<V8Engine.V8EngineConsole> list) {
        this.mV8EngineConsoles = list;
    }

    public V8Engine.JavaScriptExceptionDelegate getJavaScriptExceptionDelegate() {
        return this.mJavaScriptExceptionDelegate;
    }

    public void setJavaScriptExceptionDelegate(V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mJavaScriptExceptionDelegate = javaScriptExceptionDelegate;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        return this.mFileSystemDelegatePolicy;
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mFileSystemDelegatePolicy = v8FileSystemDelegatePolicy;
    }

    /* loaded from: classes3.dex */
    public static class CacheInfo {
        public boolean cached;
        public String jsPath;

        public CacheInfo(String str, boolean z) {
            this.jsPath = str;
            this.cached = z;
        }
    }
}
