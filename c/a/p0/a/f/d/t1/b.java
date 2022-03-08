package c.a.p0.a.f.d.t1;

import android.os.Bundle;
import c.a.p0.a.p2.g1.f;
import c.a.p0.a.v0.e.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public final class b extends c<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        public static final String a = c.r("SwanFileFetcher.Params", "file_url");

        /* renamed from: b  reason: collision with root package name */
        public static final String f5125b = c.r("SwanFileFetcher.Params", "file_save_path");

        /* renamed from: c  reason: collision with root package name */
        public static final String f5126c = c.r("SwanFileFetcher.Params", "file_head_map");

        /* renamed from: d  reason: collision with root package name */
        public static final String f5127d = c.r("SwanFileFetcher.Params", "image_save_gallery");

        /* renamed from: e  reason: collision with root package name */
        public static final String f5128e = c.r("SwanFileFetcher.Params", "file_cancel_tag");
    }

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

    public b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? z(a.f5128e, str) : (b) invokeL.objValue;
    }

    public b F(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return u(a.f5126c, bundle);
        }
        return (b) invokeL.objValue;
    }

    public b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(a.f5125b, str) : (b) invokeL.objValue;
    }

    public b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(a.a, str) : (b) invokeL.objValue;
    }

    public b I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? t(a.f5127d, z) : (b) invokeZ.objValue;
    }

    public b J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (b) invokeV.objValue;
    }

    @Override // c.a.p0.a.p2.g1.f
    public /* bridge */ /* synthetic */ f a() {
        J();
        return this;
    }
}
