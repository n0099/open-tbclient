package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.bean.ImageBitmapBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.util.BitmapReferenceMap;
import com.baidu.searchbox.v8engine.util.DeviceInfo;
import com.baidu.smallgame.sdk.Log;
import com.baidu.tieba.tg1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImageLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSET_URL = "asset://";
    public static final String BDFILE = "bdfile://";
    public static final String DATA_URL = "data:";
    public static final boolean DEBUG = false;
    public static String TAG = "WebGLImageLoader";
    public static final boolean USE_CACHE = true;
    public static ExecutorService sExecutorService;
    public static BitmapReferenceMap sReferenceMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class NetValueCallback implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebGLImage mImage;
        public final int mImageId;
        public final String mSrc;

        public NetValueCallback(WebGLImage webGLImage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webGLImage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mImage = webGLImage;
            this.mSrc = webGLImage.src();
            this.mImageId = this.mImage.getImageId();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                WebGLImageLoader.runInIOThread(new Runnable(this, str) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.NetValueCallback.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetValueCallback this$0;
                    public final /* synthetic */ String val$path;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$path = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebGLImageLoader.loadImageFromConvertedSource(this.this$0.mImage, this.this$0.mImageId, this.this$0.mSrc, this.val$path);
                        }
                    }
                });
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1923729707, "Lcom/baidu/searchbox/v8engine/WebGLImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1923729707, "Lcom/baidu/searchbox/v8engine/WebGLImageLoader;");
                return;
            }
        }
        sReferenceMap = new BitmapReferenceMap();
    }

    public WebGLImageLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ImageBitmapBean getBitmapBean(WebGLImage webGLImage) {
        InterceptResult invokeL;
        ImageBitmapBean imageBitmapBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, webGLImage)) == null) {
            initializeIfNeeded();
            String src = webGLImage.src();
            String oldSrc = webGLImage.oldSrc();
            synchronized (BitmapReferenceMap.class) {
                if (src.equals(oldSrc)) {
                    imageBitmapBean = null;
                } else {
                    ImageBitmapBean imageBitmapBean2 = sReferenceMap.get(oldSrc);
                    if (imageBitmapBean2 != null) {
                        imageBitmapBean2.decreaseRefCount();
                        if (imageBitmapBean2.resetIfNoUsed()) {
                            sReferenceMap.remove(oldSrc);
                        }
                    }
                    imageBitmapBean = sReferenceMap.get(src);
                    if (imageBitmapBean != null) {
                        imageBitmapBean.increaseRefCount();
                    }
                }
            }
            return imageBitmapBean;
        }
        return (ImageBitmapBean) invokeL.objValue;
    }

    @NonNull
    public static String getRealBdFilePath(V8Engine v8Engine, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, v8Engine, str)) == null) {
            String bdFileRealPath = v8Engine.getBdFileRealPath();
            String substring = str.substring(9);
            if (!substring.startsWith(File.separator)) {
                substring = "/" + substring;
            }
            return bdFileRealPath + substring;
        }
        return (String) invokeLL.objValue;
    }

    public static void initializeIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && sExecutorService == null) {
            int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
            sExecutorService = Executors.newFixedThreadPool(numberOfCPUCores < 2 ? 1 : numberOfCPUCores / 2);
        }
    }

    public static void loadAssetImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, webGLImage) == null) {
            String src = webGLImage.src();
            runInIOThread(new Runnable(src.substring(src.indexOf("//") + 2).replace("./", ""), webGLImage, webGLImage.getImageId(), src) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$fileName;
                public final /* synthetic */ WebGLImage val$image;
                public final /* synthetic */ int val$imageId;
                public final /* synthetic */ String val$src;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, webGLImage, Integer.valueOf(r8), src};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$fileName = r6;
                    this.val$image = webGLImage;
                    this.val$imageId = r8;
                    this.val$src = src;
                }

                /* JADX WARN: Removed duplicated region for block: B:40:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    InputStream inputStream;
                    Throwable th;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                try {
                                    inputStream = V8Engine.getAppContext().getResources().getAssets().open(this.val$fileName);
                                    try {
                                        WebGLImageLoader.loadImageFromConvertedSource(this.val$image, this.val$imageId, this.val$src, inputStream);
                                    } catch (IOException e) {
                                        e = e;
                                        e.printStackTrace();
                                        WebGLImageLoader.loadBitmapData(this.val$image, this.val$imageId, null);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                inputStream = null;
                            } catch (Throwable th3) {
                                inputStream = null;
                                th = th3;
                                if (inputStream != null) {
                                }
                                throw th;
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void loadBdfileImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, webGLImage) == null) {
            V8Engine v8Engine = V8Engine.getInstance();
            if (v8Engine == null) {
                Log.e(TAG, "LoadBdfileImage->v8Engine is null");
            } else {
                runInIOThread(new Runnable(v8Engine, webGLImage.src(), webGLImage, webGLImage.getImageId()) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebGLImage val$image;
                    public final /* synthetic */ int val$imageId;
                    public final /* synthetic */ String val$src;
                    public final /* synthetic */ V8Engine val$v8Engine;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {v8Engine, r7, webGLImage, Integer.valueOf(r9)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$v8Engine = v8Engine;
                        this.val$src = r7;
                        this.val$image = webGLImage;
                        this.val$imageId = r9;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebGLImageLoader.loadImageFromConvertedSource(this.val$image, this.val$imageId, this.val$src, WebGLImageLoader.getRealBdFilePath(this.val$v8Engine, this.val$src));
                        }
                    }
                });
            }
        }
    }

    public static void loadBitmapData(WebGLImage webGLImage, int i, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, webGLImage, i, bitmap) == null) {
            if (bitmap != null && webGLImage.setBitmapData(bitmap)) {
                webGLImage.onLoadSuccess(i);
                return;
            }
            webGLImage.onLoadFailed(i, "load bitmap failed, src is " + webGLImage.src());
        }
    }

    public static void loadCacheImage(WebGLImage webGLImage, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, webGLImage, bitmap) == null) {
            runInIOThread(new Runnable(webGLImage, webGLImage.getImageId(), bitmap) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap val$bitmap;
                public final /* synthetic */ WebGLImage val$image;
                public final /* synthetic */ int val$imageId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {webGLImage, Integer.valueOf(r7), bitmap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$image = webGLImage;
                    this.val$imageId = r7;
                    this.val$bitmap = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WebGLImageLoader.loadBitmapData(this.val$image, this.val$imageId, this.val$bitmap);
                    }
                }
            });
        }
    }

    public static void loadDataImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, webGLImage) == null) {
            runInIOThread(new Runnable(webGLImage.src(), webGLImage, webGLImage.getImageId()) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebGLImage val$image;
                public final /* synthetic */ int val$imageId;
                public final /* synthetic */ String val$rawSrc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, webGLImage, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$rawSrc = r6;
                    this.val$image = webGLImage;
                    this.val$imageId = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = this.val$rawSrc;
                        WebGLImageLoader.loadImageFromConvertedSource(this.val$image, this.val$imageId, this.val$rawSrc, Base64.decode(str.substring(str.indexOf(";base64,") + 8), 0));
                    }
                }
            });
        }
    }

    public static void loadImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, webGLImage) == null) {
            ImageBitmapBean bitmapBean = getBitmapBean(webGLImage);
            if (bitmapBean != null && bitmapBean.getBitmap() != null) {
                loadCacheImage(webGLImage, bitmapBean.getBitmap());
            } else if (webGLImage.src().startsWith("http")) {
                loadNetImage(webGLImage);
            } else if (webGLImage.src().startsWith(BDFILE)) {
                loadBdfileImage(webGLImage);
            } else if (webGLImage.src().startsWith(DATA_URL)) {
                loadDataImage(webGLImage);
            } else {
                loadLocalImage(webGLImage);
            }
        }
    }

    public static void loadImageFromConvertedSource(WebGLImage webGLImage, int i, String str, Object obj) {
        Bitmap decodeStream;
        Bitmap decodeStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65550, null, webGLImage, i, str, obj) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 19) {
                options.inPremultiplied = false;
            }
            ImageBitmapBean imageBitmapBean = null;
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (tg1.b(str2)) {
                    decodeStream = BitmapFactory.decodeFile(str2, options);
                    if (decodeStream == null) {
                        decodeStream = BitmapFactory.decodeFile(str2);
                    }
                }
                decodeStream = null;
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                decodeStream = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                if (decodeStream == null) {
                    decodeStream2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    decodeStream = decodeStream2;
                }
            } else {
                if (obj instanceof InputStream) {
                    InputStream inputStream = (InputStream) obj;
                    decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    if (decodeStream == null) {
                        decodeStream2 = BitmapFactory.decodeStream(inputStream);
                        decodeStream = decodeStream2;
                    }
                }
                decodeStream = null;
            }
            synchronized (BitmapReferenceMap.class) {
                if (decodeStream != null) {
                    try {
                        imageBitmapBean = sReferenceMap.get(str);
                        if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
                            decodeStream.recycle();
                            decodeStream = imageBitmapBean.getBitmap();
                        } else {
                            imageBitmapBean = new ImageBitmapBean(str, decodeStream);
                            sReferenceMap.put(str, imageBitmapBean);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (imageBitmapBean != null) {
                    imageBitmapBean.increaseRefCount();
                }
            }
            loadBitmapData(webGLImage, i, decodeStream);
        }
    }

    public static void loadLocalImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, webGLImage) == null) {
            runInIOThread(new Runnable(webGLImage.basePath(), webGLImage.src(), webGLImage, webGLImage.getImageId()) { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$basePath;
                public final /* synthetic */ WebGLImage val$image;
                public final /* synthetic */ int val$imageId;
                public final /* synthetic */ String val$src;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, r7, webGLImage, Integer.valueOf(r9)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$basePath = r6;
                    this.val$src = r7;
                    this.val$image = webGLImage;
                    this.val$imageId = r9;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WebGLImageLoader.loadImageFromConvertedSource(this.val$image, this.val$imageId, this.val$src, this.val$basePath + this.val$src);
                    }
                }
            });
        }
    }

    public static void loadNetImage(WebGLImage webGLImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, webGLImage) == null) {
            V8Engine v8Engine = V8Engine.getInstance();
            if (v8Engine == null) {
                Log.e(TAG, "loadNetImage->v8Engine is null");
                return;
            }
            V8FileSystemDelegatePolicy fileSystemDelegatePolicy = v8Engine.getFileSystemDelegatePolicy();
            if (fileSystemDelegatePolicy == null) {
                Log.e(TAG, "fileSystemDelegatePolicy is null", new Throwable());
            } else {
                fileSystemDelegatePolicy.loadFileFromUrl(webGLImage.src(), new NetValueCallback(webGLImage));
            }
        }
    }

    public static void recycleBitmap(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            synchronized (BitmapReferenceMap.class) {
                ImageBitmapBean decrease = sReferenceMap.decrease(str);
                if (decrease != null) {
                    decrease.resetIfNoUsed();
                }
            }
        }
    }

    public static void runInIOThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, runnable) == null) {
            initializeIfNeeded();
            sExecutorService.submit(runnable);
        }
    }
}
