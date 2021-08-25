package c.a.o0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.c2.f.p0.j;
import c.a.o0.a.v2.o0;
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
    public String f7208e;

    /* renamed from: f  reason: collision with root package name */
    public String f7209f;

    /* renamed from: g  reason: collision with root package name */
    public String f7210g;

    /* renamed from: h  reason: collision with root package name */
    public String f7211h;

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

    public static String e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7208e)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7209f)) {
                return bVar.f7208e;
            }
            return bVar.f7208e + "?" + bVar.f7209f;
        }
        return (String) invokeL.objValue;
    }

    public static String f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7211h)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f7209f)) {
                return bVar.f7211h;
            }
            return bVar.f7211h + "?" + bVar.f7209f;
        }
        return (String) invokeL.objValue;
    }

    public static b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            b bVar = new b();
            bVar.f7208e = o0.f(str);
            bVar.f7209f = o0.o(str);
            bVar.f7210g = str2;
            bVar.f7211h = j.b(bVar.f7208e);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    @Nullable
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e(this) : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7208e : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7209f : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7211h : (String) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f7209f = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppPageParam{mPage='" + this.f7208e + ExtendedMessageFormat.QUOTE + ", mParams='" + this.f7209f + ExtendedMessageFormat.QUOTE + ", mBaseUrl='" + this.f7210g + ExtendedMessageFormat.QUOTE + ", mRoutePage='" + this.f7211h + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
