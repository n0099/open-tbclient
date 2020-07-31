package com.baidu.sapi2.utils;

import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class r implements Runnable {
    final /* synthetic */ HttpHashMapWrap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(HttpHashMapWrap httpHashMapWrap) {
        this.a = httpHashMapWrap;
    }

    @Override // java.lang.Runnable
    public void run() {
        t.b(this.a);
    }
}
