package com.baidu.fsg.base.restnet.beans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class BeanManager {
    public static /* synthetic */ Interceptable $ic;
    public static BeanManager mBeanMgr;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ArrayList<ApollonBean>> mContextBeanList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(575483851, "Lcom/baidu/fsg/base/restnet/beans/BeanManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(575483851, "Lcom/baidu/fsg/base/restnet/beans/BeanManager;");
        }
    }

    public BeanManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContextBeanList = new HashMap<>();
    }

    public static synchronized BeanManager getInstance() {
        InterceptResult invokeV;
        BeanManager beanManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (BeanManager.class) {
                if (mBeanMgr == null) {
                    mBeanMgr = new BeanManager();
                }
                beanManager = mBeanMgr;
            }
            return beanManager;
        }
        return (BeanManager) invokeV.objValue;
    }

    public synchronized void addBean(String str, ApollonBean apollonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, apollonBean) == null) {
            synchronized (this) {
                ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.mContextBeanList.put(str, arrayList);
                }
                arrayList.add(apollonBean);
            }
        }
    }

    public synchronized void removeAllBeans(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
                if (arrayList != null) {
                    Iterator<ApollonBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().destroyBean();
                    }
                    this.mContextBeanList.remove(str);
                }
            }
        }
    }

    public synchronized void removeBean(ApollonBean apollonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, apollonBean) == null) {
            synchronized (this) {
                for (String str : this.mContextBeanList.keySet()) {
                    ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
                    Iterator<ApollonBean> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (apollonBean == it.next()) {
                                arrayList.remove(apollonBean);
                                apollonBean.destroyBean();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}
