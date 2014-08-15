package com.baidu.tbadk.core.util.httpNet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.cdnOptimize.TbCDNTachometerService;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d extends BroadcastReceiver {
    final /* synthetic */ a this$0;

    private d(a aVar) {
        this.this$0 = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
            boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP_STRING, false);
            a.a(this.this$0).ipList = stringArrayListExtra;
            a.a(this.this$0).isUsedIp = booleanExtra;
            if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                a.a(this.this$0, true);
                a.a(this.this$0).isUsedIp = false;
            }
            a.a(this.this$0, a.a(this.this$0));
            a.a(this.this$0, 0);
            a.a(this.this$0).currentUseIpPos = 0;
        }
    }
}
