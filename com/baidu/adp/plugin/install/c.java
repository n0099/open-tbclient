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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private ArrayList<String> GW;
    private BroadcastReceiver GX;
    private com.baidu.adp.plugin.install.a GZ;
    private PluginInstallTask He;
    private PluginInstallTask Hg;
    private ServiceConnection Hi;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c Ha = null;
    private boolean GV = false;
    private boolean GY = false;
    private boolean Hb = true;
    private a Hc = null;
    private final Object Hd = new Object();
    private LinkedList<PluginInstallTask> Hf = new LinkedList<>();
    private LinkedList<PluginInstallTask> Hh = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.He != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Gq, c.this.He.Gq)) {
                        c.sHandler.removeCallbacks(c.this.Hl);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Hj = new Messenger(this.handler);
    private Runnable Hk = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.lo();
            c.this.ln();
        }
    };
    private Runnable Hl = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lq();
        }
    };
    private Runnable Hm = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.lr();
        }
    };
    private Runnable Hn = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.ls();
        }
    };

    public static c li() {
        if (Ha == null) {
            synchronized (c.class) {
                if (Ha == null) {
                    Ha = new c();
                }
            }
        }
        return Ha;
    }

    private c() {
        this.GW = null;
        this.GX = null;
        this.GW = new ArrayList<>();
        this.GX = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 135=6, 124=6, 125=5, 126=5, 127=5] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.He != null && TextUtils.equals(null, c.this.He.Gq)) {
                            c.this.lk();
                            c.this.He = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Hg == null || !TextUtils.equals(null, c.this.Hg.Gq)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.ll();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.lA().bz("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.He != null && TextUtils.equals(str, c.this.He.Gq)) {
                                    c.this.lk();
                                    c.this.He = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Hg == null || !TextUtils.equals(str, c.this.Hg.Gq)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.ll();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.lA().bz("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.mw().bX(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Hb = false;
                                }
                                c.this.d(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.mw().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.d(str, z);
                            }
                            if (c.this.He != null && TextUtils.equals(str, c.this.He.Gq)) {
                                c.this.lk();
                                c.this.He = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Hg == null || !TextUtils.equals(str, c.this.Hg.Gq)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.ll();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.lA().bz("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.He != null && TextUtils.equals(str, c.this.He.Gq)) {
                                c.this.lk();
                                c.this.He = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Hg == null || !TextUtils.equals(str, c.this.Hg.Gq)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.ll();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.lA().bz("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.He != null && TextUtils.equals(null, c.this.He.Gq)) {
                            c.this.lk();
                            c.this.He = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Hg == null || !TextUtils.equals(null, c.this.Hg.Gq)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.ll();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.lA().bz("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        lj();
    }

    public void l(String str, int i) {
        if (i == 1) {
            G(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, boolean z) {
        if (this.GW.contains(str)) {
            this.GW.remove(str);
        }
        if (!this.GY && z && this.GW.isEmpty()) {
            this.GY = true;
            if (this.GZ != null) {
                this.GZ.Q(this.Hb);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            lm();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.GZ = aVar;
        if (this.Hc != null) {
            this.Hc.cancel();
            this.Hc = null;
        }
        this.Hc = new a(context);
        this.Hc.setPriority(4);
        this.Hc.execute(new String[0]);
    }

    public boolean bv(String str) {
        if (this.He != null) {
            return TextUtils.equals(str, this.He.Gq);
        }
        if (this.Hg != null) {
            return TextUtils.equals(str, this.Hg.Gq);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [250=5, 251=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(Context context, String str) {
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
        PluginSetting bD = PluginPackageManager.lN().bD(substring);
        if (substring != null && substring.length() > 0 && bD != null && bD.apkPath != null) {
            File file = new File(bD.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f h = Util.h(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (h.compareTo(Util.h(inputStream)) == 0) {
                                if (this.GZ != null) {
                                    this.GZ.bt(substring);
                                }
                                com.baidu.adp.plugin.b.a.lA().f("plugin_install", "install_timeequals", substring, h.toString());
                                com.baidu.adp.lib.g.a.f(fileInputStream);
                                com.baidu.adp.lib.g.a.f(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.f(fileInputStream);
                            com.baidu.adp.lib.g.a.f(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.lA().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.f(fileInputStream);
                            com.baidu.adp.lib.g.a.f(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.lA().e("plugin_install", substring, bD);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mw().bY(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.f(fileInputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.f(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.lA().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.lA().e("plugin_install", substring, bD);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mw().bY(substring)));
        return true;
    }

    public void H(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            lj();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.GU = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.GU = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Gq = str2;
                if (a(pluginInstallTask) && z2) {
                    this.GW.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Gq = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(pluginInstallTask.Gq);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        com.baidu.adp.plugin.b.a.lA().f("plugin_install", "start_install_service", pluginInstallTask.Gq, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.Gq);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.lN().lO());
        if (pluginInstallTask.GR) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Hi == null && z) {
            this.Hi = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.lp();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.He != null && TextUtils.equals(stringExtra, c.this.He.Gq)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Hi, 1)) {
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

    public static File bw(String str) {
        PluginSetting bD = PluginPackageManager.lN().bD(str);
        if (bD == null || bD.apkPath == null || bD.apkPath.length() <= 0) {
            return null;
        }
        return new File(bD.apkPath);
    }

    private void lj() {
        if (!this.GV) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.GX, intentFilter);
                this.GV = true;
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
        synchronized (this.Hd) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Hf.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.He != null) {
                Iterator<PluginInstallTask> it = this.Hf.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Gq, next.Gq)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Hf.add(pluginInstallTask);
                }
                return true;
            }
            this.He = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                ln();
                sHandler.removeCallbacks(this.Hm);
                sHandler.postDelayed(this.Hm, this.He.lh());
                return true;
            }
            this.He = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Hd) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Hh.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Hg != null) {
                Iterator<PluginInstallTask> it = this.Hh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Gq, next.Gq)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Hh.add(pluginInstallTask);
                }
                return true;
            }
            this.Hg = pluginInstallTask;
            pluginInstallTask.GR = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Hn);
                sHandler.postDelayed(this.Hn, this.Hg.lh());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lk() {
        sHandler.removeCallbacks(this.Hk);
        sHandler.removeCallbacks(this.Hm);
        sHandler.removeCallbacks(this.Hl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ll() {
        this.Hg = null;
        sHandler.removeCallbacks(this.Hn);
    }

    private void lm() {
        if (this.Hi != null) {
            BdBaseApplication.getInst().unbindService(this.Hi);
            this.Hi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        sHandler.removeCallbacks(this.Hk);
        sHandler.postDelayed(this.Hk, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        if (this.messenger != null && this.He != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.He));
                message.replyTo = this.Hj;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Hl);
            sHandler.postDelayed(this.Hl, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp() {
        this.Hi = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lA().f("plugin_install", "system_kill_installprocess", this.He == null ? "" : this.He.Gq, this.Hf.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hh.size());
        lk();
        lw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq() {
        com.baidu.adp.plugin.b.a.lA().bz("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lA().f("plugin_install", "installprocess_noresponse", this.He == null ? "" : this.He.Gq, this.Hf.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hh.size());
        lk();
        lt();
        lw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr() {
        if (this.He != null) {
            com.baidu.adp.plugin.packageManager.status.a.mw().h(this.He.Gq, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.He;
        if (!lu()) {
            com.baidu.adp.plugin.b.a.lA().bz("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lA().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Gq, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lh())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hf.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hh.size());
        } else {
            com.baidu.adp.plugin.b.a.lA().bz("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lA().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Gq, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lh())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hf.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hh.size());
        }
        lk();
        lt();
        lw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        if (this.Hg != null) {
            com.baidu.adp.plugin.packageManager.status.a.mw().h(this.Hg.Gq, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lA().f("plugin_install", "timeout", this.Hg == null ? "" : this.Hg.Gq, "timeout-" + (this.Hg == null ? "" : Long.valueOf(this.Hg.lh())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hf.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hh.size());
        ll();
    }

    private void lt() {
        if (this.Hi != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Hi);
        }
        this.Hi = null;
        this.messenger = null;
        int lv = lv();
        if (lv > 0 && lv != Process.myPid()) {
            Process.killProcess(lv);
        }
    }

    private boolean lu() {
        return lv() > 0;
    }

    private int lv() {
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

    private void lw() {
        if (this.He != null) {
            com.baidu.adp.plugin.b.a.lA().B("plugin_retry_install", this.He.Gq);
            com.baidu.adp.plugin.b.a.lA().f("plugin_install", "plugin_retry_install", this.He.Gq, this.He.lh() + "");
            c(this.He);
            this.He = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Hp = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
        private Context mContext;

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
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
                                    n.f(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    n.f(inputStream);
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

        private boolean bx(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Hp) {
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
        /* renamed from: l */
        public void onPostExecute(String[] strArr) {
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && bx(str) && c.this.G(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.GZ != null) {
                c.this.GZ.Q(c.this.Hb);
            }
        }
    }
}
