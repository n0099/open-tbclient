package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MotionTelltales extends MockView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MotionTelltales";
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix mInvertMatrix;
    public MotionLayout mMotionLayout;
    public Paint mPaintTelltales;
    public int mTailColor;
    public float mTailScale;
    public int mVelocityMode;
    public float[] velocity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionTelltales(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                        this.mTailColor = obtainStyledAttributes.getColor(index, this.mTailColor);
                    } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                        this.mVelocityMode = obtainStyledAttributes.getInt(index, this.mVelocityMode);
                    } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                        this.mTailScale = obtainStyledAttributes.getFloat(index, this.mTailScale);
                    }
                }
                obtainStyledAttributes.recycle();
            }
            this.mPaintTelltales.setColor(this.mTailColor);
            this.mPaintTelltales.setStrokeWidth(5.0f);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            getMatrix().invert(this.mInvertMatrix);
            if (this.mMotionLayout == null) {
                ViewParent parent = getParent();
                if (parent instanceof MotionLayout) {
                    this.mMotionLayout = (MotionLayout) parent;
                    return;
                }
                return;
            }
            int width = getWidth();
            int height = getHeight();
            float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
            for (int i2 = 0; i2 < 5; i2++) {
                float f2 = fArr[i2];
                for (int i3 = 0; i3 < 5; i3++) {
                    float f3 = fArr[i3];
                    this.mMotionLayout.getViewVelocity(this, f3, f2, this.velocity, this.mVelocityMode);
                    this.mInvertMatrix.mapVectors(this.velocity);
                    float f4 = width * f3;
                    float f5 = height * f2;
                    float[] fArr2 = this.velocity;
                    float f6 = fArr2[0];
                    float f7 = this.mTailScale;
                    float f8 = f5 - (fArr2[1] * f7);
                    this.mInvertMatrix.mapVectors(fArr2);
                    canvas.drawLine(f4, f5, f4 - (f6 * f7), f8, this.mPaintTelltales);
                }
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            postInvalidate();
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            this.mText = charSequence.toString();
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }
}
