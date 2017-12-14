package com.baidu.sapi2.passhost.pluginsdk;

import android.util.Pair;
import com.baidu.sapi2.base.debug.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsPassPi implements IPassPi {
    private static String TAG = "AbsPassPi";
    protected PluginContext mPiContext;
    public int mPiId = -1;

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public void onInstall(PluginContext pluginContext, boolean z) {
        this.mPiContext = pluginContext;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public void onCreate(PluginContext pluginContext) {
        this.mPiContext = pluginContext;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public final void setProperty(String str, Object obj) {
        if (CommonConst.PLUGIN_ID.equals(str)) {
            this.mPiId = ((Integer) obj).intValue();
        } else {
            this.mPiId = -1;
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public void onDestroy() throws Exception {
        Log.i(TAG, "plugin(" + this.mPiId + ") onDestroy");
        this.mPiContext = null;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public void onUninstall() {
        Log.i(TAG, "plugin(" + this.mPiId + ") onUninstall");
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.IPassPi
    public Pair<ArrayList<String>, ArrayList<String>> getCookies() {
        Log.i(TAG, "plugin(" + this.mPiId + ") getCookies");
        return null;
    }
}
