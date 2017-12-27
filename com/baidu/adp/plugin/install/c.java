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
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private PluginInstallTask aqB;
    private PluginInstallTask aqD;
    private ServiceConnection aqF;
    private ArrayList<String> aqt;
    private BroadcastReceiver aqu;
    private com.baidu.adp.plugin.install.a aqw;
    private Messenger messenger;
    private static Handler pM = new Handler(Looper.getMainLooper());
    private static volatile c aqx = null;
    private boolean aqs = false;
    private boolean aqv = false;
    private boolean aqy = true;
    private a aqz = null;
    private final Object aqA = new Object();
    private LinkedList<PluginInstallTask> aqC = new LinkedList<>();
    private LinkedList<PluginInstallTask> aqE = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.aqB != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).apP, c.this.aqB.apP)) {
                        c.pM.removeCallbacks(c.this.aqI);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger aqG = new Messenger(this.handler);
    private Runnable aqH = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.qs();
            c.this.qr();
        }
    };
    private Runnable aqI = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.qu();
        }
    };
    private Runnable aqJ = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.qv();
        }
    };
    private Runnable aqK = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.qw();
        }
    };

    public static c qm() {
        if (aqx == null) {
            synchronized (c.class) {
                if (aqx == null) {
                    aqx = new c();
                }
            }
        }
        return aqx;
    }

    private c() {
        this.aqt = null;
        this.aqu = null;
        this.aqt = new ArrayList<>();
        this.aqu = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 135=6, 124=6, 125=5, 126=5, 127=5] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.aqB != null && TextUtils.equals(null, c.this.aqB.apP)) {
                            c.this.qo();
                            c.this.aqB = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.aqD == null || !TextUtils.equals(null, c.this.aqD.apP)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.qp();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.qE().bn("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.aqB != null && TextUtils.equals(str, c.this.aqB.apP)) {
                                    c.this.qo();
                                    c.this.aqB = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.aqD == null || !TextUtils.equals(str, c.this.aqD.apP)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.qp();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.qE().bn("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.rA().bL(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.aqy = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.rA().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            }
                            if (c.this.aqB != null && TextUtils.equals(str, c.this.aqB.apP)) {
                                c.this.qo();
                                c.this.aqB = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.aqD == null || !TextUtils.equals(str, c.this.aqD.apP)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.qp();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.qE().bn("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.aqB != null && TextUtils.equals(str, c.this.aqB.apP)) {
                                c.this.qo();
                                c.this.aqB = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.aqD == null || !TextUtils.equals(str, c.this.aqD.apP)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.qp();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.qE().bn("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.aqB != null && TextUtils.equals(null, c.this.aqB.apP)) {
                            c.this.qo();
                            c.this.aqB = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.aqD == null || !TextUtils.equals(null, c.this.aqD.apP)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.qp();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.qE().bn("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        qn();
    }

    public void m(String str, int i) {
        if (i == 1) {
            L(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.aqt.contains(str)) {
            this.aqt.remove(str);
        }
        if (!this.aqv && z && this.aqt.isEmpty()) {
            this.aqv = true;
            if (this.aqw != null) {
                this.aqw.as(this.aqy);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            qq();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.aqw = aVar;
        if (this.aqz != null) {
            this.aqz.cancel();
            this.aqz = null;
        }
        this.aqz = new a(context);
        this.aqz.setPriority(4);
        this.aqz.execute(new String[0]);
    }

    public boolean bj(String str) {
        if (this.aqB != null) {
            return TextUtils.equals(str, this.aqB.apP);
        }
        if (this.aqD != null) {
            return TextUtils.equals(str, this.aqD.apP);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [250=5, 251=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean L(Context context, String str) {
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
        PluginSetting br = PluginPackageManager.qR().br(substring);
        if (substring != null && substring.length() > 0 && br != null && br.apkPath != null) {
            File file = new File(br.apkPath);
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
                                if (this.aqw != null) {
                                    this.aqw.bh(substring);
                                }
                                com.baidu.adp.plugin.b.a.qE().f("plugin_install", "install_timeequals", substring, f.toString());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.d(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.qE().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.d(inputStream);
                            e(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.qE().e("plugin_install", substring, br);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.rA().bM(substring)));
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
                com.baidu.adp.plugin.b.a.qE().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        e(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.qE().e("plugin_install", substring, br);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.rA().bM(substring)));
        return true;
    }

    public void M(Context context, String str) {
        e(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void e(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            qn();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.aqr = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.aqr = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.apP = str2;
                if (a(pluginInstallTask) && z2) {
                    this.aqt.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.apP = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginInstallTask.apP);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        com.baidu.adp.plugin.b.a.qE().f("plugin_install", "start_install_service", pluginInstallTask.apP, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.apP);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.qR().qS());
        if (pluginInstallTask.aqq) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.aqF == null && z) {
            this.aqF = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.qt();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.aqB != null && TextUtils.equals(stringExtra, c.this.aqB.apP)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.aqF, 1)) {
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

    public static File bk(String str) {
        PluginSetting br = PluginPackageManager.qR().br(str);
        if (br == null || br.apkPath == null || br.apkPath.length() <= 0) {
            return null;
        }
        return new File(br.apkPath);
    }

    private void qn() {
        if (!this.aqs) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.aqu, intentFilter);
                this.aqs = true;
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
        synchronized (this.aqA) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.aqC.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.aqB != null) {
                Iterator<PluginInstallTask> it = this.aqC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.apP, next.apP)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.aqC.add(pluginInstallTask);
                }
                return true;
            }
            this.aqB = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                qr();
                pM.removeCallbacks(this.aqJ);
                pM.postDelayed(this.aqJ, this.aqB.ql());
                return true;
            }
            this.aqB = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.aqA) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.aqE.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.aqD != null) {
                Iterator<PluginInstallTask> it = this.aqE.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.apP, next.apP)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.aqE.add(pluginInstallTask);
                }
                return true;
            }
            this.aqD = pluginInstallTask;
            pluginInstallTask.aqq = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                pM.removeCallbacks(this.aqK);
                pM.postDelayed(this.aqK, this.aqD.ql());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo() {
        pM.removeCallbacks(this.aqH);
        pM.removeCallbacks(this.aqJ);
        pM.removeCallbacks(this.aqI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp() {
        this.aqD = null;
        pM.removeCallbacks(this.aqK);
    }

    private void qq() {
        if (this.aqF != null) {
            BdBaseApplication.getInst().unbindService(this.aqF);
            this.aqF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr() {
        pM.removeCallbacks(this.aqH);
        pM.postDelayed(this.aqH, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qs() {
        if (this.messenger != null && this.aqB != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.aqB));
                message.replyTo = this.aqG;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            pM.removeCallbacks(this.aqI);
            pM.postDelayed(this.aqI, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        this.aqF = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.qE().f("plugin_install", "system_kill_installprocess", this.aqB == null ? "" : this.aqB.apP, this.aqC.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqE.size());
        qo();
        qA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu() {
        com.baidu.adp.plugin.b.a.qE().bn("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.qE().f("plugin_install", "installprocess_noresponse", this.aqB == null ? "" : this.aqB.apP, this.aqC.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqE.size());
        qo();
        qx();
        qA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv() {
        if (this.aqB != null) {
            com.baidu.adp.plugin.packageManager.status.a.rA().h(this.aqB.apP, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.aqB;
        if (!qy()) {
            com.baidu.adp.plugin.b.a.qE().bn("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.qE().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.apP, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.ql())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqC.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqE.size());
        } else {
            com.baidu.adp.plugin.b.a.qE().bn("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.qE().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.apP, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.ql())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqC.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqE.size());
        }
        qo();
        qx();
        qA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw() {
        if (this.aqD != null) {
            com.baidu.adp.plugin.packageManager.status.a.rA().h(this.aqD.apP, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.qE().f("plugin_install", "timeout", this.aqD == null ? "" : this.aqD.apP, "timeout-" + (this.aqD == null ? "" : Long.valueOf(this.aqD.ql())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqC.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aqE.size());
        qp();
    }

    private void qx() {
        if (this.aqF != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.aqF);
        }
        this.aqF = null;
        this.messenger = null;
        int qz = qz();
        if (qz > 0 && qz != Process.myPid()) {
            Process.killProcess(qz);
        }
    }

    private boolean qy() {
        return qz() > 0;
    }

    private int qz() {
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

    private void qA() {
        if (this.aqB != null) {
            com.baidu.adp.plugin.b.a.qE().A("plugin_retry_install", this.aqB.apP);
            com.baidu.adp.plugin.b.a.qE().f("plugin_install", "plugin_retry_install", this.aqB.apP, this.aqB.ql() + "");
            c(this.aqB);
            this.aqB = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] aqM = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean bl(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.aqM) {
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
                    if (str != null && str.endsWith(".apk") && bl(str) && c.this.L(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.aqw != null) {
                c.this.aqw.as(c.this.aqy);
            }
        }
    }
}
