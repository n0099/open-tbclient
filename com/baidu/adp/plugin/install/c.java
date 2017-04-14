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
import com.baidu.adp.lib.util.o;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.adp.plugin.util.Util;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private ArrayList<String> Dd;
    private BroadcastReceiver De;
    private com.baidu.adp.plugin.install.a Dg;
    private PluginInstallTask Dl;
    private PluginInstallTask Dn;
    private ServiceConnection Dp;
    private Messenger messenger;
    private static Handler oz = new Handler(Looper.getMainLooper());
    private static volatile c Dh = null;
    private boolean Dc = false;
    private boolean Df = false;
    private boolean Di = true;
    private a Dj = null;
    private final Object Dk = new Object();
    private LinkedList<PluginInstallTask> Dm = new LinkedList<>();
    private LinkedList<PluginInstallTask> Do = new LinkedList<>();
    private Handler handler = new d(this, Looper.getMainLooper());
    private Messenger Dq = new Messenger(this.handler);
    private Runnable Dr = new e(this);
    private Runnable Ds = new f(this);
    private Runnable Dt = new g(this);
    private Runnable Du = new h(this);

    public static c iS() {
        if (Dh == null) {
            synchronized (c.class) {
                if (Dh == null) {
                    Dh = new c();
                }
            }
        }
        return Dh;
    }

    private c() {
        this.Dd = null;
        this.De = null;
        this.Dd = new ArrayList<>();
        this.De = new i(this);
        iT();
    }

    public void l(String str, int i) {
        if (i == 1) {
            G(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.Dd.contains(str)) {
            this.Dd.remove(str);
        }
        if (!this.Df && z && this.Dd.isEmpty()) {
            this.Df = true;
            if (this.Dg != null) {
                this.Dg.L(this.Di);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            iW();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Dg = aVar;
        if (this.Dj != null) {
            this.Dj.cancel();
            this.Dj = null;
        }
        this.Dj = new a(context);
        this.Dj.setPriority(4);
        this.Dj.execute(new String[0]);
    }

    public boolean aR(String str) {
        if (this.Dl != null) {
            return TextUtils.equals(str, this.Dl.Cz);
        }
        if (this.Dn != null) {
            return TextUtils.equals(str, this.Dn.Cz);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [272=4, 273=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0165 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    public boolean G(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting aZ = PluginPackageManager.jx().aZ(substring);
            if (substring != null && substring.length() > 0 && aZ != null && aZ.apkPath != null) {
                File file = new File(aZ.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.i l = Util.l(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (l.compareTo(Util.l(inputStream)) == 0) {
                                    if (this.Dg != null) {
                                        this.Dg.aP(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "install_timeequals", substring, l.toString());
                                    com.baidu.adp.lib.g.a.j(fileInputStream);
                                    com.baidu.adp.lib.g.a.j(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.g.a.j(fileInputStream);
                                com.baidu.adp.lib.g.a.j(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.g.a.j(fileInputStream);
                                com.baidu.adp.lib.g.a.j(inputStream);
                                b(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.jk().e("plugin_install", substring, aZ);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.kh().bu(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.g.a.j(r3);
                            com.baidu.adp.lib.g.a.j(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.g.a.j(lastIndexOf3);
                        com.baidu.adp.lib.g.a.j(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            b(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", substring, aZ);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.kh().bu(substring)));
            return true;
        }
        return false;
    }

    public void H(Context context, String str) {
        b(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void b(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            iT();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.Db = context.getAssets().open(str.substring("assets://".length())).available();
                    z2 = true;
                    str2 = substring;
                } catch (IOException e) {
                    BdLog.detailException(e);
                    z2 = true;
                    str2 = substring;
                }
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
                pluginInstallTask.Db = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.Cz = str2;
                if (a(pluginInstallTask) && z2) {
                    this.Dd.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.Cz = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(Context context, PluginInstallTask pluginInstallTask) {
        boolean z = false;
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().findPluginSetting(pluginInstallTask.Cz);
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "start_install_service", pluginInstallTask.Cz, pluginInstallTask.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.Cz);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.jx().jy());
        if (pluginInstallTask.Da) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Dp == null && z) {
            this.Dp = new j(this, intent, context);
            if (context.bindService(intent, this.Dp, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File aS(String str) {
        PluginSetting aZ = PluginPackageManager.jx().aZ(str);
        if (aZ == null || aZ.apkPath == null || aZ.apkPath.length() <= 0) {
            return null;
        }
        return new File(aZ.apkPath);
    }

    private void iT() {
        if (!this.Dc) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.De, intentFilter);
                this.Dc = true;
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
        synchronized (this.Dk) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Dm.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Dl != null) {
                Iterator<PluginInstallTask> it = this.Dm.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Cz, next.Cz)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dm.add(pluginInstallTask);
                }
                return true;
            }
            this.Dl = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                iX();
                oz.removeCallbacks(this.Dt);
                oz.postDelayed(this.Dt, this.Dl.iR());
                return true;
            }
            this.Dl = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.Dk) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.Do.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.Dn != null) {
                Iterator<PluginInstallTask> it = this.Do.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.Cz, next.Cz)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Do.add(pluginInstallTask);
                }
                return true;
            }
            this.Dn = pluginInstallTask;
            pluginInstallTask.Da = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                oz.removeCallbacks(this.Du);
                oz.postDelayed(this.Du, this.Dn.iR());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU() {
        oz.removeCallbacks(this.Dr);
        oz.removeCallbacks(this.Dt);
        oz.removeCallbacks(this.Ds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV() {
        this.Dn = null;
        oz.removeCallbacks(this.Du);
    }

    private void iW() {
        if (this.Dp != null) {
            BdBaseApplication.getInst().unbindService(this.Dp);
            this.Dp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX() {
        oz.removeCallbacks(this.Dr);
        oz.postDelayed(this.Dr, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY() {
        if (this.messenger != null && this.Dl != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.Dl));
                message.replyTo = this.Dq;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oz.removeCallbacks(this.Ds);
            oz.postDelayed(this.Ds, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        this.Dp = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "system_kill_installprocess", this.Dl == null ? "" : this.Dl.Cz, String.valueOf(this.Dm.size()) + "-" + this.Do.size());
        iU();
        jg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        com.baidu.adp.plugin.b.a.jk().aV("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "installprocess_noresponse", this.Dl == null ? "" : this.Dl.Cz, String.valueOf(this.Dm.size()) + "-" + this.Do.size());
        iU();
        jd();
        jg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb() {
        if (this.Dl != null) {
            com.baidu.adp.plugin.packageManager.status.a.kh().g(this.Dl.Cz, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.Dl;
        if (!je()) {
            com.baidu.adp.plugin.b.a.jk().aV("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.Cz, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iR())) + "-" + this.Dm.size() + "-" + this.Do.size());
        } else {
            com.baidu.adp.plugin.b.a.jk().aV("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.Cz, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.iR())) + "-" + this.Dm.size() + "-" + this.Do.size());
        }
        iU();
        jd();
        jg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc() {
        if (this.Dn != null) {
            com.baidu.adp.plugin.packageManager.status.a.kh().g(this.Dn.Cz, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "timeout", this.Dn == null ? "" : this.Dn.Cz, "timeout-" + (this.Dn == null ? "" : Long.valueOf(this.Dn.iR())) + "-" + this.Dm.size() + "-" + this.Do.size());
        iV();
    }

    private void jd() {
        if (this.Dp != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Dp);
        }
        this.Dp = null;
        this.messenger = null;
        int jf = jf();
        if (jf > 0 && jf != Process.myPid()) {
            Process.killProcess(jf);
        }
    }

    private boolean je() {
        return jf() > 0;
    }

    private int jf() {
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

    private void jg() {
        if (this.Dl != null) {
            com.baidu.adp.plugin.b.a.jk().B("plugin_retry_install", this.Dl.Cz);
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "plugin_retry_install", this.Dl.Cz, new StringBuilder(String.valueOf(this.Dl.iR())).toString());
            c(this.Dl);
            this.Dl = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Dw = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                            HashMap hashMap = new HashMap();
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
                                            String str2 = !str.endsWith(".apk") ? String.valueOf(str) + ".apk" : str;
                                            PluginStatus pluginStatus = (PluginStatus) PluginStatus.objectWithJson(optJSONObject, PluginStatus.class);
                                            if (pluginStatus != null) {
                                                hashMap.put(str2, pluginStatus);
                                            }
                                        }
                                    }
                                    o.j(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.j(inputStream);
                                }
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new k(this, hashMap));
                                return list;
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

        private boolean aT(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Dw) {
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
                    if (str != null && str.endsWith(".apk") && aT(str) && c.this.G(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.Dg != null) {
                c.this.Dg.L(c.this.Di);
            }
        }
    }
}
