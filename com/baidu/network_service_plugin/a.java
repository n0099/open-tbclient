package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements b.a {
    private b bYW;
    private String bYX;
    private HashMap<String, Object> bYY;
    private Runnable bZa;
    private String identifier;
    private boolean bYZ = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0266a bZb = null;
    private boolean bZc = false;
    private long bZd = 0;

    /* loaded from: classes5.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bZd = System.currentTimeMillis();
        if (this.bYW == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bYZ = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(ZN(), this.timeout * 1000);
        }
        if (!this.bYZ) {
            e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bZb == null) {
            this.bZb = new C0266a(this);
            this.bZb.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bZb != null) {
            this.bZb.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String ZI() {
        return this.bYX;
    }

    public void jl(String str) {
        this.bYX = str;
    }

    public HashMap<String, Object> ZJ() {
        return this.bYY;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bYY = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZK() {
        this.bZb = null;
    }

    public void dH(boolean z) {
        this.bZc = z;
    }

    public boolean ZL() {
        return this.bZc;
    }

    public long ZM() {
        return this.bZd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0266a extends BdAsyncTask<Object, String, String> {
        private a bZf;
        private com.baidu.tbadk.core.util.a.a bZg;
        private aa bZh = null;
        private boolean isCancle = false;

        public C0266a(a aVar) {
            this.bZf = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bZf.isLoading = true;
            this.bZh = new aa(this.bZf.ZI());
            HashMap<String, Object> ZJ = this.bZf.ZJ();
            if (ZJ != null && !ZJ.isEmpty()) {
                for (Map.Entry<String, Object> entry : ZJ.entrySet()) {
                    this.bZh.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bZf.ZL() && ZJ != null) {
                this.bZh.addPostData("debugfile", (byte[]) ZJ.get("debugfile"));
                postNetData = this.bZh.postMultiNetData();
            } else {
                postNetData = this.bZh.postNetData();
            }
            this.bZg = this.bZh.bqa();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            if (this.bZf.bYW != null) {
                this.bZf.bYW.a(null, null, -1, "cancle", "", this.bZf.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bZf.isLoading = false;
                if (this.bZf.bZa != null) {
                    e.mY().removeCallbacks(this.bZf.bZa);
                }
                if (this.bZg != null && this.bZg.bqI() != null && !this.isCancle && this.bZf.bYW != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bZf.ZI());
                    hashMap.put("api", this.bZf.ZI());
                    hashMap.put("state", this.bZg.bqJ().eNu.exception);
                    if (this.bZg.bqK() != null && this.bZf.ZM() > 0 && this.bZg.bqK().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bZg.bqK().get("startTime"), 0L) - this.bZf.ZM();
                        if (j > 0) {
                            this.bZg.bqK().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bZf.bYW.a(hashMap, this.bZg.bqK(), this.bZg.bqI().mServerErrorCode, this.bZg.bqI().mErrorString, strArr[0], this.bZf.identifier);
                }
                this.bZf.ZK();
            }
        }
    }

    public Runnable ZN() {
        if (this.bZa == null) {
            this.bZa = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "请求超时");
                }
            };
        }
        return this.bZa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.bYW != null) {
            this.bYW.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bYW = bVar;
    }
}
