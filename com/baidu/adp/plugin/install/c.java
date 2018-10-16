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
    private ArrayList<String> JS;
    private BroadcastReceiver JT;
    private com.baidu.adp.plugin.install.a JV;
    private PluginInstallTask Ka;
    private PluginInstallTask Kc;
    private ServiceConnection Ke;
    private Messenger messenger;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c JW = null;
    private boolean JR = false;
    private boolean JU = false;
    private boolean JX = true;
    private a JY = null;
    private final Object JZ = new Object();
    private LinkedList<PluginInstallTask> Kb = new LinkedList<>();
    private LinkedList<PluginInstallTask> Kd = new LinkedList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.plugin.install.c.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.Ka != null && message != null) {
                try {
                    if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).Jp, c.this.Ka.Jp)) {
                        c.sHandler.removeCallbacks(c.this.Kh);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private Messenger Kf = new Messenger(this.handler);
    private Runnable Kg = new Runnable() { // from class: com.baidu.adp.plugin.install.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.mE();
            c.this.mD();
        }
    };
    private Runnable Kh = new Runnable() { // from class: com.baidu.adp.plugin.install.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mG();
        }
    };
    private Runnable Ki = new Runnable() { // from class: com.baidu.adp.plugin.install.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.mH();
        }
    };
    private Runnable Kj = new Runnable() { // from class: com.baidu.adp.plugin.install.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.mI();
        }
    };

    public static c my() {
        if (JW == null) {
            synchronized (c.class) {
                if (JW == null) {
                    JW = new c();
                }
            }
        }
        return JW;
    }

    private c() {
        this.JS = null;
        this.JT = null;
        this.JS = new ArrayList<>();
        this.JT = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.install.c.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 129=5, 130=5, 131=5, 132=5, 133=5, 135=6, 124=6, 125=5, 126=5, 127=5] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                boolean z = false;
                try {
                    if (intent == null) {
                        if (c.this.Ka != null && TextUtils.equals(null, c.this.Ka.Jp)) {
                            c.this.mA();
                            c.this.Ka = null;
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else if (c.this.Kc == null || !TextUtils.equals(null, c.this.Kc.Jp)) {
                            c.this.a((PluginInstallTask) null);
                            return;
                        } else {
                            c.this.mB();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mQ().bP("plugin_retry_install_succ");
                            return;
                        }
                    }
                    try {
                        str = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                if (c.this.Ka != null && TextUtils.equals(str, c.this.Ka.Jp)) {
                                    c.this.mA();
                                    c.this.Ka = null;
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else if (c.this.Kc == null || !TextUtils.equals(str, c.this.Kc.Jp)) {
                                    c.this.a((PluginInstallTask) null);
                                    return;
                                } else {
                                    c.this.mB();
                                    c.this.a((PluginInstallTask) null);
                                    com.baidu.adp.plugin.b.a.mQ().bP("plugin_retry_install_succ");
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
                                com.baidu.adp.plugin.packageManager.status.a.nM().cn(str);
                            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                                if (z) {
                                    c.this.JX = false;
                                }
                                c.this.h(str, z);
                                com.baidu.adp.plugin.packageManager.status.a.nM().h(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                                c.this.h(str, z);
                            }
                            if (c.this.Ka != null && TextUtils.equals(str, c.this.Ka.Jp)) {
                                c.this.mA();
                                c.this.Ka = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kc == null || !TextUtils.equals(str, c.this.Kc.Jp)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.mB();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mQ().bP("plugin_retry_install_succ");
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            if (c.this.Ka != null && TextUtils.equals(str, c.this.Ka.Jp)) {
                                c.this.mA();
                                c.this.Ka = null;
                                c.this.a((PluginInstallTask) null);
                            } else if (c.this.Kc == null || !TextUtils.equals(str, c.this.Kc.Jp)) {
                                c.this.a((PluginInstallTask) null);
                            } else {
                                c.this.mB();
                                c.this.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.mQ().bP("plugin_retry_install_succ");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                        if (c.this.Ka != null && TextUtils.equals(null, c.this.Ka.Jp)) {
                            c.this.mA();
                            c.this.Ka = null;
                            c.this.a((PluginInstallTask) null);
                        } else if (c.this.Kc == null || !TextUtils.equals(null, c.this.Kc.Jp)) {
                            c.this.a((PluginInstallTask) null);
                        } else {
                            c.this.mB();
                            c.this.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.mQ().bP("plugin_retry_install_succ");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        mz();
    }

    public void q(String str, int i) {
        if (i == 1) {
            U(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.JS.contains(str)) {
            this.JS.remove(str);
        }
        if (!this.JU && z && this.JS.isEmpty()) {
            this.JU = true;
            if (this.JV != null) {
                this.JV.onInstallFinish(this.JX);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            mC();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.JV = aVar;
        if (this.JY != null) {
            this.JY.cancel();
            this.JY = null;
        }
        this.JY = new a(context);
        this.JY.setPriority(4);
        this.JY.execute(new String[0]);
    }

    public boolean bL(String str) {
        if (this.Ka != null) {
            return TextUtils.equals(str, this.Ka.Jp);
        }
        if (this.Kc != null) {
            return TextUtils.equals(str, this.Kc.Jp);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [250=5, 251=4] */
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
        PluginSetting bT = PluginPackageManager.nd().bT(substring);
        if (substring != null && substring.length() > 0 && bT != null && bT.apkPath != null) {
            File file = new File(bT.apkPath);
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
                                if (this.JV != null) {
                                    this.JV.bJ(substring);
                                }
                                com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "install_timeequals", substring, j.toString());
                                com.baidu.adp.lib.g.a.h(fileInputStream);
                                com.baidu.adp.lib.g.a.h(inputStream);
                                return false;
                            }
                            com.baidu.adp.lib.g.a.h(fileInputStream);
                            com.baidu.adp.lib.g.a.h(inputStream);
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.h(fileInputStream);
                            com.baidu.adp.lib.g.a.h(inputStream);
                            d(context, "assets://" + str, false);
                            com.baidu.adp.plugin.b.a.mQ().e("plugin_install", substring, bT);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nM().co(substring)));
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
                com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        d(context, "assets://" + str, false);
        com.baidu.adp.plugin.b.a.mQ().e("plugin_install", substring, bT);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.nM().co(substring)));
        return true;
    }

    public void V(Context context, String str) {
        d(context, "file://" + str, false);
    }

    private void d(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            mz();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.JQ = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.JQ = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Jp = str2;
                if (a(pluginInstallTask) && z2) {
                    this.JS.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Jp = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(final Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nF().findPluginSetting(pluginInstallTask.Jp);
        boolean z = pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://");
        com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "start_install_service", pluginInstallTask.Jp, pluginInstallTask.apkFilePath);
        final Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra(ETAG.KEY_PACKAGE_NAME, pluginInstallTask.Jp);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.nd().ne());
        if (pluginInstallTask.JP) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Ke == null && z) {
            this.Ke = new ServiceConnection() { // from class: com.baidu.adp.plugin.install.c.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.mF();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.messenger = new Messenger(iBinder);
                    String stringExtra = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                    if (c.this.Ka != null && TextUtils.equals(stringExtra, c.this.Ka.Jp)) {
                        try {
                            context.startService(intent);
                        } catch (Throwable th2) {
                        }
                    }
                }
            };
            if (context.bindService(intent, this.Ke, 1)) {
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
        PluginSetting bT = PluginPackageManager.nd().bT(str);
        if (bT == null || bT.apkPath == null || bT.apkPath.length() <= 0) {
            return null;
        }
        return new File(bT.apkPath);
    }

    private void mz() {
        if (!this.JR) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.JT, intentFilter);
                this.JR = true;
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
        synchronized (this.JZ) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Kb.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Ka != null) {
                Iterator<PluginInstallTask> it = this.Kb.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Jp, next.Jp)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Kb.add(pluginInstallTask);
                }
                return true;
            }
            this.Ka = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                mD();
                sHandler.removeCallbacks(this.Ki);
                sHandler.postDelayed(this.Ki, this.Ka.mx());
                return true;
            }
            this.Ka = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.JZ) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Kd.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Kc != null) {
                Iterator<PluginInstallTask> it = this.Kd.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Jp, next.Jp)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Kd.add(pluginInstallTask);
                }
                return true;
            }
            this.Kc = pluginInstallTask;
            pluginInstallTask.JP = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                sHandler.removeCallbacks(this.Kj);
                sHandler.postDelayed(this.Kj, this.Kc.mx());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA() {
        sHandler.removeCallbacks(this.Kg);
        sHandler.removeCallbacks(this.Ki);
        sHandler.removeCallbacks(this.Kh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        this.Kc = null;
        sHandler.removeCallbacks(this.Kj);
    }

    private void mC() {
        if (this.Ke != null) {
            BdBaseApplication.getInst().unbindService(this.Ke);
            this.Ke = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD() {
        sHandler.removeCallbacks(this.Kg);
        sHandler.postDelayed(this.Kg, ErrDef.Feature.WEIGHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE() {
        if (this.messenger != null && this.Ka != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Ka));
                message.replyTo = this.Kf;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            sHandler.removeCallbacks(this.Kh);
            sHandler.postDelayed(this.Kh, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF() {
        this.Ke = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "system_kill_installprocess", this.Ka == null ? "" : this.Ka.Jp, this.Kb.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kd.size());
        mA();
        mM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG() {
        com.baidu.adp.plugin.b.a.mQ().bP("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "installprocess_noresponse", this.Ka == null ? "" : this.Ka.Jp, this.Kb.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kd.size());
        mA();
        mJ();
        mM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH() {
        if (this.Ka != null) {
            com.baidu.adp.plugin.packageManager.status.a.nM().h(this.Ka.Jp, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Ka;
        if (!mK()) {
            com.baidu.adp.plugin.b.a.mQ().bP("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Jp, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mx())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kb.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kd.size());
        } else {
            com.baidu.adp.plugin.b.a.mQ().bP("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.mQ().f("plugin_install", AiAppsBluetoothConstants.KEY_TIME_OUT, pluginInstallTask == null ? "" : pluginInstallTask.Jp, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.mx())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kb.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kd.size());
        }
        mA();
        mJ();
        mM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI() {
        if (this.Kc != null) {
            com.baidu.adp.plugin.packageManager.status.a.nM().h(this.Kc.Jp, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.mQ().f("plugin_install", AiAppsBluetoothConstants.KEY_TIME_OUT, this.Kc == null ? "" : this.Kc.Jp, "timeout-" + (this.Kc == null ? "" : Long.valueOf(this.Kc.mx())) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kb.size() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Kd.size());
        mB();
    }

    private void mJ() {
        if (this.Ke != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Ke);
        }
        this.Ke = null;
        this.messenger = null;
        int mL = mL();
        if (mL > 0 && mL != Process.myPid()) {
            Process.killProcess(mL);
        }
    }

    private boolean mK() {
        return mL() > 0;
    }

    private int mL() {
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

    private void mM() {
        if (this.Ka != null) {
            com.baidu.adp.plugin.b.a.mQ().I("plugin_retry_install", this.Ka.Jp);
            com.baidu.adp.plugin.b.a.mQ().f("plugin_install", "plugin_retry_install", this.Ka.Jp, this.Ka.mx() + "");
            c(this.Ka);
            this.Ka = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Kl = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                for (String str2 : this.Kl) {
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
            if (!z && c.this.JV != null) {
                c.this.JV.onInstallFinish(c.this.JX);
            }
        }
    }
}
