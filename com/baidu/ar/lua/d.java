package com.baidu.ar.lua;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
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
/* loaded from: classes5.dex */
public class d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<LuaMsgListener> sW;

    public d() {
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
        this.sW = Collections.synchronizedList(new ArrayList());
    }

    @Override // com.baidu.ar.lua.c
    public synchronized void a(int i2, int i3, HashMap<String, Object> hashMap) {
        List<String> msgKeyListened;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, hashMap) == null) {
            synchronized (this) {
                if (this.sW != null && hashMap != null) {
                    for (int i4 = 0; i4 < this.sW.size(); i4++) {
                        LuaMsgListener luaMsgListener = this.sW.get(i4);
                        if (luaMsgListener != null && (msgKeyListened = luaMsgListener.getMsgKeyListened()) != null) {
                            for (int i5 = 0; i5 < msgKeyListened.size(); i5++) {
                                String str = msgKeyListened.get(i5);
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
    public List<Integer> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.asList(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE)) : (List) invokeV.objValue;
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
