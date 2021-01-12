package com.baidu.live.ah.a;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes10.dex */
public class b {
    private boolean bln;
    private com.baidu.live.ah.a.a bxR;
    private long mQuota;

    /* loaded from: classes10.dex */
    public interface a {
        void Pw();
    }

    public static b Pv() {
        return C0157b.bxU;
    }

    public void cN(boolean z) {
        if (this.bln != z) {
            this.bln = z;
            a(null);
        }
    }

    public synchronized boolean G(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bln && this.mQuota > 0) {
                try {
                    if (this.bxR != null) {
                        z = this.bxR.a(this.mQuota, obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    public void release() {
        if (this.bxR != null) {
            this.bxR.release();
        }
        this.bln = false;
    }

    private void a(final a aVar) {
        if (!this.bln || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.Pw();
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.ah.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(b.this.G(null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                super.onPostExecute((AnonymousClass1) bool);
                if (aVar != null) {
                    aVar.Pw();
                }
            }
        }.execute(new Void[0]);
    }

    private b() {
        this.bxR = new c();
    }

    /* renamed from: com.baidu.live.ah.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0157b {
        private static final b bxU = new b();
    }
}
