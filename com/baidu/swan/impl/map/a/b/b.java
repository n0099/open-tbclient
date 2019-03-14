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
            Bitmap F = com.baidu.swan.impl.map.e.b.F(bVar2.azd, false);
            if (F == null) {
                com.baidu.swan.apps.console.c.w("map", " icon is null ");
            }
            if (F != null) {
                int width = bVar2.azf.width == -1 ? F.getWidth() : bVar2.azf.width;
                int height = bVar2.azf.height == -1 ? F.getHeight() : bVar2.azf.height;
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(width);
                builder.height(height);
                builder.align(1, 8);
                builder.point(new Point(bVar2.azf.left, bVar2.azf.top));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(F);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(bVar2.aze);
                bVar.bhj.addView(imageView, builder.build());
                imageView.setOnClickListener(bVar3);
                com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                aVar.bhg = bVar2;
                aVar.bhh = imageView;
                bVar.ayN.add(aVar);
            }
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
