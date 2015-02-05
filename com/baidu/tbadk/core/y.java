package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ TbadkCoreApplication CO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbadkCoreApplication tbadkCoreApplication) {
        this.CO = tbadkCoreApplication;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.j.aip();
    }
}
