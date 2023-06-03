package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.platform.comapi.pano.c;
/* loaded from: classes3.dex */
public final class a implements a.InterfaceC0137a<c> {
    public final /* synthetic */ Context a;

    public a(Context context) {
        this.a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0137a
    public void a(HttpClient.HttpStateError httpStateError) {
        int i = b.b[httpStateError.ordinal()];
        if (i != 1) {
            if (i == 2) {
                Log.d("baidumapsdk", "network inner error, please check network");
                return;
            }
            return;
        }
        Log.d("baidumapsdk", "current network is not available");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0137a
    public void a(c cVar) {
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        int i = b.a[cVar.a().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (cVar.c() == 1) {
                            try {
                                BaiduMapPoiSearch.b(cVar.b(), this.a);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        Log.d("baidumapsdk", "this point do not support for pano show");
                        return;
                    }
                    return;
                }
                Log.d("baidumapsdk", "please check ak for permission");
                return;
            }
            Log.d("baidumapsdk", "pano id not found for this poi point");
            return;
        }
        Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
    }
}
