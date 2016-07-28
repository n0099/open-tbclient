package com.baidu.adp.lib.c;

import com.baidu.adp.lib.c.c;
/* loaded from: classes.dex */
class b implements c.a {
    final /* synthetic */ a kt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.kt = aVar;
    }

    @Override // com.baidu.adp.lib.c.c.a
    public void a(String str, int i, boolean z) {
        this.kt.changeSettingByType(i);
    }
}
