package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public int alpha;
    public final LottieValueAnimator animator;
    public final Set<ColorFilterData> colorFilterData;
    public LottieComposition composition;
    @Nullable
    public CompositionLayer compositionLayer;
    public boolean enableMergePaths;
    @Nullable
    public FontAssetDelegate fontAssetDelegate;
    @Nullable
    public FontAssetManager fontAssetManager;
    @Nullable
    public ImageAssetDelegate imageAssetDelegate;
    @Nullable
    public ImageAssetManager imageAssetManager;
    @Nullable
    public String imageAssetsFolder;
    public boolean isApplyingOpacityToLayersEnabled;
    public boolean isDirty;
    public boolean isExtraScaleEnabled;
    public final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    public final Matrix matrix;
    public boolean performanceTrackingEnabled;
    public final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    public boolean safeMode;
    public float scale;
    @Nullable
    public ImageView.ScaleType scaleType;
    public boolean systemAnimationsEnabled;
    @Nullable
    public TextDelegate textDelegate;

    /* loaded from: classes4.dex */
    public static class ColorFilterData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final ColorFilter colorFilter;
        @Nullable
        public final String contentName;
        public final String layerName;

        public ColorFilterData(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, colorFilter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.layerName = str;
            this.contentName = str2;
            this.colorFilter = colorFilter;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ColorFilterData) {
                    ColorFilterData colorFilterData = (ColorFilterData) obj;
                    return hashCode() == colorFilterData.hashCode() && this.colorFilter == colorFilterData.colorFilter;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.layerName;
                int hashCode = str != null ? 527 * str.hashCode() : 17;
                String str2 = this.contentName;
                return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface RepeatMode {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-914661769, "Lcom/airbnb/lottie/LottieDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-914661769, "Lcom/airbnb/lottie/LottieDrawable;");
                return;
            }
        }
        TAG = LottieDrawable.class.getSimpleName();
    }

    public LottieDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.matrix = new Matrix();
        this.animator = new LottieValueAnimator();
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.safeMode = false;
        this.colorFilterData = new HashSet();
        this.lazyCompositionTasks = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.airbnb.lottie.LottieDrawable.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieDrawable this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) || this.this$0.compositionLayer == null) {
                    return;
                }
                this.this$0.compositionLayer.setProgress(this.this$0.animator.getAnimatedValueAbsolute());
            }
        };
        this.progressUpdateListener = animatorUpdateListener;
        this.alpha = 255;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    private void buildCompositionLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
        }
    }

    private void drawInternal(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, canvas) == null) {
            if (ImageView.ScaleType.FIT_XY == this.scaleType) {
                drawWithNewAspectRatio(canvas);
            } else {
                drawWithOriginalAspectRatio(canvas);
            }
        }
    }

    private void drawWithNewAspectRatio(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, canvas) == null) || this.compositionLayer == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = bounds.width() / this.composition.getBounds().width();
        float height = bounds.height() / this.composition.getBounds().height();
        if (this.isExtraScaleEnabled) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.matrix.reset();
        this.matrix.preScale(width, height);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, canvas) == null) || this.compositionLayer == null) {
            return;
        }
        float f3 = this.scale;
        float maxScale = getMaxScale(canvas);
        if (f3 > maxScale) {
            f2 = this.scale / maxScale;
        } else {
            maxScale = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.composition.getBounds().width() / 2.0f;
            float height = this.composition.getBounds().height() / 2.0f;
            float f4 = width * maxScale;
            float f5 = height * maxScale;
            canvas.translate((getScale() * width) - f4, (getScale() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.matrix.reset();
        this.matrix.preScale(maxScale, maxScale);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    @Nullable
    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Drawable.Callback callback = getCallback();
            if (callback != null && (callback instanceof View)) {
                return ((View) callback).getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    private FontAssetManager getFontAssetManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (getCallback() == null) {
                return null;
            }
            if (this.fontAssetManager == null) {
                this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
            }
            return this.fontAssetManager;
        }
        return (FontAssetManager) invokeV.objValue;
    }

    private ImageAssetManager getImageAssetManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (getCallback() == null) {
                return null;
            }
            ImageAssetManager imageAssetManager = this.imageAssetManager;
            if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
                this.imageAssetManager = null;
            }
            if (this.imageAssetManager == null) {
                this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
            }
            return this.imageAssetManager;
        }
        return (ImageAssetManager) invokeV.objValue;
    }

    private float getMaxScale(@NonNull Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, canvas)) == null) ? Math.min(canvas.getWidth() / this.composition.getBounds().width(), canvas.getHeight() / this.composition.getBounds().height()) : invokeL.floatValue;
    }

    private void updateBounds() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.composition == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.composition.getBounds().width() * scale), (int) (this.composition.getBounds().height() * scale));
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.animator.addListener(animatorListener);
        }
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorUpdateListener) == null) {
            this.animator.addUpdateListener(animatorUpdateListener);
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, keyPath, t, lottieValueCallback) == null) {
            CompositionLayer compositionLayer = this.compositionLayer;
            if (compositionLayer == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, keyPath, t, lottieValueCallback) { // from class: com.airbnb.lottie.LottieDrawable.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ LottieValueCallback val$callback;
                    public final /* synthetic */ KeyPath val$keyPath;
                    public final /* synthetic */ Object val$property;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, keyPath, t, lottieValueCallback};
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
                        this.val$keyPath = keyPath;
                        this.val$property = t;
                        this.val$callback = lottieValueCallback;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.addValueCallback(this.val$keyPath, (KeyPath) this.val$property, (LottieValueCallback<KeyPath>) this.val$callback);
                        }
                    }
                });
                return;
            }
            boolean z = true;
            if (keyPath == KeyPath.COMPOSITION) {
                compositionLayer.addValueCallback(t, lottieValueCallback);
            } else if (keyPath.getResolvedElement() != null) {
                keyPath.getResolvedElement().addValueCallback(t, lottieValueCallback);
            } else {
                List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
                for (int i2 = 0; i2 < resolveKeyPath.size(); i2++) {
                    resolveKeyPath.get(i2).getResolvedElement().addValueCallback(t, lottieValueCallback);
                }
                z = true ^ resolveKeyPath.isEmpty();
            }
            if (z) {
                invalidateSelf();
                if (t == LottieProperty.TIME_REMAP) {
                    setProgress(getProgress());
                }
            }
        }
    }

    public void cancelAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.lazyCompositionTasks.clear();
            this.animator.cancel();
        }
    }

    public void clearComposition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.animator.isRunning()) {
                this.animator.cancel();
            }
            this.composition = null;
            this.compositionLayer = null;
            this.imageAssetManager = null;
            this.animator.clearComposition();
            invalidateSelf();
        }
    }

    public void disableExtraScaleModeInFitXY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.isExtraScaleEnabled = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            this.isDirty = false;
            L.beginSection("Drawable#draw");
            if (this.safeMode) {
                try {
                    drawInternal(canvas);
                } catch (Throwable th) {
                    Logger.error("Lottie crashed in draw!", th);
                }
            } else {
                drawInternal(canvas);
            }
            L.endSection("Drawable#draw");
        }
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.enableMergePaths : invokeV.booleanValue;
    }

    @MainThread
    public void endAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.lazyCompositionTasks.clear();
            this.animator.endAnimation();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.alpha : invokeV.intValue;
    }

    public LottieComposition getComposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.composition : (LottieComposition) invokeV.objValue;
    }

    public int getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (int) this.animator.getFrame() : invokeV.intValue;
    }

    @Nullable
    public Bitmap getImageAsset(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            ImageAssetManager imageAssetManager = getImageAssetManager();
            if (imageAssetManager != null) {
                return imageAssetManager.bitmapForId(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Nullable
    public String getImageAssetsFolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.imageAssetsFolder : (String) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return -1;
            }
            return (int) (lottieComposition.getBounds().height() * getScale());
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                return -1;
            }
            return (int) (lottieComposition.getBounds().width() * getScale());
        }
        return invokeV.intValue;
    }

    public float getMaxFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.animator.getMaxFrame() : invokeV.floatValue;
    }

    public float getMinFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.animator.getMinFrame() : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition != null) {
                return lottieComposition.getPerformanceTracker();
            }
            return null;
        }
        return (PerformanceTracker) invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.animator.getAnimatedValueAbsolute() : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.animator.getRepeatCount() : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.animator.getRepeatMode() : invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.scale : invokeV.floatValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.animator.getSpeed() : invokeV.floatValue;
    }

    @Nullable
    public TextDelegate getTextDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.textDelegate : (TextDelegate) invokeV.objValue;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            FontAssetManager fontAssetManager = getFontAssetManager();
            if (fontAssetManager != null) {
                return fontAssetManager.getTypeface(str, str2);
            }
            return null;
        }
        return (Typeface) invokeLL.objValue;
    }

    public boolean hasMasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            CompositionLayer compositionLayer = this.compositionLayer;
            return compositionLayer != null && compositionLayer.hasMasks();
        }
        return invokeV.booleanValue;
    }

    public boolean hasMatte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            CompositionLayer compositionLayer = this.compositionLayer;
            return compositionLayer != null && compositionLayer.hasMatte();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, drawable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            LottieValueAnimator lottieValueAnimator = this.animator;
            if (lottieValueAnimator == null) {
                return false;
            }
            return lottieValueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.isApplyingOpacityToLayersEnabled : invokeV.booleanValue;
    }

    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.animator.getRepeatCount() == -1 : invokeV.booleanValue;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.enableMergePaths : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? isAnimating() : invokeV.booleanValue;
    }

    @Deprecated
    public void loop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.animator.setRepeatCount(z ? -1 : 0);
        }
    }

    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.lazyCompositionTasks.clear();
            this.animator.pauseAnimation();
        }
    }

    @MainThread
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.compositionLayer == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this) { // from class: com.airbnb.lottie.LottieDrawable.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;

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
                        this.this$0 = this;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.playAnimation();
                        }
                    }
                });
                return;
            }
            if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
                this.animator.playAnimation();
            }
            if (this.systemAnimationsEnabled) {
                return;
            }
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void removeAllAnimatorListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.animator.removeAllListeners();
        }
    }

    public void removeAllUpdateListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.animator.removeAllUpdateListeners();
            this.animator.addUpdateListener(this.progressUpdateListener);
        }
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, animatorListener) == null) {
            this.animator.removeListener(animatorListener);
        }
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, animatorUpdateListener) == null) {
            this.animator.removeUpdateListener(animatorUpdateListener);
        }
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, keyPath)) == null) {
            if (this.compositionLayer == null) {
                Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @MainThread
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.compositionLayer == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this) { // from class: com.airbnb.lottie.LottieDrawable.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;

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
                        this.this$0 = this;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.resumeAnimation();
                        }
                    }
                });
                return;
            }
            if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
                this.animator.resumeAnimation();
            }
            if (this.systemAnimationsEnabled) {
                return;
            }
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void reverseAnimationSpeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.animator.reverseAnimationSpeed();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{drawable, runnable, Long.valueOf(j2)}) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.alpha = i2;
            invalidateSelf();
        }
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.isApplyingOpacityToLayersEnabled = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, colorFilter) == null) {
            Logger.warning("Use addColorFilter instead.");
        }
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, lottieComposition)) == null) {
            if (this.composition == lottieComposition) {
                return false;
            }
            this.isDirty = false;
            clearComposition();
            this.composition = lottieComposition;
            buildCompositionLayer();
            this.animator.setComposition(lottieComposition);
            setProgress(this.animator.getAnimatedFraction());
            setScale(this.scale);
            updateBounds();
            Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
            while (it.hasNext()) {
                ((LazyCompositionTask) it.next()).run(lottieComposition);
                it.remove();
            }
            this.lazyCompositionTasks.clear();
            lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
            Drawable.Callback callback = getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(this);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, fontAssetDelegate) == null) {
            this.fontAssetDelegate = fontAssetDelegate;
            FontAssetManager fontAssetManager = this.fontAssetManager;
            if (fontAssetManager != null) {
                fontAssetManager.setDelegate(fontAssetDelegate);
            }
        }
    }

    public void setFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            if (this.composition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, i2) { // from class: com.airbnb.lottie.LottieDrawable.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ int val$frame;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
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
                        this.val$frame = i2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.setFrame(this.val$frame);
                        }
                    }
                });
            } else {
                this.animator.setFrame(i2);
            }
        }
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, imageAssetDelegate) == null) {
            this.imageAssetDelegate = imageAssetDelegate;
            ImageAssetManager imageAssetManager = this.imageAssetManager;
            if (imageAssetManager != null) {
                imageAssetManager.setDelegate(imageAssetDelegate);
            }
        }
    }

    public void setImagesAssetsFolder(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.imageAssetsFolder = str;
        }
    }

    public void setMaxFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            if (this.composition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, i2) { // from class: com.airbnb.lottie.LottieDrawable.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ int val$maxFrame;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
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
                        this.val$maxFrame = i2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.setMaxFrame(this.val$maxFrame);
                        }
                    }
                });
            } else {
                this.animator.setMaxFrame(i2 + 0.99f);
            }
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, f2) { // from class: com.airbnb.lottie.LottieDrawable.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ float val$maxProgress;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
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
                        this.val$maxProgress = f2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMaxProgress(this.val$maxProgress);
                        }
                    }
                });
            } else {
                setMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f2));
            }
        }
    }

    public void setMinAndMaxFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, str) { // from class: com.airbnb.lottie.LottieDrawable.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ String val$markerName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.val$markerName = str;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMinAndMaxFrame(this.val$markerName);
                        }
                    }
                });
                return;
            }
            Marker marker = lottieComposition.getMarker(str);
            if (marker != null) {
                int i2 = (int) marker.startFrame;
                setMinAndMaxFrame(i2, ((int) marker.durationFrames) + i2);
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, f2, f3) { // from class: com.airbnb.lottie.LottieDrawable.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ float val$maxProgress;
                    public final /* synthetic */ float val$minProgress;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2), Float.valueOf(f3)};
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
                        this.val$minProgress = f2;
                        this.val$maxProgress = f3;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMinAndMaxProgress(this.val$minProgress, this.val$maxProgress);
                        }
                    }
                });
            } else {
                setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f2), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f3));
            }
        }
    }

    public void setMinFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            if (this.composition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, i2) { // from class: com.airbnb.lottie.LottieDrawable.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ int val$minFrame;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
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
                        this.val$minFrame = i2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.setMinFrame(this.val$minFrame);
                        }
                    }
                });
            } else {
                this.animator.setMinFrame(i2);
            }
        }
    }

    public void setMinProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048642, this, f2) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, f2) { // from class: com.airbnb.lottie.LottieDrawable.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ float val$minProgress;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
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
                        this.val$minProgress = f2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMinProgress(this.val$minProgress);
                        }
                    }
                });
            } else {
                setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f2));
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.performanceTrackingEnabled = z;
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition != null) {
                lottieComposition.setPerformanceTrackingEnabled(z);
            }
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048644, this, f2) == null) {
            if (this.composition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, f2) { // from class: com.airbnb.lottie.LottieDrawable.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ float val$progress;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Float.valueOf(f2)};
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
                        this.val$progress = f2;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.setProgress(this.val$progress);
                        }
                    }
                });
                return;
            }
            L.beginSection("Drawable#setProgress");
            this.animator.setFrame(MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f2));
            L.endSection("Drawable#setProgress");
        }
    }

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.animator.setRepeatCount(i2);
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.animator.setRepeatMode(i2);
        }
    }

    public void setSafeMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.safeMode = z;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048648, this, f2) == null) {
            this.scale = f2;
            updateBounds();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, scaleType) == null) {
            this.scaleType = scaleType;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f2) == null) {
            this.animator.setSpeed(f2);
        }
    }

    public void setSystemAnimationsAreEnabled(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bool) == null) {
            this.systemAnimationsEnabled = bool.booleanValue();
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, textDelegate) == null) {
            this.textDelegate = textDelegate;
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            Drawable.Callback callback = getCallback();
            if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
                return;
            }
            playAnimation();
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            endAnimation();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048655, this, drawable, runnable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048656, this, str, bitmap)) == null) {
            ImageAssetManager imageAssetManager = getImageAssetManager();
            if (imageAssetManager == null) {
                Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
                return null;
            }
            Bitmap updateBitmap = imageAssetManager.updateBitmap(str, bitmap);
            invalidateSelf();
            return updateBitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public boolean useTextGlyphs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.textDelegate == null && this.composition.getCharacters().size() > 0 : invokeV.booleanValue;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || this.enableMergePaths == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Logger.warning("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.enableMergePaths = z;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    public void setMaxFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, str) { // from class: com.airbnb.lottie.LottieDrawable.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ String val$markerName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.val$markerName = str;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMaxFrame(this.val$markerName);
                        }
                    }
                });
                return;
            }
            Marker marker = lottieComposition.getMarker(str);
            if (marker != null) {
                setMaxFrame((int) (marker.startFrame + marker.durationFrames));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void setMinFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, str) { // from class: com.airbnb.lottie.LottieDrawable.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ String val$markerName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.val$markerName = str;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMinFrame(this.val$markerName);
                        }
                    }
                });
                return;
            }
            Marker marker = lottieComposition.getMarker(str);
            if (marker != null) {
                setMinFrame((int) marker.startFrame);
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048638, this, str, str2, z) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, str, str2, z) { // from class: com.airbnb.lottie.LottieDrawable.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ String val$endMarkerName;
                    public final /* synthetic */ boolean val$playEndMarkerStartFrame;
                    public final /* synthetic */ String val$startMarkerName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, str2, Boolean.valueOf(z)};
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
                        this.val$startMarkerName = str;
                        this.val$endMarkerName = str2;
                        this.val$playEndMarkerStartFrame = z;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            this.this$0.setMinAndMaxFrame(this.val$startMarkerName, this.val$endMarkerName, this.val$playEndMarkerStartFrame);
                        }
                    }
                });
                return;
            }
            Marker marker = lottieComposition.getMarker(str);
            if (marker != null) {
                int i2 = (int) marker.startFrame;
                Marker marker2 = this.composition.getMarker(str2);
                if (str2 != null) {
                    setMinAndMaxFrame(i2, (int) (marker2.startFrame + (z ? 1.0f : 0.0f)));
                    return;
                }
                throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, keyPath, t, simpleLottieValueCallback) == null) {
            addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>(this, simpleLottieValueCallback) { // from class: com.airbnb.lottie.LottieDrawable.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LottieDrawable this$0;
                public final /* synthetic */ SimpleLottieValueCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, simpleLottieValueCallback};
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
                    this.val$callback = simpleLottieValueCallback;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
                @Override // com.airbnb.lottie.value.LottieValueCallback
                public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, lottieFrameInfo)) == null) ? this.val$callback.getValue(lottieFrameInfo) : invokeL.objValue;
                }
            });
        }
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048636, this, i2, i3) == null) {
            if (this.composition == null) {
                this.lazyCompositionTasks.add(new LazyCompositionTask(this, i2, i3) { // from class: com.airbnb.lottie.LottieDrawable.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieDrawable this$0;
                    public final /* synthetic */ int val$maxFrame;
                    public final /* synthetic */ int val$minFrame;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$minFrame = i2;
                        this.val$maxFrame = i3;
                    }

                    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                    public void run(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.setMinAndMaxFrame(this.val$minFrame, this.val$maxFrame);
                        }
                    }
                });
            } else {
                this.animator.setMinAndMaxFrames(i2, i3 + 0.99f);
            }
        }
    }
}
