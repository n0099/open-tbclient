package com.baidu.tbadk.clearResource;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a To;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.To = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            e.tO();
            ClearResourceStatic.m(TbadkCoreApplication.m411getInst().getCacheDir());
        } catch (Exception e) {
        }
    }
}
