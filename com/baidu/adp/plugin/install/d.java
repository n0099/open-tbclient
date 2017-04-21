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
        pluginInstallTask = this.this$0.Do;
        if (pluginInstallTask != null && message != null) {
            try {
                String str = ((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).CC;
                pluginInstallTask2 = this.this$0.Do;
                if (TextUtils.equals(str, pluginInstallTask2.CC)) {
                    handler = c.oz;
                    runnable = this.this$0.Dv;
                    handler.removeCallbacks(runnable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
