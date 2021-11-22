package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        super.setVisibility(8);
    }

    public boolean allowsGoneWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBarrier.allowsGoneWidget() : invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIndicatedType : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet) == null) {
            super.init(attributeSet);
            this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                        setType(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                        this.mBarrier.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                    }
                }
            }
            this.mHelperWidget = this.mBarrier;
            validateParams();
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mBarrier.setAllowsGoneWidget(z);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mIndicatedType = i2;
            this.mResolvedType = i2;
            if (Build.VERSION.SDK_INT >= 17) {
                if (1 == getResources().getConfiguration().getLayoutDirection()) {
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
            } else if (i2 == 5) {
                this.mResolvedType = 0;
            } else if (i2 == 6) {
                this.mResolvedType = 1;
            }
            this.mBarrier.setBarrierType(this.mResolvedType);
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
        super.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Barrier(Context context, AttributeSet attributeSet, int i2) {
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
        super.setVisibility(8);
    }
}
