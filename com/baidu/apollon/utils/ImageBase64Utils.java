package com.baidu.apollon.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes.dex */
public class ImageBase64Utils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f4067a = "ImageBase64Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f4068b = 70;

    /* renamed from: c  reason: collision with root package name */
    public static ImageBase64Utils f4069c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageBase64Utils f4070a;

        /* renamed from: b  reason: collision with root package name */
        public ImageBase64Listener f4071b;

        /* renamed from: c  reason: collision with root package name */
        public String f4072c;

        /* renamed from: d  reason: collision with root package name */
        public int f4073d;

        public a(ImageBase64Utils imageBase64Utils, ImageBase64Listener imageBase64Listener, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageBase64Utils, imageBase64Listener, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4070a = imageBase64Utils;
            this.f4071b = imageBase64Listener;
            this.f4072c = str;
            this.f4073d = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? ImageBase64Utils.b(this.f4072c, this.f4073d) : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onPostExecute(str);
                ImageBase64Listener imageBase64Listener = this.f4071b;
                if (imageBase64Listener != null) {
                    imageBase64Listener.onBase64Result(str);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-401015432, "Lcom/baidu/apollon/utils/ImageBase64Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-401015432, "Lcom/baidu/apollon/utils/ImageBase64Utils;");
        }
    }

    public ImageBase64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    LogUtil.d("ImageBase64Utils", "original size\t " + (file.length() / 1000) + "\twidth" + options.outWidth + "\theight" + options.outHeight);
                    int a2 = ImageProcessor.a(options, i2, -1);
                    options.inSampleSize = a2;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, f4068b, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\tsampleSize" + a2 + "\twidth" + decodeFile.getWidth());
                    decodeFile.recycle();
                    byteArrayOutputStream.close();
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("base64 size:\t");
                    sb.append(byteArray.length / 1024);
                    LogUtil.d("ImageBase64Utils", sb.toString());
                    return new String(encode);
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static ImageBase64Utils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4069c == null) {
                f4069c = new ImageBase64Utils();
            }
            return f4069c;
        }
        return (ImageBase64Utils) invokeV.objValue;
    }

    public void getImgageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, imageBase64Listener) == null) {
            new a(this, imageBase64Listener, str, i2).execute("");
        }
    }
}
