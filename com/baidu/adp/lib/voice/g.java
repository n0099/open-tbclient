package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class g extends com.baidu.adp.lib.util.h {
    @Override // com.baidu.adp.lib.util.h
    public void l(boolean z) {
        Amrnb.bLoadLibrary = z;
        if (!Amrnb.bLoadLibrary) {
            return;
        }
        try {
            Amrnb.native_init();
            Amrnb.bLoadLibrary = true;
        } catch (Throwable th) {
            Amrnb.bLoadLibrary = false;
            com.baidu.adp.lib.stats.a.hi().a("so", "initAmrnb", "", -9104, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), new Object[0]);
        }
    }
}
