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

    public RunGroup(WidgetRun widgetRun, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {widgetRun, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        int i4 = index;
        this.groupIndex = i4;
        index = i4 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i;
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
            for (int i = 0; i < size; i++) {
                Dependency dependency = dependencyNode.dependencies.get(i);
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
            for (int i = 0; i < size; i++) {
                Dependency dependency = dependencyNode.dependencies.get(i);
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

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i) {
        InterceptResult invokeLI;
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, widgetRun, i)) == null) {
            if (!widgetRun.widget.isTerminalWidget[i]) {
                return false;
            }
            for (Dependency dependency : widgetRun.start.dependencies) {
                if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                        while (it.hasNext()) {
                            defineTerminalWidget(it.next(), i);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i] = false;
                    }
                    defineTerminalWidget(dependencyNode2.run, i);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                        while (it2.hasNext()) {
                            defineTerminalWidget(it2.next(), i);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i] = false;
                    }
                    defineTerminalWidget(dependencyNode.run, i);
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void add(WidgetRun widgetRun) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, widgetRun) == null) {
            this.runs.add(widgetRun);
            this.lastRun = widgetRun;
        }
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        InterceptResult invokeLI;
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        WidgetRun widgetRun3;
        long wrapDimension;
        int i2;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidgetContainer, i)) == null) {
            WidgetRun widgetRun5 = this.firstRun;
            long j = 0;
            if (widgetRun5 instanceof ChainRun) {
                if (((ChainRun) widgetRun5).orientation != i) {
                    return 0L;
                }
            } else if (i == 0) {
                if (!(widgetRun5 instanceof HorizontalWidgetRun)) {
                    return 0L;
                }
            } else if (!(widgetRun5 instanceof VerticalWidgetRun)) {
                return 0L;
            }
            if (i == 0) {
                widgetRun = constraintWidgetContainer.horizontalRun;
            } else {
                widgetRun = constraintWidgetContainer.verticalRun;
            }
            DependencyNode dependencyNode3 = widgetRun.start;
            if (i == 0) {
                widgetRun2 = constraintWidgetContainer.horizontalRun;
            } else {
                widgetRun2 = constraintWidgetContainer.verticalRun;
            }
            DependencyNode dependencyNode4 = widgetRun2.end;
            boolean contains = this.firstRun.start.targets.contains(dependencyNode3);
            boolean contains2 = this.firstRun.end.targets.contains(dependencyNode4);
            long wrapDimension2 = this.firstRun.getWrapDimension();
            if (contains && contains2) {
                long traverseStart = traverseStart(this.firstRun.start, 0L);
                long traverseEnd = traverseEnd(this.firstRun.end, 0L);
                long j2 = traverseStart - wrapDimension2;
                int i3 = this.firstRun.end.margin;
                if (j2 >= (-i3)) {
                    j2 += i3;
                }
                int i4 = this.firstRun.start.margin;
                long j3 = ((-traverseEnd) - wrapDimension2) - i4;
                if (j3 >= i4) {
                    j3 -= i4;
                }
                float biasPercent = this.firstRun.widget.getBiasPercent(i);
                if (biasPercent > 0.0f) {
                    j = (((float) j3) / biasPercent) + (((float) j2) / (1.0f - biasPercent));
                }
                float f = (float) j;
                long j4 = (f * biasPercent) + 0.5f + wrapDimension2 + (f * (1.0f - biasPercent)) + 0.5f;
                wrapDimension = widgetRun4.start.margin + j4;
                i2 = this.firstRun.end.margin;
            } else if (contains) {
                return Math.max(traverseStart(this.firstRun.start, dependencyNode2.margin), this.firstRun.start.margin + wrapDimension2);
            } else if (contains2) {
                return Math.max(-traverseEnd(this.firstRun.end, dependencyNode.margin), (-this.firstRun.end.margin) + wrapDimension2);
            } else {
                wrapDimension = widgetRun3.start.margin + this.firstRun.getWrapDimension();
                i2 = this.firstRun.end.margin;
            }
            return wrapDimension - i2;
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
