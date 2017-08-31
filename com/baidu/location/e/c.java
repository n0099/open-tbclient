package com.baidu.location.e;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Callable<String> {
    final /* synthetic */ a MP;
    final /* synthetic */ String a;
    final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, List list) {
        this.MP = aVar;
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        String ab;
        this.MP.a(this.a, this.b);
        ab = this.MP.ab(true);
        return ab;
    }
}
