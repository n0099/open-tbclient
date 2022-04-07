package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ye;
import com.repackage.ze;
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
    public ConcurrentHashMap<String, ze> mSwitchs;

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

    public void addSwitchData(ye yeVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, yeVar) == null) || yeVar == null || this.mSwitchs.containsKey(yeVar.e())) {
            return;
        }
        this.mSwitchs.put(yeVar.e(), new ze(yeVar));
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mSwitchs == null) {
            return;
        }
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        for (ze zeVar : this.mSwitchs.values()) {
            if (zeVar != null) {
                zeVar.h(0);
                edit.putInt(zeVar.d() + ze.d, 0);
                edit.putInt(zeVar.d() + ze.e, zeVar.c());
            }
        }
        edit.commit();
    }

    public void crash(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Iterator<ze> it = this.mSwitchs.values().iterator();
            while (it.hasNext() && !it.next().a(str)) {
            }
        }
    }

    public int findType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ze zeVar = this.mSwitchs.get(str);
            if (zeVar != null) {
                return zeVar.getType();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public HashMap<String, Integer> getBaseSwitchs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBaseSwitchs : (HashMap) invokeV.objValue;
    }

    public void refreshSwitchManager(HashMap<String, Integer> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.mBaseSwitchs = hashMap;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                turn(entry.getKey(), entry.getValue().intValue());
            }
        }
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

    public ye removeSwitchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ze remove = this.mSwitchs.remove(str);
            if (remove != null) {
                return remove.b();
            }
            return null;
        }
        return (ye) invokeL.objValue;
    }

    public boolean turn(String str, int i) {
        InterceptResult invokeLI;
        ze zeVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i)) == null) {
            if (i >= 0 && (zeVar = this.mSwitchs.get(str)) != null) {
                return zeVar.i(i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
