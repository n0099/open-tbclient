package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = 0;
            int i3 = 0;
            for (ConstraintWidgetGroup constraintWidgetGroup : list) {
                i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 0));
                i3 = Math.max(i3, getMaxDimension(constraintWidgetGroup, 1));
            }
            if (z) {
                constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setWidth(i2);
                constraintWidgetContainer.mGroupsWrapOptimized = true;
                constraintWidgetContainer.mHorizontalWrapOptimized = true;
                constraintWidgetContainer.mWrapFixedWidth = i2;
            }
            if (z2) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setHeight(i3);
                constraintWidgetContainer.mGroupsWrapOptimized = true;
                constraintWidgetContainer.mVerticalWrapOptimized = true;
                constraintWidgetContainer.mWrapFixedHeight = i3;
            }
            setPosition(list, 0, constraintWidgetContainer.getWidth());
            setPosition(list, 1, constraintWidgetContainer.getHeight());
        }
    }

    public static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, constraintWidgetGroup, i2)) == null) {
            int i3 = i2 * 2;
            List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i2);
            int size = startWidgets.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = startWidgets.get(i5);
                ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
                int i6 = i3 + 1;
                i4 = Math.max(i4, getMaxDimensionTraversal(constraintWidget, i2, constraintAnchorArr[i6].mTarget == null || !(constraintAnchorArr[i3].mTarget == null || constraintAnchorArr[i6].mTarget == null), 0));
            }
            constraintWidgetGroup.mGroupDimensions[i2] = i4;
            return i4;
        }
        return invokeLI.intValue;
    }

    public static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        int height;
        int baselineDistance;
        int i4;
        int i5;
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{constraintWidget, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            int i10 = 0;
            if (constraintWidget.mOptimizerMeasurable) {
                boolean z2 = constraintWidget.mBaseline.mTarget != null && i2 == 1;
                if (z) {
                    height = constraintWidget.getBaselineDistance();
                    baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
                    i5 = i2 * 2;
                    i4 = i5 + 1;
                } else {
                    height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
                    baselineDistance = constraintWidget.getBaselineDistance();
                    i4 = i2 * 2;
                    i5 = i4 + 1;
                }
                ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
                if (constraintAnchorArr[i4].mTarget == null || constraintAnchorArr[i5].mTarget != null) {
                    i6 = 1;
                } else {
                    i6 = -1;
                    int i11 = i4;
                    i4 = i5;
                    i5 = i11;
                }
                int i12 = z2 ? i3 - height : i3;
                int margin = (constraintWidget.mListAnchors[i5].getMargin() * i6) + getParentBiasOffset(constraintWidget, i2);
                int i13 = i12 + margin;
                int width2 = (i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
                Iterator<ResolutionNode> it = constraintWidget.mListAnchors[i5].getResolutionNode().dependents.iterator();
                while (it.hasNext()) {
                    i10 = Math.max(i10, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).myAnchor.mOwner, i2, z, i13));
                }
                int i14 = 0;
                for (Iterator<ResolutionNode> it2 = constraintWidget.mListAnchors[i4].getResolutionNode().dependents.iterator(); it2.hasNext(); it2 = it2) {
                    i14 = Math.max(i14, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).myAnchor.mOwner, i2, z, width2 + i13));
                }
                if (z2) {
                    i10 -= height;
                    width = i14 + baselineDistance;
                } else {
                    width = i14 + ((i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6);
                }
                int i15 = 1;
                if (i2 == 1) {
                    Iterator<ResolutionNode> it3 = constraintWidget.mBaseline.getResolutionNode().dependents.iterator();
                    int i16 = 0;
                    while (it3.hasNext()) {
                        Iterator<ResolutionNode> it4 = it3;
                        ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                        if (i6 == i15) {
                            i16 = Math.max(i16, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, height + i13));
                            i9 = i4;
                        } else {
                            i9 = i4;
                            i16 = Math.max(i16, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, (baselineDistance * i6) + i13));
                        }
                        it3 = it4;
                        i4 = i9;
                        i15 = 1;
                    }
                    i7 = i4;
                    int i17 = i16;
                    i8 = (constraintWidget.mBaseline.getResolutionNode().dependents.size() <= 0 || z2) ? i17 : i6 == 1 ? i17 + height : i17 - baselineDistance;
                } else {
                    i7 = i4;
                    i8 = 0;
                }
                int max = margin + Math.max(i10, Math.max(width, i8));
                int i18 = width2 + i13;
                if (i6 == -1) {
                    i18 = i13;
                    i13 = i18;
                }
                if (z) {
                    Optimizer.setOptimizedWidget(constraintWidget, i2, i13);
                    constraintWidget.setFrame(i13, i18, i2);
                } else {
                    constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
                    constraintWidget.setRelativePositioning(i13, i2);
                }
                if (constraintWidget.getDimensionBehaviour(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mDimensionRatio != 0.0f) {
                    constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
                }
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.mListAnchors;
                if (constraintAnchorArr2[i5].mTarget != null && constraintAnchorArr2[i7].mTarget != null) {
                    ConstraintWidget parent = constraintWidget.getParent();
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.mListAnchors;
                    if (constraintAnchorArr3[i5].mTarget.mOwner == parent && constraintAnchorArr3[i7].mTarget.mOwner == parent) {
                        constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
                    }
                }
                return max;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static int getParentBiasOffset(ConstraintWidget constraintWidget, int i2) {
        InterceptResult invokeLI;
        ConstraintAnchor constraintAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, constraintWidget, i2)) == null) {
            int i3 = i2 * 2;
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3];
            ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i3 + 1];
            ConstraintAnchor constraintAnchor4 = constraintAnchor2.mTarget;
            if (constraintAnchor4 != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor4.mOwner;
                ConstraintWidget constraintWidget3 = constraintWidget.mParent;
                if (constraintWidget2 == constraintWidget3 && (constraintAnchor = constraintAnchor3.mTarget) != null && constraintAnchor.mOwner == constraintWidget3) {
                    return (int) ((((constraintWidget3.getLength(i2) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i2)) * (i2 == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, constraintWidgetContainer, constraintWidget, constraintWidgetGroup) == null) {
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
                int i2 = (int) height;
                constraintWidget.setWidth(i2);
                return i2;
            } else if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (constraintWidget.mDimensionRatioSide == 1) {
                    width = constraintWidget.getWidth() * constraintWidget.mDimensionRatio;
                } else {
                    width = constraintWidget.getWidth() / constraintWidget.mDimensionRatio;
                }
                int i3 = (int) width;
                constraintWidget.setHeight(i3);
                return i3;
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

    public static void setPosition(List<ConstraintWidgetGroup> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, list, i2, i3) == null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                for (ConstraintWidget constraintWidget : list.get(i4).getWidgetsToSet(i2)) {
                    if (constraintWidget.mOptimizerMeasurable) {
                        updateSizeDependentWidgets(constraintWidget, i2, i3);
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
        int i2;
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
                        for (int i3 = 0; i3 < helper.mWidgetsCount; i3++) {
                            if (!traverse(helper.mWidgets[i3], constraintWidgetGroup, list, z)) {
                                return false;
                            }
                        }
                    }
                    length = constraintWidget.mListAnchors.length;
                    for (i2 = 0; i2 < length; i2++) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget.mListAnchors[i2];
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
                while (i2 < length) {
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
            while (i2 < length) {
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65548, null, constraintWidget, i2, i3) == null) {
            int i4 = i2 * 2;
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4 + 1];
            if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
                Optimizer.setOptimizedWidget(constraintWidget, i2, getParentBiasOffset(constraintWidget, i2) + constraintAnchor.getMargin());
            } else if (constraintWidget.mDimensionRatio != 0.0f && constraintWidget.getDimensionBehaviour(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
                int i5 = (int) constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset;
                constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
                constraintAnchor2.getResolutionNode().resolvedOffset = resolveDimensionRatio;
                constraintAnchor2.getResolutionNode().state = 1;
                constraintWidget.setFrame(i5, i5 + resolveDimensionRatio, i2);
            } else {
                int relativePositioning = i3 - constraintWidget.getRelativePositioning(i2);
                int length = relativePositioning - constraintWidget.getLength(i2);
                constraintWidget.setFrame(length, relativePositioning, i2);
                Optimizer.setOptimizedWidget(constraintWidget, i2, length);
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
