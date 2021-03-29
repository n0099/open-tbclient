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
    public View f10270b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10271c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f10272d;

    /* renamed from: e  reason: collision with root package name */
    public Context f10273e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f10274a = new c();
    }

    public static c b() {
        return a.f10274a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f10273e = context;
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
            this.f10270b = inflate;
            this.f10271c = (TextView) inflate.findViewById(R.dimen.abc_text_size_caption_material);
            this.f10272d = (ImageView) this.f10270b.findViewById(R.dimen.abc_text_size_button_material);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                TextView textView = this.f10271c;
                textView.setText(i + "");
            } else {
                this.f10271c.setText("途");
            }
            this.f10270b.setDrawingCacheEnabled(true);
            this.f10270b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f10270b.layout(0, 0, this.f10270b.getMeasuredWidth(), this.f10270b.getMeasuredHeight());
            this.f10270b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f10270b.getDrawingCache());
        } catch (Exception unused) {
            return null;
        }
    }
}
