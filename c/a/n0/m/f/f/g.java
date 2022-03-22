package c.a.n0.m.f.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.t;
import c.a.n0.a.y0.c.h.d;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.y0.c.h.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.m.i.b f9032b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f9033c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f9034d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.m.i.c f9035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f9036f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f9037g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f9038h;
        public final /* synthetic */ int i;

        public a(c.a.n0.a.y0.c.h.d dVar, c.a.n0.m.i.b bVar, List list, Context context, c.a.n0.m.i.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, list, context, cVar, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f9032b = bVar;
            this.f9033c = list;
            this.f9034d = context;
            this.f9035e = cVar;
            this.f9036f = list2;
            this.f9037g = list3;
            this.f9038h = atomicInteger;
            this.i = i;
        }

        @Override // c.a.n0.a.p2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (g.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = g.f();
                }
                Bitmap g2 = g.g(bitmap, this.a);
                c.a.n0.a.y0.c.h.c cVar = this.a.f7705b;
                LatLng latLng = new LatLng(cVar.a, cVar.f7704b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.a.f7709f).title(this.a.f7706c).rotate((float) this.a.f7708e).zIndex(88);
                d.a aVar = this.a.k;
                MarkerOptions anchor = zIndex.anchor((float) aVar.a, (float) aVar.f7712b);
                this.f9032b.a = this.a;
                this.f9033c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.f9034d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view = new View(this.f9034d);
                view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
                view.setVisibility(4);
                linearLayout.addView(view);
                this.f9032b.f9045e = linearLayout;
                if (c.a.n0.m.i.b.f9041h.booleanValue()) {
                    d.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.f7714g, "ALWAYS")) {
                        View a = c.a.n0.m.f.f.a.a(this.f9035e, this.a);
                        linearLayout.addView(a, 0);
                        this.f9032b.f9044d = a;
                    }
                    d.c cVar2 = this.a.j;
                    if (cVar2 != null && cVar2.isValid()) {
                        this.f9036f.add(c.a(this.f9035e, this.f9032b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g2.getHeight() * (1.0d - this.a.k.f7712b)) + 0.0d));
                this.f9035e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.f9037g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.a.k.a * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.a.k.f7712b * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (e.a) {
                    this.f9038h.getAndIncrement();
                    this.f9035e.n.add(this.f9032b);
                    int size = this.f9035e.n.size();
                    if (this.i == this.f9038h.get()) {
                        List<Overlay> addOverlays = this.f9035e.l.getMap().addOverlays(this.f9036f);
                        int size2 = addOverlays.size();
                        for (int i = 0; i < size2 && i < size; i++) {
                            this.f9035e.n.get(i).f9043c = (Marker) addOverlays.get(i);
                        }
                        List<Overlay> addOverlays2 = this.f9035e.l.getMap().addOverlays(this.f9033c);
                        int size3 = addOverlays2.size();
                        for (int i2 = 0; i2 < size3 && i2 < size; i2++) {
                            this.f9035e.n.get(i2).f9042b = (Marker) addOverlays2.get(i2);
                        }
                        List<Overlay> addOverlays3 = this.f9035e.l.getMap().addOverlays(this.f9037g);
                        int size4 = addOverlays3.size();
                        for (int i3 = 0; i3 < size4 && i3 < size; i3++) {
                            this.f9035e.n.get(i3).f9046f = (Marker) addOverlays3.get(i3);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699354193, "Lc/a/n0/m/f/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699354193, "Lc/a/n0/m/f/f/g;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void d(@NonNull c.a.n0.a.y0.c.c cVar, @NonNull c.a.n0.m.i.c cVar2, c.a.n0.m.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, cVar2, bVar) == null) {
            List<c.a.n0.a.y0.c.h.b> list = cVar.o;
            if (list != null && list.size() > 0) {
                for (c.a.n0.a.y0.c.h.b bVar2 : cVar.o) {
                    b.a(cVar2, bVar2, bVar);
                    c.a.n0.a.u.d.i("map", "initMapView createControl id " + bVar2.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<c.a.n0.a.y0.c.h.f> list2 = cVar.m;
            if (list2 != null && list2.size() > 0) {
                for (c.a.n0.a.y0.c.h.f fVar : cVar.m) {
                    if (!fVar.isValid()) {
                        c.a.n0.a.u.d.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(fVar.a.size());
                        Iterator<c.a.n0.a.y0.c.h.c> it = fVar.a.iterator();
                        while (it.hasNext()) {
                            c.a.n0.a.y0.c.h.c next = it.next();
                            arrayList2.add(new LatLng(next.a, next.f7704b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f7727b).width((int) fVar.f7728c).dottedLine(fVar.f7729d));
                            c.a.n0.a.u.d.i("map", "initMapView createPoly");
                        } else {
                            c.a.n0.a.u.d.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<c.a.n0.a.y0.c.h.e> list3 = cVar.q;
            if (list3 != null && !list3.isEmpty()) {
                for (c.a.n0.a.y0.c.h.e eVar : cVar.q) {
                    if (!eVar.isValid()) {
                        c.a.n0.a.u.d.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(eVar.a.size());
                        Iterator<c.a.n0.a.y0.c.h.c> it2 = eVar.a.iterator();
                        while (it2.hasNext()) {
                            c.a.n0.a.y0.c.h.c next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.f7704b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f7723b, eVar.f7724c)).fillColor(eVar.f7725d).zIndex(eVar.f7726e));
                            c.a.n0.a.u.d.i("map", "initMapView createPolygons");
                        } else {
                            c.a.n0.a.u.d.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<c.a.n0.a.y0.c.h.c> list4 = cVar.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (c.a.n0.a.y0.c.h.c cVar3 : cVar.p) {
                    builder.include(new LatLng(cVar3.a, cVar3.f7704b));
                }
                cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                c.a.n0.a.u.d.i("map", "initMapView includePoints");
            }
            List<c.a.n0.a.y0.c.h.a> list5 = cVar.n;
            if (list5 != null && list5.size() > 0) {
                for (c.a.n0.a.y0.c.h.a aVar : cVar.n) {
                    if (aVar.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        c.a.n0.a.y0.c.h.c cVar4 = aVar.a;
                        arrayList.add(circleOptions.center(new LatLng(cVar4.a, cVar4.f7704b)).stroke(new Stroke((int) aVar.f7700e, aVar.f7697b)).fillColor(aVar.f7698c).radius(aVar.f7699d));
                        c.a.n0.a.u.d.i("map", "initMapView createCircle");
                    }
                }
            }
            cVar2.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull c.a.n0.a.y0.c.c cVar, @NonNull c.a.n0.m.i.c cVar2) {
        List<c.a.n0.a.y0.c.h.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, cVar, cVar2) == null) || (list = cVar.l) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<c.a.n0.a.y0.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            c.a.n0.a.y0.c.h.d next = it.next();
            c.a.n0.m.i.b bVar = new c.a.n0.m.i.b();
            if (next.k == null) {
                next.k = new d.a();
            }
            String str = next.f7707d;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080f76).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080f76) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, c.a.n0.a.y0.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, dVar)) == null) {
            int i = dVar.f7710g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = dVar.f7711h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return c.a.n0.m.m.b.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
