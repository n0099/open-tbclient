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
    public String f11636g;

    /* renamed from: h  reason: collision with root package name */
    public int f11637h;

    /* renamed from: i  reason: collision with root package name */
    public long f11638i;

    /* renamed from: j  reason: collision with root package name */
    public String f11639j;
    public long k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f11636g) || this.f11638i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true : invokeV.booleanValue;
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
                return (TextUtils.isEmpty(this.f11639j) && TextUtils.isEmpty(fVar.f11639j)) ? this.f11636g.equals(fVar.f11636g) && this.f11638i == fVar.f11638i : TextUtils.equals(this.f11636g, fVar.f11636g) && this.f11638i == fVar.f11638i && TextUtils.equals(this.f11639j, fVar.f11639j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f11636g, Integer.valueOf(this.f11637h), Long.valueOf(this.f11638i), this.f11639j) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "bundleId=" + this.f11636g + ", category=" + this.f11637h + ", versionCode=" + this.f11638i + ", versionName=" + this.f11639j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
        }
        return (String) invokeV.objValue;
    }
}
