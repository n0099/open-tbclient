package com.baidu.mobads.cid.cesium.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
/* loaded from: classes7.dex */
public class d extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f41444a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f41445e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f41446f;

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
        this.f41446f = null;
        int i4 = this.f41457c;
        this.f41445e = new byte[i4];
        this.f41444a = new byte[i4];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            System.arraycopy(this.f41458d, 0, this.f41444a, 0, this.f41457c);
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bArr, bArr2}) == null) {
            if (bArr == null || bArr2 == null || bArr2.length != this.f41457c) {
                throw new InvalidKeyException("Internal error");
            }
            this.f41458d = bArr2;
            a();
            this.f41456b.a(z, str, bArr);
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i5 = i3 + i2;
            while (i2 < i5) {
                for (int i6 = 0; i6 < this.f41457c; i6++) {
                    this.f41445e[i6] = (byte) (bArr[i6 + i2] ^ this.f41444a[i6]);
                }
                this.f41456b.a(this.f41445e, 0, bArr2, i4);
                System.arraycopy(bArr2, i4, this.f41444a, 0, this.f41457c);
                int i7 = this.f41457c;
                i2 += i7;
                i4 += i7;
            }
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f41446f == null) {
                this.f41446f = new byte[this.f41457c];
            }
            System.arraycopy(this.f41444a, 0, this.f41446f, 0, this.f41457c);
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i6 = i3 + i2;
            byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f41457c) ? null : (byte[]) bArr.clone();
            while (i2 < i6) {
                this.f41456b.b(bArr, i2, this.f41445e, 0);
                int i7 = 0;
                while (true) {
                    i5 = this.f41457c;
                    if (i7 >= i5) {
                        break;
                    }
                    bArr2[i7 + i4] = (byte) (this.f41445e[i7] ^ this.f41444a[i7]);
                    i7++;
                }
                byte[] bArr4 = this.f41444a;
                if (bArr3 == null) {
                    System.arraycopy(bArr, i2, bArr4, 0, i5);
                } else {
                    System.arraycopy(bArr3, i2, bArr4, 0, i5);
                }
                int i8 = this.f41457c;
                i2 += i8;
                i4 += i8;
            }
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            System.arraycopy(this.f41446f, 0, this.f41444a, 0, this.f41457c);
        }
    }
}
