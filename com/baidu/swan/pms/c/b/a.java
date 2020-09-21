package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cv */
    public com.baidu.swan.pms.c.c.a cu(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cI(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ah(com.baidu.swan.pms.c.c.a aVar) {
        this.dHC.ajg();
        f fVar = new f();
        Map<String, PMSAppInfo> aUh = com.baidu.swan.pms.database.a.aUf().aUh();
        ArrayList arrayList = new ArrayList();
        for (a.C0515a c0515a : aVar.dIi) {
            if (c0515a != null) {
                if (c0515a.errorCode != 0) {
                    this.dHC.ajh().a(c0515a, aUh.get(c0515a.dHr), new com.baidu.swan.pms.model.a(c0515a.errorCode, c0515a.dHr + "，Server返回错误"));
                } else {
                    if (c0515a.dIk != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0515a.dIk) {
                            if (gVar != null) {
                                gVar.appId = c0515a.dHr;
                            }
                        }
                        a(c0515a.dIk, fVar);
                        arrayList.addAll(c0515a.dIk);
                    }
                    if (c0515a.dIj != null && c0515a.dIl != null) {
                        c0515a.dIl.appId = c0515a.dHr;
                        a(c0515a.dIj, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aUh.get(c0515a.dHr);
                        if (pMSAppInfo == null) {
                            if (c0515a.dIl != null) {
                                c0515a.dIl.appId = c0515a.dHr;
                                if (c0515a.dIk != null && !c0515a.dIk.isEmpty()) {
                                    c0515a.dIl.m(c0515a.dIk.get(0));
                                }
                                this.dHC.ajh().b(c0515a.dIl, null);
                            } else {
                                this.dHC.ajh().a(c0515a, null, new com.baidu.swan.pms.model.a(c0515a.errorCode, c0515a.dHr + "，本地记录不存在"));
                            }
                        } else if (c0515a.dIj == null && c0515a.dIl != null) {
                            c0515a.dIl.appId = c0515a.dHr;
                            this.dHC.ajh().b(c0515a.dIl, pMSAppInfo);
                        } else if (c0515a.dIj != null && c0515a.dIl == null) {
                            c0515a.dIm = true;
                            c0515a.dIl = pMSAppInfo;
                            a(c0515a.dIj, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aVw() == 0) {
            this.dHC.agl();
        } else {
            this.dHC.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.dHC);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ai(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dIi == null || aVar.dIi.isEmpty()) {
            return false;
        }
        for (a.C0515a c0515a : aVar.dIi) {
            if (TextUtils.isEmpty(c0515a.dHr)) {
                return false;
            }
            if (c0515a.errorCode == 0) {
                if (c0515a.dIj == null && c0515a.dIl == null && c0515a.dIk == null) {
                    return false;
                }
                if (c0515a.dIj != null && !c0515a.dIj.ajY()) {
                    return false;
                }
                if (c0515a.dIl != null && !c0515a.dIl.ajY()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aUu() {
        return "getpkglist";
    }
}
