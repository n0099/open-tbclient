package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements b.a {
    private b chK;
    private String chL;
    private HashMap<String, Object> chM;
    private Runnable chO;
    private String identifier;
    private boolean chN = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0266a chP = null;
    private boolean chQ = false;
    private long chR = 0;

    /* loaded from: classes5.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.chK == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.chN = l.isNetOk();
        if (this.timeout >= 10) {
            e.mB().postDelayed(aaZ(), this.timeout * 1000);
        }
        if (!this.chN) {
            e.mB().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ac(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.chP == null) {
            this.chP = new C0266a(this);
            this.chP.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.chP != null) {
            this.chP.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String aaU() {
        return this.chL;
    }

    public void iD(String str) {
        this.chL = str;
    }

    public HashMap<String, Object> aaV() {
        return this.chM;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.chM = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaW() {
        this.chP = null;
    }

    public void ea(boolean z) {
        this.chQ = z;
    }

    public boolean aaX() {
        return this.chQ;
    }

    public long aaY() {
        return this.chR;
    }

    public void bJ(long j) {
        this.chR = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0266a extends BdAsyncTask<Object, String, String> {
        private a chT;
        private com.baidu.tbadk.core.util.b.a chU;
        private z chV = null;
        private boolean isCancle = false;
        private long chW = 0;

        public C0266a(a aVar) {
            this.chT = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.chW = System.currentTimeMillis() - this.chT.aaY();
            this.chT.isLoading = true;
            this.chV = new z(this.chT.aaU());
            HashMap<String, Object> aaV = this.chT.aaV();
            if (aaV != null && !aaV.isEmpty()) {
                for (Map.Entry<String, Object> entry : aaV.entrySet()) {
                    this.chV.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.chT.aaX() && aaV != null) {
                this.chV.addPostData("debugfile", (byte[]) aaV.get("debugfile"));
                postNetData = this.chV.postMultiNetData();
            } else {
                postNetData = this.chV.postNetData();
            }
            this.chU = this.chV.brX();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            if (this.chT.chK != null) {
                this.chT.chK.a(null, null, -1, "cancle", "", this.chT.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.chT.isLoading = false;
                if (this.chT.chO != null) {
                    e.mB().removeCallbacks(this.chT.chO);
                }
                if (this.chU != null && this.chU.bsH() != null && !this.isCancle && this.chT.chK != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.chT.aaU());
                    hashMap.put("api", this.chT.aaU());
                    hashMap.put("state", this.chU.bsI().eZA.exception);
                    if (this.chU.bsJ() != null && this.chT.aaY() > 0 && this.chU.bsJ().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.chU.bsJ().get("startTime"), 0L) - this.chT.aaY();
                        if (j > 0) {
                            this.chU.bsJ().put("taskWaitTime", String.valueOf(j));
                        }
                        if (this.chW < 20000) {
                            this.chU.bsJ().put("queneTime", String.valueOf(this.chW));
                        }
                    }
                    this.chT.chK.a(hashMap, this.chU.bsJ(), this.chU.bsH().mServerErrorCode, this.chU.bsH().mErrorString, strArr[0], this.chT.identifier);
                }
                this.chT.aaW();
            }
        }
    }

    public Runnable aaZ() {
        if (this.chO == null) {
            this.chO = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ac(-1, "请求超时");
                }
            };
        }
        return this.chO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        if (this.chK != null) {
            this.chK.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.chK = bVar;
    }
}
