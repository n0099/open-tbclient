package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cP */
    public com.baidu.swan.pms.c.c.a cO(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.dc(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.a aVar) {
        this.esg.aqj();
        f fVar = new f();
        Map<String, PMSAppInfo> bck = com.baidu.swan.pms.database.a.bci().bck();
        ArrayList arrayList = new ArrayList();
        for (a.C0542a c0542a : aVar.esL) {
            if (c0542a != null) {
                if (c0542a.errorCode != 0) {
                    this.esg.aqk().a(c0542a, bck.get(c0542a.erV), new com.baidu.swan.pms.model.a(c0542a.errorCode, c0542a.erV + "，Server返回错误"));
                } else {
                    if (c0542a.esN != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0542a.esN) {
                            if (gVar != null) {
                                gVar.appId = c0542a.erV;
                            }
                        }
                        a(c0542a.esN, fVar);
                        arrayList.addAll(c0542a.esN);
                    }
                    if (c0542a.esM != null && c0542a.esO != null) {
                        c0542a.esO.appId = c0542a.erV;
                        a(c0542a.esM, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bck.get(c0542a.erV);
                        if (pMSAppInfo == null) {
                            if (c0542a.esO != null) {
                                c0542a.esO.appId = c0542a.erV;
                                if (c0542a.esN != null && !c0542a.esN.isEmpty()) {
                                    c0542a.esO.m(c0542a.esN.get(0));
                                }
                                this.esg.aqk().b(c0542a.esO, null);
                            } else {
                                this.esg.aqk().a(c0542a, null, new com.baidu.swan.pms.model.a(c0542a.errorCode, c0542a.erV + "，本地记录不存在"));
                            }
                        } else if (c0542a.esM == null && c0542a.esO != null) {
                            c0542a.esO.appId = c0542a.erV;
                            this.esg.aqk().b(c0542a.esO, pMSAppInfo);
                        } else if (c0542a.esM != null && c0542a.esO == null) {
                            c0542a.esP = true;
                            c0542a.esO = pMSAppInfo;
                            a(c0542a.esM, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bdy() == 0) {
            this.esg.ani();
        } else {
            this.esg.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.esg);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.esL == null || aVar.esL.isEmpty()) {
            return false;
        }
        for (a.C0542a c0542a : aVar.esL) {
            if (TextUtils.isEmpty(c0542a.erV)) {
                return false;
            }
            if (c0542a.errorCode == 0) {
                if (c0542a.esM == null && c0542a.esO == null && c0542a.esN == null) {
                    return false;
                }
                if (c0542a.esM != null && !c0542a.esM.arb()) {
                    return false;
                }
                if (c0542a.esO != null && !c0542a.esO.arb()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcx() {
        return "getpkglist";
    }
}
