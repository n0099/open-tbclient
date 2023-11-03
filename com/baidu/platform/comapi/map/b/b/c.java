package com.baidu.platform.comapi.map.b.b;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.x;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.al;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public long c;
    public MapController d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MapController mapController) {
        super(mapController);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MapController) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.d = mapController;
    }

    private void a(double d, MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Double.valueOf(d), mapStatus}) == null) {
            if (this.c == 0) {
                this.c = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            if (currentTimeMillis - currentTimeMillis <= 50 && Math.abs(d) >= 4.0d) {
                if (d > 0.0d) {
                    mapStatus.overlooking -= 4;
                } else {
                    mapStatus.overlooking = (int) (mapStatus.overlooking + 2.0d);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, pair) == null) {
            MapStatus mapStatus = this.d.getMapStatus();
            if (mapStatus.bOverlookSpringback) {
                if (mapStatus.overlooking > 0) {
                    mapStatus.overlooking = 0;
                } else {
                    mapStatus.overlooking = mapStatus.minOverlooking;
                }
                this.d.setMapStatusWithAnimation(mapStatus, 200);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, motionEvent) == null) {
            a.C0125a c0125a = bVar.b;
            a.C0125a c0125a2 = bVar.c;
            MapStatus mapStatus = this.d.getMapStatus();
            double d = c0125a2.a.b - c0125a.a.b;
            double d2 = c0125a2.b.b - c0125a.b.b;
            int i = ((d * d2) > 0.0d ? 1 : ((d * d2) == 0.0d ? 0 : -1));
            if (i > 0) {
                a(d, mapStatus);
            } else if (i == 0) {
                if (d != 0.0d) {
                    a(d, mapStatus);
                } else if (d2 != 0.0d) {
                    a(d2, mapStatus);
                }
            } else if (Math.abs(d) > Math.abs(d2)) {
                a(d, mapStatus);
            } else {
                a(d2, mapStatus);
            }
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
            List<al> listeners = this.d.getListeners();
            if (listeners != null) {
                x mapStatusInner = this.d.getMapStatusInner();
                for (int i2 = 0; i2 < listeners.size(); i2++) {
                    al alVar = listeners.get(i2);
                    if (alVar != null && alVar.c(point, point2, mapStatusInner)) {
                        return;
                    }
                }
            }
            this.d.setMapStatus(mapStatus);
            if (this.b) {
                this.b = false;
                this.d.getGestureMonitor().d();
            }
        }
    }
}
