package com.baidu.swan.a.a;

import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.PMSPkgStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.pms.c.d<c> {
    public b(a aVar, com.baidu.swan.a.a aVar2) {
        super(aVar2, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: by */
    public c bz(JSONObject jSONObject) {
        return (c) com.baidu.swan.pms.f.d.a(jSONObject, new c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(c cVar) {
        this.dlN.ZP();
        e eVar = new e();
        eVar.a(cVar, PMSPkgStatus.WAIT);
        this.dlN.a(eVar);
        com.baidu.swan.a.d.a(cVar, (com.baidu.swan.a.a) this.dlN);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(c cVar) {
        return cVar != null && cVar.aaF();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ave() {
        return "getSailor";
    }
}
