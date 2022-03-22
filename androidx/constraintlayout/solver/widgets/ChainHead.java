package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChainHead {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mDefined;
    public ConstraintWidget mFirst;
    public ConstraintWidget mFirstMatchConstraintWidget;
    public ConstraintWidget mFirstVisibleWidget;
    public boolean mHasComplexMatchWeights;
    public boolean mHasDefinedWeights;
    public boolean mHasUndefinedWeights;
    public ConstraintWidget mHead;
    public boolean mIsRtl;
    public ConstraintWidget mLast;
    public ConstraintWidget mLastMatchConstraintWidget;
    public ConstraintWidget mLastVisibleWidget;
    public int mOrientation;
    public float mTotalWeight;
    public ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    public int mWidgetsCount;
    public int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTotalWeight = 0.0f;
        this.mIsRtl = false;
        this.mFirst = constraintWidget;
        this.mOrientation = i;
        this.mIsRtl = z;
    }

    private void defineChainProperties() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i = this.mOrientation * 2;
            ConstraintWidget constraintWidget = this.mFirst;
            boolean z = false;
            ConstraintWidget constraintWidget2 = constraintWidget;
            boolean z2 = false;
            while (!z2) {
                this.mWidgetsCount++;
                ConstraintWidget[] constraintWidgetArr = constraintWidget.mNextChainWidget;
                int i2 = this.mOrientation;
                ConstraintWidget constraintWidget3 = null;
                constraintWidgetArr[i2] = null;
                constraintWidget.mListNextMatchConstraintsWidget[i2] = null;
                if (constraintWidget.getVisibility() != 8) {
                    if (this.mFirstVisibleWidget == null) {
                        this.mFirstVisibleWidget = constraintWidget;
                    }
                    this.mLastVisibleWidget = constraintWidget;
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                    int i3 = this.mOrientation;
                    if (dimensionBehaviourArr[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
                        if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                            this.mWidgetsMatchCount++;
                            float[] fArr = constraintWidget.mWeight;
                            int i4 = this.mOrientation;
                            float f2 = fArr[i4];
                            if (f2 > 0.0f) {
                                this.mTotalWeight += fArr[i4];
                            }
                            if (isMatchConstraintEqualityCandidate(constraintWidget, this.mOrientation)) {
                                if (f2 < 0.0f) {
                                    this.mHasUndefinedWeights = true;
                                } else {
                                    this.mHasDefinedWeights = true;
                                }
                                if (this.mWeightedMatchConstraintsWidgets == null) {
                                    this.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                                }
                                this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                            }
                            if (this.mFirstMatchConstraintWidget == null) {
                                this.mFirstMatchConstraintWidget = constraintWidget;
                            }
                            ConstraintWidget constraintWidget4 = this.mLastMatchConstraintWidget;
                            if (constraintWidget4 != null) {
                                constraintWidget4.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget;
                            }
                            this.mLastMatchConstraintWidget = constraintWidget;
                        }
                    }
                }
                if (constraintWidget2 != constraintWidget) {
                    constraintWidget2.mNextChainWidget[this.mOrientation] = constraintWidget;
                }
                ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i + 1].mTarget;
                if (constraintAnchor != null) {
                    ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget5.mListAnchors;
                    if (constraintAnchorArr[i].mTarget != null && constraintAnchorArr[i].mTarget.mOwner == constraintWidget) {
                        constraintWidget3 = constraintWidget5;
                    }
                }
                if (constraintWidget3 == null) {
                    constraintWidget3 = constraintWidget;
                    z2 = true;
                }
                constraintWidget2 = constraintWidget;
                constraintWidget = constraintWidget3;
            }
            this.mLast = constraintWidget;
            if (this.mOrientation == 0 && this.mIsRtl) {
                this.mHead = constraintWidget;
            } else {
                this.mHead = this.mFirst;
            }
            if (this.mHasDefinedWeights && this.mHasUndefinedWeights) {
                z = true;
            }
            this.mHasComplexMatchWeights = z;
        }
    }

    public static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, constraintWidget, i)) == null) {
            if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
                if (iArr[i] == 0 || iArr[i] == 3) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void define() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.mDefined) {
                defineChainProperties();
            }
            this.mDefined = true;
        }
    }

    public ConstraintWidget getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFirst : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFirstMatchConstraintWidget : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFirstVisibleWidget : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHead : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLast : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLastMatchConstraintWidget : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getLastVisibleWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLastVisibleWidget : (ConstraintWidget) invokeV.objValue;
    }

    public float getTotalWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTotalWeight : invokeV.floatValue;
    }
}
