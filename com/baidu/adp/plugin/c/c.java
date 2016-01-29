package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a DR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.DR = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aA = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().aA(message.getCmd());
        if (TextUtils.isEmpty(aA) || com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bJ(aA)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aA)) {
            if (PluginCenter.getInstance().isLoaded(aA)) {
                return false;
            }
            this.DR.a(aA, message);
            return true;
        }
        this.DR.a(aA, message);
        return PluginCenter.getInstance().launch(aA).CF;
    }
}
