package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
/* loaded from: classes9.dex */
public class ImageProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ImageProcessor";

    /* renamed from: b  reason: collision with root package name */
    public static final int f33395b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f33396c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1533491707, "Lcom/baidu/apollon/imagemanager/ImageProcessor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1533491707, "Lcom/baidu/apollon/imagemanager/ImageProcessor;");
        }
    }

    public ImageProcessor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33396c = ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, options, i2, i3)) == null) {
            int b2 = b(options, i2, i3);
            String str = a;
            LogUtil.d(str, "initialSize = " + b2);
            if (b2 <= 8) {
                int i4 = 1;
                while (i4 < b2) {
                    i4 <<= 1;
                }
                return i4;
            }
            return ((b2 + 7) / 8) * 8;
        }
        return invokeLII.intValue;
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, options, i2, i3)) == null) {
            double d2 = options.outWidth;
            double d3 = options.outHeight;
            int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
            if (i2 == -1) {
                min = 128;
            } else {
                double d4 = i2;
                min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
            }
            if (min < ceil) {
                return ceil;
            }
            if (i3 == -1 && i2 == -1) {
                return 1;
            }
            return i2 == -1 ? ceil : min;
        }
        return invokeLII.intValue;
    }

    public Bitmap decode(File file, int i2) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, i2)) == null) {
            if (file != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getPath(), options);
                    if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                        options.inSampleSize = a(options, -1, this.f33396c);
                        options.inJustDecodeBounds = false;
                        options.inDensity = i2;
                        options.inDither = false;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeFile(file.getPath(), options);
                    }
                } catch (OutOfMemoryError unused) {
                }
                return null;
            }
            throw new FileNotFoundException("The file is null");
        }
        return (Bitmap) invokeLI.objValue;
    }

    public Bitmap a(FileDescriptor fileDescriptor, int i2) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, fileDescriptor, i2)) == null) {
            if (fileDescriptor != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                        options.inSampleSize = a(options, -1, this.f33396c);
                        options.inJustDecodeBounds = false;
                        options.inDensity = i2;
                        options.inDither = false;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    }
                } catch (OutOfMemoryError unused) {
                }
                return null;
            }
            throw new FileNotFoundException("The file is null");
        }
        return (Bitmap) invokeLI.objValue;
    }
}
