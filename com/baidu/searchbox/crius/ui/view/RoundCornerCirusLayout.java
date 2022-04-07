package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RoundCornerCirusLayout extends CriusLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint mBitmapPaint;
    public int mStrokeColor;
    public Paint mStrokePaint;
    public float mStrokeWidth;
    public float[] radii;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerCirusLayout(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void drawStroke(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas, i, i2) == null) {
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
            int i3 = this.mStrokeColor;
            if (i3 != Integer.MAX_VALUE) {
                this.mStrokePaint.setColor(i3);
            }
            this.mStrokePaint.setColor(SupportMenu.CATEGORY_MASK);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, i, i2), this.radii, Path.Direction.CW);
            canvas.drawPath(path, this.mStrokePaint);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mBitmapPaint = new Paint(1);
            this.mStrokePaint = new Paint(1);
        }
    }

    private boolean isDrawRoundCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            for (int i = 0; i < 8; i++) {
                if (this.radii[i] > 0.0f) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private Bitmap makeRoundRectFrame(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, this, i, i2)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, i, i2), this.radii, Path.Direction.CW);
            Paint paint = new Paint(1);
            paint.setColor(-16711936);
            canvas.drawPath(path, paint);
            return createBitmap;
        }
        return (Bitmap) invokeII.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (getWidth() > 0 && getHeight() > 0) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.dispatchDraw(canvas);
                if (isDrawRoundCorner()) {
                    Bitmap makeRoundRectFrame = makeRoundRectFrame(getWidth(), getHeight());
                    this.mBitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    canvas.drawBitmap(makeRoundRectFrame, 0.0f, 0.0f, this.mBitmapPaint);
                    this.mBitmapPaint.setXfermode(null);
                }
                if (this.mStrokeWidth > 0.0f) {
                    drawStroke(canvas, getWidth(), getHeight());
                }
                canvas.restoreToCount(saveLayer);
                return;
            }
            super.dispatchDraw(canvas);
        }
    }

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) || f <= 0.0f) {
            return;
        }
        setCornerRadius(f, f, f, f);
    }

    public void setStroke(float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            this.mStrokeWidth = f;
            this.mStrokeColor = i;
            postInvalidate();
        }
    }

    public void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mStrokeColor = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerCirusLayout(Context context, AttributeSet attributeSet) {
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
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f > 0.0f || f2 > 0.0f || f3 > 0.0f || f4 > 0.0f) {
                float[] fArr = this.radii;
                fArr[0] = f;
                fArr[1] = f;
                fArr[2] = f2;
                fArr[3] = f2;
                fArr[4] = f3;
                fArr[5] = f3;
                fArr[6] = f4;
                fArr[7] = f4;
                postInvalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerCirusLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mStrokeWidth = 0.0f;
        this.mStrokeColor = Integer.MAX_VALUE;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerCirusLayout(Context context, CriusData criusData) {
        super(context, criusData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (CriusData) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mStrokeWidth = 0.0f;
        this.mStrokeColor = Integer.MAX_VALUE;
        init();
    }
}
