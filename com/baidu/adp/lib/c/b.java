package com.baidu.adp.lib.c;

import com.baidu.adp.lib.c.c;
/* loaded from: classes.dex */
class b implements c.a {
    final /* synthetic */ a mN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.mN = aVar;
    }

    @Override // com.baidu.adp.lib.c.c.a
    public void a(String str, int i, boolean z) {
        this.mN.changeSettingByType(i);
    }
}
