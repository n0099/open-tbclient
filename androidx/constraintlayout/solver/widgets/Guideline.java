package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
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
public class Guideline extends ConstraintWidget {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintAnchor mAnchor;
    public Rectangle mHead;
    public int mHeadSize;
    public boolean mIsPositionRelaxed;
    public int mMinimumPosition;
    public int mOrientation;
    public int mRelativeBegin;
    public int mRelativeEnd;
    public float mRelativePercent;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-208044244, "Landroidx/constraintlayout/solver/widgets/Guideline$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-208044244, "Landroidx/constraintlayout/solver/widgets/Guideline$1;");
                    return;
                }
            }
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.mAnchor = this.mTop;
        this.mOrientation = 0;
        this.mIsPositionRelaxed = false;
        this.mMinimumPosition = 0;
        this.mHead = new Rectangle();
        this.mHeadSize = 8;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mListAnchors[i3] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, linearSystem) == null) || (constraintWidgetContainer = (ConstraintWidgetContainer) getParent()) == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z = true;
        boolean z2 = constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.mOrientation == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.mParent;
            z2 = (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ? false : false;
        }
        if (this.mRelativeBegin != -1) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
            linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 6);
            if (z2) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
            }
        } else if (this.mRelativeEnd != -1) {
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(createObjectVariable2, createObjectVariable3, -this.mRelativeEnd, 6);
            if (z2) {
                linearSystem.addGreaterThan(createObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, 0, 5);
            }
        } else if (this.mRelativePercent != -1.0f) {
            linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor), linearSystem.createObjectVariable(anchor2), this.mRelativePercent, this.mIsPositionRelaxed));
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        ConstraintWidget parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (parent = getParent()) == null) {
            return;
        }
        if (getOrientation() == 1) {
            this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), 0);
            this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), 0);
            if (this.mRelativeBegin != -1) {
                this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), this.mRelativeBegin);
                this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), this.mRelativeBegin);
                return;
            } else if (this.mRelativeEnd != -1) {
                this.mLeft.getResolutionNode().dependsOn(1, parent.mRight.getResolutionNode(), -this.mRelativeEnd);
                this.mRight.getResolutionNode().dependsOn(1, parent.mRight.getResolutionNode(), -this.mRelativeEnd);
                return;
            } else if (this.mRelativePercent == -1.0f || parent.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
                return;
            } else {
                int i2 = (int) (parent.mWidth * this.mRelativePercent);
                this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), i2);
                this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), i2);
                return;
            }
        }
        this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), 0);
        this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), 0);
        if (this.mRelativeBegin != -1) {
            this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), this.mRelativeBegin);
            this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), this.mRelativeBegin);
        } else if (this.mRelativeEnd != -1) {
            this.mTop.getResolutionNode().dependsOn(1, parent.mBottom.getResolutionNode(), -this.mRelativeEnd);
            this.mBottom.getResolutionNode().dependsOn(1, parent.mBottom.getResolutionNode(), -this.mRelativeEnd);
        } else if (this.mRelativePercent == -1.0f || parent.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
        } else {
            int i3 = (int) (parent.mHeight * this.mRelativePercent);
            this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), i3);
            this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), i3);
        }
    }

    public void cyclePosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mRelativeBegin != -1) {
                inferRelativePercentPosition();
            } else if (this.mRelativePercent != -1.0f) {
                inferRelativeEndPosition();
            } else if (this.mRelativeEnd != -1) {
                inferRelativeBeginPosition();
            }
        }
    }

    public ConstraintAnchor getAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAnchor : (ConstraintAnchor) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> getAnchors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAnchors : (ArrayList) invokeV.objValue;
    }

    public Rectangle getHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Rectangle rectangle = this.mHead;
            int drawX = getDrawX() - this.mHeadSize;
            int drawY = getDrawY();
            int i = this.mHeadSize;
            rectangle.setBounds(drawX, drawY - (i * 2), i * 2, i * 2);
            if (getOrientation() == 0) {
                Rectangle rectangle2 = this.mHead;
                int drawX2 = getDrawX() - (this.mHeadSize * 2);
                int drawY2 = getDrawY();
                int i2 = this.mHeadSize;
                rectangle2.setBounds(drawX2, drawY2 - i2, i2 * 2, i2 * 2);
            }
            return this.mHead;
        }
        return (Rectangle) invokeV.objValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mOrientation : invokeV.intValue;
    }

    public int getRelativeBegin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRelativeBegin : invokeV.intValue;
    }

    public int getRelativeBehaviour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mRelativePercent != -1.0f) {
                return 0;
            }
            if (this.mRelativeBegin != -1) {
                return 1;
            }
            return this.mRelativeEnd != -1 ? 2 : -1;
        }
        return invokeV.intValue;
    }

    public int getRelativeEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRelativeEnd : invokeV.intValue;
    }

    public float getRelativePercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRelativePercent : invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "Guideline" : (String) invokeV.objValue;
    }

    public void inferRelativeBeginPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int x = getX();
            if (this.mOrientation == 0) {
                x = getY();
            }
            setGuideBegin(x);
        }
    }

    public void inferRelativeEndPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int width = getParent().getWidth() - getX();
            if (this.mOrientation == 0) {
                width = getParent().getHeight() - getY();
            }
            setGuideEnd(width);
        }
    }

    public void inferRelativePercentPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float x = getX() / getParent().getWidth();
            if (this.mOrientation == 0) {
                x = getY() / getParent().getHeight();
            }
            setGuidePercent(x);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDrawOrigin(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            if (this.mOrientation == 1) {
                int i3 = i - this.mOffsetX;
                if (this.mRelativeBegin != -1) {
                    setGuideBegin(i3);
                    return;
                } else if (this.mRelativeEnd != -1) {
                    setGuideEnd(getParent().getWidth() - i3);
                    return;
                } else if (this.mRelativePercent != -1.0f) {
                    setGuidePercent(i3 / getParent().getWidth());
                    return;
                } else {
                    return;
                }
            }
            int i4 = i2 - this.mOffsetY;
            if (this.mRelativeBegin != -1) {
                setGuideBegin(i4);
            } else if (this.mRelativeEnd != -1) {
                setGuideEnd(getParent().getHeight() - i4);
            } else if (this.mRelativePercent != -1.0f) {
                setGuidePercent(i4 / getParent().getHeight());
            }
        }
    }

    public void setGuideBegin(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || i <= -1) {
            return;
        }
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = i;
        this.mRelativeEnd = -1;
    }

    public void setGuideEnd(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || i <= -1) {
            return;
        }
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = i;
    }

    public void setGuidePercent(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            setGuidePercent(i / 100.0f);
        }
    }

    public void setMinimumPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.mMinimumPosition = i;
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        this.mAnchors.clear();
        if (this.mOrientation == 1) {
            this.mAnchor = this.mLeft;
        } else {
            this.mAnchor = this.mTop;
        }
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mListAnchors[i2] = this.mAnchor;
        }
    }

    public void setPositionRelaxed(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.mIsPositionRelaxed == z) {
            return;
        }
        this.mIsPositionRelaxed = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, linearSystem) == null) || getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, type)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
                case 1:
                case 2:
                    if (this.mOrientation == 1) {
                        return this.mAnchor;
                    }
                    break;
                case 3:
                case 4:
                    if (this.mOrientation == 0) {
                        return this.mAnchor;
                    }
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return null;
            }
            throw new AssertionError(type.name());
        }
        return (ConstraintAnchor) invokeL.objValue;
    }

    public void setGuidePercent(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f) == null) || f <= -1.0f) {
            return;
        }
        this.mRelativePercent = f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
    }
}
