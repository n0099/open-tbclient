package com.baidu.adp.lib.b;

import com.baidu.adp.lib.b.c;
/* loaded from: classes.dex */
class b implements c.a {
    final /* synthetic */ a tD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tD = aVar;
    }

    @Override // com.baidu.adp.lib.b.c.a
    public void b(String str, int i, boolean z) {
        this.tD.changeSettingByType(i);
    }
}
