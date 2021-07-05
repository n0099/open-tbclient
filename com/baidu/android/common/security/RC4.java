package com.baidu.android.common.security;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RC4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_LENGTH = 256;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] engineState;
    public byte[] workingKey;
    public int x;
    public int y;

    public RC4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.engineState = null;
        this.x = 0;
        this.y = 0;
        this.workingKey = null;
        this.workingKey = str.getBytes();
    }

    private void processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            if (i2 + i3 <= bArr.length) {
                if (i4 + i3 > bArr2.length) {
                    throw new RuntimeException("output buffer too short");
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = (this.x + 1) & 255;
                    this.x = i6;
                    byte[] bArr3 = this.engineState;
                    int i7 = (bArr3[i6] + this.y) & 255;
                    this.y = i7;
                    byte b2 = bArr3[i6];
                    bArr3[i6] = bArr3[i7];
                    bArr3[i7] = b2;
                    bArr2[i5 + i4] = (byte) (bArr3[(bArr3[i6] + bArr3[i7]) & 255] ^ bArr[i5 + i2]);
                }
                return;
            }
            throw new RuntimeException("input buffer too short");
        }
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setKey(this.workingKey);
        }
    }

    private void setKey(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bArr) == null) {
            this.x = 0;
            this.y = 0;
            if (this.engineState == null) {
                this.engineState = new byte[256];
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.engineState[i2] = (byte) i2;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                byte[] bArr2 = this.engineState;
                i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
                byte b2 = bArr2[i5];
                bArr2[i5] = bArr2[i4];
                bArr2[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
        }
    }

    public byte[] decrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            reset();
            byte[] bArr2 = new byte[bArr.length];
            processBytes(bArr, 0, bArr.length, bArr2, 0);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] encrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            reset();
            byte[] bArr2 = new byte[bArr.length];
            processBytes(bArr, 0, bArr.length, bArr2, 0);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }
}
