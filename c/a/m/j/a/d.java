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
    public byte[] f4467d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4468e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f4469f;

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
        this.f4469f = null;
        int i4 = this.f4478b;
        this.f4468e = new byte[i4];
        this.f4467d = new byte[i4];
    }

    @Override // c.a.m.j.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bArr, bArr2}) == null) {
            if (bArr == null || bArr2 == null || bArr2.length != this.f4478b) {
                throw new InvalidKeyException("Internal error");
            }
            this.f4479c = bArr2;
            f();
            this.a.f(z, str, bArr);
        }
    }

    @Override // c.a.m.j.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i6 = i3 + i2;
            byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f4478b) ? null : (byte[]) bArr.clone();
            while (i2 < i6) {
                this.a.g(bArr, i2, this.f4468e, 0);
                int i7 = 0;
                while (true) {
                    i5 = this.f4478b;
                    if (i7 >= i5) {
                        break;
                    }
                    bArr2[i7 + i4] = (byte) (this.f4468e[i7] ^ this.f4467d[i7]);
                    i7++;
                }
                byte[] bArr4 = this.f4467d;
                if (bArr3 == null) {
                    System.arraycopy(bArr, i2, bArr4, 0, i5);
                } else {
                    System.arraycopy(bArr3, i2, bArr4, 0, i5);
                }
                int i8 = this.f4478b;
                i2 += i8;
                i4 += i8;
            }
        }
    }

    @Override // c.a.m.j.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i5 = i3 + i2;
            while (i2 < i5) {
                for (int i6 = 0; i6 < this.f4478b; i6++) {
                    this.f4468e[i6] = (byte) (bArr[i6 + i2] ^ this.f4467d[i6]);
                }
                this.a.i(this.f4468e, 0, bArr2, i4);
                System.arraycopy(bArr2, i4, this.f4467d, 0, this.f4478b);
                int i7 = this.f4478b;
                i2 += i7;
                i4 += i7;
            }
        }
    }

    @Override // c.a.m.j.a.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            System.arraycopy(this.f4479c, 0, this.f4467d, 0, this.f4478b);
        }
    }

    @Override // c.a.m.j.a.f
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            System.arraycopy(this.f4469f, 0, this.f4467d, 0, this.f4478b);
        }
    }

    @Override // c.a.m.j.a.f
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f4469f == null) {
                this.f4469f = new byte[this.f4478b];
            }
            System.arraycopy(this.f4467d, 0, this.f4469f, 0, this.f4478b);
        }
    }
}
