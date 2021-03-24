package com.baidu.platform.comapi.wnplatform.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.bikenavi.model.RouteGuideKind;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends ItemizedOverlay {

    /* renamed from: b  reason: collision with root package name */
    public View f10264b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f10265c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f10266d;

    /* renamed from: e  reason: collision with root package name */
    public Context f10267e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0129a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f10268a = new a();
    }

    public static a b() {
        return C0129a.f10268a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f10267e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            if (iArr3[i] < RouteGuideKind.values().length) {
                int[] a2 = com.baidu.platform.comapi.walknavi.g.a.c.a(RouteGuideKind.values()[iArr3[i]]);
                bundle.putInt("upResId", a2[0]);
                bundle.putInt("downResId", a2[1]);
                a(context, bundle);
            }
        }
    }

    public a() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().G().a());
    }

    public void a(Context context, Bundle bundle) {
        double d2 = bundle.getDouble("x");
        double d3 = bundle.getDouble("y");
        int i = bundle.getInt("upResId");
        int i2 = bundle.getInt("downResId");
        new GeoPoint(d3, d2);
        LatLng latLng = new LatLng(d3, d2);
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor a2 = a(context, i, i2);
        if (a2 != null) {
            markerOptions.icon(a2);
            markerOptions.position(latLng);
            addItem(markerOptions);
        }
    }

    private BitmapDescriptor a(Context context, int i, int i2) {
        try {
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.array.aiapps_loading_tips_prepare, (ViewGroup) null);
            this.f10264b = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.dimen.abc_text_size_display_1_material);
            this.f10265c = imageView;
            imageView.setImageResource(i);
            ImageView imageView2 = (ImageView) this.f10264b.findViewById(R.dimen.abc_text_size_display_2_material);
            this.f10266d = imageView2;
            imageView2.setImageResource(i2);
            this.f10264b.setDrawingCacheEnabled(true);
            this.f10264b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f10264b.layout(0, 0, this.f10264b.getMeasuredWidth(), this.f10264b.getMeasuredHeight());
            this.f10264b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f10264b.getDrawingCache());
        } catch (Exception unused) {
            return null;
        }
    }
}
