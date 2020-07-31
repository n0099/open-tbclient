package com.baidu.mobads.utils;

import android.net.wifi.ScanResult;
import java.util.Comparator;
/* loaded from: classes20.dex */
class r implements Comparator<ScanResult> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.a = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
