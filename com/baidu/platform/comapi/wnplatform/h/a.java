package com.baidu.platform.comapi.wnplatform.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes7.dex */
public class a extends ItemizedOverlay {
    private View b;
    private ImageView c;
    private ImageView d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0295a {

        /* renamed from: a  reason: collision with root package name */
        static final a f3115a = new a();
    }

    public static a b() {
        return C0295a.f3115a;
    }

    private a() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().J().a());
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            if (iArr3[i] < RouteGuideKind.values().length) {
                int[] a2 = com.baidu.platform.comapi.walknavi.g.b.c.a(RouteGuideKind.values()[iArr3[i]]);
                bundle.putInt("upResId", a2[0]);
                bundle.putInt("downResId", a2[1]);
                a(context, bundle);
            }
        }
    }

    public void a(Context context, Bundle bundle) {
        double d = bundle.getDouble("x");
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
            this.b = ((Activity) context).getLayoutInflater().inflate(2130903056, (ViewGroup) null);
            this.c = (ImageView) this.b.findViewById(2131165327);
            this.c.setImageResource(i);
            this.d = (ImageView) this.b.findViewById(2131165328);
            this.d.setImageResource(i2);
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
