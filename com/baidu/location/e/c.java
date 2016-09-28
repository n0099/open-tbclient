package com.baidu.location.e;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Callable<String> {
    final /* synthetic */ a Ka;
    final /* synthetic */ String a;
    final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, List list) {
        this.Ka = aVar;
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        String ac;
        this.Ka.b(this.a, this.b);
        ac = this.Ka.ac(true);
        return ac;
    }
}
