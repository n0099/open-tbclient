package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a sB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.sB = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aw = h.ir().aw(message.getCmd());
        if (TextUtils.isEmpty(aw) || h.ir().bq(aw)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(aw)) {
            if (PluginCenter.getInstance().isLoaded(aw)) {
                return false;
            }
            this.sB.a(aw, message);
            return true;
        }
        this.sB.a(aw, message);
        return PluginCenter.getInstance().launch(aw);
    }
}
