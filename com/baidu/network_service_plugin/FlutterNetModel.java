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
    private NetModelType aPq;
    private c aPr;
    private d aPs;
    private String aPt;
    private int aPu;
    private int aPv;
    private HashMap<String, Object> aPw;
    private Runnable aPy;
    private String identifier;
    private boolean aPx = true;
    protected BdUniqueId unique_id = null;
    private int timeout = -1;
    private boolean isLoading = false;
    private a aPz = null;

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
        this.aPq = netModelType;
        this.identifier = str;
    }

    public boolean loadData() {
        if (this.aPs == null && this.aPr == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aPx = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(Er(), this.timeout * 1000);
        }
        switch (this.aPq) {
            case TYPE_NETWORK:
                if (!this.aPx) {
                    e.gx().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModel.this.r(-1, "网络不可用");
                        }
                    });
                    return false;
                } else if (this.aPz == null) {
                    this.aPz = new a(this);
                    this.aPz.execute(new Object[0]);
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
        return this.aPt;
    }

    public void eJ(String str) {
        this.aPt = str;
    }

    public int En() {
        return this.aPu;
    }

    public int Eo() {
        return this.aPv;
    }

    public void ds(int i) {
        this.aPu = i;
    }

    public HashMap<String, Object> Ep() {
        return this.aPw;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.aPw = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        this.aPz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, String, String> {
        private FlutterNetModel aPC;
        private com.baidu.tbadk.core.util.a.a aPD;

        public a(FlutterNetModel flutterNetModel) {
            this.aPC = flutterNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.aPC.isLoading = true;
            x xVar = new x(this.aPC.Em());
            HashMap<String, Object> Ep = this.aPC.Ep();
            if (Ep != null && !Ep.isEmpty()) {
                for (Map.Entry<String, Object> entry : Ep.entrySet()) {
                    xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            String postNetData = xVar.postNetData();
            this.aPD = xVar.aGg();
            publishProgress(postNetData);
            return postNetData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            if (strArr != null && strArr.length > 0) {
                this.aPC.isLoading = false;
                if (this.aPC.aPy != null) {
                    e.gx().removeCallbacks(this.aPC.aPy);
                }
                if (this.aPD != null && this.aPD.aGI() != null && this.aPC.aPr != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.aPC.Em());
                    hashMap.put("api", this.aPC.Em());
                    hashMap.put("state", this.aPD.aGJ().daO.exception);
                    this.aPC.aPr.a(hashMap, this.aPD.aGI().mServerErrorCode, this.aPD.aGI().mErrorString, strArr[0], this.aPC.identifier);
                }
                this.aPC.Eq();
            }
        }
    }

    public Runnable Er() {
        if (this.aPy == null) {
            this.aPy = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModel.2
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass3.aPB[FlutterNetModel.this.aPq.ordinal()]) {
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
        return this.aPy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.aPr != null) {
            this.aPr.a(null, i, str, null, this.identifier);
        }
    }

    public void a(b bVar) {
        this.aPr = bVar;
        this.aPs = bVar;
    }

    public void a(c cVar) {
        this.aPr = cVar;
    }

    public void a(d dVar) {
        this.aPs = dVar;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }
}
