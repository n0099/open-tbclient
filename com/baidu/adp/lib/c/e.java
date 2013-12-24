package com.baidu.adp.lib.c;

import android.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements BDLocationListener {
    final /* synthetic */ a a;

    private e(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.location.BDLocationListener
    public void onReceiveLocation(BDLocation bDLocation) {
        Address address;
        Address address2;
        Address address3;
        int i;
        Address address4;
        Address address5;
        if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
            this.a.j = 0;
            this.a.d();
            this.a.l = new Address(Locale.getDefault());
            address = this.a.l;
            address.setLatitude(bDLocation.getLatitude());
            address2 = this.a.l;
            address2.setLongitude(bDLocation.getLongitude());
            address3 = this.a.l;
            address3.setLocality(bDLocation.getCity());
            this.a.a = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                address5 = this.a.l;
                address5.setAddressLine(0, stringBuffer.toString());
            }
            a aVar = this.a;
            i = this.a.j;
            address4 = this.a.l;
            aVar.a(i, "", address4);
        }
    }

    @Override // com.baidu.location.BDLocationListener
    public void onReceivePoi(BDLocation bDLocation) {
    }
}
