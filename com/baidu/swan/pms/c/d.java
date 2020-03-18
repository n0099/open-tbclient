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
/* loaded from: classes11.dex */
public abstract class d<T> implements StatResponseCallback<String> {
    protected g cBy;
    protected f cBz;
    private String mRequestUrl;

    protected abstract boolean Q(T t);

    protected abstract com.baidu.swan.pms.model.a R(T t);

    protected abstract String ajo();

    protected abstract T bp(JSONObject jSONObject);

    public d(g gVar, f fVar) {
        this.cBy = gVar;
        this.cBz = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        if (this.cBy != null) {
            this.cBy.a(response, i, networkStatRecord);
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
            this.cBy.a(aVar);
            a(aVar, str);
            return;
        }
        c qr = c.qr(str);
        if (qr == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(2103, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.f.d.parseString(str).toString());
            this.cBy.a(aVar2);
            a(aVar2, str);
        } else if (qr.getErrorCode() != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(qr.getErrorCode(), PMSConstants.a.iD(qr.getErrorCode()));
            this.cBy.a(aVar3);
            if (qr.getErrorCode() != 1010) {
                a(aVar3, str);
            }
        } else {
            T bp = bp(qr.getData());
            if (bp == null) {
                com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(2102, "response data empty");
                this.cBy.a(aVar4);
                a(aVar4, str);
            } else if (!Q(bp)) {
                com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(2103, str);
                this.cBy.a(aVar5);
                a(aVar5, str);
            } else {
                R(bp);
            }
        }
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2101, exc.getMessage());
        this.cBy.a(aVar);
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
        com.baidu.swan.pms.a.f Px;
        if (pMSAppInfo != null && (Px = this.cBy.Px()) != null) {
            Px.b(pMSAppInfo);
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
        if (this.cBz instanceof com.baidu.swan.pms.c.d.c) {
            jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.cBz).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.d.a.a(this.cBz.getCategory(), "cs_protocol", ajo(), i, jSONObject);
    }
}
