package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cM */
    public com.baidu.swan.pms.c.c.a cL(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cZ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.a aVar) {
        this.eun.aqH();
        f fVar = new f();
        Map<String, PMSAppInfo> bcx = com.baidu.swan.pms.database.a.bcv().bcx();
        ArrayList arrayList = new ArrayList();
        for (a.C0539a c0539a : aVar.euS) {
            if (c0539a != null) {
                if (c0539a.errorCode != 0) {
                    this.eun.aqI().a(c0539a, bcx.get(c0539a.euc), new com.baidu.swan.pms.model.a(c0539a.errorCode, c0539a.euc + "，Server返回错误"));
                } else {
                    if (c0539a.euU != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0539a.euU) {
                            if (gVar != null) {
                                gVar.appId = c0539a.euc;
                            }
                        }
                        a(c0539a.euU, fVar);
                        arrayList.addAll(c0539a.euU);
                    }
                    if (c0539a.euT != null && c0539a.euV != null) {
                        c0539a.euV.appId = c0539a.euc;
                        a(c0539a.euT, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bcx.get(c0539a.euc);
                        if (pMSAppInfo == null) {
                            if (c0539a.euV != null) {
                                c0539a.euV.appId = c0539a.euc;
                                if (c0539a.euU != null && !c0539a.euU.isEmpty()) {
                                    c0539a.euV.m(c0539a.euU.get(0));
                                }
                                this.eun.aqI().b(c0539a.euV, null);
                            } else {
                                this.eun.aqI().a(c0539a, null, new com.baidu.swan.pms.model.a(c0539a.errorCode, c0539a.euc + "，本地记录不存在"));
                            }
                        } else if (c0539a.euT == null && c0539a.euV != null) {
                            c0539a.euV.appId = c0539a.euc;
                            this.eun.aqI().b(c0539a.euV, pMSAppInfo);
                        } else if (c0539a.euT != null && c0539a.euV == null) {
                            c0539a.euW = true;
                            c0539a.euV = pMSAppInfo;
                            a(c0539a.euT, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bdL() == 0) {
            this.eun.anG();
        } else {
            this.eun.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.eun);
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
        if (aVar.euS == null || aVar.euS.isEmpty()) {
            return false;
        }
        for (a.C0539a c0539a : aVar.euS) {
            if (TextUtils.isEmpty(c0539a.euc)) {
                return false;
            }
            if (c0539a.errorCode == 0) {
                if (c0539a.euT == null && c0539a.euV == null && c0539a.euU == null) {
                    return false;
                }
                if (c0539a.euT != null && !c0539a.euT.arz()) {
                    return false;
                }
                if (c0539a.euV != null && !c0539a.euV.arz()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcK() {
        return "getpkglist";
    }
}
