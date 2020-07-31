package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.f.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cn */
    public com.baidu.swan.pms.c.c.a bL(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.e.cA(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.a aVar) {
        this.dwq.abX();
        f fVar = new f();
        Map<String, PMSAppInfo> aKU = com.baidu.swan.pms.database.a.aKS().aKU();
        ArrayList arrayList = new ArrayList();
        for (a.C0474a c0474a : aVar.dwV) {
            if (c0474a != null) {
                if (c0474a.errorCode != 0) {
                    this.dwq.abY().a(c0474a, aKU.get(c0474a.dvZ), new com.baidu.swan.pms.model.a(c0474a.errorCode, c0474a.dvZ + "，Server返回错误"));
                } else {
                    if (c0474a.dwX != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0474a.dwX) {
                            if (gVar != null) {
                                gVar.appId = c0474a.dvZ;
                            }
                        }
                        a(c0474a.dwX, fVar);
                        arrayList.addAll(c0474a.dwX);
                    }
                    if (c0474a.dwW != null && c0474a.dwY != null) {
                        c0474a.dwY.appId = c0474a.dvZ;
                        a(c0474a.dwW, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aKU.get(c0474a.dvZ);
                        if (pMSAppInfo == null) {
                            if (c0474a.dwY != null) {
                                c0474a.dwY.appId = c0474a.dvZ;
                                if (c0474a.dwX != null && !c0474a.dwX.isEmpty()) {
                                    c0474a.dwY.m(c0474a.dwX.get(0));
                                }
                                this.dwq.abY().b(c0474a.dwY, null);
                            } else {
                                this.dwq.abY().a(c0474a, null, new com.baidu.swan.pms.model.a(c0474a.errorCode, c0474a.dvZ + "，本地记录不存在"));
                            }
                        } else if (c0474a.dwW == null && c0474a.dwY != null) {
                            c0474a.dwY.appId = c0474a.dvZ;
                            this.dwq.abY().b(c0474a.dwY, pMSAppInfo);
                        } else if (c0474a.dwW != null && c0474a.dwY == null) {
                            c0474a.dwZ = true;
                            c0474a.dwY = pMSAppInfo;
                            a(c0474a.dwW, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aMl() == 0) {
            this.dwq.Zs();
        } else {
            this.dwq.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.dwq);
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
        if (aVar.dwV == null || aVar.dwV.isEmpty()) {
            return false;
        }
        for (a.C0474a c0474a : aVar.dwV) {
            if (TextUtils.isEmpty(c0474a.dvZ)) {
                return false;
            }
            if (c0474a.errorCode == 0) {
                if (c0474a.dwW == null && c0474a.dwY == null && c0474a.dwX == null) {
                    return false;
                }
                if (c0474a.dwW != null && !c0474a.dwW.acP()) {
                    return false;
                }
                if (c0474a.dwY != null && !c0474a.dwY.acP()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "getpkglist";
    }
}
