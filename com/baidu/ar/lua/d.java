package com.baidu.ar.lua;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List sW;

    public d() {
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
        this.sW = Collections.synchronizedList(new ArrayList());
    }

    @Override // com.baidu.ar.lua.c
    public synchronized void a(int i, int i2, HashMap hashMap) {
        List msgKeyListened;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, hashMap) == null) {
            synchronized (this) {
                if (this.sW != null && hashMap != null) {
                    for (int i3 = 0; i3 < this.sW.size(); i3++) {
                        LuaMsgListener luaMsgListener = (LuaMsgListener) this.sW.get(i3);
                        if (luaMsgListener != null && (msgKeyListened = luaMsgListener.getMsgKeyListened()) != null) {
                            for (int i4 = 0; i4 < msgKeyListened.size(); i4++) {
                                String str = (String) msgKeyListened.get(i4);
                                if (!TextUtils.isEmpty(str) && hashMap.get(str) != null) {
                                    luaMsgListener.onLuaMessage(hashMap);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, luaMsgListener)) == null) {
            synchronized (this) {
                if (this.sW == null) {
                    return false;
                }
                for (LuaMsgListener luaMsgListener2 : this.sW) {
                    if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                        return false;
                    }
                }
                com.baidu.ar.h.b.c("LuaMsgBridge", "addLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
                return this.sW.add(luaMsgListener);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.sW != null) {
                    this.sW.clear();
                    this.sW = null;
                }
            }
        }
    }

    @Override // com.baidu.ar.lua.c
    public List n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.asList(1901) : (List) invokeV.objValue;
    }

    public synchronized boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, luaMsgListener)) == null) {
            synchronized (this) {
                if (this.sW == null) {
                    return false;
                }
                for (LuaMsgListener luaMsgListener2 : this.sW) {
                    if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                        com.baidu.ar.h.b.c("LuaMsgBridge", "removeLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
                        return this.sW.remove(luaMsgListener2);
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
