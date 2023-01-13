package com.baidu.searchbox.abtest;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.tieba.b9;
import com.baidu.tieba.c9;
import com.baidu.tieba.i9;
import com.baidu.tieba.k9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AbTestManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "AbTestManager";
    public static AbTestManager mAbTestManager;
    public transient /* synthetic */ FieldHolder $fh;
    public c9 mExperimentManager;

    @Deprecated
    public void addEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-910776733, "Lcom/baidu/searchbox/abtest/AbTestManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-910776733, "Lcom/baidu/searchbox/abtest/AbTestManager;");
                return;
            }
        }
        DEBUG = ABTestConfig.isDebug();
    }

    public AbTestManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExperimentManager = c9.n(AppRuntime.getAppContext());
    }

    public static AbTestManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mAbTestManager == null) {
                synchronized (AbTestManager.class) {
                    if (mAbTestManager == null) {
                        mAbTestManager = new AbTestManager();
                    }
                }
            }
            return mAbTestManager;
        }
        return (AbTestManager) invokeV.objValue;
    }

    public void forceReloadConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mExperimentManager.h();
            BdEventBus.Companion.getDefault().post(new k9());
        }
    }

    public String getExpInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExperimentManager.m();
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<b9> getExperimentInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mExperimentManager.l();
        }
        return (ArrayList) invokeV.objValue;
    }

    public JSONObject getRawSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mExperimentManager.q();
        }
        return (JSONObject) invokeV.objValue;
    }

    public void addLocalExpInfo(i9 i9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i9Var) == null) {
            this.mExperimentManager.g(i9Var);
        }
    }

    @Deprecated
    public void forceReloadConfig(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.mExperimentManager.i(list);
        }
    }

    public JSONObject getRawSwitch(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.mExperimentManager.q();
        }
        return (JSONObject) invokeI.objValue;
    }

    public boolean isInExperiment(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            return this.mExperimentManager.x(i);
        }
        return invokeI.booleanValue;
    }

    public ArrayList<String> getSidsFromTids(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList)) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<b9> l = this.mExperimentManager.l();
            if (l == null) {
                return arrayList2;
            }
            for (int i = 0; i < l.size(); i++) {
                b9 b9Var = l.get(i);
                if (b9Var != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (arrayList.get(i2).intValue() == b9Var.c()) {
                            arrayList2.add(b9Var.c() + "_" + b9Var.b());
                        }
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public double getSwitch(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Double.valueOf(d)})) == null) {
            double k = this.mExperimentManager.k(str, d);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + k + " default value :" + d);
            }
            return k;
        }
        return invokeCommon.doubleValue;
    }

    public int getSwitch(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            int o = this.mExperimentManager.o(str, i);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + o + " default value :" + i);
            }
            return o;
        }
        return invokeLI.intValue;
    }

    public long getSwitch(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, str, j)) == null) {
            long p = this.mExperimentManager.p(str, j);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + p + " default value :" + j);
            }
            return p;
        }
        return invokeLJ.longValue;
    }

    public Object getSwitch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Object t = this.mExperimentManager.t(str);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + t);
            }
            return t;
        }
        return invokeL.objValue;
    }

    public boolean has(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            boolean v = this.mExperimentManager.v(str);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " has key: " + v);
            }
            return v;
        }
        return invokeL.booleanValue;
    }

    public String getSwitch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            String r = this.mExperimentManager.r(str, str2);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + r + " default value :" + str2);
            }
            return r;
        }
        return (String) invokeLL.objValue;
    }

    public boolean getSwitch(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            boolean j = this.mExperimentManager.j(str, z);
            if (DEBUG) {
                Log.d(TAG, " get switch key: " + str + " switch value: " + j + " default value :" + z);
            }
            return j;
        }
        return invokeLZ.booleanValue;
    }

    @Deprecated
    public int getValueFromOldABCache(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            return this.mExperimentManager.u(str, i);
        }
        return invokeLI.intValue;
    }
}
