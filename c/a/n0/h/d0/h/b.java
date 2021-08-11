package c.a.n0.h.d0.h;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f10882a;

    /* renamed from: b  reason: collision with root package name */
    public long f10883b;

    /* renamed from: c  reason: collision with root package name */
    public long f10884c;

    public b(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10882a = j2;
        this.f10883b = j3;
        this.f10884c = j4;
    }

    @NonNull
    public static b b(long j2, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3)})) == null) ? new b(j2, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d)) : (b) invokeCommon.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c()) {
                a aVar = new a();
                aVar.f10880a = Math.max(this.f10882a - this.f10883b, 0L);
                aVar.f10881b = this.f10882a + this.f10884c;
                return aVar;
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.f10882a;
            if (j2 >= 0) {
                long j3 = this.f10883b;
                if (j3 >= 0) {
                    long j4 = this.f10884c;
                    if (j4 >= 0 && j3 + j4 > 0 && j2 + j4 > 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "[ mBaseline = " + this.f10882a + "; mLeftOffset = " + this.f10883b + "; mRightOffset = " + this.f10884c + " ]";
        }
        return (String) invokeV.objValue;
    }
}
