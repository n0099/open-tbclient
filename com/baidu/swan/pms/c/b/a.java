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
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.c.c.a aVar) {
        this.daD.Xd();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        Map<String, PMSAppInfo> aBK = com.baidu.swan.pms.database.a.aBI().aBK();
        for (a.C0415a c0415a : aVar.dbg) {
            if (c0415a != null) {
                if (c0415a.errorCode != 0) {
                    this.daD.Xe().b(new com.baidu.swan.pms.model.a(c0415a.errorCode, c0415a.dan + "，Server返回错误"));
                } else if (c0415a.dbh != null && c0415a.dbi != null) {
                    c0415a.dbi.appId = c0415a.dan;
                    a(c0415a.dbh, eVar);
                } else {
                    PMSAppInfo pMSAppInfo = aBK.get(c0415a.dan);
                    if (pMSAppInfo == null) {
                        this.daD.Xe().b(new com.baidu.swan.pms.model.a(c0415a.errorCode, c0415a.dan + "，本地记录不存在"));
                    } else if (c0415a.dbh == null && c0415a.dbi != null) {
                        c0415a.dbi.appId = c0415a.dan;
                        this.daD.Xe().a(c0415a.dbi, pMSAppInfo);
                    } else if (c0415a.dbh != null && c0415a.dbi == null) {
                        c0415a.dbj = true;
                        c0415a.dbi = pMSAppInfo;
                        a(c0415a.dbh, eVar);
                    }
                }
            }
        }
        if (eVar.aCH() == 0) {
            this.daD.WZ();
            return null;
        }
        this.daD.a(eVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this.daD);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean S(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.dbg == null || aVar.dbg.isEmpty()) {
            return false;
        }
        for (a.C0415a c0415a : aVar.dbg) {
            if (TextUtils.isEmpty(c0415a.dan)) {
                return false;
            }
            if (c0415a.errorCode == 0) {
                if (c0415a.dbh == null && c0415a.dbi == null) {
                    return false;
                }
                if (c0415a.dbh != null && !c0415a.dbh.XL()) {
                    return false;
                }
                if (c0415a.dbi != null && !c0415a.dbi.XL()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arv() {
        return "getpkglist";
    }
}
