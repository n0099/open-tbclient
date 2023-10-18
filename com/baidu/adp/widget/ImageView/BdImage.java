package com.baidu.adp.widget.ImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class BdImage {
    public static /* synthetic */ Interceptable $ic;
    public static final Object lockForSyncImageDecoder;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean drawingNow;
    public Bitmap image;
    public volatile boolean isGif;
    public boolean isNinePatchBitmap;
    public byte[] mByteData;
    public n6 mGif;
    public boolean mIsEmotionGif;
    public Rect mPadding;
    public boolean mRecyclable;
    public int mRequestHeight;
    public int mRequestWidth;
    public boolean needCache;
    public NinePatch ninePatch;
    public long timeStamp;
    public String url;

    /* loaded from: classes.dex */
    public class a extends BitmapDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdImage a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdImage bdImage, Bitmap bitmap) {
            super(bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImage, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Bitmap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdImage;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.a.image != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.a.image, (Rect) null, getBounds(), getPaint());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681548396, "Lcom/baidu/adp/widget/ImageView/BdImage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681548396, "Lcom/baidu/adp/widget/ImageView/BdImage;");
                return;
            }
        }
        lockForSyncImageDecoder = new Object();
    }

    private void checkIsNinePatchBitmap() {
        Bitmap bitmap;
        byte[] ninePatchChunk;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && (bitmap = this.image) != null && (ninePatchChunk = bitmap.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.isNinePatchBitmap = true;
            this.ninePatch = new NinePatch(this.image, ninePatchChunk, "image");
        }
    }

    public BitmapShader createBitmapShader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap bitmap = this.image;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mRecyclable = false;
                Bitmap bitmap2 = this.image;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                return new BitmapShader(bitmap2, tileMode, tileMode);
            }
            return null;
        }
        return (BitmapShader) invokeV.objValue;
    }

    public BitmapDrawable getAsBitmapDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.image == null) {
                return null;
            }
            this.mRecyclable = false;
            return new a(this, this.image);
        }
        return (BitmapDrawable) invokeV.objValue;
    }

    public byte[] getByteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mByteData;
        }
        return (byte[]) invokeV.objValue;
    }

    public n6 getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mGif;
        }
        return (n6) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Bitmap bitmap = this.image;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        return invokeV.intValue;
    }

    public Rect getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mPadding;
        }
        return (Rect) invokeV.objValue;
    }

    public Bitmap getRawBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.mRecyclable = false;
            return this.image;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Bitmap bitmap = this.image;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        return invokeV.intValue;
    }

    public boolean isEmotionGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mIsEmotionGif;
        }
        return invokeV.booleanValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.isGif;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.needCache;
        }
        return invokeV.booleanValue;
    }

    public boolean isNinePatchBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.isNinePatchBitmap;
        }
        return invokeV.booleanValue;
    }

    public boolean isValidNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Bitmap bitmap = this.image;
            if (bitmap != null && !bitmap.isRecycled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Bitmap bitmap = this.image;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight() * this.image.getRowBytes();
        }
        return invokeV.intValue;
    }

    public BdImage(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.image = bitmap;
    }

    public BdImage(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.image = bitmap;
        this.isGif = z;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, rect};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mPadding = rect;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, bArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mByteData = bArr;
        checkIsNinePatchBitmap();
    }

    public BdImage(n6 n6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n6Var};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.mGif = n6Var;
        this.mIsEmotionGif = true;
    }

    public BdImage(n6 n6Var, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n6Var, bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.mGif = n6Var;
        this.image = bitmap;
        this.isGif = z;
    }

    public BdImage(n6 n6Var, Bitmap bitmap, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n6Var, bitmap, Boolean.valueOf(z), bArr};
            interceptable.invokeUnInit(65544, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.mGif = n6Var;
        this.image = bitmap;
        this.isGif = z;
        this.mByteData = bArr;
    }

    public void changeDrawing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.drawingNow.set(z);
        }
    }

    public void drawImageTo(ImageView imageView) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, imageView) != null) || imageView == null || (bitmap = this.image) == null) {
            return;
        }
        this.mRecyclable = false;
        imageView.setImageBitmap(bitmap);
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.needCache = z;
        }
    }

    public void setPadding(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rect) == null) {
            this.mPadding = rect;
        }
    }

    public void setRequestHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mRequestHeight = i;
        }
    }

    public void setRequestWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mRequestWidth = i;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.url = str;
        }
    }

    public void drawImageTo(Canvas canvas, float f, float f2, Paint paint) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), paint}) != null) || this.image == null) {
            return;
        }
        this.drawingNow.set(true);
        canvas.drawBitmap(this.image, f, f2, paint);
        this.drawingNow.set(false);
    }

    public void drawImageTo(Canvas canvas, Matrix matrix, Paint paint) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, canvas, matrix, paint) == null) && (bitmap = this.image) != null && !bitmap.isRecycled()) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, matrix, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(Canvas canvas, Rect rect, Rect rect2, Paint paint) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048580, this, canvas, rect, rect2, paint) != null) || this.image == null) {
            return;
        }
        this.drawingNow.set(true);
        canvas.drawBitmap(this.image, rect, rect2, paint);
        this.drawingNow.set(false);
    }

    public void drawImageTo(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048581, this, canvas, rect, rectF, paint) != null) || this.image == null) {
            return;
        }
        this.drawingNow.set(true);
        canvas.drawBitmap(this.image, rect, rectF, paint);
        this.drawingNow.set(false);
    }

    public void drawNinePatchImage(Canvas canvas, RectF rectF) {
        NinePatch ninePatch;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, canvas, rectF) == null) && this.isNinePatchBitmap && (ninePatch = this.ninePatch) != null) {
            ninePatch.draw(canvas, rectF);
        }
    }

    public byte[] getImageByte() {
        InterceptResult invokeV;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.image == null) {
                return null;
            }
            synchronized (lockForSyncImageDecoder) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean recycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (!this.mRecyclable || this.drawingNow.get()) {
                return false;
            }
            Bitmap bitmap = this.image;
            if (bitmap != null) {
                this.image = null;
                bitmap.recycle();
            }
            n6 n6Var = this.mGif;
            if (n6Var != null) {
                this.mGif = null;
                n6Var.close();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
