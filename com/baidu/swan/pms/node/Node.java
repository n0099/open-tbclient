package com.baidu.swan.pms.node;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.n.j.d;
import c.a.o0.n.j.e;
import c.a.o0.n.j.j.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
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
    public Class<? extends e> mParamsProvider;
    public Class<? extends d> mProcessor;

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
        HOST = new Node("HOST", 0, "host", c.class, c.a.o0.n.j.j.d.class);
        PACKAGE = new Node("PACKAGE", 1, AsInstallService.SCHEME_PACKAGE_ADDED, c.a.o0.n.j.k.d.class, c.a.o0.n.j.k.e.class, true);
        CERES = new Node("CERES", 2, "ceres", c.a.o0.n.j.h.c.class, c.a.o0.n.j.h.d.class);
        Node node = new Node("COMMON", 3, "common", c.a.o0.n.j.i.c.class, c.a.o0.n.j.i.d.class);
        COMMON = node;
        $VALUES = new Node[]{HOST, PACKAGE, CERES, node};
    }

    public Node(String str, int i2, String str2, Class cls, Class cls2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, cls, cls2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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

    public static e getProvider(Node node) {
        InterceptResult invokeL;
        Class<? extends e> paramsProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, node)) == null) {
            if (node == null || (paramsProvider = node.getParamsProvider()) == null) {
                return null;
            }
            try {
                return paramsProvider.newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                if (c.a.o0.n.c.f11828a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (e) invokeL.objValue;
    }

    public static Node valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (Node) Enum.valueOf(Node.class, str) : (Node) invokeL.objValue;
    }

    public static Node[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (Node[]) $VALUES.clone() : (Node[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public Class<? extends e> getParamsProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamsProvider : (Class) invokeV.objValue;
    }

    public Class<? extends d> getProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProcessor : (Class) invokeV.objValue;
    }

    public boolean isDataArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsDataArray : invokeV.booleanValue;
    }

    public Node(String str, int i2, String str2, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
