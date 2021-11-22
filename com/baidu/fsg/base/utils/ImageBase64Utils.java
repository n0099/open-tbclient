package com.baidu.fsg.base.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class ImageBase64Utils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38401a = "ImageBase64Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f38402b = 70;

    /* renamed from: c  reason: collision with root package name */
    public static ImageBase64Utils f38403c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageBase64Listener f38404a;

        /* renamed from: b  reason: collision with root package name */
        public String f38405b;

        /* renamed from: c  reason: collision with root package name */
        public int f38406c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImageBase64Utils f38407d;

        public ImageBase64AsyncTask(ImageBase64Utils imageBase64Utils, ImageBase64Listener imageBase64Listener, String str, int i2) {
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
            this.f38407d = imageBase64Utils;
            this.f38404a = imageBase64Listener;
            this.f38405b = str;
            this.f38406c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? ImageBase64Utils.b(this.f38405b, this.f38406c) : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onPostExecute(str);
                ImageBase64Listener imageBase64Listener = this.f38404a;
                if (imageBase64Listener != null) {
                    imageBase64Listener.onBase64Result(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1443832155, "Lcom/baidu/fsg/base/utils/ImageBase64Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1443832155, "Lcom/baidu/fsg/base/utils/ImageBase64Utils;");
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("original size\t ");
                    sb.append(file.length() / 1000);
                    sb.append("\twidth");
                    sb.append(options.outWidth);
                    sb.append("\theight");
                    sb.append(options.outHeight);
                    LogUtil.d("ImageBase64Utils", sb.toString());
                    int computeSampleSize = ImageCompressor.computeSampleSize(options, i2, -1);
                    options.inSampleSize = computeSampleSize;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, f38402b, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("compress size:\t");
                    sb2.append(byteArray.length);
                    sb2.append("\tsampleSize");
                    sb2.append(computeSampleSize);
                    sb2.append("\twidth");
                    sb2.append(decodeFile.getWidth());
                    LogUtil.d("ImageBase64Utils", sb2.toString());
                    decodeFile.recycle();
                    byteArrayOutputStream.close();
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("base64 size:\t");
                    sb3.append(byteArray.length / 1024);
                    LogUtil.d("ImageBase64Utils", sb3.toString());
                    return new String(encode);
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static Bitmap getBase64Bitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] decode = Base64Utils.decode(str);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getImageBase64(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, bitmap, i2)) == null) {
            if (bitmap == null) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    StringBuilder sb = new StringBuilder();
                    sb.append("compress size:\t");
                    sb.append(byteArray.length);
                    sb.append("\timagesize");
                    sb.append(byteArray.length);
                    sb.append("\twidth");
                    sb.append(bitmap.getWidth());
                    LogUtil.d("ImageBase64Utils", sb.toString());
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("base64 size:\t");
                    sb2.append(byteArray.length / 1024);
                    LogUtil.d("ImageBase64Utils", sb2.toString());
                    String str = new String(encode);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return "";
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static ImageBase64Utils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f38403c == null) {
                f38403c = new ImageBase64Utils();
            }
            return f38403c;
        }
        return (ImageBase64Utils) invokeV.objValue;
    }

    public void getImgageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, imageBase64Listener) == null) {
            new ImageBase64AsyncTask(this, imageBase64Listener, str, i2).execute("");
        }
    }
}
