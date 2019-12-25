package com.baidu.swan.bdprivate.invoice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity;
/* loaded from: classes9.dex */
public class f implements com.baidu.swan.apps.w.b.c {
    @Override // com.baidu.swan.apps.w.b.c
    public void a(Context context, String str, String str2, final com.baidu.swan.apps.u.b bVar) {
        ActivityResultDispatcher resultDispatcher;
        if (context != null && bVar != null && (resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher()) != null) {
            Intent intent = new Intent(context, InvoiceListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("appId", str);
            bundle.putString("appKey", str2);
            bundle.putString("source", "source_ai_app");
            intent.putExtras(bundle);
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.bdprivate.invoice.f.1
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                    if (i == -1 && intent2 != null) {
                        bVar.L(s.parseString(intent2.getStringExtra("invoiceInfo")));
                    } else if (i == 0) {
                        bVar.dG(1);
                    } else {
                        bVar.dG(0);
                    }
                    return true;
                }
            });
            resultDispatcher.startActivityForResult(intent);
        }
    }
}
