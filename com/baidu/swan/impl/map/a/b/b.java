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
            Bitmap K = com.baidu.swan.impl.map.e.b.K(bVar2.aUh, false);
            if (K == null) {
                com.baidu.swan.apps.console.c.w("map", " icon is null ");
            }
            if (K != null) {
                int width = bVar2.aUj.width == -1 ? K.getWidth() : bVar2.aUj.width;
                int height = bVar2.aUj.height == -1 ? K.getHeight() : bVar2.aUj.height;
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(width);
                builder.height(height);
                builder.align(1, 8);
                builder.point(new Point(bVar2.aUj.left, bVar2.aUj.top));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(K);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(bVar2.aUi);
                bVar.bGy.addView(imageView, builder.build());
                imageView.setOnClickListener(bVar3);
                com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                aVar.bGv = bVar2;
                aVar.bGw = imageView;
                bVar.aTQ.add(aVar);
            }
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
