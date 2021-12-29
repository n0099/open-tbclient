package c.a.t0.j3.f0.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18794b;

    /* renamed from: c  reason: collision with root package name */
    public long f18795c;

    /* renamed from: d  reason: collision with root package name */
    public int f18796d;

    /* renamed from: e  reason: collision with root package name */
    public long f18797e;

    /* renamed from: f  reason: collision with root package name */
    public String f18798f;

    /* renamed from: g  reason: collision with root package name */
    public String f18799g;

    /* renamed from: h  reason: collision with root package name */
    public int f18800h;

    /* renamed from: i  reason: collision with root package name */
    public String f18801i;

    /* renamed from: j  reason: collision with root package name */
    public String f18802j;

    /* renamed from: k  reason: collision with root package name */
    public String f18803k;

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

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return TextUtils.equals(this.a, bVar.a) && TextUtils.equals(this.f18794b, bVar.f18794b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.a + this.f18794b).hashCode();
        }
        return invokeV.intValue;
    }
}
