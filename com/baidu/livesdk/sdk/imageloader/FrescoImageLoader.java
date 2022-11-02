package com.baidu.livesdk.sdk.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.imageloader.ImageCache;
import com.baidu.livesdk.api.imageloader.ImageLoadListener;
import com.baidu.livesdk.api.imageloader.ImageLoader;
import com.baidu.livesdk.api.imageloader.ImageProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class FrescoImageLoader implements ImageLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "FrescoImageLoader";
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService mExecutors;
    public boolean mRelease;

    public FrescoImageLoader() {
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
        this.mExecutors = Executors.newFixedThreadPool(5);
        this.mRelease = false;
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mRelease = true;
            ExecutorService executorService = this.mExecutors;
            if (executorService != null) {
                executorService.shutdown();
                this.mExecutors = null;
            }
        }
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(String str, ImageView imageView, ImageLoadListener imageLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, imageView, imageLoadListener) == null) {
            loadImage(str, imageView, 0, 0, imageLoadListener, null);
        }
    }

    private CacheKey getCacheKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            return DefaultCacheKeyFactory.getInstance().getBitmapCacheKey(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build(), null);
        }
        return (CacheKey) invokeL.objValue;
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public boolean hasCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            FileBinaryResource fileBinaryResource = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(getCacheKey(str));
            if (fileBinaryResource != null && fileBinaryResource.getFile() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(Bitmap bitmap, ImageProcessor imageProcessor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bitmap, imageProcessor) == null) {
            ImageCache process = imageProcessor.process(bitmap);
            Fresco.getImagePipelineFactory().getMainFileCache().insert(getCacheKey(process.key), new WriterCallback(this, process) { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrescoImageLoader this$0;
                public final /* synthetic */ ImageCache val$cache;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, process};
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
                    this.val$cache = process;
                }

                @Override // com.facebook.cache.common.WriterCallback
                public void write(OutputStream outputStream) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, outputStream) == null) {
                        this.val$cache.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        outputStream.flush();
                    }
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, imageView) == null) {
            loadImage(str, imageView, 0, 0, null, null);
        }
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public Bitmap getBitmapFromCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            FileBinaryResource fileBinaryResource = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(getCacheKey(str));
            if (fileBinaryResource != null && fileBinaryResource.getFile() != null) {
                return BitmapFactory.decodeFile(fileBinaryResource.getFile().getAbsolutePath());
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(String str, ImageView imageView, int i, int i2, ImageLoadListener imageLoadListener, ImageProcessor imageProcessor) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{str, imageView, Integer.valueOf(i), Integer.valueOf(i2), imageLoadListener, imageProcessor}) != null) || this.mRelease) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (imageLoadListener != null) {
                imageLoadListener.onLoadingFail(str);
            }
            if (imageView != null && i2 > 0) {
                imageView.setImageResource(i2);
            }
        } else if (imageView instanceof SimpleDraweeView) {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;
            GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
            hierarchy.setFailureImage(i2);
            hierarchy.setPlaceholderImage(i);
            simpleDraweeView.setImageURI(Uri.parse(str));
        } else {
            if (imageView != null && i > 0) {
                imageView.setImageResource(i);
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build(), this).subscribe(new BaseBitmapDataSubscriber(this, imageProcessor, imageLoadListener, str, imageView, i2) { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrescoImageLoader this$0;
                public final /* synthetic */ int val$failureImage;
                public final /* synthetic */ ImageView val$imageView;
                public final /* synthetic */ ImageProcessor val$intercept;
                public final /* synthetic */ ImageLoadListener val$listener;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageProcessor, imageLoadListener, str, imageView, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$intercept = imageProcessor;
                    this.val$listener = imageLoadListener;
                    this.val$url = str;
                    this.val$imageView = imageView;
                    this.val$failureImage = i2;
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dataSource) == null) {
                        ImageLoadListener imageLoadListener2 = this.val$listener;
                        if (imageLoadListener2 != null) {
                            imageLoadListener2.onLoadingFail(this.val$url);
                        }
                        ImageView imageView2 = this.val$imageView;
                        if (imageView2 != null && this.val$failureImage > 0) {
                            imageView2.post(new Runnable(this) { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.3
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
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.this$1;
                                        anonymousClass1.val$imageView.setImageResource(anonymousClass1.val$failureImage);
                                    }
                                }
                            });
                        }
                    }
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            ImageProcessor imageProcessor2 = this.val$intercept;
                            if (imageProcessor2 != null) {
                                try {
                                    this.this$0.process(bitmap, imageProcessor2);
                                } catch (IOException unused) {
                                }
                            }
                            ImageLoadListener imageLoadListener2 = this.val$listener;
                            if (imageLoadListener2 != null) {
                                imageLoadListener2.onLoadingComplete(this.val$url, bitmap);
                            }
                            ImageView imageView2 = this.val$imageView;
                            if (imageView2 != null) {
                                imageView2.post(new Runnable(this, bitmap) { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;
                                    public final /* synthetic */ Bitmap val$bitmap;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, bitmap};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$bitmap = bitmap;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.this$1.val$imageView.setImageBitmap(this.val$bitmap);
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        ImageLoadListener imageLoadListener3 = this.val$listener;
                        if (imageLoadListener3 != null) {
                            imageLoadListener3.onLoadingFail(this.val$url);
                        }
                        ImageView imageView3 = this.val$imageView;
                        if (imageView3 != null && this.val$failureImage > 0) {
                            imageView3.post(new Runnable(this) { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.2
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
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.this$1;
                                        anonymousClass1.val$imageView.setImageResource(anonymousClass1.val$failureImage);
                                    }
                                }
                            });
                        }
                    }
                }
            }, this.mExecutors);
        }
    }
}
