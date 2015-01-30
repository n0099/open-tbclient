package com.baidu.adp.lib.b;
/* loaded from: classes.dex */
class b implements d {
    final /* synthetic */ a hY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.hY = aVar;
    }

    @Override // com.baidu.adp.lib.b.d
    public void a(String str, int i, boolean z) {
        this.hY.changeSettingByType(i);
    }
}
