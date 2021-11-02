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
    public ChainRun(ConstraintWidget constraintWidget, int i2) {
        super(constraintWidget);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((ConstraintWidget) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.widgets = new ArrayList<>();
        this.orientation = i2;
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
                int i2 = this.orientation;
                if (i2 == 0) {
                    next.widget.horizontalChainRun = this;
                } else if (i2 == 1) {
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
            for (int i2 = 0; i2 < this.widgets.size(); i2++) {
                WidgetRun widgetRun = this.widgets.get(i2);
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
            for (int i2 = 0; i2 < this.widgets.size(); i2++) {
                this.widgets.get(i2).applyToWidget();
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
            for (int i2 = 0; i2 < size; i2++) {
                WidgetRun widgetRun = this.widgets.get(i2);
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
            for (int i2 = 0; i2 < size; i2++) {
                if (!this.widgets.get(i2).supportsWrapComputation()) {
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        float f3;
        int i11;
        int max;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, dependency) == null) && this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
            int i12 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i13 = 0;
            while (true) {
                i2 = -1;
                i3 = 8;
                if (i13 >= size) {
                    i13 = -1;
                    break;
                } else if (this.widgets.get(i13).widget.getVisibility() != 8) {
                    break;
                } else {
                    i13++;
                }
            }
            int i14 = size - 1;
            int i15 = i14;
            while (true) {
                if (i15 < 0) {
                    break;
                }
                if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    i2 = i15;
                    break;
                }
                i15--;
            }
            int i16 = 0;
            while (i16 < 2) {
                int i17 = 0;
                i5 = 0;
                i6 = 0;
                int i18 = 0;
                f2 = 0.0f;
                while (i17 < size) {
                    WidgetRun widgetRun = this.widgets.get(i17);
                    if (widgetRun.widget.getVisibility() != i3) {
                        i18++;
                        if (i17 > 0 && i17 >= i13) {
                            i5 += widgetRun.start.margin;
                        }
                        int i19 = widgetRun.dimension.value;
                        boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z) {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            if (widgetRun.matchConstraintsType == 1 && i16 == 0) {
                                i19 = widgetRun.dimension.wrapValue;
                                i6++;
                            }
                            z = true;
                        }
                        if (z) {
                            i5 += i19;
                        } else {
                            i6++;
                            float f4 = widgetRun.widget.mWeight[this.orientation];
                            if (f4 >= 0.0f) {
                                f2 += f4;
                            }
                        }
                        if (i17 < i14 && i17 < i2) {
                            i5 += -widgetRun.end.margin;
                        }
                    }
                    i17++;
                    i3 = 8;
                }
                if (i5 < i12 || i6 == 0) {
                    i4 = i18;
                    break;
                } else {
                    i16++;
                    i3 = 8;
                }
            }
            i4 = 0;
            i5 = 0;
            i6 = 0;
            f2 = 0.0f;
            int i20 = this.start.value;
            if (isRtl) {
                i20 = this.end.value;
            }
            if (i5 > i12) {
                i20 = isRtl ? i20 + ((int) (((i5 - i12) / 2.0f) + 0.5f)) : i20 - ((int) (((i5 - i12) / 2.0f) + 0.5f));
            }
            if (i6 > 0) {
                float f5 = i12 - i5;
                int i21 = (int) ((f5 / i6) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i22);
                    int i24 = i21;
                    if (widgetRun2.widget.getVisibility() == 8 || widgetRun2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.dimension.resolved) {
                        i10 = i20;
                        f3 = f5;
                        i11 = i5;
                    } else {
                        int i25 = f2 > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f5) / f2) + 0.5f) : i24;
                        if (this.orientation == 0) {
                            ConstraintWidget constraintWidget = widgetRun2.widget;
                            f3 = f5;
                            int i26 = constraintWidget.mMatchConstraintMaxWidth;
                            i11 = i5;
                            i10 = i20;
                            max = Math.max(constraintWidget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i26 > 0) {
                                max = Math.min(i26, max);
                            }
                        } else {
                            i10 = i20;
                            f3 = f5;
                            i11 = i5;
                            ConstraintWidget constraintWidget2 = widgetRun2.widget;
                            int i27 = constraintWidget2.mMatchConstraintMaxHeight;
                            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i27 > 0) {
                                max = Math.min(i27, max);
                            }
                        }
                    }
                    i22++;
                    i21 = i24;
                    f5 = f3;
                    i5 = i11;
                    i20 = i10;
                }
                i7 = i20;
                int i28 = i5;
                if (i23 > 0) {
                    i6 -= i23;
                    int i29 = 0;
                    for (int i30 = 0; i30 < size; i30++) {
                        WidgetRun widgetRun3 = this.widgets.get(i30);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i30 > 0 && i30 >= i13) {
                                i29 += widgetRun3.start.margin;
                            }
                            i29 += widgetRun3.dimension.value;
                            if (i30 < i14 && i30 < i2) {
                                i29 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i5 = i29;
                } else {
                    i5 = i28;
                }
                i8 = 2;
                if (this.chainStyle == 2 && i23 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                i7 = i20;
                i8 = 2;
            }
            if (i5 > i12) {
                this.chainStyle = i8;
            }
            if (i4 > 0 && i6 == 0 && i13 == i2) {
                this.chainStyle = i8;
            }
            int i31 = this.chainStyle;
            if (i31 == 1) {
                if (i4 > 1) {
                    i9 = (i12 - i5) / (i4 - 1);
                } else {
                    i9 = i4 == 1 ? (i12 - i5) / 2 : 0;
                }
                if (i6 > 0) {
                    i9 = 0;
                }
                int i32 = i7;
                for (int i33 = 0; i33 < size; i33++) {
                    WidgetRun widgetRun4 = this.widgets.get(isRtl ? size - (i33 + 1) : i33);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i32);
                        widgetRun4.end.resolve(i32);
                    } else {
                        if (i33 > 0) {
                            i32 = isRtl ? i32 - i9 : i32 + i9;
                        }
                        if (i33 > 0 && i33 >= i13) {
                            if (isRtl) {
                                i32 -= widgetRun4.start.margin;
                            } else {
                                i32 += widgetRun4.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun4.end.resolve(i32);
                        } else {
                            widgetRun4.start.resolve(i32);
                        }
                        DimensionDependency dimensionDependency = widgetRun4.dimension;
                        int i34 = dimensionDependency.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i34 = dimensionDependency.wrapValue;
                        }
                        i32 = isRtl ? i32 - i34 : i32 + i34;
                        if (isRtl) {
                            widgetRun4.start.resolve(i32);
                        } else {
                            widgetRun4.end.resolve(i32);
                        }
                        widgetRun4.resolved = true;
                        if (i33 < i14 && i33 < i2) {
                            if (isRtl) {
                                i32 -= -widgetRun4.end.margin;
                            } else {
                                i32 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
            } else if (i31 == 0) {
                int i35 = (i12 - i5) / (i4 + 1);
                if (i6 > 0) {
                    i35 = 0;
                }
                int i36 = i7;
                for (int i37 = 0; i37 < size; i37++) {
                    WidgetRun widgetRun5 = this.widgets.get(isRtl ? size - (i37 + 1) : i37);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i36);
                        widgetRun5.end.resolve(i36);
                    } else {
                        int i38 = isRtl ? i36 - i35 : i36 + i35;
                        if (i37 > 0 && i37 >= i13) {
                            if (isRtl) {
                                i38 -= widgetRun5.start.margin;
                            } else {
                                i38 += widgetRun5.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun5.end.resolve(i38);
                        } else {
                            widgetRun5.start.resolve(i38);
                        }
                        DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                        int i39 = dimensionDependency2.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i39 = Math.min(i39, dimensionDependency2.wrapValue);
                        }
                        i36 = isRtl ? i38 - i39 : i38 + i39;
                        if (isRtl) {
                            widgetRun5.start.resolve(i36);
                        } else {
                            widgetRun5.end.resolve(i36);
                        }
                        if (i37 < i14 && i37 < i2) {
                            if (isRtl) {
                                i36 -= -widgetRun5.end.margin;
                            } else {
                                i36 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
            } else if (i31 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (isRtl) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i40 = (((int) ((((float) (i12 - i5)) * horizontalBiasPercent) + 0.5f)) < 0 || i6 > 0) ? 0 : 0;
                int i41 = isRtl ? i7 - i40 : i7 + i40;
                for (int i42 = 0; i42 < size; i42++) {
                    WidgetRun widgetRun6 = this.widgets.get(isRtl ? size - (i42 + 1) : i42);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i41);
                        widgetRun6.end.resolve(i41);
                    } else {
                        if (i42 > 0 && i42 >= i13) {
                            if (isRtl) {
                                i41 -= widgetRun6.start.margin;
                            } else {
                                i41 += widgetRun6.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun6.end.resolve(i41);
                        } else {
                            widgetRun6.start.resolve(i41);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                        int i43 = dimensionDependency3.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i43 = dimensionDependency3.wrapValue;
                        }
                        i41 += i43;
                        if (isRtl) {
                            widgetRun6.start.resolve(i41);
                        } else {
                            widgetRun6.end.resolve(i41);
                        }
                        if (i42 < i14 && i42 < i2) {
                            if (isRtl) {
                                i41 -= -widgetRun6.end.margin;
                            } else {
                                i41 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }
}
