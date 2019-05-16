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
    private ArrayList<String> HN;
    private BroadcastReceiver HO;
    private com.baidu.adp.plugin.install.a HQ;
    private PluginInstallTask HW;
    private PluginInstallTask HY;
    private ServiceConnection Ia;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c HR = null;
    private boolean HM = false;
    private boolean HP = false;
    private boolean HS = true;
    private a HU = null;
    private final Object HV = new Object();
    private LinkedList<PluginInstallTask> HX = new LinkedList<>();
    private LinkedList<PluginInstallTask> HZ = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.HW != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Hj, c.this.HW.Hj)) {
                        c.sHandler.removeCallbacks(c.this.Id);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Ib = new Messenger(this.handler);
    private Runnable Ic = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.lA();
            c.this.lz();
        }
    };
    private Runnable Id = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lC();
        }
    };
    private Runnable Ie = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.lD();
        }
    };
    private Runnable If = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.lE();
        }
    };

    public static c lu() {
        if (HR == null) {
            synchronized (c.class) {
                if (HR == null) {
                    HR = new c();
                }
            }
        }
        return HR;
    }

    private c() {
        this.HN = null;
        this.HO = null;
        this.HN = new ArrayList<>();
        this.HO = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.HW != null && TextUtils.equals(null, c.this.HW.Hj)) {
                            c.this.lw();
                            c.this.HW = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.HY == null || !TextUtils.equals(null, c.this.HY.Hj)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.lx();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.lM().bz("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra(Constants.PACKAGE_NAME);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.HW != null && TextUtils.equals(str, c.this.HW.Hj)) {
                                    c.this.lw();
                                    c.this.HW = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.HY == null || !TextUtils.equals(str, c.this.HY.Hj)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.lx();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.lM().bz("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.mN().bX(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.HS = false;
                                }
                                c.this.e(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.mN().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.e(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.HW != null && TextUtils.equals(str, c.this.HW.Hj)) {
                                c.this.lw();
                                c.this.HW = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.HY == null || !TextUtils.equals(str, c.this.HY.Hj)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lx();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.lM().bz("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.HW != null && TextUtils.equals(str, c.this.HW.Hj)) {
                                c.this.lw();
                                c.this.HW = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.HY == null || !TextUtils.equals(str, c.this.HY.Hj)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.lx();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.lM().bz("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.HW != null && TextUtils.equals(null, c.this.HW.Hj)) {
                            c.this.lw();
                            c.this.HW = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.HY == null || !TextUtils.equals(null, c.this.HY.Hj)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.lx();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.lM().bz("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        lv();
    }

    public void k(String str, int i) {
        if (i == 1) {
            G(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.HN.contains(str)) {
            this.HN.remove(str);
        }
        if (!this.HP && z && this.HN.isEmpty()) {
            this.HP = true;
            if (this.HQ != null) {
                this.HQ.ag(this.HS);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            ly();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.HQ = aVar;
        if (this.HU != null) {
            this.HU.cancel();
            this.HU = null;
        }
        this.HU = new a(context);
        this.HU.setPriority(4);
        this.HU.execute(new String[0]);
    }

    public boolean bv(String str) {
        if (this.HW != null) {
            return TextUtils.equals(str, this.HW.Hj);
        }
        if (this.HY != null) {
            return TextUtils.equals(str, this.HY.Hj);
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
        PluginSetting bE = PluginPackageManager.mc().bE(substring);
        if (substring != null && substring.length() > 0 && bE != null && bE.apkPath != null) {
            File file = new File(bE.apkPath);
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
                                if (this.HQ != null) {
                                    this.HQ.bt(substring);
                                }
                                com.baidu.adp.plugin.b.a.lM().f("plugin_install", "install_timeequals", substring, i.toString());
                                com.baidu.adp.lib.g.a.g(fileInputStream);
                                com.baidu.adp.lib.g.a.g(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            com.baidu.adp.lib.g.a.g(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.lM().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            com.baidu.adp.lib.g.a.g(inputStream);
                            c(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.lM().e("plugin_install", substring, bE);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mN().bY(substring)));
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
                com.baidu.adp.plugin.b.a.lM().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        c(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.lM().e("plugin_install", substring, bE);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.mN().bY(substring)));
        return true;
    }

    public void H(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            lv();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.HL = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.HL = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Hj = str2;
                if (a(pluginInstallTask) && z2) {
                    this.HN.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Hj = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mG().findPluginSetting(pluginInstallTask.Hj);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.lM().f("plugin_install", "start_service_install_status_error", pluginInstallTask.Hj, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring(SkiaImageDecoder.FILE_PREFIX.length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.lM().f("plugin_install", "start_service_file_not_find", pluginInstallTask.Hj, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        com.baidu.adp.plugin.b.a.lM().f("plugin_install", "start_install_service", pluginInstallTask.Hj, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra(Constants.PACKAGE_NAME, pluginInstallTask.Hj);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.mc().md());
        if (pluginInstallTask.HK) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Ia == null && z) {
            this.Ia = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.lB();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra(Constants.PACKAGE_NAME);
                    if (c.this.HW != null && TextUtils.equals(stringExtra, c.this.HW.Hj)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Ia, 1)) {
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
        PluginSetting bE = PluginPackageManager.mc().bE(str);
        if (bE == null || bE.apkPath == null || bE.apkPath.length() <= 0) {
            return null;
        }
        return new File(bE.apkPath);
    }

    private void lv() {
        if (!this.HM) {
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
                applicationContext.registerReceiver(this.HO, intentFilter);
                this.HM = true;
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
        synchronized (this.HV) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.HX.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.HW != null) {
                Iterator<PluginInstallTask> it = this.HX.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Hj, next.Hj)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.HX.add(pluginInstallTask);
                }
                return true;
            }
            this.HW = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                lz();
                sHandler.removeCallbacks(this.Ie);
                sHandler.postDelayed(this.Ie, this.HW.lt());
                return true;
            }
            this.HW = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.HV) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.HZ.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.HY != null) {
                Iterator<PluginInstallTask> it = this.HZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Hj, next.Hj)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.HZ.add(pluginInstallTask);
                }
                return true;
            }
            this.HY = pluginInstallTask;
            pluginInstallTask.HK = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.If);
                sHandler.postDelayed(this.If, this.HY.lt());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        sHandler.removeCallbacks(this.Ic);
        sHandler.removeCallbacks(this.Ie);
        sHandler.removeCallbacks(this.Id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        this.HY = null;
        sHandler.removeCallbacks(this.If);
    }

    private void ly() {
        if (this.Ia != null) {
            BdBaseApplication.getInst().unbindService(this.Ia);
            this.Ia = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        sHandler.removeCallbacks(this.Ic);
        sHandler.postDelayed(this.Ic, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (this.messenger != null && this.HW != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.HW));
                message.replyTo = this.Ib;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Id);
            sHandler.postDelayed(this.Id, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB() {
        this.Ia = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lM().f("plugin_install", "system_kill_installprocess", this.HW == null ? "" : this.HW.Hj, this.HX.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HZ.size());
        lw();
        lI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC() {
        com.baidu.adp.plugin.b.a.lM().bz("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lM().f("plugin_install", "installprocess_noresponse", this.HW == null ? "" : this.HW.Hj, this.HX.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HZ.size());
        lw();
        lF();
        lI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        if (this.HW != null) {
            com.baidu.adp.plugin.packageManager.status.a.mN().h(this.HW.Hj, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.HW;
        if (!lG()) {
            com.baidu.adp.plugin.b.a.lM().bz("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lM().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Hj, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lt())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HX.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HZ.size());
        } else {
            com.baidu.adp.plugin.b.a.lM().bz("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lM().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Hj, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.lt())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HX.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HZ.size());
        }
        lw();
        lF();
        lI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE() {
        if (this.HY != null) {
            com.baidu.adp.plugin.packageManager.status.a.mN().h(this.HY.Hj, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lM().f("plugin_install", "timeout", this.HY == null ? "" : this.HY.Hj, "timeout-" + (this.HY == null ? "" : Long.valueOf(this.HY.lt())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HX.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.HZ.size());
        lx();
    }

    private void lF() {
        if (this.Ia != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Ia);
        }
        this.Ia = null;
        this.messenger = null;
        int lH = lH();
        if (lH > 0 && lH != Process.myPid()) {
            Process.killProcess(lH);
        }
    }

    private boolean lG() {
        return lH() > 0;
    }

    private int lH() {
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

    private void lI() {
        if (this.HW != null) {
            com.baidu.adp.plugin.b.a.lM().B("plugin_retry_install", this.HW.Hj);
            com.baidu.adp.plugin.b.a.lM().f("plugin_install", "plugin_retry_install", this.HW.Hj, this.HW.lt() + "");
            c(this.HW);
            this.HW = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Ih = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean bx(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Ih) {
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
            if (!z && c.this.HQ != null) {
                c.this.HQ.ag(c.this.HS);
            }
        }
    }
}
