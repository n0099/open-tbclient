package c.a.k.b.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes.dex */
public class a implements WebKitFactory.WebkitInstallListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f3774c = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte f3775a;

    /* renamed from: b  reason: collision with root package name */
    public long f3776b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1956241687, "Lc/a/k/b/d/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1956241687, "Lc/a/k/b/d/b/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c(LoadErrorCode loadErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, loadErrorCode) == null) {
            BdSailorPlatform.getStatic().b("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
        }
    }

    public final void a(LoadErrorCode loadErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, loadErrorCode) == null) {
            WebKitFactory.setEngine(0);
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f3775a, loadErrorCode);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        this.f3775a = (byte) 0;
        if (!str.startsWith("file://")) {
            str = "file://".concat(String.valueOf(str));
        }
        BdZeusUtil.printKernellog("install plugin from download");
        WebKitFactory.installAsync(str, this);
        this.f3776b = System.currentTimeMillis();
        Log.i(f3774c, "full update started!");
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            System.currentTimeMillis();
            Log.i("soar", "the return value of installing kernal is: ".concat(String.valueOf(i2)));
            BdZeusUtil.printKernellog("oninstalled: " + i2 + " targetpath: " + str);
            if (i2 == 0) {
                Log.d(f3774c, "install success!");
                BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.f3775a);
            } else {
                Log.d(f3774c, "install failed!");
                BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f3775a, WebKitFactory.getLoadErrorCode());
            }
            BdSailorPlatform.getWebkitManager().enableBdWebkit();
            long currentTimeMillis = System.currentTimeMillis() - this.f3776b;
            String str2 = f3774c;
            Log.i(str2, "total timecost: " + String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
