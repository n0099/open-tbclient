package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Layer";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mApplyElevationOnAttach;
    public boolean mApplyVisibilityOnAttach;
    public float mComputedCenterX;
    public float mComputedCenterY;
    public float mComputedMaxX;
    public float mComputedMaxY;
    public float mComputedMinX;
    public float mComputedMinY;
    public ConstraintLayout mContainer;
    public float mGroupRotateAngle;
    public boolean mNeedBounds;
    public float mRotationCenterX;
    public float mRotationCenterY;
    public float mScaleX;
    public float mScaleY;
    public float mShiftX;
    public float mShiftY;
    public View[] mViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Layer(Context context) {
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
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    private void reCacheViews() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mContainer == null || (i2 = this.mCount) == 0) {
            return;
        }
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != i2) {
            this.mViews = new View[this.mCount];
        }
        for (int i3 = 0; i3 < this.mCount; i3++) {
            this.mViews[i3] = this.mContainer.getViewById(this.mIds[i3]);
        }
    }

    private void transform() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.mContainer == null) {
            return;
        }
        if (this.mViews == null) {
            reCacheViews();
        }
        calcCenters();
        double radians = Float.isNaN(this.mGroupRotateAngle) ? 0.0d : Math.toRadians(this.mGroupRotateAngle);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f2 = this.mScaleX;
        float f3 = f2 * cos;
        float f4 = this.mScaleY;
        float f5 = (-f4) * sin;
        float f6 = f2 * sin;
        float f7 = f4 * cos;
        for (int i2 = 0; i2 < this.mCount; i2++) {
            View view = this.mViews[i2];
            float left = ((view.getLeft() + view.getRight()) / 2) - this.mComputedCenterX;
            float top = ((view.getTop() + view.getBottom()) / 2) - this.mComputedCenterY;
            view.setTranslationX((((f3 * left) + (f5 * top)) - left) + this.mShiftX);
            view.setTranslationY((((left * f6) + (f7 * top)) - top) + this.mShiftY);
            view.setScaleY(this.mScaleY);
            view.setScaleX(this.mScaleX);
            if (!Float.isNaN(this.mGroupRotateAngle)) {
                view.setRotation(this.mGroupRotateAngle);
            }
        }
    }

    public void calcCenters() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mContainer == null) {
            return;
        }
        if (this.mNeedBounds || Float.isNaN(this.mComputedCenterX) || Float.isNaN(this.mComputedCenterY)) {
            if (!Float.isNaN(this.mRotationCenterX) && !Float.isNaN(this.mRotationCenterY)) {
                this.mComputedCenterY = this.mRotationCenterY;
                this.mComputedCenterX = this.mRotationCenterX;
                return;
            }
            View[] views = getViews(this.mContainer);
            int left = views[0].getLeft();
            int top = views[0].getTop();
            int right = views[0].getRight();
            int bottom = views[0].getBottom();
            for (int i2 = 0; i2 < this.mCount; i2++) {
                View view = views[i2];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.mComputedMaxX = right;
            this.mComputedMaxY = bottom;
            this.mComputedMinX = left;
            this.mComputedMinY = top;
            if (Float.isNaN(this.mRotationCenterX)) {
                this.mComputedCenterX = (left + right) / 2;
            } else {
                this.mComputedCenterX = this.mRotationCenterX;
            }
            if (Float.isNaN(this.mRotationCenterY)) {
                this.mComputedCenterY = (top + bottom) / 2;
            } else {
                this.mComputedCenterY = this.mRotationCenterY;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet) == null) {
            super.init(attributeSet);
            this.mUseViewMeasure = false;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                        this.mApplyVisibilityOnAttach = true;
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                        this.mApplyElevationOnAttach = true;
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            this.mContainer = (ConstraintLayout) getParent();
            if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
                int visibility = getVisibility();
                float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
                for (int i2 = 0; i2 < this.mCount; i2++) {
                    View viewById = this.mContainer.getViewById(this.mIds[i2]);
                    if (viewById != null) {
                        if (this.mApplyVisibilityOnAttach) {
                            viewById.setVisibility(visibility);
                        }
                        if (this.mApplyElevationOnAttach && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            super.setElevation(f2);
            applyLayoutFeatures();
        }
    }

    @Override // android.view.View
    public void setPivotX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.mRotationCenterX = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setPivotY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mRotationCenterY = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.mGroupRotateAngle = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.mScaleX = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mScaleY = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.mShiftX = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.mShiftY = f2;
            transform();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.setVisibility(i2);
            applyLayoutFeatures();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, constraintLayout) == null) {
            reCacheViews();
            this.mComputedCenterX = Float.NaN;
            this.mComputedCenterY = Float.NaN;
            ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
            constraintWidget.setWidth(0);
            constraintWidget.setHeight(0);
            calcCenters();
            layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
            transform();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, constraintLayout) == null) {
            this.mContainer = constraintLayout;
            float rotation = getRotation();
            if (rotation == 0.0f) {
                if (Float.isNaN(this.mGroupRotateAngle)) {
                    return;
                }
                this.mGroupRotateAngle = rotation;
                return;
            }
            this.mGroupRotateAngle = rotation;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Layer(Context context, AttributeSet attributeSet) {
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
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Layer(Context context, AttributeSet attributeSet, int i2) {
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
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }
}
