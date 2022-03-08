package com.baidu.ar.marker;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.c;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IMarker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<IMarker> sZ;
    public IMarkerStateListener ta;
    public b tb;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof IMarker)) {
            WeakReference<IMarker> weakReference = new WeakReference<>((IMarker) cVar);
            this.sZ = weakReference;
            if (this.ta != null) {
                weakReference.get().setMarkerStateListener(this.ta);
            }
            if (this.tb != null) {
                this.sZ.get().setTrackerSessionCallback(this.tb);
            }
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void chioceOneCoordinate(com.baidu.ar.marker.a.a aVar) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().chioceOneCoordinate(aVar);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void createSession() {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().createSession();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideFinalPoint() {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().hideFinalPoint();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void initMarkerByTrackerType(TrackerType trackerType) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, trackerType) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().initMarkerByTrackerType(trackerType);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] location2ScreenPoint(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fArr)) == null) {
            WeakReference<IMarker> weakReference = this.sZ;
            return (weakReference == null || weakReference.get() == null) ? new float[0] : this.sZ.get().location2ScreenPoint(fArr);
        }
        return (float[]) invokeL.objValue;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(float f2, float f3, float f4) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postArrow(f2, f3, f4);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(String str, int i2, double[] dArr, double[] dArr2, double[] dArr3, float f2, float f3) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i2), dArr, dArr2, dArr3, Float.valueOf(f2), Float.valueOf(f3)}) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postArrow(str, i2, dArr, dArr2, dArr3, f2, f3);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postFinalArrow(String str, double[] dArr) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, dArr) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postFinalArrow(str, dArr);
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.clear();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeAllArrow() {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().removeAllArrow();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeArrowByArrowId(String str) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().removeArrowByArrowId(str);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetMarker() {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().resetMarker();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAvailableFrame(MarkerFrameInfo markerFrameInfo) {
        WeakReference<IMarker> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, markerFrameInfo) == null) || (weakReference = this.sZ) == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().setAvailableFrame(markerFrameInfo);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iMarkerStateListener) == null) {
            this.ta = iMarkerStateListener;
            WeakReference<IMarker> weakReference = this.sZ;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.sZ.get().setMarkerStateListener(iMarkerStateListener);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setTrackerSessionCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.tb = bVar;
            WeakReference<IMarker> weakReference = this.sZ;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.sZ.get().setTrackerSessionCallback(bVar);
        }
    }
}
