package com.baidu.tbadk.core.util.httpNet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.cdnOptimize.TbCDNTachometerService;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b extends BroadcastReceiver {
    final /* synthetic */ CDNIPDirectConnect this$0;

    private b(CDNIPDirectConnect cDNIPDirectConnect) {
        this.this$0 = cDNIPDirectConnect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(CDNIPDirectConnect cDNIPDirectConnect, b bVar) {
        this(cDNIPDirectConnect);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
            if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                CDNIPDirectConnect.a(this.this$0).setMobileIpList(stringArrayListExtra);
                CDNIPDirectConnect.a(this.this$0, CDNIPDirectConnect.a(this.this$0));
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
            int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
            int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
            if ((1 == intExtra || 2 == intExtra) && size > 0) {
                z = true;
            } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                CDNIPDirectConnect.a(this.this$0, true);
            }
            CDNIPDirectConnect.a(this.this$0).setIpList(stringArrayListExtra, booleanExtra, z);
            if (size > 0) {
                CDNIPDirectConnect.a(this.this$0, CDNIPDirectConnect.a(this.this$0));
            }
        }
    }
}
