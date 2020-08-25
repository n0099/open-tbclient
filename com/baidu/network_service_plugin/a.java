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
    private b bDN;
    private String bDO;
    private HashMap<String, Object> bDP;
    private Runnable bDR;
    private String identifier;
    private boolean bDQ = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0229a bDS = null;
    private boolean bDT = false;
    private long bDU = 0;

    /* loaded from: classes14.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bDU = System.currentTimeMillis();
        if (this.bDN == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bDQ = l.isNetOk();
        if (this.timeout >= 10) {
            e.mS().postDelayed(Tz(), this.timeout * 1000);
        }
        if (!this.bDQ) {
            e.mS().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.H(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bDS == null) {
            this.bDS = new C0229a(this);
            this.bDS.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bDS != null) {
            this.bDS.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Tu() {
        return this.bDO;
    }

    public void hQ(String str) {
        this.bDO = str;
    }

    public HashMap<String, Object> Tv() {
        return this.bDP;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bDP = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tw() {
        this.bDS = null;
    }

    public void de(boolean z) {
        this.bDT = z;
    }

    public boolean Tx() {
        return this.bDT;
    }

    public long Ty() {
        return this.bDU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0229a extends BdAsyncTask<Object, String, String> {
        private a bDW;
        private com.baidu.tbadk.core.util.a.a bDX;
        private aa bDY = null;
        private boolean isCancle = false;

        public C0229a(a aVar) {
            this.bDW = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bDW.isLoading = true;
            this.bDY = new aa(this.bDW.Tu());
            HashMap<String, Object> Tv = this.bDW.Tv();
            if (Tv != null && !Tv.isEmpty()) {
                for (Map.Entry<String, Object> entry : Tv.entrySet()) {
                    this.bDY.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bDW.Tx()) {
                postNetData = this.bDY.postMultiNetData();
            } else {
                postNetData = this.bDY.postNetData();
            }
            this.bDX = this.bDY.biQ();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            if (this.bDW.bDN != null) {
                this.bDW.bDN.a(null, null, -1, "cancle", "", this.bDW.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bDW.isLoading = false;
                if (this.bDW.bDR != null) {
                    e.mS().removeCallbacks(this.bDW.bDR);
                }
                if (this.bDX != null && this.bDX.bjw() != null && !this.isCancle && this.bDW.bDN != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bDW.Tu());
                    hashMap.put("api", this.bDW.Tu());
                    hashMap.put("state", this.bDX.bjx().elw.exception);
                    if (this.bDX.bjy() != null && this.bDW.Ty() > 0 && this.bDX.bjy().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bDX.bjy().get("startTime"), 0L) - this.bDW.Ty();
                        if (j > 0) {
                            this.bDX.bjy().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bDW.bDN.a(hashMap, this.bDX.bjy(), this.bDX.bjw().mServerErrorCode, this.bDX.bjw().mErrorString, strArr[0], this.bDW.identifier);
                }
                this.bDW.Tw();
            }
        }
    }

    public Runnable Tz() {
        if (this.bDR == null) {
            this.bDR = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.H(-1, "请求超时");
                }
            };
        }
        return this.bDR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        if (this.bDN != null) {
            this.bDN.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bDN = bVar;
    }
}
