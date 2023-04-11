package com.baidu.sdk.container.filedownloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.tieba.ek1;
import com.baidu.tieba.ok1;
import com.baidu.tieba.wj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class MaterialLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile MaterialLoader c = null;
    public static final String d = "MaterialLoader";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ek1 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(883575412, "Lcom/baidu/sdk/container/filedownloader/MaterialLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(883575412, "Lcom/baidu/sdk/container/filedownloader/MaterialLoader;");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ok1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaterialCacheType a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ek1 e;
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ MaterialLoader h;

        /* loaded from: classes2.dex */
        public class a implements wj1.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.wj1.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.a;
                    cVar.e.a(cVar.b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }

            @Override // com.baidu.tieba.wj1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.a;
                    cVar.e.onLoadingComplete(cVar.b, null, null);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements wj1.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.wj1.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.a;
                    cVar.e.a(cVar.b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }

            @Override // com.baidu.tieba.wj1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.a;
                    cVar.e.onLoadingComplete(cVar.b, null, null);
                }
            }
        }

        /* renamed from: com.baidu.sdk.container.filedownloader.MaterialLoader$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0146c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ c b;

            public RunnableC0146c(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (imageView = this.b.f) != null) {
                    imageView.setImageBitmap(this.a);
                    this.b.f.setBackgroundResource(17170445);
                    this.b.f.setVisibility(0);
                }
            }
        }

        public c(MaterialLoader materialLoader, MaterialCacheType materialCacheType, String str, String str2, int i, ek1 ek1Var, ImageView imageView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader, materialCacheType, str, str2, Integer.valueOf(i), ek1Var, imageView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = materialLoader;
            this.a = materialCacheType;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = ek1Var;
            this.f = imageView;
            this.g = z;
        }

        @Override // com.baidu.tieba.ok1.c
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
                return;
            }
            String str2 = MaterialLoader.d;
            Log.e(str2, "素材请求失败，onFail: " + str);
            this.e.a(this.b, this.f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
        }

        @Override // com.baidu.tieba.ok1.c
        public void b(InputStream inputStream, String str) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, str) == null) {
                try {
                    if (inputStream != null) {
                        if (this.a != MaterialCacheType.VIDEO && !this.h.p(this.b)) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            Bitmap decodeStream = BitmapFactory.decodeStream(new d(inputStream), null, options);
                            if (decodeStream != null) {
                                if (!this.b.substring(this.b.lastIndexOf("/") + 1).toUpperCase().contains("PNG")) {
                                    bitmap = MaterialLoader.r(MaterialLoader.s(decodeStream, 100 - (this.h.t(decodeStream) * 10)), MaterialLoader.v(options));
                                } else {
                                    bitmap = decodeStream;
                                }
                                if (bitmap != null) {
                                    decodeStream = bitmap;
                                }
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    if (this.f != null) {
                                        this.f.setImageBitmap(decodeStream);
                                        this.f.setBackgroundResource(17170445);
                                        this.f.setVisibility(0);
                                    }
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new RunnableC0146c(this, decodeStream));
                                }
                                this.h.y(decodeStream, this.b, this.g);
                                this.e.onLoadingComplete(this.b, this.f, decodeStream);
                                if (inputStream != null) {
                                    inputStream.close();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (!TextUtils.isEmpty(this.c) && this.d > 0) {
                                this.h.x(byteArrayOutputStream.toByteArray(), this.b, this.c, this.d, new a(this));
                            } else {
                                this.h.w(byteArrayOutputStream.toByteArray(), this.b, new b(this));
                            }
                            byteArrayOutputStream.flush();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return;
                    }
                    Log.e(MaterialLoader.d, "素材请求失败，无数据流");
                    this.e.a(this.b, this.f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (OutOfMemoryError unused) {
                    Log.e(MaterialLoader.d, "素材请求失败，OOM");
                    this.e.a(this.b, this.f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (Throwable unused2) {
                    Log.e(MaterialLoader.d, "素材请求失败，解析异常");
                    this.e.a(this.b, this.f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class MaterialCacheType {
        public static final /* synthetic */ MaterialCacheType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaterialCacheType CUSTOM;
        public static final MaterialCacheType PICTURE;
        public static final MaterialCacheType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(175792035, "Lcom/baidu/sdk/container/filedownloader/MaterialLoader$MaterialCacheType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(175792035, "Lcom/baidu/sdk/container/filedownloader/MaterialLoader$MaterialCacheType;");
                    return;
                }
            }
            PICTURE = new MaterialCacheType("PICTURE", 0, "normal");
            VIDEO = new MaterialCacheType(HlsPlaylistParser.TYPE_VIDEO, 1, "video");
            MaterialCacheType materialCacheType = new MaterialCacheType("CUSTOM", 2, ExceptionHandlerImpl.KEY_CUSTOM);
            CUSTOM = materialCacheType;
            $VALUES = new MaterialCacheType[]{PICTURE, VIDEO, materialCacheType};
        }

        public MaterialCacheType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static MaterialCacheType parse(String str) {
            InterceptResult invokeL;
            MaterialCacheType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (MaterialCacheType materialCacheType : values()) {
                    if (materialCacheType.value.equalsIgnoreCase(str)) {
                        return materialCacheType;
                    }
                }
                return null;
            }
            return (MaterialCacheType) invokeL.objValue;
        }

        public static MaterialCacheType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (MaterialCacheType) Enum.valueOf(MaterialCacheType.class, str);
            }
            return (MaterialCacheType) invokeL.objValue;
        }

        public static MaterialCacheType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (MaterialCacheType[]) $VALUES.clone();
            }
            return (MaterialCacheType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.value;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ek1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ek1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
            }
        }

        @Override // com.baidu.tieba.ek1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
            }
        }

        @Override // com.baidu.tieba.ek1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }

        public a(MaterialLoader materialLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ Bitmap b;

        public b(MaterialLoader materialLoader, ImageView imageView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader, imageView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setImageBitmap(this.b);
                this.a.setBackgroundResource(17170445);
                this.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = ((FilterInputStream) this).in.skip(j - j2);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 += skip;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    public MaterialLoader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.a = context.getApplicationContext();
    }

    public static int v(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, options)) == null) {
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 <= 1140 && i3 <= 1140) {
                i = 1;
            } else {
                int i4 = 2;
                int i5 = i2 / 2;
                int i6 = i3 / 2;
                while (true) {
                    if (i5 < 1140 && i6 < 1140) {
                        break;
                    }
                    i5 /= 2;
                    i6 /= 2;
                    i4 *= 2;
                }
                i = i4;
            }
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void g(String str, ImageView imageView, MaterialCacheType materialCacheType, ek1 ek1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, imageView, materialCacheType, ek1Var) == null) {
            h(str, imageView, materialCacheType, false, null, 0, ek1Var);
        }
    }

    public static int j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bitmap)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static MaterialLoader k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (c == null) {
                synchronized (MaterialLoader.class) {
                    if (c == null) {
                        c = new MaterialLoader(context);
                    }
                }
            }
            return c;
        }
        return (MaterialLoader) invokeL.objValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!p(str)) {
                return m(str, MaterialCacheType.PICTURE);
            }
            return m(str, MaterialCacheType.VIDEO);
        }
        return (String) invokeL.objValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (p(str)) {
                return o(str, MaterialCacheType.VIDEO);
            }
            return o(str, MaterialCacheType.PICTURE);
        }
        return invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str.indexOf(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) <= 0 && str.indexOf(".gif") <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int t(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmap)) == null) {
            int j = j(bitmap);
            if (j > 2457600) {
                int i = j / 2457600;
                if (i > 6) {
                    return 6;
                }
                return i;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final Bitmap u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return wj1.e(this.a).j(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap r(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bitmap, i)) == null) {
            if (i <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f = 1.0f / i;
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap s(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bitmap, i)) == null) {
            if (i == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public void e(String str, MaterialCacheType materialCacheType, ek1 ek1Var) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, materialCacheType, ek1Var) == null) {
            if (ek1Var == null) {
                ek1Var = this.b;
            }
            if (o(str, materialCacheType)) {
                if (materialCacheType == MaterialCacheType.PICTURE) {
                    bitmap = u(str);
                } else {
                    bitmap = null;
                }
                ek1Var.onLoadingComplete(str, null, bitmap);
                return;
            }
            g(str, null, materialCacheType, ek1Var);
        }
    }

    public final void w(byte[] bArr, String str, wj1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bArr, str, cVar) == null) {
            wj1.e(this.a).n(str, bArr, MaterialCacheType.VIDEO, false, cVar);
        }
    }

    public final void y(Bitmap bitmap, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, bitmap, str, z) == null) {
            wj1.e(this.a).l(str, bitmap, z);
        }
    }

    public void f(String str, ek1 ek1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ek1Var) == null) {
            if (p(str)) {
                e(str, MaterialCacheType.VIDEO, ek1Var);
            } else {
                e(str, MaterialCacheType.PICTURE, ek1Var);
            }
        }
    }

    public Bitmap i(String str, ek1 ek1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, ek1Var)) == null) {
            if (ek1Var == null) {
                ek1Var = this.b;
            }
            if (n(str)) {
                return u(str);
            }
            g(str, null, MaterialCacheType.PICTURE, ek1Var);
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public String m(String str, MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, materialCacheType)) == null) {
            return wj1.e(this.a).d(str, materialCacheType);
        }
        return (String) invokeLL.objValue;
    }

    public boolean o(String str, MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType)) == null) {
            return wj1.e(this.a).f(str, materialCacheType);
        }
        return invokeLL.booleanValue;
    }

    public final void h(String str, ImageView imageView, MaterialCacheType materialCacheType, boolean z, String str2, int i, ek1 ek1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, imageView, materialCacheType, Boolean.valueOf(z), str2, Integer.valueOf(i), ek1Var}) == null) {
            ok1 ok1Var = new ok1(1, str);
            ok1Var.c(new c(this, materialCacheType, str, str2, i, ek1Var, imageView, z));
            ok1Var.d();
        }
    }

    public void q(ImageView imageView, String str, ek1 ek1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, imageView, str, ek1Var) == null) {
            if (ek1Var == null) {
                try {
                    ek1Var = this.b;
                } catch (Throwable unused) {
                    ek1Var.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_PARSE_ERROR);
                    return;
                }
            }
            ek1Var.onLoadingStarted(str, imageView);
            if (TextUtils.isEmpty(str)) {
                ek1Var.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_URL_NULL);
            } else if (imageView == null) {
                ek1Var.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_VIEW_NULL);
            } else {
                Bitmap u = u(str);
                if (u == null) {
                    g(str, imageView, MaterialCacheType.PICTURE, ek1Var);
                    return;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    imageView.setImageBitmap(u);
                    imageView.setBackgroundResource(17170445);
                    imageView.setVisibility(0);
                } else {
                    new Handler(Looper.getMainLooper()).post(new b(this, imageView, u));
                }
                ek1Var.onLoadingComplete(str, imageView, u);
            }
        }
    }

    public final void x(byte[] bArr, String str, String str2, int i, wj1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bArr, str, str2, Integer.valueOf(i), cVar}) == null) {
            wj1.e(this.a).o(str, bArr, str2, i, false, cVar);
        }
    }
}
