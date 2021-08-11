package c.a.n0.j.k.f;

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
import c.a.n0.a.h1.c.h.d;
import c.a.n0.a.k;
import c.a.n0.a.v2.t;
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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11451a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h1.c.h.d f11452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.n.b f11453b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f11454c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f11455d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.n.c f11456e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f11457f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f11458g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f11459h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f11460i;

        public a(c.a.n0.a.h1.c.h.d dVar, c.a.n0.j.n.b bVar, List list, Context context, c.a.n0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
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
            this.f11452a = dVar;
            this.f11453b = bVar;
            this.f11454c = list;
            this.f11455d = context;
            this.f11456e = cVar;
            this.f11457f = list2;
            this.f11458g = list3;
            this.f11459h = atomicInteger;
            this.f11460i = i2;
        }

        @Override // c.a.n0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (g.f11451a) {
                    String str2 = "url=" + str;
                }
                if (bitmap == null) {
                    bitmap = g.f();
                }
                Bitmap g2 = g.g(bitmap, this.f11452a);
                c.a.n0.a.h1.c.h.c cVar = this.f11452a.f6262f;
                LatLng latLng = new LatLng(cVar.f6259e, cVar.f6260f);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f11452a.f6266j).title(this.f11452a.f6263g).rotate((float) this.f11452a.f6265i).zIndex(88);
                d.a aVar = this.f11452a.o;
                MarkerOptions anchor = zIndex.anchor((float) aVar.f6267e, (float) aVar.f6268f);
                this.f11453b.f11474a = this.f11452a;
                this.f11454c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.f11455d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view = new View(this.f11455d);
                view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
                view.setVisibility(4);
                linearLayout.addView(view);
                this.f11453b.f11478e = linearLayout;
                if (c.a.n0.j.n.b.f11473h.booleanValue()) {
                    d.b bVar = this.f11452a.m;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.f11452a.m.k, "ALWAYS")) {
                        View a2 = c.a.n0.j.k.f.a.a(this.f11456e, this.f11452a);
                        linearLayout.addView(a2, 0);
                        this.f11453b.f11477d = a2;
                    }
                    d.c cVar2 = this.f11452a.n;
                    if (cVar2 != null && cVar2.isValid()) {
                        this.f11457f.add(c.a(this.f11456e, this.f11453b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f11452a.o.f6268f)) + 0.0d));
                this.f11456e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.f11458g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f11452a.o.f6267e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f11452a.o.f6268f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (e.f11449a) {
                    this.f11459h.getAndIncrement();
                    this.f11456e.n.add(this.f11453b);
                    int size = this.f11456e.n.size();
                    if (this.f11460i == this.f11459h.get()) {
                        List<Overlay> addOverlays = this.f11456e.l.getMap().addOverlays(this.f11457f);
                        int size2 = addOverlays.size();
                        for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                            this.f11456e.n.get(i2).f11476c = (Marker) addOverlays.get(i2);
                        }
                        List<Overlay> addOverlays2 = this.f11456e.l.getMap().addOverlays(this.f11454c);
                        int size3 = addOverlays2.size();
                        for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                            this.f11456e.n.get(i3).f11475b = (Marker) addOverlays2.get(i3);
                        }
                        List<Overlay> addOverlays3 = this.f11456e.l.getMap().addOverlays(this.f11458g);
                        int size4 = addOverlays3.size();
                        for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                            this.f11456e.n.get(i4).f11479f = (Marker) addOverlays3.get(i4);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1805295149, "Lc/a/n0/j/k/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1805295149, "Lc/a/n0/j/k/f/g;");
                return;
            }
        }
        f11451a = k.f6803a;
    }

    public static void d(@NonNull c.a.n0.a.h1.c.c cVar, @NonNull c.a.n0.j.n.c cVar2, c.a.n0.j.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, cVar2, bVar) == null) {
            List<c.a.n0.a.h1.c.h.b> list = cVar.s;
            if (list != null && list.size() > 0) {
                for (c.a.n0.a.h1.c.h.b bVar2 : cVar.s) {
                    b.a(cVar2, bVar2, bVar);
                    c.a.n0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f6255e);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<c.a.n0.a.h1.c.h.f> list2 = cVar.q;
            if (list2 != null && list2.size() > 0) {
                for (c.a.n0.a.h1.c.h.f fVar : cVar.q) {
                    if (!fVar.isValid()) {
                        c.a.n0.a.e0.d.b("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(fVar.f6281e.size());
                        Iterator<c.a.n0.a.h1.c.h.c> it = fVar.f6281e.iterator();
                        while (it.hasNext()) {
                            c.a.n0.a.h1.c.h.c next = it.next();
                            arrayList2.add(new LatLng(next.f6259e, next.f6260f));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f6282f).width((int) fVar.f6283g).dottedLine(fVar.f6284h));
                            c.a.n0.a.e0.d.g("map", "initMapView createPoly");
                        } else {
                            c.a.n0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<c.a.n0.a.h1.c.h.e> list3 = cVar.u;
            if (list3 != null && !list3.isEmpty()) {
                for (c.a.n0.a.h1.c.h.e eVar : cVar.u) {
                    if (!eVar.isValid()) {
                        c.a.n0.a.e0.d.b("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(eVar.f6276e.size());
                        Iterator<c.a.n0.a.h1.c.h.c> it2 = eVar.f6276e.iterator();
                        while (it2.hasNext()) {
                            c.a.n0.a.h1.c.h.c next2 = it2.next();
                            arrayList3.add(new LatLng(next2.f6259e, next2.f6260f));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f6277f, eVar.f6278g)).fillColor(eVar.f6279h).zIndex(eVar.f6280i));
                            c.a.n0.a.e0.d.g("map", "initMapView createPolygons");
                        } else {
                            c.a.n0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<c.a.n0.a.h1.c.h.c> list4 = cVar.t;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (c.a.n0.a.h1.c.h.c cVar3 : cVar.t) {
                    builder.include(new LatLng(cVar3.f6259e, cVar3.f6260f));
                }
                cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                c.a.n0.a.e0.d.g("map", "initMapView includePoints");
            }
            List<c.a.n0.a.h1.c.h.a> list5 = cVar.r;
            if (list5 != null && list5.size() > 0) {
                for (c.a.n0.a.h1.c.h.a aVar : cVar.r) {
                    if (aVar.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        c.a.n0.a.h1.c.h.c cVar4 = aVar.f6250e;
                        arrayList.add(circleOptions.center(new LatLng(cVar4.f6259e, cVar4.f6260f)).stroke(new Stroke((int) aVar.f6254i, aVar.f6251f)).fillColor(aVar.f6252g).radius(aVar.f6253h));
                        c.a.n0.a.e0.d.g("map", "initMapView createCircle");
                    }
                }
            }
            cVar2.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull c.a.n0.a.h1.c.c cVar, @NonNull c.a.n0.j.n.c cVar2) {
        List<c.a.n0.a.h1.c.h.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, cVar, cVar2) == null) || (list = cVar.p) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<c.a.n0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            c.a.n0.a.h1.c.h.d next = it.next();
            c.a.n0.j.n.b bVar = new c.a.n0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f6264h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(c.a.n0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), c.a.n0.j.d.pin_red) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, c.a.n0.a.h1.c.h.d dVar) {
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
            return c.a.n0.j.r.b.a(bitmap, i2, i3);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
