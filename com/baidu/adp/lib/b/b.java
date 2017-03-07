package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements c.a {
    final /* synthetic */ a uA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uA = aVar;
    }

    @Override // com.baidu.adp.lib.b.c.a
    public void a(String str, int i, boolean z) {
        this.uA.changeSettingByType(i);
    }
}
