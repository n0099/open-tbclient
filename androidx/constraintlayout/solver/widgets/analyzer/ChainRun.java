package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int chainStyle;
    public ArrayList<WidgetRun> widgets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ConstraintWidget) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.widgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ConstraintWidget constraintWidget2 = this.widget;
            ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            while (true) {
                ConstraintWidget constraintWidget3 = previousChainMember;
                constraintWidget = constraintWidget2;
                constraintWidget2 = constraintWidget3;
                if (constraintWidget2 == null) {
                    break;
                }
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
            this.widget = constraintWidget;
            this.widgets.add(constraintWidget.getRun(this.orientation));
            ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
            while (nextChainMember != null) {
                this.widgets.add(nextChainMember.getRun(this.orientation));
                nextChainMember = nextChainMember.getNextChainMember(this.orientation);
            }
            Iterator<WidgetRun> it = this.widgets.iterator();
            while (it.hasNext()) {
                WidgetRun next = it.next();
                int i = this.orientation;
                if (i == 0) {
                    next.widget.horizontalChainRun = this;
                } else if (i == 1) {
                    next.widget.verticalChainRun = this;
                }
            }
            if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
                ArrayList<WidgetRun> arrayList = this.widgets;
                this.widget = arrayList.get(arrayList.size() - 1).widget;
            }
            this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            for (int i = 0; i < this.widgets.size(); i++) {
                WidgetRun widgetRun = this.widgets.get(i);
                if (widgetRun.widget.getVisibility() != 8) {
                    return widgetRun.widget;
                }
            }
            return null;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    private ConstraintWidget getLastVisibleWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            for (int size = this.widgets.size() - 1; size >= 0; size--) {
                WidgetRun widgetRun = this.widgets.get(size);
                if (widgetRun.widget.getVisibility() != 8) {
                    return widgetRun.widget;
                }
            }
            return null;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<WidgetRun> it = this.widgets.iterator();
            while (it.hasNext()) {
                it.next().apply();
            }
            int size = this.widgets.size();
            if (size < 1) {
                return;
            }
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.widgets.size(); i++) {
                this.widgets.get(i).applyToWidget();
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.runGroup = null;
            Iterator<WidgetRun> it = this.widgets.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int size = this.widgets.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                WidgetRun widgetRun = this.widgets.get(i);
                j = j + widgetRun.start.margin + widgetRun.getWrapDimension() + widgetRun.end.margin;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.start.resolved = false;
            this.end.resolved = false;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.widgets.size();
            for (int i = 0; i < size; i++) {
                if (!this.widgets.get(i).supportsWrapComputation()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Iterator<WidgetRun> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ChainRun ");
            sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
            String sb2 = sb.toString();
            while (this.widgets.iterator().hasNext()) {
                sb2 = ((sb2 + "<") + it.next()) + "> ";
            }
            return sb2;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x01a2, code lost:
        if (r7 != r9) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ca, code lost:
        if (r7 != r9) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cc, code lost:
        r16 = r16 + 1;
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01cf, code lost:
        r12.dimension.resolve(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0407, code lost:
        r3 = r3 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
        if (r2.dimension.resolved != false) goto L70;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        int max;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, dependency) == null) && this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
            int i11 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i12 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i12 >= size) {
                    i12 = -1;
                    break;
                } else if (this.widgets.get(i12).widget.getVisibility() != 8) {
                    break;
                } else {
                    i12++;
                }
            }
            int i13 = size - 1;
            int i14 = i13;
            while (true) {
                if (i14 < 0) {
                    break;
                }
                if (this.widgets.get(i14).widget.getVisibility() != 8) {
                    i = i14;
                    break;
                }
                i14--;
            }
            int i15 = 0;
            while (i15 < 2) {
                int i16 = 0;
                i4 = 0;
                i5 = 0;
                int i17 = 0;
                f = 0.0f;
                while (i16 < size) {
                    WidgetRun widgetRun = this.widgets.get(i16);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i17++;
                        if (i16 > 0 && i16 >= i12) {
                            i4 += widgetRun.start.margin;
                        }
                        int i18 = widgetRun.dimension.value;
                        boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z) {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            if (widgetRun.matchConstraintsType == 1 && i15 == 0) {
                                i18 = widgetRun.dimension.wrapValue;
                                i5++;
                            }
                            z = true;
                        }
                        if (z) {
                            i4 += i18;
                        } else {
                            i5++;
                            float f3 = widgetRun.widget.mWeight[this.orientation];
                            if (f3 >= 0.0f) {
                                f += f3;
                            }
                        }
                        if (i16 < i13 && i16 < i) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i16++;
                    i2 = 8;
                }
                if (i4 < i11 || i5 == 0) {
                    i3 = i17;
                    break;
                } else {
                    i15++;
                    i2 = 8;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = 0.0f;
            int i19 = this.start.value;
            if (isRtl) {
                i19 = this.end.value;
            }
            if (i4 > i11) {
                i19 = isRtl ? i19 + ((int) (((i4 - i11) / 2.0f) + 0.5f)) : i19 - ((int) (((i4 - i11) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f4 = i11 - i4;
                int i20 = (int) ((f4 / i5) + 0.5f);
                int i21 = 0;
                int i22 = 0;
                while (i21 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i21);
                    int i23 = i20;
                    if (widgetRun2.widget.getVisibility() == 8 || widgetRun2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.dimension.resolved) {
                        i9 = i19;
                        f2 = f4;
                        i10 = i4;
                    } else {
                        int i24 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f4) / f) + 0.5f) : i23;
                        if (this.orientation == 0) {
                            ConstraintWidget constraintWidget = widgetRun2.widget;
                            f2 = f4;
                            int i25 = constraintWidget.mMatchConstraintMaxWidth;
                            i10 = i4;
                            i9 = i19;
                            max = Math.max(constraintWidget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i25 > 0) {
                                max = Math.min(i25, max);
                            }
                        } else {
                            i9 = i19;
                            f2 = f4;
                            i10 = i4;
                            ConstraintWidget constraintWidget2 = widgetRun2.widget;
                            int i26 = constraintWidget2.mMatchConstraintMaxHeight;
                            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i26 > 0) {
                                max = Math.min(i26, max);
                            }
                        }
                    }
                    i21++;
                    i20 = i23;
                    f4 = f2;
                    i4 = i10;
                    i19 = i9;
                }
                i6 = i19;
                int i27 = i4;
                if (i22 > 0) {
                    i5 -= i22;
                    int i28 = 0;
                    for (int i29 = 0; i29 < size; i29++) {
                        WidgetRun widgetRun3 = this.widgets.get(i29);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i29 > 0 && i29 >= i12) {
                                i28 += widgetRun3.start.margin;
                            }
                            i28 += widgetRun3.dimension.value;
                            if (i29 < i13 && i29 < i) {
                                i28 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i28;
                } else {
                    i4 = i27;
                }
                i7 = 2;
                if (this.chainStyle == 2 && i22 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                i6 = i19;
                i7 = 2;
            }
            if (i4 > i11) {
                this.chainStyle = i7;
            }
            if (i3 > 0 && i5 == 0 && i12 == i) {
                this.chainStyle = i7;
            }
            int i30 = this.chainStyle;
            if (i30 == 1) {
                if (i3 > 1) {
                    i8 = (i11 - i4) / (i3 - 1);
                } else {
                    i8 = i3 == 1 ? (i11 - i4) / 2 : 0;
                }
                if (i5 > 0) {
                    i8 = 0;
                }
                int i31 = i6;
                for (int i32 = 0; i32 < size; i32++) {
                    WidgetRun widgetRun4 = this.widgets.get(isRtl ? size - (i32 + 1) : i32);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i31);
                        widgetRun4.end.resolve(i31);
                    } else {
                        if (i32 > 0) {
                            i31 = isRtl ? i31 - i8 : i31 + i8;
                        }
                        if (i32 > 0 && i32 >= i12) {
                            if (isRtl) {
                                i31 -= widgetRun4.start.margin;
                            } else {
                                i31 += widgetRun4.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun4.end.resolve(i31);
                        } else {
                            widgetRun4.start.resolve(i31);
                        }
                        DimensionDependency dimensionDependency = widgetRun4.dimension;
                        int i33 = dimensionDependency.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i33 = dimensionDependency.wrapValue;
                        }
                        i31 = isRtl ? i31 - i33 : i31 + i33;
                        if (isRtl) {
                            widgetRun4.start.resolve(i31);
                        } else {
                            widgetRun4.end.resolve(i31);
                        }
                        widgetRun4.resolved = true;
                        if (i32 < i13 && i32 < i) {
                            if (isRtl) {
                                i31 -= -widgetRun4.end.margin;
                            } else {
                                i31 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
            } else if (i30 == 0) {
                int i34 = (i11 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i34 = 0;
                }
                int i35 = i6;
                for (int i36 = 0; i36 < size; i36++) {
                    WidgetRun widgetRun5 = this.widgets.get(isRtl ? size - (i36 + 1) : i36);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i35);
                        widgetRun5.end.resolve(i35);
                    } else {
                        int i37 = isRtl ? i35 - i34 : i35 + i34;
                        if (i36 > 0 && i36 >= i12) {
                            if (isRtl) {
                                i37 -= widgetRun5.start.margin;
                            } else {
                                i37 += widgetRun5.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun5.end.resolve(i37);
                        } else {
                            widgetRun5.start.resolve(i37);
                        }
                        DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                        int i38 = dimensionDependency2.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i38 = Math.min(i38, dimensionDependency2.wrapValue);
                        }
                        i35 = isRtl ? i37 - i38 : i37 + i38;
                        if (isRtl) {
                            widgetRun5.start.resolve(i35);
                        } else {
                            widgetRun5.end.resolve(i35);
                        }
                        if (i36 < i13 && i36 < i) {
                            if (isRtl) {
                                i35 -= -widgetRun5.end.margin;
                            } else {
                                i35 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
            } else if (i30 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (isRtl) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i39 = (((int) ((((float) (i11 - i4)) * horizontalBiasPercent) + 0.5f)) < 0 || i5 > 0) ? 0 : 0;
                int i40 = isRtl ? i6 - i39 : i6 + i39;
                for (int i41 = 0; i41 < size; i41++) {
                    WidgetRun widgetRun6 = this.widgets.get(isRtl ? size - (i41 + 1) : i41);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i40);
                        widgetRun6.end.resolve(i40);
                    } else {
                        if (i41 > 0 && i41 >= i12) {
                            if (isRtl) {
                                i40 -= widgetRun6.start.margin;
                            } else {
                                i40 += widgetRun6.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun6.end.resolve(i40);
                        } else {
                            widgetRun6.start.resolve(i40);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                        int i42 = dimensionDependency3.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i42 = dimensionDependency3.wrapValue;
                        }
                        i40 += i42;
                        if (isRtl) {
                            widgetRun6.start.resolve(i40);
                        } else {
                            widgetRun6.end.resolve(i40);
                        }
                        if (i41 < i13 && i41 < i) {
                            if (isRtl) {
                                i40 -= -widgetRun6.end.margin;
                            } else {
                                i40 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }
}
