package com.baidu.cloudsdk.common.imgloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
/* loaded from: classes.dex */
public class ImageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_HIT_COUNT_REQUIRED = 1;
    public static final int DEFAULT_MAX_MEMCACHE_SIZE = 20;
    public static ImageManager sImageManager;
    public transient /* synthetic */ FieldHolder $fh;
    public FSBitmapCache mFSCache;
    public int mMaxNumOfPixels;
    public MemoryBitmapCache mMemCache;

    public ImageManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxNumOfPixels = 19656;
        this.mMemCache = new MemoryBitmapCache(20);
        try {
            this.mFSCache = new FSBitmapCache(Environment.getExternalStorageDirectory().getPath() + "/baidu/.imagecache/", 1, this.mMaxNumOfPixels, this.mMemCache);
        } catch (Exception e) {
            Log.e("ImageManager", e.getMessage());
        }
    }

    public static void clean() {
        ImageManager imageManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (imageManager = sImageManager) == null) {
            return;
        }
        imageManager.mMemCache.clean();
        sImageManager = null;
    }

    public static ImageManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (sImageManager == null) {
                sImageManager = new ImageManager();
            }
            return sImageManager;
        }
        return (ImageManager) invokeV.objValue;
    }

    public void addCache(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
            sImageManager.mMemCache.put(str, bitmap);
            sImageManager.mFSCache.put(str, bitmap);
        }
    }

    public String getCachedFilePath(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            Validator.notNull(uri, "uri");
            return this.mFSCache.getFilePath(Utils.md5(uri.toString()));
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(3)
    public void loadImage(Context context, Uri uri, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, uri, iAsyncImageLoaderListener) == null) {
            Validator.notNull(context, "context");
            Validator.notNull(uri, "uri");
            Validator.notNull(iAsyncImageLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            String md5 = Utils.md5(uri.toString());
            Bitmap bitmap = this.mMemCache.get(md5);
            if (bitmap != null) {
                iAsyncImageLoaderListener.onComplete(bitmap);
            } else if (Utils.isUrl(uri)) {
                new AsyncTask<String, Integer, Bitmap>(this, md5, iAsyncImageLoaderListener, context, uri) { // from class: com.baidu.cloudsdk.common.imgloader.ImageManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImageManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener val$listener;
                    public final /* synthetic */ Uri val$uri;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, md5, iAsyncImageLoaderListener, context, uri};
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
                        this.val$key = md5;
                        this.val$listener = iAsyncImageLoaderListener;
                        this.val$context = context;
                        this.val$uri = uri;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.AsyncTask
                    public Bitmap doInBackground(String... strArr) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, strArr)) == null) ? this.this$0.mFSCache.get(this.val$key) : (Bitmap) invokeL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Bitmap bitmap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap2) == null) {
                            super.onPostExecute((AnonymousClass1) bitmap2);
                            if (bitmap2 != null) {
                                this.val$listener.onComplete(bitmap2);
                            } else {
                                new AsyncImageLoader(this.val$context, this.this$0.mMaxNumOfPixels, new AsyncImageLoader.IAsyncImageLoaderListener(this) { // from class: com.baidu.cloudsdk.common.imgloader.ImageManager.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
                                    public void onComplete(Bitmap bitmap3) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, bitmap3) == null) {
                                            if (bitmap3 != null) {
                                                if (Utils.isUrl(this.this$1.val$uri)) {
                                                    this.this$1.this$0.mFSCache.put(this.this$1.val$key, bitmap3);
                                                } else {
                                                    this.this$1.this$0.mMemCache.put(this.this$1.val$key, bitmap3);
                                                }
                                            }
                                            this.this$1.val$listener.onComplete(bitmap3);
                                        }
                                    }
                                }).execute(this.val$uri);
                            }
                        }
                    }
                }.execute(new String[0]);
            } else {
                new AsyncImageLoader(context, this.mMaxNumOfPixels, new AsyncImageLoader.IAsyncImageLoaderListener(this, uri, md5, iAsyncImageLoaderListener) { // from class: com.baidu.cloudsdk.common.imgloader.ImageManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImageManager this$0;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener val$listener;
                    public final /* synthetic */ Uri val$uri;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, uri, md5, iAsyncImageLoaderListener};
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
                        this.val$uri = uri;
                        this.val$key = md5;
                        this.val$listener = iAsyncImageLoaderListener;
                    }

                    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
                    public void onComplete(Bitmap bitmap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap2) == null) {
                            if (bitmap2 != null) {
                                if (Utils.isUrl(this.val$uri)) {
                                    this.this$0.mFSCache.put(this.val$key, bitmap2);
                                } else {
                                    this.this$0.mMemCache.put(this.val$key, bitmap2);
                                }
                            }
                            this.val$listener.onComplete(bitmap2);
                        }
                    }
                }).execute(uri);
            }
        }
    }

    public ImageManager setHitCountRequired(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.mFSCache.setHitCountRequired(i);
            return this;
        }
        return (ImageManager) invokeI.objValue;
    }

    public ImageManager setMaxMemCacheSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.mMemCache.setMaxSize(i);
            return this;
        }
        return (ImageManager) invokeI.objValue;
    }

    public ImageManager setMaxNumOfPixels(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.mMaxNumOfPixels = i;
            this.mFSCache.setMaxNumOfPixels(i);
            return this;
        }
        return (ImageManager) invokeI.objValue;
    }

    public ImageManager setMemCacheEvictPolicy(MemoryBitmapCache.IEvictPolicy iEvictPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iEvictPolicy)) == null) {
            this.mMemCache.setEvictPolicy(iEvictPolicy);
            return this;
        }
        return (ImageManager) invokeL.objValue;
    }

    public ImageManager setStorageDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.mFSCache.setStorageDir(str);
            return this;
        }
        return (ImageManager) invokeL.objValue;
    }
}
