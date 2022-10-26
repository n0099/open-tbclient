package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GuidelineReference implements Reference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object key;
    public int mEnd;
    public Guideline mGuidelineWidget;
    public int mOrientation;
    public float mPercent;
    public int mStart;
    public final State mState;

    public GuidelineReference(State state) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {state};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0.0f;
        this.mState = state;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mGuidelineWidget.setOrientation(this.mOrientation);
            int i = this.mStart;
            if (i != -1) {
                this.mGuidelineWidget.setGuideBegin(i);
                return;
            }
            int i2 = this.mEnd;
            if (i2 != -1) {
                this.mGuidelineWidget.setGuideEnd(i2);
            } else {
                this.mGuidelineWidget.setGuidePercent(this.mPercent);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mGuidelineWidget == null) {
                this.mGuidelineWidget = new Guideline();
            }
            return this.mGuidelineWidget;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.key;
        }
        return invokeV.objValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mOrientation;
        }
        return invokeV.intValue;
    }

    public void end(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.mStart = -1;
            this.mEnd = this.mState.convertDimension(obj);
            this.mPercent = 0.0f;
        }
    }

    public void percent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.mStart = -1;
            this.mEnd = -1;
            this.mPercent = f;
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, constraintWidget) == null) {
            if (constraintWidget instanceof Guideline) {
                this.mGuidelineWidget = (Guideline) constraintWidget;
            } else {
                this.mGuidelineWidget = null;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.key = obj;
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mOrientation = i;
        }
    }

    public void start(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            this.mStart = this.mState.convertDimension(obj);
            this.mEnd = -1;
            this.mPercent = 0.0f;
        }
    }
}
