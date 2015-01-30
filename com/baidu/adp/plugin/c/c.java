package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a sE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.sE = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String aw = h.iy().aw(message.getCmd());
        if (TextUtils.isEmpty(aw) || h.iy().bt(aw)) {
            return false;
        }
        if (PluginCenter.gW().aQ(aw)) {
            if (PluginCenter.gW().aR(aw)) {
                return false;
            }
            this.sE.a(aw, message);
            return true;
        }
        this.sE.a(aw, message);
        return PluginCenter.gW().aP(aw);
    }
}
