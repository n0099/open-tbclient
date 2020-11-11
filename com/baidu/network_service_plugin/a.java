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
    private b caH;
    private String caI;
    private HashMap<String, Object> caJ;
    private Runnable caL;
    private String identifier;
    private boolean caK = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0268a caM = null;
    private boolean caN = false;
    private long caO = 0;

    /* loaded from: classes16.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.caO = System.currentTimeMillis();
        if (this.caH == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.caK = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(aaw(), this.timeout * 1000);
        }
        if (!this.caK) {
            e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.caM == null) {
            this.caM = new C0268a(this);
            this.caM.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.caM != null) {
            this.caM.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String aar() {
        return this.caI;
    }

    public void jr(String str) {
        this.caI = str;
    }

    public HashMap<String, Object> aas() {
        return this.caJ;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.caJ = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aat() {
        this.caM = null;
    }

    public void dF(boolean z) {
        this.caN = z;
    }

    public boolean aau() {
        return this.caN;
    }

    public long aav() {
        return this.caO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0268a extends BdAsyncTask<Object, String, String> {
        private a caQ;
        private com.baidu.tbadk.core.util.a.a caR;
        private aa caS = null;
        private boolean isCancle = false;

        public C0268a(a aVar) {
            this.caQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.caQ.isLoading = true;
            this.caS = new aa(this.caQ.aar());
            HashMap<String, Object> aas = this.caQ.aas();
            if (aas != null && !aas.isEmpty()) {
                for (Map.Entry<String, Object> entry : aas.entrySet()) {
                    this.caS.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.caQ.aau() && aas != null) {
                this.caS.addPostData("debugfile", (byte[]) aas.get("debugfile"));
                postNetData = this.caS.postMultiNetData();
            } else {
                postNetData = this.caS.postNetData();
            }
            this.caR = this.caS.bqN();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            if (this.caQ.caH != null) {
                this.caQ.caH.a(null, null, -1, "cancle", "", this.caQ.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.caQ.isLoading = false;
                if (this.caQ.caL != null) {
                    e.mY().removeCallbacks(this.caQ.caL);
                }
                if (this.caR != null && this.caR.bru() != null && !this.isCancle && this.caQ.caH != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.caQ.aar());
                    hashMap.put("api", this.caQ.aar());
                    hashMap.put("state", this.caR.brv().eOq.exception);
                    if (this.caR.brw() != null && this.caQ.aav() > 0 && this.caR.brw().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.caR.brw().get("startTime"), 0L) - this.caQ.aav();
                        if (j > 0) {
                            this.caR.brw().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.caQ.caH.a(hashMap, this.caR.brw(), this.caR.bru().mServerErrorCode, this.caR.bru().mErrorString, strArr[0], this.caQ.identifier);
                }
                this.caQ.aat();
            }
        }
    }

    public Runnable aaw() {
        if (this.caL == null) {
            this.caL = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "请求超时");
                }
            };
        }
        return this.caL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.caH != null) {
            this.caH.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.caH = bVar;
    }
}
