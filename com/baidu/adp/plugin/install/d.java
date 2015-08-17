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
    private BroadcastReceiver CA;
    private com.baidu.adp.plugin.install.a CB;
    private c CG;
    private c CI;
    private ServiceConnection CK;
    private ArrayList<String> Cz;
    private Messenger messenger;
    private static Handler oy = new Handler(Looper.getMainLooper());
    private static volatile d CC = null;
    private boolean Cy = false;
    private boolean CD = true;
    private a CE = null;
    private final Object CF = new Object();
    private LinkedList<c> CH = new LinkedList<>();
    private LinkedList<c> CJ = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger CL = new Messenger(this.handler);
    private Runnable CM = new f(this);
    private Runnable CN = new g(this);
    private Runnable CO = new h(this);
    private Runnable CP = new i(this);

    public static d lr() {
        if (CC == null) {
            synchronized (d.class) {
                if (CC == null) {
                    CC = new d();
                }
            }
        }
        return CC;
    }

    public d() {
        this.Cz = null;
        this.CA = null;
        this.Cz = new ArrayList<>();
        this.CA = new j(this);
        ls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.Cz.contains(str)) {
            this.Cz.remove(str);
        }
        if (z && this.Cz.isEmpty() && this.CB != null) {
            this.CB.L(this.CD);
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.CB = aVar;
        if (this.CE != null) {
            this.CE.cancel();
            this.CE = null;
        }
        this.CE = new a(context);
        this.CE.setPriority(4);
        this.CE.execute(new String[0]);
    }

    public boolean be(String str) {
        if (this.CG != null) {
            return TextUtils.equals(str, this.CG.pkgName);
        }
        if (this.CI != null) {
            return TextUtils.equals(str, this.CI.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=4, 239=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00b6 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public boolean w(Context context, String str) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".apk");
        if (lastIndexOf + 1 < lastIndexOf2) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bm = PluginPackageManager.lT().bm(substring);
            if (substring != null && substring.length() > 0 && bm != null && bm.apkPath != null) {
                File file = new File(bm.apkPath);
                if (file.exists() && file.isFile()) {
                    ?? r3 = (file.length() > 0L ? 1 : (file.length() == 0L ? 0 : -1));
                    try {
                        if (r3 > 0) {
                            try {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    com.baidu.adp.plugin.util.g f = Util.f(fileInputStream);
                                    inputStream = context.getAssets().open(str);
                                    if (f.compareTo(Util.f(inputStream)) == 0) {
                                        if (this.CB != null) {
                                            this.CB.bc(substring);
                                        }
                                        com.baidu.adp.lib.g.a.d(fileInputStream);
                                        com.baidu.adp.lib.g.a.d(inputStream);
                                        return false;
                                    }
                                    com.baidu.adp.lib.g.a.d(fileInputStream);
                                    com.baidu.adp.lib.g.a.d(inputStream);
                                } catch (Exception e) {
                                    e = e;
                                    BdLog.e(e);
                                    com.baidu.adp.lib.g.a.d(fileInputStream);
                                    com.baidu.adp.lib.g.a.d(inputStream);
                                    c(context, "assets://" + str, false);
                                    com.baidu.adp.plugin.b.a.lH().a("plugin_install", substring, bm);
                                    return true;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileInputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                r3 = 0;
                                com.baidu.adp.lib.g.a.d(r3);
                                com.baidu.adp.lib.g.a.d(null);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            c(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lH().a("plugin_install", substring, bm);
            return true;
        }
        return false;
    }

    public void x(Context context, String str) {
        c(context, "file://" + str, false);
    }

    private void c(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            ls();
            String str3 = null;
            c cVar = new c();
            cVar.Cv = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.Cx = context.getAssets().open(str.substring("assets://".length())).available();
                    z2 = true;
                    str2 = substring;
                } catch (IOException e) {
                    BdLog.detailException(e);
                    z2 = true;
                    str2 = substring;
                }
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
                cVar.Cx = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.Cz.add(str2);
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.mv().bG(cVar.pkgName)));
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.Cv);
        intent.putExtra("package_name", cVar.pkgName);
        if (cVar.Cw) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.CK == null) {
            this.CK = new k(this, context, intent);
            if (context.bindService(intent, this.CK, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bf(String str) {
        PluginSetting bm = PluginPackageManager.lT().bm(str);
        if (bm == null || bm.apkPath == null || bm.apkPath.length() <= 0) {
            return null;
        }
        return new File(bm.apkPath);
    }

    private void ls() {
        if (!this.Cy) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.CA, intentFilter);
                this.Cy = true;
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
        synchronized (this.CF) {
            if (cVar == null) {
                cVar = this.CH.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.CG != null) {
                Iterator<c> it = this.CH.iterator();
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
                    this.CH.add(cVar);
                }
                return true;
            }
            this.CG = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                lv();
                oy.removeCallbacks(this.CO);
                oy.postDelayed(this.CO, this.CG.lq());
                return true;
            }
            this.CG = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.CF) {
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
            cVar.Cw = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oy.removeCallbacks(this.CP);
                oy.postDelayed(this.CP, this.CI.lq());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        oy.removeCallbacks(this.CM);
        oy.removeCallbacks(this.CO);
        oy.removeCallbacks(this.CN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu() {
        this.CI = null;
        oy.removeCallbacks(this.CP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        oy.removeCallbacks(this.CM);
        oy.postDelayed(this.CM, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        if (this.messenger != null && this.CG != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.CG));
                message.replyTo = this.CL;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oy.removeCallbacks(this.CN);
            oy.postDelayed(this.CN, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        this.CK = null;
        this.messenger = null;
        lt();
        lE();
        com.baidu.adp.plugin.b.a.lH().bi("plugin_system_kill_installprocess");
        com.baidu.adp.plugin.b.a.lH().g("plugin_install", "system_kill_installprocess", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        lt();
        lB();
        lE();
        com.baidu.adp.plugin.b.a.lH().bi("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lH().g("plugin_install", "installprocess_noresponse", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        if (this.CG != null) {
            com.baidu.adp.plugin.packageManager.a.b.mv().h(this.CG.pkgName, "plugin_install_timeout", null);
        }
        lt();
        lB();
        lE();
        if (!lC()) {
            com.baidu.adp.plugin.b.a.lH().bi("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lH().g("plugin_install", "timeout_installprocess_notlive", null);
            return;
        }
        com.baidu.adp.plugin.b.a.lH().bi("plugin_install_timeout");
        com.baidu.adp.plugin.b.a.lH().g("plugin_install", "timeout", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (this.CI != null) {
            com.baidu.adp.plugin.packageManager.a.b.mv().h(this.CI.pkgName, "plugin_install_retry_timeout", null);
        }
        lu();
    }

    private void lB() {
        if (this.CK != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.CK);
        }
        this.CK = null;
        this.messenger = null;
        int lD = lD();
        if (lD > 0 && lD != Process.myPid()) {
            Process.killProcess(lD);
        }
    }

    private boolean lC() {
        return lD() > 0;
    }

    private int lD() {
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

    private void lE() {
        if (this.CG != null) {
            com.baidu.adp.plugin.b.a.lH().bi("plugin_retry_install");
            c(this.CG);
            this.CG = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] CR = {"com.baidu.tieba.pluginInjectCore"};
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

        private boolean bg(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.CR) {
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
                    if (str != null && str.endsWith(".apk") && bg(str) && d.this.w(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.CB != null) {
                d.this.CB.L(d.this.CD);
            }
        }
    }
}
