package com.baidu.swan.pms.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.List;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d<T> extends ResponseCallback<String> {
    protected com.baidu.swan.pms.a.e bmi;
    protected com.baidu.swan.pms.b.d.c bmj;

    protected abstract String RK();

    protected abstract com.baidu.swan.pms.model.b a(c cVar);

    public d(com.baidu.swan.pms.a.e eVar, com.baidu.swan.pms.b.d.c cVar) {
        this.bmi = eVar;
        this.bmj = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public String parseResponse(Response response, int i) throws Exception {
        return (response == null || response.body() == null) ? "" : response.body().string();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    /* renamed from: I */
    public void onSuccess(String str, int i) {
        if (i != 200) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2104, "metadata : network error. http code=" + i);
            this.bmi.a(bVar);
            a(bVar, str);
            return;
        }
        c jm = c.jm(str);
        if (jm == null) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.d.d.dm(str).toString());
            this.bmi.a(bVar2);
            a(bVar2, str);
        } else if (jm.getErrorCode() != 0) {
            com.baidu.swan.pms.model.b bVar3 = new com.baidu.swan.pms.model.b(jm.getErrorCode(), d.a.fd(jm.getErrorCode()));
            this.bmi.a(bVar3);
            a(bVar3, str);
        } else {
            a(a(jm), str);
        }
    }

    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2101, exc.getMessage());
        this.bmi.a(bVar);
        a(bVar, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar, com.baidu.swan.pms.d.e eVar) {
        if (gVar != null) {
            eVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<i> list, com.baidu.swan.pms.d.e eVar) {
        if (list != null && !list.isEmpty()) {
            for (i iVar : list) {
                eVar.a(iVar, PMSPkgStatus.WAIT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.d.e eVar2) {
        if (eVar != null) {
            eVar2.a(eVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.c cVar, com.baidu.swan.pms.d.e eVar) {
        if (cVar != null) {
            eVar.a(cVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.pms.a.d zG;
        if (aVar != null && (zG = this.bmi.zG()) != null) {
            zG.c(aVar);
        }
    }

    private void a(com.baidu.swan.pms.model.b bVar, String str) {
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        String str2 = "unknown";
        if (bVar != null) {
            try {
                if (bVar.errorNo != 0) {
                    i = bVar.errorNo;
                    jSONObject.put("response", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bmj instanceof com.baidu.swan.pms.b.d.a) {
            jSONObject.put("appId", ((com.baidu.swan.pms.b.d.a) this.bmj).getBundleId());
        }
        if (this.bmj.Si() == 0) {
            str2 = "swan";
        } else if (this.bmj.Si() == 1) {
            str2 = "swangame";
        }
        com.baidu.swan.pms.e.Ru().a(str2, "cs_protocol", RK(), i, jSONObject);
    }
}
