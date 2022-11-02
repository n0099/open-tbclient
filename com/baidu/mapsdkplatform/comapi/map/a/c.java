package com.baidu.mapsdkplatform.comapi.map.a;

import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.ag;
import com.baidu.platform.comapi.map.ap;
import com.baidu.platform.comapi.map.ar;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comapi.util.j;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comapi.map.a.a a;
    public com.baidu.mapsdkplatform.comapi.map.d b;
    public int c;
    public TraceAnimationListener d;
    public a e;
    public b f;
    public MapSurfaceView g;
    public MapTextureView h;
    public volatile boolean i;

    /* loaded from: classes2.dex */
    public class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 65302) {
                    int i2 = message.arg1;
                    if (i2 > 0 && i2 <= 1000 && this.a.d != null) {
                        this.a.d.onTraceAnimationUpdate(message.arg1 / 10);
                    }
                    if (message.arg2 == 1 && this.a.d != null) {
                        this.a.d.onTraceAnimationFinish();
                    }
                } else if (i == 65303 && this.a.d != null) {
                    this.a.d.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
                }
            }
        }
    }

    public c(MapSurfaceView mapSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapSurfaceView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 1;
        this.e = new a(this);
        this.i = false;
        if (mapSurfaceView == null) {
            return;
        }
        this.a = new com.baidu.mapsdkplatform.comapi.map.a.a();
        this.g = mapSurfaceView;
        this.b = mapSurfaceView.getBaseMap();
        mapSurfaceView.addOverlay(this.a);
        this.a.SetOverlayShow(true);
        this.c = 1;
    }

    private List<GeoPoint> d(TraceOverlay traceOverlay) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, traceOverlay)) == null) {
            if (traceOverlay != null && traceOverlay.getPoints() != null) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                ArrayList arrayList = new ArrayList();
                for (LatLng latLng : traceOverlay.getPoints()) {
                    arrayList.add(CoordUtil.ll2mc(latLng));
                    builder.include(latLng);
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public c(MapTextureView mapTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapTextureView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 1;
        this.e = new a(this);
        this.i = false;
        if (mapTextureView == null) {
            return;
        }
        this.a = new com.baidu.mapsdkplatform.comapi.map.a.a();
        this.h = mapTextureView;
        this.b = mapTextureView.getBaseMap();
        mapTextureView.addOverlay(this.a);
        this.a.SetOverlayShow(true);
        this.c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TraceOverlay traceOverlay) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, traceOverlay)) == null) {
            if (traceOverlay != null && this.a != null) {
                c();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TraceOverlay traceOverlay) {
        com.baidu.mapsdkplatform.comapi.map.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, traceOverlay) == null) && traceOverlay != null && (aVar = this.a) != null) {
            aVar.clear();
            j.b().execute(new f(this, traceOverlay));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TraceOverlay traceOverlay) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, traceOverlay) == null) && this.a != null && traceOverlay != null) {
            this.a.a(traceOverlay.isAnimate(), traceOverlay.getAnimationTime(), traceOverlay.getAnimationDuration(), traceOverlay.getAnimationType());
            ag agVar = new ag(new ap().a(-15794282).b(14));
            agVar.a(d(traceOverlay));
            agVar.a(new ar().d(DebugConstants.HTTP_ERRCODE_NOT_FIND).a(traceOverlay.getColor()).b(traceOverlay.getWidth()));
            agVar.c = traceOverlay.isTrackMove();
            this.a.a(agVar);
        }
    }

    public TraceOverlay a(TraceOptions traceOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, traceOptions)) == null) {
            if (traceOptions == null) {
                return null;
            }
            TraceOverlay overlay = traceOptions.getOverlay();
            overlay.mListener = this.f;
            j.b().execute(new e(this, overlay));
            return overlay;
        }
        return (TraceOverlay) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = new d(this);
            MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
            MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
        }
    }

    public void b() {
        com.baidu.mapsdkplatform.comapi.map.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (aVar = this.a) == null) {
            return;
        }
        aVar.clear();
        this.a.a();
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public void a(TraceAnimationListener traceAnimationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, traceAnimationListener) == null) {
            this.d = traceAnimationListener;
        }
    }

    public void c() {
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
            MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
            if (this.c == 1 && (mapSurfaceView = this.g) != null) {
                mapSurfaceView.removeOverlay(this.a);
            } else if (this.c == 2 && (mapTextureView = this.h) != null) {
                mapTextureView.removeOverlay(this.a);
            }
            if (this.d != null) {
                this.d = null;
            }
            this.i = true;
        }
    }
}
