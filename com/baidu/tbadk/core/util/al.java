package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            NetWorkCore netWorkCore = (NetWorkCore) message.obj;
            if (netWorkCore != null) {
                netWorkCore.b();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
