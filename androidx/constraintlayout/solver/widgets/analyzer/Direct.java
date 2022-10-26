package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class Direct {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean APPLY_MATCH_PARENT = false;
    public static final boolean DEBUG = false;
    public static BasicMeasure.Measure measure;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1400568169, "Landroidx/constraintlayout/solver/widgets/analyzer/Direct;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1400568169, "Landroidx/constraintlayout/solver/widgets/analyzer/Direct;");
                return;
            }
        }
        measure = new BasicMeasure.Measure();
    }

    public Direct() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean canMeasure(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, constraintWidget)) == null) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
            if (constraintWidget.getParent() != null) {
                constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
            } else {
                constraintWidgetContainer = null;
            }
            if (constraintWidgetContainer != null) {
                constraintWidgetContainer.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            if (constraintWidgetContainer != null) {
                constraintWidgetContainer.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mDimensionRatio != 0.0f || !constraintWidget.hasDanglingDimension(0)) && !constraintWidget.isResolvedHorizontally())) {
                z = false;
            } else {
                z = true;
            }
            if (verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mDimensionRatio != 0.0f || !constraintWidget.hasDanglingDimension(1)) && !constraintWidget.isResolvedVertically())) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (constraintWidget.mDimensionRatio > 0.0f && (z || z2)) {
                return true;
            }
            if (!z || !z2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void horizontalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        boolean z2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        boolean z3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, constraintWidget, measurer, z) == null) {
            if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
                ConstraintWidgetContainer.measure(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget2 = next.mOwner;
                    boolean canMeasure = canMeasure(constraintWidget2);
                    if (constraintWidget2.isMeasureRequested() && canMeasure) {
                        ConstraintWidgetContainer.measure(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if (constraintWidget2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !canMeasure) {
                        if (constraintWidget2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                            if (!constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout()) {
                                if ((next == constraintWidget2.mLeft && (constraintAnchor5 = constraintWidget2.mRight.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor4 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor4.hasFinalValue())) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3 && !constraintWidget2.isInHorizontalChain()) {
                                    solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget2, z);
                                }
                            }
                        }
                    } else if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.mLeft;
                        if (next == constraintAnchor6 && constraintWidget2.mRight.mTarget == null) {
                            int margin = constraintAnchor6.getMargin() + finalValue;
                            constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                            horizontalSolvingPass(constraintWidget2, measurer, z);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.mRight;
                            if (next == constraintAnchor7 && constraintWidget2.mLeft.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor7.getMargin();
                                constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                                horizontalSolvingPass(constraintWidget2, measurer, z);
                            } else if (next == constraintWidget2.mLeft && (constraintAnchor3 = constraintWidget2.mRight.mTarget) != null && constraintAnchor3.hasFinalValue() && !constraintWidget2.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(measurer, constraintWidget2, z);
                            }
                        }
                    }
                }
            }
            if (!(constraintWidget instanceof Guideline) && anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                while (it2.hasNext()) {
                    ConstraintAnchor next2 = it2.next();
                    ConstraintWidget constraintWidget3 = next2.mOwner;
                    boolean canMeasure2 = canMeasure(constraintWidget3);
                    if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                        ConstraintWidgetContainer.measure(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue())) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintWidget3.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !canMeasure2) {
                        if (constraintWidget3.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                            if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z2 && !constraintWidget3.isInHorizontalChain()) {
                                solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget3, z);
                            }
                        }
                    } else if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.mLeft;
                        if (next2 == constraintAnchor8 && constraintWidget3.mRight.mTarget == null) {
                            int margin3 = constraintAnchor8.getMargin() + finalValue2;
                            constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                            horizontalSolvingPass(constraintWidget3, measurer, z);
                        } else {
                            ConstraintAnchor constraintAnchor9 = constraintWidget3.mRight;
                            if (next2 == constraintAnchor9 && constraintWidget3.mLeft.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor9.getMargin();
                                constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                                horizontalSolvingPass(constraintWidget3, measurer, z);
                            } else if (z2 && !constraintWidget3.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(measurer, constraintWidget3, z);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void solveBarrier(Barrier barrier, BasicMeasure.Measurer measurer, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{barrier, measurer, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && barrier.allSolved()) {
            if (i == 0) {
                horizontalSolvingPass(barrier, measurer, z);
            } else {
                verticalSolvingPass(barrier, measurer);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01db, code lost:
        if (r6[r21].mTarget.mOwner == r2) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean solveChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        int finalValue;
        int finalValue2;
        int finalValue3;
        int i3;
        int height;
        ConstraintWidget constraintWidget;
        float verticalBiasPercent;
        int height2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{constraintWidgetContainer, linearSystem, Integer.valueOf(i), Integer.valueOf(i2), chainHead, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z3) {
                return false;
            }
            if (i == 0) {
                if (!constraintWidgetContainer.isResolvedHorizontally()) {
                    return false;
                }
            } else if (!constraintWidgetContainer.isResolvedVertically()) {
                return false;
            }
            boolean isRtl = constraintWidgetContainer.isRtl();
            ConstraintWidget first = chainHead.getFirst();
            ConstraintWidget last = chainHead.getLast();
            ConstraintWidget firstVisibleWidget = chainHead.getFirstVisibleWidget();
            ConstraintWidget lastVisibleWidget = chainHead.getLastVisibleWidget();
            ConstraintWidget head = chainHead.getHead();
            ConstraintAnchor constraintAnchor = first.mListAnchors[i2];
            int i4 = i2 + 1;
            ConstraintAnchor constraintAnchor2 = last.mListAnchors[i4];
            ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
            if (constraintAnchor3 == null || constraintAnchor2.mTarget == null || !constraintAnchor3.hasFinalValue() || !constraintAnchor2.mTarget.hasFinalValue() || firstVisibleWidget == null || lastVisibleWidget == null || (finalValue3 = (finalValue2 = constraintAnchor2.mTarget.getFinalValue() - lastVisibleWidget.mListAnchors[i4].getMargin()) - (finalValue = constraintAnchor.mTarget.getFinalValue() + firstVisibleWidget.mListAnchors[i2].getMargin())) <= 0) {
                return false;
            }
            BasicMeasure.Measure measure2 = new BasicMeasure.Measure();
            ConstraintWidget constraintWidget2 = first;
            boolean z4 = false;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                ConstraintWidget constraintWidget3 = null;
                if (!z4) {
                    ConstraintAnchor constraintAnchor4 = constraintWidget2.mListAnchors[i2];
                    if (!canMeasure(constraintWidget2)) {
                        return false;
                    }
                    ConstraintWidget constraintWidget4 = first;
                    if (constraintWidget2.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        return false;
                    }
                    if (constraintWidget2.isMeasureRequested()) {
                        ConstraintWidgetContainer.measure(constraintWidget2, constraintWidgetContainer.getMeasurer(), measure2, BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    int margin = i7 + constraintWidget2.mListAnchors[i2].getMargin();
                    if (i == 0) {
                        height2 = constraintWidget2.getWidth();
                    } else {
                        height2 = constraintWidget2.getHeight();
                    }
                    i7 = margin + height2 + constraintWidget2.mListAnchors[i4].getMargin();
                    i6++;
                    if (constraintWidget2.getVisibility() != 8) {
                        i5++;
                    }
                    ConstraintAnchor constraintAnchor5 = constraintWidget2.mListAnchors[i4].mTarget;
                    if (constraintAnchor5 != null) {
                        ConstraintWidget constraintWidget5 = constraintAnchor5.mOwner;
                        ConstraintAnchor[] constraintAnchorArr = constraintWidget5.mListAnchors;
                        if (constraintAnchorArr[i2].mTarget != null && constraintAnchorArr[i2].mTarget.mOwner == constraintWidget2) {
                            constraintWidget3 = constraintWidget5;
                        }
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget2 = constraintWidget3;
                    } else {
                        z4 = true;
                    }
                    first = constraintWidget4;
                } else {
                    ConstraintWidget constraintWidget6 = first;
                    if (i5 == 0 || i5 != i6 || finalValue3 < i7) {
                        return false;
                    }
                    int i8 = finalValue3 - i7;
                    if (z) {
                        i8 /= i5 + 1;
                    } else if (z2 && i5 > 2) {
                        i3 = 1;
                        i8 = (i8 / i5) - 1;
                        if (i5 != i3) {
                            if (i == 0) {
                                verticalBiasPercent = head.getHorizontalBiasPercent();
                            } else {
                                verticalBiasPercent = head.getVerticalBiasPercent();
                            }
                            int i9 = (int) (finalValue + 0.5f + (i8 * verticalBiasPercent));
                            if (i == 0) {
                                firstVisibleWidget.setFinalHorizontal(i9, firstVisibleWidget.getWidth() + i9);
                            } else {
                                firstVisibleWidget.setFinalVertical(i9, firstVisibleWidget.getHeight() + i9);
                            }
                            horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                            return true;
                        }
                        if (z) {
                            int i10 = finalValue + i8;
                            ConstraintWidget constraintWidget7 = constraintWidget6;
                            boolean z5 = false;
                            while (!z5) {
                                ConstraintAnchor constraintAnchor6 = constraintWidget7.mListAnchors[i2];
                                if (constraintWidget7.getVisibility() == 8) {
                                    if (i == 0) {
                                        constraintWidget7.setFinalHorizontal(i10, i10);
                                        horizontalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                    } else {
                                        constraintWidget7.setFinalVertical(i10, i10);
                                        verticalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer());
                                    }
                                } else {
                                    int margin2 = i10 + constraintWidget7.mListAnchors[i2].getMargin();
                                    if (i == 0) {
                                        constraintWidget7.setFinalHorizontal(margin2, constraintWidget7.getWidth() + margin2);
                                        horizontalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                        height = constraintWidget7.getWidth();
                                    } else {
                                        constraintWidget7.setFinalVertical(margin2, constraintWidget7.getHeight() + margin2);
                                        verticalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer());
                                        height = constraintWidget7.getHeight();
                                    }
                                    i10 = margin2 + height + constraintWidget7.mListAnchors[i4].getMargin() + i8;
                                }
                                constraintWidget7.addToSolver(linearSystem, false);
                                ConstraintAnchor constraintAnchor7 = constraintWidget7.mListAnchors[i4].mTarget;
                                if (constraintAnchor7 != null) {
                                    constraintWidget = constraintAnchor7.mOwner;
                                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.mListAnchors;
                                    if (constraintAnchorArr2[i2].mTarget != null) {
                                    }
                                }
                                constraintWidget = null;
                                if (constraintWidget != null) {
                                    constraintWidget7 = constraintWidget;
                                } else {
                                    z5 = true;
                                }
                            }
                        } else if (z2) {
                            if (i5 == 2) {
                                if (i == 0) {
                                    firstVisibleWidget.setFinalHorizontal(finalValue, firstVisibleWidget.getWidth() + finalValue);
                                    lastVisibleWidget.setFinalHorizontal(finalValue2 - lastVisibleWidget.getWidth(), finalValue2);
                                    horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                    horizontalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                    return true;
                                }
                                firstVisibleWidget.setFinalVertical(finalValue, firstVisibleWidget.getHeight() + finalValue);
                                lastVisibleWidget.setFinalVertical(finalValue2 - lastVisibleWidget.getHeight(), finalValue2);
                                verticalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer());
                                verticalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer());
                                return true;
                            }
                            return false;
                        }
                        return true;
                    }
                    i3 = 1;
                    if (i5 != i3) {
                    }
                }
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }

    public static void solveHorizontalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, measurer, constraintWidget, z) == null) {
            float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
            int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
            int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
            int margin = constraintWidget.mLeft.getMargin() + finalValue;
            int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
            if (finalValue == finalValue2) {
                horizontalBiasPercent = 0.5f;
            } else {
                finalValue = margin;
                finalValue2 = margin2;
            }
            int width = constraintWidget.getWidth();
            int i = (finalValue2 - finalValue) - width;
            if (finalValue > finalValue2) {
                i = (finalValue - finalValue2) - width;
            }
            int i2 = ((int) ((horizontalBiasPercent * i) + 0.5f)) + finalValue;
            int i3 = i2 + width;
            if (finalValue > finalValue2) {
                i3 = i2 - width;
            }
            constraintWidget.setFinalHorizontal(i2, i3);
            horizontalSolvingPass(constraintWidget, measurer, z);
        }
    }

    public static void solveHorizontalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{constraintWidget, measurer, constraintWidget2, Boolean.valueOf(z)}) == null) {
            float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
            int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
            int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
            if (finalValue2 >= finalValue) {
                int width2 = constraintWidget2.getWidth();
                if (constraintWidget2.getVisibility() != 8) {
                    int i = constraintWidget2.mMatchConstraintDefaultWidth;
                    if (i == 2) {
                        if (constraintWidget instanceof ConstraintWidgetContainer) {
                            width = constraintWidget.getWidth();
                        } else {
                            width = constraintWidget.getParent().getWidth();
                        }
                        width2 = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * width);
                    } else if (i == 0) {
                        width2 = finalValue2 - finalValue;
                    }
                    width2 = Math.max(constraintWidget2.mMatchConstraintMinWidth, width2);
                    int i2 = constraintWidget2.mMatchConstraintMaxWidth;
                    if (i2 > 0) {
                        width2 = Math.min(i2, width2);
                    }
                }
                int i3 = finalValue + ((int) ((horizontalBiasPercent * ((finalValue2 - finalValue) - width2)) + 0.5f));
                constraintWidget2.setFinalHorizontal(i3, width2 + i3);
                horizontalSolvingPass(constraintWidget2, measurer, z);
            }
        }
    }

    public static void solveVerticalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, measurer, constraintWidget) == null) {
            float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
            int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
            int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
            int margin = constraintWidget.mTop.getMargin() + finalValue;
            int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
            if (finalValue == finalValue2) {
                verticalBiasPercent = 0.5f;
            } else {
                finalValue = margin;
                finalValue2 = margin2;
            }
            int height = constraintWidget.getHeight();
            int i = (finalValue2 - finalValue) - height;
            if (finalValue > finalValue2) {
                i = (finalValue - finalValue2) - height;
            }
            int i2 = (int) ((verticalBiasPercent * i) + 0.5f);
            int i3 = finalValue + i2;
            int i4 = i3 + height;
            if (finalValue > finalValue2) {
                i3 = finalValue - i2;
                i4 = i3 - height;
            }
            constraintWidget.setFinalVertical(i3, i4);
            verticalSolvingPass(constraintWidget, measurer);
        }
    }

    public static void solveVerticalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, constraintWidget, measurer, constraintWidget2) == null) {
            float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
            int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
            int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
            if (finalValue2 >= finalValue) {
                int height2 = constraintWidget2.getHeight();
                if (constraintWidget2.getVisibility() != 8) {
                    int i = constraintWidget2.mMatchConstraintDefaultHeight;
                    if (i == 2) {
                        if (constraintWidget instanceof ConstraintWidgetContainer) {
                            height = constraintWidget.getHeight();
                        } else {
                            height = constraintWidget.getParent().getHeight();
                        }
                        height2 = (int) (verticalBiasPercent * 0.5f * height);
                    } else if (i == 0) {
                        height2 = finalValue2 - finalValue;
                    }
                    height2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, height2);
                    int i2 = constraintWidget2.mMatchConstraintMaxHeight;
                    if (i2 > 0) {
                        height2 = Math.min(i2, height2);
                    }
                }
                int i3 = finalValue + ((int) ((verticalBiasPercent * ((finalValue2 - finalValue) - height2)) + 0.5f));
                constraintWidget2.setFinalVertical(i3, height2 + i3);
                verticalSolvingPass(constraintWidget2, measurer);
            }
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, constraintWidgetContainer, measurer) == null) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
            constraintWidgetContainer.resetFinalResolution();
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                children.get(i).resetFinalResolution();
            }
            boolean isRtl = constraintWidgetContainer.isRtl();
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
            } else {
                constraintWidgetContainer.setFinalLeft(0);
            }
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = children.get(i2);
                if (constraintWidget instanceof Guideline) {
                    Guideline guideline = (Guideline) constraintWidget;
                    if (guideline.getOrientation() == 1) {
                        if (guideline.getRelativeBegin() != -1) {
                            guideline.setFinalValue(guideline.getRelativeBegin());
                        } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                            guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                        } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                            guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                        }
                        z = true;
                    }
                } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                    z2 = true;
                }
            }
            if (z) {
                for (int i3 = 0; i3 < size; i3++) {
                    ConstraintWidget constraintWidget2 = children.get(i3);
                    if (constraintWidget2 instanceof Guideline) {
                        Guideline guideline2 = (Guideline) constraintWidget2;
                        if (guideline2.getOrientation() == 1) {
                            horizontalSolvingPass(guideline2, measurer, isRtl);
                        }
                    }
                }
            }
            horizontalSolvingPass(constraintWidgetContainer, measurer, isRtl);
            if (z2) {
                for (int i4 = 0; i4 < size; i4++) {
                    ConstraintWidget constraintWidget3 = children.get(i4);
                    if (constraintWidget3 instanceof Barrier) {
                        Barrier barrier = (Barrier) constraintWidget3;
                        if (barrier.getOrientation() == 0) {
                            solveBarrier(barrier, measurer, 0, isRtl);
                        }
                    }
                }
            }
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
            } else {
                constraintWidgetContainer.setFinalTop(0);
            }
            boolean z3 = false;
            boolean z4 = false;
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget4 = children.get(i5);
                if (constraintWidget4 instanceof Guideline) {
                    Guideline guideline3 = (Guideline) constraintWidget4;
                    if (guideline3.getOrientation() == 0) {
                        if (guideline3.getRelativeBegin() != -1) {
                            guideline3.setFinalValue(guideline3.getRelativeBegin());
                        } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                            guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                        } else if (constraintWidgetContainer.isResolvedVertically()) {
                            guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                        }
                        z3 = true;
                    }
                } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                    z4 = true;
                }
            }
            if (z3) {
                for (int i6 = 0; i6 < size; i6++) {
                    ConstraintWidget constraintWidget5 = children.get(i6);
                    if (constraintWidget5 instanceof Guideline) {
                        Guideline guideline4 = (Guideline) constraintWidget5;
                        if (guideline4.getOrientation() == 0) {
                            verticalSolvingPass(guideline4, measurer);
                        }
                    }
                }
            }
            verticalSolvingPass(constraintWidgetContainer, measurer);
            if (z4) {
                for (int i7 = 0; i7 < size; i7++) {
                    ConstraintWidget constraintWidget6 = children.get(i7);
                    if (constraintWidget6 instanceof Barrier) {
                        Barrier barrier2 = (Barrier) constraintWidget6;
                        if (barrier2.getOrientation() == 1) {
                            solveBarrier(barrier2, measurer, 1, isRtl);
                        }
                    }
                }
            }
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget7 = children.get(i8);
                if (constraintWidget7.isMeasureRequested() && canMeasure(constraintWidget7)) {
                    ConstraintWidgetContainer.measure(constraintWidget7, measurer, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
                    horizontalSolvingPass(constraintWidget7, measurer, isRtl);
                    verticalSolvingPass(constraintWidget7, measurer);
                }
            }
        }
    }

    public static void verticalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        boolean z2;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, constraintWidget, measurer) == null) {
            if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
                ConstraintWidgetContainer.measure(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget2 = next.mOwner;
                    boolean canMeasure = canMeasure(constraintWidget2);
                    if (constraintWidget2.isMeasureRequested() && canMeasure) {
                        ConstraintWidgetContainer.measure(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !canMeasure) {
                        if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                            if (!constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout()) {
                                if ((next == constraintWidget2.mTop && (constraintAnchor5 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor4 = constraintWidget2.mTop.mTarget) != null && constraintAnchor4.hasFinalValue())) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2 && !constraintWidget2.isInVerticalChain()) {
                                    solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget2);
                                }
                            }
                        }
                    } else if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.mTop;
                        if (next == constraintAnchor6 && constraintWidget2.mBottom.mTarget == null) {
                            int margin = constraintAnchor6.getMargin() + finalValue;
                            constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                            verticalSolvingPass(constraintWidget2, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.mBottom;
                            if (next == constraintAnchor7 && constraintAnchor7.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor7.getMargin();
                                constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                                verticalSolvingPass(constraintWidget2, measurer);
                            } else if (next == constraintWidget2.mTop && (constraintAnchor3 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor3.hasFinalValue()) {
                                solveVerticalCenterConstraints(measurer, constraintWidget2);
                            }
                        }
                    }
                }
            }
            if (constraintWidget instanceof Guideline) {
                return;
            }
            if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                while (it2.hasNext()) {
                    ConstraintAnchor next2 = it2.next();
                    ConstraintWidget constraintWidget3 = next2.mOwner;
                    boolean canMeasure2 = canMeasure(constraintWidget3);
                    if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                        ConstraintWidgetContainer.measure(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (constraintWidget3.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !canMeasure2) {
                        if (constraintWidget3.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                            if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z && !constraintWidget3.isInVerticalChain()) {
                                solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget3);
                            }
                        }
                    } else if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.mTop;
                        if (next2 == constraintAnchor8 && constraintWidget3.mBottom.mTarget == null) {
                            int margin3 = constraintAnchor8.getMargin() + finalValue2;
                            constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                            verticalSolvingPass(constraintWidget3, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor9 = constraintWidget3.mBottom;
                            if (next2 == constraintAnchor9 && constraintWidget3.mTop.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor9.getMargin();
                                constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                                verticalSolvingPass(constraintWidget3, measurer);
                            } else if (z && !constraintWidget3.isInVerticalChain()) {
                                solveVerticalCenterConstraints(measurer, constraintWidget3);
                            }
                        }
                    }
                }
            }
            ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
            if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
                int finalValue3 = anchor3.getFinalValue();
                Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
                while (it3.hasNext()) {
                    ConstraintAnchor next3 = it3.next();
                    ConstraintWidget constraintWidget4 = next3.mOwner;
                    boolean canMeasure3 = canMeasure(constraintWidget4);
                    if (constraintWidget4.isMeasureRequested() && canMeasure3) {
                        ConstraintWidgetContainer.measure(constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if (constraintWidget4.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) {
                        if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.mBaseline) {
                            constraintWidget4.setFinalBaseline(finalValue3);
                            verticalSolvingPass(constraintWidget4, measurer);
                        }
                    }
                }
            }
        }
    }
}
