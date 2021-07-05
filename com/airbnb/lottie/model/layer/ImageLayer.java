package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ImageLayer extends BaseLayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final Rect dst;
    public final Paint paint;
    public final Rect src;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, layer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((LottieDrawable) objArr2[0], (Layer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Nullable
    private Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.lottieDrawable.getImageAsset(this.layerModel.getRefId()) : (Bitmap) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            super.addValueCallback(t, lottieValueCallback);
            if (t == LottieProperty.COLOR_FILTER) {
                if (lottieValueCallback == null) {
                    this.colorFilterAnimation = null;
                } else {
                    this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        float dpScale = Utils.dpScale();
        this.paint.setAlpha(i2);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.dst.set(0, 0, (int) (bitmap.getWidth() * dpScale), (int) (bitmap.getHeight() * dpScale));
        canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix, z) == null) {
            super.getBounds(rectF, matrix, z);
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                rectF.set(0.0f, 0.0f, bitmap.getWidth() * Utils.dpScale(), bitmap.getHeight() * Utils.dpScale());
                this.boundsMatrix.mapRect(rectF);
            }
        }
    }
}
