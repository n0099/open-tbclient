package c.p.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            r1 r1Var = new r1(null);
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                String str = providers.contains("network") ? "network" : providers.contains("gps") ? "gps" : null;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    r1Var.onLocationChanged(lastKnownLocation);
                } else {
                    locationManager.requestLocationUpdates(str, 1000L, 0.0f, r1Var, Looper.getMainLooper());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
