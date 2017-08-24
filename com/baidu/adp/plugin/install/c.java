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
    private ArrayList<String> EH;
    private BroadcastReceiver EI;
    private com.baidu.adp.plugin.install.a EK;
    private PluginInstallTask EP;
    private PluginInstallTask ER;
    private ServiceConnection ET;
    private Messenger messenger;
    private static Handler ql = new Handler(Looper.getMainLooper());
    private static volatile c EL = null;
    private boolean EG = false;
    private boolean EJ = false;
    private boolean EM = true;
    private a EN = null;
    private final Object EO = new Object();
    private LinkedList<PluginInstallTask> EQ = new LinkedList<>();
    private LinkedList<PluginInstallTask> ES = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.EP != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Ed, c.this.EP.Ed)) {
                        c.ql.removeCallbacks(c.this.EW);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger EU = new Messenger(this.handler);
    private Runnable EV = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.jf();
            c.this.je();
        }
    };
    private Runnable EW = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.jh();
        }
    };
    private Runnable EX = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.ji();
        }
    };
    private Runnable EY = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.jj();
        }
    };

    public static c iZ() {
        if (EL == null) {
            synchronized (c.class) {
                if (EL == null) {
                    EL = new c();
                }
            }
        }
        return EL;
    }

    private c() {
        this.EH = null;
        this.EI = null;
        this.EH = new ArrayList<>();
        this.EI = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=6, 149=5, 150=5, 151=5, 152=5, 153=5, 154=5, 155=5, 156=5, 157=5, 159=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.EP != null && TextUtils.equals(null, c.this.EP.Ed)) {
                            c.this.jb();
                            c.this.EP = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.ER == null || !TextUtils.equals(null, c.this.ER.Ed)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.jc();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jr().bj("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.EP != null && TextUtils.equals(str, c.this.EP.Ed)) {
                                    c.this.jb();
                                    c.this.EP = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.ER == null || !TextUtils.equals(str, c.this.ER.Ed)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.jc();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.jr().bj("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.kn().bH(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.EM = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.kn().g(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            }
                            if (c.this.EP != null && TextUtils.equals(str, c.this.EP.Ed)) {
                                c.this.jb();
                                c.this.EP = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.ER == null || !TextUtils.equals(str, c.this.ER.Ed)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.jc();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jr().bj("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.EP != null && TextUtils.equals(str, c.this.EP.Ed)) {
                                c.this.jb();
                                c.this.EP = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.ER == null || !TextUtils.equals(str, c.this.ER.Ed)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.jc();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jr().bj("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.EP != null && TextUtils.equals(null, c.this.EP.Ed)) {
                            c.this.jb();
                            c.this.EP = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.ER == null || !TextUtils.equals(null, c.this.ER.Ed)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.jc();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jr().bj("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        ja();
    }

    public void l(String str, int i) {
        if (i == 1) {
            H(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.EH.contains(str)) {
            this.EH.remove(str);
        }
        if (!this.EJ && z && this.EH.isEmpty()) {
            this.EJ = true;
            if (this.EK != null) {
                this.EK.L(this.EM);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            jd();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.EK = aVar;
        if (this.EN != null) {
            this.EN.cancel();
            this.EN = null;
        }
        this.EN = new a(context);
        this.EN.setPriority(4);
        this.EN.execute(new String[0]);
    }

    public boolean bf(String str) {
        if (this.EP != null) {
            return TextUtils.equals(str, this.EP.Ed);
        }
        if (this.ER != null) {
            return TextUtils.equals(str, this.ER.Ed);
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
        PluginSetting bn = PluginPackageManager.jE().bn(substring);
        if (substring != null && substring.length() > 0 && bn != null && bn.apkPath != null) {
            File file = new File(bn.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f r = Util.r(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (r.compareTo(Util.r(inputStream)) == 0) {
                                if (this.EK != null) {
                                    this.EK.bd(substring);
                                }
                                com.baidu.adp.plugin.b.a.jr().c("plugin_install", "install_timeequals", substring, r.toString());
                                com.baidu.adp.lib.g.a.p(fileInputStream);
                                com.baidu.adp.lib.g.a.p(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.p(fileInputStream);
                            com.baidu.adp.lib.g.a.p(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.jr().c("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.p(fileInputStream);
                            com.baidu.adp.lib.g.a.p(inputStream);
                            e(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.jr().e("plugin_install", substring, bn);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.kn().bI(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.p(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.p(fileInputStream);
                    com.baidu.adp.lib.g.a.p(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.jr().c("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        e(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.jr().e("plugin_install", substring, bn);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.kn().bI(substring)));
        return true;
    }

    public void I(Context context, String str) {
        e(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void e(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            ja();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.EF = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.EF = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Ed = str2;
                if (a(pluginInstallTask) && z2) {
                    this.EH.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Ed = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        boolean z = false;
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kg().findPluginSetting(pluginInstallTask.Ed);
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.jr().c("plugin_install", "start_install_service", pluginInstallTask.Ed, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.Ed);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.jE().jF());
        if (pluginInstallTask.EE) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.ET == null && z) {
            this.ET = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.jg();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.EP != null && TextUtils.equals(stringExtra, c.this.EP.Ed)) {
                        context.startService(intent);
                    }
                }
            };
            if (context.bindService(intent, this.ET, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bg(String str) {
        PluginSetting bn = PluginPackageManager.jE().bn(str);
        if (bn == null || bn.apkPath == null || bn.apkPath.length() <= 0) {
            return null;
        }
        return new File(bn.apkPath);
    }

    private void ja() {
        if (!this.EG) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.EI, intentFilter);
                this.EG = true;
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
        synchronized (this.EO) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.EQ.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.EP != null) {
                Iterator<PluginInstallTask> it = this.EQ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Ed, next.Ed)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.EQ.add(pluginInstallTask);
                }
                return true;
            }
            this.EP = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                je();
                ql.removeCallbacks(this.EX);
                ql.postDelayed(this.EX, this.EP.iY());
                return true;
            }
            this.EP = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.EO) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.ES.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.ER != null) {
                Iterator<PluginInstallTask> it = this.ES.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Ed, next.Ed)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.ES.add(pluginInstallTask);
                }
                return true;
            }
            this.ER = pluginInstallTask;
            pluginInstallTask.EE = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                ql.removeCallbacks(this.EY);
                ql.postDelayed(this.EY, this.ER.iY());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb() {
        ql.removeCallbacks(this.EV);
        ql.removeCallbacks(this.EX);
        ql.removeCallbacks(this.EW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc() {
        this.ER = null;
        ql.removeCallbacks(this.EY);
    }

    private void jd() {
        if (this.ET != null) {
            BdBaseApplication.getInst().unbindService(this.ET);
            this.ET = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        ql.removeCallbacks(this.EV);
        ql.postDelayed(this.EV, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf() {
        if (this.messenger != null && this.EP != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.EP));
                message.replyTo = this.EU;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            ql.removeCallbacks(this.EW);
            ql.postDelayed(this.EW, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg() {
        this.ET = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.jr().c("plugin_install", "system_kill_installprocess", this.EP == null ? "" : this.EP.Ed, this.EQ.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES.size());
        jb();
        jn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh() {
        com.baidu.adp.plugin.b.a.jr().bj("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.jr().c("plugin_install", "installprocess_noresponse", this.EP == null ? "" : this.EP.Ed, this.EQ.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES.size());
        jb();
        jk();
        jn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji() {
        if (this.EP != null) {
            com.baidu.adp.plugin.packageManager.status.a.kn().g(this.EP.Ed, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.EP;
        if (!jl()) {
            com.baidu.adp.plugin.b.a.jr().bj("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.jr().c("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Ed, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iY())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EQ.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES.size());
        } else {
            com.baidu.adp.plugin.b.a.jr().bj("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.jr().c("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Ed, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iY())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EQ.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES.size());
        }
        jb();
        jk();
        jn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj() {
        if (this.ER != null) {
            com.baidu.adp.plugin.packageManager.status.a.kn().g(this.ER.Ed, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.jr().c("plugin_install", "timeout", this.ER == null ? "" : this.ER.Ed, "timeout-" + (this.ER == null ? "" : Long.valueOf(this.ER.iY())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EQ.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES.size());
        jc();
    }

    private void jk() {
        if (this.ET != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.ET);
        }
        this.ET = null;
        this.messenger = null;
        int jm = jm();
        if (jm > 0 && jm != Process.myPid()) {
            Process.killProcess(jm);
        }
    }

    private boolean jl() {
        return jm() > 0;
    }

    private int jm() {
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

    private void jn() {
        if (this.EP != null) {
            com.baidu.adp.plugin.b.a.jr().B("plugin_retry_install", this.EP.Ed);
            com.baidu.adp.plugin.b.a.jr().c("plugin_install", "plugin_retry_install", this.EP.Ed, this.EP.iY() + "");
            c(this.EP);
            this.EP = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Fa = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    m.p(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    m.p(inputStream);
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

        private boolean bh(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Fa) {
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
                    if (str != null && str.endsWith(".apk") && bh(str) && c.this.H(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.EK != null) {
                c.this.EK.L(c.this.EM);
            }
        }
    }
}
