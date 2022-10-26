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
        boolean z;
        int verticalChainStyle;
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
            if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.widgets.size() > 1) {
                ArrayList<WidgetRun> arrayList = this.widgets;
                this.widget = arrayList.get(arrayList.size() - 1).widget;
            }
            if (this.orientation == 0) {
                verticalChainStyle = this.widget.getHorizontalChainStyle();
            } else {
                verticalChainStyle = this.widget.getVerticalChainStyle();
            }
            this.chainStyle = verticalChainStyle;
        }
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
        String str;
        Iterator<WidgetRun> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ChainRun ");
            if (this.orientation == 0) {
                str = "horizontal : ";
            } else {
                str = "vertical : ";
            }
            sb.append(str);
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
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        float verticalBiasPercent;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f2;
        int i15;
        int i16;
        int i17;
        int max;
        int i18;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, dependency) == null) && this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            if (parent != null && (parent instanceof ConstraintWidgetContainer)) {
                z = ((ConstraintWidgetContainer) parent).isRtl();
            } else {
                z = false;
            }
            int i19 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i20 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i20 < size) {
                    if (this.widgets.get(i20).widget.getVisibility() != 8) {
                        break;
                    }
                    i20++;
                } else {
                    i20 = -1;
                    break;
                }
            }
            int i21 = size - 1;
            int i22 = i21;
            while (true) {
                if (i22 < 0) {
                    break;
                } else if (this.widgets.get(i22).widget.getVisibility() != 8) {
                    i = i22;
                    break;
                } else {
                    i22--;
                }
            }
            int i23 = 0;
            while (i23 < 2) {
                int i24 = 0;
                i4 = 0;
                i5 = 0;
                int i25 = 0;
                f = 0.0f;
                while (i24 < size) {
                    WidgetRun widgetRun = this.widgets.get(i24);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i25++;
                        if (i24 > 0 && i24 >= i20) {
                            i4 += widgetRun.start.margin;
                        }
                        int i26 = widgetRun.dimension.value;
                        if (widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            if (widgetRun.matchConstraintsType == 1 && i23 == 0) {
                                i26 = widgetRun.dimension.wrapValue;
                                i5++;
                            }
                            z2 = true;
                        }
                        if (!z2) {
                            i5++;
                            float f3 = widgetRun.widget.mWeight[this.orientation];
                            if (f3 >= 0.0f) {
                                f += f3;
                            }
                        } else {
                            i4 += i26;
                        }
                        if (i24 < i21 && i24 < i) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i24++;
                    i2 = 8;
                }
                if (i4 >= i19 && i5 != 0) {
                    i23++;
                    i2 = 8;
                } else {
                    i3 = i25;
                    break;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = 0.0f;
            int i27 = this.start.value;
            if (z) {
                i27 = this.end.value;
            }
            if (i4 > i19) {
                if (z) {
                    i27 += (int) (((i4 - i19) / 2.0f) + 0.5f);
                } else {
                    i27 -= (int) (((i4 - i19) / 2.0f) + 0.5f);
                }
            }
            if (i5 > 0) {
                float f4 = i19 - i4;
                int i28 = (int) ((f4 / i5) + 0.5f);
                int i29 = 0;
                int i30 = 0;
                while (i29 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i29);
                    int i31 = i28;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !widgetRun2.dimension.resolved) {
                        if (f > 0.0f) {
                            i16 = (int) (((widgetRun2.widget.mWeight[this.orientation] * f4) / f) + 0.5f);
                        } else {
                            i16 = i31;
                        }
                        if (this.orientation == 0) {
                            ConstraintWidget constraintWidget = widgetRun2.widget;
                            f2 = f4;
                            int i32 = constraintWidget.mMatchConstraintMaxWidth;
                            int i33 = constraintWidget.mMatchConstraintMinWidth;
                            i15 = i4;
                            i14 = i27;
                            if (widgetRun2.matchConstraintsType == 1) {
                                i18 = Math.min(i16, widgetRun2.dimension.wrapValue);
                            } else {
                                i18 = i16;
                            }
                            max = Math.max(i33, i18);
                            if (i32 > 0) {
                                max = Math.min(i32, max);
                            }
                        } else {
                            i14 = i27;
                            f2 = f4;
                            i15 = i4;
                            ConstraintWidget constraintWidget2 = widgetRun2.widget;
                            int i34 = constraintWidget2.mMatchConstraintMaxHeight;
                            int i35 = constraintWidget2.mMatchConstraintMinHeight;
                            if (widgetRun2.matchConstraintsType == 1) {
                                i17 = Math.min(i16, widgetRun2.dimension.wrapValue);
                            } else {
                                i17 = i16;
                            }
                            max = Math.max(i35, i17);
                            if (i34 > 0) {
                                max = Math.min(i34, max);
                            }
                        }
                    } else {
                        i14 = i27;
                        f2 = f4;
                        i15 = i4;
                    }
                    i29++;
                    i28 = i31;
                    f4 = f2;
                    i4 = i15;
                    i27 = i14;
                }
                i6 = i27;
                int i36 = i4;
                if (i30 > 0) {
                    i5 -= i30;
                    int i37 = 0;
                    for (int i38 = 0; i38 < size; i38++) {
                        WidgetRun widgetRun3 = this.widgets.get(i38);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i38 > 0 && i38 >= i20) {
                                i37 += widgetRun3.start.margin;
                            }
                            i37 += widgetRun3.dimension.value;
                            if (i38 < i21 && i38 < i) {
                                i37 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i37;
                } else {
                    i4 = i36;
                }
                i7 = 2;
                if (this.chainStyle == 2 && i30 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                i6 = i27;
                i7 = 2;
            }
            if (i4 > i19) {
                this.chainStyle = i7;
            }
            if (i3 > 0 && i5 == 0 && i20 == i) {
                this.chainStyle = i7;
            }
            int i39 = this.chainStyle;
            if (i39 == 1) {
                if (i3 > 1) {
                    i12 = (i19 - i4) / (i3 - 1);
                } else if (i3 == 1) {
                    i12 = (i19 - i4) / 2;
                } else {
                    i12 = 0;
                }
                if (i5 > 0) {
                    i12 = 0;
                }
                int i40 = i6;
                for (int i41 = 0; i41 < size; i41++) {
                    if (z) {
                        i13 = size - (i41 + 1);
                    } else {
                        i13 = i41;
                    }
                    WidgetRun widgetRun4 = this.widgets.get(i13);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i40);
                        widgetRun4.end.resolve(i40);
                    } else {
                        if (i41 > 0) {
                            if (z) {
                                i40 -= i12;
                            } else {
                                i40 += i12;
                            }
                        }
                        if (i41 > 0 && i41 >= i20) {
                            if (z) {
                                i40 -= widgetRun4.start.margin;
                            } else {
                                i40 += widgetRun4.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun4.end.resolve(i40);
                        } else {
                            widgetRun4.start.resolve(i40);
                        }
                        DimensionDependency dimensionDependency = widgetRun4.dimension;
                        int i42 = dimensionDependency.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i42 = dimensionDependency.wrapValue;
                        }
                        if (z) {
                            i40 -= i42;
                        } else {
                            i40 += i42;
                        }
                        if (z) {
                            widgetRun4.start.resolve(i40);
                        } else {
                            widgetRun4.end.resolve(i40);
                        }
                        widgetRun4.resolved = true;
                        if (i41 < i21 && i41 < i) {
                            if (z) {
                                i40 -= -widgetRun4.end.margin;
                            } else {
                                i40 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
            } else if (i39 == 0) {
                int i43 = (i19 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i43 = 0;
                }
                int i44 = i6;
                for (int i45 = 0; i45 < size; i45++) {
                    if (z) {
                        i10 = size - (i45 + 1);
                    } else {
                        i10 = i45;
                    }
                    WidgetRun widgetRun5 = this.widgets.get(i10);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i44);
                        widgetRun5.end.resolve(i44);
                    } else {
                        if (z) {
                            i11 = i44 - i43;
                        } else {
                            i11 = i44 + i43;
                        }
                        if (i45 > 0 && i45 >= i20) {
                            if (z) {
                                i11 -= widgetRun5.start.margin;
                            } else {
                                i11 += widgetRun5.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun5.end.resolve(i11);
                        } else {
                            widgetRun5.start.resolve(i11);
                        }
                        DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                        int i46 = dimensionDependency2.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i46 = Math.min(i46, dimensionDependency2.wrapValue);
                        }
                        if (z) {
                            i44 = i11 - i46;
                        } else {
                            i44 = i11 + i46;
                        }
                        if (z) {
                            widgetRun5.start.resolve(i44);
                        } else {
                            widgetRun5.end.resolve(i44);
                        }
                        if (i45 < i21 && i45 < i) {
                            if (z) {
                                i44 -= -widgetRun5.end.margin;
                            } else {
                                i44 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
            } else if (i39 == 2) {
                if (this.orientation == 0) {
                    verticalBiasPercent = this.widget.getHorizontalBiasPercent();
                } else {
                    verticalBiasPercent = this.widget.getVerticalBiasPercent();
                }
                if (z) {
                    verticalBiasPercent = 1.0f - verticalBiasPercent;
                }
                int i47 = (((int) ((((float) (i19 - i4)) * verticalBiasPercent) + 0.5f)) < 0 || i5 > 0) ? 0 : 0;
                if (z) {
                    i8 = i6 - i47;
                } else {
                    i8 = i6 + i47;
                }
                int i48 = i8;
                for (int i49 = 0; i49 < size; i49++) {
                    if (z) {
                        i9 = size - (i49 + 1);
                    } else {
                        i9 = i49;
                    }
                    WidgetRun widgetRun6 = this.widgets.get(i9);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i48);
                        widgetRun6.end.resolve(i48);
                    } else {
                        if (i49 > 0 && i49 >= i20) {
                            if (z) {
                                i48 -= widgetRun6.start.margin;
                            } else {
                                i48 += widgetRun6.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun6.end.resolve(i48);
                        } else {
                            widgetRun6.start.resolve(i48);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                        int i50 = dimensionDependency3.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i50 = dimensionDependency3.wrapValue;
                        }
                        i48 += i50;
                        if (z) {
                            widgetRun6.start.resolve(i48);
                        } else {
                            widgetRun6.end.resolve(i48);
                        }
                        if (i49 < i21 && i49 < i) {
                            if (z) {
                                i48 -= -widgetRun6.end.margin;
                            } else {
                                i48 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }
}
