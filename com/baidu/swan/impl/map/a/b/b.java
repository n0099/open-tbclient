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
            Bitmap K = com.baidu.swan.impl.map.e.b.K(bVar2.aUz, false);
            if (K == null) {
                com.baidu.swan.apps.console.c.w("map", " icon is null ");
            }
            if (K != null) {
                int width = bVar2.aUB.width == -1 ? K.getWidth() : bVar2.aUB.width;
                int height = bVar2.aUB.height == -1 ? K.getHeight() : bVar2.aUB.height;
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(width);
                builder.height(height);
                builder.align(1, 8);
                builder.point(new Point(bVar2.aUB.left, bVar2.aUB.top));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(K);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(bVar2.aUA);
                bVar.bHp.addView(imageView, builder.build());
                imageView.setOnClickListener(bVar3);
                com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                aVar.bHm = bVar2;
                aVar.bHn = imageView;
                bVar.aUi.add(aVar);
            }
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
