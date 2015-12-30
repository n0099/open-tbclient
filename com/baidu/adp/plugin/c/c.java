package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a DE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.DE = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String ao = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().ao(message.getCmd());
        if (TextUtils.isEmpty(ao) || com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bJ(ao)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(ao)) {
            if (PluginCenter.getInstance().isLoaded(ao)) {
                return false;
            }
            this.DE.a(ao, message);
            return true;
        }
        this.DE.a(ao, message);
        return PluginCenter.getInstance().launch(ao).Cv;
    }
}
