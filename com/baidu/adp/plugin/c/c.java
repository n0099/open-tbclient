package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d<Message<?>> {
    final /* synthetic */ a sv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.sv = aVar;
    }

    @Override // com.baidu.adp.framework.listener.d
    public boolean a(Message<?> message) {
        if (message == null) {
            return false;
        }
        String ar = h.iy().ar(message.getCmd());
        if (TextUtils.isEmpty(ar) || h.iy().bt(ar)) {
            return false;
        }
        if (PluginCenter.gX().aQ(ar)) {
            if (PluginCenter.gX().aR(ar)) {
                return false;
            }
            this.sv.a(ar, message);
            return true;
        }
        this.sv.a(ar, message);
        return PluginCenter.gX().aP(ar);
    }
}
