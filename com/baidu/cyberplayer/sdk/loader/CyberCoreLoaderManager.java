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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class CyberCoreLoaderManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CyberCoreLoaderManager f37137a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f37138b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f37139c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f37140d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f37141e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37142f;

    /* renamed from: g  reason: collision with root package name */
    public long f37143g;

    /* renamed from: h  reason: collision with root package name */
    public long f37144h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f37145i;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberCoreLoaderManager f37152a;

        /* renamed from: b  reason: collision with root package name */
        public int f37153b;

        /* renamed from: c  reason: collision with root package name */
        public CyberPlayerManager.InstallListener f37154c;

        public a(CyberCoreLoaderManager cyberCoreLoaderManager, int i2, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberCoreLoaderManager, Integer.valueOf(i2), installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37152a = cyberCoreLoaderManager;
            this.f37153b = i2;
            this.f37154c = installListener;
        }
    }

    public CyberCoreLoaderManager() {
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
        this.f37139c = new Object();
        this.f37141e = 0;
        this.f37143g = -1L;
        this.f37144h = -1L;
        this.f37145i = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CyberCoreLoaderManager f37146a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37146a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    int i5 = 0;
                    if (i4 == 0) {
                        synchronized (this.f37146a.f37139c) {
                            while (i5 < this.f37146a.f37138b.size()) {
                                a aVar = (a) this.f37146a.f37138b.get(i5);
                                if (aVar.f37154c != null && CyberPlayerManager.isCoreLoaded(aVar.f37153b)) {
                                    aVar.f37154c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                                }
                                i5++;
                            }
                            this.f37146a.b(message.arg1);
                        }
                    } else if (i4 == 1) {
                        synchronized (this.f37146a.f37139c) {
                            while (i5 < this.f37146a.f37138b.size()) {
                                a aVar2 = (a) this.f37146a.f37138b.get(i5);
                                if (aVar2.f37154c != null) {
                                    aVar2.f37154c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                                }
                                i5++;
                            }
                            this.f37146a.b(message.arg1);
                        }
                    } else if (i4 == 2) {
                        while (i5 < this.f37146a.f37138b.size()) {
                            a aVar3 = (a) this.f37146a.f37138b.get(i5);
                            if (aVar3.f37154c != null) {
                                aVar3.f37154c.onInstallProgress(message.arg1, message.arg2);
                                if (aVar3.f37154c instanceof CyberPlayerManager.InstallListener2) {
                                    ((CyberPlayerManager.InstallListener2) aVar3.f37154c).onInstallInfo(103, message.arg2, null);
                                }
                            }
                            i5++;
                        }
                    } else if (i4 == 3) {
                        Object obj = message.obj;
                        if (obj != null) {
                            ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                    } else if (i4 == 4) {
                        for (int i6 = 0; i6 < this.f37146a.f37138b.size(); i6++) {
                            a aVar4 = (a) this.f37146a.f37138b.get(i6);
                            if (aVar4.f37154c != null && (aVar4.f37154c instanceof CyberPlayerManager.InstallListener2)) {
                                ((CyberPlayerManager.InstallListener2) aVar4.f37154c).onInstallInfo(message.arg1, 0, message.obj);
                            }
                        }
                    }
                    super.handleMessage(message);
                }
            }
        };
        this.f37138b = new ArrayList();
        this.f37140d = Executors.newSingleThreadExecutor();
    }

    public static synchronized CyberCoreLoaderManager a() {
        InterceptResult invokeV;
        CyberCoreLoaderManager cyberCoreLoaderManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CyberCoreLoaderManager.class) {
                if (f37137a == null) {
                    f37137a = new CyberCoreLoaderManager();
                }
                cyberCoreLoaderManager = f37137a;
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
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadcode", String.valueOf(i2));
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
            if (i2 == 0) {
                long a3 = com.baidu.cyberplayer.sdk.loader.a.a().a(0);
                long a4 = com.baidu.cyberplayer.sdk.loader.a.a().a(1);
                long a5 = com.baidu.cyberplayer.sdk.loader.a.a().a(2);
                if (this.f37143g > 0) {
                    hashMap.put("install_t_ms", String.valueOf(System.currentTimeMillis() - this.f37143g));
                }
                long j = this.f37144h;
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
            this.f37143g = -1L;
            o.h();
            b.a(this.f37142f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65545, this, str, i2, map) == null) || CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DpSessionDatasUploader.getInstance().a(this.f37142f);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        this.f37144h = System.currentTimeMillis() - currentTimeMillis;
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i2, map, new CyberPlayerManager.InstallListener2(this) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CyberCoreLoaderManager f37151a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37151a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i3, int i4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str2) == null) {
                    this.f37151a.a(i4, str2);
                    Message obtainMessage = this.f37151a.f37145i.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.arg1 = i3;
                    obtainMessage.arg2 = i4;
                    obtainMessage.obj = str2;
                    this.f37151a.f37145i.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i3, int i4, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4, obj) == null) {
                    Message obtainMessage = this.f37151a.f37145i.obtainMessage();
                    switch (i3) {
                        case 100:
                        case 101:
                        case 102:
                            obtainMessage.what = 4;
                            obtainMessage.arg1 = i3;
                            obtainMessage.arg2 = i4;
                            obtainMessage.obj = obj;
                            this.f37151a.f37145i.sendMessage(obtainMessage);
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i3, i4) == null) {
                    Message obtainMessage = this.f37151a.f37145i.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = i3;
                    obtainMessage.arg2 = i4;
                    this.f37151a.f37145i.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i3, str2) == null) {
                    this.f37151a.a(0, "");
                    if (o.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                        g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), this.f37151a.a(CyberPlayerManager.getInstallOpts()));
                    }
                    this.f37151a.c();
                    Message obtainMessage = this.f37151a.f37145i.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.arg1 = i3;
                    this.f37151a.f37145i.sendMessage(obtainMessage);
                }
            }
        });
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i2)) == null) {
            synchronized (this.f37139c) {
                if (i2 != (this.f37141e & i2)) {
                    this.f37141e = i2 | this.f37141e;
                    return true;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            Iterator<a> it = this.f37138b.iterator();
            while (it.hasNext()) {
                if (it.next().f37153b == i2) {
                    it.remove();
                }
            }
            this.f37141e = (i2 ^ Integer.MAX_VALUE) & this.f37141e;
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

    public void a(String str, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, str, i2, map, installListener) == null) {
            if (this.f37143g == -1) {
                this.f37143g = System.currentTimeMillis();
            }
            this.f37142f = CyberPlayerManager.getApplicationContext();
            synchronized (this.f37139c) {
                if (CyberPlayerManager.isCoreLoaded(i2)) {
                    if (installListener != null) {
                        Message obtainMessage = this.f37145i.obtainMessage();
                        obtainMessage.what = 3;
                        obtainMessage.arg1 = i2;
                        obtainMessage.obj = installListener;
                        this.f37145i.sendMessage(obtainMessage);
                    }
                    return;
                }
                if (installListener != null) {
                    this.f37138b.add(new a(this, i2, installListener));
                }
                if (a(i2)) {
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
                        a(str, i2, map);
                    } else {
                        this.f37140d.submit(new Runnable(this, str, i2, map) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f37147a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f37148b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ Map f37149c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ CyberCoreLoaderManager f37150d;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str, Integer.valueOf(i2), map};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f37150d = this;
                                this.f37147a = str;
                                this.f37148b = i2;
                                this.f37149c = map;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f37150d.a(this.f37147a, this.f37148b, this.f37149c);
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
