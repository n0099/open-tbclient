package com.baidu.network_service_plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a implements b.a {
    private Runnable cfB;
    private b cfw;
    private String cfx;
    private HashMap<String, Object> cfy;
    private String identifier;
    private boolean cfz = true;
    private int cfA = -1;
    private boolean isLoading = false;
    private C0277a cfC = null;
    private boolean cfD = false;
    private long cfE = 0;

    /* loaded from: classes10.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        this.cfE = System.currentTimeMillis();
        if (this.cfw == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cfz = l.isNetOk();
        if (this.cfA >= 10) {
            e.mY().postDelayed(acV(), this.cfA * 1000);
        }
        if (!this.cfz) {
            e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.cfC == null) {
            this.cfC = new C0277a(this);
            this.cfC.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.cfC != null) {
            this.cfC.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String acQ() {
        return this.cfx;
    }

    public void jS(String str) {
        this.cfx = str;
    }

    public HashMap<String, Object> acR() {
        return this.cfy;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.cfy = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acS() {
        this.cfC = null;
    }

    public void dX(boolean z) {
        this.cfD = z;
    }

    public boolean acT() {
        return this.cfD;
    }

    public long acU() {
        return this.cfE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0277a extends BdAsyncTask<Object, String, String> {
        private a cfG;
        private com.baidu.tbadk.core.util.a.a cfH;
        private aa cfI = null;
        private boolean isCancle = false;

        public C0277a(a aVar) {
            this.cfG = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.cfG.isLoading = true;
            this.cfI = new aa(this.cfG.acQ());
            HashMap<String, Object> acR = this.cfG.acR();
            if (acR != null && !acR.isEmpty()) {
                for (Map.Entry<String, Object> entry : acR.entrySet()) {
                    this.cfI.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.cfG.acT() && acR != null) {
                this.cfI.addPostData("debugfile", (byte[]) acR.get("debugfile"));
                postNetData = this.cfI.postMultiNetData();
            } else {
                postNetData = this.cfI.postNetData();
            }
            this.cfH = this.cfI.btv();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCancle = true;
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            if (this.cfG.cfw != null) {
                this.cfG.cfw.a(null, null, -1, "cancle", "", this.cfG.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.cfG.isLoading = false;
                if (this.cfG.cfB != null) {
                    e.mY().removeCallbacks(this.cfG.cfB);
                }
                if (this.cfH != null && this.cfH.buf() != null && !this.isCancle && this.cfG.cfw != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.cfG.acQ());
                    hashMap.put("api", this.cfG.acQ());
                    hashMap.put("state", this.cfH.bug().eUJ.exception);
                    if (this.cfH.buh() != null && this.cfG.acU() > 0 && this.cfH.buh().containsKey("startTime")) {
                        long j = com.baidu.adp.lib.f.b.toLong(this.cfH.buh().get("startTime"), 0L) - this.cfG.acU();
                        if (j > 0) {
                            this.cfH.buh().put("queneTime", String.valueOf(j));
                        }
                    }
                    this.cfG.cfw.a(hashMap, this.cfH.buh(), this.cfH.buf().mServerErrorCode, this.cfH.buf().mErrorString, strArr[0], this.cfG.identifier);
                }
                this.cfG.acS();
            }
        }
    }

    public Runnable acV() {
        if (this.cfB == null) {
            this.cfB = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Z(-1, "请求超时");
                }
            };
        }
        return this.cfB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.cfw != null) {
            this.cfw.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.cfw = bVar;
    }
}
