package androidx.constraintlayout.solver;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Metrics {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long iterations;
    public long lastTableSize;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measures;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts;
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;

    public Metrics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.problematicLayouts = new ArrayList<>();
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.measures = 0L;
            this.additionalMeasures = 0L;
            this.resolutions = 0L;
            this.tableSizeIncrease = 0L;
            this.maxTableSize = 0L;
            this.lastTableSize = 0L;
            this.maxVariables = 0L;
            this.maxRows = 0L;
            this.minimize = 0L;
            this.minimizeGoal = 0L;
            this.constraints = 0L;
            this.simpleconstraints = 0L;
            this.optimize = 0L;
            this.iterations = 0L;
            this.pivots = 0L;
            this.bfs = 0L;
            this.variables = 0L;
            this.errors = 0L;
            this.slackvariables = 0L;
            this.extravariables = 0L;
            this.fullySolved = 0L;
            this.graphOptimizer = 0L;
            this.resolvedWidgets = 0L;
            this.oldresolvedWidgets = 0L;
            this.nonresolvedWidgets = 0L;
            this.centerConnectionResolved = 0L;
            this.matchConnectionResolved = 0L;
            this.chainConnectionResolved = 0L;
            this.barrierConnectionResolved = 0L;
            this.problematicLayouts.clear();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "\n*** Metrics ***\nmeasures: " + this.measures + "\nadditionalMeasures: " + this.additionalMeasures + "\nresolutions passes: " + this.resolutions + "\ntable increases: " + this.tableSizeIncrease + "\nmaxTableSize: " + this.maxTableSize + "\nmaxVariables: " + this.maxVariables + "\nmaxRows: " + this.maxRows + "\n\nminimize: " + this.minimize + "\nminimizeGoal: " + this.minimizeGoal + "\nconstraints: " + this.constraints + "\nsimpleconstraints: " + this.simpleconstraints + "\noptimize: " + this.optimize + "\niterations: " + this.iterations + "\npivots: " + this.pivots + "\nbfs: " + this.bfs + "\nvariables: " + this.variables + "\nerrors: " + this.errors + "\nslackvariables: " + this.slackvariables + "\nextravariables: " + this.extravariables + "\nfullySolved: " + this.fullySolved + "\ngraphOptimizer: " + this.graphOptimizer + "\nresolvedWidgets: " + this.resolvedWidgets + "\noldresolvedWidgets: " + this.oldresolvedWidgets + "\nnonresolvedWidgets: " + this.nonresolvedWidgets + "\ncenterConnectionResolved: " + this.centerConnectionResolved + "\nmatchConnectionResolved: " + this.matchConnectionResolved + "\nchainConnectionResolved: " + this.chainConnectionResolved + "\nbarrierConnectionResolved: " + this.barrierConnectionResolved + "\nproblematicsLayouts: " + this.problematicLayouts + "\n";
        }
        return (String) invokeV.objValue;
    }
}
