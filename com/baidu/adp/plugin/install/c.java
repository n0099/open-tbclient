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
import com.baidu.adp.lib.util.n;
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
    private ArrayList<String> CD;
    private BroadcastReceiver CE;
    private com.baidu.adp.plugin.install.a CG;
    private PluginInstallTask CL;
    private PluginInstallTask CN;
    private ServiceConnection CP;
    private Messenger messenger;
    private static Handler nT = new Handler(Looper.getMainLooper());
    private static volatile c CH = null;
    private boolean CC = false;
    private boolean CF = false;
    private boolean CI = true;
    private a CJ = null;
    private final Object CK = new Object();
    private LinkedList<PluginInstallTask> CM = new LinkedList<>();
    private LinkedList<PluginInstallTask> CO = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.CL != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).BZ, c.this.CL.BZ)) {
                        c.nT.removeCallbacks(c.this.CS);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger CQ = new Messenger(this.handler);
    private Runnable CR = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.iW();
            c.this.iV();
        }
    };
    private Runnable CS = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.iY();
        }
    };
    private Runnable CT = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.iZ();
        }
    };
    private Runnable CU = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.ja();
        }
    };

    public static c iQ() {
        if (CH == null) {
            synchronized (c.class) {
                if (CH == null) {
                    CH = new c();
                }
            }
        }
        return CH;
    }

    private c() {
        this.CD = null;
        this.CE = null;
        this.CD = new ArrayList<>();
        this.CE = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 135=6, 124=6, 125=5, 126=5, 127=5] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.CL != null && TextUtils.equals(null, c.this.CL.BZ)) {
                            c.this.iS();
                            c.this.CL = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.CN == null || !TextUtils.equals(null, c.this.CN.BZ)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.iT();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.ji().bf("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.CL != null && TextUtils.equals(str, c.this.CL.BZ)) {
                                    c.this.iS();
                                    c.this.CL = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.CN == null || !TextUtils.equals(str, c.this.CN.BZ)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.iT();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.ji().bf("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.ke().bD(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.CI = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.ke().g(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            }
                            if (c.this.CL != null && TextUtils.equals(str, c.this.CL.BZ)) {
                                c.this.iS();
                                c.this.CL = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.CN == null || !TextUtils.equals(str, c.this.CN.BZ)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iT();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.ji().bf("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.CL != null && TextUtils.equals(str, c.this.CL.BZ)) {
                                c.this.iS();
                                c.this.CL = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.CN == null || !TextUtils.equals(str, c.this.CN.BZ)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.iT();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.ji().bf("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.CL != null && TextUtils.equals(null, c.this.CL.BZ)) {
                            c.this.iS();
                            c.this.CL = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.CN == null || !TextUtils.equals(null, c.this.CN.BZ)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.iT();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.ji().bf("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        iR();
    }

    public void l(String str, int i) {
        if (i == 1) {
            H(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.CD.contains(str)) {
            this.CD.remove(str);
        }
        if (!this.CF && z && this.CD.isEmpty()) {
            this.CF = true;
            if (this.CG != null) {
                this.CG.M(this.CI);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            iU();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.CG = aVar;
        if (this.CJ != null) {
            this.CJ.cancel();
            this.CJ = null;
        }
        this.CJ = new a(context);
        this.CJ.setPriority(4);
        this.CJ.execute(new String[0]);
    }

    public boolean bb(String str) {
        if (this.CL != null) {
            return TextUtils.equals(str, this.CL.BZ);
        }
        if (this.CN != null) {
            return TextUtils.equals(str, this.CN.BZ);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [250=5, 251=4] */
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
        PluginSetting bj = PluginPackageManager.jv().bj(substring);
        if (substring != null && substring.length() > 0 && bj != null && bj.apkPath != null) {
            File file = new File(bj.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f f = Util.f(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (f.compareTo(Util.f(inputStream)) == 0) {
                                if (this.CG != null) {
                                    this.CG.aZ(substring);
                                }
                                com.baidu.adp.plugin.b.a.ji().c("plugin_install", "install_timeequals", substring, f.toString());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.d(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.ji().c("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.d(inputStream);
                            e(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.ji().e("plugin_install", substring, bj);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.ke().bE(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.d(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.ji().c("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        e(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.ji().e("plugin_install", substring, bj);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.ke().bE(substring)));
        return true;
    }

    public void I(Context context, String str) {
        e(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void e(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            iR();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.CB = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.CB = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.BZ = str2;
                if (a(pluginInstallTask) && z2) {
                    this.CD.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.BZ = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jX().findPluginSetting(pluginInstallTask.BZ);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        com.baidu.adp.plugin.b.a.ji().c("plugin_install", "start_install_service", pluginInstallTask.BZ, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.BZ);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.jv().jw());
        if (pluginInstallTask.CA) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.CP == null && z) {
            this.CP = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.iX();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.CL != null && TextUtils.equals(stringExtra, c.this.CL.BZ)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.CP, 1)) {
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

    public static File bc(String str) {
        PluginSetting bj = PluginPackageManager.jv().bj(str);
        if (bj == null || bj.apkPath == null || bj.apkPath.length() <= 0) {
            return null;
        }
        return new File(bj.apkPath);
    }

    private void iR() {
        if (!this.CC) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.CE, intentFilter);
                this.CC = true;
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
        synchronized (this.CK) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.CM.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.CL != null) {
                Iterator<PluginInstallTask> it = this.CM.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.BZ, next.BZ)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.CM.add(pluginInstallTask);
                }
                return true;
            }
            this.CL = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                iV();
                nT.removeCallbacks(this.CT);
                nT.postDelayed(this.CT, this.CL.iP());
                return true;
            }
            this.CL = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.CK) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.CO.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.CN != null) {
                Iterator<PluginInstallTask> it = this.CO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.BZ, next.BZ)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.CO.add(pluginInstallTask);
                }
                return true;
            }
            this.CN = pluginInstallTask;
            pluginInstallTask.CA = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                nT.removeCallbacks(this.CU);
                nT.postDelayed(this.CU, this.CN.iP());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        nT.removeCallbacks(this.CR);
        nT.removeCallbacks(this.CT);
        nT.removeCallbacks(this.CS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        this.CN = null;
        nT.removeCallbacks(this.CU);
    }

    private void iU() {
        if (this.CP != null) {
            BdBaseApplication.getInst().unbindService(this.CP);
            this.CP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV() {
        nT.removeCallbacks(this.CR);
        nT.postDelayed(this.CR, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW() {
        if (this.messenger != null && this.CL != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.CL));
                message.replyTo = this.CQ;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            nT.removeCallbacks(this.CS);
            nT.postDelayed(this.CS, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX() {
        this.CP = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.ji().c("plugin_install", "system_kill_installprocess", this.CL == null ? "" : this.CL.BZ, this.CM.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CO.size());
        iS();
        je();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY() {
        com.baidu.adp.plugin.b.a.ji().bf("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.ji().c("plugin_install", "installprocess_noresponse", this.CL == null ? "" : this.CL.BZ, this.CM.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CO.size());
        iS();
        jb();
        je();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        if (this.CL != null) {
            com.baidu.adp.plugin.packageManager.status.a.ke().g(this.CL.BZ, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.CL;
        if (!jc()) {
            com.baidu.adp.plugin.b.a.ji().bf("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.ji().c("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.BZ, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iP())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CM.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CO.size());
        } else {
            com.baidu.adp.plugin.b.a.ji().bf("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.ji().c("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.BZ, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iP())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CM.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CO.size());
        }
        iS();
        jb();
        je();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.CN != null) {
            com.baidu.adp.plugin.packageManager.status.a.ke().g(this.CN.BZ, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.ji().c("plugin_install", "timeout", this.CN == null ? "" : this.CN.BZ, "timeout-" + (this.CN == null ? "" : Long.valueOf(this.CN.iP())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CM.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.CO.size());
        iT();
    }

    private void jb() {
        if (this.CP != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.CP);
        }
        this.CP = null;
        this.messenger = null;
        int jd = jd();
        if (jd > 0 && jd != Process.myPid()) {
            Process.killProcess(jd);
        }
    }

    private boolean jc() {
        return jd() > 0;
    }

    private int jd() {
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

    private void je() {
        if (this.CL != null) {
            com.baidu.adp.plugin.b.a.ji().B("plugin_retry_install", this.CL.BZ);
            com.baidu.adp.plugin.b.a.ji().c("plugin_install", "plugin_retry_install", this.CL.BZ, this.CL.iP() + "");
            c(this.CL);
            this.CL = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] CW = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    n.d(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    n.d(inputStream);
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

        private boolean bd(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.CW) {
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
                    if (str != null && str.endsWith(".apk") && bd(str) && c.this.H(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.CG != null) {
                c.this.CG.M(c.this.CI);
            }
        }
    }
}
