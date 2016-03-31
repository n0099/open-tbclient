package com.baidu.adp.lib.e;

import android.location.Address;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    final /* synthetic */ a vb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.vb = aVar;
    }

    @Override // com.baidu.adp.lib.e.a.b
    public void a(int i, String str, Address address, long j, boolean z) {
        this.vb.uR = j;
        this.vb.uX = address;
        this.vb.uU = z;
        this.vb.errorCode = i;
        this.vb.gO();
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
        this.vb.a(i, str, address);
    }
}
