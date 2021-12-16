package com.baidu.ar.lua;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends com.baidu.ar.arplay.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean aJ;

    /* renamed from: if  reason: not valid java name */
    public d f2if;
    public List<WeakReference<c>> sV;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sV = Collections.synchronizedList(new ArrayList());
        this.aJ = false;
        bh();
        d dVar = new d();
        this.f2if = dVar;
        c(dVar);
    }

    private synchronized boolean b(int i2, int i3, HashMap<String, Object> hashMap) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, this, i2, i3, hashMap)) == null) {
            synchronized (this) {
                if (i2 == 1001) {
                    hashMap.put("audio_status", "audio_play");
                    return true;
                } else if (i2 == 1003) {
                    hashMap.put("audio_status", "audio_pause");
                    return true;
                } else if (i2 == 1005) {
                    hashMap.put("audio_status", "audio_resume");
                    return true;
                } else if (i2 == 1007) {
                    hashMap.put("audio_status", "audio_stop");
                    return true;
                } else if (i2 != 1012) {
                    return false;
                } else {
                    hashMap.put("audio_status", "audio_reset");
                    return true;
                }
            }
        }
        return invokeIIL.booleanValue;
    }

    public void aw(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ARPMessage.getInstance().sendLuaScriptToEngine(str);
        }
    }

    public void b(int i2, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, hashMap) == null) {
            ARPMessage.getInstance().sendMessage(i2, hashMap);
        }
    }

    public synchronized boolean c(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            synchronized (this) {
                if (this.sV == null) {
                    return false;
                }
                for (WeakReference<c> weakReference : this.sV) {
                    if (weakReference.get() != null && weakReference.get().equals(cVar)) {
                        return false;
                    }
                }
                com.baidu.ar.h.b.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + cVar.hashCode());
                return this.sV.add(new WeakReference<>(cVar));
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean d(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            synchronized (this) {
                if (this.sV == null) {
                    return false;
                }
                for (WeakReference<c> weakReference : this.sV) {
                    if (weakReference.get() != null && weakReference.get().equals(cVar)) {
                        com.baidu.ar.h.b.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + cVar.hashCode());
                        boolean remove = this.sV.remove(weakReference);
                        weakReference.clear();
                        return remove;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f2if != null) {
                    this.f2if.destroy();
                    this.f2if = null;
                }
                if (this.sV != null) {
                    for (WeakReference<c> weakReference : this.sV) {
                        weakReference.clear();
                    }
                    this.sV.clear();
                    this.sV = null;
                }
            }
        }
    }

    public d fk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2if : (d) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    @Override // com.baidu.ar.arplay.b.a, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void handleMessage(int i2, int i3, HashMap<String, Object> hashMap) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIIL(1048582, this, i2, i3, hashMap) != null) {
            return;
        }
        synchronized (this) {
            com.baidu.ar.h.b.c("EngineMsgBridge", "handleMessage aMessageType = " + i2 + " && aMessageID = " + i3);
            if (this.aJ && b(i2, i3, hashMap)) {
                i2 = 1901;
                if (this.sV != null) {
                    return;
                }
                for (int i4 = 0; i4 < this.sV.size(); i4++) {
                    WeakReference<c> weakReference = this.sV.get(i4);
                    if (weakReference != null && (cVar = weakReference.get()) != null && cVar.n() != null) {
                        for (Integer num : cVar.n()) {
                            if (i2 == num.intValue()) {
                                cVar.a(i2, i3, hashMap);
                            }
                        }
                    }
                }
                return;
            }
            super.handleMessage(i2, i3, hashMap);
            if (this.sV != null) {
            }
        }
    }

    public void setUserPlayAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.aJ = z;
        }
    }
}
