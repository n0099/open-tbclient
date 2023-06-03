package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.widget.dialog.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/RoundAngleFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottomLeftRadius", "", "mBottomRightRadius", "mImagePaint", "Landroid/graphics/Paint;", "mRoundPaint", "mTopLeftRadius", "mTopRightRadius", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawBottomLeft", "drawBottomRight", "drawTopLeft", "drawTopRight", "isRoundAngle", "", "setBottomLeftRadius", "bottomLeftRadius", "setBottomRightRadius", "bottomRightRadius", "setTopLeftRadius", "topLeftRadius", "setTopRadius", "topRadius", "setTopRightRadius", "topRightRadius", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundAngleFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, View> _$_findViewCache;
    public float mBottomLeftRadius;
    public float mBottomRightRadius;
    public final Paint mImagePaint;
    public final Paint mRoundPaint;
    public float mTopLeftRadius;
    public float mTopRightRadius;

    public void _$_clearFindViewByIdCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, View> map = this._$_findViewCache;
            View view2 = map.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleFrameLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawTopLeft(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, canvas) == null) && this.mTopLeftRadius > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.mTopLeftRadius);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.mTopLeftRadius, 0.0f);
            float f = this.mTopLeftRadius;
            float f2 = 2;
            path.arcTo(new RectF(0.0f, 0.0f, f * f2, f * f2), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.mRoundPaint);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundAngleFrameLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…le.RoundAngleFrameLayout)");
            float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
            this.mTopLeftRadius = obtainStyledAttributes.getDimension(3, dimension);
            this.mTopRightRadius = obtainStyledAttributes.getDimension(4, dimension);
            this.mBottomLeftRadius = obtainStyledAttributes.getDimension(0, dimension);
            this.mBottomRightRadius = obtainStyledAttributes.getDimension(1, dimension);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.mRoundPaint = paint;
        paint.setColor(-1);
        this.mRoundPaint.setAntiAlias(true);
        this.mRoundPaint.setStyle(Paint.Style.FILL);
        this.mRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.mImagePaint = paint2;
        paint2.setXfermode(null);
    }

    private final void drawBottomLeft(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, canvas) == null) && this.mBottomLeftRadius > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f = height;
            path.moveTo(0.0f, f - this.mBottomLeftRadius);
            path.lineTo(0.0f, f);
            path.lineTo(this.mBottomLeftRadius, f);
            float f2 = 2;
            float f3 = this.mBottomLeftRadius;
            path.arcTo(new RectF(0.0f, f - (f2 * f3), f3 * f2, f), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.mRoundPaint);
        }
    }

    private final void drawBottomRight(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) && this.mBottomRightRadius > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f = width;
            float f2 = height;
            path.moveTo(f - this.mBottomRightRadius, f2);
            path.lineTo(f, f2);
            path.lineTo(f, f2 - this.mBottomRightRadius);
            float f3 = 2;
            float f4 = this.mBottomRightRadius;
            path.arcTo(new RectF(f - (f3 * f4), f2 - (f3 * f4), f, f2), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.mRoundPaint);
        }
    }

    private final void drawTopRight(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, canvas) == null) && this.mTopRightRadius > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f = width;
            path.moveTo(f - this.mTopRightRadius, 0.0f);
            path.lineTo(f, 0.0f);
            path.lineTo(f, this.mTopRightRadius);
            float f2 = 2;
            float f3 = this.mTopRightRadius;
            path.arcTo(new RectF(f - (f2 * f3), 0.0f, f, f3 * f2), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.mRoundPaint);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (isRoundAngle()) {
                canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.mImagePaint, 31);
            }
            super.dispatchDraw(canvas);
            if (isRoundAngle()) {
                drawTopLeft(canvas);
                drawTopRight(canvas);
                drawBottomLeft(canvas);
                drawBottomRight(canvas);
                canvas.restore();
            }
        }
    }

    private final boolean isRoundAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mTopLeftRadius <= 0.0f && this.mTopRightRadius <= 0.0f && this.mBottomLeftRadius <= 0.0f && this.mBottomRightRadius <= 0.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void setBottomLeftRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.mBottomLeftRadius = f;
            invalidate();
        }
    }

    public final void setBottomRightRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.mBottomRightRadius = f;
            invalidate();
        }
    }

    public final void setTopLeftRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.mTopLeftRadius = f;
            invalidate();
        }
    }

    public final void setTopRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.mTopLeftRadius = f;
            this.mTopRightRadius = f;
            invalidate();
        }
    }

    public final void setTopRightRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.mTopRightRadius = f;
            invalidate();
        }
    }
}
