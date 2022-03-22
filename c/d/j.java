package c.d;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.d.j0;
import c.d.p;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.http.GetRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f23148b;

    /* renamed from: c  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f23149c;

    /* renamed from: d  reason: collision with root package name */
    public static final Handler f23150d;

    /* renamed from: e  reason: collision with root package name */
    public static final b0 f23151e;

    /* renamed from: f  reason: collision with root package name */
    public static final j0 f23152f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f23153g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f23154h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
                j.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            Response perform;
            Reporter a;
            JSONObject jSONObject;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                int i3 = -1;
                boolean z = false;
                if (i2 != 100) {
                    if (i2 == 101) {
                        i iVar = new i();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            LogPrinter.v("Start load config from assets.", new Object[0]);
                            AssetManager assets = FunAdSdk.getAppContext().getAssets();
                            InputStream open = assets.open(str + ".json");
                            StringWriter stringWriter = new StringWriter();
                            InputStreamReader inputStreamReader = new InputStreamReader(open);
                            char[] cArr = new char[4096];
                            while (true) {
                                int read = inputStreamReader.read(cArr);
                                if (-1 == read) {
                                    break;
                                }
                                stringWriter.write(cArr, 0, read);
                            }
                            String stringWriter2 = stringWriter.toString();
                            LogPrinter.v("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = m.a(stringWriter2, str);
                                LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e2) {
                            LogPrinter.e(e2, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (iVar.b(str2)) {
                            LogPrinter.v("Config from assets parsed over with succeed", new Object[0]);
                        } else {
                            LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                            if (FunAdSdk.isLogEnabled()) {
                                throw new RuntimeException("Config from assets parsed failed");
                            }
                        }
                        j.f23148b.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    HostAppInfo.fillReqParams(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    perform = new GetRequest("https://cd.xdplt.com/v2/z", new RequestParams(hashMap)).perform();
                } catch (IOException e3) {
                    LogPrinter.e(e3);
                }
                if (perform != null && perform.getResponseCode() == 200) {
                    try {
                        jSONObject = new JSONObject(perform.getContent());
                        i = jSONObject.getInt(Constants.KEYS.RET);
                        LogPrinter.d("Download online ad config response ret: " + i, new Object[0]);
                    } catch (JSONException e4) {
                        LogPrinter.e(e4);
                        a = s.a();
                    }
                    if (i == 200) {
                        try {
                        } catch (Exception e5) {
                            LogPrinter.e(e5);
                            a = s.a();
                            i3 = -2;
                        }
                        if (new i().b(m.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                            j.a.clear();
                            z = true;
                        } else {
                            a = s.a();
                            i3 = -3;
                            a.logEvent("k_ppcfg", "st", Integer.valueOf(i3));
                        }
                    }
                    o.f23222b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                    if (z) {
                        j.f23148b.sendEmptyMessage(200);
                    }
                    j.c();
                }
                LogPrinter.e("Pull ad config failed.", new Object[0]);
                o.f23222b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                }
                j.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1611522068, "Lc/d/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1611522068, "Lc/d/j;");
                return;
            }
        }
        a = new HashMap();
        f23148b = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f23150d = new b(handlerThread.getLooper());
        f23151e = new b0();
        f23152f = new j0();
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            p pVar = f23151e.f23127b;
            synchronized (pVar.a) {
                Deque<p.c> deque = pVar.a.get(str);
                i = 0;
                if (deque != null) {
                    Iterator<p.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        p.c next = descendingIterator.next();
                        if (next.a().contains(pid)) {
                            i = next.b();
                            break;
                        }
                    }
                }
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static r b(String str) {
        InterceptResult invokeL;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            b0 b0Var = f23151e;
            synchronized (b0Var) {
                if (b0Var.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    rVar = null;
                } else {
                    rVar = b0Var.f23128c.get(str);
                }
            }
            return rVar;
        }
        return (r) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = o.f23222b;
            long j = 0;
            long j2 = sharedPreferences.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = sharedPreferences.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            LogPrinter.v("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            Handler handler = f23150d;
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100, max);
        }
    }

    public static void d(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var) == null) {
            f23154h = true;
            j0 j0Var = f23152f;
            synchronized (j0Var.f23156b) {
                j0Var.f23159e = o0Var;
                j0Var.f23158d = 1;
                while (!j0Var.f23157c.isEmpty()) {
                    j0.a pollFirst = j0Var.f23157c.pollFirst();
                    if (!j0.f23155f && pollFirst == null) {
                        throw new AssertionError();
                    }
                    j0Var.loadAd(pollFirst.a, pollFirst.f23160b, pollFirst.f23161c);
                }
            }
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f23149c;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            f23149c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0114 A[Catch: all -> 0x0260, TRY_LEAVE, TryCatch #0 {, blocks: (B:41:0x00a7, B:43:0x00ab, B:45:0x00b1, B:46:0x00b9, B:65:0x0114, B:49:0x00ca, B:50:0x00d7, B:52:0x00dd, B:53:0x00e7, B:55:0x00ed, B:57:0x00fd, B:59:0x0107, B:68:0x011e, B:72:0x0126, B:76:0x0137, B:75:0x0135, B:71:0x0124), top: B:118:0x00a7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(boolean z) {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(65541, null, z) != null) {
            return;
        }
        LogPrinter.v("tryInitialize", new Object[0]);
        c();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        Set<l> set = null;
        String string = o.f23222b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                cVar = new c(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                LogPrinter.e(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(cVar == null);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (cVar != null) {
                if (z) {
                    f23150d.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                j0 j0Var = f23152f;
                synchronized (j0Var.f23156b) {
                    j0Var.f23158d = -1;
                    while (!j0Var.f23157c.isEmpty()) {
                        j0.a pollFirst = j0Var.f23157c.pollFirst();
                        if (!j0.f23155f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.f23161c.onError(pollFirst.f23160b.getSid());
                    }
                }
                return;
            }
            b0 b0Var = f23151e;
            synchronized (b0Var) {
                c cVar2 = b0Var.a;
                if (cVar2 != null) {
                    if (cVar2.equals(cVar)) {
                        LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        c cVar3 = b0Var.a;
                        if (cVar3.a.size() == cVar.a.size()) {
                            HashSet hashSet = new HashSet(cVar.a);
                            for (Ssp ssp : cVar3.a) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    Ssp ssp2 = (Ssp) it.next();
                                    if (ssp.type.equals(ssp2.type) && ssp.sspId.equals(ssp2.sspId)) {
                                        it.remove();
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z4) {
                                }
                            }
                            z3 = true;
                            if (!z3) {
                                LogPrinter.d("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                c cVar4 = b0Var.a;
                b0Var.a(cVar4 == null ? null : cVar4.f23129b, cVar.f23129b, new v(b0Var));
                c cVar5 = b0Var.a;
                if (cVar5 != null) {
                    set = cVar5.f23130c;
                }
                b0Var.a(set, cVar.f23130c, new z(b0Var));
                b0Var.a = cVar;
                z2 = true;
            }
            if (!z2) {
                LogPrinter.d("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            HostAppInfo.updateCfgv(o.f23222b.getLong("key_config_v", 0L));
            if (f23153g) {
                return;
            }
            f23153g = true;
            c.d.a aVar = c.d.a.a;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (Ssp ssp3 : cVar.a) {
                if (!TextUtils.isEmpty(ssp3.sspId)) {
                    if (FunAdSdk.PLATFORM_CJ.equals(ssp3.type)) {
                        if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                            LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            LogPrinter.d("sdk for %s init start", ssp3.type);
                            f.c(ssp3.type, "com.fun.ad.sdk.channel.CjModule", funAdConfig, hashMap, ssp3.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                    } else if (!FunAdSdk.PLATFORM_CSJ.equals(ssp3.type)) {
                        arrayList.add(ssp3);
                    } else if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                    } else {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        LogPrinter.d("sdk for %s init start", ssp3.type);
                        f.c(ssp3.type, "com.fun.ad.sdk.channel.CsjModule", funAdConfig, hashMap, ssp3.sspId);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                f.b(currentTimeMillis, aVar, hashMap);
                return;
            } else {
                new Thread(new e(arrayList, funAdConfig, hashMap, currentTimeMillis, aVar)).start();
                return;
            }
        }
        cVar = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(cVar == null);
        objArr2[1] = Boolean.valueOf(z);
        LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (cVar != null) {
        }
    }
}
