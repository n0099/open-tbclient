package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements b.a {
    private b bxQ;
    private String bxR;
    private HashMap<String, Object> bxS;
    private Runnable bxU;
    private String identifier;
    private boolean bxT = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0219a bxV = null;
    private boolean bxW = false;
    private long bxX = 0;

    /* loaded from: classes6.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bxX = System.currentTimeMillis();
        if (this.bxQ == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bxT = l.isNetOk();
        if (this.timeout >= 10) {
            e.lt().postDelayed(NA(), this.timeout * 1000);
        }
        if (!this.bxT) {
            e.lt().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bxV == null) {
            this.bxV = new C0219a(this);
            this.bxV.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bxV != null) {
            this.bxV.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Nv() {
        return this.bxR;
    }

    public void gx(String str) {
        this.bxR = str;
    }

    public HashMap<String, Object> Nw() {
        return this.bxS;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bxS = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nx() {
        this.bxV = null;
    }

    public void cU(boolean z) {
        this.bxW = z;
    }

    public boolean Ny() {
        return this.bxW;
    }

    public long Nz() {
        return this.bxX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0219a extends BdAsyncTask<Object, String, String> {
        private a bxZ;
        private com.baidu.tbadk.core.util.a.a bya;
        private y byb = null;
        private boolean byc = false;

        public C0219a(a aVar) {
            this.bxZ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bxZ.isLoading = true;
            this.byb = new y(this.bxZ.Nv());
            HashMap<String, Object> Nw = this.bxZ.Nw();
            if (Nw != null && !Nw.isEmpty()) {
                for (Map.Entry<String, Object> entry : Nw.entrySet()) {
                    this.byb.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bxZ.Ny()) {
                postNetData = this.byb.postMultiNetData();
            } else {
                postNetData = this.byb.postNetData();
            }
            this.bya = this.byb.aWu();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.byc = true;
            super.cancel(true);
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            if (this.bxZ.bxQ != null) {
                this.bxZ.bxQ.a(null, null, -1, "cancle", "", this.bxZ.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bxZ.isLoading = false;
                if (this.bxZ.bxU != null) {
                    e.lt().removeCallbacks(this.bxZ.bxU);
                }
                if (this.bya != null && this.bya.aWW() != null && !this.byc && this.bxZ.bxQ != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bxZ.Nv());
                    hashMap.put("api", this.bxZ.Nv());
                    hashMap.put("state", this.bya.aWX().dVs.exception);
                    if (this.bya.aWY() != null && this.bxZ.Nz() > 0 && this.bya.aWY().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bya.aWY().get("startTime"), 0L) - this.bxZ.Nz();
                        if (j > 0) {
                            this.bya.aWY().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bxZ.bxQ.a(hashMap, this.bya.aWY(), this.bya.aWW().mServerErrorCode, this.bya.aWW().mErrorString, strArr[0], this.bxZ.identifier);
                }
                this.bxZ.Nx();
            }
        }
    }

    public Runnable NA() {
        if (this.bxU == null) {
            this.bxU = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "请求超时");
                }
            };
        }
        return this.bxU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.bxQ != null) {
            this.bxQ.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bxQ = bVar;
    }
}
