package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class Grouping {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_GROUPING = false;
    public transient /* synthetic */ FieldHolder $fh;

    public Grouping() {
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

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        InterceptResult invokeLILL;
        int i2;
        int findGroupInDependents;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65537, null, constraintWidget, i, arrayList, widgetGroup)) == null) {
            if (i == 0) {
                i2 = constraintWidget.horizontalGroup;
            } else {
                i2 = constraintWidget.verticalGroup;
            }
            int i3 = 0;
            if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.id)) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup2 = arrayList.get(i4);
                    if (widgetGroup2.getId() == i2) {
                        if (widgetGroup != null) {
                            widgetGroup.moveTo(i, widgetGroup2);
                            arrayList.remove(widgetGroup);
                        }
                        widgetGroup = widgetGroup2;
                    } else {
                        i4++;
                    }
                }
            } else if (i2 != -1) {
                return widgetGroup;
            }
            if (widgetGroup == null) {
                if ((constraintWidget instanceof HelperWidget) && (findGroupInDependents = ((HelperWidget) constraintWidget).findGroupInDependents(i)) != -1) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList.size()) {
                            break;
                        }
                        WidgetGroup widgetGroup3 = arrayList.get(i5);
                        if (widgetGroup3.getId() == findGroupInDependents) {
                            widgetGroup = widgetGroup3;
                            break;
                        }
                        i5++;
                    }
                }
                if (widgetGroup == null) {
                    widgetGroup = new WidgetGroup(i);
                }
                arrayList.add(widgetGroup);
            }
            if (widgetGroup.add(constraintWidget)) {
                if (constraintWidget instanceof Guideline) {
                    Guideline guideline = (Guideline) constraintWidget;
                    ConstraintAnchor anchor = guideline.getAnchor();
                    if (guideline.getOrientation() == 0) {
                        i3 = 1;
                    }
                    anchor.findDependents(i3, arrayList, widgetGroup);
                }
                if (i == 0) {
                    constraintWidget.horizontalGroup = widgetGroup.getId();
                    constraintWidget.mLeft.findDependents(i, arrayList, widgetGroup);
                    constraintWidget.mRight.findDependents(i, arrayList, widgetGroup);
                } else {
                    constraintWidget.verticalGroup = widgetGroup.getId();
                    constraintWidget.mTop.findDependents(i, arrayList, widgetGroup);
                    constraintWidget.mBaseline.findDependents(i, arrayList, widgetGroup);
                    constraintWidget.mBottom.findDependents(i, arrayList, widgetGroup);
                }
                constraintWidget.mCenter.findDependents(i, arrayList, widgetGroup);
            }
            return widgetGroup;
        }
        return (WidgetGroup) invokeLILL.objValue;
    }

    public static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, arrayList, i)) == null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                WidgetGroup widgetGroup = arrayList.get(i2);
                if (i == widgetGroup.id) {
                    return widgetGroup;
                }
            }
            return null;
        }
        return (WidgetGroup) invokeLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0393 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean simpleSolvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        InterceptResult invokeLL;
        WidgetGroup widgetGroup;
        WidgetGroup widgetGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, constraintWidgetContainer, measurer)) == null) {
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = children.get(i);
                if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getVerticalDimensionBehaviour()) || (constraintWidget instanceof Flow)) {
                    return false;
                }
            }
            Metrics metrics = constraintWidgetContainer.mMetrics;
            if (metrics != null) {
                metrics.grouping++;
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ArrayList arrayList3 = null;
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            ArrayList arrayList6 = null;
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = children.get(i2);
                if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget2.getHorizontalDimensionBehaviour(), constraintWidget2.getVerticalDimensionBehaviour())) {
                    ConstraintWidgetContainer.measure(constraintWidget2, measurer, constraintWidgetContainer.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z = constraintWidget2 instanceof Guideline;
                if (z) {
                    Guideline guideline = (Guideline) constraintWidget2;
                    if (guideline.getOrientation() == 0) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(guideline);
                    }
                    if (guideline.getOrientation() == 1) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(guideline);
                    }
                }
                if (constraintWidget2 instanceof HelperWidget) {
                    if (constraintWidget2 instanceof Barrier) {
                        Barrier barrier = (Barrier) constraintWidget2;
                        if (barrier.getOrientation() == 0) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(barrier);
                        }
                        if (barrier.getOrientation() == 1) {
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(barrier);
                        }
                    } else {
                        HelperWidget helperWidget = (HelperWidget) constraintWidget2;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(helperWidget);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(helperWidget);
                    }
                }
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null && !z && !(constraintWidget2 instanceof Barrier)) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(constraintWidget2);
                }
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline.mTarget == null && !z && !(constraintWidget2 instanceof Barrier)) {
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList6.add(constraintWidget2);
                }
            }
            ArrayList<WidgetGroup> arrayList7 = new ArrayList<>();
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    findDependents((Guideline) it.next(), 0, arrayList7, null);
                }
            }
            int i3 = 0;
            WidgetGroup widgetGroup3 = null;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    HelperWidget helperWidget2 = (HelperWidget) it2.next();
                    WidgetGroup findDependents = findDependents(helperWidget2, i3, arrayList7, widgetGroup3);
                    helperWidget2.addDependents(arrayList7, i3, findDependents);
                    findDependents.cleanup(arrayList7);
                    i3 = 0;
                    widgetGroup3 = null;
                }
            }
            ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor.getDependents() != null) {
                Iterator<ConstraintAnchor> it3 = anchor.getDependents().iterator();
                while (it3.hasNext()) {
                    findDependents(it3.next().mOwner, 0, arrayList7, null);
                }
            }
            ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
            if (anchor2.getDependents() != null) {
                Iterator<ConstraintAnchor> it4 = anchor2.getDependents().iterator();
                while (it4.hasNext()) {
                    findDependents(it4.next().mOwner, 0, arrayList7, null);
                }
            }
            ConstraintAnchor anchor3 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
            if (anchor3.getDependents() != null) {
                Iterator<ConstraintAnchor> it5 = anchor3.getDependents().iterator();
                while (it5.hasNext()) {
                    findDependents(it5.next().mOwner, 0, arrayList7, null);
                }
            }
            WidgetGroup widgetGroup4 = null;
            if (arrayList5 != null) {
                Iterator it6 = arrayList5.iterator();
                while (it6.hasNext()) {
                    findDependents((ConstraintWidget) it6.next(), 0, arrayList7, null);
                }
            }
            if (arrayList3 != null) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    findDependents((Guideline) it7.next(), 1, arrayList7, null);
                }
            }
            if (arrayList4 != null) {
                Iterator it8 = arrayList4.iterator();
                while (it8.hasNext()) {
                    HelperWidget helperWidget3 = (HelperWidget) it8.next();
                    WidgetGroup findDependents2 = findDependents(helperWidget3, 1, arrayList7, widgetGroup4);
                    helperWidget3.addDependents(arrayList7, 1, findDependents2);
                    findDependents2.cleanup(arrayList7);
                    widgetGroup4 = null;
                }
            }
            ConstraintAnchor anchor4 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor4.getDependents() != null) {
                Iterator<ConstraintAnchor> it9 = anchor4.getDependents().iterator();
                while (it9.hasNext()) {
                    findDependents(it9.next().mOwner, 1, arrayList7, null);
                }
            }
            ConstraintAnchor anchor5 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BASELINE);
            if (anchor5.getDependents() != null) {
                Iterator<ConstraintAnchor> it10 = anchor5.getDependents().iterator();
                while (it10.hasNext()) {
                    findDependents(it10.next().mOwner, 1, arrayList7, null);
                }
            }
            ConstraintAnchor anchor6 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            if (anchor6.getDependents() != null) {
                Iterator<ConstraintAnchor> it11 = anchor6.getDependents().iterator();
                while (it11.hasNext()) {
                    findDependents(it11.next().mOwner, 1, arrayList7, null);
                }
            }
            ConstraintAnchor anchor7 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
            if (anchor7.getDependents() != null) {
                Iterator<ConstraintAnchor> it12 = anchor7.getDependents().iterator();
                while (it12.hasNext()) {
                    findDependents(it12.next().mOwner, 1, arrayList7, null);
                }
            }
            if (arrayList6 != null) {
                Iterator it13 = arrayList6.iterator();
                while (it13.hasNext()) {
                    findDependents((ConstraintWidget) it13.next(), 1, arrayList7, null);
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget3 = children.get(i4);
                if (constraintWidget3.oppositeDimensionsTied()) {
                    WidgetGroup findGroup = findGroup(arrayList7, constraintWidget3.horizontalGroup);
                    WidgetGroup findGroup2 = findGroup(arrayList7, constraintWidget3.verticalGroup);
                    if (findGroup != null && findGroup2 != null) {
                        findGroup.moveTo(0, findGroup2);
                        findGroup2.setOrientation(2);
                        arrayList7.remove(findGroup);
                    }
                }
            }
            if (arrayList7.size() <= 1) {
                return false;
            }
            if (constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                Iterator<WidgetGroup> it14 = arrayList7.iterator();
                widgetGroup = null;
                int i5 = 0;
                while (it14.hasNext()) {
                    WidgetGroup next = it14.next();
                    if (next.getOrientation() != 1) {
                        next.setAuthoritative(false);
                        int measureWrap = next.measureWrap(constraintWidgetContainer.getSystem(), 0);
                        if (measureWrap > i5) {
                            widgetGroup = next;
                            i5 = measureWrap;
                        }
                    }
                }
                if (widgetGroup != null) {
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidgetContainer.setWidth(i5);
                    widgetGroup.setAuthoritative(true);
                    if (constraintWidgetContainer.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        Iterator<WidgetGroup> it15 = arrayList7.iterator();
                        WidgetGroup widgetGroup5 = null;
                        int i6 = 0;
                        while (it15.hasNext()) {
                            WidgetGroup next2 = it15.next();
                            if (next2.getOrientation() != 0) {
                                next2.setAuthoritative(false);
                                int measureWrap2 = next2.measureWrap(constraintWidgetContainer.getSystem(), 1);
                                if (measureWrap2 > i6) {
                                    widgetGroup5 = next2;
                                    i6 = measureWrap2;
                                }
                            }
                        }
                        if (widgetGroup5 != null) {
                            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                            constraintWidgetContainer.setHeight(i6);
                            widgetGroup5.setAuthoritative(true);
                            widgetGroup2 = widgetGroup5;
                            if (widgetGroup != null && widgetGroup2 == null) {
                                return false;
                            }
                            return true;
                        }
                    }
                    widgetGroup2 = null;
                    if (widgetGroup != null) {
                    }
                    return true;
                }
            }
            widgetGroup = null;
            if (constraintWidgetContainer.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            }
            widgetGroup2 = null;
            if (widgetGroup != null) {
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dimensionBehaviour, dimensionBehaviour2, dimensionBehaviour3, dimensionBehaviour4)) == null) {
            if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                z = false;
            } else {
                z = true;
            }
            if (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z && !z2) {
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
