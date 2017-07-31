package com.baidu.tbadk.core.hybrid.cache;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class CacheControlService extends BdBaseService {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hybrid_release_assent" + TbConfig.getVersion(), true)) {
            new b().execute(new Void[0]);
        } else {
            new a().execute(new Void[0]);
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Void> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            com.baidu.tbadk.core.hybrid.cache.b.uq().ur();
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Void, Void, Void> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (com.baidu.tbadk.core.hybrid.cache.b.uq().us()) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hybrid_release_assent" + TbConfig.getVersion(), false);
                return null;
            }
            return null;
        }
    }
}
