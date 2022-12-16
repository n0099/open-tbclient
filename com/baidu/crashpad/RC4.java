package com.baidu.crashpad;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RC4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGTAG = "RC4 CRASHPAD";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.workingKey = str.getBytes();
    }

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i4 = i + i2;
            if (i4 > bArr.length) {
                Log.e(LOGTAG, "input buffer too short, buffer length=" + bArr.length + ", input length=" + i4);
            } else if (i3 + i2 > bArr2.length) {
                Log.e(LOGTAG, "output buffer too short, buffer length=" + bArr.length + ", output length=" + i4);
            } else {
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = (this.x + 1) & 255;
                    this.x = i6;
                    byte[] bArr3 = this.engineState;
                    int i7 = (bArr3[i6] + this.y) & 255;
                    this.y = i7;
                    byte b = bArr3[i6];
                    bArr3[i6] = bArr3[i7];
                    bArr3[i7] = b;
                    bArr2[i5 + i3] = (byte) (bArr3[(bArr3[i6] + bArr3[i7]) & 255] ^ bArr[i5 + i]);
                }
            }
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
            for (int i = 0; i < 256; i++) {
                this.engineState[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                byte[] bArr2 = this.engineState;
                i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
                byte b = bArr2[i4];
                bArr2[i4] = bArr2[i3];
                bArr2[i3] = b;
                i2 = (i2 + 1) % bArr.length;
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
