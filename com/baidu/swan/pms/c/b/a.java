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
    /* renamed from: ca */
    public com.baidu.swan.pms.c.c.a bz(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cn(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.a aVar) {
        this.dlN.ZP();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> aFX = com.baidu.swan.pms.database.a.aFV().aFX();
        for (a.C0456a c0456a : aVar.dms) {
            if (c0456a != null) {
                if (c0456a.errorCode != 0) {
                    this.dlN.ZQ().a(c0456a, aFX.get(c0456a.dlx), new com.baidu.swan.pms.model.a(c0456a.errorCode, c0456a.dlx + "，Server返回错误"));
                } else if (c0456a.dmt != null && c0456a.dmu != null) {
                    c0456a.dmu.appId = c0456a.dlx;
                    a(c0456a.dmt, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = aFX.get(c0456a.dlx);
                    if (pMSAppInfo == null) {
                        this.dlN.ZQ().a(c0456a, null, new com.baidu.swan.pms.model.a(c0456a.errorCode, c0456a.dlx + "，本地记录不存在"));
                    } else if (c0456a.dmt == null && c0456a.dmu != null) {
                        c0456a.dmu.appId = c0456a.dlx;
                        this.dlN.ZQ().b(c0456a.dmu, pMSAppInfo);
                    } else if (c0456a.dmt != null && c0456a.dmu == null) {
                        c0456a.dmv = true;
                        c0456a.dmu = pMSAppInfo;
                        a(c0456a.dmt, eVar);
                    }
                }
            }
        }
        if (eVar.aHn() == 0) {
            this.dlN.ZL();
        } else {
            this.dlN.a(eVar);
            com.baidu.swan.pms.c.a.a.a(aVar, this.dlN);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dms == null || aVar.dms.isEmpty()) {
            return false;
        }
        for (a.C0456a c0456a : aVar.dms) {
            if (TextUtils.isEmpty(c0456a.dlx)) {
                return false;
            }
            if (c0456a.errorCode == 0) {
                if (c0456a.dmt == null && c0456a.dmu == null) {
                    return false;
                }
                if (c0456a.dmt != null && !c0456a.dmt.aaF()) {
                    return false;
                }
                if (c0456a.dmu != null && !c0456a.dmu.aaF()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ave() {
        return "getpkglist";
    }
}
