package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.down.request.task.ProgressInfo;
import d.a.c.h.j.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PluginPackageManager {
    public static int u = 43;
    public static int v = 2;
    public static volatile PluginPackageManager w;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, k> f2223b;

    /* renamed from: f  reason: collision with root package name */
    public String f2227f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2228g;
    public d.a.c.h.j.d l;
    public boolean m;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2224c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2225d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2226e = false;

    /* renamed from: h  reason: collision with root package name */
    public long f2229h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2230i = false;
    public boolean j = false;
    public int k = 0;
    public BroadcastReceiver n = new b();
    public BroadcastReceiver o = new c();
    public a.c p = new d();
    public d.a.c.h.g.a q = new f();
    public d.a.c.h.j.f.a r = new i();
    public d.a.c.h.j.e.a s = new j();
    public CustomMessageListener t = new a(2000994);

    /* renamed from: a  reason: collision with root package name */
    public Context f2222a = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR
    }

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public long f2231a;

        /* renamed from: b  reason: collision with root package name */
        public int f2232b;

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PluginPackageManager.this.f2230i && d.a.c.e.p.j.z()) {
                if (this.f2232b < 3) {
                    PluginPackageManager pluginPackageManager = PluginPackageManager.this;
                    pluginPackageManager.y0(pluginPackageManager.m);
                    this.f2232b++;
                    this.f2231a = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.f2231a > 60000) {
                    PluginPackageManager pluginPackageManager2 = PluginPackageManager.this;
                    pluginPackageManager2.y0(pluginPackageManager2.m);
                    this.f2232b = 0;
                    this.f2231a = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public Map<String, Integer> installFailRetryMap = new HashMap();

        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            String str;
            PluginSetting pluginSetting;
            String str2;
            String str3;
            String str4;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.plugin.installed".equals(action)) {
                String stringExtra = intent.getStringExtra("package_name");
                String stringExtra2 = intent.getStringExtra("install_dest_file");
                String stringExtra3 = intent.getStringExtra("version_name");
                int intExtra = intent.getIntExtra("version_code", 0);
                String stringExtra4 = intent.getStringExtra("require_load");
                boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                String stringExtra5 = intent.getStringExtra("cmd_range");
                String stringExtra6 = intent.getStringExtra("install_flag");
                PluginSetting h2 = d.a.c.h.j.g.d.k().h(stringExtra);
                if (h2 == null) {
                    h2 = new PluginSetting();
                    h2.forbidden = false;
                }
                if (PluginPackageManager.this.f2224c) {
                    str2 = "load_lowversion";
                    if (this.installFailRetryMap.containsKey(h2.packageName)) {
                        d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                        StringBuilder sb = new StringBuilder();
                        str3 = "plugin_load";
                        sb.append("retry_at_num_");
                        str4 = "-";
                        sb.append(this.installFailRetryMap.get(h2.packageName));
                        b2.o("plugin_install", "re_install_success", stringExtra, sb.toString());
                        h2.packageName = stringExtra;
                        if (!TextUtils.equals(stringExtra2, h2.apkPath)) {
                            h2.addAbandonApk(h2.apkPath);
                        }
                        h2.apkPath = stringExtra2;
                        h2.setCmdRange(stringExtra5);
                        h2.enable = true;
                        h2.requireLoad = stringExtra4;
                        h2.version = stringExtra3;
                        h2.versionCode = intExtra;
                        h2.installStatus = 0;
                        h2.tempVersionCode = 0;
                        if (PluginPackageManager.this.f2224c) {
                            d.a.c.h.h.a.b().d("plugin_install_suc", stringExtra, h2, "");
                            d.a.c.h.h.a b3 = d.a.c.h.h.a.b();
                            b3.o("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + h2.install_fail_count);
                            if (intExtra < PluginPackageManager.u) {
                                d.a.c.h.h.a.b().i("plugin_launch_lowversion", stringExtra);
                                d.a.c.h.h.a b4 = d.a.c.h.h.a.b();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("broadcast_suc-");
                                sb2.append(h2.apkPath);
                                String str5 = str4;
                                sb2.append(str5);
                                sb2.append(h2.versionCode);
                                sb2.append(str5);
                                sb2.append(h2.forbidden);
                                sb2.append(str5);
                                sb2.append(h2.tempVersionCode);
                                sb2.append(str5);
                                sb2.append(h2.installStatus);
                                b4.o(str3, str2, stringExtra, sb2.toString());
                            }
                        }
                        h2.tempMd5 = "";
                        h2.url = "";
                        h2.install_fail_count = 0;
                        h2.hasRes = intent.getBooleanExtra("has_res", false);
                        h2.isThird = intent.getBooleanExtra("is_third", false);
                        h2.isPatch = intent.getBooleanExtra("is_patch", false);
                        h2.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                        h2.setInjectClassloader(booleanExtra);
                        PluginPackageManager.this.B(h2);
                        d.a.c.h.j.g.d.k().B(stringExtra, h2, PluginPackageManager.this.f2224c);
                        boolean z = !h2.isPatch && TextUtils.isEmpty(h2.replaceMethodClasses);
                        if (!TextUtils.isEmpty(h2.requireLoad) && h2.requireLoad.equals("0") && !z) {
                            PluginCenter.getInstance().launch(h2.packageName);
                        }
                        PluginPackageManager.this.J(stringExtra, true, null);
                    }
                } else {
                    str2 = "load_lowversion";
                }
                str3 = "plugin_load";
                str4 = "-";
                h2.packageName = stringExtra;
                if (!TextUtils.equals(stringExtra2, h2.apkPath)) {
                }
                h2.apkPath = stringExtra2;
                h2.setCmdRange(stringExtra5);
                h2.enable = true;
                h2.requireLoad = stringExtra4;
                h2.version = stringExtra3;
                h2.versionCode = intExtra;
                h2.installStatus = 0;
                h2.tempVersionCode = 0;
                if (PluginPackageManager.this.f2224c) {
                }
                h2.tempMd5 = "";
                h2.url = "";
                h2.install_fail_count = 0;
                h2.hasRes = intent.getBooleanExtra("has_res", false);
                h2.isThird = intent.getBooleanExtra("is_third", false);
                h2.isPatch = intent.getBooleanExtra("is_patch", false);
                h2.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                h2.setInjectClassloader(booleanExtra);
                PluginPackageManager.this.B(h2);
                d.a.c.h.j.g.d.k().B(stringExtra, h2, PluginPackageManager.this.f2224c);
                if (h2.isPatch) {
                }
                if (!TextUtils.isEmpty(h2.requireLoad)) {
                    PluginCenter.getInstance().launch(h2.packageName);
                }
                PluginPackageManager.this.J(stringExtra, true, null);
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra7 = intent.getStringExtra("install_src_file");
                if (stringExtra7 == null) {
                    return;
                }
                String substring = stringExtra7.substring(stringExtra7.lastIndexOf("/") + 1, stringExtra7.lastIndexOf(".apk"));
                String stringExtra8 = intent.getStringExtra("fail_reason");
                String stringExtra9 = intent.getStringExtra("install_comment");
                String stringExtra10 = intent.getStringExtra("package_name");
                String stringExtra11 = intent.getStringExtra("install_flag");
                if (TextUtils.isEmpty(stringExtra10)) {
                    pluginSetting = null;
                } else {
                    PluginSetting h3 = d.a.c.h.j.g.d.k().h(stringExtra10);
                    if ("apk_not_exist".equals(stringExtra8) && h3 != null && h3.installStatus == 0 && h3.tempVersionCode == 0) {
                        d.a.c.h.h.a b5 = d.a.c.h.h.a.b();
                        b5.o("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + "_" + stringExtra7);
                        return;
                    } else if ("assets_not_found".equals(stringExtra8)) {
                        d.a.c.h.h.a b6 = d.a.c.h.h.a.b();
                        b6.o("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + "_" + stringExtra9);
                        return;
                    } else {
                        if (h3 == null) {
                            PluginSetting pluginSetting2 = new PluginSetting();
                            pluginSetting2.packageName = stringExtra10;
                            pluginSetting = pluginSetting2;
                        } else {
                            pluginSetting = h3;
                        }
                        pluginSetting.enable = false;
                        if (PluginPackageManager.this.f2224c) {
                            int i2 = pluginSetting.install_fail_count + 1;
                            pluginSetting.install_fail_count = i2;
                            if (i2 >= 5) {
                                PluginPackageManager.this.B(pluginSetting);
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = "";
                                pluginSetting.tempMd5 = "";
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                            }
                            if (pluginSetting.install_fail_count >= d.a.c.e.n.k.a.o().q("alert_plugin", 3)) {
                                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                                bdStatisticsManager.alert("alert_plugin", "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                            }
                        }
                        d.a.c.h.j.g.d.k().B(stringExtra10, pluginSetting, PluginPackageManager.this.f2224c);
                    }
                }
                PluginPackageManager.this.J(substring, false, stringExtra8);
                if (PluginPackageManager.this.f2224c) {
                    if (stringExtra9 != null) {
                        String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                            stringExtra8 = "rom_size";
                        } else if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    d.a.c.h.h.a.b().i("plugin_fsync_failed", stringExtra10);
                                    stringExtra8 = "fsync_failed";
                                }
                            } else {
                                d.a.c.h.h.a.b().i("plugin_permission_denied", stringExtra10);
                                stringExtra8 = "permission_denied";
                            }
                        } else {
                            d.a.c.h.h.a.b().i("plugin_read_file_sys", stringExtra10);
                            stringExtra8 = "read_file_system";
                        }
                    }
                    if ("rom_size".equals(stringExtra8)) {
                        d.a.c.h.h.a.b().i("plugin_rom_small", stringExtra10);
                    }
                    d.a.c.h.h.a.b().e("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                    d.a.c.h.h.a b7 = d.a.c.h.h.a.b();
                    b7.r("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                }
            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                String stringExtra12 = intent.getStringExtra("package_name");
                PluginSetting h4 = d.a.c.h.j.g.d.k().h(stringExtra12);
                if (h4 != null) {
                    d.a.c.h.j.g.d.k().z(stringExtra12, true);
                    if (h4.versionCode < PluginPackageManager.u) {
                        d.a.c.h.h.a.b().i("plugin_launch_lowversion", stringExtra12);
                        d.a.c.h.h.a b8 = d.a.c.h.h.a.b();
                        b8.o("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + h4.apkPath + "-" + h4.versionCode + "-" + h4.forbidden + "-" + h4.tempVersionCode + "-" + h4.installStatus);
                    }
                    str = null;
                } else {
                    str = null;
                    d.a.c.h.h.a.b().o("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                }
                PluginPackageManager.this.J(stringExtra12, true, str);
            } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                String stringExtra13 = intent.getStringExtra("fail_reason");
                String stringExtra14 = intent.getStringExtra("package_name");
                if (TextUtils.isEmpty(stringExtra14)) {
                    return;
                }
                PluginSetting h5 = d.a.c.h.j.g.d.k().h(stringExtra14);
                if (h5 == null) {
                    h5 = new PluginSetting();
                    h5.packageName = stringExtra14;
                }
                h5.enable = false;
                if (PluginPackageManager.this.f2224c && "low_version_code".equals(stringExtra13)) {
                    PluginPackageManager.this.B(h5);
                    h5.tempVersionCode = 0;
                    h5.url = "";
                    h5.tempMd5 = "";
                    h5.install_fail_count = 0;
                    h5.installStatus = 0;
                }
                d.a.c.h.j.g.d.k().B(stringExtra14, h5, PluginPackageManager.this.f2224c);
                if ("low_version_code".equals(stringExtra13)) {
                    d.a.c.h.h.a.b().i("plugin_low_version_code", stringExtra14);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                boolean z = true;
                Bundle resultExtras = getResultExtras(true);
                String string = resultExtras != null ? resultExtras.getString("package_name") : "";
                if (!TextUtils.isEmpty(string) && resultExtras != null) {
                    str = resultExtras.getString("current_path");
                } else if (intent.getExtras() != null) {
                    string = intent.getExtras().getString("package_name");
                    str = intent.getExtras().getString("current_path");
                } else {
                    str = "";
                }
                String pluginApkFilePath = PluginCenter.getInstance().getPlugin(string) != null ? PluginCenter.getInstance().getPlugin(string).getPluginApkFilePath() : "";
                if (!TextUtils.isEmpty(pluginApkFilePath)) {
                    if (TextUtils.isEmpty(str)) {
                        str = pluginApkFilePath;
                    } else {
                        String[] split = str.split(",");
                        int length = split.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z = false;
                                break;
                            } else if (split[i2].equals(pluginApkFilePath)) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            str = str + "," + pluginApkFilePath;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("package_name", string);
                bundle.putString("current_path", str);
                setResultExtras(bundle);
                if (PluginPackageManager.this.f2224c) {
                    PluginPackageManager.this.E(string, str);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.c {
        public d() {
        }

        @Override // d.a.c.h.j.a.c
        public void a(String str, String str2) {
            PluginSetting h2;
            String[] split;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (h2 = d.a.c.h.j.g.d.k().h(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(h2.apkPath) && h2.apkPath.equals(str2)) {
                d.a.c.h.h.a.b().o("plugin_setting", "del_unuse_plugin_setting", h2.packageName, "apkpath-" + h2.apkPath + "-forbidden-" + h2.forbidden + "-enable-" + h2.enable + "-abandonapkpath-" + h2.getAbandon_apk_path() + "-versioncode-" + h2.versionCode);
                d.a.c.h.j.g.d.k().q(str);
            } else if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
                String str3 = "";
                for (String str4 : h2.getAbandon_apk_path().split(",")) {
                    if (!str2.equals(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = str3 + ",";
                        }
                        str3 = str3 + str4;
                    }
                }
                d.a.c.h.j.g.d.k().u(str, str3, PluginPackageManager.this.f2224c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f2235a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                e eVar = e.this;
                PluginPackageManager.this.m0(eVar.f2235a);
            }
        }

        public e(Object obj) {
            this.f2235a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            Object d2 = d.a.c.e.b.a.a.d(Looper.getMainLooper(), "sThreadLocal");
            if (d2 instanceof ThreadLocal) {
                ((ThreadLocal) d2).set(Looper.getMainLooper());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                PluginPackageManager.this.m0(this.f2235a);
                return null;
            }
            d.a.c.h.h.a.b().g("plugin_asyncinit_fail");
            d.a.c.e.m.e.a().post(new a());
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a.c.h.g.a {
        public f() {
        }

        @Override // d.a.c.h.g.a
        public void a(boolean z) {
            if (z) {
                if (PluginPackageManager.O().c0()) {
                    PluginSettings l = d.a.c.h.j.g.d.k().l();
                    d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(PluginPackageManager.this.f2227f);
                    sb.append("-");
                    sb.append(l != null ? l.getContainerVersion() : "");
                    b2.o("plugin_setting", "version_update_suc", null, sb.toString());
                }
                d.a.c.h.j.g.d.k().w(PluginPackageManager.this.f2227f);
                if (PluginPackageManager.O().c0()) {
                    d.a.c.h.h.a.b().k("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.f2229h);
                }
            } else if (PluginPackageManager.O().c0()) {
                PluginSettings l2 = d.a.c.h.j.g.d.k().l();
                d.a.c.h.h.a b3 = d.a.c.h.h.a.b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PluginPackageManager.this.f2227f);
                sb2.append("-");
                sb2.append(l2 != null ? l2.getContainerVersion() : "");
                b3.o("plugin_setting", "version_update_fail", null, sb2.toString());
            }
            PluginPackageManager.this.l0();
            PluginPackageManager.this.y0(true);
        }

        @Override // d.a.c.h.g.a
        public void b(String str) {
            d.a.c.h.j.g.d.k().z(str, true);
            PluginSetting h2 = d.a.c.h.j.g.d.k().h(str);
            if (h2 == null || h2.versionCode >= PluginPackageManager.u) {
                return;
            }
            d.a.c.h.h.a.b().i("plugin_launch_lowversion", str);
            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
            b2.o("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + h2.apkPath + "-" + h2.versionCode + "-" + h2.forbidden + "-" + h2.tempVersionCode + "-" + h2.installStatus);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f2239e;

        public g(boolean z) {
            this.f2239e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.h.j.f.d.c().e(d.a.c.h.j.g.d.k().l(), this.f2239e, PluginPackageManager.this.r);
        }
    }

    /* loaded from: classes.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PluginSettings l;
            PluginNetConfigInfos d2;
            List<PluginNetConfigInfos.PluginConfig> configs;
            Object data = customResponsedMessage.getData();
            if (data == null || !(data instanceof PluginNetConfigInfos.PluginConfig) || (l = d.a.c.h.j.g.d.k().l()) == null) {
                return;
            }
            if (l != null) {
                PluginPackageManager pluginPackageManager = PluginPackageManager.this;
                if (pluginPackageManager.z(pluginPackageManager.f2227f, l.getContainerVersion())) {
                    return;
                }
            }
            PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
            if (TextUtils.isEmpty(pluginConfig.package_name) || (d2 = d.a.c.h.j.f.d.c().d()) == null || (configs = d2.getConfigs()) == null) {
                return;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= configs.size()) {
                    z = true;
                    break;
                } else if (configs.get(i2).package_name.equals(pluginConfig.package_name)) {
                    configs.set(i2, pluginConfig);
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                configs.add(pluginConfig);
            }
            PluginPackageManager.this.p0(d.a.c.h.j.f.d.c().g(d.a.c.h.j.g.d.k().l()), pluginConfig);
            d.a.c.h.j.g.d.k().x(PluginPackageManager.this.N(configs));
            PluginPackageManager.this.D();
        }
    }

    /* loaded from: classes.dex */
    public class i implements d.a.c.h.j.f.a {
        public i() {
        }

        @Override // d.a.c.h.j.f.a
        public void a(boolean z, d.a.c.h.j.f.c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            String str2;
            if (PluginPackageManager.v != 1) {
                if (z && pluginNetConfigInfos != null) {
                    if (pluginNetConfigInfos.getConfigs() == null || pluginNetConfigInfos.getConfigs().size() <= 0) {
                        str2 = "";
                    } else {
                        List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                        PluginPackageManager.this.q0(cVar, configs);
                        str2 = PluginPackageManager.this.N(configs);
                    }
                    d.a.c.h.j.g.d.k().x(str2);
                    PluginPackageManager.this.m = false;
                    if (PluginPackageManager.this.f2224c) {
                        MessageManager.getInstance().unRegisterListener(PluginPackageManager.this.t);
                    }
                } else {
                    if (!d.a.c.e.p.k.isEmpty(str)) {
                        d.a.c.h.h.a.b().o("plugin_syncConfig", "plugin_syncConfigs_fail", null, str);
                    }
                    PluginPackageManager.this.m = true;
                    PluginPackageManager.this.h0();
                }
            }
            PluginPackageManager.this.D();
        }
    }

    /* loaded from: classes.dex */
    public class j implements d.a.c.h.j.e.a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Long> f2243a = new HashMap();

        /* loaded from: classes.dex */
        public class a implements d.a.c.h.g.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdFileDownloadData f2245a;

            public a(BdFileDownloadData bdFileDownloadData) {
                this.f2245a = bdFileDownloadData;
            }

            @Override // d.a.c.h.g.b
            public void a(String str) {
                if (PluginPackageManager.this.l != null) {
                    PluginPackageManager.this.l.c(this.f2245a, 0, "");
                }
            }

            @Override // d.a.c.h.g.b
            public void b(String str, String str2) {
                if (PluginPackageManager.this.l != null) {
                    PluginPackageManager.this.l.c(this.f2245a, -1, "rom_size".equals(str2) ? BdBaseApplication.getInst().getString(R.string.rom_too_small) : "");
                }
            }
        }

        public j() {
        }

        @Override // d.a.c.h.j.e.a
        public void a(BdFileDownloadData bdFileDownloadData) {
            String id;
            PluginSetting h2;
            if (PluginPackageManager.this.l != null) {
                PluginPackageManager.this.l.a(bdFileDownloadData);
            }
            if (bdFileDownloadData == null || (h2 = d.a.c.h.j.g.d.k().h((id = bdFileDownloadData.getId()))) == null) {
                return;
            }
            d.a.c.h.j.g.d.k().y(id, d.a.c.h.j.g.b.f42907a);
            if (this.f2243a.containsKey(id)) {
                long currentTimeMillis = System.currentTimeMillis() - this.f2243a.get(id).longValue();
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                b2.o("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(currentTimeMillis));
                this.f2243a.remove(id);
            }
            d.a.c.h.h.a.b().t("plugin_download", bdFileDownloadData.getId());
            if (Util.u(h2.size)) {
                if (PluginPackageManager.this.l != null) {
                    k kVar = new k(PluginPackageManager.this, null);
                    kVar.f2249c = id;
                    kVar.f2247a = System.currentTimeMillis();
                    kVar.f2248b = new a(bdFileDownloadData);
                    PluginPackageManager.this.f2223b.put(id, kVar);
                }
                PluginPackageManager.this.X(Util.l(h2), h2.packageName, "install_from_download");
                return;
            }
            d.a.c.h.g.d.q(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.g()));
            if (PluginPackageManager.this.l != null) {
                PluginPackageManager.this.l.c(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
            }
        }

        @Override // d.a.c.h.j.e.a
        public boolean b(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // d.a.c.h.j.e.a
        public boolean c(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // d.a.c.h.j.e.a
        public void d(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.l != null) {
                PluginPackageManager.this.l.d(bdFileDownloadData);
            }
        }

        @Override // d.a.c.h.j.e.a
        public void e(BdFileDownloadData bdFileDownloadData, int i2, String str, String str2) {
            if (PluginPackageManager.this.l != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i2);
                PluginPackageManager.this.l.b(bdFileDownloadData);
            }
            PluginPackageManager.this.h0();
            if (bdFileDownloadData == null) {
                return;
            }
            if (!this.f2243a.containsKey(bdFileDownloadData.getId())) {
                this.f2243a.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
            }
            d.a.c.h.h.a.b().p("plugin_download_fail", bdFileDownloadData.getId(), String.valueOf(i2), str2);
        }
    }

    /* loaded from: classes.dex */
    public class k {

        /* renamed from: a  reason: collision with root package name */
        public long f2247a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.c.h.g.b f2248b;

        /* renamed from: c  reason: collision with root package name */
        public String f2249c;

        public /* synthetic */ k(PluginPackageManager pluginPackageManager, b bVar) {
            this(pluginPackageManager);
        }

        public k(PluginPackageManager pluginPackageManager) {
        }
    }

    public PluginPackageManager() {
        this.f2223b = null;
        this.f2223b = new Hashtable<>();
        s0();
    }

    public static final int L() {
        return u;
    }

    public static PluginPackageManager O() {
        if (w == null) {
            synchronized (PluginPackageManager.class) {
                if (w == null) {
                    w = new PluginPackageManager();
                }
            }
        }
        return w;
    }

    public final void A() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, k>> it = this.f2223b.entrySet().iterator();
            while (it.hasNext()) {
                k value = it.next().getValue();
                if (value != null && currentTimeMillis - value.f2247a >= 600000) {
                    if (value.f2248b != null) {
                        value.f2248b.b(value.f2249c, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public final void B(PluginSetting pluginSetting) {
        if (this.f2224c) {
            d.a.c.h.j.c.e().d(pluginSetting);
        }
    }

    public void C() {
        if (this.f2230i) {
            d.a.c.h.j.b.d().c(this.f2224c);
        }
    }

    public final void D() {
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l == null) {
            return;
        }
        ArrayList<PluginSetting> arrayList = new ArrayList<>();
        for (Map.Entry<String, PluginSetting> entry : l.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null) {
                W(value, arrayList);
            }
        }
        Iterator<PluginSetting> it = arrayList.iterator();
        while (it.hasNext()) {
            PluginSetting next = it.next();
            if (next != null) {
                r0(next);
            }
        }
    }

    public final void E(String str, String str2) {
        PluginSetting h2;
        if (TextUtils.isEmpty(str) || (h2 = d.a.c.h.j.g.d.k().h(str)) == null) {
            return;
        }
        if (h2.installStatus == d.a.c.h.j.g.b.f42908b && TextUtils.isEmpty(str2)) {
            d.a.c.h.h.a.b().q("plugin_del_unuse", "server forbidden", str);
            F(str);
        } else if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
            String[] split = str2.split(",");
            String[] split2 = h2.getAbandon_apk_path().split(",");
            HashMap hashMap = new HashMap();
            ArrayList<a.b> arrayList = new ArrayList<>();
            for (String str3 : split) {
                hashMap.put(str3, "");
            }
            for (String str4 : split2) {
                if (hashMap.get(str4) == null) {
                    arrayList.add(new a.b(str, str4));
                }
            }
            d.a.c.h.j.a.h().f(arrayList, this.p);
        }
    }

    public final void F(String str) {
        PluginSetting h2;
        if (TextUtils.isEmpty(str) || (h2 = d.a.c.h.j.g.d.k().h(str)) == null) {
            return;
        }
        ArrayList<a.b> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(h2.getAbandon_apk_path())) {
            for (String str2 : h2.getAbandon_apk_path().split(",")) {
                arrayList.add(new a.b(str, str2));
            }
        }
        arrayList.add(new a.b(str, h2.apkPath));
        d.a.c.h.j.a.h().f(arrayList, this.p);
    }

    public final void G() {
        if (this.f2224c) {
            d.a.c.h.j.g.d.k().v(false);
        }
    }

    public final void H(PluginSetting pluginSetting) {
        I(pluginSetting, this.s, false);
    }

    public final void I(PluginSetting pluginSetting, d.a.c.h.j.e.a aVar, boolean z) {
        if (this.f2224c && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.j(pluginSetting));
            bdFileDownloadData.setPath(Util.l(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            bdFileDownloadData.setSize(pluginSetting.size);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (Util.u(pluginSetting.size)) {
                if (z) {
                    d.a.c.h.j.e.c.b().f(bdFileDownloadData, aVar);
                    return;
                } else {
                    d.a.c.h.j.e.c.b().e(bdFileDownloadData, aVar);
                    return;
                }
            }
            if (aVar != null) {
                bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(-1);
                aVar.e(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
            }
            d.a.c.h.h.a.b().q("plugin_download", "rom too small", pluginSetting.packageName);
        }
    }

    public final void J(String str, boolean z, String str2) {
        k remove;
        d.a.c.h.g.b bVar;
        if (StringUtils.isNull(str) || (remove = this.f2223b.remove(str)) == null || (bVar = remove.f2248b) == null) {
            return;
        }
        if (z) {
            bVar.a(str);
        } else {
            bVar.b(remove.f2249c, str2);
        }
    }

    public void K(String str) {
        d.a.c.h.j.g.d.k().i(str);
    }

    public String M() {
        return this.f2227f;
    }

    public final String N(List<PluginNetConfigInfos.PluginConfig> list) {
        String str = "";
        if (list == null) {
            return "";
        }
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                String str2 = pluginConfig.forbidden_features;
                if (!TextUtils.isEmpty(str2)) {
                    str = TextUtils.isEmpty(str) ? str2 : str + "," + str2;
                }
            }
        }
        return str;
    }

    public PluginSetting P(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return d.a.c.h.j.g.d.k().h(str);
    }

    public int Q() {
        return this.k;
    }

    public PluginNetConfigInfos.PluginConfig R(String str) {
        PluginNetConfigInfos d2;
        if (TextUtils.isEmpty(str) || (d2 = d.a.c.h.j.f.d.c().d()) == null) {
            return null;
        }
        return d2.getPluginConfig(str);
    }

    public boolean S() {
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l != null && l.getPlugins() != null && l.getPlugins().size() != 0) {
            for (Map.Entry<String, PluginSetting> entry : l.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && T(value.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean T(String str) {
        PluginNetConfigInfos.Newest newest;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = -1;
        PluginNetConfigInfos d2 = d.a.c.h.j.f.d.c().d();
        if (d2 != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = d2.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && (newest = pluginConfig.newest) != null) {
                i2 = newest.version_code;
            }
        }
        PluginSetting h2 = d.a.c.h.j.g.d.k().h(str);
        if (h2 != null) {
            int i3 = h2.versionCode;
            if (i3 < i2 || i3 < h2.tempVersionCode) {
                return true;
            }
        } else if (i2 > 0) {
            return true;
        }
        return false;
    }

    public void U(String str, boolean z, boolean z2, boolean z3) {
        this.f2224c = z;
        this.f2225d = z2;
        this.f2226e = z3;
        this.f2227f = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            u = d.a.c.e.m.b.d(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), u);
        } catch (Throwable unused) {
        }
        d.a.c.h.j.g.d.k().p(null);
    }

    public final void V() {
        MessageManager.getInstance().registerListener(2000987, new h(0));
    }

    public final void W(PluginSetting pluginSetting, ArrayList<PluginSetting> arrayList) {
        if (arrayList == null || pluginSetting == null) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            PluginSetting pluginSetting2 = arrayList.get(i2);
            if (pluginSetting2 != null && pluginSetting2.priority > pluginSetting.priority) {
                break;
            }
            i2++;
        }
        arrayList.add(i2, pluginSetting);
    }

    public void X(String str, String str2, String str3) {
        if (this.f2224c) {
            d.a.c.h.h.a.b().d("plugin_install", str2, null, str3);
            if (!Util.u(new File(str).length())) {
                d.a.c.h.g.d.q(str, str2, "rom_size", String.valueOf(Util.g()));
            } else if (str != null) {
                if (new File(str).exists()) {
                    d.a.c.h.g.c.B().F(this.f2222a, str);
                    return;
                }
                d.a.c.h.h.a.b().o("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting h2 = d.a.c.h.j.g.d.k().h(str2);
                if (h2 != null) {
                    h2.tempVersionCode = 0;
                    h2.url = "";
                    h2.tempMd5 = "";
                    h2.install_fail_count = 0;
                    h2.installStatus = 0;
                    h2.size = 0;
                    d.a.c.h.j.g.d.k().m(str2, h2);
                }
            }
        }
    }

    public void Y() {
        if (this.f2224c) {
            d.a.c.h.g.c.B().E(this.f2222a, this.q);
        }
    }

    public boolean Z(String str) {
        return d.a.c.h.j.e.c.b().c(str);
    }

    public boolean a0(String str) {
        if (d.a.c.h.j.g.d.k().l() == null) {
            return false;
        }
        return d.a.c.h.j.g.d.k().l().isFeatureForbidden(str);
    }

    public boolean b0(String str) {
        PluginSetting h2 = d.a.c.h.j.g.d.k().h(str);
        if (h2 == null) {
            return true;
        }
        return h2.forbidden;
    }

    public boolean c0() {
        return this.f2224c;
    }

    public boolean d0(String str) {
        return y(str);
    }

    public boolean e0() {
        return this.j;
    }

    public boolean f0() {
        return this.f2225d;
    }

    public boolean g0() {
        return S() && !this.f2228g;
    }

    public final void h0() {
        if (this.f2224c) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().registerListener(this.t);
        }
    }

    public void i0(d.a.c.h.j.e.b bVar, d.a.c.h.j.f.b bVar2, boolean z, Object obj) {
        d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", ProgressInfo.JSON_KEY_BEGIN);
        if (this.f2230i) {
            d.a.c.h.h.a.b().g("plugin_pkgmanager_recreate");
        }
        d.a.c.h.j.e.c.b().d(bVar);
        d.a.c.h.j.f.d.c().f(bVar2);
        this.f2230i = true;
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l != null && (l == null || !z(this.f2227f, l.getContainerVersion()))) {
            d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin");
            if ((d.a.c.e.b.a.a.d(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
                e eVar = new e(obj);
                eVar.setPriority(4);
                eVar.execute(new Void[0]);
            } else {
                d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                m0(obj);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("install_buildin_plugin-");
            sb.append(this.f2227f);
            sb.append("-");
            sb.append(l == null ? "settings_is_null" : l.getContainerVersion());
            d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", sb.toString());
            this.f2229h = System.currentTimeMillis();
            if (O().c0()) {
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2227f);
                sb2.append("-");
                sb2.append(l == null ? "" : l.getContainerVersion());
                b2.o("plugin_setting", "version_update", null, sb2.toString());
            }
            G();
            Y();
        }
        t0();
        V();
        d.a.c.h.h.b.e("PluginPackageManager_loadAllPlugins", ProgressInfo.JSON_KEY_END);
    }

    public final void j0(PluginSettings pluginSettings) {
        List<PluginSetting> pluginSettingsSortLoadPriorty;
        if (pluginSettings == null || pluginSettings.getPlugins() == null || (pluginSettingsSortLoadPriorty = pluginSettings.getPluginSettingsSortLoadPriorty()) == null) {
            return;
        }
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                try {
                    if (!Util.q()) {
                        return;
                    }
                    Plugin.c launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.f2208a) {
                        d.a.c.h.h.a.b().g("patch_launch_failed");
                    }
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                    String str = pluginSetting.packageName;
                    b2.r("plugin_load", "plugin_patch_hook_failed", str, "exception : " + th.getMessage());
                    return;
                }
            }
        }
    }

    public void k0() {
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l == null || z(this.f2227f, l.getContainerVersion())) {
            return;
        }
        j0(l);
    }

    public final void l0() {
        d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", ProgressInfo.JSON_KEY_BEGIN);
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l == null) {
            d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
            return;
        }
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        List<PluginSetting> pluginSettingsSortLoadPriorty = l.getPluginSettingsSortLoadPriorty();
        if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
            for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                    if (!pluginSetting.isPatch || this.k <= 0) {
                        if (pluginSetting.enable && pluginSetting.installStatus != d.a.c.h.j.g.b.f42908b) {
                            d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                            if (!this.f2226e || "com.baidu.tieba.pluginCore".equals(pluginSetting.packageName) || "com.baidu.tieba.pluginExtend".equals(pluginSetting.packageName)) {
                                Plugin.c launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                if (!launch.f2208a && (plugin2 == null || !plugin2.isLoaded())) {
                                    d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.f2209b + "-comment_" + launch.f2210c);
                                } else {
                                    d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                                }
                                if (!launch.f2208a && plugin2 != null && !plugin2.isLoaded()) {
                                    i2++;
                                    if (O().c0()) {
                                        if (sb.length() > 0) {
                                            sb.append(",");
                                        }
                                        sb.append(pluginSetting.packageName);
                                        sb.append("-");
                                        sb.append(pluginSetting.apkPath);
                                        sb.append("-");
                                        sb.append(pluginSetting.forbidden);
                                        sb.append("-");
                                        sb.append(pluginSetting.enable);
                                        sb.append("-");
                                        sb.append(pluginSetting.installStatus);
                                        sb.append("-");
                                        sb.append(pluginSetting.versionCode);
                                        sb.append("-");
                                        sb.append(pluginSetting.install_fail_count);
                                        sb.append("-");
                                        sb.append(pluginSetting.getAbandon_apk_path());
                                        sb.append("-");
                                        sb.append(launch.f2209b);
                                        sb.append("-");
                                        sb.append(launch.f2210c);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (O().c0() && i2 > 0) {
                d.a.c.h.h.a.b().o("plugin_load", "load_allplugin", null, sb.toString());
            }
            d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", ProgressInfo.JSON_KEY_END);
            return;
        }
        d.a.c.h.h.b.e("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
    }

    public final void m0(Object obj) {
        l0();
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
        if (Build.VERSION.SDK_INT <= 10) {
            return;
        }
        y0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n0() {
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l != null && l.getPlugins() != null && !z(this.f2227f, l.getContainerVersion())) {
            for (PluginSetting pluginSetting : l.getPlugins().values()) {
                if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || l.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                    return true;
                }
                while (r2.hasNext()) {
                }
            }
        }
        return false;
    }

    public void o0(String str, d.a.c.h.g.b bVar) {
        boolean d0 = d0(str);
        boolean H = d.a.c.h.g.c.B().H(str);
        if (d0 && !H) {
            bVar.a(str);
        } else {
            k kVar = new k(this, null);
            kVar.f2249c = str;
            kVar.f2247a = System.currentTimeMillis();
            kVar.f2248b = bVar;
            synchronized (this) {
                if (this.f2223b.size() < 1000) {
                    this.f2223b.put(str, kVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        A();
    }

    public final void p0(d.a.c.h.j.f.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        int i2;
        List<BasicNameValuePair> a2;
        int i3;
        int i4;
        if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name)) {
            return;
        }
        PluginSetting h2 = d.a.c.h.j.g.d.k().h(pluginConfig.package_name);
        boolean z = false;
        if (h2 == null) {
            h2 = new PluginSetting();
            h2.enable = false;
            h2.packageName = pluginConfig.package_name;
        }
        if (h2.installStatus == d.a.c.h.j.g.b.f42907a) {
            String l = Util.l(h2);
            if (!new File(l).exists() && this.f2224c) {
                d.a.c.h.h.a.b().o("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, l);
            }
        }
        h2.priority = pluginConfig.priority;
        h2.load_priority = pluginConfig.load_priority;
        String str = pluginConfig.ext;
        h2.ext = str;
        h2.rollback = 0;
        if (!TextUtils.isEmpty(str) && h2.ext.contains("rollback")) {
            try {
                h2.rollback = new JSONObject(h2.ext).getInt("rollback");
            } catch (Throwable unused) {
                d.a.c.h.h.a.b().o("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
            }
        }
        String str2 = null;
        if (pluginConfig.forbidden == 1) {
            d.a.c.h.h.a.b().o("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
            d.a.c.h.j.g.d.k().z(pluginConfig.package_name, false);
            d.a.c.h.j.g.d.k().y(pluginConfig.package_name, d.a.c.h.j.g.b.f42908b);
        } else {
            PluginNetConfigInfos.Newest newest = pluginConfig.newest;
            if (newest != null && newest.version_code < u && this.f2224c) {
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                String str3 = pluginConfig.package_name;
                b2.o("plugin_install", "server_config_versionlower", str3, u + "_" + h2.versionCode + "_" + pluginConfig.newest.version_code);
            }
            if (pluginConfig.enable == 1) {
                PluginNetConfigInfos.Newest newest2 = pluginConfig.newest;
                if (newest2 != null && (i3 = newest2.version_code) > (i4 = h2.versionCode)) {
                    h2.enable = false;
                    if (i3 > h2.tempVersionCode && i3 > i4) {
                        h2.tempVersionCode = i3;
                        h2.url = newest2.url;
                        h2.tempMd5 = newest2.md5;
                        h2.install_fail_count = 0;
                        h2.installStatus = 0;
                        h2.size = newest2.size;
                        int i5 = newest2.download_type;
                        if (i5 == d.a.c.h.j.g.a.f42905a) {
                            h2.installStatus = d.a.c.h.j.g.b.f42909c;
                        } else if (i5 == d.a.c.h.j.g.a.f42906b) {
                            h2.installStatus = d.a.c.h.j.g.b.f42910d;
                        }
                    } else if (h2.rollback > 0) {
                        h2.tempVersionCode = 0;
                        h2.url = null;
                        h2.tempMd5 = null;
                        h2.installStatus = 0;
                        z = true;
                    }
                    d.a.c.h.j.g.d.k().m(pluginConfig.package_name, h2);
                } else if (h2.rollback > 0) {
                    h2.tempVersionCode = 0;
                    h2.url = null;
                    h2.tempMd5 = null;
                    h2.installStatus = 0;
                    d.a.c.h.j.g.d.k().z(pluginConfig.package_name, false);
                    d.a.c.h.j.g.d.k().m(pluginConfig.package_name, h2);
                    z = true;
                } else {
                    if (cVar != null && (a2 = cVar.a()) != null) {
                        Iterator it = new ArrayList(a2).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                            if (basicNameValuePair != null && TextUtils.equals(basicNameValuePair.getName(), pluginConfig.package_name)) {
                                str2 = basicNameValuePair.getValue();
                                break;
                            }
                        }
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (pluginConfig.newest == null) {
                        d.a.c.h.h.a b3 = d.a.c.h.h.a.b();
                        String str4 = pluginConfig.package_name;
                        b3.o("plugin_setting", "server_disable_plugin_nonewest", str4, "up-" + str2 + "-set-" + h2.versionCode + "-" + h2.apkPath);
                    } else {
                        d.a.c.h.h.a b4 = d.a.c.h.h.a.b();
                        String str5 = pluginConfig.package_name;
                        b4.o("plugin_setting", "server_disable_plugin_newestversionlow", str5, "up-" + str2 + "-config-" + pluginConfig.newest.version_code + "-set-" + h2.versionCode);
                    }
                    d.a.c.h.j.g.d.k().z(pluginConfig.package_name, false);
                    d.a.c.h.j.g.d.k().y(pluginConfig.package_name, d.a.c.h.j.g.b.f42908b);
                }
            } else {
                if (h2.versionCode == 0) {
                    h2.enable = false;
                } else {
                    h2.enable = true;
                }
                PluginNetConfigInfos.Newest newest3 = pluginConfig.newest;
                if (newest3 != null && (i2 = newest3.version_code) > h2.tempVersionCode && i2 > h2.versionCode) {
                    h2.tempVersionCode = i2;
                    h2.url = newest3.url;
                    h2.tempMd5 = newest3.md5;
                    h2.install_fail_count = 0;
                    h2.installStatus = 0;
                    h2.size = newest3.size;
                    int i6 = newest3.download_type;
                    if (i6 == d.a.c.h.j.g.a.f42905a) {
                        h2.installStatus = d.a.c.h.j.g.b.f42909c;
                    } else if (i6 == d.a.c.h.j.g.a.f42906b) {
                        h2.installStatus = d.a.c.h.j.g.b.f42910d;
                    }
                } else if (h2.rollback > 0) {
                    h2.tempVersionCode = 0;
                    h2.url = null;
                    h2.tempMd5 = null;
                    h2.installStatus = 0;
                    z = true;
                }
                d.a.c.h.j.g.d.k().m(pluginConfig.package_name, h2);
            }
        }
        if (h2.rollback <= 0 || !z) {
            return;
        }
        d.a.c.h.g.c.B().R(h2.packageName, h2.rollback);
    }

    public final void q0(d.a.c.h.j.f.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            p0(cVar, pluginConfig);
        }
    }

    public final void r0(PluginSetting pluginSetting) {
        if (pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        if (pluginSetting.versionCode <= 0) {
            pluginSetting.enable = false;
            d.a.c.h.j.g.d.k().z(pluginSetting.packageName, false);
        }
        int i2 = pluginSetting.installStatus;
        if (i2 != d.a.c.h.j.g.b.f42908b) {
            int i3 = pluginSetting.versionCode;
            int i4 = pluginSetting.tempVersionCode;
            if (i3 < i4) {
                if (i2 == d.a.c.h.j.g.b.f42907a) {
                    X(Util.l(pluginSetting), pluginSetting.packageName, "install_from_setting");
                    return;
                } else if ((i2 == d.a.c.h.j.g.b.f42910d && d.a.c.e.p.j.H()) || pluginSetting.installStatus == d.a.c.h.j.g.b.f42909c) {
                    H(pluginSetting);
                    return;
                } else {
                    return;
                }
            }
            if (i3 == i4 && i3 > 0 && !pluginSetting.enable) {
                pluginSetting.enable = true;
                pluginSetting.tempMd5 = "";
                pluginSetting.url = "";
                pluginSetting.tempVersionCode = 0;
                d.a.c.h.j.g.d.k().m(pluginSetting.packageName, pluginSetting);
            }
            if (!pluginSetting.enable || pluginSetting.versionCode <= 0) {
                return;
            }
            d.a.c.h.j.g.d.k().j(pluginSetting.packageName);
            if (pluginSetting.versionCode < u) {
                d.a.c.h.h.a.b().i("plugin_launch_lowversion", pluginSetting.packageName);
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                String str = pluginSetting.packageName;
                b2.o("plugin_load", "load_lowversion", str, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
            }
        }
    }

    public final void s0() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            this.f2222a.registerReceiver(this.n, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void t0() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.f2224c) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.f2222a.registerReceiver(this.o, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (this.f2224c) {
            for (Map.Entry<String, PluginSetting> entry : d.a.c.h.j.g.d.k().l().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == d.a.c.h.j.g.b.f42908b)) {
                    Intent intent = new Intent("com.baidu.adp.plugin.currentpath");
                    Bundle bundle = new Bundle();
                    bundle.putString("package_name", value.packageName);
                    bundle.putString("current_path", "");
                    intent.putExtras(bundle);
                    this.f2222a.sendOrderedBroadcast(intent, null);
                }
            }
        }
    }

    public void u0(d.a.c.h.j.d dVar) {
        this.l = dVar;
    }

    public void v0(int i2) {
        this.k = i2;
    }

    public void w0() {
        this.f2228g = true;
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.c.h.j.e.c.b().a(str);
    }

    public void x0(PluginNetConfigInfos.PluginConfig pluginConfig, d.a.c.h.j.d dVar) {
        if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name)) {
            return;
        }
        PluginNetConfigInfos.Newest newest = pluginConfig.newest;
        if (newest == null || newest.version_code <= 0 || TextUtils.isEmpty(newest.url)) {
            if (dVar != null) {
                dVar.b(new BdFileDownloadData(pluginConfig.package_name));
            }
            if (pluginConfig.newest == null) {
                return;
            }
        }
        PluginSetting h2 = d.a.c.h.j.g.d.k().h(pluginConfig.package_name);
        if (h2 == null) {
            h2 = new PluginSetting();
            h2.packageName = pluginConfig.package_name;
        }
        PluginNetConfigInfos.Newest newest2 = pluginConfig.newest;
        h2.tempMd5 = newest2.md5;
        h2.tempVersionCode = newest2.version_code;
        h2.url = newest2.url;
        h2.size = newest2.size;
        d.a.c.h.j.g.d.k().m(h2.packageName, h2);
        this.l = dVar;
        I(h2, this.s, true);
    }

    public boolean y(String str) {
        PluginSetting h2 = d.a.c.h.j.g.d.k().h(str);
        return h2 != null && h2.enable;
    }

    public void y0(boolean z) {
        if (this.f2224c) {
            d.a.c.e.m.e.a().postDelayed(new g(z), 1500L);
        }
    }

    public final boolean z(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.c(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void z0(String str) {
        d.a.c.h.j.g.d.k().A(str);
    }
}
