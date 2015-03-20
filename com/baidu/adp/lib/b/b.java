package com.baidu.adp.lib.b;
/* loaded from: classes.dex */
class b implements d {
    final /* synthetic */ a tv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tv = aVar;
    }

    @Override // com.baidu.adp.lib.b.d
    public void a(String str, int i, boolean z) {
        this.tv.changeSettingByType(i);
    }
}
