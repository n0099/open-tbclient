package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a up;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.up = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String am = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().am(message.getCmd());
        if (TextUtils.isEmpty(am) || com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().bA(am)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(am)) {
            if (PluginCenter.getInstance().isLoaded(am)) {
                return false;
            }
            this.up.a(am, message);
            return true;
        }
        this.up.a(am, message);
        return PluginCenter.getInstance().launch(am).sZ;
    }
}
