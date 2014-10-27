package com.baidu.adp.lib.d;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Location, Void, Address> {
    final /* synthetic */ a jY;

    private f(a aVar) {
        this.jY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(a aVar, f fVar) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Address doInBackground(Location... locationArr) {
        Context context;
        List<Address> list;
        context = this.jY.mContext;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        if (locationArr == null || locationArr.length < 1) {
            return null;
        }
        Location location = locationArr[0];
        try {
            list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            list = null;
        } catch (IllegalArgumentException e2) {
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        Address address = list.get(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (address.getSubLocality() == null || address.getThoroughfare() == null) {
            stringBuffer.append(address.getLocality());
        }
        stringBuffer.append(address.getSubLocality());
        stringBuffer.append(address.getThoroughfare());
        address.setAddressLine(0, stringBuffer.toString());
        return address;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.jY.jU = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Address address) {
        int i;
        super.onPostExecute(address);
        this.jY.jU = null;
        if (address == null) {
            return;
        }
        this.jY.dH();
        this.jY.errorCode = 0;
        this.jY.jV = System.currentTimeMillis();
        a aVar = this.jY;
        i = this.jY.errorCode;
        aVar.a(i, "", address);
        this.jY.jT = address;
    }
}
