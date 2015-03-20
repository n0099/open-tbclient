package com.baidu.searchbox.plugin.api;

import android.content.Context;
import java.util.Set;
/* loaded from: classes.dex */
public interface IPluginInvoker {
    Set<String> getMethodList();

    void invoke(Context context, String str, String str2, String str3, InvokeCallback invokeCallback, InvokeListener[] invokeListenerArr);
}
