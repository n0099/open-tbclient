package com.baidu.mobads.container.util.filedownloader;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class MaterialLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IMAGE_CACHE_PATH = "img_download/";
    public static final String KEY_OF_CACHING_RESULT = "caching_result";
    public static final String KEY_OF_DL_TIME_CONSUME = "caching_time_consume";
    public static final String KEY_OF_LOCAL_CREATIVE_URL = "local_creative_url";
    public static final int MAX_IMAGE_HEIGHT = 1140;
    public static final int MAX_IMAGE_SIZE = 2457600;
    public static final int MAX_IMAGE_WIDTH = 1140;
    public static final int MAX_RATIO = 6;
    public static final String TAG = "MaterialLoader";
    public static final String VIDEO_CACHE_PATH = "video_download/";
    public static volatile MaterialLoader mSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public MaterialLoadingListener emptyListener;
    public Context mContext;

    /* loaded from: classes5.dex */
    public static class FlushedInputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FlushedInputStream(InputStream inputStream) {
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1638075889, "Lcom/baidu/mobads/container/util/filedownloader/MaterialLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1638075889, "Lcom/baidu/mobads/container/util/filedownloader/MaterialLoader;");
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
        this.emptyListener = new MaterialLoadingListener(this) { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MaterialLoader this$0;

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
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view, bitmap) == null) {
                }
            }

            @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
            public void onLoadingFailed(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, materialLoadErrorCode) == null) {
                }
            }

            @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
            public void onLoadingStarted(String str, View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
                }
            }
        };
        this.mContext = context.getApplicationContext();
    }

    private void downloadMaterial(String str, ImageView imageView, MaterialLoadingListener materialLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, str, imageView, materialLoadingListener) == null) {
            OAdURLConnection oAdURLConnection = new OAdURLConnection(1, str);
            oAdURLConnection.addImageRequestListener(new OAdURLConnection.OnImageRequestListener(this, str, materialLoadingListener, imageView) { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialLoader this$0;
                public final /* synthetic */ ImageView val$imageView;
                public final /* synthetic */ MaterialLoadingListener val$listener;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, materialLoadingListener, imageView};
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
                    this.val$listener = materialLoadingListener;
                    this.val$imageView = imageView;
                }

                @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnImageRequestListener
                public void onFail(String str2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str2, i2) == null) {
                        String unused = MaterialLoader.TAG;
                        String str3 = "素材请求失败，onFail: " + str2;
                        this.val$listener.onLoadingFailed(this.val$url, this.val$imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                    }
                }

                @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnImageRequestListener
                public void onSuccess(InputStream inputStream, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, str2) == null) {
                        try {
                            if (inputStream != null) {
                                if (this.val$url.indexOf(".mp4") <= 0 && this.val$url.indexOf(".gif") <= 0) {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inPurgeable = true;
                                    options.inInputShareable = true;
                                    Bitmap decodeStream = BitmapFactory.decodeStream(new FlushedInputStream(inputStream), null, options);
                                    if (decodeStream != null) {
                                        Bitmap pixelCompress = !this.val$url.substring(this.val$url.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.pixelCompress(MaterialLoader.qualityCompress(decodeStream, 100 - (this.this$0.qualityCompressionRatio(decodeStream) * 10)), MaterialLoader.sizeCompressRatio(options)) : decodeStream;
                                        if (pixelCompress != null) {
                                            decodeStream = pixelCompress;
                                        }
                                        if (Looper.myLooper() == Looper.getMainLooper()) {
                                            if (this.val$imageView != null) {
                                                this.val$imageView.setImageBitmap(decodeStream);
                                                this.val$imageView.setBackgroundResource(17170445);
                                                this.val$imageView.setVisibility(0);
                                            }
                                        } else {
                                            new Handler(Looper.getMainLooper()).post(new Runnable(this, decodeStream) { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3.2
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass3 this$1;
                                                public final /* synthetic */ Bitmap val$finalBitmap;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this, decodeStream};
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
                                                    this.val$finalBitmap = decodeStream;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    ImageView imageView2;
                                                    Interceptable interceptable3 = $ic;
                                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (imageView2 = this.this$1.val$imageView) == null) {
                                                        return;
                                                    }
                                                    imageView2.setImageBitmap(this.val$finalBitmap);
                                                    this.this$1.val$imageView.setBackgroundResource(17170445);
                                                    this.this$1.val$imageView.setVisibility(0);
                                                }
                                            });
                                        }
                                        this.this$0.storeImageData(decodeStream, this.val$url);
                                        this.val$listener.onLoadingComplete(this.val$url, this.val$imageView, decodeStream);
                                        inputStream.close();
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
                                    this.this$0.storeData(byteArrayOutputStream.toByteArray(), this.val$url, new CacheEngine.CacheListener(this) { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
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
                                        }

                                        @Override // com.baidu.mobads.container.util.cache.CacheEngine.CacheListener
                                        public void onCacheComplete() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                AnonymousClass3 anonymousClass3 = this.this$1;
                                                anonymousClass3.val$listener.onLoadingComplete(anonymousClass3.val$url, null, null);
                                            }
                                        }

                                        @Override // com.baidu.mobads.container.util.cache.CacheEngine.CacheListener
                                        public void onCacheFailed() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                AnonymousClass3 anonymousClass3 = this.this$1;
                                                anonymousClass3.val$listener.onLoadingFailed(anonymousClass3.val$url, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                                            }
                                        }
                                    });
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
                            String unused = MaterialLoader.TAG;
                            this.val$listener.onLoadingFailed(this.val$url, this.val$imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                        } catch (OutOfMemoryError unused2) {
                            String unused3 = MaterialLoader.TAG;
                            this.val$listener.onLoadingFailed(this.val$url, this.val$imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                        } catch (Throwable unused4) {
                            String unused5 = MaterialLoader.TAG;
                            this.val$listener.onLoadingFailed(this.val$url, this.val$imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                        }
                    }
                }
            });
            oAdURLConnection.asynLoad();
        }
    }

    public static int getBitmapSize(Bitmap bitmap) {
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

    public static MaterialLoader getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (mSingleton == null) {
                synchronized (MaterialLoader.class) {
                    if (mSingleton == null) {
                        mSingleton = new MaterialLoader(context);
                    }
                }
            }
            return mSingleton;
        }
        return (MaterialLoader) invokeL.objValue;
    }

    public static Bitmap pixelCompress(Bitmap bitmap, int i2) {
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

    public static Bitmap qualityCompress(Bitmap bitmap, int i2) {
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

    private Bitmap retrieveDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) ? CacheEngine.getInstance(this.mContext).retrieveBitmapForKey(str) : (Bitmap) invokeL.objValue;
    }

    public static int sizeCompressRatio(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, options)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void storeData(byte[] bArr, String str, CacheEngine.CacheListener cacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, this, bArr, str, cacheListener) == null) {
            CacheEngine.getInstance(this.mContext).storeData(str, bArr, false, cacheListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeImageData(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, bitmap, str) == null) {
            CacheEngine.getInstance(this.mContext).storeBitmap(str, bitmap);
        }
    }

    public void cacheMaterialForURLString(String str, MaterialLoadingListener materialLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, materialLoadingListener) == null) {
            if (materialLoadingListener == null) {
                materialLoadingListener = this.emptyListener;
            }
            if (isCachedDataExistsForKey(str).booleanValue()) {
                materialLoadingListener.onLoadingComplete(str, null, retrieveDataForKey(str));
            } else {
                downloadMaterial(str, null, materialLoadingListener);
            }
        }
    }

    public Bitmap getBitmapFromURLString(String str, MaterialLoadingListener materialLoadingListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, materialLoadingListener)) == null) {
            if (materialLoadingListener == null) {
                materialLoadingListener = this.emptyListener;
            }
            if (isCachedDataExistsForKey(str).booleanValue()) {
                return retrieveDataForKey(str);
            }
            downloadMaterial(str, null, materialLoadingListener);
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public String getMaterialFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? CacheEngine.getInstance(this.mContext).getFilePath(str) : (String) invokeL.objValue;
    }

    public Boolean isCachedDataExistsForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? Boolean.valueOf(CacheEngine.getInstance(this.mContext).isDataExistsForKey(str)) : (Boolean) invokeL.objValue;
    }

    public void loadImageForURLString(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, imageView, str) == null) {
            loadImageForURLString(imageView, str, this.emptyListener);
        }
    }

    public int qualityCompressionRatio(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            int bitmapSize = getBitmapSize(bitmap);
            if (bitmapSize > 2457600) {
                int i2 = bitmapSize / MAX_IMAGE_SIZE;
                if (i2 > 6) {
                    return 6;
                }
                return i2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void loadImageForURLString(ImageView imageView, String str, MaterialLoadingListener materialLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, imageView, str, materialLoadingListener) == null) {
            if (materialLoadingListener == null) {
                try {
                    materialLoadingListener = this.emptyListener;
                } catch (Throwable unused) {
                    materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_PARSE_ERROR);
                    return;
                }
            }
            materialLoadingListener.onLoadingStarted(str, imageView);
            if (TextUtils.isEmpty(str)) {
                materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_URL_NULL);
            } else if (imageView == null) {
                materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_VIEW_NULL);
            } else {
                Bitmap retrieveDataForKey = retrieveDataForKey(str);
                if (retrieveDataForKey == null) {
                    downloadMaterial(str, imageView, materialLoadingListener);
                    return;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    imageView.setImageBitmap(retrieveDataForKey);
                    imageView.setBackgroundResource(17170445);
                    imageView.setVisibility(0);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, imageView, retrieveDataForKey) { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MaterialLoader this$0;
                        public final /* synthetic */ Bitmap val$finalBitmap;
                        public final /* synthetic */ ImageView val$imageView;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, imageView, retrieveDataForKey};
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
                            this.val$imageView = imageView;
                            this.val$finalBitmap = retrieveDataForKey;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$imageView.setImageBitmap(this.val$finalBitmap);
                                this.val$imageView.setBackgroundResource(17170445);
                                this.val$imageView.setVisibility(0);
                            }
                        }
                    });
                }
                materialLoadingListener.onLoadingComplete(str, imageView, retrieveDataForKey);
            }
        }
    }
}
