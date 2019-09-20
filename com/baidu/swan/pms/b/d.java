package com.baidu.swan.pms.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.List;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d<T> extends ResponseCallback<String> {
    protected com.baidu.swan.pms.b.d.e btA;
    protected f btz;

    protected abstract com.baidu.swan.pms.model.a V(T t);

    protected abstract boolean W(T t);

    protected abstract String Wu();

    protected abstract T aD(JSONObject jSONObject);

    public d(f fVar, com.baidu.swan.pms.b.d.e eVar) {
        this.btz = fVar;
        this.btA = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public String parseResponse(Response response, int i) throws Exception {
        return (response == null || response.body() == null) ? "" : response.body().string();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    /* renamed from: x */
    public void onSuccess(String str, int i) {
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=" + i);
            this.btz.a(aVar);
            a(aVar, str);
            return;
        }
        c ku = c.ku(str);
        if (ku == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(2103, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.e.d.df(str).toString());
            this.btz.a(aVar2);
            a(aVar2, str);
        } else if (ku.getErrorCode() != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(ku.getErrorCode(), d.a.fH(ku.getErrorCode()));
            this.btz.a(aVar3);
            a(aVar3, str);
        } else {
            T aD = aD(ku.Wt());
            if (aD == null) {
                com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(2102, "response data empty");
                this.btz.a(aVar4);
                a(aVar4, str);
            } else if (!W(aD)) {
                com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(2103, str);
                this.btz.a(aVar5);
                a(aVar5, str);
            } else {
                a(V(aD), str);
            }
        }
    }

    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2101, exc.getMessage());
        this.btz.a(aVar);
        a(aVar, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.e.e eVar) {
        if (fVar != null) {
            eVar.a(fVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<h> list, com.baidu.swan.pms.e.e eVar) {
        if (list != null && !list.isEmpty()) {
            for (h hVar : list) {
                eVar.a(hVar, PMSPkgStatus.WAIT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.e.e eVar) {
        if (dVar != null) {
            eVar.a(dVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.e.e eVar) {
        if (bVar != null) {
            eVar.a(bVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar, com.baidu.swan.pms.e.e eVar) {
        if (iVar != null) {
            eVar.a(iVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(PMSAppInfo pMSAppInfo) {
        com.baidu.swan.pms.a.e Bw;
        if (pMSAppInfo != null && (Bw = this.btz.Bw()) != null) {
            Bw.b(pMSAppInfo);
        }
    }

    private void a(com.baidu.swan.pms.model.a aVar, String str) {
        int i;
        int i2 = 0;
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                if (aVar.errorNo != 0) {
                    i2 = aVar.errorNo;
                    jSONObject.put("response", str);
                }
            } catch (JSONException e) {
                i = i2;
                e.printStackTrace();
            }
        }
        if (this.btA instanceof com.baidu.swan.pms.b.d.b) {
            jSONObject.put("appId", ((com.baidu.swan.pms.b.d.b) this.btA).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.c.a.a(this.btA.BB(), "cs_protocol", Wu(), i, jSONObject);
    }
}
