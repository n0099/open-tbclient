package com.baidu.media.duplayer;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes5.dex */
public class MediaInstanceManagerImpl extends MediaInstanceManagerProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler>> f42609a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f42610b;

    /* renamed from: c  reason: collision with root package name */
    public int f42611c;

    /* renamed from: d  reason: collision with root package name */
    public int f42612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42613e;

    public MediaInstanceManagerImpl() {
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
        this.f42609a = new ConcurrentHashMap();
        this.f42610b = new ArrayList();
        this.f42611c = 0;
        this.f42613e = true;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_MEDIA_INSTANCE_CAP, 4);
        this.f42612d = cfgIntValue;
        if (cfgIntValue <= 0) {
            this.f42613e = false;
        }
    }

    private native int activePlayer(int i2);

    private native String getInstanceOption(int i2, String str);

    private native Bundle getInstanceStatus(int i2, int i3);

    private native int registerPlayer();

    private native void setInstanceCapacity(int i2);

    private native void unRegisterPlayer(int i2);

    private native void updateInstanceOptions(int i2, String str, String str2);

    private native void updateTimestamp(int i2, long j2);

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void activeInstance(int i2) {
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler;
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                if (this.f42613e) {
                    int activePlayer = activePlayer(i2);
                    if (activePlayer > 0) {
                        if (this.f42610b.contains(Integer.valueOf(i2))) {
                            WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference = this.f42609a.get(String.valueOf(i2));
                            if (weakReference == null || (onClientInstanceHandler2 = weakReference.get()) == null) {
                                unRegisterPlayer(i2);
                                this.f42609a.remove(String.valueOf(i2));
                            } else {
                                onClientInstanceHandler2.onResumeInstance();
                            }
                            this.f42610b.remove(Integer.valueOf(i2));
                        }
                        WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference2 = this.f42609a.get(String.valueOf(activePlayer));
                        if (weakReference2 == null || (onClientInstanceHandler = weakReference2.get()) == null) {
                            unRegisterPlayer(activePlayer);
                            this.f42609a.remove(String.valueOf(activePlayer));
                        } else {
                            onClientInstanceHandler.onDestroyInstance();
                            this.f42610b.add(Integer.valueOf(activePlayer));
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public String getInstanceOptionByKey(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (this.f42613e) {
                return getInstanceOption(i2, str);
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public Bundle getInstanceStatusByType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (this.f42613e) {
                return getInstanceStatus(i2, i3);
            }
            return null;
        }
        return (Bundle) invokeII.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized int registerInstance(MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClientInstanceHandler)) == null) {
            synchronized (this) {
                if (this.f42613e) {
                    int registerPlayer = registerPlayer();
                    if (registerPlayer > 0 && onClientInstanceHandler != null) {
                        this.f42609a.put(String.valueOf(registerPlayer), new WeakReference<>(onClientInstanceHandler));
                        if (this.f42611c != this.f42612d) {
                            setInstanceCapacity(this.f42612d);
                            this.f42611c = this.f42612d;
                        }
                        updateTimestamp(registerPlayer, System.currentTimeMillis());
                    }
                    return registerPlayer;
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void unRegisterInstance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this) {
                if (this.f42613e) {
                    if (this.f42610b.contains(Integer.valueOf(i2))) {
                        this.f42610b.remove(Integer.valueOf(i2));
                    }
                    unRegisterPlayer(i2);
                    this.f42609a.remove(String.valueOf(i2));
                    for (String str : this.f42609a.keySet()) {
                        if (this.f42609a.get(str).get() == null) {
                            unRegisterPlayer(Integer.parseInt(str));
                            this.f42609a.remove(str);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateInstanceTimestamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.f42613e) {
            updateTimestamp(i2, j2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateStringOption(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) && this.f42613e) {
            updateInstanceOptions(i2, str, str2);
        }
    }
}
