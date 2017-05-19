package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.d.a.fg().a(true, this.this$0.locationCallBack);
    }
}
