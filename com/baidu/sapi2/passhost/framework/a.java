package com.baidu.sapi2.passhost.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.appsearchlib.Info;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.EncodeUtils;
import com.baidu.sapi2.base.utils.FileUtil;
import com.baidu.sapi2.base.utils.TextUtil;
import com.baidu.sapi2.passhost.framework.b;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.AbsPassPi;
import com.baidu.sapi2.passhost.pluginsdk.AbsPassPiSafe;
import com.baidu.sapi2.passhost.pluginsdk.CommonConst;
import com.baidu.sapi2.passhost.pluginsdk.IPassPi;
import com.baidu.sapi2.passhost.pluginsdk.PassPiInfo;
import com.baidu.sapi2.passhost.pluginsdk.PluginContext;
import com.baidu.sapi2.passhost.pluginsdk.service.MultiHashMap;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    protected static String a = "PassPiManager";
    static ArrayList<PassPiInfo> b = new ArrayList<>();
    private static final boolean j = false;
    protected Context c = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
    protected ClassLoader d;
    protected Map<Integer, PassPiInfo> e;
    protected Map<Integer, PluginContext> f;
    protected String g;
    protected String h;
    protected String i;
    private volatile int k;
    private volatile int l;

    static /* synthetic */ int a(a aVar) {
        int i = aVar.k + 1;
        aVar.k = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sapi2.passhost.framework.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054a {
        public static a a = new a();

        private C0054a() {
        }
    }

    public static a a() {
        return C0054a.a;
    }

    a() {
        if (this.c == null) {
            Log.e(a, "PassPiManager() mHostContext is null");
        }
        this.d = IPassPi.class.getClassLoader();
        this.e = new HashMap();
        this.f = new HashMap();
        String str = this.c.getDir("files", 0).getAbsolutePath() + File.separator + ".tmp" + File.separator + "temp.db" + File.separator;
        this.g = str + ".p00";
        this.h = str + ".p11";
        this.i = str + ".p22";
        new File(this.g).mkdirs();
        new File(this.h).mkdirs();
        new File(this.i).mkdirs();
        f();
    }

    private void f() {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.passhost.framework.a.1
            @Override // java.lang.Runnable
            public void run() {
                String absolutePath = a.this.c.getDir("pass_p_pi", 0).getAbsolutePath();
                String absolutePath2 = a.this.c.getDir("pass_p_lib", 0).getAbsolutePath();
                String absolutePath3 = a.this.c.getDir("pass_p_dex", 0).getAbsolutePath();
                FileUtil.deleteDir(new File(absolutePath));
                FileUtil.deleteDir(new File(absolutePath2));
                FileUtil.deleteDir(new File(absolutePath3));
            }
        }));
    }

    public boolean b() {
        return this.c != null;
    }

    public void a(Context context) {
        this.c = context;
        com.baidu.sapi2.passhost.framework.a.b.a().a(context);
    }

    public void c() {
        Log.d(a, "startPassPi()");
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (SapiUtils.hasActiveNetwork(confignation.context)) {
            a(confignation);
        }
    }

    private void a(SapiConfiguration sapiConfiguration) {
        String str;
        RequestParams requestParams = new RequestParams();
        requestParams.put("tpl", sapiConfiguration.tpl);
        requestParams.put("pack_name", this.c.getPackageName());
        requestParams.put("host_ver", "1.0.3");
        String a2 = a(sapiConfiguration.context, this.c.getPackageName());
        if (TextUtils.isEmpty(a2)) {
            str = i() + "host-1.0.3.txt";
        } else {
            str = i() + "host-1.0.3" + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sapiConfiguration.tpl + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a2 + ".txt";
        }
        Log.d(a, "getTplPkgname()", "configUrl", str);
        new AsyncHttpClient().get(sapiConfiguration.context, str, requestParams, new JsonHttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.passhost.framework.a.2
            @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
            protected void onSuccess(final JSONObject jSONObject) {
                ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.passhost.framework.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(jSONObject);
                    }
                }));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                Log.w(a.a, "getTplPkgname()", "error", th.toString());
            }
        });
    }

    private String a(Context context, String str) {
        Map<String, String> pluginsSuffix = SapiContext.getInstance(context).getPluginsSuffix();
        for (String str2 : pluginsSuffix.keySet()) {
            if (str.matches(str2)) {
                return pluginsSuffix.get(str2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        if (jSONObject != null) {
            try {
                ArrayList<PassPiInfo> arrayList = new ArrayList<>();
                ArrayList<PassPiInfo> arrayList2 = new ArrayList<>();
                b a2 = b.a(jSONObject);
                a(a2);
                Log.i(a, "startPassPi()", "Options Global", Boolean.valueOf(a2.a()));
                if (a2.a()) {
                    String versionName = ServiceManager.getInstance().getIsAccountManager().getVersionName();
                    if (a2.b() != null) {
                        for (String str : a2.b()) {
                            if (a(versionName, str) == 0) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    Log.i(a, "startPassPi()", "toOffline", Boolean.valueOf(z));
                    if (!z) {
                        List<b.c> c = a2.c();
                        for (int i = 0; i < c.size(); i++) {
                            b.c cVar = c.get(i);
                            if (!cVar.b) {
                                Log.i(a, "startPassPi()", Info.kBaiduPIDKey, cVar.a, "piglobal", Boolean.valueOf(cVar.b));
                                arrayList2.add(cVar.f.get(cVar.e.get(cVar.e.size() - 1)));
                            } else {
                                if (cVar.d != null) {
                                    for (String str2 : cVar.d) {
                                        if (a(versionName, str2) == 0) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                    Log.i(a, "startPassPi()", Info.kBaiduPIDKey, cVar.a, "piOfflie", Boolean.valueOf(z2));
                                } else if (!a(cVar)) {
                                    Log.i(a, "startPassPi()", Info.kBaiduPIDKey, cVar.a, "meetGrayDemand", false);
                                } else {
                                    PassPiInfo passPiInfo = cVar.f.get(cVar.e.get(cVar.e.size() - 1));
                                    passPiInfo.filePath = this.g + File.separator + b(passPiInfo.url);
                                    arrayList.add(passPiInfo);
                                }
                            }
                        }
                        a(arrayList);
                        b(arrayList2);
                    }
                }
            } catch (Throwable th) {
                Log.e(a, "startPassPi()", Info.kBaiduTimeKey, th.toString());
            }
        }
    }

    private void b(ArrayList<PassPiInfo> arrayList) {
        File[] listFiles;
        ArrayList arrayList2;
        String str;
        if (arrayList.size() != 0) {
            MultiHashMap multiHashMap = new MultiHashMap();
            File file = new File(this.g);
            if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    multiHashMap.put(name.substring(0, name.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)), file2.getAbsolutePath());
                }
                if (!multiHashMap.isEmpty()) {
                    Iterator<PassPiInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = it.next().url;
                        String substring = str2.substring(str2.lastIndexOf("/") + 1, str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                        if (multiHashMap.containsKey(substring) && ((arrayList2 = multiHashMap.get(substring)) != null || arrayList2.size() != 0)) {
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                FileUtil.deleteFile((String) it2.next());
                                FileUtil.deleteFile(this.i + str.substring(str.lastIndexOf("/"), str.lastIndexOf(".")) + ".dex");
                            }
                        }
                    }
                }
            }
        }
    }

    public static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        int i2 = 0;
        while (i2 < min) {
            i = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
            if (i != 0) {
                break;
            }
            i2++;
        }
        if (i == 0) {
            for (int i3 = i2; i3 < split.length; i3++) {
                if (Integer.parseInt(split[i3]) > 0) {
                    return 1;
                }
            }
            while (i2 < split2.length) {
                if (Integer.parseInt(split2[i2]) > 0) {
                    return -1;
                }
                i2++;
            }
            return 0;
        }
        return i > 0 ? 1 : -1;
    }

    protected void a(ArrayList<PassPiInfo> arrayList) {
        Log.d(a, "installPassPis()");
        if (arrayList != null && arrayList.size() > 0) {
            this.l = 0;
            this.k = 0;
            Iterator<PassPiInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                final PassPiInfo next = it.next();
                try {
                    if (TextUtil.isNullOrEmptyWithoutTrim(next.hostVersion)) {
                        Log.e(a, "installPassPis()", "pi hostVersion empty");
                    } else {
                        int a2 = a("1.0.3", next.hostVersion);
                        Log.i(a, "installPassPis()", "url", next.url, "filePath", next.filePath, "cpver", Integer.valueOf(a2));
                        if (a2 < 0) {
                            Log.e(a, "installPassPis()", "hv", "1.0.3", "phv", next.hostVersion);
                        } else {
                            boolean a3 = a(next, a(next.url));
                            Log.i(a, "installPassPis()", "url", next.url, "filePath", next.filePath, "needUpdate", Boolean.valueOf(a3));
                            next.firstInstall = a3;
                            if (a3) {
                                this.l++;
                                if (next != null) {
                                    new AsyncHttpClient().get(this.c, next.url, new BinaryHttpResponseHandler(Looper.getMainLooper(), new String[]{"application/octet-stream", "*/*", "application/apk", "image/png", "application/vnd.android.package-archive"}) { // from class: com.baidu.sapi2.passhost.framework.a.3
                                        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
                                        protected void onSuccess(int i, byte[] bArr) {
                                            a.this.a(next, bArr);
                                        }

                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
                                        public void onFailure(Throwable th, byte[] bArr) {
                                            Log.d(a.a, "installPassPis() onFailure", next.url, "error", th.toString());
                                            super.onFailure(th, bArr);
                                            if (a.a(a.this) == a.this.l) {
                                                com.baidu.sapi2.passhost.hostsdk.service.a.a().a(0);
                                            }
                                        }
                                    });
                                }
                            } else {
                                next.installState = 1;
                                if (1 == next.installState) {
                                    a(next, true);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.e(a, "loadPassPis()", th.toString());
                }
            }
            if (this.l == 0) {
                com.baidu.sapi2.passhost.hostsdk.service.a.a().a(0);
            }
            a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PassPiInfo passPiInfo, final byte[] bArr) {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.passhost.framework.a.4
            @Override // java.lang.Runnable
            public void run() {
                Log.i(a.a, "installPassPis() onSuccess", passPiInfo.url);
                if (bArr != null) {
                    FileUtil.deleteFile(passPiInfo.filePath);
                    File file = new File(passPiInfo.filePath);
                    try {
                        FileUtil.checkAndCreadFile(file);
                        FileUtil.write(file, bArr);
                        passPiInfo.installState = 1;
                        if (1 == passPiInfo.installState) {
                            a.this.a(passPiInfo, true);
                        }
                    } catch (IOException e) {
                        Log.e(e);
                    }
                    if (a.a(a.this) == a.this.l) {
                        com.baidu.sapi2.passhost.hostsdk.service.a.a().a(0);
                    }
                }
            }
        }));
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            Log.d(a, "copyFileFromAssetsO()", str, str2);
            InputStream open = context.getAssets().open(str);
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(a, "copyFileFromAssetsO() e", e.toString());
            return false;
        }
    }

    protected PluginContext a(PassPiInfo passPiInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (passPiInfo.filePath == null || TextUtil.isNullOrEmptyWithoutTrim(passPiInfo.filePath)) {
            Log.e(a, "loadPassPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "pi file path is null");
            return null;
        }
        Log.i(a, "loadPassPi()", "filePath", passPiInfo.filePath);
        if (!FileUtil.isFileExist(passPiInfo.filePath)) {
            Log.e(a, "loadPassPi()", "file is not exist");
            return null;
        }
        String sha1 = EncodeUtils.getSHA1(new File(passPiInfo.filePath));
        if (sha1 == null || TextUtil.isNullOrEmptyWithoutTrim(sha1)) {
            Log.e(a, "loadPassPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "sha1OfFile is empty");
            return null;
        }
        Log.i(a, "loadPassPi()", "sha1OfFile", sha1, "sha1OfPiInfo", passPiInfo.sha1);
        if (!sha1.equalsIgnoreCase(passPiInfo.sha1)) {
            Log.e(a, "loadPassPi()", "sha1不匹配", "sha1OfFile", sha1, "sha1OfPi", passPiInfo.sha1);
            return null;
        }
        if (!passPiInfo.filePath.endsWith("apk")) {
            String replace = passPiInfo.filePath.replace(".png", ".apk");
            try {
                new AES().decryptFile(passPiInfo.filePath, replace, a(passPiInfo));
                passPiInfo.filePath = replace;
            } catch (Exception e) {
                Log.e(a, "decrypt file  e", e.toString());
            }
        }
        PluginContext a2 = a(passPiInfo, this.c, new DexClassLoader(passPiInfo.filePath, this.i, this.h, this.d), this.d);
        if (a2 == null) {
            Log.e(a, "loadPassPi()", "name", passPiInfo.name, Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "ver", passPiInfo.version, "piContext == null");
            return null;
        }
        a(passPiInfo.filePath, "armeabi", this.h);
        a(passPiInfo.filePath, h(), this.h);
        a(a2);
        if (z) {
            a(passPiInfo, a2);
        }
        Log.d(a, "loadPassPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "ver", passPiInfo.version, "name", passPiInfo.name, "time used", (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return a2;
    }

    private synchronized void a(PluginContext pluginContext) {
        if (pluginContext != null) {
            synchronized (this.f) {
                int i = pluginContext.mPiId;
                if (!this.f.containsKey(Integer.valueOf(i))) {
                    this.f.put(Integer.valueOf(i), pluginContext);
                } else if (!this.f.get(Integer.valueOf(i)).mPiVer.equals(pluginContext.mPiVer)) {
                    this.f.put(Integer.valueOf(i), pluginContext);
                }
                Log.i(a, "addPiEntityToMap()", "size", Integer.valueOf(this.f.size()));
            }
        }
    }

    protected PluginContext a(PassPiInfo passPiInfo, Context context, ClassLoader classLoader, ClassLoader classLoader2) {
        if (passPiInfo == null || context == null || classLoader == null || classLoader2 == null) {
            String str = a;
            Object[] objArr = new Object[8];
            objArr[0] = "parserImplictPlugin()";
            objArr[1] = passPiInfo != null ? Integer.valueOf(passPiInfo.pid) : "null";
            objArr[2] = "classloader";
            objArr[3] = classLoader != null ? classLoader.toString() : "null";
            objArr[4] = "context";
            objArr[5] = context != null ? context.toString() : "null";
            objArr[6] = "parentloader";
            objArr[7] = classLoader2 != null ? classLoader2.toString() : "null";
            Log.e(str, objArr);
            return null;
        }
        String str2 = passPiInfo.filePath;
        if (!new File(str2).exists()) {
            return null;
        }
        try {
            String str3 = passPiInfo.entryClass;
            if (str3 == null) {
                Log.e(a, "parserImplictPlugin()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "classname is null");
                return null;
            }
            PluginContext pluginContext = new PluginContext(str2, context, classLoader);
            pluginContext.setIServiceCenter(com.baidu.sapi2.passhost.framework.a.b.a());
            IPassPi iPassPi = (IPassPi) classLoader.loadClass(str3).newInstance();
            pluginContext.mPiId = passPiInfo.pid;
            pluginContext.mPiVer = passPiInfo.version;
            pluginContext.setPiInstance((AbsPassPi) iPassPi);
            iPassPi.setProperty(CommonConst.PLUGIN_ID, Integer.valueOf(passPiInfo.pid));
            long currentTimeMillis = System.currentTimeMillis();
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str2, 0);
            pluginContext.mPackageName = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
            String str4 = a;
            Object[] objArr2 = new Object[4];
            objArr2[0] = "parserImplictPlugin()";
            objArr2[1] = pluginContext.mPackageName != null ? pluginContext.mPackageName : "NULL";
            objArr2[2] = "used";
            objArr2[3] = (System.currentTimeMillis() - currentTimeMillis) + " ms";
            Log.i(str4, objArr2);
            return pluginContext;
        } catch (Throwable th) {
            Log.e(a, "parserImplictPlugin()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), th.getMessage(), th.toString());
            return null;
        }
    }

    protected void a(PassPiInfo passPiInfo, PluginContext pluginContext) {
        AbsPassPi piInstance = pluginContext.getPiInstance();
        if (piInstance != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (passPiInfo.firstRun) {
                    Log.i(a, "initPi()", "pkg", piInstance.getClass().getName());
                    piInstance.onInstall(pluginContext, passPiInfo.firstInstall);
                    Log.d(a, "initPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "firstInstall", Boolean.valueOf(passPiInfo.firstInstall), "time used", (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    passPiInfo.firstRun = false;
                    passPiInfo.firstInstall = false;
                    passPiInfo.installState = 2;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                piInstance.onCreate(pluginContext);
                Log.d(a, "initPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "time used", (System.currentTimeMillis() - currentTimeMillis2) + "ms");
            } catch (Throwable th) {
                Log.e(a, "initPi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), NotificationCompat.CATEGORY_ERROR, th.getMessage(), th);
            }
        }
    }

    public AbsPassPiSafe d() {
        AbsPassPiSafe absPassPiSafe;
        Log.d(a, "findAbsPassPiSafe()");
        if (this.f == null) {
            return null;
        }
        synchronized (this.f) {
            Log.d(a, "findAbsPassPiSafe() in");
            Iterator<PluginContext> it = this.f.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    absPassPiSafe = null;
                    break;
                }
                PluginContext next = it.next();
                if (next.getPiInstance() instanceof AbsPassPiSafe) {
                    Log.d(a, "findAbsPassPiSafe() got");
                    absPassPiSafe = (AbsPassPiSafe) next.getPiInstance();
                    Log.d(a, "findAbsPassPiSafe() got", absPassPiSafe.getClass());
                    break;
                }
            }
        }
        return absPassPiSafe;
    }

    public Pair<ArrayList<String>, ArrayList<String>> e() {
        Pair<ArrayList<String>, ArrayList<String>> cookies;
        Log.d(a, "combinePisCookies()");
        if (this.f == null) {
            return null;
        }
        synchronized (this.f) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (PluginContext pluginContext : this.f.values()) {
                AbsPassPi piInstance = pluginContext.getPiInstance();
                Log.d(a, "combinePisCookies()", piInstance, Integer.valueOf(piInstance.mPiId));
                if (piInstance != null && (cookies = piInstance.getCookies()) != null && cookies.first != null && cookies.second != null && ((ArrayList) cookies.first).size() > 0 && ((ArrayList) cookies.second).size() > 0 && ((ArrayList) cookies.first).size() == ((ArrayList) cookies.second).size()) {
                    arrayList.addAll((Collection) cookies.first);
                    arrayList2.addAll((Collection) cookies.second);
                    Log.i("testcookis", cookies.first, cookies.second);
                }
            }
            if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                return null;
            }
            return new Pair<>(arrayList, arrayList2);
        }
    }

    private void g() {
        if (a(this.c, "libMyFirstJNI_1-2-3.so", new File(this.h + File.separator + "libMyFirstJNI_1-2-3.so").getAbsolutePath())) {
            try {
                Log.i(a, "testSo() load done");
            } catch (Throwable th) {
                Log.e(a, "testSo()", th.toString());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [990=5, 991=4] */
    private void a(String str, String str2, String str3) {
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        byte[] bArr;
        String name;
        Log.d(a, "unZipApkSoToLibDir", str, str2, str3);
        String str4 = PluginInstallerService.APK_LIB_DIR_PREFIX + str2 + "/";
        ZipInputStream zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                BufferedOutputStream bufferedOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        try {
                            Log.d(a, "unZipApkSoToLibDir()", "entry", nextEntry);
                            bArr = new byte[4096];
                            name = nextEntry.getName();
                        } catch (Exception e2) {
                            bufferedOutputStream = bufferedOutputStream2;
                            e = e2;
                        } catch (Throwable th) {
                            th = th;
                        }
                        if (name.contains(str4)) {
                            String substring = name.substring(name.lastIndexOf("/") + 1);
                            Log.d(a, "unZipApkSoToLibDir()", "soName", substring);
                            File file = new File(str3 + File.separator + substring);
                            if (file.exists()) {
                                file.delete();
                            }
                            File file2 = new File(file.getParent());
                            Log.d(a, "unZipApkSoToLibDir()", "entryFile", file.toString(), "entryDir", file2.toString());
                            if (!file2.exists()) {
                                Log.d(a, "unZipApkSoToLibDir() not exists");
                                file2.mkdirs();
                            }
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                            while (true) {
                                try {
                                    try {
                                        int read = zipInputStream2.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    }
                                } catch (Throwable th2) {
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    th = th2;
                                    if (bufferedOutputStream2 != null) {
                                        bufferedOutputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream.flush();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            bufferedOutputStream2 = bufferedOutputStream;
                        } else {
                            Log.d(a, "unZipApkSoToLibDir()", "not want");
                            if (bufferedOutputStream2 != null) {
                                bufferedOutputStream2.close();
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                                return;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (zipInputStream2 != null) {
                    try {
                        zipInputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0129 A[Catch: IOException -> 0x012d, TRY_LEAVE, TryCatch #6 {IOException -> 0x012d, blocks: (B:42:0x0124, B:44:0x0129), top: B:82:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String h() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str;
        String str2;
        String[] split;
        FileReader fileReader2 = null;
        String[] strArr = {"", ""};
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        String[] split2 = readLine.split("\\s+");
                        Log.d(a, "getCpuType()", "str2", readLine);
                        for (int i = 2; i < split2.length; i++) {
                            strArr[0] = strArr[0] + split2[i] + " ";
                        }
                        String readLine2 = bufferedReader.readLine();
                        Log.d(a, "getCpuType()", "str2", readLine2);
                        if (readLine2.split("\\s+").length >= 3) {
                            strArr[1] = strArr[1] + split[2];
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileReader2 = fileReader;
                    try {
                        Log.e(e);
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        str = Build.CPU_ABI;
                        if (Build.VERSION.SDK_INT >= 8) {
                        }
                        str2 = "none";
                        Log.i(a, "getCpuType()", strArr[0], strArr[1], str, str2);
                        if (!str.equals("armeabi")) {
                        }
                        return "armeabi";
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("cpuAbi2").get(null);
            } catch (Exception e7) {
                Log.w(a, "getCpuType() abi2", e7.toString());
            }
            Log.i(a, "getCpuType()", strArr[0], strArr[1], str, str2);
            if (!str.equals("armeabi") || str2.equals("armeabi")) {
                return "armeabi";
            }
            if (str.equals("armeabi-v7a") || str2.equals("armeabi-v7a") || strArr[0].toLowerCase().contains("armv7")) {
                return "armeabi-v7a";
            }
            if (strArr[0].toLowerCase().contains("arm")) {
                return "armeabi";
            }
            if (strArr[0].toLowerCase().contains("mips")) {
                return "mips";
            }
            return "x86";
        }
        str2 = "none";
        Log.i(a, "getCpuType()", strArr[0], strArr[1], str, str2);
        if (!str.equals("armeabi")) {
        }
        return "armeabi";
    }

    private String a(PassPiInfo passPiInfo) {
        return EncodeUtils.toMd5((passPiInfo.hostVersion + "passSdk" + passPiInfo.entryClass.substring(3, passPiInfo.entryClass.length()) + "25dc51fccc54ad442ad264b6d2801d08" + passPiInfo.name + passPiInfo.pid + "67577b0541256ea89d15e0edb6d2a7b8").getBytes()).substring(0, 16);
    }

    private String a(String str) {
        String b2 = b(str);
        String str2 = this.g + File.separator + b2;
        if (FileUtil.isFileExist(str2) && !TextUtils.isEmpty(b2)) {
            return EncodeUtils.getSHA1(new File(str2));
        }
        return null;
    }

    private String b(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("/")) == null || split.length <= 0) {
            return null;
        }
        return split[split.length - 1];
    }

    private boolean a(PassPiInfo passPiInfo, String str) {
        if (str == null || TextUtil.isNullOrEmptyWithoutTrim(str)) {
            Log.e(a, "needUpdatePi()", Info.kBaiduPIDKey, Integer.valueOf(passPiInfo.pid), "sha1OfFile is empty");
            return true;
        } else if (str.equalsIgnoreCase(passPiInfo.sha1)) {
            return false;
        } else {
            Log.e(a, "needUpdatePi()", "sha1不匹配", "sha1OfFile", str, "sha1OfPi", passPiInfo.sha1);
            return true;
        }
    }

    private void a(b bVar) {
        boolean z;
        List<b.a> grayPlugins = SapiContext.getInstance(this.c).getGrayPlugins();
        for (b.c cVar : bVar.c()) {
            Iterator<b.a> it = grayPlugins.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (cVar.a.equals(it.next().b)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                b.a aVar = new b.a();
                aVar.b = cVar.a;
                aVar.c = random.nextInt(100);
                grayPlugins.add(aVar);
            }
        }
        SapiContext.getInstance(this.c).setGrayPlugin(grayPlugins);
    }

    private boolean a(b.c cVar) {
        List<b.a> grayPlugins = SapiContext.getInstance(this.c).getGrayPlugins();
        if (grayPlugins == null || grayPlugins.size() > 0) {
            for (b.a aVar : grayPlugins) {
                if (100 == cVar.c) {
                    return true;
                }
                if (cVar.a.equals(aVar.b) && aVar.c < cVar.c) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private String i() {
        return ServiceManager.getInstance().getIsAccountManager().getConfignation().environment.getConfigHttpsUrl() + SapiEnv.SAPI_PLUGIN_CONFIG_URI;
    }

    private void a(Map<Integer, PluginContext> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<Integer, PluginContext> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue().mPiVer);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pids", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
        hashMap.put("pi_vers", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList2));
        hashMap.put("package_name", this.c.getPackageName());
        hashMap.put("host_ver", "1.0.3");
        StatService.onEvent("app_pi_info", hashMap);
    }
}
