package com.baidu.live.ah.a;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.live.ah.a.a bCD;
    private boolean bqa;
    private long mQuota;

    /* loaded from: classes11.dex */
    public interface a {
        void Tr();
    }

    public static b Tq() {
        return C0166b.bCG;
    }

    public void cR(boolean z) {
        if (this.bqa != z) {
            this.bqa = z;
            a(null);
        }
    }

    public synchronized boolean G(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bqa && this.mQuota > 0) {
                try {
                    if (this.bCD != null) {
                        z = this.bCD.a(this.mQuota, obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    public void release() {
        if (this.bCD != null) {
            this.bCD.release();
        }
        this.bqa = false;
    }

    private void a(final a aVar) {
        if (!this.bqa || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.Tr();
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
                    aVar.Tr();
                }
            }
        }.execute(new Void[0]);
    }

    private b() {
        this.bCD = new c();
    }

    /* renamed from: com.baidu.live.ah.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0166b {
        private static final b bCG = new b();
    }
}
