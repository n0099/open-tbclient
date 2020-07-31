package com.baidu.swan.bdprivate.d;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.aq.v;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.t.b.b {
    @Override // com.baidu.swan.apps.t.b.b
    public void a(Context context, String str, String str2, final com.baidu.swan.apps.b.c.b bVar) {
        if (context != null && bVar != null) {
            DelegateUtils.callOnMainWithActivity((Activity) context, MainProcessDelegateActivity.class, a.class, new DelegateListener() { // from class: com.baidu.swan.bdprivate.d.b.1
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (delegateResult.mResult == null) {
                        bVar.er(0);
                        return;
                    }
                    String string = delegateResult.mResult.getString("invoiceInfo");
                    if (TextUtils.isEmpty(string)) {
                        bVar.er(0);
                    } else {
                        bVar.ai(v.parseString(string));
                    }
                }
            });
        }
    }
}
