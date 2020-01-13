package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
        this.cxn.MW();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> arh = com.baidu.swan.pms.database.a.arf().arh();
        for (a.C0354a c0354a : aVar.cxQ) {
            if (c0354a != null) {
                if (c0354a.errorCode != 0) {
                    this.cxn.MX().b(new com.baidu.swan.pms.model.a(c0354a.errorCode, c0354a.cwZ + "，Server返回错误"));
                } else if (c0354a.cxR != null && c0354a.cxS != null) {
                    c0354a.cxS.appId = c0354a.cwZ;
                    a(c0354a.cxR, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = arh.get(c0354a.cwZ);
                    if (pMSAppInfo == null) {
                        this.cxn.MX().b(new com.baidu.swan.pms.model.a(c0354a.errorCode, c0354a.cwZ + "，本地记录不存在"));
                    } else if (c0354a.cxR == null && c0354a.cxS != null) {
                        c0354a.cxS.appId = c0354a.cwZ;
                        this.cxn.MX().a(c0354a.cxS, pMSAppInfo);
                    } else if (c0354a.cxR != null && c0354a.cxS == null) {
                        c0354a.cxT = true;
                        c0354a.cxS = pMSAppInfo;
                        a(c0354a.cxR, eVar);
                    }
                }
            }
        }
        if (eVar.asd() == 0) {
            this.cxn.MS();
            return null;
        }
        this.cxn.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.cxn);
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
        if (aVar.cxQ == null || aVar.cxQ.isEmpty()) {
            return false;
        }
        for (a.C0354a c0354a : aVar.cxQ) {
            if (TextUtils.isEmpty(c0354a.cwZ)) {
                return false;
            }
            if (c0354a.errorCode == 0) {
                if (c0354a.cxR == null && c0354a.cxS == null) {
                    return false;
                }
                if (c0354a.cxR != null && !c0354a.cxR.NE()) {
                    return false;
                }
                if (c0354a.cxS != null && !c0354a.cxS.NE()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agV() {
        return "getpkglist";
    }
}
