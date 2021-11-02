package com.baidu.searchbox.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
/* loaded from: classes7.dex */
public class BdPlaceHolderDrawable extends ForwardingDrawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BdPlaceHolderDrawable";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBgColor;
    public Matrix mDrawMatrix;
    public int mNightBgColor;
    public Paint mPaint;
    public int mRadius;
    public Matrix mTempMatrix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlaceHolderDrawable(Drawable drawable) {
        this(drawable, AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_solid), AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_solid_night), 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void drawCircle(Canvas canvas, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, canvas, rect) == null) {
            setPaintAttrs();
            canvas.drawCircle(rect.width() / 2, rect.height() / 2, this.mRadius, this.mPaint);
        }
    }

    private void drawRect(Canvas canvas, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, canvas, rect) == null) {
            this.mPaint.setColor(AppRuntime.getAppContext().getResources().getColor(R.color.bd_place_holder_stroke));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(2.0f);
            canvas.drawRect(rect, this.mPaint);
            Rect rect2 = new Rect(rect.left + 1, rect.top + 1, rect.right - 1, rect.bottom - 1);
            setPaintAttrs();
            canvas.drawRect(rect2, this.mPaint);
        }
    }

    private void setPaintAttrs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                this.mPaint.setColor(this.mNightBgColor);
            } else {
                this.mPaint.setColor(this.mBgColor);
            }
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    @VisibleForTesting
    public void configureBounds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Drawable current = getCurrent();
            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();
            int intrinsicWidth = current.getIntrinsicWidth();
            int intrinsicHeight = current.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
            } else if (intrinsicWidth == width && intrinsicHeight == height) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
            } else {
                current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                getTransform(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, bounds.width() / intrinsicWidth, bounds.height() / intrinsicHeight);
                this.mDrawMatrix = this.mTempMatrix;
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            drawBackground(canvas);
            drawDrawable(canvas);
        }
    }

    public void drawBackground(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Rect bounds = getBounds();
            if (this.mRadius > 0) {
                drawCircle(canvas, bounds);
            } else {
                drawRect(canvas, bounds);
            }
        }
    }

    public void drawDrawable(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.mDrawMatrix != null) {
                int save = canvas.save();
                canvas.clipRect(getBounds());
                canvas.concat(this.mDrawMatrix);
                super.draw(canvas);
                canvas.restoreToCount(save);
                return;
            }
            super.draw(canvas);
        }
    }

    public void getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{matrix, rect, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float min = Math.min(Math.min(f2, f3), 1.0f);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rect) == null) {
            configureBounds();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPlaceHolderDrawable(Drawable drawable, int i2, int i3, int i4) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mBgColor = i2;
        this.mNightBgColor = i3;
        this.mRadius = i4;
    }
}
