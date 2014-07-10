package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.util.h;
/* loaded from: classes.dex */
class a extends h {
    @Override // com.baidu.adp.lib.util.h
    public void a(boolean z) {
        Amrnb.bLoadLibrary = z;
        if (!Amrnb.bLoadLibrary) {
            return;
        }
        try {
            Amrnb.native_init();
            Amrnb.bLoadLibrary = true;
        } catch (Throwable th) {
            Amrnb.bLoadLibrary = false;
            com.baidu.adp.lib.stats.d.b().a("so", "initAmrnb", "", "", -9104, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), new Object[0]);
        }
    }
}
