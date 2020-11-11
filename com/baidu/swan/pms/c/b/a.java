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
    /* renamed from: cL */
    public com.baidu.swan.pms.c.c.a cK(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cY(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.a aVar) {
        this.ehR.aqm();
        f fVar = new f();
        Map<String, PMSAppInfo> bbj = com.baidu.swan.pms.database.a.bbh().bbj();
        ArrayList arrayList = new ArrayList();
        for (a.C0558a c0558a : aVar.eix) {
            if (c0558a != null) {
                if (c0558a.errorCode != 0) {
                    this.ehR.aqn().a(c0558a, bbj.get(c0558a.ehG), new com.baidu.swan.pms.model.a(c0558a.errorCode, c0558a.ehG + "，Server返回错误"));
                } else {
                    if (c0558a.eiz != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0558a.eiz) {
                            if (gVar != null) {
                                gVar.appId = c0558a.ehG;
                            }
                        }
                        a(c0558a.eiz, fVar);
                        arrayList.addAll(c0558a.eiz);
                    }
                    if (c0558a.eiy != null && c0558a.eiA != null) {
                        c0558a.eiA.appId = c0558a.ehG;
                        a(c0558a.eiy, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bbj.get(c0558a.ehG);
                        if (pMSAppInfo == null) {
                            if (c0558a.eiA != null) {
                                c0558a.eiA.appId = c0558a.ehG;
                                if (c0558a.eiz != null && !c0558a.eiz.isEmpty()) {
                                    c0558a.eiA.m(c0558a.eiz.get(0));
                                }
                                this.ehR.aqn().b(c0558a.eiA, null);
                            } else {
                                this.ehR.aqn().a(c0558a, null, new com.baidu.swan.pms.model.a(c0558a.errorCode, c0558a.ehG + "，本地记录不存在"));
                            }
                        } else if (c0558a.eiy == null && c0558a.eiA != null) {
                            c0558a.eiA.appId = c0558a.ehG;
                            this.ehR.aqn().b(c0558a.eiA, pMSAppInfo);
                        } else if (c0558a.eiy != null && c0558a.eiA == null) {
                            c0558a.eiB = true;
                            c0558a.eiA = pMSAppInfo;
                            a(c0558a.eiy, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bcy() == 0) {
            this.ehR.anq();
        } else {
            this.ehR.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.ehR);
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
        if (aVar.eix == null || aVar.eix.isEmpty()) {
            return false;
        }
        for (a.C0558a c0558a : aVar.eix) {
            if (TextUtils.isEmpty(c0558a.ehG)) {
                return false;
            }
            if (c0558a.errorCode == 0) {
                if (c0558a.eiy == null && c0558a.eiA == null && c0558a.eiz == null) {
                    return false;
                }
                if (c0558a.eiy != null && !c0558a.eiy.are()) {
                    return false;
                }
                if (c0558a.eiA != null && !c0558a.eiA.are()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bbw() {
        return "getpkglist";
    }
}
