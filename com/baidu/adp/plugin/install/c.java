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
    private static Handler hg = new Handler(Looper.getMainLooper());
    private static volatile c ws = null;
    private Messenger messenger;
    private ServiceConnection wA;
    private ArrayList<String> wo;
    private BroadcastReceiver wp;
    private com.baidu.adp.plugin.install.a wr;
    private PluginInstallTask ww;
    private PluginInstallTask wy;
    private boolean wn = false;
    private boolean wq = false;
    private boolean wt = true;
    private a wu = null;
    private final Object wv = new Object();
    private LinkedList<PluginInstallTask> wx = new LinkedList<>();
    private LinkedList<PluginInstallTask> wz = new LinkedList<>();
    private Handler handler = new d(this, Looper.getMainLooper());
    private Messenger wB = new Messenger(this.handler);
    private Runnable wC = new e(this);
    private Runnable wD = new f(this);
    private Runnable wE = new g(this);
    private Runnable wF = new h(this);

    public static c hU() {
        if (ws == null) {
            synchronized (c.class) {
                if (ws == null) {
                    ws = new c();
                }
            }
        }
        return ws;
    }

    private c() {
        this.wo = null;
        this.wp = null;
        this.wo = new ArrayList<>();
        this.wp = new i(this);
        hV();
    }

    public void l(String str, int i) {
        if (i == 1) {
            o(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.wo.contains(str)) {
            this.wo.remove(str);
        }
        if (!this.wq && z && this.wo.isEmpty()) {
            this.wq = true;
            if (this.wr != null) {
                this.wr.K(this.wt);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            hY();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.wr = aVar;
        if (this.wu != null) {
            this.wu.cancel();
            this.wu = null;
        }
        this.wu = new a(context);
        this.wu.setPriority(4);
        this.wu.execute(new String[0]);
    }

    public boolean bc(String str) {
        if (this.ww != null) {
            return TextUtils.equals(str, this.ww.vK);
        }
        if (this.wy != null) {
            return TextUtils.equals(str, this.wy.vK);
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
    public boolean o(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bk = PluginPackageManager.iz().bk(substring);
            if (substring != null && substring.length() > 0 && bk != null && bk.apkPath != null) {
                File file = new File(bk.apkPath);
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
                                    if (this.wr != null) {
                                        this.wr.ba(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.im().e("plugin_install", "install_timeequals", substring, l.toString());
                                    com.baidu.adp.lib.g.a.j(fileInputStream);
                                    com.baidu.adp.lib.g.a.j(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.g.a.j(fileInputStream);
                                com.baidu.adp.lib.g.a.j(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.im().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.g.a.j(fileInputStream);
                                com.baidu.adp.lib.g.a.j(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.im().e("plugin_install", substring, bk);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.jj().bF(substring)));
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
                    com.baidu.adp.plugin.b.a.im().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.im().e("plugin_install", substring, bk);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.status.a.jj().bF(substring)));
            return true;
        }
        return false;
    }

    public void p(Context context, String str) {
        a(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void a(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            hV();
            String str3 = null;
            PluginInstallTask pluginInstallTask = new PluginInstallTask();
            pluginInstallTask.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    pluginInstallTask.wm = context.getAssets().open(str.substring("assets://".length())).available();
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
                pluginInstallTask.wm = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                pluginInstallTask.vK = str2;
                if (a(pluginInstallTask) && z2) {
                    this.wo.add(str2);
                    return;
                }
                return;
            }
            pluginInstallTask.vK = str;
            a(pluginInstallTask);
        }
    }

    private boolean a(Context context, PluginInstallTask pluginInstallTask) {
        boolean z = false;
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().findPluginSetting(pluginInstallTask.vK);
        if (pluginInstallTask.apkFilePath != null && pluginInstallTask.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.im().e("plugin_install", "start_install_service", pluginInstallTask.vK, pluginInstallTask.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.apkFilePath);
        intent.putExtra("package_name", pluginInstallTask.vK);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.iz().iA());
        if (pluginInstallTask.wl) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.wA == null && z) {
            this.wA = new j(this, intent, context);
            if (context.bindService(intent, this.wA, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bd(String str) {
        PluginSetting bk = PluginPackageManager.iz().bk(str);
        if (bk == null || bk.apkPath == null || bk.apkPath.length() <= 0) {
            return null;
        }
        return new File(bk.apkPath);
    }

    private void hV() {
        if (!this.wn) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.wp, intentFilter);
                this.wn = true;
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
        synchronized (this.wv) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.wx.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.ww != null) {
                Iterator<PluginInstallTask> it = this.wx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.vK, next.vK)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.wx.add(pluginInstallTask);
                }
                return true;
            }
            this.ww = pluginInstallTask;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                hZ();
                hg.removeCallbacks(this.wE);
                hg.postDelayed(this.wE, this.ww.hT());
                return true;
            }
            this.ww = null;
            return a((PluginInstallTask) null);
        }
    }

    private boolean c(PluginInstallTask pluginInstallTask) {
        boolean z = false;
        synchronized (this.wv) {
            if (pluginInstallTask == null) {
                pluginInstallTask = this.wz.poll();
            }
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.wy != null) {
                Iterator<PluginInstallTask> it = this.wz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.vK, next.vK)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.wz.add(pluginInstallTask);
                }
                return true;
            }
            this.wy = pluginInstallTask;
            pluginInstallTask.wl = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                hg.removeCallbacks(this.wF);
                hg.postDelayed(this.wF, this.wy.hT());
                return true;
            }
            return a((PluginInstallTask) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW() {
        hg.removeCallbacks(this.wC);
        hg.removeCallbacks(this.wE);
        hg.removeCallbacks(this.wD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX() {
        this.wy = null;
        hg.removeCallbacks(this.wF);
    }

    private void hY() {
        if (this.wA != null) {
            BdBaseApplication.getInst().unbindService(this.wA);
            this.wA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ() {
        hg.removeCallbacks(this.wC);
        hg.postDelayed(this.wC, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.messenger != null && this.ww != null) {
            Message message = new Message();
            try {
                message.setData(OrmObject.bundleWithObject(this.ww));
                message.replyTo = this.wB;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            hg.removeCallbacks(this.wD);
            hg.postDelayed(this.wD, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        this.wA = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.im().e("plugin_install", "system_kill_installprocess", this.ww == null ? "" : this.ww.vK, String.valueOf(this.wx.size()) + "-" + this.wz.size());
        hW();
        ii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        com.baidu.adp.plugin.b.a.im().bg("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.im().e("plugin_install", "installprocess_noresponse", this.ww == null ? "" : this.ww.vK, String.valueOf(this.wx.size()) + "-" + this.wz.size());
        hW();
        m5if();
        ii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id() {
        if (this.ww != null) {
            com.baidu.adp.plugin.packageManager.status.a.jj().n(this.ww.vK, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.ww;
        if (!ig()) {
            com.baidu.adp.plugin.b.a.im().bg("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.im().e("plugin_install", "timeout_installprocess_notlive", pluginInstallTask == null ? "" : pluginInstallTask.vK, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.hT())) + "-" + this.wx.size() + "-" + this.wz.size());
        } else {
            com.baidu.adp.plugin.b.a.im().bg("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.im().e("plugin_install", "timeout", pluginInstallTask == null ? "" : pluginInstallTask.vK, "timeout-" + (pluginInstallTask == null ? "" : Long.valueOf(pluginInstallTask.hT())) + "-" + this.wx.size() + "-" + this.wz.size());
        }
        hW();
        m5if();
        ii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie() {
        if (this.wy != null) {
            com.baidu.adp.plugin.packageManager.status.a.jj().n(this.wy.vK, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.im().e("plugin_install", "timeout", this.wy == null ? "" : this.wy.vK, "timeout-" + (this.wy == null ? "" : Long.valueOf(this.wy.hT())) + "-" + this.wx.size() + "-" + this.wz.size());
        hX();
    }

    /* renamed from: if  reason: not valid java name */
    private void m5if() {
        if (this.wA != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.wA);
        }
        this.wA = null;
        this.messenger = null;
        int ih = ih();
        if (ih > 0 && ih != Process.myPid()) {
            Process.killProcess(ih);
        }
    }

    private boolean ig() {
        return ih() > 0;
    }

    private int ih() {
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

    private void ii() {
        if (this.ww != null) {
            com.baidu.adp.plugin.b.a.im().D("plugin_retry_install", this.ww.vK);
            com.baidu.adp.plugin.b.a.im().e("plugin_install", "plugin_retry_install", this.ww.vK, new StringBuilder(String.valueOf(this.ww.hT())).toString());
            c(this.ww);
            this.ww = null;
            return;
        }
        a((PluginInstallTask) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] wH = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

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

        private boolean be(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.wH) {
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
                    if (str != null && str.endsWith(".apk") && be(str) && c.this.o(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && c.this.wr != null) {
                c.this.wr.K(c.this.wt);
            }
        }
    }
}
