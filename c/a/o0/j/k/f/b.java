package c.a.o0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import c.a.o0.a.v2.t;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h1.c.h.b f11690a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.j.n.c f11691b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.j.l.b f11692c;

        public a(c.a.o0.a.h1.c.h.b bVar, c.a.o0.j.n.c cVar, c.a.o0.j.l.b bVar2) {
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
            this.f11690a = bVar;
            this.f11691b = cVar;
            this.f11692c = bVar2;
        }

        @Override // c.a.o0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    c.a.o0.a.e0.d.l("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f11690a.f6504h.f6533g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f11690a.f6504h.f6534h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    c.a.o0.a.h1.c.h.g gVar = this.f11690a.f6504h;
                    builder.point(new Point(gVar.f6531e, gVar.f6532f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f11691b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f11692c);
                    imageView.setClickable(this.f11690a.f6503g);
                    c.a.o0.j.n.a aVar = new c.a.o0.j.n.a();
                    aVar.f11717a = this.f11690a;
                    aVar.f11718b = imageView;
                    this.f11691b.o.add(aVar);
                }
            }
        }
    }

    public static void a(c.a.o0.j.n.c cVar, c.a.o0.a.h1.c.h.b bVar, c.a.o0.j.l.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            c.a.o0.a.e0.d.g("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f6502f, new a(bVar, cVar, bVar2));
            }
            c.a.o0.a.e0.d.g("map", "createControl end");
        }
    }
}
