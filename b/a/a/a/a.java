package b.a.a.a;

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
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1002b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1003c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1004d;

    /* renamed from: e  reason: collision with root package name */
    public int f1005e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
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

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f1002b = 0;
                this.f1003c = 0;
                this.f1004d = 0;
            }
        }
    }

    public synchronized boolean b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && i2 <= this.f1002b) {
                        if (this.f1003c + i2 <= this.f1005e) {
                            System.arraycopy(this.a, this.f1003c, bArr, 0, i2);
                            this.f1003c += i2;
                            this.f1002b -= i2;
                            return true;
                        }
                        System.arraycopy(this.a, this.f1003c, bArr, 0, this.f1005e - this.f1003c);
                        System.arraycopy(this.a, 0, bArr, this.f1005e - this.f1003c, (this.f1003c + i2) - this.f1005e);
                        this.f1003c = (i2 - this.f1005e) + this.f1003c;
                        this.f1002b -= i2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public synchronized boolean c(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && this.f1002b + i2 <= this.f1005e) {
                        if (this.f1004d + i2 <= this.f1005e) {
                            System.arraycopy(bArr, 0, this.a, this.f1004d, i2);
                            this.f1004d += i2;
                            this.f1002b += i2;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.a, this.f1004d, this.f1005e - this.f1004d);
                        System.arraycopy(bArr, this.f1005e - this.f1004d, this.a, 0, (this.f1004d + i2) - this.f1005e);
                        this.f1004d = (i2 - this.f1005e) + this.f1004d;
                        this.f1002b += i2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public a(int i2) {
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
        this.a = null;
        this.f1002b = 0;
        this.f1003c = 0;
        this.f1004d = 0;
        this.f1005e = 0;
        this.f1005e = i2;
        this.a = new byte[i2];
    }
}
