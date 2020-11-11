package com.baidu.live.ac.a;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes4.dex */
public class b {
    private boolean bln;
    private com.baidu.live.ac.a.a but;
    private long mQuota;

    /* loaded from: classes4.dex */
    public interface a {
        void Qy();
    }

    public static b Qx() {
        return C0169b.buw;
    }

    public void cy(boolean z) {
        this.bln = z;
        a(null);
    }

    public synchronized boolean K(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bln && this.mQuota > 0 && this.but != null) {
                z = this.but.a(this.mQuota, obj);
            }
        }
        return z;
    }

    public void release() {
        if (this.but != null) {
            this.but.release();
        }
        this.mQuota = 0L;
        this.bln = false;
    }

    private void a(final a aVar) {
        if (!this.bln || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.Qy();
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
                    aVar.Qy();
                }
            }
        }.execute(new Void[0]);
    }

    private b() {
        this.but = new c();
    }

    /* renamed from: com.baidu.live.ac.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0169b {
        private static final b buw = new b();
    }
}
