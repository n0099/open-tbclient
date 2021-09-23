package c.a.m.d.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public class d extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3979d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3980e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3981f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3981f = null;
        int i4 = this.f3992b;
        this.f3980e = new byte[i4];
        this.f3979d = new byte[i4];
    }

    @Override // c.a.m.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bArr, bArr2}) == null) {
            if (bArr == null || bArr2 == null || bArr2.length != this.f3992b) {
                throw new InvalidKeyException("Internal error");
            }
            this.f3993c = bArr2;
            c();
            this.f3991a.e(z, str, bArr);
        }
    }

    @Override // c.a.m.d.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i5 = i3 + i2;
            while (i2 < i5) {
                for (int i6 = 0; i6 < this.f3992b; i6++) {
                    this.f3980e[i6] = (byte) (bArr[i6 + i2] ^ this.f3979d[i6]);
                }
                this.f3991a.f(this.f3980e, 0, bArr2, i4);
                System.arraycopy(bArr2, i4, this.f3979d, 0, this.f3992b);
                int i7 = this.f3992b;
                i2 += i7;
                i4 += i7;
            }
        }
    }

    @Override // c.a.m.d.a.f
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            System.arraycopy(this.f3993c, 0, this.f3979d, 0, this.f3992b);
        }
    }

    @Override // c.a.m.d.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i6 = i3 + i2;
            byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f3992b) ? null : (byte[]) bArr.clone();
            while (i2 < i6) {
                this.f3991a.j(bArr, i2, this.f3980e, 0);
                int i7 = 0;
                while (true) {
                    i5 = this.f3992b;
                    if (i7 >= i5) {
                        break;
                    }
                    bArr2[i7 + i4] = (byte) (this.f3980e[i7] ^ this.f3979d[i7]);
                    i7++;
                }
                byte[] bArr4 = this.f3979d;
                if (bArr3 == null) {
                    System.arraycopy(bArr, i2, bArr4, 0, i5);
                } else {
                    System.arraycopy(bArr3, i2, bArr4, 0, i5);
                }
                int i8 = this.f3992b;
                i2 += i8;
                i4 += i8;
            }
        }
    }

    @Override // c.a.m.d.a.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f3981f == null) {
                this.f3981f = new byte[this.f3992b];
            }
            System.arraycopy(this.f3979d, 0, this.f3981f, 0, this.f3992b);
        }
    }

    @Override // c.a.m.d.a.f
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            System.arraycopy(this.f3981f, 0, this.f3979d, 0, this.f3992b);
        }
    }
}
