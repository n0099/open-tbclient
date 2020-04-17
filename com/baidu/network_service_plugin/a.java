package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements b.a {
    private b blv;
    private String blw;
    private HashMap<String, Object> blx;
    private Runnable blz;
    private String identifier;
    private boolean bly = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0159a blA = null;
    private boolean blB = false;

    /* loaded from: classes6.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.blv == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bly = l.isNetOk();
        if (this.timeout >= 10) {
            e.lb().postDelayed(Ky(), this.timeout * 1000);
        }
        if (!this.bly) {
            e.lb().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.blA == null) {
            this.blA = new C0159a(this);
            this.blA.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.blA != null) {
            this.blA.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Ku() {
        return this.blw;
    }

    public void fC(String str) {
        this.blw = str;
    }

    public HashMap<String, Object> Kv() {
        return this.blx;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.blx = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw() {
        this.blA = null;
    }

    public void cD(boolean z) {
        this.blB = z;
    }

    public boolean Kx() {
        return this.blB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0159a extends BdAsyncTask<Object, String, String> {
        private a blD;
        private com.baidu.tbadk.core.util.a.a blE;
        private x blF = null;
        private boolean blG = false;

        public C0159a(a aVar) {
            this.blD = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.blD.isLoading = true;
            this.blF = new x(this.blD.Ku());
            HashMap<String, Object> Kv = this.blD.Kv();
            if (Kv != null && !Kv.isEmpty()) {
                for (Map.Entry<String, Object> entry : Kv.entrySet()) {
                    this.blF.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.blD.Kx()) {
                postNetData = this.blF.postMultiNetData();
            } else {
                postNetData = this.blF.postNetData();
            }
            this.blE = this.blF.aOy();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.blG = true;
            super.cancel(true);
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            if (this.blD.blv != null) {
                this.blD.blv.a(null, null, -1, "cancle", "", this.blD.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.blD.isLoading = false;
                if (this.blD.blz != null) {
                    e.lb().removeCallbacks(this.blD.blz);
                }
                if (this.blE != null && this.blE.aPa() != null && !this.blG && this.blD.blv != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.blD.Ku());
                    hashMap.put("api", this.blD.Ku());
                    hashMap.put("state", this.blE.aPb().dAq.exception);
                    this.blD.blv.a(hashMap, this.blE.aPc(), this.blE.aPa().mServerErrorCode, this.blE.aPa().mErrorString, strArr[0], this.blD.identifier);
                }
                this.blD.Kw();
            }
        }
    }

    public Runnable Ky() {
        if (this.blz == null) {
            this.blz = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "请求超时");
                }
            };
        }
        return this.blz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        if (this.blv != null) {
            this.blv.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.blv = bVar;
    }
}
