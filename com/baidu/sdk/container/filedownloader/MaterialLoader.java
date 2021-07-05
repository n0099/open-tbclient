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
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k0.a.c.a;
import d.a.k0.a.h.a;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class MaterialLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile MaterialLoader f10088c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f10089d = "MaterialLoader";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10090a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.a.e.a f10091b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (MaterialCacheType[]) $VALUES.clone() : (MaterialCacheType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.k0.a.e.a {
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

        @Override // d.a.k0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
            }
        }

        @Override // d.a.k0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
            }
        }

        @Override // d.a.k0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f10092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f10093f;

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
            this.f10092e = imageView;
            this.f10093f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10092e.setImageBitmap(this.f10093f);
                this.f10092e.setBackgroundResource(17170445);
                this.f10092e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MaterialCacheType f10094a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10095b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10096c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f10097d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.a.e.a f10098e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageView f10099f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f10100g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MaterialLoader f10101h;

        /* loaded from: classes3.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f10102a;

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
                this.f10102a = cVar;
            }

            @Override // d.a.k0.a.c.a.c
            public void onCacheComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f10102a;
                    cVar.f10098e.onLoadingComplete(cVar.f10095b, null, null);
                }
            }

            @Override // d.a.k0.a.c.a.c
            public void onCacheFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.f10102a;
                    cVar.f10098e.a(cVar.f10095b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f10103a;

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
                this.f10103a = cVar;
            }

            @Override // d.a.k0.a.c.a.c
            public void onCacheComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f10103a;
                    cVar.f10098e.onLoadingComplete(cVar.f10095b, null, null);
                }
            }

            @Override // d.a.k0.a.c.a.c
            public void onCacheFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.f10103a;
                    cVar.f10098e.a(cVar.f10095b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                }
            }
        }

        /* renamed from: com.baidu.sdk.container.filedownloader.MaterialLoader$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0149c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f10104e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f10105f;

            public RunnableC0149c(c cVar, Bitmap bitmap) {
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
                this.f10105f = cVar;
                this.f10104e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.f10105f.f10099f) == null) {
                    return;
                }
                imageView.setImageBitmap(this.f10104e);
                this.f10105f.f10099f.setBackgroundResource(17170445);
                this.f10105f.f10099f.setVisibility(0);
            }
        }

        public c(MaterialLoader materialLoader, MaterialCacheType materialCacheType, String str, String str2, int i2, d.a.k0.a.e.a aVar, ImageView imageView, boolean z) {
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
            this.f10101h = materialLoader;
            this.f10094a = materialCacheType;
            this.f10095b = str;
            this.f10096c = str2;
            this.f10097d = i2;
            this.f10098e = aVar;
            this.f10099f = imageView;
            this.f10100g = z;
        }

        @Override // d.a.k0.a.h.a.c
        public void onFail(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                String str2 = MaterialLoader.f10089d;
                Log.e(str2, "素材请求失败，onFail: " + str);
                this.f10098e.a(this.f10095b, this.f10099f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            }
        }

        @Override // d.a.k0.a.h.a.c
        public void onSuccess(InputStream inputStream, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, str) == null) {
                try {
                    if (inputStream != null) {
                        if (this.f10094a != MaterialCacheType.VIDEO && !this.f10101h.p(this.f10095b)) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            Bitmap decodeStream = BitmapFactory.decodeStream(new d(inputStream), null, options);
                            if (decodeStream != null) {
                                Bitmap r = !this.f10095b.substring(this.f10095b.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.r(MaterialLoader.s(decodeStream, 100 - (this.f10101h.t(decodeStream) * 10)), MaterialLoader.v(options)) : decodeStream;
                                if (r != null) {
                                    decodeStream = r;
                                }
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    if (this.f10099f != null) {
                                        this.f10099f.setImageBitmap(decodeStream);
                                        this.f10099f.setBackgroundResource(17170445);
                                        this.f10099f.setVisibility(0);
                                    }
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new RunnableC0149c(this, decodeStream));
                                }
                                this.f10101h.y(decodeStream, this.f10095b, this.f10100g);
                                this.f10098e.onLoadingComplete(this.f10095b, this.f10099f, decodeStream);
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
                            if (TextUtils.isEmpty(this.f10096c) || this.f10097d <= 0) {
                                this.f10101h.w(byteArrayOutputStream.toByteArray(), this.f10095b, new b(this));
                            } else {
                                this.f10101h.x(byteArrayOutputStream.toByteArray(), this.f10095b, this.f10096c, this.f10097d, new a(this));
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
                    Log.e(MaterialLoader.f10089d, "素材请求失败，无数据流");
                    this.f10098e.a(this.f10095b, this.f10099f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (OutOfMemoryError unused) {
                    Log.e(MaterialLoader.f10089d, "素材请求失败，OOM");
                    this.f10098e.a(this.f10095b, this.f10099f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (Throwable unused2) {
                    Log.e(MaterialLoader.f10089d, "素材请求失败，解析异常");
                    this.f10098e.a(this.f10095b, this.f10099f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f10091b = new a(this);
        this.f10090a = context.getApplicationContext();
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
            if (f10088c == null) {
                synchronized (MaterialLoader.class) {
                    if (f10088c == null) {
                        f10088c = new MaterialLoader(context);
                    }
                }
            }
            return f10088c;
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

    public void e(String str, MaterialCacheType materialCacheType, d.a.k0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, materialCacheType, aVar) == null) {
            if (aVar == null) {
                aVar = this.f10091b;
            }
            if (o(str, materialCacheType)) {
                aVar.onLoadingComplete(str, null, materialCacheType == MaterialCacheType.PICTURE ? u(str) : null);
            } else {
                g(str, null, materialCacheType, aVar);
            }
        }
    }

    public void f(String str, d.a.k0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (p(str)) {
                e(str, MaterialCacheType.VIDEO, aVar);
            } else {
                e(str, MaterialCacheType.PICTURE, aVar);
            }
        }
    }

    public final void g(String str, ImageView imageView, MaterialCacheType materialCacheType, d.a.k0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, imageView, materialCacheType, aVar) == null) {
            h(str, imageView, materialCacheType, false, null, 0, aVar);
        }
    }

    public final void h(String str, ImageView imageView, MaterialCacheType materialCacheType, boolean z, String str2, int i2, d.a.k0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, imageView, materialCacheType, Boolean.valueOf(z), str2, Integer.valueOf(i2), aVar}) == null) {
            d.a.k0.a.h.a aVar2 = new d.a.k0.a.h.a(1, str);
            aVar2.c(new c(this, materialCacheType, str, str2, i2, aVar, imageView, z));
            aVar2.d();
        }
    }

    public Bitmap i(String str, d.a.k0.a.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) {
            if (aVar == null) {
                aVar = this.f10091b;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, materialCacheType)) == null) ? d.a.k0.a.c.a.e(this.f10090a).d(str, materialCacheType) : (String) invokeLL.objValue;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType)) == null) ? d.a.k0.a.c.a.e(this.f10090a).f(str, materialCacheType) : invokeLL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? str.indexOf(".mp4") > 0 || str.indexOf(".gif") > 0 : invokeL.booleanValue;
    }

    public void q(ImageView imageView, String str, d.a.k0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, imageView, str, aVar) == null) {
            if (aVar == null) {
                try {
                    aVar = this.f10091b;
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
            int j = j(bitmap);
            if (j > 2457600) {
                int i2 = j / com.baidu.mobads.container.util.filedownloader.MaterialLoader.MAX_IMAGE_SIZE;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? d.a.k0.a.c.a.e(this.f10090a).j(str) : (Bitmap) invokeL.objValue;
    }

    public final void w(byte[] bArr, String str, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bArr, str, cVar) == null) {
            d.a.k0.a.c.a.e(this.f10090a).n(str, bArr, MaterialCacheType.VIDEO, false, cVar);
        }
    }

    public final void x(byte[] bArr, String str, String str2, int i2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bArr, str, str2, Integer.valueOf(i2), cVar}) == null) {
            d.a.k0.a.c.a.e(this.f10090a).o(str, bArr, str2, i2, false, cVar);
        }
    }

    public final void y(Bitmap bitmap, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, bitmap, str, z) == null) {
            d.a.k0.a.c.a.e(this.f10090a).l(str, bitmap, z);
        }
    }
}
