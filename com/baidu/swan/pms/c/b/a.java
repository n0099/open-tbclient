package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bZ */
    public com.baidu.swan.pms.c.c.a bA(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.ch(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a S(com.baidu.swan.pms.c.c.a aVar) {
        this.dax.Xe();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> aBK = com.baidu.swan.pms.database.a.aBI().aBK();
        for (a.C0394a c0394a : aVar.dbb) {
            if (c0394a != null) {
                if (c0394a.errorCode != 0) {
                    this.dax.Xf().b(new com.baidu.swan.pms.model.a(c0394a.errorCode, c0394a.dai + "，Server返回错误"));
                } else if (c0394a.dbc != null && c0394a.dbd != null) {
                    c0394a.dbd.appId = c0394a.dai;
                    a(c0394a.dbc, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = aBK.get(c0394a.dai);
                    if (pMSAppInfo == null) {
                        this.dax.Xf().b(new com.baidu.swan.pms.model.a(c0394a.errorCode, c0394a.dai + "，本地记录不存在"));
                    } else if (c0394a.dbc == null && c0394a.dbd != null) {
                        c0394a.dbd.appId = c0394a.dai;
                        this.dax.Xf().a(c0394a.dbd, pMSAppInfo);
                    } else if (c0394a.dbc != null && c0394a.dbd == null) {
                        c0394a.dbe = true;
                        c0394a.dbd = pMSAppInfo;
                        a(c0394a.dbc, eVar);
                    }
                }
            }
        }
        if (eVar.aCH() == 0) {
            this.dax.Xa();
            return null;
        }
        this.dax.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.dax);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean R(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dbb == null || aVar.dbb.isEmpty()) {
            return false;
        }
        for (a.C0394a c0394a : aVar.dbb) {
            if (TextUtils.isEmpty(c0394a.dai)) {
                return false;
            }
            if (c0394a.errorCode == 0) {
                if (c0394a.dbc == null && c0394a.dbd == null) {
                    return false;
                }
                if (c0394a.dbc != null && !c0394a.dbc.XM()) {
                    return false;
                }
                if (c0394a.dbd != null && !c0394a.dbd.XM()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arw() {
        return "getpkglist";
    }
}
