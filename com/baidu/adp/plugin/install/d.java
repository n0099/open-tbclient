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
    private static Handler eV = new Handler(Looper.getMainLooper());
    private static volatile d up = null;
    private Messenger messenger;
    private ArrayList<String> uk;
    private BroadcastReceiver ul;
    private com.baidu.adp.plugin.install.a uo;
    private c ut;
    private c uv;
    private ServiceConnection ux;
    private boolean uj = false;
    private boolean um = false;
    private boolean uq = true;
    private a ur = null;
    private final Object us = new Object();
    private LinkedList<c> uu = new LinkedList<>();
    private LinkedList<c> uw = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger uy = new Messenger(this.handler);
    private Runnable uz = new f(this);
    private Runnable uA = new g(this);
    private Runnable uB = new h(this);
    private Runnable uC = new i(this);

    public static d hb() {
        if (up == null) {
            synchronized (d.class) {
                if (up == null) {
                    up = new d();
                }
            }
        }
        return up;
    }

    private d() {
        this.uk = null;
        this.ul = null;
        this.uk = new ArrayList<>();
        this.ul = new j(this);
        hc();
    }

    public void l(String str, int i) {
        if (i == 1) {
            o(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.uk.contains(str)) {
            this.uk.remove(str);
        }
        if (!this.um && z && this.uk.isEmpty()) {
            this.um = true;
            if (this.uo != null) {
                this.uo.I(this.uq);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            hf();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.uo = aVar;
        if (this.ur != null) {
            this.ur.cancel();
            this.ur = null;
        }
        this.ur = new a(context);
        this.ur.setPriority(4);
        this.ur.execute(new String[0]);
    }

    public boolean bc(String str) {
        if (this.ut != null) {
            return TextUtils.equals(str, this.ut.tG);
        }
        if (this.uv != null) {
            return TextUtils.equals(str, this.uv.tG);
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
            PluginSetting bk = PluginPackageManager.hG().bk(substring);
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
                                    if (this.uo != null) {
                                        this.uo.ba(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.ht().e("plugin_install", "install_timeequals", substring, l.toString());
                                    com.baidu.adp.lib.h.a.j(fileInputStream);
                                    com.baidu.adp.lib.h.a.j(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.j(fileInputStream);
                                com.baidu.adp.lib.h.a.j(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.ht().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.j(fileInputStream);
                                com.baidu.adp.lib.h.a.j(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.ht().e("plugin_install", substring, bk);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.iq().bG(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.h.a.j(r3);
                            com.baidu.adp.lib.h.a.j(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.h.a.j(lastIndexOf3);
                        com.baidu.adp.lib.h.a.j(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.ht().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.ht().e("plugin_install", substring, bk);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.iq().bG(substring)));
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
            hc();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.ui = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.ui = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.tG = str2;
                if (a(cVar) && z2) {
                    this.uk.add(str2);
                    return;
                }
                return;
            }
            cVar.tG = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().findPluginSetting(cVar.tG);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.ht().e("plugin_install", "start_install_service", cVar.tG, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.tG);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.hG().hH());
        if (cVar.uh) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.ux == null && z) {
            this.ux = new k(this, intent, context);
            if (context.bindService(intent, this.ux, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bd(String str) {
        PluginSetting bk = PluginPackageManager.hG().bk(str);
        if (bk == null || bk.apkPath == null || bk.apkPath.length() <= 0) {
            return null;
        }
        return new File(bk.apkPath);
    }

    private void hc() {
        if (!this.uj) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.ul, intentFilter);
                this.uj = true;
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
        synchronized (this.us) {
            if (cVar == null) {
                cVar = this.uu.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.ut != null) {
                Iterator<c> it = this.uu.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.tG, next.tG)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.uu.add(cVar);
                }
                return true;
            }
            this.ut = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                hg();
                eV.removeCallbacks(this.uB);
                eV.postDelayed(this.uB, this.ut.ha());
                return true;
            }
            this.ut = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.us) {
            if (cVar == null) {
                cVar = this.uw.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.uv != null) {
                Iterator<c> it = this.uw.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.tG, next.tG)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.uw.add(cVar);
                }
                return true;
            }
            this.uv = cVar;
            cVar.uh = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                eV.removeCallbacks(this.uC);
                eV.postDelayed(this.uC, this.uv.ha());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        eV.removeCallbacks(this.uz);
        eV.removeCallbacks(this.uB);
        eV.removeCallbacks(this.uA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he() {
        this.uv = null;
        eV.removeCallbacks(this.uC);
    }

    private void hf() {
        if (this.ux != null) {
            BdBaseApplication.getInst().unbindService(this.ux);
            this.ux = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg() {
        eV.removeCallbacks(this.uz);
        eV.postDelayed(this.uz, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh() {
        if (this.messenger != null && this.ut != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.ut));
                message.replyTo = this.uy;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            eV.removeCallbacks(this.uA);
            eV.postDelayed(this.uA, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi() {
        this.ux = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.ht().e("plugin_install", "system_kill_installprocess", this.ut == null ? "" : this.ut.tG, String.valueOf(this.uu.size()) + "-" + this.uw.size());
        hd();
        hp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj() {
        com.baidu.adp.plugin.b.a.ht().bg("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.ht().e("plugin_install", "installprocess_noresponse", this.ut == null ? "" : this.ut.tG, String.valueOf(this.uu.size()) + "-" + this.uw.size());
        hd();
        hm();
        hp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk() {
        if (this.ut != null) {
            com.baidu.adp.plugin.packageManager.a.b.iq().n(this.ut.tG, "plugin_install_timeout", null);
        }
        c cVar = this.ut;
        if (!hn()) {
            com.baidu.adp.plugin.b.a.ht().bg("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.ht().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.tG, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.ha())) + "-" + this.uu.size() + "-" + this.uw.size());
        } else {
            com.baidu.adp.plugin.b.a.ht().bg("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.ht().e("plugin_install", "timeout", cVar == null ? "" : cVar.tG, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.ha())) + "-" + this.uu.size() + "-" + this.uw.size());
        }
        hd();
        hm();
        hp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl() {
        if (this.uv != null) {
            com.baidu.adp.plugin.packageManager.a.b.iq().n(this.uv.tG, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.ht().e("plugin_install", "timeout", this.uv == null ? "" : this.uv.tG, "timeout-" + (this.uv == null ? "" : Long.valueOf(this.uv.ha())) + "-" + this.uu.size() + "-" + this.uw.size());
        he();
    }

    private void hm() {
        if (this.ux != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.ux);
        }
        this.ux = null;
        this.messenger = null;
        int ho = ho();
        if (ho > 0 && ho != Process.myPid()) {
            Process.killProcess(ho);
        }
    }

    private boolean hn() {
        return ho() > 0;
    }

    private int ho() {
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

    private void hp() {
        if (this.ut != null) {
            com.baidu.adp.plugin.b.a.ht().D("plugin_retry_install", this.ut.tG);
            com.baidu.adp.plugin.b.a.ht().e("plugin_install", "plugin_retry_install", this.ut.tG, new StringBuilder(String.valueOf(this.ut.ha())).toString());
            c(this.ut);
            this.ut = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] uE = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

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
                                    o.j(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.j(inputStream);
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

        private boolean be(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.uE) {
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
                    if (str != null && str.endsWith(".apk") && be(str) && d.this.o(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.uo != null) {
                d.this.uo.I(d.this.uq);
            }
        }
    }
}
