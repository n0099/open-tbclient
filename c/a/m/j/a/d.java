package c.a.m.j.a;

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
    public byte[] f3792d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3793e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3794f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3794f = null;
        int i3 = this.f3802b;
        this.f3793e = new byte[i3];
        this.f3792d = new byte[i3];
    }

    @Override // c.a.m.j.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bArr, bArr2}) == null) {
            if (bArr == null || bArr2 == null || bArr2.length != this.f3802b) {
                throw new InvalidKeyException("Internal error");
            }
            this.f3803c = bArr2;
            f();
            this.a.f(z, str, bArr);
        }
    }

    @Override // c.a.m.j.a.f
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i5 = i2 + i;
            byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.f3802b) ? null : (byte[]) bArr.clone();
            while (i < i5) {
                this.a.g(bArr, i, this.f3793e, 0);
                int i6 = 0;
                while (true) {
                    i4 = this.f3802b;
                    if (i6 >= i4) {
                        break;
                    }
                    bArr2[i6 + i3] = (byte) (this.f3793e[i6] ^ this.f3792d[i6]);
                    i6++;
                }
                byte[] bArr4 = this.f3792d;
                if (bArr3 == null) {
                    System.arraycopy(bArr, i, bArr4, 0, i4);
                } else {
                    System.arraycopy(bArr3, i, bArr4, 0, i4);
                }
                int i7 = this.f3802b;
                i += i7;
                i3 += i7;
            }
        }
    }

    @Override // c.a.m.j.a.f
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i4 = i2 + i;
            while (i < i4) {
                for (int i5 = 0; i5 < this.f3802b; i5++) {
                    this.f3793e[i5] = (byte) (bArr[i5 + i] ^ this.f3792d[i5]);
                }
                this.a.i(this.f3793e, 0, bArr2, i3);
                System.arraycopy(bArr2, i3, this.f3792d, 0, this.f3802b);
                int i6 = this.f3802b;
                i += i6;
                i3 += i6;
            }
        }
    }

    @Override // c.a.m.j.a.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            System.arraycopy(this.f3803c, 0, this.f3792d, 0, this.f3802b);
        }
    }

    @Override // c.a.m.j.a.f
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            System.arraycopy(this.f3794f, 0, this.f3792d, 0, this.f3802b);
        }
    }

    @Override // c.a.m.j.a.f
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f3794f == null) {
                this.f3794f = new byte[this.f3802b];
            }
            System.arraycopy(this.f3792d, 0, this.f3794f, 0, this.f3802b);
        }
    }
}
