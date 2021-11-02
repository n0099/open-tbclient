package com.baidu.pass.main.facesdk.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BDFaceImageInstance {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] data;
    public int height;
    public BDFaceSDKCommon.BDFaceImageType imageType;
    public long index;
    public int width;

    public BDFaceImageInstance(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.index = 0L;
        this.index = j;
    }

    private native int create(byte[] bArr, int i2, int i3, int i4, float f2, int i5);

    private native int createInt(int[] iArr, int i2, int i3, int i4, float f2, int i5);

    public native int destory();

    public native String getBase64();

    public native BDFaceImageInstance getImage();

    public native String getSec(Context context);

    public BDFaceImageInstance(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.index = 0L;
        this.height = i2;
        this.width = i3;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i4];
    }

    public BDFaceImageInstance(byte[] bArr, int i2, int i3, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), bDFaceImageType, Float.valueOf(f2), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.index = 0L;
        if (bArr == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        create(bArr, i2, i3, bDFaceImageType.ordinal(), f2, i4);
    }

    public BDFaceImageInstance(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.index = 0L;
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }
}
