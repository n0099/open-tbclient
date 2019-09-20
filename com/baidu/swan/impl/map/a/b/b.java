package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes5.dex */
public class b {
    public static void a(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.b bVar2, com.baidu.swan.impl.map.b.b bVar3) {
        com.baidu.swan.apps.console.c.i("map", "createControl start");
        if (bVar2 != null && bVar2.isValid()) {
            Bitmap H = com.baidu.swan.impl.map.e.b.H(bVar2.aBl, false);
            if (H == null) {
                com.baidu.swan.apps.console.c.w("map", " icon is null ");
            }
            if (H != null) {
                int width = bVar2.aBn.width == -1 ? H.getWidth() : bVar2.aBn.width;
                int height = bVar2.aBn.height == -1 ? H.getHeight() : bVar2.aBn.height;
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(width);
                builder.height(height);
                builder.align(1, 8);
                builder.point(new Point(bVar2.aBn.left, bVar2.aBn.top));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(H);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(bVar2.aBm);
                bVar.boD.addView(imageView, builder.build());
                imageView.setOnClickListener(bVar3);
                com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                aVar.boA = bVar2;
                aVar.boB = imageView;
                bVar.aAU.add(aVar);
            }
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
