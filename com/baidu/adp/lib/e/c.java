package com.baidu.adp.lib.e;

import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ a uS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.uS = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 0:
                this.uS.gO();
                String str = "";
                i = this.uS.errorCode;
                switch (i) {
                    case 1:
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                        break;
                    case 2:
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                        break;
                    case 3:
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        break;
                    case 4:
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        break;
                }
                a aVar = this.uS;
                i2 = this.uS.errorCode;
                aVar.a(i2, str, (Address) null);
                return false;
            default:
                return false;
        }
    }
}
