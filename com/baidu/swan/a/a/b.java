package com.baidu.swan.a.a;

import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.f.f;
import com.baidu.swan.pms.model.PMSPkgStatus;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.pms.c.d<c> {
    public b(a aVar, com.baidu.swan.a.a aVar2) {
        super(aVar2, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bK */
    public c bL(JSONObject jSONObject) {
        return (c) e.a(jSONObject, new c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(c cVar) {
        this.dwq.abX();
        f fVar = new f();
        fVar.a(cVar, PMSPkgStatus.WAIT);
        this.dwq.a(fVar);
        com.baidu.swan.a.d.a(cVar, (com.baidu.swan.a.a) this.dwq);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(c cVar) {
        return cVar != null && cVar.acP();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "getSailor";
    }
}
