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
        String an = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().an(message.getCmd());
        if (TextUtils.isEmpty(an) || com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().bA(an)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(an)) {
            if (PluginCenter.getInstance().isLoaded(an)) {
                return false;
            }
            this.up.a(an, message);
            return true;
        }
        this.up.a(an, message);
        return PluginCenter.getInstance().launch(an).sZ;
    }
}
