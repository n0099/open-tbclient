package b.a.p0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import b.a.p0.a.v2.t;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h1.c.h.b f10915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.n.c f10916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.l.b f10917c;

        public a(b.a.p0.a.h1.c.h.b bVar, b.a.p0.j.n.c cVar, b.a.p0.j.l.b bVar2) {
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
            this.f10915a = bVar;
            this.f10916b = cVar;
            this.f10917c = bVar2;
        }

        @Override // b.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    b.a.p0.a.e0.d.l("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f10915a.f5870h.f5896g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f10915a.f5870h.f5897h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    b.a.p0.a.h1.c.h.g gVar = this.f10915a.f5870h;
                    builder.point(new Point(gVar.f5894e, gVar.f5895f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f10916b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f10917c);
                    imageView.setClickable(this.f10915a.f5869g);
                    b.a.p0.j.n.a aVar = new b.a.p0.j.n.a();
                    aVar.f10942a = this.f10915a;
                    aVar.f10943b = imageView;
                    this.f10916b.o.add(aVar);
                }
            }
        }
    }

    public static void a(b.a.p0.j.n.c cVar, b.a.p0.a.h1.c.h.b bVar, b.a.p0.j.l.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            b.a.p0.a.e0.d.g("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f5868f, new a(bVar, cVar, bVar2));
            }
            b.a.p0.a.e0.d.g("map", "createControl end");
        }
    }
}
