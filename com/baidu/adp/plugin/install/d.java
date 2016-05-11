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
    private static Handler eu = new Handler(Looper.getMainLooper());
    private static volatile d tK = null;
    private Messenger messenger;
    private ArrayList<String> tG;
    private BroadcastReceiver tH;
    private com.baidu.adp.plugin.install.a tJ;
    private c tO;
    private c tQ;
    private ServiceConnection tS;
    private boolean tF = false;
    private boolean tI = false;
    private boolean tL = true;
    private a tM = null;
    private final Object tN = new Object();
    private LinkedList<c> tP = new LinkedList<>();
    private LinkedList<c> tR = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger tT = new Messenger(this.handler);
    private Runnable tU = new f(this);
    private Runnable tV = new g(this);
    private Runnable tW = new h(this);
    private Runnable tX = new i(this);

    public static d ha() {
        if (tK == null) {
            synchronized (d.class) {
                if (tK == null) {
                    tK = new d();
                }
            }
        }
        return tK;
    }

    private d() {
        this.tG = null;
        this.tH = null;
        this.tG = new ArrayList<>();
        this.tH = new j(this);
        hb();
    }

    public void l(String str, int i) {
        if (i == 1) {
            n(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.tG.contains(str)) {
            this.tG.remove(str);
        }
        if (!this.tI && z && this.tG.isEmpty()) {
            this.tI = true;
            if (this.tJ != null) {
                this.tJ.G(this.tL);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            he();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.tJ = aVar;
        if (this.tM != null) {
            this.tM.cancel();
            this.tM = null;
        }
        this.tM = new a(context);
        this.tM.setPriority(4);
        this.tM.execute(new String[0]);
    }

    public boolean bb(String str) {
        if (this.tO != null) {
            return TextUtils.equals(str, this.tO.pkgName);
        }
        if (this.tQ != null) {
            return TextUtils.equals(str, this.tQ.pkgName);
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
    public boolean n(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bj = PluginPackageManager.hF().bj(substring);
            if (substring != null && substring.length() > 0 && bj != null && bj.apkPath != null) {
                File file = new File(bj.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.i e = Util.e(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (e.compareTo(Util.e(inputStream)) == 0) {
                                    if (this.tJ != null) {
                                        this.tJ.aZ(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "install_timeequals", substring, e.toString());
                                    com.baidu.adp.lib.h.a.c(fileInputStream);
                                    com.baidu.adp.lib.h.a.c(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.hs().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.hs().e("plugin_install", substring, bj);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.io().bF(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.h.a.c(r3);
                            com.baidu.adp.lib.h.a.c(null);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.h.a.c(lastIndexOf3);
                        com.baidu.adp.lib.h.a.c(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.hs().e("plugin_install", substring, bj);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.io().bF(substring)));
            return true;
        }
        return false;
    }

    public void o(Context context, String str) {
        a(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void a(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            hb();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.tE = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.tE = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.tG.add(str2);
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(cVar.pkgName);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.hs().e("plugin_install", "start_install_service", cVar.pkgName, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.hF().hG());
        if (cVar.tD) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.tS == null && z) {
            this.tS = new k(this, intent, context);
            if (context.bindService(intent, this.tS, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bc(String str) {
        PluginSetting bj = PluginPackageManager.hF().bj(str);
        if (bj == null || bj.apkPath == null || bj.apkPath.length() <= 0) {
            return null;
        }
        return new File(bj.apkPath);
    }

    private void hb() {
        if (!this.tF) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.tH, intentFilter);
                this.tF = true;
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
        synchronized (this.tN) {
            if (cVar == null) {
                cVar = this.tP.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.tO != null) {
                Iterator<c> it = this.tP.iterator();
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
                    this.tP.add(cVar);
                }
                return true;
            }
            this.tO = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                hf();
                eu.removeCallbacks(this.tW);
                eu.postDelayed(this.tW, this.tO.gZ());
                return true;
            }
            this.tO = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.tN) {
            if (cVar == null) {
                cVar = this.tR.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.tQ != null) {
                Iterator<c> it = this.tR.iterator();
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
                    this.tR.add(cVar);
                }
                return true;
            }
            this.tQ = cVar;
            cVar.tD = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                eu.removeCallbacks(this.tX);
                eu.postDelayed(this.tX, this.tQ.gZ());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc() {
        eu.removeCallbacks(this.tU);
        eu.removeCallbacks(this.tW);
        eu.removeCallbacks(this.tV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        this.tQ = null;
        eu.removeCallbacks(this.tX);
    }

    private void he() {
        if (this.tS != null) {
            BdBaseApplication.getInst().unbindService(this.tS);
            this.tS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        eu.removeCallbacks(this.tU);
        eu.postDelayed(this.tU, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg() {
        if (this.messenger != null && this.tO != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.tO));
                message.replyTo = this.tT;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            eu.removeCallbacks(this.tV);
            eu.postDelayed(this.tV, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh() {
        this.tS = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.hs().e("plugin_install", "system_kill_installprocess", this.tO == null ? "" : this.tO.pkgName, String.valueOf(this.tP.size()) + "-" + this.tR.size());
        hc();
        ho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi() {
        com.baidu.adp.plugin.b.a.hs().bf("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.hs().e("plugin_install", "installprocess_noresponse", this.tO == null ? "" : this.tO.pkgName, String.valueOf(this.tP.size()) + "-" + this.tR.size());
        hc();
        hl();
        ho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj() {
        if (this.tO != null) {
            com.baidu.adp.plugin.packageManager.a.b.io().j(this.tO.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.tO;
        if (!hm()) {
            com.baidu.adp.plugin.b.a.hs().bf("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.hs().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.gZ())) + "-" + this.tP.size() + "-" + this.tR.size());
        } else {
            com.baidu.adp.plugin.b.a.hs().bf("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.hs().e("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.gZ())) + "-" + this.tP.size() + "-" + this.tR.size());
        }
        hc();
        hl();
        ho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk() {
        if (this.tQ != null) {
            com.baidu.adp.plugin.packageManager.a.b.io().j(this.tQ.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.hs().e("plugin_install", "timeout", this.tQ == null ? "" : this.tQ.pkgName, "timeout-" + (this.tQ == null ? "" : Long.valueOf(this.tQ.gZ())) + "-" + this.tP.size() + "-" + this.tR.size());
        hd();
    }

    private void hl() {
        if (this.tS != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.tS);
        }
        this.tS = null;
        this.messenger = null;
        int hn = hn();
        if (hn > 0 && hn != Process.myPid()) {
            Process.killProcess(hn);
        }
    }

    private boolean hm() {
        return hn() > 0;
    }

    private int hn() {
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

    private void ho() {
        if (this.tO != null) {
            com.baidu.adp.plugin.b.a.hs().D("plugin_retry_install", this.tO.pkgName);
            com.baidu.adp.plugin.b.a.hs().e("plugin_install", "plugin_retry_install", this.tO.pkgName, new StringBuilder(String.valueOf(this.tO.gZ())).toString());
            c(this.tO);
            this.tO = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] tZ = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

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
                                            com.baidu.adp.plugin.packageManager.a.a aVar = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJson(optJSONObject, com.baidu.adp.plugin.packageManager.a.a.class);
                                            if (aVar != null) {
                                                hashMap.put(str2, aVar);
                                            }
                                        }
                                    }
                                    o.c(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.c(inputStream);
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

        private boolean bd(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.tZ) {
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
                    if (str != null && str.endsWith(".apk") && bd(str) && d.this.n(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.tJ != null) {
                d.this.tJ.G(d.this.tL);
            }
        }
    }
}
