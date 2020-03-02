package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bO */
    public com.baidu.swan.pms.c.c.a bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bW(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a R(com.baidu.swan.pms.c.c.a aVar) {
        this.cBm.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> atx = com.baidu.swan.pms.database.a.atv().atx();
        for (a.C0364a c0364a : aVar.cBP) {
            if (c0364a != null) {
                if (c0364a.errorCode != 0) {
                    this.cBm.Pn().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAY + "，Server返回错误"));
                } else if (c0364a.cBQ != null && c0364a.cBR != null) {
                    c0364a.cBR.appId = c0364a.cAY;
                    a(c0364a.cBQ, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = atx.get(c0364a.cAY);
                    if (pMSAppInfo == null) {
                        this.cBm.Pn().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAY + "，本地记录不存在"));
                    } else if (c0364a.cBQ == null && c0364a.cBR != null) {
                        c0364a.cBR.appId = c0364a.cAY;
                        this.cBm.Pn().a(c0364a.cBR, pMSAppInfo);
                    } else if (c0364a.cBQ != null && c0364a.cBR == null) {
                        c0364a.cBS = true;
                        c0364a.cBR = pMSAppInfo;
                        a(c0364a.cBQ, eVar);
                    }
                }
            }
        }
        if (eVar.aut() == 0) {
            this.cBm.Pi();
            return null;
        }
        this.cBm.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cBm);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean Q(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.cBP == null || aVar.cBP.isEmpty()) {
            return false;
        }
        for (a.C0364a c0364a : aVar.cBP) {
            if (TextUtils.isEmpty(c0364a.cAY)) {
                return false;
            }
            if (c0364a.errorCode == 0) {
                if (c0364a.cBQ == null && c0364a.cBR == null) {
                    return false;
                }
                if (c0364a.cBQ != null && !c0364a.cBQ.PU()) {
                    return false;
                }
                if (c0364a.cBR != null && !c0364a.cBR.PU()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajl() {
        return "getpkglist";
    }
}
