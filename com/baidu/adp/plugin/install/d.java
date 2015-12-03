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
    private ArrayList<String> CH;
    private BroadcastReceiver CI;
    private com.baidu.adp.plugin.install.a CK;
    private c CP;
    private c CR;
    private ServiceConnection CT;
    private Messenger messenger;
    private static Handler oz = new Handler(Looper.getMainLooper());
    private static volatile d CL = null;
    private boolean CG = false;
    private boolean CJ = false;
    private boolean CM = true;
    private a CN = null;
    private final Object CO = new Object();
    private LinkedList<c> CQ = new LinkedList<>();
    private LinkedList<c> CS = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger CU = new Messenger(this.handler);
    private Runnable CV = new f(this);
    private Runnable CW = new g(this);
    private Runnable CX = new h(this);
    private Runnable CY = new i(this);

    public static d lr() {
        if (CL == null) {
            synchronized (d.class) {
                if (CL == null) {
                    CL = new d();
                }
            }
        }
        return CL;
    }

    private d() {
        this.CH = null;
        this.CI = null;
        this.CH = new ArrayList<>();
        this.CI = new j(this);
        ls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, boolean z) {
        if (this.CH.contains(str)) {
            this.CH.remove(str);
        }
        if (!this.CJ && z && this.CH.isEmpty()) {
            this.CJ = true;
            if (this.CK != null) {
                this.CK.L(this.CM);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            lv();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.CK = aVar;
        if (this.CN != null) {
            this.CN.cancel();
            this.CN = null;
        }
        this.CN = new a(context);
        this.CN.setPriority(4);
        this.CN.execute(new String[0]);
    }

    public boolean bh(String str) {
        if (this.CP != null) {
            return TextUtils.equals(str, this.CP.pkgName);
        }
        if (this.CR != null) {
            return TextUtils.equals(str, this.CR.pkgName);
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
            PluginSetting bp = PluginPackageManager.lU().bp(substring);
            if (substring != null && substring.length() > 0 && bp != null && bp.apkPath != null) {
                File file = new File(bp.apkPath);
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
                                    if (this.CK != null) {
                                        this.CK.bf(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lI().d("plugin_install", "install_timeequals", substring, g.toString());
                                    com.baidu.adp.lib.h.a.e(fileInputStream);
                                    com.baidu.adp.lib.h.a.e(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lI().d("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.e(fileInputStream);
                                com.baidu.adp.lib.h.a.e(inputStream);
                                c(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lI().e("plugin_install", substring, bp);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mx().bL(substring)));
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
                    com.baidu.adp.plugin.b.a.lI().d("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            c(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lI().e("plugin_install", substring, bp);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mx().bL(substring)));
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
            ls();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.CF = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.CF = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.CH.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(cVar.pkgName);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.lI().d("plugin_install", "start_install_service", cVar.pkgName, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        if (cVar.CE) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.CT == null && z) {
            this.CT = new k(this, intent, context);
            if (context.bindService(intent, this.CT, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bi(String str) {
        PluginSetting bp = PluginPackageManager.lU().bp(str);
        if (bp == null || bp.apkPath == null || bp.apkPath.length() <= 0) {
            return null;
        }
        return new File(bp.apkPath);
    }

    private void ls() {
        if (!this.CG) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.CI, intentFilter);
                this.CG = true;
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
        synchronized (this.CO) {
            if (cVar == null) {
                cVar = this.CQ.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CP != null) {
                Iterator<c> it = this.CQ.iterator();
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
                    this.CQ.add(cVar);
                }
                return true;
            }
            this.CP = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                lw();
                oz.removeCallbacks(this.CX);
                oz.postDelayed(this.CX, this.CP.lq());
                return true;
            }
            this.CP = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.CO) {
            if (cVar == null) {
                cVar = this.CS.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CR != null) {
                Iterator<c> it = this.CS.iterator();
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
                    this.CS.add(cVar);
                }
                return true;
            }
            this.CR = cVar;
            cVar.CE = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oz.removeCallbacks(this.CY);
                oz.postDelayed(this.CY, this.CR.lq());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        oz.removeCallbacks(this.CV);
        oz.removeCallbacks(this.CX);
        oz.removeCallbacks(this.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        this.CR = null;
        oz.removeCallbacks(this.CY);
    }

    private void lv() {
        if (this.CT != null) {
            BdBaseApplication.getInst().unbindService(this.CT);
            this.CT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        oz.removeCallbacks(this.CV);
        oz.postDelayed(this.CV, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        if (this.messenger != null && this.CP != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.CP));
                message.replyTo = this.CU;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oz.removeCallbacks(this.CW);
            oz.postDelayed(this.CW, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        this.CT = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lI().d("plugin_install", "system_kill_installprocess", this.CP == null ? "" : this.CP.pkgName, String.valueOf(this.CQ.size()) + "-" + this.CS.size());
        lt();
        lF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        com.baidu.adp.plugin.b.a.lI().bl("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lI().d("plugin_install", "installprocess_noresponse", this.CP == null ? "" : this.CP.pkgName, String.valueOf(this.CQ.size()) + "-" + this.CS.size());
        lt();
        lC();
        lF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (this.CP != null) {
            com.baidu.adp.plugin.packageManager.a.b.mx().j(this.CP.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.CP;
        if (!lD()) {
            com.baidu.adp.plugin.b.a.lI().bl("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lI().d("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.lq())) + "-" + this.CQ.size() + "-" + this.CS.size());
        } else {
            com.baidu.adp.plugin.b.a.lI().bl("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lI().d("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.lq())) + "-" + this.CQ.size() + "-" + this.CS.size());
        }
        lt();
        lC();
        lF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB() {
        if (this.CR != null) {
            com.baidu.adp.plugin.packageManager.a.b.mx().j(this.CR.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lI().d("plugin_install", "timeout", this.CR == null ? "" : this.CR.pkgName, "timeout-" + (this.CR == null ? "" : Long.valueOf(this.CR.lq())) + "-" + this.CQ.size() + "-" + this.CS.size());
        lu();
    }

    private void lC() {
        if (this.CT != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.CT);
        }
        this.CT = null;
        this.messenger = null;
        int lE = lE();
        if (lE > 0 && lE != Process.myPid()) {
            Process.killProcess(lE);
        }
    }

    private boolean lD() {
        return lE() > 0;
    }

    private int lE() {
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

    private void lF() {
        if (this.CP != null) {
            com.baidu.adp.plugin.b.a.lI().F("plugin_retry_install", this.CP.pkgName);
            com.baidu.adp.plugin.b.a.lI().d("plugin_install", "plugin_retry_install", this.CP.pkgName, new StringBuilder(String.valueOf(this.CP.lq())).toString());
            c(this.CP);
            this.CP = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] Da = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
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

        private boolean bj(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.Da) {
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
                    if (str != null && str.endsWith(".apk") && bj(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.CK != null) {
                d.this.CK.L(d.this.CM);
            }
        }
    }
}
