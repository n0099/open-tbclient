package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cC */
    public com.baidu.swan.pms.c.c.a cB(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cP(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.a aVar) {
        this.dTD.alR();
        f fVar = new f();
        Map<String, PMSAppInfo> aWQ = com.baidu.swan.pms.database.a.aWO().aWQ();
        ArrayList arrayList = new ArrayList();
        for (a.C0532a c0532a : aVar.dUj) {
            if (c0532a != null) {
                if (c0532a.errorCode != 0) {
                    this.dTD.alS().a(c0532a, aWQ.get(c0532a.dTs), new com.baidu.swan.pms.model.a(c0532a.errorCode, c0532a.dTs + "，Server返回错误"));
                } else {
                    if (c0532a.dUl != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0532a.dUl) {
                            if (gVar != null) {
                                gVar.appId = c0532a.dTs;
                            }
                        }
                        a(c0532a.dUl, fVar);
                        arrayList.addAll(c0532a.dUl);
                    }
                    if (c0532a.dUk != null && c0532a.dUm != null) {
                        c0532a.dUm.appId = c0532a.dTs;
                        a(c0532a.dUk, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aWQ.get(c0532a.dTs);
                        if (pMSAppInfo == null) {
                            if (c0532a.dUm != null) {
                                c0532a.dUm.appId = c0532a.dTs;
                                if (c0532a.dUl != null && !c0532a.dUl.isEmpty()) {
                                    c0532a.dUm.m(c0532a.dUl.get(0));
                                }
                                this.dTD.alS().b(c0532a.dUm, null);
                            } else {
                                this.dTD.alS().a(c0532a, null, new com.baidu.swan.pms.model.a(c0532a.errorCode, c0532a.dTs + "，本地记录不存在"));
                            }
                        } else if (c0532a.dUk == null && c0532a.dUm != null) {
                            c0532a.dUm.appId = c0532a.dTs;
                            this.dTD.alS().b(c0532a.dUm, pMSAppInfo);
                        } else if (c0532a.dUk != null && c0532a.dUm == null) {
                            c0532a.dUn = true;
                            c0532a.dUm = pMSAppInfo;
                            a(c0532a.dUk, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aYf() == 0) {
            this.dTD.aiW();
        } else {
            this.dTD.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.dTD);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dUj == null || aVar.dUj.isEmpty()) {
            return false;
        }
        for (a.C0532a c0532a : aVar.dUj) {
            if (TextUtils.isEmpty(c0532a.dTs)) {
                return false;
            }
            if (c0532a.errorCode == 0) {
                if (c0532a.dUk == null && c0532a.dUm == null && c0532a.dUl == null) {
                    return false;
                }
                if (c0532a.dUk != null && !c0532a.dUk.amJ()) {
                    return false;
                }
                if (c0532a.dUm != null && !c0532a.dUm.amJ()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aXd() {
        return "getpkglist";
    }
}
