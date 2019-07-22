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
    private ArrayList<String> HY;
    private BroadcastReceiver HZ;
    private com.baidu.adp.plugin.install.a Ib;
    private PluginInstallTask Ig;
    private PluginInstallTask Ii;
    private ServiceConnection Ik;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c Ic = null;
    private boolean HX = false;
    private boolean Ia = false;
    private boolean Id = true;
    private a Ie = null;
    private final Object If = new Object();
    private LinkedList<PluginInstallTask> Ih = new LinkedList<>();
    private LinkedList<PluginInstallTask> Ij = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Ig != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Ht, c.this.Ig.Ht)) {
                        c.sHandler.removeCallbacks(c.this.In);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Il = new Messenger(this.handler);
    private Runnable Im = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.lQ();
            c.this.lP();
        }
    };
    private Runnable In = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lS();
        }
    };
    private Runnable Io = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.lT();
        }
    };
    private Runnable Ip = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.lU();
        }
    };

    public static c lK() {
        if (Ic == null) {
            synchronized (c.class) {
                if (Ic == null) {
                    Ic = new c();
                }
            }
        }
        return Ic;
    }

    private c() {
        this.HY = null;
        this.HZ = null;
        this.HY = new ArrayList<>();
        this.HZ = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Ig != null && TextUtils.equals(null, c.this.Ig.Ht)) {
                            c.this.lM();
                            c.this.Ig = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Ii == null || !TextUtils.equals(null, c.this.Ii.Ht)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.lN();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mc().bB("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra(Constants.PACKAGE_NAME);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Ig != null && TextUtils.equals(str, c.this.Ig.Ht)) {
                                    c.this.lM();
                                    c.this.Ig = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Ii == null || !TextUtils.equals(str, c.this.Ii.Ht)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.lN();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.mc().bB("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.nd().bZ(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Id = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.nd().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.Ig != null && TextUtils.equals(str, c.this.Ig.Ht)) {
                                c.this.lM();
                                c.this.Ig = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Ii == null || !TextUtils.equals(str, c.this.Ii.Ht)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lN();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mc().bB("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Ig != null && TextUtils.equals(str, c.this.Ig.Ht)) {
                                c.this.lM();
                                c.this.Ig = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Ii == null || !TextUtils.equals(str, c.this.Ii.Ht)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lN();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mc().bB("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Ig != null && TextUtils.equals(null, c.this.Ig.Ht)) {
                            c.this.lM();
                            c.this.Ig = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Ii == null || !TextUtils.equals(null, c.this.Ii.Ht)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.lN();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mc().bB("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        lL();
    }

    public void k(String str, int i) {
        if (i == 1) {
            G(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.HY.contains(str)) {
            this.HY.remove(str);
        }
        if (!this.Ia && z && this.HY.isEmpty()) {
            this.Ia = true;
            if (this.Ib != null) {
                this.Ib.ai(this.Id);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            lO();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Ib = aVar;
        if (this.Ie != null) {
            this.Ie.cancel();
            this.Ie = null;
        }
        this.Ie = new a(context);
        this.Ie.setPriority(4);
        this.Ie.execute(new String[0]);
    }

    public boolean bx(String str) {
        if (this.Ig != null) {
            return TextUtils.equals(str, this.Ig.Ht);
        }
        if (this.Ii != null) {
            return TextUtils.equals(str, this.Ii.Ht);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=4] */
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
        PluginSetting bG = PluginPackageManager.ms().bG(substring);
        if (substring != null && substring.length() > 0 && bG != null && bG.apkPath != null) {
            File file = new File(bG.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f i = Util.i(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (i.compareTo(Util.i(inputStream)) == 0) {
                                if (this.Ib != null) {
                                    this.Ib.bv(substring);
                                }
                                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "install_timeequals", substring, i.toString());
                                com.baidu.adp.lib.g.a.g(fileInputStream);
                                com.baidu.adp.lib.g.a.g(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            com.baidu.adp.lib.g.a.g(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            com.baidu.adp.lib.g.a.g(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.mc().e("plugin_install", substring, bG);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nd().ca(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.g(fileInputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.g(fileInputStream);
                    com.baidu.adp.lib.g.a.g(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.mc().e("plugin_install", substring, bG);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nd().ca(substring)));
        return true;
    }

    public void H(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            lL();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.HW = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.HW = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Ht = str2;
                if (a(pluginInstallTask) && z2) {
                    this.HY.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Ht = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(pluginInstallTask.Ht);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "start_service_install_status_error", pluginInstallTask.Ht, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring(SkiaImageDecoder.FILE_PREFIX.length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "start_service_file_not_find", pluginInstallTask.Ht, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "start_install_service", pluginInstallTask.Ht, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra(Constants.PACKAGE_NAME, pluginInstallTask.Ht);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.ms().mt());
        if (pluginInstallTask.HV) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Ik == null && z) {
            this.Ik = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.lR();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra(Constants.PACKAGE_NAME);
                    if (c.this.Ig != null && TextUtils.equals(stringExtra, c.this.Ig.Ht)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Ik, 1)) {
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

    public static File by(String str) {
        PluginSetting bG = PluginPackageManager.ms().bG(str);
        if (bG == null || bG.apkPath == null || bG.apkPath.length() <= 0) {
            return null;
        }
        return new File(bG.apkPath);
    }

    private void lL() {
        if (!this.HX) {
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
                applicationContext.registerReceiver(this.HZ, intentFilter);
                this.HX = true;
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
        synchronized (this.If) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Ih.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Ig != null) {
                Iterator<PluginInstallTask> it = this.Ih.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Ht, next.Ht)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Ih.add(pluginInstallTask);
                }
                return true;
            }
            this.Ig = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                lP();
                sHandler.removeCallbacks(this.Io);
                sHandler.postDelayed(this.Io, this.Ig.lJ());
                return true;
            }
            this.Ig = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.If) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Ij.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Ii != null) {
                Iterator<PluginInstallTask> it = this.Ij.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Ht, next.Ht)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Ij.add(pluginInstallTask);
                }
                return true;
            }
            this.Ii = pluginInstallTask;
            pluginInstallTask.HV = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Ip);
                sHandler.postDelayed(this.Ip, this.Ii.lJ());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM() {
        sHandler.removeCallbacks(this.Im);
        sHandler.removeCallbacks(this.Io);
        sHandler.removeCallbacks(this.In);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN() {
        this.Ii = null;
        sHandler.removeCallbacks(this.Ip);
    }

    private void lO() {
        if (this.Ik != null) {
            BdBaseApplication.getInst().unbindService(this.Ik);
            this.Ik = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP() {
        sHandler.removeCallbacks(this.Im);
        sHandler.postDelayed(this.Im, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        if (this.messenger != null && this.Ig != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Ig));
                message.replyTo = this.Il;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.In);
            sHandler.postDelayed(this.In, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR() {
        this.Ik = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "system_kill_installprocess", this.Ig == null ? "" : this.Ig.Ht, this.Ih.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ij.size());
        lM();
        lY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS() {
        com.baidu.adp.plugin.b.a.mc().bB("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "installprocess_noresponse", this.Ig == null ? "" : this.Ig.Ht, this.Ih.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ij.size());
        lM();
        lV();
        lY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT() {
        if (this.Ig != null) {
            com.baidu.adp.plugin.packageManager.status.a.nd().h(this.Ig.Ht, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Ig;
        if (!lW()) {
            com.baidu.adp.plugin.b.a.mc().bB("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Ht, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lJ())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ih.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ij.size());
        } else {
            com.baidu.adp.plugin.b.a.mc().bB("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Ht, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lJ())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ih.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ij.size());
        }
        lM();
        lV();
        lY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU() {
        if (this.Ii != null) {
            com.baidu.adp.plugin.packageManager.status.a.nd().h(this.Ii.Ht, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "timeout", this.Ii == null ? "" : this.Ii.Ht, "timeout-" + (this.Ii == null ? "" : Long.valueOf(this.Ii.lJ())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ih.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ij.size());
        lN();
    }

    private void lV() {
        if (this.Ik != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Ik);
        }
        this.Ik = null;
        this.messenger = null;
        int lX = lX();
        if (lX > 0 && lX != Process.myPid()) {
            Process.killProcess(lX);
        }
    }

    private boolean lW() {
        return lX() > 0;
    }

    private int lX() {
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

    private void lY() {
        if (this.Ig != null) {
            com.baidu.adp.plugin.b.a.mc().B("plugin_retry_install", this.Ig.Ht);
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "plugin_retry_install", this.Ig.Ht, this.Ig.lJ() + "");
            c(this.Ig);
            this.Ig = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Ir = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    n.g(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    n.g(inputStream);
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

        private boolean bz(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Ir) {
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
                    if (str != null && str.endsWith(".apk") && bz(str) && c.this.G(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.Ib != null) {
                c.this.Ib.ai(c.this.Id);
            }
        }
    }
}
