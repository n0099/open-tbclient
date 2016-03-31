package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a DX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.DX = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String az = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().az(message.getCmd());
        if (TextUtils.isEmpty(az) || com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bH(az)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(az)) {
            if (PluginCenter.getInstance().isLoaded(az)) {
                return false;
            }
            this.DX.a(az, message);
            return true;
        }
        this.DX.a(az, message);
        return PluginCenter.getInstance().launch(az).CK;
    }
}
