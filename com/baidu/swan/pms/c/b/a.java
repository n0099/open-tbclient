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
    /* renamed from: cF */
    public com.baidu.swan.pms.c.c.a cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cS(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.a aVar) {
        this.egj.apE();
        f fVar = new f();
        Map<String, PMSAppInfo> baC = com.baidu.swan.pms.database.a.baA().baC();
        ArrayList arrayList = new ArrayList();
        for (a.C0556a c0556a : aVar.egQ) {
            if (c0556a != null) {
                if (c0556a.errorCode != 0) {
                    this.egj.apF().a(c0556a, baC.get(c0556a.efY), new com.baidu.swan.pms.model.a(c0556a.errorCode, c0556a.efY + "，Server返回错误"));
                } else {
                    if (c0556a.egS != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0556a.egS) {
                            if (gVar != null) {
                                gVar.appId = c0556a.efY;
                            }
                        }
                        a(c0556a.egS, fVar);
                        arrayList.addAll(c0556a.egS);
                    }
                    if (c0556a.egR != null && c0556a.egT != null) {
                        c0556a.egT.appId = c0556a.efY;
                        a(c0556a.egR, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = baC.get(c0556a.efY);
                        if (pMSAppInfo == null) {
                            if (c0556a.egT != null) {
                                c0556a.egT.appId = c0556a.efY;
                                if (c0556a.egS != null && !c0556a.egS.isEmpty()) {
                                    c0556a.egT.m(c0556a.egS.get(0));
                                }
                                this.egj.apF().b(c0556a.egT, null);
                            } else {
                                this.egj.apF().a(c0556a, null, new com.baidu.swan.pms.model.a(c0556a.errorCode, c0556a.efY + "，本地记录不存在"));
                            }
                        } else if (c0556a.egR == null && c0556a.egT != null) {
                            c0556a.egT.appId = c0556a.efY;
                            this.egj.apF().b(c0556a.egT, pMSAppInfo);
                        } else if (c0556a.egR != null && c0556a.egT == null) {
                            c0556a.egU = true;
                            c0556a.egT = pMSAppInfo;
                            a(c0556a.egR, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bbR() == 0) {
            this.egj.amI();
        } else {
            this.egj.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.egj);
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
        if (aVar.egQ == null || aVar.egQ.isEmpty()) {
            return false;
        }
        for (a.C0556a c0556a : aVar.egQ) {
            if (TextUtils.isEmpty(c0556a.efY)) {
                return false;
            }
            if (c0556a.errorCode == 0) {
                if (c0556a.egR == null && c0556a.egT == null && c0556a.egS == null) {
                    return false;
                }
                if (c0556a.egR != null && !c0556a.egR.aqw()) {
                    return false;
                }
                if (c0556a.egT != null && !c0556a.egT.aqw()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String baP() {
        return "getpkglist";
    }
}
