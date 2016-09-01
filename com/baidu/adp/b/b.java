package com.baidu.adp.b;

import com.baidu.adp.b.a;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends a {
    @Override // com.baidu.adp.b.a
    public void a(String str, long j, long j2, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = a.yS;
        if (arrayList.size() >= 30) {
            return;
        }
        arrayList2 = a.yS;
        arrayList2.add(new a.C0001a(str, j, j2, str2));
    }
}
