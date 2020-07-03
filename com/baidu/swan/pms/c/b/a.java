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
    /* renamed from: ch */
    public com.baidu.swan.pms.c.c.a bG(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cu(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.a aVar) {
        this.dqy.aaV();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> aHd = com.baidu.swan.pms.database.a.aHb().aHd();
        for (a.C0462a c0462a : aVar.drd) {
            if (c0462a != null) {
                if (c0462a.errorCode != 0) {
                    this.dqy.aaW().a(c0462a, aHd.get(c0462a.dqi), new com.baidu.swan.pms.model.a(c0462a.errorCode, c0462a.dqi + "，Server返回错误"));
                } else if (c0462a.dre != null && c0462a.drf != null) {
                    c0462a.drf.appId = c0462a.dqi;
                    a(c0462a.dre, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = aHd.get(c0462a.dqi);
                    if (pMSAppInfo == null) {
                        this.dqy.aaW().a(c0462a, null, new com.baidu.swan.pms.model.a(c0462a.errorCode, c0462a.dqi + "，本地记录不存在"));
                    } else if (c0462a.dre == null && c0462a.drf != null) {
                        c0462a.drf.appId = c0462a.dqi;
                        this.dqy.aaW().b(c0462a.drf, pMSAppInfo);
                    } else if (c0462a.dre != null && c0462a.drf == null) {
                        c0462a.drg = true;
                        c0462a.drf = pMSAppInfo;
                        a(c0462a.dre, eVar);
                    }
                }
            }
        }
        if (eVar.aIt() == 0) {
            this.dqy.aaR();
        } else {
            this.dqy.a(eVar);
            com.baidu.swan.pms.c.a.a.a(aVar, this.dqy);
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
        if (aVar.drd == null || aVar.drd.isEmpty()) {
            return false;
        }
        for (a.C0462a c0462a : aVar.drd) {
            if (TextUtils.isEmpty(c0462a.dqi)) {
                return false;
            }
            if (c0462a.errorCode == 0) {
                if (c0462a.dre == null && c0462a.drf == null) {
                    return false;
                }
                if (c0462a.dre != null && !c0462a.dre.abL()) {
                    return false;
                }
                if (c0462a.drf != null && !c0462a.drf.abL()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String awk() {
        return "getpkglist";
    }
}
