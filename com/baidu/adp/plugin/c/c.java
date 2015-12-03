package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a Dm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.Dm = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String av = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().av(message.getCmd());
        if (TextUtils.isEmpty(av) || com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bG(av)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(av)) {
            if (PluginCenter.getInstance().isLoaded(av)) {
                return false;
            }
            this.Dm.a(av, message);
            return true;
        }
        this.Dm.a(av, message);
        return PluginCenter.getInstance().launch(av).Cq;
    }
}
