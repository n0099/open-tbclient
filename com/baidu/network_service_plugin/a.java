package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes16.dex */
public class a implements b.a {
    private b bUX;
    private String bUY;
    private HashMap<String, Object> bUZ;
    private Runnable bVb;
    private String identifier;
    private boolean bVa = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0256a bVc = null;
    private boolean bVd = false;
    private long bVe = 0;

    /* loaded from: classes16.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bVe = System.currentTimeMillis();
        if (this.bUX == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bVa = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(XX(), this.timeout * 1000);
        }
        if (!this.bVa) {
            e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.V(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bVc == null) {
            this.bVc = new C0256a(this);
            this.bVc.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bVc != null) {
            this.bVc.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String XS() {
        return this.bUY;
    }

    public void je(String str) {
        this.bUY = str;
    }

    public HashMap<String, Object> XT() {
        return this.bUZ;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bUZ = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XU() {
        this.bVc = null;
    }

    public void dy(boolean z) {
        this.bVd = z;
    }

    public boolean XV() {
        return this.bVd;
    }

    public long XW() {
        return this.bVe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0256a extends BdAsyncTask<Object, String, String> {
        private a bVg;
        private com.baidu.tbadk.core.util.a.a bVh;
        private aa bVi = null;
        private boolean isCancle = false;

        public C0256a(a aVar) {
            this.bVg = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bVg.isLoading = true;
            this.bVi = new aa(this.bVg.XS());
            HashMap<String, Object> XT = this.bVg.XT();
            if (XT != null && !XT.isEmpty()) {
                for (Map.Entry<String, Object> entry : XT.entrySet()) {
                    this.bVi.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bVg.XV() && XT != null) {
                this.bVi.addPostData("debugfile", (byte[]) XT.get("debugfile"));
                postNetData = this.bVi.postMultiNetData();
            } else {
                postNetData = this.bVi.postNetData();
            }
            this.bVh = this.bVi.bon();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            if (this.bVg.bUX != null) {
                this.bVg.bUX.a(null, null, -1, "cancle", "", this.bVg.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bVg.isLoading = false;
                if (this.bVg.bVb != null) {
                    e.mY().removeCallbacks(this.bVg.bVb);
                }
                if (this.bVh != null && this.bVh.boU() != null && !this.isCancle && this.bVg.bUX != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bVg.XS());
                    hashMap.put("api", this.bVg.XS());
                    hashMap.put("state", this.bVh.boV().eIB.exception);
                    if (this.bVh.boW() != null && this.bVg.XW() > 0 && this.bVh.boW().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bVh.boW().get("startTime"), 0L) - this.bVg.XW();
                        if (j > 0) {
                            this.bVh.boW().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bVg.bUX.a(hashMap, this.bVh.boW(), this.bVh.boU().mServerErrorCode, this.bVh.boU().mErrorString, strArr[0], this.bVg.identifier);
                }
                this.bVg.XU();
            }
        }
    }

    public Runnable XX() {
        if (this.bVb == null) {
            this.bVb = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.V(-1, "请求超时");
                }
            };
        }
        return this.bVb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
        if (this.bUX != null) {
            this.bUX.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bUX = bVar;
    }
}
