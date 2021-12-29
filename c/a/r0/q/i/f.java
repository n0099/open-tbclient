package c.a.r0.q.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes6.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f11761g;

    /* renamed from: h  reason: collision with root package name */
    public int f11762h;

    /* renamed from: i  reason: collision with root package name */
    public long f11763i;

    /* renamed from: j  reason: collision with root package name */
    public String f11764j;

    /* renamed from: k  reason: collision with root package name */
    public long f11765k;
    public String l;
    public String m;
    public String n;

    public f() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f11761g) || this.f11763i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof f)) {
                f fVar = (f) obj;
                return (TextUtils.isEmpty(this.f11764j) && TextUtils.isEmpty(fVar.f11764j)) ? this.f11761g.equals(fVar.f11761g) && this.f11763i == fVar.f11763i : TextUtils.equals(this.f11761g, fVar.f11761g) && this.f11763i == fVar.f11763i && TextUtils.equals(this.f11764j, fVar.f11764j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f11761g, Integer.valueOf(this.f11762h), Long.valueOf(this.f11763i), this.f11764j) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "bundleId=" + this.f11761g + ", category=" + this.f11762h + ", versionCode=" + this.f11763i + ", versionName=" + this.f11764j + ", size=" + this.f11765k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
        }
        return (String) invokeV.objValue;
    }
}
