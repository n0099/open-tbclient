package com.baidu.sapi2.passhost.pluginsdk;

import android.util.Pair;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IPassPi {
    Pair<ArrayList<String>, ArrayList<String>> getCookies();

    void onCreate(PluginContext pluginContext);

    void onDestroy() throws Exception;

    void onInstall(PluginContext pluginContext, boolean z);

    void onUninstall();

    void setProperty(String str, Object obj);
}
