package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.a;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
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
/* loaded from: classes5.dex */
public final class ImageLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f37715a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f37716b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f37717c = "baidu/wallet/image_cache";

    /* renamed from: d  reason: collision with root package name */
    public static final long f37718d = 864000000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37719e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f37720f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37721g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static ImageLoader f37722h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f37723i;

    /* renamed from: j  reason: collision with root package name */
    public b f37724j;
    public a k;
    public ImageProcessor l;
    public ThreadPoolExecutor m;

    /* loaded from: classes5.dex */
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
        f37715a = ApollonConstants.DEBUG;
        f37716b = ImageLoader.class.getSimpleName();
        f37722h = null;
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
        this.f37723i = DxmApplicationContextImpl.getApplicationContext(context);
        this.l = new ImageProcessor(this.f37723i);
        this.f37724j = new b();
        this.k = new a(this.f37723i, f37717c, new a.InterfaceC1608a(this) { // from class: com.baidu.apollon.imagemanager.ImageLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ImageLoader f37725a;

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
                this.f37725a = this;
            }

            @Override // com.baidu.apollon.imagemanager.a.InterfaceC1608a
            public List<File> a(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    if (file.exists() && file.isDirectory()) {
                        LinkedList linkedList = new LinkedList();
                        File[] listFiles = file.listFiles();
                        long currentTimeMillis = System.currentTimeMillis() - ImageLoader.f37718d;
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
            boolean z = f37715a;
            if (f37722h == null) {
                synchronized (ImageLoader.class) {
                    if (f37722h == null) {
                        f37722h = new ImageLoader(DxmApplicationContextImpl.getApplicationContext(context));
                    }
                }
            }
            return f37722h;
        }
        return (ImageLoader) invokeL.objValue;
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, str, onGetBitmapListener, obj, i2) == null) && a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                boolean z = f37715a;
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
                public final /* synthetic */ String f37727a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ OnGetBitmapListener f37728b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Object f37729c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f37730d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ImageLoader f37731e;

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
                    this.f37731e = this;
                    this.f37727a = str;
                    this.f37728b = onGetBitmapListener;
                    this.f37729c = obj;
                    this.f37730d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f37731e.a(this.f37727a, this.f37728b, this.f37729c, this.f37730d)) {
                        return;
                    }
                    this.f37731e.b(this.f37727a, this.f37728b, this.f37729c, this.f37730d);
                }
            });
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = f37715a;
            if (a(str)) {
                return this.f37724j.a(str);
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
                    boolean z = f37715a;
                    return bitmapFromMemCache;
                }
                Bitmap a2 = a(str, obj, i2);
                if (a2 != null) {
                    boolean z2 = f37715a;
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
                    public final /* synthetic */ ImageLoader f37726a;

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
                        this.f37726a = this;
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
                boolean z = f37715a;
                Context context = this.f37723i;
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
                    boolean z2 = f37715a;
                    this.f37724j.a(str, bitmap);
                    this.f37724j.a();
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
                boolean z = f37715a;
                File a2 = this.k.a(str);
                if (a2 == null || !a2.exists()) {
                    return false;
                }
                boolean z2 = f37715a;
                try {
                    bitmap = this.l.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    boolean z3 = f37715a;
                    this.f37724j.a(str, bitmap);
                    this.f37724j.a();
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
            boolean z = f37715a;
            File a2 = this.k.a(str);
            Bitmap bitmap = null;
            if (a2 != null && a2.exists()) {
                boolean z2 = f37715a;
                try {
                    bitmap = this.l.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    boolean z3 = f37715a;
                    this.f37724j.a(str, bitmap);
                    this.f37724j.a();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }
}
