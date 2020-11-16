package com.baidu.live.ac.a;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes4.dex */
public class b {
    private boolean bjC;
    private com.baidu.live.ac.a.a bsG;
    private long mQuota;

    /* loaded from: classes4.dex */
    public interface a {
        void PP();
    }

    public static b PO() {
        return C0167b.bsJ;
    }

    public void cA(boolean z) {
        this.bjC = z;
        a(null);
    }

    public synchronized boolean K(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bjC && this.mQuota > 0 && this.bsG != null) {
                z = this.bsG.a(this.mQuota, obj);
            }
        }
        return z;
    }

    public void release() {
        if (this.bsG != null) {
            this.bsG.release();
        }
        this.mQuota = 0L;
        this.bjC = false;
    }

    private void a(final a aVar) {
        if (!this.bjC || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.PP();
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.ac.a.b.1
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
                    aVar.PP();
                }
            }
        }.execute(new Void[0]);
    }

    private b() {
        this.bsG = new c();
    }

    /* renamed from: com.baidu.live.ac.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0167b {
        private static final b bsJ = new b();
    }
}
