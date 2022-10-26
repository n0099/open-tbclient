package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mEndToEnd;
    public Object mEndToStart;
    public Object mStartToEnd;
    public Object mStartToStart;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523641866, "Landroidx/constraintlayout/solver/state/helpers/HorizontalChainReference$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(523641866, "Landroidx/constraintlayout/solver/state/helpers/HorizontalChainReference$1;");
                    return;
                }
            }
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
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
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Object> it = this.mReferences.iterator();
            while (it.hasNext()) {
                this.mState.constraints(it.next()).clearHorizontal();
            }
            Iterator<Object> it2 = this.mReferences.iterator();
            ConstraintReference constraintReference = null;
            ConstraintReference constraintReference2 = null;
            while (it2.hasNext()) {
                ConstraintReference constraints = this.mState.constraints(it2.next());
                if (constraintReference2 == null) {
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
                    constraintReference2 = constraints;
                }
                if (constraintReference != null) {
                    constraintReference.endToStart(constraints.getKey());
                    constraints.startToEnd(constraintReference.getKey());
                }
                constraintReference = constraints;
            }
            if (constraintReference != null) {
                Object obj3 = this.mEndToStart;
                if (obj3 != null) {
                    constraintReference.endToStart(obj3);
                } else {
                    Object obj4 = this.mEndToEnd;
                    if (obj4 != null) {
                        constraintReference.endToEnd(obj4);
                    } else {
                        constraintReference.endToEnd(State.PARENT);
                    }
                }
            }
            if (constraintReference2 != null) {
                float f = this.mBias;
                if (f != 0.5f) {
                    constraintReference2.horizontalBias(f);
                }
            }
            int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        constraintReference2.setHorizontalChainStyle(2);
                        return;
                    }
                    return;
                }
                constraintReference2.setHorizontalChainStyle(1);
                return;
            }
            constraintReference2.setHorizontalChainStyle(0);
        }
    }

    public void endToEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.mEndToEnd = obj;
        }
    }

    public void endToStart(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.mEndToStart = obj;
        }
    }

    public void startToEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.mStartToEnd = obj;
        }
    }

    public void startToStart(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.mStartToStart = obj;
        }
    }
}
