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
    private NetModelType aPp;
    private c aPq;
    private d aPr;
    private String aPs;
    private int aPt;
    private int aPu;
    private HashMap<String, Object> aPv;
    private Runnable aPx;
    private String identifier;
    private boolean aPw = true;
    protected BdUniqueId unique_id = null;
    private int timeout = -1;
    private boolean isLoading = false;
    private a aPy = null;

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
        this.aPp = netModelType;
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.aPr == null && this.aPq == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aPw = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(Er(), this.timeout * 1000);
        }
        switch (this.aPp) {
            case TYPE_NETWORK:
                if (!this.aPw) {
                    e.gx().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModel.this.r(-1, "网络不可用");
                        }
                    });
                    return false;
                } else if (this.aPy == null) {
                    this.aPy = new a(this);
                    this.aPy.execute(new Object[0]);
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
        MessageManager.getInstance().removeMessage(En(), this.unique_id);
        MessageManager.getInstance().removeMessage(Eo(), this.unique_id);
        return true;
    }

    public String Em() {
        return this.aPs;
    }

    public void eJ(String str) {
        this.aPs = str;
    }

    public int En() {
        return this.aPt;
    }

    public int Eo() {
        return this.aPu;
    }

    public void ds(int i) {
        this.aPt = i;
    }

    public HashMap<String, Object> Ep() {
        return this.aPv;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.aPv = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        this.aPy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, String, String> {
        private FlutterNetModel aPB;
        private com.baidu.tbadk.core.util.a.a aPC;

        public a(FlutterNetModel flutterNetModel) {
            this.aPB = flutterNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.aPB.isLoading = true;
            x xVar = new x(this.aPB.Em());
            HashMap<String, Object> Ep = this.aPB.Ep();
            if (Ep != null && !Ep.isEmpty()) {
                for (Map.Entry<String, Object> entry : Ep.entrySet()) {
                    xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            String postNetData = xVar.postNetData();
            this.aPC = xVar.aGg();
            publishProgress(postNetData);
            return postNetData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.aPB.isLoading = false;
                if (this.aPB.aPx != null) {
                    e.gx().removeCallbacks(this.aPB.aPx);
                }
                if (this.aPC != null && this.aPC.aGI() != null && this.aPB.aPq != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.aPB.Em());
                    hashMap.put("api", this.aPB.Em());
                    hashMap.put("state", this.aPC.aGJ().daN.exception);
                    this.aPB.aPq.a(hashMap, this.aPC.aGI().mServerErrorCode, this.aPC.aGI().mErrorString, strArr[0], this.aPB.identifier);
                }
                this.aPB.Eq();
            }
        }
    }

    public Runnable Er() {
        if (this.aPx == null) {
            this.aPx = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.2
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass3.aPA[FlutterNetModel.this.aPp.ordinal()]) {
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
        return this.aPx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.aPq != null) {
            this.aPq.a(null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.aPq = bVar;
        this.aPr = bVar;
    }

    public void a(c cVar) {
        this.aPq = cVar;
    }

    public void a(d dVar) {
        this.aPr = dVar;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }
}
