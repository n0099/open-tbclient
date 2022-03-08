package c.a.p0.m.f.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import c.a.p0.a.p2.t;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.y0.c.h.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.i.c f10825b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.g.b f10826c;

        public a(c.a.p0.a.y0.c.h.b bVar, c.a.p0.m.i.c cVar, c.a.p0.m.g.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f10825b = cVar;
            this.f10826c = bVar2;
        }

        @Override // c.a.p0.a.p2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    c.a.p0.a.u.d.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.a.f9188h.f9217g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.a.f9188h.f9218h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    c.a.p0.a.y0.c.h.g gVar = this.a.f9188h;
                    builder.point(new Point(gVar.f9215e, gVar.f9216f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f10825b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f10826c);
                    imageView.setClickable(this.a.f9187g);
                    c.a.p0.m.i.a aVar = new c.a.p0.m.i.a();
                    aVar.a = this.a;
                    aVar.f10842b = imageView;
                    this.f10825b.o.add(aVar);
                }
            }
        }
    }

    public static void a(c.a.p0.m.i.c cVar, c.a.p0.a.y0.c.h.b bVar, c.a.p0.m.g.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            c.a.p0.a.u.d.i("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f9186f, new a(bVar, cVar, bVar2));
            }
            c.a.p0.a.u.d.i("map", "createControl end");
        }
    }
}
