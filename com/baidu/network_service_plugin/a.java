package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements b.a {
    private HashMap<String, Object> cmA;
    private Runnable cmC;
    private b cmy;
    private String cmz;
    private String identifier;
    private boolean cmB = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0278a cmD = null;
    private boolean cmE = false;
    private long cmF = 0;

    /* loaded from: classes6.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.cmy == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cmB = l.isNetOk();
        if (this.timeout >= 10) {
            e.mB().postDelayed(aeS(), this.timeout * 1000);
        }
        if (!this.cmB) {
            e.mB().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ab(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.cmD == null) {
            this.cmD = new C0278a(this);
            this.cmD.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.cmD != null) {
            this.cmD.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String aeN() {
        return this.cmz;
    }

    public void jO(String str) {
        this.cmz = str;
    }

    public HashMap<String, Object> aeO() {
        return this.cmA;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.cmA = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeP() {
        this.cmD = null;
    }

    public void ee(boolean z) {
        this.cmE = z;
    }

    public boolean aeQ() {
        return this.cmE;
    }

    public long aeR() {
        return this.cmF;
    }

    public void bJ(long j) {
        this.cmF = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0278a extends BdAsyncTask<Object, String, String> {
        private a cmH;
        private com.baidu.tbadk.core.util.b.a cmI;
        private z cmJ = null;
        private boolean isCancle = false;
        private long cmK = 0;

        public C0278a(a aVar) {
            this.cmH = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.cmK = System.currentTimeMillis() - this.cmH.aeR();
            this.cmH.isLoading = true;
            this.cmJ = new z(this.cmH.aeN());
            HashMap<String, Object> aeO = this.cmH.aeO();
            if (aeO != null && !aeO.isEmpty()) {
                for (Map.Entry<String, Object> entry : aeO.entrySet()) {
                    this.cmJ.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.cmH.aeQ() && aeO != null) {
                this.cmJ.addPostData("debugfile", (byte[]) aeO.get("debugfile"));
                postNetData = this.cmJ.postMultiNetData();
            } else {
                postNetData = this.cmJ.postNetData();
            }
            this.cmI = this.cmJ.bvR();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            if (this.cmH.cmy != null) {
                this.cmH.cmy.a(null, null, -1, "cancle", "", this.cmH.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.cmH.isLoading = false;
                if (this.cmH.cmC != null) {
                    e.mB().removeCallbacks(this.cmH.cmC);
                }
                if (this.cmI != null && this.cmI.bwB() != null && !this.isCancle && this.cmH.cmy != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.cmH.aeN());
                    hashMap.put("api", this.cmH.aeN());
                    hashMap.put("state", this.cmI.bwC().fej.exception);
                    if (this.cmI.bwD() != null && this.cmH.aeR() > 0 && this.cmI.bwD().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.cmI.bwD().get("startTime"), 0L) - this.cmH.aeR();
                        if (j > 0) {
                            this.cmI.bwD().put("taskWaitTime", String.valueOf(j));
                        }
                        if (this.cmK < 20000) {
                            this.cmI.bwD().put("queneTime", String.valueOf(this.cmK));
                        }
                    }
                    this.cmH.cmy.a(hashMap, this.cmI.bwD(), this.cmI.bwB().mServerErrorCode, this.cmI.bwB().mErrorString, strArr[0], this.cmH.identifier);
                }
                this.cmH.aeP();
            }
        }
    }

    public Runnable aeS() {
        if (this.cmC == null) {
            this.cmC = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ab(-1, "请求超时");
                }
            };
        }
        return this.cmC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.cmy != null) {
            this.cmy.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.cmy = bVar;
    }
}
