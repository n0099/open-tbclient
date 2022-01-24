package c.a.r0.a.m1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.f2.f.o0.j;
import c.a.r0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public final class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f7814e;

    /* renamed from: f  reason: collision with root package name */
    public String f7815f;

    /* renamed from: g  reason: collision with root package name */
    public String f7816g;

    /* renamed from: h  reason: collision with root package name */
    public String f7817h;

    /* renamed from: i  reason: collision with root package name */
    public String f7818i;

    /* renamed from: j  reason: collision with root package name */
    public String f7819j;

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

    public static String b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7814e)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7815f)) {
                return bVar.f7814e;
            }
            return bVar.f7814e + "?" + bVar.f7815f;
        }
        return (String) invokeL.objValue;
    }

    public static String c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7817h)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7815f)) {
                return bVar.f7817h;
            }
            return bVar.f7817h + "?" + bVar.f7815f;
        }
        return (String) invokeL.objValue;
    }

    public static b e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            b bVar = new b();
            bVar.f7814e = o0.f(str);
            bVar.f7815f = o0.o(str);
            bVar.f7816g = str2;
            bVar.f7817h = j.b(bVar.f7814e);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    @Nullable
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b(this) : (String) invokeV.objValue;
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7814e : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7815f : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7817h : (String) invokeV.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f7815f = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppPageParam{mPage='" + this.f7814e + ExtendedMessageFormat.QUOTE + ", mParams='" + this.f7815f + ExtendedMessageFormat.QUOTE + ", mBaseUrl='" + this.f7816g + ExtendedMessageFormat.QUOTE + ", mRoutePage='" + this.f7817h + ExtendedMessageFormat.QUOTE + ", mRoutType='" + this.f7818i + ExtendedMessageFormat.QUOTE + ", mRouteId='" + this.f7819j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
