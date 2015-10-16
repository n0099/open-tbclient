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
    private ArrayList<String> CA;
    private BroadcastReceiver CB;
    private com.baidu.adp.plugin.install.a CD;
    private c CI;
    private c CK;
    private ServiceConnection CM;
    private Messenger messenger;
    private static Handler oy = new Handler(Looper.getMainLooper());
    private static volatile d CE = null;
    private boolean Cz = false;
    private boolean CC = false;
    private boolean CF = true;
    private a CG = null;
    private final Object CH = new Object();
    private LinkedList<c> CJ = new LinkedList<>();
    private LinkedList<c> CL = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger CN = new Messenger(this.handler);
    private Runnable CO = new f(this);
    private Runnable CP = new g(this);
    private Runnable CQ = new h(this);
    private Runnable CR = new i(this);

    public static d lp() {
        if (CE == null) {
            synchronized (d.class) {
                if (CE == null) {
                    CE = new d();
                }
            }
        }
        return CE;
    }

    private d() {
        this.CA = null;
        this.CB = null;
        this.CA = new ArrayList<>();
        this.CB = new j(this);
        lq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.CA.contains(str)) {
            this.CA.remove(str);
        }
        if (!this.CC && z && this.CA.isEmpty()) {
            this.CC = true;
            if (this.CD != null) {
                this.CD.L(this.CF);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.CD = aVar;
        if (this.CG != null) {
            this.CG.cancel();
            this.CG = null;
        }
        this.CG = new a(context);
        this.CG.setPriority(4);
        this.CG.execute(new String[0]);
    }

    public boolean bf(String str) {
        if (this.CI != null) {
            return TextUtils.equals(str, this.CI.pkgName);
        }
        if (this.CK != null) {
            return TextUtils.equals(str, this.CK.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4, 254=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0172 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStream] */
    public boolean w(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bn = PluginPackageManager.lR().bn(substring);
            if (substring != null && substring.length() > 0 && bn != null && bn.apkPath != null) {
                File file = new File(bn.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.g f = Util.f(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (f.compareTo(Util.f(inputStream)) == 0) {
                                    if (this.CD != null) {
                                        this.CD.bd(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lF().d("plugin_install", "install_timeequals", substring, f.toString());
                                    com.baidu.adp.lib.g.a.d(fileInputStream);
                                    com.baidu.adp.lib.g.a.d(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                                c(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lF().a("plugin_install", substring, bn);
                                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "plugin_install", substring, null);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mt().bI(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.g.a.d(r3);
                            com.baidu.adp.lib.g.a.d(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.g.a.d(lastIndexOf3);
                        com.baidu.adp.lib.g.a.d(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.lF().d("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            c(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lF().a("plugin_install", substring, bn);
            com.baidu.adp.plugin.b.a.lF().d("plugin_install", "plugin_install", substring, null);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mt().bI(substring)));
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
            lq();
            String str3 = null;
            c cVar = new c();
            cVar.Cw = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.Cy = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.Cy = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.CA.add(str2);
                    return;
                }
                return;
            }
            cVar.pkgName = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        if (cVar == null) {
            return false;
        }
        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "start_install_service", cVar.pkgName, cVar.Cw);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.Cw);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (cVar.Cx) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.CM == null) {
            this.CM = new k(this, context, intent);
            if (context.bindService(intent, this.CM, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bg(String str) {
        PluginSetting bn = PluginPackageManager.lR().bn(str);
        if (bn == null || bn.apkPath == null || bn.apkPath.length() <= 0) {
            return null;
        }
        return new File(bn.apkPath);
    }

    private void lq() {
        if (!this.Cz) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.CB, intentFilter);
                this.Cz = true;
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
        synchronized (this.CH) {
            if (cVar == null) {
                cVar = this.CJ.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CI != null) {
                Iterator<c> it = this.CJ.iterator();
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
                    this.CJ.add(cVar);
                }
                return true;
            }
            this.CI = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                lt();
                oy.removeCallbacks(this.CQ);
                oy.postDelayed(this.CQ, this.CI.lo());
                return true;
            }
            this.CI = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.CH) {
            if (cVar == null) {
                cVar = this.CL.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CK != null) {
                Iterator<c> it = this.CL.iterator();
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
                    this.CL.add(cVar);
                }
                return true;
            }
            this.CK = cVar;
            cVar.Cx = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oy.removeCallbacks(this.CR);
                oy.postDelayed(this.CR, this.CK.lo());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr() {
        oy.removeCallbacks(this.CO);
        oy.removeCallbacks(this.CQ);
        oy.removeCallbacks(this.CP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        this.CK = null;
        oy.removeCallbacks(this.CR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        oy.removeCallbacks(this.CO);
        oy.postDelayed(this.CO, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        if (this.messenger != null && this.CI != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.CI));
                message.replyTo = this.CN;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oy.removeCallbacks(this.CP);
            oy.postDelayed(this.CP, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        this.CM = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lF().bj("plugin_system_kill_installprocess");
        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "system_kill_installprocess", this.CI == null ? "" : this.CI.pkgName, String.valueOf(this.CJ.size()) + "-" + this.CL.size());
        lr();
        lC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        com.baidu.adp.plugin.b.a.lF().bj("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "installprocess_noresponse", this.CI == null ? "" : this.CI.pkgName, String.valueOf(this.CJ.size()) + "-" + this.CL.size());
        lr();
        lz();
        lC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        if (this.CI != null) {
            com.baidu.adp.plugin.packageManager.a.b.mt().h(this.CI.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.CI;
        if (!lA()) {
            com.baidu.adp.plugin.b.a.lF().bj("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lF().d("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + this.CI.lo() + "-" + this.CJ.size() + "-" + this.CL.size());
        } else {
            com.baidu.adp.plugin.b.a.lF().bj("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lF().d("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + this.CI.lo() + "-" + this.CJ.size() + "-" + this.CL.size());
        }
        lr();
        lz();
        lC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        if (this.CK != null) {
            com.baidu.adp.plugin.packageManager.a.b.mt().h(this.CK.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "timeout", this.CK == null ? "" : this.CK.pkgName, "timeout-" + this.CI.lo() + "-" + this.CJ.size() + "-" + this.CL.size());
        ls();
    }

    private void lz() {
        if (this.CM != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.CM);
        }
        this.CM = null;
        this.messenger = null;
        int lB = lB();
        if (lB > 0 && lB != Process.myPid()) {
            Process.killProcess(lB);
        }
    }

    private boolean lA() {
        return lB() > 0;
    }

    private int lB() {
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

    private void lC() {
        if (this.CI != null) {
            com.baidu.adp.plugin.b.a.lF().I("plugin_retry_install", this.CI.pkgName);
            com.baidu.adp.plugin.b.a.lF().d("plugin_install", "plugin_retry_install", this.CI.pkgName, new StringBuilder(String.valueOf(this.CI.lo())).toString());
            c(this.CI);
            this.CI = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] CT = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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
                                    o.d(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.d(inputStream);
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

        private boolean bh(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.CT) {
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
                    if (str != null && str.endsWith(".apk") && bh(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.CD != null) {
                d.this.CD.L(d.this.CF);
            }
        }
    }
}
