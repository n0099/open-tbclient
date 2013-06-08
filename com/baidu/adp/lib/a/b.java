package com.baidu.adp.lib.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(null);
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Object c;
        c = this.a.c(this.a.a(this.b));
        return c;
    }
}
