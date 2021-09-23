package c.a.p0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import c.a.p0.a.v2.t;
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
        public final /* synthetic */ c.a.p0.a.h1.c.h.b f11726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.n.c f11727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.l.b f11728c;

        public a(c.a.p0.a.h1.c.h.b bVar, c.a.p0.j.n.c cVar, c.a.p0.j.l.b bVar2) {
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
            this.f11726a = bVar;
            this.f11727b = cVar;
            this.f11728c = bVar2;
        }

        @Override // c.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    c.a.p0.a.e0.d.l("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f11726a.f6540h.f6569g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f11726a.f6540h.f6570h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    c.a.p0.a.h1.c.h.g gVar = this.f11726a.f6540h;
                    builder.point(new Point(gVar.f6567e, gVar.f6568f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f11727b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f11728c);
                    imageView.setClickable(this.f11726a.f6539g);
                    c.a.p0.j.n.a aVar = new c.a.p0.j.n.a();
                    aVar.f11753a = this.f11726a;
                    aVar.f11754b = imageView;
                    this.f11727b.o.add(aVar);
                }
            }
        }
    }

    public static void a(c.a.p0.j.n.c cVar, c.a.p0.a.h1.c.h.b bVar, c.a.p0.j.l.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            c.a.p0.a.e0.d.g("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f6538f, new a(bVar, cVar, bVar2));
            }
            c.a.p0.a.e0.d.g("map", "createControl end");
        }
    }
}
