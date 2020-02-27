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
        this.cBl.Pk();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> atv = com.baidu.swan.pms.database.a.att().atv();
        for (a.C0364a c0364a : aVar.cBO) {
            if (c0364a != null) {
                if (c0364a.errorCode != 0) {
                    this.cBl.Pl().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAX + "，Server返回错误"));
                } else if (c0364a.cBP != null && c0364a.cBQ != null) {
                    c0364a.cBQ.appId = c0364a.cAX;
                    a(c0364a.cBP, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = atv.get(c0364a.cAX);
                    if (pMSAppInfo == null) {
                        this.cBl.Pl().b(new com.baidu.swan.pms.model.a(c0364a.errorCode, c0364a.cAX + "，本地记录不存在"));
                    } else if (c0364a.cBP == null && c0364a.cBQ != null) {
                        c0364a.cBQ.appId = c0364a.cAX;
                        this.cBl.Pl().a(c0364a.cBQ, pMSAppInfo);
                    } else if (c0364a.cBP != null && c0364a.cBQ == null) {
                        c0364a.cBR = true;
                        c0364a.cBQ = pMSAppInfo;
                        a(c0364a.cBP, eVar);
                    }
                }
            }
        }
        if (eVar.aur() == 0) {
            this.cBl.Pg();
            return null;
        }
        this.cBl.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cBl);
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
        if (aVar.cBO == null || aVar.cBO.isEmpty()) {
            return false;
        }
        for (a.C0364a c0364a : aVar.cBO) {
            if (TextUtils.isEmpty(c0364a.cAX)) {
                return false;
            }
            if (c0364a.errorCode == 0) {
                if (c0364a.cBP == null && c0364a.cBQ == null) {
                    return false;
                }
                if (c0364a.cBP != null && !c0364a.cBP.PS()) {
                    return false;
                }
                if (c0364a.cBQ != null && !c0364a.cBQ.PS()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajj() {
        return "getpkglist";
    }
}
