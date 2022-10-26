package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class DependencyGraph {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean USE_GROUPS = true;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintWidgetContainer container;
    public ConstraintWidgetContainer mContainer;
    public ArrayList<RunGroup> mGroups;
    public BasicMeasure.Measure mMeasure;
    public BasicMeasure.Measurer mMeasurer;
    public boolean mNeedBuildGraph;
    public boolean mNeedRedoMeasures;
    public ArrayList<WidgetRun> mRuns;
    public ArrayList<RunGroup> runGroups;

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidgetContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList<>();
        this.runGroups = new ArrayList<>();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList<>();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{dependencyNode, Integer.valueOf(i), Integer.valueOf(i2), dependencyNode2, arrayList, runGroup}) == null) {
            WidgetRun widgetRun = dependencyNode.run;
            if (widgetRun.runGroup == null) {
                ConstraintWidgetContainer constraintWidgetContainer = this.container;
                if (widgetRun != constraintWidgetContainer.horizontalRun && widgetRun != constraintWidgetContainer.verticalRun) {
                    if (runGroup == null) {
                        runGroup = new RunGroup(widgetRun, i2);
                        arrayList.add(runGroup);
                    }
                    widgetRun.runGroup = runGroup;
                    runGroup.add(widgetRun);
                    for (Dependency dependency : widgetRun.start.dependencies) {
                        if (dependency instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
                        }
                    }
                    for (Dependency dependency2 : widgetRun.end.dependencies) {
                        if (dependency2 instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
                        }
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                            if (dependency3 instanceof DependencyNode) {
                                applyGroup((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                            }
                        }
                    }
                    for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                        if (dependencyNode3 == dependencyNode2) {
                            runGroup.dual = true;
                        }
                        applyGroup(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
                    }
                    for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                        if (dependencyNode4 == dependencyNode2) {
                            runGroup.dual = true;
                        }
                        applyGroup(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).baseline.targets) {
                            applyGroup(dependencyNode5, i, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, constraintWidgetContainer)) == null) {
            Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                if (next.getVisibility() == 8) {
                    next.measured = true;
                } else {
                    if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mMatchConstraintDefaultWidth = 2;
                    }
                    if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mMatchConstraintDefaultHeight = 2;
                    }
                    if (next.getDimensionRatio() > 0.0f) {
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            next.mMatchConstraintDefaultWidth = 3;
                        } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            next.mMatchConstraintDefaultHeight = 3;
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
                                if (next.mMatchConstraintDefaultWidth == 0) {
                                    next.mMatchConstraintDefaultWidth = 3;
                                }
                                if (next.mMatchConstraintDefaultHeight == 0) {
                                    next.mMatchConstraintDefaultHeight = 3;
                                }
                            }
                        }
                    }
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour;
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour2;
                    HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                    horizontalWidgetRun.dimensionBehavior = dimensionBehaviour4;
                    horizontalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                    VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                    verticalWidgetRun.dimensionBehavior = dimensionBehaviour5;
                    verticalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                    if ((dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour5 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour5 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                        if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            int i4 = next.mMatchConstraintDefaultWidth;
                            if (i4 == 3) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour5 == dimensionBehaviour6) {
                                    measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                                }
                                int height = next.getHeight();
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
                                measure(next, dimensionBehaviour7, (int) ((height * next.mDimensionRatio) + 0.5f), dimensionBehaviour7, height);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            } else if (i4 == 1) {
                                measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                next.horizontalRun.dimension.wrapValue = next.getWidth();
                            } else if (i4 == 2) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                                if (dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour5, next.getHeight());
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            } else {
                                ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                    measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        }
                        if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                            int i5 = next.mMatchConstraintDefaultHeight;
                            if (i5 == 3) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour4 == dimensionBehaviour8) {
                                    measure(next, dimensionBehaviour8, 0, dimensionBehaviour8, 0);
                                }
                                int width = next.getWidth();
                                float f = next.mDimensionRatio;
                                if (next.getDimensionRatioSide() == -1) {
                                    f = 1.0f / f;
                                }
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.FIXED;
                                measure(next, dimensionBehaviour9, width, dimensionBehaviour9, (int) ((width * f) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            } else if (i5 == 1) {
                                measure(next, dimensionBehaviour4, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                                next.verticalRun.dimension.wrapValue = next.getHeight();
                            } else if (i5 == 2) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                                if (dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                    measure(next, dimensionBehaviour4, next.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            } else {
                                ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                                if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                    measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        }
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour4 == dimensionBehaviour10 && dimensionBehaviour5 == dimensionBehaviour10) {
                            int i6 = next.mMatchConstraintDefaultWidth;
                            if (i6 != 1 && (i3 = next.mMatchConstraintDefaultHeight) != 1) {
                                if (i3 == 2 && i6 == 2) {
                                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                                    ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviourArr4[0];
                                    ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                                    if (dimensionBehaviour11 == dimensionBehaviour12 || dimensionBehaviourArr4[0] == dimensionBehaviour12) {
                                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr5 = constraintWidgetContainer.mListDimensionBehaviors;
                                        ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dimensionBehaviourArr5[1];
                                        ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                                        if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviourArr5[1] == dimensionBehaviour14) {
                                            float f2 = next.mMatchConstraintPercentWidth;
                                            float f3 = next.mMatchConstraintPercentHeight;
                                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                                            measure(next, dimensionBehaviour15, (int) ((f2 * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour15, (int) ((f3 * constraintWidgetContainer.getHeight()) + 0.5f));
                                            next.horizontalRun.dimension.resolve(next.getWidth());
                                            next.verticalRun.dimension.resolve(next.getHeight());
                                            next.measured = true;
                                        }
                                    }
                                }
                            } else {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                measure(next, dimensionBehaviour16, 0, dimensionBehaviour16, 0);
                                next.horizontalRun.dimension.wrapValue = next.getWidth();
                                next.verticalRun.dimension.wrapValue = next.getHeight();
                            }
                        }
                    } else {
                        int width2 = next.getWidth();
                        if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            i = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                            dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                        } else {
                            i = width2;
                        }
                        int height2 = next.getHeight();
                        if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                            dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                        } else {
                            i2 = height2;
                        }
                        measure(next, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        InterceptResult invokeL;
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, widgetRun)) == null) {
            boolean z = widgetRun instanceof VerticalWidgetRun;
            String debugName = widgetRun.widget.getDebugName();
            ConstraintWidget constraintWidget = widgetRun.widget;
            if (!z) {
                verticalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            } else {
                verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
            }
            RunGroup runGroup = widgetRun.runGroup;
            if (!z) {
                str = debugName + "_HORIZONTAL";
            } else {
                str = debugName + "_VERTICAL";
            }
            String str5 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
            if (!z) {
                String str6 = str5 + "    <TD ";
                if (widgetRun.start.resolved) {
                    str6 = str6 + " BGCOLOR=\"green\"";
                }
                str2 = str6 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
            } else {
                String str7 = str5 + "    <TD ";
                if (widgetRun.start.resolved) {
                    str7 = str7 + " BGCOLOR=\"green\"";
                }
                str2 = str7 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
            }
            String str8 = str2 + "    <TD BORDER=\"1\" ";
            if (widgetRun.dimension.resolved && !widgetRun.widget.measured) {
                str8 = str8 + " BGCOLOR=\"green\" ";
            } else if (widgetRun.dimension.resolved && widgetRun.widget.measured) {
                str8 = str8 + " BGCOLOR=\"lightgray\" ";
            } else if (!widgetRun.dimension.resolved && widgetRun.widget.measured) {
                str8 = str8 + " BGCOLOR=\"yellow\" ";
            }
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                str8 = str8 + "style=\"dashed\"";
            }
            if (runGroup != null) {
                str3 = " [" + (runGroup.groupIndex + 1) + "/" + RunGroup.index + PreferencesUtil.RIGHT_MOUNT;
            } else {
                str3 = "";
            }
            String str9 = str8 + ">" + debugName + str3 + " </TD>";
            if (!z) {
                String str10 = str9 + "    <TD ";
                if (widgetRun.end.resolved) {
                    str10 = str10 + " BGCOLOR=\"green\"";
                }
                str4 = str10 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
            } else {
                String str11 = str9 + "    <TD ";
                if (z && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                    str11 = str11 + " BGCOLOR=\"green\"";
                }
                String str12 = (str11 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
                if (widgetRun.end.resolved) {
                    str12 = str12 + " BGCOLOR=\"green\"";
                }
                str4 = str12 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
            }
            return (str4 + "  </TR></TABLE>") + ">];\n";
        }
        return (String) invokeL.objValue;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, constraintWidgetContainer, i)) == null) {
            int size = this.mGroups.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                j = Math.max(j, this.mGroups.get(i2).computeWrapSize(constraintWidgetContainer, i));
            }
            return (int) j;
        }
        return invokeLI.intValue;
    }

    private void displayGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            String str = "digraph {\n";
            while (it.hasNext()) {
                str = generateDisplayGraph(it.next(), str);
            }
            String str2 = str + "\n}\n";
            System.out.println("content:<<\n" + str2 + "\n>>");
        }
    }

    private void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, this, widgetRun, i, arrayList) == null) {
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
                } else if (dependency instanceof WidgetRun) {
                    applyGroup(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
                } else if (dependency2 instanceof WidgetRun) {
                    applyGroup(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
                }
            }
            if (i == 1) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i, 2, null, arrayList, null);
                    }
                }
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, chainRun, str)) == null) {
            int i = chainRun.orientation;
            String str4 = "cluster_" + chainRun.widget.getDebugName();
            if (i == 0) {
                str2 = str4 + "_h";
            } else {
                str2 = str4 + "_v";
            }
            String str5 = "subgraph " + str2 + " {\n";
            Iterator<WidgetRun> it = chainRun.widgets.iterator();
            String str6 = "";
            while (it.hasNext()) {
                WidgetRun next = it.next();
                String debugName = next.widget.getDebugName();
                if (i == 0) {
                    str3 = debugName + "_HORIZONTAL";
                } else {
                    str3 = debugName + "_VERTICAL";
                }
                str5 = str5 + str3 + ";\n";
                str6 = generateDisplayGraph(next, str6);
            }
            return str + str6 + (str5 + "}\n");
        }
        return (String) invokeLL.objValue;
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, widgetRun, str)) == null) {
            DependencyNode dependencyNode = widgetRun.start;
            DependencyNode dependencyNode2 = widgetRun.end;
            if (!(widgetRun instanceof HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() & dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
                return str;
            }
            boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
            String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str + nodeDefinition(widgetRun)));
            boolean z2 = widgetRun instanceof VerticalWidgetRun;
            if (z2) {
                generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
            }
            if (!(widgetRun instanceof HorizontalWidgetRun) && (!((z = widgetRun instanceof ChainRun)) || ((ChainRun) widgetRun).orientation != 0)) {
                if (z2 || (z && ((ChainRun) widgetRun).orientation == 1)) {
                    ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
                    if (verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                            String debugName = widgetRun.widget.getDebugName();
                            String str2 = "\n" + debugName + "_VERTICAL -> " + debugName + "_HORIZONTAL;\n";
                        }
                    } else if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                        generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + LoadErrorCode.TOKEN_NEXT + dependencyNode.name() + "\n");
                    } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                        generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + LoadErrorCode.TOKEN_NEXT + dependencyNode2.name() + "\n");
                    }
                }
            } else {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
                if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                        String debugName2 = widgetRun.widget.getDebugName();
                        String str3 = "\n" + debugName2 + "_HORIZONTAL -> " + debugName2 + "_VERTICAL;\n";
                    }
                } else if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + LoadErrorCode.TOKEN_NEXT + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + LoadErrorCode.TOKEN_NEXT + dependencyNode2.name() + "\n");
                }
            }
            if (widgetRun instanceof ChainRun) {
                return generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode);
            }
            return generateDisplayNode;
        }
        return (String) invokeLL.objValue;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{dependencyNode, Boolean.valueOf(z), str})) == null) {
            Iterator<DependencyNode> it = dependencyNode.targets.iterator();
            while (it.hasNext()) {
                String str2 = ("\n" + dependencyNode.name()) + LoadErrorCode.TOKEN_NEXT + it.next().name();
                if (dependencyNode.margin > 0 || z || (dependencyNode.run instanceof HelperReferences)) {
                    String str3 = str2 + PreferencesUtil.LEFT_MOUNT;
                    if (dependencyNode.margin > 0) {
                        str3 = str3 + "label=\"" + dependencyNode.margin + "\"";
                        if (z) {
                            str3 = str3 + ",";
                        }
                    }
                    if (z) {
                        str3 = str3 + " style=dashed ";
                    }
                    if (dependencyNode.run instanceof HelperReferences) {
                        str3 = str3 + " style=bold,color=gray ";
                    }
                    str2 = str3 + PreferencesUtil.RIGHT_MOUNT;
                }
                str = str + (str2 + "\n");
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, dependencyNode, dependencyNode2)) == null) {
            int i = 0;
            for (DependencyNode dependencyNode3 : dependencyNode.targets) {
                if (dependencyNode3 != dependencyNode2) {
                    i++;
                }
            }
            int i2 = 0;
            for (DependencyNode dependencyNode4 : dependencyNode2.targets) {
                if (dependencyNode4 != dependencyNode) {
                    i2++;
                }
            }
            if (i <= 0 || i2 <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dimensionBehaviour, dimensionBehaviour2) == null) && this.mNeedBuildGraph) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z3 = true;
                }
            }
            if (!z3) {
                Iterator<RunGroup> it2 = this.mGroups.iterator();
                while (it2.hasNext()) {
                    RunGroup next2 = it2.next();
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    next2.defineTerminalWidgets(z, z2);
                }
            }
        }
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{constraintWidget, dimensionBehaviour, Integer.valueOf(i), dimensionBehaviour2, Integer.valueOf(i2)}) == null) {
            BasicMeasure.Measure measure = this.mMeasure;
            measure.horizontalBehavior = dimensionBehaviour;
            measure.verticalBehavior = dimensionBehaviour2;
            measure.horizontalDimension = i;
            measure.verticalDimension = i2;
            this.mMeasurer.measure(constraintWidget, measure);
            constraintWidget.setWidth(this.mMeasure.measuredWidth);
            constraintWidget.setHeight(this.mMeasure.measuredHeight);
            constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        }
    }

    public void buildGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            buildGraph(this.mRuns);
            this.mGroups.clear();
            RunGroup.index = 0;
            findGroup(this.container.horizontalRun, 0, this.mGroups);
            findGroup(this.container.verticalRun, 1, this.mGroups);
            this.mNeedBuildGraph = false;
        }
    }

    public void invalidateGraph() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mNeedBuildGraph = true;
        }
    }

    public void invalidateMeasures() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mNeedRedoMeasures = true;
        }
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            arrayList.clear();
            this.mContainer.horizontalRun.clear();
            this.mContainer.verticalRun.clear();
            arrayList.add(this.mContainer.horizontalRun);
            arrayList.add(this.mContainer.verticalRun);
            Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
            HashSet hashSet = null;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof Guideline) {
                    arrayList.add(new GuidelineReference(next));
                } else {
                    if (next.isInHorizontalChain()) {
                        if (next.horizontalChainRun == null) {
                            next.horizontalChainRun = new ChainRun(next, 0);
                        }
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(next.horizontalChainRun);
                    } else {
                        arrayList.add(next.horizontalRun);
                    }
                    if (next.isInVerticalChain()) {
                        if (next.verticalChainRun == null) {
                            next.verticalChainRun = new ChainRun(next, 1);
                        }
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(next.verticalChainRun);
                    } else {
                        arrayList.add(next.verticalRun);
                    }
                    if (next instanceof HelperWidget) {
                        arrayList.add(new HelperReferences(next));
                    }
                }
            }
            if (hashSet != null) {
                arrayList.addAll(hashSet);
            }
            Iterator<WidgetRun> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().clear();
            }
            Iterator<WidgetRun> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                WidgetRun next2 = it3.next();
                if (next2.widget != this.mContainer) {
                    next2.apply();
                }
            }
        }
    }

    public boolean directMeasure(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            boolean z3 = true;
            boolean z4 = z & true;
            if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
                Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    next.ensureWidgetRuns();
                    next.measured = false;
                    next.horizontalRun.reset();
                    next.verticalRun.reset();
                }
                this.container.ensureWidgetRuns();
                ConstraintWidgetContainer constraintWidgetContainer = this.container;
                constraintWidgetContainer.measured = false;
                constraintWidgetContainer.horizontalRun.reset();
                this.container.verticalRun.reset();
                this.mNeedRedoMeasures = false;
            }
            if (basicMeasureWidgets(this.mContainer)) {
                return false;
            }
            this.container.setX(0);
            this.container.setY(0);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
            if (this.mNeedBuildGraph) {
                buildGraph();
            }
            int x = this.container.getX();
            int y = this.container.getY();
            this.container.horizontalRun.start.resolve(x);
            this.container.verticalRun.start.resolve(y);
            measureWidgets();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
                if (z4) {
                    Iterator<WidgetRun> it2 = this.mRuns.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (!it2.next().supportsWrapComputation()) {
                            z4 = false;
                            break;
                        }
                    }
                }
                if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                    constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
                }
                if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                    constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                    ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                    constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
                }
            }
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr[0] != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviourArr[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                z2 = false;
            } else {
                int width = this.container.getWidth() + x;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x);
                measureWidgets();
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.container.mListDimensionBehaviors;
                if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    int height = this.container.getHeight() + y;
                    this.container.verticalRun.end.resolve(height);
                    this.container.verticalRun.dimension.resolve(height - y);
                }
                measureWidgets();
                z2 = true;
            }
            Iterator<WidgetRun> it3 = this.mRuns.iterator();
            while (it3.hasNext()) {
                WidgetRun next2 = it3.next();
                if (next2.widget != this.container || next2.resolved) {
                    next2.applyToWidget();
                }
            }
            Iterator<WidgetRun> it4 = this.mRuns.iterator();
            while (it4.hasNext()) {
                WidgetRun next3 = it4.next();
                if (z2 || next3.widget != this.container) {
                    if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                        z3 = false;
                        break;
                    }
                }
            }
            this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
            this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
            return z3;
        }
        return invokeZ.booleanValue;
    }

    public boolean directMeasureSetup(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.mNeedBuildGraph) {
                Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    next.ensureWidgetRuns();
                    next.measured = false;
                    HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                    horizontalWidgetRun.dimension.resolved = false;
                    horizontalWidgetRun.resolved = false;
                    horizontalWidgetRun.reset();
                    VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                    verticalWidgetRun.dimension.resolved = false;
                    verticalWidgetRun.resolved = false;
                    verticalWidgetRun.reset();
                }
                this.container.ensureWidgetRuns();
                ConstraintWidgetContainer constraintWidgetContainer = this.container;
                constraintWidgetContainer.measured = false;
                HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
                horizontalWidgetRun2.dimension.resolved = false;
                horizontalWidgetRun2.resolved = false;
                horizontalWidgetRun2.reset();
                VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
                verticalWidgetRun2.dimension.resolved = false;
                verticalWidgetRun2.resolved = false;
                verticalWidgetRun2.reset();
                buildGraph();
            }
            if (basicMeasureWidgets(this.mContainer)) {
                return false;
            }
            this.container.setX(0);
            this.container.setY(0);
            this.container.horizontalRun.start.resolve(0);
            this.container.verticalRun.start.resolve(0);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        InterceptResult invokeCommon;
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            boolean z3 = true;
            boolean z4 = z & true;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
            int x = this.container.getX();
            int y = this.container.getY();
            if (z4 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
                Iterator<WidgetRun> it = this.mRuns.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WidgetRun next = it.next();
                    if (next.orientation == i && !next.supportsWrapComputation()) {
                        z4 = false;
                        break;
                    }
                }
                if (i == 0) {
                    if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        ConstraintWidgetContainer constraintWidgetContainer = this.container;
                        constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                        ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                        constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                    }
                } else if (z4 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                    constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                    ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                    constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
                }
            }
            if (i == 0) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
                if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    int width = this.container.getWidth() + x;
                    this.container.horizontalRun.end.resolve(width);
                    this.container.horizontalRun.dimension.resolve(width - x);
                    z2 = true;
                }
                z2 = false;
            } else {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.container.mListDimensionBehaviors;
                if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    int height = this.container.getHeight() + y;
                    this.container.verticalRun.end.resolve(height);
                    this.container.verticalRun.dimension.resolve(height - y);
                    z2 = true;
                }
                z2 = false;
            }
            measureWidgets();
            Iterator<WidgetRun> it2 = this.mRuns.iterator();
            while (it2.hasNext()) {
                WidgetRun next2 = it2.next();
                if (next2.orientation == i && (next2.widget != this.container || next2.resolved)) {
                    next2.applyToWidget();
                }
            }
            Iterator<WidgetRun> it3 = this.mRuns.iterator();
            while (it3.hasNext()) {
                WidgetRun next3 = it3.next();
                if (next3.orientation == i && (z2 || next3.widget != this.container)) {
                    if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)) {
                        z3 = false;
                        break;
                    }
                }
            }
            this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
            this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public void measureWidgets() {
        boolean z;
        DimensionDependency dimensionDependency;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (!next.measured) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                    boolean z2 = false;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    int i = next.mMatchConstraintDefaultWidth;
                    int i2 = next.mMatchConstraintDefaultHeight;
                    if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || i != 1)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                        z2 = true;
                    }
                    DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                    boolean z3 = dimensionDependency2.resolved;
                    DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                    boolean z4 = dimensionDependency3.resolved;
                    if (z3 && z4) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                        measure(next, dimensionBehaviour3, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                        next.measured = true;
                    } else if (z3 && z2) {
                        measure(next, ConstraintWidget.DimensionBehaviour.FIXED, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.verticalRun.dimension.value);
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else {
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        }
                    } else if (z4 && z) {
                        measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, next.verticalRun.dimension.value);
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else {
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.measured = true;
                        }
                    }
                    if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                        dimensionDependency.resolve(next.getBaselineDistance());
                    }
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, measurer) == null) {
            this.mMeasurer = measurer;
        }
    }
}
