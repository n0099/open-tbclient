package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mBias;
    public Object mEndToEnd;
    public Object mEndToStart;
    public Object mStartToEnd;
    public Object mStartToStart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {state};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((State) objArr2[0], (State.Helper) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Object> it = this.mReferences.iterator();
            while (it.hasNext()) {
                ConstraintReference constraints = this.mState.constraints(it.next());
                constraints.clearHorizontal();
                Object obj = this.mStartToStart;
                if (obj != null) {
                    constraints.startToStart(obj);
                } else {
                    Object obj2 = this.mStartToEnd;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2);
                    } else {
                        constraints.startToStart(State.PARENT);
                    }
                }
                Object obj3 = this.mEndToStart;
                if (obj3 != null) {
                    constraints.endToStart(obj3);
                } else {
                    Object obj4 = this.mEndToEnd;
                    if (obj4 != null) {
                        constraints.endToEnd(obj4);
                    } else {
                        constraints.endToEnd(State.PARENT);
                    }
                }
                float f = this.mBias;
                if (f != 0.5f) {
                    constraints.horizontalBias(f);
                }
            }
        }
    }

    public void bias(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.mBias = f;
        }
    }

    public void endToEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.mEndToEnd = obj;
        }
    }

    public void endToStart(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.mEndToStart = obj;
        }
    }

    public void startToEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.mStartToEnd = obj;
        }
    }

    public void startToStart(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            this.mStartToStart = obj;
        }
    }
}
