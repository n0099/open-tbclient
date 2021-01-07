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
        this.ewT.aue();
        f fVar = new f();
        Map<String, PMSAppInfo> bge = com.baidu.swan.pms.database.a.bgc().bge();
        ArrayList arrayList = new ArrayList();
        for (a.C0559a c0559a : aVar.exz) {
            if (c0559a != null) {
                if (c0559a.errorCode != 0) {
                    this.ewT.auf().a(c0559a, bge.get(c0559a.ewI), new com.baidu.swan.pms.model.a(c0559a.errorCode, c0559a.ewI + "，Server返回错误"));
                } else {
                    if (c0559a.exB != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0559a.exB) {
                            if (gVar != null) {
                                gVar.appId = c0559a.ewI;
                            }
                        }
                        a(c0559a.exB, fVar);
                        arrayList.addAll(c0559a.exB);
                    }
                    if (c0559a.exA != null && c0559a.exC != null) {
                        c0559a.exC.appId = c0559a.ewI;
                        a(c0559a.exA, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bge.get(c0559a.ewI);
                        if (pMSAppInfo == null) {
                            if (c0559a.exC != null) {
                                c0559a.exC.appId = c0559a.ewI;
                                if (c0559a.exB != null && !c0559a.exB.isEmpty()) {
                                    c0559a.exC.m(c0559a.exB.get(0));
                                }
                                this.ewT.auf().b(c0559a.exC, null);
                            } else {
                                this.ewT.auf().a(c0559a, null, new com.baidu.swan.pms.model.a(c0559a.errorCode, c0559a.ewI + "，本地记录不存在"));
                            }
                        } else if (c0559a.exA == null && c0559a.exC != null) {
                            c0559a.exC.appId = c0559a.ewI;
                            this.ewT.auf().b(c0559a.exC, pMSAppInfo);
                        } else if (c0559a.exA != null && c0559a.exC == null) {
                            c0559a.exD = true;
                            c0559a.exC = pMSAppInfo;
                            a(c0559a.exA, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bhs() == 0) {
            this.ewT.ard();
        } else {
            this.ewT.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.ewT);
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
        if (aVar.exz == null || aVar.exz.isEmpty()) {
            return false;
        }
        for (a.C0559a c0559a : aVar.exz) {
            if (TextUtils.isEmpty(c0559a.ewI)) {
                return false;
            }
            if (c0559a.errorCode == 0) {
                if (c0559a.exA == null && c0559a.exC == null && c0559a.exB == null) {
                    return false;
                }
                if (c0559a.exA != null && !c0559a.exA.auW()) {
                    return false;
                }
                if (c0559a.exC != null && !c0559a.exC.auW()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bgr() {
        return "getpkglist";
    }
}
