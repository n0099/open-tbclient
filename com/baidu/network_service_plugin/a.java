package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class a implements b.a {
    private b bFQ;
    private String bFR;
    private HashMap<String, Object> bFS;
    private Runnable bFU;
    private String identifier;
    private boolean bFT = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0227a bFV = null;
    private boolean bFW = false;
    private long bFX = 0;

    /* loaded from: classes18.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.bFQ == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bFT = l.isNetOk();
        if (this.timeout >= 10) {
            e.mX().postDelayed(Ui(), this.timeout * 1000);
        }
        if (!this.bFT) {
            e.mX().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bFV == null) {
            this.bFV = new C0227a(this);
            this.bFV.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bFV != null) {
            this.bFV.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Ud() {
        return this.bFR;
    }

    public void ik(String str) {
        this.bFR = str;
    }

    public HashMap<String, Object> Ue() {
        return this.bFS;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bFS = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        this.bFV = null;
    }

    public void dd(boolean z) {
        this.bFW = z;
    }

    public boolean Ug() {
        return this.bFW;
    }

    public long Uh() {
        return this.bFX;
    }

    public void aK(long j) {
        this.bFX = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0227a extends BdAsyncTask<Object, String, String> {
        private a bFZ;
        private com.baidu.tbadk.core.util.a.a bGa;
        private aa bGb = null;
        private boolean isCancle = false;
        private long bGc = 0;

        public C0227a(a aVar) {
            this.bFZ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bGc = System.currentTimeMillis() - this.bFZ.Uh();
            this.bFZ.isLoading = true;
            this.bGb = new aa(this.bFZ.Ud());
            HashMap<String, Object> Ue = this.bFZ.Ue();
            if (Ue != null && !Ue.isEmpty()) {
                for (Map.Entry<String, Object> entry : Ue.entrySet()) {
                    this.bGb.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bFZ.Ug()) {
                postNetData = this.bGb.postMultiNetData();
            } else {
                postNetData = this.bGb.postNetData();
            }
            this.bGa = this.bGb.bjL();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            if (this.bFZ.bFQ != null) {
                this.bFZ.bFQ.a(null, null, -1, "cancle", "", this.bFZ.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bFZ.isLoading = false;
                if (this.bFZ.bFU != null) {
                    e.mX().removeCallbacks(this.bFZ.bFU);
                }
                if (this.bGa != null && this.bGa.bkr() != null && !this.isCancle && this.bFZ.bFQ != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bFZ.Ud());
                    hashMap.put("api", this.bFZ.Ud());
                    hashMap.put("state", this.bGa.bks().enS.exception);
                    if (this.bGa.bkt() != null && this.bFZ.Uh() > 0 && this.bGa.bkt().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bGa.bkt().get("startTime"), 0L) - this.bFZ.Uh();
                        if (j > 0) {
                            this.bGa.bkt().put("taskWaitTime", String.valueOf(j));
                        }
                        if (this.bGc < 20000) {
                            this.bGa.bkt().put("queneTime", String.valueOf(this.bGc));
                        }
                    }
                    this.bFZ.bFQ.a(hashMap, this.bGa.bkt(), this.bGa.bkr().mServerErrorCode, this.bGa.bkr().mErrorString, strArr[0], this.bFZ.identifier);
                }
                this.bFZ.Uf();
            }
        }
    }

    public Runnable Ui() {
        if (this.bFU == null) {
            this.bFU = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "请求超时");
                }
            };
        }
        return this.bFU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.bFQ != null) {
            this.bFQ.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bFQ = bVar;
    }
}
