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
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.f;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
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
    private ArrayList<String> Dg;
    private BroadcastReceiver Dh;
    private com.baidu.adp.plugin.install.a Dj;
    private PluginInstallTask Do;
    private PluginInstallTask Dq;
    private ServiceConnection Ds;
    private Messenger messenger;
    private static Handler oA = new Handler(Looper.getMainLooper());
    private static volatile c Dk = null;
    private boolean Df = false;
    private boolean Di = false;
    private boolean Dl = true;
    private a Dm = null;
    private final Object Dn = new Object();
    private LinkedList<PluginInstallTask> Dp = new LinkedList<>();
    private LinkedList<PluginInstallTask> Dr = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Do != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).CC, c.this.Do.CC)) {
                        c.oA.removeCallbacks(c.this.Dv);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Dt = new Messenger(this.handler);
    private Runnable Du = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.iV();
            c.this.iU();
        }
    };
    private Runnable Dv = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.iX();
        }
    };
    private Runnable Dw = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.iY();
        }
    };
    private Runnable Dx = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.iZ();
        }
    };

    public static c iP() {
        if (Dk == null) {
            synchronized (c.class) {
                if (Dk == null) {
                    Dk = new c();
                }
            }
        }
        return Dk;
    }

    private c() {
        this.Dg = null;
        this.Dh = null;
        this.Dg = new ArrayList<>();
        this.Dh = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=6, 149=5, 150=5, 151=5, 152=5, 153=5, 154=5, 155=5, 156=5, 157=5, 159=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Do != null && TextUtils.equals(null, c.this.Do.CC)) {
                            c.this.iR();
                            c.this.Do = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Dq == null || !TextUtils.equals(null, c.this.Dq.CC)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.iS();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jh().bc("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Do != null && TextUtils.equals(str, c.this.Do.CC)) {
                                    c.this.iR();
                                    c.this.Do = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Dq == null || !TextUtils.equals(str, c.this.Dq.CC)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.iS();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.jh().bc("plugin_retry_install_succ");
                                    return;
                                }
                            }
                            String stringExtra = intent.getStringExtra("install_src_file");
                            if (stringExtra != null && stringExtra.startsWith("assets://")) {
                                z = true;
                            }
                            String action = intent.getAction();
                            if ("com.baidu.adp.plugin.installed".equals(action)) {
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.ke().bA(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Dl = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.ke().g(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            }
                            if (c.this.Do != null && TextUtils.equals(str, c.this.Do.CC)) {
                                c.this.iR();
                                c.this.Do = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Dq == null || !TextUtils.equals(str, c.this.Dq.CC)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iS();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jh().bc("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Do != null && TextUtils.equals(str, c.this.Do.CC)) {
                                c.this.iR();
                                c.this.Do = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Dq == null || !TextUtils.equals(str, c.this.Dq.CC)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iS();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jh().bc("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Do != null && TextUtils.equals(null, c.this.Do.CC)) {
                            c.this.iR();
                            c.this.Do = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Dq == null || !TextUtils.equals(null, c.this.Dq.CC)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.iS();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jh().bc("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        iQ();
    }

    public void l(String str, int i) {
        if (i == 1) {
            H(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.Dg.contains(str)) {
            this.Dg.remove(str);
        }
        if (!this.Di && z && this.Dg.isEmpty()) {
            this.Di = true;
            if (this.Dj != null) {
                this.Dj.L(this.Dl);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            iT();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Dj = aVar;
        if (this.Dm != null) {
            this.Dm.cancel();
            this.Dm = null;
        }
        this.Dm = new a(context);
        this.Dm.setPriority(4);
        this.Dm.execute(new String[0]);
    }

    public boolean aY(String str) {
        if (this.Do != null) {
            return TextUtils.equals(str, this.Do.CC);
        }
        if (this.Dq != null) {
            return TextUtils.equals(str, this.Dq.CC);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [272=5, 273=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(Context context, String str) {
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
        PluginSetting bg = PluginPackageManager.ju().bg(substring);
        if (substring != null && substring.length() > 0 && bg != null && bg.apkPath != null) {
            File file = new File(bg.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f l = Util.l(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (l.compareTo(Util.l(inputStream)) == 0) {
                                if (this.Dj != null) {
                                    this.Dj.aW(substring);
                                }
                                com.baidu.adp.plugin.b.a.jh().e("plugin_install", "install_timeequals", substring, l.toString());
                                com.baidu.adp.lib.g.a.j(fileInputStream);
                                com.baidu.adp.lib.g.a.j(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.j(fileInputStream);
                            com.baidu.adp.lib.g.a.j(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.jh().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.j(fileInputStream);
                            com.baidu.adp.lib.g.a.j(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.jh().e("plugin_install", substring, bg);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.ke().bB(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.j(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.jh().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.jh().e("plugin_install", substring, bg);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.ke().bB(substring)));
        return true;
    }

    public void I(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            iQ();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.De = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.De = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.CC = str2;
                if (a(pluginInstallTask) && z2) {
                    this.Dg.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.CC = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        boolean z = false;
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jX().findPluginSetting(pluginInstallTask.CC);
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.jh().e("plugin_install", "start_install_service", pluginInstallTask.CC, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.CC);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.ju().jv());
        if (pluginInstallTask.Dd) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Ds == null && z) {
            this.Ds = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.iW();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.Do != null && TextUtils.equals(stringExtra, c.this.Do.CC)) {
                        context.startService(intent);
                    }
                }
            };
            if (context.bindService(intent, this.Ds, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File aZ(String str) {
        PluginSetting bg = PluginPackageManager.ju().bg(str);
        if (bg == null || bg.apkPath == null || bg.apkPath.length() <= 0) {
            return null;
        }
        return new File(bg.apkPath);
    }

    private void iQ() {
        if (!this.Df) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.Dh, intentFilter);
                this.Df = true;
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
        synchronized (this.Dn) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Dp.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Do != null) {
                Iterator<PluginInstallTask> it = this.Dp.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.CC, next.CC)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dp.add(pluginInstallTask);
                }
                return true;
            }
            this.Do = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                iU();
                oA.removeCallbacks(this.Dw);
                oA.postDelayed(this.Dw, this.Do.iO());
                return true;
            }
            this.Do = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Dn) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Dr.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Dq != null) {
                Iterator<PluginInstallTask> it = this.Dr.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.CC, next.CC)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dr.add(pluginInstallTask);
                }
                return true;
            }
            this.Dq = pluginInstallTask;
            pluginInstallTask.Dd = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                oA.removeCallbacks(this.Dx);
                oA.postDelayed(this.Dx, this.Dq.iO());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        oA.removeCallbacks(this.Du);
        oA.removeCallbacks(this.Dw);
        oA.removeCallbacks(this.Dv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        this.Dq = null;
        oA.removeCallbacks(this.Dx);
    }

    private void iT() {
        if (this.Ds != null) {
            BdBaseApplication.getInst().unbindService(this.Ds);
            this.Ds = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU() {
        oA.removeCallbacks(this.Du);
        oA.postDelayed(this.Du, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV() {
        if (this.messenger != null && this.Do != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Do));
                message.replyTo = this.Dt;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oA.removeCallbacks(this.Dv);
            oA.postDelayed(this.Dv, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW() {
        this.Ds = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.jh().e("plugin_install", "system_kill_installprocess", this.Do == null ? "" : this.Do.CC, this.Dp.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dr.size());
        iR();
        jd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX() {
        com.baidu.adp.plugin.b.a.jh().bc("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.jh().e("plugin_install", "installprocess_noresponse", this.Do == null ? "" : this.Do.CC, this.Dp.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dr.size());
        iR();
        ja();
        jd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY() {
        if (this.Do != null) {
            com.baidu.adp.plugin.packageManager.status.a.ke().g(this.Do.CC, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Do;
        if (!jb()) {
            com.baidu.adp.plugin.b.a.jh().bc("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.jh().e("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.CC, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iO())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dp.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dr.size());
        } else {
            com.baidu.adp.plugin.b.a.jh().bc("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.jh().e("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.CC, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iO())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dp.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dr.size());
        }
        iR();
        ja();
        jd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        if (this.Dq != null) {
            com.baidu.adp.plugin.packageManager.status.a.ke().g(this.Dq.CC, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.jh().e("plugin_install", "timeout", this.Dq == null ? "" : this.Dq.CC, "timeout-" + (this.Dq == null ? "" : Long.valueOf(this.Dq.iO())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dp.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dr.size());
        iS();
    }

    private void ja() {
        if (this.Ds != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Ds);
        }
        this.Ds = null;
        this.messenger = null;
        int jc = jc();
        if (jc > 0 && jc != Process.myPid()) {
            Process.killProcess(jc);
        }
    }

    private boolean jb() {
        return jc() > 0;
    }

    private int jc() {
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
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.pid;
                    }
                }
            }
        }
        return ExploreByTouchHelper.INVALID_ID;
    }

    private void jd() {
        if (this.Do != null) {
            com.baidu.adp.plugin.b.a.jh().B("plugin_retry_install", this.Do.CC);
            com.baidu.adp.plugin.b.a.jh().e("plugin_install", "plugin_retry_install", this.Do.CC, this.Do.iO() + "");
            c(this.Do);
            this.Do = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Dz = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
        private Context mContext;

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
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
                                    m.j(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    m.j(inputStream);
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

        private boolean ba(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Dz) {
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
        /* renamed from: m */
        public void onPostExecute(String[] strArr) {
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && ba(str) && c.this.H(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.Dj != null) {
                c.this.Dj.L(c.this.Dl);
            }
        }
    }
}
