package b.a.p0.i.b.c;

import android.content.IntentFilter;
import b.a.p0.a.k;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h extends b.a.p0.i.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f10739c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1001754118, "Lb/a/p0/i/b/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1001754118, "Lb/a/p0/i/b/c/h;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h() {
        super("resumeAllDownloadWhileWifi");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.i.e.a
    public b.a.p0.a.u.h.b a(JSONObject jSONObject, b.a.p0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                bVar.onFail(202, "params may be error");
                return null;
            }
            if (this.f10739c == null) {
                this.f10739c = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            b.a.p0.a.c1.a.c().registerReceiver(this.f10739c, intentFilter);
            bVar.a(null);
            return null;
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }
}
