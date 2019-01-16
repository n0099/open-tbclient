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
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.webkit.internal.ETAG;
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
    private ArrayList<String> JV;
    private BroadcastReceiver JW;
    private com.baidu.adp.plugin.install.a JY;
    private PluginInstallTask Kd;
    private PluginInstallTask Kf;
    private ServiceConnection Kh;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c JZ = null;
    private boolean JU = false;
    private boolean JX = false;
    private boolean Ka = true;
    private a Kb = null;
    private final Object Kc = new Object();
    private LinkedList<PluginInstallTask> Ke = new LinkedList<>();
    private LinkedList<PluginInstallTask> Kg = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Kd != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Js, c.this.Kd.Js)) {
                        c.sHandler.removeCallbacks(c.this.Kk);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Ki = new Messenger(this.handler);
    private Runnable Kj = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.mB();
            c.this.mA();
        }
    };
    private Runnable Kk = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mD();
        }
    };
    private Runnable Kl = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.mE();
        }
    };
    private Runnable Km = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.mF();
        }
    };

    public static c mv() {
        if (JZ == null) {
            synchronized (c.class) {
                if (JZ == null) {
                    JZ = new c();
                }
            }
        }
        return JZ;
    }

    private c() {
        this.JV = null;
        this.JW = null;
        this.JV = new ArrayList<>();
        this.JW = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Kd != null && TextUtils.equals(null, c.this.Kd.Js)) {
                            c.this.mx();
                            c.this.Kd = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Kf == null || !TextUtils.equals(null, c.this.Kf.Js)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.my();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mN().bP("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Kd != null && TextUtils.equals(str, c.this.Kd.Js)) {
                                    c.this.mx();
                                    c.this.Kd = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Kf == null || !TextUtils.equals(str, c.this.Kf.Js)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.my();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.mN().bP("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.nN().co(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Ka = false;
                                }
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.nN().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.h(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.Kd != null && TextUtils.equals(str, c.this.Kd.Js)) {
                                c.this.mx();
                                c.this.Kd = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kf == null || !TextUtils.equals(str, c.this.Kf.Js)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.my();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mN().bP("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Kd != null && TextUtils.equals(str, c.this.Kd.Js)) {
                                c.this.mx();
                                c.this.Kd = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kf == null || !TextUtils.equals(str, c.this.Kf.Js)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.my();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mN().bP("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Kd != null && TextUtils.equals(null, c.this.Kd.Js)) {
                            c.this.mx();
                            c.this.Kd = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Kf == null || !TextUtils.equals(null, c.this.Kf.Js)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.my();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mN().bP("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        mw();
    }

    public void q(String str, int i) {
        if (i == 1) {
            U(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.JV.contains(str)) {
            this.JV.remove(str);
        }
        if (!this.JX && z && this.JV.isEmpty()) {
            this.JX = true;
            if (this.JY != null) {
                this.JY.onInstallFinish(this.Ka);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            mz();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.JY = aVar;
        if (this.Kb != null) {
            this.Kb.cancel();
            this.Kb = null;
        }
        this.Kb = new a(context);
        this.Kb.setPriority(4);
        this.Kb.execute(new String[0]);
    }

    public boolean bL(String str) {
        if (this.Kd != null) {
            return TextUtils.equals(str, this.Kd.Js);
        }
        if (this.Kf != null) {
            return TextUtils.equals(str, this.Kf.Js);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(Context context, String str) {
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
        PluginSetting bU = PluginPackageManager.nd().bU(substring);
        if (substring != null && substring.length() > 0 && bU != null && bU.apkPath != null) {
            File file = new File(bU.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                InputStream inputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            f j = Util.j(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (j.compareTo(Util.j(inputStream)) == 0) {
                                if (this.JY != null) {
                                    this.JY.bJ(substring);
                                }
                                com.baidu.adp.plugin.b.a.mN().f("plugin_install", "install_timeequals", substring, j.toString());
                                com.baidu.adp.lib.g.a.h(fileInputStream);
                                com.baidu.adp.lib.g.a.h(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.h(fileInputStream);
                            com.baidu.adp.lib.g.a.h(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.mN().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.h(fileInputStream);
                            com.baidu.adp.lib.g.a.h(inputStream);
                            d(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.mN().e("plugin_install", substring, bU);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nN().cp(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.h(fileInputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.h(fileInputStream);
                    com.baidu.adp.lib.g.a.h(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.mN().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        d(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.mN().e("plugin_install", substring, bU);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nN().cp(substring)));
        return true;
    }

    public void V(Context context, String str) {
        d(context, "file://" + str, false);
    }

    private void d(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            mw();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.JT = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.JT = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Js = str2;
                if (a(pluginInstallTask) && z2) {
                    this.JV.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Js = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(pluginInstallTask.Js);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("file://")) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.mN().f("plugin_install", "start_service_install_status_error", pluginInstallTask.Js, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring("file://".length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_install", "start_service_file_not_find", pluginInstallTask.Js, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        com.baidu.adp.plugin.b.a.mN().f("plugin_install", "start_install_service", pluginInstallTask.Js, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra(ETAG.KEY_PACKAGE_NAME, pluginInstallTask.Js);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.nd().ne());
        if (pluginInstallTask.JS) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Kh == null && z) {
            this.Kh = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.mC();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                    if (c.this.Kd != null && TextUtils.equals(stringExtra, c.this.Kd.Js)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Kh, 1)) {
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

    public static File bM(String str) {
        PluginSetting bU = PluginPackageManager.nd().bU(str);
        if (bU == null || bU.apkPath == null || bU.apkPath.length() <= 0) {
            return null;
        }
        return new File(bU.apkPath);
    }

    private void mw() {
        if (!this.JU) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
                applicationContext.registerReceiver(this.JW, intentFilter);
                this.JU = true;
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
        synchronized (this.Kc) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Ke.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Kd != null) {
                Iterator<PluginInstallTask> it = this.Ke.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Js, next.Js)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Ke.add(pluginInstallTask);
                }
                return true;
            }
            this.Kd = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                mA();
                sHandler.removeCallbacks(this.Kl);
                sHandler.postDelayed(this.Kl, this.Kd.mu());
                return true;
            }
            this.Kd = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Kc) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Kg.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Kf != null) {
                Iterator<PluginInstallTask> it = this.Kg.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Js, next.Js)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Kg.add(pluginInstallTask);
                }
                return true;
            }
            this.Kf = pluginInstallTask;
            pluginInstallTask.JS = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Km);
                sHandler.postDelayed(this.Km, this.Kf.mu());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx() {
        sHandler.removeCallbacks(this.Kj);
        sHandler.removeCallbacks(this.Kl);
        sHandler.removeCallbacks(this.Kk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        this.Kf = null;
        sHandler.removeCallbacks(this.Km);
    }

    private void mz() {
        if (this.Kh != null) {
            BdBaseApplication.getInst().unbindService(this.Kh);
            this.Kh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA() {
        sHandler.removeCallbacks(this.Kj);
        sHandler.postDelayed(this.Kj, ErrDef.Feature.WEIGHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        if (this.messenger != null && this.Kd != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Kd));
                message.replyTo = this.Ki;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Kk);
            sHandler.postDelayed(this.Kk, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC() {
        this.Kh = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.mN().f("plugin_install", "system_kill_installprocess", this.Kd == null ? "" : this.Kd.Js, this.Ke.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kg.size());
        mx();
        mJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD() {
        com.baidu.adp.plugin.b.a.mN().bP("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.mN().f("plugin_install", "installprocess_noresponse", this.Kd == null ? "" : this.Kd.Js, this.Ke.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kg.size());
        mx();
        mG();
        mJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE() {
        if (this.Kd != null) {
            com.baidu.adp.plugin.packageManager.status.a.nN().h(this.Kd.Js, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Kd;
        if (!mH()) {
            com.baidu.adp.plugin.b.a.mN().bP("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.mN().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Js, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mu())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ke.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kg.size());
        } else {
            com.baidu.adp.plugin.b.a.mN().bP("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.mN().f("plugin_install", AiAppsBluetoothConstants.KEY_TIME_OUT, pluginInstallTask == null ? "" : pluginInstallTask.Js, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mu())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ke.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kg.size());
        }
        mx();
        mG();
        mJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF() {
        if (this.Kf != null) {
            com.baidu.adp.plugin.packageManager.status.a.nN().h(this.Kf.Js, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.mN().f("plugin_install", AiAppsBluetoothConstants.KEY_TIME_OUT, this.Kf == null ? "" : this.Kf.Js, "timeout-" + (this.Kf == null ? "" : Long.valueOf(this.Kf.mu())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ke.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kg.size());
        my();
    }

    private void mG() {
        if (this.Kh != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Kh);
        }
        this.Kh = null;
        this.messenger = null;
        int mI = mI();
        if (mI > 0 && mI != Process.myPid()) {
            Process.killProcess(mI);
        }
    }

    private boolean mH() {
        return mI() > 0;
    }

    private int mI() {
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

    private void mJ() {
        if (this.Kd != null) {
            com.baidu.adp.plugin.b.a.mN().I("plugin_retry_install", this.Kd.Js);
            com.baidu.adp.plugin.b.a.mN().f("plugin_install", "plugin_retry_install", this.Kd.Js, this.Kd.mu() + "");
            c(this.Kd);
            this.Kd = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Ko = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    n.h(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    n.h(inputStream);
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

        private boolean bN(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Ko) {
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
                    if (str != null && str.endsWith(".apk") && bN(str) && c.this.U(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.JY != null) {
                c.this.JY.onInstallFinish(c.this.Ka);
            }
        }
    }
}
