package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class a extends c {
    public a(@NonNull Context context) {
        super("BaiduMap", context.getString(R.string.openlocation_bottommenu_baidumap), "com.baidu.BaiduMap");
        this.ctM = true;
    }

    @Override // com.baidu.swan.impl.map.d.c
    public void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (latLng != null && latLng2 != null) {
            Intent intent = new Intent();
            Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
            buildUpon.appendQueryParameter("origin", "name:" + str + "|latlng:" + latLng.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + latLng.longitude);
            buildUpon.appendQueryParameter("destination", "name:" + str2 + "|latlng:" + latLng2.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + latLng2.longitude);
            buildUpon.appendQueryParameter("mode", "driving");
            buildUpon.appendQueryParameter("target", "1");
            buildUpon.appendQueryParameter(UserAccountActionItem.KEY_SRC, context.getPackageName());
            intent.setData(buildUpon.build());
            context.startActivity(intent);
        }
    }
}
