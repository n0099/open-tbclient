package com.baidu.swan.bdprivate.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.adaptation.a.l;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.setting.oauth.c;
import com.vivo.push.PushClientConstants;
/* loaded from: classes10.dex */
public class a implements l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(Context context, String str, String str2, final com.baidu.swan.apps.b.a.b bVar) {
        ActivityResultDispatcher resultDispatcher;
        if (context != null && bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("openSource", "aiapp");
            bundle.putString("appId", str);
            bundle.putString("appKey", str2);
            bundle.putString(PushClientConstants.TAG_PKG_NAME, c.getAppContext().getPackageName());
            bundle.putString("keyHash", c.getKeyHash());
            Intent intent = new Intent(context, DeliveryListActivity.class);
            intent.putExtras(bundle);
            if ((context instanceof ActivityResultDispatcherHolder) && (resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher()) != null) {
                resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.bdprivate.address.a.1
                    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                    public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                        if (i == -1) {
                            bVar.L(s.parseString(intent2.getStringExtra("data")));
                        } else if (i == 0) {
                            bVar.dH(1);
                        } else {
                            bVar.dH(0);
                        }
                        return true;
                    }
                });
                resultDispatcher.startActivityForResult(intent);
            }
        }
    }
}
