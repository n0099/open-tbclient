package com.baidu.android.nebula.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements p {
    private final String a = System.getProperty("baidu.moplus.tmpdir");
    private final List b = new ArrayList();

    @Override // com.baidu.android.nebula.b.p
    public s a() {
        d dVar = new d(this.a);
        this.b.add(dVar);
        return dVar;
    }

    @Override // com.baidu.android.nebula.b.p
    public void b() {
        for (s sVar : this.b) {
            try {
                sVar.a();
            } catch (Exception e) {
            }
        }
        this.b.clear();
    }
}
