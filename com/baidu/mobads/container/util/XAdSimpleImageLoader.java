package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class XAdSimpleImageLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XAdSimpleImageLoader";
    public static final String TEMP_SUFFIX = ".temp";
    public static XAdSimpleImageLoader sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public LruCache<String, Bitmap> mCache;

    /* loaded from: classes2.dex */
    public static class ImageSize {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public int width;

        public ImageSize() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public XAdSimpleImageLoader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppContext = context.getApplicationContext();
        this.mCache = new LruCache<String, Bitmap>(this, ((int) Runtime.getRuntime().maxMemory()) / 32) { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XAdSimpleImageLoader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                    if (bitmap == null) {
                        return 0;
                    }
                    return bitmap.getByteCount();
                }
                return invokeLL.intValue;
            }
        };
    }

    public static int caculateInSampleSize(BitmapFactory.Options options, ImageView imageView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, options, imageView)) == null) {
            ImageSize generateImageViewSize = generateImageViewSize(imageView);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 > generateImageViewSize.width || i3 > generateImageViewSize.height) {
                return Math.max(Math.round((i2 * 1.0f) / generateImageViewSize.width), Math.round((i3 * 1.0f) / generateImageViewSize.height));
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    public static String fileFolder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? SdcardUtils.getStoragePath(context.getApplicationContext()) : (String) invokeL.objValue;
    }

    public static String fileLocation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            String storagePath = SdcardUtils.getStoragePath(context.getApplicationContext());
            String md5 = EncryptUtils.getMD5(str);
            return storagePath + md5 + TEMP_SUFFIX;
        }
        return (String) invokeLL.objValue;
    }

    public static String fileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? EncryptUtils.getMD5(str) : (String) invokeL.objValue;
    }

    public static ImageSize generateImageViewSize(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, imageView)) == null) {
            ImageSize imageSize = new ImageSize();
            DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int width = imageView.getWidth();
            if (width <= 0) {
                width = layoutParams.width;
            }
            if (width <= 0) {
                width = imageView.getMaxWidth();
            }
            if (width <= 0) {
                width = displayMetrics.widthPixels;
            }
            int height = imageView.getHeight();
            if (height <= 0) {
                height = layoutParams.height;
            }
            if (height <= 0) {
                height = imageView.getMaxHeight();
            }
            if (height <= 0) {
                height = displayMetrics.heightPixels;
            }
            imageSize.width = width;
            imageSize.height = height;
            return imageSize;
        }
        return (ImageSize) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertToLruCache(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, str, bitmap) == null) || this.mCache.get(str) != null || str == null || bitmap == null) {
            return;
        }
        this.mCache.put(str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap loadImageFromFile(String str, ImageView imageView, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, this, str, imageView, z)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            generateImageViewSize(imageView);
            options.inSampleSize = caculateInSampleSize(options, imageView);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (z) {
                imageView.setImageBitmap(decodeFile);
            }
            return decodeFile;
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    private void loadImageFromNet(String str, Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, str, observer) == null) {
            try {
                URL url = new URL(str);
                OAdRemoteDownloadManager oAdRemoteDownloadManager = OAdRemoteDownloadManager.getInstance(this.mAppContext);
                String fileFolder = fileFolder(this.mAppContext);
                IDownloader createSimpleFileDownloader = oAdRemoteDownloadManager.createSimpleFileDownloader(url, fileFolder, fileName(str) + TEMP_SUFFIX, true);
                createSimpleFileDownloader.addObserver(observer);
                createSimpleFileDownloader.start();
            } catch (MalformedURLException unused) {
            }
        }
    }

    public static XAdSimpleImageLoader obtain(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (sInstance == null) {
                synchronized (XAdSimpleImageLoader.class) {
                    if (sInstance == null) {
                        sInstance = new XAdSimpleImageLoader(context);
                    }
                }
            }
            return sInstance;
        }
        return (XAdSimpleImageLoader) invokeL.objValue;
    }

    public boolean isNeedCacheFromNet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || this.mCache.get(str) != null) {
                return false;
            }
            Bitmap loadImageFromFile = loadImageFromFile(fileLocation(this.mAppContext, str));
            if (loadImageFromFile == null) {
                return true;
            }
            insertToLruCache(str, loadImageFromFile);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void load(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalThreadStateException("please invoke in main thread!");
            }
            if (imageView == null || str == null) {
                return;
            }
            Bitmap bitmap = this.mCache.get(str);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap loadImageFromFile = loadImageFromFile(fileLocation(this.mAppContext, str), imageView, true);
            if (loadImageFromFile != null) {
                insertToLruCache(str, loadImageFromFile);
            } else {
                loadImageFromNet(str, new Observer(this, str, imageView) { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XAdSimpleImageLoader this$0;
                    public final /* synthetic */ ImageView val$iv;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, imageView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$url = str;
                        this.val$iv = imageView;
                    }

                    @Override // java.util.Observer
                    public void update(Observable observable, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, observable, obj) == null) && ((IDownloader) observable).getState() == IDownloader.DownloadStatus.COMPLETED) {
                            XAdSimpleImageLoader xAdSimpleImageLoader = this.this$0;
                            Bitmap loadImageFromFile2 = xAdSimpleImageLoader.loadImageFromFile(XAdSimpleImageLoader.fileLocation(xAdSimpleImageLoader.mAppContext, this.val$url), this.val$iv, false);
                            if (loadImageFromFile2 != null) {
                                ActivityUtils.runOnUiThread(new Runnable(this, loadImageFromFile2) { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;
                                    public final /* synthetic */ Bitmap val$bitmapFromNet;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, loadImageFromFile2};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$bitmapFromNet = loadImageFromFile2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.this$1.val$iv.setImageBitmap(this.val$bitmapFromNet);
                                        }
                                    }
                                });
                                this.this$0.insertToLruCache(this.val$url, loadImageFromFile2);
                            }
                        }
                    }
                });
            }
        }
    }

    public void load(String str, Observer observer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, observer) == null) || str == null || observer == null) {
            return;
        }
        try {
            loadImageFromNet(str, observer);
        } catch (Throwable unused) {
        }
    }

    private Bitmap loadImageFromFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeL.objValue;
    }
}
