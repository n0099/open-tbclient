package c.q.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class r1 implements LocationListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public /* synthetic */ r1(p1 p1Var) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
            u1.f31469c.a = location.getLatitude();
            u1.f31469c.f31470b = location.getLongitude();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
        }
    }
}
