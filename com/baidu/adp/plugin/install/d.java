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
    private ArrayList<String> CB;
    private BroadcastReceiver CC;
    private com.baidu.adp.plugin.install.a CE;
    private c CJ;
    private c CL;
    private ServiceConnection CN;
    private Messenger messenger;
    private static Handler oy = new Handler(Looper.getMainLooper());
    private static volatile d CF = null;
    private boolean CA = false;
    private boolean CD = false;
    private boolean CG = true;
    private a CH = null;
    private final Object CI = new Object();
    private LinkedList<c> CK = new LinkedList<>();
    private LinkedList<c> CM = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger CO = new Messenger(this.handler);
    private Runnable CP = new f(this);
    private Runnable CQ = new g(this);
    private Runnable CR = new h(this);
    private Runnable CS = new i(this);

    public static d lq() {
        if (CF == null) {
            synchronized (d.class) {
                if (CF == null) {
                    CF = new d();
                }
            }
        }
        return CF;
    }

    private d() {
        this.CB = null;
        this.CC = null;
        this.CB = new ArrayList<>();
        this.CC = new j(this);
        lr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.CB.contains(str)) {
            this.CB.remove(str);
        }
        if (!this.CD && z && this.CB.isEmpty()) {
            this.CD = true;
            if (this.CE != null) {
                this.CE.L(this.CG);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.CE = aVar;
        if (this.CH != null) {
            this.CH.cancel();
            this.CH = null;
        }
        this.CH = new a(context);
        this.CH.setPriority(4);
        this.CH.execute(new String[0]);
    }

    public boolean bd(String str) {
        if (this.CJ != null) {
            return TextUtils.equals(str, this.CJ.pkgName);
        }
        if (this.CL != null) {
            return TextUtils.equals(str, this.CL.pkgName);
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
            PluginSetting bl = PluginPackageManager.lS().bl(substring);
            if (substring != null && substring.length() > 0 && bl != null && bl.apkPath != null) {
                File file = new File(bl.apkPath);
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
                                    if (this.CE != null) {
                                        this.CE.bb(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lG().d("plugin_install", "install_timeequals", substring, f.toString());
                                    com.baidu.adp.lib.g.a.d(fileInputStream);
                                    com.baidu.adp.lib.g.a.d(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lG().d("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                                c(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lG().a("plugin_install", substring, bl);
                                com.baidu.adp.plugin.b.a.lG().d("plugin_install", "plugin_install", substring, null);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mu().bG(substring)));
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
                    com.baidu.adp.plugin.b.a.lG().d("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            c(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lG().a("plugin_install", substring, bl);
            com.baidu.adp.plugin.b.a.lG().d("plugin_install", "plugin_install", substring, null);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mu().bG(substring)));
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
            lr();
            String str3 = null;
            c cVar = new c();
            cVar.Cx = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.Cz = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.Cz = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.CB.add(str2);
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
        com.baidu.adp.plugin.b.a.lG().d("plugin_install", "start_install_service", cVar.pkgName, cVar.Cx);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.Cx);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (cVar.Cy) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.CN == null) {
            this.CN = new k(this, context, intent);
            if (context.bindService(intent, this.CN, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File be(String str) {
        PluginSetting bl = PluginPackageManager.lS().bl(str);
        if (bl == null || bl.apkPath == null || bl.apkPath.length() <= 0) {
            return null;
        }
        return new File(bl.apkPath);
    }

    private void lr() {
        if (!this.CA) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.CC, intentFilter);
                this.CA = true;
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
        synchronized (this.CI) {
            if (cVar == null) {
                cVar = this.CK.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CJ != null) {
                Iterator<c> it = this.CK.iterator();
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
                    this.CK.add(cVar);
                }
                return true;
            }
            this.CJ = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                lu();
                oy.removeCallbacks(this.CR);
                oy.postDelayed(this.CR, this.CJ.lp());
                return true;
            }
            this.CJ = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.CI) {
            if (cVar == null) {
                cVar = this.CM.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CL != null) {
                Iterator<c> it = this.CM.iterator();
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
                    this.CM.add(cVar);
                }
                return true;
            }
            this.CL = cVar;
            cVar.Cy = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oy.removeCallbacks(this.CS);
                oy.postDelayed(this.CS, this.CL.lp());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        oy.removeCallbacks(this.CP);
        oy.removeCallbacks(this.CR);
        oy.removeCallbacks(this.CQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        this.CL = null;
        oy.removeCallbacks(this.CS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        oy.removeCallbacks(this.CP);
        oy.postDelayed(this.CP, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        if (this.messenger != null && this.CJ != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.CJ));
                message.replyTo = this.CO;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oy.removeCallbacks(this.CQ);
            oy.postDelayed(this.CQ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        this.CN = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lG().bh("plugin_system_kill_installprocess");
        com.baidu.adp.plugin.b.a.lG().d("plugin_install", "system_kill_installprocess", this.CJ == null ? "" : this.CJ.pkgName, String.valueOf(this.CK.size()) + "-" + this.CM.size());
        ls();
        lD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        com.baidu.adp.plugin.b.a.lG().bh("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lG().d("plugin_install", "installprocess_noresponse", this.CJ == null ? "" : this.CJ.pkgName, String.valueOf(this.CK.size()) + "-" + this.CM.size());
        ls();
        lA();
        lD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        if (this.CJ != null) {
            com.baidu.adp.plugin.packageManager.a.b.mu().h(this.CJ.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.CJ;
        if (!lB()) {
            com.baidu.adp.plugin.b.a.lG().bh("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lG().d("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.lp())) + "-" + this.CK.size() + "-" + this.CM.size());
        } else {
            com.baidu.adp.plugin.b.a.lG().bh("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lG().d("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.lp())) + "-" + this.CK.size() + "-" + this.CM.size());
        }
        ls();
        lA();
        lD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        if (this.CL != null) {
            com.baidu.adp.plugin.packageManager.a.b.mu().h(this.CL.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lG().d("plugin_install", "timeout", this.CL == null ? "" : this.CL.pkgName, "timeout-" + (this.CL == null ? "" : Long.valueOf(this.CL.lp())) + "-" + this.CK.size() + "-" + this.CM.size());
        lt();
    }

    private void lA() {
        if (this.CN != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.CN);
        }
        this.CN = null;
        this.messenger = null;
        int lC = lC();
        if (lC > 0 && lC != Process.myPid()) {
            Process.killProcess(lC);
        }
    }

    private boolean lB() {
        return lC() > 0;
    }

    private int lC() {
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

    private void lD() {
        if (this.CJ != null) {
            com.baidu.adp.plugin.b.a.lG().I("plugin_retry_install", this.CJ.pkgName);
            com.baidu.adp.plugin.b.a.lG().d("plugin_install", "plugin_retry_install", this.CJ.pkgName, new StringBuilder(String.valueOf(this.CJ.lp())).toString());
            c(this.CJ);
            this.CJ = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] CU = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean bf(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.CU) {
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
                    if (str != null && str.endsWith(".apk") && bf(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.CE != null) {
                d.this.CE.L(d.this.CG);
            }
        }
    }
}
