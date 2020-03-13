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
        this.cBn.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> atx = com.baidu.swan.pms.database.a.atv().atx();
        for (a.C0364a c0364a : aVar.cBQ) {
            if (c0364a != null) {
                if (c0364a.errorCode != 0) {
                    this.cBn.Pn().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAZ + "，Server返回错误"));
                } else if (c0364a.cBR != null && c0364a.cBS != null) {
                    c0364a.cBS.appId = c0364a.cAZ;
                    a(c0364a.cBR, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = atx.get(c0364a.cAZ);
                    if (pMSAppInfo == null) {
                        this.cBn.Pn().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAZ + "，本地记录不存在"));
                    } else if (c0364a.cBR == null && c0364a.cBS != null) {
                        c0364a.cBS.appId = c0364a.cAZ;
                        this.cBn.Pn().a(c0364a.cBS, pMSAppInfo);
                    } else if (c0364a.cBR != null && c0364a.cBS == null) {
                        c0364a.cBT = true;
                        c0364a.cBS = pMSAppInfo;
                        a(c0364a.cBR, eVar);
                    }
                }
            }
        }
        if (eVar.aut() == 0) {
            this.cBn.Pi();
            return null;
        }
        this.cBn.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cBn);
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
        if (aVar.cBQ == null || aVar.cBQ.isEmpty()) {
            return false;
        }
        for (a.C0364a c0364a : aVar.cBQ) {
            if (TextUtils.isEmpty(c0364a.cAZ)) {
                return false;
            }
            if (c0364a.errorCode == 0) {
                if (c0364a.cBR == null && c0364a.cBS == null) {
                    return false;
                }
                if (c0364a.cBR != null && !c0364a.cBR.PU()) {
                    return false;
                }
                if (c0364a.cBS != null && !c0364a.cBS.PU()) {
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
