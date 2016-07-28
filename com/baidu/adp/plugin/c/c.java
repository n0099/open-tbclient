package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a uT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.uT = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aq = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().aq(message.getCmd());
        if (TextUtils.isEmpty(aq) || com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().bB(aq)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aq)) {
            if (PluginCenter.getInstance().isLoaded(aq)) {
                return false;
            }
            this.uT.a(aq, message);
            return true;
        }
        this.uT.a(aq, message);
        return PluginCenter.getInstance().launch(aq).tF;
    }
}
