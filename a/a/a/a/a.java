package a.a.a.a;

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
    public byte[] f1006a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1007b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1008c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1009d;

    /* renamed from: e  reason: collision with root package name */
    public int f1010e;

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
                this.f1007b = 0;
                this.f1008c = 0;
                this.f1009d = 0;
            }
        }
    }

    public synchronized boolean b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i2 && i2 <= this.f1007b) {
                        if (this.f1008c + i2 <= this.f1010e) {
                            System.arraycopy(this.f1006a, this.f1008c, bArr, 0, i2);
                            this.f1008c += i2;
                            this.f1007b -= i2;
                            return true;
                        }
                        System.arraycopy(this.f1006a, this.f1008c, bArr, 0, this.f1010e - this.f1008c);
                        System.arraycopy(this.f1006a, 0, bArr, this.f1010e - this.f1008c, (this.f1008c + i2) - this.f1010e);
                        this.f1008c = (i2 - this.f1010e) + this.f1008c;
                        this.f1007b -= i2;
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
                    if (bArr.length >= i2 && this.f1007b + i2 <= this.f1010e) {
                        if (this.f1009d + i2 <= this.f1010e) {
                            System.arraycopy(bArr, 0, this.f1006a, this.f1009d, i2);
                            this.f1009d += i2;
                            this.f1007b += i2;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.f1006a, this.f1009d, this.f1010e - this.f1009d);
                        System.arraycopy(bArr, this.f1010e - this.f1009d, this.f1006a, 0, (this.f1009d + i2) - this.f1010e);
                        this.f1009d = (i2 - this.f1010e) + this.f1009d;
                        this.f1007b += i2;
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
        this.f1006a = null;
        this.f1007b = 0;
        this.f1008c = 0;
        this.f1009d = 0;
        this.f1010e = 0;
        this.f1010e = i2;
        this.f1006a = new byte[i2];
    }
}
