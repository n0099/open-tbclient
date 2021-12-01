package c.a.r.a.e;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f13814c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f13815b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2016421678, "Lc/a/r/a/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2016421678, "Lc/a/r/a/e/d;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f13814c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f13814c.put("3GNET", 21);
        f13814c.put("3GWAP", 22);
        f13814c.put("CMNET", 31);
        f13814c.put("UNINET", 32);
        f13814c.put("CTNET", 33);
        f13814c.put("CMWAP", 41);
        f13814c.put("UNIWAP", 42);
        f13814c.put("CTWAP", 43);
    }

    public d(Context context) {
        String upperCase;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        NetworkInfo a = e.a(context);
        if (a != null) {
            if (!"wifi".equals(a.getTypeName().toLowerCase())) {
                String extraInfo = a.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.f13815b = a.getSubtype();
            }
            "wifi".toUpperCase();
            this.a = upperCase;
            this.f13815b = a.getSubtype();
        }
    }
}
