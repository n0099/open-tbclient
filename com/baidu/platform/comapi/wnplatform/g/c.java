package com.baidu.platform.comapi.wnplatform.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends ItemizedOverlay {
    private View b;
    private TextView c;
    private ImageView d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        static final c a = new c();
    }

    public static c b() {
        return a.a;
    }

    private c() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().G().a());
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble(Config.EVENT_HEAT_X, iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            bundle.putInt("index", iArr3[i]);
            a(context, bundle);
        }
    }

    private void a(Context context, Bundle bundle) {
        double d = bundle.getDouble(Config.EVENT_HEAT_X);
        double d2 = bundle.getDouble("y");
        int i = bundle.getInt("index");
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "addItem:lng:" + d + "lat:" + d2 + "index:" + i);
        new GeoPoint(d2, d);
        LatLng latLng = new LatLng(d2, d);
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor a2 = a(context, i);
        if (a2 != null) {
            markerOptions.icon(a2);
            markerOptions.position(latLng);
            addItem(markerOptions);
        }
    }

    private BitmapDescriptor a(Context context, int i) {
        try {
            this.b = ((Activity) context).getLayoutInflater().inflate(R.layout.abc_alert_dialog_material, (ViewGroup) null);
            this.c = (TextView) this.b.findViewById(2131165304);
            this.d = (ImageView) this.b.findViewById(2131165303);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                this.c.setText(i + "");
            } else {
                this.c.setText("途");
            }
            this.b.setDrawingCacheEnabled(true);
            this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.b.layout(0, 0, this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
            this.b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.b.getDrawingCache());
        } catch (Exception e) {
            return null;
        }
    }
}
