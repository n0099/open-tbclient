package com.baidu.adp.lib.d;

import android.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import java.util.Locale;
/* loaded from: classes.dex */
class e implements BDLocationListener {
    final /* synthetic */ a uG;

    private e(a aVar) {
        this.uG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // com.baidu.location.BDLocationListener
    public void onReceiveLocation(BDLocation bDLocation) {
        if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
            a.a(this.uG, 0);
            a.c(this.uG);
            a.a(this.uG, new Address(Locale.getDefault()));
            a.e(this.uG).setLatitude(bDLocation.getLatitude());
            a.e(this.uG).setLongitude(bDLocation.getLongitude());
            a.e(this.uG).setLocality(bDLocation.getCity());
            this.uG.uD = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.e(this.uG).setAddressLine(0, stringBuffer.toString());
            }
            a.a(this.uG, a.d(this.uG), "", a.e(this.uG));
        }
    }
}
