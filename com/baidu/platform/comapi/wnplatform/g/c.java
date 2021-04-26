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
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends ItemizedOverlay {

    /* renamed from: b  reason: collision with root package name */
    public View f10193b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10194c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f10195d;

    /* renamed from: e  reason: collision with root package name */
    public Context f10196e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f10197a = new c();
    }

    public static c b() {
        return a.f10197a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f10196e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bundle.putDouble("x", iArr[i2]);
            bundle.putDouble("y", iArr2[i2]);
            bundle.putInt("index", iArr3[i2]);
            a(context, bundle);
        }
    }

    public c() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().G().a());
    }

    private void a(Context context, Bundle bundle) {
        double d2 = bundle.getDouble("x");
        double d3 = bundle.getDouble("y");
        int i2 = bundle.getInt("index");
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "addItem:lng:" + d2 + "lat:" + d3 + "index:" + i2);
        new GeoPoint(d3, d2);
        LatLng latLng = new LatLng(d3, d2);
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor a2 = a(context, i2);
        if (a2 != null) {
            markerOptions.icon(a2);
            markerOptions.position(latLng);
            addItem(markerOptions);
        }
    }

    private BitmapDescriptor a(Context context, int i2) {
        try {
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.array.S_O_X004, (ViewGroup) null);
            this.f10193b = inflate;
            this.f10194c = (TextView) inflate.findViewById(R.dimen.abc_text_size_body_1_material);
            this.f10195d = (ImageView) this.f10193b.findViewById(R.dimen.abc_switch_padding);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                TextView textView = this.f10194c;
                textView.setText(i2 + "");
            } else {
                this.f10194c.setText("途");
            }
            this.f10193b.setDrawingCacheEnabled(true);
            this.f10193b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f10193b.layout(0, 0, this.f10193b.getMeasuredWidth(), this.f10193b.getMeasuredHeight());
            this.f10193b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f10193b.getDrawingCache());
        } catch (Exception unused) {
            return null;
        }
    }
}
