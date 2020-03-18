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
        this.cBy.Pp();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> atA = com.baidu.swan.pms.database.a.aty().atA();
        for (a.C0364a c0364a : aVar.cCb) {
            if (c0364a != null) {
                if (c0364a.errorCode != 0) {
                    this.cBy.Pq().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cBk + "，Server返回错误"));
                } else if (c0364a.cCc != null && c0364a.cCd != null) {
                    c0364a.cCd.appId = c0364a.cBk;
                    a(c0364a.cCc, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = atA.get(c0364a.cBk);
                    if (pMSAppInfo == null) {
                        this.cBy.Pq().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cBk + "，本地记录不存在"));
                    } else if (c0364a.cCc == null && c0364a.cCd != null) {
                        c0364a.cCd.appId = c0364a.cBk;
                        this.cBy.Pq().a(c0364a.cCd, pMSAppInfo);
                    } else if (c0364a.cCc != null && c0364a.cCd == null) {
                        c0364a.cCe = true;
                        c0364a.cCd = pMSAppInfo;
                        a(c0364a.cCc, eVar);
                    }
                }
            }
        }
        if (eVar.auw() == 0) {
            this.cBy.Pl();
            return null;
        }
        this.cBy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cBy);
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
        if (aVar.cCb == null || aVar.cCb.isEmpty()) {
            return false;
        }
        for (a.C0364a c0364a : aVar.cCb) {
            if (TextUtils.isEmpty(c0364a.cBk)) {
                return false;
            }
            if (c0364a.errorCode == 0) {
                if (c0364a.cCc == null && c0364a.cCd == null) {
                    return false;
                }
                if (c0364a.cCc != null && !c0364a.cCc.PX()) {
                    return false;
                }
                if (c0364a.cCd != null && !c0364a.cCd.PX()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajo() {
        return "getpkglist";
    }
}
