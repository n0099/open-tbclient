package b.a.p0.m.l.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import b.a.p0.a.z2.t;
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
        public final /* synthetic */ b.a.p0.a.i1.c.h.b f11603a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.m.o.c f11604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.m.m.b f11605c;

        public a(b.a.p0.a.i1.c.h.b bVar, b.a.p0.m.o.c cVar, b.a.p0.m.m.b bVar2) {
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
            this.f11603a = bVar;
            this.f11604b = cVar;
            this.f11605c = bVar2;
        }

        @Override // b.a.p0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    b.a.p0.a.e0.d.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f11603a.f6485h.f6511g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f11603a.f6485h.f6512h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    b.a.p0.a.i1.c.h.g gVar = this.f11603a.f6485h;
                    builder.point(new Point(gVar.f6509e, gVar.f6510f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f11604b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f11605c);
                    imageView.setClickable(this.f11603a.f6484g);
                    b.a.p0.m.o.a aVar = new b.a.p0.m.o.a();
                    aVar.f11630a = this.f11603a;
                    aVar.f11631b = imageView;
                    this.f11604b.o.add(aVar);
                }
            }
        }
    }

    public static void a(b.a.p0.m.o.c cVar, b.a.p0.a.i1.c.h.b bVar, b.a.p0.m.m.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            b.a.p0.a.e0.d.i("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f6483f, new a(bVar, cVar, bVar2));
            }
            b.a.p0.a.e0.d.i("map", "createControl end");
        }
    }
}
