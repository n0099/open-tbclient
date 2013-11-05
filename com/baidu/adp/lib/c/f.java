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
public class f extends BdAsyncTask<Location, Void, Address> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f424a;

    private f(a aVar) {
        this.f424a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Address a(Location... locationArr) {
        Context context;
        List<Address> list;
        context = this.f424a.o;
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
    public void a() {
        super.a();
        this.f424a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Address address) {
        int i;
        super.a((f) address);
        this.f424a.m = null;
        if (address != null) {
            this.f424a.d();
            this.f424a.j = 0;
            this.f424a.f420a = System.currentTimeMillis();
            a aVar = this.f424a;
            i = this.f424a.j;
            aVar.a(i, "", address);
            this.f424a.l = address;
        }
    }
}
