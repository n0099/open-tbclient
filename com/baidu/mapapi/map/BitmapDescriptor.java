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
/* loaded from: classes8.dex */
public final class BitmapDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f35781b;

    public BitmapDescriptor(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bitmap != null) {
            this.a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, this, bitmap, i2, i3)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
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

    public Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a != null) {
                if (this.f35781b == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("image_width", this.a.getWidth());
                    bundle.putInt("image_height", this.a.getHeight());
                    byte[] a = a();
                    bundle.putByteArray("image_data", a);
                    MessageDigest messageDigest = null;
                    try {
                        messageDigest = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                    if (messageDigest != null) {
                        messageDigest.update(a, 0, a.length);
                        byte[] digest = messageDigest.digest();
                        StringBuilder sb = new StringBuilder("");
                        for (byte b2 : digest) {
                            sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                        }
                        bundle.putString("image_hashcode", sb.toString());
                    }
                    this.f35781b = bundle;
                }
                return this.f35781b;
            }
            throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
        }
        return (Bundle) invokeV.objValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (Bitmap) invokeV.objValue;
    }

    public void recycle() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bitmap = this.a) == null || bitmap.isRecycled()) {
            return;
        }
        this.a.recycle();
        this.a = null;
    }
}
