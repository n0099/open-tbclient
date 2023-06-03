package com.baidu.android.common.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NetImageView extends BdBaseImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String DEBUG_TAG = "NetImageView";
    public static final int DELAY_REQUEST = 200;
    public static Handler sHandler;
    public static Runnable sRequestAllRemoteDrawablesTask;
    public static ConcurrentHashMap<NetImageView, Object> sRequestQueue;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSyncLoadFromDiskCache;
    public Drawable mDefaultDrawable;
    public int mDefaultHeight;
    public int mDefaultResourceId;
    public int mDefaultWidth;
    public boolean mEnableReleaseWhenDetach;
    public boolean mEnableResize;
    public boolean mHasRequestedRemoteDrawable;
    public String mImageUrl;
    public OnDrawableSizeChangedListener mOnDrawableSizeChangedListener;
    public Drawable mRemoteDrawable;
    public ImageView.ScaleType mScalType;

    /* loaded from: classes.dex */
    public interface OnDrawableSizeChangedListener {
        void onSizeChanged(NetImageView netImageView, boolean z);
    }

    public void onLoadUrlError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void onStartLoadUrl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uri) == null) {
        }
    }

    public void setOnDrawableSizeChangedListener(OnDrawableSizeChangedListener onDrawableSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onDrawableSizeChangedListener) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(867040818, "Lcom/baidu/android/common/loader/NetImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(867040818, "Lcom/baidu/android/common/loader/NetImageView;");
                return;
            }
        }
        sRequestQueue = new ConcurrentHashMap<>();
        sRequestAllRemoteDrawablesTask = new Runnable() { // from class: com.baidu.android.common.loader.NetImageView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Iterator it = NetImageView.sRequestQueue.entrySet().iterator();
                    while (it.hasNext()) {
                        it.remove();
                        NetImageView netImageView = (NetImageView) ((Map.Entry) it.next()).getKey();
                        if (!TextUtils.isEmpty(netImageView.mImageUrl)) {
                            netImageView.loadImage(netImageView.getContext().getApplicationContext(), netImageView.mImageUrl);
                        }
                    }
                }
            }
        };
    }

    private void applyDefaultSize() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, this) != null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        int i = this.mDefaultWidth;
        if (i != Integer.MIN_VALUE) {
            layoutParams.width = i;
        }
        int i2 = this.mDefaultHeight;
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.height = i2;
        }
    }

    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasRemoteDrawableDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mRemoteDrawable != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mEnableReleaseWhenDetach) {
                releaseRemoteDrawable();
            }
            super.onDetachedFromWindow();
        }
    }

    public void releaseRemoteDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mImageUrl = null;
            this.mRemoteDrawable = null;
            callRealSetImageDrawable(this.mDefaultDrawable, false);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            onStartLoadUrl(false);
            onLoadUrlError(false);
            this.mImageUrl = null;
            this.mRemoteDrawable = null;
            this.mHasRequestedRemoteDrawable = false;
            callRealSetImageDrawable(this.mDefaultDrawable, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnableReleaseWhenDetach = true;
        this.isSyncLoadFromDiskCache = false;
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            if (sHandler == null) {
                synchronized (NetImageView.class) {
                    if (sHandler == null) {
                        sHandler = new Handler(context.getMainLooper());
                    }
                }
            }
            if (this.mScalType == null) {
                this.mScalType = ImageView.ScaleType.FIT_CENTER;
            }
            this.mDefaultWidth = Integer.MIN_VALUE;
            this.mDefaultHeight = Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEnableReleaseWhenDetach = true;
        this.isSyncLoadFromDiskCache = false;
        init(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            if (hasRemoteDrawableDone() && this.mEnableResize) {
                int intrinsicWidth = this.mRemoteDrawable.getIntrinsicWidth();
                int intrinsicHeight = this.mRemoteDrawable.getIntrinsicHeight();
                int size = View.MeasureSpec.getSize(i);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (size >= intrinsicWidth) {
                    layoutParams.width = intrinsicWidth;
                    layoutParams.height = intrinsicHeight;
                } else {
                    layoutParams.width = size;
                    layoutParams.height = (int) (((intrinsicHeight / intrinsicWidth) * size) + 0.5f);
                }
                setMeasuredDimension(layoutParams.width, layoutParams.height);
                return;
            }
            super.onMeasure(i, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mEnableReleaseWhenDetach = true;
        this.isSyncLoadFromDiskCache = false;
        init(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (!this.mHasRequestedRemoteDrawable && !hasRemoteDrawableDone()) {
                requestLoadingRemoteImage();
            }
            super.onDraw(canvas);
        }
    }

    public void setEnableResize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mEnableResize = z;
        }
    }

    @Override // com.baidu.searchbox.ui.fontsize.view.FontSizeImageView, android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && i != this.mDefaultResourceId) {
            this.mDefaultResourceId = i;
            if (i != 0) {
                this.mDefaultDrawable = getResources().getDrawable(i);
            } else {
                this.mDefaultDrawable = null;
            }
            super.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            callRealSetImageDrawable(this.mDefaultDrawable, false);
        }
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            setImageUrl(str, true);
        }
    }

    public void setIsSyncLoadFromDiskCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.isSyncLoadFromDiskCache = z;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            applyDefaultSize();
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, drawable, z) == null) {
            if (hasRemoteDrawableDone()) {
                if (this.mEnableResize) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    View view2 = (View) getParent();
                    if (view2.getWidth() > 0) {
                        int intrinsicWidth = this.mRemoteDrawable.getIntrinsicWidth();
                        int intrinsicHeight = this.mRemoteDrawable.getIntrinsicHeight();
                        int width = (view2.getWidth() - view2.getPaddingLeft()) - view2.getPaddingRight();
                        int i = layoutParams.width;
                        int i2 = layoutParams.height;
                        if (width >= intrinsicWidth) {
                            layoutParams.width = intrinsicWidth;
                            layoutParams.height = intrinsicHeight;
                        } else {
                            layoutParams.width = width;
                            layoutParams.height = (int) (((intrinsicHeight / intrinsicWidth) * width) + 0.5f);
                        }
                        if (i == layoutParams.width && i2 == layoutParams.height) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            requestLayout();
                        }
                    }
                }
                super.setImageDrawable(this.mRemoteDrawable);
                return;
            }
            applyDefaultSize();
            super.setImageDrawable(drawable);
            if (z) {
                requestLoadingRemoteImage();
            } else {
                invalidate();
            }
        }
    }

    public void loadImage(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(str), context).subscribe(new BaseBitmapDataSubscriber(this, str) { // from class: com.baidu.android.common.loader.NetImageView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetImageView this$0;
            public final /* synthetic */ String val$url;

            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dataSource) == null) {
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                }
            }

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
                this.val$url = str;
            }

            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                Bitmap copy;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) && bitmap != null && !bitmap.isRecycled() && this.val$url.equals(this.this$0.mImageUrl)) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.this$0.setRemoteDrawable(this.val$url, new BitmapDrawable(this.this$0.getResources(), copy));
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                    }
                }
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    public void setDefaultDrawable(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, drawable) == null) {
            this.mDefaultResourceId = i;
            this.mDefaultDrawable = drawable;
        }
    }

    public void setDefaultSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.mDefaultWidth = i;
            this.mDefaultHeight = i2;
        }
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, bitmap) == null) && this.mRemoteDrawable == null && TextUtils.equals(str, this.mImageUrl)) {
            onStartLoadUrl(false);
            onLoadUrlError(false);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.mRemoteDrawable = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
        }
    }

    public void requestLoadingRemoteImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (hasRemoteDrawableDone()) {
                callRealSetImageDrawable(this.mRemoteDrawable, false);
            } else if (!this.mHasRequestedRemoteDrawable && !TextUtils.isEmpty(this.mImageUrl)) {
                sHandler.removeCallbacks(sRequestAllRemoteDrawablesTask);
                sRequestQueue.put(this, "");
                sHandler.postDelayed(sRequestAllRemoteDrawablesTask, 200L);
                this.mHasRequestedRemoteDrawable = true;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00fc -> B:77:0x0103). Please submit an issue!!! */
    public void setImageUrl(String str, boolean z) {
        Bitmap underlyingBitmap;
        Bitmap underlyingBitmap2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) && !TextUtils.equals(this.mImageUrl, str)) {
            onStartLoadUrl(false);
            onLoadUrlError(false);
            this.mImageUrl = str;
            Bitmap bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            CloseableReference<CloseableImage> closeableReference = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            CloseableReference<CloseableImage> closeableReference2 = null;
            bitmap = null;
            bitmap = null;
            this.mRemoteDrawable = null;
            this.mHasRequestedRemoteDrawable = false;
            if (!TextUtils.isEmpty(str)) {
                if (Fresco.getImagePipeline().isInBitmapMemoryCache(Uri.parse(str))) {
                    DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache = Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(str), getContext());
                    try {
                        CloseableReference<CloseableImage> result = fetchImageFromBitmapCache.getResult();
                        if (result != null) {
                            try {
                                CloseableImage closeableImage = result.get();
                                if (closeableImage != null && (closeableImage instanceof CloseableBitmap) && (underlyingBitmap2 = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null && !underlyingBitmap2.isRecycled()) {
                                    try {
                                        if (underlyingBitmap2.getConfig() == null) {
                                            bitmap = underlyingBitmap2.copy(Bitmap.Config.ARGB_8888, true);
                                        } else {
                                            bitmap = underlyingBitmap2.copy(underlyingBitmap2.getConfig(), true);
                                        }
                                    } catch (OutOfMemoryError unused) {
                                        System.gc();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                closeableReference = result;
                                fetchImageFromBitmapCache.close();
                                CloseableReference.closeSafely(closeableReference);
                                throw th;
                            }
                        }
                        fetchImageFromBitmapCache.close();
                        CloseableReference.closeSafely(result);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else if (this.isSyncLoadFromDiskCache) {
                    DataSource<Boolean> isInDiskCache = Fresco.getImagePipeline().isInDiskCache(Uri.parse(str));
                    try {
                        if (isInDiskCache.hasResult() && isInDiskCache.getResult().booleanValue()) {
                            DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(Uri.parse(str)), getContext());
                            try {
                                CloseableReference<CloseableImage> result2 = fetchDecodedImage.getResult();
                                if (result2 != null) {
                                    try {
                                        CloseableImage closeableImage2 = result2.get();
                                        if (closeableImage2 != null && (closeableImage2 instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage2).getUnderlyingBitmap()) != null && !underlyingBitmap.isRecycled()) {
                                            try {
                                                bitmap = underlyingBitmap.getConfig() == null ? underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true) : underlyingBitmap.copy(underlyingBitmap.getConfig(), true);
                                            } catch (OutOfMemoryError unused2) {
                                                System.gc();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        closeableReference2 = result2;
                                        fetchDecodedImage.close();
                                        CloseableReference.closeSafely(closeableReference2);
                                        throw th;
                                    }
                                }
                                fetchDecodedImage.close();
                                CloseableReference.closeSafely(result2);
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } finally {
                        isInDiskCache.close();
                    }
                }
                if (bitmap != null) {
                    setRemoteDrawable(this.mImageUrl, bitmap);
                    return;
                }
            }
            callRealSetImageDrawable(this.mDefaultDrawable, z);
        }
    }

    public void setRemoteDrawable(String str, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, str, drawable) == null) && this.mRemoteDrawable == null && TextUtils.equals(str, this.mImageUrl)) {
            onStartLoadUrl(false);
            onLoadUrlError(false);
            this.mRemoteDrawable = drawable;
            callRealSetImageDrawable(drawable, false);
        }
    }
}
