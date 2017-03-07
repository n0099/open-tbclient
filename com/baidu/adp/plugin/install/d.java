package com.baidu.adp.plugin.install;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Looper looper) {
        super(looper);
        this.this$0 = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        PluginInstallTask pluginInstallTask;
        PluginInstallTask pluginInstallTask2;
        Handler handler;
        Runnable runnable;
        pluginInstallTask = this.this$0.DK;
        if (pluginInstallTask != null && message != null) {
            try {
                String str = ((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).CY;
                pluginInstallTask2 = this.this$0.DK;
                if (TextUtils.equals(str, pluginInstallTask2.CY)) {
                    handler = c.pa;
                    runnable = this.this$0.DR;
                    handler.removeCallbacks(runnable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
