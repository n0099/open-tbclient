package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
/* loaded from: classes3.dex */
public class CyberCoreLoaderManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CyberCoreLoaderManager f4932a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f4933b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4934c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4935d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4936e;

    /* renamed from: f  reason: collision with root package name */
    public Context f4937f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4938g;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberCoreLoaderManager f4945a;

        /* renamed from: b  reason: collision with root package name */
        public int f4946b;

        /* renamed from: c  reason: collision with root package name */
        public CyberPlayerManager.InstallListener f4947c;

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
            this.f4945a = cyberCoreLoaderManager;
            this.f4946b = i2;
            this.f4947c = installListener;
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
        this.f4934c = new Object();
        this.f4936e = 0;
        this.f4938g = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CyberCoreLoaderManager f4939a;

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
                this.f4939a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    int i5 = 0;
                    if (i4 == 0) {
                        synchronized (this.f4939a.f4934c) {
                            while (i5 < this.f4939a.f4933b.size()) {
                                a aVar = (a) this.f4939a.f4933b.get(i5);
                                if (aVar.f4947c != null && CyberPlayerManager.isCoreLoaded(aVar.f4946b)) {
                                    aVar.f4947c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                                }
                                i5++;
                            }
                            this.f4939a.b(message.arg1);
                        }
                    } else if (i4 == 1) {
                        synchronized (this.f4939a.f4934c) {
                            while (i5 < this.f4939a.f4933b.size()) {
                                a aVar2 = (a) this.f4939a.f4933b.get(i5);
                                if (aVar2.f4947c != null) {
                                    aVar2.f4947c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                                }
                                i5++;
                            }
                            this.f4939a.b(message.arg1);
                        }
                    } else if (i4 == 2) {
                        while (i5 < this.f4939a.f4933b.size()) {
                            a aVar3 = (a) this.f4939a.f4933b.get(i5);
                            if (aVar3.f4947c != null) {
                                aVar3.f4947c.onInstallProgress(message.arg1, message.arg2);
                            }
                            i5++;
                        }
                    } else if (i4 == 3 && (obj = message.obj) != null) {
                        ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                    }
                    super.handleMessage(message);
                }
            }
        };
        this.f4933b = new ArrayList();
        this.f4935d = Executors.newSingleThreadExecutor();
    }

    public static synchronized CyberCoreLoaderManager a() {
        InterceptResult invokeV;
        CyberCoreLoaderManager cyberCoreLoaderManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CyberCoreLoaderManager.class) {
                if (f4932a == null) {
                    f4932a = new CyberCoreLoaderManager();
                }
                cyberCoreLoaderManager = f4932a;
            }
            return cyberCoreLoaderManager;
        }
        return (CyberCoreLoaderManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, map)) == null) {
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
            o.h();
            b.a(this.f4937f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65545, this, str, i2, map) == null) || CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        DpSessionDatasUploader.getInstance().a(this.f4937f);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i2, map, new CyberPlayerManager.InstallListener(this) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CyberCoreLoaderManager f4944a;

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
                this.f4944a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i3, int i4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str2) == null) {
                    this.f4944a.a(i4, str2);
                    Message obtainMessage = this.f4944a.f4938g.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.arg1 = i3;
                    obtainMessage.arg2 = i4;
                    obtainMessage.obj = str2;
                    this.f4944a.f4938g.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    Message obtainMessage = this.f4944a.f4938g.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = i3;
                    obtainMessage.arg2 = i4;
                    this.f4944a.f4938g.sendMessage(obtainMessage);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i3, str2) == null) {
                    this.f4944a.a(0, "");
                    if (o.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                        g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), this.f4944a.a(CyberPlayerManager.getInstallOpts()));
                    }
                    this.f4944a.c();
                    Message obtainMessage = this.f4944a.f4938g.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.arg1 = i3;
                    this.f4944a.f4938g.sendMessage(obtainMessage);
                }
            }
        });
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i2)) == null) {
            synchronized (this.f4934c) {
                if (i2 != (this.f4936e & i2)) {
                    this.f4936e = i2 | this.f4936e;
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
            Iterator<a> it = this.f4933b.iterator();
            while (it.hasNext()) {
                if (it.next().f4946b == i2) {
                    it.remove();
                }
            }
            this.f4936e = (i2 ^ Integer.MAX_VALUE) & this.f4936e;
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
            this.f4937f = CyberPlayerManager.getApplicationContext();
            synchronized (this.f4934c) {
                if (CyberPlayerManager.isCoreLoaded(i2)) {
                    if (installListener != null) {
                        Message obtainMessage = this.f4938g.obtainMessage();
                        obtainMessage.what = 3;
                        obtainMessage.arg1 = i2;
                        obtainMessage.obj = installListener;
                        this.f4938g.sendMessage(obtainMessage);
                    }
                    return;
                }
                if (installListener != null) {
                    this.f4933b.add(new a(this, i2, installListener));
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
                        this.f4935d.submit(new Runnable(this, str, i2, map) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f4940a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f4941b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ Map f4942c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ CyberCoreLoaderManager f4943d;

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
                                this.f4943d = this;
                                this.f4940a = str;
                                this.f4941b = i2;
                                this.f4942c = map;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f4943d.a(this.f4940a, this.f4941b, this.f4942c);
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
