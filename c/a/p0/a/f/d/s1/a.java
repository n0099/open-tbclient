package c.a.p0.a.f.d.s1;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.g1.f;
import c.a.p0.a.v0.e.f.c;
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

    /* renamed from: c.a.p0.a.f.d.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0273a {
        public static final String a = c.r("SwanApkFetcher.Params", "title");

        /* renamed from: b  reason: collision with root package name */
        public static final String f5116b = c.r("SwanApkFetcher.Params", EmotionResourceInfo.JSON_KEY_PKG_NAME);

        /* renamed from: c  reason: collision with root package name */
        public static final String f5117c = c.r("SwanApkFetcher.Params", "description");

        /* renamed from: d  reason: collision with root package name */
        public static final String f5118d = c.r("SwanApkFetcher.Params", "should_auto_install");

        /* renamed from: e  reason: collision with root package name */
        public static final String f5119e = c.r("SwanApkFetcher.Params", "current_swan_app");

        /* renamed from: f  reason: collision with root package name */
        public static final String f5120f = c.r("SwanApkFetcher.Params", "content_disposition");

        /* renamed from: g  reason: collision with root package name */
        public static final String f5121g = c.r("SwanApkFetcher.Params", "mime_type");

        /* renamed from: h  reason: collision with root package name */
        public static final String f5122h = c.r("SwanApkFetcher.Params", "user_agent");

        /* renamed from: i  reason: collision with root package name */
        public static final String f5123i = c.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);

        /* renamed from: j  reason: collision with root package name */
        public static final String f5124j = c.r("SwanApkFetcher.Params", "ext_info");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) ? t(InterfaceC0273a.f5118d, bool.booleanValue()) : (a) invokeL.objValue;
    }

    public a F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? z(InterfaceC0273a.f5120f, str) : (a) invokeL.objValue;
    }

    public a G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(InterfaceC0273a.f5123i, str) : (a) invokeL.objValue;
    }

    public a H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(InterfaceC0273a.f5119e, str) : (a) invokeL.objValue;
    }

    public a I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? z(InterfaceC0273a.f5117c, str) : (a) invokeL.objValue;
    }

    public a J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? z(InterfaceC0273a.f5124j, str) : (a) invokeL.objValue;
    }

    public a K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? z(InterfaceC0273a.f5121g, str) : (a) invokeL.objValue;
    }

    public a L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? z(InterfaceC0273a.f5116b, str) : (a) invokeL.objValue;
    }

    public a M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (a) invokeV.objValue;
    }

    public a N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? z(InterfaceC0273a.a, str) : (a) invokeL.objValue;
    }

    public a O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? z(InterfaceC0273a.f5122h, str) : (a) invokeL.objValue;
    }

    @Override // c.a.p0.a.p2.g1.f
    public /* bridge */ /* synthetic */ f a() {
        M();
        return this;
    }
}
