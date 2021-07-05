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
    public byte[] f1002a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1003b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1004c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1005d;

    /* renamed from: e  reason: collision with root package name */
    public int f1006e;

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
        this.f1002a = null;
        this.f1003b = 0;
        this.f1004c = 0;
        this.f1005d = 0;
        this.f1006e = 0;
        this.f1006e = i2;
        this.f1002a = new byte[i2];
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f1003b = 0;
                this.f1004c = 0;
                this.f1005d = 0;
            }
        }
    }

    public boolean a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && i2 <= this.f1003b) {
                        if (this.f1004c + i2 <= this.f1006e) {
                            System.arraycopy(this.f1002a, this.f1004c, bArr, 0, i2);
                            this.f1004c += i2;
                            this.f1003b -= i2;
                            return true;
                        }
                        System.arraycopy(this.f1002a, this.f1004c, bArr, 0, this.f1006e - this.f1004c);
                        System.arraycopy(this.f1002a, 0, bArr, this.f1006e - this.f1004c, (this.f1004c + i2) - this.f1006e);
                        this.f1004c = (i2 - this.f1006e) + this.f1004c;
                        this.f1003b -= i2;
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
                    if (bArr.length >= i2 && this.f1003b + i2 <= this.f1006e) {
                        if (this.f1005d + i2 <= this.f1006e) {
                            System.arraycopy(bArr, 0, this.f1002a, this.f1005d, i2);
                            this.f1005d += i2;
                            this.f1003b += i2;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.f1002a, this.f1005d, this.f1006e - this.f1005d);
                        System.arraycopy(bArr, this.f1006e - this.f1005d, this.f1002a, 0, (this.f1005d + i2) - this.f1006e);
                        this.f1005d = (i2 - this.f1006e) + this.f1005d;
                        this.f1003b += i2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }
}
