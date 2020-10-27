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
    /* renamed from: cF */
    public com.baidu.swan.pms.c.c.a cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cS(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.a aVar) {
        this.ebZ.anL();
        f fVar = new f();
        Map<String, PMSAppInfo> aYJ = com.baidu.swan.pms.database.a.aYH().aYJ();
        ArrayList arrayList = new ArrayList();
        for (a.C0546a c0546a : aVar.ecF) {
            if (c0546a != null) {
                if (c0546a.errorCode != 0) {
                    this.ebZ.anM().a(c0546a, aYJ.get(c0546a.ebO), new com.baidu.swan.pms.model.a(c0546a.errorCode, c0546a.ebO + "，Server返回错误"));
                } else {
                    if (c0546a.ecH != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0546a.ecH) {
                            if (gVar != null) {
                                gVar.appId = c0546a.ebO;
                            }
                        }
                        a(c0546a.ecH, fVar);
                        arrayList.addAll(c0546a.ecH);
                    }
                    if (c0546a.ecG != null && c0546a.ecI != null) {
                        c0546a.ecI.appId = c0546a.ebO;
                        a(c0546a.ecG, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = aYJ.get(c0546a.ebO);
                        if (pMSAppInfo == null) {
                            if (c0546a.ecI != null) {
                                c0546a.ecI.appId = c0546a.ebO;
                                if (c0546a.ecH != null && !c0546a.ecH.isEmpty()) {
                                    c0546a.ecI.m(c0546a.ecH.get(0));
                                }
                                this.ebZ.anM().b(c0546a.ecI, null);
                            } else {
                                this.ebZ.anM().a(c0546a, null, new com.baidu.swan.pms.model.a(c0546a.errorCode, c0546a.ebO + "，本地记录不存在"));
                            }
                        } else if (c0546a.ecG == null && c0546a.ecI != null) {
                            c0546a.ecI.appId = c0546a.ebO;
                            this.ebZ.anM().b(c0546a.ecI, pMSAppInfo);
                        } else if (c0546a.ecG != null && c0546a.ecI == null) {
                            c0546a.ecJ = true;
                            c0546a.ecI = pMSAppInfo;
                            a(c0546a.ecG, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.aZY() == 0) {
            this.ebZ.akQ();
        } else {
            this.ebZ.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.ebZ);
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
        if (aVar.ecF == null || aVar.ecF.isEmpty()) {
            return false;
        }
        for (a.C0546a c0546a : aVar.ecF) {
            if (TextUtils.isEmpty(c0546a.ebO)) {
                return false;
            }
            if (c0546a.errorCode == 0) {
                if (c0546a.ecG == null && c0546a.ecI == null && c0546a.ecH == null) {
                    return false;
                }
                if (c0546a.ecG != null && !c0546a.ecG.aoD()) {
                    return false;
                }
                if (c0546a.ecI != null && !c0546a.ecI.aoD()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aYW() {
        return "getpkglist";
    }
}
