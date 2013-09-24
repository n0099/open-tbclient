package com.baidu.adp.widget.a;

import com.baidu.adp.lib.c.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f514a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void a(Object obj, String str, f fVar) {
        this.f514a.invalidate();
    }
}
