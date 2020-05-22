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
    private com.baidu.adp.plugin.install.a QC;
    private PluginInstallTask QH;
    private PluginInstallTask QJ;
    private ServiceConnection QL;
    private ArrayList<String> Qy;
    private BroadcastReceiver Qz;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c QD = null;
    private boolean Qx = false;
    private boolean QB = false;
    private boolean QE = true;
    private a QF = null;
    private final Object QG = new Object();
    private LinkedList<PluginInstallTask> QI = new LinkedList<>();
    private LinkedList<PluginInstallTask> QK = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.QH != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).pkgName, c.this.QH.pkgName)) {
                        c.sHandler.removeCallbacks(c.this.QO);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger QM = new Messenger(this.handler);
    private Runnable QN = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.nv();
            c.this.nu();
        }
    };
    private Runnable QO = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.nx();
        }
    };
    private Runnable QP = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.ny();
        }
    };
    private Runnable QR = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.nz();
        }
    };

    public static c np() {
        if (QD == null) {
            synchronized (c.class) {
                if (QD == null) {
                    QD = new c();
                }
            }
        }
        return QD;
    }

    private c() {
        this.Qy = null;
        this.Qz = null;
        this.Qy = new ArrayList<>();
        this.Qz = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.QH != null && TextUtils.equals(null, c.this.QH.pkgName)) {
                            c.this.nr();
                            c.this.QH = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.QJ == null || !TextUtils.equals(null, c.this.QJ.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.ns();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.nH().log("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.QH != null && TextUtils.equals(str, c.this.QH.pkgName)) {
                                    c.this.nr();
                                    c.this.QH = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.QJ == null || !TextUtils.equals(str, c.this.QJ.pkgName)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.ns();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.nH().log("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.oG().cJ(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.QE = false;
                                }
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.oG().j(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.h(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.QH != null && TextUtils.equals(str, c.this.QH.pkgName)) {
                                c.this.nr();
                                c.this.QH = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.QJ == null || !TextUtils.equals(str, c.this.QJ.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.ns();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.nH().log("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.QH != null && TextUtils.equals(str, c.this.QH.pkgName)) {
                                c.this.nr();
                                c.this.QH = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.QJ == null || !TextUtils.equals(str, c.this.QJ.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.ns();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.nH().log("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.QH != null && TextUtils.equals(null, c.this.QH.pkgName)) {
                            c.this.nr();
                            c.this.QH = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.QJ == null || !TextUtils.equals(null, c.this.QJ.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.ns();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.nH().log("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        nq();
    }

    public void m(String str, int i) {
        if (i == 1) {
            l(BdBaseApplication.getInst(), "plugins/" + str + ".apk", "install_from_rollback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.Qy.contains(str)) {
            this.Qy.remove(str);
        }
        if (!this.QB && z && this.Qy.isEmpty()) {
            this.QB = true;
            if (this.QC != null) {
                this.QC.onInstallFinish(this.QE);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_ALL_INSTALL));
            nt();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.QC = aVar;
        if (this.QF != null) {
            this.QF.cancel();
            this.QF = null;
        }
        this.QF = new a(context);
        this.QF.setPriority(4);
        this.QF.execute(new String[0]);
    }

    public boolean cj(String str) {
        if (this.QH != null) {
            return TextUtils.equals(str, this.QH.pkgName);
        }
        if (this.QJ != null) {
            return TextUtils.equals(str, this.QJ.pkgName);
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
        PluginSetting cr = PluginPackageManager.nX().cr(substring);
        if (substring != null && substring.length() > 0 && cr != null && cr.apkPath != null) {
            File file = new File(cr.apkPath);
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
                                if (this.QC != null) {
                                    this.QC.ch(substring);
                                }
                                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "install_timeequals", substring, g.toString());
                                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.f.a.close(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.nH().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.nH().a("plugin_install", substring, cr, str2);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.oG().cL(substring)));
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
                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.nH().a("plugin_install", substring, cr, str2);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.oG().cL(substring)));
        return true;
    }

    public void w(Context context, String str) {
        c(context, "file://" + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            nq();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.Qw = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.Qw = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.pkgName = str2;
                if (a(pluginInstallTask) && z2) {
                    this.Qy.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(pluginInstallTask.pkgName);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("file://")) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "start_service_install_status_error", pluginInstallTask.pkgName, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring("file://".length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.nH().f("plugin_install", "start_service_file_not_find", pluginInstallTask.pkgName, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        String str = "f" + System.currentTimeMillis();
        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "start_install_service", pluginInstallTask.pkgName, "flag=" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.pkgName);
        intent.putExtra("install_flag", str);
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.nX().nY());
        if (pluginInstallTask.Qv) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.QL == null && z) {
            this.QL = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.nw();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.QH != null && TextUtils.equals(stringExtra, c.this.QH.pkgName)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.QL, 1)) {
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

    public static File ck(String str) {
        PluginSetting cr = PluginPackageManager.nX().cr(str);
        if (cr == null || cr.apkPath == null || cr.apkPath.length() <= 0) {
            return null;
        }
        return new File(cr.apkPath);
    }

    private void nq() {
        if (!this.Qx) {
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
                applicationContext.registerReceiver(this.Qz, intentFilter);
                this.Qx = true;
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
        synchronized (this.QG) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.QI.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.QH != null) {
                Iterator<PluginInstallTask> it = this.QI.iterator();
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
                    this.QI.add(pluginInstallTask);
                }
                return true;
            }
            this.QH = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                nu();
                sHandler.removeCallbacks(this.QP);
                sHandler.postDelayed(this.QP, this.QH.getTimeout());
                return true;
            }
            this.QH = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.QG) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.QK.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.QJ != null) {
                Iterator<PluginInstallTask> it = this.QK.iterator();
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
                    this.QK.add(pluginInstallTask);
                }
                return true;
            }
            this.QJ = pluginInstallTask;
            pluginInstallTask.Qv = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.QR);
                sHandler.postDelayed(this.QR, this.QJ.getTimeout());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        sHandler.removeCallbacks(this.QN);
        sHandler.removeCallbacks(this.QP);
        sHandler.removeCallbacks(this.QO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns() {
        this.QJ = null;
        sHandler.removeCallbacks(this.QR);
    }

    private void nt() {
        if (this.QL != null) {
            BdBaseApplication.getInst().unbindService(this.QL);
            this.QL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        sHandler.removeCallbacks(this.QN);
        sHandler.postDelayed(this.QN, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv() {
        if (this.messenger != null && this.QH != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.QH));
                message.replyTo = this.QM;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.QO);
            sHandler.postDelayed(this.QO, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
        this.QL = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "system_kill_installprocess", this.QH == null ? "" : this.QH.pkgName, this.QI.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QK.size());
        nr();
        nD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx() {
        com.baidu.adp.plugin.b.a.nH().log("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "installprocess_noresponse", this.QH == null ? "" : this.QH.pkgName, this.QI.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QK.size());
        nr();
        nA();
        nD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        if (this.QH != null) {
            com.baidu.adp.plugin.packageManager.status.a.oG().j(this.QH.pkgName, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.QH;
        if (!nB()) {
            com.baidu.adp.plugin.b.a.nH().log("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.nH().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QI.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QK.size());
        } else {
            com.baidu.adp.plugin.b.a.nH().log("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.nH().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QI.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QK.size());
        }
        nr();
        nA();
        nD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz() {
        if (this.QJ != null) {
            com.baidu.adp.plugin.packageManager.status.a.oG().j(this.QJ.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "timeout", this.QJ == null ? "" : this.QJ.pkgName, "timeout-" + (this.QJ == null ? "" : Long.valueOf(this.QJ.getTimeout())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QI.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.QK.size());
        ns();
    }

    private void nA() {
        if (this.QL != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.QL);
        }
        this.QL = null;
        this.messenger = null;
        int nC = nC();
        if (nC > 0 && nC != Process.myPid()) {
            Process.killProcess(nC);
        }
    }

    private boolean nB() {
        return nC() > 0;
    }

    private int nC() {
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

    private void nD() {
        if (this.QH != null) {
            com.baidu.adp.plugin.b.a.nH().D("plugin_retry_install", this.QH.pkgName);
            com.baidu.adp.plugin.b.a.nH().f("plugin_install", "plugin_retry_install", this.QH.pkgName, this.QH.getTimeout() + "");
            c(this.QH);
            this.QH = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] QT = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean cl(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.QT) {
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
                    if (str != null && str.endsWith(".apk") && cl(str) && c.this.l(this.mContext, "plugins/" + str, "install_from_start")) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.QC != null) {
                c.this.QC.onInstallFinish(c.this.QE);
            }
        }
    }
}
