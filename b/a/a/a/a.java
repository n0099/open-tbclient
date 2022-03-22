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
    public volatile int f978b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f979c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f980d;

    /* renamed from: e  reason: collision with root package name */
    public int f981e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(4194304);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                this.f978b = 0;
                this.f979c = 0;
                this.f980d = 0;
            }
        }
    }

    public synchronized boolean b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i && i <= this.f978b) {
                        if (this.f979c + i <= this.f981e) {
                            System.arraycopy(this.a, this.f979c, bArr, 0, i);
                            this.f979c += i;
                            this.f978b -= i;
                            return true;
                        }
                        System.arraycopy(this.a, this.f979c, bArr, 0, this.f981e - this.f979c);
                        System.arraycopy(this.a, 0, bArr, this.f981e - this.f979c, (this.f979c + i) - this.f981e);
                        this.f979c = (i - this.f981e) + this.f979c;
                        this.f978b -= i;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public synchronized boolean c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i && this.f978b + i <= this.f981e) {
                        if (this.f980d + i <= this.f981e) {
                            System.arraycopy(bArr, 0, this.a, this.f980d, i);
                            this.f980d += i;
                            this.f978b += i;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.a, this.f980d, this.f981e - this.f980d);
                        System.arraycopy(bArr, this.f981e - this.f980d, this.a, 0, (this.f980d + i) - this.f981e);
                        this.f980d = (i - this.f981e) + this.f980d;
                        this.f978b += i;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f978b = 0;
        this.f979c = 0;
        this.f980d = 0;
        this.f981e = 0;
        this.f981e = i;
        this.a = new byte[i];
    }
}
