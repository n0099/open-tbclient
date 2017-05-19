package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ a vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.vg = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 0:
                this.vg.fj();
                String str = "";
                i = this.vg.errorCode;
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
                    case 6:
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        break;
                }
                a aVar = this.vg;
                i2 = this.vg.errorCode;
                aVar.a(i2, str, (Address) null);
                return false;
            default:
                return false;
        }
    }
}
