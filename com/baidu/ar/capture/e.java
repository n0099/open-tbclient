package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.face.IFaceResultData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class e implements ICaptureResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] le;
    public byte[] lf;
    public Bitmap lg;
    public Bitmap lh;
    public int li;
    public int lj;
    public IFaceResultData lk;
    public long timestamp;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Bitmap a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, this, bArr, i, i2)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public IFaceResultData getFaceData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lk : (IFaceResultData) invokeV.objValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOriginPhoto() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.lg == null && (bArr = this.le) != null) {
                this.lg = a(bArr, this.li, this.lj);
            }
            return this.lg;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.lh == null && (bArr = this.lf) != null) {
                this.lh = a(bArr, this.li, this.lj);
            }
            return this.lh;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lj : invokeV.intValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.li : invokeV.intValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.timestamp : invokeV.longValue;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Bitmap bitmap = this.lg;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.lg.recycle();
                this.lg = null;
            }
            Bitmap bitmap2 = this.lh;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            this.lh.recycle();
            this.lh = null;
        }
    }
}
