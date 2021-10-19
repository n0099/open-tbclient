package c.a.s.a.e;

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
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f29906c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29907a;

    /* renamed from: b  reason: collision with root package name */
    public int f29908b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273611343, "Lc/a/s/a/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-273611343, "Lc/a/s/a/e/d;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f29906c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f29906c.put("3GNET", 21);
        f29906c.put("3GWAP", 22);
        f29906c.put("CMNET", 31);
        f29906c.put("UNINET", 32);
        f29906c.put("CTNET", 33);
        f29906c.put("CMWAP", 41);
        f29906c.put("UNIWAP", 42);
        f29906c.put("CTWAP", 43);
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
        NetworkInfo a2 = e.a(context);
        if (a2 != null) {
            if (!"wifi".equals(a2.getTypeName().toLowerCase())) {
                String extraInfo = a2.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.f29908b = a2.getSubtype();
            }
            "wifi".toUpperCase();
            this.f29907a = upperCase;
            this.f29908b = a2.getSubtype();
        }
    }
}
