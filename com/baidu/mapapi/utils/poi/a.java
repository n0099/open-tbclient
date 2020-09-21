package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.platform.comapi.pano.c;
/* loaded from: classes3.dex */
final class a implements a.InterfaceC0243a<c> {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0243a
    public void a(HttpClient.HttpStateError httpStateError) {
        switch (httpStateError) {
            case NETWORK_ERROR:
                Log.d("baidumapsdk", "current network is not available");
                return;
            case INNER_ERROR:
                Log.d("baidumapsdk", "network inner error, please check network");
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0243a
    public void a(c cVar) {
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        switch (cVar.a()) {
            case PANO_UID_ERROR:
                Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
                return;
            case PANO_NOT_FOUND:
                Log.d("baidumapsdk", "pano id not found for this poi point");
                return;
            case PANO_NO_TOKEN:
                Log.d("baidumapsdk", "please check ak for permission");
                return;
            case PANO_NO_ERROR:
                if (cVar.c() != 1) {
                    Log.d("baidumapsdk", "this point do not support for pano show");
                    return;
                }
                try {
                    BaiduMapPoiSearch.b(cVar.b(), this.a);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }
}
