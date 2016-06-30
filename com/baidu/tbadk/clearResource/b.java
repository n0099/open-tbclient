package com.baidu.tbadk.clearResource;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a KY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.KY = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            d.sT();
            ClearResourceStatic.k(TbadkCoreApplication.m9getInst().getCacheDir());
        } catch (Exception e) {
        }
    }
}
