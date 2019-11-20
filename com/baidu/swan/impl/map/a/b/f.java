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
        Bitmap K;
        if (bVar != null && dVar.isValid() && (K = com.baidu.swan.impl.map.e.b.K(dVar.aUh, true)) != null) {
            com.baidu.swan.impl.map.item.c cVar = new com.baidu.swan.impl.map.item.c();
            int width = dVar.width == -1 ? K.getWidth() : dVar.width;
            int height = dVar.height == -1 ? K.getHeight() : dVar.height;
            if (width > 0 && height > 0) {
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                imageView.setImageBitmap(com.baidu.swan.impl.map.e.b.c(K, width, height));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.aUn == null) {
                    dVar.aUn = new d.a();
                }
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                if (fromView != null) {
                    Bitmap bitmap = fromView.getBitmap();
                    LatLng latLng = new LatLng(dVar.aTL.latitude, dVar.aTL.longitude);
                    cVar.bGA = (Marker) bVar.bGy.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView).alpha((float) dVar.aUk).title(dVar.title).rotate((float) dVar.aUb).zIndex(88).anchor((float) dVar.aUn.x, (float) dVar.aUn.y));
                    cVar.bGz = dVar;
                    LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    linearLayout.setGravity(17);
                    View view = new View(AppRuntime.getAppContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                    view.setVisibility(4);
                    linearLayout.addView(view);
                    cVar.bGE = linearLayout;
                    if (com.baidu.swan.impl.map.item.c.bGD.booleanValue()) {
                        if (dVar.aUl != null && dVar.aUl.isValid() && TextUtils.equals(dVar.aUl.Lo, "ALWAYS")) {
                            View a = a.a(bVar, dVar);
                            linearLayout.addView(a, 0);
                            cVar.bGC = a;
                        }
                        if (dVar.aUm != null && dVar.aUm.isValid()) {
                            c.a(bVar, cVar);
                        }
                    }
                    linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    builder.yOffset((int) ((bitmap.getHeight() * (1.0d - dVar.aUn.y)) + 0.0d));
                    bVar.bGy.addView(linearLayout, builder.build());
                    linearLayout.setAlpha(0.0f);
                    BitmapDescriptor fromView2 = BitmapDescriptorFactory.fromView(linearLayout);
                    if (fromView2 != null) {
                        Bitmap bitmap2 = fromView2.getBitmap();
                        cVar.bGF = (Marker) bVar.bGy.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView2).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (dVar.aUn.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (dVar.aUn.y * bitmap.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                        bVar.aTN.add(cVar);
                    }
                }
            }
        }
    }
}
