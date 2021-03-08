package com.baidu.adp.plugin.install;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.f;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private ArrayList<String> UD;
    private BroadcastReceiver UE;
    private com.baidu.adp.plugin.install.a UG;
    private PluginInstallTask UN;
    private PluginInstallTask UQ;
    private ServiceConnection US;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c UH = null;
    private boolean UC = false;
    private boolean UF = false;
    private boolean UJ = true;
    private a UL = null;
    private final Object UM = new Object();
    private LinkedList<PluginInstallTask> UO = new LinkedList<>();
    private LinkedList<PluginInstallTask> UR = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.UN != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).pkgName, c.this.UN.pkgName)) {
                        c.sHandler.removeCallbacks(c.this.UV);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger UT = new Messenger(this.handler);
    private Runnable UU = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.oS();
            c.this.oR();
        }
    };
    private Runnable UV = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.oU();
        }
    };
    private Runnable UW = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.oV();
        }
    };
    private Runnable UX = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.oW();
        }
    };

    public static c oM() {
        if (UH == null) {
            synchronized (c.class) {
                if (UH == null) {
                    UH = new c();
                }
            }
        }
        return UH;
    }

    private c() {
        this.UD = null;
        this.UE = null;
        this.UD = new ArrayList<>();
        this.UE = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.UN != null && TextUtils.equals(null, c.this.UN.pkgName)) {
                            c.this.oO();
                            c.this.UN = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.UQ == null || !TextUtils.equals(null, c.this.UQ.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.oP();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.pe().log("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.UN != null && TextUtils.equals(str, c.this.UN.pkgName)) {
                                    c.this.oO();
                                    c.this.UN = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.UQ == null || !TextUtils.equals(str, c.this.UQ.pkgName)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.oP();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.pe().log("plugin_retry_install_succ");
                                    return;
                                }
                            }
                            String stringExtra = intent.getStringExtra("install_src_file");
                            if (stringExtra != null && stringExtra.startsWith("assets://")) {
                                z = true;
                            }
                            String action = intent.getAction();
                            if ("com.baidu.adp.plugin.installed".equals(action)) {
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.qd().cS(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.UJ = false;
                                }
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.qd().j(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.h(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.UN != null && TextUtils.equals(str, c.this.UN.pkgName)) {
                                c.this.oO();
                                c.this.UN = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.UQ == null || !TextUtils.equals(str, c.this.UQ.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.oP();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.pe().log("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.UN != null && TextUtils.equals(str, c.this.UN.pkgName)) {
                                c.this.oO();
                                c.this.UN = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.UQ == null || !TextUtils.equals(str, c.this.UQ.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.oP();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.pe().log("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.UN != null && TextUtils.equals(null, c.this.UN.pkgName)) {
                            c.this.oO();
                            c.this.UN = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.UQ == null || !TextUtils.equals(null, c.this.UQ.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.oP();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.pe().log("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        oN();
    }

    public void n(String str, int i) {
        if (i == 1) {
            l(BdBaseApplication.getInst(), "plugins/" + str + ".apk", "install_from_rollback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.UD.contains(str)) {
            this.UD.remove(str);
        }
        if (!this.UF && z && this.UD.isEmpty()) {
            this.UF = true;
            if (this.UG != null) {
                this.UG.onInstallFinish(this.UJ);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_ALL_INSTALL));
            oQ();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.UG = aVar;
        if (this.UL != null) {
            this.UL.cancel();
            this.UL = null;
        }
        this.UL = new a(context);
        this.UL.setPriority(4);
        this.UL.execute(new String[0]);
    }

    public boolean cs(String str) {
        if (this.UN != null) {
            return TextUtils.equals(str, this.UN.pkgName);
        }
        if (this.UQ != null) {
            return TextUtils.equals(str, this.UQ.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".apk");
        if (lastIndexOf + 1 >= lastIndexOf2) {
            return false;
        }
        String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
        PluginSetting cA = PluginPackageManager.pv().cA(substring);
        if (substring != null && substring.length() > 0 && cA != null && cA.apkPath != null) {
            File file = new File(cA.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f g = Util.g(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (g.compareTo(Util.g(inputStream)) == 0) {
                                if (this.UG != null) {
                                    this.UG.cq(substring);
                                }
                                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "install_timeequals", substring, g.toString());
                                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.f.a.close(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.pe().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.pe().a("plugin_install", substring, cA, str2);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.qd().cU(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.pe().a("plugin_install", substring, cA, str2);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.qd().cU(substring)));
        return true;
    }

    public void w(Context context, String str) {
        c(context, "file://" + str, false);
    }

    private void c(Context context, String str, boolean z) {
        boolean z2 = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            oN();
            String str2 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z2 = true;
                try {
                    pluginInstallTask.UB = context.getAssets().open(str.substring("assets://".length())).available();
                } catch (IOException e) {
                    BdLog.detailException(e);
                }
                str2 = substring;
            } else if (str.startsWith("file://")) {
                PackageManager packageManager = context.getPackageManager();
                String substring2 = str.substring("file://".length());
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring2, 0);
                if (packageArchiveInfo != null) {
                    str2 = packageArchiveInfo.packageName;
                }
                pluginInstallTask.UB = new File(substring2).length();
            }
            if (str2 != null) {
                pluginInstallTask.pkgName = str2;
                if (a(pluginInstallTask) && z2) {
                    this.UD.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.pkgName = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(pluginInstallTask.pkgName);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("file://")) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "start_service_install_status_error", pluginInstallTask.pkgName, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring("file://".length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_install", "start_service_file_not_find", pluginInstallTask.pkgName, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        String str = "f" + System.currentTimeMillis();
        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "start_install_service", pluginInstallTask.pkgName, "flag=" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.pkgName);
        intent.putExtra("install_flag", str);
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.pv().pw());
        if (pluginInstallTask.Uz) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.US == null && z) {
            this.US = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.oT();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.UN != null && TextUtils.equals(stringExtra, c.this.UN.pkgName)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.US, 1)) {
                return true;
            }
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th2) {
                return false;
            }
        }
        try {
            context.startService(intent);
            return true;
        } catch (Throwable th3) {
            return false;
        }
    }

    public static File ct(String str) {
        PluginSetting cA = PluginPackageManager.pv().cA(str);
        if (cA == null || cA.apkPath == null || cA.apkPath.length() <= 0) {
            return null;
        }
        return new File(cA.apkPath);
    }

    private void oN() {
        if (!this.UC) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
                if (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().equals(RomUtils.MANUFACTURER_OPPO)) {
                    intentFilter.setPriority(1000);
                }
                applicationContext.registerReceiver(this.UE, intentFilter);
                this.UC = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PluginInstallTask pluginInstallTask) {
        if (b(pluginInstallTask)) {
            return true;
        }
        return c(pluginInstallTask);
    }

    private boolean b(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.UM) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.UO.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.UN != null) {
                Iterator<PluginInstallTask> it = this.UO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.UO.add(pluginInstallTask);
                }
                return true;
            }
            this.UN = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                oR();
                sHandler.removeCallbacks(this.UW);
                sHandler.postDelayed(this.UW, this.UN.oL());
                return true;
            }
            this.UN = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.UM) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.UR.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.UQ != null) {
                Iterator<PluginInstallTask> it = this.UR.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.UR.add(pluginInstallTask);
                }
                return true;
            }
            this.UQ = pluginInstallTask;
            pluginInstallTask.Uz = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.UX);
                sHandler.postDelayed(this.UX, this.UQ.oL());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO() {
        sHandler.removeCallbacks(this.UU);
        sHandler.removeCallbacks(this.UW);
        sHandler.removeCallbacks(this.UV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP() {
        this.UQ = null;
        sHandler.removeCallbacks(this.UX);
    }

    private void oQ() {
        if (this.US != null) {
            BdBaseApplication.getInst().unbindService(this.US);
            this.US = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR() {
        sHandler.removeCallbacks(this.UU);
        sHandler.postDelayed(this.UU, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS() {
        if (this.messenger != null && this.UN != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.UN));
                message.replyTo = this.UT;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.UV);
            sHandler.postDelayed(this.UV, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oT() {
        this.US = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "system_kill_installprocess", this.UN == null ? "" : this.UN.pkgName, this.UO.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR.size());
        oO();
        pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU() {
        com.baidu.adp.plugin.b.a.pe().log("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "installprocess_noresponse", this.UN == null ? "" : this.UN.pkgName, this.UO.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR.size());
        oO();
        oX();
        pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV() {
        if (this.UN != null) {
            com.baidu.adp.plugin.packageManager.status.a.qd().j(this.UN.pkgName, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.UN;
        if (!oY()) {
            com.baidu.adp.plugin.b.a.pe().log("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.pe().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.oL())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UO.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR.size());
        } else {
            com.baidu.adp.plugin.b.a.pe().log("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.pe().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.oL())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UO.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR.size());
        }
        oO();
        oX();
        pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW() {
        if (this.UQ != null) {
            com.baidu.adp.plugin.packageManager.status.a.qd().j(this.UQ.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "timeout", this.UQ == null ? "" : this.UQ.pkgName, "timeout-" + (this.UQ == null ? "" : Long.valueOf(this.UQ.oL())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UO.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UR.size());
        oP();
    }

    private void oX() {
        if (this.US != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.US);
        }
        this.US = null;
        this.messenger = null;
        int oZ = oZ();
        if (oZ > 0 && oZ != Process.myPid()) {
            Process.killProcess(oZ);
        }
    }

    private boolean oY() {
        return oZ() > 0;
    }

    private int oZ() {
        ServiceInfo serviceInfo;
        Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
        try {
            serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, PluginInstallerService.class), 0);
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            serviceInfo = null;
        }
        if (serviceInfo != null) {
            String str = serviceInfo.processName;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.pid;
                    }
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private void pa() {
        if (this.UN != null) {
            com.baidu.adp.plugin.b.a.pe().B("plugin_retry_install", this.UN.pkgName);
            com.baidu.adp.plugin.b.a.pe().f("plugin_install", "plugin_retry_install", this.UN.pkgName, this.UN.oL() + "");
            c(this.UN);
            this.UN = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] UZ = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
        private Context mContext;

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String[] doInBackground(String... strArr) {
            Exception e;
            InputStream inputStream;
            String[] strArr2 = null;
            if (this.mContext == null) {
                return null;
            }
            try {
                AssetManager assets = this.mContext.getAssets();
                String[] list = assets.list("plugins");
                if (list != null) {
                    try {
                        if (list.length > 0) {
                            final HashMap hashMap = new HashMap();
                            try {
                                inputStream = assets.open("plugins/plugin.config");
                            } catch (IOException e2) {
                                BdLog.e("plugin.config file not in assets");
                                inputStream = null;
                            }
                            if (inputStream != null) {
                                try {
                                    byte[] bArr = new byte[inputStream.available()];
                                    inputStream.read(bArr);
                                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (next instanceof String) {
                                            String str = next;
                                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                            String str2 = !str.endsWith(".apk") ? str + ".apk" : str;
                                            PluginStatus pluginStatus = (PluginStatus) PluginStatus.objectWithJson(optJSONObject, PluginStatus.class);
                                            if (pluginStatus != null) {
                                                hashMap.put(str2, pluginStatus);
                                            }
                                        }
                                    }
                                    n.close(inputStream);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    n.close(inputStream);
                                }
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new Comparator<String>() { // from class: com.baidu.adp.plugin.install.c.a.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    public int compare(String str3, String str4) {
                                        PluginStatus pluginStatus2 = (PluginStatus) hashMap.get(str3);
                                        PluginStatus pluginStatus3 = (PluginStatus) hashMap.get(str4);
                                        if (pluginStatus2 != null && pluginStatus3 != null) {
                                            return pluginStatus3.getPriority() - pluginStatus2.getPriority();
                                        }
                                        if (pluginStatus2 != null && pluginStatus3 == null) {
                                            return -1;
                                        }
                                        if (pluginStatus2 == null && pluginStatus3 != null) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                });
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        strArr2 = list;
                        BdLog.e(e);
                        return strArr2;
                    }
                }
                return list;
            } catch (Exception e5) {
                e = e5;
            }
        }

        private boolean cu(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.UZ) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public void onPostExecute(String[] strArr) {
            boolean z;
            super.onPostExecute(strArr);
            if (strArr == null || strArr.length <= 0) {
                z = false;
            } else {
                z = false;
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && cu(str) && c.this.l(this.mContext, "plugins/" + str, "install_from_start")) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.UG != null) {
                c.this.UG.onInstallFinish(c.this.UJ);
            }
        }
    }
}
