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
    private b bsW;
    private String bsX;
    private HashMap<String, Object> bsY;
    private Runnable bta;
    private String identifier;
    private boolean bsZ = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0213a btb = null;
    private boolean btc = false;
    private long btd = 0;

    /* loaded from: classes6.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.btd = System.currentTimeMillis();
        if (this.bsW == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bsZ = l.isNetOk();
        if (this.timeout >= 10) {
            e.ld().postDelayed(Mr(), this.timeout * 1000);
        }
        if (!this.bsZ) {
            e.ld().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.btb == null) {
            this.btb = new C0213a(this);
            this.btb.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.btb != null) {
            this.btb.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Mm() {
        return this.bsX;
    }

    public void go(String str) {
        this.bsX = str;
    }

    public HashMap<String, Object> Mn() {
        return this.bsY;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.bsY = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mo() {
        this.btb = null;
    }

    public void cP(boolean z) {
        this.btc = z;
    }

    public boolean Mp() {
        return this.btc;
    }

    public long Mq() {
        return this.btd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0213a extends BdAsyncTask<Object, String, String> {
        private a btf;
        private com.baidu.tbadk.core.util.a.a btg;
        private x bth = null;
        private boolean bti = false;

        public C0213a(a aVar) {
            this.btf = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.btf.isLoading = true;
            this.bth = new x(this.btf.Mm());
            HashMap<String, Object> Mn = this.btf.Mn();
            if (Mn != null && !Mn.isEmpty()) {
                for (Map.Entry<String, Object> entry : Mn.entrySet()) {
                    this.bth.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.btf.Mp()) {
                postNetData = this.bth.postMultiNetData();
            } else {
                postNetData = this.bth.postNetData();
            }
            this.btg = this.bth.aUA();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.bti = true;
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            if (this.btf.bsW != null) {
                this.btf.bsW.a(null, null, -1, "cancle", "", this.btf.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.btf.isLoading = false;
                if (this.btf.bta != null) {
                    e.ld().removeCallbacks(this.btf.bta);
                }
                if (this.btg != null && this.btg.aVc() != null && !this.bti && this.btf.bsW != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.btf.Mm());
                    hashMap.put("api", this.btf.Mm());
                    hashMap.put("state", this.btg.aVd().dOA.exception);
                    if (this.btg.aVe() != null && this.btf.Mq() > 0 && this.btg.aVe().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.btg.aVe().get("startTime"), 0L) - this.btf.Mq();
                        if (j > 0) {
                            this.btg.aVe().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.btf.bsW.a(hashMap, this.btg.aVe(), this.btg.aVc().mServerErrorCode, this.btg.aVc().mErrorString, strArr[0], this.btf.identifier);
                }
                this.btf.Mo();
            }
        }
    }

    public Runnable Mr() {
        if (this.bta == null) {
            this.bta = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "请求超时");
                }
            };
        }
        return this.bta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        if (this.bsW != null) {
            this.bsW.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.bsW = bVar;
    }
}
