package com.baidu.tbadk.core.util;

import android.os.Build;
/* loaded from: classes.dex */
public final class u extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        ak akVar = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/inpv");
        akVar.a("st_type", "enter_fore");
        akVar.a("os_version", Build.VERSION.RELEASE);
        akVar.a("subapp_type", "im");
        akVar.i();
    }
}
