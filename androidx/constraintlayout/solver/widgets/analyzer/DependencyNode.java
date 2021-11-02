package androidx.constraintlayout.solver.widgets.analyzer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DependencyNode implements Dependency {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean delegateToWidgetRun;
    public List<Dependency> dependencies;
    public int margin;
    public DimensionDependency marginDependency;
    public int marginFactor;
    public boolean readyToSolve;
    public boolean resolved;
    public WidgetRun run;
    public List<DependencyNode> targets;
    public Type type;
    public Dependency updateDelegate;
    public int value;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type BASELINE;
        public static final Type BOTTOM;
        public static final Type HORIZONTAL_DIMENSION;
        public static final Type LEFT;
        public static final Type RIGHT;
        public static final Type TOP;
        public static final Type UNKNOWN;
        public static final Type VERTICAL_DIMENSION;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1518276699, "Landroidx/constraintlayout/solver/widgets/analyzer/DependencyNode$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1518276699, "Landroidx/constraintlayout/solver/widgets/analyzer/DependencyNode$Type;");
                    return;
                }
            }
            UNKNOWN = new Type(RomUtils.UNKNOWN, 0);
            HORIZONTAL_DIMENSION = new Type("HORIZONTAL_DIMENSION", 1);
            VERTICAL_DIMENSION = new Type("VERTICAL_DIMENSION", 2);
            LEFT = new Type("LEFT", 3);
            RIGHT = new Type("RIGHT", 4);
            TOP = new Type("TOP", 5);
            BOTTOM = new Type("BOTTOM", 6);
            Type type = new Type("BASELINE", 7);
            BASELINE = type;
            $VALUES = new Type[]{UNKNOWN, HORIZONTAL_DIMENSION, VERTICAL_DIMENSION, LEFT, RIGHT, TOP, BOTTOM, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    public DependencyNode(WidgetRun widgetRun) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {widgetRun};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dependency) == null) {
            this.dependencies.add(dependency);
            if (this.resolved) {
                dependency.update(dependency);
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.targets.clear();
            this.dependencies.clear();
            this.resolved = false;
            this.value = 0;
            this.readyToSolve = false;
            this.delegateToWidgetRun = false;
        }
    }

    public String name() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String debugName = this.run.widget.getDebugName();
            Type type = this.type;
            if (type != Type.LEFT && type != Type.RIGHT) {
                str = debugName + "_VERTICAL";
            } else {
                str = debugName + "_HORIZONTAL";
            }
            return str + ":" + this.type.name();
        }
        return (String) invokeV.objValue;
    }

    public void resolve(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i2;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.run.widget.getDebugName());
            sb.append(":");
            sb.append(this.type);
            sb.append("(");
            sb.append(this.resolved ? Integer.valueOf(this.value) : "unresolved");
            sb.append(") <t=");
            sb.append(this.targets.size());
            sb.append(":d=");
            sb.append(this.dependencies.size());
            sb.append(">");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dependency) == null) {
            for (DependencyNode dependencyNode : this.targets) {
                if (!dependencyNode.resolved) {
                    return;
                }
            }
            this.readyToSolve = true;
            Dependency dependency2 = this.updateDelegate;
            if (dependency2 != null) {
                dependency2.update(this);
            }
            if (this.delegateToWidgetRun) {
                this.run.update(this);
                return;
            }
            DependencyNode dependencyNode2 = null;
            int i2 = 0;
            for (DependencyNode dependencyNode3 : this.targets) {
                if (!(dependencyNode3 instanceof DimensionDependency)) {
                    i2++;
                    dependencyNode2 = dependencyNode3;
                }
            }
            if (dependencyNode2 != null && i2 == 1 && dependencyNode2.resolved) {
                DimensionDependency dimensionDependency = this.marginDependency;
                if (dimensionDependency != null) {
                    if (!dimensionDependency.resolved) {
                        return;
                    }
                    this.margin = this.marginFactor * dimensionDependency.value;
                }
                resolve(dependencyNode2.value + this.margin);
            }
            Dependency dependency3 = this.updateDelegate;
            if (dependency3 != null) {
                dependency3.update(this);
            }
        }
    }
}
