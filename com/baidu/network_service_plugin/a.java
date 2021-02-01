package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.a {
    private b clZ;
    private String cma;
    private HashMap<String, Object> cmb;
    private Runnable cme;
    private String identifier;
    private boolean cmc = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0270a cmf = null;
    private boolean cmg = false;
    private long cmh = 0;

    /* loaded from: classes4.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.clZ == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cmc = l.isNetOk();
        if (this.timeout >= 10) {
            e.mA().postDelayed(acN(), this.timeout * 1000);
        }
        if (!this.cmc) {
            e.mA().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ag(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.cmf == null) {
            this.cmf = new C0270a(this);
            this.cmf.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.cmf != null) {
            this.cmf.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String acI() {
        return this.cma;
    }

    public void jj(String str) {
        this.cma = str;
    }

    public HashMap<String, Object> acJ() {
        return this.cmb;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.cmb = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acK() {
        this.cmf = null;
    }

    public void ek(boolean z) {
        this.cmg = z;
    }

    public boolean acL() {
        return this.cmg;
    }

    public long acM() {
        return this.cmh;
    }

    public void bN(long j) {
        this.cmh = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0270a extends BdAsyncTask<Object, String, String> {
        private a cmj;
        private com.baidu.tbadk.core.util.b.a cmk;
        private aa cml = null;
        private boolean isCancle = false;
        private long cmm = 0;

        public C0270a(a aVar) {
            this.cmj = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.cmm = System.currentTimeMillis() - this.cmj.acM();
            this.cmj.isLoading = true;
            this.cml = new aa(this.cmj.acI());
            HashMap<String, Object> acJ = this.cmj.acJ();
            if (acJ != null && !acJ.isEmpty()) {
                for (Map.Entry<String, Object> entry : acJ.entrySet()) {
                    this.cml.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.cmj.acL() && acJ != null) {
                this.cml.addPostData("debugfile", (byte[]) acJ.get("debugfile"));
                postNetData = this.cml.postMultiNetData();
            } else {
                postNetData = this.cml.postNetData();
            }
            this.cmk = this.cml.bsr();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            if (this.cmj.clZ != null) {
                this.cmj.clZ.a(null, null, -1, "cancle", "", this.cmj.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.cmj.isLoading = false;
                if (this.cmj.cme != null) {
                    e.mA().removeCallbacks(this.cmj.cme);
                }
                if (this.cmk != null && this.cmk.btb() != null && !this.isCancle && this.cmj.clZ != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.cmj.acI());
                    hashMap.put("api", this.cmj.acI());
                    hashMap.put("state", this.cmk.btc().fbP.exception);
                    if (this.cmk.btd() != null && this.cmj.acM() > 0 && this.cmk.btd().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.cmk.btd().get("startTime"), 0L) - this.cmj.acM();
                        if (j > 0) {
                            this.cmk.btd().put("taskWaitTime", String.valueOf(j));
                        }
                        if (this.cmm < 20000) {
                            this.cmk.btd().put("queneTime", String.valueOf(this.cmm));
                        }
                    }
                    this.cmj.clZ.a(hashMap, this.cmk.btd(), this.cmk.btb().mServerErrorCode, this.cmk.btb().mErrorString, strArr[0], this.cmj.identifier);
                }
                this.cmj.acK();
            }
        }
    }

    public Runnable acN() {
        if (this.cme == null) {
            this.cme = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ag(-1, "请求超时");
                }
            };
        }
        return this.cme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, String str) {
        if (this.clZ != null) {
            this.clZ.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.clZ = bVar;
    }
}
