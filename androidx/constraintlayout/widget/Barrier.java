package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    public int mIndicatedType;
    public int mResolvedType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Barrier(Context context) {
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
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget constraintWidget, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{constraintWidget, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mResolvedType = i;
            if (Build.VERSION.SDK_INT < 17) {
                int i2 = this.mIndicatedType;
                if (i2 == 5) {
                    this.mResolvedType = 0;
                } else if (i2 == 6) {
                    this.mResolvedType = 1;
                }
            } else if (z) {
                int i3 = this.mIndicatedType;
                if (i3 == 5) {
                    this.mResolvedType = 1;
                } else if (i3 == 6) {
                    this.mResolvedType = 0;
                }
            } else {
                int i4 = this.mIndicatedType;
                if (i4 == 5) {
                    this.mResolvedType = 0;
                } else if (i4 == 6) {
                    this.mResolvedType = 1;
                }
            }
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget).setBarrierType(this.mResolvedType);
            }
        }
    }

    public boolean allowsGoneWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBarrier.allowsGoneWidget() : invokeV.booleanValue;
    }

    public int getMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBarrier.getMargin() : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIndicatedType : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
            super.init(attributeSet);
            this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                        setType(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                        this.mBarrier.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                        this.mBarrier.setMargin(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                }
                obtainStyledAttributes.recycle();
            }
            this.mHelperWidget = this.mBarrier;
            validateParams();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, constraint, helperWidget, layoutParams, sparseArray) == null) {
            super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
            if (helperWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) helperWidget;
                updateType(barrier, constraint.layout.mBarrierDirection, ((ConstraintWidgetContainer) helperWidget.getParent()).isRtl());
                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                barrier.setMargin(constraint.layout.mBarrierMargin);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, constraintWidget, z) == null) {
            updateType(constraintWidget, this.mIndicatedType, z);
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mBarrier.setAllowsGoneWidget(z);
        }
    }

    public void setDpMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            androidx.constraintlayout.solver.widgets.Barrier barrier = this.mBarrier;
            barrier.setMargin((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
        }
    }

    public void setMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mBarrier.setMargin(i);
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mIndicatedType = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Barrier(Context context, AttributeSet attributeSet) {
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
        super.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Barrier(Context context, AttributeSet attributeSet, int i) {
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
        super.setVisibility(8);
    }
}
