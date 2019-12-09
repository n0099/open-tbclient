package com.baidu.sapi2.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a extends com.baidu.sapi2.callback.a.a {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: a */
    public void onFailure(com.baidu.sapi2.result.a.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: b */
    public void onSuccess(com.baidu.sapi2.result.a.a aVar) {
        String str;
        str = b.a;
        Log.e(str, "thread id", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
        if (aVar.a && !TextUtils.isEmpty(aVar.d) && !TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.b)) {
            b bVar = this.b;
            Context context = this.a;
            String str2 = aVar.c;
            bVar.a(context, str2, str2, aVar.d, aVar.b);
            SapiContext sapiContext = SapiContext.getInstance(this.a);
            int i = aVar.e;
            sapiContext.setPushInternalTime(i == 0 ? 432000L : i);
            SapiContext.getInstance(this.a).setPushSucTime(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }
}
