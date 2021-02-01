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
/* loaded from: classes4.dex */
public class c extends ItemizedOverlay {

    /* renamed from: b  reason: collision with root package name */
    private View f4411b;
    private TextView c;
    private ImageView d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final c f4412a = new c();
    }

    public static c b() {
        return a.f4412a;
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
            this.f4411b = ((Activity) context).getLayoutInflater().inflate(R.array.S_O_X004, (ViewGroup) null);
            this.c = (TextView) this.f4411b.findViewById(R.dimen.abc_text_size_display_1_material);
            this.d = (ImageView) this.f4411b.findViewById(R.dimen.abc_text_size_caption_material);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                this.c.setText(i + "");
            } else {
                this.c.setText("途");
            }
            this.f4411b.setDrawingCacheEnabled(true);
            this.f4411b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f4411b.layout(0, 0, this.f4411b.getMeasuredWidth(), this.f4411b.getMeasuredHeight());
            this.f4411b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f4411b.getDrawingCache());
        } catch (Exception e) {
            return null;
        }
    }
}
