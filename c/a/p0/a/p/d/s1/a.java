package c.a.p0.a.p.d.s1;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.f.c;
import c.a.p0.a.z2.g1.f;
import com.alipay.sdk.cons.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.p.d.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0403a {
        public static final String a = c.r("SwanApkFetcher.Params", "title");

        /* renamed from: b  reason: collision with root package name */
        public static final String f7285b = c.r("SwanApkFetcher.Params", EmotionResourceInfo.JSON_KEY_PKG_NAME);

        /* renamed from: c  reason: collision with root package name */
        public static final String f7286c = c.r("SwanApkFetcher.Params", "description");

        /* renamed from: d  reason: collision with root package name */
        public static final String f7287d = c.r("SwanApkFetcher.Params", "should_auto_install");

        /* renamed from: e  reason: collision with root package name */
        public static final String f7288e = c.r("SwanApkFetcher.Params", "current_swan_app");

        /* renamed from: f  reason: collision with root package name */
        public static final String f7289f = c.r("SwanApkFetcher.Params", "content_disposition");

        /* renamed from: g  reason: collision with root package name */
        public static final String f7290g = c.r("SwanApkFetcher.Params", "mime_type");

        /* renamed from: h  reason: collision with root package name */
        public static final String f7291h = c.r("SwanApkFetcher.Params", b.f31302b);

        /* renamed from: i  reason: collision with root package name */
        public static final String f7292i = c.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);

        /* renamed from: j  reason: collision with root package name */
        public static final String f7293j = c.r("SwanApkFetcher.Params", "ext_info");
    }

    public a() {
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

    public a E(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) ? t(InterfaceC0403a.f7287d, bool.booleanValue()) : (a) invokeL.objValue;
    }

    public a F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? z(InterfaceC0403a.f7289f, str) : (a) invokeL.objValue;
    }

    public a G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(InterfaceC0403a.f7292i, str) : (a) invokeL.objValue;
    }

    public a H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(InterfaceC0403a.f7288e, str) : (a) invokeL.objValue;
    }

    public a I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? z(InterfaceC0403a.f7286c, str) : (a) invokeL.objValue;
    }

    public a J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? z(InterfaceC0403a.f7293j, str) : (a) invokeL.objValue;
    }

    public a K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? z(InterfaceC0403a.f7290g, str) : (a) invokeL.objValue;
    }

    public a L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? z(InterfaceC0403a.f7285b, str) : (a) invokeL.objValue;
    }

    public a M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (a) invokeV.objValue;
    }

    public a N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? z(InterfaceC0403a.a, str) : (a) invokeL.objValue;
    }

    public a O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? z(InterfaceC0403a.f7291h, str) : (a) invokeL.objValue;
    }

    @Override // c.a.p0.a.z2.g1.f
    public /* bridge */ /* synthetic */ f a() {
        M();
        return this;
    }
}
