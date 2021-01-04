package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.s;
/* loaded from: classes9.dex */
public class b {
    public static void a(final com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.w.a.a.b bVar, final com.baidu.swan.impl.map.b.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            s.a(bVar.dkE, new s.a() { // from class: com.baidu.swan.impl.map.a.b.b.1
                @Override // com.baidu.swan.apps.ao.s.a
                public void g(String str, Bitmap bitmap) {
                    if (bitmap == null) {
                        com.baidu.swan.apps.console.c.w("map", " icon is null ");
                    }
                    if (bitmap != null) {
                        int width = com.baidu.swan.apps.w.a.a.b.this.dkF.width == -1 ? bitmap.getWidth() : com.baidu.swan.apps.w.a.a.b.this.dkF.width;
                        int height = com.baidu.swan.apps.w.a.a.b.this.dkF.height == -1 ? bitmap.getHeight() : com.baidu.swan.apps.w.a.a.b.this.dkF.height;
                        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                        builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                        builder.width(width);
                        builder.height(height);
                        builder.align(1, 8);
                        builder.point(new Point(com.baidu.swan.apps.w.a.a.b.this.dkF.left, com.baidu.swan.apps.w.a.a.b.this.dkF.top));
                        ImageView imageView = new ImageView(AppRuntime.getAppContext());
                        imageView.setImageBitmap(bitmap);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setClickable(com.baidu.swan.apps.w.a.a.b.this.bpK);
                        cVar.esf.addView(imageView, builder.build());
                        imageView.setOnClickListener(bVar2);
                        com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                        aVar.erN = com.baidu.swan.apps.w.a.a.b.this;
                        aVar.erO = imageView;
                        cVar.dkj.add(aVar);
                    }
                }
            });
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
