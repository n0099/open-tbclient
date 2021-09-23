package com.baidu.ar;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.capture.ICapture;
import com.baidu.ar.cloud.ICloudIR;
import com.baidu.ar.face.IFace;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.recg.IOnDeviceIR;
import com.baidu.ar.track2d.ITrack2D;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ARProxyManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d> f38434a;

    public ARProxyManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38434a = new HashMap<>();
    }

    private d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (b(str)) {
                if (this.f38434a == null) {
                    this.f38434a = new HashMap<>();
                }
                d dVar = this.f38434a.get(str);
                if (dVar == null) {
                    dVar = c(str);
                }
                if (dVar != null) {
                    this.f38434a.put(str, dVar);
                }
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    private d c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if ("com.baidu.ar.face.FaceAR".equals(str)) {
                return new com.baidu.ar.face.a();
            }
            if ("com.baidu.ar.track2d.Track2DAR".equals(str)) {
                return new com.baidu.ar.track2d.a();
            }
            if ("com.baidu.ar.track3d.Track3DAR".equals(str)) {
                return new com.baidu.ar.g.c();
            }
            if ("com.baidu.ar.cloud.CloudAR".equals(str)) {
                return new com.baidu.ar.cloud.a();
            }
            if ("com.baidu.ar.recg.RecgAR".equals(str)) {
                return new com.baidu.ar.recg.a();
            }
            if ("com.baidu.ar.capture.FamilyWithChildAR".equals(str)) {
                return new com.baidu.ar.capture.b();
            }
            if ("com.baidu.ar.vps.marker.MarkerAR".equals(str)) {
                return new com.baidu.ar.marker.a();
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public void a(c cVar, String str) {
        d a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) || (a2 = a(str)) == null) {
            return;
        }
        a2.a(cVar);
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? "com.baidu.ar.face.FaceAR".equals(str) || "com.baidu.ar.track2d.Track2DAR".equals(str) || "com.baidu.ar.track3d.Track3DAR".equals(str) || "com.baidu.ar.cloud.CloudAR".equals(str) || "com.baidu.ar.recg.RecgAR".equals(str) || "com.baidu.ar.vps.marker.MarkerAR".equals(str) || "com.baidu.ar.capture.FamilyWithChildAR".equals(str) : invokeL.booleanValue;
    }

    public void d() {
        HashMap<String, d> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hashMap = this.f38434a) == null) {
            return;
        }
        for (d dVar : hashMap.values()) {
            dVar.a(null);
        }
    }

    public void d(String str) {
        HashMap<String, d> hashMap;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (hashMap = this.f38434a) == null || (dVar = hashMap.get(str)) == null) {
            return;
        }
        dVar.a(null);
    }

    public ICapture getCaptureAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (ICapture) a("com.baidu.ar.capture.FamilyWithChildAR") : (ICapture) invokeV.objValue;
    }

    public ICloudIR getCloudIRAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (ICloudIR) a("com.baidu.ar.cloud.CloudAR") : (ICloudIR) invokeV.objValue;
    }

    public IFace getFaceAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (IFace) a("com.baidu.ar.face.FaceAR") : (IFace) invokeV.objValue;
    }

    public IMarker getMarkerAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (IMarker) a("com.baidu.ar.vps.marker.MarkerAR") : (IMarker) invokeV.objValue;
    }

    public IOnDeviceIR getOnDeviceIRAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (IOnDeviceIR) a("com.baidu.ar.recg.RecgAR") : (IOnDeviceIR) invokeV.objValue;
    }

    public ITrack2D getTrack2DAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (ITrack2D) a("com.baidu.ar.track2d.Track2DAR") : (ITrack2D) invokeV.objValue;
    }

    public com.baidu.ar.g.a getTrack3DAR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (com.baidu.ar.g.a) a("com.baidu.ar.track3d.Track3DAR") : (com.baidu.ar.g.a) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d();
            HashMap<String, d> hashMap = this.f38434a;
            if (hashMap != null) {
                for (Map.Entry<String, d> entry : hashMap.entrySet()) {
                    entry.getValue().release();
                }
                this.f38434a.clear();
                this.f38434a = null;
            }
        }
    }
}
