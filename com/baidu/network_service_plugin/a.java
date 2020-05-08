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
    private b blA;
    private String blB;
    private HashMap<String, Object> blC;
    private Runnable blE;
    private String identifier;
    private boolean blD = true;
    private int timeout = -1;
    private boolean isLoading = false;
    private C0180a blF = null;
    private boolean blG = false;

    /* loaded from: classes6.dex */
    public interface b {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.blA == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.blD = l.isNetOk();
        if (this.timeout >= 10) {
            e.lb().postDelayed(Kx(), this.timeout * 1000);
        }
        if (!this.blD) {
            e.lb().post(new Runnable() { // from class: com.baidu.network_service_plugin.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "网络不可用");
                }
            });
            return false;
        } else if (this.blF == null) {
            this.blF = new C0180a(this);
            this.blF.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        if (this.isLoading && this.blF != null) {
            this.blF.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String Kt() {
        return this.blB;
    }

    public void fC(String str) {
        this.blB = str;
    }

    public HashMap<String, Object> Ku() {
        return this.blC;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.blC = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        this.blF = null;
    }

    public void cD(boolean z) {
        this.blG = z;
    }

    public boolean Kw() {
        return this.blG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.network_service_plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0180a extends BdAsyncTask<Object, String, String> {
        private a blI;
        private com.baidu.tbadk.core.util.a.a blJ;
        private x blK = null;
        private boolean blL = false;

        public C0180a(a aVar) {
            this.blI = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.blI.isLoading = true;
            this.blK = new x(this.blI.Kt());
            HashMap<String, Object> Ku = this.blI.Ku();
            if (Ku != null && !Ku.isEmpty()) {
                for (Map.Entry<String, Object> entry : Ku.entrySet()) {
                    this.blK.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.blI.Kw()) {
                postNetData = this.blK.postMultiNetData();
            } else {
                postNetData = this.blK.postNetData();
            }
            this.blJ = this.blK.aOw();
            publishProgress(postNetData);
            return postNetData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.blL = true;
            super.cancel(true);
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            if (this.blI.blA != null) {
                this.blI.blA.a(null, null, -1, "cancle", "", this.blI.identifier);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.blI.isLoading = false;
                if (this.blI.blE != null) {
                    e.lb().removeCallbacks(this.blI.blE);
                }
                if (this.blJ != null && this.blJ.aOX() != null && !this.blL && this.blI.blA != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.blI.Kt());
                    hashMap.put("api", this.blI.Kt());
                    hashMap.put("state", this.blJ.aOY().dAu.exception);
                    this.blI.blA.a(hashMap, this.blJ.aOZ(), this.blJ.aOX().mServerErrorCode, this.blJ.aOX().mErrorString, strArr[0], this.blI.identifier);
                }
                this.blI.Kv();
            }
        }
    }

    public Runnable Kx() {
        if (this.blE == null) {
            this.blE = new Runnable() { // from class: com.baidu.network_service_plugin.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.G(-1, "请求超时");
                }
            };
        }
        return this.blE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        if (this.blA != null) {
            this.blA.a(null, null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.blA = bVar;
    }
}
