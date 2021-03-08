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
    private b cnB;
    private String cnC;
    private HashMap<String, Object> cnD;
    private Runnable cnF;
    private String identifier;
    private boolean cnE = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0276a cnG = null;
    private boolean cnH = false;
    private long cnI = 0;

    /* loaded from: classes14.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.cnB == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cnE = l.isNetOk();
        if (this.timeout >= 10) {
            e.mA().postDelayed(acQ(), this.timeout * 1000);
        }
        if (!this.cnE) {
            e.mA().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ag(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.cnG == null) {
            this.cnG = new C0276a(this);
            this.cnG.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.cnG != null) {
            this.cnG.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String acL() {
        return this.cnC;
    }

    public void jp(String str) {
        this.cnC = str;
    }

    public HashMap<String, Object> acM() {
        return this.cnD;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.cnD = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acN() {
        this.cnG = null;
    }

    public void ek(boolean z) {
        this.cnH = z;
    }

    public boolean acO() {
        return this.cnH;
    }

    public long acP() {
        return this.cnI;
    }

    public void bN(long j) {
        this.cnI = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0276a extends BdAsyncTask<Object, String, String> {
        private a cnK;
        private com.baidu.tbadk.core.util.b.a cnL;
        private aa cnM = null;
        private boolean isCancle = false;
        private long cnN = 0;

        public C0276a(a aVar) {
            this.cnK = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.cnN = System.currentTimeMillis() - this.cnK.acP();
            this.cnK.isLoading = true;
            this.cnM = new aa(this.cnK.acL());
            HashMap<String, Object> acM = this.cnK.acM();
            if (acM != null && !acM.isEmpty()) {
                for (Map.Entry<String, Object> entry : acM.entrySet()) {
                    this.cnM.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.cnK.acO() && acM != null) {
                this.cnM.addPostData("debugfile", (byte[]) acM.get("debugfile"));
                postNetData = this.cnM.postMultiNetData();
            } else {
                postNetData = this.cnM.postNetData();
            }
            this.cnL = this.cnM.bsu();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            if (this.cnK.cnB != null) {
                this.cnK.cnB.a(null, null, -1, "cancle", "", this.cnK.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.cnK.isLoading = false;
                if (this.cnK.cnF != null) {
                    e.mA().removeCallbacks(this.cnK.cnF);
                }
                if (this.cnL != null && this.cnL.bte() != null && !this.isCancle && this.cnK.cnB != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.cnK.acL());
                    hashMap.put("api", this.cnK.acL());
                    hashMap.put("state", this.cnL.btf().fdp.exception);
                    if (this.cnL.btg() != null && this.cnK.acP() > 0 && this.cnL.btg().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.cnL.btg().get("startTime"), 0L) - this.cnK.acP();
                        if (j > 0) {
                            this.cnL.btg().put("taskWaitTime", String.valueOf(j));
                        }
                        if (this.cnN < 20000) {
                            this.cnL.btg().put("queneTime", String.valueOf(this.cnN));
                        }
                    }
                    this.cnK.cnB.a(hashMap, this.cnL.btg(), this.cnL.bte().mServerErrorCode, this.cnL.bte().mErrorString, strArr[0], this.cnK.identifier);
                }
                this.cnK.acN();
            }
        }
    }

    public Runnable acQ() {
        if (this.cnF == null) {
            this.cnF = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ag(-1, "请求超时");
                }
            };
        }
        return this.cnF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, String str) {
        if (this.cnB != null) {
            this.cnB.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.cnB = bVar;
    }
}
