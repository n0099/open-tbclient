package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class BitmapDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public Bundle b;

    public BitmapDescriptor(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bitmap != null) {
            this.a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, this, bitmap, i, i2)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(this.a.getWidth() * this.a.getHeight() * 4);
            this.a.copyPixelsToBuffer(allocate);
            return allocate.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public void clearCache() {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bundle = this.b) != null) {
            bundle.clear();
            this.b = null;
        }
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void recycle() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bitmap = this.a) != null && !bitmap.isRecycled()) {
            this.a.recycle();
            this.a = null;
        }
    }

    public Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a != null) {
                if (this.b == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("image_width", this.a.getWidth());
                    bundle.putInt("image_height", this.a.getHeight());
                    byte[] a = a();
                    bundle.putByteArray("image_data", a);
                    MessageDigest messageDigest = null;
                    try {
                        messageDigest = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    if (messageDigest != null) {
                        messageDigest.update(a, 0, a.length);
                        byte[] digest = messageDigest.digest();
                        StringBuilder sb = new StringBuilder("");
                        for (byte b : digest) {
                            sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                        }
                        bundle.putString("image_hashcode", sb.toString());
                    }
                    this.b = bundle;
                }
                return this.b;
            }
            throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
        }
        return (Bundle) invokeV.objValue;
    }
}
