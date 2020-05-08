package com.baidu.sapi2.utils;

import android.webkit.ValueCallback;
/* loaded from: classes6.dex */
class e implements ValueCallback<String> {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.a = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.webkit.ValueCallback
    /* renamed from: a */
    public void onReceiveValue(String str) {
        this.a.c.a(str);
        this.a.a.destroy();
    }
}
