package com.baidu.android.pushservice.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public DataOutputStream b;

    public e(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new DataOutputStream(outputStream);
        this.a = new byte[8];
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.close();
        }
    }

    public final void a(int i) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            byte[] bArr = this.a;
            bArr[1] = (byte) (i >> 8);
            bArr[0] = (byte) i;
            this.b.write(bArr, 0, 2);
        }
    }

    public final void a(long j) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            byte[] bArr = this.a;
            bArr[7] = (byte) (j >> 56);
            bArr[6] = (byte) (j >> 48);
            bArr[5] = (byte) (j >> 40);
            bArr[4] = (byte) (j >> 32);
            bArr[3] = (byte) (j >> 24);
            bArr[2] = (byte) (j >> 16);
            bArr[1] = (byte) (j >> 8);
            bArr[0] = (byte) j;
            this.b.write(bArr, 0, 8);
        }
    }

    public void a(byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            this.b.write(bArr);
        }
    }

    public final void b(int i) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            byte[] bArr = this.a;
            bArr[3] = (byte) (i >> 24);
            bArr[2] = (byte) (i >> 16);
            bArr[1] = (byte) (i >> 8);
            bArr[0] = (byte) i;
            this.b.write(bArr, 0, 4);
        }
    }
}
