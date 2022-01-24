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
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f12188c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f12189b;

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
        f12188c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f12188c.put("3GNET", 21);
        f12188c.put("3GWAP", 22);
        f12188c.put("CMNET", 31);
        f12188c.put("UNINET", 32);
        f12188c.put("CTNET", 33);
        f12188c.put("CMWAP", 41);
        f12188c.put("UNIWAP", 42);
        f12188c.put("CTWAP", 43);
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
                this.f12189b = a.getSubtype();
            }
            "wifi".toUpperCase();
            this.a = upperCase;
            this.f12189b = a.getSubtype();
        }
    }
}
