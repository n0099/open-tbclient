package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class k extends com.baidu.adp.lib.util.i {
    @Override // com.baidu.adp.lib.util.i
    public void h(boolean z) {
        Amrnb.bLoadLibrary = z;
        if (!Amrnb.bLoadLibrary) {
            return;
        }
        try {
            Amrnb.native_init();
            Amrnb.bLoadLibrary = true;
        } catch (Throwable th) {
            Amrnb.bLoadLibrary = false;
            com.baidu.adp.lib.stats.f.er().a("so", "initAmrnb", "", "", -9104, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), new Object[0]);
        }
    }
}
