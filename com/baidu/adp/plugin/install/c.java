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
    private ArrayList<String> GZ;
    private BroadcastReceiver Ha;
    private com.baidu.adp.plugin.install.a Hc;
    private PluginInstallTask Hh;
    private PluginInstallTask Hj;
    private ServiceConnection Hl;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c Hd = null;
    private boolean GY = false;
    private boolean Hb = false;
    private boolean He = true;
    private a Hf = null;
    private final Object Hg = new Object();
    private LinkedList<PluginInstallTask> Hi = new LinkedList<>();
    private LinkedList<PluginInstallTask> Hk = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Hh != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Gs, c.this.Hh.Gs)) {
                        c.sHandler.removeCallbacks(c.this.Ho);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Hm = new Messenger(this.handler);
    private Runnable Hn = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.lm();
            c.this.ll();
        }
    };
    private Runnable Ho = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lo();
        }
    };
    private Runnable Hp = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.lp();
        }
    };
    private Runnable Hq = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.lq();
        }
    };

    public static c lg() {
        if (Hd == null) {
            synchronized (c.class) {
                if (Hd == null) {
                    Hd = new c();
                }
            }
        }
        return Hd;
    }

    private c() {
        this.GZ = null;
        this.Ha = null;
        this.GZ = new ArrayList<>();
        this.Ha = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 135=6, 124=6, 125=5, 126=5, 127=5] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Hh != null && TextUtils.equals(null, c.this.Hh.Gs)) {
                            c.this.li();
                            c.this.Hh = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Hj == null || !TextUtils.equals(null, c.this.Hj.Gs)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.lj();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.ly().by("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Hh != null && TextUtils.equals(str, c.this.Hh.Gs)) {
                                    c.this.li();
                                    c.this.Hh = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Hj == null || !TextUtils.equals(str, c.this.Hj.Gs)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.lj();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.ly().by("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.mu().bW(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.He = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.mu().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            }
                            if (c.this.Hh != null && TextUtils.equals(str, c.this.Hh.Gs)) {
                                c.this.li();
                                c.this.Hh = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Hj == null || !TextUtils.equals(str, c.this.Hj.Gs)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lj();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.ly().by("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Hh != null && TextUtils.equals(str, c.this.Hh.Gs)) {
                                c.this.li();
                                c.this.Hh = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Hj == null || !TextUtils.equals(str, c.this.Hj.Gs)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lj();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.ly().by("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Hh != null && TextUtils.equals(null, c.this.Hh.Gs)) {
                            c.this.li();
                            c.this.Hh = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Hj == null || !TextUtils.equals(null, c.this.Hj.Gs)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.lj();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.ly().by("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        lh();
    }

    public void l(String str, int i) {
        if (i == 1) {
            F(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.GZ.contains(str)) {
            this.GZ.remove(str);
        }
        if (!this.Hb && z && this.GZ.isEmpty()) {
            this.Hb = true;
            if (this.Hc != null) {
                this.Hc.R(this.He);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            lk();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Hc = aVar;
        if (this.Hf != null) {
            this.Hf.cancel();
            this.Hf = null;
        }
        this.Hf = new a(context);
        this.Hf.setPriority(4);
        this.Hf.execute(new String[0]);
    }

    public boolean bu(String str) {
        if (this.Hh != null) {
            return TextUtils.equals(str, this.Hh.Gs);
        }
        if (this.Hj != null) {
            return TextUtils.equals(str, this.Hj.Gs);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [250=5, 251=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(Context context, String str) {
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
        PluginSetting bC = PluginPackageManager.lL().bC(substring);
        if (substring != null && substring.length() > 0 && bC != null && bC.apkPath != null) {
            File file = new File(bC.apkPath);
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
                                if (this.Hc != null) {
                                    this.Hc.bs(substring);
                                }
                                com.baidu.adp.plugin.b.a.ly().f("plugin_install", "install_timeequals", substring, h.toString());
                                com.baidu.adp.lib.g.a.f(fileInputStream);
                                com.baidu.adp.lib.g.a.f(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.f(fileInputStream);
                            com.baidu.adp.lib.g.a.f(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.ly().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.f(fileInputStream);
                            com.baidu.adp.lib.g.a.f(inputStream);
                            e(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.ly().e("plugin_install", substring, bC);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mu().bX(substring)));
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
                com.baidu.adp.plugin.b.a.ly().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        e(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.ly().e("plugin_install", substring, bC);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mu().bX(substring)));
        return true;
    }

    public void G(Context context, String str) {
        e(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void e(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            lh();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.GX = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.GX = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Gs = str2;
                if (a(pluginInstallTask) && z2) {
                    this.GZ.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Gs = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(pluginInstallTask.Gs);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        com.baidu.adp.plugin.b.a.ly().f("plugin_install", "start_install_service", pluginInstallTask.Gs, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.Gs);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.lL().lM());
        if (pluginInstallTask.GW) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Hl == null && z) {
            this.Hl = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.ln();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.Hh != null && TextUtils.equals(stringExtra, c.this.Hh.Gs)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Hl, 1)) {
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

    public static File bv(String str) {
        PluginSetting bC = PluginPackageManager.lL().bC(str);
        if (bC == null || bC.apkPath == null || bC.apkPath.length() <= 0) {
            return null;
        }
        return new File(bC.apkPath);
    }

    private void lh() {
        if (!this.GY) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.Ha, intentFilter);
                this.GY = true;
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
        synchronized (this.Hg) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Hi.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Hh != null) {
                Iterator<PluginInstallTask> it = this.Hi.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Gs, next.Gs)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Hi.add(pluginInstallTask);
                }
                return true;
            }
            this.Hh = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                ll();
                sHandler.removeCallbacks(this.Hp);
                sHandler.postDelayed(this.Hp, this.Hh.lf());
                return true;
            }
            this.Hh = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Hg) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Hk.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Hj != null) {
                Iterator<PluginInstallTask> it = this.Hk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Gs, next.Gs)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Hk.add(pluginInstallTask);
                }
                return true;
            }
            this.Hj = pluginInstallTask;
            pluginInstallTask.GW = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Hq);
                sHandler.postDelayed(this.Hq, this.Hj.lf());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        sHandler.removeCallbacks(this.Hn);
        sHandler.removeCallbacks(this.Hp);
        sHandler.removeCallbacks(this.Ho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj() {
        this.Hj = null;
        sHandler.removeCallbacks(this.Hq);
    }

    private void lk() {
        if (this.Hl != null) {
            BdBaseApplication.getInst().unbindService(this.Hl);
            this.Hl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ll() {
        sHandler.removeCallbacks(this.Hn);
        sHandler.postDelayed(this.Hn, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.messenger != null && this.Hh != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Hh));
                message.replyTo = this.Hm;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Ho);
            sHandler.postDelayed(this.Ho, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        this.Hl = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.ly().f("plugin_install", "system_kill_installprocess", this.Hh == null ? "" : this.Hh.Gs, this.Hi.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hk.size());
        li();
        lu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        com.baidu.adp.plugin.b.a.ly().by("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.ly().f("plugin_install", "installprocess_noresponse", this.Hh == null ? "" : this.Hh.Gs, this.Hi.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hk.size());
        li();
        lr();
        lu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp() {
        if (this.Hh != null) {
            com.baidu.adp.plugin.packageManager.status.a.mu().h(this.Hh.Gs, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Hh;
        if (!ls()) {
            com.baidu.adp.plugin.b.a.ly().by("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.ly().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Gs, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lf())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hi.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hk.size());
        } else {
            com.baidu.adp.plugin.b.a.ly().by("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.ly().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Gs, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lf())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hi.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hk.size());
        }
        li();
        lr();
        lu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq() {
        if (this.Hj != null) {
            com.baidu.adp.plugin.packageManager.status.a.mu().h(this.Hj.Gs, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.ly().f("plugin_install", "timeout", this.Hj == null ? "" : this.Hj.Gs, "timeout-" + (this.Hj == null ? "" : Long.valueOf(this.Hj.lf())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hi.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Hk.size());
        lj();
    }

    private void lr() {
        if (this.Hl != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Hl);
        }
        this.Hl = null;
        this.messenger = null;
        int lt = lt();
        if (lt > 0 && lt != Process.myPid()) {
            Process.killProcess(lt);
        }
    }

    private boolean ls() {
        return lt() > 0;
    }

    private int lt() {
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

    private void lu() {
        if (this.Hh != null) {
            com.baidu.adp.plugin.b.a.ly().C("plugin_retry_install", this.Hh.Gs);
            com.baidu.adp.plugin.b.a.ly().f("plugin_install", "plugin_retry_install", this.Hh.Gs, this.Hh.lf() + "");
            c(this.Hh);
            this.Hh = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Hs = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean bw(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Hs) {
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
                    if (str != null && str.endsWith(".apk") && bw(str) && c.this.F(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.Hc != null) {
                c.this.Hc.R(c.this.He);
            }
        }
    }
}
