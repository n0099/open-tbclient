package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a xf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.xf = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aE = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().aE(message.getCmd());
        if (TextUtils.isEmpty(aE) || com.baidu.adp.plugin.packageManager.pluginSettings.c.je().bC(aE)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aE)) {
            if (PluginCenter.getInstance().isLoaded(aE)) {
                return false;
            }
            this.xf.a(aE, message);
            return true;
        }
        this.xf.a(aE, message);
        return PluginCenter.getInstance().launch(aE).vS;
    }
}
