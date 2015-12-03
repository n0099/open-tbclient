package com.baidu.adp.plugin.packageManager;

import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ m DY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.DY = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        PluginPackageManager pluginPackageManager;
        Object c = com.baidu.adp.lib.a.a.a.c(Looper.getMainLooper(), "sThreadLocal");
        if (c instanceof ThreadLocal) {
            ((ThreadLocal) c).set(Looper.getMainLooper());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            pluginPackageManager = this.DY.this$0;
            pluginPackageManager.lX();
            return null;
        }
        com.baidu.adp.plugin.b.a.lI().bl("plugin_asyncinit_fail");
        com.baidu.adp.lib.h.h.hj().post(new o(this));
        return null;
    }
}
