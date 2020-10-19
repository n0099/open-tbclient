package com.baidu.swan.pms.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.c.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public abstract class d<T> implements f.a {
    protected com.baidu.swan.pms.c.d.g cEM;
    protected com.baidu.swan.pms.a.g dTD;
    private String mRequestUrl;

    protected abstract String aXd();

    protected abstract com.baidu.swan.pms.model.a ak(T t);

    protected abstract boolean al(T t);

    protected abstract T cB(JSONObject jSONObject);

    public d(com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        this.dTD = gVar;
        this.cEM = gVar2;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void b(String str, String str2, JSONObject jSONObject) {
        if (this.dTD != null) {
            this.dTD.b(str, str2, jSONObject);
        }
        this.mRequestUrl = str;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onSuccess(String str, int i) {
        if (this.dTD != null) {
            this.dTD.N(str, i);
        }
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=" + i);
            this.dTD.b(aVar);
            a(aVar, str);
            return;
        }
        c xK = c.xK(str);
        if (xK == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.utils.e.parseString(str).toString());
            this.dTD.b(aVar2);
            a(aVar2, str);
            return;
        }
        int errorCode = xK.getErrorCode();
        if (errorCode != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(errorCode, PMSConstants.a.au(errorCode, "response errorCode with errmsg:" + xK.getErrorMessage()), xK.aXc());
            this.dTD.b(aVar3);
            if (xK.getErrorCode() != 1010) {
                a(aVar3, str);
                return;
            }
            return;
        }
        T cB = cB(xK.getData());
        if (cB == null) {
            com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2, "response data empty");
            this.dTD.b(aVar4);
            a(aVar4, str);
        } else if (!al(cB)) {
            com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, str);
            this.dTD.b(aVar5);
            a(aVar5, str);
        } else {
            ak(cB);
        }
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1, Log.getStackTraceString(exc));
        this.dTD.b(aVar);
        a(aVar, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.utils.f fVar2) {
        if (fVar != null) {
            fVar2.a(fVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<com.baidu.swan.pms.model.g> list, com.baidu.swan.pms.utils.f fVar) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.swan.pms.model.g gVar : list) {
                fVar.a(gVar, PMSPkgStatus.WAIT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.utils.f fVar) {
        if (dVar != null) {
            fVar.a(dVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.utils.f fVar) {
        if (bVar != null) {
            fVar.a(bVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar, com.baidu.swan.pms.utils.f fVar) {
        if (hVar != null) {
            fVar.a(hVar, PMSPkgStatus.WAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(PMSAppInfo pMSAppInfo) {
        com.baidu.swan.pms.a.f alZ;
        if (pMSAppInfo != null && (alZ = this.dTD.alZ()) != null) {
            alZ.e(pMSAppInfo);
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
        if (this.cEM instanceof com.baidu.swan.pms.c.d.c) {
            jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.cEM).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.f.a.a(this.cEM.getCategory(), "cs_protocol", aXd(), i, jSONObject);
    }
}
