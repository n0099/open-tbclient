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
    private NetModelType aPo;
    private c aPp;
    private d aPq;
    private String aPr;
    private int aPs;
    private int aPt;
    private HashMap<String, Object> aPu;
    private Runnable aPw;
    private String identifier;
    private boolean aPv = true;
    protected BdUniqueId unique_id = null;
    private int timeout = -1;
    private boolean isLoading = false;
    private a aPx = null;

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
        this.aPo = netModelType;
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.aPq == null && this.aPp == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aPv = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(Ep(), this.timeout * 1000);
        }
        switch (this.aPo) {
            case TYPE_NETWORK:
                if (!this.aPv) {
                    e.gx().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModel.this.r(-1, "网络不可用");
                        }
                    });
                    return false;
                } else if (this.aPx == null) {
                    this.aPx = new a(this);
                    this.aPx.execute(new Object[0]);
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
        MessageManager.getInstance().removeMessage(El(), this.unique_id);
        MessageManager.getInstance().removeMessage(Em(), this.unique_id);
        return true;
    }

    public String Ek() {
        return this.aPr;
    }

    public void eJ(String str) {
        this.aPr = str;
    }

    public int El() {
        return this.aPs;
    }

    public int Em() {
        return this.aPt;
    }

    public void ds(int i) {
        this.aPs = i;
    }

    public HashMap<String, Object> En() {
        return this.aPu;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.aPu = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        this.aPx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, String, String> {
        private FlutterNetModel aPA;
        private com.baidu.tbadk.core.util.a.a aPB;

        public a(FlutterNetModel flutterNetModel) {
            this.aPA = flutterNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.aPA.isLoading = true;
            x xVar = new x(this.aPA.Ek());
            HashMap<String, Object> En = this.aPA.En();
            if (En != null && !En.isEmpty()) {
                for (Map.Entry<String, Object> entry : En.entrySet()) {
                    xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            String postNetData = xVar.postNetData();
            this.aPB = xVar.aGe();
            publishProgress(postNetData);
            return postNetData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.aPA.isLoading = false;
                if (this.aPA.aPw != null) {
                    e.gx().removeCallbacks(this.aPA.aPw);
                }
                if (this.aPB != null && this.aPB.aGG() != null && this.aPA.aPp != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.aPA.Ek());
                    hashMap.put("api", this.aPA.Ek());
                    hashMap.put("state", this.aPB.aGH().daM.exception);
                    this.aPA.aPp.a(hashMap, this.aPB.aGG().mServerErrorCode, this.aPB.aGG().mErrorString, strArr[0], this.aPA.identifier);
                }
                this.aPA.Eo();
            }
        }
    }

    public Runnable Ep() {
        if (this.aPw == null) {
            this.aPw = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.2
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass3.aPz[FlutterNetModel.this.aPo.ordinal()]) {
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
        return this.aPw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.aPp != null) {
            this.aPp.a(null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.aPp = bVar;
        this.aPq = bVar;
    }

    public void a(c cVar) {
        this.aPp = cVar;
    }

    public void a(d dVar) {
        this.aPq = dVar;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }
}
