package com.baidu.mobads.utils;

import android.net.wifi.ScanResult;
import java.util.Comparator;
/* loaded from: classes3.dex */
class s implements Comparator<ScanResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f3549a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f3549a = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
