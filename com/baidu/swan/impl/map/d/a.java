package com.baidu.swan.impl.map.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends c {
    public a(@NonNull Context context) {
        super("BaiduMap", context.getString(R.string.openlocation_bottommenu_baidumap), "com.baidu.BaiduMap");
        this.erf = true;
    }

    @Override // com.baidu.swan.impl.map.d.c
    public void a(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (latLng != null && latLng2 != null) {
            Intent intent = new Intent();
            Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
            buildUpon.appendQueryParameter("origin", "name:" + str + "|latlng:" + latLng.latitude + "," + latLng.longitude);
            buildUpon.appendQueryParameter("destination", "name:" + str2 + "|latlng:" + latLng2.latitude + "," + latLng2.longitude);
            buildUpon.appendQueryParameter(UbcStatConstant.KEY_CONTENT_EXT_MODE, "driving");
            buildUpon.appendQueryParameter("target", "1");
            buildUpon.appendQueryParameter(UserAccountActionItem.KEY_SRC, context.getPackageName());
            intent.setData(buildUpon.build());
            context.startActivity(intent);
        }
    }
}
