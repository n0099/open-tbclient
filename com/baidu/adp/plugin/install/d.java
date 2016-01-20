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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
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
public class d {
    private ArrayList<String> CZ;
    private BroadcastReceiver Da;
    private com.baidu.adp.plugin.install.a Dc;
    private c Dh;
    private c Dj;
    private ServiceConnection Dl;
    private Messenger messenger;
    private static Handler oz = new Handler(Looper.getMainLooper());
    private static volatile d Dd = null;
    private boolean CY = false;
    private boolean Db = false;
    private boolean De = true;
    private a Df = null;
    private final Object Dg = new Object();
    private LinkedList<c> Di = new LinkedList<>();
    private LinkedList<c> Dk = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger Dm = new Messenger(this.handler);
    private Runnable Dn = new f(this);
    private Runnable Do = new g(this);
    private Runnable Dp = new h(this);
    private Runnable Dq = new i(this);

    public static d kO() {
        if (Dd == null) {
            synchronized (d.class) {
                if (Dd == null) {
                    Dd = new d();
                }
            }
        }
        return Dd;
    }

    private d() {
        this.CZ = null;
        this.Da = null;
        this.CZ = new ArrayList<>();
        this.Da = new j(this);
        kP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, boolean z) {
        if (this.CZ.contains(str)) {
            this.CZ.remove(str);
        }
        if (!this.Db && z && this.CZ.isEmpty()) {
            this.Db = true;
            if (this.Dc != null) {
                this.Dc.H(this.De);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            kS();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Dc = aVar;
        if (this.Df != null) {
            this.Df.cancel();
            this.Df = null;
        }
        this.Df = new a(context);
        this.Df.setPriority(4);
        this.Df.execute(new String[0]);
    }

    public boolean bk(String str) {
        if (this.Dh != null) {
            return TextUtils.equals(str, this.Dh.pkgName);
        }
        if (this.Dj != null) {
            return TextUtils.equals(str, this.Dj.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4, 257=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0165 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    public boolean w(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bs = PluginPackageManager.ls().bs(substring);
            if (substring != null && substring.length() > 0 && bs != null && bs.apkPath != null) {
                File file = new File(bs.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.h g = Util.g(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (g.compareTo(Util.g(inputStream)) == 0) {
                                    if (this.Dc != null) {
                                        this.Dc.bi(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lf().d("plugin_install", "install_timeequals", substring, g.toString());
                                    com.baidu.adp.lib.h.a.e(fileInputStream);
                                    com.baidu.adp.lib.h.a.e(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lf().d("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                                c(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lf().e("plugin_install", substring, bs);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.lV().bO(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.h.a.e((InputStream) r3);
                            com.baidu.adp.lib.h.a.e((InputStream) null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.h.a.e((InputStream) lastIndexOf3);
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.lf().d("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            c(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", substring, bs);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.lV().bO(substring)));
            return true;
        }
        return false;
    }

    public void x(Context context, String str) {
        c(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            kP();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.CX = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.CX = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.CZ.add(str2);
                    return;
                }
                return;
            }
            cVar.pkgName = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(cVar.pkgName);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "start_install_service", cVar.pkgName, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        if (cVar.CW) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Dl == null && z) {
            this.Dl = new k(this, intent, context);
            if (context.bindService(intent, this.Dl, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bl(String str) {
        PluginSetting bs = PluginPackageManager.ls().bs(str);
        if (bs == null || bs.apkPath == null || bs.apkPath.length() <= 0) {
            return null;
        }
        return new File(bs.apkPath);
    }

    private void kP() {
        if (!this.CY) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.Da, intentFilter);
                this.CY = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar) {
        if (b(cVar)) {
            return true;
        }
        return c(cVar);
    }

    private boolean b(c cVar) {
        boolean z = false;
        synchronized (this.Dg) {
            if (cVar == null) {
                cVar = this.Di.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dh != null) {
                Iterator<c> it = this.Di.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Di.add(cVar);
                }
                return true;
            }
            this.Dh = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                kT();
                oz.removeCallbacks(this.Dp);
                oz.postDelayed(this.Dp, this.Dh.kN());
                return true;
            }
            this.Dh = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.Dg) {
            if (cVar == null) {
                cVar = this.Dk.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dj != null) {
                Iterator<c> it = this.Dk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dk.add(cVar);
                }
                return true;
            }
            this.Dj = cVar;
            cVar.CW = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oz.removeCallbacks(this.Dq);
                oz.postDelayed(this.Dq, this.Dj.kN());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ() {
        oz.removeCallbacks(this.Dn);
        oz.removeCallbacks(this.Dp);
        oz.removeCallbacks(this.Do);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR() {
        this.Dj = null;
        oz.removeCallbacks(this.Dq);
    }

    private void kS() {
        if (this.Dl != null) {
            BdBaseApplication.getInst().unbindService(this.Dl);
            this.Dl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT() {
        oz.removeCallbacks(this.Dn);
        oz.postDelayed(this.Dn, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU() {
        if (this.messenger != null && this.Dh != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.Dh));
                message.replyTo = this.Dm;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oz.removeCallbacks(this.Do);
            oz.postDelayed(this.Do, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV() {
        this.Dl = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "system_kill_installprocess", this.Dh == null ? "" : this.Dh.pkgName, String.valueOf(this.Di.size()) + "-" + this.Dk.size());
        kQ();
        lc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW() {
        com.baidu.adp.plugin.b.a.lf().bo("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "installprocess_noresponse", this.Dh == null ? "" : this.Dh.pkgName, String.valueOf(this.Di.size()) + "-" + this.Dk.size());
        kQ();
        kZ();
        lc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX() {
        if (this.Dh != null) {
            com.baidu.adp.plugin.packageManager.a.b.lV().j(this.Dh.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.Dh;
        if (!la()) {
            com.baidu.adp.plugin.b.a.lf().bo("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lf().d("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kN())) + "-" + this.Di.size() + "-" + this.Dk.size());
        } else {
            com.baidu.adp.plugin.b.a.lf().bo("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lf().d("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kN())) + "-" + this.Di.size() + "-" + this.Dk.size());
        }
        kQ();
        kZ();
        lc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY() {
        if (this.Dj != null) {
            com.baidu.adp.plugin.packageManager.a.b.lV().j(this.Dj.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "timeout", this.Dj == null ? "" : this.Dj.pkgName, "timeout-" + (this.Dj == null ? "" : Long.valueOf(this.Dj.kN())) + "-" + this.Di.size() + "-" + this.Dk.size());
        kR();
    }

    private void kZ() {
        if (this.Dl != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Dl);
        }
        this.Dl = null;
        this.messenger = null;
        int lb = lb();
        if (lb > 0 && lb != Process.myPid()) {
            Process.killProcess(lb);
        }
    }

    private boolean la() {
        return lb() > 0;
    }

    private int lb() {
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

    private void lc() {
        if (this.Dh != null) {
            com.baidu.adp.plugin.b.a.lf().E("plugin_retry_install", this.Dh.pkgName);
            com.baidu.adp.plugin.b.a.lf().d("plugin_install", "plugin_retry_install", this.Dh.pkgName, new StringBuilder(String.valueOf(this.Dh.kN())).toString());
            c(this.Dh);
            this.Dh = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Ds = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
        private Context mContext;

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
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
                                            com.baidu.adp.plugin.packageManager.a.a aVar = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJson(optJSONObject, com.baidu.adp.plugin.packageManager.a.a.class);
                                            if (aVar != null) {
                                                hashMap.put(str2, aVar);
                                            }
                                        }
                                    }
                                    o.e(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.e(inputStream);
                                }
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new l(this, hashMap));
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

        private boolean bm(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Ds) {
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
        /* renamed from: h */
        public void onPostExecute(String[] strArr) {
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && bm(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.Dc != null) {
                d.this.Dc.H(d.this.De);
            }
        }
    }
}
