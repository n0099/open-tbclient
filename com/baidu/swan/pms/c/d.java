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
/* loaded from: classes6.dex */
public abstract class d<T> implements f.a {
    protected com.baidu.swan.pms.c.d.g ddf;
    protected com.baidu.swan.pms.a.g ewT;
    private String mRequestUrl;

    protected abstract com.baidu.swan.pms.model.a am(T t);

    protected abstract boolean an(T t);

    protected abstract String bgr();

    protected abstract T cO(JSONObject jSONObject);

    public d(com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        this.ewT = gVar;
        this.ddf = gVar2;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void b(String str, String str2, JSONObject jSONObject) {
        if (this.ewT != null) {
            this.ewT.b(str, str2, jSONObject);
        }
        this.mRequestUrl = str;
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void S(String str, int i) {
        if (this.ewT != null) {
            this.ewT.R(str, i);
        }
        if (i != 200) {
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=" + i);
            this.ewT.b(aVar);
            a(aVar, str);
            return;
        }
        c yS = c.yS(str);
        if (yS == null) {
            com.baidu.swan.pms.model.a aVar2 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, "metadata : parse response error - ,errmsg:" + com.baidu.swan.pms.utils.e.parseString(str).toString());
            this.ewT.b(aVar2);
            a(aVar2, str);
            return;
        }
        int errorCode = yS.getErrorCode();
        if (errorCode != 0) {
            com.baidu.swan.pms.model.a aVar3 = new com.baidu.swan.pms.model.a(errorCode, PMSConstants.a.aC(errorCode, "response errorCode with errmsg:" + yS.getErrorMessage()), yS.bgq());
            this.ewT.b(aVar3);
            if (yS.getErrorCode() != 1010) {
                a(aVar3, str);
                return;
            }
            return;
        }
        T cO = cO(yS.getData());
        if (cO == null) {
            com.baidu.swan.pms.model.a aVar4 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2, "response data empty");
            this.ewT.b(aVar4);
            a(aVar4, str);
        } else if (!an(cO)) {
            com.baidu.swan.pms.model.a aVar5 = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3, str);
            this.ewT.b(aVar5);
            a(aVar5, str);
        } else {
            am(cO);
        }
    }

    @Override // com.baidu.swan.pms.c.f.a
    public void onFail(Exception exc) {
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1, Log.getStackTraceString(exc));
        this.ewT.b(aVar);
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
        com.baidu.swan.pms.a.f aum;
        if (pMSAppInfo != null && (aum = this.ewT.aum()) != null) {
            aum.e(pMSAppInfo);
        }
    }

    private void a(com.baidu.swan.pms.model.a aVar, String str) {
        JSONException e;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                if (aVar.errorNo != 0) {
                    i = aVar.errorNo;
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, str);
                    if (!TextUtils.isEmpty(this.mRequestUrl) && (aVar.errorNo == 1011 || aVar.errorNo == 1012)) {
                        jSONObject.put("request_url", this.mRequestUrl);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                com.baidu.swan.pms.f.a.a(this.ddf.getCategory(), "cs_protocol", bgr(), i, jSONObject);
            }
        }
        int i2 = i;
        try {
            if (this.ddf instanceof com.baidu.swan.pms.c.d.c) {
                jSONObject.put("appId", ((com.baidu.swan.pms.c.d.c) this.ddf).getBundleId());
            }
            i = i2;
        } catch (JSONException e3) {
            e = e3;
            i = i2;
            e.printStackTrace();
            com.baidu.swan.pms.f.a.a(this.ddf.getCategory(), "cs_protocol", bgr(), i, jSONObject);
        }
        com.baidu.swan.pms.f.a.a(this.ddf.getCategory(), "cs_protocol", bgr(), i, jSONObject);
    }
}
