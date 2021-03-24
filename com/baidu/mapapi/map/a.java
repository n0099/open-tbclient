package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Overlay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements Overlay.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7062a;

    public a(BaiduMap baiduMap) {
        this.f7062a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void a(Overlay overlay) {
        List list;
        List list2;
        List list3;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        com.baidu.mapsdkplatform.comapi.map.e eVar2;
        List list4;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.e eVar3;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.e eVar4;
        if (overlay != null) {
            list6 = this.f7062a.k;
            if (list6.contains(overlay)) {
                Bundle a2 = overlay.a();
                eVar3 = this.f7062a.i;
                if (eVar3 != null) {
                    eVar4 = this.f7062a.i;
                    eVar4.d(a2);
                }
                list7 = this.f7062a.k;
                list7.remove(overlay);
            }
        }
        if (overlay != null) {
            list4 = this.f7062a.m;
            if (list4.contains(overlay)) {
                list5 = this.f7062a.m;
                list5.remove(overlay);
            }
        }
        if (overlay != null) {
            list = this.f7062a.l;
            if (list.contains(overlay)) {
                Marker marker = (Marker) overlay;
                if (marker.o != null) {
                    list2 = this.f7062a.l;
                    list2.remove(marker);
                    list3 = this.f7062a.l;
                    if (list3.size() == 0) {
                        eVar = this.f7062a.i;
                        if (eVar != null) {
                            eVar2 = this.f7062a.i;
                            eVar2.b(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void b(Overlay overlay) {
        List list;
        List list2;
        List list3;
        List list4;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        com.baidu.mapsdkplatform.comapi.map.e eVar2;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.e eVar3;
        com.baidu.mapsdkplatform.comapi.map.e eVar4;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.e eVar5;
        com.baidu.mapsdkplatform.comapi.map.e eVar6;
        List list8;
        if (overlay != null) {
            list4 = this.f7062a.k;
            if (list4.contains(overlay)) {
                boolean z = false;
                if (overlay instanceof Marker) {
                    Marker marker = (Marker) overlay;
                    if (marker.f6942b != null) {
                        ArrayList<BitmapDescriptor> arrayList = marker.o;
                        if (arrayList != null && arrayList.size() > 1) {
                            Bundle bundle = new Bundle();
                            eVar5 = this.f7062a.i;
                            if (eVar5 != null) {
                                marker.remove();
                                marker.o.clear();
                                eVar6 = this.f7062a.i;
                                eVar6.b(overlay.a(bundle));
                                list8 = this.f7062a.k;
                                list8.add(overlay);
                                z = true;
                            }
                        }
                    } else {
                        ArrayList<BitmapDescriptor> arrayList2 = marker.o;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            list5 = this.f7062a.l;
                            if (list5.contains(marker)) {
                                list7 = this.f7062a.l;
                                list7.remove(marker);
                            }
                            list6 = this.f7062a.l;
                            list6.add(marker);
                            eVar3 = this.f7062a.i;
                            if (eVar3 != null) {
                                eVar4 = this.f7062a.i;
                                eVar4.b(true);
                            }
                        }
                    }
                }
                eVar = this.f7062a.i;
                if (eVar != null && !z) {
                    Bundle bundle2 = new Bundle();
                    eVar2 = this.f7062a.i;
                    eVar2.c(overlay.a(bundle2));
                }
            }
        }
        list = this.f7062a.m;
        if (list.contains(overlay)) {
            list3 = this.f7062a.m;
            list3.remove(overlay);
        }
        if (overlay instanceof Marker) {
            list2 = this.f7062a.m;
            list2.add((Marker) overlay);
        }
    }
}
