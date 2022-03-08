package c.a.p0.m.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaiduMap f10884e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f10885f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f10886g;

    public c(BaiduMap baiduMap) {
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
        this.f10884e = null;
        this.f10885f = null;
        this.f10886g = null;
        this.f10884e = baiduMap;
        if (0 == 0) {
            this.f10885f = new ArrayList();
        }
        if (this.f10886g == null) {
            this.f10886g = new ArrayList();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10884e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f10885f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f10885f) {
            this.f10886g.add(this.f10884e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f10884e == null) {
            return;
        }
        for (Overlay overlay : this.f10886g) {
            overlay.remove();
        }
        this.f10885f.clear();
        this.f10886g.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f10884e == null || this.f10886g.size() <= 0) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Overlay overlay : this.f10886g) {
            if (overlay instanceof Marker) {
                builder.include(((Marker) overlay).getPosition());
            }
        }
        this.f10884e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
    }
}
