package com.baidu.live.ag.a;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes4.dex */
public class b {
    private boolean bor;
    private com.baidu.live.ag.a.a bxR;
    private long mQuota;

    /* loaded from: classes4.dex */
    public interface a {
        void Sn();
    }

    public static b Sm() {
        return C0173b.bxU;
    }

    public void cO(boolean z) {
        this.bor = z;
        a(null);
    }

    public synchronized boolean K(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bor && this.mQuota > 0 && this.bxR != null) {
                z = this.bxR.a(this.mQuota, obj);
            }
        }
        return z;
    }

    public void release() {
        if (this.bxR != null) {
            this.bxR.release();
        }
        this.mQuota = 0L;
        this.bor = false;
    }

    private void a(final a aVar) {
        if (!this.bor || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.Sn();
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.ag.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(b.this.K(null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                super.onPostExecute((AnonymousClass1) bool);
                if (aVar != null) {
                    aVar.Sn();
                }
            }
        }.execute(new Void[0]);
    }

    private b() {
        this.bxR = new c();
    }

    /* renamed from: com.baidu.live.ag.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0173b {
        private static final b bxU = new b();
    }
}
