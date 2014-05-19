package com.baidu.adp.lib.c;

import android.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import java.util.Locale;
/* loaded from: classes.dex */
class e implements BDLocationListener {
    final /* synthetic */ a a;

    private e(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // com.baidu.location.BDLocationListener
    public void onReceiveLocation(BDLocation bDLocation) {
        if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
            a.a(this.a, 0);
            a.c(this.a);
            a.a(this.a, new Address(Locale.getDefault()));
            a.e(this.a).setLatitude(bDLocation.getLatitude());
            a.e(this.a).setLongitude(bDLocation.getLongitude());
            a.e(this.a).setLocality(bDLocation.getCity());
            this.a.a = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.e(this.a).setAddressLine(0, stringBuffer.toString());
            }
            a.a(this.a, a.d(this.a), "", a.e(this.a));
        }
    }

    @Override // com.baidu.location.BDLocationListener
    public void onReceivePoi(BDLocation bDLocation) {
    }
}
