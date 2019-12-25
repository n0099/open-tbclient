package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
    public com.baidu.swan.pms.model.a P(com.baidu.swan.pms.c.c.a aVar) {
        this.cxc.MA();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> aqO = com.baidu.swan.pms.database.a.aqM().aqO();
        for (a.C0352a c0352a : aVar.cxF) {
            if (c0352a != null) {
                if (c0352a.errorCode != 0) {
                    this.cxc.MB().b(new com.baidu.swan.pms.model.a(c0352a.errorCode, c0352a.cwO + "，Server返回错误"));
                } else if (c0352a.cxG != null && c0352a.cxH != null) {
                    c0352a.cxH.appId = c0352a.cwO;
                    a(c0352a.cxG, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = aqO.get(c0352a.cwO);
                    if (pMSAppInfo == null) {
                        this.cxc.MB().b(new com.baidu.swan.pms.model.a(c0352a.errorCode, c0352a.cwO + "，本地记录不存在"));
                    } else if (c0352a.cxG == null && c0352a.cxH != null) {
                        c0352a.cxH.appId = c0352a.cwO;
                        this.cxc.MB().a(c0352a.cxH, pMSAppInfo);
                    } else if (c0352a.cxG != null && c0352a.cxH == null) {
                        c0352a.cxI = true;
                        c0352a.cxH = pMSAppInfo;
                        a(c0352a.cxG, eVar);
                    }
                }
            }
        }
        if (eVar.arK() == 0) {
            this.cxc.Mw();
            return null;
        }
        this.cxc.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cxc);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.cxF == null || aVar.cxF.isEmpty()) {
            return false;
        }
        for (a.C0352a c0352a : aVar.cxF) {
            if (TextUtils.isEmpty(c0352a.cwO)) {
                return false;
            }
            if (c0352a.errorCode == 0) {
                if (c0352a.cxG == null && c0352a.cxH == null) {
                    return false;
                }
                if (c0352a.cxG != null && !c0352a.cxG.Ni()) {
                    return false;
                }
                if (c0352a.cxH != null && !c0352a.cxH.Ni()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agC() {
        return "getpkglist";
    }
}
