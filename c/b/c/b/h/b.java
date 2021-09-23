package c.b.c.b.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.c.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31579a;

    /* renamed from: b  reason: collision with root package name */
    public c.b.c.b.g f31580b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f31581c;

    public b(@NonNull Context context, @NonNull c.b.c.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31579a = context;
        this.f31580b = gVar;
    }

    public static boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) ? map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code")) : invokeL.booleanValue;
    }

    @Nullable
    public Map<String, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, Object> a2 = this.f31580b.a();
            if (a2 == null) {
                a2 = new HashMap<>(4);
            }
            if (b(a2)) {
                try {
                    PackageInfo packageInfo = this.f31579a.getPackageManager().getPackageInfo(this.f31579a.getPackageName(), 128);
                    a2.put("version_name", packageInfo.versionName);
                    a2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                    if (a2.get("update_version_code") == null) {
                        Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                        if (obj == null) {
                            obj = a2.get("version_code");
                        }
                        a2.put("update_version_code", obj);
                    }
                } catch (Throwable unused) {
                    a2.put("version_name", l.b.l(this.f31579a));
                    a2.put("version_code", Integer.valueOf(l.b.m(this.f31579a)));
                    if (a2.get("update_version_code") == null) {
                        a2.put("update_version_code", a2.get("version_code"));
                    }
                }
            }
            return a2;
        }
        return (Map) invokeV.objValue;
    }

    @Nullable
    public Map<String, Object> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f31581c == null) {
                this.f31581c = this.f31580b.g();
            }
            return this.f31581c;
        }
        return (Map) invokeV.objValue;
    }

    @NonNull
    public c.b.c.b.g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31580b : (c.b.c.b.g) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l.b.k(this.f31579a) : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31580b.b() : (String) invokeV.objValue;
    }
}
