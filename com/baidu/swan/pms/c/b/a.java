package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cs */
    public com.baidu.swan.pms.c.c.a cr(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cF(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ag(com.baidu.swan.pms.c.c.a aVar) {
        this.dFu.aiw();
        f fVar = new f();
        Map<String, PMSAppInfo> aTv = com.baidu.swan.pms.database.a.aTt().aTv();
        ArrayList arrayList = new ArrayList();
        for (a.C0520a c0520a : aVar.dGa) {
            if (c0520a != null) {
                if (c0520a.errorCode != 0) {
                    this.dFu.aix().a(c0520a, aTv.get(c0520a.dFj), new com.baidu.swan.pms.model.a(c0520a.errorCode, c0520a.dFj + "，Server返回错误"));
                } else {
                    if (c0520a.dGc != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0520a.dGc) {
                            if (gVar != null) {
                                gVar.appId = c0520a.dFj;
                            }
                        }
                        a(c0520a.dGc, fVar);
                        arrayList.addAll(c0520a.dGc);
                    }
                    if (c0520a.dGb != null && c0520a.dGd != null) {
                        c0520a.dGd.appId = c0520a.dFj;
                        a(c0520a.dGb, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aTv.get(c0520a.dFj);
                        if (pMSAppInfo == null) {
                            if (c0520a.dGd != null) {
                                c0520a.dGd.appId = c0520a.dFj;
                                if (c0520a.dGc != null && !c0520a.dGc.isEmpty()) {
                                    c0520a.dGd.m(c0520a.dGc.get(0));
                                }
                                this.dFu.aix().b(c0520a.dGd, null);
                            } else {
                                this.dFu.aix().a(c0520a, null, new com.baidu.swan.pms.model.a(c0520a.errorCode, c0520a.dFj + "，本地记录不存在"));
                            }
                        } else if (c0520a.dGb == null && c0520a.dGd != null) {
                            c0520a.dGd.appId = c0520a.dFj;
                            this.dFu.aix().b(c0520a.dGd, pMSAppInfo);
                        } else if (c0520a.dGb != null && c0520a.dGd == null) {
                            c0520a.dGe = true;
                            c0520a.dGd = pMSAppInfo;
                            a(c0520a.dGb, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aUK() == 0) {
            this.dFu.afB();
        } else {
            this.dFu.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.dFu);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ah(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dGa == null || aVar.dGa.isEmpty()) {
            return false;
        }
        for (a.C0520a c0520a : aVar.dGa) {
            if (TextUtils.isEmpty(c0520a.dFj)) {
                return false;
            }
            if (c0520a.errorCode == 0) {
                if (c0520a.dGb == null && c0520a.dGd == null && c0520a.dGc == null) {
                    return false;
                }
                if (c0520a.dGb != null && !c0520a.dGb.ajo()) {
                    return false;
                }
                if (c0520a.dGd != null && !c0520a.dGd.ajo()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aTI() {
        return "getpkglist";
    }
}
