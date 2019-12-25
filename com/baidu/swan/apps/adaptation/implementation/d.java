package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.a.r;
import java.util.Map;
/* loaded from: classes9.dex */
public class d implements r {
    @Override // com.baidu.swan.apps.adaptation.a.r
    public void a(com.baidu.swan.apps.commonsync.a.a aVar) {
        if (aVar != null) {
            aVar.onSuccess();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        if (bVar != null) {
            bVar.a(null);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void l(Map<String, String> map) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public void m(Map<String, String> map) {
    }
}
