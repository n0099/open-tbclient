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
    private ArrayList<String> Tm;
    private BroadcastReceiver Tn;
    private com.baidu.adp.plugin.install.a Tp;
    private PluginInstallTask Tu;
    private PluginInstallTask Tw;
    private ServiceConnection Ty;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c Tq = null;
    private boolean Tl = false;
    private boolean To = false;
    private boolean Tr = true;
    private a Ts = null;
    private final Object Tt = new Object();
    private LinkedList<PluginInstallTask> Tv = new LinkedList<>();
    private LinkedList<PluginInstallTask> Tx = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Tu != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).pkgName, c.this.Tu.pkgName)) {
                        c.sHandler.removeCallbacks(c.this.TB);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Tz = new Messenger(this.handler);
    private Runnable TA = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.oU();
            c.this.oT();
        }
    };
    private Runnable TB = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.oW();
        }
    };
    private Runnable TC = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.oX();
        }
    };
    private Runnable TD = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.oY();
        }
    };

    public static c oO() {
        if (Tq == null) {
            synchronized (c.class) {
                if (Tq == null) {
                    Tq = new c();
                }
            }
        }
        return Tq;
    }

    private c() {
        this.Tm = null;
        this.Tn = null;
        this.Tm = new ArrayList<>();
        this.Tn = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Tu != null && TextUtils.equals(null, c.this.Tu.pkgName)) {
                            c.this.oQ();
                            c.this.Tu = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Tw == null || !TextUtils.equals(null, c.this.Tw.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.oR();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.pg().log("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Tu != null && TextUtils.equals(str, c.this.Tu.pkgName)) {
                                    c.this.oQ();
                                    c.this.Tu = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Tw == null || !TextUtils.equals(str, c.this.Tw.pkgName)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.oR();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.pg().log("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.qf().cO(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Tr = false;
                                }
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.qf().j(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.h(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.Tu != null && TextUtils.equals(str, c.this.Tu.pkgName)) {
                                c.this.oQ();
                                c.this.Tu = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Tw == null || !TextUtils.equals(str, c.this.Tw.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.oR();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.pg().log("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Tu != null && TextUtils.equals(str, c.this.Tu.pkgName)) {
                                c.this.oQ();
                                c.this.Tu = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Tw == null || !TextUtils.equals(str, c.this.Tw.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.oR();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.pg().log("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Tu != null && TextUtils.equals(null, c.this.Tu.pkgName)) {
                            c.this.oQ();
                            c.this.Tu = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Tw == null || !TextUtils.equals(null, c.this.Tw.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.oR();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.pg().log("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        oP();
    }

    public void n(String str, int i) {
        if (i == 1) {
            l(BdBaseApplication.getInst(), "plugins/" + str + ".apk", "install_from_rollback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.Tm.contains(str)) {
            this.Tm.remove(str);
        }
        if (!this.To && z && this.Tm.isEmpty()) {
            this.To = true;
            if (this.Tp != null) {
                this.Tp.onInstallFinish(this.Tr);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_ALL_INSTALL));
            oS();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Tp = aVar;
        if (this.Ts != null) {
            this.Ts.cancel();
            this.Ts = null;
        }
        this.Ts = new a(context);
        this.Ts.setPriority(4);
        this.Ts.execute(new String[0]);
    }

    public boolean co(String str) {
        if (this.Tu != null) {
            return TextUtils.equals(str, this.Tu.pkgName);
        }
        if (this.Tw != null) {
            return TextUtils.equals(str, this.Tw.pkgName);
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
        PluginSetting cw = PluginPackageManager.px().cw(substring);
        if (substring != null && substring.length() > 0 && cw != null && cw.apkPath != null) {
            File file = new File(cw.apkPath);
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
                                if (this.Tp != null) {
                                    this.Tp.cm(substring);
                                }
                                com.baidu.adp.plugin.b.a.pg().f("plugin_install", "install_timeequals", substring, g.toString());
                                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.f.a.close(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.pg().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.pg().a("plugin_install", substring, cw, str2);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.qf().cQ(substring)));
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
                com.baidu.adp.plugin.b.a.pg().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.pg().a("plugin_install", substring, cw, str2);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.qf().cQ(substring)));
        return true;
    }

    public void w(Context context, String str) {
        c(context, "file://" + str, false);
    }

    private void c(Context context, String str, boolean z) {
        boolean z2 = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            oP();
            String str2 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z2 = true;
                try {
                    pluginInstallTask.Tk = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.Tk = new File(substring2).length();
            }
            if (str2 != null) {
                pluginInstallTask.pkgName = str2;
                if (a(pluginInstallTask) && z2) {
                    this.Tm.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pZ().findPluginSetting(pluginInstallTask.pkgName);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("file://")) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.pg().f("plugin_install", "start_service_install_status_error", pluginInstallTask.pkgName, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring("file://".length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.pg().f("plugin_install", "start_service_file_not_find", pluginInstallTask.pkgName, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        String str = "f" + System.currentTimeMillis();
        com.baidu.adp.plugin.b.a.pg().f("plugin_install", "start_install_service", pluginInstallTask.pkgName, "flag=" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.pkgName);
        intent.putExtra("install_flag", str);
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.px().py());
        if (pluginInstallTask.Tj) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Ty == null && z) {
            this.Ty = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.oV();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.Tu != null && TextUtils.equals(stringExtra, c.this.Tu.pkgName)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Ty, 1)) {
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

    public static File cp(String str) {
        PluginSetting cw = PluginPackageManager.px().cw(str);
        if (cw == null || cw.apkPath == null || cw.apkPath.length() <= 0) {
            return null;
        }
        return new File(cw.apkPath);
    }

    private void oP() {
        if (!this.Tl) {
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
                applicationContext.registerReceiver(this.Tn, intentFilter);
                this.Tl = true;
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
        synchronized (this.Tt) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Tv.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Tu != null) {
                Iterator<PluginInstallTask> it = this.Tv.iterator();
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
                    this.Tv.add(pluginInstallTask);
                }
                return true;
            }
            this.Tu = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                oT();
                sHandler.removeCallbacks(this.TC);
                sHandler.postDelayed(this.TC, this.Tu.oN());
                return true;
            }
            this.Tu = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Tt) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Tx.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Tw != null) {
                Iterator<PluginInstallTask> it = this.Tx.iterator();
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
                    this.Tx.add(pluginInstallTask);
                }
                return true;
            }
            this.Tw = pluginInstallTask;
            pluginInstallTask.Tj = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.TD);
                sHandler.postDelayed(this.TD, this.Tw.oN());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ() {
        sHandler.removeCallbacks(this.TA);
        sHandler.removeCallbacks(this.TC);
        sHandler.removeCallbacks(this.TB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR() {
        this.Tw = null;
        sHandler.removeCallbacks(this.TD);
    }

    private void oS() {
        if (this.Ty != null) {
            BdBaseApplication.getInst().unbindService(this.Ty);
            this.Ty = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oT() {
        sHandler.removeCallbacks(this.TA);
        sHandler.postDelayed(this.TA, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU() {
        if (this.messenger != null && this.Tu != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Tu));
                message.replyTo = this.Tz;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.TB);
            sHandler.postDelayed(this.TB, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV() {
        this.Ty = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.pg().f("plugin_install", "system_kill_installprocess", this.Tu == null ? "" : this.Tu.pkgName, this.Tv.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tx.size());
        oQ();
        pc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW() {
        com.baidu.adp.plugin.b.a.pg().log("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.pg().f("plugin_install", "installprocess_noresponse", this.Tu == null ? "" : this.Tu.pkgName, this.Tv.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tx.size());
        oQ();
        oZ();
        pc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oX() {
        if (this.Tu != null) {
            com.baidu.adp.plugin.packageManager.status.a.qf().j(this.Tu.pkgName, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Tu;
        if (!pa()) {
            com.baidu.adp.plugin.b.a.pg().log("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.pg().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.oN())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tv.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tx.size());
        } else {
            com.baidu.adp.plugin.b.a.pg().log("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.pg().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.oN())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tv.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tx.size());
        }
        oQ();
        oZ();
        pc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY() {
        if (this.Tw != null) {
            com.baidu.adp.plugin.packageManager.status.a.qf().j(this.Tw.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.pg().f("plugin_install", "timeout", this.Tw == null ? "" : this.Tw.pkgName, "timeout-" + (this.Tw == null ? "" : Long.valueOf(this.Tw.oN())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tv.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tx.size());
        oR();
    }

    private void oZ() {
        if (this.Ty != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Ty);
        }
        this.Ty = null;
        this.messenger = null;
        int pb = pb();
        if (pb > 0 && pb != Process.myPid()) {
            Process.killProcess(pb);
        }
    }

    private boolean pa() {
        return pb() > 0;
    }

    private int pb() {
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

    private void pc() {
        if (this.Tu != null) {
            com.baidu.adp.plugin.b.a.pg().D("plugin_retry_install", this.Tu.pkgName);
            com.baidu.adp.plugin.b.a.pg().f("plugin_install", "plugin_retry_install", this.Tu.pkgName, this.Tu.oN() + "");
            c(this.Tu);
            this.Tu = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] TG = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean cq(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.TG) {
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
                    if (str != null && str.endsWith(".apk") && cq(str) && c.this.l(this.mContext, "plugins/" + str, "install_from_start")) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.Tp != null) {
                c.this.Tp.onInstallFinish(c.this.Tr);
            }
        }
    }
}
