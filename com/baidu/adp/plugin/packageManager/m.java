package com.baidu.adp.plugin.packageManager;

import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        Object d = com.baidu.adp.lib.a.a.a.d(Looper.getMainLooper(), "sThreadLocal");
        if (d instanceof ThreadLocal) {
            ((ThreadLocal) d).set(Looper.getMainLooper());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            com.baidu.adp.plugin.b.a.io().bh("plugin_asyncinit_fail");
            com.baidu.adp.lib.h.h.eG().post(new n(this));
            return null;
        }
        this.this$0.iH();
        return null;
    }
}
