package com.baidu.adp.lib.b;
/* loaded from: classes.dex */
class b implements d {
    final /* synthetic */ a tG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tG = aVar;
    }

    @Override // com.baidu.adp.lib.b.d
    public void a(String str, int i, boolean z) {
        this.tG.changeSettingByType(i);
    }
}
