package com.baidu.network_service_plugin;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterNetModel {
    private NetModelType aPE;
    private c aPF;
    private d aPG;
    private String aPH;
    private int aPI;
    private int aPJ;
    private HashMap<String, Object> aPK;
    private Runnable aPM;
    private String identifier;
    private boolean aPL = true;
    protected BdUniqueId unique_id = null;
    private int timeout = -1;
    private boolean isLoading = false;
    private a aPN = null;

    /* loaded from: classes6.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK
    }

    /* loaded from: classes6.dex */
    public interface b extends c, d {
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(HashMap<String, String> hashMap, int i, String str, Object obj, String str2);
    }

    /* loaded from: classes6.dex */
    public interface d {
    }

    public FlutterNetModel(NetModelType netModelType, String str) {
        this.aPE = netModelType;
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.aPG == null && this.aPF == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aPL = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(Ey(), this.timeout * 1000);
        }
        switch (this.aPE) {
            case TYPE_NETWORK:
                if (!this.aPL) {
                    e.gx().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModel.this.r(-1, "网络不可用");
                        }
                    });
                    return false;
                } else if (this.aPN == null) {
                    this.aPN = new a(this);
                    this.aPN.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(Eu(), this.unique_id);
        MessageManager.getInstance().removeMessage(Ev(), this.unique_id);
        return true;
    }

    public String Et() {
        return this.aPH;
    }

    public void eI(String str) {
        this.aPH = str;
    }

    public int Eu() {
        return this.aPI;
    }

    public int Ev() {
        return this.aPJ;
    }

    public void ds(int i) {
        this.aPI = i;
    }

    public HashMap<String, Object> Ew() {
        return this.aPK;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.aPK = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex() {
        this.aPN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, String, String> {
        private FlutterNetModel aPQ;
        private com.baidu.tbadk.core.util.a.a aPR;

        public a(FlutterNetModel flutterNetModel) {
            this.aPQ = flutterNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.aPQ.isLoading = true;
            x xVar = new x(this.aPQ.Et());
            HashMap<String, Object> Ew = this.aPQ.Ew();
            if (Ew != null && !Ew.isEmpty()) {
                for (Map.Entry<String, Object> entry : Ew.entrySet()) {
                    xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            String postNetData = xVar.postNetData();
            this.aPR = xVar.aGk();
            publishProgress(postNetData);
            return postNetData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.aPQ.isLoading = false;
                if (this.aPQ.aPM != null) {
                    e.gx().removeCallbacks(this.aPQ.aPM);
                }
                if (this.aPR != null && this.aPR.aGM() != null && this.aPQ.aPF != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.aPQ.Et());
                    hashMap.put("api", this.aPQ.Et());
                    hashMap.put("state", this.aPR.aGN().dbb.exception);
                    this.aPQ.aPF.a(hashMap, this.aPR.aGM().mServerErrorCode, this.aPR.aGM().mErrorString, strArr[0], this.aPQ.identifier);
                }
                this.aPQ.Ex();
            }
        }
    }

    public Runnable Ey() {
        if (this.aPM == null) {
            this.aPM = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.2
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass3.aPP[FlutterNetModel.this.aPE.ordinal()]) {
                        case 1:
                            FlutterNetModel.this.r(-1, "请求超时");
                            return;
                        case 2:
                        case 3:
                        case 4:
                        default:
                            return;
                    }
                }
            };
        }
        return this.aPM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.aPF != null) {
            this.aPF.a(null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.aPF = bVar;
        this.aPG = bVar;
    }

    public void a(c cVar) {
        this.aPF = cVar;
    }

    public void a(d dVar) {
        this.aPG = dVar;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }
}
