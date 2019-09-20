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
        Bitmap H;
        if (bVar != null && dVar.isValid() && (H = com.baidu.swan.impl.map.e.b.H(dVar.aBl, true)) != null) {
            com.baidu.swan.impl.map.item.c cVar = new com.baidu.swan.impl.map.item.c();
            int width = dVar.width == -1 ? H.getWidth() : dVar.width;
            int height = dVar.height == -1 ? H.getHeight() : dVar.height;
            if (width > 0 && height > 0) {
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                imageView.setImageBitmap(com.baidu.swan.impl.map.e.b.c(H, width, height));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.aBr == null) {
                    dVar.aBr = new d.a();
                }
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                if (fromView != null) {
                    Bitmap bitmap = fromView.getBitmap();
                    LatLng latLng = new LatLng(dVar.aAP.latitude, dVar.aAP.longitude);
                    cVar.boF = (Marker) bVar.boD.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView).alpha((float) dVar.aBo).title(dVar.title).rotate((float) dVar.aBf).zIndex(88).anchor((float) dVar.aBr.x, (float) dVar.aBr.y));
                    cVar.boE = dVar;
                    LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    linearLayout.setGravity(17);
                    View view = new View(AppRuntime.getAppContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                    view.setVisibility(4);
                    linearLayout.addView(view);
                    cVar.boJ = linearLayout;
                    if (com.baidu.swan.impl.map.item.c.boI.booleanValue()) {
                        if (dVar.aBp != null && dVar.aBp.isValid() && TextUtils.equals(dVar.aBp.abR, "ALWAYS")) {
                            View a = a.a(bVar, dVar);
                            linearLayout.addView(a, 0);
                            cVar.boH = a;
                        }
                        if (dVar.aBq != null && dVar.aBq.isValid()) {
                            c.a(bVar, cVar);
                        }
                    }
                    linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    builder.yOffset((int) ((bitmap.getHeight() * (1.0d - dVar.aBr.y)) + 0.0d));
                    bVar.boD.addView(linearLayout, builder.build());
                    linearLayout.setAlpha(0.0f);
                    BitmapDescriptor fromView2 = BitmapDescriptorFactory.fromView(linearLayout);
                    if (fromView2 != null) {
                        Bitmap bitmap2 = fromView2.getBitmap();
                        cVar.boK = (Marker) bVar.boD.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView2).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (dVar.aBr.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (dVar.aBr.y * bitmap.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                        bVar.aAR.add(cVar);
                    }
                }
            }
        }
    }
}
