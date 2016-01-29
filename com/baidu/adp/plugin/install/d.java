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
    private ArrayList<String> Dj;
    private BroadcastReceiver Dk;
    private com.baidu.adp.plugin.install.a Dm;
    private c Dr;
    private c Dt;
    private ServiceConnection Dv;
    private Messenger messenger;
    private static Handler oC = new Handler(Looper.getMainLooper());
    private static volatile d Dn = null;
    private boolean Di = false;
    private boolean Dl = false;
    private boolean Do = true;
    private a Dp = null;
    private final Object Dq = new Object();
    private LinkedList<c> Ds = new LinkedList<>();
    private LinkedList<c> Du = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger Dw = new Messenger(this.handler);
    private Runnable Dx = new f(this);
    private Runnable Dy = new g(this);
    private Runnable Dz = new h(this);
    private Runnable DA = new i(this);

    public static d kY() {
        if (Dn == null) {
            synchronized (d.class) {
                if (Dn == null) {
                    Dn = new d();
                }
            }
        }
        return Dn;
    }

    private d() {
        this.Dj = null;
        this.Dk = null;
        this.Dj = new ArrayList<>();
        this.Dk = new j(this);
        kZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, boolean z) {
        if (this.Dj.contains(str)) {
            this.Dj.remove(str);
        }
        if (!this.Dl && z && this.Dj.isEmpty()) {
            this.Dl = true;
            if (this.Dm != null) {
                this.Dm.H(this.Do);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            lc();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Dm = aVar;
        if (this.Dp != null) {
            this.Dp.cancel();
            this.Dp = null;
        }
        this.Dp = new a(context);
        this.Dp.setPriority(4);
        this.Dp.execute(new String[0]);
    }

    public boolean bk(String str) {
        if (this.Dr != null) {
            return TextUtils.equals(str, this.Dr.pkgName);
        }
        if (this.Dt != null) {
            return TextUtils.equals(str, this.Dt.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4, 255=4] */
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
            PluginSetting bs = PluginPackageManager.lD().bs(substring);
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
                                    if (this.Dm != null) {
                                        this.Dm.bi(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lq().e("plugin_install", "install_timeequals", substring, g.toString());
                                    com.baidu.adp.lib.h.a.e(fileInputStream);
                                    com.baidu.adp.lib.h.a.e(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lq().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lq().e("plugin_install", substring, bs);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mi().bO(substring)));
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
                    com.baidu.adp.plugin.b.a.lq().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lq().e("plugin_install", substring, bs);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mi().bO(substring)));
            return true;
        }
        return false;
    }

    public void x(Context context, String str) {
        a(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void a(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            kZ();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.Dh = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.Dh = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.Dj.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(cVar.pkgName);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "start_install_service", cVar.pkgName, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.lD().lE());
        if (cVar.Dg) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.Dv == null && z) {
            this.Dv = new k(this, intent, context);
            if (context.bindService(intent, this.Dv, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bl(String str) {
        PluginSetting bs = PluginPackageManager.lD().bs(str);
        if (bs == null || bs.apkPath == null || bs.apkPath.length() <= 0) {
            return null;
        }
        return new File(bs.apkPath);
    }

    private void kZ() {
        if (!this.Di) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.Dk, intentFilter);
                this.Di = true;
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
        synchronized (this.Dq) {
            if (cVar == null) {
                cVar = this.Ds.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dr != null) {
                Iterator<c> it = this.Ds.iterator();
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
                    this.Ds.add(cVar);
                }
                return true;
            }
            this.Dr = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                ld();
                oC.removeCallbacks(this.Dz);
                oC.postDelayed(this.Dz, this.Dr.kX());
                return true;
            }
            this.Dr = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.Dq) {
            if (cVar == null) {
                cVar = this.Du.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dt != null) {
                Iterator<c> it = this.Du.iterator();
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
                    this.Du.add(cVar);
                }
                return true;
            }
            this.Dt = cVar;
            cVar.Dg = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oC.removeCallbacks(this.DA);
                oC.postDelayed(this.DA, this.Dt.kX());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        oC.removeCallbacks(this.Dx);
        oC.removeCallbacks(this.Dz);
        oC.removeCallbacks(this.Dy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        this.Dt = null;
        oC.removeCallbacks(this.DA);
    }

    private void lc() {
        if (this.Dv != null) {
            BdBaseApplication.getInst().unbindService(this.Dv);
            this.Dv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        oC.removeCallbacks(this.Dx);
        oC.postDelayed(this.Dx, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (this.messenger != null && this.Dr != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.Dr));
                message.replyTo = this.Dw;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oC.removeCallbacks(this.Dy);
            oC.postDelayed(this.Dy, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf() {
        this.Dv = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "system_kill_installprocess", this.Dr == null ? "" : this.Dr.pkgName, String.valueOf(this.Ds.size()) + "-" + this.Du.size());
        la();
        lm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        com.baidu.adp.plugin.b.a.lq().bo("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "installprocess_noresponse", this.Dr == null ? "" : this.Dr.pkgName, String.valueOf(this.Ds.size()) + "-" + this.Du.size());
        la();
        lj();
        lm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        if (this.Dr != null) {
            com.baidu.adp.plugin.packageManager.a.b.mi().j(this.Dr.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.Dr;
        if (!lk()) {
            com.baidu.adp.plugin.b.a.lq().bo("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lq().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kX())) + "-" + this.Ds.size() + "-" + this.Du.size());
        } else {
            com.baidu.adp.plugin.b.a.lq().bo("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lq().e("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kX())) + "-" + this.Ds.size() + "-" + this.Du.size());
        }
        la();
        lj();
        lm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.Dt != null) {
            com.baidu.adp.plugin.packageManager.a.b.mi().j(this.Dt.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "timeout", this.Dt == null ? "" : this.Dt.pkgName, "timeout-" + (this.Dt == null ? "" : Long.valueOf(this.Dt.kX())) + "-" + this.Ds.size() + "-" + this.Du.size());
        lb();
    }

    private void lj() {
        if (this.Dv != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.Dv);
        }
        this.Dv = null;
        this.messenger = null;
        int ll = ll();
        if (ll > 0 && ll != Process.myPid()) {
            Process.killProcess(ll);
        }
    }

    private boolean lk() {
        return ll() > 0;
    }

    private int ll() {
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

    private void lm() {
        if (this.Dr != null) {
            com.baidu.adp.plugin.b.a.lq().F("plugin_retry_install", this.Dr.pkgName);
            com.baidu.adp.plugin.b.a.lq().e("plugin_install", "plugin_retry_install", this.Dr.pkgName, new StringBuilder(String.valueOf(this.Dr.kX())).toString());
            c(this.Dr);
            this.Dr = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] DC = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                for (String str2 : this.DC) {
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
                    if (str != null && str.endsWith(".apk") && bm(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.Dm != null) {
                d.this.Dm.H(d.this.Do);
            }
        }
    }
}
