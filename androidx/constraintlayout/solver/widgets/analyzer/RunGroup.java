package androidx.constraintlayout.solver.widgets.analyzer;

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
public class RunGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public transient /* synthetic */ FieldHolder $fh;
    public int direction;
    public boolean dual;
    public WidgetRun firstRun;
    public int groupIndex;
    public WidgetRun lastRun;
    public int position;
    public ArrayList<WidgetRun> runs;

    public RunGroup(WidgetRun widgetRun, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {widgetRun, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList<>();
        this.groupIndex = 0;
        int i5 = index;
        this.groupIndex = i5;
        index = i5 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i2;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i2) {
        InterceptResult invokeLI;
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, widgetRun, i2)) == null) {
            if (widgetRun.widget.isTerminalWidget[i2]) {
                for (Dependency dependency : widgetRun.start.dependencies) {
                    if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                        if (widgetRun instanceof ChainRun) {
                            Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                            while (it.hasNext()) {
                                defineTerminalWidget(it.next(), i2);
                            }
                        } else if (!(widgetRun instanceof HelperReferences)) {
                            widgetRun.widget.isTerminalWidget[i2] = false;
                        }
                        defineTerminalWidget(dependencyNode2.run, i2);
                    }
                }
                for (Dependency dependency2 : widgetRun.end.dependencies) {
                    if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                        if (widgetRun instanceof ChainRun) {
                            Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                            while (it2.hasNext()) {
                                defineTerminalWidget(it2.next(), i2);
                            }
                        } else if (!(widgetRun instanceof HelperReferences)) {
                            widgetRun.widget.isTerminalWidget[i2] = false;
                        }
                        defineTerminalWidget(dependencyNode.run, i2);
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, this, dependencyNode, j)) == null) {
            WidgetRun widgetRun = dependencyNode.run;
            if (widgetRun instanceof HelperReferences) {
                return j;
            }
            int size = dependencyNode.dependencies.size();
            long j2 = j;
            for (int i2 = 0; i2 < size; i2++) {
                Dependency dependency = dependencyNode.dependencies.get(i2);
                if (dependency instanceof DependencyNode) {
                    DependencyNode dependencyNode2 = (DependencyNode) dependency;
                    if (dependencyNode2.run != widgetRun) {
                        j2 = Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.margin + j));
                    }
                }
            }
            if (dependencyNode == widgetRun.end) {
                long wrapDimension = j - widgetRun.getWrapDimension();
                return Math.min(Math.min(j2, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    private long traverseStart(DependencyNode dependencyNode, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, dependencyNode, j)) == null) {
            WidgetRun widgetRun = dependencyNode.run;
            if (widgetRun instanceof HelperReferences) {
                return j;
            }
            int size = dependencyNode.dependencies.size();
            long j2 = j;
            for (int i2 = 0; i2 < size; i2++) {
                Dependency dependency = dependencyNode.dependencies.get(i2);
                if (dependency instanceof DependencyNode) {
                    DependencyNode dependencyNode2 = (DependencyNode) dependency;
                    if (dependencyNode2.run != widgetRun) {
                        j2 = Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.margin + j));
                    }
                }
            }
            if (dependencyNode == widgetRun.start) {
                long wrapDimension = j + widgetRun.getWrapDimension();
                return Math.max(Math.max(j2, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    public void add(WidgetRun widgetRun) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, widgetRun) == null) {
            this.runs.add(widgetRun);
            this.lastRun = widgetRun;
        }
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        InterceptResult invokeLI;
        long wrapDimension;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidgetContainer, i2)) == null) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof ChainRun) {
                if (((ChainRun) widgetRun).orientation != i2) {
                    return 0L;
                }
            } else if (i2 == 0) {
                if (!(widgetRun instanceof HorizontalWidgetRun)) {
                    return 0L;
                }
            } else if (!(widgetRun instanceof VerticalWidgetRun)) {
                return 0L;
            }
            DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
            DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
            boolean contains = this.firstRun.start.targets.contains(dependencyNode);
            boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
            long wrapDimension2 = this.firstRun.getWrapDimension();
            if (contains && contains2) {
                long traverseStart = traverseStart(this.firstRun.start, 0L);
                long traverseEnd = traverseEnd(this.firstRun.end, 0L);
                long j = traverseStart - wrapDimension2;
                int i4 = this.firstRun.end.margin;
                if (j >= (-i4)) {
                    j += i4;
                }
                int i5 = this.firstRun.start.margin;
                long j2 = ((-traverseEnd) - wrapDimension2) - i5;
                if (j2 >= i5) {
                    j2 -= i5;
                }
                float biasPercent = this.firstRun.widget.getBiasPercent(i2);
                float f2 = (float) (biasPercent > 0.0f ? (((float) j2) / biasPercent) + (((float) j) / (1.0f - biasPercent)) : 0L);
                long j3 = (f2 * biasPercent) + 0.5f + wrapDimension2 + (f2 * (1.0f - biasPercent)) + 0.5f;
                WidgetRun widgetRun2 = this.firstRun;
                wrapDimension = widgetRun2.start.margin + j3;
                i3 = widgetRun2.end.margin;
            } else if (contains) {
                DependencyNode dependencyNode3 = this.firstRun.start;
                return Math.max(traverseStart(dependencyNode3, dependencyNode3.margin), this.firstRun.start.margin + wrapDimension2);
            } else if (contains2) {
                DependencyNode dependencyNode4 = this.firstRun.end;
                return Math.max(-traverseEnd(dependencyNode4, dependencyNode4.margin), (-this.firstRun.end.margin) + wrapDimension2);
            } else {
                WidgetRun widgetRun3 = this.firstRun;
                wrapDimension = widgetRun3.start.margin + widgetRun3.getWrapDimension();
                i3 = this.firstRun.end.margin;
            }
            return wrapDimension - i3;
        }
        return invokeLI.longValue;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                WidgetRun widgetRun = this.firstRun;
                if (widgetRun instanceof HorizontalWidgetRun) {
                    defineTerminalWidget(widgetRun, 0);
                }
            }
            if (z2) {
                WidgetRun widgetRun2 = this.firstRun;
                if (widgetRun2 instanceof VerticalWidgetRun) {
                    defineTerminalWidget(widgetRun2, 1);
                }
            }
        }
    }
}
