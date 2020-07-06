package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.q;
/* loaded from: classes12.dex */
public class b {
    public static void a(final com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.x.a.a.b bVar, final com.baidu.swan.impl.map.b.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            q.a(bVar.coa, new q.a() { // from class: com.baidu.swan.impl.map.a.b.b.1
                @Override // com.baidu.swan.apps.aq.q.a
                public void h(String str, Bitmap bitmap) {
                    if (bitmap == null) {
                        com.baidu.swan.apps.console.c.w("map", " icon is null ");
                    }
                    if (bitmap != null) {
                        int width = com.baidu.swan.apps.x.a.a.b.this.cob.width == -1 ? bitmap.getWidth() : com.baidu.swan.apps.x.a.a.b.this.cob.width;
                        int height = com.baidu.swan.apps.x.a.a.b.this.cob.height == -1 ? bitmap.getHeight() : com.baidu.swan.apps.x.a.a.b.this.cob.height;
                        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                        builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                        builder.width(width);
                        builder.height(height);
                        builder.align(1, 8);
                        builder.point(new Point(com.baidu.swan.apps.x.a.a.b.this.cob.left, com.baidu.swan.apps.x.a.a.b.this.cob.f1007top));
                        ImageView imageView = new ImageView(AppRuntime.getAppContext());
                        imageView.setImageBitmap(bitmap);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setClickable(com.baidu.swan.apps.x.a.a.b.this.aVu);
                        cVar.dls.addView(imageView, builder.build());
                        imageView.setOnClickListener(bVar2);
                        com.baidu.swan.impl.map.item.a aVar = new com.baidu.swan.impl.map.item.a();
                        aVar.dla = com.baidu.swan.apps.x.a.a.b.this;
                        aVar.dlb = imageView;
                        cVar.cnF.add(aVar);
                    }
                }
            });
        }
        com.baidu.swan.apps.console.c.i("map", "createControl end");
    }
}
