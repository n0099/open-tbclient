package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ue;
import com.baidu.tieba.ve;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class SwitchManager {
    public static /* synthetic */ Interceptable $ic;
    public static SwitchManager sSwitchManager;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Integer> mBaseSwitchs;
    public ConcurrentHashMap<String, ve> mSwitchs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1911479039, "Lcom/baidu/adp/lib/featureSwitch/SwitchManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1911479039, "Lcom/baidu/adp/lib/featureSwitch/SwitchManager;");
        }
    }

    public SwitchManager() {
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
        this.mSwitchs = null;
        this.mBaseSwitchs = null;
        this.mSwitchs = new ConcurrentHashMap<>();
    }

    public static synchronized SwitchManager getInstance() {
        InterceptResult invokeV;
        SwitchManager switchManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (SwitchManager.class) {
                if (sSwitchManager == null) {
                    sSwitchManager = new SwitchManager();
                }
                switchManager = sSwitchManager;
            }
            return switchManager;
        }
        return (SwitchManager) invokeV.objValue;
    }

    public HashMap<String, Integer> getBaseSwitchs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBaseSwitchs;
        }
        return (HashMap) invokeV.objValue;
    }

    public void addSwitchData(ue ueVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ueVar) != null) || ueVar == null || this.mSwitchs.containsKey(ueVar.e())) {
            return;
        }
        this.mSwitchs.put(ueVar.e(), new ve(ueVar));
    }

    public void crash(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Iterator<ve> it = this.mSwitchs.values().iterator();
            while (it.hasNext() && !it.next().a(str)) {
            }
        }
    }

    public int findType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ve veVar = this.mSwitchs.get(str);
            if (veVar != null) {
                return veVar.getType();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void registerSwitch(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cls) == null) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    public ue removeSwitchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ve remove = this.mSwitchs.remove(str);
            if (remove != null) {
                return remove.b();
            }
            return null;
        }
        return (ue) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.mSwitchs == null) {
            return;
        }
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        for (ve veVar : this.mSwitchs.values()) {
            if (veVar != null) {
                veVar.h(0);
                edit.putInt(veVar.d() + ve.d, 0);
                edit.putInt(veVar.d() + ve.e, veVar.c());
            }
        }
        edit.commit();
    }

    public void refreshSwitchManager(HashMap<String, Integer> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.mBaseSwitchs = hashMap;
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    turn(entry.getKey(), entry.getValue().intValue());
                }
            }
        }
    }

    public boolean turn(String str, int i) {
        InterceptResult invokeLI;
        ve veVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i)) == null) {
            if (i < 0 || (veVar = this.mSwitchs.get(str)) == null) {
                return false;
            }
            return veVar.i(i);
        }
        return invokeLI.booleanValue;
    }
}
