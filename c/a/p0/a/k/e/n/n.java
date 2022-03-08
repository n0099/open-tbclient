package c.a.p0.a.k.e.n;

import android.media.AudioManager;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public AudioManager f6239f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NonNull c.a.p0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "VolumeApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.k.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#getMediaVolume", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.u.d.c("VolumeApi", "swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            }
            if (this.f6239f == null) {
                this.f6239f = (AudioManager) x.getSystemService("audio");
            }
            float streamMaxVolume = this.f6239f.getStreamMaxVolume(3);
            float streamVolume = this.f6239f.getStreamVolume(3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", streamVolume / streamMaxVolume);
                return new c.a.p0.a.k.h.b(0, jSONObject);
            } catch (JSONException unused) {
                return new c.a.p0.a.k.h.b(1001, "make result json error");
            }
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }

    public final int y(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            int round = Math.round(i2 * f2);
            if (round != 0 || f2 <= 0.0f) {
                return round;
            }
            return 1;
        }
        return invokeCommon.intValue;
    }

    public c.a.p0.a.k.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setMediaVolume", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.u.d.c("VolumeApi", "swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                try {
                    float parseFloat = Float.parseFloat(((JSONObject) s.second).optString("value"));
                    if (this.f6239f == null) {
                        this.f6239f = (AudioManager) x.getSystemService("audio");
                    }
                    int streamMaxVolume = this.f6239f.getStreamMaxVolume(3);
                    int y = y(parseFloat, streamMaxVolume);
                    if (y >= 0 && y <= streamMaxVolume) {
                        try {
                            this.f6239f.setStreamVolume(3, y, 1);
                            return c.a.p0.a.k.h.b.f();
                        } catch (SecurityException unused) {
                            return new c.a.p0.a.k.h.b(1001, "Cannot set volume under silent mode.");
                        }
                    }
                    return new c.a.p0.a.k.h.b(202, "value is illegal.");
                } catch (NumberFormatException unused2) {
                    c.a.p0.a.u.d.c("VolumeApi", "illegal argument type");
                    return new c.a.p0.a.k.h.b(202, "value is illegal.");
                }
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }
}
