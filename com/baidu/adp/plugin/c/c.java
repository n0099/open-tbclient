package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a Dc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.Dc = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String au = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().au(message.getCmd());
        if (TextUtils.isEmpty(au) || com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().bC(au)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(au)) {
            if (PluginCenter.getInstance().isLoaded(au)) {
                return false;
            }
            this.Dc.a(au, message);
            return true;
        }
        this.Dc.a(au, message);
        return PluginCenter.getInstance().launch(au);
    }
}
