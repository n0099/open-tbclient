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
    private ArrayList<String> Kd;
    private BroadcastReceiver Ke;
    private com.baidu.adp.plugin.install.a Kg;
    private PluginInstallTask Kl;
    private PluginInstallTask Kn;
    private ServiceConnection Kp;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c Kh = null;
    private boolean Kc = false;
    private boolean Kf = false;
    private boolean Ki = true;
    private a Kj = null;
    private final Object Kk = new Object();
    private LinkedList<PluginInstallTask> Km = new LinkedList<>();
    private LinkedList<PluginInstallTask> Ko = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Kl != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Jz, c.this.Kl.Jz)) {
                        c.sHandler.removeCallbacks(c.this.Ks);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Kq = new Messenger(this.handler);
    private Runnable Kr = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.mG();
            c.this.mF();
        }
    };
    private Runnable Ks = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mI();
        }
    };
    private Runnable Kt = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.mJ();
        }
    };
    private Runnable Ku = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.mK();
        }
    };

    public static c mA() {
        if (Kh == null) {
            synchronized (c.class) {
                if (Kh == null) {
                    Kh = new c();
                }
            }
        }
        return Kh;
    }

    private c() {
        this.Kd = null;
        this.Ke = null;
        this.Kd = new ArrayList<>();
        this.Ke = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 134=5, 135=5, 136=5, 138=6, 127=6] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Kl != null && TextUtils.equals(null, c.this.Kl.Jz)) {
                            c.this.mC();
                            c.this.Kl = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Kn == null || !TextUtils.equals(null, c.this.Kn.Jz)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.mD();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mS().bP("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra("package_name");
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Kl != null && TextUtils.equals(str, c.this.Kl.Jz)) {
                                    c.this.mC();
                                    c.this.Kl = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Kn == null || !TextUtils.equals(str, c.this.Kn.Jz)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.mD();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.mS().bP("plugin_retry_install_succ");
                                    return;
                                }
                            }
                            String stringExtra = intent.getStringExtra("install_src_file");
                            if (stringExtra != null && stringExtra.startsWith("assets://")) {
                                z = true;
                            }
                            String action = intent.getAction();
                            if ("com.baidu.adp.plugin.installed".equals(action)) {
                                c.this.f(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.nS().cn(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.Ki = false;
                                }
                                c.this.f(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.nS().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.f(str, z);
                            } else if ("com.baidu.adp.plugin.installrepeat".equals(action)) {
                            }
                            if (c.this.Kl != null && TextUtils.equals(str, c.this.Kl.Jz)) {
                                c.this.mC();
                                c.this.Kl = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kn == null || !TextUtils.equals(str, c.this.Kn.Jz)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.mD();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mS().bP("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Kl != null && TextUtils.equals(str, c.this.Kl.Jz)) {
                                c.this.mC();
                                c.this.Kl = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kn == null || !TextUtils.equals(str, c.this.Kn.Jz)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.mD();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mS().bP("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Kl != null && TextUtils.equals(null, c.this.Kl.Jz)) {
                            c.this.mC();
                            c.this.Kl = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Kn == null || !TextUtils.equals(null, c.this.Kn.Jz)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.mD();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mS().bP("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        mB();
    }

    public void q(String str, int i) {
        if (i == 1) {
            U(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, boolean z) {
        if (this.Kd.contains(str)) {
            this.Kd.remove(str);
        }
        if (!this.Kf && z && this.Kd.isEmpty()) {
            this.Kf = true;
            if (this.Kg != null) {
                this.Kg.ao(this.Ki);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            mE();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Kg = aVar;
        if (this.Kj != null) {
            this.Kj.cancel();
            this.Kj = null;
        }
        this.Kj = new a(context);
        this.Kj.setPriority(4);
        this.Kj.execute(new String[0]);
    }

    public boolean bL(String str) {
        if (this.Kl != null) {
            return TextUtils.equals(str, this.Kl.Jz);
        }
        if (this.Kn != null) {
            return TextUtils.equals(str, this.Kn.Jz);
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
        PluginSetting bU = PluginPackageManager.ni().bU(substring);
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
                            f k = Util.k(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (k.compareTo(Util.k(inputStream)) == 0) {
                                if (this.Kg != null) {
                                    this.Kg.bJ(substring);
                                }
                                com.baidu.adp.plugin.b.a.mS().f("plugin_install", "install_timeequals", substring, k.toString());
                                com.baidu.adp.lib.g.a.i(fileInputStream);
                                com.baidu.adp.lib.g.a.i(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.i(fileInputStream);
                            com.baidu.adp.lib.g.a.i(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.mS().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.i(fileInputStream);
                            com.baidu.adp.lib.g.a.i(inputStream);
                            d(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.mS().e("plugin_install", substring, bU);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nS().co(substring)));
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.i(fileInputStream);
                        com.baidu.adp.lib.g.a.i(inputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    com.baidu.adp.lib.g.a.i(fileInputStream);
                    com.baidu.adp.lib.g.a.i(inputStream);
                    throw th;
                }
            } else {
                com.baidu.adp.plugin.b.a.mS().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        d(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.mS().e("plugin_install", substring, bU);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nS().co(substring)));
        return true;
    }

    public void V(Context context, String str) {
        d(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void d(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            mB();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.Kb = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.Kb = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Jz = str2;
                if (a(pluginInstallTask) && z2) {
                    this.Kd.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Jz = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nL().findPluginSetting(pluginInstallTask.Jz);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                com.baidu.adp.plugin.b.a.mS().f("plugin_install", "start_service_install_status_error", pluginInstallTask.Jz, "apkFilePath_" + pluginInstallTask.apkFilePath);
                return false;
            }
            String substring = pluginInstallTask.apkFilePath.substring(SkiaImageDecoder.FILE_PREFIX.length());
            try {
                if (!new File(substring).exists()) {
                    com.baidu.adp.plugin.b.a.mS().f("plugin_install", "start_service_file_not_find", pluginInstallTask.Jz, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        com.baidu.adp.plugin.b.a.mS().f("plugin_install", "start_install_service", pluginInstallTask.Jz, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.Jz);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.ni().nj());
        if (pluginInstallTask.Ka) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Kp == null && z) {
            this.Kp = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.mH();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra("package_name");
                    if (c.this.Kl != null && TextUtils.equals(stringExtra, c.this.Kl.Jz)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Kp, 1)) {
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
        PluginSetting bU = PluginPackageManager.ni().bU(str);
        if (bU == null || bU.apkPath == null || bU.apkPath.length() <= 0) {
            return null;
        }
        return new File(bU.apkPath);
    }

    private void mB() {
        if (!this.Kc) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
                applicationContext.registerReceiver(this.Ke, intentFilter);
                this.Kc = true;
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
        synchronized (this.Kk) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Km.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Kl != null) {
                Iterator<PluginInstallTask> it = this.Km.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Jz, next.Jz)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Km.add(pluginInstallTask);
                }
                return true;
            }
            this.Kl = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                mF();
                sHandler.removeCallbacks(this.Kt);
                sHandler.postDelayed(this.Kt, this.Kl.mz());
                return true;
            }
            this.Kl = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Kk) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Ko.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Kn != null) {
                Iterator<PluginInstallTask> it = this.Ko.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Jz, next.Jz)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Ko.add(pluginInstallTask);
                }
                return true;
            }
            this.Kn = pluginInstallTask;
            pluginInstallTask.Ka = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Ku);
                sHandler.postDelayed(this.Ku, this.Kn.mz());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC() {
        sHandler.removeCallbacks(this.Kr);
        sHandler.removeCallbacks(this.Kt);
        sHandler.removeCallbacks(this.Ks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD() {
        this.Kn = null;
        sHandler.removeCallbacks(this.Ku);
    }

    private void mE() {
        if (this.Kp != null) {
            BdBaseApplication.getInst().unbindService(this.Kp);
            this.Kp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF() {
        sHandler.removeCallbacks(this.Kr);
        sHandler.postDelayed(this.Kr, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG() {
        if (this.messenger != null && this.Kl != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Kl));
                message.replyTo = this.Kq;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Ks);
            sHandler.postDelayed(this.Ks, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH() {
        this.Kp = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.mS().f("plugin_install", "system_kill_installprocess", this.Kl == null ? "" : this.Kl.Jz, this.Km.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko.size());
        mC();
        mO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI() {
        com.baidu.adp.plugin.b.a.mS().bP("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.mS().f("plugin_install", "installprocess_noresponse", this.Kl == null ? "" : this.Kl.Jz, this.Km.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko.size());
        mC();
        mL();
        mO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        if (this.Kl != null) {
            com.baidu.adp.plugin.packageManager.status.a.nS().h(this.Kl.Jz, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Kl;
        if (!mM()) {
            com.baidu.adp.plugin.b.a.mS().bP("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.mS().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Jz, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mz())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Km.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko.size());
        } else {
            com.baidu.adp.plugin.b.a.mS().bP("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.mS().f("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Jz, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mz())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Km.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko.size());
        }
        mC();
        mL();
        mO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK() {
        if (this.Kn != null) {
            com.baidu.adp.plugin.packageManager.status.a.nS().h(this.Kn.Jz, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.mS().f("plugin_install", "timeout", this.Kn == null ? "" : this.Kn.Jz, "timeout-" + (this.Kn == null ? "" : Long.valueOf(this.Kn.mz())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Km.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ko.size());
        mD();
    }

    private void mL() {
        if (this.Kp != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Kp);
        }
        this.Kp = null;
        this.messenger = null;
        int mN = mN();
        if (mN > 0 && mN != Process.myPid()) {
            Process.killProcess(mN);
        }
    }

    private boolean mM() {
        return mN() > 0;
    }

    private int mN() {
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

    private void mO() {
        if (this.Kl != null) {
            com.baidu.adp.plugin.b.a.mS().H("plugin_retry_install", this.Kl.Jz);
            com.baidu.adp.plugin.b.a.mS().f("plugin_install", "plugin_retry_install", this.Kl.Jz, this.Kl.mz() + "");
            c(this.Kl);
            this.Kl = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Kw = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    n.i(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    n.i(inputStream);
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
                for (String str2 : this.Kw) {
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
            if (!z && c.this.Kg != null) {
                c.this.Kg.ao(c.this.Ki);
            }
        }
    }
}
