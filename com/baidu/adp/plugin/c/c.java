package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a Dg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.Dg = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String as = h.mi().as(message.getCmd());
        if (TextUtils.isEmpty(as) || h.mi().bI(as)) {
            return false;
        }
        if (PluginCenter.getInstance().hasInstance(as)) {
            if (PluginCenter.getInstance().isLoaded(as)) {
                return false;
            }
            this.Dg.a(as, message);
            return true;
        }
        this.Dg.a(as, message);
        return PluginCenter.getInstance().launch(as);
    }
}
