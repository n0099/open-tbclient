package com.baidu.tbadk.clearResource;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a Qh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Qh = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            d.vo();
            ClearResourceStatic.k(TbadkCoreApplication.m411getInst().getCacheDir());
        } catch (Exception e) {
        }
    }
}
