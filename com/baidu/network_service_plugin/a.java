package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class a implements b.a {
    private b bDQ;
    private String bDR;
    private HashMap<String, Object> bDS;
    private Runnable bDU;
    private String identifier;
    private boolean bDT = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0229a bDV = null;
    private boolean bDW = false;
    private long bDX = 0;

    /* loaded from: classes14.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bDX = System.currentTimeMillis();
        if (this.bDQ == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bDT = l.isNetOk();
        if (this.timeout >= 10) {
            e.mS().postDelayed(Tz(), this.timeout * 1000);
        }
        if (!this.bDT) {
            e.mS().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.H(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bDV == null) {
            this.bDV = new C0229a(this);
            this.bDV.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bDV != null) {
            this.bDV.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Tu() {
        return this.bDR;
    }

    public void hR(String str) {
        this.bDR = str;
    }

    public HashMap<String, Object> Tv() {
        return this.bDS;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bDS = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tw() {
        this.bDV = null;
    }

    public void df(boolean z) {
        this.bDW = z;
    }

    public boolean Tx() {
        return this.bDW;
    }

    public long Ty() {
        return this.bDX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0229a extends BdAsyncTask<Object, String, String> {
        private a bDZ;
        private com.baidu.tbadk.core.util.a.a bEa;
        private aa bEb = null;
        private boolean isCancle = false;

        public C0229a(a aVar) {
            this.bDZ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bDZ.isLoading = true;
            this.bEb = new aa(this.bDZ.Tu());
            HashMap<String, Object> Tv = this.bDZ.Tv();
            if (Tv != null && !Tv.isEmpty()) {
                for (Map.Entry<String, Object> entry : Tv.entrySet()) {
                    this.bEb.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bDZ.Tx()) {
                postNetData = this.bEb.postMultiNetData();
            } else {
                postNetData = this.bEb.postNetData();
            }
            this.bEa = this.bEb.biQ();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            if (this.bDZ.bDQ != null) {
                this.bDZ.bDQ.a(null, null, -1, "cancle", "", this.bDZ.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bDZ.isLoading = false;
                if (this.bDZ.bDU != null) {
                    e.mS().removeCallbacks(this.bDZ.bDU);
                }
                if (this.bEa != null && this.bEa.bjw() != null && !this.isCancle && this.bDZ.bDQ != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bDZ.Tu());
                    hashMap.put("api", this.bDZ.Tu());
                    hashMap.put("state", this.bEa.bjx().elA.exception);
                    if (this.bEa.bjy() != null && this.bDZ.Ty() > 0 && this.bEa.bjy().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bEa.bjy().get("startTime"), 0L) - this.bDZ.Ty();
                        if (j > 0) {
                            this.bEa.bjy().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bDZ.bDQ.a(hashMap, this.bEa.bjy(), this.bEa.bjw().mServerErrorCode, this.bEa.bjw().mErrorString, strArr[0], this.bDZ.identifier);
                }
                this.bDZ.Tw();
            }
        }
    }

    public Runnable Tz() {
        if (this.bDU == null) {
            this.bDU = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.H(-1, "请求超时");
                }
            };
        }
        return this.bDU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        if (this.bDQ != null) {
            this.bDQ.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bDQ = bVar;
    }
}
