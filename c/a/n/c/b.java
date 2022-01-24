package c.a.n.c;

import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4600b;

    public b() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f4600b) {
                StringBuilder sb = new StringBuilder();
                if (DeviceUtils.isHarmonyOS(AppRuntime.getAppContext())) {
                    String harmonyVersion = DeviceUtils.getHarmonyVersion();
                    if (TextUtils.isEmpty(harmonyVersion)) {
                        harmonyVersion = "0.0";
                    }
                    sb.append("HMS");
                    sb.append("_");
                    sb.append(harmonyVersion);
                }
                this.a = sb.toString();
                this.f4600b = true;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
