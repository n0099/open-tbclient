package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.platform.comapi.pano.c;
/* loaded from: classes2.dex */
public final class a implements a.InterfaceC0120a<c> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7409a;

    public a(Context context) {
        this.f7409a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0120a
    public void a(HttpClient.HttpStateError httpStateError) {
        String str;
        int i = b.f7411b[httpStateError.ordinal()];
        if (i == 1) {
            str = "current network is not available";
        } else if (i != 2) {
            return;
        } else {
            str = "network inner error, please check network";
        }
        Log.d("baidumapsdk", str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0120a
    public void a(c cVar) {
        String str;
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        int i = b.f7410a[cVar.a().ordinal()];
        if (i == 1) {
            str = "pano uid is error, please check param poi uid";
        } else if (i == 2) {
            str = "pano id not found for this poi point";
        } else if (i == 3) {
            str = "please check ak for permission";
        } else if (i != 4) {
            return;
        } else {
            if (cVar.c() == 1) {
                try {
                    BaiduMapPoiSearch.b(cVar.b(), this.f7409a);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            str = "this point do not support for pano show";
        }
        Log.d("baidumapsdk", str);
    }
}
