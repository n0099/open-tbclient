package c.a.d.a.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f1945a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f1946b;

    /* renamed from: c  reason: collision with root package name */
    public int f1947c;

    public g() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i2 = c.f1938d;
        this.f1945a = i2;
        this.f1946b = new byte[i2];
    }

    public f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new f(Arrays.copyOf(this.f1946b, this.f1947c)) : (f) invokeV.objValue;
    }

    public g b(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) {
            c(this.f1947c + 1);
            byte[] bArr = this.f1946b;
            int i2 = this.f1947c;
            this.f1947c = i2 + 1;
            bArr[i2] = b2;
            return this;
        }
        return (g) invokeB.objValue;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            byte[] bArr = this.f1946b;
            if (i2 - bArr.length > 0) {
                int length = bArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f1946b = Arrays.copyOf(this.f1946b, i2);
            }
        }
    }
}
