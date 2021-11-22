package b.a.p0.a.k0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f6865a;

    /* renamed from: b  reason: collision with root package name */
    public int f6866b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.p0.q.k.i.t.b f6867c;

    /* renamed from: d  reason: collision with root package name */
    public long f6868d;

    public a(@NonNull String str, @NonNull b.a.p0.q.k.i.t.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6866b = 0;
        this.f6868d = 0L;
        this.f6865a = str;
        this.f6867c = bVar;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 > this.f6867c.f11942b) {
                return false;
            }
            boolean e2 = e();
            if (!e2) {
                this.f6866b++;
            }
            return !e2;
        }
        return invokeI.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f6868d >= this.f6867c.f11943c) {
                this.f6868d = currentTimeMillis;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6865a : (String) invokeV.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(str, this.f6865a) : invokeL.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6866b >= this.f6867c.f11941a : invokeV.booleanValue;
    }
}
