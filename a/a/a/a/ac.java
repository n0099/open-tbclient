package a.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1003a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1004b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1005c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1006d;

    /* renamed from: e  reason: collision with root package name */
    public int f1007e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ac() {
        this(4194304);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ac(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1003a = null;
        this.f1004b = 0;
        this.f1005c = 0;
        this.f1006d = 0;
        this.f1007e = 0;
        this.f1007e = i2;
        this.f1003a = new byte[i2];
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f1004b = 0;
                this.f1005c = 0;
                this.f1006d = 0;
            }
        }
    }

    public boolean a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && i2 <= this.f1004b) {
                        if (this.f1005c + i2 <= this.f1007e) {
                            System.arraycopy(this.f1003a, this.f1005c, bArr, 0, i2);
                            this.f1005c += i2;
                            this.f1004b -= i2;
                            return true;
                        }
                        System.arraycopy(this.f1003a, this.f1005c, bArr, 0, this.f1007e - this.f1005c);
                        System.arraycopy(this.f1003a, 0, bArr, this.f1007e - this.f1005c, (this.f1005c + i2) - this.f1007e);
                        this.f1005c = (i2 - this.f1007e) + this.f1005c;
                        this.f1004b -= i2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && this.f1004b + i2 <= this.f1007e) {
                        if (this.f1006d + i2 <= this.f1007e) {
                            System.arraycopy(bArr, 0, this.f1003a, this.f1006d, i2);
                            this.f1006d += i2;
                            this.f1004b += i2;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.f1003a, this.f1006d, this.f1007e - this.f1006d);
                        System.arraycopy(bArr, this.f1007e - this.f1006d, this.f1003a, 0, (this.f1006d + i2) - this.f1007e);
                        this.f1006d = (i2 - this.f1007e) + this.f1006d;
                        this.f1004b += i2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }
}
