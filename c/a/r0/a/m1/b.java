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
    public String f7843e;

    /* renamed from: f  reason: collision with root package name */
    public String f7844f;

    /* renamed from: g  reason: collision with root package name */
    public String f7845g;

    /* renamed from: h  reason: collision with root package name */
    public String f7846h;

    /* renamed from: i  reason: collision with root package name */
    public String f7847i;

    /* renamed from: j  reason: collision with root package name */
    public String f7848j;

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
            if (bVar == null || TextUtils.isEmpty(bVar.f7843e)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7844f)) {
                return bVar.f7843e;
            }
            return bVar.f7843e + "?" + bVar.f7844f;
        }
        return (String) invokeL.objValue;
    }

    public static String c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7846h)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7844f)) {
                return bVar.f7846h;
            }
            return bVar.f7846h + "?" + bVar.f7844f;
        }
        return (String) invokeL.objValue;
    }

    public static b e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            b bVar = new b();
            bVar.f7843e = o0.f(str);
            bVar.f7844f = o0.o(str);
            bVar.f7845g = str2;
            bVar.f7846h = j.b(bVar.f7843e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7843e : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7844f : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7846h : (String) invokeV.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f7844f = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppPageParam{mPage='" + this.f7843e + ExtendedMessageFormat.QUOTE + ", mParams='" + this.f7844f + ExtendedMessageFormat.QUOTE + ", mBaseUrl='" + this.f7845g + ExtendedMessageFormat.QUOTE + ", mRoutePage='" + this.f7846h + ExtendedMessageFormat.QUOTE + ", mRoutType='" + this.f7847i + ExtendedMessageFormat.QUOTE + ", mRouteId='" + this.f7848j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
