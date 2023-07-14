package com.baidu.android.ext.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.LoadingDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.widget.dialog.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J0\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\rJ\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\nH\u0016J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010\u0017J\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/CircleProgressBar;", "Landroid/view/View;", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCenterX", "", "mCenterY", "mCircleColor", "mCircleWidth", "mPaint", "Landroid/graphics/Paint;", "mProgress", "mProgressColor", "mRadius", "mText", "", "mTextColor", "mTextSize", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "onLayout", "changed", "", "left", "top", "right", "bottom", "setCircleColor", "circleColor", "setCircleWidth", "circleWidth", "setProgress", "progress", "setProgressColor", WBConstants.TRANS_PROGRESS_COLOR, "setText", "text", "setTextColor", "textColor", "setTextSize", "textSize", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CircleProgressBar extends View implements LoadingDialog.IProgressBar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, View> _$_findViewCache;
    public float mCenterX;
    public float mCenterY;
    public int mCircleColor;
    public float mCircleWidth;
    public final Paint mPaint;
    public int mProgress;
    public int mProgressColor;
    public float mRadius;
    public String mText;
    public int mTextColor;
    public float mTextSize;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mPaint = new Paint();
        this.mTextColor = -65536;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mPaint = new Paint();
        this.mTextColor = -65536;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.mPaint = new Paint();
        this.mTextColor = -65536;
        init(context, attributeSet);
    }

    @SuppressLint({"CustomViewStyleable"})
    private final void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(50.0f);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.circle_progressbar);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.circle_progressbar)");
                this.mCircleWidth = obtainStyledAttributes.getDimension(4, getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070223));
                this.mCircleColor = obtainStyledAttributes.getColor(0, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b1));
                this.mProgressColor = obtainStyledAttributes.getColor(5, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b2));
                this.mText = obtainStyledAttributes.getString(1);
                this.mTextSize = obtainStyledAttributes.getDimension(3, getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070226));
                this.mTextColor = obtainStyledAttributes.getColor(2, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b2));
                obtainStyledAttributes.recycle();
            } else {
                this.mCircleWidth = getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070223);
                this.mCircleColor = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b1);
                this.mProgressColor = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b2);
                this.mTextSize = getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070226);
                this.mTextColor = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603b2);
            }
            this.mPaint.setStrokeWidth(this.mCircleWidth);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mCircleColor);
            canvas.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
            this.mPaint.setColor(this.mProgressColor);
            float f = this.mCenterX;
            float f2 = this.mRadius;
            float f3 = this.mCenterY;
            canvas.drawArc(new RectF(f - f2, f3 - f2, f + f2, f3 + f2), -90.0f, (this.mProgress * 360.0f) / 100, false, this.mPaint);
            if (this.mText != null) {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mTextColor);
                this.mPaint.setTextSize(this.mTextSize);
                this.mPaint.setTextAlign(Paint.Align.CENTER);
                Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
                String str = this.mText;
                Intrinsics.checkNotNull(str);
                float f4 = this.mCenterX;
                float f5 = this.mCenterY;
                float f6 = fontMetrics.bottom;
                canvas.drawText(str, f4, (f5 + ((f6 - fontMetrics.top) / 2)) - f6, this.mPaint);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            this.mRadius = (RangesKt___RangesKt.coerceAtMost(getWidth(), getHeight()) / 2.0f) - this.mCircleWidth;
            this.mCenterX = getWidth() / 2;
            this.mCenterY = getHeight() / 2;
        }
    }

    public final void setCircleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mCircleColor = i;
        }
    }

    public final void setCircleWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.mCircleWidth = f;
        }
    }

    public final void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mProgressColor = i;
        }
    }

    public final void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mText = str;
            postInvalidate();
        }
    }

    public final void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mTextColor = i;
        }
    }

    public final void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.mTextSize = f;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0016: IGET  (r0v4 int A[REMOVE]) = (r4v0 'this' com.baidu.android.ext.widget.dialog.CircleProgressBar A[IMMUTABLE_TYPE, THIS]) com.baidu.android.ext.widget.dialog.CircleProgressBar.mProgress int), ('%' char)] */
    @Override // com.baidu.android.ext.widget.dialog.LoadingDialog.IProgressBar
    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mProgress = RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(i, 0), 100);
            StringBuilder sb = new StringBuilder();
            sb.append(this.mProgress);
            sb.append('%');
            this.mText = sb.toString();
            postInvalidate();
        }
    }
}
