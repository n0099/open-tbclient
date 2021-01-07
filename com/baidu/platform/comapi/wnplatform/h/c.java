package com.baidu.platform.comapi.wnplatform.h;

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
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends ItemizedOverlay {

    /* renamed from: b  reason: collision with root package name */
    private View f4639b;
    private TextView c;
    private ImageView d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final c f4640a = new c();
    }

    public static c b() {
        return a.f4640a;
    }

    private c() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().J().a());
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            bundle.putInt("index", iArr3[i]);
            a(context, bundle);
        }
    }

    private void a(Context context, Bundle bundle) {
        double d = bundle.getDouble("x");
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
            this.f4639b = ((Activity) context).getLayoutInflater().inflate(R.array.edit_video_tab, (ViewGroup) null);
            this.c = (TextView) this.f4639b.findViewById(R.dimen.aiapp_menu_gridview_padding_view_height1);
            this.d = (ImageView) this.f4639b.findViewById(R.dimen.aiapp_menu_gridview_padding_top);
            if (com.baidu.platform.comapi.wnplatform.a.a().h() == 2) {
                this.c.setText(i + "");
            } else {
                this.c.setText("途");
            }
            this.f4639b.setDrawingCacheEnabled(true);
            this.f4639b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f4639b.layout(0, 0, this.f4639b.getMeasuredWidth(), this.f4639b.getMeasuredHeight());
            this.f4639b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.f4639b.getDrawingCache());
        } catch (Exception e) {
            return null;
        }
    }
}
