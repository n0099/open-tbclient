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
    protected com.baidu.swan.pms.c.d.g cNi;
    protected com.baidu.swan.pms.a.g ebZ;
    private String mRequestUrl;

    protected abstract String aYW();

    protected abstract com.baidu.swan.pms.model.a ak(T t);

    protected abstract boolean al(T t);

    protected abstract T cE(JSONObject jSONObject);

    public d(com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        this.ebZ = gVar;
        this.cNi = gVar2;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void b(String str, String str2, JSONObject jSONObject) {
        if (this.ebZ != null) {
            this.ebZ.b(str, str2, jSONObject);
        }
        this.mRequestUrl = str;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onSuccess(String str, int i) {
        if (this.ebZ != null) {
            this.ebZ.N(str, i);
        }
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=" + i);
            this.ebZ.b(aVar);
            a(aVar, str);
            return;
        }
        c yd = c.yd(str);
        if (yd == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.utils.e.parseString(str).toString());
            this.ebZ.b(aVar2);
            a(aVar2, str);
            return;
        }
        int errorCode = yd.getErrorCode();
        if (errorCode != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(errorCode, PMSConstants.a.aw(errorCode, "response errorCode with errmsg:" + yd.getErrorMessage()), yd.aYV());
            this.ebZ.b(aVar3);
            if (yd.getErrorCode() != 1010) {
                a(aVar3, str);
                return;
            }
            return;
        }
        T cE = cE(yd.getData());
        if (cE == null) {
            com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2, "response data empty");
            this.ebZ.b(aVar4);
            a(aVar4, str);
        } else if (!al(cE)) {
            com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, str);
            this.ebZ.b(aVar5);
            a(aVar5, str);
        } else {
            ak(cE);
        }
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1, Log.getStackTraceString(exc));
        this.ebZ.b(aVar);
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
        com.baidu.swan.pms.a.f anT;
        if (pMSAppInfo != null && (anT = this.ebZ.anT()) != null) {
            anT.e(pMSAppInfo);
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
        if (this.cNi instanceof com.baidu.swan.pms.c.d.c) {
            jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.cNi).getBundleId());
        }
        i = i2;
        com.baidu.swan.pms.f.a.a(this.cNi.getCategory(), "cs_protocol", aYW(), i, jSONObject);
    }
}
