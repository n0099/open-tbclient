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
    public View f9828b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9829c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f9830d;

    /* renamed from: e  reason: collision with root package name */
    public Context f9831e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f9832a = new c();
    }

    public static c b() {
        return a.f9832a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f9831e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            bundle.putInt("index", iArr3[i]);
            a(context, bundle);
        }
    }

    public c() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().G().a());
    }

    private void a(Context context, Bundle bundle) {
        double d2 = bundle.getDouble("x");
        double d3 = bundle.getDouble("y");
        int i = bundle.getInt("index");
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "addItem:lng:" + d2 + "lat:" + d3 + "index:" + i);
        new GeoPoint(d3, d2);
        LatLng latLng = new LatLng(d3, d2);
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
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.array.S_O_X004, (ViewGroup) null);
            this.f9828b = inflate;
            this.f9829c = (TextView) inflate.findViewById(R.dimen.abc_text_size_caption_material);
            this.f9830d = (ImageView) this.f9828b.findViewById(R.dimen.abc_text_size_button_material);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                TextView textView = this.f9829c;
                textView.setText(i + "");
            } else {
                this.f9829c.setText("途");
            }
            this.f9828b.setDrawingCacheEnabled(true);
            this.f9828b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f9828b.layout(0, 0, this.f9828b.getMeasuredWidth(), this.f9828b.getMeasuredHeight());
            this.f9828b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f9828b.getDrawingCache());
        } catch (Exception unused) {
            return null;
        }
    }
}
