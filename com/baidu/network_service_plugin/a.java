package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements b.a {
    private b byf;
    private String byg;
    private HashMap<String, Object> byh;
    private Runnable byj;
    private String identifier;
    private boolean byi = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0220a byk = null;
    private boolean byl = false;
    private long bym = 0;

    /* loaded from: classes8.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.bym = System.currentTimeMillis();
        if (this.byf == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.byi = l.isNetOk();
        if (this.timeout >= 10) {
            e.lt().postDelayed(NF(), this.timeout * 1000);
        }
        if (!this.byi) {
            e.lt().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.byk == null) {
            this.byk = new C0220a(this);
            this.byk.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.byk != null) {
            this.byk.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String NA() {
        return this.byg;
    }

    public void gw(String str) {
        this.byg = str;
    }

    public HashMap<String, Object> NB() {
        return this.byh;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.byh = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC() {
        this.byk = null;
    }

    public void cW(boolean z) {
        this.byl = z;
    }

    public boolean ND() {
        return this.byl;
    }

    public long NE() {
        return this.bym;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0220a extends BdAsyncTask<Object, String, String> {
        private a byo;
        private com.baidu.tbadk.core.util.a.a byp;
        private z byq = null;
        private boolean byr = false;

        public C0220a(a aVar) {
            this.byo = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.byo.isLoading = true;
            this.byq = new z(this.byo.NA());
            HashMap<String, Object> NB = this.byo.NB();
            if (NB != null && !NB.isEmpty()) {
                for (Map.Entry<String, Object> entry : NB.entrySet()) {
                    this.byq.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.byo.ND()) {
                postNetData = this.byq.postMultiNetData();
            } else {
                postNetData = this.byq.postNetData();
            }
            this.byp = this.byq.bav();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.byr = true;
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            if (this.byo.byf != null) {
                this.byo.byf.a(null, null, -1, "cancle", "", this.byo.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.byo.isLoading = false;
                if (this.byo.byj != null) {
                    e.lt().removeCallbacks(this.byo.byj);
                }
                if (this.byp != null && this.byp.baX() != null && !this.byr && this.byo.byf != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.byo.NA());
                    hashMap.put("api", this.byo.NA());
                    hashMap.put("state", this.byp.baY().ebN.exception);
                    if (this.byp.baZ() != null && this.byo.NE() > 0 && this.byp.baZ().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.byp.baZ().get("startTime"), 0L) - this.byo.NE();
                        if (j > 0) {
                            this.byp.baZ().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.byo.byf.a(hashMap, this.byp.baZ(), this.byp.baX().mServerErrorCode, this.byp.baX().mErrorString, strArr[0], this.byo.identifier);
                }
                this.byo.NC();
            }
        }
    }

    public Runnable NF() {
        if (this.byj == null) {
            this.byj = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.I(-1, "请求超时");
                }
            };
        }
        return this.byj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.byf != null) {
            this.byf.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.byf = bVar;
    }
}
