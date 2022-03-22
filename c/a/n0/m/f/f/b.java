package c.a.n0.m.f.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import c.a.n0.a.p2.t;
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
        public final /* synthetic */ c.a.n0.a.y0.c.h.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.m.i.c f9030b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.m.g.b f9031c;

        public a(c.a.n0.a.y0.c.h.b bVar, c.a.n0.m.i.c cVar, c.a.n0.m.g.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f9030b = cVar;
            this.f9031c = bVar2;
        }

        @Override // c.a.n0.a.p2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    c.a.n0.a.u.d.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i = this.a.f7703d.f7731c;
                    if (i == -1) {
                        i = bitmap.getWidth();
                    }
                    int i2 = this.a.f7703d.f7732d;
                    if (i2 == -1) {
                        i2 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i);
                    builder.height(i2);
                    builder.align(1, 8);
                    c.a.n0.a.y0.c.h.g gVar = this.a.f7703d;
                    builder.point(new Point(gVar.a, gVar.f7730b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f9030b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f9031c);
                    imageView.setClickable(this.a.f7702c);
                    c.a.n0.m.i.a aVar = new c.a.n0.m.i.a();
                    aVar.a = this.a;
                    aVar.f9040b = imageView;
                    this.f9030b.o.add(aVar);
                }
            }
        }
    }

    public static void a(c.a.n0.m.i.c cVar, c.a.n0.a.y0.c.h.b bVar, c.a.n0.m.g.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            c.a.n0.a.u.d.i("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f7701b, new a(bVar, cVar, bVar2));
            }
            c.a.n0.a.u.d.i("map", "createControl end");
        }
    }
}
