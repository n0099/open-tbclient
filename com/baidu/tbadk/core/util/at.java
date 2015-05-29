package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements Runnable {
    final /* synthetic */ aq VI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(aq aqVar) {
        this.VI = aqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.VI.tq();
    }
}
