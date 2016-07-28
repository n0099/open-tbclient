package com.baidu.tbadk.clearResource;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a KX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.KX = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            d.sS();
            ClearResourceStatic.l(TbadkCoreApplication.m10getInst().getCacheDir());
        } catch (Exception e) {
        }
    }
}
