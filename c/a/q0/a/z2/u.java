package c.a.q0.a.z2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase10;
/* loaded from: classes.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.q0.a.z2.g1.e<OutputStream, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap.CompressFormat f9530b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f9531c;

        public a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, compressFormat, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bitmap;
            this.f9530b = compressFormat;
            this.f9531c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.e
        /* renamed from: b */
        public Boolean a(OutputStream outputStream) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream)) == null) {
                Bitmap bitmap = this.a;
                if (bitmap != null) {
                    Bitmap.CompressFormat compressFormat = this.f9530b;
                    if (compressFormat == null) {
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    }
                    if (bitmap.compress(compressFormat, this.f9531c, outputStream)) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639177061, "Lc/a/q0/a/z2/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639177061, "Lc/a/q0/a/z2/u;");
                return;
            }
        }
        a = c.a.q0.a.k.a;
    }

    public static Bitmap a(Bitmap bitmap, long j2, boolean z) {
        InterceptResult invokeCommon;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (bitmap == null || j2 <= 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() <= j2) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                byteArrayOutputStream.reset();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= j2) {
                    byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < i2) {
                        i4 = (i3 + i2) / 2;
                        byteArrayOutputStream.reset();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                        int i5 = (byteArrayOutputStream.size() > j2 ? 1 : (byteArrayOutputStream.size() == j2 ? 0 : -1));
                        if (i5 == 0) {
                            break;
                        } else if (i5 > 0) {
                            i2 = i4 - 1;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    if (i2 == i4 - 1) {
                        byteArrayOutputStream.reset();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                }
            }
            if (z && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static boolean b(File file, File file2, int i2) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, file, file2, i2)) == null) {
            boolean z = a;
            if (file2 == null) {
                boolean z2 = a;
                return false;
            } else if (i2 >= 0 && i2 <= 100) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile == null) {
                    boolean z3 = a;
                    return false;
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException unused) {
                }
                try {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                    c.a.q0.w.d.d(fileOutputStream);
                    return true;
                } catch (FileNotFoundException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    boolean z4 = a;
                    c.a.q0.w.d.d(fileOutputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    c.a.q0.w.d.d(fileOutputStream2);
                    throw th;
                }
            } else {
                boolean z5 = a;
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean c(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i2)) == null) {
            try {
                if (a) {
                    String str3 = "copyJpegExif oldFilePath:" + str + "，newFilePath：" + str2 + ",quality:" + i2;
                }
                ExifInterface i3 = i(str);
                ExifInterface i4 = i(str2);
                if (i3 != null && i4 != null) {
                    Field[] fields = ExifInterface.class.getFields();
                    for (int i5 = 0; i5 < fields.length; i5++) {
                        String name = fields[i5].getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("TAG")) {
                            String obj = fields[i5].get(ExifInterface.class).toString();
                            String attribute = i3.getAttribute(obj);
                            if (a) {
                                String str4 = "fields name:" + obj + "，value：" + attribute;
                            }
                            if (!TextUtils.isEmpty(obj) && !TextUtils.equals("Orientation", obj)) {
                                if (i2 < 100) {
                                    char c2 = 65535;
                                    switch (obj.hashCode()) {
                                        case -2093253645:
                                            if (obj.equals("PixelYDimension")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                        case -1896740140:
                                            if (obj.equals("PixelXDimension")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                        case -666122239:
                                            if (obj.equals("ImageLength")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 542970187:
                                            if (obj.equals("ImageWidth")) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c2 != 0) {
                                        if (c2 != 1) {
                                            if (c2 != 2) {
                                                if (c2 == 3) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (attribute != null) {
                                    i4.setAttribute(obj, attribute);
                                }
                            }
                        }
                    }
                    i4.saveAttributes();
                    return true;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file.getParentFile().exists()) {
                return true;
            }
            return file.getParentFile().mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static Bitmap e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            try {
                return MediaStore.Images.Media.getBitmap(c.a.q0.a.d2.d.J().getContentResolver(), uri);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        ExifInterface i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (i2 = i(str)) == null) {
                return 0;
            }
            int attributeInt = i2.getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        }
        return invokeL.intValue;
    }

    public static Bitmap g(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return h(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap h(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, drawable, i2, i3)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i2 > 0 && i3 > 0) {
                try {
                    bitmap = Bitmap.createBitmap(i2, i3, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, i2, i3);
                        drawable.draw(canvas);
                    }
                } catch (Exception | OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static ExifInterface i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public static int[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            if (iArr[0] != 0) {
                return iArr;
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, new int[1]);
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
            EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 1, 12344});
            egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
            GLES10.glGetIntegerv(3379, iArr, 0);
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
            egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
            egl10.eglTerminate(eglGetDisplay);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static File k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? l(c.a.q0.a.g1.f.U().G().k(), str) : (File) invokeL.objValue;
    }

    public static File l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            boolean z = a;
            String str3 = "swan_tmp_" + System.currentTimeMillis() + "_" + str2;
            File file = null;
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(str);
                if (file2.exists()) {
                    file = new File(file2, str3);
                } else if (file2.mkdirs()) {
                    file = new File(file2, str3);
                }
                if (file != null && !file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if (a && file != null) {
                String str4 = "temp路径:" + file.getAbsolutePath();
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static Uri m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("content://")) {
                if (str.startsWith("/")) {
                    return Uri.fromFile(new File(str));
                }
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean n(File file, File file2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(65550, null, file, file2, i2)) != null) {
            return invokeLLI.booleanValue;
        }
        boolean z = a;
        if (file2 == null || file == null || !file.exists() || !file2.exists()) {
            boolean z2 = a;
            return false;
        } else if (i2 >= 0 && i2 <= 100) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (decodeFile != null && decodeFile.getWidth() != 0 && decodeFile.getHeight() != 0) {
                        int f2 = f(file.getAbsolutePath());
                        if (f2 != 0) {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(f2);
                            decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream2);
                            c.a.q0.w.d.d(fileOutputStream2);
                            c(file.getAbsolutePath(), file2.getAbsolutePath(), i2);
                            return true;
                        } catch (Exception unused) {
                            fileOutputStream = fileOutputStream2;
                            boolean z3 = a;
                            c.a.q0.w.d.d(fileOutputStream);
                            return false;
                        } catch (OutOfMemoryError unused2) {
                            fileOutputStream = fileOutputStream2;
                            boolean z4 = a;
                            c.a.q0.w.d.d(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            c.a.q0.w.d.d(fileOutputStream);
                            throw th;
                        }
                    }
                    boolean z5 = a;
                    c.a.q0.w.d.d(null);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused3) {
            } catch (OutOfMemoryError unused4) {
            }
        } else {
            boolean z6 = a;
            return false;
        }
    }

    public static boolean o(Bitmap bitmap, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65551, null, bitmap, str, i2)) == null) ? p(bitmap, str, i2, Bitmap.CompressFormat.JPEG) : invokeLLI.booleanValue;
    }

    public static boolean p(Bitmap bitmap, String str, int i2, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65552, null, bitmap, str, i2, compressFormat)) == null) ? q(str, new a(bitmap, compressFormat, i2)) : invokeLLIL.booleanValue;
    }

    public static boolean q(String str, c.a.q0.a.z2.g1.e<OutputStream, Boolean> eVar) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65553, null, str, eVar)) != null) {
            return invokeLL.booleanValue;
        }
        boolean z = false;
        if (!c.a.q0.w.d.w()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (eVar != null && d(file)) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        if (eVar.a(fileOutputStream).booleanValue()) {
                            z = true;
                            c.a.q0.w.d.d(fileOutputStream);
                            return z;
                        }
                        fileOutputStream2 = fileOutputStream;
                    } catch (FileNotFoundException unused) {
                        fileOutputStream2 = fileOutputStream;
                        boolean z2 = a;
                        c.a.q0.w.d.d(fileOutputStream2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        c.a.q0.w.d.d(fileOutputStream2);
                        throw th;
                    }
                }
                fileOutputStream = fileOutputStream2;
                c.a.q0.w.d.d(fileOutputStream);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused2) {
        }
    }

    public static void r(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) || str == null || context == null) {
            return;
        }
        File file = new File(str);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }
}
