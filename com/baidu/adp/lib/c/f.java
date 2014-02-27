package com.baidu.adp.lib.c;

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
public final class f extends BdAsyncTask<Location, Void, Address> {
    final /* synthetic */ a a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Address address) {
        int i;
        Address address2 = address;
        super.a((f) address2);
        this.a.m = null;
        if (address2 != null) {
            this.a.c();
            this.a.j = 0;
            this.a.a = System.currentTimeMillis();
            a aVar = this.a;
            i = this.a.j;
            a.a(aVar, i, "", address2);
            this.a.l = address2;
        }
    }

    private f(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(a aVar, byte b) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Address a(Location... locationArr) {
        Context context;
        List<Address> list;
        context = this.a.o;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        if (locationArr == null || locationArr.length <= 0) {
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
    public final void a() {
        super.a();
        this.a.m = null;
    }
}
