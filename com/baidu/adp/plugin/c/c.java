package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a wW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.wW = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aE = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().aE(message.getCmd());
        if (TextUtils.isEmpty(aE) || com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().bB(aE)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aE)) {
            if (PluginCenter.getInstance().isLoaded(aE)) {
                return false;
            }
            this.wW.a(aE, message);
            return true;
        }
        this.wW.a(aE, message);
        return PluginCenter.getInstance().launch(aE).vJ;
    }
}
