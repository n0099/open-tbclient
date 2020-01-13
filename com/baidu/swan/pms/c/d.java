package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import java.util.List;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class d<T> implements StatResponseCallback<String> {
    protected g cxn;
    protected f cxo;
    private String mRequestUrl;

    protected abstract boolean O(T t);

    protected abstract com.baidu.swan.pms.model.a P(T t);

    protected abstract String agV();

    protected abstract T bp(JSONObject jSONObject);

    public d(g gVar, f fVar) {
        this.cxn = gVar;
        this.cxo = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        if (this.cxn != null) {
            this.cxn.a(response, i, networkStatRecord);
        }
        if (response == null || response.body() == null) {
            return "";
        }
        this.mRequestUrl = response.request().url().toString();
        return response.body().string();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onSuccess(String str, int i) {
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=" + i);
            this.cxn.a(aVar);
            a(aVar, str);
            return;
        }
        c qd = c.qd(str);
        if (qd == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(2103, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.f.d.parseString(str).toString());
            this.cxn.a(aVar2);
            a(aVar2, str);
        } else if (qd.getErrorCode() != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(qd.getErrorCode(), PMSConstants.a.im(qd.getErrorCode()));
            this.cxn.a(aVar3);
            if (qd.getErrorCode() != 1010) {
                a(aVar3, str);
            }
        } else {
            T bp = bp(qd.getData());
            if (bp == null) {
                com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(2102, "response data empty");
                this.cxn.a(aVar4);
                a(aVar4, str);
            } else if (!O(bp)) {
                com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(2103, str);
                this.cxn.a(aVar5);
                a(aVar5, str);
            } else {
                P(bp);
            }
        }
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2101, exc.getMessage());
        this.cxn.a(aVar);
        a(aVar, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.f.e eVar) {
        if (fVar != null) {
            eVar.a(fVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<com.baidu.swan.pms.model.g> list, com.baidu.swan.pms.f.e eVar) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.swan.pms.model.g gVar : list) {
                eVar.a(gVar, PMSPkgStatus.WAIT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.f.e eVar) {
        if (dVar != null) {
            eVar.a(dVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.f.e eVar) {
        if (bVar != null) {
            eVar.a(bVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar, com.baidu.swan.pms.f.e eVar) {
        if (hVar != null) {
            eVar.a(hVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(PMSAppInfo pMSAppInfo) {
        com.baidu.swan.pms.a.f Ne;
        if (pMSAppInfo != null && (Ne = this.cxn.Ne()) != null) {
            Ne.b(pMSAppInfo);
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
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, str);
                    if (!TextUtils.isEmpty(this.mRequestUrl) && (aVar.errorNo == 1011 || aVar.errorNo == 1012)) {
                        jSONObject.put("request_url", this.mRequestUrl);
                    }
                }
            } catch (JSONException e) {
                i = i2;
                e.printStackTrace();
            }
        }
        if (this.cxo instanceof com.baidu.swan.pms.c.d.c) {
            jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.cxo).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.d.a.a(this.cxo.getCategory(), "cs_protocol", agV(), i, jSONObject);
    }
}
