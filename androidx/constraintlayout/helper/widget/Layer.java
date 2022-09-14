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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mContainer == null || (i = this.mCount) == 0) {
            return;
        }
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != i) {
            this.mViews = new View[this.mCount];
        }
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mViews[i2] = this.mContainer.getViewById(this.mIds[i2]);
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
        float f = this.mScaleX;
        float f2 = f * cos;
        float f3 = this.mScaleY;
        float f4 = (-f3) * sin;
        float f5 = f * sin;
        float f6 = f3 * cos;
        for (int i = 0; i < this.mCount; i++) {
            View view2 = this.mViews[i];
            float left = ((view2.getLeft() + view2.getRight()) / 2) - this.mComputedCenterX;
            float top = ((view2.getTop() + view2.getBottom()) / 2) - this.mComputedCenterY;
            view2.setTranslationX((((f2 * left) + (f4 * top)) - left) + this.mShiftX);
            view2.setTranslationY((((left * f5) + (f6 * top)) - top) + this.mShiftY);
            view2.setScaleY(this.mScaleY);
            view2.setScaleX(this.mScaleX);
            if (!Float.isNaN(this.mGroupRotateAngle)) {
                view2.setRotation(this.mGroupRotateAngle);
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
            for (int i = 0; i < this.mCount; i++) {
                View view2 = views[i];
                left = Math.min(left, view2.getLeft());
                top = Math.min(top, view2.getTop());
                right = Math.max(right, view2.getRight());
                bottom = Math.max(bottom, view2.getBottom());
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
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == 6) {
                        this.mApplyVisibilityOnAttach = true;
                    } else if (index == 13) {
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
                for (int i = 0; i < this.mCount; i++) {
                    View viewById = this.mContainer.getViewById(this.mIds[i]);
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
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            super.setElevation(f);
            applyLayoutFeatures();
        }
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.mRotationCenterX = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.mRotationCenterY = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.mGroupRotateAngle = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.mScaleX = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.mScaleY = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.mShiftX = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.mShiftY = f;
            transform();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.setVisibility(i);
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
    public Layer(Context context, AttributeSet attributeSet, int i) {
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
