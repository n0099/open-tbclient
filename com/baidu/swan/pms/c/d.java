package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.c.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class d<T> implements f.a {
    protected com.baidu.swan.pms.a.g dlN;
    protected com.baidu.swan.pms.c.d.f dlO;
    private String mRequestUrl;

    protected abstract boolean W(T t);

    protected abstract com.baidu.swan.pms.model.a X(T t);

    protected abstract String ave();

    protected abstract T bz(JSONObject jSONObject);

    public d(com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.c.d.f fVar) {
        this.dlN = gVar;
        this.dlO = fVar;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void b(String str, String str2, JSONObject jSONObject) {
        if (this.dlN != null) {
            this.dlN.b(str, str2, jSONObject);
        }
        this.mRequestUrl = str;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onSuccess(String str, int i) {
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=" + i);
            this.dlN.b(aVar);
            a(aVar, str);
            return;
        }
        c tj = c.tj(str);
        if (tj == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(2103, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.f.d.parseString(str).toString());
            this.dlN.b(aVar2);
            a(aVar2, str);
            return;
        }
        int errorCode = tj.getErrorCode();
        if (errorCode != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(errorCode, PMSConstants.a.ah(errorCode, tj.getErrorMessage()), tj.aGm());
            this.dlN.b(aVar3);
            if (tj.getErrorCode() != 1010) {
                a(aVar3, str);
                return;
            }
            return;
        }
        T bz = bz(tj.getData());
        if (bz == null) {
            com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(2102, "response data empty");
            this.dlN.b(aVar4);
            a(aVar4, str);
        } else if (!W(bz)) {
            com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(2103, str);
            this.dlN.b(aVar5);
            a(aVar5, str);
        } else {
            X(bz);
        }
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(2101, exc.getMessage());
        this.dlN.b(aVar);
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
    public void r(PMSAppInfo pMSAppInfo) {
        com.baidu.swan.pms.a.f ZX;
        if (pMSAppInfo != null && (ZX = this.dlN.ZX()) != null) {
            ZX.c(pMSAppInfo);
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
        if (this.dlO instanceof com.baidu.swan.pms.c.d.c) {
            jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.dlO).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.d.a.a(this.dlO.getCategory(), "cs_protocol", ave(), i, jSONObject);
    }
}
