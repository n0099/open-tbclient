package c.a.r0.m.l.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import c.a.r0.a.z2.t;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.i1.c.h.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.m.o.c f11500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.m.m.b f11501c;

        public a(c.a.r0.a.i1.c.h.b bVar, c.a.r0.m.o.c cVar, c.a.r0.m.m.b bVar2) {
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
            this.f11500b = cVar;
            this.f11501c = bVar2;
        }

        @Override // c.a.r0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    c.a.r0.a.e0.d.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.a.f7355h.f7384g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.a.f7355h.f7385h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    c.a.r0.a.i1.c.h.g gVar = this.a.f7355h;
                    builder.point(new Point(gVar.f7382e, gVar.f7383f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f11500b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f11501c);
                    imageView.setClickable(this.a.f7354g);
                    c.a.r0.m.o.a aVar = new c.a.r0.m.o.a();
                    aVar.a = this.a;
                    aVar.f11517b = imageView;
                    this.f11500b.o.add(aVar);
                }
            }
        }
    }

    public static void a(c.a.r0.m.o.c cVar, c.a.r0.a.i1.c.h.b bVar, c.a.r0.m.m.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            c.a.r0.a.e0.d.i("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f7353f, new a(bVar, cVar, bVar2));
            }
            c.a.r0.a.e0.d.i("map", "createControl end");
        }
    }
}
