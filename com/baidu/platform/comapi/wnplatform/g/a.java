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
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends ItemizedOverlay {

    /* renamed from: b  reason: collision with root package name */
    private View f4409b;
    private ImageView c;
    private ImageView d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0291a {

        /* renamed from: a  reason: collision with root package name */
        static final a f4410a = new a();
    }

    public static a b() {
        return C0291a.f4410a;
    }

    private a() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().G().a());
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble(Config.EVENT_HEAT_X, iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            if (iArr3[i] < RouteGuideKind.values().length) {
                int[] a2 = com.baidu.platform.comapi.walknavi.g.a.c.a(RouteGuideKind.values()[iArr3[i]]);
                bundle.putInt("upResId", a2[0]);
                bundle.putInt("downResId", a2[1]);
                a(context, bundle);
            }
        }
    }

    public void a(Context context, Bundle bundle) {
        double d = bundle.getDouble(Config.EVENT_HEAT_X);
        double d2 = bundle.getDouble("y");
        int i = bundle.getInt("upResId");
        int i2 = bundle.getInt("downResId");
        new GeoPoint(d2, d);
        LatLng latLng = new LatLng(d2, d);
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
            this.f4409b = ((Activity) context).getLayoutInflater().inflate(R.array.aiapps_loading_tips_prepare, (ViewGroup) null);
            this.c = (ImageView) this.f4409b.findViewById(R.dimen.abc_text_size_display_2_material);
            this.c.setImageResource(i);
            this.d = (ImageView) this.f4409b.findViewById(R.dimen.abc_text_size_display_3_material);
            this.d.setImageResource(i2);
            this.f4409b.setDrawingCacheEnabled(true);
            this.f4409b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f4409b.layout(0, 0, this.f4409b.getMeasuredWidth(), this.f4409b.getMeasuredHeight());
            this.f4409b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f4409b.getDrawingCache());
        } catch (Exception e) {
            return null;
        }
    }
}
