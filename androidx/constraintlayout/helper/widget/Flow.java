package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public androidx.constraintlayout.solver.widgets.Flow mFlow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Flow(Context context) {
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
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            super.init(attributeSet);
            this.mFlow = new androidx.constraintlayout.solver.widgets.Flow();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                        this.mFlow.setOrientation(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                        this.mFlow.setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.mFlow.setPaddingStart(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        }
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.mFlow.setPaddingEnd(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        }
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                        this.mFlow.setPaddingLeft(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                        this.mFlow.setPaddingTop(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                        this.mFlow.setPaddingRight(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                        this.mFlow.setPaddingBottom(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                        this.mFlow.setWrapMode(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                        this.mFlow.setHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                        this.mFlow.setVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                        this.mFlow.setFirstHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                        this.mFlow.setLastHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                        this.mFlow.setFirstVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                        this.mFlow.setLastVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                        this.mFlow.setHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                        this.mFlow.setFirstHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                        this.mFlow.setLastHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                        this.mFlow.setFirstVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                        this.mFlow.setLastVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                        this.mFlow.setVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                        this.mFlow.setHorizontalAlign(obtainStyledAttributes.getInt(index, 2));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                        this.mFlow.setVerticalAlign(obtainStyledAttributes.getInt(index, 2));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                        this.mFlow.setHorizontalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                        this.mFlow.setVerticalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                        this.mFlow.setMaxElementsWrap(obtainStyledAttributes.getInt(index, -1));
                    }
                }
                obtainStyledAttributes.recycle();
            }
            this.mHelperWidget = this.mFlow;
            validateParams();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraint, helperWidget, layoutParams, sparseArray) == null) {
            super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
            if (helperWidget instanceof androidx.constraintlayout.solver.widgets.Flow) {
                androidx.constraintlayout.solver.widgets.Flow flow = (androidx.constraintlayout.solver.widgets.Flow) helperWidget;
                int i2 = layoutParams.orientation;
                if (i2 != -1) {
                    flow.setOrientation(i2);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            onMeasure(this.mFlow, i2, i3);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, constraintWidget, z) == null) {
            this.mFlow.applyRtl(z);
        }
    }

    public void setFirstHorizontalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mFlow.setFirstHorizontalBias(f2);
            requestLayout();
        }
    }

    public void setFirstHorizontalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mFlow.setFirstHorizontalStyle(i2);
            requestLayout();
        }
    }

    public void setFirstVerticalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.mFlow.setFirstVerticalBias(f2);
            requestLayout();
        }
    }

    public void setFirstVerticalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mFlow.setFirstVerticalStyle(i2);
            requestLayout();
        }
    }

    public void setHorizontalAlign(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mFlow.setHorizontalAlign(i2);
            requestLayout();
        }
    }

    public void setHorizontalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.mFlow.setHorizontalBias(f2);
            requestLayout();
        }
    }

    public void setHorizontalGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mFlow.setHorizontalGap(i2);
            requestLayout();
        }
    }

    public void setHorizontalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mFlow.setHorizontalStyle(i2);
            requestLayout();
        }
    }

    public void setMaxElementsWrap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mFlow.setMaxElementsWrap(i2);
            requestLayout();
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mFlow.setOrientation(i2);
            requestLayout();
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mFlow.setPadding(i2);
            requestLayout();
        }
    }

    public void setPaddingBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mFlow.setPaddingBottom(i2);
            requestLayout();
        }
    }

    public void setPaddingLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mFlow.setPaddingLeft(i2);
            requestLayout();
        }
    }

    public void setPaddingRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mFlow.setPaddingRight(i2);
            requestLayout();
        }
    }

    public void setPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mFlow.setPaddingTop(i2);
            requestLayout();
        }
    }

    public void setVerticalAlign(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mFlow.setVerticalAlign(i2);
            requestLayout();
        }
    }

    public void setVerticalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mFlow.setVerticalBias(f2);
            requestLayout();
        }
    }

    public void setVerticalGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mFlow.setVerticalGap(i2);
            requestLayout();
        }
    }

    public void setVerticalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mFlow.setVerticalStyle(i2);
            requestLayout();
        }
    }

    public void setWrapMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mFlow.setWrapMode(i2);
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Flow(Context context, AttributeSet attributeSet) {
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
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout virtualLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, virtualLayout, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (virtualLayout != null) {
                virtualLayout.measure(mode, size, mode2, size2);
                setMeasuredDimension(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Flow(Context context, AttributeSet attributeSet, int i2) {
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
    }
}
