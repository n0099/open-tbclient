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
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c um = null;
    private Messenger messenger;
    private ArrayList<String> uh;
    private BroadcastReceiver uj;
    private com.baidu.adp.plugin.install.a ul;
    private PluginInstallTask us;
    private PluginInstallTask uu;
    private ServiceConnection uw;
    private boolean ug = false;
    private boolean uk = false;
    private boolean uo = true;
    private a uq = null;
    private final Object ur = new Object();
    private LinkedList<PluginInstallTask> ut = new LinkedList<>();
    private LinkedList<PluginInstallTask> uv = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.us != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).pkgName, c.this.us.pkgName)) {
                        c.sHandler.removeCallbacks(c.this.uz);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger ux = new Messenger(this.handler);
    private Runnable uy = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.ii();
            c.this.ih();
        }
    };
    private Runnable uz = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.ik();
        }
    };
    private Runnable uA = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.il();
        }
    };
    private Runnable uB = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.im();
        }
    };

    public static c ic() {
        if (um == null) {
            synchronized (c.class) {
                if (um == null) {
                    um = new c();
                }
            }
        }
        return um;
    }

    private c() {
        this.uh = null;
        this.uj = null;
        this.uh = new ArrayList<>();
        this.uj = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.us != null && TextUtils.equals(null, c.this.us.pkgName)) {
                            c.this.ie();
                            c.this.us = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.uu == null || !TextUtils.equals(null, c.this.uu.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.m9if();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.iv().aI("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra(Constants.PACKAGE_NAME);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.us != null && TextUtils.equals(str, c.this.us.pkgName)) {
                                    c.this.ie();
                                    c.this.us = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.uu == null || !TextUtils.equals(str, c.this.uu.pkgName)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.m9if();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.iv().aI("plugin_retry_install_succ");
                                    return;
                                }
                            }
                            String stringExtra = intent.getStringExtra("install_src_file");
                            if (stringExtra != null && stringExtra.startsWith("assets://")) {
                                z = true;
                            }
                            String action = intent.getAction();
                            if ("com.baidu.adp.plugin.installed".equals(action)) {
                                c.this.c(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.jv().bg(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.uo = false;
                                }
                                c.this.c(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.jv().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.c(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.us != null && TextUtils.equals(str, c.this.us.pkgName)) {
                                c.this.ie();
                                c.this.us = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.uu == null || !TextUtils.equals(str, c.this.uu.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.m9if();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.iv().aI("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.us != null && TextUtils.equals(str, c.this.us.pkgName)) {
                                c.this.ie();
                                c.this.us = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.uu == null || !TextUtils.equals(str, c.this.uu.pkgName)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.m9if();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.iv().aI("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.us != null && TextUtils.equals(null, c.this.us.pkgName)) {
                            c.this.ie();
                            c.this.us = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.uu == null || !TextUtils.equals(null, c.this.uu.pkgName)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.m9if();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.iv().aI("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        id();
    }

    public void f(String str, int i) {
        if (i == 1) {
            E(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z) {
        if (this.uh.contains(str)) {
            this.uh.remove(str);
        }
        if (!this.uk && z && this.uh.isEmpty()) {
            this.uk = true;
            if (this.ul != null) {
                this.ul.J(this.uo);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_ALL_INSTALL));
            ig();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.ul = aVar;
        if (this.uq != null) {
            this.uq.cancel();
            this.uq = null;
        }
        this.uq = new a(context);
        this.uq.setPriority(4);
        this.uq.execute(new String[0]);
    }

    public boolean aE(String str) {
        if (this.us != null) {
            return TextUtils.equals(str, this.us.pkgName);
        }
        if (this.uu != null) {
            return TextUtils.equals(str, this.uu.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(Context context, String str) {
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
        PluginSetting aN = PluginPackageManager.iL().aN(substring);
        if (substring != null && substring.length() > 0 && aN != null && aN.apkPath != null) {
            File file = new File(aN.apkPath);
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
                                if (this.ul != null) {
                                    this.ul.aC(substring);
                                }
                                com.baidu.adp.plugin.b.a.iv().f("plugin_install", "install_timeequals", substring, g.toString());
                                com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.g.a.close(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.g.a.close(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.iv().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.g.a.close(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.iv().e("plugin_install", substring, aN);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.jv().bi(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                        com.baidu.adp.lib.g.a.close(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.g.a.close(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.iv().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.iv().e("plugin_install", substring, aN);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_START, com.baidu.adp.plugin.packageManager.status.a.jv().bi(substring)));
        return true;
    }

    public void F(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            id();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.uf = context.getAssets().open(str.substring("assets://".length())).available();
                } catch (IOException e) {
                    BdLog.detailException(e);
                }
                z2 = true;
                str2 = substring;
            } else if (!str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                str2 = null;
                z2 = false;
            } else {
                PackageManager packageManager = context.getPackageManager();
                String substring2 = str.substring(SkiaImageDecoder.FILE_PREFIX.length());
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring2, 0);
                if (packageArchiveInfo != null) {
                    str3 = packageArchiveInfo.packageName;
                }
                pluginInstallTask.uf = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.pkgName = str2;
                if (a(pluginInstallTask) && z2) {
                    this.uh.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jp().findPluginSetting(pluginInstallTask.pkgName);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.iv().f("plugin_install", "start_service_install_status_error", pluginInstallTask.pkgName, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring(SkiaImageDecoder.FILE_PREFIX.length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.iv().f("plugin_install", "start_service_file_not_find", pluginInstallTask.pkgName, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        com.baidu.adp.plugin.b.a.iv().f("plugin_install", "start_install_service", pluginInstallTask.pkgName, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra(Constants.PACKAGE_NAME, pluginInstallTask.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.iL().iM());
        if (pluginInstallTask.ue) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.uw == null && z) {
            this.uw = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.ij();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra(Constants.PACKAGE_NAME);
                    if (c.this.us != null && TextUtils.equals(stringExtra, c.this.us.pkgName)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.uw, 1)) {
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

    public static File aF(String str) {
        PluginSetting aN = PluginPackageManager.iL().aN(str);
        if (aN == null || aN.apkPath == null || aN.apkPath.length() <= 0) {
            return null;
        }
        return new File(aN.apkPath);
    }

    private void id() {
        if (!this.ug) {
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
                applicationContext.registerReceiver(this.uj, intentFilter);
                this.ug = true;
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
        synchronized (this.ur) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.ut.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.us != null) {
                Iterator<PluginInstallTask> it = this.ut.iterator();
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
                    this.ut.add(pluginInstallTask);
                }
                return true;
            }
            this.us = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                ih();
                sHandler.removeCallbacks(this.uA);
                sHandler.postDelayed(this.uA, this.us.ib());
                return true;
            }
            this.us = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.ur) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.uv.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.uu != null) {
                Iterator<PluginInstallTask> it = this.uv.iterator();
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
                    this.uv.add(pluginInstallTask);
                }
                return true;
            }
            this.uu = pluginInstallTask;
            pluginInstallTask.ue = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.uB);
                sHandler.postDelayed(this.uB, this.uu.ib());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie() {
        sHandler.removeCallbacks(this.uy);
        sHandler.removeCallbacks(this.uA);
        sHandler.removeCallbacks(this.uz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m9if() {
        this.uu = null;
        sHandler.removeCallbacks(this.uB);
    }

    private void ig() {
        if (this.uw != null) {
            BdBaseApplication.getInst().unbindService(this.uw);
            this.uw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih() {
        sHandler.removeCallbacks(this.uy);
        sHandler.postDelayed(this.uy, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        if (this.messenger != null && this.us != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.us));
                message.replyTo = this.ux;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.uz);
            sHandler.postDelayed(this.uz, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij() {
        this.uw = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.iv().f("plugin_install", "system_kill_installprocess", this.us == null ? "" : this.us.pkgName, this.ut.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.uv.size());
        ie();
        ir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik() {
        com.baidu.adp.plugin.b.a.iv().aI("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.iv().f("plugin_install", "installprocess_noresponse", this.us == null ? "" : this.us.pkgName, this.ut.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.uv.size());
        ie();
        in();
        ir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il() {
        if (this.us != null) {
            com.baidu.adp.plugin.packageManager.status.a.jv().h(this.us.pkgName, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.us;
        if (!ip()) {
            com.baidu.adp.plugin.b.a.iv().aI("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.iv().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.ib())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ut.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.uv.size());
        } else {
            com.baidu.adp.plugin.b.a.iv().aI("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.iv().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.pkgName, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.ib())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ut.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.uv.size());
        }
        ie();
        in();
        ir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im() {
        if (this.uu != null) {
            com.baidu.adp.plugin.packageManager.status.a.jv().h(this.uu.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.iv().f("plugin_install", "timeout", this.uu == null ? "" : this.uu.pkgName, "timeout-" + (this.uu == null ? "" : Long.valueOf(this.uu.ib())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ut.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.uv.size());
        m9if();
    }

    private void in() {
        if (this.uw != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.uw);
        }
        this.uw = null;
        this.messenger = null;
        int iq = iq();
        if (iq > 0 && iq != Process.myPid()) {
            Process.killProcess(iq);
        }
    }

    private boolean ip() {
        return iq() > 0;
    }

    private int iq() {
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

    private void ir() {
        if (this.us != null) {
            com.baidu.adp.plugin.b.a.iv().q("plugin_retry_install", this.us.pkgName);
            com.baidu.adp.plugin.b.a.iv().f("plugin_install", "plugin_retry_install", this.us.pkgName, this.us.ib() + "");
            c(this.us);
            this.us = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] uD = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

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
                                    JSONObject jSONObject = new JSONObject(new String(bArr, HTTP.UTF_8));
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

        private boolean aG(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.uD) {
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
                    if (str != null && str.endsWith(".apk") && aG(str) && c.this.E(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.ul != null) {
                c.this.ul.J(c.this.uo);
            }
        }
    }
}
