package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class KeyPath {
    public static /* synthetic */ Interceptable $ic;
    public static final KeyPath COMPOSITION;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> keys;
    @Nullable
    public KeyPathElement resolvedElement;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-594856284, "Lcom/airbnb/lottie/model/KeyPath;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-594856284, "Lcom/airbnb/lottie/model/KeyPath;");
                return;
            }
        }
        COMPOSITION = new KeyPath("COMPOSITION");
    }

    public KeyPath(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            List<String> list = this.keys;
            return list.get(list.size() - 1).equals("**");
        }
        return invokeV.booleanValue;
    }

    private boolean isContainer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) ? "__container".equals(str) : invokeL.booleanValue;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath addKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            KeyPath keyPath = new KeyPath(this);
            keyPath.keys.add(str);
            return keyPath;
        }
        return (KeyPath) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (i2 >= this.keys.size()) {
                return false;
            }
            boolean z = i2 == this.keys.size() - 1;
            String str2 = this.keys.get(i2);
            if (!str2.equals("**")) {
                return (z || (i2 == this.keys.size() + (-2) && endsWithGlobstar())) && (str2.equals(str) || str2.equals("*"));
            }
            if (!z && this.keys.get(i2 + 1).equals(str)) {
                return i2 == this.keys.size() + (-2) || (i2 == this.keys.size() + (-3) && endsWithGlobstar());
            } else if (z) {
                return true;
            } else {
                int i3 = i2 + 1;
                if (i3 < this.keys.size() - 1) {
                    return false;
                }
                return this.keys.get(i3).equals(str);
            }
        }
        return invokeLI.booleanValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement getResolvedElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resolvedElement : (KeyPathElement) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            if (isContainer(str)) {
                return 0;
            }
            if (this.keys.get(i2).equals("**")) {
                return (i2 != this.keys.size() - 1 && this.keys.get(i2 + 1).equals(str)) ? 2 : 0;
            }
            return 1;
        }
        return invokeLI.intValue;
    }

    public String keysToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.keys.toString() : (String) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean matches(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (isContainer(str)) {
                return true;
            }
            if (i2 >= this.keys.size()) {
                return false;
            }
            return this.keys.get(i2).equals(str) || this.keys.get(i2).equals("**") || this.keys.get(i2).equals("*");
        }
        return invokeLI.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) ? "__container".equals(str) || i2 < this.keys.size() - 1 || this.keys.get(i2).equals("**") : invokeLI.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath resolve(KeyPathElement keyPathElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyPathElement)) == null) {
            KeyPath keyPath = new KeyPath(this);
            keyPath.resolvedElement = keyPathElement;
            return keyPath;
        }
        return (KeyPath) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("KeyPath{keys=");
            sb.append(this.keys);
            sb.append(",resolved=");
            sb.append(this.resolvedElement != null);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public KeyPath(KeyPath keyPath) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {keyPath};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
