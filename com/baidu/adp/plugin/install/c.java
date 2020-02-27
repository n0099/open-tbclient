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
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c xm = null;
    private Messenger messenger;
    private ArrayList<String> xi;
    private BroadcastReceiver xj;
    private com.baidu.adp.plugin.install.a xl;
    private PluginInstallTask xq;
    private PluginInstallTask xs;
    private ServiceConnection xu;
    private boolean xh = false;
    private boolean xk = false;
    private boolean xn = true;
    private a xo = null;
    private final Object xp = new Object();
    private LinkedList<PluginInstallTask> xr = new LinkedList<>();
    private LinkedList<PluginInstallTask> xt = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.xq != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).pkgName, c.this.xq.pkgName)) {
                        c.sHandler.removeCallbacks(c.this.xx);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger xv = new Messenger(this.handler);
    private Runnable xw = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.iQ();
            c.this.iP();
        }
    };
    private Runnable xx = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.iS();
        }
    };
    private Runnable xy = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.iT();
        }
    };
    private Runnable xz = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.iU();
        }
    };

    public static c iK() {
        if (xm == null) {
            synchronized (c.class) {
                if (xm == null) {
                    xm = new c();
                }
            }
        }
        return xm;
    }

    private c() {
        this.xi = null;
        this.xj = null;
        this.xi = new ArrayList<>();
        this.xj = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.xq != null && TextUtils.equals(null, c.this.xq.pkgName)) {
                            c.this.iM();
                            c.this.xq = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.xs == null || !TextUtils.equals(null, c.this.xs.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.iN();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jc().log("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.xq != null && TextUtils.equals(str, c.this.xq.pkgName)) {
                                    c.this.iM();
                                    c.this.xq = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.xs == null || !TextUtils.equals(str, c.this.xs.pkgName)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.iN();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.jc().log("plugin_retry_install_succ");
                                    return;
                                }
                            }
                            String stringExtra = intent.getStringExtra("install_src_file");
                            if (stringExtra != null && stringExtra.startsWith("assets://")) {
                                z = true;
                            }
                            String action = intent.getAction();
                            if ("com.baidu.adp.plugin.installed".equals(action)) {
                                c.this.d(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.kb().bs(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.xn = false;
                                }
                                c.this.d(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.kb().j(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.d(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.xq != null && TextUtils.equals(str, c.this.xq.pkgName)) {
                                c.this.iM();
                                c.this.xq = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.xs == null || !TextUtils.equals(str, c.this.xs.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iN();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jc().log("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.xq != null && TextUtils.equals(str, c.this.xq.pkgName)) {
                                c.this.iM();
                                c.this.xq = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.xs == null || !TextUtils.equals(str, c.this.xs.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iN();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jc().log("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.xq != null && TextUtils.equals(null, c.this.xq.pkgName)) {
                            c.this.iM();
                            c.this.xq = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.xs == null || !TextUtils.equals(null, c.this.xs.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.iN();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jc().log("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        iL();
    }

    public void i(String str, int i) {
        if (i == 1) {
            j(BdBaseApplication.getInst(), "plugins/" + str + ".apk", "install_from_rollback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, boolean z) {
        if (this.xi.contains(str)) {
            this.xi.remove(str);
        }
        if (!this.xk && z && this.xi.isEmpty()) {
            this.xk = true;
            if (this.xl != null) {
                this.xl.onInstallFinish(this.xn);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_ALL_INSTALL));
            iO();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.xl = aVar;
        if (this.xo != null) {
            this.xo.cancel();
            this.xo = null;
        }
        this.xo = new a(context);
        this.xo.setPriority(4);
        this.xo.execute(new String[0]);
    }

    public boolean aT(String str) {
        if (this.xq != null) {
            return TextUtils.equals(str, this.xq.pkgName);
        }
        if (this.xs != null) {
            return TextUtils.equals(str, this.xs.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(Context context, String str, String str2) {
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
        PluginSetting bb = PluginPackageManager.js().bb(substring);
        if (substring != null && substring.length() > 0 && bb != null && bb.apkPath != null) {
            File file = new File(bb.apkPath);
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
                                if (this.xl != null) {
                                    this.xl.aR(substring);
                                }
                                com.baidu.adp.plugin.b.a.jc().f("plugin_install", "install_timeequals", substring, g.toString());
                                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.f.a.close(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.jc().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.jc().a("plugin_install", substring, bb, str2);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.kb().bu(substring)));
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
                com.baidu.adp.plugin.b.a.jc().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.jc().a("plugin_install", substring, bb, str2);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.kb().bu(substring)));
        return true;
    }

    public void I(Context context, String str) {
        c(context, "file://" + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            iL();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.xg = context.getAssets().open(str.substring("assets://".length())).available();
                } catch (IOException e) {
                    BdLog.detailException(e);
                }
                z2 = true;
                str2 = substring;
            } else if (!str.startsWith("file://")) {
                str2 = null;
                z2 = false;
            } else {
                PackageManager packageManager = context.getPackageManager();
                String substring2 = str.substring("file://".length());
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring2, 0);
                if (packageArchiveInfo != null) {
                    str3 = packageArchiveInfo.packageName;
                }
                pluginInstallTask.xg = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.pkgName = str2;
                if (a(pluginInstallTask) && z2) {
                    this.xi.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jV().findPluginSetting(pluginInstallTask.pkgName);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("file://")) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.jc().f("plugin_install", "start_service_install_status_error", pluginInstallTask.pkgName, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring("file://".length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.jc().f("plugin_install", "start_service_file_not_find", pluginInstallTask.pkgName, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        String str = "f" + System.currentTimeMillis();
        com.baidu.adp.plugin.b.a.jc().f("plugin_install", "start_install_service", pluginInstallTask.pkgName, "flag=" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.pkgName);
        intent.putExtra("install_flag", str);
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.js().jt());
        if (pluginInstallTask.xf) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.xu == null && z) {
            this.xu = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.iR();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.xq != null && TextUtils.equals(stringExtra, c.this.xq.pkgName)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.xu, 1)) {
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

    public static File aU(String str) {
        PluginSetting bb = PluginPackageManager.js().bb(str);
        if (bb == null || bb.apkPath == null || bb.apkPath.length() <= 0) {
            return null;
        }
        return new File(bb.apkPath);
    }

    private void iL() {
        if (!this.xh) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
                if (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().equals("oppo")) {
                    intentFilter.setPriority(1000);
                }
                applicationContext.registerReceiver(this.xj, intentFilter);
                this.xh = true;
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
        synchronized (this.xp) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.xr.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.xq != null) {
                Iterator<PluginInstallTask> it = this.xr.iterator();
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
                    this.xr.add(pluginInstallTask);
                }
                return true;
            }
            this.xq = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                iP();
                sHandler.removeCallbacks(this.xy);
                sHandler.postDelayed(this.xy, this.xq.getTimeout());
                return true;
            }
            this.xq = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.xp) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.xt.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.xs != null) {
                Iterator<PluginInstallTask> it = this.xt.iterator();
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
                    this.xt.add(pluginInstallTask);
                }
                return true;
            }
            this.xs = pluginInstallTask;
            pluginInstallTask.xf = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.xz);
                sHandler.postDelayed(this.xz, this.xs.getTimeout());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM() {
        sHandler.removeCallbacks(this.xw);
        sHandler.removeCallbacks(this.xy);
        sHandler.removeCallbacks(this.xx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iN() {
        this.xs = null;
        sHandler.removeCallbacks(this.xz);
    }

    private void iO() {
        if (this.xu != null) {
            BdBaseApplication.getInst().unbindService(this.xu);
            this.xu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        sHandler.removeCallbacks(this.xw);
        sHandler.postDelayed(this.xw, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ() {
        if (this.messenger != null && this.xq != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.xq));
                message.replyTo = this.xv;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.xx);
            sHandler.postDelayed(this.xx, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        this.xu = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.jc().f("plugin_install", "system_kill_installprocess", this.xq == null ? "" : this.xq.pkgName, this.xr.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xt.size());
        iM();
        iY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        com.baidu.adp.plugin.b.a.jc().log("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.jc().f("plugin_install", "installprocess_noresponse", this.xq == null ? "" : this.xq.pkgName, this.xr.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xt.size());
        iM();
        iV();
        iY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        if (this.xq != null) {
            com.baidu.adp.plugin.packageManager.status.a.kb().j(this.xq.pkgName, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.xq;
        if (!iW()) {
            com.baidu.adp.plugin.b.a.jc().log("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.jc().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xr.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xt.size());
        } else {
            com.baidu.adp.plugin.b.a.jc().log("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.jc().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xr.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xt.size());
        }
        iM();
        iV();
        iY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU() {
        if (this.xs != null) {
            com.baidu.adp.plugin.packageManager.status.a.kb().j(this.xs.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.jc().f("plugin_install", "timeout", this.xs == null ? "" : this.xs.pkgName, "timeout-" + (this.xs == null ? "" : Long.valueOf(this.xs.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xr.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xt.size());
        iN();
    }

    private void iV() {
        if (this.xu != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.xu);
        }
        this.xu = null;
        this.messenger = null;
        int iX = iX();
        if (iX > 0 && iX != Process.myPid()) {
            Process.killProcess(iX);
        }
    }

    private boolean iW() {
        return iX() > 0;
    }

    private int iX() {
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

    private void iY() {
        if (this.xq != null) {
            com.baidu.adp.plugin.b.a.jc().z("plugin_retry_install", this.xq.pkgName);
            com.baidu.adp.plugin.b.a.jc().f("plugin_install", "plugin_retry_install", this.xq.pkgName, this.xq.getTimeout() + "");
            c(this.xq);
            this.xq = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] xB = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String[] doInBackground(String... strArr) {
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
                            } catch (IOException e) {
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
                                } catch (Exception e2) {
                                    e2.printStackTrace();
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
                    } catch (Exception e3) {
                        strArr2 = list;
                        e = e3;
                        BdLog.e(e);
                        return strArr2;
                    }
                }
                return list;
            } catch (Exception e4) {
                e = e4;
            }
        }

        private boolean aV(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.xB) {
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
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && aV(str) && c.this.j(this.mContext, "plugins/" + str, "install_from_start")) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.xl != null) {
                c.this.xl.onInstallFinish(c.this.xn);
            }
        }
    }
}
