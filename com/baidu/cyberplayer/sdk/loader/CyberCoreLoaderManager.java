package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.downloader.SilentDownloaderManager;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.cyberplayer.sdk.remote.g;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.b;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class CyberCoreLoaderManager {
    public static /* synthetic */ Interceptable $ic;
    public static CyberCoreLoaderManager a;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> b;
    public final Object c;
    public ExecutorService d;
    public volatile int e;
    public Context f;
    public long g;
    public long h;
    public Handler i;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberCoreLoaderManager a;
        public int b;
        public CyberPlayerManager.InstallListener c;

        public a(CyberCoreLoaderManager cyberCoreLoaderManager, int i, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberCoreLoaderManager, Integer.valueOf(i), installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cyberCoreLoaderManager;
            this.b = i;
            this.c = installListener;
        }
    }

    public CyberCoreLoaderManager() {
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
        this.c = new Object();
        this.e = 0;
        this.g = -1L;
        this.h = -1L;
        this.i = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CyberCoreLoaderManager a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i3 = message.what;
                    int i4 = 0;
                    if (i3 == 0) {
                        synchronized (this.a.c) {
                            while (i4 < this.a.b.size()) {
                                a aVar = (a) this.a.b.get(i4);
                                if (aVar.c != null && CyberPlayerManager.isCoreLoaded(aVar.b)) {
                                    aVar.c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                                }
                                i4++;
                            }
                            this.a.b(message.arg1);
                        }
                    } else if (i3 == 1) {
                        synchronized (this.a.c) {
                            while (i4 < this.a.b.size()) {
                                a aVar2 = (a) this.a.b.get(i4);
                                if (aVar2.c != null) {
                                    aVar2.c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                                }
                                i4++;
                            }
                            this.a.b(message.arg1);
                        }
                    } else if (i3 == 2) {
                        while (i4 < this.a.b.size()) {
                            a aVar3 = (a) this.a.b.get(i4);
                            if (aVar3.c != null) {
                                aVar3.c.onInstallProgress(message.arg1, message.arg2);
                                if (aVar3.c instanceof CyberPlayerManager.InstallListener2) {
                                    ((CyberPlayerManager.InstallListener2) aVar3.c).onInstallInfo(103, message.arg2, null);
                                }
                            }
                            i4++;
                        }
                    } else if (i3 == 3) {
                        Object obj = message.obj;
                        if (obj != null) {
                            ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                    } else if (i3 == 4) {
                        for (int i5 = 0; i5 < this.a.b.size(); i5++) {
                            a aVar4 = (a) this.a.b.get(i5);
                            if (aVar4.c != null && (aVar4.c instanceof CyberPlayerManager.InstallListener2)) {
                                ((CyberPlayerManager.InstallListener2) aVar4.c).onInstallInfo(message.arg1, 0, message.obj);
                            }
                        }
                    }
                    super.handleMessage(message);
                }
            }
        };
        this.b = new ArrayList();
        this.d = Executors.newSingleThreadExecutor();
    }

    public static synchronized CyberCoreLoaderManager a() {
        InterceptResult invokeV;
        CyberCoreLoaderManager cyberCoreLoaderManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CyberCoreLoaderManager.class) {
                if (a == null) {
                    a = new CyberCoreLoaderManager();
                }
                cyberCoreLoaderManager = a;
            }
            return cyberCoreLoaderManager;
        }
        return (CyberCoreLoaderManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map)) == null) {
            if (o.m() && map != null) {
                map.put("cyber-media-dex", d.a());
                Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
                if (a2 != null) {
                    map.putAll(a2);
                }
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, this, i, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadcode", String.valueOf(i));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("detail", str);
            }
            hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, o.l());
            Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
            if (a2 != null) {
                hashMap.putAll(a2);
            }
            String prefStr = CyberCfgManager.getInstance().getPrefStr("update_type_black", "");
            String prefStr2 = CyberCfgManager.getInstance().getPrefStr("update_version_black", "");
            if (!TextUtils.isEmpty(prefStr) && !TextUtils.isEmpty(prefStr2)) {
                hashMap.put("isallowupdate", "0");
                hashMap.put("updatetype", prefStr);
                hashMap.put("updateversion", prefStr2);
            }
            if (com.baidu.cyberplayer.sdk.loader.a.a().b()) {
                hashMap.put("isdowngradled", com.baidu.cyberplayer.sdk.loader.a.a().b() ? "1" : "0");
            }
            if (i == 0) {
                long a3 = com.baidu.cyberplayer.sdk.loader.a.a().a(0);
                long a4 = com.baidu.cyberplayer.sdk.loader.a.a().a(1);
                long a5 = com.baidu.cyberplayer.sdk.loader.a.a().a(2);
                if (this.g > 0) {
                    hashMap.put("install_t_ms", String.valueOf(System.currentTimeMillis() - this.g));
                }
                long j = this.h;
                if (j >= 0) {
                    hashMap.put("init_dp_t_ms", String.valueOf(j));
                }
                if (a5 >= 0) {
                    hashMap.put("init_cfg_t_ms", String.valueOf(a5));
                }
                if (a3 >= 0) {
                    hashMap.put("loadcore_t_ms", String.valueOf(a3));
                }
                if (a4 >= 0) {
                    hashMap.put("loadlibs_t_ms", String.valueOf(a4));
                }
                hashMap.put("install_type", String.valueOf(CyberPlayerManager.getInstallType()));
            }
            this.g = -1L;
            o.h();
            b.a(this.f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65545, this, str, i, map) == null) || CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DpSessionDatasUploader.getInstance().a(this.f);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        this.h = System.currentTimeMillis() - currentTimeMillis;
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i, map, new CyberPlayerManager.InstallListener2(this) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CyberCoreLoaderManager a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str2) == null) {
                    this.a.a(i3, str2);
                    Message obtainMessage = this.a.i.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.arg1 = i2;
                    obtainMessage.arg2 = i3;
                    obtainMessage.obj = str2;
                    this.a.i.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i2, int i3, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) {
                    Message obtainMessage = this.a.i.obtainMessage();
                    switch (i2) {
                        case 100:
                        case 101:
                        case 102:
                            obtainMessage.what = 4;
                            obtainMessage.arg1 = i2;
                            obtainMessage.arg2 = i3;
                            obtainMessage.obj = obj;
                            this.a.i.sendMessage(obtainMessage);
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                    Message obtainMessage = this.a.i.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = i2;
                    obtainMessage.arg2 = i3;
                    this.a.i.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i2, str2) == null) {
                    this.a.a(0, "");
                    if (o.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                        g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), this.a.a(CyberPlayerManager.getInstallOpts()));
                    }
                    this.a.c();
                    Message obtainMessage = this.a.i.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.arg1 = i2;
                    this.a.i.sendMessage(obtainMessage);
                }
            }
        });
    }

    private boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            synchronized (this.c) {
                if (i != (this.e & i)) {
                    this.e = i | this.e;
                    return true;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next().b == i) {
                    it.remove();
                }
            }
            this.e = (i ^ Integer.MAX_VALUE) & this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && o.m()) {
            CyberCfgManager.getInstance().removePref("latest_success_loaded_cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("latest_success_loaded_cyber-media-dex", d.a());
            Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
            Map<String, String> a3 = d.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (a2 == null || a3 == null) {
                return;
            }
            for (Map.Entry<String, String> entry : a2.entrySet()) {
                CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
                cyberCfgManager.removePref("latest_success_loaded_" + entry.getKey());
                if (!TextUtils.isEmpty(a3.get(entry.getKey()))) {
                    CyberCfgManager cyberCfgManager2 = CyberCfgManager.getInstance();
                    cyberCfgManager2.setPrefStr("latest_success_loaded_" + entry.getKey(), a3.get(entry.getKey()));
                }
            }
        }
    }

    @Keep
    public static String getLatestLoadedVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
            return cyberCfgManager.getPrefStr("latest_success_loaded_" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, str, i, map, installListener) == null) {
            if (this.g == -1) {
                this.g = System.currentTimeMillis();
            }
            this.f = CyberPlayerManager.getApplicationContext();
            synchronized (this.c) {
                if (CyberPlayerManager.isCoreLoaded(i)) {
                    if (installListener != null) {
                        Message obtainMessage = this.i.obtainMessage();
                        obtainMessage.what = 3;
                        obtainMessage.arg1 = i;
                        obtainMessage.obj = installListener;
                        this.i.sendMessage(obtainMessage);
                    }
                    return;
                }
                if (installListener != null) {
                    this.b.add(new a(this, i, installListener));
                }
                if (a(i)) {
                    boolean z = false;
                    if (map != null) {
                        String str2 = map.get("enable_sync_install");
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                if (Integer.parseInt(str2) == 1) {
                                    z = true;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (z) {
                        a(str, i, map);
                    } else {
                        this.d.submit(new Runnable(this, str, i, map) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ String a;
                            public final /* synthetic */ int b;
                            public final /* synthetic */ Map c;
                            public final /* synthetic */ CyberCoreLoaderManager d;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str, Integer.valueOf(i), map};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.d = this;
                                this.a = str;
                                this.b = i;
                                this.c = map;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.d.a(this.a, this.b, this.c);
                                    SilentDownloaderManager.getInstance().a();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
            String str = SDKVersion.VERSION;
            String cfgValue = cyberCfgManager.getCfgValue("update_core_ver", SDKVersion.VERSION);
            if (SilentDownloaderManager.getInstance().a(cfgValue)) {
                String latestLoadedVersion = getLatestLoadedVersion("cyber-media-dex");
                if (CyberCfgManager.compareVersion(latestLoadedVersion, SDKVersion.VERSION) == 1) {
                    str = latestLoadedVersion;
                }
                CyberLog.i("CyberCoreLoaderManager", "need silent download, last success loaded:" + latestLoadedVersion + " loadableVersion:" + str);
                cfgValue = str;
            }
            String cfgValue2 = CyberCfgManager.getInstance().getCfgValue("core_external_path", "");
            if (TextUtils.isEmpty(cfgValue2) || !new File(cfgValue2).exists()) {
                return cfgValue;
            }
            String a2 = com.baidu.cyberplayer.sdk.downloader.a.a(cfgValue2, o.b());
            return !TextUtils.isEmpty(a2) ? a2 : cfgValue;
        }
        return (String) invokeV.objValue;
    }
}
