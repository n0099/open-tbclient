package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.a;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class ImageLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3801a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3802b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f3803c = "baidu/wallet/image_cache";

    /* renamed from: d  reason: collision with root package name */
    public static final long f3804d = 864000000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3805e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f3806f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f3807g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static ImageLoader f3808h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f3809i;
    public b j;
    public a k;
    public ImageProcessor l;
    public ThreadPoolExecutor m;

    /* loaded from: classes.dex */
    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1335646228, "Lcom/baidu/apollon/imagemanager/ImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1335646228, "Lcom/baidu/apollon/imagemanager/ImageLoader;");
                return;
            }
        }
        f3801a = ApollonConstants.DEBUG;
        f3802b = ImageLoader.class.getSimpleName();
        f3808h = null;
    }

    public ImageLoader(Context context) {
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
        this.m = null;
        Context applicationContext = context.getApplicationContext();
        this.f3809i = applicationContext;
        this.l = new ImageProcessor(applicationContext);
        this.j = new b();
        this.k = new a(this.f3809i, f3803c, new a.InterfaceC0062a(this) { // from class: com.baidu.apollon.imagemanager.ImageLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ImageLoader f3810a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3810a = this;
            }

            @Override // com.baidu.apollon.imagemanager.a.InterfaceC0062a
            public List<File> a(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    if (file.exists() && file.isDirectory()) {
                        LinkedList linkedList = new LinkedList();
                        File[] listFiles = file.listFiles();
                        long currentTimeMillis = System.currentTimeMillis() - ImageLoader.f3804d;
                        for (File file2 : listFiles) {
                            if (file2.lastModified() < currentTimeMillis) {
                                linkedList.add(file2);
                            }
                        }
                        return linkedList;
                    }
                    return null;
                }
                return (List) invokeL.objValue;
            }
        });
    }

    public static ImageLoader getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (f3801a) {
                Log.d(f3802b, "getInstance()");
            }
            if (f3808h == null) {
                synchronized (ImageLoader.class) {
                    if (f3808h == null) {
                        f3808h = new ImageLoader(context.getApplicationContext());
                    }
                }
            }
            return f3808h;
        }
        return (ImageLoader) invokeL.objValue;
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, str, onGetBitmapListener, obj, i2) == null) && a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                if (f3801a) {
                    Log.d(f3802b, "find in memory");
                }
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i2);
        }
    }

    public void getBitmapFromDiskOrNet(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, onGetBitmapListener, obj, i2) == null) {
            a(new Runnable(this, str, onGetBitmapListener, obj, i2) { // from class: com.baidu.apollon.imagemanager.ImageLoader.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f3812a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ OnGetBitmapListener f3813b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Object f3814c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f3815d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ImageLoader f3816e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, onGetBitmapListener, obj, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3816e = this;
                    this.f3812a = str;
                    this.f3813b = onGetBitmapListener;
                    this.f3814c = obj;
                    this.f3815d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f3816e.a(this.f3812a, this.f3813b, this.f3814c, this.f3815d)) {
                        return;
                    }
                    this.f3816e.b(this.f3812a, this.f3813b, this.f3814c, this.f3815d);
                }
            });
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (f3801a) {
                Log.d(f3802b, "check memory");
            }
            if (a(str)) {
                return this.j.a(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, str, obj, i2)) == null) {
            if (a(str)) {
                Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
                if (bitmapFromMemCache != null) {
                    if (f3801a) {
                        Log.d(f3802b, "find in memory");
                    }
                    return bitmapFromMemCache;
                }
                Bitmap a2 = a(str, obj, i2);
                if (a2 != null && f3801a) {
                    Log.d(f3802b, "find in disk");
                }
                return a2;
            }
            return null;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, runnable) == null) {
            if (this.m == null) {
                this.m = new ThreadPoolExecutor(3, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.baidu.apollon.imagemanager.ImageLoader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ImageLoader f3811a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f3811a = this;
                    }

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable2)) == null) {
                            AtomicInteger atomicInteger = new AtomicInteger(1);
                            return new Thread(runnable2, "ImageLoader #" + atomicInteger.getAndIncrement());
                        }
                        return (Thread) invokeL.objValue;
                    }
                }, new ThreadPoolExecutor.DiscardOldestPolicy());
                if (ChannelUtils.isSpecailPackage()) {
                    this.m.allowCoreThreadTimeOut(true);
                }
            }
            this.m.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65544, this, str, onGetBitmapListener, obj, i2) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                if (f3801a) {
                    Log.d(f3802b, "download from net");
                }
                Context context = this.f3809i;
                RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "image load http request");
                restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.a());
                Bitmap bitmap = null;
                try {
                    bArr = (byte[]) restTemplate.a(str, null, "utf-8", byte[].class);
                } catch (RestRuntimeException e2) {
                    e2.printStackTrace();
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                this.k.a(str, bArr);
                File a2 = this.k.a(str);
                if (a2 == null || !a2.exists()) {
                    return;
                }
                try {
                    bitmap = this.l.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    if (f3801a) {
                        Log.d(f3802b, "find in file");
                    }
                    this.j.a(str, bitmap);
                    this.j.a();
                    if (onGetBitmapListener != null) {
                        onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        InterceptResult invokeLLLI;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(AdIconUtil.BAIDU_LOGO_ID, this, str, onGetBitmapListener, obj, i2)) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                if (f3801a) {
                    Log.d(f3802b, "chech file async ");
                }
                File a2 = this.k.a(str);
                if (a2 == null || !a2.exists()) {
                    return false;
                }
                if (f3801a) {
                    Log.d(f3802b, "file is not null ");
                }
                try {
                    bitmap = this.l.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    if (f3801a) {
                        Log.d(f3802b, "find in file");
                    }
                    this.j.a(str, bitmap);
                    this.j.a();
                    if (onGetBitmapListener != null) {
                        onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return invokeLLLI.booleanValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private Bitmap a(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, str, obj, i2)) == null) {
            if (f3801a) {
                Log.d(f3802b, "chech file async ");
            }
            File a2 = this.k.a(str);
            Bitmap bitmap = null;
            if (a2 != null && a2.exists()) {
                if (f3801a) {
                    Log.d(f3802b, "file is not null ");
                }
                try {
                    bitmap = this.l.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    if (f3801a) {
                        Log.d(f3802b, "find in file");
                    }
                    this.j.a(str, bitmap);
                    this.j.a();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }
}
