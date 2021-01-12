package com.baidu.swan.impl.map.a.b;

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
import com.baidu.swan.apps.ao.s;
import com.baidu.swan.apps.w.a.a.d;
import com.baidu.tieba.R;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final Context context, @NonNull com.baidu.swan.apps.w.a.c cVar, @NonNull final com.baidu.swan.impl.map.item.c cVar2) {
        List<com.baidu.swan.apps.w.a.a.d> list = cVar.dfr;
        if (list != null && list.size() != 0) {
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            final int size = list.size();
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            for (final com.baidu.swan.apps.w.a.a.d dVar : list) {
                final com.baidu.swan.impl.map.item.b bVar = new com.baidu.swan.impl.map.item.b();
                if (dVar.dfU == null) {
                    dVar.dfU = new d.a();
                }
                String str = dVar.dfP;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.PU(R.drawable.pin_red).exQ().exF().toString();
                }
                s.a(str, new s.a() { // from class: com.baidu.swan.impl.map.a.b.f.1
                    @Override // com.baidu.swan.apps.ao.s.a
                    public void g(String str2, Bitmap bitmap) {
                        if (f.DEBUG) {
                            Log.d("MarkerViewCreateHelper", "url=" + str2);
                        }
                        if (bitmap == null) {
                            bitmap = f.bas();
                        }
                        Bitmap a2 = f.a(bitmap, com.baidu.swan.apps.w.a.a.d.this);
                        LatLng latLng = new LatLng(com.baidu.swan.apps.w.a.a.d.this.dfp.latitude, com.baidu.swan.apps.w.a.a.d.this.dfp.longitude);
                        MarkerOptions anchor = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(a2)).alpha((float) com.baidu.swan.apps.w.a.a.d.this.dfR).title(com.baidu.swan.apps.w.a.a.d.this.title).rotate((float) com.baidu.swan.apps.w.a.a.d.this.dfK).zIndex(88).anchor((float) com.baidu.swan.apps.w.a.a.d.this.dfU.x, (float) com.baidu.swan.apps.w.a.a.d.this.dfU.y);
                        bVar.emZ = com.baidu.swan.apps.w.a.a.d.this;
                        arrayList.add(anchor);
                        LinearLayout linearLayout = new LinearLayout(context);
                        linearLayout.setOrientation(1);
                        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        linearLayout.setGravity(17);
                        View view = new View(context);
                        view.setLayoutParams(new ViewGroup.LayoutParams(a2.getWidth(), a2.getHeight()));
                        view.setVisibility(4);
                        linearLayout.addView(view);
                        bVar.enf = linearLayout;
                        if (com.baidu.swan.impl.map.item.b.ene.booleanValue()) {
                            if (com.baidu.swan.apps.w.a.a.d.this.dfS != null && com.baidu.swan.apps.w.a.a.d.this.dfS.isValid() && TextUtils.equals(com.baidu.swan.apps.w.a.a.d.this.dfS.crw, "ALWAYS")) {
                                View a3 = a.a(cVar2, com.baidu.swan.apps.w.a.a.d.this);
                                linearLayout.addView(a3, 0);
                                bVar.enc = a3;
                            }
                            if (com.baidu.swan.apps.w.a.a.d.this.dfT != null && com.baidu.swan.apps.w.a.a.d.this.dfT.isValid()) {
                                arrayList2.add(c.a(cVar2, bVar));
                            }
                        }
                        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                        builder.position(latLng);
                        builder.yOffset((int) ((a2.getHeight() * (1.0d - com.baidu.swan.apps.w.a.a.d.this.dfU.y)) + 0.0d));
                        cVar2.enq.addView(linearLayout, builder.build());
                        linearLayout.setAlpha(0.0f);
                        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                        if (fromView != null) {
                            Bitmap bitmap2 = fromView.getBitmap();
                            arrayList3.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - a2.getWidth()) / 2.0f) + (com.baidu.swan.apps.w.a.a.d.this.dfU.x * a2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - a2.getHeight())) + (com.baidu.swan.apps.w.a.a.d.this.dfU.y * a2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                            atomicInteger.getAndIncrement();
                            cVar2.dfr.add(bVar);
                            if (size == atomicInteger.get()) {
                                List<Overlay> addOverlays = cVar2.enq.getMap().addOverlays(arrayList2);
                                int size2 = addOverlays.size();
                                for (int i = 0; i < size2; i++) {
                                    cVar2.dfr.get(i).enb = (Marker) addOverlays.get(i);
                                }
                                List<Overlay> addOverlays2 = cVar2.enq.getMap().addOverlays(arrayList);
                                int size3 = addOverlays2.size();
                                for (int i2 = 0; i2 < size3; i2++) {
                                    cVar2.dfr.get(i2).ena = (Marker) addOverlays2.get(i2);
                                }
                                List<Overlay> addOverlays3 = cVar2.enq.getMap().addOverlays(arrayList3);
                                int size4 = addOverlays3.size();
                                for (int i3 = 0; i3 < size4; i3++) {
                                    cVar2.dfr.get(i3).eng = (Marker) addOverlays3.get(i3);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public static void a(@NonNull com.baidu.swan.apps.w.a.c cVar, @NonNull com.baidu.swan.impl.map.item.c cVar2, com.baidu.swan.impl.map.b.b bVar) {
        if (cVar.dfu != null && cVar.dfu.size() > 0) {
            for (com.baidu.swan.apps.w.a.a.b bVar2 : cVar.dfu) {
                b.a(cVar2, bVar2, bVar);
                com.baidu.swan.apps.console.c.i("map", "initMapView createControl id " + bVar2.id);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (cVar.dfs != null && cVar.dfs.size() > 0) {
            for (com.baidu.swan.apps.w.a.a.f fVar : cVar.dfs) {
                if (!fVar.isValid()) {
                    com.baidu.swan.apps.console.c.e("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.dfZ.size());
                    Iterator<com.baidu.swan.apps.w.a.a.c> it = fVar.dfZ.iterator();
                    while (it.hasNext()) {
                        com.baidu.swan.apps.w.a.a.c next = it.next();
                        arrayList2.add(new LatLng(next.latitude, next.longitude));
                    }
                    if (arrayList2.size() < 2 || arrayList2.contains(null)) {
                        com.baidu.swan.apps.console.c.e("map", "polyline count can't less than 2 or your polyline points contains null");
                    } else {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.color).width((int) fVar.width).dottedLine(fVar.dga));
                        com.baidu.swan.apps.console.c.i("map", "initMapView createPoly");
                    }
                }
            }
        }
        if (cVar.dfw != null && !cVar.dfw.isEmpty()) {
            for (com.baidu.swan.apps.w.a.a.e eVar : cVar.dfw) {
                if (!eVar.isValid()) {
                    com.baidu.swan.apps.console.c.e("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.dfZ.size());
                    Iterator<com.baidu.swan.apps.w.a.a.c> it2 = eVar.dfZ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.swan.apps.w.a.a.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    if (arrayList3.size() < 3 || arrayList3.contains(null)) {
                        com.baidu.swan.apps.console.c.e("map", "polygons count can't less than 3 or your polygons points contains null");
                    } else {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.strokeWidth, eVar.strokeColor)).fillColor(eVar.dfO).zIndex(eVar.axq));
                        com.baidu.swan.apps.console.c.i("map", "initMapView createPolygons");
                    }
                }
            }
        }
        if (cVar.dfv != null && cVar.dfv.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (com.baidu.swan.apps.w.a.a.c cVar3 : cVar.dfv) {
                builder.include(new LatLng(cVar3.latitude, cVar3.longitude));
            }
            cVar2.enq.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            com.baidu.swan.apps.console.c.i("map", "initMapView includePoints");
        }
        if (cVar.dft != null && cVar.dft.size() > 0) {
            for (com.baidu.swan.apps.w.a.a.a aVar : cVar.dft) {
                if (aVar.isValid()) {
                    arrayList.add(new CircleOptions().center(new LatLng(aVar.dfp.latitude, aVar.dfp.longitude)).stroke(new Stroke((int) aVar.strokeWidth, aVar.color)).fillColor(aVar.dfO).radius(aVar.radius));
                    com.baidu.swan.apps.console.c.i("map", "initMapView createCircle");
                }
            }
        }
        if (arrayList != null) {
            cVar2.enq.getMap().addOverlays(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static Bitmap a(Bitmap bitmap, com.baidu.swan.apps.w.a.a.d dVar) {
        return com.baidu.swan.impl.map.f.b.d(bitmap, dVar.width == -1 ? bitmap.getWidth() : dVar.width, dVar.height == -1 ? bitmap.getHeight() : dVar.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap bas() {
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.pin_red);
    }
}
