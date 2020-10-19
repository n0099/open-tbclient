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
    private b bMA;
    private String bMB;
    private HashMap<String, Object> bMC;
    private Runnable bME;
    private String identifier;
    private boolean bMD = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0242a bMF = null;
    private boolean bMG = false;
    private long bMH = 0;

    /* loaded from: classes16.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bMH = System.currentTimeMillis();
        if (this.bMA == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bMD = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(Wd(), this.timeout * 1000);
        }
        if (!this.bMD) {
            e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.T(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.bMF == null) {
            this.bMF = new C0242a(this);
            this.bMF.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.bMF != null) {
            this.bMF.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String VY() {
        return this.bMB;
    }

    public void iL(String str) {
        this.bMB = str;
    }

    public HashMap<String, Object> VZ() {
        return this.bMC;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bMC = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        this.bMF = null;
    }

    public void dk(boolean z) {
        this.bMG = z;
    }

    public boolean Wb() {
        return this.bMG;
    }

    public long Wc() {
        return this.bMH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0242a extends BdAsyncTask<Object, String, String> {
        private a bMJ;
        private com.baidu.tbadk.core.util.a.a bMK;
        private aa bML = null;
        private boolean isCancle = false;

        public C0242a(a aVar) {
            this.bMJ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.bMJ.isLoading = true;
            this.bML = new aa(this.bMJ.VY());
            HashMap<String, Object> VZ = this.bMJ.VZ();
            if (VZ != null && !VZ.isEmpty()) {
                for (Map.Entry<String, Object> entry : VZ.entrySet()) {
                    this.bML.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.bMJ.Wb() && VZ != null) {
                this.bML.addPostData("debugfile", (byte[]) VZ.get("debugfile"));
                postNetData = this.bML.postMultiNetData();
            } else {
                postNetData = this.bML.postNetData();
            }
            this.bMK = this.bML.bmu();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            if (this.bMJ.bMA != null) {
                this.bMJ.bMA.a(null, null, -1, "cancle", "", this.bMJ.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.bMJ.isLoading = false;
                if (this.bMJ.bME != null) {
                    e.mY().removeCallbacks(this.bMJ.bME);
                }
                if (this.bMK != null && this.bMK.bnb() != null && !this.isCancle && this.bMJ.bMA != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.bMJ.VY());
                    hashMap.put("api", this.bMJ.VY());
                    hashMap.put("state", this.bMK.bnc().eAf.exception);
                    if (this.bMK.bnd() != null && this.bMJ.Wc() > 0 && this.bMK.bnd().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.bMK.bnd().get("startTime"), 0L) - this.bMJ.Wc();
                        if (j > 0) {
                            this.bMK.bnd().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.bMJ.bMA.a(hashMap, this.bMK.bnd(), this.bMK.bnb().mServerErrorCode, this.bMK.bnb().mErrorString, strArr[0], this.bMJ.identifier);
                }
                this.bMJ.Wa();
            }
        }
    }

    public Runnable Wd() {
        if (this.bME == null) {
            this.bME = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.T(-1, "请求超时");
                }
            };
        }
        return this.bME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (this.bMA != null) {
            this.bMA.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bMA = bVar;
    }
}
