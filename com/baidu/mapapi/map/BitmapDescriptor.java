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
/* loaded from: classes5.dex */
public final class BitmapDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f41166a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f41167b;

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
            this.f41166a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
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
            ByteBuffer allocate = ByteBuffer.allocate(this.f41166a.getWidth() * this.f41166a.getHeight() * 4);
            this.f41166a.copyPixelsToBuffer(allocate);
            return allocate.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f41166a != null) {
                if (this.f41167b == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("image_width", this.f41166a.getWidth());
                    bundle.putInt("image_height", this.f41166a.getHeight());
                    byte[] a2 = a();
                    bundle.putByteArray("image_data", a2);
                    MessageDigest messageDigest = null;
                    try {
                        messageDigest = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                    if (messageDigest != null) {
                        messageDigest.update(a2, 0, a2.length);
                        byte[] digest = messageDigest.digest();
                        StringBuilder sb = new StringBuilder("");
                        for (byte b2 : digest) {
                            sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                        }
                        bundle.putString("image_hashcode", sb.toString());
                    }
                    this.f41167b = bundle;
                }
                return this.f41167b;
            }
            throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
        }
        return (Bundle) invokeV.objValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41166a : (Bitmap) invokeV.objValue;
    }

    public void recycle() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bitmap = this.f41166a) == null || bitmap.isRecycled()) {
            return;
        }
        this.f41166a.recycle();
        this.f41166a = null;
    }
}
