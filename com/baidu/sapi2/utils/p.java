package com.baidu.sapi2.utils;

import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p implements Runnable {
    final /* synthetic */ HttpHashMapWrap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HttpHashMapWrap httpHashMapWrap) {
        this.a = httpHashMapWrap;
    }

    @Override // java.lang.Runnable
    public void run() {
        r.b(this.a);
    }
}
