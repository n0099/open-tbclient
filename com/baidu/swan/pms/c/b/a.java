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
        this.dFy.aiw();
        f fVar = new f();
        Map<String, PMSAppInfo> aTv = com.baidu.swan.pms.database.a.aTt().aTv();
        ArrayList arrayList = new ArrayList();
        for (a.C0520a c0520a : aVar.dGe) {
            if (c0520a != null) {
                if (c0520a.errorCode != 0) {
                    this.dFy.aix().a(c0520a, aTv.get(c0520a.dFn), new com.baidu.swan.pms.model.a(c0520a.errorCode, c0520a.dFn + "，Server返回错误"));
                } else {
                    if (c0520a.dGg != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0520a.dGg) {
                            if (gVar != null) {
                                gVar.appId = c0520a.dFn;
                            }
                        }
                        a(c0520a.dGg, fVar);
                        arrayList.addAll(c0520a.dGg);
                    }
                    if (c0520a.dGf != null && c0520a.dGh != null) {
                        c0520a.dGh.appId = c0520a.dFn;
                        a(c0520a.dGf, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aTv.get(c0520a.dFn);
                        if (pMSAppInfo == null) {
                            if (c0520a.dGh != null) {
                                c0520a.dGh.appId = c0520a.dFn;
                                if (c0520a.dGg != null && !c0520a.dGg.isEmpty()) {
                                    c0520a.dGh.m(c0520a.dGg.get(0));
                                }
                                this.dFy.aix().b(c0520a.dGh, null);
                            } else {
                                this.dFy.aix().a(c0520a, null, new com.baidu.swan.pms.model.a(c0520a.errorCode, c0520a.dFn + "，本地记录不存在"));
                            }
                        } else if (c0520a.dGf == null && c0520a.dGh != null) {
                            c0520a.dGh.appId = c0520a.dFn;
                            this.dFy.aix().b(c0520a.dGh, pMSAppInfo);
                        } else if (c0520a.dGf != null && c0520a.dGh == null) {
                            c0520a.dGi = true;
                            c0520a.dGh = pMSAppInfo;
                            a(c0520a.dGf, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aUK() == 0) {
            this.dFy.afB();
        } else {
            this.dFy.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.dFy);
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
        if (aVar.dGe == null || aVar.dGe.isEmpty()) {
            return false;
        }
        for (a.C0520a c0520a : aVar.dGe) {
            if (TextUtils.isEmpty(c0520a.dFn)) {
                return false;
            }
            if (c0520a.errorCode == 0) {
                if (c0520a.dGf == null && c0520a.dGh == null && c0520a.dGg == null) {
                    return false;
                }
                if (c0520a.dGf != null && !c0520a.dGf.ajo()) {
                    return false;
                }
                if (c0520a.dGh != null && !c0520a.dGh.ajo()) {
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
