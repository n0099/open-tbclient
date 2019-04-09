package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.x.a.a.d;
/* loaded from: classes5.dex */
public class f {
    public static void b(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.d dVar) {
        Bitmap F;
        if (bVar != null && dVar.isValid() && (F = com.baidu.swan.impl.map.e.b.F(dVar.azh, true)) != null) {
            com.baidu.swan.impl.map.item.c cVar = new com.baidu.swan.impl.map.item.c();
            int width = dVar.width == -1 ? F.getWidth() : dVar.width;
            int height = dVar.height == -1 ? F.getHeight() : dVar.height;
            if (width > 0 && height > 0) {
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                imageView.setImageBitmap(com.baidu.swan.impl.map.e.b.c(F, width, height));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.azn == null) {
                    dVar.azn = new d.a();
                }
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                if (fromView != null) {
                    Bitmap bitmap = fromView.getBitmap();
                    LatLng latLng = new LatLng(dVar.ayM.latitude, dVar.ayM.longitude);
                    cVar.bhp = (Marker) bVar.bhn.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView).alpha((float) dVar.azk).title(dVar.title).rotate((float) dVar.azc).zIndex(88).anchor((float) dVar.azn.x, (float) dVar.azn.y));
                    cVar.bho = dVar;
                    LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    linearLayout.setGravity(17);
                    View view = new View(AppRuntime.getAppContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                    view.setVisibility(4);
                    linearLayout.addView(view);
                    cVar.bht = linearLayout;
                    if (com.baidu.swan.impl.map.item.c.bhs.booleanValue()) {
                        if (dVar.azl != null && dVar.azl.isValid() && TextUtils.equals(dVar.azl.adG, "ALWAYS")) {
                            View a = a.a(bVar, dVar);
                            linearLayout.addView(a, 0);
                            cVar.bhr = a;
                        }
                        if (dVar.azm != null && dVar.azm.isValid()) {
                            c.a(bVar, cVar);
                        }
                    }
                    linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    builder.yOffset((int) ((bitmap.getHeight() * (1.0d - dVar.azn.y)) + 0.0d));
                    bVar.bhn.addView(linearLayout, builder.build());
                    linearLayout.setAlpha(0.0f);
                    BitmapDescriptor fromView2 = BitmapDescriptorFactory.fromView(linearLayout);
                    if (fromView2 != null) {
                        Bitmap bitmap2 = fromView2.getBitmap();
                        cVar.bhu = (Marker) bVar.bhn.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView2).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (dVar.azn.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (dVar.azn.y * bitmap.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                        bVar.ayO.add(cVar);
                    }
                }
            }
        }
    }
}
