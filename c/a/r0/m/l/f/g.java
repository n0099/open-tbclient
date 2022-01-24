package c.a.r0.m.l.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.i1.c.h.d;
import c.a.r0.a.k;
import c.a.r0.a.z2.t;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.i1.c.h.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.m.o.b f11503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f11504c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f11505d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.m.o.c f11506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f11507f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f11508g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f11509h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f11510i;

        public a(c.a.r0.a.i1.c.h.d dVar, c.a.r0.m.o.b bVar, List list, Context context, c.a.r0.m.o.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, list, context, cVar, list2, list3, atomicInteger, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f11503b = bVar;
            this.f11504c = list;
            this.f11505d = context;
            this.f11506e = cVar;
            this.f11507f = list2;
            this.f11508g = list3;
            this.f11509h = atomicInteger;
            this.f11510i = i2;
        }

        @Override // c.a.r0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (g.a) {
                    String str2 = "url=" + str;
                }
                if (bitmap == null) {
                    bitmap = g.f();
                }
                Bitmap g2 = g.g(bitmap, this.a);
                c.a.r0.a.i1.c.h.c cVar = this.a.f7359f;
                LatLng latLng = new LatLng(cVar.f7356e, cVar.f7357f);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.a.f7363j).title(this.a.f7360g).rotate((float) this.a.f7362i).zIndex(88);
                d.a aVar = this.a.o;
                MarkerOptions anchor = zIndex.anchor((float) aVar.f7364e, (float) aVar.f7365f);
                this.f11503b.a = this.a;
                this.f11504c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.f11505d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view = new View(this.f11505d);
                view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
                view.setVisibility(4);
                linearLayout.addView(view);
                this.f11503b.f11522e = linearLayout;
                if (c.a.r0.m.o.b.f11518h.booleanValue()) {
                    d.b bVar = this.a.m;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.m.k, "ALWAYS")) {
                        View a = c.a.r0.m.l.f.a.a(this.f11506e, this.a);
                        linearLayout.addView(a, 0);
                        this.f11503b.f11521d = a;
                    }
                    d.c cVar2 = this.a.n;
                    if (cVar2 != null && cVar2.isValid()) {
                        this.f11507f.add(c.a(this.f11506e, this.f11503b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g2.getHeight() * (1.0d - this.a.o.f7365f)) + 0.0d));
                this.f11506e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.f11508g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.a.o.f7364e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.a.o.f7365f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (e.a) {
                    this.f11509h.getAndIncrement();
                    this.f11506e.n.add(this.f11503b);
                    int size = this.f11506e.n.size();
                    if (this.f11510i == this.f11509h.get()) {
                        List<Overlay> addOverlays = this.f11506e.l.getMap().addOverlays(this.f11507f);
                        int size2 = addOverlays.size();
                        for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                            this.f11506e.n.get(i2).f11520c = (Marker) addOverlays.get(i2);
                        }
                        List<Overlay> addOverlays2 = this.f11506e.l.getMap().addOverlays(this.f11504c);
                        int size3 = addOverlays2.size();
                        for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                            this.f11506e.n.get(i3).f11519b = (Marker) addOverlays2.get(i3);
                        }
                        List<Overlay> addOverlays3 = this.f11506e.l.getMap().addOverlays(this.f11508g);
                        int size4 = addOverlays3.size();
                        for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                            this.f11506e.n.get(i4).f11523f = (Marker) addOverlays3.get(i4);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125450131, "Lc/a/r0/m/l/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125450131, "Lc/a/r0/m/l/f/g;");
                return;
            }
        }
        a = k.a;
    }

    public static void d(@NonNull c.a.r0.a.i1.c.c cVar, @NonNull c.a.r0.m.o.c cVar2, c.a.r0.m.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, cVar2, bVar) == null) {
            List<c.a.r0.a.i1.c.h.b> list = cVar.s;
            if (list != null && list.size() > 0) {
                for (c.a.r0.a.i1.c.h.b bVar2 : cVar.s) {
                    b.a(cVar2, bVar2, bVar);
                    c.a.r0.a.e0.d.i("map", "initMapView createControl id " + bVar2.f7352e);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<c.a.r0.a.i1.c.h.f> list2 = cVar.q;
            if (list2 != null && list2.size() > 0) {
                for (c.a.r0.a.i1.c.h.f fVar : cVar.q) {
                    if (!fVar.isValid()) {
                        c.a.r0.a.e0.d.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(fVar.f7378e.size());
                        Iterator<c.a.r0.a.i1.c.h.c> it = fVar.f7378e.iterator();
                        while (it.hasNext()) {
                            c.a.r0.a.i1.c.h.c next = it.next();
                            arrayList2.add(new LatLng(next.f7356e, next.f7357f));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f7379f).width((int) fVar.f7380g).dottedLine(fVar.f7381h));
                            c.a.r0.a.e0.d.i("map", "initMapView createPoly");
                        } else {
                            c.a.r0.a.e0.d.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<c.a.r0.a.i1.c.h.e> list3 = cVar.u;
            if (list3 != null && !list3.isEmpty()) {
                for (c.a.r0.a.i1.c.h.e eVar : cVar.u) {
                    if (!eVar.isValid()) {
                        c.a.r0.a.e0.d.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(eVar.f7373e.size());
                        Iterator<c.a.r0.a.i1.c.h.c> it2 = eVar.f7373e.iterator();
                        while (it2.hasNext()) {
                            c.a.r0.a.i1.c.h.c next2 = it2.next();
                            arrayList3.add(new LatLng(next2.f7356e, next2.f7357f));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f7374f, eVar.f7375g)).fillColor(eVar.f7376h).zIndex(eVar.f7377i));
                            c.a.r0.a.e0.d.i("map", "initMapView createPolygons");
                        } else {
                            c.a.r0.a.e0.d.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<c.a.r0.a.i1.c.h.c> list4 = cVar.t;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (c.a.r0.a.i1.c.h.c cVar3 : cVar.t) {
                    builder.include(new LatLng(cVar3.f7356e, cVar3.f7357f));
                }
                cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                c.a.r0.a.e0.d.i("map", "initMapView includePoints");
            }
            List<c.a.r0.a.i1.c.h.a> list5 = cVar.r;
            if (list5 != null && list5.size() > 0) {
                for (c.a.r0.a.i1.c.h.a aVar : cVar.r) {
                    if (aVar.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        c.a.r0.a.i1.c.h.c cVar4 = aVar.f7347e;
                        arrayList.add(circleOptions.center(new LatLng(cVar4.f7356e, cVar4.f7357f)).stroke(new Stroke((int) aVar.f7351i, aVar.f7348f)).fillColor(aVar.f7349g).radius(aVar.f7350h));
                        c.a.r0.a.e0.d.i("map", "initMapView createCircle");
                    }
                }
            }
            cVar2.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull c.a.r0.a.i1.c.c cVar, @NonNull c.a.r0.m.o.c cVar2) {
        List<c.a.r0.a.i1.c.h.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, cVar, cVar2) == null) || (list = cVar.p) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<c.a.r0.a.i1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            c.a.r0.a.i1.c.h.d next = it.next();
            c.a.r0.m.o.b bVar = new c.a.r0.m.o.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f7361h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(c.a.r0.m.e.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), c.a.r0.m.e.pin_red) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, c.a.r0.a.i1.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, dVar)) == null) {
            int i2 = dVar.k;
            if (i2 == -1) {
                i2 = bitmap.getWidth();
            }
            int i3 = dVar.l;
            if (i3 == -1) {
                i3 = bitmap.getHeight();
            }
            return c.a.r0.m.s.b.a(bitmap, i2, i3);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
