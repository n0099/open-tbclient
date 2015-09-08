package com.baidu.adp.lib.d;

import android.location.Address;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    final /* synthetic */ a uB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uB = aVar;
    }

    @Override // com.baidu.adp.lib.d.a.b
    public void a(int i, String str, Address address, long j, boolean z) {
        this.uB.ur = j;
        this.uB.ux = address;
        this.uB.uu = z;
        this.uB.errorCode = i;
        this.uB.gE();
        switch (i) {
            case 1:
                if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                    break;
                }
                break;
            case 2:
                if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                    break;
                }
                break;
            case 3:
                if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                    break;
                }
                break;
            case 4:
                if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                    break;
                }
                break;
        }
        this.uB.a(i, str, address);
    }
}
