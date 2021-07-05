package androidx.constraintlayout.solver.widgets;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ResolutionNode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REMOVED = 2;
    public static final int RESOLVED = 1;
    public static final int UNRESOLVED = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<ResolutionNode> dependents;
    public int state;

    public ResolutionNode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dependents = new HashSet<>(2);
        this.state = 0;
    }

    public void addDependent(ResolutionNode resolutionNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, resolutionNode) == null) {
            this.dependents.add(resolutionNode);
        }
    }

    public void didResolve() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.state = 1;
            Iterator<ResolutionNode> it = this.dependents.iterator();
            while (it.hasNext()) {
                it.next().resolve();
            }
        }
    }

    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state = 0;
            Iterator<ResolutionNode> it = this.dependents.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }

    public void invalidateAnchors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this instanceof ResolutionAnchor) {
                this.state = 0;
            }
            Iterator<ResolutionNode> it = this.dependents.iterator();
            while (it.hasNext()) {
                it.next().invalidateAnchors();
            }
        }
    }

    public boolean isResolved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.state == 1 : invokeV.booleanValue;
    }

    public void remove(ResolutionDimension resolutionDimension) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, resolutionDimension) == null) {
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.state = 0;
            this.dependents.clear();
        }
    }

    public void resolve() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
