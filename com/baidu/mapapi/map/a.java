package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Overlay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements Overlay.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaiduMap a;

    public a(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baiduMap;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, overlay) == null) {
            if (overlay != null) {
                list6 = this.a.f35770k;
                if (list6.contains(overlay)) {
                    Bundle a = overlay.a();
                    eVar3 = this.a.f35768i;
                    if (eVar3 != null) {
                        eVar4 = this.a.f35768i;
                        eVar4.d(a);
                    }
                    list7 = this.a.f35770k;
                    list7.remove(overlay);
                }
            }
            if (overlay != null) {
                list4 = this.a.m;
                if (list4.contains(overlay)) {
                    list5 = this.a.m;
                    list5.remove(overlay);
                }
            }
            if (overlay != null) {
                list = this.a.l;
                if (list.contains(overlay)) {
                    Marker marker = (Marker) overlay;
                    if (marker.o != null) {
                        list2 = this.a.l;
                        list2.remove(marker);
                        list3 = this.a.l;
                        if (list3.size() == 0) {
                            eVar = this.a.f35768i;
                            if (eVar != null) {
                                eVar2 = this.a.f35768i;
                                eVar2.b(false);
                            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, overlay) == null) {
            if (overlay != null) {
                list4 = this.a.f35770k;
                if (list4.contains(overlay)) {
                    boolean z = false;
                    if (overlay instanceof Marker) {
                        Marker marker = (Marker) overlay;
                        if (marker.f35897b != null) {
                            ArrayList<BitmapDescriptor> arrayList = marker.o;
                            if (arrayList != null && arrayList.size() > 1) {
                                Bundle bundle = new Bundle();
                                eVar5 = this.a.f35768i;
                                if (eVar5 != null) {
                                    marker.remove();
                                    marker.o.clear();
                                    eVar6 = this.a.f35768i;
                                    eVar6.b(overlay.a(bundle));
                                    list8 = this.a.f35770k;
                                    list8.add(overlay);
                                    z = true;
                                }
                            }
                        } else {
                            ArrayList<BitmapDescriptor> arrayList2 = marker.o;
                            if (arrayList2 != null && arrayList2.size() != 0) {
                                list5 = this.a.l;
                                if (list5.contains(marker)) {
                                    list7 = this.a.l;
                                    list7.remove(marker);
                                }
                                list6 = this.a.l;
                                list6.add(marker);
                                eVar3 = this.a.f35768i;
                                if (eVar3 != null) {
                                    eVar4 = this.a.f35768i;
                                    eVar4.b(true);
                                }
                            }
                        }
                    }
                    eVar = this.a.f35768i;
                    if (eVar != null && !z) {
                        Bundle bundle2 = new Bundle();
                        eVar2 = this.a.f35768i;
                        eVar2.c(overlay.a(bundle2));
                    }
                }
            }
            list = this.a.m;
            if (list.contains(overlay)) {
                list3 = this.a.m;
                list3.remove(overlay);
            }
            if (overlay instanceof Marker) {
                list2 = this.a.m;
                list2.add((Marker) overlay);
            }
        }
    }
}
