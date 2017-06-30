package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a DO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.DO = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aD = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().aD(message.getCmd());
        if (TextUtils.isEmpty(aD) || com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bv(aD)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aD)) {
            if (PluginCenter.getInstance().isLoaded(aD)) {
                return false;
            }
            this.DO.a(aD, message);
            return true;
        }
        this.DO.a(aD, message);
        return PluginCenter.getInstance().launch(aD).CB;
    }
}
