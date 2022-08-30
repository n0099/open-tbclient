package com.baidu.swan.pms.node;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jc4;
import com.baidu.tieba.kc4;
import com.baidu.tieba.od4;
import com.baidu.tieba.pc4;
import com.baidu.tieba.pd4;
import com.baidu.tieba.qc4;
import com.baidu.tieba.tc4;
import com.baidu.tieba.td4;
import com.baidu.tieba.uc4;
import com.baidu.tieba.ud4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Node {
    public static final /* synthetic */ Node[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Node CERES;
    public static final Node COMMON;
    public static final Node HOST;
    public static final Node PACKAGE;
    public static final String TAG = "LXNODE";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends kc4> mParamsProvider;
    public Class<? extends jc4> mProcessor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1568771051, "Lcom/baidu/swan/pms/node/Node;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1568771051, "Lcom/baidu/swan/pms/node/Node;");
                return;
            }
        }
        HOST = new Node("HOST", 0, "host", od4.class, pd4.class);
        PACKAGE = new Node("PACKAGE", 1, "package", td4.class, ud4.class, true);
        CERES = new Node("CERES", 2, "ceres", pc4.class, qc4.class);
        Node node = new Node("COMMON", 3, "common", tc4.class, uc4.class);
        COMMON = node;
        $VALUES = new Node[]{HOST, PACKAGE, CERES, node};
    }

    public Node(String str, int i, String str2, Class cls, Class cls2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, cls, cls2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mName = str2;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = z;
    }

    public static Node getNodeByConfigName(String str) {
        InterceptResult invokeL;
        Node[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            for (Node node : values()) {
                if (node != null && TextUtils.equals(node.getName(), str)) {
                    return node;
                }
            }
            return null;
        }
        return (Node) invokeL.objValue;
    }

    public static kc4 getProvider(Node node) {
        InterceptResult invokeL;
        Class<? extends kc4> paramsProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, node)) == null) {
            if (node == null || (paramsProvider = node.getParamsProvider()) == null) {
                return null;
            }
            try {
                return paramsProvider.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                return null;
            }
        }
        return (kc4) invokeL.objValue;
    }

    public static Node valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (Node) Enum.valueOf(Node.class, str) : (Node) invokeL.objValue;
    }

    public static Node[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (Node[]) $VALUES.clone() : (Node[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public Class<? extends kc4> getParamsProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamsProvider : (Class) invokeV.objValue;
    }

    public Class<? extends jc4> getProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProcessor : (Class) invokeV.objValue;
    }

    public boolean isDataArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsDataArray : invokeV.booleanValue;
    }

    public Node(String str, int i, String str2, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = str2;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = false;
    }
}
