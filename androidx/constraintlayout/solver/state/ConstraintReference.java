package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConstraintReference implements Reference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object key;
    public Object mBaselineToBaseline;
    public Object mBottomToBottom;
    public Object mBottomToTop;
    public ConstraintWidget mConstraintWidget;
    public Object mEndToEnd;
    public Object mEndToStart;
    public float mHorizontalBias;
    public int mHorizontalChainStyle;
    public Dimension mHorizontalDimension;
    public State.Constraint mLast;
    public Object mLeftToLeft;
    public Object mLeftToRight;
    public int mMarginBottom;
    public int mMarginBottomGone;
    public int mMarginEnd;
    public int mMarginEndGone;
    public int mMarginLeft;
    public int mMarginLeftGone;
    public int mMarginRight;
    public int mMarginRightGone;
    public int mMarginStart;
    public int mMarginStartGone;
    public int mMarginTop;
    public int mMarginTopGone;
    public Object mRightToLeft;
    public Object mRightToRight;
    public Object mStartToEnd;
    public Object mStartToStart;
    public final State mState;
    public Object mTopToBottom;
    public Object mTopToTop;
    public float mVerticalBias;
    public int mVerticalChainStyle;
    public Dimension mVerticalDimension;
    public Object mView;

    /* renamed from: androidx.constraintlayout.solver.state.ConstraintReference$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(109776716, "Landroidx/constraintlayout/solver/state/ConstraintReference$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(109776716, "Landroidx/constraintlayout/solver/state/ConstraintReference$1;");
                    return;
                }
            }
            int[] iArr = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    /* loaded from: classes.dex */
    public class IncorrectConstraintException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<String> mErrors;
        public final /* synthetic */ ConstraintReference this$0;

        public IncorrectConstraintException(ConstraintReference constraintReference, ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constraintReference, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constraintReference;
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mErrors : (ArrayList) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "IncorrectConstraintException: " + this.mErrors.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public ConstraintReference(State state) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {state};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mLast = null;
        this.mHorizontalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mVerticalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mState = state;
    }

    private void applyConnection(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget target;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, constraintWidget, obj, constraint) == null) || (target = getTarget(obj)) == null) {
            return;
        }
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()];
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
            case 1:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginLeft, this.mMarginLeftGone, false);
                return;
            case 2:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
                return;
            case 3:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
                return;
            case 4:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginRight, this.mMarginRightGone, false);
                return;
            case 5:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginStart, this.mMarginStartGone, false);
                return;
            case 6:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
                return;
            case 7:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
                return;
            case 8:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginEnd, this.mMarginEndGone, false);
                return;
            case 9:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginTop, this.mMarginTopGone, false);
                return;
            case 10:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
                return;
            case 11:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
                return;
            case 12:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginBottom, this.mMarginBottomGone, false);
                return;
            case 13:
                ConstraintAnchor.Type type = ConstraintAnchor.Type.BASELINE;
                constraintWidget.immediateConnect(type, target, type, 0, 0);
                return;
            default:
                return;
        }
    }

    private void dereference() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mLeftToLeft = get(this.mLeftToLeft);
            this.mLeftToRight = get(this.mLeftToRight);
            this.mRightToLeft = get(this.mRightToLeft);
            this.mRightToRight = get(this.mRightToRight);
            this.mStartToStart = get(this.mStartToStart);
            this.mStartToEnd = get(this.mStartToEnd);
            this.mEndToStart = get(this.mEndToStart);
            this.mEndToEnd = get(this.mEndToEnd);
            this.mTopToTop = get(this.mTopToTop);
            this.mTopToBottom = get(this.mTopToBottom);
            this.mBottomToTop = get(this.mBottomToTop);
            this.mBottomToBottom = get(this.mBottomToBottom);
            this.mBaselineToBaseline = get(this.mBaselineToBaseline);
        }
    }

    private Object get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return !(obj instanceof ConstraintReference) ? this.mState.reference(obj) : obj;
        }
        return invokeL.objValue;
    }

    private ConstraintWidget getTarget(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj)) == null) {
            if (obj instanceof Reference) {
                return ((Reference) obj).getConstraintWidget();
            }
            return null;
        }
        return (ConstraintWidget) invokeL.objValue;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (constraintWidget = this.mConstraintWidget) == null) {
            return;
        }
        this.mHorizontalDimension.apply(this.mState, constraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        int i2 = this.mHorizontalChainStyle;
        if (i2 != 0) {
            this.mConstraintWidget.setHorizontalChainStyle(i2);
        }
        int i3 = this.mVerticalChainStyle;
        if (i3 != 0) {
            this.mConstraintWidget.setVerticalChainStyle(i3);
        }
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    public ConstraintReference baseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.mLast = State.Constraint.BASELINE_TO_BASELINE;
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            this.mLast = State.Constraint.BASELINE_TO_BASELINE;
            this.mBaselineToBaseline = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference bias(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            State.Constraint constraint = this.mLast;
            if (constraint == null) {
                return this;
            }
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 14:
                    this.mHorizontalBias = f2;
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 15:
                    this.mVerticalBias = f2;
                    break;
            }
            return this;
        }
        return (ConstraintReference) invokeF.objValue;
    }

    public ConstraintReference bottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mBottomToTop != null) {
                this.mLast = State.Constraint.BOTTOM_TO_TOP;
            } else {
                this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
            this.mBottomToBottom = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference bottomToTop(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            this.mLast = State.Constraint.BOTTOM_TO_TOP;
            this.mBottomToTop = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            Object obj2 = get(obj);
            this.mStartToStart = obj2;
            this.mEndToEnd = obj2;
            this.mLast = State.Constraint.CENTER_HORIZONTALLY;
            this.mHorizontalBias = 0.5f;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference centerVertically(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            Object obj2 = get(obj);
            this.mTopToTop = obj2;
            this.mBottomToBottom = obj2;
            this.mLast = State.Constraint.CENTER_VERTICALLY;
            this.mVerticalBias = 0.5f;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            State.Constraint constraint = this.mLast;
            if (constraint != null) {
                switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                    case 1:
                    case 2:
                        this.mLeftToLeft = null;
                        this.mLeftToRight = null;
                        this.mMarginLeft = 0;
                        this.mMarginLeftGone = 0;
                        break;
                    case 3:
                    case 4:
                        this.mRightToLeft = null;
                        this.mRightToRight = null;
                        this.mMarginRight = 0;
                        this.mMarginRightGone = 0;
                        break;
                    case 5:
                    case 6:
                        this.mStartToStart = null;
                        this.mStartToEnd = null;
                        this.mMarginStart = 0;
                        this.mMarginStartGone = 0;
                        break;
                    case 7:
                    case 8:
                        this.mEndToStart = null;
                        this.mEndToEnd = null;
                        this.mMarginEnd = 0;
                        this.mMarginEndGone = 0;
                        break;
                    case 9:
                    case 10:
                        this.mTopToTop = null;
                        this.mTopToBottom = null;
                        this.mMarginTop = 0;
                        this.mMarginTopGone = 0;
                        break;
                    case 11:
                    case 12:
                        this.mBottomToTop = null;
                        this.mBottomToBottom = null;
                        this.mMarginBottom = 0;
                        this.mMarginBottomGone = 0;
                        break;
                    case 13:
                        this.mBaselineToBaseline = null;
                        break;
                }
            } else {
                this.mLeftToLeft = null;
                this.mLeftToRight = null;
                this.mMarginLeft = 0;
                this.mRightToLeft = null;
                this.mRightToRight = null;
                this.mMarginRight = 0;
                this.mStartToStart = null;
                this.mStartToEnd = null;
                this.mMarginStart = 0;
                this.mEndToStart = null;
                this.mEndToEnd = null;
                this.mMarginEnd = 0;
                this.mTopToTop = null;
                this.mTopToBottom = null;
                this.mMarginTop = 0;
                this.mBottomToTop = null;
                this.mBottomToBottom = null;
                this.mMarginBottom = 0;
                this.mBaselineToBaseline = null;
                this.mHorizontalBias = 0.5f;
                this.mVerticalBias = 0.5f;
                this.mMarginLeftGone = 0;
                this.mMarginRightGone = 0;
                this.mMarginStartGone = 0;
                this.mMarginEndGone = 0;
                this.mMarginTopGone = 0;
                this.mMarginBottomGone = 0;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference clearHorizontal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            start().clear();
            end().clear();
            left().clear();
            right().clear();
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference clearVertical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            top().clear();
            baseline().clear();
            bottom().clear();
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintWidget createConstraintWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new ConstraintWidget(getWidth().getValue(), getHeight().getValue()) : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintReference end() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mEndToStart != null) {
                this.mLast = State.Constraint.END_TO_START;
            } else {
                this.mLast = State.Constraint.END_TO_END;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference endToEnd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            this.mLast = State.Constraint.END_TO_END;
            this.mEndToEnd = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference endToStart(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            this.mLast = State.Constraint.END_TO_START;
            this.mEndToStart = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mConstraintWidget == null) {
                ConstraintWidget createConstraintWidget = createConstraintWidget();
                this.mConstraintWidget = createConstraintWidget;
                createConstraintWidget.setCompanionWidget(this.mView);
            }
            return this.mConstraintWidget;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    public Dimension getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mVerticalDimension : (Dimension) invokeV.objValue;
    }

    public int getHorizontalChainStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mHorizontalChainStyle : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.key : invokeV.objValue;
    }

    public int getVerticalChainStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.mVerticalChainStyle : invokeI.intValue;
    }

    public Object getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mView : invokeV.objValue;
    }

    public Dimension getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mHorizontalDimension : (Dimension) invokeV.objValue;
    }

    public ConstraintReference height(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, dimension)) == null) ? setHeight(dimension) : (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference horizontalBias(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f2)) == null) {
            this.mHorizontalBias = f2;
            return this;
        }
        return (ConstraintReference) invokeF.objValue;
    }

    public ConstraintReference left() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.mLeftToLeft != null) {
                this.mLast = State.Constraint.LEFT_TO_LEFT;
            } else {
                this.mLast = State.Constraint.LEFT_TO_RIGHT;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference leftToLeft(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            this.mLast = State.Constraint.LEFT_TO_LEFT;
            this.mLeftToLeft = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference leftToRight(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            this.mLast = State.Constraint.LEFT_TO_RIGHT;
            this.mLeftToRight = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference margin(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) ? margin(this.mState.convertDimension(obj)) : (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference marginGone(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            State.Constraint constraint = this.mLast;
            if (constraint != null) {
                switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                    case 1:
                    case 2:
                        this.mMarginLeftGone = i2;
                        break;
                    case 3:
                    case 4:
                        this.mMarginRightGone = i2;
                        break;
                    case 5:
                    case 6:
                        this.mMarginStartGone = i2;
                        break;
                    case 7:
                    case 8:
                        this.mMarginEndGone = i2;
                        break;
                    case 9:
                    case 10:
                        this.mMarginTopGone = i2;
                        break;
                    case 11:
                    case 12:
                        this.mMarginBottomGone = i2;
                        break;
                }
            } else {
                this.mMarginLeftGone = i2;
                this.mMarginRightGone = i2;
                this.mMarginStartGone = i2;
                this.mMarginEndGone = i2;
                this.mMarginTopGone = i2;
                this.mMarginBottomGone = i2;
            }
            return this;
        }
        return (ConstraintReference) invokeI.objValue;
    }

    public ConstraintReference right() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.mRightToLeft != null) {
                this.mLast = State.Constraint.RIGHT_TO_LEFT;
            } else {
                this.mLast = State.Constraint.RIGHT_TO_RIGHT;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference rightToLeft(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, obj)) == null) {
            this.mLast = State.Constraint.RIGHT_TO_LEFT;
            this.mRightToLeft = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference rightToRight(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
            this.mLast = State.Constraint.RIGHT_TO_RIGHT;
            this.mRightToRight = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, constraintWidget) == null) || constraintWidget == null) {
            return;
        }
        this.mConstraintWidget = constraintWidget;
        constraintWidget.setCompanionWidget(this.mView);
    }

    public ConstraintReference setHeight(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, dimension)) == null) {
            this.mVerticalDimension = dimension;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public void setHorizontalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mHorizontalChainStyle = i2;
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, obj) == null) {
            this.key = obj;
        }
    }

    public void setVerticalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mVerticalChainStyle = i2;
        }
    }

    public void setView(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, obj) == null) {
            this.mView = obj;
            ConstraintWidget constraintWidget = this.mConstraintWidget;
            if (constraintWidget != null) {
                constraintWidget.setCompanionWidget(obj);
            }
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, dimension)) == null) {
            this.mHorizontalDimension = dimension;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.mStartToStart != null) {
                this.mLast = State.Constraint.START_TO_START;
            } else {
                this.mLast = State.Constraint.START_TO_END;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference startToEnd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, obj)) == null) {
            this.mLast = State.Constraint.START_TO_END;
            this.mStartToEnd = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference startToStart(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, obj)) == null) {
            this.mLast = State.Constraint.START_TO_START;
            this.mStartToStart = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference top() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.mTopToTop != null) {
                this.mLast = State.Constraint.TOP_TO_TOP;
            } else {
                this.mLast = State.Constraint.TOP_TO_BOTTOM;
            }
            return this;
        }
        return (ConstraintReference) invokeV.objValue;
    }

    public ConstraintReference topToBottom(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, obj)) == null) {
            this.mLast = State.Constraint.TOP_TO_BOTTOM;
            this.mTopToBottom = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference topToTop(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, obj)) == null) {
            this.mLast = State.Constraint.TOP_TO_TOP;
            this.mTopToTop = obj;
            return this;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public void validate() throws IncorrectConstraintException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.mLeftToLeft != null && this.mLeftToRight != null) {
                arrayList.add("LeftToLeft and LeftToRight both defined");
            }
            if (this.mRightToLeft != null && this.mRightToRight != null) {
                arrayList.add("RightToLeft and RightToRight both defined");
            }
            if (this.mStartToStart != null && this.mStartToEnd != null) {
                arrayList.add("StartToStart and StartToEnd both defined");
            }
            if (this.mEndToStart != null && this.mEndToEnd != null) {
                arrayList.add("EndToStart and EndToEnd both defined");
            }
            if ((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
                arrayList.add("Both left/right and start/end constraints defined");
            }
            if (arrayList.size() > 0) {
                throw new IncorrectConstraintException(this, arrayList);
            }
        }
    }

    public ConstraintReference verticalBias(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048624, this, f2)) == null) {
            this.mVerticalBias = f2;
            return this;
        }
        return (ConstraintReference) invokeF.objValue;
    }

    public ConstraintReference width(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, dimension)) == null) ? setWidth(dimension) : (ConstraintReference) invokeL.objValue;
    }

    public ConstraintReference margin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            State.Constraint constraint = this.mLast;
            if (constraint != null) {
                switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                    case 1:
                    case 2:
                        this.mMarginLeft = i2;
                        break;
                    case 3:
                    case 4:
                        this.mMarginRight = i2;
                        break;
                    case 5:
                    case 6:
                        this.mMarginStart = i2;
                        break;
                    case 7:
                    case 8:
                        this.mMarginEnd = i2;
                        break;
                    case 9:
                    case 10:
                        this.mMarginTop = i2;
                        break;
                    case 11:
                    case 12:
                        this.mMarginBottom = i2;
                        break;
                }
            } else {
                this.mMarginLeft = i2;
                this.mMarginRight = i2;
                this.mMarginStart = i2;
                this.mMarginEnd = i2;
                this.mMarginTop = i2;
                this.mMarginBottom = i2;
            }
            return this;
        }
        return (ConstraintReference) invokeI.objValue;
    }
}
