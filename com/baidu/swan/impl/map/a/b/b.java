package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.p;
/* loaded from: classes12.dex */
public class b {
    public static void a(final com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.z.a.a.b bVar, final com.baidu.swan.impl.map.b.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            p.a(bVar.iconPath, new p.a() { // from class: com.baidu.swan.impl.map.a.b.b.1
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str, Bitmap bitmap) {
                    if (bitmap == null) {
                        com.baidu.swan.apps.console.c.w("map", " icon is null ");
                    }
                    if (bitmap != null) {
                        int width = com.baidu.swan.apps.z.a.a.b.this.bAk.width == -1 ? bitmap.getWidth() : com.baidu.swan.apps.z.a.a.b.this.bAk.width;
                        int height = com.baidu.swan.apps.z.a.a.b.this.bAk.height == -1 ? bitmap.getHeight() : com.baidu.swan.apps.z.a.a.b.this.bAk.height;
                        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                        builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                        builder.width(width);
                        builder.height(height);
                        builder.align(1, 8);
                        builder.point(new Point(com.baidu.swan.apps.z.a.a.b.this.bAk.left, com.baidu.swan.apps.z.a.a.b.this.bAk.f1008top));
                        ImageView imageView = new ImageView(AppRuntime.getAppContext());
                        imageView.setImageBitmap(bitmap);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setClickable(com.baidu.swan.apps.z.a.a.b.this.atm);
                        cVar.cwr.addView(imageView, builder.build());
                        imageView.setOnClickListener(bVar2);
                        com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                        aVar.cvZ = com.baidu.swan.apps.z.a.a.b.this;
                        aVar.cwa = imageView;
                        cVar.bzP.add(aVar);
                    }
                }
            });
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
