package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class Analyzer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Analyzer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, constraintWidgetContainer) == null) {
            if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
                singleGroup(constraintWidgetContainer);
                return;
            }
            constraintWidgetContainer.mSkipSolver = true;
            constraintWidgetContainer.mGroupsWrapOptimized = false;
            constraintWidgetContainer.mHorizontalWrapOptimized = false;
            constraintWidgetContainer.mVerticalWrapOptimized = false;
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
            List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
            boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = z || z2;
            list.clear();
            for (ConstraintWidget constraintWidget : arrayList) {
                constraintWidget.mBelongingGroup = null;
                constraintWidget.mGroupsToSolver = false;
                constraintWidget.resetResolutionNodes();
            }
            for (ConstraintWidget constraintWidget2 : arrayList) {
                if (constraintWidget2.mBelongingGroup == null && !determineGroups(constraintWidget2, list, z3)) {
                    singleGroup(constraintWidgetContainer);
                    constraintWidgetContainer.mSkipSolver = false;
                    return;
                }
            }
            int i = 0;
            int i2 = 0;
            for (ConstraintWidgetGroup constraintWidgetGroup : list) {
                i = Math.max(i, getMaxDimension(constraintWidgetGroup, 0));
                i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 1));
            }
            if (z) {
                constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setWidth(i);
                constraintWidgetContainer.mGroupsWrapOptimized = true;
                constraintWidgetContainer.mHorizontalWrapOptimized = true;
                constraintWidgetContainer.mWrapFixedWidth = i;
            }
            if (z2) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setHeight(i2);
                constraintWidgetContainer.mGroupsWrapOptimized = true;
                constraintWidgetContainer.mVerticalWrapOptimized = true;
                constraintWidgetContainer.mWrapFixedHeight = i2;
            }
            setPosition(list, 0, constraintWidgetContainer.getWidth());
            setPosition(list, 1, constraintWidgetContainer.getHeight());
        }
    }

    public static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, constraintWidgetGroup, i)) == null) {
            int i2 = i * 2;
            List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i);
            int size = startWidgets.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget = startWidgets.get(i4);
                ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
                int i5 = i2 + 1;
                i3 = Math.max(i3, getMaxDimensionTraversal(constraintWidget, i, constraintAnchorArr[i5].mTarget == null || !(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i5].mTarget == null), 0));
            }
            constraintWidgetGroup.mGroupDimensions[i] = i3;
            return i3;
        }
        return invokeLI.intValue;
    }

    public static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        int height;
        int baselineDistance;
        int i3;
        int i4;
        int i5;
        int width;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{constraintWidget, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            int i9 = 0;
            if (constraintWidget.mOptimizerMeasurable) {
                boolean z2 = constraintWidget.mBaseline.mTarget != null && i == 1;
                if (z) {
                    height = constraintWidget.getBaselineDistance();
                    baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
                    i4 = i * 2;
                    i3 = i4 + 1;
                } else {
                    height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
                    baselineDistance = constraintWidget.getBaselineDistance();
                    i3 = i * 2;
                    i4 = i3 + 1;
                }
                ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
                if (constraintAnchorArr[i3].mTarget == null || constraintAnchorArr[i4].mTarget != null) {
                    i5 = 1;
                } else {
                    i5 = -1;
                    int i10 = i3;
                    i3 = i4;
                    i4 = i10;
                }
                int i11 = z2 ? i2 - height : i2;
                int margin = (constraintWidget.mListAnchors[i4].getMargin() * i5) + getParentBiasOffset(constraintWidget, i);
                int i12 = i11 + margin;
                int width2 = (i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i5;
                Iterator<ResolutionNode> it = constraintWidget.mListAnchors[i4].getResolutionNode().dependents.iterator();
                while (it.hasNext()) {
                    i9 = Math.max(i9, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).myAnchor.mOwner, i, z, i12));
                }
                int i13 = 0;
                for (Iterator<ResolutionNode> it2 = constraintWidget.mListAnchors[i3].getResolutionNode().dependents.iterator(); it2.hasNext(); it2 = it2) {
                    i13 = Math.max(i13, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).myAnchor.mOwner, i, z, width2 + i12));
                }
                if (z2) {
                    i9 -= height;
                    width = i13 + baselineDistance;
                } else {
                    width = i13 + ((i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i5);
                }
                int i14 = 1;
                if (i == 1) {
                    Iterator<ResolutionNode> it3 = constraintWidget.mBaseline.getResolutionNode().dependents.iterator();
                    int i15 = 0;
                    while (it3.hasNext()) {
                        Iterator<ResolutionNode> it4 = it3;
                        ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                        if (i5 == i14) {
                            i15 = Math.max(i15, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i, z, height + i12));
                            i8 = i3;
                        } else {
                            i8 = i3;
                            i15 = Math.max(i15, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i, z, (baselineDistance * i5) + i12));
                        }
                        it3 = it4;
                        i3 = i8;
                        i14 = 1;
                    }
                    i6 = i3;
                    int i16 = i15;
                    i7 = (constraintWidget.mBaseline.getResolutionNode().dependents.size() <= 0 || z2) ? i16 : i5 == 1 ? i16 + height : i16 - baselineDistance;
                } else {
                    i6 = i3;
                    i7 = 0;
                }
                int max = margin + Math.max(i9, Math.max(width, i7));
                int i17 = width2 + i12;
                if (i5 == -1) {
                    i17 = i12;
                    i12 = i17;
                }
                if (z) {
                    Optimizer.setOptimizedWidget(constraintWidget, i, i12);
                    constraintWidget.setFrame(i12, i17, i);
                } else {
                    constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i);
                    constraintWidget.setRelativePositioning(i12, i);
                }
                if (constraintWidget.getDimensionBehaviour(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mDimensionRatio != 0.0f) {
                    constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i);
                }
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.mListAnchors;
                if (constraintAnchorArr2[i4].mTarget != null && constraintAnchorArr2[i6].mTarget != null) {
                    ConstraintWidget parent = constraintWidget.getParent();
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.mListAnchors;
                    if (constraintAnchorArr3[i4].mTarget.mOwner == parent && constraintAnchorArr3[i6].mTarget.mOwner == parent) {
                        constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i);
                    }
                }
                return max;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static int getParentBiasOffset(ConstraintWidget constraintWidget, int i) {
        InterceptResult invokeLI;
        ConstraintAnchor constraintAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, constraintWidget, i)) == null) {
            int i2 = i * 2;
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
            ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
            ConstraintAnchor constraintAnchor4 = constraintAnchor2.mTarget;
            if (constraintAnchor4 != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor4.mOwner;
                ConstraintWidget constraintWidget3 = constraintWidget.mParent;
                if (constraintWidget2 == constraintWidget3 && (constraintAnchor = constraintAnchor3.mTarget) != null && constraintAnchor.mOwner == constraintWidget3) {
                    return (int) ((((constraintWidget3.getLength(i) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i)) * (i == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, constraintWidgetContainer, constraintWidget, constraintWidgetGroup) == null) {
            constraintWidgetGroup.mSkipSolver = false;
            constraintWidgetContainer.mSkipSolver = false;
            constraintWidget.mOptimizerMeasurable = false;
        }
    }

    public static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, constraintWidget)) == null) {
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (constraintWidget.mDimensionRatioSide == 0) {
                    height = constraintWidget.getHeight() * constraintWidget.mDimensionRatio;
                } else {
                    height = constraintWidget.getHeight() / constraintWidget.mDimensionRatio;
                }
                int i = (int) height;
                constraintWidget.setWidth(i);
                return i;
            } else if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (constraintWidget.mDimensionRatioSide == 1) {
                    width = constraintWidget.getWidth() * constraintWidget.mDimensionRatio;
                } else {
                    width = constraintWidget.getWidth() / constraintWidget.mDimensionRatio;
                }
                int i2 = (int) width;
                constraintWidget.setHeight(i2);
                return i2;
            } else {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void setConnection(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, constraintAnchor) == null) {
            ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 == null || constraintAnchor2.mTarget == constraintAnchor) {
                return;
            }
            constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
        }
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, list, i, i2) == null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                for (ConstraintWidget constraintWidget : list.get(i3).getWidgetsToSet(i)) {
                    if (constraintWidget.mOptimizerMeasurable) {
                        updateSizeDependentWidgets(constraintWidget, i, i2);
                    }
                }
            }
        }
    }

    public static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, constraintWidgetContainer) == null) {
            constraintWidgetContainer.mWidgetGroups.clear();
            constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0185, code lost:
        if (r3.mOwner == r4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x012c, code lost:
        if (r3.mOwner == r4) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean traverse(ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup, List<ConstraintWidgetGroup> list, boolean z) {
        InterceptResult invokeCommon;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        int length;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{constraintWidget, constraintWidgetGroup, list, Boolean.valueOf(z)})) == null) {
            if (constraintWidget == null) {
                return true;
            }
            constraintWidget.mOptimizerMeasured = false;
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
            ConstraintWidgetGroup constraintWidgetGroup2 = constraintWidget.mBelongingGroup;
            if (constraintWidgetGroup2 != null) {
                if (constraintWidgetGroup2 != constraintWidgetGroup) {
                    constraintWidgetGroup.mConstrainedGroup.addAll(constraintWidgetGroup2.mConstrainedGroup);
                    constraintWidgetGroup.mStartHorizontalWidgets.addAll(constraintWidget.mBelongingGroup.mStartHorizontalWidgets);
                    constraintWidgetGroup.mStartVerticalWidgets.addAll(constraintWidget.mBelongingGroup.mStartVerticalWidgets);
                    if (!constraintWidget.mBelongingGroup.mSkipSolver) {
                        constraintWidgetGroup.mSkipSolver = false;
                    }
                    list.remove(constraintWidget.mBelongingGroup);
                    for (ConstraintWidget constraintWidget2 : constraintWidget.mBelongingGroup.mConstrainedGroup) {
                        constraintWidget2.mBelongingGroup = constraintWidgetGroup;
                    }
                }
                return true;
            }
            constraintWidget.mOptimizerMeasurable = true;
            constraintWidgetGroup.mConstrainedGroup.add(constraintWidget);
            constraintWidget.mBelongingGroup = constraintWidgetGroup;
            if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null && constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null && constraintWidget.mBaseline.mTarget == null && constraintWidget.mCenter.mTarget == null) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                constraintWidgetContainer.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (constraintWidget.mTop.mTarget.mOwner != constraintWidget.getParent() || constraintWidget.mBottom.mTarget.mOwner != constraintWidget.getParent()) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                constraintWidgetContainer.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (constraintWidget.mLeft.mTarget.mOwner != constraintWidget.getParent() || constraintWidget.mRight.mTarget.mOwner != constraintWidget.getParent()) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (((constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ^ (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) && constraintWidget.mDimensionRatio != 0.0f) {
                resolveDimensionRatio(constraintWidget);
            } else if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if ((constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget != null) && (((constraintAnchor = constraintWidget.mLeft.mTarget) == null || constraintAnchor.mOwner != constraintWidget.mParent || constraintWidget.mRight.mTarget != null) && ((constraintAnchor2 = constraintWidget.mRight.mTarget) == null || constraintAnchor2.mOwner != constraintWidget.mParent || constraintWidget.mLeft.mTarget != null))) {
                ConstraintAnchor constraintAnchor6 = constraintWidget.mLeft.mTarget;
                if (constraintAnchor6 != null) {
                    ConstraintWidget constraintWidget3 = constraintAnchor6.mOwner;
                    ConstraintWidget constraintWidget4 = constraintWidget.mParent;
                    if (constraintWidget3 == constraintWidget4) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget.mRight.mTarget;
                        if (constraintAnchor7 != null) {
                        }
                    }
                }
                if ((constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) && (((constraintAnchor3 = constraintWidget.mTop.mTarget) == null || constraintAnchor3.mOwner != constraintWidget.mParent || constraintWidget.mBottom.mTarget != null) && ((constraintAnchor4 = constraintWidget.mBottom.mTarget) == null || constraintAnchor4.mOwner != constraintWidget.mParent || constraintWidget.mTop.mTarget != null))) {
                    constraintAnchor5 = constraintWidget.mTop.mTarget;
                    if (constraintAnchor5 != null) {
                        ConstraintWidget constraintWidget5 = constraintAnchor5.mOwner;
                        ConstraintWidget constraintWidget6 = constraintWidget.mParent;
                        if (constraintWidget5 == constraintWidget6) {
                            ConstraintAnchor constraintAnchor8 = constraintWidget.mBottom.mTarget;
                            if (constraintAnchor8 != null) {
                            }
                        }
                    }
                    if (constraintWidget instanceof Helper) {
                        invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                        if (z) {
                            return false;
                        }
                        Helper helper = (Helper) constraintWidget;
                        for (int i2 = 0; i2 < helper.mWidgetsCount; i2++) {
                            if (!traverse(helper.mWidgets[i2], constraintWidgetGroup, list, z)) {
                                return false;
                            }
                        }
                    }
                    length = constraintWidget.mListAnchors.length;
                    for (i = 0; i < length; i++) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget.mListAnchors[i];
                        ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                        if (constraintAnchor10 != null && constraintAnchor10.mOwner != constraintWidget.getParent()) {
                            if (constraintAnchor9.mType == ConstraintAnchor.Type.CENTER) {
                                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                                if (z) {
                                    return false;
                                }
                            } else {
                                setConnection(constraintAnchor9);
                            }
                            if (!traverse(constraintAnchor9.mTarget.mOwner, constraintWidgetGroup, list, z)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
                if (constraintWidget.mCenter.mTarget == null && constraintWidget.mBaseline.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                    constraintWidgetGroup.mStartVerticalWidgets.add(constraintWidget);
                }
                if (constraintWidget instanceof Helper) {
                }
                length = constraintWidget.mListAnchors.length;
                while (i < length) {
                }
                return true;
            }
            if (constraintWidget.mCenter.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartHorizontalWidgets.add(constraintWidget);
            }
            if (constraintWidget.mTop.mTarget == null) {
            }
            constraintAnchor5 = constraintWidget.mTop.mTarget;
            if (constraintAnchor5 != null) {
            }
            if (constraintWidget instanceof Helper) {
            }
            length = constraintWidget.mListAnchors.length;
            while (i < length) {
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65548, null, constraintWidget, i, i2) == null) {
            int i3 = i * 2;
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
            if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
                Optimizer.setOptimizedWidget(constraintWidget, i, getParentBiasOffset(constraintWidget, i) + constraintAnchor.getMargin());
            } else if (constraintWidget.mDimensionRatio != 0.0f && constraintWidget.getDimensionBehaviour(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
                int i4 = (int) constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset;
                constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
                constraintAnchor2.getResolutionNode().resolvedOffset = resolveDimensionRatio;
                constraintAnchor2.getResolutionNode().state = 1;
                constraintWidget.setFrame(i4, i4 + resolveDimensionRatio, i);
            } else {
                int relativePositioning = i2 - constraintWidget.getRelativePositioning(i);
                int length = relativePositioning - constraintWidget.getLength(i);
                constraintWidget.setFrame(length, relativePositioning, i);
                Optimizer.setOptimizedWidget(constraintWidget, i, length);
            }
        }
    }

    public static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, constraintWidget, list, z)) == null) {
            ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
            list.add(constraintWidgetGroup);
            return traverse(constraintWidget, constraintWidgetGroup, list, z);
        }
        return invokeLLZ.booleanValue;
    }
}
