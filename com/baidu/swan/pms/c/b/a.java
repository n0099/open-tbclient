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
    /* renamed from: cH */
    public com.baidu.swan.pms.c.c.a cG(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cU(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.a aVar) {
        this.enl.asM();
        f fVar = new f();
        Map<String, PMSAppInfo> bdH = com.baidu.swan.pms.database.a.bdF().bdH();
        ArrayList arrayList = new ArrayList();
        for (a.C0568a c0568a : aVar.enR) {
            if (c0568a != null) {
                if (c0568a.errorCode != 0) {
                    this.enl.asN().a(c0568a, bdH.get(c0568a.emZ), new com.baidu.swan.pms.model.a(c0568a.errorCode, c0568a.emZ + "，Server返回错误"));
                } else {
                    if (c0568a.enT != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0568a.enT) {
                            if (gVar != null) {
                                gVar.appId = c0568a.emZ;
                            }
                        }
                        a(c0568a.enT, fVar);
                        arrayList.addAll(c0568a.enT);
                    }
                    if (c0568a.enS != null && c0568a.enU != null) {
                        c0568a.enU.appId = c0568a.emZ;
                        a(c0568a.enS, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bdH.get(c0568a.emZ);
                        if (pMSAppInfo == null) {
                            if (c0568a.enU != null) {
                                c0568a.enU.appId = c0568a.emZ;
                                if (c0568a.enT != null && !c0568a.enT.isEmpty()) {
                                    c0568a.enU.m(c0568a.enT.get(0));
                                }
                                this.enl.asN().b(c0568a.enU, null);
                            } else {
                                this.enl.asN().a(c0568a, null, new com.baidu.swan.pms.model.a(c0568a.errorCode, c0568a.emZ + "，本地记录不存在"));
                            }
                        } else if (c0568a.enS == null && c0568a.enU != null) {
                            c0568a.enU.appId = c0568a.emZ;
                            this.enl.asN().b(c0568a.enU, pMSAppInfo);
                        } else if (c0568a.enS != null && c0568a.enU == null) {
                            c0568a.enV = true;
                            c0568a.enU = pMSAppInfo;
                            a(c0568a.enS, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.beW() == 0) {
            this.enl.apQ();
        } else {
            this.enl.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.enl);
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
        if (aVar.enR == null || aVar.enR.isEmpty()) {
            return false;
        }
        for (a.C0568a c0568a : aVar.enR) {
            if (TextUtils.isEmpty(c0568a.emZ)) {
                return false;
            }
            if (c0568a.errorCode == 0) {
                if (c0568a.enS == null && c0568a.enU == null && c0568a.enT == null) {
                    return false;
                }
                if (c0568a.enS != null && !c0568a.enS.atE()) {
                    return false;
                }
                if (c0568a.enU != null && !c0568a.enU.atE()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bdU() {
        return "getpkglist";
    }
}
