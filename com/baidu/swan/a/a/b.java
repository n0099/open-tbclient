package com.baidu.swan.a.a;

import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.PMSPkgStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.pms.c.d<c> {
    public b(a aVar, com.baidu.swan.a.a aVar2) {
        super(aVar2, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bo */
    public c bp(JSONObject jSONObject) {
        return (c) com.baidu.swan.pms.f.d.a(jSONObject, new c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a P(c cVar) {
        this.cxn.MW();
        e eVar = new e();
        eVar.a(cVar, PMSPkgStatus.WAIT);
        this.cxn.a(eVar);
        com.baidu.swan.a.d.a(cVar, (com.baidu.swan.a.a) this.cxn);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(c cVar) {
        return cVar != null && cVar.NE();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agV() {
        return "getSailor";
    }
}
