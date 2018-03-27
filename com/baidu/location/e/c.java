package com.baidu.location.e;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Callable<String> {
    final /* synthetic */ String a;
    final /* synthetic */ a aCS;
    final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, List list) {
        this.aCS = aVar;
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        String aK;
        this.aCS.a(this.a, this.b);
        aK = this.aCS.aK(true);
        return aK;
    }
}
