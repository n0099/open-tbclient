package c.a.b0.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static h f1880b;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public c.a.h0.a.b.c<IWebViewDataDirectoryManager> f1881a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1767444504, "Lc/a/b0/c/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1767444504, "Lc/a/b0/c/a/h;");
                return;
            }
        }
        f1880b = new h();
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1880b : (h) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.h0.a.b.a b2 = c.a.h0.a.b.a.b();
            this.f1881a = b2;
            b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.b0.i.b.a()) {
                String str = "webViewDataDirectoryManagerHolder class=" + this.f1881a.getClass();
            }
            this.f1881a.get().setDataDirectorySuffix();
        }
    }
}
