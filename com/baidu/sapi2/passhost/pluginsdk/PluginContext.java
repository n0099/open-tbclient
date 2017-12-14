package com.baidu.sapi2.passhost.pluginsdk;

import android.content.Context;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.IServiceCenter;
/* loaded from: classes.dex */
public class PluginContext implements IContext {
    private static final String TAG = "PluginContext";
    public Context mAppContext;
    public IServiceCenter mIServiceCenter;
    public String mPackageName;
    public int mPiId = -1;
    private AbsPassPi mPiInstance;
    public String mPiVer;
    public ClassLoader mPluginClassLoader;

    public PluginContext(String str, Context context, ClassLoader classLoader) {
        try {
            this.mAppContext = context;
            this.mPluginClassLoader = classLoader;
        } catch (Exception e) {
            Log.e(TAG, "PluginContext construct err: " + e.getMessage());
        }
    }

    public void setIServiceCenter(IServiceCenter iServiceCenter) {
        this.mIServiceCenter = iServiceCenter;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IContext
    public ClassLoader getClassLoader() {
        return this.mPluginClassLoader;
    }

    public void setPiInstance(AbsPassPi absPassPi) {
        this.mPiInstance = absPassPi;
        Log.i(TAG, "set pi(" + this.mPiId + ")'s instance");
    }

    public AbsPassPi getPiInstance() {
        Object[] objArr = new Object[1];
        objArr[0] = "get pi(" + this.mPiId + ")'s instance: " + (this.mPiInstance == null ? "null" : this.mPiInstance.getClass().getName());
        Log.i(TAG, objArr);
        return this.mPiInstance;
    }

    public void releaseInstance() {
        this.mPiInstance = null;
        Log.i(TAG, "release set pi(" + this.mPiId + ")'s instance");
    }
}
