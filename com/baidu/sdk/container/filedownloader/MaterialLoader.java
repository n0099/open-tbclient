package com.baidu.sdk.container.filedownloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.i0.a.c.a;
import c.a.i0.a.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class MaterialLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile MaterialLoader f44907c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f44908d = "MaterialLoader";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f44909a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.i0.a.e.a f44910b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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
            VIDEO = new MaterialCacheType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 1, "video");
            MaterialCacheType materialCacheType = new MaterialCacheType("CUSTOM", 2, SchedulerSupport.CUSTOM);
            CUSTOM = materialCacheType;
            $VALUES = new MaterialCacheType[]{PICTURE, VIDEO, materialCacheType};
        }

        public MaterialCacheType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (MaterialCacheType) Enum.valueOf(MaterialCacheType.class, str) : (MaterialCacheType) invokeL.objValue;
        }

        public static MaterialCacheType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (MaterialCacheType[]) $VALUES.clone() : (MaterialCacheType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements c.a.i0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(MaterialLoader materialLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.i0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
            }
        }

        @Override // c.a.i0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
            }
        }

        @Override // c.a.i0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f44911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f44912f;

        public b(MaterialLoader materialLoader, ImageView imageView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader, imageView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44911e = imageView;
            this.f44912f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44911e.setImageBitmap(this.f44912f);
                this.f44911e.setBackgroundResource(17170445);
                this.f44911e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MaterialCacheType f44913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44915c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f44916d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.i0.a.e.a f44917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageView f44918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44919g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MaterialLoader f44920h;

        /* loaded from: classes5.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f44921a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44921a = cVar;
            }

            @Override // c.a.i0.a.c.a.c
            public void onCacheComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f44921a;
                    cVar.f44917e.onLoadingComplete(cVar.f44914b, null, null);
                }
            }

            @Override // c.a.i0.a.c.a.c
            public void onCacheFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.f44921a;
                    cVar.f44917e.a(cVar.f44914b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f44922a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44922a = cVar;
            }

            @Override // c.a.i0.a.c.a.c
            public void onCacheComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f44922a;
                    cVar.f44917e.onLoadingComplete(cVar.f44914b, null, null);
                }
            }

            @Override // c.a.i0.a.c.a.c
            public void onCacheFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.f44922a;
                    cVar.f44917e.a(cVar.f44914b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }
        }

        /* renamed from: com.baidu.sdk.container.filedownloader.MaterialLoader$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1702c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f44923e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f44924f;

            public RunnableC1702c(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44924f = cVar;
                this.f44923e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.f44924f.f44918f) == null) {
                    return;
                }
                imageView.setImageBitmap(this.f44923e);
                this.f44924f.f44918f.setBackgroundResource(17170445);
                this.f44924f.f44918f.setVisibility(0);
            }
        }

        public c(MaterialLoader materialLoader, MaterialCacheType materialCacheType, String str, String str2, int i2, c.a.i0.a.e.a aVar, ImageView imageView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialLoader, materialCacheType, str, str2, Integer.valueOf(i2), aVar, imageView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44920h = materialLoader;
            this.f44913a = materialCacheType;
            this.f44914b = str;
            this.f44915c = str2;
            this.f44916d = i2;
            this.f44917e = aVar;
            this.f44918f = imageView;
            this.f44919g = z;
        }

        @Override // c.a.i0.a.h.a.c
        public void onFail(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                String unused = MaterialLoader.f44908d;
                String str2 = "素材请求失败，onFail: " + str;
                this.f44917e.a(this.f44914b, this.f44918f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            }
        }

        @Override // c.a.i0.a.h.a.c
        public void onSuccess(InputStream inputStream, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, str) == null) {
                try {
                    if (inputStream != null) {
                        if (this.f44913a != MaterialCacheType.VIDEO && !this.f44920h.p(this.f44914b)) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            Bitmap decodeStream = BitmapFactory.decodeStream(new d(inputStream), null, options);
                            if (decodeStream != null) {
                                Bitmap r = !this.f44914b.substring(this.f44914b.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.r(MaterialLoader.s(decodeStream, 100 - (this.f44920h.t(decodeStream) * 10)), MaterialLoader.v(options)) : decodeStream;
                                if (r != null) {
                                    decodeStream = r;
                                }
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    if (this.f44918f != null) {
                                        this.f44918f.setImageBitmap(decodeStream);
                                        this.f44918f.setBackgroundResource(17170445);
                                        this.f44918f.setVisibility(0);
                                    }
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new RunnableC1702c(this, decodeStream));
                                }
                                this.f44920h.y(decodeStream, this.f44914b, this.f44919g);
                                this.f44917e.onLoadingComplete(this.f44914b, this.f44918f, decodeStream);
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
                            if (TextUtils.isEmpty(this.f44915c) || this.f44916d <= 0) {
                                this.f44920h.w(byteArrayOutputStream.toByteArray(), this.f44914b, new b(this));
                            } else {
                                this.f44920h.x(byteArrayOutputStream.toByteArray(), this.f44914b, this.f44915c, this.f44916d, new a(this));
                            }
                            byteArrayOutputStream.flush();
                        } catch (FileNotFoundException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return;
                    }
                    String unused = MaterialLoader.f44908d;
                    this.f44917e.a(this.f44914b, this.f44918f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (OutOfMemoryError unused2) {
                    String unused3 = MaterialLoader.f44908d;
                    this.f44917e.a(this.f44914b, this.f44918f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (Throwable unused4) {
                    String unused5 = MaterialLoader.f44908d;
                    this.f44917e.a(this.f44914b, this.f44918f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                long j3 = 0;
                while (j3 < j2) {
                    long skip = ((FilterInputStream) this).in.skip(j2 - j3);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j3 += skip;
                }
                return j3;
            }
            return invokeJ.longValue;
        }
    }

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

    public MaterialLoader(Context context) {
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
        this.f44910b = new a(this);
        this.f44909a = context.getApplicationContext();
    }

    public static int j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bitmap)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i2 >= 12) {
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
            if (f44907c == null) {
                synchronized (MaterialLoader.class) {
                    if (f44907c == null) {
                        f44907c = new MaterialLoader(context);
                    }
                }
            }
            return f44907c;
        }
        return (MaterialLoader) invokeL.objValue;
    }

    public static Bitmap r(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bitmap, i2)) == null) {
            if (i2 <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = 1.0f / i2;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap s(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bitmap, i2)) == null) {
            if (i2 == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                }
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static int v(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, options)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 > 1140 || i4 > 1140) {
                int i5 = 2;
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (true) {
                    if (i6 < 1140 && i7 < 1140) {
                        break;
                    }
                    i5 *= 2;
                }
                i2 = i5;
            } else {
                i2 = 1;
            }
            if (i2 > 6) {
                return 6;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public void e(String str, MaterialCacheType materialCacheType, c.a.i0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, materialCacheType, aVar) == null) {
            if (aVar == null) {
                aVar = this.f44910b;
            }
            if (o(str, materialCacheType)) {
                aVar.onLoadingComplete(str, null, materialCacheType == MaterialCacheType.PICTURE ? u(str) : null);
            } else {
                g(str, null, materialCacheType, aVar);
            }
        }
    }

    public void f(String str, c.a.i0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (p(str)) {
                e(str, MaterialCacheType.VIDEO, aVar);
            } else {
                e(str, MaterialCacheType.PICTURE, aVar);
            }
        }
    }

    public final void g(String str, ImageView imageView, MaterialCacheType materialCacheType, c.a.i0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, imageView, materialCacheType, aVar) == null) {
            h(str, imageView, materialCacheType, false, null, 0, aVar);
        }
    }

    public final void h(String str, ImageView imageView, MaterialCacheType materialCacheType, boolean z, String str2, int i2, c.a.i0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, imageView, materialCacheType, Boolean.valueOf(z), str2, Integer.valueOf(i2), aVar}) == null) {
            c.a.i0.a.h.a aVar2 = new c.a.i0.a.h.a(1, str);
            aVar2.c(new c(this, materialCacheType, str, str2, i2, aVar, imageView, z));
            aVar2.d();
        }
    }

    public Bitmap i(String str, c.a.i0.a.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) {
            if (aVar == null) {
                aVar = this.f44910b;
            }
            if (n(str)) {
                return u(str);
            }
            g(str, null, MaterialCacheType.PICTURE, aVar);
            return null;
        }
        return (Bitmap) invokeLL.objValue;
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

    public String m(String str, MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, materialCacheType)) == null) ? c.a.i0.a.c.a.e(this.f44909a).d(str, materialCacheType) : (String) invokeLL.objValue;
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

    public boolean o(String str, MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType)) == null) ? c.a.i0.a.c.a.e(this.f44909a).f(str, materialCacheType) : invokeLL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? str.indexOf(".mp4") > 0 || str.indexOf(".gif") > 0 : invokeL.booleanValue;
    }

    public void q(ImageView imageView, String str, c.a.i0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, imageView, str, aVar) == null) {
            if (aVar == null) {
                try {
                    aVar = this.f44910b;
                } catch (Throwable unused) {
                    aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_PARSE_ERROR);
                    return;
                }
            }
            aVar.onLoadingStarted(str, imageView);
            if (TextUtils.isEmpty(str)) {
                aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_URL_NULL);
            } else if (imageView == null) {
                aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_VIEW_NULL);
            } else {
                Bitmap u = u(str);
                if (u == null) {
                    g(str, imageView, MaterialCacheType.PICTURE, aVar);
                    return;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    imageView.setImageBitmap(u);
                    imageView.setBackgroundResource(17170445);
                    imageView.setVisibility(0);
                } else {
                    new Handler(Looper.getMainLooper()).post(new b(this, imageView, u));
                }
                aVar.onLoadingComplete(str, imageView, u);
            }
        }
    }

    public int t(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmap)) == null) {
            int j2 = j(bitmap);
            if (j2 > 2457600) {
                int i2 = j2 / com.baidu.mobads.container.util.filedownloader.MaterialLoader.MAX_IMAGE_SIZE;
                if (i2 > 6) {
                    return 6;
                }
                return i2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final Bitmap u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? c.a.i0.a.c.a.e(this.f44909a).j(str) : (Bitmap) invokeL.objValue;
    }

    public final void w(byte[] bArr, String str, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bArr, str, cVar) == null) {
            c.a.i0.a.c.a.e(this.f44909a).n(str, bArr, MaterialCacheType.VIDEO, false, cVar);
        }
    }

    public final void x(byte[] bArr, String str, String str2, int i2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bArr, str, str2, Integer.valueOf(i2), cVar}) == null) {
            c.a.i0.a.c.a.e(this.f44909a).o(str, bArr, str2, i2, false, cVar);
        }
    }

    public final void y(Bitmap bitmap, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, bitmap, str, z) == null) {
            c.a.i0.a.c.a.e(this.f44909a).l(str, bitmap, z);
        }
    }
}
