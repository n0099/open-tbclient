package b.h.b.a.d0.v.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f32968a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f32969b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f32970c;

    public d(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32968a = str;
        this.f32969b = str2;
        this.f32970c = str3;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return v.a(this.f32968a, dVar.f32968a) && v.a(this.f32969b, dVar.f32969b) && v.a(this.f32970c, dVar.f32970c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f32968a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f32969b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f32970c;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }
}
